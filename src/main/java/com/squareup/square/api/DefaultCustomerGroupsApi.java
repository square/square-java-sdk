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
import com.squareup.square.models.CreateCustomerGroupRequest;
import com.squareup.square.models.CreateCustomerGroupResponse;
import com.squareup.square.models.DeleteCustomerGroupResponse;
import com.squareup.square.models.ListCustomerGroupsResponse;
import com.squareup.square.models.RetrieveCustomerGroupResponse;
import com.squareup.square.models.UpdateCustomerGroupRequest;
import com.squareup.square.models.UpdateCustomerGroupResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCustomerGroupsApi extends BaseApi implements CustomerGroupsApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultCustomerGroupsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultCustomerGroupsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Retrieves the list of customer groups of a business.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     * @return    Returns the ListCustomerGroupsResponse response from the API call
     */
    public ListCustomerGroupsResponse listCustomerGroups(
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListCustomerGroupsRequest(cursor);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListCustomerGroupsResponse(context);
    }

    /**
     * Retrieves the list of customer groups of a business.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     * @return    Returns the ListCustomerGroupsResponse response from the API call 
     */
    public CompletableFuture<ListCustomerGroupsResponse> listCustomerGroupsAsync(
            final String cursor) {
        return makeHttpCallAsync(() -> buildListCustomerGroupsRequest(cursor),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListCustomerGroupsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCustomerGroups
     */
    private HttpRequest buildListCustomerGroupsRequest(
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/customers/groups");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
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
     * Processes the response for listCustomerGroups
     * @return An object of type ListCustomerGroupsResponse
     */
    private ListCustomerGroupsResponse handleListCustomerGroupsResponse(HttpContext context)
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
        ListCustomerGroupsResponse result = ApiHelper.deserialize(responseBody,
                ListCustomerGroupsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a new customer group for a business. 
     * The request must include the `name` value of the group.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerGroupResponse response from the API call
     */
    public CreateCustomerGroupResponse createCustomerGroup(
            final CreateCustomerGroupRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateCustomerGroupRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateCustomerGroupResponse(context);
    }

    /**
     * Creates a new customer group for a business. 
     * The request must include the `name` value of the group.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerGroupResponse response from the API call 
     */
    public CompletableFuture<CreateCustomerGroupResponse> createCustomerGroupAsync(
            final CreateCustomerGroupRequest body) {
        return makeHttpCallAsync(() -> buildCreateCustomerGroupRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateCustomerGroupResponse(context));
    }

    /**
     * Builds the HttpRequest object for createCustomerGroup
     */
    private HttpRequest buildCreateCustomerGroupRequest(
            final CreateCustomerGroupRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/customers/groups");
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
     * Processes the response for createCustomerGroup
     * @return An object of type CreateCustomerGroupResponse
     */
    private CreateCustomerGroupResponse handleCreateCustomerGroupResponse(HttpContext context)
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
        CreateCustomerGroupResponse result = ApiHelper.deserialize(responseBody,
                CreateCustomerGroupResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to delete.
     * @return    Returns the DeleteCustomerGroupResponse response from the API call
     */
    public DeleteCustomerGroupResponse deleteCustomerGroup(
            final String groupId) throws ApiException, IOException {
        HttpRequest request = buildDeleteCustomerGroupRequest(groupId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteCustomerGroupResponse(context);
    }

    /**
     * Deletes a customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to delete.
     * @return    Returns the DeleteCustomerGroupResponse response from the API call 
     */
    public CompletableFuture<DeleteCustomerGroupResponse> deleteCustomerGroupAsync(
            final String groupId) {
        return makeHttpCallAsync(() -> buildDeleteCustomerGroupRequest(groupId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteCustomerGroupResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteCustomerGroup
     */
    private HttpRequest buildDeleteCustomerGroupRequest(
            final String groupId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/customers/groups/{group_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("group_id", groupId);
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
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteCustomerGroup
     * @return An object of type DeleteCustomerGroupResponse
     */
    private DeleteCustomerGroupResponse handleDeleteCustomerGroupResponse(HttpContext context)
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
        DeleteCustomerGroupResponse result = ApiHelper.deserialize(responseBody,
                DeleteCustomerGroupResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a specific customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to retrieve.
     * @return    Returns the RetrieveCustomerGroupResponse response from the API call
     */
    public RetrieveCustomerGroupResponse retrieveCustomerGroup(
            final String groupId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveCustomerGroupRequest(groupId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveCustomerGroupResponse(context);
    }

    /**
     * Retrieves a specific customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to retrieve.
     * @return    Returns the RetrieveCustomerGroupResponse response from the API call 
     */
    public CompletableFuture<RetrieveCustomerGroupResponse> retrieveCustomerGroupAsync(
            final String groupId) {
        return makeHttpCallAsync(() -> buildRetrieveCustomerGroupRequest(groupId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveCustomerGroupResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveCustomerGroup
     */
    private HttpRequest buildRetrieveCustomerGroupRequest(
            final String groupId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/customers/groups/{group_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("group_id", groupId);
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
     * Processes the response for retrieveCustomerGroup
     * @return An object of type RetrieveCustomerGroupResponse
     */
    private RetrieveCustomerGroupResponse handleRetrieveCustomerGroupResponse(HttpContext context)
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
        RetrieveCustomerGroupResponse result = ApiHelper.deserialize(responseBody,
                RetrieveCustomerGroupResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerGroupResponse response from the API call
     */
    public UpdateCustomerGroupResponse updateCustomerGroup(
            final String groupId,
            final UpdateCustomerGroupRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateCustomerGroupRequest(groupId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateCustomerGroupResponse(context);
    }

    /**
     * Updates a customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerGroupResponse response from the API call 
     */
    public CompletableFuture<UpdateCustomerGroupResponse> updateCustomerGroupAsync(
            final String groupId,
            final UpdateCustomerGroupRequest body) {
        return makeHttpCallAsync(() -> buildUpdateCustomerGroupRequest(groupId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateCustomerGroupResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateCustomerGroup
     */
    private HttpRequest buildUpdateCustomerGroupRequest(
            final String groupId,
            final UpdateCustomerGroupRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/customers/groups/{group_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("group_id", groupId);
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
     * Processes the response for updateCustomerGroup
     * @return An object of type UpdateCustomerGroupResponse
     */
    private UpdateCustomerGroupResponse handleUpdateCustomerGroupResponse(HttpContext context)
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
        UpdateCustomerGroupResponse result = ApiHelper.deserialize(responseBody,
                UpdateCustomerGroupResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}