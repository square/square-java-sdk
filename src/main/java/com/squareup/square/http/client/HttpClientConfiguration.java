
package com.squareup.square.http.client;

import com.squareup.square.http.request.HttpMethod;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class to hold HTTP Client Configuration.
 */
public class HttpClientConfiguration implements ReadonlyHttpClientConfiguration {

    /**
     * The timeout in seconds to use for making HTTP requests.
     */
    private final long timeout;

    /**
     * The number of retries to make.
     */
    private final int numberOfRetries;

    /**
     * To use in calculation of wait time for next request in case of failure.
     */
    private final int backOffFactor;

    /**
     * To use in calculation of wait time for next request in case of failure.
     */
    private final long retryInterval;

    /**
     * Http status codes to retry against.
     */
    private final Set<Integer> httpStatusCodesToRetry;

    /**
     * Http methods to retry against.
     */
    private final Set<HttpMethod> httpMethodsToRetry;

    /**
     * The maximum wait time for overall retrying requests.
     */
    private final long maximumRetryWaitTime;

    /**
     * Whether to retry on request timeout.
     */
    private final boolean shouldRetryOnTimeout;

    /**
     * The OkHttpClient instance used to make the HTTP calls.
     */
    private final okhttp3.OkHttpClient httpClientInstance;

    /**
     * Allow the SDK to override HTTP client instance's settings used for features like retries,
     * timeouts etc.
     */
    private final boolean overrideHttpClientConfigurations;

    /**
     * Default Constructor.
     */
    private HttpClientConfiguration(long timeout, int numberOfRetries, int backOffFactor,
            long retryInterval, Set<Integer> httpStatusCodesToRetry,
            Set<HttpMethod> httpMethodsToRetry, long maximumRetryWaitTime,
            boolean shouldRetryOnTimeout, okhttp3.OkHttpClient httpClientInstance,
            boolean overrideHttpClientConfigurations) {
        this.timeout = timeout;
        this.numberOfRetries = numberOfRetries;
        this.backOffFactor = backOffFactor;
        this.retryInterval = retryInterval;
        this.httpStatusCodesToRetry = httpStatusCodesToRetry;
        this.httpMethodsToRetry = httpMethodsToRetry;
        this.maximumRetryWaitTime = maximumRetryWaitTime;
        this.shouldRetryOnTimeout = shouldRetryOnTimeout;
        this.httpClientInstance = httpClientInstance;
        this.overrideHttpClientConfigurations = overrideHttpClientConfigurations;
    }

    /**
     * The timeout in seconds to use for making HTTP requests.
     * @return timeout
     */
    public long getTimeout() {
        return timeout;
    }

    /**
     * The number of retries to make.
     * @return numberOfRetries
     */
    public int getNumberOfRetries() {
        return numberOfRetries;
    }

    /**
     * To use in calculation of wait time for next request in case of failure.
     * @return backOffFactor
     */
    public int getBackOffFactor() {
        return backOffFactor;
    }

    /**
     * To use in calculation of wait time for next request in case of failure.
     * @return retryInterval
     */
    public long getRetryInterval() {
        return retryInterval;
    }

    /**
     * Http status codes to retry against.
     * @return httpStatusCodesToRetry
     */
    public Set<Integer> getHttpStatusCodesToRetry() {
        return httpStatusCodesToRetry;
    }

    /**
     * Http methods to retry against.
     * @return httpMethodsToRetry
     */
    public Set<HttpMethod> getHttpMethodsToRetry() {
        return httpMethodsToRetry;
    }

    /**
     * The maximum wait time for overall retrying requests.
     * @return maximumRetryWaitTime
     */
    public long getMaximumRetryWaitTime() {
        return maximumRetryWaitTime;
    }

    /**
     * Whether to retry on request timeout.
     * @return shouldRetryOnTimeout
     */
    public boolean shouldRetryOnTimeout() {
        return shouldRetryOnTimeout;
    }

    /**
     * The OkHttpClient instance used to make the HTTP calls.
     * @return httpClientInstance
     */
    public okhttp3.OkHttpClient getHttpClientInstance() {
        return httpClientInstance;
    }

    /**
     * Allow the SDK to override HTTP client instance's settings used for features like retries,
     * timeouts etc.
     * @return overrideHttpClientConfigurations
     */
    public boolean shouldOverrideHttpClientConfigurations() {
        return overrideHttpClientConfigurations;
    }

    /**
     * Converts this HttpClientConfiguration into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "HttpClientConfiguration [" + "timeout=" + timeout + ", numberOfRetries="
                + numberOfRetries + ", backOffFactor=" + backOffFactor + ", retryInterval="
                + retryInterval + ", httpStatusCodesToRetry=" + httpStatusCodesToRetry
                + ", httpMethodsToRetry=" + httpMethodsToRetry + ", maximumRetryWaitTime="
                + maximumRetryWaitTime + ", shouldRetryOnTimeout=" + shouldRetryOnTimeout
                + ", httpClientInstance=" + httpClientInstance
                + ", overrideHttpClientConfigurations=" + overrideHttpClientConfigurations + "]";
    }

    /**
     * Builds a new {@link HttpClientConfiguration.Builder} object. Creates the instance with the
     * current state.
     * 
     * @return a new {@link HttpClientConfiguration.Builder} object
     */
    public Builder newBuilder() {
        return new Builder()
                .timeout(timeout)
                .numberOfRetries(numberOfRetries)
                .backOffFactor(backOffFactor)
                .retryInterval(retryInterval)
                .httpStatusCodesToRetry(httpStatusCodesToRetry)
                .httpMethodsToRetry(httpMethodsToRetry)
                .maximumRetryWaitTime(maximumRetryWaitTime)
                .shouldRetryOnTimeout(shouldRetryOnTimeout)
                .httpClientInstance(httpClientInstance, overrideHttpClientConfigurations);
    }

