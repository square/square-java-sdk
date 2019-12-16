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

public final class LocationsApi extends BaseApi {
    public LocationsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public LocationsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Provides information of all locations of a business.
     * Most other Connect API endpoints have a required `location_id` path parameter.
     * The `id` field of the [`Location`](#type-location) objects returned by this
     * endpoint correspond to that `location_id` parameter.
     * @return    Returns the ListLocationsResponse response from the API call
     */
    public ListLocationsResponse listLocations() throws ApiException, IOException {
        HttpRequest _request = _buildListLocationsRequest();
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListLocationsResponse(_context);
    }

    /**
     * Provides information of all locations of a business.
     * Most other Connect API endpoints have a required `location_id` path parameter.
     * The `id` field of the [`Location`](#type-location) objects returned by this
     * endpoint correspond to that `location_id` parameter.
     * @return    Returns the ListLocationsResponse response from the API call 
     */
    public CompletableFuture<ListLocationsResponse> listLocationsAsync() {
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
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations");
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
     * @return An object of type ListLocationsResponse
     */
    private ListLocationsResponse _handleListLocationsResponse(HttpContext _context)
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
        ListLocationsResponse _result = ApiHelper.deserialize(_responseBody,
                ListLocationsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Creates a location.
     * For more information about locations, see [Locations API Overview](https://developer.squareup.com/docs/locations-api).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateLocationResponse response from the API call
     */
    public CreateLocationResponse createLocation(
            final CreateLocationRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateLocationRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateLocationResponse(_context);
    }

    /**
     * Creates a location.
     * For more information about locations, see [Locations API Overview](https://developer.squareup.com/docs/locations-api).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateLocationResponse response from the API call 
     */
    public CompletableFuture<CreateLocationResponse> createLocationAsync(
            final CreateLocationRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreateLocationRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateLocationResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createLocation
     */
    private HttpRequest _buildCreateLocationRequest(
            final CreateLocationRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations");
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
     * Processes the response for createLocation
     * @return An object of type CreateLocationResponse
     */
    private CreateLocationResponse _handleCreateLocationResponse(HttpContext _context)
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
        CreateLocationResponse _result = ApiHelper.deserialize(_responseBody,
                CreateLocationResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Retrieves details of a location.
     * @param    locationId    Required parameter: The ID of the location to retrieve.
     * @return    Returns the RetrieveLocationResponse response from the API call
     */
    public RetrieveLocationResponse retrieveLocation(
            final String locationId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveLocationRequest(locationId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveLocationResponse(_context);
    }

    /**
     * Retrieves details of a location.
     * @param    locationId    Required parameter: The ID of the location to retrieve.
     * @return    Returns the RetrieveLocationResponse response from the API call 
     */
    public CompletableFuture<RetrieveLocationResponse> retrieveLocationAsync(
            final String locationId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveLocationRequest(locationId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveLocationResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveLocation
     */
    private HttpRequest _buildRetrieveLocationRequest(
            final String locationId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
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
     * Processes the response for retrieveLocation
     * @return An object of type RetrieveLocationResponse
     */
    private RetrieveLocationResponse _handleRetrieveLocationResponse(HttpContext _context)
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
        RetrieveLocationResponse _result = ApiHelper.deserialize(_responseBody,
                RetrieveLocationResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Updates a location.
     * @param    locationId    Required parameter: The ID of the location to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationResponse response from the API call
     */
    public UpdateLocationResponse updateLocation(
            final String locationId,
            final UpdateLocationRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateLocationRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateLocationResponse(_context);
    }

    /**
     * Updates a location.
     * @param    locationId    Required parameter: The ID of the location to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationResponse response from the API call 
     */
    public CompletableFuture<UpdateLocationResponse> updateLocationAsync(
            final String locationId,
            final UpdateLocationRequest body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateLocationRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateLocationResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateLocation
     */
    private HttpRequest _buildUpdateLocationRequest(
            final String locationId,
            final UpdateLocationRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
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
        HttpRequest _request = getClientInstance().putBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for updateLocation
     * @return An object of type UpdateLocationResponse
     */
    private UpdateLocationResponse _handleUpdateLocationResponse(HttpContext _context)
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
        UpdateLocationResponse _result = ApiHelper.deserialize(_responseBody,
                UpdateLocationResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
