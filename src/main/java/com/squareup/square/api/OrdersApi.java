
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.BatchRetrieveOrdersRequest;
import com.squareup.square.models.BatchRetrieveOrdersResponse;
import com.squareup.square.models.CalculateOrderRequest;
import com.squareup.square.models.CalculateOrderResponse;
import com.squareup.square.models.CloneOrderRequest;
import com.squareup.square.models.CloneOrderResponse;
import com.squareup.square.models.CreateOrderRequest;
import com.squareup.square.models.CreateOrderResponse;
import com.squareup.square.models.PayOrderRequest;
import com.squareup.square.models.PayOrderResponse;
import com.squareup.square.models.RetrieveOrderResponse;
import com.squareup.square.models.SearchOrdersRequest;
import com.squareup.square.models.SearchOrdersResponse;
import com.squareup.square.models.UpdateOrderRequest;
import com.squareup.square.models.UpdateOrderResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface OrdersApi {
    /**
     * Creates a new [order]($m/Order) that can include information about products for purchase and
     * settings to apply to the purchase. To pay for a created order, see [Pay for
     * Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders). You can modify open
     * orders using the [UpdateOrder]($e/Orders/UpdateOrder) endpoint.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateOrderResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateOrderResponse createOrder(
            final CreateOrderRequest body) throws ApiException, IOException;

    /**
     * Creates a new [order]($m/Order) that can include information about products for purchase and
     * settings to apply to the purchase. To pay for a created order, see [Pay for
     * Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders). You can modify open
     * orders using the [UpdateOrder]($e/Orders/UpdateOrder) endpoint.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateOrderResponse response from the API call
     */
    CompletableFuture<CreateOrderResponse> createOrderAsync(
            final CreateOrderRequest body);

    /**
     * Retrieves a set of [orders]($m/Order) by their IDs. If a given order ID does not exist, the
     * ID is ignored instead of generating an error.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveOrdersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BatchRetrieveOrdersResponse batchRetrieveOrders(
            final BatchRetrieveOrdersRequest body) throws ApiException, IOException;

    /**
     * Retrieves a set of [orders]($m/Order) by their IDs. If a given order ID does not exist, the
     * ID is ignored instead of generating an error.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveOrdersResponse response from the API call
     */
    CompletableFuture<BatchRetrieveOrdersResponse> batchRetrieveOrdersAsync(
            final BatchRetrieveOrdersRequest body);

    /**
     * Enables applications to preview order pricing without creating an order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateOrderResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CalculateOrderResponse calculateOrder(
            final CalculateOrderRequest body) throws ApiException, IOException;

    /**
     * Enables applications to preview order pricing without creating an order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateOrderResponse response from the API call
     */
    CompletableFuture<CalculateOrderResponse> calculateOrderAsync(
            final CalculateOrderRequest body);

    /**
     * Creates a new order, in the `DRAFT` state, by duplicating an existing order. The newly
     * created order has only the core fields (such as line items, taxes, and discounts) copied from
     * the original order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CloneOrderResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CloneOrderResponse cloneOrder(
            final CloneOrderRequest body) throws ApiException, IOException;

    /**
     * Creates a new order, in the `DRAFT` state, by duplicating an existing order. The newly
     * created order has only the core fields (such as line items, taxes, and discounts) copied from
     * the original order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CloneOrderResponse response from the API call
     */
    CompletableFuture<CloneOrderResponse> cloneOrderAsync(
            final CloneOrderRequest body);

    /**
     * Search all orders for one or more locations. Orders include all sales, returns, and exchanges
     * regardless of how or when they entered the Square ecosystem (such as Point of Sale, Invoices,
     * and Connect APIs). `SearchOrders` requests need to specify which locations to search and
     * define a [SearchOrdersQuery]($m/SearchOrdersQuery) object that controls how to sort or filter
     * the results. Your `SearchOrdersQuery` can: Set filter criteria. Set the sort order. Determine
     * whether to return results as complete `Order` objects or as [OrderEntry]($m/OrderEntry)
     * objects. Note that details for orders processed with Square Point of Sale while in offline
     * mode might not be transmitted to Square for up to 72 hours. Offline orders have a
     * `created_at` value that reflects the time the order was created, not the time it was
     * subsequently transmitted to Square.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchOrdersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchOrdersResponse searchOrders(
            final SearchOrdersRequest body) throws ApiException, IOException;

    /**
     * Search all orders for one or more locations. Orders include all sales, returns, and exchanges
     * regardless of how or when they entered the Square ecosystem (such as Point of Sale, Invoices,
     * and Connect APIs). `SearchOrders` requests need to specify which locations to search and
     * define a [SearchOrdersQuery]($m/SearchOrdersQuery) object that controls how to sort or filter
     * the results. Your `SearchOrdersQuery` can: Set filter criteria. Set the sort order. Determine
     * whether to return results as complete `Order` objects or as [OrderEntry]($m/OrderEntry)
     * objects. Note that details for orders processed with Square Point of Sale while in offline
     * mode might not be transmitted to Square for up to 72 hours. Offline orders have a
     * `created_at` value that reflects the time the order was created, not the time it was
     * subsequently transmitted to Square.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchOrdersResponse response from the API call
     */
    CompletableFuture<SearchOrdersResponse> searchOrdersAsync(
            final SearchOrdersRequest body);

    /**
     * Retrieves an [Order]($m/Order) by ID.
     * @param  orderId  Required parameter: The ID of the order to retrieve.
     * @return    Returns the RetrieveOrderResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveOrderResponse retrieveOrder(
            final String orderId) throws ApiException, IOException;

    /**
     * Retrieves an [Order]($m/Order) by ID.
     * @param  orderId  Required parameter: The ID of the order to retrieve.
     * @return    Returns the RetrieveOrderResponse response from the API call
     */
    CompletableFuture<RetrieveOrderResponse> retrieveOrderAsync(
            final String orderId);

    /**
     * Updates an open [order]($m/Order) by adding, replacing, or deleting fields. Orders with a
     * `COMPLETED` or `CANCELED` state cannot be updated. An `UpdateOrder` request requires the
     * following: - The `order_id` in the endpoint path, identifying the order to update. - The
     * latest `version` of the order to update. - The [sparse
     * order](https://developer.squareup.com/docs/orders-api/manage-orders#sparse-order-objects)
     * containing only the fields to update and the version to which the update is being applied. -
     * If deleting fields, the [dot notation
     * paths](https://developer.squareup.com/docs/orders-api/manage-orders#on-dot-notation)
     * identifying the fields to clear. To pay for an order, see [Pay for
     * Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders).
     * @param  orderId  Required parameter: The ID of the order to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateOrderResponse updateOrder(
            final String orderId,
            final UpdateOrderRequest body) throws ApiException, IOException;

    /**
     * Updates an open [order]($m/Order) by adding, replacing, or deleting fields. Orders with a
     * `COMPLETED` or `CANCELED` state cannot be updated. An `UpdateOrder` request requires the
     * following: - The `order_id` in the endpoint path, identifying the order to update. - The
     * latest `version` of the order to update. - The [sparse
     * order](https://developer.squareup.com/docs/orders-api/manage-orders#sparse-order-objects)
     * containing only the fields to update and the version to which the update is being applied. -
     * If deleting fields, the [dot notation
     * paths](https://developer.squareup.com/docs/orders-api/manage-orders#on-dot-notation)
     * identifying the fields to clear. To pay for an order, see [Pay for
     * Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders).
     * @param  orderId  Required parameter: The ID of the order to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderResponse response from the API call
     */
    CompletableFuture<UpdateOrderResponse> updateOrderAsync(
            final String orderId,
            final UpdateOrderRequest body);

    /**
     * Pay for an [order]($m/Order) using one or more approved [payments]($m/Payment) or settle an
     * order with a total of `0`. The total of the `payment_ids` listed in the request must be equal
     * to the order total. Orders with a total amount of `0` can be marked as paid by specifying an
     * empty array of `payment_ids` in the request. To be used with `PayOrder`, a payment must: -
     * Reference the order by specifying the `order_id` when [creating the
     * payment]($e/Payments/CreatePayment). Any approved payments that reference the same `order_id`
     * not specified in the `payment_ids` is canceled. - Be approved with [delayed
     * capture](https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture).
     * Using a delayed capture payment with `PayOrder` completes the approved payment.
     * @param  orderId  Required parameter: The ID of the order being paid.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PayOrderResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    PayOrderResponse payOrder(
            final String orderId,
            final PayOrderRequest body) throws ApiException, IOException;

    /**
     * Pay for an [order]($m/Order) using one or more approved [payments]($m/Payment) or settle an
     * order with a total of `0`. The total of the `payment_ids` listed in the request must be equal
     * to the order total. Orders with a total amount of `0` can be marked as paid by specifying an
     * empty array of `payment_ids` in the request. To be used with `PayOrder`, a payment must: -
     * Reference the order by specifying the `order_id` when [creating the
     * payment]($e/Payments/CreatePayment). Any approved payments that reference the same `order_id`
     * not specified in the `payment_ids` is canceled. - Be approved with [delayed
     * capture](https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture).
     * Using a delayed capture payment with `PayOrder` completes the approved payment.
     * @param  orderId  Required parameter: The ID of the order being paid.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PayOrderResponse response from the API call
     */
    CompletableFuture<PayOrderResponse> payOrderAsync(
            final String orderId,
            final PayOrderRequest body);

}