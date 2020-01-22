package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.HashMap;
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
import com.squareup.square.models.CreateBreakTypeRequest;
import com.squareup.square.models.CreateBreakTypeResponse;
import com.squareup.square.models.CreateShiftRequest;
import com.squareup.square.models.CreateShiftResponse;
import com.squareup.square.models.DeleteBreakTypeResponse;
import com.squareup.square.models.DeleteShiftResponse;
import com.squareup.square.models.GetBreakTypeResponse;
import com.squareup.square.models.GetEmployeeWageResponse;
import com.squareup.square.models.GetShiftResponse;
import com.squareup.square.models.ListBreakTypesResponse;
import com.squareup.square.models.ListEmployeeWagesResponse;
import com.squareup.square.models.ListWorkweekConfigsResponse;
import com.squareup.square.models.SearchShiftsRequest;
import com.squareup.square.models.SearchShiftsResponse;
import com.squareup.square.models.UpdateBreakTypeRequest;
import com.squareup.square.models.UpdateBreakTypeResponse;
import com.squareup.square.models.UpdateShiftRequest;
import com.squareup.square.models.UpdateShiftResponse;
import com.squareup.square.models.UpdateWorkweekConfigRequest;
import com.squareup.square.models.UpdateWorkweekConfigResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class LaborApi extends BaseApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public LaborApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
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
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListBreakTypesRequest(locationId, limit, cursor);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListBreakTypesResponse(context);
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
            final String cursor) {
        return makeHttpCallAsync(() -> buildListBreakTypesRequest(locationId, limit, cursor),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListBreakTypesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listBreakTypes
     */
    private HttpRequest buildListBreakTypesRequest(
            final String locationId,
            final Integer limit,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/break-types");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("location_id", locationId);
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for listBreakTypes
     * @return An object of type ListBreakTypesResponse
     */
    private ListBreakTypesResponse handleListBreakTypesResponse(HttpContext context)
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
        ListBreakTypesResponse result = ApiHelper.deserialize(responseBody,
                ListBreakTypesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
            final CreateBreakTypeRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateBreakTypeRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateBreakTypeResponse(context);
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
            final CreateBreakTypeRequest body) {
        return makeHttpCallAsync(() -> buildCreateBreakTypeRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateBreakTypeResponse(context));
    }

    /**
     * Builds the HttpRequest object for createBreakType
     */
    private HttpRequest buildCreateBreakTypeRequest(
            final CreateBreakTypeRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/break-types");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for createBreakType
     * @return An object of type CreateBreakTypeResponse
     */
    private CreateBreakTypeResponse handleCreateBreakTypeResponse(HttpContext context)
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
        CreateBreakTypeResponse result = ApiHelper.deserialize(responseBody,
                CreateBreakTypeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes an existing `BreakType`. 
     * A `BreakType` can be deleted even if it is referenced from a `Shift`.
     * @param    id    Required parameter: UUID for the `BreakType` being deleted.
     * @return    Returns the DeleteBreakTypeResponse response from the API call
     */
    public DeleteBreakTypeResponse deleteBreakType(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildDeleteBreakTypeRequest(id);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteBreakTypeResponse(context);
    }

    /**
     * Deletes an existing `BreakType`. 
     * A `BreakType` can be deleted even if it is referenced from a `Shift`.
     * @param    id    Required parameter: UUID for the `BreakType` being deleted.
     * @return    Returns the DeleteBreakTypeResponse response from the API call 
     */
    public CompletableFuture<DeleteBreakTypeResponse> deleteBreakTypeAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildDeleteBreakTypeRequest(id),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteBreakTypeResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteBreakType
     */
    private HttpRequest buildDeleteBreakTypeRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/break-types/{id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("id", id);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for deleteBreakType
     * @return An object of type DeleteBreakTypeResponse
     */
    private DeleteBreakTypeResponse handleDeleteBreakTypeResponse(HttpContext context)
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
        DeleteBreakTypeResponse result = ApiHelper.deserialize(responseBody,
                DeleteBreakTypeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a single `BreakType` specified by id.
     * @param    id    Required parameter: UUID for the `BreakType` being retrieved.
     * @return    Returns the GetBreakTypeResponse response from the API call
     */
    public GetBreakTypeResponse getBreakType(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildGetBreakTypeRequest(id);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleGetBreakTypeResponse(context);
    }

    /**
     * Returns a single `BreakType` specified by id.
     * @param    id    Required parameter: UUID for the `BreakType` being retrieved.
     * @return    Returns the GetBreakTypeResponse response from the API call 
     */
    public CompletableFuture<GetBreakTypeResponse> getBreakTypeAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildGetBreakTypeRequest(id),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleGetBreakTypeResponse(context));
    }

    /**
     * Builds the HttpRequest object for getBreakType
     */
    private HttpRequest buildGetBreakTypeRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/break-types/{id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("id", id);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for getBreakType
     * @return An object of type GetBreakTypeResponse
     */
    private GetBreakTypeResponse handleGetBreakTypeResponse(HttpContext context)
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
        GetBreakTypeResponse result = ApiHelper.deserialize(responseBody,
                GetBreakTypeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates an existing `BreakType`.
     * @param    id    Required parameter: UUID for the `BreakType` being updated.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateBreakTypeResponse response from the API call
     */
    public UpdateBreakTypeResponse updateBreakType(
            final String id,
            final UpdateBreakTypeRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateBreakTypeRequest(id, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateBreakTypeResponse(context);
    }

    /**
     * Updates an existing `BreakType`.
     * @param    id    Required parameter: UUID for the `BreakType` being updated.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateBreakTypeResponse response from the API call 
     */
    public CompletableFuture<UpdateBreakTypeResponse> updateBreakTypeAsync(
            final String id,
            final UpdateBreakTypeRequest body) {
        return makeHttpCallAsync(() -> buildUpdateBreakTypeRequest(id, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateBreakTypeResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateBreakType
     */
    private HttpRequest buildUpdateBreakTypeRequest(
            final String id,
            final UpdateBreakTypeRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/break-types/{id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("id", id);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for updateBreakType
     * @return An object of type UpdateBreakTypeResponse
     */
    private UpdateBreakTypeResponse handleUpdateBreakTypeResponse(HttpContext context)
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
        UpdateBreakTypeResponse result = ApiHelper.deserialize(responseBody,
                UpdateBreakTypeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListEmployeeWagesRequest(employeeId, limit, cursor);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListEmployeeWagesResponse(context);
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
            final String cursor) {
        return makeHttpCallAsync(() -> buildListEmployeeWagesRequest(employeeId, limit, cursor),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListEmployeeWagesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listEmployeeWages
     */
    private HttpRequest buildListEmployeeWagesRequest(
            final String employeeId,
            final Integer limit,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/employee-wages");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("employee_id", employeeId);
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for listEmployeeWages
     * @return An object of type ListEmployeeWagesResponse
     */
    private ListEmployeeWagesResponse handleListEmployeeWagesResponse(HttpContext context)
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
        ListEmployeeWagesResponse result = ApiHelper.deserialize(responseBody,
                ListEmployeeWagesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a single `EmployeeWage` specified by id.
     * @param    id    Required parameter: UUID for the `EmployeeWage` being retrieved.
     * @return    Returns the GetEmployeeWageResponse response from the API call
     */
    public GetEmployeeWageResponse getEmployeeWage(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildGetEmployeeWageRequest(id);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleGetEmployeeWageResponse(context);
    }

    /**
     * Returns a single `EmployeeWage` specified by id.
     * @param    id    Required parameter: UUID for the `EmployeeWage` being retrieved.
     * @return    Returns the GetEmployeeWageResponse response from the API call 
     */
    public CompletableFuture<GetEmployeeWageResponse> getEmployeeWageAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildGetEmployeeWageRequest(id),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleGetEmployeeWageResponse(context));
    }

    /**
     * Builds the HttpRequest object for getEmployeeWage
     */
    private HttpRequest buildGetEmployeeWageRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/employee-wages/{id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("id", id);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for getEmployeeWage
     * @return An object of type GetEmployeeWageResponse
     */
    private GetEmployeeWageResponse handleGetEmployeeWageResponse(HttpContext context)
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
        GetEmployeeWageResponse result = ApiHelper.deserialize(responseBody,
                GetEmployeeWageResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
            final CreateShiftRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateShiftRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateShiftResponse(context);
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
            final CreateShiftRequest body) {
        return makeHttpCallAsync(() -> buildCreateShiftRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateShiftResponse(context));
    }

    /**
     * Builds the HttpRequest object for createShift
     */
    private HttpRequest buildCreateShiftRequest(
            final CreateShiftRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/shifts");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for createShift
     * @return An object of type CreateShiftResponse
     */
    private CreateShiftResponse handleCreateShiftResponse(HttpContext context)
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
        CreateShiftResponse result = ApiHelper.deserialize(responseBody,
                CreateShiftResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
            final SearchShiftsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchShiftsRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleSearchShiftsResponse(context);
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
            final SearchShiftsRequest body) {
        return makeHttpCallAsync(() -> buildSearchShiftsRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleSearchShiftsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchShifts
     */
    private HttpRequest buildSearchShiftsRequest(
            final SearchShiftsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/shifts/search");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for searchShifts
     * @return An object of type SearchShiftsResponse
     */
    private SearchShiftsResponse handleSearchShiftsResponse(HttpContext context)
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
        SearchShiftsResponse result = ApiHelper.deserialize(responseBody,
                SearchShiftsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a `Shift`.
     * @param    id    Required parameter: UUID for the `Shift` being deleted.
     * @return    Returns the DeleteShiftResponse response from the API call
     */
    public DeleteShiftResponse deleteShift(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildDeleteShiftRequest(id);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteShiftResponse(context);
    }

    /**
     * Deletes a `Shift`.
     * @param    id    Required parameter: UUID for the `Shift` being deleted.
     * @return    Returns the DeleteShiftResponse response from the API call 
     */
    public CompletableFuture<DeleteShiftResponse> deleteShiftAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildDeleteShiftRequest(id),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteShiftResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteShift
     */
    private HttpRequest buildDeleteShiftRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/shifts/{id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("id", id);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for deleteShift
     * @return An object of type DeleteShiftResponse
     */
    private DeleteShiftResponse handleDeleteShiftResponse(HttpContext context)
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
        DeleteShiftResponse result = ApiHelper.deserialize(responseBody,
                DeleteShiftResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a single `Shift` specified by id.
     * @param    id    Required parameter: UUID for the `Shift` being retrieved.
     * @return    Returns the GetShiftResponse response from the API call
     */
    public GetShiftResponse getShift(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildGetShiftRequest(id);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleGetShiftResponse(context);
    }

    /**
     * Returns a single `Shift` specified by id.
     * @param    id    Required parameter: UUID for the `Shift` being retrieved.
     * @return    Returns the GetShiftResponse response from the API call 
     */
    public CompletableFuture<GetShiftResponse> getShiftAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildGetShiftRequest(id),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleGetShiftResponse(context));
    }

    /**
     * Builds the HttpRequest object for getShift
     */
    private HttpRequest buildGetShiftRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/shifts/{id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("id", id);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for getShift
     * @return An object of type GetShiftResponse
     */
    private GetShiftResponse handleGetShiftResponse(HttpContext context)
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
        GetShiftResponse result = ApiHelper.deserialize(responseBody,
                GetShiftResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
            final UpdateShiftRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateShiftRequest(id, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateShiftResponse(context);
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
            final UpdateShiftRequest body) {
        return makeHttpCallAsync(() -> buildUpdateShiftRequest(id, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateShiftResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateShift
     */
    private HttpRequest buildUpdateShiftRequest(
            final String id,
            final UpdateShiftRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/shifts/{id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("id", id);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for updateShift
     * @return An object of type UpdateShiftResponse
     */
    private UpdateShiftResponse handleUpdateShiftResponse(HttpContext context)
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
        UpdateShiftResponse result = ApiHelper.deserialize(responseBody,
                UpdateShiftResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a list of `WorkweekConfig` instances for a business.
     * @param    limit    Optional parameter: Maximum number of Workweek Configs to return per page.
     * @param    cursor    Optional parameter: Pointer to the next page of Workweek Config results to fetch.
     * @return    Returns the ListWorkweekConfigsResponse response from the API call
     */
    public ListWorkweekConfigsResponse listWorkweekConfigs(
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListWorkweekConfigsRequest(limit, cursor);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListWorkweekConfigsResponse(context);
    }

    /**
     * Returns a list of `WorkweekConfig` instances for a business.
     * @param    limit    Optional parameter: Maximum number of Workweek Configs to return per page.
     * @param    cursor    Optional parameter: Pointer to the next page of Workweek Config results to fetch.
     * @return    Returns the ListWorkweekConfigsResponse response from the API call 
     */
    public CompletableFuture<ListWorkweekConfigsResponse> listWorkweekConfigsAsync(
            final Integer limit,
            final String cursor) {
        return makeHttpCallAsync(() -> buildListWorkweekConfigsRequest(limit, cursor),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListWorkweekConfigsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listWorkweekConfigs
     */
    private HttpRequest buildListWorkweekConfigsRequest(
            final Integer limit,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/workweek-configs");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for listWorkweekConfigs
     * @return An object of type ListWorkweekConfigsResponse
     */
    private ListWorkweekConfigsResponse handleListWorkweekConfigsResponse(HttpContext context)
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
        ListWorkweekConfigsResponse result = ApiHelper.deserialize(responseBody,
                ListWorkweekConfigsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a `WorkweekConfig`.
     * @param    id    Required parameter: UUID for the `WorkweekConfig` object being updated.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateWorkweekConfigResponse response from the API call
     */
    public UpdateWorkweekConfigResponse updateWorkweekConfig(
            final String id,
            final UpdateWorkweekConfigRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateWorkweekConfigRequest(id, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateWorkweekConfigResponse(context);
    }

    /**
     * Updates a `WorkweekConfig`.
     * @param    id    Required parameter: UUID for the `WorkweekConfig` object being updated.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateWorkweekConfigResponse response from the API call 
     */
    public CompletableFuture<UpdateWorkweekConfigResponse> updateWorkweekConfigAsync(
            final String id,
            final UpdateWorkweekConfigRequest body) {
        return makeHttpCallAsync(() -> buildUpdateWorkweekConfigRequest(id, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateWorkweekConfigResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateWorkweekConfig
     */
    private HttpRequest buildUpdateWorkweekConfigRequest(
            final String id,
            final UpdateWorkweekConfigRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/labor/workweek-configs/{id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("id", id);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
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
     * Processes the response for updateWorkweekConfig
     * @return An object of type UpdateWorkweekConfigResponse
     */
    private UpdateWorkweekConfigResponse handleUpdateWorkweekConfigResponse(HttpContext context)
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
        UpdateWorkweekConfigResponse result = ApiHelper.deserialize(responseBody,
                UpdateWorkweekConfigResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}
