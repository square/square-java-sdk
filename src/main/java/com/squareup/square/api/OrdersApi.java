package com.squareup.square.api;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.*;
import com.squareup.square.exceptions.*;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.Headers;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.*;

public final class OrdersApi extends BaseApi {
    public OrdersApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

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
            final CreateOrderRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateOrderRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateOrderResponse(_context);
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
            final CreateOrderRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreateOrderRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateOrderResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createOrder
     */
    private HttpRequest _buildCreateOrderRequest(
            final String locationId,
            final CreateOrderRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/orders");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("content-type", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String _bodyJson = ApiHelper.serialize(body);
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for createOrder
     * @return An object of type CreateOrderResponse
     */
    private CreateOrderResponse _handleCreateOrderResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        CreateOrderResponse _result = ApiHelper.deserialize(_responseBody,
                CreateOrderResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
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
            final BatchRetrieveOrdersRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildBatchRetrieveOrdersRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleBatchRetrieveOrdersResponse(_context);
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
            final BatchRetrieveOrdersRequest body
    ) {
        return makeHttpCallAsync(() -> _buildBatchRetrieveOrdersRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleBatchRetrieveOrdersResponse(_context));
    }

    /**
     * Builds the HttpRequest object for batchRetrieveOrders
     */
    private HttpRequest _buildBatchRetrieveOrdersRequest(
            final String locationId,
            final BatchRetrieveOrdersRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/orders/batch-retrieve");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("content-type", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String _bodyJson = ApiHelper.serialize(body);
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for batchRetrieveOrders
     * @return An object of type BatchRetrieveOrdersResponse
     */
    private BatchRetrieveOrdersResponse _handleBatchRetrieveOrdersResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        BatchRetrieveOrdersResponse _result = ApiHelper.deserialize(_responseBody,
                BatchRetrieveOrdersResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
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
            final UpdateOrderRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateOrderRequest(locationId, orderId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateOrderResponse(_context);
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
            final UpdateOrderRequest body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateOrderRequest(locationId, orderId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateOrderResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateOrder
     */
    private HttpRequest _buildUpdateOrderRequest(
            final String locationId,
            final String orderId,
            final UpdateOrderRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/orders/{order_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("order_id", orderId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("content-type", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String _bodyJson = ApiHelper.serialize(body);
        HttpRequest _request = getClientInstance().putBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for updateOrder
     * @return An object of type UpdateOrderResponse
     */
    private UpdateOrderResponse _handleUpdateOrderResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        UpdateOrderResponse _result = ApiHelper.deserialize(_responseBody,
                UpdateOrderResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
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
            final SearchOrdersRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildSearchOrdersRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleSearchOrdersResponse(_context);
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
            final SearchOrdersRequest body
    ) {
        return makeHttpCallAsync(() -> _buildSearchOrdersRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleSearchOrdersResponse(_context));
    }

    /**
     * Builds the HttpRequest object for searchOrders
     */
    private HttpRequest _buildSearchOrdersRequest(
            final SearchOrdersRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/orders/search");
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("content-type", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String _bodyJson = ApiHelper.serialize(body);
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for searchOrders
     * @return An object of type SearchOrdersResponse
     */
    private SearchOrdersResponse _handleSearchOrdersResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        SearchOrdersResponse _result = ApiHelper.deserialize(_responseBody,
                SearchOrdersResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
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
            final PayOrderRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildPayOrderRequest(orderId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handlePayOrderResponse(_context);
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
            final PayOrderRequest body
    ) {
        return makeHttpCallAsync(() -> _buildPayOrderRequest(orderId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handlePayOrderResponse(_context));
    }

    /**
     * Builds the HttpRequest object for payOrder
     */
    private HttpRequest _buildPayOrderRequest(
            final String orderId,
            final PayOrderRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/orders/{order_id}/pay");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("order_id", orderId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("content-type", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String _bodyJson = ApiHelper.serialize(body);
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for payOrder
     * @return An object of type PayOrderResponse
     */
    private PayOrderResponse _handlePayOrderResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        PayOrderResponse _result = ApiHelper.deserialize(_responseBody,
                PayOrderResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
