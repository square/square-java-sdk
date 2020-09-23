package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.BatchRetrieveOrdersRequest;
import com.squareup.square.models.BatchRetrieveOrdersResponse;
import com.squareup.square.models.CalculateOrderRequest;
import com.squareup.square.models.CalculateOrderResponse;
import com.squareup.square.models.CreateOrderRequest;
import com.squareup.square.models.CreateOrderResponse;
import com.squareup.square.models.PayOrderRequest;
import com.squareup.square.models.PayOrderResponse;
import com.squareup.square.models.SearchOrdersRequest;
import com.squareup.square.models.SearchOrdersResponse;
import com.squareup.square.models.UpdateOrderRequest;
import com.squareup.square.models.UpdateOrderResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface OrdersApi {
    /**
     * Creates a new [Order](#type-order) which can include information on products for
     * purchase and settings to apply to the purchase.
     * To pay for a created order, please refer to the [Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders)
     * guide.
     * You can modify open orders using the [UpdateOrder](#endpoint-orders-updateorder) endpoint.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateOrderResponse response from the API call
     */
    CreateOrderResponse createOrder(
            final CreateOrderRequest body) throws ApiException, IOException;

    /**
     * Creates a new [Order](#type-order) which can include information on products for
     * purchase and settings to apply to the purchase.
     * To pay for a created order, please refer to the [Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders)
     * guide.
     * You can modify open orders using the [UpdateOrder](#endpoint-orders-updateorder) endpoint.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateOrderResponse response from the API call 
     */
    CompletableFuture<CreateOrderResponse> createOrderAsync(
            final CreateOrderRequest body);

    /**
     * Retrieves a set of [Order](#type-order)s by their IDs.
     * If a given Order ID does not exist, the ID is ignored instead of generating an error.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveOrdersResponse response from the API call
     */
    BatchRetrieveOrdersResponse batchRetrieveOrders(
            final BatchRetrieveOrdersRequest body) throws ApiException, IOException;

    /**
     * Retrieves a set of [Order](#type-order)s by their IDs.
     * If a given Order ID does not exist, the ID is ignored instead of generating an error.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveOrdersResponse response from the API call 
     */
    CompletableFuture<BatchRetrieveOrdersResponse> batchRetrieveOrdersAsync(
            final BatchRetrieveOrdersRequest body);

    /**
     * Calculates an [Order](#type-order).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CalculateOrderResponse response from the API call
     */
    CalculateOrderResponse calculateOrder(
            final CalculateOrderRequest body) throws ApiException, IOException;

    /**
     * Calculates an [Order](#type-order).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CalculateOrderResponse response from the API call 
     */
    CompletableFuture<CalculateOrderResponse> calculateOrderAsync(
            final CalculateOrderRequest body);

    /**
     * Search all orders for one or more locations. Orders include all sales,
     * returns, and exchanges regardless of how or when they entered the Square
     * Ecosystem (e.g. Point of Sale, Invoices, Connect APIs, etc).
     * SearchOrders requests need to specify which locations to search and define a
     * [`SearchOrdersQuery`](#type-searchordersquery) object which controls
     * how to sort or filter the results. Your SearchOrdersQuery can:
     *   Set filter criteria.
     *   Set sort order.
     *   Determine whether to return results as complete Order objects, or as
     * [OrderEntry](#type-orderentry) objects.
     * Note that details for orders processed with Square Point of Sale while in
     * offline mode may not be transmitted to Square for up to 72 hours. Offline
     * orders have a `created_at` value that reflects the time the order was created,
     * not the time it was subsequently transmitted to Square.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchOrdersResponse response from the API call
     */
    SearchOrdersResponse searchOrders(
            final SearchOrdersRequest body) throws ApiException, IOException;

    /**
     * Search all orders for one or more locations. Orders include all sales,
     * returns, and exchanges regardless of how or when they entered the Square
     * Ecosystem (e.g. Point of Sale, Invoices, Connect APIs, etc).
     * SearchOrders requests need to specify which locations to search and define a
     * [`SearchOrdersQuery`](#type-searchordersquery) object which controls
     * how to sort or filter the results. Your SearchOrdersQuery can:
     *   Set filter criteria.
     *   Set sort order.
     *   Determine whether to return results as complete Order objects, or as
     * [OrderEntry](#type-orderentry) objects.
     * Note that details for orders processed with Square Point of Sale while in
     * offline mode may not be transmitted to Square for up to 72 hours. Offline
     * orders have a `created_at` value that reflects the time the order was created,
     * not the time it was subsequently transmitted to Square.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchOrdersResponse response from the API call 
     */
    CompletableFuture<SearchOrdersResponse> searchOrdersAsync(
            final SearchOrdersRequest body);

    /**
     * Updates an open [Order](#type-order) by adding, replacing, or deleting
     * fields. Orders with a `COMPLETED` or `CANCELED` state cannot be updated.
     * An UpdateOrder request requires the following:
     * - The `order_id` in the endpoint path, identifying the order to update.
     * - The latest `version` of the order to update.
     * - The [sparse order](https://developer.squareup.com/docs/orders-api/manage-orders#sparse-order-objects)
     * containing only the fields to update and the version the update is
     * being applied to.
     * - If deleting fields, the [dot notation paths](https://developer.squareup.com/docs/orders-api/manage-orders#on-dot-notation)
     * identifying fields to clear.
     * To pay for an order, please refer to the [Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders) guide.
     * @param    orderId    Required parameter: The ID of the order to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderResponse response from the API call
     */
    UpdateOrderResponse updateOrder(
            final String orderId,
            final UpdateOrderRequest body) throws ApiException, IOException;

    /**
     * Updates an open [Order](#type-order) by adding, replacing, or deleting
     * fields. Orders with a `COMPLETED` or `CANCELED` state cannot be updated.
     * An UpdateOrder request requires the following:
     * - The `order_id` in the endpoint path, identifying the order to update.
     * - The latest `version` of the order to update.
     * - The [sparse order](https://developer.squareup.com/docs/orders-api/manage-orders#sparse-order-objects)
     * containing only the fields to update and the version the update is
     * being applied to.
     * - If deleting fields, the [dot notation paths](https://developer.squareup.com/docs/orders-api/manage-orders#on-dot-notation)
     * identifying fields to clear.
     * To pay for an order, please refer to the [Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders) guide.
     * @param    orderId    Required parameter: The ID of the order to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderResponse response from the API call 
     */
    CompletableFuture<UpdateOrderResponse> updateOrderAsync(
            final String orderId,
            final UpdateOrderRequest body);

    /**
     * Pay for an [order](#type-order) using one or more approved [payments](#type-payment),
     * or settle an order with a total of `0`.
     * The total of the `payment_ids` listed in the request must be equal to the order
     * total. Orders with a total amount of `0` can be marked as paid by specifying an empty
     * array of `payment_ids` in the request.
     * To be used with PayOrder, a payment must:
     * - Reference the order by specifying the `order_id` when [creating the payment](#endpoint-payments-createpayment).
     * Any approved payments that reference the same `order_id` not specified in the
     * `payment_ids` will be canceled.
     * - Be approved with [delayed capture](https://developer.squareup.com/docs/payments-api/take-payments#delayed-capture).
     * Using a delayed capture payment with PayOrder will complete the approved payment.
     * @param    orderId    Required parameter: The ID of the order being paid.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the PayOrderResponse response from the API call
     */
    PayOrderResponse payOrder(
            final String orderId,
            final PayOrderRequest body) throws ApiException, IOException;

    /**
     * Pay for an [order](#type-order) using one or more approved [payments](#type-payment),
     * or settle an order with a total of `0`.
     * The total of the `payment_ids` listed in the request must be equal to the order
     * total. Orders with a total amount of `0` can be marked as paid by specifying an empty
     * array of `payment_ids` in the request.
     * To be used with PayOrder, a payment must:
     * - Reference the order by specifying the `order_id` when [creating the payment](#endpoint-payments-createpayment).
     * Any approved payments that reference the same `order_id` not specified in the
     * `payment_ids` will be canceled.
     * - Be approved with [delayed capture](https://developer.squareup.com/docs/payments-api/take-payments#delayed-capture).
     * Using a delayed capture payment with PayOrder will complete the approved payment.
     * @param    orderId    Required parameter: The ID of the order being paid.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the PayOrderResponse response from the API call 
     */
    CompletableFuture<PayOrderResponse> payOrderAsync(
            final String orderId,
            final PayOrderRequest body);

}