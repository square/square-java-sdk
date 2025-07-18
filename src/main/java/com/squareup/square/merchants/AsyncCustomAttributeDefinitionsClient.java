/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.merchants;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.merchants.types.CreateMerchantCustomAttributeDefinitionRequest;
import com.squareup.square.merchants.types.DeleteCustomAttributeDefinitionsRequest;
import com.squareup.square.merchants.types.GetCustomAttributeDefinitionsRequest;
import com.squareup.square.merchants.types.ListCustomAttributeDefinitionsRequest;
import com.squareup.square.merchants.types.UpdateMerchantCustomAttributeDefinitionRequest;
import com.squareup.square.types.CreateMerchantCustomAttributeDefinitionResponse;
import com.squareup.square.types.CustomAttributeDefinition;
import com.squareup.square.types.DeleteMerchantCustomAttributeDefinitionResponse;
import com.squareup.square.types.RetrieveMerchantCustomAttributeDefinitionResponse;
import com.squareup.square.types.UpdateMerchantCustomAttributeDefinitionResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncCustomAttributeDefinitionsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawCustomAttributeDefinitionsClient rawClient;

    public AsyncCustomAttributeDefinitionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawCustomAttributeDefinitionsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawCustomAttributeDefinitionsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Lists the merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definitions</a> that belong to a Square seller account.
     * When all response pages are retrieved, the results include all custom attribute definitions
     * that are visible to the requesting application, including those that are created by other
     * applications and set to <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<SyncPagingIterable<CustomAttributeDefinition>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Lists the merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definitions</a> that belong to a Square seller account.
     * When all response pages are retrieved, the results include all custom attribute definitions
     * that are visible to the requesting application, including those that are created by other
     * applications and set to <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<SyncPagingIterable<CustomAttributeDefinition>> list(
            ListCustomAttributeDefinitionsRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Lists the merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definitions</a> that belong to a Square seller account.
     * When all response pages are retrieved, the results include all custom attribute definitions
     * that are visible to the requesting application, including those that are created by other
     * applications and set to <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<SyncPagingIterable<CustomAttributeDefinition>> list(
            ListCustomAttributeDefinitionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Creates a merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> for a Square seller account.
     * Use this endpoint to define a custom attribute that can be associated with a merchant connecting to your application.
     * A custom attribute definition specifies the <code>key</code>, <code>visibility</code>, <code>schema</code>, and other properties
     * for a custom attribute. After the definition is created, you can call
     * <a href="api-endpoint:MerchantCustomAttributes-UpsertMerchantCustomAttribute">UpsertMerchantCustomAttribute</a> or
     * <a href="api-endpoint:MerchantCustomAttributes-BulkUpsertMerchantCustomAttributes">BulkUpsertMerchantCustomAttributes</a>
     * to set the custom attribute for a merchant.
     */
    public CompletableFuture<CreateMerchantCustomAttributeDefinitionResponse> create(
            CreateMerchantCustomAttributeDefinitionRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Creates a merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> for a Square seller account.
     * Use this endpoint to define a custom attribute that can be associated with a merchant connecting to your application.
     * A custom attribute definition specifies the <code>key</code>, <code>visibility</code>, <code>schema</code>, and other properties
     * for a custom attribute. After the definition is created, you can call
     * <a href="api-endpoint:MerchantCustomAttributes-UpsertMerchantCustomAttribute">UpsertMerchantCustomAttribute</a> or
     * <a href="api-endpoint:MerchantCustomAttributes-BulkUpsertMerchantCustomAttributes">BulkUpsertMerchantCustomAttributes</a>
     * to set the custom attribute for a merchant.
     */
    public CompletableFuture<CreateMerchantCustomAttributeDefinitionResponse> create(
            CreateMerchantCustomAttributeDefinitionRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Retrieves a merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> from a Square seller account.
     * To retrieve a custom attribute definition created by another application, the <code>visibility</code>
     * setting must be <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<RetrieveMerchantCustomAttributeDefinitionResponse> get(
            GetCustomAttributeDefinitionsRequest request) {
        return this.rawClient.get(request).thenApply(response -> response.body());
    }

    /**
     * Retrieves a merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> from a Square seller account.
     * To retrieve a custom attribute definition created by another application, the <code>visibility</code>
     * setting must be <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.
     */
    public CompletableFuture<RetrieveMerchantCustomAttributeDefinitionResponse> get(
            GetCustomAttributeDefinitionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.get(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Updates a merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> for a Square seller account.
     * Use this endpoint to update the following fields: <code>name</code>, <code>description</code>, <code>visibility</code>, or the
     * <code>schema</code> for a <code>Selection</code> data type.
     * Only the definition owner can update a custom attribute definition.
     */
    public CompletableFuture<UpdateMerchantCustomAttributeDefinitionResponse> update(
            UpdateMerchantCustomAttributeDefinitionRequest request) {
        return this.rawClient.update(request).thenApply(response -> response.body());
    }

    /**
     * Updates a merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> for a Square seller account.
     * Use this endpoint to update the following fields: <code>name</code>, <code>description</code>, <code>visibility</code>, or the
     * <code>schema</code> for a <code>Selection</code> data type.
     * Only the definition owner can update a custom attribute definition.
     */
    public CompletableFuture<UpdateMerchantCustomAttributeDefinitionResponse> update(
            UpdateMerchantCustomAttributeDefinitionRequest request, RequestOptions requestOptions) {
        return this.rawClient.update(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Deletes a merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> from a Square seller account.
     * Deleting a custom attribute definition also deletes the corresponding custom attribute from
     * the merchant.
     * Only the definition owner can delete a custom attribute definition.
     */
    public CompletableFuture<DeleteMerchantCustomAttributeDefinitionResponse> delete(
            DeleteCustomAttributeDefinitionsRequest request) {
        return this.rawClient.delete(request).thenApply(response -> response.body());
    }

    /**
     * Deletes a merchant-related <a href="entity:CustomAttributeDefinition">custom attribute definition</a> from a Square seller account.
     * Deleting a custom attribute definition also deletes the corresponding custom attribute from
     * the merchant.
     * Only the definition owner can delete a custom attribute definition.
     */
    public CompletableFuture<DeleteMerchantCustomAttributeDefinitionResponse> delete(
            DeleteCustomAttributeDefinitionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.delete(request, requestOptions).thenApply(response -> response.body());
    }
}
