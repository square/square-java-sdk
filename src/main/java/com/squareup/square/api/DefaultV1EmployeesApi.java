
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.AuthManager;
import com.squareup.square.Configuration;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.Headers;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.V1Employee;
import com.squareup.square.models.V1EmployeeRole;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultV1EmployeesApi extends BaseApi implements V1EmployeesApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultV1EmployeesApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     * @param httpCallback    Callback to be called before and after the HTTP call.
     */
    public DefaultV1EmployeesApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Provides summary information for all of a business's employees.
     * @param  order  Optional parameter: The order in which employees are listed in the response,
     *         based on their created_at field. Default value: ASC
     * @param  beginUpdatedAt  Optional parameter: If filtering results by their updated_at field,
     *         the beginning of the requested reporting period, in ISO 8601 format
     * @param  endUpdatedAt  Optional parameter: If filtering results by there updated_at field, the
     *         end of the requested reporting period, in ISO 8601 format.
     * @param  beginCreatedAt  Optional parameter: If filtering results by their created_at field,
     *         the beginning of the requested reporting period, in ISO 8601 format.
     * @param  endCreatedAt  Optional parameter: If filtering results by their created_at field, the
     *         end of the requested reporting period, in ISO 8601 format.
     * @param  status  Optional parameter: If provided, the endpoint returns only employee entities
     *         with the specified status (ACTIVE or INACTIVE).
     * @param  externalId  Optional parameter: If provided, the endpoint returns only employee
     *         entities with the specified external_id.
     * @param  limit  Optional parameter: The maximum integer number of employee entities to return
     *         in a single response. Default 100, maximum 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Employee response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
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
        HttpRequest request = buildListEmployeesRequest(order, beginUpdatedAt, endUpdatedAt,
                beginCreatedAt, endCreatedAt, status, externalId, limit, batchToken);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListEmployeesResponse(context);
    }

    /**
     * Provides summary information for all of a business's employees.
     * @param  order  Optional parameter: The order in which employees are listed in the response,
     *         based on their created_at field. Default value: ASC
     * @param  beginUpdatedAt  Optional parameter: If filtering results by their updated_at field,
     *         the beginning of the requested reporting period, in ISO 8601 format
     * @param  endUpdatedAt  Optional parameter: If filtering results by there updated_at field, the
     *         end of the requested reporting period, in ISO 8601 format.
     * @param  beginCreatedAt  Optional parameter: If filtering results by their created_at field,
     *         the beginning of the requested reporting period, in ISO 8601 format.
     * @param  endCreatedAt  Optional parameter: If filtering results by their created_at field, the
     *         end of the requested reporting period, in ISO 8601 format.
     * @param  status  Optional parameter: If provided, the endpoint returns only employee entities
     *         with the specified status (ACTIVE or INACTIVE).
     * @param  externalId  Optional parameter: If provided, the endpoint returns only employee
     *         entities with the specified external_id.
     * @param  limit  Optional parameter: The maximum integer number of employee entities to return
     *         in a single response. Default 100, maximum 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Employee response from the API call
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
        return makeHttpCallAsync(() -> buildListEmployeesRequest(order, beginUpdatedAt,
                endUpdatedAt, beginCreatedAt, endCreatedAt, status, externalId, limit, batchToken),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleListEmployeesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listEmployees.
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
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/me/employees");

        //load all query parameters
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

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listEmployees.
     * @return An object of type List of V1Employee
     */
    private List<V1Employee> handleListEmployeesResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        List<V1Employee> result = ApiHelper.deserializeArray(responseBody,
                V1Employee[].class);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).toBuilder().httpContext(context).build());
        }
        return result;
    }

    /**
     * Use the CreateEmployee endpoint to add an employee to a Square account. Employees created
     * with the Connect API have an initial status of `INACTIVE`. Inactive employees cannot sign in
     * to Square Point of Sale until they are activated from the Square Dashboard. Employee status
     * cannot be changed with the Connect API. Employee entities cannot be deleted. To disable
     * employee profiles, set the employee's status to <code>INACTIVE</code>.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public V1Employee createEmployee(
            final V1Employee body) throws ApiException, IOException {
        HttpRequest request = buildCreateEmployeeRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateEmployeeResponse(context);
    }

    /**
     * Use the CreateEmployee endpoint to add an employee to a Square account. Employees created
     * with the Connect API have an initial status of `INACTIVE`. Inactive employees cannot sign in
     * to Square Point of Sale until they are activated from the Square Dashboard. Employee status
     * cannot be changed with the Connect API. Employee entities cannot be deleted. To disable
     * employee profiles, set the employee's status to <code>INACTIVE</code>.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     */
    public CompletableFuture<V1Employee> createEmployeeAsync(
            final V1Employee body) {
        return makeHttpCallAsync(() -> buildCreateEmployeeRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleCreateEmployeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for createEmployee.
     */
    private HttpRequest buildCreateEmployeeRequest(
            final V1Employee body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/me/employees");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createEmployee.
     * @return An object of type V1Employee
     */
    private V1Employee handleCreateEmployeeResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        V1Employee result = ApiHelper.deserialize(responseBody,
                V1Employee.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides the details for a single employee.
     * @param  employeeId  Required parameter: The employee's ID.
     * @return    Returns the V1Employee response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public V1Employee retrieveEmployee(
            final String employeeId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveEmployeeRequest(employeeId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveEmployeeResponse(context);
    }

    /**
     * Provides the details for a single employee.
     * @param  employeeId  Required parameter: The employee's ID.
     * @return    Returns the V1Employee response from the API call
     */
    public CompletableFuture<V1Employee> retrieveEmployeeAsync(
            final String employeeId) {
        return makeHttpCallAsync(() -> buildRetrieveEmployeeRequest(employeeId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleRetrieveEmployeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveEmployee.
     */
    private HttpRequest buildRetrieveEmployeeRequest(
            final String employeeId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/me/employees/{employee_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("employee_id",
                new SimpleEntry<Object, Boolean>(employeeId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveEmployee.
     * @return An object of type V1Employee
     */
    private V1Employee handleRetrieveEmployeeResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        V1Employee result = ApiHelper.deserialize(responseBody,
                V1Employee.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * UpdateEmployee.
     * @param  employeeId  Required parameter: The ID of the role to modify.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public V1Employee updateEmployee(
            final String employeeId,
            final V1Employee body) throws ApiException, IOException {
        HttpRequest request = buildUpdateEmployeeRequest(employeeId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateEmployeeResponse(context);
    }

    /**
     * UpdateEmployee.
     * @param  employeeId  Required parameter: The ID of the role to modify.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     */
    public CompletableFuture<V1Employee> updateEmployeeAsync(
            final String employeeId,
            final V1Employee body) {
        return makeHttpCallAsync(() -> buildUpdateEmployeeRequest(employeeId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleUpdateEmployeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateEmployee.
     */
    private HttpRequest buildUpdateEmployeeRequest(
            final String employeeId,
            final V1Employee body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/me/employees/{employee_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("employee_id",
                new SimpleEntry<Object, Boolean>(employeeId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateEmployee.
     * @return An object of type V1Employee
     */
    private V1Employee handleUpdateEmployeeResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        V1Employee result = ApiHelper.deserialize(responseBody,
                V1Employee.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides summary information for all of a business's employee roles.
     * @param  order  Optional parameter: The order in which employees are listed in the response,
     *         based on their created_at field.Default value: ASC
     * @param  limit  Optional parameter: The maximum integer number of employee entities to return
     *         in a single response. Default 100, maximum 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1EmployeeRole response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public List<V1EmployeeRole> listEmployeeRoles(
            final String order,
            final Integer limit,
            final String batchToken) throws ApiException, IOException {
        HttpRequest request = buildListEmployeeRolesRequest(order, limit, batchToken);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListEmployeeRolesResponse(context);
    }

    /**
     * Provides summary information for all of a business's employee roles.
     * @param  order  Optional parameter: The order in which employees are listed in the response,
     *         based on their created_at field.Default value: ASC
     * @param  limit  Optional parameter: The maximum integer number of employee entities to return
     *         in a single response. Default 100, maximum 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1EmployeeRole response from the API call
     */
    public CompletableFuture<List<V1EmployeeRole>> listEmployeeRolesAsync(
            final String order,
            final Integer limit,
            final String batchToken) {
        return makeHttpCallAsync(() -> buildListEmployeeRolesRequest(order, limit, batchToken),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleListEmployeeRolesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listEmployeeRoles.
     */
    private HttpRequest buildListEmployeeRolesRequest(
            final String order,
            final Integer limit,
            final String batchToken) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/me/roles");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("order", order);
        queryParameters.put("limit", limit);
        queryParameters.put("batch_token", batchToken);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listEmployeeRoles.
     * @return An object of type List of V1EmployeeRole
     */
    private List<V1EmployeeRole> handleListEmployeeRolesResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        List<V1EmployeeRole> result = ApiHelper.deserializeArray(responseBody,
                V1EmployeeRole[].class);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).toBuilder().httpContext(context).build());
        }
        return result;
    }

    /**
     * Creates an employee role you can then assign to employees. Square accounts can include any
     * number of roles that can be assigned to employees. These roles define the actions and
     * permissions granted to an employee with that role. For example, an employee with a "Shift
     * Manager" role might be able to issue refunds in Square Point of Sale, whereas an employee
     * with a "Clerk" role might not. Roles are assigned with the
     * [V1UpdateEmployee](#endpoint-v1updateemployee) endpoint. An employee can have only one role
     * at a time. If an employee has no role, they have none of the permissions associated with
     * roles. All employees can accept payments with Square Point of Sale.
     * @param  body  Required parameter: An EmployeeRole object with a name and permissions, and an
     *         optional owner flag.
     * @return    Returns the V1EmployeeRole response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public V1EmployeeRole createEmployeeRole(
            final V1EmployeeRole body) throws ApiException, IOException {
        HttpRequest request = buildCreateEmployeeRoleRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateEmployeeRoleResponse(context);
    }

    /**
     * Creates an employee role you can then assign to employees. Square accounts can include any
     * number of roles that can be assigned to employees. These roles define the actions and
     * permissions granted to an employee with that role. For example, an employee with a "Shift
     * Manager" role might be able to issue refunds in Square Point of Sale, whereas an employee
     * with a "Clerk" role might not. Roles are assigned with the
     * [V1UpdateEmployee](#endpoint-v1updateemployee) endpoint. An employee can have only one role
     * at a time. If an employee has no role, they have none of the permissions associated with
     * roles. All employees can accept payments with Square Point of Sale.
     * @param  body  Required parameter: An EmployeeRole object with a name and permissions, and an
     *         optional owner flag.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    public CompletableFuture<V1EmployeeRole> createEmployeeRoleAsync(
            final V1EmployeeRole body) {
        return makeHttpCallAsync(() -> buildCreateEmployeeRoleRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleCreateEmployeeRoleResponse(context));
    }

    /**
     * Builds the HttpRequest object for createEmployeeRole.
     */
    private HttpRequest buildCreateEmployeeRoleRequest(
            final V1EmployeeRole body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/me/roles");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createEmployeeRole.
     * @return An object of type V1EmployeeRole
     */
    private V1EmployeeRole handleCreateEmployeeRoleResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        V1EmployeeRole result = ApiHelper.deserialize(responseBody,
                V1EmployeeRole.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides the details for a single employee role.
     * @param  roleId  Required parameter: The role's ID.
     * @return    Returns the V1EmployeeRole response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public V1EmployeeRole retrieveEmployeeRole(
            final String roleId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveEmployeeRoleRequest(roleId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveEmployeeRoleResponse(context);
    }

    /**
     * Provides the details for a single employee role.
     * @param  roleId  Required parameter: The role's ID.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    public CompletableFuture<V1EmployeeRole> retrieveEmployeeRoleAsync(
            final String roleId) {
        return makeHttpCallAsync(() -> buildRetrieveEmployeeRoleRequest(roleId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleRetrieveEmployeeRoleResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveEmployeeRole.
     */
    private HttpRequest buildRetrieveEmployeeRoleRequest(
            final String roleId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/me/roles/{role_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("role_id",
                new SimpleEntry<Object, Boolean>(roleId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveEmployeeRole.
     * @return An object of type V1EmployeeRole
     */
    private V1EmployeeRole handleRetrieveEmployeeRoleResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        V1EmployeeRole result = ApiHelper.deserialize(responseBody,
                V1EmployeeRole.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the details of an employee role.
     * @param  roleId  Required parameter: The ID of the role to modify.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1EmployeeRole response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public V1EmployeeRole updateEmployeeRole(
            final String roleId,
            final V1EmployeeRole body) throws ApiException, IOException {
        HttpRequest request = buildUpdateEmployeeRoleRequest(roleId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateEmployeeRoleResponse(context);
    }

    /**
     * Modifies the details of an employee role.
     * @param  roleId  Required parameter: The ID of the role to modify.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    public CompletableFuture<V1EmployeeRole> updateEmployeeRoleAsync(
            final String roleId,
            final V1EmployeeRole body) {
        return makeHttpCallAsync(() -> buildUpdateEmployeeRoleRequest(roleId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleUpdateEmployeeRoleResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateEmployeeRole.
     */
    private HttpRequest buildUpdateEmployeeRoleRequest(
            final String roleId,
            final V1EmployeeRole body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/me/roles/{role_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("role_id",
                new SimpleEntry<Object, Boolean>(roleId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateEmployeeRole.
     * @return An object of type V1EmployeeRole
     */
    private V1EmployeeRole handleUpdateEmployeeRoleResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        V1EmployeeRole result = ApiHelper.deserialize(responseBody,
                V1EmployeeRole.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}