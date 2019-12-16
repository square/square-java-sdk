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

public final class TransactionsApi extends BaseApi {
    public TransactionsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public TransactionsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists refunds for one of a business's locations.
     * Deprecated - recommend using [SearchOrders](#endpoint-orders-searchorders)
     * In addition to full or partial tender refunds processed through Square APIs,
     * refunds may result from itemized returns or exchanges through Square's
     * Point of Sale applications.
     * Refunds with a `status` of `PENDING` are not currently included in this
     * endpoint's response.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list refunds for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListRefundsResponse response from the API call
     */
    @Deprecated
    public ListRefundsResponse listRefunds(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListRefundsRequest(locationId, beginTime, endTime, sortOrder, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListRefundsResponse(_context);
    }

    /**
     * Lists refunds for one of a business's locations.
     * Deprecated - recommend using [SearchOrders](#endpoint-orders-searchorders)
     * In addition to full or partial tender refunds processed through Square APIs,
     * refunds may result from itemized returns or exchanges through Square's
     * Point of Sale applications.
     * Refunds with a `status` of `PENDING` are not currently included in this
     * endpoint's response.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list refunds for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListRefundsResponse response from the API call 
     */
    @Deprecated
    public CompletableFuture<ListRefundsResponse> listRefundsAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildListRefundsRequest(locationId, beginTime, endTime, sortOrder, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListRefundsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listRefunds
     */
    private HttpRequest _buildListRefundsRequest(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/refunds");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
        _queryParameters.put("sort_order", sortOrder);
        _queryParameters.put("cursor", cursor);
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
     * @return An object of type ListRefundsResponse
     */
    private ListRefundsResponse _handleListRefundsResponse(HttpContext _context)
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
        ListRefundsResponse _result = ApiHelper.deserialize(_responseBody,
                ListRefundsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Lists transactions for a particular location.
     * Deprecated - recommend using [SearchOrders](#endpoint-orders-searchorders)
     * Transactions include payment information from sales and exchanges and refund
     * information from returns and exchanges.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list transactions for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListTransactionsResponse response from the API call
     */
    @Deprecated
    public ListTransactionsResponse listTransactions(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListTransactionsRequest(locationId, beginTime, endTime, sortOrder, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListTransactionsResponse(_context);
    }

    /**
     * Lists transactions for a particular location.
     * Deprecated - recommend using [SearchOrders](#endpoint-orders-searchorders)
     * Transactions include payment information from sales and exchanges and refund
     * information from returns and exchanges.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list transactions for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListTransactionsResponse response from the API call 
     */
    @Deprecated
    public CompletableFuture<ListTransactionsResponse> listTransactionsAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildListTransactionsRequest(locationId, beginTime, endTime, sortOrder, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListTransactionsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listTransactions
     */
    private HttpRequest _buildListTransactionsRequest(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/transactions");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
        _queryParameters.put("sort_order", sortOrder);
        _queryParameters.put("cursor", cursor);
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
     * Processes the response for listTransactions
     * @return An object of type ListTransactionsResponse
     */
    private ListTransactionsResponse _handleListTransactionsResponse(HttpContext _context)
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
        ListTransactionsResponse _result = ApiHelper.deserialize(_responseBody,
                ListTransactionsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Charges a card represented by a card nonce or a customer's card on file.
     * Deprecated - recommend using [CreatePayment](#endpoint-payments-createpayment)
     * Your request to this endpoint must include _either_:
     * - A value for the `card_nonce` parameter (to charge a card nonce generated
     * with the `SqPaymentForm`)
     * - Values for the `customer_card_id` and `customer_id` parameters (to charge
     * a customer's card on file)
     * In order for an eCommerce payment to potentially qualify for
     * [Square chargeback protection](https://squareup.com/help/article/5394), you
     * _must_ provide values for the following parameters in your request:
     * - `buyer_email_address`
     * - At least one of `billing_address` or `shipping_address`
     * When this response is returned, the amount of Square's processing fee might not yet be
     * calculated. To obtain the processing fee, wait about ten seconds and call
     * [RetrieveTransaction](#endpoint-retrievetransaction). See the `processing_fee_money`
     * field of each [Tender included](#type-tender) in the transaction.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to associate the created transaction with.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the ChargeResponse response from the API call
     */
    @Deprecated
    public ChargeResponse charge(
            final String locationId,
            final ChargeRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildChargeRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleChargeResponse(_context);
    }

    /**
     * Charges a card represented by a card nonce or a customer's card on file.
     * Deprecated - recommend using [CreatePayment](#endpoint-payments-createpayment)
     * Your request to this endpoint must include _either_:
     * - A value for the `card_nonce` parameter (to charge a card nonce generated
     * with the `SqPaymentForm`)
     * - Values for the `customer_card_id` and `customer_id` parameters (to charge
     * a customer's card on file)
     * In order for an eCommerce payment to potentially qualify for
     * [Square chargeback protection](https://squareup.com/help/article/5394), you
     * _must_ provide values for the following parameters in your request:
     * - `buyer_email_address`
     * - At least one of `billing_address` or `shipping_address`
     * When this response is returned, the amount of Square's processing fee might not yet be
     * calculated. To obtain the processing fee, wait about ten seconds and call
     * [RetrieveTransaction](#endpoint-retrievetransaction). See the `processing_fee_money`
     * field of each [Tender included](#type-tender) in the transaction.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to associate the created transaction with.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the ChargeResponse response from the API call 
     */
    @Deprecated
    public CompletableFuture<ChargeResponse> chargeAsync(
            final String locationId,
            final ChargeRequest body
    ) {
        return makeHttpCallAsync(() -> _buildChargeRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleChargeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for charge
     */
    private HttpRequest _buildChargeRequest(
            final String locationId,
            final ChargeRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/transactions");

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
     * Processes the response for charge
     * @return An object of type ChargeResponse
     */
    private ChargeResponse _handleChargeResponse(HttpContext _context)
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
        ChargeResponse _result = ApiHelper.deserialize(_responseBody,
                ChargeResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Retrieves details for a single transaction.
     * Deprecated - recommend using [BatchRetrieveOrders](#endpoint-batchretrieveorders)
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the transaction's associated location.
     * @param    transactionId    Required parameter: The ID of the transaction to retrieve.
     * @return    Returns the RetrieveTransactionResponse response from the API call
     */
    @Deprecated
    public RetrieveTransactionResponse retrieveTransaction(
            final String locationId,
            final String transactionId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveTransactionRequest(locationId, transactionId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveTransactionResponse(_context);
    }

    /**
     * Retrieves details for a single transaction.
     * Deprecated - recommend using [BatchRetrieveOrders](#endpoint-batchretrieveorders)
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the transaction's associated location.
     * @param    transactionId    Required parameter: The ID of the transaction to retrieve.
     * @return    Returns the RetrieveTransactionResponse response from the API call 
     */
    @Deprecated
    public CompletableFuture<RetrieveTransactionResponse> retrieveTransactionAsync(
            final String locationId,
            final String transactionId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveTransactionRequest(locationId, transactionId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveTransactionResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveTransaction
     */
    private HttpRequest _buildRetrieveTransactionRequest(
            final String locationId,
            final String transactionId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/transactions/{transaction_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("transaction_id", transactionId);
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
     * Processes the response for retrieveTransaction
     * @return An object of type RetrieveTransactionResponse
     */
    private RetrieveTransactionResponse _handleRetrieveTransactionResponse(HttpContext _context)
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
        RetrieveTransactionResponse _result = ApiHelper.deserialize(_responseBody,
                RetrieveTransactionResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Captures a transaction that was created with the [Charge](#endpoint-charge)
     * endpoint with a `delay_capture` value of `true`.
     * See [Delayed capture transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param    locationId    Required parameter: Example: 
     * @param    transactionId    Required parameter: Example: 
     * @return    Returns the CaptureTransactionResponse response from the API call
     */
    @Deprecated
    public CaptureTransactionResponse captureTransaction(
            final String locationId,
            final String transactionId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCaptureTransactionRequest(locationId, transactionId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCaptureTransactionResponse(_context);
    }

    /**
     * Captures a transaction that was created with the [Charge](#endpoint-charge)
     * endpoint with a `delay_capture` value of `true`.
     * See [Delayed capture transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param    locationId    Required parameter: Example: 
     * @param    transactionId    Required parameter: Example: 
     * @return    Returns the CaptureTransactionResponse response from the API call 
     */
    @Deprecated
    public CompletableFuture<CaptureTransactionResponse> captureTransactionAsync(
            final String locationId,
            final String transactionId
    ) {
        return makeHttpCallAsync(() -> _buildCaptureTransactionRequest(locationId, transactionId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCaptureTransactionResponse(_context));
    }

    /**
     * Builds the HttpRequest object for captureTransaction
     */
    private HttpRequest _buildCaptureTransactionRequest(
            final String locationId,
            final String transactionId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/transactions/{transaction_id}/capture");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("transaction_id", transactionId);
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
        HttpRequest _request = getClientInstance().post(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for captureTransaction
     * @return An object of type CaptureTransactionResponse
     */
    private CaptureTransactionResponse _handleCaptureTransactionResponse(HttpContext _context)
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
        CaptureTransactionResponse _result = ApiHelper.deserialize(_responseBody,
                CaptureTransactionResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Initiates a refund for a previously charged tender.
     * Deprecated - recommend using [RefundPayment](#endpoint-refunds-refundpayment)
     * You must issue a refund within 120 days of the associated payment. See
     * [this article](https://squareup.com/help/us/en/article/5060) for more information
     * on refund behavior.
     * NOTE: Card-present transactions with Interac credit cards **cannot be
     * refunded using the Connect API**. Interac transactions must refunded
     * in-person (e.g., dipping the card using POS app).
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the original transaction's associated location.
     * @param    transactionId    Required parameter: The ID of the original transaction that includes the tender to refund.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateRefundResponse response from the API call
     */
    @Deprecated
    public CreateRefundResponse createRefund(
            final String locationId,
            final String transactionId,
            final CreateRefundRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateRefundRequest(locationId, transactionId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateRefundResponse(_context);
    }

    /**
     * Initiates a refund for a previously charged tender.
     * Deprecated - recommend using [RefundPayment](#endpoint-refunds-refundpayment)
     * You must issue a refund within 120 days of the associated payment. See
     * [this article](https://squareup.com/help/us/en/article/5060) for more information
     * on refund behavior.
     * NOTE: Card-present transactions with Interac credit cards **cannot be
     * refunded using the Connect API**. Interac transactions must refunded
     * in-person (e.g., dipping the card using POS app).
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the original transaction's associated location.
     * @param    transactionId    Required parameter: The ID of the original transaction that includes the tender to refund.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateRefundResponse response from the API call 
     */
    @Deprecated
    public CompletableFuture<CreateRefundResponse> createRefundAsync(
            final String locationId,
            final String transactionId,
            final CreateRefundRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreateRefundRequest(locationId, transactionId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateRefundResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createRefund
     */
    private HttpRequest _buildCreateRefundRequest(
            final String locationId,
            final String transactionId,
            final CreateRefundRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/transactions/{transaction_id}/refund");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("transaction_id", transactionId);
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
     * @return An object of type CreateRefundResponse
     */
    private CreateRefundResponse _handleCreateRefundResponse(HttpContext _context)
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
        CreateRefundResponse _result = ApiHelper.deserialize(_responseBody,
                CreateRefundResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Cancels a transaction that was created with the [Charge](#endpoint-charge)
     * endpoint with a `delay_capture` value of `true`.
     * See [Delayed capture transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param    locationId    Required parameter: Example: 
     * @param    transactionId    Required parameter: Example: 
     * @return    Returns the VoidTransactionResponse response from the API call
     */
    @Deprecated
    public VoidTransactionResponse voidTransaction(
            final String locationId,
            final String transactionId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildVoidTransactionRequest(locationId, transactionId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleVoidTransactionResponse(_context);
    }

    /**
     * Cancels a transaction that was created with the [Charge](#endpoint-charge)
     * endpoint with a `delay_capture` value of `true`.
     * See [Delayed capture transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param    locationId    Required parameter: Example: 
     * @param    transactionId    Required parameter: Example: 
     * @return    Returns the VoidTransactionResponse response from the API call 
     */
    @Deprecated
    public CompletableFuture<VoidTransactionResponse> voidTransactionAsync(
            final String locationId,
            final String transactionId
    ) {
        return makeHttpCallAsync(() -> _buildVoidTransactionRequest(locationId, transactionId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleVoidTransactionResponse(_context));
    }

    /**
     * Builds the HttpRequest object for voidTransaction
     */
    private HttpRequest _buildVoidTransactionRequest(
            final String locationId,
            final String transactionId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/transactions/{transaction_id}/void");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("transaction_id", transactionId);
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
        HttpRequest _request = getClientInstance().post(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for voidTransaction
     * @return An object of type VoidTransactionResponse
     */
    private VoidTransactionResponse _handleVoidTransactionResponse(HttpContext _context)
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
        VoidTransactionResponse _result = ApiHelper.deserialize(_responseBody,
                VoidTransactionResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
