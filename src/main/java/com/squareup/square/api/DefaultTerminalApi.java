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
import com.squareup.square.models.CancelTerminalCheckoutResponse;
import com.squareup.square.models.CreateTerminalCheckoutRequest;
import com.squareup.square.models.CreateTerminalCheckoutResponse;
import com.squareup.square.models.GetTerminalCheckoutResponse;
import com.squareup.square.models.SearchTerminalCheckoutsRequest;
import com.squareup.square.models.SearchTerminalCheckoutsResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultTerminalApi extends BaseApi implements TerminalApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultTerminalApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultTerminalApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Creates a new Terminal checkout request and sends it to the specified device to take a payment for the requested amount.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalCheckoutResponse response from the API call
     */
    public CreateTerminalCheckoutResponse createTerminalCheckout(
            final CreateTerminalCheckoutRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateTerminalCheckoutRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateTerminalCheckoutResponse(context);
    }

    /**
     * Creates a new Terminal checkout request and sends it to the specified device to take a payment for the requested amount.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalCheckoutResponse response from the API call 
     */
    public CompletableFuture<CreateTerminalCheckoutResponse> createTerminalCheckoutAsync(
            final CreateTerminalCheckoutRequest body) {
        return makeHttpCallAsync(() -> buildCreateTerminalCheckoutRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateTerminalCheckoutResponse(context));
    }

    /**
     * Builds the HttpRequest object for createTerminalCheckout
     */
    private HttpRequest buildCreateTerminalCheckoutRequest(
            final CreateTerminalCheckoutRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/terminals/checkouts");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-05-28");
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
     * Processes the response for createTerminalCheckout
     * @return An object of type CreateTerminalCheckoutResponse
     */
    private CreateTerminalCheckoutResponse handleCreateTerminalCheckoutResponse(HttpContext context)
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
        CreateTerminalCheckoutResponse result = ApiHelper.deserialize(responseBody,
                CreateTerminalCheckoutResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a filtered list of Terminal checkout requests created by the account making the request.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call
     */
    public SearchTerminalCheckoutsResponse searchTerminalCheckouts(
            final SearchTerminalCheckoutsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchTerminalCheckoutsRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleSearchTerminalCheckoutsResponse(context);
    }

    /**
     * Retrieves a filtered list of Terminal checkout requests created by the account making the request.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call 
     */
    public CompletableFuture<SearchTerminalCheckoutsResponse> searchTerminalCheckoutsAsync(
            final SearchTerminalCheckoutsRequest body) {
        return makeHttpCallAsync(() -> buildSearchTerminalCheckoutsRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleSearchTerminalCheckoutsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchTerminalCheckouts
     */
    private HttpRequest buildSearchTerminalCheckoutsRequest(
            final SearchTerminalCheckoutsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/terminals/checkouts/search");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-05-28");
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
     * Processes the response for searchTerminalCheckouts
     * @return An object of type SearchTerminalCheckoutsResponse
     */
    private SearchTerminalCheckoutsResponse handleSearchTerminalCheckoutsResponse(HttpContext context)
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
        SearchTerminalCheckoutsResponse result = ApiHelper.deserialize(responseBody,
                SearchTerminalCheckoutsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a Terminal checkout request by checkout_id.
     * @param    checkoutId    Required parameter: Unique ID for the desired `TerminalCheckout`
     * @return    Returns the GetTerminalCheckoutResponse response from the API call
     */
    public GetTerminalCheckoutResponse getTerminalCheckout(
            final String checkoutId) throws ApiException, IOException {
        HttpRequest request = buildGetTerminalCheckoutRequest(checkoutId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleGetTerminalCheckoutResponse(context);
    }

    /**
     * Retrieves a Terminal checkout request by checkout_id.
     * @param    checkoutId    Required parameter: Unique ID for the desired `TerminalCheckout`
     * @return    Returns the GetTerminalCheckoutResponse response from the API call 
     */
    public CompletableFuture<GetTerminalCheckoutResponse> getTerminalCheckoutAsync(
            final String checkoutId) {
        return makeHttpCallAsync(() -> buildGetTerminalCheckoutRequest(checkoutId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleGetTerminalCheckoutResponse(context));
    }

    /**
     * Builds the HttpRequest object for getTerminalCheckout
     */
    private HttpRequest buildGetTerminalCheckoutRequest(
            final String checkoutId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/terminals/checkouts/{checkout_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("checkout_id", checkoutId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-05-28");
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
     * Processes the response for getTerminalCheckout
     * @return An object of type GetTerminalCheckoutResponse
     */
    private GetTerminalCheckoutResponse handleGetTerminalCheckoutResponse(HttpContext context)
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
        GetTerminalCheckoutResponse result = ApiHelper.deserialize(responseBody,
                GetTerminalCheckoutResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels a Terminal checkout request, if the status of the request permits it.
     * @param    checkoutId    Required parameter: Unique ID for the desired `TerminalCheckout`
     * @return    Returns the CancelTerminalCheckoutResponse response from the API call
     */
    public CancelTerminalCheckoutResponse cancelTerminalCheckout(
            final String checkoutId) throws ApiException, IOException {
        HttpRequest request = buildCancelTerminalCheckoutRequest(checkoutId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCancelTerminalCheckoutResponse(context);
    }

    /**
     * Cancels a Terminal checkout request, if the status of the request permits it.
     * @param    checkoutId    Required parameter: Unique ID for the desired `TerminalCheckout`
     * @return    Returns the CancelTerminalCheckoutResponse response from the API call 
     */
    public CompletableFuture<CancelTerminalCheckoutResponse> cancelTerminalCheckoutAsync(
            final String checkoutId) {
        return makeHttpCallAsync(() -> buildCancelTerminalCheckoutRequest(checkoutId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCancelTerminalCheckoutResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelTerminalCheckout
     */
    private HttpRequest buildCancelTerminalCheckoutRequest(
            final String checkoutId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/terminals/checkouts/{checkout_id}/cancel");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("checkout_id", checkoutId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-05-28");
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
     * Processes the response for cancelTerminalCheckout
     * @return An object of type CancelTerminalCheckoutResponse
     */
    private CancelTerminalCheckoutResponse handleCancelTerminalCheckoutResponse(HttpContext context)
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
        CancelTerminalCheckoutResponse result = ApiHelper.deserialize(responseBody,
                CancelTerminalCheckoutResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}