package com.squareup.square.legacy;

import com.squareup.square.legacy.authentication.BearerAuthModel;
import com.squareup.square.legacy.http.Headers;
import com.squareup.square.legacy.http.client.ReadonlyHttpClientConfiguration;

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
     * @return a copy of httpClientConfig
     */
    ReadonlyHttpClientConfiguration getHttpClientConfig();

    /**
     * Additional headers to add to each API request.
     * @return a copy of additionalHeaders
     */
    Headers getAdditionalHeaders();

    /**
     * Additional detail which can be appended with User-Agent header.
     * @return a copy of userAgentDetail
     */
    String getUserAgentDetail();

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
     * The credentials to use with BearerAuth.
     * @return bearerAuthCredentials
     */
    BearerAuthCredentials getBearerAuthCredentials();

    /**
     * The auth credential model for BearerAuth.
     * @return the instance of BearerAuthModel
     */
    BearerAuthModel getBearerAuthModel();

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
