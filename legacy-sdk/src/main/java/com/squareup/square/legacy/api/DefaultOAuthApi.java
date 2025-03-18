package com.squareup.square.legacy.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.legacy.ApiHelper;
import com.squareup.square.legacy.Server;
import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.http.client.HttpContext;
import com.squareup.square.legacy.http.request.HttpMethod;
import com.squareup.square.legacy.models.ObtainTokenRequest;
import com.squareup.square.legacy.models.ObtainTokenResponse;
import com.squareup.square.legacy.models.RetrieveTokenStatusResponse;
import com.squareup.square.legacy.models.RevokeTokenRequest;
import com.squareup.square.legacy.models.RevokeTokenResponse;
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
    public RevokeTokenResponse revokeToken(final RevokeTokenRequest body, final String authorization)
            throws ApiException, IOException {
        return prepareRevokeTokenRequest(body, authorization).execute();
    }

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
    public CompletableFuture<RevokeTokenResponse> revokeTokenAsync(
            final RevokeTokenRequest body, final String authorization) {
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
            final RevokeTokenRequest body, final String authorization) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<RevokeTokenResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/oauth2/revoke")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param ->
                                param.key("Authorization").value(authorization).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, RevokeTokenResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public ObtainTokenResponse obtainToken(final ObtainTokenRequest body) throws ApiException, IOException {
        return prepareObtainTokenRequest(body).execute();
    }

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
    public CompletableFuture<ObtainTokenResponse> obtainTokenAsync(final ObtainTokenRequest body) {
        try {
            return prepareObtainTokenRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for obtainToken.
     */
    private ApiCall<ObtainTokenResponse, ApiException> prepareObtainTokenRequest(final ObtainTokenRequest body)
            throws JsonProcessingException, IOException {
        return new ApiCall.Builder<ObtainTokenResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/oauth2/token")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, ObtainTokenResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
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
     * @return    Returns the RetrieveTokenStatusResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveTokenStatusResponse retrieveTokenStatus() throws ApiException, IOException {
        return prepareRetrieveTokenStatusRequest().execute();
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
     * @return    Returns the RetrieveTokenStatusResponse response from the API call
     */
    public CompletableFuture<RetrieveTokenStatusResponse> retrieveTokenStatusAsync() {
        try {
            return prepareRetrieveTokenStatusRequest().executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for retrieveTokenStatus.
     */
    private ApiCall<RetrieveTokenStatusResponse, ApiException> prepareRetrieveTokenStatusRequest() throws IOException {
        return new ApiCall.Builder<RetrieveTokenStatusResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/oauth2/token/status")
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, RetrieveTokenStatusResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}
