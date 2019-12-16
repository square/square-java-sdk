package com.squareup.square.api;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

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

public final class V1LocationsApi extends BaseApi {
    public V1LocationsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public V1LocationsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Get the general information for a business.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-locations)
     * ---
     * @deprecated
     * 
     * @return    Returns the V1Merchant response from the API call
     */
    @Deprecated
    public V1Merchant retrieveBusiness() throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveBusinessRequest();
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveBusinessResponse(_context);
    }

    /**
     * Get the general information for a business.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-locations)
     * ---
     * @deprecated
     * 
     * @return    Returns the V1Merchant response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Merchant> retrieveBusinessAsync() {
        return makeHttpCallAsync(() -> _buildRetrieveBusinessRequest(),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveBusinessResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveBusiness
     */
    private HttpRequest _buildRetrieveBusinessRequest() {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me");
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for retrieveBusiness
     * @return An object of type V1Merchant
     */
    private V1Merchant _handleRetrieveBusinessResponse(HttpContext _context)
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
        V1Merchant _result = ApiHelper.deserialize(_responseBody,
                V1Merchant.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides details for all business locations associated with a Square
     * account, including the Square-assigned object ID for the location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-locations)
     * ---
     * @deprecated
     * 
     * @return    Returns the List<V1Merchant> response from the API call
     */
    @Deprecated
    public List<V1Merchant> listLocations() throws ApiException, IOException {
        HttpRequest _request = _buildListLocationsRequest();
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListLocationsResponse(_context);
    }

    /**
     * Provides details for all business locations associated with a Square
     * account, including the Square-assigned object ID for the location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-locations)
     * ---
     * @deprecated
     * 
     * @return    Returns the List<V1Merchant> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Merchant>> listLocationsAsync() {
        return makeHttpCallAsync(() -> _buildListLocationsRequest(),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListLocationsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listLocations
     */
    private HttpRequest _buildListLocationsRequest() {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/locations");
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for listLocations
     * @return An object of type List<V1Merchant>
     */
    private List<V1Merchant> _handleListLocationsResponse(HttpContext _context)
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
        List<V1Merchant> _result = ApiHelper.deserializeArray(_responseBody,
                V1Merchant[].class);
        return _result;
    }

}
