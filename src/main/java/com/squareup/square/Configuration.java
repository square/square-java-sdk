
package com.squareup.square;

import com.squareup.square.http.Headers;
import com.squareup.square.http.client.ReadonlyHttpClientConfiguration;

/**
 * Configuration Interface for the library.
 */
public interface Configuration {

    /**
     * Current API environment.
     * @return a copy of environment
     */
    Environment getEnvironment();

    /**
     * Sets the base URL requests are made to. Defaults to `https://connect.squareup.com`
     * @return a copy of customUrl
     */
    String getCustomUrl();

    /**
     * Square Connect API versions.
     * @return a copy of squareVersion
     */
    String getSquareVersion();

    /**
     * Http Client Configuration instance. 
     * See available [builder methods here](__HttpClientConfiguration.Builder).
     * @return a copy of httpClientConfig
     */
    ReadonlyHttpClientConfiguration getHttpClientConfig();

    /**
     * Additional headers to add to each API request.
     * @return a copy of additionalHeaders
     */
    Headers getAdditionalHeaders();

    /**
     * The timeout to use for making HTTP requests. The timeout to use for making HTTP requests.
     * @return a copy of timeout
     */
    long timeout();

    /**
     * OAuth 2.0 Access Token.
     * @return accessToken
     */
    String getAccessToken();

    /**
     * Get base URI by current environment.
     * @param server Server for which to get the base URI
     * @return Processed base URI
     */
    String getBaseUri(Server server);

    /**
     * Get base URI by current environment.
     * @return Processed base URI
     */
    String getBaseUri();
}
