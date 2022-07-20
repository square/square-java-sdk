
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.AuthManager;
import com.squareup.square.Configuration;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.Headers;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
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
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultOrdersApi extends BaseApi implements OrdersApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultOrdersApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     * @param httpCallback    Callback to be called before and after the HTTP call.
     */
    public DefaultOrdersApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
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
        HttpRequest request = buildCreateOrderRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateOrderResponse(context);
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
        return makeHttpCallAsync(() -> buildCreateOrderRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for createOrder.
     */
    private HttpRequest buildCreateOrderRequest(
            final CreateOrderRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/orders");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createOrder.
     * @return An object of type CreateOrderResponse
     */
    private CreateOrderResponse handleCreateOrderResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        CreateOrderResponse result = ApiHelper.deserialize(responseBody,
                CreateOrderResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
        HttpRequest request = buildBatchRetrieveOrdersRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleBatchRetrieveOrdersResponse(context);
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
        return makeHttpCallAsync(() -> buildBatchRetrieveOrdersRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleBatchRetrieveOrdersResponse(context));
    }

    /**
     * Builds the HttpRequest object for batchRetrieveOrders.
     */
    private HttpRequest buildBatchRetrieveOrdersRequest(
            final BatchRetrieveOrdersRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/orders/batch-retrieve");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for batchRetrieveOrders.
     * @return An object of type BatchRetrieveOrdersResponse
     */
    private BatchRetrieveOrdersResponse handleBatchRetrieveOrdersResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        BatchRetrieveOrdersResponse result = ApiHelper.deserialize(responseBody,
                BatchRetrieveOrdersResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
        HttpRequest request = buildCalculateOrderRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCalculateOrderResponse(context);
    }

    /**
     * Enables applications to preview order pricing without creating an order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateOrderResponse response from the API call
     */
    public CompletableFuture<CalculateOrderResponse> calculateOrderAsync(
            final CalculateOrderRequest body) {
        return makeHttpCallAsync(() -> buildCalculateOrderRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCalculateOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for calculateOrder.
     */
    private HttpRequest buildCalculateOrderRequest(
            final CalculateOrderRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/orders/calculate");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for calculateOrder.
     * @return An object of type CalculateOrderResponse
     */
    private CalculateOrderResponse handleCalculateOrderResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        CalculateOrderResponse result = ApiHelper.deserialize(responseBody,
                CalculateOrderResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
        HttpRequest request = buildCloneOrderRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCloneOrderResponse(context);
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
        return makeHttpCallAsync(() -> buildCloneOrderRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCloneOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for cloneOrder.
     */
    private HttpRequest buildCloneOrderRequest(
            final CloneOrderRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/orders/clone");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for cloneOrder.
     * @return An object of type CloneOrderResponse
     */
    private CloneOrderResponse handleCloneOrderResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        CloneOrderResponse result = ApiHelper.deserialize(responseBody,
                CloneOrderResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
        HttpRequest request = buildSearchOrdersRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchOrdersResponse(context);
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
        return makeHttpCallAsync(() -> buildSearchOrdersRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchOrdersResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchOrders.
     */
    private HttpRequest buildSearchOrdersRequest(
            final SearchOrdersRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/orders/search");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for searchOrders.
     * @return An object of type SearchOrdersResponse
     */
    private SearchOrdersResponse handleSearchOrdersResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        SearchOrdersResponse result = ApiHelper.deserialize(responseBody,
                SearchOrdersResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
        HttpRequest request = buildRetrieveOrderRequest(orderId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveOrderResponse(context);
    }

    /**
     * Retrieves an [Order]($m/Order) by ID.
     * @param  orderId  Required parameter: The ID of the order to retrieve.
     * @return    Returns the RetrieveOrderResponse response from the API call
     */
    public CompletableFuture<RetrieveOrderResponse> retrieveOrderAsync(
            final String orderId) {
        return makeHttpCallAsync(() -> buildRetrieveOrderRequest(orderId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveOrder.
     */
    private HttpRequest buildRetrieveOrderRequest(
            final String orderId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/orders/{order_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("order_id",
                new SimpleEntry<Object, Boolean>(orderId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveOrder.
     * @return An object of type RetrieveOrderResponse
     */
    private RetrieveOrderResponse handleRetrieveOrderResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        RetrieveOrderResponse result = ApiHelper.deserialize(responseBody,
                RetrieveOrderResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates an open [order]($m/Order) by adding, replacing, or deleting fields. Orders with a
     * `COMPLETED` or `CANCELED` state cannot be updated. An `UpdateOrder` request requires the
     * following: - The `order_id` in the endpoint path, identifying the order to update. - The
     * latest `version` of the order to update. - The [sparse
     * order](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#sparse-order-objects)
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
    public UpdateOrderResponse updateOrder(
            final String orderId,
            final UpdateOrderRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateOrderRequest(orderId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateOrderResponse(context);
    }

    /**
     * Updates an open [order]($m/Order) by adding, replacing, or deleting fields. Orders with a
     * `COMPLETED` or `CANCELED` state cannot be updated. An `UpdateOrder` request requires the
     * following: - The `order_id` in the endpoint path, identifying the order to update. - The
     * latest `version` of the order to update. - The [sparse
     * order](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#sparse-order-objects)
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
    public CompletableFuture<UpdateOrderResponse> updateOrderAsync(
            final String orderId,
            final UpdateOrderRequest body) {
        return makeHttpCallAsync(() -> buildUpdateOrderRequest(orderId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateOrder.
     */
    private HttpRequest buildUpdateOrderRequest(
            final String orderId,
            final UpdateOrderRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/orders/{order_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("order_id",
                new SimpleEntry<Object, Boolean>(orderId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateOrder.
     * @return An object of type UpdateOrderResponse
     */
    private UpdateOrderResponse handleUpdateOrderResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        UpdateOrderResponse result = ApiHelper.deserialize(responseBody,
                UpdateOrderResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
        HttpRequest request = buildPayOrderRequest(orderId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handlePayOrderResponse(context);
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
        return makeHttpCallAsync(() -> buildPayOrderRequest(orderId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handlePayOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for payOrder.
     */
    private HttpRequest buildPayOrderRequest(
            final String orderId,
            final PayOrderRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/orders/{order_id}/pay");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("order_id",
                new SimpleEntry<Object, Boolean>(orderId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for payOrder.
     * @return An object of type PayOrderResponse
     */
    private PayOrderResponse handlePayOrderResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        PayOrderResponse result = ApiHelper.deserialize(responseBody,
                PayOrderResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}