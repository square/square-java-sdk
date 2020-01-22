package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.AuthManager;
import com.squareup.square.Configuration;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.Headers;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.BatchRetrieveOrdersRequest;
import com.squareup.square.models.BatchRetrieveOrdersResponse;
import com.squareup.square.models.CreateOrderRequest;
import com.squareup.square.models.CreateOrderResponse;
import com.squareup.square.models.PayOrderRequest;
import com.squareup.square.models.PayOrderResponse;
import com.squareup.square.models.SearchOrdersRequest;
import com.squareup.square.models.SearchOrdersResponse;
import com.squareup.square.models.UpdateOrderRequest;
import com.squareup.square.models.UpdateOrderResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class OrdersApi extends BaseApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public OrdersApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public OrdersApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Creates a new [Order](#type-order) which can include information on products for
     * purchase and settings to apply to the purchase.
     * To pay for a created order, please refer to the [Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders)
     * guide.
     * You can modify open orders using the [UpdateOrder](#endpoint-orders-updateorder) endpoint.
     * To learn more about the Orders API, see the
     * [Orders API Overview](https://developer.squareup.com/docs/orders-api/what-it-does).
     * @param    locationId    Required parameter: The ID of the business location to associate the order with.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateOrderResponse response from the API call
     */
    public CreateOrderResponse createOrder(
            final String locationId,
            final CreateOrderRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateOrderRequest(locationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateOrderResponse(context);
    }

    /**
     * Creates a new [Order](#type-order) which can include information on products for
     * purchase and settings to apply to the purchase.
     * To pay for a created order, please refer to the [Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders)
     * guide.
     * You can modify open orders using the [UpdateOrder](#endpoint-orders-updateorder) endpoint.
     * To learn more about the Orders API, see the
     * [Orders API Overview](https://developer.squareup.com/docs/orders-api/what-it-does).
     * @param    locationId    Required parameter: The ID of the business location to associate the order with.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateOrderResponse response from the API call 
     */
    public CompletableFuture<CreateOrderResponse> createOrderAsync(
            final String locationId,
            final CreateOrderRequest body) {
        return makeHttpCallAsync(() -> buildCreateOrderRequest(locationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for createOrder
     */
    private HttpRequest buildCreateOrderRequest(
            final String locationId,
            final CreateOrderRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/locations/{location_id}/orders");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createOrder
     * @return An object of type CreateOrderResponse
     */
    private CreateOrderResponse handleCreateOrderResponse(HttpContext context)
            throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse)response).getBody();
        CreateOrderResponse result = ApiHelper.deserialize(responseBody,
                CreateOrderResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a set of [Order](#type-order)s by their IDs.
     * If a given Order ID does not exist, the ID is ignored instead of generating an error.
     * @param    locationId    Required parameter: The ID of the orders' associated location.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveOrdersResponse response from the API call
     */
    public BatchRetrieveOrdersResponse batchRetrieveOrders(
            final String locationId,
            final BatchRetrieveOrdersRequest body) throws ApiException, IOException {
        HttpRequest request = buildBatchRetrieveOrdersRequest(locationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleBatchRetrieveOrdersResponse(context);
    }

    /**
     * Retrieves a set of [Order](#type-order)s by their IDs.
     * If a given Order ID does not exist, the ID is ignored instead of generating an error.
     * @param    locationId    Required parameter: The ID of the orders' associated location.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveOrdersResponse response from the API call 
     */
    public CompletableFuture<BatchRetrieveOrdersResponse> batchRetrieveOrdersAsync(
            final String locationId,
            final BatchRetrieveOrdersRequest body) {
        return makeHttpCallAsync(() -> buildBatchRetrieveOrdersRequest(locationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleBatchRetrieveOrdersResponse(context));
    }

    /**
     * Builds the HttpRequest object for batchRetrieveOrders
     */
    private HttpRequest buildBatchRetrieveOrdersRequest(
            final String locationId,
            final BatchRetrieveOrdersRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/locations/{location_id}/orders/batch-retrieve");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for batchRetrieveOrders
     * @return An object of type BatchRetrieveOrdersResponse
     */
    private BatchRetrieveOrdersResponse handleBatchRetrieveOrdersResponse(HttpContext context)
            throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse)response).getBody();
        BatchRetrieveOrdersResponse result = ApiHelper.deserialize(responseBody,
                BatchRetrieveOrdersResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

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
     * To learn more about the Orders API, see the
     * [Orders API Overview](https://developer.squareup.com/docs/orders-api/what-it-does).
     * @param    locationId    Required parameter: The ID of the order's associated location.
     * @param    orderId    Required parameter: The ID of the order to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderResponse response from the API call
     */
    public UpdateOrderResponse updateOrder(
            final String locationId,
            final String orderId,
            final UpdateOrderRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateOrderRequest(locationId, orderId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateOrderResponse(context);
    }

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
     * To learn more about the Orders API, see the
     * [Orders API Overview](https://developer.squareup.com/docs/orders-api/what-it-does).
     * @param    locationId    Required parameter: The ID of the order's associated location.
     * @param    orderId    Required parameter: The ID of the order to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderResponse response from the API call 
     */
    public CompletableFuture<UpdateOrderResponse> updateOrderAsync(
            final String locationId,
            final String orderId,
            final UpdateOrderRequest body) {
        return makeHttpCallAsync(() -> buildUpdateOrderRequest(locationId, orderId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateOrder
     */
    private HttpRequest buildUpdateOrderRequest(
            final String locationId,
            final String orderId,
            final UpdateOrderRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/locations/{location_id}/orders/{order_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("order_id", orderId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateOrder
     * @return An object of type UpdateOrderResponse
     */
    private UpdateOrderResponse handleUpdateOrderResponse(HttpContext context)
            throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse)response).getBody();
        UpdateOrderResponse result = ApiHelper.deserialize(responseBody,
                UpdateOrderResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

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
    public SearchOrdersResponse searchOrders(
            final SearchOrdersRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchOrdersRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleSearchOrdersResponse(context);
    }

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
    public CompletableFuture<SearchOrdersResponse> searchOrdersAsync(
            final SearchOrdersRequest body) {
        return makeHttpCallAsync(() -> buildSearchOrdersRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleSearchOrdersResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchOrders
     */
    private HttpRequest buildSearchOrdersRequest(
            final SearchOrdersRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/orders/search");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for searchOrders
     * @return An object of type SearchOrdersResponse
     */
    private SearchOrdersResponse handleSearchOrdersResponse(HttpContext context)
            throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse)response).getBody();
        SearchOrdersResponse result = ApiHelper.deserialize(responseBody,
                SearchOrdersResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

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
     * Learn how to [pay for orders with a single payment using the Payments API](https://developer.squareup.com/docs/orders-api/pay-for-orders).
     * @param    orderId    Required parameter: The ID of the order being paid.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the PayOrderResponse response from the API call
     */
    public PayOrderResponse payOrder(
            final String orderId,
            final PayOrderRequest body) throws ApiException, IOException {
        HttpRequest request = buildPayOrderRequest(orderId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handlePayOrderResponse(context);
    }

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
     * Learn how to [pay for orders with a single payment using the Payments API](https://developer.squareup.com/docs/orders-api/pay-for-orders).
     * @param    orderId    Required parameter: The ID of the order being paid.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the PayOrderResponse response from the API call 
     */
    public CompletableFuture<PayOrderResponse> payOrderAsync(
            final String orderId,
            final PayOrderRequest body) {
        return makeHttpCallAsync(() -> buildPayOrderRequest(orderId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handlePayOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for payOrder
     */
    private HttpRequest buildPayOrderRequest(
            final String orderId,
            final PayOrderRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/orders/{order_id}/pay");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("order_id", orderId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-01-22");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for payOrder
     * @return An object of type PayOrderResponse
     */
    private PayOrderResponse handlePayOrderResponse(HttpContext context)
            throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse)response).getBody();
        PayOrderResponse result = ApiHelper.deserialize(responseBody,
                PayOrderResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}
