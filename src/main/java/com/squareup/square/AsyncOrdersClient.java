/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.Suppliers;
import com.squareup.square.orders.AsyncCustomAttributeDefinitionsClient;
import com.squareup.square.orders.AsyncCustomAttributesClient;
import com.squareup.square.types.BatchGetOrdersRequest;
import com.squareup.square.types.BatchGetOrdersResponse;
import com.squareup.square.types.CalculateOrderRequest;
import com.squareup.square.types.CalculateOrderResponse;
import com.squareup.square.types.CloneOrderRequest;
import com.squareup.square.types.CloneOrderResponse;
import com.squareup.square.types.CreateOrderRequest;
import com.squareup.square.types.CreateOrderResponse;
import com.squareup.square.types.GetOrderResponse;
import com.squareup.square.types.GetOrdersRequest;
import com.squareup.square.types.PayOrderRequest;
import com.squareup.square.types.PayOrderResponse;
import com.squareup.square.types.SearchOrdersRequest;
import com.squareup.square.types.SearchOrdersResponse;
import com.squareup.square.types.UpdateOrderRequest;
import com.squareup.square.types.UpdateOrderResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class AsyncOrdersClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawOrdersClient rawClient;

    protected final Supplier<AsyncCustomAttributeDefinitionsClient> customAttributeDefinitionsClient;

    protected final Supplier<AsyncCustomAttributesClient> customAttributesClient;

    public AsyncOrdersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawOrdersClient(clientOptions);
        this.customAttributeDefinitionsClient =
                Suppliers.memoize(() -> new AsyncCustomAttributeDefinitionsClient(clientOptions));
        this.customAttributesClient = Suppliers.memoize(() -> new AsyncCustomAttributesClient(clientOptions));
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawOrdersClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Creates a new <a href="entity:Order">order</a> that can include information about products for
     * purchase and settings to apply to the purchase.
     * <p>To pay for a created order, see
     * <a href="https://developer.squareup.com/docs/orders-api/pay-for-orders">Pay for Orders</a>.</p>
     * <p>You can modify open orders using the <a href="api-endpoint:Orders-UpdateOrder">UpdateOrder</a> endpoint.</p>
     */
    public CompletableFuture<CreateOrderResponse> create() {
        return this.rawClient.create().thenApply(response -> response.body());
    }

    /**
     * Creates a new <a href="entity:Order">order</a> that can include information about products for
     * purchase and settings to apply to the purchase.
     * <p>To pay for a created order, see
     * <a href="https://developer.squareup.com/docs/orders-api/pay-for-orders">Pay for Orders</a>.</p>
     * <p>You can modify open orders using the <a href="api-endpoint:Orders-UpdateOrder">UpdateOrder</a> endpoint.</p>
     */
    public CompletableFuture<CreateOrderResponse> create(CreateOrderRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Creates a new <a href="entity:Order">order</a> that can include information about products for
     * purchase and settings to apply to the purchase.
     * <p>To pay for a created order, see
     * <a href="https://developer.squareup.com/docs/orders-api/pay-for-orders">Pay for Orders</a>.</p>
     * <p>You can modify open orders using the <a href="api-endpoint:Orders-UpdateOrder">UpdateOrder</a> endpoint.</p>
     */
    public CompletableFuture<CreateOrderResponse> create(CreateOrderRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Retrieves a set of <a href="entity:Order">orders</a> by their IDs.
     * <p>If a given order ID does not exist, the ID is ignored instead of generating an error.</p>
     */
    public CompletableFuture<BatchGetOrdersResponse> batchGet(BatchGetOrdersRequest request) {
        return this.rawClient.batchGet(request).thenApply(response -> response.body());
    }

    /**
     * Retrieves a set of <a href="entity:Order">orders</a> by their IDs.
     * <p>If a given order ID does not exist, the ID is ignored instead of generating an error.</p>
     */
    public CompletableFuture<BatchGetOrdersResponse> batchGet(
            BatchGetOrdersRequest request, RequestOptions requestOptions) {
        return this.rawClient.batchGet(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Enables applications to preview order pricing without creating an order.
     */
    public CompletableFuture<CalculateOrderResponse> calculate(CalculateOrderRequest request) {
        return this.rawClient.calculate(request).thenApply(response -> response.body());
    }

    /**
     * Enables applications to preview order pricing without creating an order.
     */
    public CompletableFuture<CalculateOrderResponse> calculate(
            CalculateOrderRequest request, RequestOptions requestOptions) {
        return this.rawClient.calculate(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Creates a new order, in the <code>DRAFT</code> state, by duplicating an existing order. The newly created order has
     * only the core fields (such as line items, taxes, and discounts) copied from the original order.
     */
    public CompletableFuture<CloneOrderResponse> clone(CloneOrderRequest request) {
        return this.rawClient.clone(request).thenApply(response -> response.body());
    }

    /**
     * Creates a new order, in the <code>DRAFT</code> state, by duplicating an existing order. The newly created order has
     * only the core fields (such as line items, taxes, and discounts) copied from the original order.
     */
    public CompletableFuture<CloneOrderResponse> clone(CloneOrderRequest request, RequestOptions requestOptions) {
        return this.rawClient.clone(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Search all orders for one or more locations. Orders include all sales,
     * returns, and exchanges regardless of how or when they entered the Square
     * ecosystem (such as Point of Sale, Invoices, and Connect APIs).
     * <p><code>SearchOrders</code> requests need to specify which locations to search and define a
     * <a href="entity:SearchOrdersQuery">SearchOrdersQuery</a> object that controls
     * how to sort or filter the results. Your <code>SearchOrdersQuery</code> can:</p>
     * <p>Set filter criteria.
     * Set the sort order.
     * Determine whether to return results as complete <code>Order</code> objects or as
     * <a href="entity:OrderEntry">OrderEntry</a> objects.</p>
     * <p>Note that details for orders processed with Square Point of Sale while in
     * offline mode might not be transmitted to Square for up to 72 hours. Offline
     * orders have a <code>created_at</code> value that reflects the time the order was created,
     * not the time it was subsequently transmitted to Square.</p>
     */
    public CompletableFuture<SearchOrdersResponse> search() {
        return this.rawClient.search().thenApply(response -> response.body());
    }

    /**
     * Search all orders for one or more locations. Orders include all sales,
     * returns, and exchanges regardless of how or when they entered the Square
     * ecosystem (such as Point of Sale, Invoices, and Connect APIs).
     * <p><code>SearchOrders</code> requests need to specify which locations to search and define a
     * <a href="entity:SearchOrdersQuery">SearchOrdersQuery</a> object that controls
     * how to sort or filter the results. Your <code>SearchOrdersQuery</code> can:</p>
     * <p>Set filter criteria.
     * Set the sort order.
     * Determine whether to return results as complete <code>Order</code> objects or as
     * <a href="entity:OrderEntry">OrderEntry</a> objects.</p>
     * <p>Note that details for orders processed with Square Point of Sale while in
     * offline mode might not be transmitted to Square for up to 72 hours. Offline
     * orders have a <code>created_at</code> value that reflects the time the order was created,
     * not the time it was subsequently transmitted to Square.</p>
     */
    public CompletableFuture<SearchOrdersResponse> search(SearchOrdersRequest request) {
        return this.rawClient.search(request).thenApply(response -> response.body());
    }

    /**
     * Search all orders for one or more locations. Orders include all sales,
     * returns, and exchanges regardless of how or when they entered the Square
     * ecosystem (such as Point of Sale, Invoices, and Connect APIs).
     * <p><code>SearchOrders</code> requests need to specify which locations to search and define a
     * <a href="entity:SearchOrdersQuery">SearchOrdersQuery</a> object that controls
     * how to sort or filter the results. Your <code>SearchOrdersQuery</code> can:</p>
     * <p>Set filter criteria.
     * Set the sort order.
     * Determine whether to return results as complete <code>Order</code> objects or as
     * <a href="entity:OrderEntry">OrderEntry</a> objects.</p>
     * <p>Note that details for orders processed with Square Point of Sale while in
     * offline mode might not be transmitted to Square for up to 72 hours. Offline
     * orders have a <code>created_at</code> value that reflects the time the order was created,
     * not the time it was subsequently transmitted to Square.</p>
     */
    public CompletableFuture<SearchOrdersResponse> search(SearchOrdersRequest request, RequestOptions requestOptions) {
        return this.rawClient.search(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Retrieves an <a href="entity:Order">Order</a> by ID.
     */
    public CompletableFuture<GetOrderResponse> get(GetOrdersRequest request) {
        return this.rawClient.get(request).thenApply(response -> response.body());
    }

    /**
     * Retrieves an <a href="entity:Order">Order</a> by ID.
     */
    public CompletableFuture<GetOrderResponse> get(GetOrdersRequest request, RequestOptions requestOptions) {
        return this.rawClient.get(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Updates an open <a href="entity:Order">order</a> by adding, replacing, or deleting
     * fields. Orders with a <code>COMPLETED</code> or <code>CANCELED</code> state cannot be updated.
     * <p>An <code>UpdateOrder</code> request requires the following:</p>
     * <ul>
     * <li>The <code>order_id</code> in the endpoint path, identifying the order to update.</li>
     * <li>The latest <code>version</code> of the order to update.</li>
     * <li>The <a href="https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#sparse-order-objects">sparse order</a>
     * containing only the fields to update and the version to which the update is
     * being applied.</li>
     * <li>If deleting fields, the <a href="https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#identifying-fields-to-delete">dot notation paths</a>
     * identifying the fields to clear.</li>
     * </ul>
     * <p>To pay for an order, see
     * <a href="https://developer.squareup.com/docs/orders-api/pay-for-orders">Pay for Orders</a>.</p>
     */
    public CompletableFuture<UpdateOrderResponse> update(UpdateOrderRequest request) {
        return this.rawClient.update(request).thenApply(response -> response.body());
    }

    /**
     * Updates an open <a href="entity:Order">order</a> by adding, replacing, or deleting
     * fields. Orders with a <code>COMPLETED</code> or <code>CANCELED</code> state cannot be updated.
     * <p>An <code>UpdateOrder</code> request requires the following:</p>
     * <ul>
     * <li>The <code>order_id</code> in the endpoint path, identifying the order to update.</li>
     * <li>The latest <code>version</code> of the order to update.</li>
     * <li>The <a href="https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#sparse-order-objects">sparse order</a>
     * containing only the fields to update and the version to which the update is
     * being applied.</li>
     * <li>If deleting fields, the <a href="https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#identifying-fields-to-delete">dot notation paths</a>
     * identifying the fields to clear.</li>
     * </ul>
     * <p>To pay for an order, see
     * <a href="https://developer.squareup.com/docs/orders-api/pay-for-orders">Pay for Orders</a>.</p>
     */
    public CompletableFuture<UpdateOrderResponse> update(UpdateOrderRequest request, RequestOptions requestOptions) {
        return this.rawClient.update(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Pay for an <a href="entity:Order">order</a> using one or more approved <a href="entity:Payment">payments</a>
     * or settle an order with a total of <code>0</code>.
     * <p>The total of the <code>payment_ids</code> listed in the request must be equal to the order
     * total. Orders with a total amount of <code>0</code> can be marked as paid by specifying an empty
     * array of <code>payment_ids</code> in the request.</p>
     * <p>To be used with <code>PayOrder</code>, a payment must:</p>
     * <ul>
     * <li>Reference the order by specifying the <code>order_id</code> when <a href="api-endpoint:Payments-CreatePayment">creating the payment</a>.
     * Any approved payments that reference the same <code>order_id</code> not specified in the
     * <code>payment_ids</code> is canceled.</li>
     * <li>Be approved with <a href="https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture">delayed capture</a>.
     * Using a delayed capture payment with <code>PayOrder</code> completes the approved payment.</li>
     * </ul>
     */
    public CompletableFuture<PayOrderResponse> pay(PayOrderRequest request) {
        return this.rawClient.pay(request).thenApply(response -> response.body());
    }

    /**
     * Pay for an <a href="entity:Order">order</a> using one or more approved <a href="entity:Payment">payments</a>
     * or settle an order with a total of <code>0</code>.
     * <p>The total of the <code>payment_ids</code> listed in the request must be equal to the order
     * total. Orders with a total amount of <code>0</code> can be marked as paid by specifying an empty
     * array of <code>payment_ids</code> in the request.</p>
     * <p>To be used with <code>PayOrder</code>, a payment must:</p>
     * <ul>
     * <li>Reference the order by specifying the <code>order_id</code> when <a href="api-endpoint:Payments-CreatePayment">creating the payment</a>.
     * Any approved payments that reference the same <code>order_id</code> not specified in the
     * <code>payment_ids</code> is canceled.</li>
     * <li>Be approved with <a href="https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture">delayed capture</a>.
     * Using a delayed capture payment with <code>PayOrder</code> completes the approved payment.</li>
     * </ul>
     */
    public CompletableFuture<PayOrderResponse> pay(PayOrderRequest request, RequestOptions requestOptions) {
        return this.rawClient.pay(request, requestOptions).thenApply(response -> response.body());
    }

    public AsyncCustomAttributeDefinitionsClient customAttributeDefinitions() {
        return this.customAttributeDefinitionsClient.get();
    }

    public AsyncCustomAttributesClient customAttributes() {
        return this.customAttributesClient.get();
    }
}
