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
import com.squareup.square.models.BulkCreateTeamMembersRequest;
import com.squareup.square.models.BulkCreateTeamMembersResponse;
import com.squareup.square.models.BulkUpdateTeamMembersRequest;
import com.squareup.square.models.BulkUpdateTeamMembersResponse;
import com.squareup.square.models.CreateTeamMemberRequest;
import com.squareup.square.models.CreateTeamMemberResponse;
import com.squareup.square.models.RetrieveTeamMemberResponse;
import com.squareup.square.models.RetrieveWageSettingResponse;
import com.squareup.square.models.SearchTeamMembersRequest;
import com.squareup.square.models.SearchTeamMembersResponse;
import com.squareup.square.models.UpdateTeamMemberRequest;
import com.squareup.square.models.UpdateTeamMemberResponse;
import com.squareup.square.models.UpdateWageSettingRequest;
import com.squareup.square.models.UpdateWageSettingResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultTeamApi extends BaseApi implements TeamApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultTeamApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultTeamApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Creates a single `TeamMember` object. The `TeamMember` will be returned on successful creates.
     * You must provide the following values in your request to this endpoint:
     * - `first_name`
     * - `last_name`
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#createteammember).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateTeamMemberResponse response from the API call
     */
    public CreateTeamMemberResponse createTeamMember(
            final CreateTeamMemberRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateTeamMemberRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateTeamMemberResponse(context);
    }

    /**
     * Creates a single `TeamMember` object. The `TeamMember` will be returned on successful creates.
     * You must provide the following values in your request to this endpoint:
     * - `first_name`
     * - `last_name`
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#createteammember).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateTeamMemberResponse response from the API call 
     */
    public CompletableFuture<CreateTeamMemberResponse> createTeamMemberAsync(
            final CreateTeamMemberRequest body) {
        return makeHttpCallAsync(() -> buildCreateTeamMemberRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateTeamMemberResponse(context));
    }

    /**
     * Builds the HttpRequest object for createTeamMember
     */
    private HttpRequest buildCreateTeamMemberRequest(
            final CreateTeamMemberRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/team-members");
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
     * Processes the response for createTeamMember
     * @return An object of type CreateTeamMemberResponse
     */
    private CreateTeamMemberResponse handleCreateTeamMemberResponse(HttpContext context)
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
        CreateTeamMemberResponse result = ApiHelper.deserialize(responseBody,
                CreateTeamMemberResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates multiple `TeamMember` objects. The created `TeamMember` objects will be returned on successful creates.
     * This process is non-transactional and will process as much of the request as is possible. If one of the creates in
     * the request cannot be successfully processed, the request will NOT be marked as failed, but the body of the response
     * will contain explicit error information for this particular create.
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#bulkcreateteammembers).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BulkCreateTeamMembersResponse response from the API call
     */
    public BulkCreateTeamMembersResponse bulkCreateTeamMembers(
            final BulkCreateTeamMembersRequest body) throws ApiException, IOException {
        HttpRequest request = buildBulkCreateTeamMembersRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleBulkCreateTeamMembersResponse(context);
    }

    /**
     * Creates multiple `TeamMember` objects. The created `TeamMember` objects will be returned on successful creates.
     * This process is non-transactional and will process as much of the request as is possible. If one of the creates in
     * the request cannot be successfully processed, the request will NOT be marked as failed, but the body of the response
     * will contain explicit error information for this particular create.
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#bulkcreateteammembers).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BulkCreateTeamMembersResponse response from the API call 
     */
    public CompletableFuture<BulkCreateTeamMembersResponse> bulkCreateTeamMembersAsync(
            final BulkCreateTeamMembersRequest body) {
        return makeHttpCallAsync(() -> buildBulkCreateTeamMembersRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleBulkCreateTeamMembersResponse(context));
    }

    /**
     * Builds the HttpRequest object for bulkCreateTeamMembers
     */
    private HttpRequest buildBulkCreateTeamMembersRequest(
            final BulkCreateTeamMembersRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/team-members/bulk-create");
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
     * Processes the response for bulkCreateTeamMembers
     * @return An object of type BulkCreateTeamMembersResponse
     */
    private BulkCreateTeamMembersResponse handleBulkCreateTeamMembersResponse(HttpContext context)
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
        BulkCreateTeamMembersResponse result = ApiHelper.deserialize(responseBody,
                BulkCreateTeamMembersResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates multiple `TeamMember` objects. The updated `TeamMember` objects will be returned on successful updates.
     * This process is non-transactional and will process as much of the request as is possible. If one of the updates in
     * the request cannot be successfully processed, the request will NOT be marked as failed, but the body of the response
     * will contain explicit error information for this particular update.
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#bulkupdateteammembers).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateTeamMembersResponse response from the API call
     */
    public BulkUpdateTeamMembersResponse bulkUpdateTeamMembers(
            final BulkUpdateTeamMembersRequest body) throws ApiException, IOException {
        HttpRequest request = buildBulkUpdateTeamMembersRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleBulkUpdateTeamMembersResponse(context);
    }

    /**
     * Updates multiple `TeamMember` objects. The updated `TeamMember` objects will be returned on successful updates.
     * This process is non-transactional and will process as much of the request as is possible. If one of the updates in
     * the request cannot be successfully processed, the request will NOT be marked as failed, but the body of the response
     * will contain explicit error information for this particular update.
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#bulkupdateteammembers).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateTeamMembersResponse response from the API call 
     */
    public CompletableFuture<BulkUpdateTeamMembersResponse> bulkUpdateTeamMembersAsync(
            final BulkUpdateTeamMembersRequest body) {
        return makeHttpCallAsync(() -> buildBulkUpdateTeamMembersRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleBulkUpdateTeamMembersResponse(context));
    }

    /**
     * Builds the HttpRequest object for bulkUpdateTeamMembers
     */
    private HttpRequest buildBulkUpdateTeamMembersRequest(
            final BulkUpdateTeamMembersRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/team-members/bulk-update");
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
     * Processes the response for bulkUpdateTeamMembers
     * @return An object of type BulkUpdateTeamMembersResponse
     */
    private BulkUpdateTeamMembersResponse handleBulkUpdateTeamMembersResponse(HttpContext context)
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
        BulkUpdateTeamMembersResponse result = ApiHelper.deserialize(responseBody,
                BulkUpdateTeamMembersResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a paginated list of `TeamMember` objects for a business.
     * The list to be returned can be filtered by:
     * - location IDs **and**
     * - `is_active`
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchTeamMembersResponse response from the API call
     */
    public SearchTeamMembersResponse searchTeamMembers(
            final SearchTeamMembersRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchTeamMembersRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleSearchTeamMembersResponse(context);
    }

    /**
     * Returns a paginated list of `TeamMember` objects for a business.
     * The list to be returned can be filtered by:
     * - location IDs **and**
     * - `is_active`
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchTeamMembersResponse response from the API call 
     */
    public CompletableFuture<SearchTeamMembersResponse> searchTeamMembersAsync(
            final SearchTeamMembersRequest body) {
        return makeHttpCallAsync(() -> buildSearchTeamMembersRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleSearchTeamMembersResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchTeamMembers
     */
    private HttpRequest buildSearchTeamMembersRequest(
            final SearchTeamMembersRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/team-members/search");
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
     * Processes the response for searchTeamMembers
     * @return An object of type SearchTeamMembersResponse
     */
    private SearchTeamMembersResponse handleSearchTeamMembersResponse(HttpContext context)
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
        SearchTeamMembersResponse result = ApiHelper.deserialize(responseBody,
                SearchTeamMembersResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieve a `TeamMember` object for the given `TeamMember.id`
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#retrieveteammember).
     * @param    teamMemberId    Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberResponse response from the API call
     */
    public RetrieveTeamMemberResponse retrieveTeamMember(
            final String teamMemberId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveTeamMemberRequest(teamMemberId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveTeamMemberResponse(context);
    }

    /**
     * Retrieve a `TeamMember` object for the given `TeamMember.id`
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#retrieveteammember).
     * @param    teamMemberId    Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberResponse response from the API call 
     */
    public CompletableFuture<RetrieveTeamMemberResponse> retrieveTeamMemberAsync(
            final String teamMemberId) {
        return makeHttpCallAsync(() -> buildRetrieveTeamMemberRequest(teamMemberId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveTeamMemberResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveTeamMember
     */
    private HttpRequest buildRetrieveTeamMemberRequest(
            final String teamMemberId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/team-members/{team_member_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("team_member_id", teamMemberId);
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
     * Processes the response for retrieveTeamMember
     * @return An object of type RetrieveTeamMemberResponse
     */
    private RetrieveTeamMemberResponse handleRetrieveTeamMemberResponse(HttpContext context)
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
        RetrieveTeamMemberResponse result = ApiHelper.deserialize(responseBody,
                RetrieveTeamMemberResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a single `TeamMember` object. The `TeamMember` will be returned on successful updates.
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#updateteammember).
     * @param    teamMemberId    Required parameter: The ID of the team member to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateTeamMemberResponse response from the API call
     */
    public UpdateTeamMemberResponse updateTeamMember(
            final String teamMemberId,
            final UpdateTeamMemberRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateTeamMemberRequest(teamMemberId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateTeamMemberResponse(context);
    }

    /**
     * Updates a single `TeamMember` object. The `TeamMember` will be returned on successful updates.
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#updateteammember).
     * @param    teamMemberId    Required parameter: The ID of the team member to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateTeamMemberResponse response from the API call 
     */
    public CompletableFuture<UpdateTeamMemberResponse> updateTeamMemberAsync(
            final String teamMemberId,
            final UpdateTeamMemberRequest body) {
        return makeHttpCallAsync(() -> buildUpdateTeamMemberRequest(teamMemberId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateTeamMemberResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateTeamMember
     */
    private HttpRequest buildUpdateTeamMemberRequest(
            final String teamMemberId,
            final UpdateTeamMemberRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/team-members/{team_member_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("team_member_id", teamMemberId);
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
     * Processes the response for updateTeamMember
     * @return An object of type UpdateTeamMemberResponse
     */
    private UpdateTeamMemberResponse handleUpdateTeamMemberResponse(HttpContext context)
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
        UpdateTeamMemberResponse result = ApiHelper.deserialize(responseBody,
                UpdateTeamMemberResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieve a `WageSetting` object for a team member specified
     * by `TeamMember.id`.
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#retrievewagesetting).
     * @param    teamMemberId    Required parameter: The ID of the team member to retrieve wage setting for
     * @return    Returns the RetrieveWageSettingResponse response from the API call
     */
    public RetrieveWageSettingResponse retrieveWageSetting(
            final String teamMemberId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveWageSettingRequest(teamMemberId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveWageSettingResponse(context);
    }

    /**
     * Retrieve a `WageSetting` object for a team member specified
     * by `TeamMember.id`.
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#retrievewagesetting).
     * @param    teamMemberId    Required parameter: The ID of the team member to retrieve wage setting for
     * @return    Returns the RetrieveWageSettingResponse response from the API call 
     */
    public CompletableFuture<RetrieveWageSettingResponse> retrieveWageSettingAsync(
            final String teamMemberId) {
        return makeHttpCallAsync(() -> buildRetrieveWageSettingRequest(teamMemberId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveWageSettingResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveWageSetting
     */
    private HttpRequest buildRetrieveWageSettingRequest(
            final String teamMemberId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/team-members/{team_member_id}/wage-setting");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("team_member_id", teamMemberId);
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
     * Processes the response for retrieveWageSetting
     * @return An object of type RetrieveWageSettingResponse
     */
    private RetrieveWageSettingResponse handleRetrieveWageSettingResponse(HttpContext context)
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
        RetrieveWageSettingResponse result = ApiHelper.deserialize(responseBody,
                RetrieveWageSettingResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates or updates a `WageSetting` object. The object is created if a
     * `WageSetting` with the specified `team_member_id` does not exist. Otherwise,
     * it fully replaces the `WageSetting` object for the team member.
     * The `WageSetting` will be returned upon successful update.
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#updatewagesetting).
     * @param    teamMemberId    Required parameter: The ID of the team member to update the `WageSetting` object for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateWageSettingResponse response from the API call
     */
    public UpdateWageSettingResponse updateWageSetting(
            final String teamMemberId,
            final UpdateWageSettingRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateWageSettingRequest(teamMemberId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateWageSettingResponse(context);
    }

    /**
     * Creates or updates a `WageSetting` object. The object is created if a
     * `WageSetting` with the specified `team_member_id` does not exist. Otherwise,
     * it fully replaces the `WageSetting` object for the team member.
     * The `WageSetting` will be returned upon successful update.
     * Learn about [Troubleshooting the Teams API](https://developer.squareup.com/docs/docs/team/troubleshooting#updatewagesetting).
     * @param    teamMemberId    Required parameter: The ID of the team member to update the `WageSetting` object for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateWageSettingResponse response from the API call 
     */
    public CompletableFuture<UpdateWageSettingResponse> updateWageSettingAsync(
            final String teamMemberId,
            final UpdateWageSettingRequest body) {
        return makeHttpCallAsync(() -> buildUpdateWageSettingRequest(teamMemberId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateWageSettingResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateWageSetting
     */
    private HttpRequest buildUpdateWageSettingRequest(
            final String teamMemberId,
            final UpdateWageSettingRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/team-members/{team_member_id}/wage-setting");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("team_member_id", teamMemberId);
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
     * Processes the response for updateWageSetting
     * @return An object of type UpdateWageSettingResponse
     */
    private UpdateWageSettingResponse handleUpdateWageSettingResponse(HttpContext context)
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
        UpdateWageSettingResponse result = ApiHelper.deserialize(responseBody,
                UpdateWageSettingResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}