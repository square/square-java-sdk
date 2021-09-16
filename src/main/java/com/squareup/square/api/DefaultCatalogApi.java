
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
import com.squareup.square.http.request.MultipartFileWrapper;
import com.squareup.square.http.request.MultipartWrapper;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.BatchDeleteCatalogObjectsRequest;
import com.squareup.square.models.BatchDeleteCatalogObjectsResponse;
import com.squareup.square.models.BatchRetrieveCatalogObjectsRequest;
import com.squareup.square.models.BatchRetrieveCatalogObjectsResponse;
import com.squareup.square.models.BatchUpsertCatalogObjectsRequest;
import com.squareup.square.models.BatchUpsertCatalogObjectsResponse;
import com.squareup.square.models.CatalogInfoResponse;
import com.squareup.square.models.CreateCatalogImageRequest;
import com.squareup.square.models.CreateCatalogImageResponse;
import com.squareup.square.models.DeleteCatalogObjectResponse;
import com.squareup.square.models.ListCatalogResponse;
import com.squareup.square.models.RetrieveCatalogObjectResponse;
import com.squareup.square.models.SearchCatalogItemsRequest;
import com.squareup.square.models.SearchCatalogItemsResponse;
import com.squareup.square.models.SearchCatalogObjectsRequest;
import com.squareup.square.models.SearchCatalogObjectsResponse;
import com.squareup.square.models.UpdateItemModifierListsRequest;
import com.squareup.square.models.UpdateItemModifierListsResponse;
import com.squareup.square.models.UpdateItemTaxesRequest;
import com.squareup.square.models.UpdateItemTaxesResponse;
import com.squareup.square.models.UpsertCatalogObjectRequest;
import com.squareup.square.models.UpsertCatalogObjectResponse;
import com.squareup.square.utilities.FileWrapper;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCatalogApi extends BaseApi implements CatalogApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultCatalogApi(Configuration config, HttpClient httpClient,
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
    public DefaultCatalogApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Deletes a set of [CatalogItem]($m/CatalogItem)s based on the provided list of target IDs and
     * returns a set of successfully deleted IDs in the response. Deletion is a cascading event such
     * that all children of the targeted object are also deleted. For example, deleting a
     * CatalogItem will also delete all of its [CatalogItemVariation]($m/CatalogItemVariation)
     * children. `BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted IDs can
     * be deleted. The response will only include IDs that were actually deleted.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchDeleteCatalogObjectsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BatchDeleteCatalogObjectsResponse batchDeleteCatalogObjects(
            final BatchDeleteCatalogObjectsRequest body) throws ApiException, IOException {
        HttpRequest request = buildBatchDeleteCatalogObjectsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleBatchDeleteCatalogObjectsResponse(context);
    }

    /**
     * Deletes a set of [CatalogItem]($m/CatalogItem)s based on the provided list of target IDs and
     * returns a set of successfully deleted IDs in the response. Deletion is a cascading event such
     * that all children of the targeted object are also deleted. For example, deleting a
     * CatalogItem will also delete all of its [CatalogItemVariation]($m/CatalogItemVariation)
     * children. `BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted IDs can
     * be deleted. The response will only include IDs that were actually deleted.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchDeleteCatalogObjectsResponse response from the API call
     */
    public CompletableFuture<BatchDeleteCatalogObjectsResponse> batchDeleteCatalogObjectsAsync(
            final BatchDeleteCatalogObjectsRequest body) {
        return makeHttpCallAsync(() -> buildBatchDeleteCatalogObjectsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleBatchDeleteCatalogObjectsResponse(context));
    }

    /**
     * Builds the HttpRequest object for batchDeleteCatalogObjects.
     */
    private HttpRequest buildBatchDeleteCatalogObjectsRequest(
            final BatchDeleteCatalogObjectsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/batch-delete");

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
     * Processes the response for batchDeleteCatalogObjects.
     * @return An object of type BatchDeleteCatalogObjectsResponse
     */
    private BatchDeleteCatalogObjectsResponse handleBatchDeleteCatalogObjectsResponse(
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
        BatchDeleteCatalogObjectsResponse result = ApiHelper.deserialize(responseBody,
                BatchDeleteCatalogObjectsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a set of objects based on the provided ID. Each [CatalogItem]($m/CatalogItem)
     * returned in the set includes all of its child information including: all of its
     * [CatalogItemVariation]($m/CatalogItemVariation) objects, references to its
     * [CatalogModifierList]($m/CatalogModifierList) objects, and the ids of any
     * [CatalogTax]($m/CatalogTax) objects that apply to it.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveCatalogObjectsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BatchRetrieveCatalogObjectsResponse batchRetrieveCatalogObjects(
            final BatchRetrieveCatalogObjectsRequest body) throws ApiException, IOException {
        HttpRequest request = buildBatchRetrieveCatalogObjectsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleBatchRetrieveCatalogObjectsResponse(context);
    }

    /**
     * Returns a set of objects based on the provided ID. Each [CatalogItem]($m/CatalogItem)
     * returned in the set includes all of its child information including: all of its
     * [CatalogItemVariation]($m/CatalogItemVariation) objects, references to its
     * [CatalogModifierList]($m/CatalogModifierList) objects, and the ids of any
     * [CatalogTax]($m/CatalogTax) objects that apply to it.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveCatalogObjectsResponse response from the API call
     */
    public CompletableFuture<BatchRetrieveCatalogObjectsResponse> batchRetrieveCatalogObjectsAsync(
            final BatchRetrieveCatalogObjectsRequest body) {
        return makeHttpCallAsync(() -> buildBatchRetrieveCatalogObjectsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleBatchRetrieveCatalogObjectsResponse(context));
    }

    /**
     * Builds the HttpRequest object for batchRetrieveCatalogObjects.
     */
    private HttpRequest buildBatchRetrieveCatalogObjectsRequest(
            final BatchRetrieveCatalogObjectsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/batch-retrieve");

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
     * Processes the response for batchRetrieveCatalogObjects.
     * @return An object of type BatchRetrieveCatalogObjectsResponse
     */
    private BatchRetrieveCatalogObjectsResponse handleBatchRetrieveCatalogObjectsResponse(
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
        BatchRetrieveCatalogObjectsResponse result = ApiHelper.deserialize(responseBody,
                BatchRetrieveCatalogObjectsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates or updates up to 10,000 target objects based on the provided list of objects. The
     * target objects are grouped into batches and each batch is inserted/updated in an
     * all-or-nothing manner. If an object within a batch is malformed in some way, or violates a
     * database constraint, the entire batch containing that item will be disregarded. However,
     * other batches in the same request may still succeed. Each batch may contain up to 1,000
     * objects, and batches will be processed in order as long as the total object count for the
     * request (items, variations, modifier lists, discounts, and taxes) is no more than 10,000.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchUpsertCatalogObjectsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BatchUpsertCatalogObjectsResponse batchUpsertCatalogObjects(
            final BatchUpsertCatalogObjectsRequest body) throws ApiException, IOException {
        HttpRequest request = buildBatchUpsertCatalogObjectsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleBatchUpsertCatalogObjectsResponse(context);
    }

    /**
     * Creates or updates up to 10,000 target objects based on the provided list of objects. The
     * target objects are grouped into batches and each batch is inserted/updated in an
     * all-or-nothing manner. If an object within a batch is malformed in some way, or violates a
     * database constraint, the entire batch containing that item will be disregarded. However,
     * other batches in the same request may still succeed. Each batch may contain up to 1,000
     * objects, and batches will be processed in order as long as the total object count for the
     * request (items, variations, modifier lists, discounts, and taxes) is no more than 10,000.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchUpsertCatalogObjectsResponse response from the API call
     */
    public CompletableFuture<BatchUpsertCatalogObjectsResponse> batchUpsertCatalogObjectsAsync(
            final BatchUpsertCatalogObjectsRequest body) {
        return makeHttpCallAsync(() -> buildBatchUpsertCatalogObjectsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleBatchUpsertCatalogObjectsResponse(context));
    }

    /**
     * Builds the HttpRequest object for batchUpsertCatalogObjects.
     */
    private HttpRequest buildBatchUpsertCatalogObjectsRequest(
            final BatchUpsertCatalogObjectsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/batch-upsert");

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
     * Processes the response for batchUpsertCatalogObjects.
     * @return An object of type BatchUpsertCatalogObjectsResponse
     */
    private BatchUpsertCatalogObjectsResponse handleBatchUpsertCatalogObjectsResponse(
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
        BatchUpsertCatalogObjectsResponse result = ApiHelper.deserialize(responseBody,
                BatchUpsertCatalogObjectsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Uploads an image file to be represented by a [CatalogImage]($m/CatalogImage) object linked to
     * an existing [CatalogObject]($m/CatalogObject) instance. A call to this endpoint can upload an
     * image, link an image to a catalog object, or do both. This `CreateCatalogImage` endpoint
     * accepts HTTP multipart/form-data requests with a JSON part and an image file part in JPEG,
     * PJPEG, PNG, or GIF format. The maximum file size is 15MB.
     * @param  request  Optional parameter: Example:
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateCatalogImageResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateCatalogImageResponse createCatalogImage(
            final CreateCatalogImageRequest request,
            final FileWrapper imageFile) throws ApiException, IOException {
        HttpRequest internalRequest = buildCreateCatalogImageRequest(request, imageFile);
        authManagers.get("global").apply(internalRequest);

        HttpResponse response = getClientInstance().execute(internalRequest, false);
        HttpContext context = new HttpContext(internalRequest, response);

        return handleCreateCatalogImageResponse(context);
    }

    /**
     * Uploads an image file to be represented by a [CatalogImage]($m/CatalogImage) object linked to
     * an existing [CatalogObject]($m/CatalogObject) instance. A call to this endpoint can upload an
     * image, link an image to a catalog object, or do both. This `CreateCatalogImage` endpoint
     * accepts HTTP multipart/form-data requests with a JSON part and an image file part in JPEG,
     * PJPEG, PNG, or GIF format. The maximum file size is 15MB.
     * @param  request  Optional parameter: Example:
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateCatalogImageResponse response from the API call
     */
    public CompletableFuture<CreateCatalogImageResponse> createCatalogImageAsync(
            final CreateCatalogImageRequest request,
            final FileWrapper imageFile) {
        return makeHttpCallAsync(() -> buildCreateCatalogImageRequest(request, imageFile),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(internalRequest -> getClientInstance()
                        .executeAsync(internalRequest, false)),
            context -> handleCreateCatalogImageResponse(context));
    }

    /**
     * Builds the HttpRequest object for createCatalogImage.
     */
    private HttpRequest buildCreateCatalogImageRequest(
            final CreateCatalogImageRequest request,
            final FileWrapper imageFile) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/images");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());
        Headers requestHeaders = new Headers();
        requestHeaders.add("Content-Type", "application/json; charset=utf-8");
        MultipartWrapper requestWrapper = new MultipartWrapper(
                ApiHelper.serialize(request), requestHeaders);
        Headers imageFileHeaders = new Headers();
        imageFileHeaders.add("Content-Type", "image/jpeg");
        MultipartFileWrapper imageFileWrapper =
                new MultipartFileWrapper(imageFile, imageFileHeaders);

        //load all fields for the outgoing API request
        Map<String, Object> formParameters = new HashMap<>();
        if (request != null) {
            formParameters.put("request", requestWrapper);
        }
        if (imageFile != null) {
            formParameters.put("image_file", imageFileWrapper);
        }

        //prepare and invoke the API call request to fetch the response
        HttpRequest internalRequest = getClientInstance().post(queryBuilder, headers, null,
                ApiHelper.prepareFormFields(formParameters));

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(internalRequest);
        }

        return internalRequest;
    }

    /**
     * Processes the response for createCatalogImage.
     * @return An object of type CreateCatalogImageResponse
     */
    private CreateCatalogImageResponse handleCreateCatalogImageResponse(
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
        CreateCatalogImageResponse result = ApiHelper.deserialize(responseBody,
                CreateCatalogImageResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves information about the Square Catalog API, such as batch size limits that can be
     * used by the `BatchUpsertCatalogObjects` endpoint.
     * @return    Returns the CatalogInfoResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CatalogInfoResponse catalogInfo() throws ApiException, IOException {
        HttpRequest request = buildCatalogInfoRequest();
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCatalogInfoResponse(context);
    }

    /**
     * Retrieves information about the Square Catalog API, such as batch size limits that can be
     * used by the `BatchUpsertCatalogObjects` endpoint.
     * @return    Returns the CatalogInfoResponse response from the API call
     */
    public CompletableFuture<CatalogInfoResponse> catalogInfoAsync() {
        return makeHttpCallAsync(() -> buildCatalogInfoRequest(),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCatalogInfoResponse(context));
    }

    /**
     * Builds the HttpRequest object for catalogInfo.
     */
    private HttpRequest buildCatalogInfoRequest() {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/info");

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
     * Processes the response for catalogInfo.
     * @return An object of type CatalogInfoResponse
     */
    private CatalogInfoResponse handleCatalogInfoResponse(
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
        CatalogInfoResponse result = ApiHelper.deserialize(responseBody,
                CatalogInfoResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a list of [CatalogObject]($m/CatalogObject)s that includes all objects of a set of
     * desired types (for example, all [CatalogItem]($m/CatalogItem) and [CatalogTax]($m/CatalogTax)
     * objects) in the catalog. The `types` parameter is specified as a comma-separated list of
     * valid [CatalogObject]($m/CatalogObject) types: `ITEM`, `ITEM_VARIATION`, `MODIFIER`,
     * `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`. __Important:__ ListCatalog does not
     * return deleted catalog items. To retrieve deleted catalog items, use
     * [SearchCatalogObjects]($e/Catalog/SearchCatalogObjects) and set the `include_deleted_objects`
     * attribute value to `true`.
     * @param  cursor  Optional parameter: The pagination cursor returned in the previous response.
     *         Leave unset for an initial request. The page size is currently set to be 100. See
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more
     *         information.
     * @param  types  Optional parameter: An optional case-insensitive, comma-separated list of
     *         object types to retrieve. The valid values are defined in the
     *         [CatalogObjectType]($m/CatalogObjectType) enum, including `ITEM`, `ITEM_VARIATION`,
     *         `CATEGORY`, `DISCOUNT`, `TAX`, `MODIFIER`, `MODIFIER_LIST`, or `IMAGE`. If this is
     *         unspecified, the operation returns objects of all the types at the version of the
     *         Square API used to make the request.
     * @param  catalogVersion  Optional parameter: The specific version of the catalog objects to be
     *         included in the response. This allows you to retrieve historical versions of objects.
     *         The specified version value is matched against the
     *         [CatalogObject]($m/CatalogObject)s' `version` attribute.
     * @return    Returns the ListCatalogResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCatalogResponse listCatalog(
            final String cursor,
            final String types,
            final Long catalogVersion) throws ApiException, IOException {
        HttpRequest request = buildListCatalogRequest(cursor, types, catalogVersion);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListCatalogResponse(context);
    }

    /**
     * Returns a list of [CatalogObject]($m/CatalogObject)s that includes all objects of a set of
     * desired types (for example, all [CatalogItem]($m/CatalogItem) and [CatalogTax]($m/CatalogTax)
     * objects) in the catalog. The `types` parameter is specified as a comma-separated list of
     * valid [CatalogObject]($m/CatalogObject) types: `ITEM`, `ITEM_VARIATION`, `MODIFIER`,
     * `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`. __Important:__ ListCatalog does not
     * return deleted catalog items. To retrieve deleted catalog items, use
     * [SearchCatalogObjects]($e/Catalog/SearchCatalogObjects) and set the `include_deleted_objects`
     * attribute value to `true`.
     * @param  cursor  Optional parameter: The pagination cursor returned in the previous response.
     *         Leave unset for an initial request. The page size is currently set to be 100. See
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more
     *         information.
     * @param  types  Optional parameter: An optional case-insensitive, comma-separated list of
     *         object types to retrieve. The valid values are defined in the
     *         [CatalogObjectType]($m/CatalogObjectType) enum, including `ITEM`, `ITEM_VARIATION`,
     *         `CATEGORY`, `DISCOUNT`, `TAX`, `MODIFIER`, `MODIFIER_LIST`, or `IMAGE`. If this is
     *         unspecified, the operation returns objects of all the types at the version of the
     *         Square API used to make the request.
     * @param  catalogVersion  Optional parameter: The specific version of the catalog objects to be
     *         included in the response. This allows you to retrieve historical versions of objects.
     *         The specified version value is matched against the
     *         [CatalogObject]($m/CatalogObject)s' `version` attribute.
     * @return    Returns the ListCatalogResponse response from the API call
     */
    public CompletableFuture<ListCatalogResponse> listCatalogAsync(
            final String cursor,
            final String types,
            final Long catalogVersion) {
        return makeHttpCallAsync(() -> buildListCatalogRequest(cursor, types, catalogVersion),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListCatalogResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCatalog.
     */
    private HttpRequest buildListCatalogRequest(
            final String cursor,
            final String types,
            final Long catalogVersion) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/list");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
        queryParameters.put("types", types);
        queryParameters.put("catalog_version", catalogVersion);

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
     * Processes the response for listCatalog.
     * @return An object of type ListCatalogResponse
     */
    private ListCatalogResponse handleListCatalogResponse(
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
        ListCatalogResponse result = ApiHelper.deserialize(responseBody,
                ListCatalogResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates or updates the target [CatalogObject]($m/CatalogObject).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertCatalogObjectResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpsertCatalogObjectResponse upsertCatalogObject(
            final UpsertCatalogObjectRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpsertCatalogObjectRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpsertCatalogObjectResponse(context);
    }

    /**
     * Creates or updates the target [CatalogObject]($m/CatalogObject).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertCatalogObjectResponse response from the API call
     */
    public CompletableFuture<UpsertCatalogObjectResponse> upsertCatalogObjectAsync(
            final UpsertCatalogObjectRequest body) {
        return makeHttpCallAsync(() -> buildUpsertCatalogObjectRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpsertCatalogObjectResponse(context));
    }

    /**
     * Builds the HttpRequest object for upsertCatalogObject.
     */
    private HttpRequest buildUpsertCatalogObjectRequest(
            final UpsertCatalogObjectRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/object");

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
     * Processes the response for upsertCatalogObject.
     * @return An object of type UpsertCatalogObjectResponse
     */
    private UpsertCatalogObjectResponse handleUpsertCatalogObjectResponse(
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
        UpsertCatalogObjectResponse result = ApiHelper.deserialize(responseBody,
                UpsertCatalogObjectResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a single [CatalogObject]($m/CatalogObject) based on the provided ID and returns the
     * set of successfully deleted IDs in the response. Deletion is a cascading event such that all
     * children of the targeted object are also deleted. For example, deleting a
     * [CatalogItem]($m/CatalogItem) will also delete all of its
     * [CatalogItemVariation]($m/CatalogItemVariation) children.
     * @param  objectId  Required parameter: The ID of the catalog object to be deleted. When an
     *         object is deleted, other objects in the graph that depend on that object will be
     *         deleted as well (for example, deleting a catalog item will delete its catalog item
     *         variations).
     * @return    Returns the DeleteCatalogObjectResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteCatalogObjectResponse deleteCatalogObject(
            final String objectId) throws ApiException, IOException {
        HttpRequest request = buildDeleteCatalogObjectRequest(objectId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteCatalogObjectResponse(context);
    }

    /**
     * Deletes a single [CatalogObject]($m/CatalogObject) based on the provided ID and returns the
     * set of successfully deleted IDs in the response. Deletion is a cascading event such that all
     * children of the targeted object are also deleted. For example, deleting a
     * [CatalogItem]($m/CatalogItem) will also delete all of its
     * [CatalogItemVariation]($m/CatalogItemVariation) children.
     * @param  objectId  Required parameter: The ID of the catalog object to be deleted. When an
     *         object is deleted, other objects in the graph that depend on that object will be
     *         deleted as well (for example, deleting a catalog item will delete its catalog item
     *         variations).
     * @return    Returns the DeleteCatalogObjectResponse response from the API call
     */
    public CompletableFuture<DeleteCatalogObjectResponse> deleteCatalogObjectAsync(
            final String objectId) {
        return makeHttpCallAsync(() -> buildDeleteCatalogObjectRequest(objectId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteCatalogObjectResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteCatalogObject.
     */
    private HttpRequest buildDeleteCatalogObjectRequest(
            final String objectId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/object/{object_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("object_id",
                new SimpleEntry<Object, Boolean>(objectId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteCatalogObject.
     * @return An object of type DeleteCatalogObjectResponse
     */
    private DeleteCatalogObjectResponse handleDeleteCatalogObjectResponse(
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
        DeleteCatalogObjectResponse result = ApiHelper.deserialize(responseBody,
                DeleteCatalogObjectResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a single [CatalogItem]($m/CatalogItem) as a [CatalogObject]($m/CatalogObject) based
     * on the provided ID. The returned object includes all of the relevant
     * [CatalogItem]($m/CatalogItem) information including:
     * [CatalogItemVariation]($m/CatalogItemVariation) children, references to its
     * [CatalogModifierList]($m/CatalogModifierList) objects, and the ids of any
     * [CatalogTax]($m/CatalogTax) objects that apply to it.
     * @param  objectId  Required parameter: The object ID of any type of catalog objects to be
     *         retrieved.
     * @param  includeRelatedObjects  Optional parameter: If `true`, the response will include
     *         additional objects that are related to the requested object, as follows: If the
     *         `object` field of the response contains a `CatalogItem`, its associated
     *         `CatalogCategory`, `CatalogTax`, `CatalogImage` and `CatalogModifierList` objects
     *         will be returned in the `related_objects` field of the response. If the `object`
     *         field of the response contains a `CatalogItemVariation`, its parent `CatalogItem`
     *         will be returned in the `related_objects` field of the response. Default value:
     *         `false`
     * @param  catalogVersion  Optional parameter: Requests objects as of a specific version of the
     *         catalog. This allows you to retrieve historical versions of objects. The value to
     *         retrieve a specific version of an object can be found in the version field of
     *         [CatalogObject]($m/CatalogObject)s.
     * @return    Returns the RetrieveCatalogObjectResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCatalogObjectResponse retrieveCatalogObject(
            final String objectId,
            final Boolean includeRelatedObjects,
            final Long catalogVersion) throws ApiException, IOException {
        HttpRequest request = buildRetrieveCatalogObjectRequest(objectId, includeRelatedObjects,
                catalogVersion);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveCatalogObjectResponse(context);
    }

    /**
     * Returns a single [CatalogItem]($m/CatalogItem) as a [CatalogObject]($m/CatalogObject) based
     * on the provided ID. The returned object includes all of the relevant
     * [CatalogItem]($m/CatalogItem) information including:
     * [CatalogItemVariation]($m/CatalogItemVariation) children, references to its
     * [CatalogModifierList]($m/CatalogModifierList) objects, and the ids of any
     * [CatalogTax]($m/CatalogTax) objects that apply to it.
     * @param  objectId  Required parameter: The object ID of any type of catalog objects to be
     *         retrieved.
     * @param  includeRelatedObjects  Optional parameter: If `true`, the response will include
     *         additional objects that are related to the requested object, as follows: If the
     *         `object` field of the response contains a `CatalogItem`, its associated
     *         `CatalogCategory`, `CatalogTax`, `CatalogImage` and `CatalogModifierList` objects
     *         will be returned in the `related_objects` field of the response. If the `object`
     *         field of the response contains a `CatalogItemVariation`, its parent `CatalogItem`
     *         will be returned in the `related_objects` field of the response. Default value:
     *         `false`
     * @param  catalogVersion  Optional parameter: Requests objects as of a specific version of the
     *         catalog. This allows you to retrieve historical versions of objects. The value to
     *         retrieve a specific version of an object can be found in the version field of
     *         [CatalogObject]($m/CatalogObject)s.
     * @return    Returns the RetrieveCatalogObjectResponse response from the API call
     */
    public CompletableFuture<RetrieveCatalogObjectResponse> retrieveCatalogObjectAsync(
            final String objectId,
            final Boolean includeRelatedObjects,
            final Long catalogVersion) {
        return makeHttpCallAsync(() -> buildRetrieveCatalogObjectRequest(objectId,
                includeRelatedObjects, catalogVersion),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveCatalogObjectResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveCatalogObject.
     */
    private HttpRequest buildRetrieveCatalogObjectRequest(
            final String objectId,
            final Boolean includeRelatedObjects,
            final Long catalogVersion) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/object/{object_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("object_id",
                new SimpleEntry<Object, Boolean>(objectId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("include_related_objects",
                (includeRelatedObjects != null) ? includeRelatedObjects : false);
        queryParameters.put("catalog_version", catalogVersion);

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
     * Processes the response for retrieveCatalogObject.
     * @return An object of type RetrieveCatalogObjectResponse
     */
    private RetrieveCatalogObjectResponse handleRetrieveCatalogObjectResponse(
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
        RetrieveCatalogObjectResponse result = ApiHelper.deserialize(responseBody,
                RetrieveCatalogObjectResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches for [CatalogObject]($m/CatalogObject) of any type by matching supported search
     * attribute values, excluding custom attribute values on items or item variations, against one
     * or more of the specified query filters. This (`SearchCatalogObjects`) endpoint differs from
     * the [SearchCatalogItems]($e/Catalog/SearchCatalogItems) endpoint in the following aspects: -
     * `SearchCatalogItems` can only search for items or item variations, whereas
     * `SearchCatalogObjects` can search for any type of catalog objects. - `SearchCatalogItems`
     * supports the custom attribute query filters to return items or item variations that contain
     * custom attribute values, where `SearchCatalogObjects` does not. - `SearchCatalogItems` does
     * not support the `include_deleted_objects` filter to search for deleted items or item
     * variations, whereas `SearchCatalogObjects` does. - The both endpoints have different call
     * conventions, including the query filter formats.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogObjectsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchCatalogObjectsResponse searchCatalogObjects(
            final SearchCatalogObjectsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchCatalogObjectsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchCatalogObjectsResponse(context);
    }

    /**
     * Searches for [CatalogObject]($m/CatalogObject) of any type by matching supported search
     * attribute values, excluding custom attribute values on items or item variations, against one
     * or more of the specified query filters. This (`SearchCatalogObjects`) endpoint differs from
     * the [SearchCatalogItems]($e/Catalog/SearchCatalogItems) endpoint in the following aspects: -
     * `SearchCatalogItems` can only search for items or item variations, whereas
     * `SearchCatalogObjects` can search for any type of catalog objects. - `SearchCatalogItems`
     * supports the custom attribute query filters to return items or item variations that contain
     * custom attribute values, where `SearchCatalogObjects` does not. - `SearchCatalogItems` does
     * not support the `include_deleted_objects` filter to search for deleted items or item
     * variations, whereas `SearchCatalogObjects` does. - The both endpoints have different call
     * conventions, including the query filter formats.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogObjectsResponse response from the API call
     */
    public CompletableFuture<SearchCatalogObjectsResponse> searchCatalogObjectsAsync(
            final SearchCatalogObjectsRequest body) {
        return makeHttpCallAsync(() -> buildSearchCatalogObjectsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchCatalogObjectsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchCatalogObjects.
     */
    private HttpRequest buildSearchCatalogObjectsRequest(
            final SearchCatalogObjectsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/search");

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
     * Processes the response for searchCatalogObjects.
     * @return An object of type SearchCatalogObjectsResponse
     */
    private SearchCatalogObjectsResponse handleSearchCatalogObjectsResponse(
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
        SearchCatalogObjectsResponse result = ApiHelper.deserialize(responseBody,
                SearchCatalogObjectsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches for catalog items or item variations by matching supported search attribute values,
     * including custom attribute values, against one or more of the specified query filters. This
     * (`SearchCatalogItems`) endpoint differs from the
     * [SearchCatalogObjects]($e/Catalog/SearchCatalogObjects) endpoint in the following aspects: -
     * `SearchCatalogItems` can only search for items or item variations, whereas
     * `SearchCatalogObjects` can search for any type of catalog objects. - `SearchCatalogItems`
     * supports the custom attribute query filters to return items or item variations that contain
     * custom attribute values, where `SearchCatalogObjects` does not. - `SearchCatalogItems` does
     * not support the `include_deleted_objects` filter to search for deleted items or item
     * variations, whereas `SearchCatalogObjects` does. - The both endpoints use different call
     * conventions, including the query filter formats.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogItemsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchCatalogItemsResponse searchCatalogItems(
            final SearchCatalogItemsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchCatalogItemsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchCatalogItemsResponse(context);
    }

    /**
     * Searches for catalog items or item variations by matching supported search attribute values,
     * including custom attribute values, against one or more of the specified query filters. This
     * (`SearchCatalogItems`) endpoint differs from the
     * [SearchCatalogObjects]($e/Catalog/SearchCatalogObjects) endpoint in the following aspects: -
     * `SearchCatalogItems` can only search for items or item variations, whereas
     * `SearchCatalogObjects` can search for any type of catalog objects. - `SearchCatalogItems`
     * supports the custom attribute query filters to return items or item variations that contain
     * custom attribute values, where `SearchCatalogObjects` does not. - `SearchCatalogItems` does
     * not support the `include_deleted_objects` filter to search for deleted items or item
     * variations, whereas `SearchCatalogObjects` does. - The both endpoints use different call
     * conventions, including the query filter formats.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogItemsResponse response from the API call
     */
    public CompletableFuture<SearchCatalogItemsResponse> searchCatalogItemsAsync(
            final SearchCatalogItemsRequest body) {
        return makeHttpCallAsync(() -> buildSearchCatalogItemsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchCatalogItemsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchCatalogItems.
     */
    private HttpRequest buildSearchCatalogItemsRequest(
            final SearchCatalogItemsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/search-catalog-items");

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
     * Processes the response for searchCatalogItems.
     * @return An object of type SearchCatalogItemsResponse
     */
    private SearchCatalogItemsResponse handleSearchCatalogItemsResponse(
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
        SearchCatalogItemsResponse result = ApiHelper.deserialize(responseBody,
                SearchCatalogItemsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates the [CatalogModifierList]($m/CatalogModifierList) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemModifierListsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateItemModifierListsResponse updateItemModifierLists(
            final UpdateItemModifierListsRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateItemModifierListsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateItemModifierListsResponse(context);
    }

    /**
     * Updates the [CatalogModifierList]($m/CatalogModifierList) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemModifierListsResponse response from the API call
     */
    public CompletableFuture<UpdateItemModifierListsResponse> updateItemModifierListsAsync(
            final UpdateItemModifierListsRequest body) {
        return makeHttpCallAsync(() -> buildUpdateItemModifierListsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateItemModifierListsResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateItemModifierLists.
     */
    private HttpRequest buildUpdateItemModifierListsRequest(
            final UpdateItemModifierListsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/update-item-modifier-lists");

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
     * Processes the response for updateItemModifierLists.
     * @return An object of type UpdateItemModifierListsResponse
     */
    private UpdateItemModifierListsResponse handleUpdateItemModifierListsResponse(
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
        UpdateItemModifierListsResponse result = ApiHelper.deserialize(responseBody,
                UpdateItemModifierListsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates the [CatalogTax]($m/CatalogTax) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemTaxesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateItemTaxesResponse updateItemTaxes(
            final UpdateItemTaxesRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateItemTaxesRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateItemTaxesResponse(context);
    }

    /**
     * Updates the [CatalogTax]($m/CatalogTax) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemTaxesResponse response from the API call
     */
    public CompletableFuture<UpdateItemTaxesResponse> updateItemTaxesAsync(
            final UpdateItemTaxesRequest body) {
        return makeHttpCallAsync(() -> buildUpdateItemTaxesRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateItemTaxesResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateItemTaxes.
     */
    private HttpRequest buildUpdateItemTaxesRequest(
            final UpdateItemTaxesRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/catalog/update-item-taxes");

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
     * Processes the response for updateItemTaxes.
     * @return An object of type UpdateItemTaxesResponse
     */
    private UpdateItemTaxesResponse handleUpdateItemTaxesResponse(
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
        UpdateItemTaxesResponse result = ApiHelper.deserialize(responseBody,
                UpdateItemTaxesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}