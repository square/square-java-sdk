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

public final class InventoryApi extends BaseApi {
    public InventoryApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public InventoryApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Returns the [InventoryAdjustment](#type-inventoryadjustment) object
     * with the provided `adjustment_id`.
     * @param    adjustmentId    Required parameter: ID of the [InventoryAdjustment](#type-inventoryadjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call
     */
    public RetrieveInventoryAdjustmentResponse retrieveInventoryAdjustment(
            final String adjustmentId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveInventoryAdjustmentRequest(adjustmentId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveInventoryAdjustmentResponse(_context);
    }

    /**
     * Returns the [InventoryAdjustment](#type-inventoryadjustment) object
     * with the provided `adjustment_id`.
     * @param    adjustmentId    Required parameter: ID of the [InventoryAdjustment](#type-inventoryadjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call 
     */
    public CompletableFuture<RetrieveInventoryAdjustmentResponse> retrieveInventoryAdjustmentAsync(
            final String adjustmentId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveInventoryAdjustmentRequest(adjustmentId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveInventoryAdjustmentResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveInventoryAdjustment
     */
    private HttpRequest _buildRetrieveInventoryAdjustmentRequest(
            final String adjustmentId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/inventory/adjustment/{adjustment_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("adjustment_id", adjustmentId);
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
     * Processes the response for retrieveInventoryAdjustment
     * @return An object of type RetrieveInventoryAdjustmentResponse
     */
    private RetrieveInventoryAdjustmentResponse _handleRetrieveInventoryAdjustmentResponse(HttpContext _context)
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
        RetrieveInventoryAdjustmentResponse _result = ApiHelper.deserialize(_responseBody,
                RetrieveInventoryAdjustmentResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Applies adjustments and counts to the provided item quantities.
     * On success: returns the current calculated counts for all objects
     * referenced in the request.
     * On failure: returns a list of related errors.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call
     */
    public BatchChangeInventoryResponse batchChangeInventory(
            final BatchChangeInventoryRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildBatchChangeInventoryRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleBatchChangeInventoryResponse(_context);
    }

    /**
     * Applies adjustments and counts to the provided item quantities.
     * On success: returns the current calculated counts for all objects
     * referenced in the request.
     * On failure: returns a list of related errors.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call 
     */
    public CompletableFuture<BatchChangeInventoryResponse> batchChangeInventoryAsync(
            final BatchChangeInventoryRequest body
    ) {
        return makeHttpCallAsync(() -> _buildBatchChangeInventoryRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleBatchChangeInventoryResponse(_context));
    }

    /**
     * Builds the HttpRequest object for batchChangeInventory
     */
    private HttpRequest _buildBatchChangeInventoryRequest(
            final BatchChangeInventoryRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/inventory/batch-change");
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
     * Processes the response for batchChangeInventory
     * @return An object of type BatchChangeInventoryResponse
     */
    private BatchChangeInventoryResponse _handleBatchChangeInventoryResponse(HttpContext _context)
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
        BatchChangeInventoryResponse _result = ApiHelper.deserialize(_responseBody,
                BatchChangeInventoryResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns historical physical counts and adjustments based on the
     * provided filter criteria.
     * Results are paginated and sorted in ascending order according their
     * `occurred_at` timestamp (oldest first).
     * BatchRetrieveInventoryChanges is a catch-all query endpoint for queries
     * that cannot be handled by other, simpler endpoints.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call
     */
    public BatchRetrieveInventoryChangesResponse batchRetrieveInventoryChanges(
            final BatchRetrieveInventoryChangesRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildBatchRetrieveInventoryChangesRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleBatchRetrieveInventoryChangesResponse(_context);
    }

    /**
     * Returns historical physical counts and adjustments based on the
     * provided filter criteria.
     * Results are paginated and sorted in ascending order according their
     * `occurred_at` timestamp (oldest first).
     * BatchRetrieveInventoryChanges is a catch-all query endpoint for queries
     * that cannot be handled by other, simpler endpoints.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call 
     */
    public CompletableFuture<BatchRetrieveInventoryChangesResponse> batchRetrieveInventoryChangesAsync(
            final BatchRetrieveInventoryChangesRequest body
    ) {
        return makeHttpCallAsync(() -> _buildBatchRetrieveInventoryChangesRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleBatchRetrieveInventoryChangesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for batchRetrieveInventoryChanges
     */
    private HttpRequest _buildBatchRetrieveInventoryChangesRequest(
            final BatchRetrieveInventoryChangesRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/inventory/batch-retrieve-changes");
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
     * Processes the response for batchRetrieveInventoryChanges
     * @return An object of type BatchRetrieveInventoryChangesResponse
     */
    private BatchRetrieveInventoryChangesResponse _handleBatchRetrieveInventoryChangesResponse(HttpContext _context)
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
        BatchRetrieveInventoryChangesResponse _result = ApiHelper.deserialize(_responseBody,
                BatchRetrieveInventoryChangesResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns current counts for the provided
     * [CatalogObject](#type-catalogobject)s at the requested
     * [Location](#type-location)s.
     * Results are paginated and sorted in descending order according to their
     * `calculated_at` timestamp (newest first).
     * When `updated_after` is specified, only counts that have changed since that
     * time (based on the server timestamp for the most recent change) are
     * returned. This allows clients to perform a "sync" operation, for example
     * in response to receiving a Webhook notification.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryCountsResponse response from the API call
     */
    public BatchRetrieveInventoryCountsResponse batchRetrieveInventoryCounts(
            final BatchRetrieveInventoryCountsRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildBatchRetrieveInventoryCountsRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleBatchRetrieveInventoryCountsResponse(_context);
    }

    /**
     * Returns current counts for the provided
     * [CatalogObject](#type-catalogobject)s at the requested
     * [Location](#type-location)s.
     * Results are paginated and sorted in descending order according to their
     * `calculated_at` timestamp (newest first).
     * When `updated_after` is specified, only counts that have changed since that
     * time (based on the server timestamp for the most recent change) are
     * returned. This allows clients to perform a "sync" operation, for example
     * in response to receiving a Webhook notification.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryCountsResponse response from the API call 
     */
    public CompletableFuture<BatchRetrieveInventoryCountsResponse> batchRetrieveInventoryCountsAsync(
            final BatchRetrieveInventoryCountsRequest body
    ) {
        return makeHttpCallAsync(() -> _buildBatchRetrieveInventoryCountsRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleBatchRetrieveInventoryCountsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for batchRetrieveInventoryCounts
     */
    private HttpRequest _buildBatchRetrieveInventoryCountsRequest(
            final BatchRetrieveInventoryCountsRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/inventory/batch-retrieve-counts");
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
     * Processes the response for batchRetrieveInventoryCounts
     * @return An object of type BatchRetrieveInventoryCountsResponse
     */
    private BatchRetrieveInventoryCountsResponse _handleBatchRetrieveInventoryCountsResponse(HttpContext _context)
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
        BatchRetrieveInventoryCountsResponse _result = ApiHelper.deserialize(_responseBody,
                BatchRetrieveInventoryCountsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns the [InventoryPhysicalCount](#type-inventoryphysicalcount)
     * object with the provided `physical_count_id`.
     * @param    physicalCountId    Required parameter: ID of the [InventoryPhysicalCount](#type-inventoryphysicalcount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call
     */
    public RetrieveInventoryPhysicalCountResponse retrieveInventoryPhysicalCount(
            final String physicalCountId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveInventoryPhysicalCountRequest(physicalCountId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveInventoryPhysicalCountResponse(_context);
    }

    /**
     * Returns the [InventoryPhysicalCount](#type-inventoryphysicalcount)
     * object with the provided `physical_count_id`.
     * @param    physicalCountId    Required parameter: ID of the [InventoryPhysicalCount](#type-inventoryphysicalcount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call 
     */
    public CompletableFuture<RetrieveInventoryPhysicalCountResponse> retrieveInventoryPhysicalCountAsync(
            final String physicalCountId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveInventoryPhysicalCountRequest(physicalCountId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveInventoryPhysicalCountResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveInventoryPhysicalCount
     */
    private HttpRequest _buildRetrieveInventoryPhysicalCountRequest(
            final String physicalCountId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/inventory/physical-count/{physical_count_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("physical_count_id", physicalCountId);
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
     * Processes the response for retrieveInventoryPhysicalCount
     * @return An object of type RetrieveInventoryPhysicalCountResponse
     */
    private RetrieveInventoryPhysicalCountResponse _handleRetrieveInventoryPhysicalCountResponse(HttpContext _context)
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
        RetrieveInventoryPhysicalCountResponse _result = ApiHelper.deserialize(_responseBody,
                RetrieveInventoryPhysicalCountResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Retrieves the current calculated stock count for a given
     * [CatalogObject](#type-catalogobject) at a given set of
     * [Location](#type-location)s. Responses are paginated and unsorted.
     * For more sophisticated queries, use a batch endpoint.
     * @param    catalogObjectId    Required parameter: ID of the [CatalogObject](#type-catalogobject) to retrieve.
     * @param    locationIds    Optional parameter: The [Location](#type-location) IDs to look up as a comma-separated list. An empty list queries all locations.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     * @return    Returns the RetrieveInventoryCountResponse response from the API call
     */
    public RetrieveInventoryCountResponse retrieveInventoryCount(
            final String catalogObjectId,
            final String locationIds,
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveInventoryCountRequest(catalogObjectId, locationIds, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveInventoryCountResponse(_context);
    }

    /**
     * Retrieves the current calculated stock count for a given
     * [CatalogObject](#type-catalogobject) at a given set of
     * [Location](#type-location)s. Responses are paginated and unsorted.
     * For more sophisticated queries, use a batch endpoint.
     * @param    catalogObjectId    Required parameter: ID of the [CatalogObject](#type-catalogobject) to retrieve.
     * @param    locationIds    Optional parameter: The [Location](#type-location) IDs to look up as a comma-separated list. An empty list queries all locations.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     * @return    Returns the RetrieveInventoryCountResponse response from the API call 
     */
    public CompletableFuture<RetrieveInventoryCountResponse> retrieveInventoryCountAsync(
            final String catalogObjectId,
            final String locationIds,
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveInventoryCountRequest(catalogObjectId, locationIds, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveInventoryCountResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveInventoryCount
     */
    private HttpRequest _buildRetrieveInventoryCountRequest(
            final String catalogObjectId,
            final String locationIds,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/inventory/{catalog_object_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("catalog_object_id", catalogObjectId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("location_ids", locationIds);
        _queryParameters.put("cursor", cursor);
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
     * Processes the response for retrieveInventoryCount
     * @return An object of type RetrieveInventoryCountResponse
     */
    private RetrieveInventoryCountResponse _handleRetrieveInventoryCountResponse(HttpContext _context)
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
        RetrieveInventoryCountResponse _result = ApiHelper.deserialize(_responseBody,
                RetrieveInventoryCountResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a set of physical counts and inventory adjustments for the
     * provided [CatalogObject](#type-catalogobject) at the requested
     * [Location](#type-location)s.
     * Results are paginated and sorted in descending order according to their
     * `occurred_at` timestamp (newest first).
     * There are no limits on how far back the caller can page. This endpoint is
     * useful when displaying recent changes for a specific item. For more
     * sophisticated queries, use a batch endpoint.
     * @param    catalogObjectId    Required parameter: ID of the [CatalogObject](#type-catalogobject) to retrieve.
     * @param    locationIds    Optional parameter: The [Location](#type-location) IDs to look up as a comma-separated list. An empty list queries all locations.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     * @return    Returns the RetrieveInventoryChangesResponse response from the API call
     */
    public RetrieveInventoryChangesResponse retrieveInventoryChanges(
            final String catalogObjectId,
            final String locationIds,
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveInventoryChangesRequest(catalogObjectId, locationIds, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveInventoryChangesResponse(_context);
    }

    /**
     * Returns a set of physical counts and inventory adjustments for the
     * provided [CatalogObject](#type-catalogobject) at the requested
     * [Location](#type-location)s.
     * Results are paginated and sorted in descending order according to their
     * `occurred_at` timestamp (newest first).
     * There are no limits on how far back the caller can page. This endpoint is
     * useful when displaying recent changes for a specific item. For more
     * sophisticated queries, use a batch endpoint.
     * @param    catalogObjectId    Required parameter: ID of the [CatalogObject](#type-catalogobject) to retrieve.
     * @param    locationIds    Optional parameter: The [Location](#type-location) IDs to look up as a comma-separated list. An empty list queries all locations.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     * @return    Returns the RetrieveInventoryChangesResponse response from the API call 
     */
    public CompletableFuture<RetrieveInventoryChangesResponse> retrieveInventoryChangesAsync(
            final String catalogObjectId,
            final String locationIds,
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveInventoryChangesRequest(catalogObjectId, locationIds, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveInventoryChangesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveInventoryChanges
     */
    private HttpRequest _buildRetrieveInventoryChangesRequest(
            final String catalogObjectId,
            final String locationIds,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/inventory/{catalog_object_id}/changes");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("catalog_object_id", catalogObjectId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("location_ids", locationIds);
        _queryParameters.put("cursor", cursor);
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
     * Processes the response for retrieveInventoryChanges
     * @return An object of type RetrieveInventoryChangesResponse
     */
    private RetrieveInventoryChangesResponse _handleRetrieveInventoryChangesResponse(HttpContext _context)
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
        RetrieveInventoryChangesResponse _result = ApiHelper.deserialize(_responseBody,
                RetrieveInventoryChangesResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
