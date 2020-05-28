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
import com.squareup.square.models.CreateLocationRequest;
import com.squareup.square.models.CreateLocationResponse;
import com.squareup.square.models.ListLocationsResponse;
import com.squareup.square.models.RetrieveLocationResponse;
import com.squareup.square.models.UpdateLocationRequest;
import com.squareup.square.models.UpdateLocationResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultLocationsApi extends BaseApi implements LocationsApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultLocationsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultLocationsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Provides information of all locations of a business.
     * Most other Connect API endpoints have a required `location_id` path parameter.
     * The `id` field of the [`Location`](#type-location) objects returned by this
     * endpoint correspond to that `location_id` parameter.
     * @return    Returns the ListLocationsResponse response from the API call
     */
    public ListLocationsResponse listLocations() throws ApiException, IOException {
        HttpRequest request = buildListLocationsRequest();
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListLocationsResponse(context);
    }

    /**
     * Provides information of all locations of a business.
     * Most other Connect API endpoints have a required `location_id` path parameter.
     * The `id` field of the [`Location`](#type-location) objects returned by this
     * endpoint correspond to that `location_id` parameter.
     * @return    Returns the ListLocationsResponse response from the API call 
     */
    public CompletableFuture<ListLocationsResponse> listLocationsAsync() {
        return makeHttpCallAsync(() -> buildListLocationsRequest(),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListLocationsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listLocations
     */
    private HttpRequest buildListLocationsRequest() {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/locations");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-05-28");
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
     * Processes the response for listLocations
     * @return An object of type ListLocationsResponse
     */
    private ListLocationsResponse handleListLocationsResponse(HttpContext context)
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
        ListLocationsResponse result = ApiHelper.deserialize(responseBody,
                ListLocationsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a location.
     * For more information about locations, see [Locations API Overview](https://developer.squareup.com/docs/locations-api).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateLocationResponse response from the API call
     */
    public CreateLocationResponse createLocation(
            final CreateLocationRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateLocationRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateLocationResponse(context);
    }

    /**
     * Creates a location.
     * For more information about locations, see [Locations API Overview](https://developer.squareup.com/docs/locations-api).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateLocationResponse response from the API call 
     */
    public CompletableFuture<CreateLocationResponse> createLocationAsync(
            final CreateLocationRequest body) {
        return makeHttpCallAsync(() -> buildCreateLocationRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateLocationResponse(context));
    }

    /**
     * Builds the HttpRequest object for createLocation
     */
    private HttpRequest buildCreateLocationRequest(
            final CreateLocationRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/locations");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-05-28");
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
     * Processes the response for createLocation
     * @return An object of type CreateLocationResponse
     */
    private CreateLocationResponse handleCreateLocationResponse(HttpContext context)
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
        CreateLocationResponse result = ApiHelper.deserialize(responseBody,
                CreateLocationResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves details of a location.
     * @param    locationId    Required parameter: The ID of the location to retrieve.
     * @return    Returns the RetrieveLocationResponse response from the API call
     */
    public RetrieveLocationResponse retrieveLocation(
            final String locationId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveLocationRequest(locationId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveLocationResponse(context);
    }

    /**
     * Retrieves details of a location.
     * @param    locationId    Required parameter: The ID of the location to retrieve.
     * @return    Returns the RetrieveLocationResponse response from the API call 
     */
    public CompletableFuture<RetrieveLocationResponse> retrieveLocationAsync(
            final String locationId) {
        return makeHttpCallAsync(() -> buildRetrieveLocationRequest(locationId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveLocationResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveLocation
     */
    private HttpRequest buildRetrieveLocationRequest(
            final String locationId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/locations/{location_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-05-28");
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
     * Processes the response for retrieveLocation
     * @return An object of type RetrieveLocationResponse
     */
    private RetrieveLocationResponse handleRetrieveLocationResponse(HttpContext context)
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
        RetrieveLocationResponse result = ApiHelper.deserialize(responseBody,
                RetrieveLocationResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a location.
     * @param    locationId    Required parameter: The ID of the location to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationResponse response from the API call
     */
    public UpdateLocationResponse updateLocation(
            final String locationId,
            final UpdateLocationRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateLocationRequest(locationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateLocationResponse(context);
    }

    /**
     * Updates a location.
     * @param    locationId    Required parameter: The ID of the location to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationResponse response from the API call 
     */
    public CompletableFuture<UpdateLocationResponse> updateLocationAsync(
            final String locationId,
            final UpdateLocationRequest body) {
        return makeHttpCallAsync(() -> buildUpdateLocationRequest(locationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateLocationResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateLocation
     */
    private HttpRequest buildUpdateLocationRequest(
            final String locationId,
            final UpdateLocationRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/locations/{location_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-05-28");
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
     * Processes the response for updateLocation
     * @return An object of type UpdateLocationResponse
     */
    private UpdateLocationResponse handleUpdateLocationResponse(HttpContext context)
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
        UpdateLocationResponse result = ApiHelper.deserialize(responseBody,
                UpdateLocationResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}