
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
import com.squareup.square.models.V1CreateRefundRequest;
import com.squareup.square.models.V1Order;
import com.squareup.square.models.V1Payment;
import com.squareup.square.models.V1Refund;
import com.squareup.square.models.V1Settlement;
import com.squareup.square.models.V1UpdateOrderRequest;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultV1TransactionsApi extends BaseApi implements V1TransactionsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultV1TransactionsApi(Configuration config, HttpClient httpClient,
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
    public DefaultV1TransactionsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

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
    @Deprecated
    public List<V1Order> v1ListOrders(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken) throws ApiException, IOException {
        HttpRequest request = buildV1ListOrdersRequest(locationId, order, limit, batchToken);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleV1ListOrdersResponse(context);
    }

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
    public CompletableFuture<List<V1Order>> v1ListOrdersAsync(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken) {
        return makeHttpCallAsync(() -> buildV1ListOrdersRequest(locationId, order, limit,
                batchToken),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleV1ListOrdersResponse(context));
    }

    /**
     * Builds the HttpRequest object for v1ListOrders.
     */
    private HttpRequest buildV1ListOrdersRequest(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/{location_id}/orders");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("order", order);
        queryParameters.put("limit", limit);
        queryParameters.put("batch_token", batchToken);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for v1ListOrders.
     * @return An object of type List of V1Order
     */
    private List<V1Order> handleV1ListOrdersResponse(
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
        List<V1Order> result = ApiHelper.deserializeArray(responseBody,
                V1Order[].class);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).toBuilder().httpContext(context).build());
        }
        return result;
    }

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
    @Deprecated
    public V1Order v1RetrieveOrder(
            final String locationId,
            final String orderId) throws ApiException, IOException {
        HttpRequest request = buildV1RetrieveOrderRequest(locationId, orderId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleV1RetrieveOrderResponse(context);
    }

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
    public CompletableFuture<V1Order> v1RetrieveOrderAsync(
            final String locationId,
            final String orderId) {
        return makeHttpCallAsync(() -> buildV1RetrieveOrderRequest(locationId, orderId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleV1RetrieveOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for v1RetrieveOrder.
     */
    private HttpRequest buildV1RetrieveOrderRequest(
            final String locationId,
            final String orderId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/{location_id}/orders/{order_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
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
     * Processes the response for v1RetrieveOrder.
     * @return An object of type V1Order
     */
    private V1Order handleV1RetrieveOrderResponse(
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
        V1Order result = ApiHelper.deserialize(responseBody,
                V1Order.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

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
    @Deprecated
    public V1Order v1UpdateOrder(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body) throws ApiException, IOException {
        HttpRequest request = buildV1UpdateOrderRequest(locationId, orderId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleV1UpdateOrderResponse(context);
    }

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
    public CompletableFuture<V1Order> v1UpdateOrderAsync(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body) {
        return makeHttpCallAsync(() -> buildV1UpdateOrderRequest(locationId, orderId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleV1UpdateOrderResponse(context));
    }

    /**
     * Builds the HttpRequest object for v1UpdateOrder.
     */
    private HttpRequest buildV1UpdateOrderRequest(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/{location_id}/orders/{order_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
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
     * Processes the response for v1UpdateOrder.
     * @return An object of type V1Order
     */
    private V1Order handleV1UpdateOrderResponse(
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
        V1Order result = ApiHelper.deserialize(responseBody,
                V1Order.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides summary information for all payments taken for a given Square account during a date
     * range. Date ranges cannot exceed 1 year in length. See Date ranges for details of inclusive
     * and exclusive dates. *Note**: Details for payments processed with Square Point of Sale while
     * in offline mode may not be transmitted to Square for up to 72 hours. Offline payments have a
     * `created_at` value that reflects the time the payment was originally processed, not the time
     * it was subsequently transmitted to Square. Consequently, the ListPayments endpoint might list
     * an offline payment chronologically between online payments that were seen in a previous
     * request.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list payments for. If you
     *         specify me, this endpoint returns payments aggregated from all of the business's
     *         locations.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The maximum number of payments to return in a single
     *         response. This value cannot exceed 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @param  includePartial  Optional parameter: Indicates whether or not to include partial
     *         payments in the response. Partial payments will have the tenders collected so far,
     *         but the itemizations will be empty until the payment is completed.
     * @return    Returns the List of V1Payment response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public List<V1Payment> v1ListPayments(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial) throws ApiException, IOException {
        HttpRequest request = buildV1ListPaymentsRequest(locationId, order, beginTime, endTime,
                limit, batchToken, includePartial);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleV1ListPaymentsResponse(context);
    }

    /**
     * Provides summary information for all payments taken for a given Square account during a date
     * range. Date ranges cannot exceed 1 year in length. See Date ranges for details of inclusive
     * and exclusive dates. *Note**: Details for payments processed with Square Point of Sale while
     * in offline mode may not be transmitted to Square for up to 72 hours. Offline payments have a
     * `created_at` value that reflects the time the payment was originally processed, not the time
     * it was subsequently transmitted to Square. Consequently, the ListPayments endpoint might list
     * an offline payment chronologically between online payments that were seen in a previous
     * request.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list payments for. If you
     *         specify me, this endpoint returns payments aggregated from all of the business's
     *         locations.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The maximum number of payments to return in a single
     *         response. This value cannot exceed 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @param  includePartial  Optional parameter: Indicates whether or not to include partial
     *         payments in the response. Partial payments will have the tenders collected so far,
     *         but the itemizations will be empty until the payment is completed.
     * @return    Returns the List of V1Payment response from the API call
     */
    @Deprecated
    public CompletableFuture<List<V1Payment>> v1ListPaymentsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial) {
        return makeHttpCallAsync(() -> buildV1ListPaymentsRequest(locationId, order, beginTime,
                endTime, limit, batchToken, includePartial),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleV1ListPaymentsResponse(context));
    }

    /**
     * Builds the HttpRequest object for v1ListPayments.
     */
    private HttpRequest buildV1ListPaymentsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/{location_id}/payments");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("order", order);
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("limit", limit);
        queryParameters.put("batch_token", batchToken);
        queryParameters.put("include_partial",
                (includePartial != null) ? includePartial : false);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for v1ListPayments.
     * @return An object of type List of V1Payment
     */
    private List<V1Payment> handleV1ListPaymentsResponse(
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
        List<V1Payment> result = ApiHelper.deserializeArray(responseBody,
                V1Payment[].class);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).toBuilder().httpContext(context).build());
        }
        return result;
    }

    /**
     * Provides comprehensive information for a single payment.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the payment's associated location.
     * @param  paymentId  Required parameter: The Square-issued payment ID. payment_id comes from
     *         Payment objects returned by the List Payments endpoint, Settlement objects returned
     *         by the List Settlements endpoint, or Refund objects returned by the List Refunds
     *         endpoint.
     * @return    Returns the V1Payment response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public V1Payment v1RetrievePayment(
            final String locationId,
            final String paymentId) throws ApiException, IOException {
        HttpRequest request = buildV1RetrievePaymentRequest(locationId, paymentId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleV1RetrievePaymentResponse(context);
    }

    /**
     * Provides comprehensive information for a single payment.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the payment's associated location.
     * @param  paymentId  Required parameter: The Square-issued payment ID. payment_id comes from
     *         Payment objects returned by the List Payments endpoint, Settlement objects returned
     *         by the List Settlements endpoint, or Refund objects returned by the List Refunds
     *         endpoint.
     * @return    Returns the V1Payment response from the API call
     */
    @Deprecated
    public CompletableFuture<V1Payment> v1RetrievePaymentAsync(
            final String locationId,
            final String paymentId) {
        return makeHttpCallAsync(() -> buildV1RetrievePaymentRequest(locationId, paymentId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleV1RetrievePaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for v1RetrievePayment.
     */
    private HttpRequest buildV1RetrievePaymentRequest(
            final String locationId,
            final String paymentId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/{location_id}/payments/{payment_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        templateParameters.put("payment_id",
                new SimpleEntry<Object, Boolean>(paymentId, true));
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
     * Processes the response for v1RetrievePayment.
     * @return An object of type V1Payment
     */
    private V1Payment handleV1RetrievePaymentResponse(
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
        V1Payment result = ApiHelper.deserialize(responseBody,
                V1Payment.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides the details for all refunds initiated by a merchant or any of the merchant's mobile
     * staff during a date range. Date ranges cannot exceed one year in length.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list refunds for.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The approximate number of refunds to return in a single
     *         response. Default: 100. Max: 200. Response may contain more results than the
     *         prescribed limit when refunds are made simultaneously to multiple tenders in a
     *         payment or when refunds are generated in an exchange to account for the value of
     *         returned goods.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Refund response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public List<V1Refund> v1ListRefunds(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken) throws ApiException, IOException {
        HttpRequest request = buildV1ListRefundsRequest(locationId, order, beginTime, endTime,
                limit, batchToken);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleV1ListRefundsResponse(context);
    }

    /**
     * Provides the details for all refunds initiated by a merchant or any of the merchant's mobile
     * staff during a date range. Date ranges cannot exceed one year in length.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list refunds for.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The approximate number of refunds to return in a single
     *         response. Default: 100. Max: 200. Response may contain more results than the
     *         prescribed limit when refunds are made simultaneously to multiple tenders in a
     *         payment or when refunds are generated in an exchange to account for the value of
     *         returned goods.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Refund response from the API call
     */
    @Deprecated
    public CompletableFuture<List<V1Refund>> v1ListRefundsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken) {
        return makeHttpCallAsync(() -> buildV1ListRefundsRequest(locationId, order, beginTime,
                endTime, limit, batchToken),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleV1ListRefundsResponse(context));
    }

    /**
     * Builds the HttpRequest object for v1ListRefunds.
     */
    private HttpRequest buildV1ListRefundsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/{location_id}/refunds");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("order", order);
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("limit", limit);
        queryParameters.put("batch_token", batchToken);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for v1ListRefunds.
     * @return An object of type List of V1Refund
     */
    private List<V1Refund> handleV1ListRefundsResponse(
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
        List<V1Refund> result = ApiHelper.deserializeArray(responseBody,
                V1Refund[].class);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).toBuilder().httpContext(context).build());
        }
        return result;
    }

    /**
     * Issues a refund for a previously processed payment. You must issue a refund within 60 days of
     * the associated payment. You cannot issue a partial refund for a split tender payment. You
     * must instead issue a full or partial refund for a particular tender, by providing the
     * applicable tender id to the V1CreateRefund endpoint. Issuing a full refund for a split tender
     * payment refunds all tenders associated with the payment. Issuing a refund for a card payment
     * is not reversible. For development purposes, you can create fake cash payments in Square
     * Point of Sale and refund them.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the original payment's associated location.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Refund response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public V1Refund v1CreateRefund(
            final String locationId,
            final V1CreateRefundRequest body) throws ApiException, IOException {
        HttpRequest request = buildV1CreateRefundRequest(locationId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleV1CreateRefundResponse(context);
    }

    /**
     * Issues a refund for a previously processed payment. You must issue a refund within 60 days of
     * the associated payment. You cannot issue a partial refund for a split tender payment. You
     * must instead issue a full or partial refund for a particular tender, by providing the
     * applicable tender id to the V1CreateRefund endpoint. Issuing a full refund for a split tender
     * payment refunds all tenders associated with the payment. Issuing a refund for a card payment
     * is not reversible. For development purposes, you can create fake cash payments in Square
     * Point of Sale and refund them.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the original payment's associated location.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Refund response from the API call
     */
    @Deprecated
    public CompletableFuture<V1Refund> v1CreateRefundAsync(
            final String locationId,
            final V1CreateRefundRequest body) {
        return makeHttpCallAsync(() -> buildV1CreateRefundRequest(locationId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleV1CreateRefundResponse(context));
    }

    /**
     * Builds the HttpRequest object for v1CreateRefund.
     */
    private HttpRequest buildV1CreateRefundRequest(
            final String locationId,
            final V1CreateRefundRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/{location_id}/refunds");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
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
     * Processes the response for v1CreateRefund.
     * @return An object of type V1Refund
     */
    private V1Refund handleV1CreateRefundResponse(
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
        V1Refund result = ApiHelper.deserialize(responseBody,
                V1Refund.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides summary information for all deposits and withdrawals initiated by Square to a linked
     * bank account during a date range. Date ranges cannot exceed one year in length. *Note**: the
     * ListSettlements endpoint does not provide entry information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list settlements for. If
     *         you specify me, this endpoint returns settlements aggregated from all of the
     *         business's locations.
     * @param  order  Optional parameter: The order in which settlements are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The maximum number of settlements to return in a single
     *         response. This value cannot exceed 200.
     * @param  status  Optional parameter: Provide this parameter to retrieve only settlements with
     *         a particular status (SENT or FAILED).
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Settlement response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public List<V1Settlement> v1ListSettlements(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken) throws ApiException, IOException {
        HttpRequest request = buildV1ListSettlementsRequest(locationId, order, beginTime, endTime,
                limit, status, batchToken);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleV1ListSettlementsResponse(context);
    }

    /**
     * Provides summary information for all deposits and withdrawals initiated by Square to a linked
     * bank account during a date range. Date ranges cannot exceed one year in length. *Note**: the
     * ListSettlements endpoint does not provide entry information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list settlements for. If
     *         you specify me, this endpoint returns settlements aggregated from all of the
     *         business's locations.
     * @param  order  Optional parameter: The order in which settlements are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The maximum number of settlements to return in a single
     *         response. This value cannot exceed 200.
     * @param  status  Optional parameter: Provide this parameter to retrieve only settlements with
     *         a particular status (SENT or FAILED).
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Settlement response from the API call
     */
    @Deprecated
    public CompletableFuture<List<V1Settlement>> v1ListSettlementsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken) {
        return makeHttpCallAsync(() -> buildV1ListSettlementsRequest(locationId, order, beginTime,
                endTime, limit, status, batchToken),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleV1ListSettlementsResponse(context));
    }

    /**
     * Builds the HttpRequest object for v1ListSettlements.
     */
    private HttpRequest buildV1ListSettlementsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/{location_id}/settlements");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("order", order);
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("limit", limit);
        queryParameters.put("status", status);
        queryParameters.put("batch_token", batchToken);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for v1ListSettlements.
     * @return An object of type List of V1Settlement
     */
    private List<V1Settlement> handleV1ListSettlementsResponse(
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
        List<V1Settlement> result = ApiHelper.deserializeArray(responseBody,
                V1Settlement[].class);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).toBuilder().httpContext(context).build());
        }
        return result;
    }

    /**
     * Provides comprehensive information for a single settlement. The returned `Settlement` objects
     * include an `entries` field that lists the transactions that contribute to the settlement
     * total. Most settlement entries correspond to a payment payout, but settlement entries are
     * also generated for less common events, like refunds, manual adjustments, or chargeback holds.
     * Square initiates its regular deposits as indicated in the [Deposit Options with
     * Square](https://squareup.com/help/us/en/article/3807) help article. Details for a regular
     * deposit are usually not available from Connect API endpoints before 10 p.m. PST the same day.
     * Square does not know when an initiated settlement **completes**, only whether it has failed.
     * A completed settlement is typically reflected in a bank account within 3 business days, but
     * in exceptional cases it may take longer.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the settlements's associated location.
     * @param  settlementId  Required parameter: The settlement's Square-issued ID. You obtain this
     *         value from Settlement objects returned by the List Settlements endpoint.
     * @return    Returns the V1Settlement response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public V1Settlement v1RetrieveSettlement(
            final String locationId,
            final String settlementId) throws ApiException, IOException {
        HttpRequest request = buildV1RetrieveSettlementRequest(locationId, settlementId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleV1RetrieveSettlementResponse(context);
    }

    /**
     * Provides comprehensive information for a single settlement. The returned `Settlement` objects
     * include an `entries` field that lists the transactions that contribute to the settlement
     * total. Most settlement entries correspond to a payment payout, but settlement entries are
     * also generated for less common events, like refunds, manual adjustments, or chargeback holds.
     * Square initiates its regular deposits as indicated in the [Deposit Options with
     * Square](https://squareup.com/help/us/en/article/3807) help article. Details for a regular
     * deposit are usually not available from Connect API endpoints before 10 p.m. PST the same day.
     * Square does not know when an initiated settlement **completes**, only whether it has failed.
     * A completed settlement is typically reflected in a bank account within 3 business days, but
     * in exceptional cases it may take longer.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the settlements's associated location.
     * @param  settlementId  Required parameter: The settlement's Square-issued ID. You obtain this
     *         value from Settlement objects returned by the List Settlements endpoint.
     * @return    Returns the V1Settlement response from the API call
     */
    @Deprecated
    public CompletableFuture<V1Settlement> v1RetrieveSettlementAsync(
            final String locationId,
            final String settlementId) {
        return makeHttpCallAsync(() -> buildV1RetrieveSettlementRequest(locationId, settlementId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleV1RetrieveSettlementResponse(context));
    }

    /**
     * Builds the HttpRequest object for v1RetrieveSettlement.
     */
    private HttpRequest buildV1RetrieveSettlementRequest(
            final String locationId,
            final String settlementId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/{location_id}/settlements/{settlement_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        templateParameters.put("settlement_id",
                new SimpleEntry<Object, Boolean>(settlementId, true));
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
     * Processes the response for v1RetrieveSettlement.
     * @return An object of type V1Settlement
     */
    private V1Settlement handleV1RetrieveSettlementResponse(
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
        V1Settlement result = ApiHelper.deserialize(responseBody,
                V1Settlement.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}