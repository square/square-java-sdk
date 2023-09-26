
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.ObtainTokenRequest;
import com.squareup.square.models.ObtainTokenResponse;
import com.squareup.square.models.RenewTokenRequest;
import com.squareup.square.models.RenewTokenResponse;
import com.squareup.square.models.RetrieveTokenStatusResponse;
import com.squareup.square.models.RevokeTokenRequest;
import com.squareup.square.models.RevokeTokenResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface OAuthApi {
    /**
     * `RenewToken` is deprecated. For information about refreshing OAuth access tokens, see
     * [Migrate from Renew to Refresh OAuth
     * Tokens](https://developer.squareup.com/docs/oauth-api/migrate-to-refresh-tokens). Renews an
     * OAuth access token before it expires. OAuth access tokens besides your application's personal
     * access token expire after 30 days. You can also renew expired tokens within 15 days of their
     * expiration. You cannot renew an access token that has been expired for more than 15 days.
     * Instead, the associated user must recomplete the OAuth flow from the beginning.
     * __Important:__ The `Authorization` header for this endpoint must have the following format:
     * ``` Authorization: Client APPLICATION_SECRET ``` Replace `APPLICATION_SECRET` with the
     * application secret on the **Credentials** page in the [Developer
     * Dashboard](https://developer.squareup.com/apps).
     * @deprecated
     * 
     * @param  clientId  Required parameter: Your application ID, which is available on the
     *         **OAuth** page in the [Developer Dashboard](https://developer.squareup.com/apps).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RenewTokenResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    RenewTokenResponse renewToken(
            final String clientId,
            final RenewTokenRequest body,
            final String authorization) throws ApiException, IOException;

    /**
     * `RenewToken` is deprecated. For information about refreshing OAuth access tokens, see
     * [Migrate from Renew to Refresh OAuth
     * Tokens](https://developer.squareup.com/docs/oauth-api/migrate-to-refresh-tokens). Renews an
     * OAuth access token before it expires. OAuth access tokens besides your application's personal
     * access token expire after 30 days. You can also renew expired tokens within 15 days of their
     * expiration. You cannot renew an access token that has been expired for more than 15 days.
     * Instead, the associated user must recomplete the OAuth flow from the beginning.
     * __Important:__ The `Authorization` header for this endpoint must have the following format:
     * ``` Authorization: Client APPLICATION_SECRET ``` Replace `APPLICATION_SECRET` with the
     * application secret on the **Credentials** page in the [Developer
     * Dashboard](https://developer.squareup.com/apps).
     * @deprecated
     * 
     * @param  clientId  Required parameter: Your application ID, which is available on the
     *         **OAuth** page in the [Developer Dashboard](https://developer.squareup.com/apps).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RenewTokenResponse response from the API call
     */
    @Deprecated
    CompletableFuture<RenewTokenResponse> renewTokenAsync(
            final String clientId,
            final RenewTokenRequest body,
            final String authorization);

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
    RevokeTokenResponse revokeToken(
            final RevokeTokenRequest body,
            final String authorization) throws ApiException, IOException;

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
    CompletableFuture<RevokeTokenResponse> revokeTokenAsync(
            final RevokeTokenRequest body,
            final String authorization);

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
    ObtainTokenResponse obtainToken(
            final ObtainTokenRequest body) throws ApiException, IOException;

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
    CompletableFuture<ObtainTokenResponse> obtainTokenAsync(
            final ObtainTokenRequest body);

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
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RetrieveTokenStatusResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveTokenStatusResponse retrieveTokenStatus(
            final String authorization) throws ApiException, IOException;

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
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RetrieveTokenStatusResponse response from the API call
     */
    CompletableFuture<RetrieveTokenStatusResponse> retrieveTokenStatusAsync(
            final String authorization);

}