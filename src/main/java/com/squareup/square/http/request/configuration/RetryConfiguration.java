
package com.squareup.square.http.request.configuration;

/**
 * Holds configurations for a particular HTTP request.
 */
public class RetryConfiguration {
    
    /**
     * The option to override HTTP method whitelist configuration for the request in retries.
     */
    private final RetryOption retryOption;

    /**
     * Default constructor.
     * @param retryOption The option to override retry configurations for a particular
     *        request.
     */
    private RetryConfiguration(RetryOption retryOption) {
        this.retryOption = retryOption;
    }

    /**
     * The option for overriding global retry configuration.
     * @return the overrideRetryOption
     */
    public RetryOption getRetryOption() {
        return retryOption;
    }

    @Override
    public String toString() {
        return "RetryConfiguration [retryOption=" + retryOption + "]";
    }

    /**
     * Builds a new {@link RetryConfiguration.Builder} object. Creates the instance with the current
     * state.
     * @return a new {@link RetryConfiguration.Builder} object
     */
    public Builder newBuilder() {
        return new Builder().retryOption(getRetryOption());
    }

    /**
     * Class to build instances of {@link RetryConfiguration}.
     */
    public static class Builder {

        private RetryOption retryOption = RetryOption.DEFAULT;

        /**
         * The option to override retry configurations for a particular request.
         * @param retryOption The retryOption to set.
         * @return Builder
         */
        public Builder retryOption(RetryOption retryOption) {
            this.retryOption = retryOption;
            return this;
        }

        /**
         * Builds a new RetryConfiguration object using the set fields.
         * @return {@link RetryConfiguration}
         */
        public RetryConfiguration build() {
            return new RetryConfiguration(retryOption);
        }
    }

}
