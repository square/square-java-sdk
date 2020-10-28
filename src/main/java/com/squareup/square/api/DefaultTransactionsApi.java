
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
import com.squareup.square.models.CaptureTransactionResponse;
import com.squareup.square.models.ChargeRequest;
import com.squareup.square.models.ChargeResponse;
import com.squareup.square.models.CreateRefundRequest;
import com.squareup.square.models.CreateRefundResponse;
import com.squareup.square.models.ListRefundsResponse;
import com.squareup.square.models.ListTransactionsResponse;
import com.squareup.square.models.RetrieveTransactionResponse;
import com.squareup.square.models.VoidTransactionResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultTransactionsApi extends BaseApi implements TransactionsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultTransactionsApi(Configuration config, HttpClient httpClient,
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
    public DefaultTransactionsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists refunds for one of a business's locations. In addition to full or partial tender
     * refunds processed through Square APIs, refunds may result from itemized returns or exchanges
     * through Square's Point of Sale applications. Refunds with a `status` of `PENDING` are not
     * currently included in this endpoint's response. Max results per [page](#paginatingresults):
     * 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list refunds for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date ranges](#dateranges) for details on date
     *         inclusivity/exclusivity. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     *         Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListRefundsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public ListRefundsResponse listRefunds(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListRefundsRequest(locationId, beginTime, endTime, sortOrder,
                cursor);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListRefundsResponse(context);
    }

    /**
     * Lists refunds for one of a business's locations. In addition to full or partial tender
     * refunds processed through Square APIs, refunds may result from itemized returns or exchanges
     * through Square's Point of Sale applications. Refunds with a `status` of `PENDING` are not
     * currently included in this endpoint's response. Max results per [page](#paginatingresults):
     * 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list refunds for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date ranges](#dateranges) for details on date
     *         inclusivity/exclusivity. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     *         Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListRefundsResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<ListRefundsResponse> listRefundsAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) {
        return makeHttpCallAsync(() -> buildListRefundsRequest(locationId, beginTime, endTime,
                sortOrder, cursor),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleListRefundsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listRefunds.
     */
    private HttpRequest buildListRefundsRequest(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/locations/{location_id}/refunds");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("sort_order", sortOrder);
        queryParameters.put("cursor", cursor);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for listRefunds.
     * @return An object of type ListRefundsResponse
     */
    private ListRefundsResponse handleListRefundsResponse(
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
        ListRefundsResponse result = ApiHelper.deserialize(responseBody,
                ListRefundsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Lists transactions for a particular location. Transactions include payment information from
     * sales and exchanges and refund information from returns and exchanges. Max results per
     * [page](#paginatingresults): 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list transactions for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date ranges](#dateranges) for details on date
     *         inclusivity/exclusivity. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     *         Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListTransactionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public ListTransactionsResponse listTransactions(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListTransactionsRequest(locationId, beginTime, endTime,
                sortOrder, cursor);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListTransactionsResponse(context);
    }

    /**
     * Lists transactions for a particular location. Transactions include payment information from
     * sales and exchanges and refund information from returns and exchanges. Max results per
     * [page](#paginatingresults): 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list transactions for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date ranges](#dateranges) for details on date
     *         inclusivity/exclusivity. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     *         Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListTransactionsResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<ListTransactionsResponse> listTransactionsAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) {
        return makeHttpCallAsync(() -> buildListTransactionsRequest(locationId, beginTime, endTime,
                sortOrder, cursor),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleListTransactionsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listTransactions.
     */
    private HttpRequest buildListTransactionsRequest(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/locations/{location_id}/transactions");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("sort_order", sortOrder);
        queryParameters.put("cursor", cursor);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for listTransactions.
     * @return An object of type ListTransactionsResponse
     */
    private ListTransactionsResponse handleListTransactionsResponse(
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
        ListTransactionsResponse result = ApiHelper.deserialize(responseBody,
                ListTransactionsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Charges a card represented by a card nonce or a customer's card on file. Your request to this
     * endpoint must include _either_: - A value for the `card_nonce` parameter (to charge a card
     * nonce generated with the `SqPaymentForm`) - Values for the `customer_card_id` and
     * `customer_id` parameters (to charge a customer's card on file) In order for an eCommerce
     * payment to potentially qualify for [Square chargeback
     * protection](https://squareup.com/help/article/5394), you _must_ provide values for the
     * following parameters in your request: - `buyer_email_address` - At least one of
     * `billing_address` or `shipping_address` When this response is returned, the amount of
     * Square's processing fee might not yet be calculated. To obtain the processing fee, wait about
     * ten seconds and call [RetrieveTransaction](#endpoint-retrievetransaction). See the
     * `processing_fee_money` field of each [Tender included](#type-tender) in the transaction.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to associate the created
     *         transaction with.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ChargeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public ChargeResponse charge(
            final String locationId,
            final ChargeRequest body) throws ApiException, IOException {
        HttpRequest request = buildChargeRequest(locationId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleChargeResponse(context);
    }

    /**
     * Charges a card represented by a card nonce or a customer's card on file. Your request to this
     * endpoint must include _either_: - A value for the `card_nonce` parameter (to charge a card
     * nonce generated with the `SqPaymentForm`) - Values for the `customer_card_id` and
     * `customer_id` parameters (to charge a customer's card on file) In order for an eCommerce
     * payment to potentially qualify for [Square chargeback
     * protection](https://squareup.com/help/article/5394), you _must_ provide values for the
     * following parameters in your request: - `buyer_email_address` - At least one of
     * `billing_address` or `shipping_address` When this response is returned, the amount of
     * Square's processing fee might not yet be calculated. To obtain the processing fee, wait about
     * ten seconds and call [RetrieveTransaction](#endpoint-retrievetransaction). See the
     * `processing_fee_money` field of each [Tender included](#type-tender) in the transaction.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to associate the created
     *         transaction with.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ChargeResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<ChargeResponse> chargeAsync(
            final String locationId,
            final ChargeRequest body) {
        return makeHttpCallAsync(() -> buildChargeRequest(locationId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleChargeResponse(context));
    }

    /**
     * Builds the HttpRequest object for charge.
     */
    private HttpRequest buildChargeRequest(
            final String locationId,
            final ChargeRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/locations/{location_id}/transactions");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
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
     * Processes the response for charge.
     * @return An object of type ChargeResponse
     */
    private ChargeResponse handleChargeResponse(
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
        ChargeResponse result = ApiHelper.deserialize(responseBody,
                ChargeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves details for a single transaction.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the transaction's associated location.
     * @param  transactionId  Required parameter: The ID of the transaction to retrieve.
     * @return    Returns the RetrieveTransactionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public RetrieveTransactionResponse retrieveTransaction(
            final String locationId,
            final String transactionId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveTransactionRequest(locationId, transactionId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveTransactionResponse(context);
    }

    /**
     * Retrieves details for a single transaction.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the transaction's associated location.
     * @param  transactionId  Required parameter: The ID of the transaction to retrieve.
     * @return    Returns the RetrieveTransactionResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<RetrieveTransactionResponse> retrieveTransactionAsync(
            final String locationId,
            final String transactionId) {
        return makeHttpCallAsync(() -> buildRetrieveTransactionRequest(locationId, transactionId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleRetrieveTransactionResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveTransaction.
     */
    private HttpRequest buildRetrieveTransactionRequest(
            final String locationId,
            final String transactionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/locations/{location_id}/transactions/{transaction_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        templateParameters.put("transaction_id",
                new SimpleEntry<Object, Boolean>(transactionId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for retrieveTransaction.
     * @return An object of type RetrieveTransactionResponse
     */
    private RetrieveTransactionResponse handleRetrieveTransactionResponse(
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
        RetrieveTransactionResponse result = ApiHelper.deserialize(responseBody,
                RetrieveTransactionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Captures a transaction that was created with the [Charge](#endpoint-charge) endpoint with a
     * `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the CaptureTransactionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public CaptureTransactionResponse captureTransaction(
            final String locationId,
            final String transactionId) throws ApiException, IOException {
        HttpRequest request = buildCaptureTransactionRequest(locationId, transactionId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCaptureTransactionResponse(context);
    }

    /**
     * Captures a transaction that was created with the [Charge](#endpoint-charge) endpoint with a
     * `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the CaptureTransactionResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<CaptureTransactionResponse> captureTransactionAsync(
            final String locationId,
            final String transactionId) {
        return makeHttpCallAsync(() -> buildCaptureTransactionRequest(locationId, transactionId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleCaptureTransactionResponse(context));
    }

    /**
     * Builds the HttpRequest object for captureTransaction.
     */
    private HttpRequest buildCaptureTransactionRequest(
            final String locationId,
            final String transactionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/locations/{location_id}/transactions/{transaction_id}/capture");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        templateParameters.put("transaction_id",
                new SimpleEntry<Object, Boolean>(transactionId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for captureTransaction.
     * @return An object of type CaptureTransactionResponse
     */
    private CaptureTransactionResponse handleCaptureTransactionResponse(
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
        CaptureTransactionResponse result = ApiHelper.deserialize(responseBody,
                CaptureTransactionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Initiates a refund for a previously charged tender. You must issue a refund within 120 days
     * of the associated payment. See [this article](https://squareup.com/help/us/en/article/5060)
     * for more information on refund behavior. NOTE: Card-present transactions with Interac credit
     * cards **cannot be refunded using the Connect API**. Interac transactions must refunded
     * in-person (e.g., dipping the card using POS app).
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the original transaction's associated
     *         location.
     * @param  transactionId  Required parameter: The ID of the original transaction that includes
     *         the tender to refund.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public CreateRefundResponse createRefund(
            final String locationId,
            final String transactionId,
            final CreateRefundRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateRefundRequest(locationId, transactionId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateRefundResponse(context);
    }

    /**
     * Initiates a refund for a previously charged tender. You must issue a refund within 120 days
     * of the associated payment. See [this article](https://squareup.com/help/us/en/article/5060)
     * for more information on refund behavior. NOTE: Card-present transactions with Interac credit
     * cards **cannot be refunded using the Connect API**. Interac transactions must refunded
     * in-person (e.g., dipping the card using POS app).
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the original transaction's associated
     *         location.
     * @param  transactionId  Required parameter: The ID of the original transaction that includes
     *         the tender to refund.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateRefundResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<CreateRefundResponse> createRefundAsync(
            final String locationId,
            final String transactionId,
            final CreateRefundRequest body) {
        return makeHttpCallAsync(() -> buildCreateRefundRequest(locationId, transactionId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleCreateRefundResponse(context));
    }

    /**
     * Builds the HttpRequest object for createRefund.
     */
    private HttpRequest buildCreateRefundRequest(
            final String locationId,
            final String transactionId,
            final CreateRefundRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/locations/{location_id}/transactions/{transaction_id}/refund");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        templateParameters.put("transaction_id",
                new SimpleEntry<Object, Boolean>(transactionId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
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
     * Processes the response for createRefund.
     * @return An object of type CreateRefundResponse
     */
    private CreateRefundResponse handleCreateRefundResponse(
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
        CreateRefundResponse result = ApiHelper.deserialize(responseBody,
                CreateRefundResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels a transaction that was created with the [Charge](#endpoint-charge) endpoint with a
     * `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the VoidTransactionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public VoidTransactionResponse voidTransaction(
            final String locationId,
            final String transactionId) throws ApiException, IOException {
        HttpRequest request = buildVoidTransactionRequest(locationId, transactionId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleVoidTransactionResponse(context);
    }

    /**
     * Cancels a transaction that was created with the [Charge](#endpoint-charge) endpoint with a
     * `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the VoidTransactionResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<VoidTransactionResponse> voidTransactionAsync(
            final String locationId,
            final String transactionId) {
        return makeHttpCallAsync(() -> buildVoidTransactionRequest(locationId, transactionId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleVoidTransactionResponse(context));
    }

    /**
     * Builds the HttpRequest object for voidTransaction.
     */
    private HttpRequest buildVoidTransactionRequest(
            final String locationId,
            final String transactionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/locations/{location_id}/transactions/{transaction_id}/void");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
        templateParameters.put("transaction_id",
                new SimpleEntry<Object, Boolean>(transactionId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for voidTransaction.
     * @return An object of type VoidTransactionResponse
     */
    private VoidTransactionResponse handleVoidTransactionResponse(
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
        VoidTransactionResponse result = ApiHelper.deserialize(responseBody,
                VoidTransactionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}