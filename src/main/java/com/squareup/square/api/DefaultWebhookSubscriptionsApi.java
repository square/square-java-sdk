
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
import com.squareup.square.models.CreateWebhookSubscriptionRequest;
import com.squareup.square.models.CreateWebhookSubscriptionResponse;
import com.squareup.square.models.DeleteWebhookSubscriptionResponse;
import com.squareup.square.models.ListWebhookEventTypesResponse;
import com.squareup.square.models.ListWebhookSubscriptionsResponse;
import com.squareup.square.models.RetrieveWebhookSubscriptionResponse;
import com.squareup.square.models.TestWebhookSubscriptionRequest;
import com.squareup.square.models.TestWebhookSubscriptionResponse;
import com.squareup.square.models.UpdateWebhookSubscriptionRequest;
import com.squareup.square.models.UpdateWebhookSubscriptionResponse;
import com.squareup.square.models.UpdateWebhookSubscriptionSignatureKeyRequest;
import com.squareup.square.models.UpdateWebhookSubscriptionSignatureKeyResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultWebhookSubscriptionsApi extends BaseApi implements WebhookSubscriptionsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultWebhookSubscriptionsApi(Configuration config, HttpClient httpClient,
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
    public DefaultWebhookSubscriptionsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists all webhook event types that can be subscribed to.
     * @param  apiVersion  Optional parameter: The API version for which to list event types.
     *         Setting this field overrides the default version used by the application.
     * @return    Returns the ListWebhookEventTypesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListWebhookEventTypesResponse listWebhookEventTypes(
            final String apiVersion) throws ApiException, IOException {
        HttpRequest request = buildListWebhookEventTypesRequest(apiVersion);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListWebhookEventTypesResponse(context);
    }

    /**
     * Lists all webhook event types that can be subscribed to.
     * @param  apiVersion  Optional parameter: The API version for which to list event types.
     *         Setting this field overrides the default version used by the application.
     * @return    Returns the ListWebhookEventTypesResponse response from the API call
     */
    public CompletableFuture<ListWebhookEventTypesResponse> listWebhookEventTypesAsync(
            final String apiVersion) {
        return makeHttpCallAsync(() -> buildListWebhookEventTypesRequest(apiVersion),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListWebhookEventTypesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listWebhookEventTypes.
     */
    private HttpRequest buildListWebhookEventTypesRequest(
            final String apiVersion) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/webhooks/event-types");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("api_version", apiVersion);

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
     * Processes the response for listWebhookEventTypes.
     * @return An object of type ListWebhookEventTypesResponse
     */
    private ListWebhookEventTypesResponse handleListWebhookEventTypesResponse(
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
        ListWebhookEventTypesResponse result = ApiHelper.deserialize(responseBody,
                ListWebhookEventTypesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Lists all webhook subscriptions owned by your application.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  includeDisabled  Optional parameter: Includes disabled
     *         [Subscription]($m/WebhookSubscription)s. By default, all enabled
     *         [Subscription]($m/WebhookSubscription)s are returned.
     * @param  sortOrder  Optional parameter: Sorts the returned list by when the
     *         [Subscription]($m/WebhookSubscription) was created with the specified order. This
     *         field defaults to ASC.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: 100
     * @return    Returns the ListWebhookSubscriptionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListWebhookSubscriptionsResponse listWebhookSubscriptions(
            final String cursor,
            final Boolean includeDisabled,
            final String sortOrder,
            final Integer limit) throws ApiException, IOException {
        HttpRequest request = buildListWebhookSubscriptionsRequest(cursor, includeDisabled,
                sortOrder, limit);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListWebhookSubscriptionsResponse(context);
    }

    /**
     * Lists all webhook subscriptions owned by your application.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  includeDisabled  Optional parameter: Includes disabled
     *         [Subscription]($m/WebhookSubscription)s. By default, all enabled
     *         [Subscription]($m/WebhookSubscription)s are returned.
     * @param  sortOrder  Optional parameter: Sorts the returned list by when the
     *         [Subscription]($m/WebhookSubscription) was created with the specified order. This
     *         field defaults to ASC.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: 100
     * @return    Returns the ListWebhookSubscriptionsResponse response from the API call
     */
    public CompletableFuture<ListWebhookSubscriptionsResponse> listWebhookSubscriptionsAsync(
            final String cursor,
            final Boolean includeDisabled,
            final String sortOrder,
            final Integer limit) {
        return makeHttpCallAsync(() -> buildListWebhookSubscriptionsRequest(cursor, includeDisabled,
                sortOrder, limit),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListWebhookSubscriptionsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listWebhookSubscriptions.
     */
    private HttpRequest buildListWebhookSubscriptionsRequest(
            final String cursor,
            final Boolean includeDisabled,
            final String sortOrder,
            final Integer limit) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/webhooks/subscriptions");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
        queryParameters.put("include_disabled",
                (includeDisabled != null) ? includeDisabled : false);
        queryParameters.put("sort_order", sortOrder);
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
     * Processes the response for listWebhookSubscriptions.
     * @return An object of type ListWebhookSubscriptionsResponse
     */
    private ListWebhookSubscriptionsResponse handleListWebhookSubscriptionsResponse(
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
        ListWebhookSubscriptionsResponse result = ApiHelper.deserialize(responseBody,
                ListWebhookSubscriptionsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a webhook subscription.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateWebhookSubscriptionResponse createWebhookSubscription(
            final CreateWebhookSubscriptionRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateWebhookSubscriptionRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateWebhookSubscriptionResponse(context);
    }

    /**
     * Creates a webhook subscription.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateWebhookSubscriptionResponse response from the API call
     */
    public CompletableFuture<CreateWebhookSubscriptionResponse> createWebhookSubscriptionAsync(
            final CreateWebhookSubscriptionRequest body) {
        return makeHttpCallAsync(() -> buildCreateWebhookSubscriptionRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateWebhookSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for createWebhookSubscription.
     */
    private HttpRequest buildCreateWebhookSubscriptionRequest(
            final CreateWebhookSubscriptionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/webhooks/subscriptions");

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
     * Processes the response for createWebhookSubscription.
     * @return An object of type CreateWebhookSubscriptionResponse
     */
    private CreateWebhookSubscriptionResponse handleCreateWebhookSubscriptionResponse(
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
        CreateWebhookSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                CreateWebhookSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to delete.
     * @return    Returns the DeleteWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteWebhookSubscriptionResponse deleteWebhookSubscription(
            final String subscriptionId) throws ApiException, IOException {
        HttpRequest request = buildDeleteWebhookSubscriptionRequest(subscriptionId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteWebhookSubscriptionResponse(context);
    }

    /**
     * Deletes a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to delete.
     * @return    Returns the DeleteWebhookSubscriptionResponse response from the API call
     */
    public CompletableFuture<DeleteWebhookSubscriptionResponse> deleteWebhookSubscriptionAsync(
            final String subscriptionId) {
        return makeHttpCallAsync(() -> buildDeleteWebhookSubscriptionRequest(subscriptionId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteWebhookSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteWebhookSubscription.
     */
    private HttpRequest buildDeleteWebhookSubscriptionRequest(
            final String subscriptionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/webhooks/subscriptions/{subscription_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
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
     * Processes the response for deleteWebhookSubscription.
     * @return An object of type DeleteWebhookSubscriptionResponse
     */
    private DeleteWebhookSubscriptionResponse handleDeleteWebhookSubscriptionResponse(
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
        DeleteWebhookSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                DeleteWebhookSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a webhook subscription identified by its ID.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to retrieve.
     * @return    Returns the RetrieveWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveWebhookSubscriptionResponse retrieveWebhookSubscription(
            final String subscriptionId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveWebhookSubscriptionRequest(subscriptionId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveWebhookSubscriptionResponse(context);
    }

    /**
     * Retrieves a webhook subscription identified by its ID.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to retrieve.
     * @return    Returns the RetrieveWebhookSubscriptionResponse response from the API call
     */
    public CompletableFuture<RetrieveWebhookSubscriptionResponse> retrieveWebhookSubscriptionAsync(
            final String subscriptionId) {
        return makeHttpCallAsync(() -> buildRetrieveWebhookSubscriptionRequest(subscriptionId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveWebhookSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveWebhookSubscription.
     */
    private HttpRequest buildRetrieveWebhookSubscriptionRequest(
            final String subscriptionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/webhooks/subscriptions/{subscription_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
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
     * Processes the response for retrieveWebhookSubscription.
     * @return An object of type RetrieveWebhookSubscriptionResponse
     */
    private RetrieveWebhookSubscriptionResponse handleRetrieveWebhookSubscriptionResponse(
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
        RetrieveWebhookSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                RetrieveWebhookSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateWebhookSubscriptionResponse updateWebhookSubscription(
            final String subscriptionId,
            final UpdateWebhookSubscriptionRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateWebhookSubscriptionRequest(subscriptionId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateWebhookSubscriptionResponse(context);
    }

    /**
     * Updates a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWebhookSubscriptionResponse response from the API call
     */
    public CompletableFuture<UpdateWebhookSubscriptionResponse> updateWebhookSubscriptionAsync(
            final String subscriptionId,
            final UpdateWebhookSubscriptionRequest body) {
        return makeHttpCallAsync(() -> buildUpdateWebhookSubscriptionRequest(subscriptionId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateWebhookSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateWebhookSubscription.
     */
    private HttpRequest buildUpdateWebhookSubscriptionRequest(
            final String subscriptionId,
            final UpdateWebhookSubscriptionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/webhooks/subscriptions/{subscription_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
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
     * Processes the response for updateWebhookSubscription.
     * @return An object of type UpdateWebhookSubscriptionResponse
     */
    private UpdateWebhookSubscriptionResponse handleUpdateWebhookSubscriptionResponse(
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
        UpdateWebhookSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                UpdateWebhookSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a webhook subscription by replacing the existing signature key with a new one.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWebhookSubscriptionSignatureKeyResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateWebhookSubscriptionSignatureKeyResponse updateWebhookSubscriptionSignatureKey(
            final String subscriptionId,
            final UpdateWebhookSubscriptionSignatureKeyRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateWebhookSubscriptionSignatureKeyRequest(subscriptionId,
                body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateWebhookSubscriptionSignatureKeyResponse(context);
    }

    /**
     * Updates a webhook subscription by replacing the existing signature key with a new one.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWebhookSubscriptionSignatureKeyResponse response from the API call
     */
    public CompletableFuture<UpdateWebhookSubscriptionSignatureKeyResponse> updateWebhookSubscriptionSignatureKeyAsync(
            final String subscriptionId,
            final UpdateWebhookSubscriptionSignatureKeyRequest body) {
        return makeHttpCallAsync(() -> buildUpdateWebhookSubscriptionSignatureKeyRequest(
                subscriptionId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateWebhookSubscriptionSignatureKeyResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateWebhookSubscriptionSignatureKey.
     */
    private HttpRequest buildUpdateWebhookSubscriptionSignatureKeyRequest(
            final String subscriptionId,
            final UpdateWebhookSubscriptionSignatureKeyRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/webhooks/subscriptions/{subscription_id}/signature-key");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
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
     * Processes the response for updateWebhookSubscriptionSignatureKey.
     * @return An object of type UpdateWebhookSubscriptionSignatureKeyResponse
     */
    private UpdateWebhookSubscriptionSignatureKeyResponse handleUpdateWebhookSubscriptionSignatureKeyResponse(
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
        UpdateWebhookSubscriptionSignatureKeyResponse result = ApiHelper.deserialize(responseBody,
                UpdateWebhookSubscriptionSignatureKeyResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Tests a webhook subscription by sending a test event to the notification URL.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to test.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the TestWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public TestWebhookSubscriptionResponse testWebhookSubscription(
            final String subscriptionId,
            final TestWebhookSubscriptionRequest body) throws ApiException, IOException {
        HttpRequest request = buildTestWebhookSubscriptionRequest(subscriptionId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleTestWebhookSubscriptionResponse(context);
    }

    /**
     * Tests a webhook subscription by sending a test event to the notification URL.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to test.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the TestWebhookSubscriptionResponse response from the API call
     */
    public CompletableFuture<TestWebhookSubscriptionResponse> testWebhookSubscriptionAsync(
            final String subscriptionId,
            final TestWebhookSubscriptionRequest body) {
        return makeHttpCallAsync(() -> buildTestWebhookSubscriptionRequest(subscriptionId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleTestWebhookSubscriptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for testWebhookSubscription.
     */
    private HttpRequest buildTestWebhookSubscriptionRequest(
            final String subscriptionId,
            final TestWebhookSubscriptionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/webhooks/subscriptions/{subscription_id}/test");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("subscription_id",
                new SimpleEntry<Object, Boolean>(subscriptionId, true));
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
     * Processes the response for testWebhookSubscription.
     * @return An object of type TestWebhookSubscriptionResponse
     */
    private TestWebhookSubscriptionResponse handleTestWebhookSubscriptionResponse(
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
        TestWebhookSubscriptionResponse result = ApiHelper.deserialize(responseBody,
                TestWebhookSubscriptionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}