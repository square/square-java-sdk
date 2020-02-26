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
import com.squareup.square.models.CancelPaymentByIdempotencyKeyRequest;
import com.squareup.square.models.CancelPaymentByIdempotencyKeyResponse;
import com.squareup.square.models.CancelPaymentResponse;
import com.squareup.square.models.CompletePaymentResponse;
import com.squareup.square.models.CreatePaymentRequest;
import com.squareup.square.models.CreatePaymentResponse;
import com.squareup.square.models.GetPaymentResponse;
import com.squareup.square.models.ListPaymentsResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class PaymentsApi extends BaseApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public PaymentsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
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
     * @param    locationId    Optional parameter: Limit results to the location supplied. By default, results are returned for all locations associated with the merchant.
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
            final String cardBrand) throws ApiException, IOException {
        HttpRequest request = buildListPaymentsRequest(beginTime, endTime, sortOrder, cursor, locationId, total, last4, cardBrand);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListPaymentsResponse(context);
    }

    /**
     * Retrieves a list of payments taken by the account making the request.
     * Max results per page: 100
     * @param    beginTime    Optional parameter: Timestamp for the beginning of the reporting period, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param    endTime    Optional parameter: Timestamp for the end of the requested reporting period, in RFC 3339 format.  Default: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed. - `ASC` - oldest to newest - `DESC` - newest to oldest (default).
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    locationId    Optional parameter: Limit results to the location supplied. By default, results are returned for all locations associated with the merchant.
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
            final String cardBrand) {
        return makeHttpCallAsync(() -> buildListPaymentsRequest(beginTime, endTime, sortOrder, cursor, locationId, total, last4, cardBrand),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListPaymentsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listPayments
     */
    private HttpRequest buildListPaymentsRequest(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/payments");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("sort_order", sortOrder);
        queryParameters.put("cursor", cursor);
        queryParameters.put("location_id", locationId);
        queryParameters.put("total", total);
        queryParameters.put("last_4", last4);
        queryParameters.put("card_brand", cardBrand);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-02-26");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listPayments
     * @return An object of type ListPaymentsResponse
     */
    private ListPaymentsResponse handleListPaymentsResponse(HttpContext context)
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
        ListPaymentsResponse result = ApiHelper.deserialize(responseBody,
                ListPaymentsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
            final CreatePaymentRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreatePaymentRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreatePaymentResponse(context);
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
            final CreatePaymentRequest body) {
        return makeHttpCallAsync(() -> buildCreatePaymentRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreatePaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for createPayment
     */
    private HttpRequest buildCreatePaymentRequest(
            final CreatePaymentRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/payments");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-02-26");
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
     * Processes the response for createPayment
     * @return An object of type CreatePaymentResponse
     */
    private CreatePaymentResponse handleCreatePaymentResponse(HttpContext context)
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
        CreatePaymentResponse result = ApiHelper.deserialize(responseBody,
                CreatePaymentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels (voids) a payment identified by the idempotency key that is specified in the
     * request.
     * Use this method when status of a CreatePayment request is unknown. For example, after you send a
     * CreatePayment request a network error occurs and you don't get a response. In this case, you can
     * direct Square to cancel the payment using this endpoint. In the request, you provide the same
     * idempotency key that you provided in your CreatePayment request you want  to cancel. After
     * cancelling the payment, you can submit your CreatePayment request again.
     * Note that if no payment with the specified idempotency key is found, no action is taken, the end
     * point returns successfully.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CancelPaymentByIdempotencyKeyResponse response from the API call
     */
    public CancelPaymentByIdempotencyKeyResponse cancelPaymentByIdempotencyKey(
            final CancelPaymentByIdempotencyKeyRequest body) throws ApiException, IOException {
        HttpRequest request = buildCancelPaymentByIdempotencyKeyRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCancelPaymentByIdempotencyKeyResponse(context);
    }

    /**
     * Cancels (voids) a payment identified by the idempotency key that is specified in the
     * request.
     * Use this method when status of a CreatePayment request is unknown. For example, after you send a
     * CreatePayment request a network error occurs and you don't get a response. In this case, you can
     * direct Square to cancel the payment using this endpoint. In the request, you provide the same
     * idempotency key that you provided in your CreatePayment request you want  to cancel. After
     * cancelling the payment, you can submit your CreatePayment request again.
     * Note that if no payment with the specified idempotency key is found, no action is taken, the end
     * point returns successfully.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CancelPaymentByIdempotencyKeyResponse response from the API call 
     */
    public CompletableFuture<CancelPaymentByIdempotencyKeyResponse> cancelPaymentByIdempotencyKeyAsync(
            final CancelPaymentByIdempotencyKeyRequest body) {
        return makeHttpCallAsync(() -> buildCancelPaymentByIdempotencyKeyRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCancelPaymentByIdempotencyKeyResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelPaymentByIdempotencyKey
     */
    private HttpRequest buildCancelPaymentByIdempotencyKeyRequest(
            final CancelPaymentByIdempotencyKeyRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/payments/cancel");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-02-26");
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
     * Processes the response for cancelPaymentByIdempotencyKey
     * @return An object of type CancelPaymentByIdempotencyKeyResponse
     */
    private CancelPaymentByIdempotencyKeyResponse handleCancelPaymentByIdempotencyKeyResponse(HttpContext context)
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
        CancelPaymentByIdempotencyKeyResponse result = ApiHelper.deserialize(responseBody,
                CancelPaymentByIdempotencyKeyResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves details for a specific Payment.
     * @param    paymentId    Required parameter: Unique ID for the desired `Payment`.
     * @return    Returns the GetPaymentResponse response from the API call
     */
    public GetPaymentResponse getPayment(
            final String paymentId) throws ApiException, IOException {
        HttpRequest request = buildGetPaymentRequest(paymentId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleGetPaymentResponse(context);
    }

    /**
     * Retrieves details for a specific Payment.
     * @param    paymentId    Required parameter: Unique ID for the desired `Payment`.
     * @return    Returns the GetPaymentResponse response from the API call 
     */
    public CompletableFuture<GetPaymentResponse> getPaymentAsync(
            final String paymentId) {
        return makeHttpCallAsync(() -> buildGetPaymentRequest(paymentId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleGetPaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for getPayment
     */
    private HttpRequest buildGetPaymentRequest(
            final String paymentId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/payments/{payment_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("payment_id", paymentId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-02-26");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for getPayment
     * @return An object of type GetPaymentResponse
     */
    private GetPaymentResponse handleGetPaymentResponse(HttpContext context)
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
        GetPaymentResponse result = ApiHelper.deserialize(responseBody,
                GetPaymentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels (voids) a payment. If you set `autocomplete` to false when creating a payment, 
     * you can cancel the payment using this endpoint. For more information, see 
     * [Delayed Payments](https://developer.squareup.com/docs/payments-api/take-payments#delayed-payments).
     * @param    paymentId    Required parameter: `payment_id` identifying the payment to be canceled.
     * @return    Returns the CancelPaymentResponse response from the API call
     */
    public CancelPaymentResponse cancelPayment(
            final String paymentId) throws ApiException, IOException {
        HttpRequest request = buildCancelPaymentRequest(paymentId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCancelPaymentResponse(context);
    }

    /**
     * Cancels (voids) a payment. If you set `autocomplete` to false when creating a payment, 
     * you can cancel the payment using this endpoint. For more information, see 
     * [Delayed Payments](https://developer.squareup.com/docs/payments-api/take-payments#delayed-payments).
     * @param    paymentId    Required parameter: `payment_id` identifying the payment to be canceled.
     * @return    Returns the CancelPaymentResponse response from the API call 
     */
    public CompletableFuture<CancelPaymentResponse> cancelPaymentAsync(
            final String paymentId) {
        return makeHttpCallAsync(() -> buildCancelPaymentRequest(paymentId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCancelPaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelPayment
     */
    private HttpRequest buildCancelPaymentRequest(
            final String paymentId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/payments/{payment_id}/cancel");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("payment_id", paymentId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-02-26");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().post(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for cancelPayment
     * @return An object of type CancelPaymentResponse
     */
    private CancelPaymentResponse handleCancelPaymentResponse(HttpContext context)
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
        CancelPaymentResponse result = ApiHelper.deserialize(responseBody,
                CancelPaymentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
            final String paymentId) throws ApiException, IOException {
        HttpRequest request = buildCompletePaymentRequest(paymentId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCompletePaymentResponse(context);
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
            final String paymentId) {
        return makeHttpCallAsync(() -> buildCompletePaymentRequest(paymentId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCompletePaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for completePayment
     */
    private HttpRequest buildCompletePaymentRequest(
            final String paymentId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/payments/{payment_id}/complete");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("payment_id", paymentId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-02-26");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().post(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for completePayment
     * @return An object of type CompletePaymentResponse
     */
    private CompletePaymentResponse handleCompletePaymentResponse(HttpContext context)
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
        CompletePaymentResponse result = ApiHelper.deserialize(responseBody,
                CompletePaymentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}
