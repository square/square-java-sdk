
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
import com.squareup.square.models.AccumulateLoyaltyPointsRequest;
import com.squareup.square.models.AccumulateLoyaltyPointsResponse;
import com.squareup.square.models.AdjustLoyaltyPointsRequest;
import com.squareup.square.models.AdjustLoyaltyPointsResponse;
import com.squareup.square.models.CalculateLoyaltyPointsRequest;
import com.squareup.square.models.CalculateLoyaltyPointsResponse;
import com.squareup.square.models.CreateLoyaltyAccountRequest;
import com.squareup.square.models.CreateLoyaltyAccountResponse;
import com.squareup.square.models.CreateLoyaltyRewardRequest;
import com.squareup.square.models.CreateLoyaltyRewardResponse;
import com.squareup.square.models.DeleteLoyaltyRewardResponse;
import com.squareup.square.models.ListLoyaltyProgramsResponse;
import com.squareup.square.models.RedeemLoyaltyRewardRequest;
import com.squareup.square.models.RedeemLoyaltyRewardResponse;
import com.squareup.square.models.RetrieveLoyaltyAccountResponse;
import com.squareup.square.models.RetrieveLoyaltyProgramResponse;
import com.squareup.square.models.RetrieveLoyaltyRewardResponse;
import com.squareup.square.models.SearchLoyaltyAccountsRequest;
import com.squareup.square.models.SearchLoyaltyAccountsResponse;
import com.squareup.square.models.SearchLoyaltyEventsRequest;
import com.squareup.square.models.SearchLoyaltyEventsResponse;
import com.squareup.square.models.SearchLoyaltyRewardsRequest;
import com.squareup.square.models.SearchLoyaltyRewardsResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultLoyaltyApi extends BaseApi implements LoyaltyApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultLoyaltyApi(Configuration config, HttpClient httpClient,
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
    public DefaultLoyaltyApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Creates a loyalty account. To create a loyalty account, you must provide the `program_id` and
     * a `mapping` with the `phone_number` of the buyer.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyAccountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateLoyaltyAccountResponse createLoyaltyAccount(
            final CreateLoyaltyAccountRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateLoyaltyAccountRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateLoyaltyAccountResponse(context);
    }

    /**
     * Creates a loyalty account. To create a loyalty account, you must provide the `program_id` and
     * a `mapping` with the `phone_number` of the buyer.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyAccountResponse response from the API call
     */
    public CompletableFuture<CreateLoyaltyAccountResponse> createLoyaltyAccountAsync(
            final CreateLoyaltyAccountRequest body) {
        return makeHttpCallAsync(() -> buildCreateLoyaltyAccountRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateLoyaltyAccountResponse(context));
    }

    /**
     * Builds the HttpRequest object for createLoyaltyAccount.
     */
    private HttpRequest buildCreateLoyaltyAccountRequest(
            final CreateLoyaltyAccountRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/accounts");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for createLoyaltyAccount.
     * @return An object of type CreateLoyaltyAccountResponse
     */
    private CreateLoyaltyAccountResponse handleCreateLoyaltyAccountResponse(
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
        CreateLoyaltyAccountResponse result = ApiHelper.deserialize(responseBody,
                CreateLoyaltyAccountResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches for loyalty accounts in a loyalty program. You can search for a loyalty account
     * using the phone number or customer ID associated with the account. To return all loyalty
     * accounts, specify an empty `query` object or omit it entirely. Search results are sorted by
     * `created_at` in ascending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyAccountsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchLoyaltyAccountsResponse searchLoyaltyAccounts(
            final SearchLoyaltyAccountsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchLoyaltyAccountsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchLoyaltyAccountsResponse(context);
    }

    /**
     * Searches for loyalty accounts in a loyalty program. You can search for a loyalty account
     * using the phone number or customer ID associated with the account. To return all loyalty
     * accounts, specify an empty `query` object or omit it entirely. Search results are sorted by
     * `created_at` in ascending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyAccountsResponse response from the API call
     */
    public CompletableFuture<SearchLoyaltyAccountsResponse> searchLoyaltyAccountsAsync(
            final SearchLoyaltyAccountsRequest body) {
        return makeHttpCallAsync(() -> buildSearchLoyaltyAccountsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchLoyaltyAccountsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchLoyaltyAccounts.
     */
    private HttpRequest buildSearchLoyaltyAccountsRequest(
            final SearchLoyaltyAccountsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/accounts/search");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for searchLoyaltyAccounts.
     * @return An object of type SearchLoyaltyAccountsResponse
     */
    private SearchLoyaltyAccountsResponse handleSearchLoyaltyAccountsResponse(
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
        SearchLoyaltyAccountsResponse result = ApiHelper.deserialize(responseBody,
                SearchLoyaltyAccountsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a loyalty account.
     * @param  accountId  Required parameter: The ID of the [loyalty account]($m/LoyaltyAccount) to
     *         retrieve.
     * @return    Returns the RetrieveLoyaltyAccountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveLoyaltyAccountResponse retrieveLoyaltyAccount(
            final String accountId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveLoyaltyAccountRequest(accountId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveLoyaltyAccountResponse(context);
    }

    /**
     * Retrieves a loyalty account.
     * @param  accountId  Required parameter: The ID of the [loyalty account]($m/LoyaltyAccount) to
     *         retrieve.
     * @return    Returns the RetrieveLoyaltyAccountResponse response from the API call
     */
    public CompletableFuture<RetrieveLoyaltyAccountResponse> retrieveLoyaltyAccountAsync(
            final String accountId) {
        return makeHttpCallAsync(() -> buildRetrieveLoyaltyAccountRequest(accountId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveLoyaltyAccountResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveLoyaltyAccount.
     */
    private HttpRequest buildRetrieveLoyaltyAccountRequest(
            final String accountId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/accounts/{account_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("account_id",
                new SimpleEntry<Object, Boolean>(accountId, true));
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
     * Processes the response for retrieveLoyaltyAccount.
     * @return An object of type RetrieveLoyaltyAccountResponse
     */
    private RetrieveLoyaltyAccountResponse handleRetrieveLoyaltyAccountResponse(
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
        RetrieveLoyaltyAccountResponse result = ApiHelper.deserialize(responseBody,
                RetrieveLoyaltyAccountResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Adds points to a loyalty account. - If you are using the Orders API to manage orders, you
     * only provide the `order_id`. The endpoint reads the order to compute points to add to the
     * buyer's account. - If you are not using the Orders API to manage orders, you first perform a
     * client-side computation to compute the points. For spend-based and visit-based programs, you
     * can first call [CalculateLoyaltyPoints]($e/Loyalty/CalculateLoyaltyPoints) to compute the
     * points that you provide to this endpoint. __Note:__ The country of the seller's Square
     * account determines whether tax is included in the purchase amount when accruing points for
     * spend-based and visit-based programs. For more information, see [Availability of Square
     * Loyalty](https://developer.squareup.com/docs/loyalty-api/overview#loyalty-market-availability).
     * @param  accountId  Required parameter: The [loyalty account]($m/LoyaltyAccount) ID to which
     *         to add the points.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AccumulateLoyaltyPointsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public AccumulateLoyaltyPointsResponse accumulateLoyaltyPoints(
            final String accountId,
            final AccumulateLoyaltyPointsRequest body) throws ApiException, IOException {
        HttpRequest request = buildAccumulateLoyaltyPointsRequest(accountId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleAccumulateLoyaltyPointsResponse(context);
    }

    /**
     * Adds points to a loyalty account. - If you are using the Orders API to manage orders, you
     * only provide the `order_id`. The endpoint reads the order to compute points to add to the
     * buyer's account. - If you are not using the Orders API to manage orders, you first perform a
     * client-side computation to compute the points. For spend-based and visit-based programs, you
     * can first call [CalculateLoyaltyPoints]($e/Loyalty/CalculateLoyaltyPoints) to compute the
     * points that you provide to this endpoint. __Note:__ The country of the seller's Square
     * account determines whether tax is included in the purchase amount when accruing points for
     * spend-based and visit-based programs. For more information, see [Availability of Square
     * Loyalty](https://developer.squareup.com/docs/loyalty-api/overview#loyalty-market-availability).
     * @param  accountId  Required parameter: The [loyalty account]($m/LoyaltyAccount) ID to which
     *         to add the points.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AccumulateLoyaltyPointsResponse response from the API call
     */
    public CompletableFuture<AccumulateLoyaltyPointsResponse> accumulateLoyaltyPointsAsync(
            final String accountId,
            final AccumulateLoyaltyPointsRequest body) {
        return makeHttpCallAsync(() -> buildAccumulateLoyaltyPointsRequest(accountId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleAccumulateLoyaltyPointsResponse(context));
    }

    /**
     * Builds the HttpRequest object for accumulateLoyaltyPoints.
     */
    private HttpRequest buildAccumulateLoyaltyPointsRequest(
            final String accountId,
            final AccumulateLoyaltyPointsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/accounts/{account_id}/accumulate");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("account_id",
                new SimpleEntry<Object, Boolean>(accountId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for accumulateLoyaltyPoints.
     * @return An object of type AccumulateLoyaltyPointsResponse
     */
    private AccumulateLoyaltyPointsResponse handleAccumulateLoyaltyPointsResponse(
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
        AccumulateLoyaltyPointsResponse result = ApiHelper.deserialize(responseBody,
                AccumulateLoyaltyPointsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Adds points to or subtracts points from a buyer's account. Use this endpoint only when you
     * need to manually adjust points. Otherwise, in your application flow, you call
     * [AccumulateLoyaltyPoints]($e/Loyalty/AccumulateLoyaltyPoints) to add points when a buyer pays
     * for the purchase.
     * @param  accountId  Required parameter: The ID of the [loyalty account]($m/LoyaltyAccount) in
     *         which to adjust the points.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AdjustLoyaltyPointsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public AdjustLoyaltyPointsResponse adjustLoyaltyPoints(
            final String accountId,
            final AdjustLoyaltyPointsRequest body) throws ApiException, IOException {
        HttpRequest request = buildAdjustLoyaltyPointsRequest(accountId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleAdjustLoyaltyPointsResponse(context);
    }

    /**
     * Adds points to or subtracts points from a buyer's account. Use this endpoint only when you
     * need to manually adjust points. Otherwise, in your application flow, you call
     * [AccumulateLoyaltyPoints]($e/Loyalty/AccumulateLoyaltyPoints) to add points when a buyer pays
     * for the purchase.
     * @param  accountId  Required parameter: The ID of the [loyalty account]($m/LoyaltyAccount) in
     *         which to adjust the points.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AdjustLoyaltyPointsResponse response from the API call
     */
    public CompletableFuture<AdjustLoyaltyPointsResponse> adjustLoyaltyPointsAsync(
            final String accountId,
            final AdjustLoyaltyPointsRequest body) {
        return makeHttpCallAsync(() -> buildAdjustLoyaltyPointsRequest(accountId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleAdjustLoyaltyPointsResponse(context));
    }

    /**
     * Builds the HttpRequest object for adjustLoyaltyPoints.
     */
    private HttpRequest buildAdjustLoyaltyPointsRequest(
            final String accountId,
            final AdjustLoyaltyPointsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/accounts/{account_id}/adjust");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("account_id",
                new SimpleEntry<Object, Boolean>(accountId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for adjustLoyaltyPoints.
     * @return An object of type AdjustLoyaltyPointsResponse
     */
    private AdjustLoyaltyPointsResponse handleAdjustLoyaltyPointsResponse(
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
        AdjustLoyaltyPointsResponse result = ApiHelper.deserialize(responseBody,
                AdjustLoyaltyPointsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches for loyalty events. A Square loyalty program maintains a ledger of events that occur
     * during the lifetime of a buyer's loyalty account. Each change in the point balance (for
     * example, points earned, points redeemed, and points expired) is recorded in the ledger. Using
     * this endpoint, you can search the ledger for events. Search results are sorted by
     * `created_at` in descending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchLoyaltyEventsResponse searchLoyaltyEvents(
            final SearchLoyaltyEventsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchLoyaltyEventsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchLoyaltyEventsResponse(context);
    }

    /**
     * Searches for loyalty events. A Square loyalty program maintains a ledger of events that occur
     * during the lifetime of a buyer's loyalty account. Each change in the point balance (for
     * example, points earned, points redeemed, and points expired) is recorded in the ledger. Using
     * this endpoint, you can search the ledger for events. Search results are sorted by
     * `created_at` in descending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyEventsResponse response from the API call
     */
    public CompletableFuture<SearchLoyaltyEventsResponse> searchLoyaltyEventsAsync(
            final SearchLoyaltyEventsRequest body) {
        return makeHttpCallAsync(() -> buildSearchLoyaltyEventsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchLoyaltyEventsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchLoyaltyEvents.
     */
    private HttpRequest buildSearchLoyaltyEventsRequest(
            final SearchLoyaltyEventsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/events/search");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for searchLoyaltyEvents.
     * @return An object of type SearchLoyaltyEventsResponse
     */
    private SearchLoyaltyEventsResponse handleSearchLoyaltyEventsResponse(
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
        SearchLoyaltyEventsResponse result = ApiHelper.deserialize(responseBody,
                SearchLoyaltyEventsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a list of loyalty programs in the seller's account. Loyalty programs define how
     * buyers can earn points and redeem points for rewards. Square sellers can have only one
     * loyalty program, which is created and managed from the Seller Dashboard. For more
     * information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview). Replaced with
     * [RetrieveLoyaltyProgram]($e/Loyalty/RetrieveLoyaltyProgram) when used with the keyword
     * `main`.
     * @deprecated
     * 
     * @return    Returns the ListLoyaltyProgramsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public ListLoyaltyProgramsResponse listLoyaltyPrograms() throws ApiException, IOException {
        HttpRequest request = buildListLoyaltyProgramsRequest();
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListLoyaltyProgramsResponse(context);
    }

    /**
     * Returns a list of loyalty programs in the seller's account. Loyalty programs define how
     * buyers can earn points and redeem points for rewards. Square sellers can have only one
     * loyalty program, which is created and managed from the Seller Dashboard. For more
     * information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview). Replaced with
     * [RetrieveLoyaltyProgram]($e/Loyalty/RetrieveLoyaltyProgram) when used with the keyword
     * `main`.
     * @deprecated
     * 
     * @return    Returns the ListLoyaltyProgramsResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<ListLoyaltyProgramsResponse> listLoyaltyProgramsAsync() {
        return makeHttpCallAsync(() -> buildListLoyaltyProgramsRequest(),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListLoyaltyProgramsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listLoyaltyPrograms.
     */
    private HttpRequest buildListLoyaltyProgramsRequest() {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/programs");

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
     * Processes the response for listLoyaltyPrograms.
     * @return An object of type ListLoyaltyProgramsResponse
     */
    private ListLoyaltyProgramsResponse handleListLoyaltyProgramsResponse(
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
        ListLoyaltyProgramsResponse result = ApiHelper.deserialize(responseBody,
                ListLoyaltyProgramsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves the loyalty program in a seller's account, specified by the program ID or the
     * keyword `main`. Loyalty programs define how buyers can earn points and redeem points for
     * rewards. Square sellers can have only one loyalty program, which is created and managed from
     * the Seller Dashboard. For more information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview).
     * @param  programId  Required parameter: The ID of the loyalty program or the keyword `main`.
     *         Either value can be used to retrieve the single loyalty program that belongs to the
     *         seller.
     * @return    Returns the RetrieveLoyaltyProgramResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveLoyaltyProgramResponse retrieveLoyaltyProgram(
            final String programId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveLoyaltyProgramRequest(programId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveLoyaltyProgramResponse(context);
    }

    /**
     * Retrieves the loyalty program in a seller's account, specified by the program ID or the
     * keyword `main`. Loyalty programs define how buyers can earn points and redeem points for
     * rewards. Square sellers can have only one loyalty program, which is created and managed from
     * the Seller Dashboard. For more information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview).
     * @param  programId  Required parameter: The ID of the loyalty program or the keyword `main`.
     *         Either value can be used to retrieve the single loyalty program that belongs to the
     *         seller.
     * @return    Returns the RetrieveLoyaltyProgramResponse response from the API call
     */
    public CompletableFuture<RetrieveLoyaltyProgramResponse> retrieveLoyaltyProgramAsync(
            final String programId) {
        return makeHttpCallAsync(() -> buildRetrieveLoyaltyProgramRequest(programId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveLoyaltyProgramResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveLoyaltyProgram.
     */
    private HttpRequest buildRetrieveLoyaltyProgramRequest(
            final String programId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/programs/{program_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("program_id",
                new SimpleEntry<Object, Boolean>(programId, true));
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
     * Processes the response for retrieveLoyaltyProgram.
     * @return An object of type RetrieveLoyaltyProgramResponse
     */
    private RetrieveLoyaltyProgramResponse handleRetrieveLoyaltyProgramResponse(
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
        RetrieveLoyaltyProgramResponse result = ApiHelper.deserialize(responseBody,
                RetrieveLoyaltyProgramResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Calculates the points a purchase earns. - If you are using the Orders API to manage orders,
     * you provide `order_id` in the request. The endpoint calculates the points by reading the
     * order. - If you are not using the Orders API to manage orders, you provide the purchase
     * amount in the request for the endpoint to calculate the points. An application might call
     * this endpoint to show the points that a buyer can earn with the specific purchase. __Note:__
     * The country of the seller's Square account determines whether tax is included in the purchase
     * amount when accruing points for spend-based and visit-based programs. For more information,
     * see [Availability of Square
     * Loyalty](https://developer.squareup.com/docs/loyalty-api/overview#loyalty-market-availability).
     * @param  programId  Required parameter: The [loyalty program]($m/LoyaltyProgram) ID, which
     *         defines the rules for accruing points.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateLoyaltyPointsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CalculateLoyaltyPointsResponse calculateLoyaltyPoints(
            final String programId,
            final CalculateLoyaltyPointsRequest body) throws ApiException, IOException {
        HttpRequest request = buildCalculateLoyaltyPointsRequest(programId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCalculateLoyaltyPointsResponse(context);
    }

    /**
     * Calculates the points a purchase earns. - If you are using the Orders API to manage orders,
     * you provide `order_id` in the request. The endpoint calculates the points by reading the
     * order. - If you are not using the Orders API to manage orders, you provide the purchase
     * amount in the request for the endpoint to calculate the points. An application might call
     * this endpoint to show the points that a buyer can earn with the specific purchase. __Note:__
     * The country of the seller's Square account determines whether tax is included in the purchase
     * amount when accruing points for spend-based and visit-based programs. For more information,
     * see [Availability of Square
     * Loyalty](https://developer.squareup.com/docs/loyalty-api/overview#loyalty-market-availability).
     * @param  programId  Required parameter: The [loyalty program]($m/LoyaltyProgram) ID, which
     *         defines the rules for accruing points.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateLoyaltyPointsResponse response from the API call
     */
    public CompletableFuture<CalculateLoyaltyPointsResponse> calculateLoyaltyPointsAsync(
            final String programId,
            final CalculateLoyaltyPointsRequest body) {
        return makeHttpCallAsync(() -> buildCalculateLoyaltyPointsRequest(programId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCalculateLoyaltyPointsResponse(context));
    }

    /**
     * Builds the HttpRequest object for calculateLoyaltyPoints.
     */
    private HttpRequest buildCalculateLoyaltyPointsRequest(
            final String programId,
            final CalculateLoyaltyPointsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/programs/{program_id}/calculate");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("program_id",
                new SimpleEntry<Object, Boolean>(programId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for calculateLoyaltyPoints.
     * @return An object of type CalculateLoyaltyPointsResponse
     */
    private CalculateLoyaltyPointsResponse handleCalculateLoyaltyPointsResponse(
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
        CalculateLoyaltyPointsResponse result = ApiHelper.deserialize(responseBody,
                CalculateLoyaltyPointsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a loyalty reward. In the process, the endpoint does following: - Uses the
     * `reward_tier_id` in the request to determine the number of points to lock for this reward. -
     * If the request includes `order_id`, it adds the reward and related discount to the order.
     * After a reward is created, the points are locked and not available for the buyer to redeem
     * another reward.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateLoyaltyRewardResponse createLoyaltyReward(
            final CreateLoyaltyRewardRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateLoyaltyRewardRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateLoyaltyRewardResponse(context);
    }

    /**
     * Creates a loyalty reward. In the process, the endpoint does following: - Uses the
     * `reward_tier_id` in the request to determine the number of points to lock for this reward. -
     * If the request includes `order_id`, it adds the reward and related discount to the order.
     * After a reward is created, the points are locked and not available for the buyer to redeem
     * another reward.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyRewardResponse response from the API call
     */
    public CompletableFuture<CreateLoyaltyRewardResponse> createLoyaltyRewardAsync(
            final CreateLoyaltyRewardRequest body) {
        return makeHttpCallAsync(() -> buildCreateLoyaltyRewardRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateLoyaltyRewardResponse(context));
    }

    /**
     * Builds the HttpRequest object for createLoyaltyReward.
     */
    private HttpRequest buildCreateLoyaltyRewardRequest(
            final CreateLoyaltyRewardRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/rewards");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for createLoyaltyReward.
     * @return An object of type CreateLoyaltyRewardResponse
     */
    private CreateLoyaltyRewardResponse handleCreateLoyaltyRewardResponse(
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
        CreateLoyaltyRewardResponse result = ApiHelper.deserialize(responseBody,
                CreateLoyaltyRewardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches for loyalty rewards in a loyalty account. In the current implementation, the
     * endpoint supports search by the reward `status`. If you know a reward ID, use the
     * [RetrieveLoyaltyReward]($e/Loyalty/RetrieveLoyaltyReward) endpoint. Search results are sorted
     * by `updated_at` in descending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyRewardsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchLoyaltyRewardsResponse searchLoyaltyRewards(
            final SearchLoyaltyRewardsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchLoyaltyRewardsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchLoyaltyRewardsResponse(context);
    }

    /**
     * Searches for loyalty rewards in a loyalty account. In the current implementation, the
     * endpoint supports search by the reward `status`. If you know a reward ID, use the
     * [RetrieveLoyaltyReward]($e/Loyalty/RetrieveLoyaltyReward) endpoint. Search results are sorted
     * by `updated_at` in descending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyRewardsResponse response from the API call
     */
    public CompletableFuture<SearchLoyaltyRewardsResponse> searchLoyaltyRewardsAsync(
            final SearchLoyaltyRewardsRequest body) {
        return makeHttpCallAsync(() -> buildSearchLoyaltyRewardsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchLoyaltyRewardsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchLoyaltyRewards.
     */
    private HttpRequest buildSearchLoyaltyRewardsRequest(
            final SearchLoyaltyRewardsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/rewards/search");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for searchLoyaltyRewards.
     * @return An object of type SearchLoyaltyRewardsResponse
     */
    private SearchLoyaltyRewardsResponse handleSearchLoyaltyRewardsResponse(
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
        SearchLoyaltyRewardsResponse result = ApiHelper.deserialize(responseBody,
                SearchLoyaltyRewardsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a loyalty reward by doing the following: - Returns the loyalty points back to the
     * loyalty account. - If an order ID was specified when the reward was created (see
     * [CreateLoyaltyReward]($e/Loyalty/CreateLoyaltyReward)), it updates the order by removing the
     * reward and related discounts. You cannot delete a reward that has reached the terminal state
     * (REDEEMED).
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         delete.
     * @return    Returns the DeleteLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteLoyaltyRewardResponse deleteLoyaltyReward(
            final String rewardId) throws ApiException, IOException {
        HttpRequest request = buildDeleteLoyaltyRewardRequest(rewardId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteLoyaltyRewardResponse(context);
    }

    /**
     * Deletes a loyalty reward by doing the following: - Returns the loyalty points back to the
     * loyalty account. - If an order ID was specified when the reward was created (see
     * [CreateLoyaltyReward]($e/Loyalty/CreateLoyaltyReward)), it updates the order by removing the
     * reward and related discounts. You cannot delete a reward that has reached the terminal state
     * (REDEEMED).
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         delete.
     * @return    Returns the DeleteLoyaltyRewardResponse response from the API call
     */
    public CompletableFuture<DeleteLoyaltyRewardResponse> deleteLoyaltyRewardAsync(
            final String rewardId) {
        return makeHttpCallAsync(() -> buildDeleteLoyaltyRewardRequest(rewardId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteLoyaltyRewardResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteLoyaltyReward.
     */
    private HttpRequest buildDeleteLoyaltyRewardRequest(
            final String rewardId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/rewards/{reward_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("reward_id",
                new SimpleEntry<Object, Boolean>(rewardId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteLoyaltyReward.
     * @return An object of type DeleteLoyaltyRewardResponse
     */
    private DeleteLoyaltyRewardResponse handleDeleteLoyaltyRewardResponse(
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
        DeleteLoyaltyRewardResponse result = ApiHelper.deserialize(responseBody,
                DeleteLoyaltyRewardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a loyalty reward.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         retrieve.
     * @return    Returns the RetrieveLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveLoyaltyRewardResponse retrieveLoyaltyReward(
            final String rewardId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveLoyaltyRewardRequest(rewardId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveLoyaltyRewardResponse(context);
    }

    /**
     * Retrieves a loyalty reward.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         retrieve.
     * @return    Returns the RetrieveLoyaltyRewardResponse response from the API call
     */
    public CompletableFuture<RetrieveLoyaltyRewardResponse> retrieveLoyaltyRewardAsync(
            final String rewardId) {
        return makeHttpCallAsync(() -> buildRetrieveLoyaltyRewardRequest(rewardId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveLoyaltyRewardResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveLoyaltyReward.
     */
    private HttpRequest buildRetrieveLoyaltyRewardRequest(
            final String rewardId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/rewards/{reward_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("reward_id",
                new SimpleEntry<Object, Boolean>(rewardId, true));
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
     * Processes the response for retrieveLoyaltyReward.
     * @return An object of type RetrieveLoyaltyRewardResponse
     */
    private RetrieveLoyaltyRewardResponse handleRetrieveLoyaltyRewardResponse(
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
        RetrieveLoyaltyRewardResponse result = ApiHelper.deserialize(responseBody,
                RetrieveLoyaltyRewardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Redeems a loyalty reward. The endpoint sets the reward to the `REDEEMED` terminal state. If
     * you are using your own order processing system (not using the Orders API), you call this
     * endpoint after the buyer paid for the purchase. After the reward reaches the terminal state,
     * it cannot be deleted. In other words, points used for the reward cannot be returned to the
     * account.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         redeem.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RedeemLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RedeemLoyaltyRewardResponse redeemLoyaltyReward(
            final String rewardId,
            final RedeemLoyaltyRewardRequest body) throws ApiException, IOException {
        HttpRequest request = buildRedeemLoyaltyRewardRequest(rewardId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRedeemLoyaltyRewardResponse(context);
    }

    /**
     * Redeems a loyalty reward. The endpoint sets the reward to the `REDEEMED` terminal state. If
     * you are using your own order processing system (not using the Orders API), you call this
     * endpoint after the buyer paid for the purchase. After the reward reaches the terminal state,
     * it cannot be deleted. In other words, points used for the reward cannot be returned to the
     * account.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         redeem.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RedeemLoyaltyRewardResponse response from the API call
     */
    public CompletableFuture<RedeemLoyaltyRewardResponse> redeemLoyaltyRewardAsync(
            final String rewardId,
            final RedeemLoyaltyRewardRequest body) {
        return makeHttpCallAsync(() -> buildRedeemLoyaltyRewardRequest(rewardId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRedeemLoyaltyRewardResponse(context));
    }

    /**
     * Builds the HttpRequest object for redeemLoyaltyReward.
     */
    private HttpRequest buildRedeemLoyaltyRewardRequest(
            final String rewardId,
            final RedeemLoyaltyRewardRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/loyalty/rewards/{reward_id}/redeem");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("reward_id",
                new SimpleEntry<Object, Boolean>(rewardId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for redeemLoyaltyReward.
     * @return An object of type RedeemLoyaltyRewardResponse
     */
    private RedeemLoyaltyRewardResponse handleRedeemLoyaltyRewardResponse(
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
        RedeemLoyaltyRewardResponse result = ApiHelper.deserialize(responseBody,
                RedeemLoyaltyRewardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}