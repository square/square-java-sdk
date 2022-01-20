
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
import com.squareup.square.models.GetPaymentRefundResponse;
import com.squareup.square.models.ListPaymentRefundsResponse;
import com.squareup.square.models.RefundPaymentRequest;
import com.squareup.square.models.RefundPaymentResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultRefundsApi extends BaseApi implements RefundsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultRefundsApi(Configuration config, HttpClient httpClient,
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
    public DefaultRefundsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Retrieves a list of refunds for the account making the request. Results are eventually
     * consistent, and new refunds or changes to refunds might take several seconds to appear. The
     * maximum results per page is 100.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the requested
     *         reporting period, in RFC 3339 format. Default: The current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the requested reporting
     *         period, in RFC 3339 format. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed: - `ASC` -
     *         Oldest to newest. - `DESC` - Newest to oldest (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  locationId  Optional parameter: Limit results to the location supplied. By default,
     *         results are returned for all locations associated with the seller.
     * @param  status  Optional parameter: If provided, only refunds with the given status are
     *         returned. For a list of refund status values, see [PaymentRefund]($m/PaymentRefund).
     *         Default: If omitted, refunds are returned regardless of their status.
     * @param  sourceType  Optional parameter: If provided, only returns refunds whose payments have
     *         the indicated source type. Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`,
     *         `CASH`, and `EXTERNAL`. For information about these payment source types, see [Take
     *         Payments](https://developer.squareup.com/docs/payments-api/take-payments). Default:
     *         If omitted, refunds are returned regardless of the source type.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. If the supplied value is greater than 100, no more than 100 results are
     *         returned. Default: 100
     * @return    Returns the ListPaymentRefundsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListPaymentRefundsResponse listPaymentRefunds(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType,
            final Integer limit) throws ApiException, IOException {
        HttpRequest request = buildListPaymentRefundsRequest(beginTime, endTime, sortOrder, cursor,
                locationId, status, sourceType, limit);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListPaymentRefundsResponse(context);
    }

    /**
     * Retrieves a list of refunds for the account making the request. Results are eventually
     * consistent, and new refunds or changes to refunds might take several seconds to appear. The
     * maximum results per page is 100.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the requested
     *         reporting period, in RFC 3339 format. Default: The current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the requested reporting
     *         period, in RFC 3339 format. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed: - `ASC` -
     *         Oldest to newest. - `DESC` - Newest to oldest (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  locationId  Optional parameter: Limit results to the location supplied. By default,
     *         results are returned for all locations associated with the seller.
     * @param  status  Optional parameter: If provided, only refunds with the given status are
     *         returned. For a list of refund status values, see [PaymentRefund]($m/PaymentRefund).
     *         Default: If omitted, refunds are returned regardless of their status.
     * @param  sourceType  Optional parameter: If provided, only returns refunds whose payments have
     *         the indicated source type. Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`,
     *         `CASH`, and `EXTERNAL`. For information about these payment source types, see [Take
     *         Payments](https://developer.squareup.com/docs/payments-api/take-payments). Default:
     *         If omitted, refunds are returned regardless of the source type.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. If the supplied value is greater than 100, no more than 100 results are
     *         returned. Default: 100
     * @return    Returns the ListPaymentRefundsResponse response from the API call
     */
    public CompletableFuture<ListPaymentRefundsResponse> listPaymentRefundsAsync(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType,
            final Integer limit) {
        return makeHttpCallAsync(() -> buildListPaymentRefundsRequest(beginTime, endTime, sortOrder,
                cursor, locationId, status, sourceType, limit),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListPaymentRefundsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listPaymentRefunds.
     */
    private HttpRequest buildListPaymentRefundsRequest(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType,
            final Integer limit) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/refunds");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("sort_order", sortOrder);
        queryParameters.put("cursor", cursor);
        queryParameters.put("location_id", locationId);
        queryParameters.put("status", status);
        queryParameters.put("source_type", sourceType);
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
     * Processes the response for listPaymentRefunds.
     * @return An object of type ListPaymentRefundsResponse
     */
    private ListPaymentRefundsResponse handleListPaymentRefundsResponse(
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
        ListPaymentRefundsResponse result = ApiHelper.deserialize(responseBody,
                ListPaymentRefundsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Refunds a payment. You can refund the entire payment amount or a portion of it. You can use
     * this endpoint to refund a card payment or record a refund of a cash or external payment. For
     * more information, see [Refund
     * Payment](https://developer.squareup.com/docs/payments-api/refund-payments).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RefundPaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RefundPaymentResponse refundPayment(
            final RefundPaymentRequest body) throws ApiException, IOException {
        HttpRequest request = buildRefundPaymentRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRefundPaymentResponse(context);
    }

    /**
     * Refunds a payment. You can refund the entire payment amount or a portion of it. You can use
     * this endpoint to refund a card payment or record a refund of a cash or external payment. For
     * more information, see [Refund
     * Payment](https://developer.squareup.com/docs/payments-api/refund-payments).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RefundPaymentResponse response from the API call
     */
    public CompletableFuture<RefundPaymentResponse> refundPaymentAsync(
            final RefundPaymentRequest body) {
        return makeHttpCallAsync(() -> buildRefundPaymentRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRefundPaymentResponse(context));
    }

    /**
     * Builds the HttpRequest object for refundPayment.
     */
    private HttpRequest buildRefundPaymentRequest(
            final RefundPaymentRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/refunds");

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
     * Processes the response for refundPayment.
     * @return An object of type RefundPaymentResponse
     */
    private RefundPaymentResponse handleRefundPaymentResponse(
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
        RefundPaymentResponse result = ApiHelper.deserialize(responseBody,
                RefundPaymentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a specific refund using the `refund_id`.
     * @param  refundId  Required parameter: The unique ID for the desired `PaymentRefund`.
     * @return    Returns the GetPaymentRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetPaymentRefundResponse getPaymentRefund(
            final String refundId) throws ApiException, IOException {
        HttpRequest request = buildGetPaymentRefundRequest(refundId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleGetPaymentRefundResponse(context);
    }

    /**
     * Retrieves a specific refund using the `refund_id`.
     * @param  refundId  Required parameter: The unique ID for the desired `PaymentRefund`.
     * @return    Returns the GetPaymentRefundResponse response from the API call
     */
    public CompletableFuture<GetPaymentRefundResponse> getPaymentRefundAsync(
            final String refundId) {
        return makeHttpCallAsync(() -> buildGetPaymentRefundRequest(refundId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleGetPaymentRefundResponse(context));
    }

    /**
     * Builds the HttpRequest object for getPaymentRefund.
     */
    private HttpRequest buildGetPaymentRefundRequest(
            final String refundId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/refunds/{refund_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("refund_id",
                new SimpleEntry<Object, Boolean>(refundId, true));
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
     * Processes the response for getPaymentRefund.
     * @return An object of type GetPaymentRefundResponse
     */
    private GetPaymentRefundResponse handleGetPaymentRefundResponse(
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
        GetPaymentRefundResponse result = ApiHelper.deserialize(responseBody,
                GetPaymentRefundResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}