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

public final class MobileAuthorizationApi extends BaseApi {
    public MobileAuthorizationApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public MobileAuthorizationApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Generates code to authorize a mobile application to connect to a Square card reader
     * Authorization codes are one-time-use and expire __60 minutes__ after being issued.
     * __Important:__ The `Authorization` header you provide to this endpoint must have the following format:
     * ```
     * Authorization: Bearer ACCESS_TOKEN
     * ```
     * Replace `ACCESS_TOKEN` with a
     * [valid production authorization credential](https://developer.squareup.com/docs/docs/build-basics/access-tokens).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateMobileAuthorizationCodeResponse response from the API call
     */
    public CreateMobileAuthorizationCodeResponse createMobileAuthorizationCode(
            final CreateMobileAuthorizationCodeRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateMobileAuthorizationCodeRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateMobileAuthorizationCodeResponse(_context);
    }

    /**
     * Generates code to authorize a mobile application to connect to a Square card reader
     * Authorization codes are one-time-use and expire __60 minutes__ after being issued.
     * __Important:__ The `Authorization` header you provide to this endpoint must have the following format:
     * ```
     * Authorization: Bearer ACCESS_TOKEN
     * ```
     * Replace `ACCESS_TOKEN` with a
     * [valid production authorization credential](https://developer.squareup.com/docs/docs/build-basics/access-tokens).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateMobileAuthorizationCodeResponse response from the API call 
     */
    public CompletableFuture<CreateMobileAuthorizationCodeResponse> createMobileAuthorizationCodeAsync(
            final CreateMobileAuthorizationCodeRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreateMobileAuthorizationCodeRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateMobileAuthorizationCodeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createMobileAuthorizationCode
     */
    private HttpRequest _buildCreateMobileAuthorizationCodeRequest(
            final CreateMobileAuthorizationCodeRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/mobile/authorization-code");
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
     * Processes the response for createMobileAuthorizationCode
     * @return An object of type CreateMobileAuthorizationCodeResponse
     */
    private CreateMobileAuthorizationCodeResponse _handleCreateMobileAuthorizationCodeResponse(HttpContext _context)
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
        CreateMobileAuthorizationCodeResponse _result = ApiHelper.deserialize(_responseBody,
                CreateMobileAuthorizationCodeResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
