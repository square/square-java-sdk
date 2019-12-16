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

public final class EmployeesApi extends BaseApi {
    public EmployeesApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public EmployeesApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * ListEmployees
     * @param    locationId    Optional parameter: Filter employees returned to only those that are associated with the specified location.
     * @param    status    Optional parameter: Specifies the EmployeeStatus to filter the employee by.
     * @param    limit    Optional parameter: The number of employees to be returned on each page.
     * @param    cursor    Optional parameter: The token required to retrieve the specified page of results.
     * @return    Returns the ListEmployeesResponse response from the API call
     */
    public ListEmployeesResponse listEmployees(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListEmployeesRequest(locationId, status, limit, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListEmployeesResponse(_context);
    }

    /**
     * ListEmployees
     * @param    locationId    Optional parameter: Filter employees returned to only those that are associated with the specified location.
     * @param    status    Optional parameter: Specifies the EmployeeStatus to filter the employee by.
     * @param    limit    Optional parameter: The number of employees to be returned on each page.
     * @param    cursor    Optional parameter: The token required to retrieve the specified page of results.
     * @return    Returns the ListEmployeesResponse response from the API call 
     */
    public CompletableFuture<ListEmployeesResponse> listEmployeesAsync(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildListEmployeesRequest(locationId, status, limit, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListEmployeesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listEmployees
     */
    private HttpRequest _buildListEmployeesRequest(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/employees");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("location_id", locationId);
        _queryParameters.put("status", status);
        _queryParameters.put("limit", limit);
        _queryParameters.put("cursor", cursor);
        ApiHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
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
     * Processes the response for listEmployees
     * @return An object of type ListEmployeesResponse
     */
    private ListEmployeesResponse _handleListEmployeesResponse(HttpContext _context)
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
        ListEmployeesResponse _result = ApiHelper.deserialize(_responseBody,
                ListEmployeesResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * RetrieveEmployee
     * @param    id    Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call
     */
    public RetrieveEmployeeResponse retrieveEmployee(
            final String id
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveEmployeeRequest(id);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveEmployeeResponse(_context);
    }

    /**
     * RetrieveEmployee
     * @param    id    Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call 
     */
    public CompletableFuture<RetrieveEmployeeResponse> retrieveEmployeeAsync(
            final String id
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveEmployeeRequest(id),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveEmployeeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveEmployee
     */
    private HttpRequest _buildRetrieveEmployeeRequest(
            final String id
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/employees/{id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("id", id);
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
     * Processes the response for retrieveEmployee
     * @return An object of type RetrieveEmployeeResponse
     */
    private RetrieveEmployeeResponse _handleRetrieveEmployeeResponse(HttpContext _context)
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
        RetrieveEmployeeResponse _result = ApiHelper.deserialize(_responseBody,
                RetrieveEmployeeResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
