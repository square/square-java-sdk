
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
import com.squareup.square.models.RegisterDomainRequest;
import com.squareup.square.models.RegisterDomainResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultApplePayApi extends BaseApi implements ApplePayApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultApplePayApi(Configuration config, HttpClient httpClient,
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
    public DefaultApplePayApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Activates a domain for use with Apple Pay on the Web and Square. A validation is performed on
     * this domain by Apple to ensure that it is properly set up as an Apple Pay enabled domain.
     * This endpoint provides an easy way for platform developers to bulk activate Apple Pay on the
     * Web with Square for merchants using their platform. To learn more about Web Apple Pay, see
     * [Add the Apple Pay on the Web
     * Button](https://developer.squareup.com/docs/payment-form/add-digital-wallets/apple-pay).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RegisterDomainResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RegisterDomainResponse registerDomain(
            final RegisterDomainRequest body) throws ApiException, IOException {
        HttpRequest request = buildRegisterDomainRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRegisterDomainResponse(context);
    }

    /**
     * Activates a domain for use with Apple Pay on the Web and Square. A validation is performed on
     * this domain by Apple to ensure that it is properly set up as an Apple Pay enabled domain.
     * This endpoint provides an easy way for platform developers to bulk activate Apple Pay on the
     * Web with Square for merchants using their platform. To learn more about Web Apple Pay, see
     * [Add the Apple Pay on the Web
     * Button](https://developer.squareup.com/docs/payment-form/add-digital-wallets/apple-pay).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RegisterDomainResponse response from the API call
     */
    public CompletableFuture<RegisterDomainResponse> registerDomainAsync(
            final RegisterDomainRequest body) {
        return makeHttpCallAsync(() -> buildRegisterDomainRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRegisterDomainResponse(context));
    }

    /**
     * Builds the HttpRequest object for registerDomain.
     */
    private HttpRequest buildRegisterDomainRequest(
            final RegisterDomainRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/apple-pay/domains");

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
     * Processes the response for registerDomain.
     * @return An object of type RegisterDomainResponse
     */
    private RegisterDomainResponse handleRegisterDomainResponse(
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
        RegisterDomainResponse result = ApiHelper.deserialize(responseBody,
                RegisterDomainResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}