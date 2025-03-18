/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.locations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.locations.types.BulkDeleteLocationCustomAttributesRequest;
import com.squareup.square.locations.types.BulkUpsertLocationCustomAttributesRequest;
import com.squareup.square.locations.types.DeleteCustomAttributesRequest;
import com.squareup.square.locations.types.GetCustomAttributesRequest;
import com.squareup.square.locations.types.ListCustomAttributesRequest;
import com.squareup.square.locations.types.UpsertLocationCustomAttributeRequest;
import com.squareup.square.types.BulkDeleteLocationCustomAttributesResponse;
import com.squareup.square.types.BulkUpsertLocationCustomAttributesResponse;
import com.squareup.square.types.CustomAttribute;
import com.squareup.square.types.DeleteLocationCustomAttributeResponse;
import com.squareup.square.types.ListLocationCustomAttributesResponse;
import com.squareup.square.types.RetrieveLocationCustomAttributeResponse;
import com.squareup.square.types.UpsertLocationCustomAttributeResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public class AsyncCustomAttributesClient {
    protected final ClientOptions clientOptions;

    public AsyncCustomAttributesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Deletes <a href="entity:CustomAttribute">custom attributes</a> for locations as a bulk operation.
     * To delete a custom attribute owned by another application, the <code>visibility</code> setting must be
     * <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<BulkDeleteLocationCustomAttributesResponse> batchDelete(
            BulkDeleteLocationCustomAttributesRequest request) {
        return batchDelete(request, null);
    }

    /**
     * Deletes <a href="entity:CustomAttribute">custom attributes</a> for locations as a bulk operation.
     * To delete a custom attribute owned by another application, the <code>visibility</code> setting must be
     * <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<BulkDeleteLocationCustomAttributesResponse> batchDelete(
            BulkDeleteLocationCustomAttributesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations/custom-attributes/bulk-delete")
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
        CompletableFuture<BulkDeleteLocationCustomAttributesResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), BulkDeleteLocationCustomAttributesResponse.class));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Creates or updates <a href="entity:CustomAttribute">custom attributes</a> for locations as a bulk operation.
     * Use this endpoint to set the value of one or more custom attributes for one or more locations.
     * A custom attribute is based on a custom attribute definition in a Square seller account, which is
     * created using the <a href="api-endpoint:LocationCustomAttributes-CreateLocationCustomAttributeDefinition">CreateLocationCustomAttributeDefinition</a> endpoint.
     * This <code>BulkUpsertLocationCustomAttributes</code> endpoint accepts a map of 1 to 25 individual upsert
     * requests and returns a map of individual upsert responses. Each upsert request has a unique ID
     * and provides a location ID and custom attribute. Each upsert response is returned with the ID
     * of the corresponding request.
     * To create or update a custom attribute owned by another application, the <code>visibility</code> setting
     * must be <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<BulkUpsertLocationCustomAttributesResponse> batchUpsert(
            BulkUpsertLocationCustomAttributesRequest request) {
        return batchUpsert(request, null);
    }

    /**
     * Creates or updates <a href="entity:CustomAttribute">custom attributes</a> for locations as a bulk operation.
     * Use this endpoint to set the value of one or more custom attributes for one or more locations.
     * A custom attribute is based on a custom attribute definition in a Square seller account, which is
     * created using the <a href="api-endpoint:LocationCustomAttributes-CreateLocationCustomAttributeDefinition">CreateLocationCustomAttributeDefinition</a> endpoint.
     * This <code>BulkUpsertLocationCustomAttributes</code> endpoint accepts a map of 1 to 25 individual upsert
     * requests and returns a map of individual upsert responses. Each upsert request has a unique ID
     * and provides a location ID and custom attribute. Each upsert response is returned with the ID
     * of the corresponding request.
     * To create or update a custom attribute owned by another application, the <code>visibility</code> setting
     * must be <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<BulkUpsertLocationCustomAttributesResponse> batchUpsert(
            BulkUpsertLocationCustomAttributesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations/custom-attributes/bulk-upsert")
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
        CompletableFuture<BulkUpsertLocationCustomAttributesResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), BulkUpsertLocationCustomAttributesResponse.class));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Lists the <a href="entity:CustomAttribute">custom attributes</a> associated with a location.
     * You can use the <code>with_definitions</code> query parameter to also retrieve custom attribute definitions
     * in the same call.
     * When all response pages are retrieved, the results include all custom attributes that are
     * visible to the requesting application, including those that are owned by other applications
     * and set to <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<SyncPagingIterable<CustomAttribute>> list(ListCustomAttributesRequest request) {
        return list(request, null);
    }

    /**
     * Lists the <a href="entity:CustomAttribute">custom attributes</a> associated with a location.
     * You can use the <code>with_definitions</code> query parameter to also retrieve custom attribute definitions
     * in the same call.
     * When all response pages are retrieved, the results include all custom attributes that are
     * visible to the requesting application, including those that are owned by other applications
     * and set to <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<SyncPagingIterable<CustomAttribute>> list(
            ListCustomAttributesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
                .addPathSegments("custom-attributes");
        if (request.getVisibilityFilter().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "visibility_filter",
                    request.getVisibilityFilter().get().toString(),
                    false);
        }
        if (request.getLimit().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "limit", request.getLimit().get().toString(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getWithDefinitions().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "with_definitions",
                    request.getWithDefinitions().get().toString(),
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
        CompletableFuture<SyncPagingIterable<CustomAttribute>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        ListLocationCustomAttributesResponse parsedResponse = ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), ListLocationCustomAttributesResponse.class);
                        Optional<String> startingAfter = parsedResponse.getCursor();
                        ListCustomAttributesRequest nextRequest = ListCustomAttributesRequest.builder()
                                .from(request)
                                .cursor(startingAfter)
                                .build();
                        List<CustomAttribute> result =
                                parsedResponse.getCustomAttributes().orElse(Collections.emptyList());
                        future.complete(
                                new SyncPagingIterable<CustomAttribute>(startingAfter.isPresent(), result, () -> {
                                    try {
                                        return list(nextRequest, requestOptions).get();
                                    } catch (InterruptedException | ExecutionException e) {
                                        throw new RuntimeException(e);
                                    }
                                }));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Retrieves a <a href="entity:CustomAttribute">custom attribute</a> associated with a location.
     * You can use the <code>with_definition</code> query parameter to also retrieve the custom attribute definition
     * in the same call.
     * To retrieve a custom attribute owned by another application, the <code>visibility</code> setting must be
     * <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<RetrieveLocationCustomAttributeResponse> get(GetCustomAttributesRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves a <a href="entity:CustomAttribute">custom attribute</a> associated with a location.
     * You can use the <code>with_definition</code> query parameter to also retrieve the custom attribute definition
     * in the same call.
     * To retrieve a custom attribute owned by another application, the <code>visibility</code> setting must be
     * <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<RetrieveLocationCustomAttributeResponse> get(
            GetCustomAttributesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
                .addPathSegments("custom-attributes")
                .addPathSegment(request.getKey());
        if (request.getWithDefinition().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "with_definition",
                    request.getWithDefinition().get().toString(),
                    false);
        }
        if (request.getVersion().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "version", request.getVersion().get().toString(), false);
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
        CompletableFuture<RetrieveLocationCustomAttributeResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), RetrieveLocationCustomAttributeResponse.class));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Creates or updates a <a href="entity:CustomAttribute">custom attribute</a> for a location.
     * Use this endpoint to set the value of a custom attribute for a specified location.
     * A custom attribute is based on a custom attribute definition in a Square seller account, which
     * is created using the <a href="api-endpoint:LocationCustomAttributes-CreateLocationCustomAttributeDefinition">CreateLocationCustomAttributeDefinition</a> endpoint.
     * To create or update a custom attribute owned by another application, the <code>visibility</code> setting
     * must be <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<UpsertLocationCustomAttributeResponse> upsert(
            UpsertLocationCustomAttributeRequest request) {
        return upsert(request, null);
    }

    /**
     * Creates or updates a <a href="entity:CustomAttribute">custom attribute</a> for a location.
     * Use this endpoint to set the value of a custom attribute for a specified location.
     * A custom attribute is based on a custom attribute definition in a Square seller account, which
     * is created using the <a href="api-endpoint:LocationCustomAttributes-CreateLocationCustomAttributeDefinition">CreateLocationCustomAttributeDefinition</a> endpoint.
     * To create or update a custom attribute owned by another application, the <code>visibility</code> setting
     * must be <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<UpsertLocationCustomAttributeResponse> upsert(
            UpsertLocationCustomAttributeRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
                .addPathSegments("custom-attributes")
                .addPathSegment(request.getKey())
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
        CompletableFuture<UpsertLocationCustomAttributeResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), UpsertLocationCustomAttributeResponse.class));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Deletes a <a href="entity:CustomAttribute">custom attribute</a> associated with a location.
     * To delete a custom attribute owned by another application, the <code>visibility</code> setting must be
     * <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<DeleteLocationCustomAttributeResponse> delete(DeleteCustomAttributesRequest request) {
        return delete(request, null);
    }

    /**
     * Deletes a <a href="entity:CustomAttribute">custom attribute</a> associated with a location.
     * To delete a custom attribute owned by another application, the <code>visibility</code> setting must be
     * <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<DeleteLocationCustomAttributeResponse> delete(
            DeleteCustomAttributesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
                .addPathSegments("custom-attributes")
                .addPathSegment(request.getKey())
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<DeleteLocationCustomAttributeResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), DeleteLocationCustomAttributeResponse.class));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
            }
        });
        return future;
    }
}
