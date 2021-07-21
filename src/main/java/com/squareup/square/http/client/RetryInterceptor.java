
package com.squareup.square.http.client;

import com.squareup.square.http.request.HttpMethod;
import java.io.IOException;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * RetryInterceptor intercepts and retry requests if failed based on configuration.
 */
public class RetryInterceptor implements Interceptor {

    private static final DateTimeFormatter RFC1123_DATE_TIME_FORMATTER = 
            DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z")
            .withZone(ZoneId.of("GMT"));

    /**
     * To keep track of requests being sent and its current state.
     */
    private final ConcurrentMap<Request, RequestState> requestEntries;

    /**
     * User specified retry configurations.
     */
    private final ReadonlyHttpClientConfiguration httpClientConfiguration;

    /**
     * Default Constructor, Initializes the httpClientConfiguration attribute.
     * 
     * @param httpClientConfig the user specified configurations.
     */
    public RetryInterceptor(ReadonlyHttpClientConfiguration httpClientConfig) {
        this.httpClientConfiguration = httpClientConfig;
        requestEntries = new ConcurrentHashMap<>();
    }

    /**
     * Intercepts and retry requests if failed based on configuration.
     * @see okhttp3.Interceptor#intercept(okhttp3.Interceptor.Chain)
     */
    @SuppressWarnings("resource")
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestState requestState = getRequestState(request);
        Response response = null;
        try {
            response = chain.proceed(request);
        } catch (IOException ioException) {
            if (httpClientConfiguration.shouldRetryOnTimeout()
                    && httpClientConfiguration.getNumberOfRetries() > 0) {
                response = retryOnTimeout(chain, request, requestState, ioException);
            }
        }
        while (requestState != null && needToRetry(request, response)) {
            requestState.retryCount++;
            // Performing wait time calculation.
            calculateWaitTime(requestState, response);

            // Checking total wait time against allowed max back-off time
            if (hasWaitTimeLimitExceeded(requestState)) {
                break;
            }
            
            
            // Waiting before making next request
            holdExecution(requestState);
            // proceeding with execution of next request
            try {
                response.close();
                response = chain.proceed(request);
            } catch (SocketException socketException) {
                response = chain.proceed(request);
            } catch (IOException ioException) {
                if (httpClientConfiguration.shouldRetryOnTimeout()
                        && httpClientConfiguration.getNumberOfRetries() > 0) {
                    response = retryOnTimeout(chain, request, requestState, ioException);
                }
            }
            
        }
        
