
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.ObtainTokenRequest;
import com.squareup.square.models.ObtainTokenResponse;
import com.squareup.square.models.RenewTokenRequest;
import com.squareup.square.models.RenewTokenResponse;
import com.squareup.square.models.RetrieveTokenStatusResponse;
import com.squareup.square.models.RevokeTokenRequest;
import com.squareup.square.models.RevokeTokenResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultOAuthApi extends BaseApi implements OAuthApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultOAuthApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

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
     * application secret on the Credentials page in the [Developer
     * Dashboard](https://developer.squareup.com/apps).
     * @deprecated
     * 
     * @param  clientId  Required parameter: Your application ID, which is available in the OAuth
     *         page in the [Developer Dashboard](https://developer.squareup.com/apps).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RenewTokenResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public RenewTokenResponse renewToken(
            final String clientId,
            final RenewTokenRequest body,
            final String authorization) throws ApiException, IOException {
        return prepareRenewTokenRequest(clientId, body, authorization).execute();
    }

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
     * application secret on the Credentials page in the [Developer
     * Dashboard](https://developer.squareup.com/apps).
     * @deprecated
     * 
     * @param  clientId  Required parameter: Your application ID, which is available in the OAuth
     *         page in the [Developer Dashboard](https://developer.squareup.com/apps).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RenewTokenResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<RenewTokenResponse> renewTokenAsync(
            final String clientId,
            final RenewTokenRequest body,
            final String authorization) {
        try { 
            return prepareRenewTokenRequest(clientId, body, authorization).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for renewToken.
     */
    private ApiCall<RenewTokenResponse, ApiException> prepareRenewTokenRequest(
            final String clientId,
            final RenewTokenRequest body,
            final String authorization) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<RenewTokenResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/oauth2/clients/{client_id}/access-token/renew")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("client_id").value(clientId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("Authorization")
                                .value(authorization).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RenewTokenResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Revokes an access token generated with the OAuth flow. If an account has more than one OAuth
     * access token for your application, this endpoint revokes all of them, regardless of which
     * token you specify. When an OAuth access token is revoked, all of the active subscriptions
     * associated with that OAuth token are canceled immediately. __Important:__ The `Authorization`
     * header for this endpoint must have the following format: ``` Authorization: Client
     * APPLICATION_SECRET ``` Replace `APPLICATION_SECRET` with the application secret on the OAuth
     * page for your application on the Developer Dashboard.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RevokeTokenResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RevokeTokenResponse revokeToken(
            final RevokeTokenRequest body,
            final String authorization) throws ApiException, IOException {
        return prepareRevokeTokenRequest(body, authorization).execute();
    }

    /**
     * Revokes an access token generated with the OAuth flow. If an account has more than one OAuth
     * access token for your application, this endpoint revokes all of them, regardless of which
     * token you specify. When an OAuth access token is revoked, all of the active subscriptions
     * associated with that OAuth token are canceled immediately. __Important:__ The `Authorization`
     * header for this endpoint must have the following format: ``` Authorization: Client
     * APPLICATION_SECRET ``` Replace `APPLICATION_SECRET` with the application secret on the OAuth
     * page for your application on the Developer Dashboard.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  authorization  Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RevokeTokenResponse response from the API call
     */
    public CompletableFuture<RevokeTokenResponse> revokeTokenAsync(
            final RevokeTokenRequest body,
            final String authorization) {
        try { 
            return prepareRevokeTokenRequest(body, authorization).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for revokeToken.
     */
    private ApiCall<RevokeTokenResponse, ApiException> prepareRevokeTokenRequest(
            final RevokeTokenRequest body,
            final String authorization) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<RevokeTokenResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/oauth2/revoke")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("Authorization")
                                .value(authorization).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RevokeTokenResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns an OAuth access token and a refresh token unless the `short_lived` parameter is set
     * to `true`, in which case the endpoint returns only an access token. The `grant_type`
     * parameter specifies the type of OAuth request. If `grant_type` is `authorization_code`, you
     * must include the authorization code you received when a seller granted you authorization. If
     * `grant_type` is `refresh_token`, you must provide a valid refresh token. If you are using an
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
    public ObtainTokenResponse obtainToken(
            final ObtainTokenRequest body) throws ApiException, IOException {
        return prepareObtainTokenRequest(body).execute();
    }

    /**
     * Returns an OAuth access token and a refresh token unless the `short_lived` parameter is set
     * to `true`, in which case the endpoint returns only an access token. The `grant_type`
     * parameter specifies the type of OAuth request. If `grant_type` is `authorization_code`, you
     * must include the authorization code you received when a seller granted you authorization. If
     * `grant_type` is `refresh_token`, you must provide a valid refresh token. If you are using an
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
    public CompletableFuture<ObtainTokenResponse> obtainTokenAsync(
            final ObtainTokenRequest body) {
        try { 
            return prepareObtainTokenRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for obtainToken.
     */
    private ApiCall<ObtainTokenResponse, ApiException> prepareObtainTokenRequest(
            final ObtainTokenRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<ObtainTokenResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/oauth2/token")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ObtainTokenResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public RetrieveTokenStatusResponse retrieveTokenStatus(
            final String authorization) throws ApiException, IOException {
        return prepareRetrieveTokenStatusRequest(authorization).execute();
    }

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
    public CompletableFuture<RetrieveTokenStatusResponse> retrieveTokenStatusAsync(
            final String authorization) {
        try { 
            return prepareRetrieveTokenStatusRequest(authorization).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveTokenStatus.
     */
    private ApiCall<RetrieveTokenStatusResponse, ApiException> prepareRetrieveTokenStatusRequest(
            final String authorization) throws IOException {
        return new ApiCall.Builder<RetrieveTokenStatusResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/oauth2/token/status")
                        .headerParam(param -> param.key("Authorization")
                                .value(authorization).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveTokenStatusResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}