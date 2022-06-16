
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
import com.squareup.square.models.CancelTerminalActionResponse;
import com.squareup.square.models.CancelTerminalCheckoutResponse;
import com.squareup.square.models.CancelTerminalRefundResponse;
import com.squareup.square.models.CreateTerminalActionRequest;
import com.squareup.square.models.CreateTerminalActionResponse;
import com.squareup.square.models.CreateTerminalCheckoutRequest;
import com.squareup.square.models.CreateTerminalCheckoutResponse;
import com.squareup.square.models.CreateTerminalRefundRequest;
import com.squareup.square.models.CreateTerminalRefundResponse;
import com.squareup.square.models.GetTerminalActionResponse;
import com.squareup.square.models.GetTerminalCheckoutResponse;
import com.squareup.square.models.GetTerminalRefundResponse;
import com.squareup.square.models.SearchTerminalActionsRequest;
import com.squareup.square.models.SearchTerminalActionsResponse;
import com.squareup.square.models.SearchTerminalCheckoutsRequest;
import com.squareup.square.models.SearchTerminalCheckoutsResponse;
import com.squareup.square.models.SearchTerminalRefundsRequest;
import com.squareup.square.models.SearchTerminalRefundsResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultTerminalApi extends BaseApi implements TerminalApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultTerminalApi(Configuration config, HttpClient httpClient,
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
    public DefaultTerminalApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Creates a Terminal action request and sends it to the specified device.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateTerminalActionResponse createTerminalAction(
            final CreateTerminalActionRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateTerminalActionRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateTerminalActionResponse(context);
    }

    /**
     * Creates a Terminal action request and sends it to the specified device.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalActionResponse response from the API call
     */
    public CompletableFuture<CreateTerminalActionResponse> createTerminalActionAsync(
            final CreateTerminalActionRequest body) {
        return makeHttpCallAsync(() -> buildCreateTerminalActionRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateTerminalActionResponse(context));
    }

    /**
     * Builds the HttpRequest object for createTerminalAction.
     */
    private HttpRequest buildCreateTerminalActionRequest(
            final CreateTerminalActionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/actions");

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
     * Processes the response for createTerminalAction.
     * @return An object of type CreateTerminalActionResponse
     */
    private CreateTerminalActionResponse handleCreateTerminalActionResponse(
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
        CreateTerminalActionResponse result = ApiHelper.deserialize(responseBody,
                CreateTerminalActionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a filtered list of Terminal action requests created by the account making the
     * request. Terminal action requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalActionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchTerminalActionsResponse searchTerminalActions(
            final SearchTerminalActionsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchTerminalActionsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchTerminalActionsResponse(context);
    }

    /**
     * Retrieves a filtered list of Terminal action requests created by the account making the
     * request. Terminal action requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalActionsResponse response from the API call
     */
    public CompletableFuture<SearchTerminalActionsResponse> searchTerminalActionsAsync(
            final SearchTerminalActionsRequest body) {
        return makeHttpCallAsync(() -> buildSearchTerminalActionsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchTerminalActionsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchTerminalActions.
     */
    private HttpRequest buildSearchTerminalActionsRequest(
            final SearchTerminalActionsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/actions/search");

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
     * Processes the response for searchTerminalActions.
     * @return An object of type SearchTerminalActionsResponse
     */
    private SearchTerminalActionsResponse handleSearchTerminalActionsResponse(
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
        SearchTerminalActionsResponse result = ApiHelper.deserialize(responseBody,
                SearchTerminalActionsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a Terminal action request by `action_id`. Terminal action requests are available
     * for 30 days.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`
     * @return    Returns the GetTerminalActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetTerminalActionResponse getTerminalAction(
            final String actionId) throws ApiException, IOException {
        HttpRequest request = buildGetTerminalActionRequest(actionId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleGetTerminalActionResponse(context);
    }

    /**
     * Retrieves a Terminal action request by `action_id`. Terminal action requests are available
     * for 30 days.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`
     * @return    Returns the GetTerminalActionResponse response from the API call
     */
    public CompletableFuture<GetTerminalActionResponse> getTerminalActionAsync(
            final String actionId) {
        return makeHttpCallAsync(() -> buildGetTerminalActionRequest(actionId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleGetTerminalActionResponse(context));
    }

    /**
     * Builds the HttpRequest object for getTerminalAction.
     */
    private HttpRequest buildGetTerminalActionRequest(
            final String actionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/actions/{action_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("action_id",
                new SimpleEntry<Object, Boolean>(actionId, true));
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
     * Processes the response for getTerminalAction.
     * @return An object of type GetTerminalActionResponse
     */
    private GetTerminalActionResponse handleGetTerminalActionResponse(
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
        GetTerminalActionResponse result = ApiHelper.deserialize(responseBody,
                GetTerminalActionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels a Terminal action request if the status of the request permits it.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`
     * @return    Returns the CancelTerminalActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelTerminalActionResponse cancelTerminalAction(
            final String actionId) throws ApiException, IOException {
        HttpRequest request = buildCancelTerminalActionRequest(actionId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCancelTerminalActionResponse(context);
    }

    /**
     * Cancels a Terminal action request if the status of the request permits it.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`
     * @return    Returns the CancelTerminalActionResponse response from the API call
     */
    public CompletableFuture<CancelTerminalActionResponse> cancelTerminalActionAsync(
            final String actionId) {
        return makeHttpCallAsync(() -> buildCancelTerminalActionRequest(actionId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCancelTerminalActionResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelTerminalAction.
     */
    private HttpRequest buildCancelTerminalActionRequest(
            final String actionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/actions/{action_id}/cancel");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("action_id",
                new SimpleEntry<Object, Boolean>(actionId, true));
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
     * Processes the response for cancelTerminalAction.
     * @return An object of type CancelTerminalActionResponse
     */
    private CancelTerminalActionResponse handleCancelTerminalActionResponse(
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
        CancelTerminalActionResponse result = ApiHelper.deserialize(responseBody,
                CancelTerminalActionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a Terminal checkout request and sends it to the specified device to take a payment
     * for the requested amount.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateTerminalCheckoutResponse createTerminalCheckout(
            final CreateTerminalCheckoutRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateTerminalCheckoutRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateTerminalCheckoutResponse(context);
    }

    /**
     * Creates a Terminal checkout request and sends it to the specified device to take a payment
     * for the requested amount.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalCheckoutResponse response from the API call
     */
    public CompletableFuture<CreateTerminalCheckoutResponse> createTerminalCheckoutAsync(
            final CreateTerminalCheckoutRequest body) {
        return makeHttpCallAsync(() -> buildCreateTerminalCheckoutRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateTerminalCheckoutResponse(context));
    }

    /**
     * Builds the HttpRequest object for createTerminalCheckout.
     */
    private HttpRequest buildCreateTerminalCheckoutRequest(
            final CreateTerminalCheckoutRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/checkouts");

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
     * Processes the response for createTerminalCheckout.
     * @return An object of type CreateTerminalCheckoutResponse
     */
    private CreateTerminalCheckoutResponse handleCreateTerminalCheckoutResponse(
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
        CreateTerminalCheckoutResponse result = ApiHelper.deserialize(responseBody,
                CreateTerminalCheckoutResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a filtered list of Terminal checkout requests created by the application making the
     * request. Only Terminal checkout requests created for the merchant scoped to the OAuth token
     * are returned. Terminal checkout requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchTerminalCheckoutsResponse searchTerminalCheckouts(
            final SearchTerminalCheckoutsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchTerminalCheckoutsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchTerminalCheckoutsResponse(context);
    }

    /**
     * Returns a filtered list of Terminal checkout requests created by the application making the
     * request. Only Terminal checkout requests created for the merchant scoped to the OAuth token
     * are returned. Terminal checkout requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call
     */
    public CompletableFuture<SearchTerminalCheckoutsResponse> searchTerminalCheckoutsAsync(
            final SearchTerminalCheckoutsRequest body) {
        return makeHttpCallAsync(() -> buildSearchTerminalCheckoutsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchTerminalCheckoutsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchTerminalCheckouts.
     */
    private HttpRequest buildSearchTerminalCheckoutsRequest(
            final SearchTerminalCheckoutsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/checkouts/search");

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
     * Processes the response for searchTerminalCheckouts.
     * @return An object of type SearchTerminalCheckoutsResponse
     */
    private SearchTerminalCheckoutsResponse handleSearchTerminalCheckoutsResponse(
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
        SearchTerminalCheckoutsResponse result = ApiHelper.deserialize(responseBody,
                SearchTerminalCheckoutsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a Terminal checkout request by `checkout_id`. Terminal checkout requests are
     * available for 30 days.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the GetTerminalCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetTerminalCheckoutResponse getTerminalCheckout(
            final String checkoutId) throws ApiException, IOException {
        HttpRequest request = buildGetTerminalCheckoutRequest(checkoutId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleGetTerminalCheckoutResponse(context);
    }

    /**
     * Retrieves a Terminal checkout request by `checkout_id`. Terminal checkout requests are
     * available for 30 days.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the GetTerminalCheckoutResponse response from the API call
     */
    public CompletableFuture<GetTerminalCheckoutResponse> getTerminalCheckoutAsync(
            final String checkoutId) {
        return makeHttpCallAsync(() -> buildGetTerminalCheckoutRequest(checkoutId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleGetTerminalCheckoutResponse(context));
    }

    /**
     * Builds the HttpRequest object for getTerminalCheckout.
     */
    private HttpRequest buildGetTerminalCheckoutRequest(
            final String checkoutId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/checkouts/{checkout_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("checkout_id",
                new SimpleEntry<Object, Boolean>(checkoutId, true));
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
     * Processes the response for getTerminalCheckout.
     * @return An object of type GetTerminalCheckoutResponse
     */
    private GetTerminalCheckoutResponse handleGetTerminalCheckoutResponse(
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
        GetTerminalCheckoutResponse result = ApiHelper.deserialize(responseBody,
                GetTerminalCheckoutResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels a Terminal checkout request if the status of the request permits it.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the CancelTerminalCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelTerminalCheckoutResponse cancelTerminalCheckout(
            final String checkoutId) throws ApiException, IOException {
        HttpRequest request = buildCancelTerminalCheckoutRequest(checkoutId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCancelTerminalCheckoutResponse(context);
    }

    /**
     * Cancels a Terminal checkout request if the status of the request permits it.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the CancelTerminalCheckoutResponse response from the API call
     */
    public CompletableFuture<CancelTerminalCheckoutResponse> cancelTerminalCheckoutAsync(
            final String checkoutId) {
        return makeHttpCallAsync(() -> buildCancelTerminalCheckoutRequest(checkoutId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCancelTerminalCheckoutResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelTerminalCheckout.
     */
    private HttpRequest buildCancelTerminalCheckoutRequest(
            final String checkoutId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/checkouts/{checkout_id}/cancel");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("checkout_id",
                new SimpleEntry<Object, Boolean>(checkoutId, true));
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
     * Processes the response for cancelTerminalCheckout.
     * @return An object of type CancelTerminalCheckoutResponse
     */
    private CancelTerminalCheckoutResponse handleCancelTerminalCheckoutResponse(
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
        CancelTerminalCheckoutResponse result = ApiHelper.deserialize(responseBody,
                CancelTerminalCheckoutResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a request to refund an Interac payment completed on a Square Terminal. Refunds for
     * Interac payments on a Square Terminal are supported only for Interac debit cards in Canada.
     * Other refunds for Terminal payments should use the Refunds API. For more information, see
     * [Refunds API]($e/Refunds).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateTerminalRefundResponse createTerminalRefund(
            final CreateTerminalRefundRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateTerminalRefundRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateTerminalRefundResponse(context);
    }

    /**
     * Creates a request to refund an Interac payment completed on a Square Terminal. Refunds for
     * Interac payments on a Square Terminal are supported only for Interac debit cards in Canada.
     * Other refunds for Terminal payments should use the Refunds API. For more information, see
     * [Refunds API]($e/Refunds).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalRefundResponse response from the API call
     */
    public CompletableFuture<CreateTerminalRefundResponse> createTerminalRefundAsync(
            final CreateTerminalRefundRequest body) {
        return makeHttpCallAsync(() -> buildCreateTerminalRefundRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateTerminalRefundResponse(context));
    }

    /**
     * Builds the HttpRequest object for createTerminalRefund.
     */
    private HttpRequest buildCreateTerminalRefundRequest(
            final CreateTerminalRefundRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/refunds");

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
     * Processes the response for createTerminalRefund.
     * @return An object of type CreateTerminalRefundResponse
     */
    private CreateTerminalRefundResponse handleCreateTerminalRefundResponse(
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
        CreateTerminalRefundResponse result = ApiHelper.deserialize(responseBody,
                CreateTerminalRefundResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a filtered list of Interac Terminal refund requests created by the seller making
     * the request. Terminal refund requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalRefundsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchTerminalRefundsResponse searchTerminalRefunds(
            final SearchTerminalRefundsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchTerminalRefundsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchTerminalRefundsResponse(context);
    }

    /**
     * Retrieves a filtered list of Interac Terminal refund requests created by the seller making
     * the request. Terminal refund requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalRefundsResponse response from the API call
     */
    public CompletableFuture<SearchTerminalRefundsResponse> searchTerminalRefundsAsync(
            final SearchTerminalRefundsRequest body) {
        return makeHttpCallAsync(() -> buildSearchTerminalRefundsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchTerminalRefundsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchTerminalRefunds.
     */
    private HttpRequest buildSearchTerminalRefundsRequest(
            final SearchTerminalRefundsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/refunds/search");

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
     * Processes the response for searchTerminalRefunds.
     * @return An object of type SearchTerminalRefundsResponse
     */
    private SearchTerminalRefundsResponse handleSearchTerminalRefundsResponse(
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
        SearchTerminalRefundsResponse result = ApiHelper.deserialize(responseBody,
                SearchTerminalRefundsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves an Interac Terminal refund object by ID. Terminal refund objects are available for
     * 30 days.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the GetTerminalRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetTerminalRefundResponse getTerminalRefund(
            final String terminalRefundId) throws ApiException, IOException {
        HttpRequest request = buildGetTerminalRefundRequest(terminalRefundId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleGetTerminalRefundResponse(context);
    }

    /**
     * Retrieves an Interac Terminal refund object by ID. Terminal refund objects are available for
     * 30 days.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the GetTerminalRefundResponse response from the API call
     */
    public CompletableFuture<GetTerminalRefundResponse> getTerminalRefundAsync(
            final String terminalRefundId) {
        return makeHttpCallAsync(() -> buildGetTerminalRefundRequest(terminalRefundId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleGetTerminalRefundResponse(context));
    }

    /**
     * Builds the HttpRequest object for getTerminalRefund.
     */
    private HttpRequest buildGetTerminalRefundRequest(
            final String terminalRefundId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/refunds/{terminal_refund_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("terminal_refund_id",
                new SimpleEntry<Object, Boolean>(terminalRefundId, true));
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
     * Processes the response for getTerminalRefund.
     * @return An object of type GetTerminalRefundResponse
     */
    private GetTerminalRefundResponse handleGetTerminalRefundResponse(
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
        GetTerminalRefundResponse result = ApiHelper.deserialize(responseBody,
                GetTerminalRefundResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels an Interac Terminal refund request by refund request ID if the status of the request
     * permits it.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the CancelTerminalRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelTerminalRefundResponse cancelTerminalRefund(
            final String terminalRefundId) throws ApiException, IOException {
        HttpRequest request = buildCancelTerminalRefundRequest(terminalRefundId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCancelTerminalRefundResponse(context);
    }

    /**
     * Cancels an Interac Terminal refund request by refund request ID if the status of the request
     * permits it.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the CancelTerminalRefundResponse response from the API call
     */
    public CompletableFuture<CancelTerminalRefundResponse> cancelTerminalRefundAsync(
            final String terminalRefundId) {
        return makeHttpCallAsync(() -> buildCancelTerminalRefundRequest(terminalRefundId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCancelTerminalRefundResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelTerminalRefund.
     */
    private HttpRequest buildCancelTerminalRefundRequest(
            final String terminalRefundId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/terminals/refunds/{terminal_refund_id}/cancel");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("terminal_refund_id",
                new SimpleEntry<Object, Boolean>(terminalRefundId, true));
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
     * Processes the response for cancelTerminalRefund.
     * @return An object of type CancelTerminalRefundResponse
     */
    private CancelTerminalRefundResponse handleCancelTerminalRefundResponse(
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
        CancelTerminalRefundResponse result = ApiHelper.deserialize(responseBody,
                CancelTerminalRefundResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}