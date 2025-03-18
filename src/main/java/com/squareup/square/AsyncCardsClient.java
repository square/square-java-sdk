/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.Card;
import com.squareup.square.types.CreateCardRequest;
import com.squareup.square.types.CreateCardResponse;
import com.squareup.square.types.DisableCardResponse;
import com.squareup.square.types.DisableCardsRequest;
import com.squareup.square.types.GetCardResponse;
import com.squareup.square.types.GetCardsRequest;
import com.squareup.square.types.ListCardsRequest;
import com.squareup.square.types.ListCardsResponse;
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

public class AsyncCardsClient {
    protected final ClientOptions clientOptions;

    public AsyncCardsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Retrieves a list of cards owned by the account making the request.
     * A max of 25 cards will be returned.
     */
    public CompletableFuture<SyncPagingIterable<Card>> list() {
        return list(ListCardsRequest.builder().build());
    }

    /**
     * Retrieves a list of cards owned by the account making the request.
     * A max of 25 cards will be returned.
     */
    public CompletableFuture<SyncPagingIterable<Card>> list(ListCardsRequest request) {
        return list(request, null);
    }

    /**
     * Retrieves a list of cards owned by the account making the request.
     * A max of 25 cards will be returned.
     */
    public CompletableFuture<SyncPagingIterable<Card>> list(ListCardsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/cards");
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getCustomerId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "customer_id", request.getCustomerId().get(), false);
        }
        if (request.getIncludeDisabled().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_disabled",
                    request.getIncludeDisabled().get().toString(),
                    false);
        }
        if (request.getReferenceId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "reference_id", request.getReferenceId().get(), false);
        }
        if (request.getSortOrder().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "sort_order", request.getSortOrder().get().toString(), false);
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
        CompletableFuture<SyncPagingIterable<Card>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        ListCardsResponse parsedResponse =
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListCardsResponse.class);
                        Optional<String> startingAfter = parsedResponse.getCursor();
                        ListCardsRequest nextRequest = ListCardsRequest.builder()
                                .from(request)
                                .cursor(startingAfter)
                                .build();
                        List<Card> result = parsedResponse.getCards().orElse(Collections.emptyList());
                        future.complete(new SyncPagingIterable<Card>(startingAfter.isPresent(), result, () -> {
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
     * Adds a card on file to an existing merchant.
     */
    public CompletableFuture<CreateCardResponse> create(CreateCardRequest request) {
        return create(request, null);
    }

    /**
     * Adds a card on file to an existing merchant.
     */
    public CompletableFuture<CreateCardResponse> create(CreateCardRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/cards")
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
        CompletableFuture<CreateCardResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CreateCardResponse.class));
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
     * Retrieves details for a specific Card.
     */
    public CompletableFuture<GetCardResponse> get(GetCardsRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves details for a specific Card.
     */
    public CompletableFuture<GetCardResponse> get(GetCardsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/cards")
                .addPathSegment(request.getCardId())
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
        CompletableFuture<GetCardResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetCardResponse.class));
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
     * Disables the card, preventing any further updates or charges.
     * Disabling an already disabled card is allowed but has no effect.
     */
    public CompletableFuture<DisableCardResponse> disable(DisableCardsRequest request) {
        return disable(request, null);
    }

    /**
     * Disables the card, preventing any further updates or charges.
     * Disabling an already disabled card is allowed but has no effect.
     */
    public CompletableFuture<DisableCardResponse> disable(DisableCardsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/cards")
                .addPathSegment(request.getCardId())
                .addPathSegments("disable")
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<DisableCardResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), DisableCardResponse.class));
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
