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
import com.squareup.square.types.RegisterDomainRequest;
import com.squareup.square.types.RegisterDomainResponse;
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

public class AsyncApplePayClient {
    protected final ClientOptions clientOptions;

    public AsyncApplePayClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Activates a domain for use with Apple Pay on the Web and Square. A validation
     * is performed on this domain by Apple to ensure that it is properly set up as
     * an Apple Pay enabled domain.
     * <p>This endpoint provides an easy way for platform developers to bulk activate
     * Apple Pay on the Web with Square for merchants using their platform.</p>
     * <p>Note: You will need to host a valid domain verification file on your domain to support Apple Pay.  The
     * current version of this file is always available at https://app.squareup.com/digital-wallets/apple-pay/apple-developer-merchantid-domain-association,
     * and should be hosted at <code>.well_known/apple-developer-merchantid-domain-association</code> on your
     * domain.  This file is subject to change; we strongly recommend checking for updates regularly and avoiding
     * long-lived caches that might not keep in sync with the correct file version.</p>
     * <p>To learn more about the Web Payments SDK and how to add Apple Pay, see <a href="https://developer.squareup.com/docs/web-payments/apple-pay">Take an Apple Pay Payment</a>.</p>
     */
    public CompletableFuture<RegisterDomainResponse> registerDomain(RegisterDomainRequest request) {
        return registerDomain(request, null);
    }

    /**
     * Activates a domain for use with Apple Pay on the Web and Square. A validation
     * is performed on this domain by Apple to ensure that it is properly set up as
     * an Apple Pay enabled domain.
     * <p>This endpoint provides an easy way for platform developers to bulk activate
     * Apple Pay on the Web with Square for merchants using their platform.</p>
     * <p>Note: You will need to host a valid domain verification file on your domain to support Apple Pay.  The
     * current version of this file is always available at https://app.squareup.com/digital-wallets/apple-pay/apple-developer-merchantid-domain-association,
     * and should be hosted at <code>.well_known/apple-developer-merchantid-domain-association</code> on your
     * domain.  This file is subject to change; we strongly recommend checking for updates regularly and avoiding
     * long-lived caches that might not keep in sync with the correct file version.</p>
     * <p>To learn more about the Web Payments SDK and how to add Apple Pay, see <a href="https://developer.squareup.com/docs/web-payments/apple-pay">Take an Apple Pay Payment</a>.</p>
     */
    public CompletableFuture<RegisterDomainResponse> registerDomain(
            RegisterDomainRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/apple-pay/domains")
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
        CompletableFuture<RegisterDomainResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), RegisterDomainResponse.class));
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
