
package com.squareup.square.api;

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
import com.squareup.square.models.V1Merchant;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultV1LocationsApi extends BaseApi implements V1LocationsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultV1LocationsApi(Configuration config, HttpClient httpClient,
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
    public DefaultV1LocationsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Get the general information for a business.
     * @deprecated
     * 
     * @return    Returns the V1Merchant response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public V1Merchant retrieveBusiness() throws ApiException, IOException {
        HttpRequest request = buildRetrieveBusinessRequest();
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveBusinessResponse(context);
    }

    /**
     * Get the general information for a business.
     * @deprecated
     * 
     * @return    Returns the V1Merchant response from the API call
     */
    @Deprecated
    public CompletableFuture<V1Merchant> retrieveBusinessAsync() {
        return makeHttpCallAsync(() -> buildRetrieveBusinessRequest(),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleRetrieveBusinessResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveBusiness.
     */
    private HttpRequest buildRetrieveBusinessRequest() {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/me");

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
     * Processes the response for retrieveBusiness.
     * @return An object of type V1Merchant
     */
    private V1Merchant handleRetrieveBusinessResponse(
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
        V1Merchant result = ApiHelper.deserialize(responseBody,
                V1Merchant.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides details for all business locations associated with a Square account, including the
     * Square-assigned object ID for the location.
     * @deprecated
     * 
     * @return    Returns the List of V1Merchant response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public List<V1Merchant> listLocations() throws ApiException, IOException {
        HttpRequest request = buildListLocationsRequest();
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListLocationsResponse(context);
    }

    /**
     * Provides details for all business locations associated with a Square account, including the
     * Square-assigned object ID for the location.
     * @deprecated
     * 
     * @return    Returns the List of V1Merchant response from the API call
     */
    @Deprecated
    public CompletableFuture<List<V1Merchant>> listLocationsAsync() {
        return makeHttpCallAsync(() -> buildListLocationsRequest(),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleListLocationsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listLocations.
     */
    private HttpRequest buildListLocationsRequest() {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/me/locations");

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
     * Processes the response for listLocations.
     * @return An object of type List of V1Merchant
     */
    private List<V1Merchant> handleListLocationsResponse(
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
        List<V1Merchant> result = ApiHelper.deserializeArray(responseBody,
                V1Merchant[].class);
        return result;
    }

}