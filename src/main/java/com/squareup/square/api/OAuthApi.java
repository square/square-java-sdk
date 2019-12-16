package com.squareup.square.api;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.*;
import com.squareup.square.exceptions.*;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.Headers;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.*;

public final class OAuthApi extends BaseApi {
    public OAuthApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public OAuthApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
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
            final String authorization
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRenewTokenRequest(clientId, body, authorization);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRenewTokenResponse(_context);
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
            final String authorization
    ) {
        return makeHttpCallAsync(() -> _buildRenewTokenRequest(clientId, body, authorization),
                _request -> getClientInstance().executeAsStringAsync(_request),
                _context -> _handleRenewTokenResponse(_context));
    }

    /**
     * Builds the HttpRequest object for renewToken
     */
    private HttpRequest _buildRenewTokenRequest(
            final String clientId,
            final RenewTokenRequest body,
            final String authorization
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/oauth2/clients/{client_id}/access-token/renew");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("client_id", clientId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("Authorization", authorization);
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("content-type", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String _bodyJson = ApiHelper.serialize(body);
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for renewToken
     * @return An object of type RenewTokenResponse
     */
    private RenewTokenResponse _handleRenewTokenResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        RenewTokenResponse _result = ApiHelper.deserialize(_responseBody,
                RenewTokenResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
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
            final String authorization
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRevokeTokenRequest(body, authorization);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRevokeTokenResponse(_context);
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
            final String authorization
    ) {
        return makeHttpCallAsync(() -> _buildRevokeTokenRequest(body, authorization),
                _request -> getClientInstance().executeAsStringAsync(_request),
                _context -> _handleRevokeTokenResponse(_context));
    }

    /**
     * Builds the HttpRequest object for revokeToken
     */
    private HttpRequest _buildRevokeTokenRequest(
            final RevokeTokenRequest body,
            final String authorization
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/oauth2/revoke");
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("Authorization", authorization);
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("content-type", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String _bodyJson = ApiHelper.serialize(body);
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for revokeToken
     * @return An object of type RevokeTokenResponse
     */
    private RevokeTokenResponse _handleRevokeTokenResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        RevokeTokenResponse _result = ApiHelper.deserialize(_responseBody,
                RevokeTokenResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
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
            final ObtainTokenRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildObtainTokenRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleObtainTokenResponse(_context);
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
            final ObtainTokenRequest body
    ) {
        return makeHttpCallAsync(() -> _buildObtainTokenRequest(body),
                _request -> getClientInstance().executeAsStringAsync(_request),
                _context -> _handleObtainTokenResponse(_context));
    }

    /**
     * Builds the HttpRequest object for obtainToken
     */
    private HttpRequest _buildObtainTokenRequest(
            final ObtainTokenRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/oauth2/token");
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("content-type", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String _bodyJson = ApiHelper.serialize(body);
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for obtainToken
     * @return An object of type ObtainTokenResponse
     */
    private ObtainTokenResponse _handleObtainTokenResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        ObtainTokenResponse _result = ApiHelper.deserialize(_responseBody,
                ObtainTokenResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
