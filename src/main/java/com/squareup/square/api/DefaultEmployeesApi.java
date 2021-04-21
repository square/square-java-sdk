
package com.squareup.square.api;

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
import com.squareup.square.models.ListEmployeesResponse;
import com.squareup.square.models.RetrieveEmployeeResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultEmployeesApi extends BaseApi implements EmployeesApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultEmployeesApi(Configuration config, HttpClient httpClient,
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
    public DefaultEmployeesApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * ListEmployees.
     * @deprecated
     * 
     * @param  locationId  Optional parameter: Example:
     * @param  status  Optional parameter: Specifies the EmployeeStatus to filter the employee by.
     * @param  limit  Optional parameter: The number of employees to be returned on each page.
     * @param  cursor  Optional parameter: The token required to retrieve the specified page of
     *         results.
     * @return    Returns the ListEmployeesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public ListEmployeesResponse listEmployees(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListEmployeesRequest(locationId, status, limit, cursor);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListEmployeesResponse(context);
    }

    /**
     * ListEmployees.
     * @deprecated
     * 
     * @param  locationId  Optional parameter: Example:
     * @param  status  Optional parameter: Specifies the EmployeeStatus to filter the employee by.
     * @param  limit  Optional parameter: The number of employees to be returned on each page.
     * @param  cursor  Optional parameter: The token required to retrieve the specified page of
     *         results.
     * @return    Returns the ListEmployeesResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<ListEmployeesResponse> listEmployeesAsync(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor) {
        return makeHttpCallAsync(() -> buildListEmployeesRequest(locationId, status, limit, cursor),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListEmployeesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listEmployees.
     */
    private HttpRequest buildListEmployeesRequest(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/employees");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("location_id", locationId);
        queryParameters.put("status", status);
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);

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
     * @return An object of type ListEmployeesResponse
     */
    private ListEmployeesResponse handleListEmployeesResponse(
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
        ListEmployeesResponse result = ApiHelper.deserialize(responseBody,
                ListEmployeesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * RetrieveEmployee.
     * @deprecated
     * 
     * @param  id  Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public RetrieveEmployeeResponse retrieveEmployee(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildRetrieveEmployeeRequest(id);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveEmployeeResponse(context);
    }

    /**
     * RetrieveEmployee.
     * @deprecated
     * 
     * @param  id  Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<RetrieveEmployeeResponse> retrieveEmployeeAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildRetrieveEmployeeRequest(id),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveEmployeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveEmployee.
     */
    private HttpRequest buildRetrieveEmployeeRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/employees/{id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("id",
                new SimpleEntry<Object, Boolean>(id, true));
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
     * @return An object of type RetrieveEmployeeResponse
     */
    private RetrieveEmployeeResponse handleRetrieveEmployeeResponse(
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
        RetrieveEmployeeResponse result = ApiHelper.deserialize(responseBody,
                RetrieveEmployeeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}