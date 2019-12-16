package com.squareup.square;

import com.squareup.square.http.Headers;

public interface Configuration {

    /**
     * Current API environment
     * @return a copy of environment
     */
    Environment getEnvironment();

    /**
     * OAuth 2.0 Access Token
     * @return a copy of accessToken
     */
    String getAccessToken();

    /**
     * The timeout to use for making HTTP requests.
     * @return a copy of timeout
     */
    long getTimeout();

    /**
     * Additional headers to add to each API request
     * @return a copy of additionalHeaders
     */
    Headers getAdditionalHeaders();

    /**
     * Get base URI by current environment
     * @param server Server for which to get the base URI
     * @return Processed base URI
     */
    String getBaseUri(Server server);

    /**
     * Get base URI by current environment
     * @return Processed base URI
     */
    String getBaseUri();
}
