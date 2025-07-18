/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.labor;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareClientHttpResponse;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.labor.types.GetEmployeeWagesRequest;
import com.squareup.square.labor.types.ListEmployeeWagesRequest;
import com.squareup.square.types.EmployeeWage;
import com.squareup.square.types.GetEmployeeWageResponse;
import com.squareup.square.types.ListEmployeeWagesResponse;
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
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public class AsyncRawEmployeeWagesClient {
    protected final ClientOptions clientOptions;

    public AsyncRawEmployeeWagesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a paginated list of <code>EmployeeWage</code> instances for a business.
     */
    public CompletableFuture<SquareClientHttpResponse<SyncPagingIterable<EmployeeWage>>> list() {
        return list(ListEmployeeWagesRequest.builder().build());
    }

    /**
     * Returns a paginated list of <code>EmployeeWage</code> instances for a business.
     */
    public CompletableFuture<SquareClientHttpResponse<SyncPagingIterable<EmployeeWage>>> list(
            ListEmployeeWagesRequest request) {
        return list(request, null);
    }

    /**
     * Returns a paginated list of <code>EmployeeWage</code> instances for a business.
     */
    public CompletableFuture<SquareClientHttpResponse<SyncPagingIterable<EmployeeWage>>> list(
            ListEmployeeWagesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/labor/employee-wages");
        if (request.getEmployeeId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "employee_id", request.getEmployeeId().get(), false);
        }
        if (request.getLimit().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "limit", request.getLimit().get(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SquareClientHttpResponse<SyncPagingIterable<EmployeeWage>>> future =
                new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        ListEmployeeWagesResponse parsedResponse = ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), ListEmployeeWagesResponse.class);
                        Optional<String> startingAfter = parsedResponse.getCursor();
                        ListEmployeeWagesRequest nextRequest = ListEmployeeWagesRequest.builder()
                                .from(request)
                                .cursor(startingAfter)
                                .build();
                        List<EmployeeWage> result =
                                parsedResponse.getEmployeeWages().orElse(Collections.emptyList());
                        future.complete(new SquareClientHttpResponse<>(
                                new SyncPagingIterable<EmployeeWage>(startingAfter.isPresent(), result, () -> {
                                    try {
                                        return list(nextRequest, requestOptions)
                                                .get()
                                                .body();
                                    } catch (InterruptedException | ExecutionException e) {
                                        throw new RuntimeException(e);
                                    }
                                }),
                                response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
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
     * Returns a single <code>EmployeeWage</code> specified by <code>id</code>.
     */
    public CompletableFuture<SquareClientHttpResponse<GetEmployeeWageResponse>> get(GetEmployeeWagesRequest request) {
        return get(request, null);
    }

    /**
     * Returns a single <code>EmployeeWage</code> specified by <code>id</code>.
     */
    public CompletableFuture<SquareClientHttpResponse<GetEmployeeWageResponse>> get(
            GetEmployeeWagesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/labor/employee-wages")
                .addPathSegment(request.getId())
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SquareClientHttpResponse<GetEmployeeWageResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SquareClientHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(
                                        responseBody.string(), GetEmployeeWageResponse.class),
                                response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
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
