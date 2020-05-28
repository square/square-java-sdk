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
import com.squareup.square.models.CreateCheckoutRequest;
import com.squareup.square.models.CreateCheckoutResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCheckoutApi extends BaseApi implements CheckoutApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultCheckoutApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultCheckoutApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Links a `checkoutId` to a `checkout_page_url` that customers will
     * be directed to in order to provide their payment information using a
     * payment processing workflow hosted on connect.squareup.com.
     * @param    locationId    Required parameter: The ID of the business location to associate the checkout with.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCheckoutResponse response from the API call
     */
    public CreateCheckoutResponse createCheckout(
            final String locationId,
            final CreateCheckoutRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateCheckoutRequest(locationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateCheckoutResponse(context);
    }

    /**
     * Links a `checkoutId` to a `checkout_page_url` that customers will
     * be directed to in order to provide their payment information using a
     * payment processing workflow hosted on connect.squareup.com.
     * @param    locationId    Required parameter: The ID of the business location to associate the checkout with.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCheckoutResponse response from the API call 
     */
    public CompletableFuture<CreateCheckoutResponse> createCheckoutAsync(
            final String locationId,
            final CreateCheckoutRequest body) {
        return makeHttpCallAsync(() -> buildCreateCheckoutRequest(locationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateCheckoutResponse(context));
    }

    /**
     * Builds the HttpRequest object for createCheckout
     */
    private HttpRequest buildCreateCheckoutRequest(
            final String locationId,
            final CreateCheckoutRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/locations/{location_id}/checkouts");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
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
     * Processes the response for createCheckout
     * @return An object of type CreateCheckoutResponse
     */
    private CreateCheckoutResponse handleCreateCheckoutResponse(HttpContext context)
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
        CreateCheckoutResponse result = ApiHelper.deserialize(responseBody,
                CreateCheckoutResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}