package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.HashMap;
import java.util.Map;

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
import com.squareup.square.models.ListMerchantsResponse;
import com.squareup.square.models.RetrieveMerchantResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultMerchantsApi extends BaseApi implements MerchantsApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultMerchantsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultMerchantsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Returns `Merchant` information for a given access token.
     * If you don't know a `Merchant` ID, you can use this endpoint to retrieve the merchant ID for an access token.
     * You can specify your personal access token to get your own merchant information or specify an OAuth token
     * to get the information for the  merchant that granted you access.
     * If you know the merchant ID, you can also use the [RetrieveMerchant](#endpoint-merchants-retrievemerchant)
     * endpoint to get the merchant information.
     * @param    cursor    Optional parameter: The cursor generated by the previous response.
     * @return    Returns the ListMerchantsResponse response from the API call
     */
    public ListMerchantsResponse listMerchants(
            final Integer cursor) throws ApiException, IOException {
        HttpRequest request = buildListMerchantsRequest(cursor);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListMerchantsResponse(context);
    }

    /**
     * Returns `Merchant` information for a given access token.
     * If you don't know a `Merchant` ID, you can use this endpoint to retrieve the merchant ID for an access token.
     * You can specify your personal access token to get your own merchant information or specify an OAuth token
     * to get the information for the  merchant that granted you access.
     * If you know the merchant ID, you can also use the [RetrieveMerchant](#endpoint-merchants-retrievemerchant)
     * endpoint to get the merchant information.
     * @param    cursor    Optional parameter: The cursor generated by the previous response.
     * @return    Returns the ListMerchantsResponse response from the API call 
     */
    public CompletableFuture<ListMerchantsResponse> listMerchantsAsync(
            final Integer cursor) {
        return makeHttpCallAsync(() -> buildListMerchantsRequest(cursor),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListMerchantsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listMerchants
     */
    private HttpRequest buildListMerchantsRequest(
            final Integer cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/merchants");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
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
     * Processes the response for listMerchants
     * @return An object of type ListMerchantsResponse
     */
    private ListMerchantsResponse handleListMerchantsResponse(HttpContext context)
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
        ListMerchantsResponse result = ApiHelper.deserialize(responseBody,
                ListMerchantsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieve a `Merchant` object for the given `merchant_id`.
     * @param    merchantId    Required parameter: The ID of the merchant to retrieve. If the string "me" is supplied as the ID, then retrieve the merchant that is currently accessible to this call.
     * @return    Returns the RetrieveMerchantResponse response from the API call
     */
    public RetrieveMerchantResponse retrieveMerchant(
            final String merchantId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveMerchantRequest(merchantId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveMerchantResponse(context);
    }

    /**
     * Retrieve a `Merchant` object for the given `merchant_id`.
     * @param    merchantId    Required parameter: The ID of the merchant to retrieve. If the string "me" is supplied as the ID, then retrieve the merchant that is currently accessible to this call.
     * @return    Returns the RetrieveMerchantResponse response from the API call 
     */
    public CompletableFuture<RetrieveMerchantResponse> retrieveMerchantAsync(
            final String merchantId) {
        return makeHttpCallAsync(() -> buildRetrieveMerchantRequest(merchantId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveMerchantResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveMerchant
     */
    private HttpRequest buildRetrieveMerchantRequest(
            final String merchantId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/merchants/{merchant_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("merchant_id", merchantId);
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
     * Processes the response for retrieveMerchant
     * @return An object of type RetrieveMerchantResponse
     */
    private RetrieveMerchantResponse handleRetrieveMerchantResponse(HttpContext context)
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
        RetrieveMerchantResponse result = ApiHelper.deserialize(responseBody,
                RetrieveMerchantResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}
