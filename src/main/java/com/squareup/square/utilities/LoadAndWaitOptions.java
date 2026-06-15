package com.squareup.square.utilities;

import com.squareup.square.core.RequestOptions;

/**
 * Polling/backoff configuration for {@link ReportingHelper#loadAndWait(com.squareup.square.SquareClient,
 * com.squareup.square.types.LoadRequest, LoadAndWaitOptions)}.
 *
 * <p>Defaults poll up to 20 times with exponential backoff (2s &rarr; 20s). Build with {@link #builder()}.
 */
public final class LoadAndWaitOptions {
    private final int maxAttempts;

    private final long initialDelayMs;

    private final long maxDelayMs;

    private final double backoffFactor;

    private final RequestOptions requestOptions;

    private LoadAndWaitOptions(
            int maxAttempts,
            long initialDelayMs,
            long maxDelayMs,
            double backoffFactor,
            RequestOptions requestOptions) {
        this.maxAttempts = maxAttempts;
        this.initialDelayMs = initialDelayMs;
        this.maxDelayMs = maxDelayMs;
        this.backoffFactor = backoffFactor;
        this.requestOptions = requestOptions;
    }

    /** Maximum poll attempts before giving up. Default 20. */
    public int getMaxAttempts() {
        return maxAttempts;
    }

    /** Delay before the first retry, in milliseconds. Default 2000. */
    public long getInitialDelayMs() {
        return initialDelayMs;
    }

    /** Upper bound on the backoff delay, in milliseconds. Default 20000. */
    public long getMaxDelayMs() {
        return maxDelayMs;
    }

    /** Multiplier applied to the delay after each attempt. Default 2. */
    public double getBackoffFactor() {
        return backoffFactor;
    }

    /** Forwarded to each underlying {@code client.reporting().load} call. May be {@code null}. */
    public RequestOptions getRequestOptions() {
        return requestOptions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private int maxAttempts = 20;

        private long initialDelayMs = 2000;

        private long maxDelayMs = 20000;

        private double backoffFactor = 2;

        private RequestOptions requestOptions = null;

        private Builder() {}

        /** Maximum poll attempts before giving up. Default 20. */
        public Builder maxAttempts(int maxAttempts) {
            this.maxAttempts = maxAttempts;
            return this;
        }

        /** Delay before the first retry, in milliseconds. Default 2000. */
        public Builder initialDelayMs(long initialDelayMs) {
            this.initialDelayMs = initialDelayMs;
            return this;
        }

        /** Upper bound on the backoff delay, in milliseconds. Default 20000. */
        public Builder maxDelayMs(long maxDelayMs) {
            this.maxDelayMs = maxDelayMs;
            return this;
        }

        /** Multiplier applied to the delay after each attempt. Default 2. */
        public Builder backoffFactor(double backoffFactor) {
            this.backoffFactor = backoffFactor;
            return this;
        }

        /** Forwarded to each underlying {@code client.reporting().load} call. */
        public Builder requestOptions(RequestOptions requestOptions) {
            this.requestOptions = requestOptions;
            return this;
        }

        public LoadAndWaitOptions build() {
            if (maxAttempts < 1) {
                throw new IllegalArgumentException("maxAttempts must be at least 1");
            }
            return new LoadAndWaitOptions(maxAttempts, initialDelayMs, maxDelayMs, backoffFactor, requestOptions);
        }
    }
}
