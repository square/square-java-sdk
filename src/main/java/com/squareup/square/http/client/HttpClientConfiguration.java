
package com.squareup.square.http.client;

import com.squareup.square.http.request.HttpMethod;
import io.apimatic.core.configurations.http.client.CoreHttpClientConfiguration;
import io.apimatic.coreinterfaces.http.ClientConfiguration;
import io.apimatic.coreinterfaces.http.HttpMethodType;
import io.apimatic.coreinterfaces.http.Method;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class to hold HTTP Client Configuration.
 */
public class HttpClientConfiguration implements ReadonlyHttpClientConfiguration {

    private final ClientConfiguration configuration;

    /**
     * Default Constructor.
     */
    private HttpClientConfiguration(CoreHttpClientConfiguration.Builder configurationBuilder) {
        this.configuration  = configurationBuilder.build();
    }

    /**
     * The timeout in seconds to use for making HTTP requests.
     * @return timeout
     */
    public long getTimeout() {
        return configuration.getTimeout();
    }

    /**
     * The number of retries to make.
     * @return numberOfRetries
     */
    public int getNumberOfRetries() {
        return configuration.getNumberOfRetries();
    }

    /**
     * To use in calculation of wait time for next request in case of failure.
     * @return backOffFactor
     */
    public int getBackOffFactor() {
        return configuration.getBackOffFactor();
    }

    /**
     * To use in calculation of wait time for next request in case of failure.
     * @return retryInterval
     */
    public long getRetryInterval() {
        return configuration.getRetryInterval();
    }

    /**
     * Http status codes to retry against.
     * @return httpStatusCodesToRetry
     */
    public Set<Integer> getHttpStatusCodesToRetry() {
        return configuration.getHttpStatusCodesToRetry();
    }

    /**
     * Http methods to retry against.
     * @return httpMethodsToRetry
     */
    public Set<HttpMethod> getHttpMethodsToRetry() {
        if (configuration.getHttpMethodsToRetry() == null) {
            return null;
        }
        return configuration.getHttpMethodsToRetry().stream()
                .map(httpMethod -> HttpMethod.valueOf(httpMethod.toString()))
                .collect(Collectors.toSet());
    }

    /**
     * The maximum wait time for overall retrying requests.
     * @return maximumRetryWaitTime
     */
    public long getMaximumRetryWaitTime() {
        return configuration.getMaximumRetryWaitTime();
    }

    /**
     * Whether to retry on request timeout.
     * @return shouldRetryOnTimeout
     */
    public boolean shouldRetryOnTimeout() {
        return configuration.shouldRetryOnTimeout();
    }

    /**
     * The OkHttpClient instance used to make the HTTP calls.
     * @return httpClientInstance
     */
    public okhttp3.OkHttpClient getHttpClientInstance() {
        return configuration.getHttpClientInstance();
    }

    /**
     * Allow the SDK to override HTTP client instance's settings used for features like retries,
     * timeouts etc.
     * @return overrideHttpClientConfigurations
     */
    public boolean shouldOverrideHttpClientConfigurations() {
        return configuration.shouldOverrideHttpClientConfigurations();
    }

    /**
    * Returns the ClientConfiguration instance.
    * @return ClientConfiguration
    */
    public ClientConfiguration getConfiguration() {
        return this.configuration;
    }

    /**
     * Converts this HttpClientConfiguration into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "HttpClientConfiguration [" + "timeout=" + getTimeout() + ", numberOfRetries="
                + getNumberOfRetries() + ", backOffFactor=" + getBackOffFactor()
                + ", retryInterval=" + getRetryInterval() + ", httpStatusCodesToRetry="
                + getHttpStatusCodesToRetry() + ", httpMethodsToRetry=" + getHttpMethodsToRetry()
                + ", maximumRetryWaitTime=" + getMaximumRetryWaitTime() + ", shouldRetryOnTimeout="
                + shouldRetryOnTimeout() + ", httpClientInstance=" + getHttpClientInstance()
                + ", overrideHttpClientConfigurations=" + shouldOverrideHttpClientConfigurations()
                + "]";
    }

    /**
     * Builds a new {@link HttpClientConfiguration.Builder} object. Creates the instance with the
     * current state.
     * 
     * @return a new {@link HttpClientConfiguration.Builder} object
     */
    public Builder newBuilder() {
        return new Builder()
                .timeout(getTimeout())
                .numberOfRetries(getNumberOfRetries())
                .backOffFactor(getBackOffFactor())
                .retryInterval(getRetryInterval())
                .httpStatusCodesToRetry(getHttpStatusCodesToRetry())
                .httpMethodsToRetry(getHttpMethodsToRetry())
                .maximumRetryWaitTime(getMaximumRetryWaitTime())
                .shouldRetryOnTimeout(shouldRetryOnTimeout())
                .httpClientInstance(getHttpClientInstance(), shouldOverrideHttpClientConfigurations());
    }

