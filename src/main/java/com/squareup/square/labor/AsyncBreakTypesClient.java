/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.labor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.labor.types.CreateBreakTypeRequest;
import com.squareup.square.labor.types.DeleteBreakTypesRequest;
import com.squareup.square.labor.types.GetBreakTypesRequest;
import com.squareup.square.labor.types.ListBreakTypesRequest;
import com.squareup.square.labor.types.UpdateBreakTypeRequest;
import com.squareup.square.types.BreakType;
import com.squareup.square.types.CreateBreakTypeResponse;
import com.squareup.square.types.DeleteBreakTypeResponse;
import com.squareup.square.types.GetBreakTypeResponse;
import com.squareup.square.types.ListBreakTypesResponse;
import com.squareup.square.types.UpdateBreakTypeResponse;
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

public class AsyncBreakTypesClient {
    protected final ClientOptions clientOptions;

    public AsyncBreakTypesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a paginated list of <code>BreakType</code> instances for a business.
     */
    public CompletableFuture<SyncPagingIterable<BreakType>> list() {
        return list(ListBreakTypesRequest.builder().build());
    }

    /**
     * Returns a paginated list of <code>BreakType</code> instances for a business.
     */
    public CompletableFuture<SyncPagingIterable<BreakType>> list(ListBreakTypesRequest request) {
        return list(request, null);
    }

    /**
     * Returns a paginated list of <code>BreakType</code> instances for a business.
     */
    public CompletableFuture<SyncPagingIterable<BreakType>> list(
            ListBreakTypesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/labor/break-types");
        if (request.getLocationId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "location_id", request.getLocationId().get(), false);
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
        CompletableFuture<SyncPagingIterable<BreakType>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        ListBreakTypesResponse parsedResponse = ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), ListBreakTypesResponse.class);
                        Optional<String> startingAfter = parsedResponse.getCursor();
                        ListBreakTypesRequest nextRequest = ListBreakTypesRequest.builder()
                                .from(request)
                                .cursor(startingAfter)
                                .build();
                        List<BreakType> result = parsedResponse.getBreakTypes().orElse(Collections.emptyList());
                        future.complete(new SyncPagingIterable<BreakType>(startingAfter.isPresent(), result, () -> {
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
     * Creates a new <code>BreakType</code>.
     * <p>A <code>BreakType</code> is a template for creating <code>Break</code> objects.
     * You must provide the following values in your request to this
     * endpoint:</p>
     * <ul>
     * <li><code>location_id</code></li>
     * <li><code>break_name</code></li>
     * <li><code>expected_duration</code></li>
     * <li><code>is_paid</code></li>
     * </ul>
     * <p>You can only have three <code>BreakType</code> instances per location. If you attempt to add a fourth
     * <code>BreakType</code> for a location, an <code>INVALID_REQUEST_ERROR</code> &quot;Exceeded limit of 3 breaks per location.&quot;
     * is returned.</p>
     */
    public CompletableFuture<CreateBreakTypeResponse> create(CreateBreakTypeRequest request) {
        return create(request, null);
    }

    /**
     * Creates a new <code>BreakType</code>.
     * <p>A <code>BreakType</code> is a template for creating <code>Break</code> objects.
     * You must provide the following values in your request to this
     * endpoint:</p>
     * <ul>
     * <li><code>location_id</code></li>
     * <li><code>break_name</code></li>
     * <li><code>expected_duration</code></li>
     * <li><code>is_paid</code></li>
     * </ul>
     * <p>You can only have three <code>BreakType</code> instances per location. If you attempt to add a fourth
     * <code>BreakType</code> for a location, an <code>INVALID_REQUEST_ERROR</code> &quot;Exceeded limit of 3 breaks per location.&quot;
     * is returned.</p>
     */
    public CompletableFuture<CreateBreakTypeResponse> create(
            CreateBreakTypeRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/labor/break-types")
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
        CompletableFuture<CreateBreakTypeResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), CreateBreakTypeResponse.class));
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
     * Returns a single <code>BreakType</code> specified by <code>id</code>.
     */
    public CompletableFuture<GetBreakTypeResponse> get(GetBreakTypesRequest request) {
        return get(request, null);
    }

    /**
     * Returns a single <code>BreakType</code> specified by <code>id</code>.
     */
    public CompletableFuture<GetBreakTypeResponse> get(GetBreakTypesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/labor/break-types")
                .addPathSegment(request.getId())
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<GetBreakTypeResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetBreakTypeResponse.class));
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
     * Updates an existing <code>BreakType</code>.
     */
    public CompletableFuture<UpdateBreakTypeResponse> update(UpdateBreakTypeRequest request) {
        return update(request, null);
    }

    /**
     * Updates an existing <code>BreakType</code>.
     */
    public CompletableFuture<UpdateBreakTypeResponse> update(
            UpdateBreakTypeRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/labor/break-types")
                .addPathSegment(request.getId())
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
        CompletableFuture<UpdateBreakTypeResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), UpdateBreakTypeResponse.class));
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
     * Deletes an existing <code>BreakType</code>.
     * <p>A <code>BreakType</code> can be deleted even if it is referenced from a <code>Shift</code>.</p>
     */
    public CompletableFuture<DeleteBreakTypeResponse> delete(DeleteBreakTypesRequest request) {
        return delete(request, null);
    }

    /**
     * Deletes an existing <code>BreakType</code>.
     * <p>A <code>BreakType</code> can be deleted even if it is referenced from a <code>Shift</code>.</p>
     */
    public CompletableFuture<DeleteBreakTypeResponse> delete(
            DeleteBreakTypesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/labor/break-types")
                .addPathSegment(request.getId())
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
        CompletableFuture<DeleteBreakTypeResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), DeleteBreakTypeResponse.class));
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
