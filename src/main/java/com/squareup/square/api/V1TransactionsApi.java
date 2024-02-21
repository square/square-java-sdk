
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.V1Order;
import com.squareup.square.models.V1UpdateOrderRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface V1TransactionsApi {
    /**
     * Provides summary information for a merchant's online store orders.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list online store orders
     *         for.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  limit  Optional parameter: The maximum number of payments to return in a single
     *         response. This value cannot exceed 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Order response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    List<V1Order> v1ListOrders(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken) throws ApiException, IOException;

    /**
     * Provides summary information for a merchant's online store orders.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list online store orders
     *         for.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  limit  Optional parameter: The maximum number of payments to return in a single
     *         response. This value cannot exceed 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Order response from the API call
     */
    @Deprecated
    CompletableFuture<List<V1Order>> v1ListOrdersAsync(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken);

    /**
     * Provides comprehensive information for a single online store order, including the order's
     * history.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the order's associated location.
     * @param  orderId  Required parameter: The order's Square-issued ID. You obtain this value from
     *         Order objects returned by the List Orders endpoint
     * @return    Returns the V1Order response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    V1Order v1RetrieveOrder(
            final String locationId,
            final String orderId) throws ApiException, IOException;

    /**
     * Provides comprehensive information for a single online store order, including the order's
     * history.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the order's associated location.
     * @param  orderId  Required parameter: The order's Square-issued ID. You obtain this value from
     *         Order objects returned by the List Orders endpoint
     * @return    Returns the V1Order response from the API call
     */
    @Deprecated
    CompletableFuture<V1Order> v1RetrieveOrderAsync(
            final String locationId,
            final String orderId);

    /**
     * Updates the details of an online store order. Every update you perform on an order
     * corresponds to one of three actions:.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the order's associated location.
     * @param  orderId  Required parameter: The order's Square-issued ID. You obtain this value from
     *         Order objects returned by the List Orders endpoint
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Order response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    V1Order v1UpdateOrder(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body) throws ApiException, IOException;

    /**
     * Updates the details of an online store order. Every update you perform on an order
     * corresponds to one of three actions:.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the order's associated location.
     * @param  orderId  Required parameter: The order's Square-issued ID. You obtain this value from
     *         Order objects returned by the List Orders endpoint
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Order response from the API call
     */
    @Deprecated
    CompletableFuture<V1Order> v1UpdateOrderAsync(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body);

}