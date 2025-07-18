/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.terminal;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.terminal.types.CancelActionsRequest;
import com.squareup.square.terminal.types.CreateTerminalActionRequest;
import com.squareup.square.terminal.types.GetActionsRequest;
import com.squareup.square.terminal.types.SearchTerminalActionsRequest;
import com.squareup.square.types.CancelTerminalActionResponse;
import com.squareup.square.types.CreateTerminalActionResponse;
import com.squareup.square.types.GetTerminalActionResponse;
import com.squareup.square.types.SearchTerminalActionsResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncActionsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawActionsClient rawClient;

    public AsyncActionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawActionsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawActionsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Creates a Terminal action request and sends it to the specified device.
     */
    public CompletableFuture<CreateTerminalActionResponse> create(CreateTerminalActionRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Creates a Terminal action request and sends it to the specified device.
     */
    public CompletableFuture<CreateTerminalActionResponse> create(
            CreateTerminalActionRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Retrieves a filtered list of Terminal action requests created by the account making the request. Terminal action requests are available for 30 days.
     */
    public CompletableFuture<SearchTerminalActionsResponse> search() {
        return this.rawClient.search().thenApply(response -> response.body());
    }

    /**
     * Retrieves a filtered list of Terminal action requests created by the account making the request. Terminal action requests are available for 30 days.
     */
    public CompletableFuture<SearchTerminalActionsResponse> search(SearchTerminalActionsRequest request) {
        return this.rawClient.search(request).thenApply(response -> response.body());
    }

    /**
     * Retrieves a filtered list of Terminal action requests created by the account making the request. Terminal action requests are available for 30 days.
     */
    public CompletableFuture<SearchTerminalActionsResponse> search(
            SearchTerminalActionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.search(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Retrieves a Terminal action request by <code>action_id</code>. Terminal action requests are available for 30 days.
     */
    public CompletableFuture<GetTerminalActionResponse> get(GetActionsRequest request) {
        return this.rawClient.get(request).thenApply(response -> response.body());
    }

    /**
     * Retrieves a Terminal action request by <code>action_id</code>. Terminal action requests are available for 30 days.
     */
    public CompletableFuture<GetTerminalActionResponse> get(GetActionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.get(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Cancels a Terminal action request if the status of the request permits it.
     */
    public CompletableFuture<CancelTerminalActionResponse> cancel(CancelActionsRequest request) {
        return this.rawClient.cancel(request).thenApply(response -> response.body());
    }

    /**
     * Cancels a Terminal action request if the status of the request permits it.
     */
    public CompletableFuture<CancelTerminalActionResponse> cancel(
            CancelActionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.cancel(request, requestOptions).thenApply(response -> response.body());
    }
}
