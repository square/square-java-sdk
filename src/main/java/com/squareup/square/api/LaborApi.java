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

public final class LaborApi extends BaseApi {
    public LaborApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public LaborApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Returns a paginated list of `BreakType` instances for a business.
     * @param    locationId    Optional parameter: Filter Break Types returned to only those that are associated with the specified location.
     * @param    limit    Optional parameter: Maximum number of Break Types to return per page. Can range between 1 and 200. The default is the maximum at 200.
     * @param    cursor    Optional parameter: Pointer to the next page of Break Type results to fetch.
     * @return    Returns the ListBreakTypesResponse response from the API call
     */
    public ListBreakTypesResponse listBreakTypes(
            final String locationId,
            final Integer limit,
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListBreakTypesRequest(locationId, limit, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListBreakTypesResponse(_context);
    }

    /**
     * Returns a paginated list of `BreakType` instances for a business.
     * @param    locationId    Optional parameter: Filter Break Types returned to only those that are associated with the specified location.
     * @param    limit    Optional parameter: Maximum number of Break Types to return per page. Can range between 1 and 200. The default is the maximum at 200.
     * @param    cursor    Optional parameter: Pointer to the next page of Break Type results to fetch.
     * @return    Returns the ListBreakTypesResponse response from the API call 
     */
    public CompletableFuture<ListBreakTypesResponse> listBreakTypesAsync(
            final String locationId,
            final Integer limit,
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildListBreakTypesRequest(locationId, limit, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListBreakTypesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listBreakTypes
     */
    private HttpRequest _buildListBreakTypesRequest(
            final String locationId,
            final Integer limit,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/break-types");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("location_id", locationId);
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
     * Processes the response for listBreakTypes
     * @return An object of type ListBreakTypesResponse
     */
    private ListBreakTypesResponse _handleListBreakTypesResponse(HttpContext _context)
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
        ListBreakTypesResponse _result = ApiHelper.deserialize(_responseBody,
                ListBreakTypesResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Creates a new `BreakType`. 
     * A `BreakType` is a template for creating `Break` objects. 
     * You must provide the following values in your request to this
     * endpoint:
     * - `location_id`
     * - `break_name`
     * - `expected_duration`
     * - `is_paid`
     * You can only have 3 `BreakType` instances per location. If you attempt to add a 4th
     * `BreakType` for a location, an `INVALID_REQUEST_ERROR` "Exceeded limit of 3 breaks per location."
     * is returned.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateBreakTypeResponse response from the API call
     */
    public CreateBreakTypeResponse createBreakType(
            final CreateBreakTypeRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateBreakTypeRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateBreakTypeResponse(_context);
    }

    /**
     * Creates a new `BreakType`. 
     * A `BreakType` is a template for creating `Break` objects. 
     * You must provide the following values in your request to this
     * endpoint:
     * - `location_id`
     * - `break_name`
     * - `expected_duration`
     * - `is_paid`
     * You can only have 3 `BreakType` instances per location. If you attempt to add a 4th
     * `BreakType` for a location, an `INVALID_REQUEST_ERROR` "Exceeded limit of 3 breaks per location."
     * is returned.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateBreakTypeResponse response from the API call 
     */
    public CompletableFuture<CreateBreakTypeResponse> createBreakTypeAsync(
            final CreateBreakTypeRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreateBreakTypeRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateBreakTypeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createBreakType
     */
    private HttpRequest _buildCreateBreakTypeRequest(
            final CreateBreakTypeRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/break-types");
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
     * Processes the response for createBreakType
     * @return An object of type CreateBreakTypeResponse
     */
    private CreateBreakTypeResponse _handleCreateBreakTypeResponse(HttpContext _context)
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
        CreateBreakTypeResponse _result = ApiHelper.deserialize(_responseBody,
                CreateBreakTypeResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes an existing `BreakType`. 
     * A `BreakType` can be deleted even if it is referenced from a `Shift`.
     * @param    id    Required parameter: UUID for the `BreakType` being deleted.
     * @return    Returns the DeleteBreakTypeResponse response from the API call
     */
    public DeleteBreakTypeResponse deleteBreakType(
            final String id
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteBreakTypeRequest(id);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteBreakTypeResponse(_context);
    }

    /**
     * Deletes an existing `BreakType`. 
     * A `BreakType` can be deleted even if it is referenced from a `Shift`.
     * @param    id    Required parameter: UUID for the `BreakType` being deleted.
     * @return    Returns the DeleteBreakTypeResponse response from the API call 
     */
    public CompletableFuture<DeleteBreakTypeResponse> deleteBreakTypeAsync(
            final String id
    ) {
        return makeHttpCallAsync(() -> _buildDeleteBreakTypeRequest(id),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteBreakTypeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteBreakType
     */
    private HttpRequest _buildDeleteBreakTypeRequest(
            final String id
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/break-types/{id}");

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
        HttpRequest _request = getClientInstance().delete(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for deleteBreakType
     * @return An object of type DeleteBreakTypeResponse
     */
    private DeleteBreakTypeResponse _handleDeleteBreakTypeResponse(HttpContext _context)
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
        DeleteBreakTypeResponse _result = ApiHelper.deserialize(_responseBody,
                DeleteBreakTypeResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a single `BreakType` specified by id.
     * @param    id    Required parameter: UUID for the `BreakType` being retrieved.
     * @return    Returns the GetBreakTypeResponse response from the API call
     */
    public GetBreakTypeResponse getBreakType(
            final String id
    ) throws ApiException, IOException {
        HttpRequest _request = _buildGetBreakTypeRequest(id);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetBreakTypeResponse(_context);
    }

    /**
     * Returns a single `BreakType` specified by id.
     * @param    id    Required parameter: UUID for the `BreakType` being retrieved.
     * @return    Returns the GetBreakTypeResponse response from the API call 
     */
    public CompletableFuture<GetBreakTypeResponse> getBreakTypeAsync(
            final String id
    ) {
        return makeHttpCallAsync(() -> _buildGetBreakTypeRequest(id),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleGetBreakTypeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for getBreakType
     */
    private HttpRequest _buildGetBreakTypeRequest(
            final String id
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/break-types/{id}");

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
     * Processes the response for getBreakType
     * @return An object of type GetBreakTypeResponse
     */
    private GetBreakTypeResponse _handleGetBreakTypeResponse(HttpContext _context)
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
        GetBreakTypeResponse _result = ApiHelper.deserialize(_responseBody,
                GetBreakTypeResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Updates an existing `BreakType`.
     * @param    id    Required parameter: UUID for the `BreakType` being updated.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateBreakTypeResponse response from the API call
     */
    public UpdateBreakTypeResponse updateBreakType(
            final String id,
            final UpdateBreakTypeRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateBreakTypeRequest(id, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateBreakTypeResponse(_context);
    }

    /**
     * Updates an existing `BreakType`.
     * @param    id    Required parameter: UUID for the `BreakType` being updated.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateBreakTypeResponse response from the API call 
     */
    public CompletableFuture<UpdateBreakTypeResponse> updateBreakTypeAsync(
            final String id,
            final UpdateBreakTypeRequest body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateBreakTypeRequest(id, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateBreakTypeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateBreakType
     */
    private HttpRequest _buildUpdateBreakTypeRequest(
            final String id,
            final UpdateBreakTypeRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/break-types/{id}");

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
     * Processes the response for updateBreakType
     * @return An object of type UpdateBreakTypeResponse
     */
    private UpdateBreakTypeResponse _handleUpdateBreakTypeResponse(HttpContext _context)
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
        UpdateBreakTypeResponse _result = ApiHelper.deserialize(_responseBody,
                UpdateBreakTypeResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a paginated list of `EmployeeWage` instances for a business.
     * @param    employeeId    Optional parameter: Filter wages returned to only those that are associated with the specified employee.
     * @param    limit    Optional parameter: Maximum number of Employee Wages to return per page. Can range between 1 and 200. The default is the maximum at 200.
     * @param    cursor    Optional parameter: Pointer to the next page of Employee Wage results to fetch.
     * @return    Returns the ListEmployeeWagesResponse response from the API call
     */
    public ListEmployeeWagesResponse listEmployeeWages(
            final String employeeId,
            final Integer limit,
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListEmployeeWagesRequest(employeeId, limit, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListEmployeeWagesResponse(_context);
    }

    /**
     * Returns a paginated list of `EmployeeWage` instances for a business.
     * @param    employeeId    Optional parameter: Filter wages returned to only those that are associated with the specified employee.
     * @param    limit    Optional parameter: Maximum number of Employee Wages to return per page. Can range between 1 and 200. The default is the maximum at 200.
     * @param    cursor    Optional parameter: Pointer to the next page of Employee Wage results to fetch.
     * @return    Returns the ListEmployeeWagesResponse response from the API call 
     */
    public CompletableFuture<ListEmployeeWagesResponse> listEmployeeWagesAsync(
            final String employeeId,
            final Integer limit,
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildListEmployeeWagesRequest(employeeId, limit, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListEmployeeWagesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listEmployeeWages
     */
    private HttpRequest _buildListEmployeeWagesRequest(
            final String employeeId,
            final Integer limit,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/employee-wages");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("employee_id", employeeId);
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
     * Processes the response for listEmployeeWages
     * @return An object of type ListEmployeeWagesResponse
     */
    private ListEmployeeWagesResponse _handleListEmployeeWagesResponse(HttpContext _context)
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
        ListEmployeeWagesResponse _result = ApiHelper.deserialize(_responseBody,
                ListEmployeeWagesResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a single `EmployeeWage` specified by id.
     * @param    id    Required parameter: UUID for the `EmployeeWage` being retrieved.
     * @return    Returns the GetEmployeeWageResponse response from the API call
     */
    public GetEmployeeWageResponse getEmployeeWage(
            final String id
    ) throws ApiException, IOException {
        HttpRequest _request = _buildGetEmployeeWageRequest(id);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetEmployeeWageResponse(_context);
    }

    /**
     * Returns a single `EmployeeWage` specified by id.
     * @param    id    Required parameter: UUID for the `EmployeeWage` being retrieved.
     * @return    Returns the GetEmployeeWageResponse response from the API call 
     */
    public CompletableFuture<GetEmployeeWageResponse> getEmployeeWageAsync(
            final String id
    ) {
        return makeHttpCallAsync(() -> _buildGetEmployeeWageRequest(id),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleGetEmployeeWageResponse(_context));
    }

    /**
     * Builds the HttpRequest object for getEmployeeWage
     */
    private HttpRequest _buildGetEmployeeWageRequest(
            final String id
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/employee-wages/{id}");

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
     * Processes the response for getEmployeeWage
     * @return An object of type GetEmployeeWageResponse
     */
    private GetEmployeeWageResponse _handleGetEmployeeWageResponse(HttpContext _context)
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
        GetEmployeeWageResponse _result = ApiHelper.deserialize(_responseBody,
                GetEmployeeWageResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Creates a new `Shift`. 
     * A `Shift` represents a complete work day for a single employee. 
     * You must provide the following values in your request to this
     * endpoint:
     * - `location_id`
     * - `employee_id`
     * - `start_at`
     * An attempt to create a new `Shift` can result in a `BAD_REQUEST` error when:
     * - The `status` of the new `Shift` is `OPEN` and the employee has another 
     * shift with an `OPEN` status. 
     * - The `start_at` date is in the future
     * - the `start_at` or `end_at` overlaps another shift for the same employee
     * - If `Break`s are set in the request, a break `start_at`
     * must not be before the `Shift.start_at`. A break `end_at` must not be after
     * the `Shift.end_at`
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateShiftResponse response from the API call
     */
    public CreateShiftResponse createShift(
            final CreateShiftRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateShiftRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateShiftResponse(_context);
    }

    /**
     * Creates a new `Shift`. 
     * A `Shift` represents a complete work day for a single employee. 
     * You must provide the following values in your request to this
     * endpoint:
     * - `location_id`
     * - `employee_id`
     * - `start_at`
     * An attempt to create a new `Shift` can result in a `BAD_REQUEST` error when:
     * - The `status` of the new `Shift` is `OPEN` and the employee has another 
     * shift with an `OPEN` status. 
     * - The `start_at` date is in the future
     * - the `start_at` or `end_at` overlaps another shift for the same employee
     * - If `Break`s are set in the request, a break `start_at`
     * must not be before the `Shift.start_at`. A break `end_at` must not be after
     * the `Shift.end_at`
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateShiftResponse response from the API call 
     */
    public CompletableFuture<CreateShiftResponse> createShiftAsync(
            final CreateShiftRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreateShiftRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateShiftResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createShift
     */
    private HttpRequest _buildCreateShiftRequest(
            final CreateShiftRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/shifts");
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
     * Processes the response for createShift
     * @return An object of type CreateShiftResponse
     */
    private CreateShiftResponse _handleCreateShiftResponse(HttpContext _context)
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
        CreateShiftResponse _result = ApiHelper.deserialize(_responseBody,
                CreateShiftResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a paginated list of `Shift` records for a business. 
     * The list to be returned can be filtered by:
     * - Location IDs **and**
     * - employee IDs **and**
     * - shift status (`OPEN`, `CLOSED`) **and**
     * - shift start **and**
     * - shift end **and**
     * - work day details
     * The list can be sorted by:
     * - `start_at`
     * - `end_at`
     * - `created_at`
     * - `updated_at`
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchShiftsResponse response from the API call
     */
    public SearchShiftsResponse searchShifts(
            final SearchShiftsRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildSearchShiftsRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleSearchShiftsResponse(_context);
    }

    /**
     * Returns a paginated list of `Shift` records for a business. 
     * The list to be returned can be filtered by:
     * - Location IDs **and**
     * - employee IDs **and**
     * - shift status (`OPEN`, `CLOSED`) **and**
     * - shift start **and**
     * - shift end **and**
     * - work day details
     * The list can be sorted by:
     * - `start_at`
     * - `end_at`
     * - `created_at`
     * - `updated_at`
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchShiftsResponse response from the API call 
     */
    public CompletableFuture<SearchShiftsResponse> searchShiftsAsync(
            final SearchShiftsRequest body
    ) {
        return makeHttpCallAsync(() -> _buildSearchShiftsRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleSearchShiftsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for searchShifts
     */
    private HttpRequest _buildSearchShiftsRequest(
            final SearchShiftsRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/shifts/search");
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
     * Processes the response for searchShifts
     * @return An object of type SearchShiftsResponse
     */
    private SearchShiftsResponse _handleSearchShiftsResponse(HttpContext _context)
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
        SearchShiftsResponse _result = ApiHelper.deserialize(_responseBody,
                SearchShiftsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes a `Shift`.
     * @param    id    Required parameter: UUID for the `Shift` being deleted.
     * @return    Returns the DeleteShiftResponse response from the API call
     */
    public DeleteShiftResponse deleteShift(
            final String id
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteShiftRequest(id);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteShiftResponse(_context);
    }

    /**
     * Deletes a `Shift`.
     * @param    id    Required parameter: UUID for the `Shift` being deleted.
     * @return    Returns the DeleteShiftResponse response from the API call 
     */
    public CompletableFuture<DeleteShiftResponse> deleteShiftAsync(
            final String id
    ) {
        return makeHttpCallAsync(() -> _buildDeleteShiftRequest(id),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteShiftResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteShift
     */
    private HttpRequest _buildDeleteShiftRequest(
            final String id
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/shifts/{id}");

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
        HttpRequest _request = getClientInstance().delete(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for deleteShift
     * @return An object of type DeleteShiftResponse
     */
    private DeleteShiftResponse _handleDeleteShiftResponse(HttpContext _context)
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
        DeleteShiftResponse _result = ApiHelper.deserialize(_responseBody,
                DeleteShiftResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a single `Shift` specified by id.
     * @param    id    Required parameter: UUID for the `Shift` being retrieved.
     * @return    Returns the GetShiftResponse response from the API call
     */
    public GetShiftResponse getShift(
            final String id
    ) throws ApiException, IOException {
        HttpRequest _request = _buildGetShiftRequest(id);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetShiftResponse(_context);
    }

    /**
     * Returns a single `Shift` specified by id.
     * @param    id    Required parameter: UUID for the `Shift` being retrieved.
     * @return    Returns the GetShiftResponse response from the API call 
     */
    public CompletableFuture<GetShiftResponse> getShiftAsync(
            final String id
    ) {
        return makeHttpCallAsync(() -> _buildGetShiftRequest(id),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleGetShiftResponse(_context));
    }

    /**
     * Builds the HttpRequest object for getShift
     */
    private HttpRequest _buildGetShiftRequest(
            final String id
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/shifts/{id}");

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
     * Processes the response for getShift
     * @return An object of type GetShiftResponse
     */
    private GetShiftResponse _handleGetShiftResponse(HttpContext _context)
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
        GetShiftResponse _result = ApiHelper.deserialize(_responseBody,
                GetShiftResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Updates an existing `Shift`. 
     * When adding a `Break` to a `Shift`, any earlier `Breaks` in the `Shift` have 
     * the `end_at` property set to a valid RFC-3339 datetime string. 
     * When closing a `Shift`, all `Break` instances in the shift must be complete with `end_at`
     * set on each `Break`.
     * @param    id    Required parameter: ID of the object being updated.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateShiftResponse response from the API call
     */
    public UpdateShiftResponse updateShift(
            final String id,
            final UpdateShiftRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateShiftRequest(id, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateShiftResponse(_context);
    }

    /**
     * Updates an existing `Shift`. 
     * When adding a `Break` to a `Shift`, any earlier `Breaks` in the `Shift` have 
     * the `end_at` property set to a valid RFC-3339 datetime string. 
     * When closing a `Shift`, all `Break` instances in the shift must be complete with `end_at`
     * set on each `Break`.
     * @param    id    Required parameter: ID of the object being updated.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateShiftResponse response from the API call 
     */
    public CompletableFuture<UpdateShiftResponse> updateShiftAsync(
            final String id,
            final UpdateShiftRequest body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateShiftRequest(id, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateShiftResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateShift
     */
    private HttpRequest _buildUpdateShiftRequest(
            final String id,
            final UpdateShiftRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/shifts/{id}");

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
     * Processes the response for updateShift
     * @return An object of type UpdateShiftResponse
     */
    private UpdateShiftResponse _handleUpdateShiftResponse(HttpContext _context)
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
        UpdateShiftResponse _result = ApiHelper.deserialize(_responseBody,
                UpdateShiftResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a list of `WorkweekConfig` instances for a business.
     * @param    limit    Optional parameter: Maximum number of Workweek Configs to return per page.
     * @param    cursor    Optional parameter: Pointer to the next page of Workweek Config results to fetch.
     * @return    Returns the ListWorkweekConfigsResponse response from the API call
     */
    public ListWorkweekConfigsResponse listWorkweekConfigs(
            final Integer limit,
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListWorkweekConfigsRequest(limit, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListWorkweekConfigsResponse(_context);
    }

    /**
     * Returns a list of `WorkweekConfig` instances for a business.
     * @param    limit    Optional parameter: Maximum number of Workweek Configs to return per page.
     * @param    cursor    Optional parameter: Pointer to the next page of Workweek Config results to fetch.
     * @return    Returns the ListWorkweekConfigsResponse response from the API call 
     */
    public CompletableFuture<ListWorkweekConfigsResponse> listWorkweekConfigsAsync(
            final Integer limit,
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildListWorkweekConfigsRequest(limit, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListWorkweekConfigsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listWorkweekConfigs
     */
    private HttpRequest _buildListWorkweekConfigsRequest(
            final Integer limit,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/workweek-configs");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
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
     * Processes the response for listWorkweekConfigs
     * @return An object of type ListWorkweekConfigsResponse
     */
    private ListWorkweekConfigsResponse _handleListWorkweekConfigsResponse(HttpContext _context)
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
        ListWorkweekConfigsResponse _result = ApiHelper.deserialize(_responseBody,
                ListWorkweekConfigsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Updates a `WorkweekConfig`.
     * @param    id    Required parameter: UUID for the `WorkweekConfig` object being updated.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateWorkweekConfigResponse response from the API call
     */
    public UpdateWorkweekConfigResponse updateWorkweekConfig(
            final String id,
            final UpdateWorkweekConfigRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateWorkweekConfigRequest(id, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateWorkweekConfigResponse(_context);
    }

    /**
     * Updates a `WorkweekConfig`.
     * @param    id    Required parameter: UUID for the `WorkweekConfig` object being updated.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateWorkweekConfigResponse response from the API call 
     */
    public CompletableFuture<UpdateWorkweekConfigResponse> updateWorkweekConfigAsync(
            final String id,
            final UpdateWorkweekConfigRequest body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateWorkweekConfigRequest(id, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateWorkweekConfigResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateWorkweekConfig
     */
    private HttpRequest _buildUpdateWorkweekConfigRequest(
            final String id,
            final UpdateWorkweekConfigRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/labor/workweek-configs/{id}");

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
     * Processes the response for updateWorkweekConfig
     * @return An object of type UpdateWorkweekConfigResponse
     */
    private UpdateWorkweekConfigResponse _handleUpdateWorkweekConfigResponse(HttpContext _context)
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
        UpdateWorkweekConfigResponse _result = ApiHelper.deserialize(_responseBody,
                UpdateWorkweekConfigResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
