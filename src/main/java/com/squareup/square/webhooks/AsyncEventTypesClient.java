/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.webhooks;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.types.ListWebhookEventTypesResponse;
import com.squareup.square.webhooks.types.ListEventTypesRequest;
import java.util.concurrent.CompletableFuture;

public class AsyncEventTypesClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawEventTypesClient rawClient;

    public AsyncEventTypesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawEventTypesClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawEventTypesClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Lists all webhook event types that can be subscribed to.
     */
    public CompletableFuture<ListWebhookEventTypesResponse> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Lists all webhook event types that can be subscribed to.
     */
    public CompletableFuture<ListWebhookEventTypesResponse> list(ListEventTypesRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Lists all webhook event types that can be subscribed to.
     */
    public CompletableFuture<ListWebhookEventTypesResponse> list(
            ListEventTypesRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }
}
