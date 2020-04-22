package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
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
import com.squareup.square.models.CreateMobileAuthorizationCodeRequest;
import com.squareup.square.models.CreateMobileAuthorizationCodeResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class MobileAuthorizationApi extends BaseApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public MobileAuthorizationApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public MobileAuthorizationApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Generates code to authorize a mobile application to connect to a Square card reader
     * Authorization codes are one-time-use and expire __60 minutes__ after being issued.
     * __Important:__ The `Authorization` header you provide to this endpoint must have the following format:
     * ```
     * Authorization: Bearer ACCESS_TOKEN
     * ```
     * Replace `ACCESS_TOKEN` with a
     * [valid production authorization credential](https://developer.squareup.com/docs/docs/build-basics/access-tokens).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateMobileAuthorizationCodeResponse response from the API call
     */
    public CreateMobileAuthorizationCodeResponse createMobileAuthorizationCode(
            final CreateMobileAuthorizationCodeRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateMobileAuthorizationCodeRequest(body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateMobileAuthorizationCodeResponse(context);
    }

    /**
     * Generates code to authorize a mobile application to connect to a Square card reader
     * Authorization codes are one-time-use and expire __60 minutes__ after being issued.
     * __Important:__ The `Authorization` header you provide to this endpoint must have the following format:
     * ```
     * Authorization: Bearer ACCESS_TOKEN
     * ```
     * Replace `ACCESS_TOKEN` with a
     * [valid production authorization credential](https://developer.squareup.com/docs/docs/build-basics/access-tokens).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateMobileAuthorizationCodeResponse response from the API call 
     */
    public CompletableFuture<CreateMobileAuthorizationCodeResponse> createMobileAuthorizationCodeAsync(
            final CreateMobileAuthorizationCodeRequest body) {
        return makeHttpCallAsync(() -> buildCreateMobileAuthorizationCodeRequest(body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateMobileAuthorizationCodeResponse(context));
    }

    /**
     * Builds the HttpRequest object for createMobileAuthorizationCode
     */
    private HttpRequest buildCreateMobileAuthorizationCodeRequest(
            final CreateMobileAuthorizationCodeRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/mobile/authorization-code");
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-04-22");
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
     * Processes the response for createMobileAuthorizationCode
     * @return An object of type CreateMobileAuthorizationCodeResponse
     */
    private CreateMobileAuthorizationCodeResponse handleCreateMobileAuthorizationCodeResponse(HttpContext context)
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
        CreateMobileAuthorizationCodeResponse result = ApiHelper.deserialize(responseBody,
                CreateMobileAuthorizationCodeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}