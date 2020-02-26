package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.List;
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
import com.squareup.square.models.V1Merchant;

/**
 * This class lists all the endpoints of the groups.
 */
public final class V1LocationsApi extends BaseApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public V1LocationsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public V1LocationsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Get the general information for a business.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-locations)
     * ---
     * @deprecated
     * 
     * @return    Returns the V1Merchant response from the API call
     */
    @Deprecated
    public V1Merchant retrieveBusiness() throws ApiException, IOException {
        HttpRequest request = buildRetrieveBusinessRequest();
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveBusinessResponse(context);
    }

    /**
     * Get the general information for a business.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-locations)
     * ---
     * @deprecated
     * 
     * @return    Returns the V1Merchant response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Merchant> retrieveBusinessAsync() {
        return makeHttpCallAsync(() -> buildRetrieveBusinessRequest(),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveBusinessResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveBusiness
     */
    private HttpRequest buildRetrieveBusinessRequest() {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-02-26");
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
     * Processes the response for retrieveBusiness
     * @return An object of type V1Merchant
     */
    private V1Merchant handleRetrieveBusinessResponse(HttpContext context)
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
        V1Merchant result = ApiHelper.deserialize(responseBody,
                V1Merchant.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides details for all business locations associated with a Square
     * account, including the Square-assigned object ID for the location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-locations)
     * ---
     * @deprecated
     * 
     * @return    Returns the List<V1Merchant> response from the API call
     */
    @Deprecated
    public List<V1Merchant> listLocations() throws ApiException, IOException {
        HttpRequest request = buildListLocationsRequest();
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListLocationsResponse(context);
    }

    /**
     * Provides details for all business locations associated with a Square
     * account, including the Square-assigned object ID for the location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-locations)
     * ---
     * @deprecated
     * 
     * @return    Returns the List<V1Merchant> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Merchant>> listLocationsAsync() {
        return makeHttpCallAsync(() -> buildListLocationsRequest(),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListLocationsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listLocations
     */
    private HttpRequest buildListLocationsRequest() {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/me/locations");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-02-26");
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
     * Processes the response for listLocations
     * @return An object of type List<V1Merchant>
     */
    private List<V1Merchant> handleListLocationsResponse(HttpContext context)
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
        List<V1Merchant> result = ApiHelper.deserializeArray(responseBody,
                V1Merchant[].class);
        return result;
    }

}
