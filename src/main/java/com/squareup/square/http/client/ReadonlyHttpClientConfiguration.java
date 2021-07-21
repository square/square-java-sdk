
package com.squareup.square.http.client;

import com.squareup.square.http.request.HttpMethod;
import java.util.Set;

/**
 * Interface for holding HTTP Client Configuration.
 */
public interface ReadonlyHttpClientConfiguration {

    /**
     * The timeout in seconds to use for making HTTP requests.
     * @return a copy of timeout
     */
    long getTimeout();

    /**
     * The number of retries to make.
     * @return a copy of numberOfRetries
     */
    int getNumberOfRetries();

    /**
     * To use in calculation of wait time for next request in case of failure.
     * @return a copy of backOffFactor
     */
    int getBackOffFactor();

    /**
     * To use in calculation of wait time for next request in case of failure.
     * @return a copy of retryInterval
     */
    long getRetryInterval();

    /**
     * Http status codes to retry against.
     * @return a copy of httpStatusCodesToRetry
     */
    Set<Integer> getHttpStatusCodesToRetry();

    /**
     * Http methods to retry against.
     * @return a copy of httpMethodsToRetry
     */
    Set<HttpMethod> getHttpMethodsToRetry();

    /**
     * The maximum wait time for overall retrying requests.
     * @return a copy of maximumRetryWaitTime
     */
    long getMaximumRetryWaitTime();

    /**
     * Whether to retry on request timeout.
     * @return a copy of shouldRetryOnTimeout
     */
    boolean shouldRetryOnTimeout();

    /**
     * The OkHttpClient instance used to make the HTTP calls.
     * @return a copy of httpClientInstance
     */
    okhttp3.OkHttpClient getHttpClientInstance();

    /**
     * Allow the SDK to override HTTP client instance's settings used for features like retries,
     * timeouts etc.
     * @return a copy of overrideHttpClientConfigurations
     */
    boolean shouldOverrideHttpClientConfigurations();

}