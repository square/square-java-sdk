
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
     * @return the timeout in seconds
     */
    public long getTimeout() {
        return timeout;
    }

    /**
     * Setter for timeout.
     * @param timeout The timeout to set in seconds.
     */
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    /**
     * Converts this HttpClientConfiguration into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "HttpClientConfiguration [" + "timeout=" + timeout + "]";
    }
}