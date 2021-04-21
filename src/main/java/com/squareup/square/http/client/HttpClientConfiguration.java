
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
    private final long maxBackOff;

    /**
     * Whether to retry on request timeout.
     */
    private final boolean shouldRetryOnTimeout;

    /**
     * Default Constructor.
     */
    private HttpClientConfiguration(long timeout, int numberOfRetries, int backOffFactor,
            long retryInterval, Set<Integer> httpStatusCodesToRetry,
            Set<HttpMethod> httpMethodsToRetry, long maxBackOff, boolean shouldRetryOnTimeout) {
        this.timeout = timeout;
        this.numberOfRetries = numberOfRetries;
        this.backOffFactor = backOffFactor;
        this.retryInterval = retryInterval;
        this.httpStatusCodesToRetry = httpStatusCodesToRetry;
        this.httpMethodsToRetry = httpMethodsToRetry;
        this.maxBackOff = maxBackOff;
        this.shouldRetryOnTimeout = shouldRetryOnTimeout;
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
     * @return maxBackOff
     */
    public long getMaxBackOff() {
        return maxBackOff;
    }

    /**
     * Whether to retry on request timeout.
     * @return shouldRetryOnTimeout
     */
    public boolean shouldRetryOnTimeout() {
        return shouldRetryOnTimeout;
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
                + ", httpMethodsToRetry=" + httpMethodsToRetry + ", maxBackOff=" + maxBackOff
                + ", shouldRetryOnTimeout=" + shouldRetryOnTimeout + "]";
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
                .maxBackOff(maxBackOff)
                .shouldRetryOnTimeout(shouldRetryOnTimeout);
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
        private long maxBackOff = 0;
        private boolean shouldRetryOnTimeout = true;
   
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
         * The timeout in seconds to use for making HTTP requests..
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
         * The number of retries to make..
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
         * To use in calculation of wait time for next request in case of failure..
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
         * To use in calculation of wait time for next request in case of failure..
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
         * Http status codes to retry against..
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
         * Http methods to retry against..
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
         * The maximum wait time for overall retrying requests..
         * @param maxBackOff The maxBackOff to set.
         * @return Builder
         */
        public Builder maxBackOff(long maxBackOff) {
            if (maxBackOff > 0) { 
                this.maxBackOff = maxBackOff;
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
         * Builds a new HttpClientConfiguration object using the set fields. 
         * @return {@link HttpClientConfiguration}
         */
        public HttpClientConfiguration build() {
            return new HttpClientConfiguration(timeout, numberOfRetries, backOffFactor,
                    retryInterval, httpStatusCodesToRetry, httpMethodsToRetry, maxBackOff,
                    shouldRetryOnTimeout);
        }
    }
}