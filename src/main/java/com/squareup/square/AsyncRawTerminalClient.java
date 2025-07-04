/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareClientHttpResponse;
import com.squareup.square.core.SquareException;
import com.squareup.square.types.DismissTerminalActionRequest;
import com.squareup.square.types.DismissTerminalActionResponse;
import com.squareup.square.types.DismissTerminalCheckoutRequest;
import com.squareup.square.types.DismissTerminalCheckoutResponse;
import com.squareup.square.types.DismissTerminalRefundRequest;
import com.squareup.square.types.DismissTerminalRefundResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
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

public class AsyncRawTerminalClient {
    protected final ClientOptions clientOptions;

    public AsyncRawTerminalClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Dismisses a Terminal action request if the status and type of the request permits it.
     * <p>See <a href="https://developer.squareup.com/docs/terminal-api/advanced-features/custom-workflows/link-and-dismiss-actions">Link and Dismiss Actions</a> for more details.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<DismissTerminalActionResponse>> dismissTerminalAction(
            DismissTerminalActionRequest request) {
        return dismissTerminalAction(request, null);
    }

    /**
     * Dismisses a Terminal action request if the status and type of the request permits it.
     * <p>See <a href="https://developer.squareup.com/docs/terminal-api/advanced-features/custom-workflows/link-and-dismiss-actions">Link and Dismiss Actions</a> for more details.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<DismissTerminalActionResponse>> dismissTerminalAction(
            DismissTerminalActionRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/terminals/actions")
                .addPathSegment(request.getActionId())
                .addPathSegments("dismiss")
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SquareClientHttpResponse<DismissTerminalActionResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SquareClientHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(
                                        responseBody.string(), DismissTerminalActionResponse.class),
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
     * Dismisses a Terminal checkout request if the status and type of the request permits it.
     */
    public CompletableFuture<SquareClientHttpResponse<DismissTerminalCheckoutResponse>> dismissTerminalCheckout(
            DismissTerminalCheckoutRequest request) {
        return dismissTerminalCheckout(request, null);
    }

    /**
     * Dismisses a Terminal checkout request if the status and type of the request permits it.
     */
    public CompletableFuture<SquareClientHttpResponse<DismissTerminalCheckoutResponse>> dismissTerminalCheckout(
            DismissTerminalCheckoutRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/terminals/checkouts")
                .addPathSegment(request.getCheckoutId())
                .addPathSegments("dismiss")
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SquareClientHttpResponse<DismissTerminalCheckoutResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SquareClientHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(
                                        responseBody.string(), DismissTerminalCheckoutResponse.class),
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
     * Dismisses a Terminal refund request if the status and type of the request permits it.
     */
    public CompletableFuture<SquareClientHttpResponse<DismissTerminalRefundResponse>> dismissTerminalRefund(
            DismissTerminalRefundRequest request) {
        return dismissTerminalRefund(request, null);
    }

    /**
     * Dismisses a Terminal refund request if the status and type of the request permits it.
     */
    public CompletableFuture<SquareClientHttpResponse<DismissTerminalRefundResponse>> dismissTerminalRefund(
            DismissTerminalRefundRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/terminals/refunds")
                .addPathSegment(request.getTerminalRefundId())
                .addPathSegments("dismiss")
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SquareClientHttpResponse<DismissTerminalRefundResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SquareClientHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(
                                        responseBody.string(), DismissTerminalRefundResponse.class),
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
