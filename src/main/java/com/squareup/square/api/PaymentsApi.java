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

public final class PaymentsApi extends BaseApi {
    public PaymentsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public PaymentsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Retrieves a list of payments taken by the account making the request.
     * Max results per page: 100
     * @param    beginTime    Optional parameter: Timestamp for the beginning of the reporting period, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param    endTime    Optional parameter: Timestamp for the end of the requested reporting period, in RFC 3339 format.  Default: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed. - `ASC` - oldest to newest - `DESC` - newest to oldest (default).
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    locationId    Optional parameter: ID of location associated with payment
     * @param    total    Optional parameter: The exact amount in the total_money for a `Payment`.
     * @param    last4    Optional parameter: The last 4 digits of `Payment` card.
     * @param    cardBrand    Optional parameter: The brand of `Payment` card. For example, `VISA`
     * @return    Returns the ListPaymentsResponse response from the API call
     */
    public ListPaymentsResponse listPayments(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListPaymentsRequest(beginTime, endTime, sortOrder, cursor, locationId, total, last4, cardBrand);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListPaymentsResponse(_context);
    }

    /**
     * Retrieves a list of payments taken by the account making the request.
     * Max results per page: 100
     * @param    beginTime    Optional parameter: Timestamp for the beginning of the reporting period, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param    endTime    Optional parameter: Timestamp for the end of the requested reporting period, in RFC 3339 format.  Default: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed. - `ASC` - oldest to newest - `DESC` - newest to oldest (default).
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    locationId    Optional parameter: ID of location associated with payment
     * @param    total    Optional parameter: The exact amount in the total_money for a `Payment`.
     * @param    last4    Optional parameter: The last 4 digits of `Payment` card.
     * @param    cardBrand    Optional parameter: The brand of `Payment` card. For example, `VISA`
     * @return    Returns the ListPaymentsResponse response from the API call 
     */
    public CompletableFuture<ListPaymentsResponse> listPaymentsAsync(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand
    ) {
        return makeHttpCallAsync(() -> _buildListPaymentsRequest(beginTime, endTime, sortOrder, cursor, locationId, total, last4, cardBrand),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListPaymentsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listPayments
     */
    private HttpRequest _buildListPaymentsRequest(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/payments");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
        _queryParameters.put("sort_order", sortOrder);
        _queryParameters.put("cursor", cursor);
        _queryParameters.put("location_id", locationId);
        _queryParameters.put("total", total);
        _queryParameters.put("last_4", last4);
        _queryParameters.put("card_brand", cardBrand);
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
     * @return An object of type ListPaymentsResponse
     */
    private ListPaymentsResponse _handleListPaymentsResponse(HttpContext _context)
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
        ListPaymentsResponse _result = ApiHelper.deserialize(_responseBody,
                ListPaymentsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Charges a payment source, for example, a card 
     * represented by customer's card on file or a card nonce. In addition 
     * to the payment source, the request must also include the 
     * amount to accept for the payment.
     * There are several optional parameters that you can include in the request. 
     * For example, tip money, whether to autocomplete the payment, or a reference ID
     * to correlate this payment with another system. 
     * For more information about these 
     * payment options, see [Take Payments](https://developer.squareup.com/docs/payments-api/take-payments).
     * The `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission is required
     * to enable application fees.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentResponse response from the API call
     */
    public CreatePaymentResponse createPayment(
            final CreatePaymentRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreatePaymentRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreatePaymentResponse(_context);
    }

    /**
     * Charges a payment source, for example, a card 
     * represented by customer's card on file or a card nonce. In addition 
     * to the payment source, the request must also include the 
     * amount to accept for the payment.
     * There are several optional parameters that you can include in the request. 
     * For example, tip money, whether to autocomplete the payment, or a reference ID
     * to correlate this payment with another system. 
     * For more information about these 
     * payment options, see [Take Payments](https://developer.squareup.com/docs/payments-api/take-payments).
     * The `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission is required
     * to enable application fees.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentResponse response from the API call 
     */
    public CompletableFuture<CreatePaymentResponse> createPaymentAsync(
            final CreatePaymentRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreatePaymentRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreatePaymentResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createPayment
     */
    private HttpRequest _buildCreatePaymentRequest(
            final CreatePaymentRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/payments");
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
     * Processes the response for createPayment
     * @return An object of type CreatePaymentResponse
     */
    private CreatePaymentResponse _handleCreatePaymentResponse(HttpContext _context)
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
        CreatePaymentResponse _result = ApiHelper.deserialize(_responseBody,
                CreatePaymentResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Cancels (voids) a payment identified by the idempotency key that is specified in the request. 
     * Use this method when status of a CreatePayment request is unknown. 
     * For example, after you send a CreatePayment 
     * request a network error occurs and you don't get a response. In this case, you can direct 
     * Square to cancel the payment using this endpoint. In the request, you provide the same idempotency 
     * key that you provided in your CreatePayment request you want  to cancel. After cancelling the 
     * payment, you can submit your CreatePayment request again. 
     * Note that if no payment with the specified idempotency key is found, no action is taken, the end 
     * point returns successfully.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CancelPaymentByIdempotencyKeyResponse response from the API call
     */
    public CancelPaymentByIdempotencyKeyResponse cancelPaymentByIdempotencyKey(
            final CancelPaymentByIdempotencyKeyRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCancelPaymentByIdempotencyKeyRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCancelPaymentByIdempotencyKeyResponse(_context);
    }

    /**
     * Cancels (voids) a payment identified by the idempotency key that is specified in the request. 
     * Use this method when status of a CreatePayment request is unknown. 
     * For example, after you send a CreatePayment 
     * request a network error occurs and you don't get a response. In this case, you can direct 
     * Square to cancel the payment using this endpoint. In the request, you provide the same idempotency 
     * key that you provided in your CreatePayment request you want  to cancel. After cancelling the 
     * payment, you can submit your CreatePayment request again. 
     * Note that if no payment with the specified idempotency key is found, no action is taken, the end 
     * point returns successfully.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CancelPaymentByIdempotencyKeyResponse response from the API call 
     */
    public CompletableFuture<CancelPaymentByIdempotencyKeyResponse> cancelPaymentByIdempotencyKeyAsync(
            final CancelPaymentByIdempotencyKeyRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCancelPaymentByIdempotencyKeyRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCancelPaymentByIdempotencyKeyResponse(_context));
    }

    /**
     * Builds the HttpRequest object for cancelPaymentByIdempotencyKey
     */
    private HttpRequest _buildCancelPaymentByIdempotencyKeyRequest(
            final CancelPaymentByIdempotencyKeyRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/payments/cancel");
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
     * Processes the response for cancelPaymentByIdempotencyKey
     * @return An object of type CancelPaymentByIdempotencyKeyResponse
     */
    private CancelPaymentByIdempotencyKeyResponse _handleCancelPaymentByIdempotencyKeyResponse(HttpContext _context)
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
        CancelPaymentByIdempotencyKeyResponse _result = ApiHelper.deserialize(_responseBody,
                CancelPaymentByIdempotencyKeyResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Retrieves details for a specific Payment.
     * @param    paymentId    Required parameter: Unique ID for the desired `Payment`.
     * @return    Returns the GetPaymentResponse response from the API call
     */
    public GetPaymentResponse getPayment(
            final String paymentId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildGetPaymentRequest(paymentId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetPaymentResponse(_context);
    }

    /**
     * Retrieves details for a specific Payment.
     * @param    paymentId    Required parameter: Unique ID for the desired `Payment`.
     * @return    Returns the GetPaymentResponse response from the API call 
     */
    public CompletableFuture<GetPaymentResponse> getPaymentAsync(
            final String paymentId
    ) {
        return makeHttpCallAsync(() -> _buildGetPaymentRequest(paymentId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleGetPaymentResponse(_context));
    }

    /**
     * Builds the HttpRequest object for getPayment
     */
    private HttpRequest _buildGetPaymentRequest(
            final String paymentId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/payments/{payment_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
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
     * Processes the response for getPayment
     * @return An object of type GetPaymentResponse
     */
    private GetPaymentResponse _handleGetPaymentResponse(HttpContext _context)
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
        GetPaymentResponse _result = ApiHelper.deserialize(_responseBody,
                GetPaymentResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Cancels (voids) a payment. If you set `autocomplete` to false when creating a payment, 
     * you can cancel the payment using this endpoint. For more information, see 
     * [Delayed Payments](https://developer.squareup.com/docs/payments-api/take-payments#delayed-payments).
     * @param    paymentId    Required parameter: `payment_id` identifying the payment to be canceled.
     * @return    Returns the CancelPaymentResponse response from the API call
     */
    public CancelPaymentResponse cancelPayment(
            final String paymentId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCancelPaymentRequest(paymentId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCancelPaymentResponse(_context);
    }

    /**
     * Cancels (voids) a payment. If you set `autocomplete` to false when creating a payment, 
     * you can cancel the payment using this endpoint. For more information, see 
     * [Delayed Payments](https://developer.squareup.com/docs/payments-api/take-payments#delayed-payments).
     * @param    paymentId    Required parameter: `payment_id` identifying the payment to be canceled.
     * @return    Returns the CancelPaymentResponse response from the API call 
     */
    public CompletableFuture<CancelPaymentResponse> cancelPaymentAsync(
            final String paymentId
    ) {
        return makeHttpCallAsync(() -> _buildCancelPaymentRequest(paymentId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCancelPaymentResponse(_context));
    }

    /**
     * Builds the HttpRequest object for cancelPayment
     */
    private HttpRequest _buildCancelPaymentRequest(
            final String paymentId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/payments/{payment_id}/cancel");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
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
        HttpRequest _request = getClientInstance().post(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for cancelPayment
     * @return An object of type CancelPaymentResponse
     */
    private CancelPaymentResponse _handleCancelPaymentResponse(HttpContext _context)
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
        CancelPaymentResponse _result = ApiHelper.deserialize(_responseBody,
                CancelPaymentResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Completes (captures) a payment.
     * By default, payments are set to complete immediately after they are created. 
     * If you set autocomplete to false when creating a payment, you can complete (capture) 
     * the payment using this endpoint. For more information, see
     * [Delayed Payments](https://developer.squareup.com/docs/payments-api/take-payments#delayed-payments).
     * @param    paymentId    Required parameter: Unique ID identifying the payment to be completed.
     * @return    Returns the CompletePaymentResponse response from the API call
     */
    public CompletePaymentResponse completePayment(
            final String paymentId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCompletePaymentRequest(paymentId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCompletePaymentResponse(_context);
    }

    /**
     * Completes (captures) a payment.
     * By default, payments are set to complete immediately after they are created. 
     * If you set autocomplete to false when creating a payment, you can complete (capture) 
     * the payment using this endpoint. For more information, see
     * [Delayed Payments](https://developer.squareup.com/docs/payments-api/take-payments#delayed-payments).
     * @param    paymentId    Required parameter: Unique ID identifying the payment to be completed.
     * @return    Returns the CompletePaymentResponse response from the API call 
     */
    public CompletableFuture<CompletePaymentResponse> completePaymentAsync(
            final String paymentId
    ) {
        return makeHttpCallAsync(() -> _buildCompletePaymentRequest(paymentId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCompletePaymentResponse(_context));
    }

    /**
     * Builds the HttpRequest object for completePayment
     */
    private HttpRequest _buildCompletePaymentRequest(
            final String paymentId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/payments/{payment_id}/complete");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
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
        HttpRequest _request = getClientInstance().post(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for completePayment
     * @return An object of type CompletePaymentResponse
     */
    private CompletePaymentResponse _handleCompletePaymentResponse(HttpContext _context)
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
        CompletePaymentResponse _result = ApiHelper.deserialize(_responseBody,
                CompletePaymentResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
