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

public final class V1TransactionsApi extends BaseApi {
    public V1TransactionsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public V1TransactionsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Provides non-confidential details for all of a location's associated bank accounts. This endpoint does not provide full bank account numbers, and there is no way to obtain a full bank account number with the Connect API.
     * @param    locationId    Required parameter: The ID of the location to list bank accounts for.
     * @return    Returns the List<V1BankAccount> response from the API call
     */
    public List<V1BankAccount> listBankAccounts(
            final String locationId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListBankAccountsRequest(locationId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListBankAccountsResponse(_context);
    }

    /**
     * Provides non-confidential details for all of a location's associated bank accounts. This endpoint does not provide full bank account numbers, and there is no way to obtain a full bank account number with the Connect API.
     * @param    locationId    Required parameter: The ID of the location to list bank accounts for.
     * @return    Returns the List<V1BankAccount> response from the API call 
     */
    public CompletableFuture<List<V1BankAccount>> listBankAccountsAsync(
            final String locationId
    ) {
        return makeHttpCallAsync(() -> _buildListBankAccountsRequest(locationId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListBankAccountsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listBankAccounts
     */
    private HttpRequest _buildListBankAccountsRequest(
            final String locationId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/bank-accounts");

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
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for listBankAccounts
     * @return An object of type List<V1BankAccount>
     */
    private List<V1BankAccount> _handleListBankAccountsResponse(HttpContext _context)
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
        List<V1BankAccount> _result = ApiHelper.deserializeArray(_responseBody,
                V1BankAccount[].class);
        return _result;
    }

    /**
     * Provides non-confidential details for a merchant's associated bank account. This endpoint does not provide full bank account numbers, and there is no way to obtain a full bank account number with the Connect API.
     * @param    locationId    Required parameter: The ID of the bank account's associated location.
     * @param    bankAccountId    Required parameter: The bank account's Square-issued ID. You obtain this value from Settlement objects returned.
     * @return    Returns the V1BankAccount response from the API call
     */
    public V1BankAccount retrieveBankAccount(
            final String locationId,
            final String bankAccountId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveBankAccountRequest(locationId, bankAccountId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveBankAccountResponse(_context);
    }

    /**
     * Provides non-confidential details for a merchant's associated bank account. This endpoint does not provide full bank account numbers, and there is no way to obtain a full bank account number with the Connect API.
     * @param    locationId    Required parameter: The ID of the bank account's associated location.
     * @param    bankAccountId    Required parameter: The bank account's Square-issued ID. You obtain this value from Settlement objects returned.
     * @return    Returns the V1BankAccount response from the API call 
     */
    public CompletableFuture<V1BankAccount> retrieveBankAccountAsync(
            final String locationId,
            final String bankAccountId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveBankAccountRequest(locationId, bankAccountId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveBankAccountResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveBankAccount
     */
    private HttpRequest _buildRetrieveBankAccountRequest(
            final String locationId,
            final String bankAccountId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/bank-accounts/{bank_account_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("bank_account_id", bankAccountId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for retrieveBankAccount
     * @return An object of type V1BankAccount
     */
    private V1BankAccount _handleRetrieveBankAccountResponse(HttpContext _context)
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
        V1BankAccount _result = ApiHelper.deserialize(_responseBody,
                V1BankAccount.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides summary information for a merchant's online store orders.
     * @param    locationId    Required parameter: The ID of the location to list online store orders for.
     * @param    order    Optional parameter: TThe order in which payments are listed in the response.
     * @param    limit    Optional parameter: The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Order> response from the API call
     */
    public List<V1Order> listOrders(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListOrdersRequest(locationId, order, limit, batchToken);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListOrdersResponse(_context);
    }

    /**
     * Provides summary information for a merchant's online store orders.
     * @param    locationId    Required parameter: The ID of the location to list online store orders for.
     * @param    order    Optional parameter: TThe order in which payments are listed in the response.
     * @param    limit    Optional parameter: The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Order> response from the API call 
     */
    public CompletableFuture<List<V1Order>> listOrdersAsync(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken
    ) {
        return makeHttpCallAsync(() -> _buildListOrdersRequest(locationId, order, limit, batchToken),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListOrdersResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listOrders
     */
    private HttpRequest _buildListOrdersRequest(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/orders");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("order", order);
        _queryParameters.put("limit", limit);
        _queryParameters.put("batch_token", batchToken);
        ApiHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for listOrders
     * @return An object of type List<V1Order>
     */
    private List<V1Order> _handleListOrdersResponse(HttpContext _context)
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
        List<V1Order> _result = ApiHelper.deserializeArray(_responseBody,
                V1Order[].class);
        return _result;
    }

    /**
     * Provides comprehensive information for a single online store order, including the order's history.
     * @param    locationId    Required parameter: The ID of the order's associated location.
     * @param    orderId    Required parameter: The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
     * @return    Returns the V1Order response from the API call
     */
    public V1Order retrieveOrder(
            final String locationId,
            final String orderId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveOrderRequest(locationId, orderId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveOrderResponse(_context);
    }

    /**
     * Provides comprehensive information for a single online store order, including the order's history.
     * @param    locationId    Required parameter: The ID of the order's associated location.
     * @param    orderId    Required parameter: The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
     * @return    Returns the V1Order response from the API call 
     */
    public CompletableFuture<V1Order> retrieveOrderAsync(
            final String locationId,
            final String orderId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveOrderRequest(locationId, orderId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveOrderResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveOrder
     */
    private HttpRequest _buildRetrieveOrderRequest(
            final String locationId,
            final String orderId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/orders/{order_id}");

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
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for retrieveOrder
     * @return An object of type V1Order
     */
    private V1Order _handleRetrieveOrderResponse(HttpContext _context)
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
        V1Order _result = ApiHelper.deserialize(_responseBody,
                V1Order.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Updates the details of an online store order. Every update you perform on an order corresponds to one of three actions:
     * @param    locationId    Required parameter: The ID of the order's associated location.
     * @param    orderId    Required parameter: The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Order response from the API call
     */
    public V1Order updateOrder(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateOrderRequest(locationId, orderId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateOrderResponse(_context);
    }

    /**
     * Updates the details of an online store order. Every update you perform on an order corresponds to one of three actions:
     * @param    locationId    Required parameter: The ID of the order's associated location.
     * @param    orderId    Required parameter: The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Order response from the API call 
     */
    public CompletableFuture<V1Order> updateOrderAsync(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body
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
            final V1UpdateOrderRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/orders/{order_id}");

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
     * @return An object of type V1Order
     */
    private V1Order _handleUpdateOrderResponse(HttpContext _context)
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
        V1Order _result = ApiHelper.deserialize(_responseBody,
                V1Order.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides summary information for all payments taken for a given
     * Square account during a date range. Date ranges cannot exceed 1 year in
     * length. See Date ranges for details of inclusive and exclusive dates.
     * *Note**: Details for payments processed with Square Point of Sale while
     * in offline mode may not be transmitted to Square for up to 72 hours.
     * Offline payments have a `created_at` value that reflects the time the
     * payment was originally processed, not the time it was subsequently
     * transmitted to Square. Consequently, the ListPayments endpoint might
     * list an offline payment chronologically between online payments that
     * were seen in a previous request.
     * @param    locationId    Required parameter: The ID of the location to list payments for. If you specify me, this endpoint returns payments aggregated from all of the business's locations.
     * @param    order    Optional parameter: The order in which payments are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @param    includePartial    Optional parameter: Indicates whether or not to include partial payments in the response. Partial payments will have the tenders collected so far, but the itemizations will be empty until the payment is completed.
     * @return    Returns the List<V1Payment> response from the API call
     */
    public List<V1Payment> listPayments(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListPaymentsRequest(locationId, order, beginTime, endTime, limit, batchToken, includePartial);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListPaymentsResponse(_context);
    }

    /**
     * Provides summary information for all payments taken for a given
     * Square account during a date range. Date ranges cannot exceed 1 year in
     * length. See Date ranges for details of inclusive and exclusive dates.
     * *Note**: Details for payments processed with Square Point of Sale while
     * in offline mode may not be transmitted to Square for up to 72 hours.
     * Offline payments have a `created_at` value that reflects the time the
     * payment was originally processed, not the time it was subsequently
     * transmitted to Square. Consequently, the ListPayments endpoint might
     * list an offline payment chronologically between online payments that
     * were seen in a previous request.
     * @param    locationId    Required parameter: The ID of the location to list payments for. If you specify me, this endpoint returns payments aggregated from all of the business's locations.
     * @param    order    Optional parameter: The order in which payments are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @param    includePartial    Optional parameter: Indicates whether or not to include partial payments in the response. Partial payments will have the tenders collected so far, but the itemizations will be empty until the payment is completed.
     * @return    Returns the List<V1Payment> response from the API call 
     */
    public CompletableFuture<List<V1Payment>> listPaymentsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial
    ) {
        return makeHttpCallAsync(() -> _buildListPaymentsRequest(locationId, order, beginTime, endTime, limit, batchToken, includePartial),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListPaymentsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listPayments
     */
    private HttpRequest _buildListPaymentsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/payments");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("order", order);
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
        _queryParameters.put("limit", limit);
        _queryParameters.put("batch_token", batchToken);
        _queryParameters.put("include_partial", includePartial);
        ApiHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for listPayments
     * @return An object of type List<V1Payment>
     */
    private List<V1Payment> _handleListPaymentsResponse(HttpContext _context)
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
        List<V1Payment> _result = ApiHelper.deserializeArray(_responseBody,
                V1Payment[].class);
        return _result;
    }

    /**
     * Provides comprehensive information for a single payment.
     * @param    locationId    Required parameter: The ID of the payment's associated location.
     * @param    paymentId    Required parameter: The Square-issued payment ID. payment_id comes from Payment objects returned by the List Payments endpoint, Settlement objects returned by the List Settlements endpoint, or Refund objects returned by the List Refunds endpoint.
     * @return    Returns the V1Payment response from the API call
     */
    public V1Payment retrievePayment(
            final String locationId,
            final String paymentId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrievePaymentRequest(locationId, paymentId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrievePaymentResponse(_context);
    }

    /**
     * Provides comprehensive information for a single payment.
     * @param    locationId    Required parameter: The ID of the payment's associated location.
     * @param    paymentId    Required parameter: The Square-issued payment ID. payment_id comes from Payment objects returned by the List Payments endpoint, Settlement objects returned by the List Settlements endpoint, or Refund objects returned by the List Refunds endpoint.
     * @return    Returns the V1Payment response from the API call 
     */
    public CompletableFuture<V1Payment> retrievePaymentAsync(
            final String locationId,
            final String paymentId
    ) {
        return makeHttpCallAsync(() -> _buildRetrievePaymentRequest(locationId, paymentId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrievePaymentResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrievePayment
     */
    private HttpRequest _buildRetrievePaymentRequest(
            final String locationId,
            final String paymentId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/payments/{payment_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("payment_id", paymentId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for retrievePayment
     * @return An object of type V1Payment
     */
    private V1Payment _handleRetrievePaymentResponse(HttpContext _context)
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
        V1Payment _result = ApiHelper.deserialize(_responseBody,
                V1Payment.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides the details for all refunds initiated by a merchant or any of the merchant's mobile staff during a date range. Date ranges cannot exceed one year in length.
     * @param    locationId    Required parameter: The ID of the location to list refunds for.
     * @param    order    Optional parameter: TThe order in which payments are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The approximate number of refunds to return in a single response. Default: 100. Max: 200. Response may contain more results than the prescribed limit when refunds are made simultaneously to multiple tenders in a payment or when refunds are generated in an exchange to account for the value of returned goods.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Refund> response from the API call
     */
    public List<V1Refund> listRefunds(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListRefundsRequest(locationId, order, beginTime, endTime, limit, batchToken);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListRefundsResponse(_context);
    }

    /**
     * Provides the details for all refunds initiated by a merchant or any of the merchant's mobile staff during a date range. Date ranges cannot exceed one year in length.
     * @param    locationId    Required parameter: The ID of the location to list refunds for.
     * @param    order    Optional parameter: TThe order in which payments are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The approximate number of refunds to return in a single response. Default: 100. Max: 200. Response may contain more results than the prescribed limit when refunds are made simultaneously to multiple tenders in a payment or when refunds are generated in an exchange to account for the value of returned goods.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Refund> response from the API call 
     */
    public CompletableFuture<List<V1Refund>> listRefundsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken
    ) {
        return makeHttpCallAsync(() -> _buildListRefundsRequest(locationId, order, beginTime, endTime, limit, batchToken),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListRefundsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listRefunds
     */
    private HttpRequest _buildListRefundsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/refunds");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("order", order);
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
        _queryParameters.put("limit", limit);
        _queryParameters.put("batch_token", batchToken);
        ApiHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for listRefunds
     * @return An object of type List<V1Refund>
     */
    private List<V1Refund> _handleListRefundsResponse(HttpContext _context)
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
        List<V1Refund> _result = ApiHelper.deserializeArray(_responseBody,
                V1Refund[].class);
        return _result;
    }

    /**
     * Issues a refund for a previously processed payment. You must issue
     * a refund within 60 days of the associated payment.
     * You cannot issue a partial refund for a split tender payment. You must
     * instead issue a full or partial refund for a particular tender, by
     * providing the applicable tender id to the V1CreateRefund endpoint.
     * Issuing a full refund for a split tender payment refunds all tenders
     * associated with the payment.
     * Issuing a refund for a card payment is not reversible. For development
     * purposes, you can create fake cash payments in Square Point of Sale and
     * refund them.
     * @param    locationId    Required parameter: The ID of the original payment's associated location.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Refund response from the API call
     */
    public V1Refund createRefund(
            final String locationId,
            final V1CreateRefundRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateRefundRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateRefundResponse(_context);
    }

    /**
     * Issues a refund for a previously processed payment. You must issue
     * a refund within 60 days of the associated payment.
     * You cannot issue a partial refund for a split tender payment. You must
     * instead issue a full or partial refund for a particular tender, by
     * providing the applicable tender id to the V1CreateRefund endpoint.
     * Issuing a full refund for a split tender payment refunds all tenders
     * associated with the payment.
     * Issuing a refund for a card payment is not reversible. For development
     * purposes, you can create fake cash payments in Square Point of Sale and
     * refund them.
     * @param    locationId    Required parameter: The ID of the original payment's associated location.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Refund response from the API call 
     */
    public CompletableFuture<V1Refund> createRefundAsync(
            final String locationId,
            final V1CreateRefundRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreateRefundRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateRefundResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createRefund
     */
    private HttpRequest _buildCreateRefundRequest(
            final String locationId,
            final V1CreateRefundRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/refunds");

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
     * Processes the response for createRefund
     * @return An object of type V1Refund
     */
    private V1Refund _handleCreateRefundResponse(HttpContext _context)
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
        V1Refund _result = ApiHelper.deserialize(_responseBody,
                V1Refund.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides summary information for all deposits and withdrawals
     * initiated by Square to a linked bank account during a date range. Date
     * ranges cannot exceed one year in length.
     * *Note**: the ListSettlements endpoint does not provide entry
     * information.
     * @param    locationId    Required parameter: The ID of the location to list settlements for.
     * @param    order    Optional parameter: TThe order in which payments are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @param    status    Optional parameter: Provide this parameter to retrieve only settlements with a particular status (SENT or FAILED).
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Settlement> response from the API call
     */
    public List<V1Settlement> listSettlements(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListSettlementsRequest(locationId, order, beginTime, endTime, limit, status, batchToken);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListSettlementsResponse(_context);
    }

    /**
     * Provides summary information for all deposits and withdrawals
     * initiated by Square to a linked bank account during a date range. Date
     * ranges cannot exceed one year in length.
     * *Note**: the ListSettlements endpoint does not provide entry
     * information.
     * @param    locationId    Required parameter: The ID of the location to list settlements for.
     * @param    order    Optional parameter: TThe order in which payments are listed in the response.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     * @param    limit    Optional parameter: The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @param    status    Optional parameter: Provide this parameter to retrieve only settlements with a particular status (SENT or FAILED).
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Settlement> response from the API call 
     */
    public CompletableFuture<List<V1Settlement>> listSettlementsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken
    ) {
        return makeHttpCallAsync(() -> _buildListSettlementsRequest(locationId, order, beginTime, endTime, limit, status, batchToken),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListSettlementsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listSettlements
     */
    private HttpRequest _buildListSettlementsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/settlements");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("order", order);
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
        _queryParameters.put("limit", limit);
        _queryParameters.put("status", status);
        _queryParameters.put("batch_token", batchToken);
        ApiHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for listSettlements
     * @return An object of type List<V1Settlement>
     */
    private List<V1Settlement> _handleListSettlementsResponse(HttpContext _context)
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
        List<V1Settlement> _result = ApiHelper.deserializeArray(_responseBody,
                V1Settlement[].class);
        return _result;
    }

    /**
     * Provides comprehensive information for a single settlement.
     * The returned `Settlement` objects include an `entries` field that lists
     * the transactions that contribute to the settlement total. Most
     * settlement entries correspond to a payment payout, but settlement
     * entries are also generated for less common events, like refunds, manual
     * adjustments, or chargeback holds.
     * Square initiates its regular deposits as indicated in the
     * [Deposit Options with Square](https://squareup.com/help/us/en/article/3807)
     * help article. Details for a regular deposit are usually not available
     * from Connect API endpoints before 10 p.m. PST the same day.
     * Square does not know when an initiated settlement **completes**, only
     * whether it has failed. A completed settlement is typically reflected in
     * a bank account within 3 business days, but in exceptional cases it may
     * take longer.
     * @param    locationId    Required parameter: The ID of the settlements's associated location.
     * @param    settlementId    Required parameter: The settlement's Square-issued ID. You obtain this value from Settlement objects returned by the List Settlements endpoint.
     * @return    Returns the V1Settlement response from the API call
     */
    public V1Settlement retrieveSettlement(
            final String locationId,
            final String settlementId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveSettlementRequest(locationId, settlementId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveSettlementResponse(_context);
    }

    /**
     * Provides comprehensive information for a single settlement.
     * The returned `Settlement` objects include an `entries` field that lists
     * the transactions that contribute to the settlement total. Most
     * settlement entries correspond to a payment payout, but settlement
     * entries are also generated for less common events, like refunds, manual
     * adjustments, or chargeback holds.
     * Square initiates its regular deposits as indicated in the
     * [Deposit Options with Square](https://squareup.com/help/us/en/article/3807)
     * help article. Details for a regular deposit are usually not available
     * from Connect API endpoints before 10 p.m. PST the same day.
     * Square does not know when an initiated settlement **completes**, only
     * whether it has failed. A completed settlement is typically reflected in
     * a bank account within 3 business days, but in exceptional cases it may
     * take longer.
     * @param    locationId    Required parameter: The ID of the settlements's associated location.
     * @param    settlementId    Required parameter: The settlement's Square-issued ID. You obtain this value from Settlement objects returned by the List Settlements endpoint.
     * @return    Returns the V1Settlement response from the API call 
     */
    public CompletableFuture<V1Settlement> retrieveSettlementAsync(
            final String locationId,
            final String settlementId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveSettlementRequest(locationId, settlementId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveSettlementResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveSettlement
     */
    private HttpRequest _buildRetrieveSettlementRequest(
            final String locationId,
            final String settlementId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/settlements/{settlement_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("settlement_id", settlementId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for retrieveSettlement
     * @return An object of type V1Settlement
     */
    private V1Settlement _handleRetrieveSettlementResponse(HttpContext _context)
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
        V1Settlement _result = ApiHelper.deserialize(_responseBody,
                V1Settlement.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
