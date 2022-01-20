
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
import com.squareup.square.models.CancelPaymentByIdempotencyKeyRequest;
import com.squareup.square.models.CancelPaymentByIdempotencyKeyResponse;
import com.squareup.square.models.CancelPaymentResponse;
import com.squareup.square.models.CompletePaymentRequest;
import com.squareup.square.models.CompletePaymentResponse;
import com.squareup.square.models.CreatePaymentRequest;
import com.squareup.square.models.CreatePaymentResponse;
import com.squareup.square.models.GetPaymentResponse;
import com.squareup.square.models.ListPaymentsResponse;
import com.squareup.square.models.UpdatePaymentRequest;
import com.squareup.square.models.UpdatePaymentResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultPaymentsApi extends BaseApi implements PaymentsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultPaymentsApi(Configuration config, HttpClient httpClient,
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
    public DefaultPaymentsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Retrieves a list of payments taken by the account making the request. Results are eventually
     * consistent, and new payments or changes to payments might take several seconds to appear. The
     * maximum results per page is 100.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the reporting
     *         period, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the reporting period, in
     *         RFC 3339 format. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed: - `ASC` -
     *         Oldest to newest. - `DESC` - Newest to oldest (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  locationId  Optional parameter: Limit results to the location supplied. By default,
     *         results are returned for the default (main) location associated with the seller.
     * @param  total  Optional parameter: The exact amount in the `total_money` for a payment.
     * @param  last4  Optional parameter: The last four digits of a payment card.
     * @param  cardBrand  Optional parameter: The brand of the payment card (for example, VISA).
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPaymentsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListPaymentsResponse listPayments(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand,
            final Integer limit) throws ApiException, IOException {
        HttpRequest request = buildListPaymentsRequest(beginTime, endTime, sortOrder, cursor,
                locationId, total, last4, cardBrand, limit);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListPaymentsResponse(context);
    }

    /**
     * Retrieves a list of payments taken by the account making the request. Results are eventually
     * consistent, and new payments or changes to payments might take several seconds to appear. The
     * maximum results per page is 100.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the reporting
     *         period, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the reporting period, in
     *         RFC 3339 format. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed: - `ASC` -
     *         Oldest to newest. - `DESC` - Newest to oldest (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  locationId  Optional parameter: Limit results to the location supplied. By default,
     *         results are returned for the default (main) location associated with the seller.
     * @param  total  Optional parameter: The exact amount in the `total_money` for a payment.
     * @param  last4  Optional parameter: The last four digits of a payment card.
     * @param  cardBrand  Optional parameter: The brand of the payment card (for example, VISA).
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
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
            final String cardBrand,
            final Integer limit) {
        return makeHttpCallAsync(() -> buildListPaymentsRequest(beginTime, endTime, sortOrder,
                cursor, locationId, total, last4, cardBrand, limit),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListPaymentsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listPayments.
     */
    private HttpRequest buildListPaymentsRequest(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand,
            final Integer limit) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/payments");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("sort_order", sortOrder);
        queryParameters.put("cursor", cursor);
        queryParameters.put("location_id", locationId);
        queryParameters.put("total", total);
        queryParameters.put("last_4", last4);
        queryParameters.put("card_brand", cardBrand);
        queryParameters.put("limit", limit);

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
     * Processes the response for listPayments.
     * @return An object of type ListPaymentsResponse
     */
    private ListPaymentsResponse handleListPaymentsResponse(
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
        ListPaymentsResponse result = ApiHelper.deserialize(responseBody,
                ListPaymentsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a payment using the provided source. You can use this endpoint to charge a card
     * (credit/debit card or Square gift card) or record a payment that the seller received outside
     * of Square (cash payment from a buyer or a payment that an external entity processed on behalf
     * of the seller). The endpoint creates a `Payment` object and returns it in the response.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreatePaymentResponse createPayment(
            final CreatePaymentRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreatePaymentRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreatePaymentResponse(context);
    }

    /**
     * Creates a payment using the provided source. You can use this endpoint to charge a card
     * (credit/debit card or Square gift card) or record a payment that the seller received outside
     * of Square (cash payment from a buyer or a payment that an external entity processed on behalf
     * of the seller). The endpoint creates a `Payment` object and returns it in the response.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentResponse response from the API call
     */
    public CompletableFuture<CreatePaymentResponse> createPaymentAsync(
            final CreatePaymentRequest body) {
        return makeHttpCallAsync(() -> buildCreatePaymentRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreatePaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for createPayment.
     */
    private HttpRequest buildCreatePaymentRequest(
            final CreatePaymentRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/payments");

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
     * Processes the response for createPayment.
     * @return An object of type CreatePaymentResponse
     */
    private CreatePaymentResponse handleCreatePaymentResponse(
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
        CreatePaymentResponse result = ApiHelper.deserialize(responseBody,
                CreatePaymentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels (voids) a payment identified by the idempotency key that is specified in the request.
     * Use this method when the status of a `CreatePayment` request is unknown (for example, after
     * you send a `CreatePayment` request, a network error occurs and you do not get a response). In
     * this case, you can direct Square to cancel the payment using this endpoint. In the request,
     * you provide the same idempotency key that you provided in your `CreatePayment` request that
     * you want to cancel. After canceling the payment, you can submit your `CreatePayment` request
     * again. Note that if no payment with the specified idempotency key is found, no action is
     * taken and the endpoint returns successfully.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelPaymentByIdempotencyKeyResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelPaymentByIdempotencyKeyResponse cancelPaymentByIdempotencyKey(
            final CancelPaymentByIdempotencyKeyRequest body) throws ApiException, IOException {
        HttpRequest request = buildCancelPaymentByIdempotencyKeyRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCancelPaymentByIdempotencyKeyResponse(context);
    }

    /**
     * Cancels (voids) a payment identified by the idempotency key that is specified in the request.
     * Use this method when the status of a `CreatePayment` request is unknown (for example, after
     * you send a `CreatePayment` request, a network error occurs and you do not get a response). In
     * this case, you can direct Square to cancel the payment using this endpoint. In the request,
     * you provide the same idempotency key that you provided in your `CreatePayment` request that
     * you want to cancel. After canceling the payment, you can submit your `CreatePayment` request
     * again. Note that if no payment with the specified idempotency key is found, no action is
     * taken and the endpoint returns successfully.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelPaymentByIdempotencyKeyResponse response from the API call
     */
    public CompletableFuture<CancelPaymentByIdempotencyKeyResponse> cancelPaymentByIdempotencyKeyAsync(
            final CancelPaymentByIdempotencyKeyRequest body) {
        return makeHttpCallAsync(() -> buildCancelPaymentByIdempotencyKeyRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCancelPaymentByIdempotencyKeyResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelPaymentByIdempotencyKey.
     */
    private HttpRequest buildCancelPaymentByIdempotencyKeyRequest(
            final CancelPaymentByIdempotencyKeyRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/payments/cancel");

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
     * Processes the response for cancelPaymentByIdempotencyKey.
     * @return An object of type CancelPaymentByIdempotencyKeyResponse
     */
    private CancelPaymentByIdempotencyKeyResponse handleCancelPaymentByIdempotencyKeyResponse(
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
        CancelPaymentByIdempotencyKeyResponse result = ApiHelper.deserialize(responseBody,
                CancelPaymentByIdempotencyKeyResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves details for a specific payment.
     * @param  paymentId  Required parameter: A unique ID for the desired payment.
     * @return    Returns the GetPaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetPaymentResponse getPayment(
            final String paymentId) throws ApiException, IOException {
        HttpRequest request = buildGetPaymentRequest(paymentId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleGetPaymentResponse(context);
    }

    /**
     * Retrieves details for a specific payment.
     * @param  paymentId  Required parameter: A unique ID for the desired payment.
     * @return    Returns the GetPaymentResponse response from the API call
     */
    public CompletableFuture<GetPaymentResponse> getPaymentAsync(
            final String paymentId) {
        return makeHttpCallAsync(() -> buildGetPaymentRequest(paymentId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleGetPaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for getPayment.
     */
    private HttpRequest buildGetPaymentRequest(
            final String paymentId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/payments/{payment_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
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
     * Processes the response for getPayment.
     * @return An object of type GetPaymentResponse
     */
    private GetPaymentResponse handleGetPaymentResponse(
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
        GetPaymentResponse result = ApiHelper.deserialize(responseBody,
                GetPaymentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a payment with the APPROVED status. You can update the `amount_money` and `tip_money`
     * using this endpoint.
     * @param  paymentId  Required parameter: The ID of the payment to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdatePaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdatePaymentResponse updatePayment(
            final String paymentId,
            final UpdatePaymentRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdatePaymentRequest(paymentId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdatePaymentResponse(context);
    }

    /**
     * Updates a payment with the APPROVED status. You can update the `amount_money` and `tip_money`
     * using this endpoint.
     * @param  paymentId  Required parameter: The ID of the payment to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdatePaymentResponse response from the API call
     */
    public CompletableFuture<UpdatePaymentResponse> updatePaymentAsync(
            final String paymentId,
            final UpdatePaymentRequest body) {
        return makeHttpCallAsync(() -> buildUpdatePaymentRequest(paymentId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdatePaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for updatePayment.
     */
    private HttpRequest buildUpdatePaymentRequest(
            final String paymentId,
            final UpdatePaymentRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/payments/{payment_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("payment_id",
                new SimpleEntry<Object, Boolean>(paymentId, true));
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
     * Processes the response for updatePayment.
     * @return An object of type UpdatePaymentResponse
     */
    private UpdatePaymentResponse handleUpdatePaymentResponse(
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
        UpdatePaymentResponse result = ApiHelper.deserialize(responseBody,
                UpdatePaymentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels (voids) a payment. You can use this endpoint to cancel a payment with the APPROVED
     * `status`.
     * @param  paymentId  Required parameter: The ID of the payment to cancel.
     * @return    Returns the CancelPaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelPaymentResponse cancelPayment(
            final String paymentId) throws ApiException, IOException {
        HttpRequest request = buildCancelPaymentRequest(paymentId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCancelPaymentResponse(context);
    }

    /**
     * Cancels (voids) a payment. You can use this endpoint to cancel a payment with the APPROVED
     * `status`.
     * @param  paymentId  Required parameter: The ID of the payment to cancel.
     * @return    Returns the CancelPaymentResponse response from the API call
     */
    public CompletableFuture<CancelPaymentResponse> cancelPaymentAsync(
            final String paymentId) {
        return makeHttpCallAsync(() -> buildCancelPaymentRequest(paymentId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCancelPaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelPayment.
     */
    private HttpRequest buildCancelPaymentRequest(
            final String paymentId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/payments/{payment_id}/cancel");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
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
        HttpRequest request = getClientInstance().post(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for cancelPayment.
     * @return An object of type CancelPaymentResponse
     */
    private CancelPaymentResponse handleCancelPaymentResponse(
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
        CancelPaymentResponse result = ApiHelper.deserialize(responseBody,
                CancelPaymentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Completes (captures) a payment. By default, payments are set to complete immediately after
     * they are created. You can use this endpoint to complete a payment with the APPROVED `status`.
     * @param  paymentId  Required parameter: The unique ID identifying the payment to be completed.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CompletePaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CompletePaymentResponse completePayment(
            final String paymentId,
            final CompletePaymentRequest body) throws ApiException, IOException {
        HttpRequest request = buildCompletePaymentRequest(paymentId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCompletePaymentResponse(context);
    }

    /**
     * Completes (captures) a payment. By default, payments are set to complete immediately after
     * they are created. You can use this endpoint to complete a payment with the APPROVED `status`.
     * @param  paymentId  Required parameter: The unique ID identifying the payment to be completed.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CompletePaymentResponse response from the API call
     */
    public CompletableFuture<CompletePaymentResponse> completePaymentAsync(
            final String paymentId,
            final CompletePaymentRequest body) {
        return makeHttpCallAsync(() -> buildCompletePaymentRequest(paymentId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCompletePaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for completePayment.
     */
    private HttpRequest buildCompletePaymentRequest(
            final String paymentId,
            final CompletePaymentRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/payments/{payment_id}/complete");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("payment_id",
                new SimpleEntry<Object, Boolean>(paymentId, true));
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
     * Processes the response for completePayment.
     * @return An object of type CompletePaymentResponse
     */
    private CompletePaymentResponse handleCompletePaymentResponse(
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
        CompletePaymentResponse result = ApiHelper.deserialize(responseBody,
                CompletePaymentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}