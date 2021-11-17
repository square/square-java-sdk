
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
import com.squareup.square.models.CancelSubscriptionResponse;
import com.squareup.square.models.CreateSubscriptionRequest;
import com.squareup.square.models.CreateSubscriptionResponse;
import com.squareup.square.models.DeleteSubscriptionActionResponse;
import com.squareup.square.models.ListSubscriptionEventsResponse;
import com.squareup.square.models.PauseSubscriptionRequest;
import com.squareup.square.models.PauseSubscriptionResponse;
import com.squareup.square.models.ResumeSubscriptionRequest;
import com.squareup.square.models.ResumeSubscriptionResponse;
import com.squareup.square.models.RetrieveSubscriptionResponse;
import com.squareup.square.models.SearchSubscriptionsRequest;
import com.squareup.square.models.SearchSubscriptionsResponse;
import com.squareup.square.models.SwapPlanRequest;
import com.squareup.square.models.SwapPlanResponse;
import com.squareup.square.models.UpdateSubscriptionRequest;
import com.squareup.square.models.UpdateSubscriptionResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultSubscriptionsApi extends BaseApi implements SubscriptionsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultSubscriptionsApi(Configuration config, HttpClient httpClient,
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
    public DefaultSubscriptionsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Creates a subscription to a subscription plan by a customer. If you provide a card on file in
     * the request, Square charges the card for the subscription. Otherwise, Square bills an invoice
     * to the customer's email address. The subscription starts immediately, unless the request
     * includes the optional `start_date`. Each individual subscription is associated with a
     * particular location.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateSubscriptionResponse createSubscription(
            final CreateSubscriptionRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateSubscriptionRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateSubscriptionResponse(context);
    }

    /**
     * Creates a subscription to a subscription plan by a customer. If you provide a card on file in
     * the request, Square charges the card for the subscription. Otherwise, Square bills an invoice
     * to the customer's email address. The subscription starts immediately, unless the request
     * includes the optional `start_date`. Each individual subscription is associated with a
     * particular location.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateSubscriptionResponse response from the API call
     */
    public CompletableFuture<CreateSubscriptionResponse> createSubscriptionAsync(
            final CreateSubscriptionRequest body) {
        return makeHttpCallAsync(() -> buildCreateSubscriptionRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for createSubscription.
     */
    private HttpRequest buildCreateSubscriptionRequest(
            final CreateSubscriptionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/subscriptions");

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
     * Processes the response for createSubscription.
     * @return An object of type CreateSubscriptionResponse
     */
    private CreateSubscriptionResponse handleCreateSubscriptionResponse(
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
        CreateSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                CreateSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches for subscriptions. Results are ordered chronologically by subscription creation
     * date. If the request specifies more than one location ID, the endpoint orders the result by
     * location ID, and then by creation date within each location. If no locations are given in the
     * query, all locations are searched. You can also optionally specify `customer_ids` to search
     * by customer. If left unset, all customers associated with the specified locations are
     * returned. If the request specifies customer IDs, the endpoint orders results first by
     * location, within location by customer ID, and within customer by subscription creation date.
     * For more information, see [Retrieve
     * subscriptions](https://developer.squareup.com/docs/subscriptions-api/overview#retrieve-subscriptions).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchSubscriptionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchSubscriptionsResponse searchSubscriptions(
            final SearchSubscriptionsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchSubscriptionsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchSubscriptionsResponse(context);
    }

    /**
     * Searches for subscriptions. Results are ordered chronologically by subscription creation
     * date. If the request specifies more than one location ID, the endpoint orders the result by
     * location ID, and then by creation date within each location. If no locations are given in the
     * query, all locations are searched. You can also optionally specify `customer_ids` to search
     * by customer. If left unset, all customers associated with the specified locations are
     * returned. If the request specifies customer IDs, the endpoint orders results first by
     * location, within location by customer ID, and within customer by subscription creation date.
     * For more information, see [Retrieve
     * subscriptions](https://developer.squareup.com/docs/subscriptions-api/overview#retrieve-subscriptions).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchSubscriptionsResponse response from the API call
     */
    public CompletableFuture<SearchSubscriptionsResponse> searchSubscriptionsAsync(
            final SearchSubscriptionsRequest body) {
        return makeHttpCallAsync(() -> buildSearchSubscriptionsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchSubscriptionsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchSubscriptions.
     */
    private HttpRequest buildSearchSubscriptionsRequest(
            final SearchSubscriptionsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/subscriptions/search");

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
     * Processes the response for searchSubscriptions.
     * @return An object of type SearchSubscriptionsResponse
     */
    private SearchSubscriptionsResponse handleSearchSubscriptionsResponse(
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
        SearchSubscriptionsResponse result = ApiHelper.deserialize(responseBody,
                SearchSubscriptionsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve.
     * @param  include  Optional parameter: A query parameter to specify related information to be
     *         included in the response. The supported query parameter values are: - `actions`: to
     *         include scheduled actions on the targeted subscription.
     * @return    Returns the RetrieveSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveSubscriptionResponse retrieveSubscription(
            final String subscriptionId,
            final String include) throws ApiException, IOException {
        HttpRequest request = buildRetrieveSubscriptionRequest(subscriptionId, include);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveSubscriptionResponse(context);
    }

    /**
     * Retrieves a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve.
     * @param  include  Optional parameter: A query parameter to specify related information to be
     *         included in the response. The supported query parameter values are: - `actions`: to
     *         include scheduled actions on the targeted subscription.
     * @return    Returns the RetrieveSubscriptionResponse response from the API call
     */
    public CompletableFuture<RetrieveSubscriptionResponse> retrieveSubscriptionAsync(
            final String subscriptionId,
            final String include) {
        return makeHttpCallAsync(() -> buildRetrieveSubscriptionRequest(subscriptionId, include),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveSubscription.
     */
    private HttpRequest buildRetrieveSubscriptionRequest(
            final String subscriptionId,
            final String include) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/subscriptions/{subscription_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("include", include);

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
     * Processes the response for retrieveSubscription.
     * @return An object of type RetrieveSubscriptionResponse
     */
    private RetrieveSubscriptionResponse handleRetrieveSubscriptionResponse(
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
        RetrieveSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                RetrieveSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a subscription. You can set, modify, and clear the `subscription` field values.
     * @param  subscriptionId  Required parameter: The ID of the subscription to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateSubscriptionResponse updateSubscription(
            final String subscriptionId,
            final UpdateSubscriptionRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateSubscriptionRequest(subscriptionId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateSubscriptionResponse(context);
    }

    /**
     * Updates a subscription. You can set, modify, and clear the `subscription` field values.
     * @param  subscriptionId  Required parameter: The ID of the subscription to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateSubscriptionResponse response from the API call
     */
    public CompletableFuture<UpdateSubscriptionResponse> updateSubscriptionAsync(
            final String subscriptionId,
            final UpdateSubscriptionRequest body) {
        return makeHttpCallAsync(() -> buildUpdateSubscriptionRequest(subscriptionId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateSubscription.
     */
    private HttpRequest buildUpdateSubscriptionRequest(
            final String subscriptionId,
            final UpdateSubscriptionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/subscriptions/{subscription_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
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
        HttpRequest request = getClientInstance().putBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateSubscription.
     * @return An object of type UpdateSubscriptionResponse
     */
    private UpdateSubscriptionResponse handleUpdateSubscriptionResponse(
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
        UpdateSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                UpdateSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a scheduled action for a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription the targeted action is
     *         to act upon.
     * @param  actionId  Required parameter: The ID of the targeted action to be deleted.
     * @return    Returns the DeleteSubscriptionActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteSubscriptionActionResponse deleteSubscriptionAction(
            final String subscriptionId,
            final String actionId) throws ApiException, IOException {
        HttpRequest request = buildDeleteSubscriptionActionRequest(subscriptionId, actionId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteSubscriptionActionResponse(context);
    }

    /**
     * Deletes a scheduled action for a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription the targeted action is
     *         to act upon.
     * @param  actionId  Required parameter: The ID of the targeted action to be deleted.
     * @return    Returns the DeleteSubscriptionActionResponse response from the API call
     */
    public CompletableFuture<DeleteSubscriptionActionResponse> deleteSubscriptionActionAsync(
            final String subscriptionId,
            final String actionId) {
        return makeHttpCallAsync(() -> buildDeleteSubscriptionActionRequest(subscriptionId,
                actionId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteSubscriptionActionResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteSubscriptionAction.
     */
    private HttpRequest buildDeleteSubscriptionActionRequest(
            final String subscriptionId,
            final String actionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/subscriptions/{subscription_id}/actions/{action_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
        templateParameters.put("action_id",
                new SimpleEntry<Object, Boolean>(actionId, true));
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
     * Processes the response for deleteSubscriptionAction.
     * @return An object of type DeleteSubscriptionActionResponse
     */
    private DeleteSubscriptionActionResponse handleDeleteSubscriptionActionResponse(
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
        DeleteSubscriptionActionResponse result = ApiHelper.deserialize(responseBody,
                DeleteSubscriptionActionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Schedules a `CANCEL` action to cancel an active subscription by setting the `canceled_date`
     * field to the end of the active billing period and changing the subscription status from
     * ACTIVE to CANCELED after this date.
     * @param  subscriptionId  Required parameter: The ID of the subscription to cancel.
     * @return    Returns the CancelSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelSubscriptionResponse cancelSubscription(
            final String subscriptionId) throws ApiException, IOException {
        HttpRequest request = buildCancelSubscriptionRequest(subscriptionId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCancelSubscriptionResponse(context);
    }

    /**
     * Schedules a `CANCEL` action to cancel an active subscription by setting the `canceled_date`
     * field to the end of the active billing period and changing the subscription status from
     * ACTIVE to CANCELED after this date.
     * @param  subscriptionId  Required parameter: The ID of the subscription to cancel.
     * @return    Returns the CancelSubscriptionResponse response from the API call
     */
    public CompletableFuture<CancelSubscriptionResponse> cancelSubscriptionAsync(
            final String subscriptionId) {
        return makeHttpCallAsync(() -> buildCancelSubscriptionRequest(subscriptionId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCancelSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelSubscription.
     */
    private HttpRequest buildCancelSubscriptionRequest(
            final String subscriptionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/subscriptions/{subscription_id}/cancel");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
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
     * Processes the response for cancelSubscription.
     * @return An object of type CancelSubscriptionResponse
     */
    private CancelSubscriptionResponse handleCancelSubscriptionResponse(
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
        CancelSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                CancelSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Lists all events for a specific subscription. In the current implementation, only
     * `START_SUBSCRIPTION` and `STOP_SUBSCRIPTION` (when the subscription was canceled) events are
     * returned.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve the events
     *         for.
     * @param  cursor  Optional parameter: When the total number of resulting subscription events
     *         exceeds the limit of a paged response, specify the cursor returned from a preceding
     *         response here to fetch the next set of results. If the cursor is unset, the response
     *         contains the last page of the results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The upper limit on the number of subscription events to
     *         return in a paged response.
     * @return    Returns the ListSubscriptionEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListSubscriptionEventsResponse listSubscriptionEvents(
            final String subscriptionId,
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        HttpRequest request = buildListSubscriptionEventsRequest(subscriptionId, cursor, limit);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListSubscriptionEventsResponse(context);
    }

    /**
     * Lists all events for a specific subscription. In the current implementation, only
     * `START_SUBSCRIPTION` and `STOP_SUBSCRIPTION` (when the subscription was canceled) events are
     * returned.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve the events
     *         for.
     * @param  cursor  Optional parameter: When the total number of resulting subscription events
     *         exceeds the limit of a paged response, specify the cursor returned from a preceding
     *         response here to fetch the next set of results. If the cursor is unset, the response
     *         contains the last page of the results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The upper limit on the number of subscription events to
     *         return in a paged response.
     * @return    Returns the ListSubscriptionEventsResponse response from the API call
     */
    public CompletableFuture<ListSubscriptionEventsResponse> listSubscriptionEventsAsync(
            final String subscriptionId,
            final String cursor,
            final Integer limit) {
        return makeHttpCallAsync(() -> buildListSubscriptionEventsRequest(subscriptionId, cursor,
                limit),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListSubscriptionEventsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listSubscriptionEvents.
     */
    private HttpRequest buildListSubscriptionEventsRequest(
            final String subscriptionId,
            final String cursor,
            final Integer limit) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/subscriptions/{subscription_id}/events");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
        queryParameters.put("limit", limit);

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
     * Processes the response for listSubscriptionEvents.
     * @return An object of type ListSubscriptionEventsResponse
     */
    private ListSubscriptionEventsResponse handleListSubscriptionEventsResponse(
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
        ListSubscriptionEventsResponse result = ApiHelper.deserialize(responseBody,
                ListSubscriptionEventsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Schedules a `PAUSE` action to pause an active subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to pause.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PauseSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public PauseSubscriptionResponse pauseSubscription(
            final String subscriptionId,
            final PauseSubscriptionRequest body) throws ApiException, IOException {
        HttpRequest request = buildPauseSubscriptionRequest(subscriptionId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handlePauseSubscriptionResponse(context);
    }

    /**
     * Schedules a `PAUSE` action to pause an active subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to pause.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PauseSubscriptionResponse response from the API call
     */
    public CompletableFuture<PauseSubscriptionResponse> pauseSubscriptionAsync(
            final String subscriptionId,
            final PauseSubscriptionRequest body) {
        return makeHttpCallAsync(() -> buildPauseSubscriptionRequest(subscriptionId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handlePauseSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for pauseSubscription.
     */
    private HttpRequest buildPauseSubscriptionRequest(
            final String subscriptionId,
            final PauseSubscriptionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/subscriptions/{subscription_id}/pause");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
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
     * Processes the response for pauseSubscription.
     * @return An object of type PauseSubscriptionResponse
     */
    private PauseSubscriptionResponse handlePauseSubscriptionResponse(
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
        PauseSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                PauseSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Schedules a `RESUME` action to resume a paused or a deactivated subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to resume.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ResumeSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ResumeSubscriptionResponse resumeSubscription(
            final String subscriptionId,
            final ResumeSubscriptionRequest body) throws ApiException, IOException {
        HttpRequest request = buildResumeSubscriptionRequest(subscriptionId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleResumeSubscriptionResponse(context);
    }

    /**
     * Schedules a `RESUME` action to resume a paused or a deactivated subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to resume.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ResumeSubscriptionResponse response from the API call
     */
    public CompletableFuture<ResumeSubscriptionResponse> resumeSubscriptionAsync(
            final String subscriptionId,
            final ResumeSubscriptionRequest body) {
        return makeHttpCallAsync(() -> buildResumeSubscriptionRequest(subscriptionId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleResumeSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for resumeSubscription.
     */
    private HttpRequest buildResumeSubscriptionRequest(
            final String subscriptionId,
            final ResumeSubscriptionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/subscriptions/{subscription_id}/resume");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
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
     * Processes the response for resumeSubscription.
     * @return An object of type ResumeSubscriptionResponse
     */
    private ResumeSubscriptionResponse handleResumeSubscriptionResponse(
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
        ResumeSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                ResumeSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Schedules a `SWAP_PLAN` action to swap a subscription plan in an existing subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to swap the
     *         subscription plan for.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SwapPlanResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SwapPlanResponse swapPlan(
            final String subscriptionId,
            final SwapPlanRequest body) throws ApiException, IOException {
        HttpRequest request = buildSwapPlanRequest(subscriptionId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSwapPlanResponse(context);
    }

    /**
     * Schedules a `SWAP_PLAN` action to swap a subscription plan in an existing subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to swap the
     *         subscription plan for.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SwapPlanResponse response from the API call
     */
    public CompletableFuture<SwapPlanResponse> swapPlanAsync(
            final String subscriptionId,
            final SwapPlanRequest body) {
        return makeHttpCallAsync(() -> buildSwapPlanRequest(subscriptionId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSwapPlanResponse(context));
    }

    /**
     * Builds the HttpRequest object for swapPlan.
     */
    private HttpRequest buildSwapPlanRequest(
            final String subscriptionId,
            final SwapPlanRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/subscriptions/{subscription_id}/swap-plan");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
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
     * Processes the response for swapPlan.
     * @return An object of type SwapPlanResponse
     */
    private SwapPlanResponse handleSwapPlanResponse(
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
        SwapPlanResponse result = ApiHelper.deserialize(responseBody,
                SwapPlanResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}