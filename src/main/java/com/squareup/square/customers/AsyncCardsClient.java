/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.customers;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.customers.types.CreateCustomerCardRequest;
import com.squareup.square.customers.types.DeleteCardsRequest;
import com.squareup.square.types.CreateCustomerCardResponse;
import com.squareup.square.types.DeleteCustomerCardResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncCardsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawCardsClient rawClient;

    public AsyncCardsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawCardsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawCardsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Adds a card on file to an existing customer.
     * <p>As with charges, calls to <code>CreateCustomerCard</code> are idempotent. Multiple
     * calls with the same card nonce return the same card record that was created
     * with the provided nonce during the <em>first</em> call.</p>
     */
    public CompletableFuture<CreateCustomerCardResponse> create(CreateCustomerCardRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Adds a card on file to an existing customer.
     * <p>As with charges, calls to <code>CreateCustomerCard</code> are idempotent. Multiple
     * calls with the same card nonce return the same card record that was created
     * with the provided nonce during the <em>first</em> call.</p>
     */
    public CompletableFuture<CreateCustomerCardResponse> create(
            CreateCustomerCardRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Removes a card on file from a customer.
     */
    public CompletableFuture<DeleteCustomerCardResponse> delete(DeleteCardsRequest request) {
        return this.rawClient.delete(request).thenApply(response -> response.body());
    }

    /**
     * Removes a card on file from a customer.
     */
    public CompletableFuture<DeleteCustomerCardResponse> delete(
            DeleteCardsRequest request, RequestOptions requestOptions) {
        return this.rawClient.delete(request, requestOptions).thenApply(response -> response.body());
    }
}
