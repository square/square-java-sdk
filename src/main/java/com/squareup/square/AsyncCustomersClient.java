/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.Suppliers;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.customers.AsyncCardsClient;
import com.squareup.square.customers.AsyncCustomAttributeDefinitionsClient;
import com.squareup.square.customers.AsyncCustomAttributesClient;
import com.squareup.square.customers.AsyncGroupsClient;
import com.squareup.square.customers.AsyncSegmentsClient;
import com.squareup.square.types.BulkCreateCustomersRequest;
import com.squareup.square.types.BulkCreateCustomersResponse;
import com.squareup.square.types.BulkDeleteCustomersRequest;
import com.squareup.square.types.BulkDeleteCustomersResponse;
import com.squareup.square.types.BulkRetrieveCustomersRequest;
import com.squareup.square.types.BulkRetrieveCustomersResponse;
import com.squareup.square.types.BulkUpdateCustomersRequest;
import com.squareup.square.types.BulkUpdateCustomersResponse;
import com.squareup.square.types.CreateCustomerRequest;
import com.squareup.square.types.CreateCustomerResponse;
import com.squareup.square.types.Customer;
import com.squareup.square.types.DeleteCustomerResponse;
import com.squareup.square.types.DeleteCustomersRequest;
import com.squareup.square.types.GetCustomerResponse;
import com.squareup.square.types.GetCustomersRequest;
import com.squareup.square.types.ListCustomersRequest;
import com.squareup.square.types.SearchCustomersRequest;
import com.squareup.square.types.SearchCustomersResponse;
import com.squareup.square.types.UpdateCustomerRequest;
import com.squareup.square.types.UpdateCustomerResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class AsyncCustomersClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawCustomersClient rawClient;

    protected final Supplier<AsyncCustomAttributeDefinitionsClient> customAttributeDefinitionsClient;

    protected final Supplier<AsyncGroupsClient> groupsClient;

    protected final Supplier<AsyncSegmentsClient> segmentsClient;

    protected final Supplier<AsyncCardsClient> cardsClient;

    protected final Supplier<AsyncCustomAttributesClient> customAttributesClient;

    public AsyncCustomersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawCustomersClient(clientOptions);
        this.customAttributeDefinitionsClient =
                Suppliers.memoize(() -> new AsyncCustomAttributeDefinitionsClient(clientOptions));
        this.groupsClient = Suppliers.memoize(() -> new AsyncGroupsClient(clientOptions));
        this.segmentsClient = Suppliers.memoize(() -> new AsyncSegmentsClient(clientOptions));
        this.cardsClient = Suppliers.memoize(() -> new AsyncCardsClient(clientOptions));
        this.customAttributesClient = Suppliers.memoize(() -> new AsyncCustomAttributesClient(clientOptions));
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawCustomersClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Lists customer profiles associated with a Square account.
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the listing operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public CompletableFuture<SyncPagingIterable<Customer>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Lists customer profiles associated with a Square account.
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the listing operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public CompletableFuture<SyncPagingIterable<Customer>> list(ListCustomersRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Lists customer profiles associated with a Square account.
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the listing operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public CompletableFuture<SyncPagingIterable<Customer>> list(
            ListCustomersRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Creates a new customer for a business.
     * <p>You must provide at least one of the following values in your request to this
     * endpoint:</p>
     * <ul>
     * <li><code>given_name</code></li>
     * <li><code>family_name</code></li>
     * <li><code>company_name</code></li>
     * <li><code>email_address</code></li>
     * <li><code>phone_number</code></li>
     * </ul>
     */
    public CompletableFuture<CreateCustomerResponse> create() {
        return this.rawClient.create().thenApply(response -> response.body());
    }

    /**
     * Creates a new customer for a business.
     * <p>You must provide at least one of the following values in your request to this
     * endpoint:</p>
     * <ul>
     * <li><code>given_name</code></li>
     * <li><code>family_name</code></li>
     * <li><code>company_name</code></li>
     * <li><code>email_address</code></li>
     * <li><code>phone_number</code></li>
     * </ul>
     */
    public CompletableFuture<CreateCustomerResponse> create(CreateCustomerRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Creates a new customer for a business.
     * <p>You must provide at least one of the following values in your request to this
     * endpoint:</p>
     * <ul>
     * <li><code>given_name</code></li>
     * <li><code>family_name</code></li>
     * <li><code>company_name</code></li>
     * <li><code>email_address</code></li>
     * <li><code>phone_number</code></li>
     * </ul>
     */
    public CompletableFuture<CreateCustomerResponse> create(
            CreateCustomerRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Creates multiple <a href="entity:Customer">customer profiles</a> for a business.
     * <p>This endpoint takes a map of individual create requests and returns a map of responses.</p>
     * <p>You must provide at least one of the following values in each create request:</p>
     * <ul>
     * <li><code>given_name</code></li>
     * <li><code>family_name</code></li>
     * <li><code>company_name</code></li>
     * <li><code>email_address</code></li>
     * <li><code>phone_number</code></li>
     * </ul>
     */
    public CompletableFuture<BulkCreateCustomersResponse> batchCreate(BulkCreateCustomersRequest request) {
        return this.rawClient.batchCreate(request).thenApply(response -> response.body());
    }

    /**
     * Creates multiple <a href="entity:Customer">customer profiles</a> for a business.
     * <p>This endpoint takes a map of individual create requests and returns a map of responses.</p>
     * <p>You must provide at least one of the following values in each create request:</p>
     * <ul>
     * <li><code>given_name</code></li>
     * <li><code>family_name</code></li>
     * <li><code>company_name</code></li>
     * <li><code>email_address</code></li>
     * <li><code>phone_number</code></li>
     * </ul>
     */
    public CompletableFuture<BulkCreateCustomersResponse> batchCreate(
            BulkCreateCustomersRequest request, RequestOptions requestOptions) {
        return this.rawClient.batchCreate(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Deletes multiple customer profiles.
     * <p>The endpoint takes a list of customer IDs and returns a map of responses.</p>
     */
    public CompletableFuture<BulkDeleteCustomersResponse> bulkDeleteCustomers(BulkDeleteCustomersRequest request) {
        return this.rawClient.bulkDeleteCustomers(request).thenApply(response -> response.body());
    }

    /**
     * Deletes multiple customer profiles.
     * <p>The endpoint takes a list of customer IDs and returns a map of responses.</p>
     */
    public CompletableFuture<BulkDeleteCustomersResponse> bulkDeleteCustomers(
            BulkDeleteCustomersRequest request, RequestOptions requestOptions) {
        return this.rawClient.bulkDeleteCustomers(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Retrieves multiple customer profiles.
     * <p>This endpoint takes a list of customer IDs and returns a map of responses.</p>
     */
    public CompletableFuture<BulkRetrieveCustomersResponse> bulkRetrieveCustomers(
            BulkRetrieveCustomersRequest request) {
        return this.rawClient.bulkRetrieveCustomers(request).thenApply(response -> response.body());
    }

    /**
     * Retrieves multiple customer profiles.
     * <p>This endpoint takes a list of customer IDs and returns a map of responses.</p>
     */
    public CompletableFuture<BulkRetrieveCustomersResponse> bulkRetrieveCustomers(
            BulkRetrieveCustomersRequest request, RequestOptions requestOptions) {
        return this.rawClient.bulkRetrieveCustomers(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Updates multiple customer profiles.
     * <p>This endpoint takes a map of individual update requests and returns a map of responses.</p>
     */
    public CompletableFuture<BulkUpdateCustomersResponse> bulkUpdateCustomers(BulkUpdateCustomersRequest request) {
        return this.rawClient.bulkUpdateCustomers(request).thenApply(response -> response.body());
    }

    /**
     * Updates multiple customer profiles.
     * <p>This endpoint takes a map of individual update requests and returns a map of responses.</p>
     */
    public CompletableFuture<BulkUpdateCustomersResponse> bulkUpdateCustomers(
            BulkUpdateCustomersRequest request, RequestOptions requestOptions) {
        return this.rawClient.bulkUpdateCustomers(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Searches the customer profiles associated with a Square account using one or more supported query filters.
     * <p>Calling <code>SearchCustomers</code> without any explicit query filter returns all
     * customer profiles ordered alphabetically based on <code>given_name</code> and
     * <code>family_name</code>.</p>
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the search operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public CompletableFuture<SearchCustomersResponse> search() {
        return this.rawClient.search().thenApply(response -> response.body());
    }

    /**
     * Searches the customer profiles associated with a Square account using one or more supported query filters.
     * <p>Calling <code>SearchCustomers</code> without any explicit query filter returns all
     * customer profiles ordered alphabetically based on <code>given_name</code> and
     * <code>family_name</code>.</p>
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the search operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public CompletableFuture<SearchCustomersResponse> search(SearchCustomersRequest request) {
        return this.rawClient.search(request).thenApply(response -> response.body());
    }

    /**
     * Searches the customer profiles associated with a Square account using one or more supported query filters.
     * <p>Calling <code>SearchCustomers</code> without any explicit query filter returns all
     * customer profiles ordered alphabetically based on <code>given_name</code> and
     * <code>family_name</code>.</p>
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the search operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public CompletableFuture<SearchCustomersResponse> search(
            SearchCustomersRequest request, RequestOptions requestOptions) {
        return this.rawClient.search(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns details for a single customer.
     */
    public CompletableFuture<GetCustomerResponse> get(GetCustomersRequest request) {
        return this.rawClient.get(request).thenApply(response -> response.body());
    }

    /**
     * Returns details for a single customer.
     */
    public CompletableFuture<GetCustomerResponse> get(GetCustomersRequest request, RequestOptions requestOptions) {
        return this.rawClient.get(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Updates a customer profile. This endpoint supports sparse updates, so only new or changed fields are required in the request.
     * To add or update a field, specify the new value. To remove a field, specify <code>null</code>.
     * <p>To update a customer profile that was created by merging existing profiles, you must use the ID of the newly created profile.</p>
     */
    public CompletableFuture<UpdateCustomerResponse> update(UpdateCustomerRequest request) {
        return this.rawClient.update(request).thenApply(response -> response.body());
    }

    /**
     * Updates a customer profile. This endpoint supports sparse updates, so only new or changed fields are required in the request.
     * To add or update a field, specify the new value. To remove a field, specify <code>null</code>.
     * <p>To update a customer profile that was created by merging existing profiles, you must use the ID of the newly created profile.</p>
     */
    public CompletableFuture<UpdateCustomerResponse> update(
            UpdateCustomerRequest request, RequestOptions requestOptions) {
        return this.rawClient.update(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Deletes a customer profile from a business.
     * <p>To delete a customer profile that was created by merging existing profiles, you must use the ID of the newly created profile.</p>
     */
    public CompletableFuture<DeleteCustomerResponse> delete(DeleteCustomersRequest request) {
        return this.rawClient.delete(request).thenApply(response -> response.body());
    }

    /**
     * Deletes a customer profile from a business.
     * <p>To delete a customer profile that was created by merging existing profiles, you must use the ID of the newly created profile.</p>
     */
    public CompletableFuture<DeleteCustomerResponse> delete(
            DeleteCustomersRequest request, RequestOptions requestOptions) {
        return this.rawClient.delete(request, requestOptions).thenApply(response -> response.body());
    }

    public AsyncCustomAttributeDefinitionsClient customAttributeDefinitions() {
        return this.customAttributeDefinitionsClient.get();
    }

    public AsyncGroupsClient groups() {
        return this.groupsClient.get();
    }

    public AsyncSegmentsClient segments() {
        return this.segmentsClient.get();
    }

    public AsyncCardsClient cards() {
        return this.cardsClient.get();
    }

    public AsyncCustomAttributesClient customAttributes() {
        return this.customAttributesClient.get();
    }
}
