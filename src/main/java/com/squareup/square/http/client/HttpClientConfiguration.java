
package com.squareup.square.http.client;



/**
 * Class to hold HTTP Client Configuration.
 */
public class HttpClientConfiguration implements ReadonlyHttpClientConfiguration {

    private long timeout;

    /**
     * Default Constructor.
     */
    public HttpClientConfiguration() {
    }

    /**
     * Getter for timeout.
     * @return the timeout
     */
    public long getTimeout() {
        return timeout;
    }

    /**
     * Setter for timeout.
     * @param timeout The timeout to set.
     */
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}