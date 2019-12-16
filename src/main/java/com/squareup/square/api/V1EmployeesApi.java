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

public final class V1EmployeesApi extends BaseApi {
    public V1EmployeesApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public V1EmployeesApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Provides summary information for all of a business's employees.
     * @param    order    Optional parameter: The order in which employees are listed in the response, based on their created_at field.      Default value: ASC
     * @param    beginUpdatedAt    Optional parameter: If filtering results by their updated_at field, the beginning of the requested reporting period, in ISO 8601 format
     * @param    endUpdatedAt    Optional parameter: If filtering results by there updated_at field, the end of the requested reporting period, in ISO 8601 format.
     * @param    beginCreatedAt    Optional parameter: If filtering results by their created_at field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param    endCreatedAt    Optional parameter: If filtering results by their created_at field, the end of the requested reporting period, in ISO 8601 format.
     * @param    status    Optional parameter: If provided, the endpoint returns only employee entities with the specified status (ACTIVE or INACTIVE).
     * @param    externalId    Optional parameter: If provided, the endpoint returns only employee entities with the specified external_id.
     * @param    limit    Optional parameter: The maximum integer number of employee entities to return in a single response. Default 100, maximum 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Employee> response from the API call
     */
    public List<V1Employee> listEmployees(
            final String order,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final String beginCreatedAt,
            final String endCreatedAt,
            final String status,
            final String externalId,
            final Integer limit,
            final String batchToken
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListEmployeesRequest(order, beginUpdatedAt, endUpdatedAt, beginCreatedAt, endCreatedAt, status, externalId, limit, batchToken);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListEmployeesResponse(_context);
    }

