package com.squareup.square.legacy.api;

import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.ObtainTokenRequest;
import com.squareup.square.legacy.models.ObtainTokenResponse;
import com.squareup.square.legacy.models.RetrieveTokenStatusResponse;
import com.squareup.square.legacy.models.RevokeTokenRequest;
import com.squareup.square.legacy.models.RevokeTokenResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface OAuthApi {
    /**
     * Revokes an access token generated with the OAuth flow. If an account has more than one OAuth
     * access token for your application, this endpoint revokes all of them, regardless of which
     * token you specify. __Important:__ The `Authorization` header for this endpoint must have the
     * following format: ``` Authorization: Client APPLICATION_SECRET ``` Replace
     * `APPLICATION_SECRET` with the application secret on the **OAuth** page for your application
     * in the Developer Dashboard.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RevokeTokenResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RevokeTokenResponse revokeToken(final RevokeTokenRequest body, final String authorization)
            throws ApiException, IOException;

    /**
     * Revokes an access token generated with the OAuth flow. If an account has more than one OAuth
     * access token for your application, this endpoint revokes all of them, regardless of which
     * token you specify. __Important:__ The `Authorization` header for this endpoint must have the
     * following format: ``` Authorization: Client APPLICATION_SECRET ``` Replace
     * `APPLICATION_SECRET` with the application secret on the **OAuth** page for your application
     * in the Developer Dashboard.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RevokeTokenResponse response from the API call
     */
    CompletableFuture<RevokeTokenResponse> revokeTokenAsync(final RevokeTokenRequest body, final String authorization);

    /**
     * Returns an OAuth access token and a refresh token unless the `short_lived` parameter is set
     * to `true`, in which case the endpoint returns only an access token. The `grant_type`
     * parameter specifies the type of OAuth request. If `grant_type` is `authorization_code`, you
     * must include the authorization code you received when a seller granted you authorization. If
     * `grant_type` is `refresh_token`, you must provide a valid refresh token. If you're using an
     * old version of the Square APIs (prior to March 13, 2019), `grant_type` can be
     * `migration_token` and you must provide a valid migration token. You can use the `scopes`
     * parameter to limit the set of permissions granted to the access token and refresh token. You
     * can use the `short_lived` parameter to create an access token that expires in 24 hours.
     * __Note:__ OAuth tokens should be encrypted and stored on a secure server. Application clients
     * should never interact directly with OAuth tokens.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ObtainTokenResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ObtainTokenResponse obtainToken(final ObtainTokenRequest body) throws ApiException, IOException;

    /**
     * Returns an OAuth access token and a refresh token unless the `short_lived` parameter is set
     * to `true`, in which case the endpoint returns only an access token. The `grant_type`
     * parameter specifies the type of OAuth request. If `grant_type` is `authorization_code`, you
     * must include the authorization code you received when a seller granted you authorization. If
     * `grant_type` is `refresh_token`, you must provide a valid refresh token. If you're using an
     * old version of the Square APIs (prior to March 13, 2019), `grant_type` can be
     * `migration_token` and you must provide a valid migration token. You can use the `scopes`
     * parameter to limit the set of permissions granted to the access token and refresh token. You
     * can use the `short_lived` parameter to create an access token that expires in 24 hours.
     * __Note:__ OAuth tokens should be encrypted and stored on a secure server. Application clients
     * should never interact directly with OAuth tokens.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ObtainTokenResponse response from the API call
     */
    CompletableFuture<ObtainTokenResponse> obtainTokenAsync(final ObtainTokenRequest body);

    /**
     * Returns information about an [OAuth access
     * token](https://developer.squareup.com/docs/build-basics/access-tokens#get-an-oauth-access-token) or
     * an application’s [personal access
     * token](https://developer.squareup.com/docs/build-basics/access-tokens#get-a-personal-access-token).
     * Add the access token to the Authorization header of the request. __Important:__ The
     * `Authorization` header you provide to this endpoint must have the following format: ```
     * Authorization: Bearer ACCESS_TOKEN ``` where `ACCESS_TOKEN` is a [valid production
     * authorization credential](https://developer.squareup.com/docs/build-basics/access-tokens). If
     * the access token is expired or not a valid access token, the endpoint returns an
     * `UNAUTHORIZED` error.
     * @return    Returns the RetrieveTokenStatusResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveTokenStatusResponse retrieveTokenStatus() throws ApiException, IOException;

    /**
     * Returns information about an [OAuth access
     * token](https://developer.squareup.com/docs/build-basics/access-tokens#get-an-oauth-access-token) or
     * an application’s [personal access
     * token](https://developer.squareup.com/docs/build-basics/access-tokens#get-a-personal-access-token).
     * Add the access token to the Authorization header of the request. __Important:__ The
     * `Authorization` header you provide to this endpoint must have the following format: ```
     * Authorization: Bearer ACCESS_TOKEN ``` where `ACCESS_TOKEN` is a [valid production
     * authorization credential](https://developer.squareup.com/docs/build-basics/access-tokens). If
     * the access token is expired or not a valid access token, the endpoint returns an
     * `UNAUTHORIZED` error.
     * @return    Returns the RetrieveTokenStatusResponse response from the API call
     */
    CompletableFuture<RetrieveTokenStatusResponse> retrieveTokenStatusAsync();
}
