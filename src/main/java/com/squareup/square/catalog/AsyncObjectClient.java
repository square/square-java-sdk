/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.catalog;

import com.squareup.square.catalog.types.DeleteObjectRequest;
import com.squareup.square.catalog.types.GetObjectRequest;
import com.squareup.square.catalog.types.UpsertCatalogObjectRequest;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.types.DeleteCatalogObjectResponse;
import com.squareup.square.types.GetCatalogObjectResponse;
import com.squareup.square.types.UpsertCatalogObjectResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncObjectClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawObjectClient rawClient;

    public AsyncObjectClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawObjectClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawObjectClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Creates a new or updates the specified <a href="entity:CatalogObject">CatalogObject</a>.
     * <p>To ensure consistency, only one update request is processed at a time per seller account.
     * While one (batch or non-batch) update request is being processed, other (batched and non-batched)
     * update requests are rejected with the <code>429</code> error code.</p>
     */
    public CompletableFuture<UpsertCatalogObjectResponse> upsert(UpsertCatalogObjectRequest request) {
        return this.rawClient.upsert(request).thenApply(response -> response.body());
    }

    /**
     * Creates a new or updates the specified <a href="entity:CatalogObject">CatalogObject</a>.
     * <p>To ensure consistency, only one update request is processed at a time per seller account.
     * While one (batch or non-batch) update request is being processed, other (batched and non-batched)
     * update requests are rejected with the <code>429</code> error code.</p>
     */
    public CompletableFuture<UpsertCatalogObjectResponse> upsert(
            UpsertCatalogObjectRequest request, RequestOptions requestOptions) {
        return this.rawClient.upsert(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a single <a href="entity:CatalogItem">CatalogItem</a> as a
     * <a href="entity:CatalogObject">CatalogObject</a> based on the provided ID. The returned
     * object includes all of the relevant <a href="entity:CatalogItem">CatalogItem</a>
     * information including: <a href="entity:CatalogItemVariation">CatalogItemVariation</a>
     * children, references to its
     * <a href="entity:CatalogModifierList">CatalogModifierList</a> objects, and the ids of
     * any <a href="entity:CatalogTax">CatalogTax</a> objects that apply to it.
     */
    public CompletableFuture<GetCatalogObjectResponse> get(GetObjectRequest request) {
        return this.rawClient.get(request).thenApply(response -> response.body());
    }

    /**
     * Returns a single <a href="entity:CatalogItem">CatalogItem</a> as a
     * <a href="entity:CatalogObject">CatalogObject</a> based on the provided ID. The returned
     * object includes all of the relevant <a href="entity:CatalogItem">CatalogItem</a>
     * information including: <a href="entity:CatalogItemVariation">CatalogItemVariation</a>
     * children, references to its
     * <a href="entity:CatalogModifierList">CatalogModifierList</a> objects, and the ids of
     * any <a href="entity:CatalogTax">CatalogTax</a> objects that apply to it.
     */
    public CompletableFuture<GetCatalogObjectResponse> get(GetObjectRequest request, RequestOptions requestOptions) {
        return this.rawClient.get(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Deletes a single <a href="entity:CatalogObject">CatalogObject</a> based on the
     * provided ID and returns the set of successfully deleted IDs in the response.
     * Deletion is a cascading event such that all children of the targeted object
     * are also deleted. For example, deleting a <a href="entity:CatalogItem">CatalogItem</a>
     * will also delete all of its
     * <a href="entity:CatalogItemVariation">CatalogItemVariation</a> children.
     * <p>To ensure consistency, only one delete request is processed at a time per seller account.
     * While one (batch or non-batch) delete request is being processed, other (batched and non-batched)
     * delete requests are rejected with the <code>429</code> error code.</p>
     */
    public CompletableFuture<DeleteCatalogObjectResponse> delete(DeleteObjectRequest request) {
        return this.rawClient.delete(request).thenApply(response -> response.body());
    }

    /**
     * Deletes a single <a href="entity:CatalogObject">CatalogObject</a> based on the
     * provided ID and returns the set of successfully deleted IDs in the response.
     * Deletion is a cascading event such that all children of the targeted object
     * are also deleted. For example, deleting a <a href="entity:CatalogItem">CatalogItem</a>
     * will also delete all of its
     * <a href="entity:CatalogItemVariation">CatalogItemVariation</a> children.
     * <p>To ensure consistency, only one delete request is processed at a time per seller account.
     * While one (batch or non-batch) delete request is being processed, other (batched and non-batched)
     * delete requests are rejected with the <code>429</code> error code.</p>
     */
    public CompletableFuture<DeleteCatalogObjectResponse> delete(
            DeleteObjectRequest request, RequestOptions requestOptions) {
        return this.rawClient.delete(request, requestOptions).thenApply(response -> response.body());
    }
}
