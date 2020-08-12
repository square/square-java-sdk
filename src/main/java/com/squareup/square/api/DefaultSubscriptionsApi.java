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
import com.squareup.square.models.CancelSubscriptionResponse;
import com.squareup.square.models.CreateSubscriptionRequest;
import com.squareup.square.models.CreateSubscriptionResponse;
import com.squareup.square.models.ListSubscriptionEventsResponse;
import com.squareup.square.models.RetrieveSubscriptionResponse;
import com.squareup.square.models.SearchSubscriptionsRequest;
import com.squareup.square.models.SearchSubscriptionsResponse;
import com.squareup.square.models.UpdateSubscriptionRequest;
import com.squareup.square.models.UpdateSubscriptionResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultSubscriptionsApi extends BaseApi implements SubscriptionsApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultSubscriptionsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultSubscriptionsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Creates a subscription for a customer to a subscription plan.
     * If you provide a card on file in the request, Square charges the card for 
     * the subscription. Otherwise, Square bills an invoice to the customer's email 
     * address. The subscription starts immediately, unless the request includes 
     * the optional `start_date`. Each individual subscription is associated with a particular location. 
     * For more information, 
     * see [Subscription API Overview](https://developer.squareup.com/docs/docs/subscriptions-api/overview).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateSubscriptionResponse response from the API call
     */
    public CreateSubscriptionResponse createSubscription(
            final CreateSubscriptionRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateSubscriptionRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateSubscriptionResponse(context);
    }

    /**
     * Creates a subscription for a customer to a subscription plan.
     * If you provide a card on file in the request, Square charges the card for 
     * the subscription. Otherwise, Square bills an invoice to the customer's email 
     * address. The subscription starts immediately, unless the request includes 
     * the optional `start_date`. Each individual subscription is associated with a particular location. 
     * For more information, 
     * see [Subscription API Overview](https://developer.squareup.com/docs/docs/subscriptions-api/overview).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateSubscriptionResponse response from the API call 
     */
    public CompletableFuture<CreateSubscriptionResponse> createSubscriptionAsync(
            final CreateSubscriptionRequest body) {
        return makeHttpCallAsync(() -> buildCreateSubscriptionRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for createSubscription
     */
    private HttpRequest buildCreateSubscriptionRequest(
            final CreateSubscriptionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/subscriptions");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
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
     * Processes the response for createSubscription
     * @return An object of type CreateSubscriptionResponse
     */
    private CreateSubscriptionResponse handleCreateSubscriptionResponse(HttpContext context)
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
        CreateSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                CreateSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches for subscriptions. 
     * Results are ordered chronologically by subscription creation date. If
     * the request specifies more than one location ID, 
     * the endpoint orders the result 
     * by location ID, and then by creation date within each location. If no locations are given
     * in the query, all locations are searched.
     * You can also optionally specify `customer_ids` to search by customer. 
     * If left unset, all customers 
     * associated with the specified locations are returned. 
     * If the request specifies customer IDs, the endpoint orders results 
     * first by location, within location by customer ID, and within 
     * customer by subscription creation date.
     * For more information, see 
     * [Retrieve subscriptions](https://developer.squareup.com/docs/docs/subscriptions-api/overview#retrieve-subscriptions).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchSubscriptionsResponse response from the API call
     */
    public SearchSubscriptionsResponse searchSubscriptions(
            final SearchSubscriptionsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchSubscriptionsRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleSearchSubscriptionsResponse(context);
    }

    /**
     * Searches for subscriptions. 
     * Results are ordered chronologically by subscription creation date. If
     * the request specifies more than one location ID, 
     * the endpoint orders the result 
     * by location ID, and then by creation date within each location. If no locations are given
     * in the query, all locations are searched.
     * You can also optionally specify `customer_ids` to search by customer. 
     * If left unset, all customers 
     * associated with the specified locations are returned. 
     * If the request specifies customer IDs, the endpoint orders results 
     * first by location, within location by customer ID, and within 
     * customer by subscription creation date.
     * For more information, see 
     * [Retrieve subscriptions](https://developer.squareup.com/docs/docs/subscriptions-api/overview#retrieve-subscriptions).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchSubscriptionsResponse response from the API call 
     */
    public CompletableFuture<SearchSubscriptionsResponse> searchSubscriptionsAsync(
            final SearchSubscriptionsRequest body) {
        return makeHttpCallAsync(() -> buildSearchSubscriptionsRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleSearchSubscriptionsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchSubscriptions
     */
    private HttpRequest buildSearchSubscriptionsRequest(
            final SearchSubscriptionsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/subscriptions/search");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
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
     * Processes the response for searchSubscriptions
     * @return An object of type SearchSubscriptionsResponse
     */
    private SearchSubscriptionsResponse handleSearchSubscriptionsResponse(HttpContext context)
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
        SearchSubscriptionsResponse result = ApiHelper.deserialize(responseBody,
                SearchSubscriptionsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a subscription.
     * @param    subscriptionId    Required parameter: The ID of the subscription to retrieve.
     * @return    Returns the RetrieveSubscriptionResponse response from the API call
     */
    public RetrieveSubscriptionResponse retrieveSubscription(
            final String subscriptionId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveSubscriptionRequest(subscriptionId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveSubscriptionResponse(context);
    }

    /**
     * Retrieves a subscription.
     * @param    subscriptionId    Required parameter: The ID of the subscription to retrieve.
     * @return    Returns the RetrieveSubscriptionResponse response from the API call 
     */
    public CompletableFuture<RetrieveSubscriptionResponse> retrieveSubscriptionAsync(
            final String subscriptionId) {
        return makeHttpCallAsync(() -> buildRetrieveSubscriptionRequest(subscriptionId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveSubscription
     */
    private HttpRequest buildRetrieveSubscriptionRequest(
            final String subscriptionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/subscriptions/{subscription_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id", subscriptionId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
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
     * Processes the response for retrieveSubscription
     * @return An object of type RetrieveSubscriptionResponse
     */
    private RetrieveSubscriptionResponse handleRetrieveSubscriptionResponse(HttpContext context)
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
        RetrieveSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                RetrieveSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a subscription. You can set, modify, and clear the 
     * `subscription` field values. For more information and examples, see 
     * [Update subscriptions](https://developer.squareup.com/docs/docs/subscriptions-api/overview#update-subscriptions).
     * @param    subscriptionId    Required parameter: The ID for the subscription to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateSubscriptionResponse response from the API call
     */
    public UpdateSubscriptionResponse updateSubscription(
            final String subscriptionId,
            final UpdateSubscriptionRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateSubscriptionRequest(subscriptionId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateSubscriptionResponse(context);
    }

    /**
     * Updates a subscription. You can set, modify, and clear the 
     * `subscription` field values. For more information and examples, see 
     * [Update subscriptions](https://developer.squareup.com/docs/docs/subscriptions-api/overview#update-subscriptions).
     * @param    subscriptionId    Required parameter: The ID for the subscription to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateSubscriptionResponse response from the API call 
     */
    public CompletableFuture<UpdateSubscriptionResponse> updateSubscriptionAsync(
            final String subscriptionId,
            final UpdateSubscriptionRequest body) {
        return makeHttpCallAsync(() -> buildUpdateSubscriptionRequest(subscriptionId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateSubscription
     */
    private HttpRequest buildUpdateSubscriptionRequest(
            final String subscriptionId,
            final UpdateSubscriptionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/subscriptions/{subscription_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id", subscriptionId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateSubscription
     * @return An object of type UpdateSubscriptionResponse
     */
    private UpdateSubscriptionResponse handleUpdateSubscriptionResponse(HttpContext context)
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
        UpdateSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                UpdateSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels a subscription immediately and sets the subscription
     * `status` to `CANCELED`. You can also use the `UpdateSubscription`
     * endpoint to cancel a subscription at a future date. For more
     * information, see
     * [CancelSubscriptions](https://developer.squareup.com/docs/docs/subscriptions-api/overview#cancel-subscriptions).
     * @param    subscriptionId    Required parameter: The ID of the subscription to cancel.
     * @return    Returns the CancelSubscriptionResponse response from the API call
     */
    public CancelSubscriptionResponse cancelSubscription(
            final String subscriptionId) throws ApiException, IOException {
        HttpRequest request = buildCancelSubscriptionRequest(subscriptionId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCancelSubscriptionResponse(context);
    }

    /**
     * Cancels a subscription immediately and sets the subscription
     * `status` to `CANCELED`. You can also use the `UpdateSubscription`
     * endpoint to cancel a subscription at a future date. For more
     * information, see
     * [CancelSubscriptions](https://developer.squareup.com/docs/docs/subscriptions-api/overview#cancel-subscriptions).
     * @param    subscriptionId    Required parameter: The ID of the subscription to cancel.
     * @return    Returns the CancelSubscriptionResponse response from the API call 
     */
    public CompletableFuture<CancelSubscriptionResponse> cancelSubscriptionAsync(
            final String subscriptionId) {
        return makeHttpCallAsync(() -> buildCancelSubscriptionRequest(subscriptionId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCancelSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelSubscription
     */
    private HttpRequest buildCancelSubscriptionRequest(
            final String subscriptionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/subscriptions/{subscription_id}/cancel");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id", subscriptionId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
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
     * Processes the response for cancelSubscription
     * @return An object of type CancelSubscriptionResponse
     */
    private CancelSubscriptionResponse handleCancelSubscriptionResponse(HttpContext context)
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
        CancelSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                CancelSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Lists all events for a specific subscription.
     * In the current implementation, only `START_SUBSCRIPTION` and `STOP_SUBSCRIPTION` (when the subscription was canceled) events are returned.
     * @param    subscriptionId    Required parameter: The ID of the subscription to retrieve the events for.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  For more information, see [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination).
     * @param    limit    Optional parameter: The upper limit on the number of subscription events to return  in the response.   Default: `200`
     * @return    Returns the ListSubscriptionEventsResponse response from the API call
     */
    public ListSubscriptionEventsResponse listSubscriptionEvents(
            final String subscriptionId,
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        HttpRequest request = buildListSubscriptionEventsRequest(subscriptionId, cursor, limit);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListSubscriptionEventsResponse(context);
    }

    /**
     * Lists all events for a specific subscription.
     * In the current implementation, only `START_SUBSCRIPTION` and `STOP_SUBSCRIPTION` (when the subscription was canceled) events are returned.
     * @param    subscriptionId    Required parameter: The ID of the subscription to retrieve the events for.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  For more information, see [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination).
     * @param    limit    Optional parameter: The upper limit on the number of subscription events to return  in the response.   Default: `200`
     * @return    Returns the ListSubscriptionEventsResponse response from the API call 
     */
    public CompletableFuture<ListSubscriptionEventsResponse> listSubscriptionEventsAsync(
            final String subscriptionId,
            final String cursor,
            final Integer limit) {
        return makeHttpCallAsync(() -> buildListSubscriptionEventsRequest(subscriptionId, cursor, limit),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListSubscriptionEventsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listSubscriptionEvents
     */
    private HttpRequest buildListSubscriptionEventsRequest(
            final String subscriptionId,
            final String cursor,
            final Integer limit) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/subscriptions/{subscription_id}/events");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id", subscriptionId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
        queryParameters.put("limit", limit);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
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
     * Processes the response for listSubscriptionEvents
     * @return An object of type ListSubscriptionEventsResponse
     */
    private ListSubscriptionEventsResponse handleListSubscriptionEventsResponse(HttpContext context)
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
        ListSubscriptionEventsResponse result = ApiHelper.deserialize(responseBody,
                ListSubscriptionEventsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}
