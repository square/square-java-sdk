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

public final class RefundsApi extends BaseApi {
    public RefundsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public RefundsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Retrieves a list of refunds for the account making the request.
     * Max results per page: 100
     * @param    beginTime    Optional parameter: Timestamp for the beginning of the requested reporting period, in RFC 3339 format.  Default: The current time minus one year.
     * @param    endTime    Optional parameter: Timestamp for the end of the requested reporting period, in RFC 3339 format.  Default: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed. - `ASC` - oldest to newest - `DESC` - newest to oldest (default).
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    locationId    Optional parameter: ID of location associated with payment.
     * @param    status    Optional parameter: If provided, only refunds with the given status are returned. For a list of refund status values, see [PaymentRefund](#type-paymentrefund).  Default: If omitted refunds are returned regardless of status.
     * @param    sourceType    Optional parameter: If provided, only refunds with the given source type are returned. - `CARD` - List refunds only for payments where card was specified as payment source.  Default: If omitted refunds are returned regardless of source type.
     * @return    Returns the ListPaymentRefundsResponse response from the API call
     */
    public ListPaymentRefundsResponse listPaymentRefunds(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListPaymentRefundsRequest(beginTime, endTime, sortOrder, cursor, locationId, status, sourceType);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListPaymentRefundsResponse(_context);
    }

    /**
     * Retrieves a list of refunds for the account making the request.
     * Max results per page: 100
     * @param    beginTime    Optional parameter: Timestamp for the beginning of the requested reporting period, in RFC 3339 format.  Default: The current time minus one year.
     * @param    endTime    Optional parameter: Timestamp for the end of the requested reporting period, in RFC 3339 format.  Default: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed. - `ASC` - oldest to newest - `DESC` - newest to oldest (default).
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    locationId    Optional parameter: ID of location associated with payment.
     * @param    status    Optional parameter: If provided, only refunds with the given status are returned. For a list of refund status values, see [PaymentRefund](#type-paymentrefund).  Default: If omitted refunds are returned regardless of status.
     * @param    sourceType    Optional parameter: If provided, only refunds with the given source type are returned. - `CARD` - List refunds only for payments where card was specified as payment source.  Default: If omitted refunds are returned regardless of source type.
     * @return    Returns the ListPaymentRefundsResponse response from the API call 
     */
    public CompletableFuture<ListPaymentRefundsResponse> listPaymentRefundsAsync(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType
    ) {
        return makeHttpCallAsync(() -> _buildListPaymentRefundsRequest(beginTime, endTime, sortOrder, cursor, locationId, status, sourceType),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListPaymentRefundsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listPaymentRefunds
     */
    private HttpRequest _buildListPaymentRefundsRequest(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/refunds");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
        _queryParameters.put("sort_order", sortOrder);
        _queryParameters.put("cursor", cursor);
        _queryParameters.put("location_id", locationId);
        _queryParameters.put("status", status);
        _queryParameters.put("source_type", sourceType);
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
     * Processes the response for listPaymentRefunds
     * @return An object of type ListPaymentRefundsResponse
     */
    private ListPaymentRefundsResponse _handleListPaymentRefundsResponse(HttpContext _context)
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
        ListPaymentRefundsResponse _result = ApiHelper.deserialize(_responseBody,
                ListPaymentRefundsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Refunds a payment. You can refund the entire payment amount or a 
     * portion of it. For more information, see 
     * [Payments and Refunds Overview](https://developer.squareup.com/docs/payments-api/overview).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the RefundPaymentResponse response from the API call
     */
    public RefundPaymentResponse refundPayment(
            final RefundPaymentRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRefundPaymentRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRefundPaymentResponse(_context);
    }

    /**
     * Refunds a payment. You can refund the entire payment amount or a 
     * portion of it. For more information, see 
     * [Payments and Refunds Overview](https://developer.squareup.com/docs/payments-api/overview).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the RefundPaymentResponse response from the API call 
     */
    public CompletableFuture<RefundPaymentResponse> refundPaymentAsync(
            final RefundPaymentRequest body
    ) {
        return makeHttpCallAsync(() -> _buildRefundPaymentRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRefundPaymentResponse(_context));
    }

    /**
     * Builds the HttpRequest object for refundPayment
     */
    private HttpRequest _buildRefundPaymentRequest(
            final RefundPaymentRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/refunds");
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
     * Processes the response for refundPayment
     * @return An object of type RefundPaymentResponse
     */
    private RefundPaymentResponse _handleRefundPaymentResponse(HttpContext _context)
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
        RefundPaymentResponse _result = ApiHelper.deserialize(_responseBody,
                RefundPaymentResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Retrieves a specific `Refund` using the `refund_id`.
     * @param    refundId    Required parameter: Unique ID for the desired `PaymentRefund`.
     * @return    Returns the GetPaymentRefundResponse response from the API call
     */
    public GetPaymentRefundResponse getPaymentRefund(
            final String refundId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildGetPaymentRefundRequest(refundId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetPaymentRefundResponse(_context);
    }

    /**
     * Retrieves a specific `Refund` using the `refund_id`.
     * @param    refundId    Required parameter: Unique ID for the desired `PaymentRefund`.
     * @return    Returns the GetPaymentRefundResponse response from the API call 
     */
    public CompletableFuture<GetPaymentRefundResponse> getPaymentRefundAsync(
            final String refundId
    ) {
        return makeHttpCallAsync(() -> _buildGetPaymentRefundRequest(refundId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleGetPaymentRefundResponse(_context));
    }

    /**
     * Builds the HttpRequest object for getPaymentRefund
     */
    private HttpRequest _buildGetPaymentRefundRequest(
            final String refundId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/refunds/{refund_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("refund_id", refundId);
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
     * Processes the response for getPaymentRefund
     * @return An object of type GetPaymentRefundResponse
     */
    private GetPaymentRefundResponse _handleGetPaymentRefundResponse(HttpContext _context)
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
        GetPaymentRefundResponse _result = ApiHelper.deserialize(_responseBody,
                GetPaymentRefundResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
