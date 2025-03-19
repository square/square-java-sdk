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
import com.squareup.square.locations.types.CreateLocationCustomAttributeDefinitionRequest;
import com.squareup.square.locations.types.DeleteCustomAttributeDefinitionsRequest;
import com.squareup.square.locations.types.GetCustomAttributeDefinitionsRequest;
import com.squareup.square.locations.types.ListCustomAttributeDefinitionsRequest;
import com.squareup.square.locations.types.UpdateLocationCustomAttributeDefinitionRequest;
import com.squareup.square.types.CreateLocationCustomAttributeDefinitionResponse;
import com.squareup.square.types.CustomAttributeDefinition;
import com.squareup.square.types.DeleteLocationCustomAttributeDefinitionResponse;
import com.squareup.square.types.ListLocationCustomAttributeDefinitionsResponse;
import com.squareup.square.types.RetrieveLocationCustomAttributeDefinitionResponse;
import com.squareup.square.types.UpdateLocationCustomAttributeDefinitionResponse;
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

public class AsyncCustomAttributeDefinitionsClient {
    protected final ClientOptions clientOptions;

    public AsyncCustomAttributeDefinitionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Lists the location-related <a href="entity:CustomAttributeDefinition">custom attribute definitions</a> that belong to a Square seller account.
     * When all response pages are retrieved, the results include all custom attribute definitions
     * that are visible to the requesting application, including those that are created by other
     * applications and set to <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<SyncPagingIterable<CustomAttributeDefinition>> list() {
        return list(ListCustomAttributeDefinitionsRequest.builder().build());
    }

    /**
     * Lists the location-related <a href="entity:CustomAttributeDefinition">custom attribute definitions</a> that belong to a Square seller account.
     * When all response pages are retrieved, the results include all custom attribute definitions
     * that are visible to the requesting application, including those that are created by other
     * applications and set to <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<SyncPagingIterable<CustomAttributeDefinition>> list(
            ListCustomAttributeDefinitionsRequest request) {
        return list(request, null);
    }

    /**
     * Lists the location-related <a href="entity:CustomAttributeDefinition">custom attribute definitions</a> that belong to a Square seller account.
     * When all response pages are retrieved, the results include all custom attribute definitions
     * that are visible to the requesting application, including those that are created by other
     * applications and set to <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<SyncPagingIterable<CustomAttributeDefinition>> list(
            ListCustomAttributeDefinitionsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations/custom-attribute-definitions");
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
        CompletableFuture<SyncPagingIterable<CustomAttributeDefinition>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        ListLocationCustomAttributeDefinitionsResponse parsedResponse =
                                ObjectMappers.JSON_MAPPER.readValue(
                                        responseBody.string(), ListLocationCustomAttributeDefinitionsResponse.class);
                        Optional<String> startingAfter = parsedResponse.getCursor();
                        ListCustomAttributeDefinitionsRequest nextRequest =
                                ListCustomAttributeDefinitionsRequest.builder()
                                        .from(request)
                                        .cursor(startingAfter)
                                        .build();
                        List<CustomAttributeDefinition> result =
                                parsedResponse.getCustomAttributeDefinitions().orElse(Collections.emptyList());
                        future.complete(new SyncPagingIterable<CustomAttributeDefinition>(
                                startingAfter.isPresent(), result, () -> {
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
     * Creates a location-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> for a Square seller account.
     * Use this endpoint to define a custom attribute that can be associated with locations.
     * A custom attribute definition specifies the <code>key</code>, <code>visibility</code>, <code>schema</code>, and other properties
     * for a custom attribute. After the definition is created, you can call
     * <a href="api-endpoint:LocationCustomAttributes-UpsertLocationCustomAttribute">UpsertLocationCustomAttribute</a> or
     * <a href="api-endpoint:LocationCustomAttributes-BulkUpsertLocationCustomAttributes">BulkUpsertLocationCustomAttributes</a>
     * to set the custom attribute for locations.
     */
    public CompletableFuture<CreateLocationCustomAttributeDefinitionResponse> create(
            CreateLocationCustomAttributeDefinitionRequest request) {
        return create(request, null);
    }