    /**
     * Class to build instances of {@link HttpClientConfiguration}.
     */
    public static class Builder {
     
        private final CoreHttpClientConfiguration.Builder configurationBuilder =
            new CoreHttpClientConfiguration.Builder();

        /**
         * Default Constructor to initiate builder with default properties.
         */
        public Builder() {
            // setting default values
            configurationBuilder.httpStatusCodesToRetry(Stream.of(408, 413, 429, 500, 502, 503, 504,
                    521, 522, 524).collect(Collectors.toSet()));
            configurationBuilder.httpMethodsToRetry(Stream.of(Method.GET,
                    Method.PUT).collect(Collectors.toSet()));
        }

        /**
         * The timeout in seconds to use for making HTTP requests.
         * @param timeout The timeout to set.
         * @return Builder
         */
        public Builder timeout(long timeout) {
            configurationBuilder.timeout(timeout);
            return this;
        }

        /**
         * The number of retries to make.
         * @param numberOfRetries The numberOfRetries to set.
         * @return Builder
         */
        public Builder numberOfRetries(int numberOfRetries) {
            configurationBuilder.numberOfRetries(numberOfRetries);
            return this;
        }

        /**
         * To use in calculation of wait time for next request in case of failure.
         * @param backOffFactor The backOffFactor to set.
         * @return Builder
         */
        public Builder backOffFactor(int backOffFactor) {
            configurationBuilder.backOffFactor(backOffFactor);
            return this;
        }

        /**
         * To use in calculation of wait time for next request in case of failure.
         * @param retryInterval The retryInterval to set.
         * @return Builder
         */
        public Builder retryInterval(long retryInterval) {
            configurationBuilder.retryInterval(retryInterval);
            return this;
        }

        /**
         * Http status codes to retry against.
         * @param httpStatusCodesToRetry The httpStatusCodesToRetry to set.
         * @return Builder
         */
        public Builder httpStatusCodesToRetry(Set<Integer> httpStatusCodesToRetry) {
            configurationBuilder.httpStatusCodesToRetry(httpStatusCodesToRetry);
            return this;
        }

        /**
         * Http methods to retry against.
         * @param httpMethodsToRetry The httpMethodsToRetry to set.
         * @return Builder
         */
        public Builder httpMethodsToRetry(Set<HttpMethod> httpMethodsToRetry) {
            Set<Method> convertedHttpMethodsToRetry = null;
            if (httpMethodsToRetry != null) {
                convertedHttpMethodsToRetry = httpMethodsToRetry.stream()
                    .map(httpMethod -> HttpMethodType.valueOf(httpMethod.toString()))
                    .collect(Collectors.toSet());
            }
            configurationBuilder.httpMethodsToRetry(convertedHttpMethodsToRetry);
            return this;
        }

        /**
         * The maximum wait time for overall retrying requests.
         * @param maximumRetryWaitTime The maximumRetryWaitTime to set.
         * @return Builder
         */
        public Builder maximumRetryWaitTime(long maximumRetryWaitTime) {
            configurationBuilder.maximumRetryWaitTime(maximumRetryWaitTime);
            return this;
        }

        /**
         * Whether to retry on request timeout.
         * @param shouldRetryOnTimeout The shouldRetryOnTimeout to set
         * @return Builder
         */
        public Builder shouldRetryOnTimeout(boolean shouldRetryOnTimeout) {
            configurationBuilder.shouldRetryOnTimeout(shouldRetryOnTimeout);
            return this;
        }

        /**
         * The OkHttpClient instance used to make the HTTP calls.
         * @param httpClientInstance The httpClientInstance to set
         * @return Builder
         */
        public Builder httpClientInstance(okhttp3.OkHttpClient httpClientInstance) {
            configurationBuilder.httpClientInstance(httpClientInstance);
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
            configurationBuilder.httpClientInstance(httpClientInstance, overrideHttpClientConfigurations);
            return this;
        }

        /**
         * Builds a new HttpClientConfiguration object using the set fields. 
         * @return {@link HttpClientConfiguration}
         */
        public HttpClientConfiguration build() {
            return new HttpClientConfiguration(configurationBuilder);
        }
    }
}