
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
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
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultOrdersApi extends BaseApi implements OrdersApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultOrdersApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

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
    public CreateOrderResponse createOrder(
            final CreateOrderRequest body) throws ApiException, IOException {
        return prepareCreateOrderRequest(body).execute();
    }

    /**
     * Creates a new [order]($m/Order) that can include information about products for purchase and
     * settings to apply to the purchase. To pay for a created order, see [Pay for
     * Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders). You can modify open
     * orders using the [UpdateOrder]($e/Orders/UpdateOrder) endpoint.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateOrderResponse response from the API call
     */
    public CompletableFuture<CreateOrderResponse> createOrderAsync(
            final CreateOrderRequest body) {
        try { 
            return prepareCreateOrderRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createOrder.
     */
    private ApiCall<CreateOrderResponse, ApiException> prepareCreateOrderRequest(
            final CreateOrderRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateOrderResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateOrderResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a set of [orders]($m/Order) by their IDs. If a given order ID does not exist, the
     * ID is ignored instead of generating an error.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveOrdersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BatchRetrieveOrdersResponse batchRetrieveOrders(
            final BatchRetrieveOrdersRequest body) throws ApiException, IOException {
        return prepareBatchRetrieveOrdersRequest(body).execute();
    }

    /**
     * Retrieves a set of [orders]($m/Order) by their IDs. If a given order ID does not exist, the
     * ID is ignored instead of generating an error.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveOrdersResponse response from the API call
     */
    public CompletableFuture<BatchRetrieveOrdersResponse> batchRetrieveOrdersAsync(
            final BatchRetrieveOrdersRequest body) {
        try { 
            return prepareBatchRetrieveOrdersRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for batchRetrieveOrders.
     */
    private ApiCall<BatchRetrieveOrdersResponse, ApiException> prepareBatchRetrieveOrdersRequest(
            final BatchRetrieveOrdersRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BatchRetrieveOrdersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/batch-retrieve")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BatchRetrieveOrdersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Enables applications to preview order pricing without creating an order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateOrderResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CalculateOrderResponse calculateOrder(
            final CalculateOrderRequest body) throws ApiException, IOException {
        return prepareCalculateOrderRequest(body).execute();
    }

    /**
     * Enables applications to preview order pricing without creating an order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateOrderResponse response from the API call
     */
    public CompletableFuture<CalculateOrderResponse> calculateOrderAsync(
            final CalculateOrderRequest body) {
        try { 
            return prepareCalculateOrderRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for calculateOrder.
     */
    private ApiCall<CalculateOrderResponse, ApiException> prepareCalculateOrderRequest(
            final CalculateOrderRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CalculateOrderResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/calculate")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CalculateOrderResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public CloneOrderResponse cloneOrder(
            final CloneOrderRequest body) throws ApiException, IOException {
        return prepareCloneOrderRequest(body).execute();
    }

    /**
     * Creates a new order, in the `DRAFT` state, by duplicating an existing order. The newly
     * created order has only the core fields (such as line items, taxes, and discounts) copied from
     * the original order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CloneOrderResponse response from the API call
     */
    public CompletableFuture<CloneOrderResponse> cloneOrderAsync(
            final CloneOrderRequest body) {
        try { 
            return prepareCloneOrderRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for cloneOrder.
     */
    private ApiCall<CloneOrderResponse, ApiException> prepareCloneOrderRequest(
            final CloneOrderRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CloneOrderResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/clone")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CloneOrderResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public SearchOrdersResponse searchOrders(
            final SearchOrdersRequest body) throws ApiException, IOException {
        return prepareSearchOrdersRequest(body).execute();
    }

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
    public CompletableFuture<SearchOrdersResponse> searchOrdersAsync(
            final SearchOrdersRequest body) {
        try { 
            return prepareSearchOrdersRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchOrders.
     */
    private ApiCall<SearchOrdersResponse, ApiException> prepareSearchOrdersRequest(
            final SearchOrdersRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchOrdersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchOrdersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves an [Order]($m/Order) by ID.
     * @param  orderId  Required parameter: The ID of the order to retrieve.
     * @return    Returns the RetrieveOrderResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveOrderResponse retrieveOrder(
            final String orderId) throws ApiException, IOException {
        return prepareRetrieveOrderRequest(orderId).execute();
    }

    /**
     * Retrieves an [Order]($m/Order) by ID.
     * @param  orderId  Required parameter: The ID of the order to retrieve.
     * @return    Returns the RetrieveOrderResponse response from the API call
     */
    public CompletableFuture<RetrieveOrderResponse> retrieveOrderAsync(
            final String orderId) {
        try { 
            return prepareRetrieveOrderRequest(orderId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveOrder.
     */
    private ApiCall<RetrieveOrderResponse, ApiException> prepareRetrieveOrderRequest(
            final String orderId) throws IOException {
        return new ApiCall.Builder<RetrieveOrderResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/{order_id}")
                        .templateParam(param -> param.key("order_id").value(orderId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveOrderResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates an open [order]($m/Order) by adding, replacing, or deleting fields. Orders with a
     * `COMPLETED` or `CANCELED` state cannot be updated. An `UpdateOrder` request requires the
     * following: - The `order_id` in the endpoint path, identifying the order to update. - The
     * latest `version` of the order to update. - The [sparse
     * order](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#sparse-order-objects)
     * containing only the fields to update and the version to which the update is being applied. -
     * If deleting fields, the [dot notation
     * paths](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#identifying-fields-to-delete)
     * identifying the fields to clear. To pay for an order, see [Pay for
     * Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders).
     * @param  orderId  Required parameter: The ID of the order to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateOrderResponse updateOrder(
            final String orderId,
            final UpdateOrderRequest body) throws ApiException, IOException {
        return prepareUpdateOrderRequest(orderId, body).execute();
    }

    /**
     * Updates an open [order]($m/Order) by adding, replacing, or deleting fields. Orders with a
     * `COMPLETED` or `CANCELED` state cannot be updated. An `UpdateOrder` request requires the
     * following: - The `order_id` in the endpoint path, identifying the order to update. - The
     * latest `version` of the order to update. - The [sparse
     * order](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#sparse-order-objects)
     * containing only the fields to update and the version to which the update is being applied. -
     * If deleting fields, the [dot notation
     * paths](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#identifying-fields-to-delete)
     * identifying the fields to clear. To pay for an order, see [Pay for
     * Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders).
     * @param  orderId  Required parameter: The ID of the order to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderResponse response from the API call
     */
    public CompletableFuture<UpdateOrderResponse> updateOrderAsync(
            final String orderId,
            final UpdateOrderRequest body) {
        try { 
            return prepareUpdateOrderRequest(orderId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateOrder.
     */
    private ApiCall<UpdateOrderResponse, ApiException> prepareUpdateOrderRequest(
            final String orderId,
            final UpdateOrderRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateOrderResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/{order_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("order_id").value(orderId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateOrderResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public PayOrderResponse payOrder(
            final String orderId,
            final PayOrderRequest body) throws ApiException, IOException {
        return preparePayOrderRequest(orderId, body).execute();
    }

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
    public CompletableFuture<PayOrderResponse> payOrderAsync(
            final String orderId,
            final PayOrderRequest body) {
        try { 
            return preparePayOrderRequest(orderId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for payOrder.
     */
    private ApiCall<PayOrderResponse, ApiException> preparePayOrderRequest(
            final String orderId,
            final PayOrderRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<PayOrderResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/{order_id}/pay")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("order_id").value(orderId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, PayOrderResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}