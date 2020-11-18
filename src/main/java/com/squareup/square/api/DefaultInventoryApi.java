
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
import com.squareup.square.models.BatchChangeInventoryRequest;
import com.squareup.square.models.BatchChangeInventoryResponse;
import com.squareup.square.models.BatchRetrieveInventoryChangesRequest;
import com.squareup.square.models.BatchRetrieveInventoryChangesResponse;
import com.squareup.square.models.BatchRetrieveInventoryCountsRequest;
import com.squareup.square.models.BatchRetrieveInventoryCountsResponse;
import com.squareup.square.models.RetrieveInventoryAdjustmentResponse;
import com.squareup.square.models.RetrieveInventoryChangesResponse;
import com.squareup.square.models.RetrieveInventoryCountResponse;
import com.squareup.square.models.RetrieveInventoryPhysicalCountResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultInventoryApi extends BaseApi implements InventoryApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultInventoryApi(Configuration config, HttpClient httpClient,
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
    public DefaultInventoryApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Returns the [InventoryAdjustment](#type-inventoryadjustment) object with the provided
     * `adjustment_id`.
     * @param  adjustmentId  Required parameter: ID of the
     *         [InventoryAdjustment](#type-inventoryadjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveInventoryAdjustmentResponse retrieveInventoryAdjustment(
            final String adjustmentId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveInventoryAdjustmentRequest(adjustmentId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveInventoryAdjustmentResponse(context);
    }

    /**
     * Returns the [InventoryAdjustment](#type-inventoryadjustment) object with the provided
     * `adjustment_id`.
     * @param  adjustmentId  Required parameter: ID of the
     *         [InventoryAdjustment](#type-inventoryadjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call
     */
    public CompletableFuture<RetrieveInventoryAdjustmentResponse> retrieveInventoryAdjustmentAsync(
            final String adjustmentId) {
        return makeHttpCallAsync(() -> buildRetrieveInventoryAdjustmentRequest(adjustmentId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleRetrieveInventoryAdjustmentResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveInventoryAdjustment.
     */
    private HttpRequest buildRetrieveInventoryAdjustmentRequest(
            final String adjustmentId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/inventory/adjustment/{adjustment_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("adjustment_id",
                new SimpleEntry<Object, Boolean>(adjustmentId, true));
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
     * Processes the response for retrieveInventoryAdjustment.
     * @return An object of type RetrieveInventoryAdjustmentResponse
     */
    private RetrieveInventoryAdjustmentResponse handleRetrieveInventoryAdjustmentResponse(
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
        RetrieveInventoryAdjustmentResponse result = ApiHelper.deserialize(responseBody,
                RetrieveInventoryAdjustmentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Applies adjustments and counts to the provided item quantities. On success: returns the
     * current calculated counts for all objects referenced in the request. On failure: returns a
     * list of related errors.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BatchChangeInventoryResponse batchChangeInventory(
            final BatchChangeInventoryRequest body) throws ApiException, IOException {
        HttpRequest request = buildBatchChangeInventoryRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleBatchChangeInventoryResponse(context);
    }

    /**
     * Applies adjustments and counts to the provided item quantities. On success: returns the
     * current calculated counts for all objects referenced in the request. On failure: returns a
     * list of related errors.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call
     */
    public CompletableFuture<BatchChangeInventoryResponse> batchChangeInventoryAsync(
            final BatchChangeInventoryRequest body) {
        return makeHttpCallAsync(() -> buildBatchChangeInventoryRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleBatchChangeInventoryResponse(context));
    }

    /**
     * Builds the HttpRequest object for batchChangeInventory.
     */
    private HttpRequest buildBatchChangeInventoryRequest(
            final BatchChangeInventoryRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/inventory/batch-change");

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
     * Processes the response for batchChangeInventory.
     * @return An object of type BatchChangeInventoryResponse
     */
    private BatchChangeInventoryResponse handleBatchChangeInventoryResponse(
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
        BatchChangeInventoryResponse result = ApiHelper.deserialize(responseBody,
                BatchChangeInventoryResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns historical physical counts and adjustments based on the provided filter criteria.
     * Results are paginated and sorted in ascending order according their `occurred_at` timestamp
     * (oldest first). BatchRetrieveInventoryChanges is a catch-all query endpoint for queries that
     * cannot be handled by other, simpler endpoints.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BatchRetrieveInventoryChangesResponse batchRetrieveInventoryChanges(
            final BatchRetrieveInventoryChangesRequest body) throws ApiException, IOException {
        HttpRequest request = buildBatchRetrieveInventoryChangesRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleBatchRetrieveInventoryChangesResponse(context);
    }

    /**
     * Returns historical physical counts and adjustments based on the provided filter criteria.
     * Results are paginated and sorted in ascending order according their `occurred_at` timestamp
     * (oldest first). BatchRetrieveInventoryChanges is a catch-all query endpoint for queries that
     * cannot be handled by other, simpler endpoints.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call
     */
    public CompletableFuture<BatchRetrieveInventoryChangesResponse> batchRetrieveInventoryChangesAsync(
            final BatchRetrieveInventoryChangesRequest body) {
        return makeHttpCallAsync(() -> buildBatchRetrieveInventoryChangesRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleBatchRetrieveInventoryChangesResponse(context));
    }

    /**
     * Builds the HttpRequest object for batchRetrieveInventoryChanges.
     */
    private HttpRequest buildBatchRetrieveInventoryChangesRequest(
            final BatchRetrieveInventoryChangesRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/inventory/batch-retrieve-changes");

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
     * Processes the response for batchRetrieveInventoryChanges.
     * @return An object of type BatchRetrieveInventoryChangesResponse
     */
    private BatchRetrieveInventoryChangesResponse handleBatchRetrieveInventoryChangesResponse(
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
        BatchRetrieveInventoryChangesResponse result = ApiHelper.deserialize(responseBody,
                BatchRetrieveInventoryChangesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns current counts for the provided [CatalogObject](#type-catalogobject)s at the
     * requested [Location](#type-location)s. Results are paginated and sorted in descending order
     * according to their `calculated_at` timestamp (newest first). When `updated_after` is
     * specified, only counts that have changed since that time (based on the server timestamp for
     * the most recent change) are returned. This allows clients to perform a "sync" operation, for
     * example in response to receiving a Webhook notification.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryCountsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BatchRetrieveInventoryCountsResponse batchRetrieveInventoryCounts(
            final BatchRetrieveInventoryCountsRequest body) throws ApiException, IOException {
        HttpRequest request = buildBatchRetrieveInventoryCountsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleBatchRetrieveInventoryCountsResponse(context);
    }

    /**
     * Returns current counts for the provided [CatalogObject](#type-catalogobject)s at the
     * requested [Location](#type-location)s. Results are paginated and sorted in descending order
     * according to their `calculated_at` timestamp (newest first). When `updated_after` is
     * specified, only counts that have changed since that time (based on the server timestamp for
     * the most recent change) are returned. This allows clients to perform a "sync" operation, for
     * example in response to receiving a Webhook notification.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryCountsResponse response from the API call
     */
    public CompletableFuture<BatchRetrieveInventoryCountsResponse> batchRetrieveInventoryCountsAsync(
            final BatchRetrieveInventoryCountsRequest body) {
        return makeHttpCallAsync(() -> buildBatchRetrieveInventoryCountsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleBatchRetrieveInventoryCountsResponse(context));
    }

    /**
     * Builds the HttpRequest object for batchRetrieveInventoryCounts.
     */
    private HttpRequest buildBatchRetrieveInventoryCountsRequest(
            final BatchRetrieveInventoryCountsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/inventory/batch-retrieve-counts");

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
     * Processes the response for batchRetrieveInventoryCounts.
     * @return An object of type BatchRetrieveInventoryCountsResponse
     */
    private BatchRetrieveInventoryCountsResponse handleBatchRetrieveInventoryCountsResponse(
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
        BatchRetrieveInventoryCountsResponse result = ApiHelper.deserialize(responseBody,
                BatchRetrieveInventoryCountsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns the [InventoryPhysicalCount](#type-inventoryphysicalcount) object with the provided
     * `physical_count_id`.
     * @param  physicalCountId  Required parameter: ID of the
     *         [InventoryPhysicalCount](#type-inventoryphysicalcount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveInventoryPhysicalCountResponse retrieveInventoryPhysicalCount(
            final String physicalCountId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveInventoryPhysicalCountRequest(physicalCountId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveInventoryPhysicalCountResponse(context);
    }

    /**
     * Returns the [InventoryPhysicalCount](#type-inventoryphysicalcount) object with the provided
     * `physical_count_id`.
     * @param  physicalCountId  Required parameter: ID of the
     *         [InventoryPhysicalCount](#type-inventoryphysicalcount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call
     */
    public CompletableFuture<RetrieveInventoryPhysicalCountResponse> retrieveInventoryPhysicalCountAsync(
            final String physicalCountId) {
        return makeHttpCallAsync(() -> buildRetrieveInventoryPhysicalCountRequest(physicalCountId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleRetrieveInventoryPhysicalCountResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveInventoryPhysicalCount.
     */
    private HttpRequest buildRetrieveInventoryPhysicalCountRequest(
            final String physicalCountId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/inventory/physical-count/{physical_count_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("physical_count_id",
                new SimpleEntry<Object, Boolean>(physicalCountId, true));
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
     * Processes the response for retrieveInventoryPhysicalCount.
     * @return An object of type RetrieveInventoryPhysicalCountResponse
     */
    private RetrieveInventoryPhysicalCountResponse handleRetrieveInventoryPhysicalCountResponse(
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
        RetrieveInventoryPhysicalCountResponse result = ApiHelper.deserialize(responseBody,
                RetrieveInventoryPhysicalCountResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves the current calculated stock count for a given [CatalogObject](#type-catalogobject)
     * at a given set of [Location](#type-location)s. Responses are paginated and unsorted. For more
     * sophisticated queries, use a batch endpoint.
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject](#type-catalogobject)
     *         to retrieve.
     * @param  locationIds  Optional parameter: The [Location](#type-location) IDs to look up as a
     *         comma-separated list. An empty list queries all locations.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @return    Returns the RetrieveInventoryCountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveInventoryCountResponse retrieveInventoryCount(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildRetrieveInventoryCountRequest(catalogObjectId, locationIds,
                cursor);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveInventoryCountResponse(context);
    }

    /**
     * Retrieves the current calculated stock count for a given [CatalogObject](#type-catalogobject)
     * at a given set of [Location](#type-location)s. Responses are paginated and unsorted. For more
     * sophisticated queries, use a batch endpoint.
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject](#type-catalogobject)
     *         to retrieve.
     * @param  locationIds  Optional parameter: The [Location](#type-location) IDs to look up as a
     *         comma-separated list. An empty list queries all locations.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @return    Returns the RetrieveInventoryCountResponse response from the API call
     */
    public CompletableFuture<RetrieveInventoryCountResponse> retrieveInventoryCountAsync(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) {
        return makeHttpCallAsync(() -> buildRetrieveInventoryCountRequest(catalogObjectId,
                locationIds, cursor),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleRetrieveInventoryCountResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveInventoryCount.
     */
    private HttpRequest buildRetrieveInventoryCountRequest(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/inventory/{catalog_object_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("catalog_object_id",
                new SimpleEntry<Object, Boolean>(catalogObjectId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("location_ids", locationIds);
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
     * Processes the response for retrieveInventoryCount.
     * @return An object of type RetrieveInventoryCountResponse
     */
    private RetrieveInventoryCountResponse handleRetrieveInventoryCountResponse(
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
        RetrieveInventoryCountResponse result = ApiHelper.deserialize(responseBody,
                RetrieveInventoryCountResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a set of physical counts and inventory adjustments for the provided
     * [CatalogObject](#type-catalogobject) at the requested [Location](#type-location)s. Results
     * are paginated and sorted in descending order according to their `occurred_at` timestamp
     * (newest first). There are no limits on how far back the caller can page. This endpoint can be
     * used to display recent changes for a specific item. For more sophisticated queries, use a
     * batch endpoint.
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject](#type-catalogobject)
     *         to retrieve.
     * @param  locationIds  Optional parameter: The [Location](#type-location) IDs to look up as a
     *         comma-separated list. An empty list queries all locations.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @return    Returns the RetrieveInventoryChangesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveInventoryChangesResponse retrieveInventoryChanges(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildRetrieveInventoryChangesRequest(catalogObjectId, locationIds,
                cursor);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveInventoryChangesResponse(context);
    }

    /**
     * Returns a set of physical counts and inventory adjustments for the provided
     * [CatalogObject](#type-catalogobject) at the requested [Location](#type-location)s. Results
     * are paginated and sorted in descending order according to their `occurred_at` timestamp
     * (newest first). There are no limits on how far back the caller can page. This endpoint can be
     * used to display recent changes for a specific item. For more sophisticated queries, use a
     * batch endpoint.
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject](#type-catalogobject)
     *         to retrieve.
     * @param  locationIds  Optional parameter: The [Location](#type-location) IDs to look up as a
     *         comma-separated list. An empty list queries all locations.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @return    Returns the RetrieveInventoryChangesResponse response from the API call
     */
    public CompletableFuture<RetrieveInventoryChangesResponse> retrieveInventoryChangesAsync(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) {
        return makeHttpCallAsync(() -> buildRetrieveInventoryChangesRequest(catalogObjectId,
                locationIds, cursor),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleRetrieveInventoryChangesResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveInventoryChanges.
     */
    private HttpRequest buildRetrieveInventoryChangesRequest(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/inventory/{catalog_object_id}/changes");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("catalog_object_id",
                new SimpleEntry<Object, Boolean>(catalogObjectId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("location_ids", locationIds);
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
     * Processes the response for retrieveInventoryChanges.
     * @return An object of type RetrieveInventoryChangesResponse
     */
    private RetrieveInventoryChangesResponse handleRetrieveInventoryChangesResponse(
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
        RetrieveInventoryChangesResponse result = ApiHelper.deserialize(responseBody,
                RetrieveInventoryChangesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}