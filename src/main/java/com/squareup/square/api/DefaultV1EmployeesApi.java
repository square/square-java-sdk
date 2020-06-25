package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.HashMap;
import java.util.List;
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
import com.squareup.square.models.V1CashDrawerShift;
import com.squareup.square.models.V1Employee;
import com.squareup.square.models.V1EmployeeRole;
import com.squareup.square.models.V1Timecard;
import com.squareup.square.models.V1TimecardEvent;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultV1EmployeesApi extends BaseApi implements V1EmployeesApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultV1EmployeesApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultV1EmployeesApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
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
            final String batchToken) throws ApiException, IOException {
        HttpRequest request = buildListEmployeesRequest(order, beginUpdatedAt, endUpdatedAt, beginCreatedAt, endCreatedAt, status, externalId, limit, batchToken);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListEmployeesResponse(context);
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
            final String batchToken) {
        return makeHttpCallAsync(() -> buildListEmployeesRequest(order, beginUpdatedAt, endUpdatedAt, beginCreatedAt, endCreatedAt, status, externalId, limit, batchToken),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListEmployeesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listEmployees
     */
    private HttpRequest buildListEmployeesRequest(
            final String order,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final String beginCreatedAt,
            final String endCreatedAt,
            final String status,
            final String externalId,
            final Integer limit,
            final String batchToken) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/employees");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("order", order);
        queryParameters.put("begin_updated_at", beginUpdatedAt);
        queryParameters.put("end_updated_at", endUpdatedAt);
        queryParameters.put("begin_created_at", beginCreatedAt);
        queryParameters.put("end_created_at", endCreatedAt);
        queryParameters.put("status", status);
        queryParameters.put("external_id", externalId);
        queryParameters.put("limit", limit);
        queryParameters.put("batch_token", batchToken);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listEmployees
     * @return An object of type List<V1Employee>
     */
    private List<V1Employee> handleListEmployeesResponse(HttpContext context)
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
        List<V1Employee> result = ApiHelper.deserializeArray(responseBody,
                V1Employee[].class);
        return result;
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
            final V1Employee body) throws ApiException, IOException {
        HttpRequest request = buildCreateEmployeeRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateEmployeeResponse(context);
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
            final V1Employee body) {
        return makeHttpCallAsync(() -> buildCreateEmployeeRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateEmployeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for createEmployee
     */
    private HttpRequest buildCreateEmployeeRequest(
            final V1Employee body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/employees");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for createEmployee
     * @return An object of type V1Employee
     */
    private V1Employee handleCreateEmployeeResponse(HttpContext context)
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
        V1Employee result = ApiHelper.deserialize(responseBody,
                V1Employee.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides the details for a single employee.
     * @param    employeeId    Required parameter: The employee's ID.
     * @return    Returns the V1Employee response from the API call
     */
    public V1Employee retrieveEmployee(
            final String employeeId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveEmployeeRequest(employeeId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveEmployeeResponse(context);
    }

    /**
     * Provides the details for a single employee.
     * @param    employeeId    Required parameter: The employee's ID.
     * @return    Returns the V1Employee response from the API call 
     */
    public CompletableFuture<V1Employee> retrieveEmployeeAsync(
            final String employeeId) {
        return makeHttpCallAsync(() -> buildRetrieveEmployeeRequest(employeeId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveEmployeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveEmployee
     */
    private HttpRequest buildRetrieveEmployeeRequest(
            final String employeeId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/employees/{employee_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("employee_id", employeeId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveEmployee
     * @return An object of type V1Employee
     */
    private V1Employee handleRetrieveEmployeeResponse(HttpContext context)
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
        V1Employee result = ApiHelper.deserialize(responseBody,
                V1Employee.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * UpdateEmployee
     * @param    employeeId    Required parameter: The ID of the role to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     */
    public V1Employee updateEmployee(
            final String employeeId,
            final V1Employee body) throws ApiException, IOException {
        HttpRequest request = buildUpdateEmployeeRequest(employeeId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateEmployeeResponse(context);
    }

    /**
     * UpdateEmployee
     * @param    employeeId    Required parameter: The ID of the role to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call 
     */
    public CompletableFuture<V1Employee> updateEmployeeAsync(
            final String employeeId,
            final V1Employee body) {
        return makeHttpCallAsync(() -> buildUpdateEmployeeRequest(employeeId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateEmployeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateEmployee
     */
    private HttpRequest buildUpdateEmployeeRequest(
            final String employeeId,
            final V1Employee body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/employees/{employee_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("employee_id", employeeId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateEmployee
     * @return An object of type V1Employee
     */
    private V1Employee handleUpdateEmployeeResponse(HttpContext context)
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
        V1Employee result = ApiHelper.deserialize(responseBody,
                V1Employee.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
            final String batchToken) throws ApiException, IOException {
        HttpRequest request = buildListEmployeeRolesRequest(order, limit, batchToken);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListEmployeeRolesResponse(context);
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
            final String batchToken) {
        return makeHttpCallAsync(() -> buildListEmployeeRolesRequest(order, limit, batchToken),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListEmployeeRolesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listEmployeeRoles
     */
    private HttpRequest buildListEmployeeRolesRequest(
            final String order,
            final Integer limit,
            final String batchToken) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/roles");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("order", order);
        queryParameters.put("limit", limit);
        queryParameters.put("batch_token", batchToken);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listEmployeeRoles
     * @return An object of type List<V1EmployeeRole>
     */
    private List<V1EmployeeRole> handleListEmployeeRolesResponse(HttpContext context)
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
        List<V1EmployeeRole> result = ApiHelper.deserializeArray(responseBody,
                V1EmployeeRole[].class);
        return result;
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
            final V1EmployeeRole body) throws ApiException, IOException {
        HttpRequest request = buildCreateEmployeeRoleRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateEmployeeRoleResponse(context);
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
            final V1EmployeeRole body) {
        return makeHttpCallAsync(() -> buildCreateEmployeeRoleRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateEmployeeRoleResponse(context));
    }

    /**
     * Builds the HttpRequest object for createEmployeeRole
     */
    private HttpRequest buildCreateEmployeeRoleRequest(
            final V1EmployeeRole body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/roles");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for createEmployeeRole
     * @return An object of type V1EmployeeRole
     */
    private V1EmployeeRole handleCreateEmployeeRoleResponse(HttpContext context)
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
        V1EmployeeRole result = ApiHelper.deserialize(responseBody,
                V1EmployeeRole.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides the details for a single employee role.
     * @param    roleId    Required parameter: The role's ID.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    public V1EmployeeRole retrieveEmployeeRole(
            final String roleId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveEmployeeRoleRequest(roleId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveEmployeeRoleResponse(context);
    }

    /**
     * Provides the details for a single employee role.
     * @param    roleId    Required parameter: The role's ID.
     * @return    Returns the V1EmployeeRole response from the API call 
     */
    public CompletableFuture<V1EmployeeRole> retrieveEmployeeRoleAsync(
            final String roleId) {
        return makeHttpCallAsync(() -> buildRetrieveEmployeeRoleRequest(roleId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveEmployeeRoleResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveEmployeeRole
     */
    private HttpRequest buildRetrieveEmployeeRoleRequest(
            final String roleId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/roles/{role_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("role_id", roleId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveEmployeeRole
     * @return An object of type V1EmployeeRole
     */
    private V1EmployeeRole handleRetrieveEmployeeRoleResponse(HttpContext context)
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
        V1EmployeeRole result = ApiHelper.deserialize(responseBody,
                V1EmployeeRole.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the details of an employee role.
     * @param    roleId    Required parameter: The ID of the role to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    public V1EmployeeRole updateEmployeeRole(
            final String roleId,
            final V1EmployeeRole body) throws ApiException, IOException {
        HttpRequest request = buildUpdateEmployeeRoleRequest(roleId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateEmployeeRoleResponse(context);
    }

    /**
     * Modifies the details of an employee role.
     * @param    roleId    Required parameter: The ID of the role to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1EmployeeRole response from the API call 
     */
    public CompletableFuture<V1EmployeeRole> updateEmployeeRoleAsync(
            final String roleId,
            final V1EmployeeRole body) {
        return makeHttpCallAsync(() -> buildUpdateEmployeeRoleRequest(roleId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateEmployeeRoleResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateEmployeeRole
     */
    private HttpRequest buildUpdateEmployeeRoleRequest(
            final String roleId,
            final V1EmployeeRole body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/roles/{role_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("role_id", roleId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateEmployeeRole
     * @return An object of type V1EmployeeRole
     */
    private V1EmployeeRole handleUpdateEmployeeRoleResponse(HttpContext context)
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
        V1EmployeeRole result = ApiHelper.deserialize(responseBody,
                V1EmployeeRole.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides summary information for all of a business's employee timecards.
     * @deprecated
     * 
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
    @Deprecated
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
            final String batchToken) throws ApiException, IOException {
        HttpRequest request = buildListTimecardsRequest(order, employeeId, beginClockinTime, endClockinTime, beginClockoutTime, endClockoutTime, beginUpdatedAt, endUpdatedAt, deleted, limit, batchToken);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListTimecardsResponse(context);
    }

    /**
     * Provides summary information for all of a business's employee timecards.
     * @deprecated
     * 
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
    @Deprecated
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
            final String batchToken) {
        return makeHttpCallAsync(() -> buildListTimecardsRequest(order, employeeId, beginClockinTime, endClockinTime, beginClockoutTime, endClockoutTime, beginUpdatedAt, endUpdatedAt, deleted, limit, batchToken),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListTimecardsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listTimecards
     */
    private HttpRequest buildListTimecardsRequest(
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
            final String batchToken) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/timecards");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("order", order);
        queryParameters.put("employee_id", employeeId);
        queryParameters.put("begin_clockin_time", beginClockinTime);
        queryParameters.put("end_clockin_time", endClockinTime);
        queryParameters.put("begin_clockout_time", beginClockoutTime);
        queryParameters.put("end_clockout_time", endClockoutTime);
        queryParameters.put("begin_updated_at", beginUpdatedAt);
        queryParameters.put("end_updated_at", endUpdatedAt);
        queryParameters.put("deleted", (deleted != null) ? deleted : false);
        queryParameters.put("limit", limit);
        queryParameters.put("batch_token", batchToken);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listTimecards
     * @return An object of type List<V1Timecard>
     */
    private List<V1Timecard> handleListTimecardsResponse(HttpContext context)
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
        List<V1Timecard> result = ApiHelper.deserializeArray(responseBody,
                V1Timecard[].class);
        return result;
    }

    /**
     * Creates a timecard for an employee and clocks them in with an
     * `API_CREATE` event and a `clockin_time` set to the current time unless
     * the request provides a different value.
     * To import timecards from another
     * system (rather than clocking someone in). Specify the `clockin_time`
     * and* `clockout_time` in the request.
     * Timecards correspond to exactly one shift for a given employee, bounded
     * by the `clockin_time` and `clockout_time` fields. An employee is
     * considered clocked in if they have a timecard that doesn't have a
     * `clockout_time` set. An employee that is currently clocked in cannot
     * be clocked in a second time.
     * @deprecated
     * 
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call
     */
    @Deprecated
    public V1Timecard createTimecard(
            final V1Timecard body) throws ApiException, IOException {
        HttpRequest request = buildCreateTimecardRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateTimecardResponse(context);
    }

    /**
     * Creates a timecard for an employee and clocks them in with an
     * `API_CREATE` event and a `clockin_time` set to the current time unless
     * the request provides a different value.
     * To import timecards from another
     * system (rather than clocking someone in). Specify the `clockin_time`
     * and* `clockout_time` in the request.
     * Timecards correspond to exactly one shift for a given employee, bounded
     * by the `clockin_time` and `clockout_time` fields. An employee is
     * considered clocked in if they have a timecard that doesn't have a
     * `clockout_time` set. An employee that is currently clocked in cannot
     * be clocked in a second time.
     * @deprecated
     * 
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Timecard> createTimecardAsync(
            final V1Timecard body) {
        return makeHttpCallAsync(() -> buildCreateTimecardRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateTimecardResponse(context));
    }

    /**
     * Builds the HttpRequest object for createTimecard
     */
    private HttpRequest buildCreateTimecardRequest(
            final V1Timecard body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/timecards");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for createTimecard
     * @return An object of type V1Timecard
     */
    private V1Timecard handleCreateTimecardResponse(HttpContext context)
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
        V1Timecard result = ApiHelper.deserialize(responseBody,
                V1Timecard.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a timecard. Timecards can also be deleted through the
     * Square Dashboard. Deleted timecards are still accessible through
     * Connect API endpoints, but cannot be modified. The `deleted` field of
     * the `Timecard` object indicates whether the timecard has been deleted.
     * __Note__: By default, deleted timecards appear alongside valid timecards in
     * results returned by the [ListTimecards](#endpoint-v1employees-listtimecards)
     * endpoint. To filter deleted timecards, include the `deleted` query
     * parameter in the list request.
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * @deprecated
     * 
     * @param    timecardId    Required parameter: The ID of the timecard to delete.
     * @return    Returns the Object response from the API call
     */
    @Deprecated
    public Object deleteTimecard(
            final String timecardId) throws ApiException, IOException {
        HttpRequest request = buildDeleteTimecardRequest(timecardId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteTimecardResponse(context);
    }

    /**
     * Deletes a timecard. Timecards can also be deleted through the
     * Square Dashboard. Deleted timecards are still accessible through
     * Connect API endpoints, but cannot be modified. The `deleted` field of
     * the `Timecard` object indicates whether the timecard has been deleted.
     * __Note__: By default, deleted timecards appear alongside valid timecards in
     * results returned by the [ListTimecards](#endpoint-v1employees-listtimecards)
     * endpoint. To filter deleted timecards, include the `deleted` query
     * parameter in the list request.
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * @deprecated
     * 
     * @param    timecardId    Required parameter: The ID of the timecard to delete.
     * @return    Returns the Object response from the API call 
     */
    @Deprecated
    public CompletableFuture<Object> deleteTimecardAsync(
            final String timecardId) {
        return makeHttpCallAsync(() -> buildDeleteTimecardRequest(timecardId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteTimecardResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteTimecard
     */
    private HttpRequest buildDeleteTimecardRequest(
            final String timecardId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/timecards/{timecard_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("timecard_id", timecardId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteTimecard
     * @return An object of type Object
     */
    private Object handleDeleteTimecardResponse(HttpContext context)
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
        Object result = responseBody;

        return result;
    }

    /**
     * Provides the details for a single timecard.
     * <aside>
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * </aside>
     * @deprecated
     * 
     * @param    timecardId    Required parameter: The timecard's ID.
     * @return    Returns the V1Timecard response from the API call
     */
    @Deprecated
    public V1Timecard retrieveTimecard(
            final String timecardId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveTimecardRequest(timecardId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveTimecardResponse(context);
    }

    /**
     * Provides the details for a single timecard.
     * <aside>
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * </aside>
     * @deprecated
     * 
     * @param    timecardId    Required parameter: The timecard's ID.
     * @return    Returns the V1Timecard response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Timecard> retrieveTimecardAsync(
            final String timecardId) {
        return makeHttpCallAsync(() -> buildRetrieveTimecardRequest(timecardId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveTimecardResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveTimecard
     */
    private HttpRequest buildRetrieveTimecardRequest(
            final String timecardId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/timecards/{timecard_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("timecard_id", timecardId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveTimecard
     * @return An object of type V1Timecard
     */
    private V1Timecard handleRetrieveTimecardResponse(HttpContext context)
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
        V1Timecard result = ApiHelper.deserialize(responseBody,
                V1Timecard.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the details of a timecard with an `API_EDIT` event for
     * the timecard. Updating an active timecard with a `clockout_time`
     * clocks the employee out.
     * @deprecated
     * 
     * @param    timecardId    Required parameter: TThe ID of the timecard to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request. See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call
     */
    @Deprecated
    public V1Timecard updateTimecard(
            final String timecardId,
            final V1Timecard body) throws ApiException, IOException {
        HttpRequest request = buildUpdateTimecardRequest(timecardId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateTimecardResponse(context);
    }

    /**
     * Modifies the details of a timecard with an `API_EDIT` event for
     * the timecard. Updating an active timecard with a `clockout_time`
     * clocks the employee out.
     * @deprecated
     * 
     * @param    timecardId    Required parameter: TThe ID of the timecard to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request. See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Timecard> updateTimecardAsync(
            final String timecardId,
            final V1Timecard body) {
        return makeHttpCallAsync(() -> buildUpdateTimecardRequest(timecardId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateTimecardResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateTimecard
     */
    private HttpRequest buildUpdateTimecardRequest(
            final String timecardId,
            final V1Timecard body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/timecards/{timecard_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("timecard_id", timecardId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateTimecard
     * @return An object of type V1Timecard
     */
    private V1Timecard handleUpdateTimecardResponse(HttpContext context)
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
        V1Timecard result = ApiHelper.deserialize(responseBody,
                V1Timecard.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides summary information for all events associated with a
     * particular timecard.
     * <aside>
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * </aside>
     * @deprecated
     * 
     * @param    timecardId    Required parameter: The ID of the timecard to list events for.
     * @return    Returns the List<V1TimecardEvent> response from the API call
     */
    @Deprecated
    public List<V1TimecardEvent> listTimecardEvents(
            final String timecardId) throws ApiException, IOException {
        HttpRequest request = buildListTimecardEventsRequest(timecardId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListTimecardEventsResponse(context);
    }

    /**
     * Provides summary information for all events associated with a
     * particular timecard.
     * <aside>
     * Only approved accounts can manage their employees with Square.
     * Unapproved accounts cannot use employee management features with the
     * API.
     * </aside>
     * @deprecated
     * 
     * @param    timecardId    Required parameter: The ID of the timecard to list events for.
     * @return    Returns the List<V1TimecardEvent> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1TimecardEvent>> listTimecardEventsAsync(
            final String timecardId) {
        return makeHttpCallAsync(() -> buildListTimecardEventsRequest(timecardId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListTimecardEventsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listTimecardEvents
     */
    private HttpRequest buildListTimecardEventsRequest(
            final String timecardId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/timecards/{timecard_id}/events");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("timecard_id", timecardId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listTimecardEvents
     * @return An object of type List<V1TimecardEvent>
     */
    private List<V1TimecardEvent> handleListTimecardEventsResponse(HttpContext context)
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
        List<V1TimecardEvent> result = ApiHelper.deserializeArray(responseBody,
                V1TimecardEvent[].class);
        return result;
    }

    /**
     * Provides the details for all of a location's cash drawer shifts during a date range. The date range you specify cannot exceed 90 days.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list cash drawer shifts for.
     * @param    order    Optional parameter: The order in which cash drawer shifts are listed in the response, based on their created_at field. Default value: ASC
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time minus 90 days.
     * @param    endTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time.
     * @return    Returns the List<V1CashDrawerShift> response from the API call
     */
    @Deprecated
    public List<V1CashDrawerShift> listCashDrawerShifts(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime) throws ApiException, IOException {
        HttpRequest request = buildListCashDrawerShiftsRequest(locationId, order, beginTime, endTime);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListCashDrawerShiftsResponse(context);
    }

    /**
     * Provides the details for all of a location's cash drawer shifts during a date range. The date range you specify cannot exceed 90 days.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list cash drawer shifts for.
     * @param    order    Optional parameter: The order in which cash drawer shifts are listed in the response, based on their created_at field. Default value: ASC
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time minus 90 days.
     * @param    endTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time.
     * @return    Returns the List<V1CashDrawerShift> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1CashDrawerShift>> listCashDrawerShiftsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime) {
        return makeHttpCallAsync(() -> buildListCashDrawerShiftsRequest(locationId, order, beginTime, endTime),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListCashDrawerShiftsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCashDrawerShifts
     */
    private HttpRequest buildListCashDrawerShiftsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/cash-drawer-shifts");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("order", order);
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listCashDrawerShifts
     * @return An object of type List<V1CashDrawerShift>
     */
    private List<V1CashDrawerShift> handleListCashDrawerShiftsResponse(HttpContext context)
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
        List<V1CashDrawerShift> result = ApiHelper.deserializeArray(responseBody,
                V1CashDrawerShift[].class);
        return result;
    }

    /**
     * Provides the details for a single cash drawer shift, including all events that occurred during the shift.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list cash drawer shifts for.
     * @param    shiftId    Required parameter: The shift's ID.
     * @return    Returns the V1CashDrawerShift response from the API call
     */
    @Deprecated
    public V1CashDrawerShift retrieveCashDrawerShift(
            final String locationId,
            final String shiftId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveCashDrawerShiftRequest(locationId, shiftId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveCashDrawerShiftResponse(context);
    }

    /**
     * Provides the details for a single cash drawer shift, including all events that occurred during the shift.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list cash drawer shifts for.
     * @param    shiftId    Required parameter: The shift's ID.
     * @return    Returns the V1CashDrawerShift response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1CashDrawerShift> retrieveCashDrawerShiftAsync(
            final String locationId,
            final String shiftId) {
        return makeHttpCallAsync(() -> buildRetrieveCashDrawerShiftRequest(locationId, shiftId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveCashDrawerShiftResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveCashDrawerShift
     */
    private HttpRequest buildRetrieveCashDrawerShiftRequest(
            final String locationId,
            final String shiftId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/cash-drawer-shifts/{shift_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("shift_id", shiftId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveCashDrawerShift
     * @return An object of type V1CashDrawerShift
     */
    private V1CashDrawerShift handleRetrieveCashDrawerShiftResponse(HttpContext context)
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
        V1CashDrawerShift result = ApiHelper.deserialize(responseBody,
                V1CashDrawerShift.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}