        this.requestEntries.remove(request);
        return response;
    }

    /**
     * Adds entry into Request entry map.
     * @param okHttpRequest the OK HTTP Request.
     */
    public void addRequestEntry(Request okHttpRequest) {
        this.requestEntries.put(okHttpRequest, new RequestState());
    }

    /**
     * Checks if the overall wait time has reached to its limit.
     * @param requestState the current state of request entry.
     * @return true if total wait time exceeds maximum back-off time.
     */
    private boolean hasWaitTimeLimitExceeded(RequestState requestState) {
        return this.httpClientConfiguration.getMaximumRetryWaitTime() > 0
                && toMilliseconds(this.httpClientConfiguration
                        .getMaximumRetryWaitTime()) < requestState.totalWaitTimeInMilliSeconds;
    }


    /**
     * Checks if the retry request is to be made against provided response.
     * @param request the HTTP request.
     * @param response the HTTP response.
     * @return true if request is needed to be retried.
     */
    private boolean needToRetry(Request request, Response response) {

        return (getRequestState(request).retryCount < this.httpClientConfiguration
                .getNumberOfRetries()
                && this.httpClientConfiguration.getHttpMethodsToRetry()
                        .contains(HttpMethod.valueOf(request.method()))
                && response != null && (this.httpClientConfiguration.getHttpStatusCodesToRetry()
                        .contains(response.code()) || hasRetryAfterHeader(response)));
    }

    /**
     * Calculates the wait time for next request.
     * @param requestState the current state of request entry.
     * @param response the HTTP response.
     */
    private void calculateWaitTime(RequestState requestState, Response response) {
        long retryAfterHeaderValue = 0;
        if (hasRetryAfterHeader(response)) {
            retryAfterHeaderValue = getCalculatedHeaderValue(response.header("Retry-After"));
        }
        long calculatedBackOffInMilliSeconds = getCalculatedBackOffValue(requestState);
        requestState.currentWaitInMilliSeconds =
                calculatedBackOffInMilliSeconds > retryAfterHeaderValue
                        ? calculatedBackOffInMilliSeconds
                        : retryAfterHeaderValue;
        requestState.totalWaitTimeInMilliSeconds += requestState.currentWaitInMilliSeconds;
    }

    /**
     * Checks if the response contains Retry-After header.
     * @param response the HTTP response.
     * @return true if response contains Retry-After header.
     */
    private boolean hasRetryAfterHeader(Response response) {
        String retryAfter = response.header("Retry-After");
        if (retryAfter != null && !retryAfter.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Analyzes the header value and checks the header if it contains date in proper format or
     * seconds. If header value is date then it calculates the delta time in milliseconds.
     * @param headerValue the retry-after header value.
     * @return long value of calculated wait time in milliseconds.
     */
    private long getCalculatedHeaderValue(String headerValue) {
        try {
            return toMilliseconds(Long.parseLong(headerValue));
        } catch (NumberFormatException nfe) {
            long requestAtValueInSeconds = LocalDateTime
                    .parse(headerValue, RFC1123_DATE_TIME_FORMATTER).toEpochSecond(ZoneOffset.UTC);
            long currentDateTimeInSeconds = LocalDateTime
                    .now(ZoneOffset.UTC).toEpochSecond(ZoneOffset.UTC);
            return toMilliseconds(requestAtValueInSeconds - currentDateTimeInSeconds);
        }
    }

    /**
     * Calculates the back-off value based on a formula which uses back-off factor and retry Count.
     * @param requestState the current state of request entry.
     * @return long value of back-off time based on formula in milliseconds.
     */
    private long getCalculatedBackOffValue(RequestState requestState) {
        return (long) (1000 * this.httpClientConfiguration.getRetryInterval()
                * Math.pow(this.httpClientConfiguration.getBackOffFactor(),
                        requestState.retryCount - 1) + Math.random() * 100);
    }

    /**
     * Holds the execution for stored wait time in milliseconds of this thread.
     * @param requestState the current state of request entry.
     */
    private void holdExecution(RequestState requestState) {
        try {
            TimeUnit.MILLISECONDS.sleep(requestState.currentWaitInMilliSeconds);
        } catch (InterruptedException e) {
            // No handler needed
        }
    }

    /**
     * Converts the seconds to milliseconds.
     * @param seconds The seconds to convert.
     * @return long value of milliseconds.
     */
    private long toMilliseconds(long seconds) {
        return seconds * 1000;
    }
    
    /**
     * getter for current request state entry from map.
     * @param okHttpRequest the OK HTTP Request.
     * @return RequestEntry the current request entry.
     */
    private RequestState getRequestState(Request okHttpRequest) {
        return this.requestEntries.get(okHttpRequest);
    }
    
    /**
     * Retries on the request which caused the request timeout to occur based on HTTP Client
     * Configurations.
     * @param chain The interceptor chain.
     * @param request The OkHttp request.
     * @param exception The thrown exception.
     * @return The OKHttp response.
     * @throws IOException the same exception which was thrown while retrying.
     */
    private okhttp3.Response retryOnTimeout(Chain chain, Request request, RequestState requestState,
            IOException exception) throws IOException {
        
        while (requestState.retryCount++ < httpClientConfiguration.getNumberOfRetries()
                && !this.hasWaitTimeLimitExceeded(requestState)) {
        
            try {
                return chain.proceed(request);
            } catch (IOException ioException) {
                exception = ioException;
            } finally {
                requestState.totalWaitTimeInMilliSeconds +=
                        toMilliseconds(httpClientConfiguration.getTimeout());
            }
        }

        throw exception;
    }


    /**
     * Class to hold the request info until request completes.
     */
    private class RequestState {
        
        /**
         * To keep track of requests count.
         */
        private int retryCount = 0;

        /**
         * To store the wait time for next request.
         */
        private long currentWaitInMilliSeconds = 0;

        /**
         * To keep track of overall wait time.
         */
        private long totalWaitTimeInMilliSeconds = 0;
    }
}