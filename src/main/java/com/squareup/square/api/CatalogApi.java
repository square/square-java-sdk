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
import com.squareup.square.http.request.MultipartFileWrapper;
import com.squareup.square.http.request.MultipartWrapper;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.*;

public final class CatalogApi extends BaseApi {
    public CatalogApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public CatalogApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Deletes a set of [CatalogItem](#type-catalogitem)s based on the
     * provided list of target IDs and returns a set of successfully deleted IDs in
     * the response. Deletion is a cascading event such that all children of the
     * targeted object are also deleted. For example, deleting a CatalogItem will
     * also delete all of its [CatalogItemVariation](#type-catalogitemvariation)
     * children.
     * `BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted
     * IDs can be deleted. The response will only include IDs that were
     * actually deleted.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchDeleteCatalogObjectsResponse response from the API call
     */
    public BatchDeleteCatalogObjectsResponse batchDeleteCatalogObjects(
            final BatchDeleteCatalogObjectsRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildBatchDeleteCatalogObjectsRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleBatchDeleteCatalogObjectsResponse(_context);
    }

    /**
     * Deletes a set of [CatalogItem](#type-catalogitem)s based on the
     * provided list of target IDs and returns a set of successfully deleted IDs in
     * the response. Deletion is a cascading event such that all children of the
     * targeted object are also deleted. For example, deleting a CatalogItem will
     * also delete all of its [CatalogItemVariation](#type-catalogitemvariation)
     * children.
     * `BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted
     * IDs can be deleted. The response will only include IDs that were
     * actually deleted.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchDeleteCatalogObjectsResponse response from the API call 
     */
    public CompletableFuture<BatchDeleteCatalogObjectsResponse> batchDeleteCatalogObjectsAsync(
            final BatchDeleteCatalogObjectsRequest body
    ) {
        return makeHttpCallAsync(() -> _buildBatchDeleteCatalogObjectsRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleBatchDeleteCatalogObjectsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for batchDeleteCatalogObjects
     */
    private HttpRequest _buildBatchDeleteCatalogObjectsRequest(
            final BatchDeleteCatalogObjectsRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/batch-delete");
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
     * Processes the response for batchDeleteCatalogObjects
     * @return An object of type BatchDeleteCatalogObjectsResponse
     */
    private BatchDeleteCatalogObjectsResponse _handleBatchDeleteCatalogObjectsResponse(HttpContext _context)
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
        BatchDeleteCatalogObjectsResponse _result = ApiHelper.deserialize(_responseBody,
                BatchDeleteCatalogObjectsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a set of objects based on the provided ID.
     * Each [CatalogItem](#type-catalogitem) returned in the set includes all of its
     * child information including: all of its
     * [CatalogItemVariation](#type-catalogitemvariation) objects, references to
     * its [CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
     * any [CatalogTax](#type-catalogtax) objects that apply to it.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveCatalogObjectsResponse response from the API call
     */
    public BatchRetrieveCatalogObjectsResponse batchRetrieveCatalogObjects(
            final BatchRetrieveCatalogObjectsRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildBatchRetrieveCatalogObjectsRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleBatchRetrieveCatalogObjectsResponse(_context);
    }

    /**
     * Returns a set of objects based on the provided ID.
     * Each [CatalogItem](#type-catalogitem) returned in the set includes all of its
     * child information including: all of its
     * [CatalogItemVariation](#type-catalogitemvariation) objects, references to
     * its [CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
     * any [CatalogTax](#type-catalogtax) objects that apply to it.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveCatalogObjectsResponse response from the API call 
     */
    public CompletableFuture<BatchRetrieveCatalogObjectsResponse> batchRetrieveCatalogObjectsAsync(
            final BatchRetrieveCatalogObjectsRequest body
    ) {
        return makeHttpCallAsync(() -> _buildBatchRetrieveCatalogObjectsRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleBatchRetrieveCatalogObjectsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for batchRetrieveCatalogObjects
     */
    private HttpRequest _buildBatchRetrieveCatalogObjectsRequest(
            final BatchRetrieveCatalogObjectsRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/batch-retrieve");
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
     * Processes the response for batchRetrieveCatalogObjects
     * @return An object of type BatchRetrieveCatalogObjectsResponse
     */
    private BatchRetrieveCatalogObjectsResponse _handleBatchRetrieveCatalogObjectsResponse(HttpContext _context)
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
        BatchRetrieveCatalogObjectsResponse _result = ApiHelper.deserialize(_responseBody,
                BatchRetrieveCatalogObjectsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Creates or updates up to 10,000 target objects based on the provided
     * list of objects. The target objects are grouped into batches and each batch is
     * inserted/updated in an all-or-nothing manner. If an object within a batch is
     * malformed in some way, or violates a database constraint, the entire batch
     * containing that item will be disregarded. However, other batches in the same
     * request may still succeed. Each batch may contain up to 1,000 objects, and
     * batches will be processed in order as long as the total object count for the
     * request (items, variations, modifier lists, discounts, and taxes) is no more
     * than 10,000.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchUpsertCatalogObjectsResponse response from the API call
     */
    public BatchUpsertCatalogObjectsResponse batchUpsertCatalogObjects(
            final BatchUpsertCatalogObjectsRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildBatchUpsertCatalogObjectsRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleBatchUpsertCatalogObjectsResponse(_context);
    }

    /**
     * Creates or updates up to 10,000 target objects based on the provided
     * list of objects. The target objects are grouped into batches and each batch is
     * inserted/updated in an all-or-nothing manner. If an object within a batch is
     * malformed in some way, or violates a database constraint, the entire batch
     * containing that item will be disregarded. However, other batches in the same
     * request may still succeed. Each batch may contain up to 1,000 objects, and
     * batches will be processed in order as long as the total object count for the
     * request (items, variations, modifier lists, discounts, and taxes) is no more
     * than 10,000.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchUpsertCatalogObjectsResponse response from the API call 
     */
    public CompletableFuture<BatchUpsertCatalogObjectsResponse> batchUpsertCatalogObjectsAsync(
            final BatchUpsertCatalogObjectsRequest body
    ) {
        return makeHttpCallAsync(() -> _buildBatchUpsertCatalogObjectsRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleBatchUpsertCatalogObjectsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for batchUpsertCatalogObjects
     */
    private HttpRequest _buildBatchUpsertCatalogObjectsRequest(
            final BatchUpsertCatalogObjectsRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/batch-upsert");
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
     * Processes the response for batchUpsertCatalogObjects
     * @return An object of type BatchUpsertCatalogObjectsResponse
     */
    private BatchUpsertCatalogObjectsResponse _handleBatchUpsertCatalogObjectsResponse(HttpContext _context)
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
        BatchUpsertCatalogObjectsResponse _result = ApiHelper.deserialize(_responseBody,
                BatchUpsertCatalogObjectsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Upload an image file to create a new [CatalogImage](#type-catalogimage) for an existing
     * [CatalogObject](#type-catalogobject). Images can be uploaded and linked in this request or created independently
     * (without an object assignment) and linked to a [CatalogObject](#type-catalogobject) at a later time.
     * CreateCatalogImage accepts HTTP multipart/form-data requests with a JSON part and an image file part in
     * JPEG, PJPEG, PNG, or GIF format. The maximum file size is 15MB. The following is an example of such an HTTP request:
     * ```
     * POST /v2/catalog/images
     * Accept: application/json
     * Content-Type: multipart/form-data;boundary="boundary"
     * Square-Version: XXXX-XX-XX
     * Authorization: Bearer {ACCESS_TOKEN}
     * --boundary
     * Content-Disposition: form-data; name="request"
     * Content-Type: application/json
     * {
     * "idempotency_key":"528dea59-7bfb-43c1-bd48-4a6bba7dd61f86",
     * "object_id": "ND6EA5AAJEO5WL3JNNIAQA32",
     * "image":{
     * "id":"#TEMP_ID",
     * "type":"IMAGE",
     * "image_data":{
     * "caption":"A picture of a cup of coffee"
     * }
     * }
     * }
     * --boundary
     * Content-Disposition: form-data; name="image"; filename="Coffee.jpg"
     * Content-Type: image/jpeg
     * {ACTUAL_IMAGE_BYTES}
     * --boundary
     * ```
     * Additional information and an example cURL request can be found in the [Create a Catalog Image recipe](https://developer.squareup.com/docs/more-apis/catalog/cookbook/create-catalog-images).
     * @param    request    Optional parameter: Example: 
     * @param    imageFile    Optional parameter: Example: 
     * @return    Returns the CreateCatalogImageResponse response from the API call
     */
    public CreateCatalogImageResponse createCatalogImage(
            final CreateCatalogImageRequest request,
            final File imageFile
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateCatalogImageRequest(request, imageFile);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateCatalogImageResponse(_context);
    }

    /**
     * Upload an image file to create a new [CatalogImage](#type-catalogimage) for an existing
     * [CatalogObject](#type-catalogobject). Images can be uploaded and linked in this request or created independently
     * (without an object assignment) and linked to a [CatalogObject](#type-catalogobject) at a later time.
     * CreateCatalogImage accepts HTTP multipart/form-data requests with a JSON part and an image file part in
     * JPEG, PJPEG, PNG, or GIF format. The maximum file size is 15MB. The following is an example of such an HTTP request:
     * ```
     * POST /v2/catalog/images
     * Accept: application/json
     * Content-Type: multipart/form-data;boundary="boundary"
     * Square-Version: XXXX-XX-XX
     * Authorization: Bearer {ACCESS_TOKEN}
     * --boundary
     * Content-Disposition: form-data; name="request"
     * Content-Type: application/json
     * {
     * "idempotency_key":"528dea59-7bfb-43c1-bd48-4a6bba7dd61f86",
     * "object_id": "ND6EA5AAJEO5WL3JNNIAQA32",
     * "image":{
     * "id":"#TEMP_ID",
     * "type":"IMAGE",
     * "image_data":{
     * "caption":"A picture of a cup of coffee"
     * }
     * }
     * }
     * --boundary
     * Content-Disposition: form-data; name="image"; filename="Coffee.jpg"
     * Content-Type: image/jpeg
     * {ACTUAL_IMAGE_BYTES}
     * --boundary
     * ```
     * Additional information and an example cURL request can be found in the [Create a Catalog Image recipe](https://developer.squareup.com/docs/more-apis/catalog/cookbook/create-catalog-images).
     * @param    request    Optional parameter: Example: 
     * @param    imageFile    Optional parameter: Example: 
     * @return    Returns the CreateCatalogImageResponse response from the API call 
     */
    public CompletableFuture<CreateCatalogImageResponse> createCatalogImageAsync(
            final CreateCatalogImageRequest request,
            final File imageFile
    ) {
        return makeHttpCallAsync(() -> _buildCreateCatalogImageRequest(request, imageFile),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateCatalogImageResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createCatalogImage
     */
    private HttpRequest _buildCreateCatalogImageRequest(
            final CreateCatalogImageRequest request,
            final File imageFile
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/images");
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());
        Headers requestHeaders = new Headers();
        requestHeaders.add("Content-Type", "application/json; charset=utf-8");
        MultipartWrapper requestWrapper = new MultipartWrapper(ApiHelper.serialize(request).getBytes(), requestHeaders);
        Headers imageFileHeaders = new Headers();
        imageFileHeaders.add("Content-Type", "image/jpeg");
        MultipartFileWrapper imageFileWrapper = new MultipartFileWrapper(imageFile, imageFileHeaders);

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>();
        if (request != null) {
            _parameters.put("request", requestWrapper);
        }
        if (imageFile != null) {
            _parameters.put("image_file", imageFileWrapper);
        }

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().post(_queryUrl, _headers, ApiHelper.prepareFormFields(_parameters));

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for createCatalogImage
     * @return An object of type CreateCatalogImageResponse
     */
    private CreateCatalogImageResponse _handleCreateCatalogImageResponse(HttpContext _context)
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
        CreateCatalogImageResponse _result = ApiHelper.deserialize(_responseBody,
                CreateCatalogImageResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns information about the Square Catalog API, such as batch size
     * limits for `BatchUpsertCatalogObjects`.
     * @return    Returns the CatalogInfoResponse response from the API call
     */
    public CatalogInfoResponse catalogInfo() throws ApiException, IOException {
        HttpRequest _request = _buildCatalogInfoRequest();
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCatalogInfoResponse(_context);
    }

    /**
     * Returns information about the Square Catalog API, such as batch size
     * limits for `BatchUpsertCatalogObjects`.
     * @return    Returns the CatalogInfoResponse response from the API call 
     */
    public CompletableFuture<CatalogInfoResponse> catalogInfoAsync() {
        return makeHttpCallAsync(() -> _buildCatalogInfoRequest(),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCatalogInfoResponse(_context));
    }

    /**
     * Builds the HttpRequest object for catalogInfo
     */
    private HttpRequest _buildCatalogInfoRequest() {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/info");
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
     * Processes the response for catalogInfo
     * @return An object of type CatalogInfoResponse
     */
    private CatalogInfoResponse _handleCatalogInfoResponse(HttpContext _context)
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
        CatalogInfoResponse _result = ApiHelper.deserialize(_responseBody,
                CatalogInfoResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a list of [CatalogObject](#type-catalogobject)s that includes
     * all objects of a set of desired types (for example, all [CatalogItem](#type-catalogitem)
     * and [CatalogTax](#type-catalogtax) objects) in the catalog. The `types` parameter
     * is specified as a comma-separated list of valid [CatalogObject](#type-catalogobject) types:
     * `ITEM`, `ITEM_VARIATION`, `MODIFIER`, `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`.
     * __Important:__ ListCatalog does not return deleted catalog items. To retrieve
     * deleted catalog items, use SearchCatalogObjects and set `include_deleted_objects`
     * to `true`.
     * @param    cursor    Optional parameter: The pagination cursor returned in the previous response. Leave unset for an initial request. See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    types    Optional parameter: An optional case-insensitive, comma-separated list of object types to retrieve, for example `ITEM,ITEM_VARIATION,CATEGORY,IMAGE`.  The legal values are taken from the CatalogObjectType enum: `ITEM`, `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`, `MODIFIER`, `MODIFIER_LIST`, or `IMAGE`.
     * @return    Returns the ListCatalogResponse response from the API call
     */
    public ListCatalogResponse listCatalog(
            final String cursor,
            final String types
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListCatalogRequest(cursor, types);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListCatalogResponse(_context);
    }

    /**
     * Returns a list of [CatalogObject](#type-catalogobject)s that includes
     * all objects of a set of desired types (for example, all [CatalogItem](#type-catalogitem)
     * and [CatalogTax](#type-catalogtax) objects) in the catalog. The `types` parameter
     * is specified as a comma-separated list of valid [CatalogObject](#type-catalogobject) types:
     * `ITEM`, `ITEM_VARIATION`, `MODIFIER`, `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`.
     * __Important:__ ListCatalog does not return deleted catalog items. To retrieve
     * deleted catalog items, use SearchCatalogObjects and set `include_deleted_objects`
     * to `true`.
     * @param    cursor    Optional parameter: The pagination cursor returned in the previous response. Leave unset for an initial request. See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    types    Optional parameter: An optional case-insensitive, comma-separated list of object types to retrieve, for example `ITEM,ITEM_VARIATION,CATEGORY,IMAGE`.  The legal values are taken from the CatalogObjectType enum: `ITEM`, `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`, `MODIFIER`, `MODIFIER_LIST`, or `IMAGE`.
     * @return    Returns the ListCatalogResponse response from the API call 
     */
    public CompletableFuture<ListCatalogResponse> listCatalogAsync(
            final String cursor,
            final String types
    ) {
        return makeHttpCallAsync(() -> _buildListCatalogRequest(cursor, types),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListCatalogResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listCatalog
     */
    private HttpRequest _buildListCatalogRequest(
            final String cursor,
            final String types
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/list");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("cursor", cursor);
        _queryParameters.put("types", types);
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
     * Processes the response for listCatalog
     * @return An object of type ListCatalogResponse
     */
    private ListCatalogResponse _handleListCatalogResponse(HttpContext _context)
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
        ListCatalogResponse _result = ApiHelper.deserialize(_responseBody,
                ListCatalogResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Creates or updates the target [CatalogObject](#type-catalogobject).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpsertCatalogObjectResponse response from the API call
     */
    public UpsertCatalogObjectResponse upsertCatalogObject(
            final UpsertCatalogObjectRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpsertCatalogObjectRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpsertCatalogObjectResponse(_context);
    }

    /**
     * Creates or updates the target [CatalogObject](#type-catalogobject).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpsertCatalogObjectResponse response from the API call 
     */
    public CompletableFuture<UpsertCatalogObjectResponse> upsertCatalogObjectAsync(
            final UpsertCatalogObjectRequest body
    ) {
        return makeHttpCallAsync(() -> _buildUpsertCatalogObjectRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpsertCatalogObjectResponse(_context));
    }

    /**
     * Builds the HttpRequest object for upsertCatalogObject
     */
    private HttpRequest _buildUpsertCatalogObjectRequest(
            final UpsertCatalogObjectRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/object");
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
     * Processes the response for upsertCatalogObject
     * @return An object of type UpsertCatalogObjectResponse
     */
    private UpsertCatalogObjectResponse _handleUpsertCatalogObjectResponse(HttpContext _context)
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
        UpsertCatalogObjectResponse _result = ApiHelper.deserialize(_responseBody,
                UpsertCatalogObjectResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes a single [CatalogObject](#type-catalogobject) based on the
     * provided ID and returns the set of successfully deleted IDs in the response.
     * Deletion is a cascading event such that all children of the targeted object
     * are also deleted. For example, deleting a [CatalogItem](#type-catalogitem)
     * will also delete all of its
     * [CatalogItemVariation](#type-catalogitemvariation) children.
     * @param    objectId    Required parameter: The ID of the catalog object to be deleted. When an object is deleted, other objects in the graph that depend on that object will be deleted as well (for example, deleting a catalog item will delete its catalog item variations).
     * @return    Returns the DeleteCatalogObjectResponse response from the API call
     */
    public DeleteCatalogObjectResponse deleteCatalogObject(
            final String objectId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteCatalogObjectRequest(objectId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteCatalogObjectResponse(_context);
    }

    /**
     * Deletes a single [CatalogObject](#type-catalogobject) based on the
     * provided ID and returns the set of successfully deleted IDs in the response.
     * Deletion is a cascading event such that all children of the targeted object
     * are also deleted. For example, deleting a [CatalogItem](#type-catalogitem)
     * will also delete all of its
     * [CatalogItemVariation](#type-catalogitemvariation) children.
     * @param    objectId    Required parameter: The ID of the catalog object to be deleted. When an object is deleted, other objects in the graph that depend on that object will be deleted as well (for example, deleting a catalog item will delete its catalog item variations).
     * @return    Returns the DeleteCatalogObjectResponse response from the API call 
     */
    public CompletableFuture<DeleteCatalogObjectResponse> deleteCatalogObjectAsync(
            final String objectId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteCatalogObjectRequest(objectId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteCatalogObjectResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteCatalogObject
     */
    private HttpRequest _buildDeleteCatalogObjectRequest(
            final String objectId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/object/{object_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("object_id", objectId);
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
        HttpRequest _request = getClientInstance().delete(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for deleteCatalogObject
     * @return An object of type DeleteCatalogObjectResponse
     */
    private DeleteCatalogObjectResponse _handleDeleteCatalogObjectResponse(HttpContext _context)
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
        DeleteCatalogObjectResponse _result = ApiHelper.deserialize(_responseBody,
                DeleteCatalogObjectResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a single [CatalogItem](#type-catalogitem) as a
     * [CatalogObject](#type-catalogobject) based on the provided ID. The returned
     * object includes all of the relevant [CatalogItem](#type-catalogitem)
     * information including: [CatalogItemVariation](#type-catalogitemvariation)
     * children, references to its
     * [CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
     * any [CatalogTax](#type-catalogtax) objects that apply to it.
     * @param    objectId    Required parameter: The object ID of any type of catalog objects to be retrieved.
     * @param    includeRelatedObjects    Optional parameter: If `true`, the response will include additional objects that are related to the requested object, as follows:  If the `object` field of the response contains a CatalogItem, its associated CatalogCategory, CatalogTax objects, CatalogImages and CatalogModifierLists will be returned in the `related_objects` field of the response. If the `object` field of the response contains a CatalogItemVariation, its parent CatalogItem will be returned in the `related_objects` field of the response.  Default value: `false`
     * @return    Returns the RetrieveCatalogObjectResponse response from the API call
     */
    public RetrieveCatalogObjectResponse retrieveCatalogObject(
            final String objectId,
            final Boolean includeRelatedObjects
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveCatalogObjectRequest(objectId, includeRelatedObjects);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveCatalogObjectResponse(_context);
    }

    /**
     * Returns a single [CatalogItem](#type-catalogitem) as a
     * [CatalogObject](#type-catalogobject) based on the provided ID. The returned
     * object includes all of the relevant [CatalogItem](#type-catalogitem)
     * information including: [CatalogItemVariation](#type-catalogitemvariation)
     * children, references to its
     * [CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
     * any [CatalogTax](#type-catalogtax) objects that apply to it.
     * @param    objectId    Required parameter: The object ID of any type of catalog objects to be retrieved.
     * @param    includeRelatedObjects    Optional parameter: If `true`, the response will include additional objects that are related to the requested object, as follows:  If the `object` field of the response contains a CatalogItem, its associated CatalogCategory, CatalogTax objects, CatalogImages and CatalogModifierLists will be returned in the `related_objects` field of the response. If the `object` field of the response contains a CatalogItemVariation, its parent CatalogItem will be returned in the `related_objects` field of the response.  Default value: `false`
     * @return    Returns the RetrieveCatalogObjectResponse response from the API call 
     */
    public CompletableFuture<RetrieveCatalogObjectResponse> retrieveCatalogObjectAsync(
            final String objectId,
            final Boolean includeRelatedObjects
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveCatalogObjectRequest(objectId, includeRelatedObjects),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveCatalogObjectResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveCatalogObject
     */
    private HttpRequest _buildRetrieveCatalogObjectRequest(
            final String objectId,
            final Boolean includeRelatedObjects
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/object/{object_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("object_id", objectId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("include_related_objects", includeRelatedObjects);
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
     * Processes the response for retrieveCatalogObject
     * @return An object of type RetrieveCatalogObjectResponse
     */
    private RetrieveCatalogObjectResponse _handleRetrieveCatalogObjectResponse(HttpContext _context)
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
        RetrieveCatalogObjectResponse _result = ApiHelper.deserialize(_responseBody,
                RetrieveCatalogObjectResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Queries the targeted catalog using a variety of query types:
     * [CatalogQuerySortedAttribute](#type-catalogquerysortedattribute),
     * [CatalogQueryExact](#type-catalogqueryexact),
     * [CatalogQueryRange](#type-catalogqueryrange),
     * [CatalogQueryText](#type-catalogquerytext),
     * [CatalogQueryItemsForTax](#type-catalogqueryitemsfortax), and
     * [CatalogQueryItemsForModifierList](#type-catalogqueryitemsformodifierlist).
     * --
     * --
     * Future end of the above comment:
     * [CatalogQueryItemsForTax](#type-catalogqueryitemsfortax),
     * [CatalogQueryItemsForModifierList](#type-catalogqueryitemsformodifierlist),
     * [CatalogQueryItemsForItemOptions](#type-catalogqueryitemsforitemoptions), and
     * [CatalogQueryItemVariationsForItemOptionValues](#type-catalogqueryitemvariationsforitemoptionvalues).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogObjectsResponse response from the API call
     */
    public SearchCatalogObjectsResponse searchCatalogObjects(
            final SearchCatalogObjectsRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildSearchCatalogObjectsRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleSearchCatalogObjectsResponse(_context);
    }

    /**
     * Queries the targeted catalog using a variety of query types:
     * [CatalogQuerySortedAttribute](#type-catalogquerysortedattribute),
     * [CatalogQueryExact](#type-catalogqueryexact),
     * [CatalogQueryRange](#type-catalogqueryrange),
     * [CatalogQueryText](#type-catalogquerytext),
     * [CatalogQueryItemsForTax](#type-catalogqueryitemsfortax), and
     * [CatalogQueryItemsForModifierList](#type-catalogqueryitemsformodifierlist).
     * --
     * --
     * Future end of the above comment:
     * [CatalogQueryItemsForTax](#type-catalogqueryitemsfortax),
     * [CatalogQueryItemsForModifierList](#type-catalogqueryitemsformodifierlist),
     * [CatalogQueryItemsForItemOptions](#type-catalogqueryitemsforitemoptions), and
     * [CatalogQueryItemVariationsForItemOptionValues](#type-catalogqueryitemvariationsforitemoptionvalues).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogObjectsResponse response from the API call 
     */
    public CompletableFuture<SearchCatalogObjectsResponse> searchCatalogObjectsAsync(
            final SearchCatalogObjectsRequest body
    ) {
        return makeHttpCallAsync(() -> _buildSearchCatalogObjectsRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleSearchCatalogObjectsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for searchCatalogObjects
     */
    private HttpRequest _buildSearchCatalogObjectsRequest(
            final SearchCatalogObjectsRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/search");
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
     * Processes the response for searchCatalogObjects
     * @return An object of type SearchCatalogObjectsResponse
     */
    private SearchCatalogObjectsResponse _handleSearchCatalogObjectsResponse(HttpContext _context)
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
        SearchCatalogObjectsResponse _result = ApiHelper.deserialize(_responseBody,
                SearchCatalogObjectsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Updates the [CatalogModifierList](#type-catalogmodifierlist) objects
     * that apply to the targeted [CatalogItem](#type-catalogitem) without having
     * to perform an upsert on the entire item.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateItemModifierListsResponse response from the API call
     */
    public UpdateItemModifierListsResponse updateItemModifierLists(
            final UpdateItemModifierListsRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateItemModifierListsRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateItemModifierListsResponse(_context);
    }

    /**
     * Updates the [CatalogModifierList](#type-catalogmodifierlist) objects
     * that apply to the targeted [CatalogItem](#type-catalogitem) without having
     * to perform an upsert on the entire item.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateItemModifierListsResponse response from the API call 
     */
    public CompletableFuture<UpdateItemModifierListsResponse> updateItemModifierListsAsync(
            final UpdateItemModifierListsRequest body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateItemModifierListsRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateItemModifierListsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateItemModifierLists
     */
    private HttpRequest _buildUpdateItemModifierListsRequest(
            final UpdateItemModifierListsRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/update-item-modifier-lists");
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
     * Processes the response for updateItemModifierLists
     * @return An object of type UpdateItemModifierListsResponse
     */
    private UpdateItemModifierListsResponse _handleUpdateItemModifierListsResponse(HttpContext _context)
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
        UpdateItemModifierListsResponse _result = ApiHelper.deserialize(_responseBody,
                UpdateItemModifierListsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Updates the [CatalogTax](#type-catalogtax) objects that apply to the
     * targeted [CatalogItem](#type-catalogitem) without having to perform an
     * upsert on the entire item.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateItemTaxesResponse response from the API call
     */
    public UpdateItemTaxesResponse updateItemTaxes(
            final UpdateItemTaxesRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateItemTaxesRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateItemTaxesResponse(_context);
    }

    /**
     * Updates the [CatalogTax](#type-catalogtax) objects that apply to the
     * targeted [CatalogItem](#type-catalogitem) without having to perform an
     * upsert on the entire item.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateItemTaxesResponse response from the API call 
     */
    public CompletableFuture<UpdateItemTaxesResponse> updateItemTaxesAsync(
            final UpdateItemTaxesRequest body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateItemTaxesRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateItemTaxesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateItemTaxes
     */
    private HttpRequest _buildUpdateItemTaxesRequest(
            final UpdateItemTaxesRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/catalog/update-item-taxes");
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
     * Processes the response for updateItemTaxes
     * @return An object of type UpdateItemTaxesResponse
     */
    private UpdateItemTaxesResponse _handleUpdateItemTaxesResponse(HttpContext _context)
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
        UpdateItemTaxesResponse _result = ApiHelper.deserialize(_responseBody,
                UpdateItemTaxesResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
