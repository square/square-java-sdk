package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.AuthManager;
import com.squareup.square.Configuration;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.Headers;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.ObtainTokenRequest;
import com.squareup.square.models.ObtainTokenResponse;
import com.squareup.square.models.RenewTokenRequest;
import com.squareup.square.models.RenewTokenResponse;
import com.squareup.square.models.RevokeTokenRequest;
import com.squareup.square.models.RevokeTokenResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultOAuthApi extends BaseApi implements OAuthApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultOAuthApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultOAuthApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * `RenewToken` is deprecated. For information about refreshing OAuth access tokens, see
     * [Renew OAuth Token](https://developer.squareup.com/docs/oauth-api/cookbook/renew-oauth-tokens).
     * Renews an OAuth access token before it expires.
     * OAuth access tokens besides your application's personal access token expire after __30 days__.
     * You can also renew expired tokens within __15 days__ of their expiration.
     * You cannot renew an access token that has been expired for more than 15 days.
     * Instead, the associated user must re-complete the OAuth flow from the beginning.
     * __Important:__ The `Authorization` header for this endpoint must have the
     * following format:
     * ```
     * Authorization: Client APPLICATION_SECRET
     * ```
     * Replace `APPLICATION_SECRET` with the application secret on the Credentials
     * page in the [application dashboard](https://connect.squareup.com/apps).
     * @deprecated
     * 
     * @param    clientId    Required parameter: Your application ID, available from the [application dashboard](https://connect.squareup.com/apps).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @param    authorization    Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RenewTokenResponse response from the API call
     */
    @Deprecated
    public RenewTokenResponse renewToken(
            final String clientId,
            final RenewTokenRequest body,
            final String authorization) throws ApiException, IOException {
        HttpRequest request = buildRenewTokenRequest(clientId, body, authorization);
        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRenewTokenResponse(context);
    }

    /**
     * `RenewToken` is deprecated. For information about refreshing OAuth access tokens, see
     * [Renew OAuth Token](https://developer.squareup.com/docs/oauth-api/cookbook/renew-oauth-tokens).
     * Renews an OAuth access token before it expires.
     * OAuth access tokens besides your application's personal access token expire after __30 days__.
     * You can also renew expired tokens within __15 days__ of their expiration.
     * You cannot renew an access token that has been expired for more than 15 days.
     * Instead, the associated user must re-complete the OAuth flow from the beginning.
     * __Important:__ The `Authorization` header for this endpoint must have the
     * following format:
     * ```
     * Authorization: Client APPLICATION_SECRET
     * ```
     * Replace `APPLICATION_SECRET` with the application secret on the Credentials
     * page in the [application dashboard](https://connect.squareup.com/apps).
     * @deprecated
     * 
     * @param    clientId    Required parameter: Your application ID, available from the [application dashboard](https://connect.squareup.com/apps).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @param    authorization    Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RenewTokenResponse response from the API call 
     */
    @Deprecated
    public CompletableFuture<RenewTokenResponse> renewTokenAsync(
            final String clientId,
            final RenewTokenRequest body,
            final String authorization) {
        return makeHttpCallAsync(() -> buildRenewTokenRequest(clientId, body, authorization),
                request -> getClientInstance().executeAsStringAsync(request),
                context -> handleRenewTokenResponse(context));
    }

    /**
     * Builds the HttpRequest object for renewToken
     */
    private HttpRequest buildRenewTokenRequest(
            final String clientId,
            final RenewTokenRequest body,
            final String authorization) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/oauth2/clients/{client_id}/access-token/renew");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("client_id", clientId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Authorization", authorization);
        headers.add("Square-Version", config.getSquareVersion());

        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for renewToken
     * @return An object of type RenewTokenResponse
     */
    private RenewTokenResponse handleRenewTokenResponse(HttpContext context)
            throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse)response).getBody();
        RenewTokenResponse result = ApiHelper.deserialize(responseBody,
                RenewTokenResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Revokes an access token generated with the OAuth flow.
     * If an account has more than one OAuth access token for your application, this
     * endpoint revokes all of them, regardless of which token you specify. When an
     * OAuth access token is revoked, all of the active subscriptions associated
     * with that OAuth token are canceled immediately.
     * __Important:__ The `Authorization` header for this endpoint must have the
     * following format:
     * ```
     * Authorization: Client APPLICATION_SECRET
     * ```
     * Replace `APPLICATION_SECRET` with the application secret on the Credentials
     * page in the [application dashboard](https://connect.squareup.com/apps).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @param    authorization    Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RevokeTokenResponse response from the API call
     */
    public RevokeTokenResponse revokeToken(
            final RevokeTokenRequest body,
            final String authorization) throws ApiException, IOException {
        HttpRequest request = buildRevokeTokenRequest(body, authorization);
        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRevokeTokenResponse(context);
    }

    /**
     * Revokes an access token generated with the OAuth flow.
     * If an account has more than one OAuth access token for your application, this
     * endpoint revokes all of them, regardless of which token you specify. When an
     * OAuth access token is revoked, all of the active subscriptions associated
     * with that OAuth token are canceled immediately.
     * __Important:__ The `Authorization` header for this endpoint must have the
     * following format:
     * ```
     * Authorization: Client APPLICATION_SECRET
     * ```
     * Replace `APPLICATION_SECRET` with the application secret on the Credentials
     * page in the [application dashboard](https://connect.squareup.com/apps).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @param    authorization    Required parameter: Client APPLICATION_SECRET
     * @return    Returns the RevokeTokenResponse response from the API call 
     */
    public CompletableFuture<RevokeTokenResponse> revokeTokenAsync(
            final RevokeTokenRequest body,
            final String authorization) {
        return makeHttpCallAsync(() -> buildRevokeTokenRequest(body, authorization),
                request -> getClientInstance().executeAsStringAsync(request),
                context -> handleRevokeTokenResponse(context));
    }

    /**
     * Builds the HttpRequest object for revokeToken
     */
    private HttpRequest buildRevokeTokenRequest(
            final RevokeTokenRequest body,
            final String authorization) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/oauth2/revoke");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Authorization", authorization);
        headers.add("Square-Version", config.getSquareVersion());

        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for revokeToken
     * @return An object of type RevokeTokenResponse
     */
    private RevokeTokenResponse handleRevokeTokenResponse(HttpContext context)
            throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse)response).getBody();
        RevokeTokenResponse result = ApiHelper.deserialize(responseBody,
                RevokeTokenResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns an OAuth access token.
     * The endpoint supports distinct methods of obtaining OAuth access tokens.
     * Applications specify a method by adding the `grant_type` parameter
     * in the request and also provide relevant information.
     * For more information, see [OAuth access token management](https://developer.squareup.com/docs/authz/oauth/how-it-works#oauth-access-token-management).
     * __Note:__ Regardless of the method application specified,
     * the endpoint always returns two items; an OAuth access token and
     * a refresh token in the response.
     * __OAuth tokens should only live on secure servers. Application clients
     * should never interact directly with OAuth tokens__.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the ObtainTokenResponse response from the API call
     */
    public ObtainTokenResponse obtainToken(
            final ObtainTokenRequest body) throws ApiException, IOException {
        HttpRequest request = buildObtainTokenRequest(body);
        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleObtainTokenResponse(context);
    }

    /**
     * Returns an OAuth access token.
     * The endpoint supports distinct methods of obtaining OAuth access tokens.
     * Applications specify a method by adding the `grant_type` parameter
     * in the request and also provide relevant information.
     * For more information, see [OAuth access token management](https://developer.squareup.com/docs/authz/oauth/how-it-works#oauth-access-token-management).
     * __Note:__ Regardless of the method application specified,
     * the endpoint always returns two items; an OAuth access token and
     * a refresh token in the response.
     * __OAuth tokens should only live on secure servers. Application clients
     * should never interact directly with OAuth tokens__.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the ObtainTokenResponse response from the API call 
     */
    public CompletableFuture<ObtainTokenResponse> obtainTokenAsync(
            final ObtainTokenRequest body) {
        return makeHttpCallAsync(() -> buildObtainTokenRequest(body),
                request -> getClientInstance().executeAsStringAsync(request),
                context -> handleObtainTokenResponse(context));
    }

    /**
     * Builds the HttpRequest object for obtainToken
     */
    private HttpRequest buildObtainTokenRequest(
            final ObtainTokenRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/oauth2/token");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());

        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for obtainToken
     * @return An object of type ObtainTokenResponse
     */
    private ObtainTokenResponse handleObtainTokenResponse(HttpContext context)
            throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse)response).getBody();
        ObtainTokenResponse result = ApiHelper.deserialize(responseBody,
                ObtainTokenResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}