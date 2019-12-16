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

public final class ApplePayApi extends BaseApi {
    public ApplePayApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public ApplePayApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Activates a domain for use with Web Apple Pay and Square. A validation
     * will be performed on this domain by Apple to ensure is it properly set up as
     * an Apple Pay enabled domain.
     * This endpoint provides an easy way for platform developers to bulk activate
     * Web Apple Pay with Square for merchants using their platform.
     * To learn more about Apple Pay on Web see the Apple Pay section in the
     * [Square Payment Form Walkthrough](https://developer.squareup.com/docs/docs/payment-form/payment-form-walkthrough).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the RegisterDomainResponse response from the API call
     */
    public RegisterDomainResponse registerDomain(
            final RegisterDomainRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRegisterDomainRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRegisterDomainResponse(_context);
    }

    /**
     * Activates a domain for use with Web Apple Pay and Square. A validation
     * will be performed on this domain by Apple to ensure is it properly set up as
     * an Apple Pay enabled domain.
     * This endpoint provides an easy way for platform developers to bulk activate
     * Web Apple Pay with Square for merchants using their platform.
     * To learn more about Apple Pay on Web see the Apple Pay section in the
     * [Square Payment Form Walkthrough](https://developer.squareup.com/docs/docs/payment-form/payment-form-walkthrough).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the RegisterDomainResponse response from the API call 
     */
    public CompletableFuture<RegisterDomainResponse> registerDomainAsync(
            final RegisterDomainRequest body
    ) {
        return makeHttpCallAsync(() -> _buildRegisterDomainRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRegisterDomainResponse(_context));
    }

    /**
     * Builds the HttpRequest object for registerDomain
     */
    private HttpRequest _buildRegisterDomainRequest(
            final RegisterDomainRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/apple-pay/domains");
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
     * Processes the response for registerDomain
     * @return An object of type RegisterDomainResponse
     */
    private RegisterDomainResponse _handleRegisterDomainResponse(HttpContext _context)
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
        RegisterDomainResponse _result = ApiHelper.deserialize(_responseBody,
                RegisterDomainResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
