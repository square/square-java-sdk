/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.Environment;
import okhttp3.OkHttpClient;

public final class SquareClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String token = System.getenv("SQUARE_TOKEN");

    private String version = "2025-07-16";

    private Environment environment = Environment.PRODUCTION;

    /**
     * Sets token.
     * Defaults to the SQUARE_TOKEN environment variable.
     */
    public SquareClientBuilder token(String token) {
        this.token = token;
        return this;
    }

    /**
     * Sets version
     */
    public SquareClientBuilder version(String version) {
        this.version = version;
        return this;
    }

    public SquareClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public SquareClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public SquareClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public SquareClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public SquareClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    public SquareClient build() {
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + this.token);
        this.clientOptionsBuilder.addHeader("Square-Version", this.version);
        clientOptionsBuilder.environment(this.environment);
        return new SquareClient(clientOptionsBuilder.build());
    }
}