    /**
     * Class to build instances of {@link HttpClientConfiguration}.
     */
    public static class Builder {
     
        private long timeout = 60;
        private int numberOfRetries = 0;
        private int backOffFactor = 2;
        private long retryInterval = 1;
        private Set<Integer> httpStatusCodesToRetry = new HashSet<>();
        private Set<HttpMethod> httpMethodsToRetry = new HashSet<>();
        private long maximumRetryWaitTime = 0;
        private boolean shouldRetryOnTimeout = true;
        private okhttp3.OkHttpClient httpClientInstance;
        private boolean overrideHttpClientConfigurations = true;
   
        /**
         * Default Constructor to initiate builder with default properties.
         */
        public Builder() {
            // setting default values
            httpStatusCodesToRetry.addAll(Arrays.asList(408, 413, 429, 500, 502, 503, 504, 521, 522,
                    524));
            httpMethodsToRetry.addAll(Arrays.asList(HttpMethod.GET, HttpMethod.PUT));
        }

        /**
         * The timeout in seconds to use for making HTTP requests.
         * @param timeout The timeout to set.
         * @return Builder
         */
        public Builder timeout(long timeout) {
            if (timeout > 0) { 
                this.timeout = timeout;
            }
            return this;
        }

        /**
         * The number of retries to make.
         * @param numberOfRetries The numberOfRetries to set.
         * @return Builder
         */
        public Builder numberOfRetries(int numberOfRetries) {
            if (numberOfRetries >= 0) { 
                this.numberOfRetries = numberOfRetries;
            }
            return this;
        }

        /**
         * To use in calculation of wait time for next request in case of failure.
         * @param backOffFactor The backOffFactor to set.
         * @return Builder
         */
        public Builder backOffFactor(int backOffFactor) {
            if (backOffFactor >= 1) { 
                this.backOffFactor = backOffFactor;
            }
            return this;
        }

        /**
         * To use in calculation of wait time for next request in case of failure.
         * @param retryInterval The retryInterval to set.
         * @return Builder
         */
        public Builder retryInterval(long retryInterval) {
            if (retryInterval >= 0) { 
                this.retryInterval = retryInterval;
            }
            return this;
        }

        /**
         * Http status codes to retry against.
         * @param httpStatusCodesToRetry The httpStatusCodesToRetry to set.
         * @return Builder
         */
        public Builder httpStatusCodesToRetry(Set<Integer> httpStatusCodesToRetry) {
            this.httpStatusCodesToRetry.clear();
            if (httpStatusCodesToRetry != null) {
                this.httpStatusCodesToRetry.addAll(httpStatusCodesToRetry);
            }
            return this;
        }

        /**
         * Http methods to retry against.
         * @param httpMethodsToRetry The httpMethodsToRetry to set.
         * @return Builder
         */
        public Builder httpMethodsToRetry(Set<HttpMethod> httpMethodsToRetry) {
            this.httpMethodsToRetry.clear();
            if (httpMethodsToRetry != null) {
                this.httpMethodsToRetry.addAll(httpMethodsToRetry);
            }
            return this;
        }

        /**
         * The maximum wait time for overall retrying requests.
         * @param maximumRetryWaitTime The maximumRetryWaitTime to set.
         * @return Builder
         */
        public Builder maximumRetryWaitTime(long maximumRetryWaitTime) {
            if (maximumRetryWaitTime > 0) { 
                this.maximumRetryWaitTime = maximumRetryWaitTime;
            }
            return this;
        }

        /**
         * Whether to retry on request timeout.
         * @param shouldRetryOnTimeout The shouldRetryOnTimeout to set
         * @return Builder
         */
        public Builder shouldRetryOnTimeout(boolean shouldRetryOnTimeout) {
            this.shouldRetryOnTimeout = shouldRetryOnTimeout;
            return this;
        }

        /**
         * The OkHttpClient instance used to make the HTTP calls.
         * @param httpClientInstance The httpClientInstance to set
         * @return Builder
         */
        public Builder httpClientInstance(okhttp3.OkHttpClient httpClientInstance) {
            this.httpClientInstance = httpClientInstance;
            return this;
        }

        /**
         * The OkHttpClient instance used to make the HTTP calls.
         * @param httpClientInstance The httpClientInstance to set
         * @param overrideHttpClientConfigurations The overrideHttpClientConfigurations to set
         * @return Builder
         */
        public Builder httpClientInstance(okhttp3.OkHttpClient httpClientInstance,
                boolean overrideHttpClientConfigurations) {
            this.httpClientInstance = httpClientInstance;
            this.overrideHttpClientConfigurations = overrideHttpClientConfigurations;
            return this;
        }

        /**
         * Builds a new HttpClientConfiguration object using the set fields. 
         * @return {@link HttpClientConfiguration}
         */
        public HttpClientConfiguration build() {
            return new HttpClientConfiguration(timeout, numberOfRetries, backOffFactor,
                    retryInterval, httpStatusCodesToRetry, httpMethodsToRetry, maximumRetryWaitTime,
                    shouldRetryOnTimeout, httpClientInstance, overrideHttpClientConfigurations);
        }
    }
}