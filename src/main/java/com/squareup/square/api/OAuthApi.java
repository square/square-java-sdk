
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.ObtainTokenRequest;
import com.squareup.square.models.ObtainTokenResponse;
import com.squareup.square.models.RenewTokenRequest;
import com.squareup.square.models.RenewTokenResponse;
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
     * `RenewToken` is deprecated. For information about refreshing OAuth access tokens, see [Renew
     * OAuth Token](https://developer.squareup.com/docs/oauth-api/cookbook/renew-oauth-tokens).
     * Renews an OAuth access token before it expires. OAuth access tokens besides your
     * application's personal access token expire after __30 days__. You can also renew expired
     * tokens within __15 days__ of their expiration. You cannot renew an access token that has been
     * expired for more than 15 days. Instead, the associated user must re-complete the OAuth flow
     * from the beginning. __Important:__ The `Authorization` header for this endpoint must have the
     * following format: ``` Authorization: Client APPLICATION_SECRET ``` Replace
     * `APPLICATION_SECRET` with the application secret on the Credentials page in the [application
     * dashboard](https://connect.squareup.com/apps).
     * @deprecated
     * 
     * @param  clientId  Required parameter: Your application ID, available from the [application
     *         dashboard](https://connect.squareup.com/apps).
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
     * `RenewToken` is deprecated. For information about refreshing OAuth access tokens, see [Renew
     * OAuth Token](https://developer.squareup.com/docs/oauth-api/cookbook/renew-oauth-tokens).
     * Renews an OAuth access token before it expires. OAuth access tokens besides your
     * application's personal access token expire after __30 days__. You can also renew expired
     * tokens within __15 days__ of their expiration. You cannot renew an access token that has been
     * expired for more than 15 days. Instead, the associated user must re-complete the OAuth flow
     * from the beginning. __Important:__ The `Authorization` header for this endpoint must have the
     * following format: ``` Authorization: Client APPLICATION_SECRET ``` Replace
     * `APPLICATION_SECRET` with the application secret on the Credentials page in the [application
     * dashboard](https://connect.squareup.com/apps).
     * @deprecated
     * 
     * @param  clientId  Required parameter: Your application ID, available from the [application
     *         dashboard](https://connect.squareup.com/apps).
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
     * token you specify. When an OAuth access token is revoked, all of the active subscriptions
     * associated with that OAuth token are canceled immediately. __Important:__ The `Authorization`
     * header for this endpoint must have the following format: ``` Authorization: Client
     * APPLICATION_SECRET ``` Replace `APPLICATION_SECRET` with the application secret on the
     * Credentials page in the [Developer Dashboard](https://developer.squareup.com/apps).
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
     * token you specify. When an OAuth access token is revoked, all of the active subscriptions
     * associated with that OAuth token are canceled immediately. __Important:__ The `Authorization`
     * header for this endpoint must have the following format: ``` Authorization: Client
     * APPLICATION_SECRET ``` Replace `APPLICATION_SECRET` with the application secret on the
     * Credentials page in the [Developer Dashboard](https://developer.squareup.com/apps).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RevokeTokenResponse response from the API call
     */
    CompletableFuture<RevokeTokenResponse> revokeTokenAsync(
            final RevokeTokenRequest body,
            final String authorization);

    /**
     * Returns an OAuth access token. The endpoint supports distinct methods of obtaining OAuth
     * access tokens. Applications specify a method by adding the `grant_type` parameter in the
     * request and also provide relevant information. __Note:__ Regardless of the method application
     * specified, the endpoint always returns two items; an OAuth access token and a refresh token
     * in the response. __OAuth tokens should only live on secure servers. Application clients
     * should never interact directly with OAuth tokens__.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ObtainTokenResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ObtainTokenResponse obtainToken(
            final ObtainTokenRequest body) throws ApiException, IOException;

    /**
     * Returns an OAuth access token. The endpoint supports distinct methods of obtaining OAuth
     * access tokens. Applications specify a method by adding the `grant_type` parameter in the
     * request and also provide relevant information. __Note:__ Regardless of the method application
     * specified, the endpoint always returns two items; an OAuth access token and a refresh token
     * in the response. __OAuth tokens should only live on secure servers. Application clients
     * should never interact directly with OAuth tokens__.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ObtainTokenResponse response from the API call
     */
    CompletableFuture<ObtainTokenResponse> obtainTokenAsync(
            final ObtainTokenRequest body);

}