    /**
     * Creates a location-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> for a Square seller account.
     * Use this endpoint to define a custom attribute that can be associated with locations.
     * A custom attribute definition specifies the <code>key</code>, <code>visibility</code>, <code>schema</code>, and other properties
     * for a custom attribute. After the definition is created, you can call
     * <a href="api-endpoint:LocationCustomAttributes-UpsertLocationCustomAttribute">UpsertLocationCustomAttribute</a> or
     * <a href="api-endpoint:LocationCustomAttributes-BulkUpsertLocationCustomAttributes">BulkUpsertLocationCustomAttributes</a>
     * to set the custom attribute for locations.
     */
    public CompletableFuture<CreateLocationCustomAttributeDefinitionResponse> create(
            CreateLocationCustomAttributeDefinitionRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations/custom-attribute-definitions")
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
        CompletableFuture<CreateLocationCustomAttributeDefinitionResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), CreateLocationCustomAttributeDefinitionResponse.class));
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
     * Retrieves a location-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> from a Square seller account.
     * To retrieve a custom attribute definition created by another application, the <code>visibility</code>
     * setting must be <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<RetrieveLocationCustomAttributeDefinitionResponse> get(
            GetCustomAttributeDefinitionsRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves a location-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> from a Square seller account.
     * To retrieve a custom attribute definition created by another application, the <code>visibility</code>
     * setting must be <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<RetrieveLocationCustomAttributeDefinitionResponse> get(
            GetCustomAttributeDefinitionsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations/custom-attribute-definitions")
                .addPathSegment(request.getKey());
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
        CompletableFuture<RetrieveLocationCustomAttributeDefinitionResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), RetrieveLocationCustomAttributeDefinitionResponse.class));
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
     * Updates a location-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> for a Square seller account.
     * Use this endpoint to update the following fields: <code>name</code>, <code>description</code>, <code>visibility</code>, or the
     * <code>schema</code> for a <code>Selection</code> data type.
     * Only the definition owner can update a custom attribute definition.
     */
    public CompletableFuture<UpdateLocationCustomAttributeDefinitionResponse> update(
            UpdateLocationCustomAttributeDefinitionRequest request) {
        return update(request, null);
    }

    /**
     * Updates a location-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> for a Square seller account.
     * Use this endpoint to update the following fields: <code>name</code>, <code>description</code>, <code>visibility</code>, or the
     * <code>schema</code> for a <code>Selection</code> data type.
     * Only the definition owner can update a custom attribute definition.
     */
    public CompletableFuture<UpdateLocationCustomAttributeDefinitionResponse> update(
            UpdateLocationCustomAttributeDefinitionRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations/custom-attribute-definitions")
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
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<UpdateLocationCustomAttributeDefinitionResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), UpdateLocationCustomAttributeDefinitionResponse.class));
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
     * Deletes a location-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> from a Square seller account.
     * Deleting a custom attribute definition also deletes the corresponding custom attribute from
     * all locations.
     * Only the definition owner can delete a custom attribute definition.
     */
    public CompletableFuture<DeleteLocationCustomAttributeDefinitionResponse> delete(
            DeleteCustomAttributeDefinitionsRequest request) {
        return delete(request, null);
    }

    /**
     * Deletes a location-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> from a Square seller account.
     * Deleting a custom attribute definition also deletes the corresponding custom attribute from
     * all locations.
     * Only the definition owner can delete a custom attribute definition.
     */
    public CompletableFuture<DeleteLocationCustomAttributeDefinitionResponse> delete(
            DeleteCustomAttributeDefinitionsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations/custom-attribute-definitions")
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
        CompletableFuture<DeleteLocationCustomAttributeDefinitionResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), DeleteLocationCustomAttributeDefinitionResponse.class));
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