    /**
     * Provides summary information for all of a business's employees.
     * @param    order    Optional parameter: The order in which employees are listed in the response, based on their created_at field.      Default value: ASC
     * @param    beginUpdatedAt    Optional parameter: If filtering results by their updated_at field, the beginning of the requested reporting period, in ISO 8601 format
     * @param    endUpdatedAt    Optional parameter: If filtering results by there updated_at field, the end of the requested reporting period, in ISO 8601 format.
     * @param    beginCreatedAt    Optional parameter: If filtering results by their created_at field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param    endCreatedAt    Optional parameter: If filtering results by their created_at field, the end of the requested reporting period, in ISO 8601 format.
     * @param    status    Optional parameter: If provided, the endpoint returns only employee entities with the specified status (ACTIVE or INACTIVE).
     * @param    externalId    Optional parameter: If provided, the endpoint returns only employee entities with the specified external_id.
     * @param    limit    Optional parameter: The maximum integer number of employee entities to return in a single response. Default 100, maximum 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Employee> response from the API call 
     */
    public CompletableFuture<List<V1Employee>> listEmployeesAsync(
            final String order,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final String beginCreatedAt,
            final String endCreatedAt,
            final String status,
            final String externalId,
            final Integer limit,
            final String batchToken
    ) {
        return makeHttpCallAsync(() -> _buildListEmployeesRequest(order, beginUpdatedAt, endUpdatedAt, beginCreatedAt, endCreatedAt, status, externalId, limit, batchToken),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListEmployeesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listEmployees
     */
    private HttpRequest _buildListEmployeesRequest(
            final String order,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final String beginCreatedAt,
            final String endCreatedAt,
            final String status,
            final String externalId,
            final Integer limit,
            final String batchToken
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/employees");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("order", order);
        _queryParameters.put("begin_updated_at", beginUpdatedAt);
        _queryParameters.put("end_updated_at", endUpdatedAt);
        _queryParameters.put("begin_created_at", beginCreatedAt);
        _queryParameters.put("end_created_at", endCreatedAt);
        _queryParameters.put("status", status);
        _queryParameters.put("external_id", externalId);
        _queryParameters.put("limit", limit);
        _queryParameters.put("batch_token", batchToken);
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
     * @return An object of type List<V1Employee>
     */
    private List<V1Employee> _handleListEmployeesResponse(HttpContext _context)
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
        List<V1Employee> _result = ApiHelper.deserializeArray(_responseBody,
                V1Employee[].class);
        return _result;
    }

    /**
     *  Use the CreateEmployee endpoint to add an employee to a Square
     * account. Employees created with the Connect API have an initial status
     * of `INACTIVE`. Inactive employees cannot sign in to Square Point of Sale
     * until they are activated from the Square Dashboard. Employee status
     * cannot be changed with the Connect API.
     * <aside class="important">
     * Employee entities cannot be deleted. To disable employee profiles,
     * set the employee's status to <code>INACTIVE</code>
     * </aside>
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     */
    public V1Employee createEmployee(
            final V1Employee body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateEmployeeRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateEmployeeResponse(_context);
    }

    /**
     *  Use the CreateEmployee endpoint to add an employee to a Square
     * account. Employees created with the Connect API have an initial status
     * of `INACTIVE`. Inactive employees cannot sign in to Square Point of Sale
     * until they are activated from the Square Dashboard. Employee status
     * cannot be changed with the Connect API.
     * <aside class="important">
     * Employee entities cannot be deleted. To disable employee profiles,
     * set the employee's status to <code>INACTIVE</code>
     * </aside>
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call 
     */
    public CompletableFuture<V1Employee> createEmployeeAsync(
            final V1Employee body
    ) {
        return makeHttpCallAsync(() -> _buildCreateEmployeeRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateEmployeeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createEmployee
     */
    private HttpRequest _buildCreateEmployeeRequest(
            final V1Employee body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/employees");
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
     * Processes the response for createEmployee
     * @return An object of type V1Employee
     */
    private V1Employee _handleCreateEmployeeResponse(HttpContext _context)
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
        V1Employee _result = ApiHelper.deserialize(_responseBody,
                V1Employee.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides the details for a single employee.
     * @param    employeeId    Required parameter: The employee's ID.
     * @return    Returns the V1Employee response from the API call
     */
    public V1Employee retrieveEmployee(
            final String employeeId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveEmployeeRequest(employeeId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveEmployeeResponse(_context);
    }

    /**
     * Provides the details for a single employee.
     * @param    employeeId    Required parameter: The employee's ID.
     * @return    Returns the V1Employee response from the API call 
     */
    public CompletableFuture<V1Employee> retrieveEmployeeAsync(
            final String employeeId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveEmployeeRequest(employeeId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveEmployeeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveEmployee
     */
    private HttpRequest _buildRetrieveEmployeeRequest(
            final String employeeId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/employees/{employee_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("employee_id", employeeId);
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
     * @return An object of type V1Employee
     */
    private V1Employee _handleRetrieveEmployeeResponse(HttpContext _context)
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
        V1Employee _result = ApiHelper.deserialize(_responseBody,
                V1Employee.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * UpdateEmployee
     * @param    employeeId    Required parameter: The ID of the role to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     */
    public V1Employee updateEmployee(
            final String employeeId,
            final V1Employee body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateEmployeeRequest(employeeId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateEmployeeResponse(_context);
    }

    /**
     * UpdateEmployee
     * @param    employeeId    Required parameter: The ID of the role to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call 
     */
    public CompletableFuture<V1Employee> updateEmployeeAsync(
            final String employeeId,
            final V1Employee body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateEmployeeRequest(employeeId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateEmployeeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateEmployee
     */
    private HttpRequest _buildUpdateEmployeeRequest(
            final String employeeId,
            final V1Employee body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/employees/{employee_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("employee_id", employeeId);
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
     * Processes the response for updateEmployee
     * @return An object of type V1Employee
     */
    private V1Employee _handleUpdateEmployeeResponse(HttpContext _context)
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
        V1Employee _result = ApiHelper.deserialize(_responseBody,
                V1Employee.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides summary information for all of a business's employee roles.
     * @param    order    Optional parameter: The order in which employees are listed in the response, based on their created_at field.Default value: ASC
     * @param    limit    Optional parameter: The maximum integer number of employee entities to return in a single response. Default 100, maximum 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1EmployeeRole> response from the API call
     */
    public List<V1EmployeeRole> listEmployeeRoles(
            final String order,
            final Integer limit,
            final String batchToken
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListEmployeeRolesRequest(order, limit, batchToken);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListEmployeeRolesResponse(_context);
    }

    /**
     * Provides summary information for all of a business's employee roles.
     * @param    order    Optional parameter: The order in which employees are listed in the response, based on their created_at field.Default value: ASC
     * @param    limit    Optional parameter: The maximum integer number of employee entities to return in a single response. Default 100, maximum 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1EmployeeRole> response from the API call 
     */
    public CompletableFuture<List<V1EmployeeRole>> listEmployeeRolesAsync(
            final String order,
            final Integer limit,
            final String batchToken
    ) {
        return makeHttpCallAsync(() -> _buildListEmployeeRolesRequest(order, limit, batchToken),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListEmployeeRolesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listEmployeeRoles
     */
    private HttpRequest _buildListEmployeeRolesRequest(
            final String order,
            final Integer limit,
            final String batchToken
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/roles");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("order", order);
        _queryParameters.put("limit", limit);
        _queryParameters.put("batch_token", batchToken);
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
     * Processes the response for listEmployeeRoles
     * @return An object of type List<V1EmployeeRole>
     */
    private List<V1EmployeeRole> _handleListEmployeeRolesResponse(HttpContext _context)
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
        List<V1EmployeeRole> _result = ApiHelper.deserializeArray(_responseBody,
                V1EmployeeRole[].class);
        return _result;
    }

    /**
     * Creates an employee role you can then assign to employees.
     * Square accounts can include any number of roles that can be assigned to
     * employees. These roles define the actions and permissions granted to an
     * employee with that role. For example, an employee with a "Shift Manager"
     * role might be able to issue refunds in Square Point of Sale, whereas an
     * employee with a "Clerk" role might not.
     * Roles are assigned with the [V1UpdateEmployee](#endpoint-v1updateemployee)
     * endpoint. An employee can have only one role at a time.
     * If an employee has no role, they have none of the permissions associated
     * with roles. All employees can accept payments with Square Point of Sale.
     * @param    body    Required parameter: An EmployeeRole object with a name and permissions, and an optional owner flag.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    public V1EmployeeRole createEmployeeRole(
            final V1EmployeeRole body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateEmployeeRoleRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateEmployeeRoleResponse(_context);
    }

    /**
     * Creates an employee role you can then assign to employees.
     * Square accounts can include any number of roles that can be assigned to
     * employees. These roles define the actions and permissions granted to an
     * employee with that role. For example, an employee with a "Shift Manager"
     * role might be able to issue refunds in Square Point of Sale, whereas an
     * employee with a "Clerk" role might not.
     * Roles are assigned with the [V1UpdateEmployee](#endpoint-v1updateemployee)
     * endpoint. An employee can have only one role at a time.
     * If an employee has no role, they have none of the permissions associated
     * with roles. All employees can accept payments with Square Point of Sale.
     * @param    body    Required parameter: An EmployeeRole object with a name and permissions, and an optional owner flag.
     * @return    Returns the V1EmployeeRole response from the API call 
     */
    public CompletableFuture<V1EmployeeRole> createEmployeeRoleAsync(
            final V1EmployeeRole body
    ) {
        return makeHttpCallAsync(() -> _buildCreateEmployeeRoleRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateEmployeeRoleResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createEmployeeRole
     */
    private HttpRequest _buildCreateEmployeeRoleRequest(
            final V1EmployeeRole body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/roles");
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
     * Processes the response for createEmployeeRole
     * @return An object of type V1EmployeeRole
     */
    private V1EmployeeRole _handleCreateEmployeeRoleResponse(HttpContext _context)
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
        V1EmployeeRole _result = ApiHelper.deserialize(_responseBody,
                V1EmployeeRole.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides the details for a single employee role.
     * @param    roleId    Required parameter: The role's ID.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    public V1EmployeeRole retrieveEmployeeRole(
            final String roleId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveEmployeeRoleRequest(roleId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveEmployeeRoleResponse(_context);
    }

    /**
     * Provides the details for a single employee role.
     * @param    roleId    Required parameter: The role's ID.
     * @return    Returns the V1EmployeeRole response from the API call 
     */
    public CompletableFuture<V1EmployeeRole> retrieveEmployeeRoleAsync(
            final String roleId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveEmployeeRoleRequest(roleId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveEmployeeRoleResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveEmployeeRole
     */
    private HttpRequest _buildRetrieveEmployeeRoleRequest(
            final String roleId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/roles/{role_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("role_id", roleId);
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
     * Processes the response for retrieveEmployeeRole
     * @return An object of type V1EmployeeRole
     */
    private V1EmployeeRole _handleRetrieveEmployeeRoleResponse(HttpContext _context)
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
        V1EmployeeRole _result = ApiHelper.deserialize(_responseBody,
                V1EmployeeRole.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies the details of an employee role.
     * @param    roleId    Required parameter: The ID of the role to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    public V1EmployeeRole updateEmployeeRole(
            final String roleId,
            final V1EmployeeRole body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateEmployeeRoleRequest(roleId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateEmployeeRoleResponse(_context);
    }

    /**
     * Modifies the details of an employee role.
     * @param    roleId    Required parameter: The ID of the role to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1EmployeeRole response from the API call 
     */
    public CompletableFuture<V1EmployeeRole> updateEmployeeRoleAsync(
            final String roleId,
            final V1EmployeeRole body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateEmployeeRoleRequest(roleId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateEmployeeRoleResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateEmployeeRole
     */
    private HttpRequest _buildUpdateEmployeeRoleRequest(
            final String roleId,
            final V1EmployeeRole body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/roles/{role_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("role_id", roleId);
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
     * Processes the response for updateEmployeeRole
     * @return An object of type V1EmployeeRole
     */
    private V1EmployeeRole _handleUpdateEmployeeRoleResponse(HttpContext _context)
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
        V1EmployeeRole _result = ApiHelper.deserialize(_responseBody,
                V1EmployeeRole.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides summary information for all of a business's employee timecards.
     * @param    order    Optional parameter: The order in which timecards are listed in the response, based on their created_at field.
     * @param    employeeId    Optional parameter: If provided, the endpoint returns only timecards for the employee with the specified ID.
     * @param    beginClockinTime    Optional parameter: If filtering results by their clockin_time field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param    endClockinTime    Optional parameter: If filtering results by their clockin_time field, the end of the requested reporting period, in ISO 8601 format.
     * @param    beginClockoutTime    Optional parameter: If filtering results by their clockout_time field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param    endClockoutTime    Optional parameter: If filtering results by their clockout_time field, the end of the requested reporting period, in ISO 8601 format.
     * @param    beginUpdatedAt    Optional parameter: If filtering results by their updated_at field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param    endUpdatedAt    Optional parameter: If filtering results by their updated_at field, the end of the requested reporting period, in ISO 8601 format.
     * @param    deleted    Optional parameter: If true, only deleted timecards are returned. If false, only valid timecards are returned.If you don't provide this parameter, both valid and deleted timecards are returned.
     * @param    limit    Optional parameter: The maximum integer number of employee entities to return in a single response. Default 100, maximum 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Timecard> response from the API call
     */
    public List<V1Timecard> listTimecards(
            final String order,
            final String employeeId,
            final String beginClockinTime,
            final String endClockinTime,
            final String beginClockoutTime,
            final String endClockoutTime,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final Boolean deleted,
            final Integer limit,
            final String batchToken
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListTimecardsRequest(order, employeeId, beginClockinTime, endClockinTime, beginClockoutTime, endClockoutTime, beginUpdatedAt, endUpdatedAt, deleted, limit, batchToken);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListTimecardsResponse(_context);
    }

    /**
     * Provides summary information for all of a business's employee timecards.
     * @param    order    Optional parameter: The order in which timecards are listed in the response, based on their created_at field.
     * @param    employeeId    Optional parameter: If provided, the endpoint returns only timecards for the employee with the specified ID.
     * @param    beginClockinTime    Optional parameter: If filtering results by their clockin_time field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param    endClockinTime    Optional parameter: If filtering results by their clockin_time field, the end of the requested reporting period, in ISO 8601 format.
     * @param    beginClockoutTime    Optional parameter: If filtering results by their clockout_time field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param    endClockoutTime    Optional parameter: If filtering results by their clockout_time field, the end of the requested reporting period, in ISO 8601 format.
     * @param    beginUpdatedAt    Optional parameter: If filtering results by their updated_at field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param    endUpdatedAt    Optional parameter: If filtering results by their updated_at field, the end of the requested reporting period, in ISO 8601 format.
     * @param    deleted    Optional parameter: If true, only deleted timecards are returned. If false, only valid timecards are returned.If you don't provide this parameter, both valid and deleted timecards are returned.
     * @param    limit    Optional parameter: The maximum integer number of employee entities to return in a single response. Default 100, maximum 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Timecard> response from the API call 
     */
    public CompletableFuture<List<V1Timecard>> listTimecardsAsync(
            final String order,
            final String employeeId,
            final String beginClockinTime,
            final String endClockinTime,
            final String beginClockoutTime,
            final String endClockoutTime,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final Boolean deleted,
            final Integer limit,
            final String batchToken
    ) {
        return makeHttpCallAsync(() -> _buildListTimecardsRequest(order, employeeId, beginClockinTime, endClockinTime, beginClockoutTime, endClockoutTime, beginUpdatedAt, endUpdatedAt, deleted, limit, batchToken),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListTimecardsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listTimecards
     */
    private HttpRequest _buildListTimecardsRequest(
            final String order,
            final String employeeId,
            final String beginClockinTime,
            final String endClockinTime,
            final String beginClockoutTime,
            final String endClockoutTime,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final Boolean deleted,
            final Integer limit,
            final String batchToken
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/timecards");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("order", order);
        _queryParameters.put("employee_id", employeeId);
        _queryParameters.put("begin_clockin_time", beginClockinTime);
        _queryParameters.put("end_clockin_time", endClockinTime);
        _queryParameters.put("begin_clockout_time", beginClockoutTime);
        _queryParameters.put("end_clockout_time", endClockoutTime);
        _queryParameters.put("begin_updated_at", beginUpdatedAt);
        _queryParameters.put("end_updated_at", endUpdatedAt);
        _queryParameters.put("deleted", deleted);
        _queryParameters.put("limit", limit);
        _queryParameters.put("batch_token", batchToken);
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
     * Processes the response for listTimecards
     * @return An object of type List<V1Timecard>
     */
    private List<V1Timecard> _handleListTimecardsResponse(HttpContext _context)
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
        List<V1Timecard> _result = ApiHelper.deserializeArray(_responseBody,
                V1Timecard[].class);
        return _result;
    }

    /**
     * Creates a timecard for an employee and clocks them in with an
     * `API_CREATE` event and a `clockin_time` set to the current time unless
     * the request provides a different value. To import timecards from another
     * system (rather than clocking someone in). Specify the `clockin_time`
     * and* `clockout_time` in the request.
     * Timecards correspond to exactly one shift for a given employee, bounded
     * by the `clockin_time` and `clockout_time` fields. An employee is
     * considered clocked in if they have a timecard that doesn't have a
     * `clockout_time` set. An employee that is currently clocked in cannot
     * be clocked in a second time.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call
     */
    public V1Timecard createTimecard(
            final V1Timecard body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateTimecardRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateTimecardResponse(_context);
    }

    /**
     * Creates a timecard for an employee and clocks them in with an
     * `API_CREATE` event and a `clockin_time` set to the current time unless
     * the request provides a different value. To import timecards from another
     * system (rather than clocking someone in). Specify the `clockin_time`
     * and* `clockout_time` in the request.
     * Timecards correspond to exactly one shift for a given employee, bounded
     * by the `clockin_time` and `clockout_time` fields. An employee is
     * considered clocked in if they have a timecard that doesn't have a
     * `clockout_time` set. An employee that is currently clocked in cannot
     * be clocked in a second time.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call 
     */
    public CompletableFuture<V1Timecard> createTimecardAsync(
            final V1Timecard body
    ) {
        return makeHttpCallAsync(() -> _buildCreateTimecardRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateTimecardResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createTimecard
     */
    private HttpRequest _buildCreateTimecardRequest(
            final V1Timecard body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/timecards");
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
     * Processes the response for createTimecard
     * @return An object of type V1Timecard
     */
    private V1Timecard _handleCreateTimecardResponse(HttpContext _context)
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
        V1Timecard _result = ApiHelper.deserialize(_responseBody,
                V1Timecard.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes a timecard. Timecards can also be deleted through the
     * Square Dashboard. Deleted timecards are still accessible through
     * Connect API endpoints, but cannot be modified. The `deleted` field of
     * the `Timecard` object indicates whether the timecard has been deleted.
     * *Note**: By default, deleted timecards appear alongside valid timecards in
     * results returned by the [ListTimecards](#endpoint-v1employees-listtimecards)
     * endpoint. To filter deleted timecards, include the `deleted` query
     * parameter in the list request.
     * <aside>
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * </aside>
     * @param    timecardId    Required parameter: The ID of the timecard to delete.
     * @return    Returns the Object response from the API call
     */
    public Object deleteTimecard(
            final String timecardId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteTimecardRequest(timecardId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteTimecardResponse(_context);
    }

    /**
     * Deletes a timecard. Timecards can also be deleted through the
     * Square Dashboard. Deleted timecards are still accessible through
     * Connect API endpoints, but cannot be modified. The `deleted` field of
     * the `Timecard` object indicates whether the timecard has been deleted.
     * *Note**: By default, deleted timecards appear alongside valid timecards in
     * results returned by the [ListTimecards](#endpoint-v1employees-listtimecards)
     * endpoint. To filter deleted timecards, include the `deleted` query
     * parameter in the list request.
     * <aside>
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * </aside>
     * @param    timecardId    Required parameter: The ID of the timecard to delete.
     * @return    Returns the Object response from the API call 
     */
    public CompletableFuture<Object> deleteTimecardAsync(
            final String timecardId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteTimecardRequest(timecardId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteTimecardResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteTimecard
     */
    private HttpRequest _buildDeleteTimecardRequest(
            final String timecardId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/timecards/{timecard_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("timecard_id", timecardId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for deleteTimecard
     * @return An object of type Object
     */
    private Object _handleDeleteTimecardResponse(HttpContext _context)
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
        Object _result = _responseBody;

        return _result;
    }

    /**
     * Provides the details for a single timecard.
     * <aside>
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * </aside>
     * @param    timecardId    Required parameter: The timecard's ID.
     * @return    Returns the V1Timecard response from the API call
     */
    public V1Timecard retrieveTimecard(
            final String timecardId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveTimecardRequest(timecardId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveTimecardResponse(_context);
    }

    /**
     * Provides the details for a single timecard.
     * <aside>
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * </aside>
     * @param    timecardId    Required parameter: The timecard's ID.
     * @return    Returns the V1Timecard response from the API call 
     */
    public CompletableFuture<V1Timecard> retrieveTimecardAsync(
            final String timecardId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveTimecardRequest(timecardId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveTimecardResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveTimecard
     */
    private HttpRequest _buildRetrieveTimecardRequest(
            final String timecardId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/timecards/{timecard_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("timecard_id", timecardId);
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
     * Processes the response for retrieveTimecard
     * @return An object of type V1Timecard
     */
    private V1Timecard _handleRetrieveTimecardResponse(HttpContext _context)
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
        V1Timecard _result = ApiHelper.deserialize(_responseBody,
                V1Timecard.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies the details of a timecard with an `API_EDIT` event for
     * the timecard. Updating an active timecard with a `clockout_time`
     * clocks the employee out.
     * @param    timecardId    Required parameter: TThe ID of the timecard to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request. See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call
     */
    public V1Timecard updateTimecard(
            final String timecardId,
            final V1Timecard body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateTimecardRequest(timecardId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateTimecardResponse(_context);
    }

    /**
     * Modifies the details of a timecard with an `API_EDIT` event for
     * the timecard. Updating an active timecard with a `clockout_time`
     * clocks the employee out.
     * @param    timecardId    Required parameter: TThe ID of the timecard to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request. See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call 
     */
    public CompletableFuture<V1Timecard> updateTimecardAsync(
            final String timecardId,
            final V1Timecard body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateTimecardRequest(timecardId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateTimecardResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateTimecard
     */
    private HttpRequest _buildUpdateTimecardRequest(
            final String timecardId,
            final V1Timecard body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/timecards/{timecard_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("timecard_id", timecardId);
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
     * Processes the response for updateTimecard
     * @return An object of type V1Timecard
     */
    private V1Timecard _handleUpdateTimecardResponse(HttpContext _context)
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
        V1Timecard _result = ApiHelper.deserialize(_responseBody,
                V1Timecard.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides summary information for all events associated with a
     * particular timecard.
     * <aside>
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * </aside>
     * @param    timecardId    Required parameter: The ID of the timecard to list events for.
     * @return    Returns the List<V1TimecardEvent> response from the API call
     */
    public List<V1TimecardEvent> listTimecardEvents(
            final String timecardId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListTimecardEventsRequest(timecardId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListTimecardEventsResponse(_context);
    }

    /**
     * Provides summary information for all events associated with a
     * particular timecard.
     * <aside>
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * </aside>
     * @param    timecardId    Required parameter: The ID of the timecard to list events for.
     * @return    Returns the List<V1TimecardEvent> response from the API call 
     */
    public CompletableFuture<List<V1TimecardEvent>> listTimecardEventsAsync(
            final String timecardId
    ) {
        return makeHttpCallAsync(() -> _buildListTimecardEventsRequest(timecardId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListTimecardEventsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listTimecardEvents
     */
    private HttpRequest _buildListTimecardEventsRequest(
            final String timecardId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/me/timecards/{timecard_id}/events");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("timecard_id", timecardId);
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
     * Processes the response for listTimecardEvents
     * @return An object of type List<V1TimecardEvent>
     */
    private List<V1TimecardEvent> _handleListTimecardEventsResponse(HttpContext _context)
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
        List<V1TimecardEvent> _result = ApiHelper.deserializeArray(_responseBody,
                V1TimecardEvent[].class);
        return _result;
    }

    /**
     * Provides the details for all of a location's cash drawer shifts during a date range. The date range you specify cannot exceed 90 days.
     * @param    locationId    Required parameter: The ID of the location to list cash drawer shifts for.
     * @param    order    Optional parameter: The order in which cash drawer shifts are listed in the response, based on their created_at field. Default value: ASC
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time minus 90 days.
     * @param    endTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time.
     * @return    Returns the List<V1CashDrawerShift> response from the API call
     */
    public List<V1CashDrawerShift> listCashDrawerShifts(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListCashDrawerShiftsRequest(locationId, order, beginTime, endTime);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListCashDrawerShiftsResponse(_context);
    }

    /**
     * Provides the details for all of a location's cash drawer shifts during a date range. The date range you specify cannot exceed 90 days.
     * @param    locationId    Required parameter: The ID of the location to list cash drawer shifts for.
     * @param    order    Optional parameter: The order in which cash drawer shifts are listed in the response, based on their created_at field. Default value: ASC
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time minus 90 days.
     * @param    endTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time.
     * @return    Returns the List<V1CashDrawerShift> response from the API call 
     */
    public CompletableFuture<List<V1CashDrawerShift>> listCashDrawerShiftsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime
    ) {
        return makeHttpCallAsync(() -> _buildListCashDrawerShiftsRequest(locationId, order, beginTime, endTime),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListCashDrawerShiftsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listCashDrawerShifts
     */
    private HttpRequest _buildListCashDrawerShiftsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/cash-drawer-shifts");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("order", order);
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
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
     * Processes the response for listCashDrawerShifts
     * @return An object of type List<V1CashDrawerShift>
     */
    private List<V1CashDrawerShift> _handleListCashDrawerShiftsResponse(HttpContext _context)
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
        List<V1CashDrawerShift> _result = ApiHelper.deserializeArray(_responseBody,
                V1CashDrawerShift[].class);
        return _result;
    }

    /**
     * Provides the details for a single cash drawer shift, including all events that occurred during the shift.
     * @param    locationId    Required parameter: The ID of the location to list cash drawer shifts for.
     * @param    shiftId    Required parameter: The shift's ID.
     * @return    Returns the V1CashDrawerShift response from the API call
     */
    public V1CashDrawerShift retrieveCashDrawerShift(
            final String locationId,
            final String shiftId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveCashDrawerShiftRequest(locationId, shiftId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveCashDrawerShiftResponse(_context);
    }

    /**
     * Provides the details for a single cash drawer shift, including all events that occurred during the shift.
     * @param    locationId    Required parameter: The ID of the location to list cash drawer shifts for.
     * @param    shiftId    Required parameter: The shift's ID.
     * @return    Returns the V1CashDrawerShift response from the API call 
     */
    public CompletableFuture<V1CashDrawerShift> retrieveCashDrawerShiftAsync(
            final String locationId,
            final String shiftId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveCashDrawerShiftRequest(locationId, shiftId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveCashDrawerShiftResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveCashDrawerShift
     */
    private HttpRequest _buildRetrieveCashDrawerShiftRequest(
            final String locationId,
            final String shiftId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/cash-drawer-shifts/{shift_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("shift_id", shiftId);
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
     * Processes the response for retrieveCashDrawerShift
     * @return An object of type V1CashDrawerShift
     */
    private V1CashDrawerShift _handleRetrieveCashDrawerShiftResponse(HttpContext _context)
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
        V1CashDrawerShift _result = ApiHelper.deserialize(_responseBody,
                V1CashDrawerShift.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
