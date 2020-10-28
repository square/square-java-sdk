
package com.squareup.square.http.client;


/**
 * Interface for holding HTTP Client Configuration.
 */
public interface ReadonlyHttpClientConfiguration {

    /**
     * Long value for timeout.
     * @return the timeout
     */
    public long getTimeout();
}