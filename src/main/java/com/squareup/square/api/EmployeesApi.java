package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.HashMap;
import java.util.Map;

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
import com.squareup.square.models.ListEmployeesResponse;
import com.squareup.square.models.RetrieveEmployeeResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class EmployeesApi extends BaseApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public EmployeesApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
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
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListEmployeesRequest(locationId, status, limit, cursor);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListEmployeesResponse(context);
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
            final String cursor) {
        return makeHttpCallAsync(() -> buildListEmployeesRequest(locationId, status, limit, cursor),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListEmployeesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listEmployees
     */
    private HttpRequest buildListEmployeesRequest(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/employees");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("location_id", locationId);
        queryParameters.put("status", status);
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-03-25");
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
     * @return An object of type ListEmployeesResponse
     */
    private ListEmployeesResponse handleListEmployeesResponse(HttpContext context)
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
        ListEmployeesResponse result = ApiHelper.deserialize(responseBody,
                ListEmployeesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * RetrieveEmployee
     * @param    id    Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call
     */
    public RetrieveEmployeeResponse retrieveEmployee(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildRetrieveEmployeeRequest(id);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveEmployeeResponse(context);
    }

    /**
     * RetrieveEmployee
     * @param    id    Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call 
     */
    public CompletableFuture<RetrieveEmployeeResponse> retrieveEmployeeAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildRetrieveEmployeeRequest(id),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveEmployeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveEmployee
     */
    private HttpRequest buildRetrieveEmployeeRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/employees/{id}");

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
        headers.add("Square-Version", "2020-03-25");
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
     * @return An object of type RetrieveEmployeeResponse
     */
    private RetrieveEmployeeResponse handleRetrieveEmployeeResponse(HttpContext context)
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
        RetrieveEmployeeResponse result = ApiHelper.deserialize(responseBody,
                RetrieveEmployeeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}