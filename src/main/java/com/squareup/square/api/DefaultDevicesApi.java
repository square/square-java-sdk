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
import com.squareup.square.models.CreateDeviceCodeRequest;
import com.squareup.square.models.CreateDeviceCodeResponse;
import com.squareup.square.models.GetDeviceCodeResponse;
import com.squareup.square.models.ListDeviceCodesResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultDevicesApi extends BaseApi implements DevicesApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultDevicesApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultDevicesApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists all DeviceCodes associated with the merchant.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @param    locationId    Optional parameter: If specified, only returns DeviceCodes of the specified location. Returns DeviceCodes of all locations if empty.
     * @param    productType    Optional parameter: If specified, only returns DeviceCodes targeting the specified product type. Returns DeviceCodes of all product types if empty.
     * @return    Returns the ListDeviceCodesResponse response from the API call
     */
    public ListDeviceCodesResponse listDeviceCodes(
            final String cursor,
            final String locationId,
            final String productType) throws ApiException, IOException {
        HttpRequest request = buildListDeviceCodesRequest(cursor, locationId, productType);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListDeviceCodesResponse(context);
    }

    /**
     * Lists all DeviceCodes associated with the merchant.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @param    locationId    Optional parameter: If specified, only returns DeviceCodes of the specified location. Returns DeviceCodes of all locations if empty.
     * @param    productType    Optional parameter: If specified, only returns DeviceCodes targeting the specified product type. Returns DeviceCodes of all product types if empty.
     * @return    Returns the ListDeviceCodesResponse response from the API call 
     */
    public CompletableFuture<ListDeviceCodesResponse> listDeviceCodesAsync(
            final String cursor,
            final String locationId,
            final String productType) {
        return makeHttpCallAsync(() -> buildListDeviceCodesRequest(cursor, locationId, productType),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListDeviceCodesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listDeviceCodes
     */
    private HttpRequest buildListDeviceCodesRequest(
            final String cursor,
            final String locationId,
            final String productType) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/devices/codes");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
        queryParameters.put("location_id", locationId);
        queryParameters.put("product_type", productType);
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
     * Processes the response for listDeviceCodes
     * @return An object of type ListDeviceCodesResponse
     */
    private ListDeviceCodesResponse handleListDeviceCodesResponse(HttpContext context)
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
        ListDeviceCodesResponse result = ApiHelper.deserialize(responseBody,
                ListDeviceCodesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a DeviceCode that can be used to login to a Square Terminal device to enter the connected
     * terminal mode.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateDeviceCodeResponse response from the API call
     */
    public CreateDeviceCodeResponse createDeviceCode(
            final CreateDeviceCodeRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateDeviceCodeRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateDeviceCodeResponse(context);
    }

    /**
     * Creates a DeviceCode that can be used to login to a Square Terminal device to enter the connected
     * terminal mode.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateDeviceCodeResponse response from the API call 
     */
    public CompletableFuture<CreateDeviceCodeResponse> createDeviceCodeAsync(
            final CreateDeviceCodeRequest body) {
        return makeHttpCallAsync(() -> buildCreateDeviceCodeRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateDeviceCodeResponse(context));
    }

    /**
     * Builds the HttpRequest object for createDeviceCode
     */
    private HttpRequest buildCreateDeviceCodeRequest(
            final CreateDeviceCodeRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/devices/codes");
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
     * Processes the response for createDeviceCode
     * @return An object of type CreateDeviceCodeResponse
     */
    private CreateDeviceCodeResponse handleCreateDeviceCodeResponse(HttpContext context)
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
        CreateDeviceCodeResponse result = ApiHelper.deserialize(responseBody,
                CreateDeviceCodeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves DeviceCode with the associated ID.
     * @param    id    Required parameter: The unique identifier for the device code.
     * @return    Returns the GetDeviceCodeResponse response from the API call
     */
    public GetDeviceCodeResponse getDeviceCode(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildGetDeviceCodeRequest(id);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleGetDeviceCodeResponse(context);
    }

    /**
     * Retrieves DeviceCode with the associated ID.
     * @param    id    Required parameter: The unique identifier for the device code.
     * @return    Returns the GetDeviceCodeResponse response from the API call 
     */
    public CompletableFuture<GetDeviceCodeResponse> getDeviceCodeAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildGetDeviceCodeRequest(id),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleGetDeviceCodeResponse(context));
    }

    /**
     * Builds the HttpRequest object for getDeviceCode
     */
    private HttpRequest buildGetDeviceCodeRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/devices/codes/{id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("id", id);
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
     * Processes the response for getDeviceCode
     * @return An object of type GetDeviceCodeResponse
     */
    private GetDeviceCodeResponse handleGetDeviceCodeResponse(HttpContext context)
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
        GetDeviceCodeResponse result = ApiHelper.deserialize(responseBody,
                GetDeviceCodeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}