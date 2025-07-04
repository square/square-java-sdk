/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.terminal;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.terminal.types.CancelCheckoutsRequest;
import com.squareup.square.terminal.types.CreateTerminalCheckoutRequest;
import com.squareup.square.terminal.types.GetCheckoutsRequest;
import com.squareup.square.terminal.types.SearchTerminalCheckoutsRequest;
import com.squareup.square.types.CancelTerminalCheckoutResponse;
import com.squareup.square.types.CreateTerminalCheckoutResponse;
import com.squareup.square.types.GetTerminalCheckoutResponse;
import com.squareup.square.types.SearchTerminalCheckoutsResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncCheckoutsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawCheckoutsClient rawClient;

    public AsyncCheckoutsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawCheckoutsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawCheckoutsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Creates a Terminal checkout request and sends it to the specified device to take a payment
     * for the requested amount.
     */
    public CompletableFuture<CreateTerminalCheckoutResponse> create(CreateTerminalCheckoutRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Creates a Terminal checkout request and sends it to the specified device to take a payment
     * for the requested amount.
     */
    public CompletableFuture<CreateTerminalCheckoutResponse> create(
            CreateTerminalCheckoutRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a filtered list of Terminal checkout requests created by the application making the request. Only Terminal checkout requests created for the merchant scoped to the OAuth token are returned. Terminal checkout requests are available for 30 days.
     */
    public CompletableFuture<SearchTerminalCheckoutsResponse> search() {
        return this.rawClient.search().thenApply(response -> response.body());
    }

    /**
     * Returns a filtered list of Terminal checkout requests created by the application making the request. Only Terminal checkout requests created for the merchant scoped to the OAuth token are returned. Terminal checkout requests are available for 30 days.
     */
    public CompletableFuture<SearchTerminalCheckoutsResponse> search(SearchTerminalCheckoutsRequest request) {
        return this.rawClient.search(request).thenApply(response -> response.body());
    }

    /**
     * Returns a filtered list of Terminal checkout requests created by the application making the request. Only Terminal checkout requests created for the merchant scoped to the OAuth token are returned. Terminal checkout requests are available for 30 days.
     */
    public CompletableFuture<SearchTerminalCheckoutsResponse> search(
            SearchTerminalCheckoutsRequest request, RequestOptions requestOptions) {
        return this.rawClient.search(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Retrieves a Terminal checkout request by <code>checkout_id</code>. Terminal checkout requests are available for 30 days.
     */
    public CompletableFuture<GetTerminalCheckoutResponse> get(GetCheckoutsRequest request) {
        return this.rawClient.get(request).thenApply(response -> response.body());
    }

    /**
     * Retrieves a Terminal checkout request by <code>checkout_id</code>. Terminal checkout requests are available for 30 days.
     */
    public CompletableFuture<GetTerminalCheckoutResponse> get(
            GetCheckoutsRequest request, RequestOptions requestOptions) {
        return this.rawClient.get(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Cancels a Terminal checkout request if the status of the request permits it.
     */
    public CompletableFuture<CancelTerminalCheckoutResponse> cancel(CancelCheckoutsRequest request) {
        return this.rawClient.cancel(request).thenApply(response -> response.body());
    }

    /**
     * Cancels a Terminal checkout request if the status of the request permits it.
     */
    public CompletableFuture<CancelTerminalCheckoutResponse> cancel(
            CancelCheckoutsRequest request, RequestOptions requestOptions) {
        return this.rawClient.cancel(request, requestOptions).thenApply(response -> response.body());
    }
}
