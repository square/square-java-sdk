package com.squareup.square.http.client;


/**
 * Class to hold HTTP Client Configuration
 */
public class HttpClientConfiguration implements ReadonlyHttpClientConfiguration {
    private long timeout;
    /**
     * Default Constructor
     */
    public HttpClientConfiguration() {
    }

    /**
     * @return the timeout
     */
    public long getTimeout() {
        return timeout;
    }

    /**
     * @param timeout
     */
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }


}
