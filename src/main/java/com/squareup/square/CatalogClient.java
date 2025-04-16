/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.catalog.ImagesClient;
import com.squareup.square.catalog.ObjectClient;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.Suppliers;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.BatchDeleteCatalogObjectsRequest;
import com.squareup.square.types.BatchDeleteCatalogObjectsResponse;
import com.squareup.square.types.BatchGetCatalogObjectsRequest;
import com.squareup.square.types.BatchGetCatalogObjectsResponse;
import com.squareup.square.types.BatchUpsertCatalogObjectsRequest;
import com.squareup.square.types.BatchUpsertCatalogObjectsResponse;
import com.squareup.square.types.CatalogInfoResponse;
import com.squareup.square.types.CatalogObject;
import com.squareup.square.types.ListCatalogRequest;
import com.squareup.square.types.ListCatalogResponse;
import com.squareup.square.types.SearchCatalogItemsRequest;
import com.squareup.square.types.SearchCatalogItemsResponse;
import com.squareup.square.types.SearchCatalogObjectsRequest;
import com.squareup.square.types.SearchCatalogObjectsResponse;
import com.squareup.square.types.UpdateItemModifierListsRequest;
import com.squareup.square.types.UpdateItemModifierListsResponse;
import com.squareup.square.types.UpdateItemTaxesRequest;
import com.squareup.square.types.UpdateItemTaxesResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CatalogClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<ImagesClient> imagesClient;

    protected final Supplier<ObjectClient> objectClient;

    public CatalogClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.imagesClient = Suppliers.memoize(() -> new ImagesClient(clientOptions));
        this.objectClient = Suppliers.memoize(() -> new ObjectClient(clientOptions));
    }

    /**
     * Deletes a set of <a href="entity:CatalogItem">CatalogItem</a>s based on the
     * provided list of target IDs and returns a set of successfully deleted IDs in
     * the response. Deletion is a cascading event such that all children of the
     * targeted object are also deleted. For example, deleting a CatalogItem will
     * also delete all of its <a href="entity:CatalogItemVariation">CatalogItemVariation</a>
     * children.
     * <p><code>BatchDeleteCatalogObjects</code> succeeds even if only a portion of the targeted
     * IDs can be deleted. The response will only include IDs that were
     * actually deleted.</p>
     * <p>To ensure consistency, only one delete request is processed at a time per seller account.
     * While one (batch or non-batch) delete request is being processed, other (batched and non-batched)
     * delete requests are rejected with the <code>429</code> error code.</p>
     */
    public BatchDeleteCatalogObjectsResponse batchDelete(BatchDeleteCatalogObjectsRequest request) {
        return batchDelete(request, null);
    }

    /**
     * Deletes a set of <a href="entity:CatalogItem">CatalogItem</a>s based on the
     * provided list of target IDs and returns a set of successfully deleted IDs in
     * the response. Deletion is a cascading event such that all children of the
     * targeted object are also deleted. For example, deleting a CatalogItem will
     * also delete all of its <a href="entity:CatalogItemVariation">CatalogItemVariation</a>
     * children.
     * <p><code>BatchDeleteCatalogObjects</code> succeeds even if only a portion of the targeted
     * IDs can be deleted. The response will only include IDs that were
     * actually deleted.</p>
     * <p>To ensure consistency, only one delete request is processed at a time per seller account.
     * While one (batch or non-batch) delete request is being processed, other (batched and non-batched)
     * delete requests are rejected with the <code>429</code> error code.</p>
     */
    public BatchDeleteCatalogObjectsResponse batchDelete(
            BatchDeleteCatalogObjectsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/catalog/batch-delete")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), BatchDeleteCatalogObjectsResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Returns a set of objects based on the provided ID.
     * Each <a href="entity:CatalogItem">CatalogItem</a> returned in the set includes all of its
     * child information including: all of its
     * <a href="entity:CatalogItemVariation">CatalogItemVariation</a> objects, references to
     * its <a href="entity:CatalogModifierList">CatalogModifierList</a> objects, and the ids of
     * any <a href="entity:CatalogTax">CatalogTax</a> objects that apply to it.
     */
    public BatchGetCatalogObjectsResponse batchGet(BatchGetCatalogObjectsRequest request) {
        return batchGet(request, null);
    }

    /**
     * Returns a set of objects based on the provided ID.
     * Each <a href="entity:CatalogItem">CatalogItem</a> returned in the set includes all of its
     * child information including: all of its
     * <a href="entity:CatalogItemVariation">CatalogItemVariation</a> objects, references to
     * its <a href="entity:CatalogModifierList">CatalogModifierList</a> objects, and the ids of
     * any <a href="entity:CatalogTax">CatalogTax</a> objects that apply to it.
     */
    public BatchGetCatalogObjectsResponse batchGet(
            BatchGetCatalogObjectsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/catalog/batch-retrieve")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), BatchGetCatalogObjectsResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
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
     * <p>To ensure consistency, only one update request is processed at a time per seller account.
     * While one (batch or non-batch) update request is being processed, other (batched and non-batched)
     * update requests are rejected with the <code>429</code> error code.</p>
     */
    public BatchUpsertCatalogObjectsResponse batchUpsert(BatchUpsertCatalogObjectsRequest request) {
        return batchUpsert(request, null);
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
     * <p>To ensure consistency, only one update request is processed at a time per seller account.
     * While one (batch or non-batch) update request is being processed, other (batched and non-batched)
     * update requests are rejected with the <code>429</code> error code.</p>
     */
    public BatchUpsertCatalogObjectsResponse batchUpsert(
            BatchUpsertCatalogObjectsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/catalog/batch-upsert")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), BatchUpsertCatalogObjectsResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Retrieves information about the Square Catalog API, such as batch size
     * limits that can be used by the <code>BatchUpsertCatalogObjects</code> endpoint.
     */
    public CatalogInfoResponse info() {
        return info(null);
    }

    /**
     * Retrieves information about the Square Catalog API, such as batch size
     * limits that can be used by the <code>BatchUpsertCatalogObjects</code> endpoint.
     */
    public CatalogInfoResponse info(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/catalog/info")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CatalogInfoResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Returns a list of all <a href="entity:CatalogObject">CatalogObject</a>s of the specified types in the catalog.
     * <p>The <code>types</code> parameter is specified as a comma-separated list of the <a href="entity:CatalogObjectType">CatalogObjectType</a> values,
     * for example, &quot;<code>ITEM</code>, <code>ITEM_VARIATION</code>, <code>MODIFIER</code>, <code>MODIFIER_LIST</code>, <code>CATEGORY</code>, <code>DISCOUNT</code>, <code>TAX</code>, <code>IMAGE</code>&quot;.</p>
     * <p><strong>Important:</strong> ListCatalog does not return deleted catalog items. To retrieve
     * deleted catalog items, use <a href="api-endpoint:Catalog-SearchCatalogObjects">SearchCatalogObjects</a>
     * and set the <code>include_deleted_objects</code> attribute value to <code>true</code>.</p>
     */
    public SyncPagingIterable<CatalogObject> list() {
        return list(ListCatalogRequest.builder().build());
    }

    /**
     * Returns a list of all <a href="entity:CatalogObject">CatalogObject</a>s of the specified types in the catalog.
     * <p>The <code>types</code> parameter is specified as a comma-separated list of the <a href="entity:CatalogObjectType">CatalogObjectType</a> values,
     * for example, &quot;<code>ITEM</code>, <code>ITEM_VARIATION</code>, <code>MODIFIER</code>, <code>MODIFIER_LIST</code>, <code>CATEGORY</code>, <code>DISCOUNT</code>, <code>TAX</code>, <code>IMAGE</code>&quot;.</p>
     * <p><strong>Important:</strong> ListCatalog does not return deleted catalog items. To retrieve
     * deleted catalog items, use <a href="api-endpoint:Catalog-SearchCatalogObjects">SearchCatalogObjects</a>
     * and set the <code>include_deleted_objects</code> attribute value to <code>true</code>.</p>
     */
    public SyncPagingIterable<CatalogObject> list(ListCatalogRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of all <a href="entity:CatalogObject">CatalogObject</a>s of the specified types in the catalog.
     * <p>The <code>types</code> parameter is specified as a comma-separated list of the <a href="entity:CatalogObjectType">CatalogObjectType</a> values,
     * for example, &quot;<code>ITEM</code>, <code>ITEM_VARIATION</code>, <code>MODIFIER</code>, <code>MODIFIER_LIST</code>, <code>CATEGORY</code>, <code>DISCOUNT</code>, <code>TAX</code>, <code>IMAGE</code>&quot;.</p>
     * <p><strong>Important:</strong> ListCatalog does not return deleted catalog items. To retrieve
     * deleted catalog items, use <a href="api-endpoint:Catalog-SearchCatalogObjects">SearchCatalogObjects</a>
     * and set the <code>include_deleted_objects</code> attribute value to <code>true</code>.</p>
     */
    public SyncPagingIterable<CatalogObject> list(ListCatalogRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/catalog/list");
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getTypes().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "types", request.getTypes().get(), false);
        }
        if (request.getCatalogVersion().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "catalog_version",
                    request.getCatalogVersion().get().toString(),
                    false);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                ListCatalogResponse parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListCatalogResponse.class);
                Optional<String> startingAfter = parsedResponse.getCursor();
                ListCatalogRequest nextRequest = ListCatalogRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<CatalogObject> result = parsedResponse.getObjects().orElse(Collections.emptyList());
                return new SyncPagingIterable<CatalogObject>(
                        startingAfter.isPresent(), result, () -> list(nextRequest, requestOptions));
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Searches for <a href="entity:CatalogObject">CatalogObject</a> of any type by matching supported search attribute values,
     * excluding custom attribute values on items or item variations, against one or more of the specified query filters.
     * <p>This (<code>SearchCatalogObjects</code>) endpoint differs from the <a href="api-endpoint:Catalog-SearchCatalogItems">SearchCatalogItems</a>
     * endpoint in the following aspects:</p>
     * <ul>
     * <li><code>SearchCatalogItems</code> can only search for items or item variations, whereas <code>SearchCatalogObjects</code> can search for any type of catalog objects.</li>
     * <li><code>SearchCatalogItems</code> supports the custom attribute query filters to return items or item variations that contain custom attribute values, where <code>SearchCatalogObjects</code> does not.</li>
     * <li><code>SearchCatalogItems</code> does not support the <code>include_deleted_objects</code> filter to search for deleted items or item variations, whereas <code>SearchCatalogObjects</code> does.</li>
     * <li>The both endpoints have different call conventions, including the query filter formats.</li>
     * </ul>
     */
    public SearchCatalogObjectsResponse search() {
        return search(SearchCatalogObjectsRequest.builder().build());
    }

    /**
     * Searches for <a href="entity:CatalogObject">CatalogObject</a> of any type by matching supported search attribute values,
     * excluding custom attribute values on items or item variations, against one or more of the specified query filters.
     * <p>This (<code>SearchCatalogObjects</code>) endpoint differs from the <a href="api-endpoint:Catalog-SearchCatalogItems">SearchCatalogItems</a>
     * endpoint in the following aspects:</p>
     * <ul>
     * <li><code>SearchCatalogItems</code> can only search for items or item variations, whereas <code>SearchCatalogObjects</code> can search for any type of catalog objects.</li>
     * <li><code>SearchCatalogItems</code> supports the custom attribute query filters to return items or item variations that contain custom attribute values, where <code>SearchCatalogObjects</code> does not.</li>
     * <li><code>SearchCatalogItems</code> does not support the <code>include_deleted_objects</code> filter to search for deleted items or item variations, whereas <code>SearchCatalogObjects</code> does.</li>
     * <li>The both endpoints have different call conventions, including the query filter formats.</li>
     * </ul>
     */
    public SearchCatalogObjectsResponse search(SearchCatalogObjectsRequest request) {
        return search(request, null);
    }

    /**
     * Searches for <a href="entity:CatalogObject">CatalogObject</a> of any type by matching supported search attribute values,
     * excluding custom attribute values on items or item variations, against one or more of the specified query filters.
     * <p>This (<code>SearchCatalogObjects</code>) endpoint differs from the <a href="api-endpoint:Catalog-SearchCatalogItems">SearchCatalogItems</a>
     * endpoint in the following aspects:</p>
     * <ul>
     * <li><code>SearchCatalogItems</code> can only search for items or item variations, whereas <code>SearchCatalogObjects</code> can search for any type of catalog objects.</li>
     * <li><code>SearchCatalogItems</code> supports the custom attribute query filters to return items or item variations that contain custom attribute values, where <code>SearchCatalogObjects</code> does not.</li>
     * <li><code>SearchCatalogItems</code> does not support the <code>include_deleted_objects</code> filter to search for deleted items or item variations, whereas <code>SearchCatalogObjects</code> does.</li>
     * <li>The both endpoints have different call conventions, including the query filter formats.</li>
     * </ul>
     */
    public SearchCatalogObjectsResponse search(SearchCatalogObjectsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/catalog/search")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), SearchCatalogObjectsResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Searches for catalog items or item variations by matching supported search attribute values, including
     * custom attribute values, against one or more of the specified query filters.
     * <p>This (<code>SearchCatalogItems</code>) endpoint differs from the <a href="api-endpoint:Catalog-SearchCatalogObjects">SearchCatalogObjects</a>
     * endpoint in the following aspects:</p>
     * <ul>
     * <li><code>SearchCatalogItems</code> can only search for items or item variations, whereas <code>SearchCatalogObjects</code> can search for any type of catalog objects.</li>
     * <li><code>SearchCatalogItems</code> supports the custom attribute query filters to return items or item variations that contain custom attribute values, where <code>SearchCatalogObjects</code> does not.</li>
     * <li><code>SearchCatalogItems</code> does not support the <code>include_deleted_objects</code> filter to search for deleted items or item variations, whereas <code>SearchCatalogObjects</code> does.</li>
     * <li>The both endpoints use different call conventions, including the query filter formats.</li>
     * </ul>
     */
    public SearchCatalogItemsResponse searchItems() {
        return searchItems(SearchCatalogItemsRequest.builder().build());
    }

    /**
     * Searches for catalog items or item variations by matching supported search attribute values, including
     * custom attribute values, against one or more of the specified query filters.
     * <p>This (<code>SearchCatalogItems</code>) endpoint differs from the <a href="api-endpoint:Catalog-SearchCatalogObjects">SearchCatalogObjects</a>
     * endpoint in the following aspects:</p>
     * <ul>
     * <li><code>SearchCatalogItems</code> can only search for items or item variations, whereas <code>SearchCatalogObjects</code> can search for any type of catalog objects.</li>
     * <li><code>SearchCatalogItems</code> supports the custom attribute query filters to return items or item variations that contain custom attribute values, where <code>SearchCatalogObjects</code> does not.</li>
     * <li><code>SearchCatalogItems</code> does not support the <code>include_deleted_objects</code> filter to search for deleted items or item variations, whereas <code>SearchCatalogObjects</code> does.</li>
     * <li>The both endpoints use different call conventions, including the query filter formats.</li>
     * </ul>
     */
    public SearchCatalogItemsResponse searchItems(SearchCatalogItemsRequest request) {
        return searchItems(request, null);
    }

    /**
     * Searches for catalog items or item variations by matching supported search attribute values, including
     * custom attribute values, against one or more of the specified query filters.
     * <p>This (<code>SearchCatalogItems</code>) endpoint differs from the <a href="api-endpoint:Catalog-SearchCatalogObjects">SearchCatalogObjects</a>
     * endpoint in the following aspects:</p>
     * <ul>
     * <li><code>SearchCatalogItems</code> can only search for items or item variations, whereas <code>SearchCatalogObjects</code> can search for any type of catalog objects.</li>
     * <li><code>SearchCatalogItems</code> supports the custom attribute query filters to return items or item variations that contain custom attribute values, where <code>SearchCatalogObjects</code> does not.</li>
     * <li><code>SearchCatalogItems</code> does not support the <code>include_deleted_objects</code> filter to search for deleted items or item variations, whereas <code>SearchCatalogObjects</code> does.</li>
     * <li>The both endpoints use different call conventions, including the query filter formats.</li>
     * </ul>
     */
    public SearchCatalogItemsResponse searchItems(SearchCatalogItemsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/catalog/search-catalog-items")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), SearchCatalogItemsResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Updates the <a href="entity:CatalogModifierList">CatalogModifierList</a> objects
     * that apply to the targeted <a href="entity:CatalogItem">CatalogItem</a> without having
     * to perform an upsert on the entire item.
     */
    public UpdateItemModifierListsResponse updateItemModifierLists(UpdateItemModifierListsRequest request) {
        return updateItemModifierLists(request, null);
    }

    /**
     * Updates the <a href="entity:CatalogModifierList">CatalogModifierList</a> objects
     * that apply to the targeted <a href="entity:CatalogItem">CatalogItem</a> without having
     * to perform an upsert on the entire item.
     */
    public UpdateItemModifierListsResponse updateItemModifierLists(
            UpdateItemModifierListsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/catalog/update-item-modifier-lists")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), UpdateItemModifierListsResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Updates the <a href="entity:CatalogTax">CatalogTax</a> objects that apply to the
     * targeted <a href="entity:CatalogItem">CatalogItem</a> without having to perform an
     * upsert on the entire item.
     */
    public UpdateItemTaxesResponse updateItemTaxes(UpdateItemTaxesRequest request) {
        return updateItemTaxes(request, null);
    }

    /**
     * Updates the <a href="entity:CatalogTax">CatalogTax</a> objects that apply to the
     * targeted <a href="entity:CatalogItem">CatalogItem</a> without having to perform an
     * upsert on the entire item.
     */
    public UpdateItemTaxesResponse updateItemTaxes(UpdateItemTaxesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/catalog/update-item-taxes")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UpdateItemTaxesResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    public ImagesClient images() {
        return this.imagesClient.get();
    }

    public ObjectClient object() {
        return this.objectClient.get();
    }
}
