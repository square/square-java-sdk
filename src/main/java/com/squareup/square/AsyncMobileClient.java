/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.types.CreateMobileAuthorizationCodeRequest;
import com.squareup.square.types.CreateMobileAuthorizationCodeResponse;
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

public class AsyncMobileClient {
    protected final ClientOptions clientOptions;

    public AsyncMobileClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * <strong>Note:</strong> This endpoint is used by the deprecated Reader SDK.
     * Developers should update their integration to use the <a href="https://developer.squareup.com/docs/mobile-payments-sdk">Mobile Payments SDK</a>, which includes its own authorization methods.
     * <p>Generates code to authorize a mobile application to connect to a Square card reader.</p>
     * <p>Authorization codes are one-time-use codes and expire 60 minutes after being issued.</p>
     * <p>The <code>Authorization</code> header you provide to this endpoint must have the following format:</p>
     * <pre><code>Authorization: Bearer ACCESS_TOKEN
     * </code></pre>
     * <p>Replace <code>ACCESS_TOKEN</code> with a
     * <a href="https://developer.squareup.com/docs/build-basics/access-tokens">valid production authorization credential</a>.</p>
     */
    public CompletableFuture<CreateMobileAuthorizationCodeResponse> authorizationCode() {
        return authorizationCode(CreateMobileAuthorizationCodeRequest.builder().build());
    }

    /**
     * <strong>Note:</strong> This endpoint is used by the deprecated Reader SDK.
     * Developers should update their integration to use the <a href="https://developer.squareup.com/docs/mobile-payments-sdk">Mobile Payments SDK</a>, which includes its own authorization methods.
     * <p>Generates code to authorize a mobile application to connect to a Square card reader.</p>
     * <p>Authorization codes are one-time-use codes and expire 60 minutes after being issued.</p>
     * <p>The <code>Authorization</code> header you provide to this endpoint must have the following format:</p>
     * <pre><code>Authorization: Bearer ACCESS_TOKEN
     * </code></pre>
     * <p>Replace <code>ACCESS_TOKEN</code> with a
     * <a href="https://developer.squareup.com/docs/build-basics/access-tokens">valid production authorization credential</a>.</p>
     */
    public CompletableFuture<CreateMobileAuthorizationCodeResponse> authorizationCode(
            CreateMobileAuthorizationCodeRequest request) {
        return authorizationCode(request, null);
    }

    /**
     * <strong>Note:</strong> This endpoint is used by the deprecated Reader SDK.
     * Developers should update their integration to use the <a href="https://developer.squareup.com/docs/mobile-payments-sdk">Mobile Payments SDK</a>, which includes its own authorization methods.
     * <p>Generates code to authorize a mobile application to connect to a Square card reader.</p>
     * <p>Authorization codes are one-time-use codes and expire 60 minutes after being issued.</p>
     * <p>The <code>Authorization</code> header you provide to this endpoint must have the following format:</p>
     * <pre><code>Authorization: Bearer ACCESS_TOKEN
     * </code></pre>
     * <p>Replace <code>ACCESS_TOKEN</code> with a
     * <a href="https://developer.squareup.com/docs/build-basics/access-tokens">valid production authorization credential</a>.</p>
     */
    public CompletableFuture<CreateMobileAuthorizationCodeResponse> authorizationCode(
            CreateMobileAuthorizationCodeRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("mobile/authorization-code")
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
        CompletableFuture<CreateMobileAuthorizationCodeResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), CreateMobileAuthorizationCodeResponse.class));
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
