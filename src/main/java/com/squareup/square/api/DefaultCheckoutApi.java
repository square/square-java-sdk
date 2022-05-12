
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
import com.squareup.square.models.CreateCheckoutRequest;
import com.squareup.square.models.CreateCheckoutResponse;
import com.squareup.square.models.CreatePaymentLinkRequest;
import com.squareup.square.models.CreatePaymentLinkResponse;
import com.squareup.square.models.DeletePaymentLinkResponse;
import com.squareup.square.models.ListPaymentLinksResponse;
import com.squareup.square.models.RetrievePaymentLinkResponse;
import com.squareup.square.models.UpdatePaymentLinkRequest;
import com.squareup.square.models.UpdatePaymentLinkResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCheckoutApi extends BaseApi implements CheckoutApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultCheckoutApi(Configuration config, HttpClient httpClient,
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
    public DefaultCheckoutApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Links a `checkoutId` to a `checkout_page_url` that customers are directed to in order to
     * provide their payment information using a payment processing workflow hosted on
     * connect.squareup.com. NOTE: The Checkout API has been updated with new features. For more
     * information, see [Checkout API
     * highlights](https://developer.squareup.com/docs/checkout-api#checkout-api-highlights). We
     * recommend that you use the new [CreatePaymentLink]($e/Checkout/CreatePaymentLink)  endpoint
     * in place of this previously released endpoint.
     * @param  locationId  Required parameter: The ID of the business location to associate the
     *         checkout with.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateCheckoutResponse createCheckout(
            final String locationId,
            final CreateCheckoutRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateCheckoutRequest(locationId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateCheckoutResponse(context);
    }

    /**
     * Links a `checkoutId` to a `checkout_page_url` that customers are directed to in order to
     * provide their payment information using a payment processing workflow hosted on
     * connect.squareup.com. NOTE: The Checkout API has been updated with new features. For more
     * information, see [Checkout API
     * highlights](https://developer.squareup.com/docs/checkout-api#checkout-api-highlights). We
     * recommend that you use the new [CreatePaymentLink]($e/Checkout/CreatePaymentLink)  endpoint
     * in place of this previously released endpoint.
     * @param  locationId  Required parameter: The ID of the business location to associate the
     *         checkout with.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCheckoutResponse response from the API call
     */
    public CompletableFuture<CreateCheckoutResponse> createCheckoutAsync(
            final String locationId,
            final CreateCheckoutRequest body) {
        return makeHttpCallAsync(() -> buildCreateCheckoutRequest(locationId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateCheckoutResponse(context));
    }

    /**
     * Builds the HttpRequest object for createCheckout.
     */
    private HttpRequest buildCreateCheckoutRequest(
            final String locationId,
            final CreateCheckoutRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/locations/{location_id}/checkouts");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("location_id",
                new SimpleEntry<Object, Boolean>(locationId, true));
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
     * Processes the response for createCheckout.
     * @return An object of type CreateCheckoutResponse
     */
    private CreateCheckoutResponse handleCreateCheckoutResponse(
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
        CreateCheckoutResponse result = ApiHelper.deserialize(responseBody,
                CreateCheckoutResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Lists all payment links.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  limit  Optional parameter: A limit on the number of results to return per page. The
     *         limit is advisory and the implementation might return more or less results. If the
     *         supplied limit is negative, zero, or greater than the maximum limit of 1000, it is
     *         ignored. Default value: `100`
     * @return    Returns the ListPaymentLinksResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListPaymentLinksResponse listPaymentLinks(
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        HttpRequest request = buildListPaymentLinksRequest(cursor, limit);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListPaymentLinksResponse(context);
    }

    /**
     * Lists all payment links.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  limit  Optional parameter: A limit on the number of results to return per page. The
     *         limit is advisory and the implementation might return more or less results. If the
     *         supplied limit is negative, zero, or greater than the maximum limit of 1000, it is
     *         ignored. Default value: `100`
     * @return    Returns the ListPaymentLinksResponse response from the API call
     */
    public CompletableFuture<ListPaymentLinksResponse> listPaymentLinksAsync(
            final String cursor,
            final Integer limit) {
        return makeHttpCallAsync(() -> buildListPaymentLinksRequest(cursor, limit),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListPaymentLinksResponse(context));
    }

    /**
     * Builds the HttpRequest object for listPaymentLinks.
     */
    private HttpRequest buildListPaymentLinksRequest(
            final String cursor,
            final Integer limit) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/online-checkout/payment-links");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
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
     * Processes the response for listPaymentLinks.
     * @return An object of type ListPaymentLinksResponse
     */
    private ListPaymentLinksResponse handleListPaymentLinksResponse(
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
        ListPaymentLinksResponse result = ApiHelper.deserialize(responseBody,
                ListPaymentLinksResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a Square-hosted checkout page. Applications can share the resulting payment link with
     * their buyer to pay for goods and services.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreatePaymentLinkResponse createPaymentLink(
            final CreatePaymentLinkRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreatePaymentLinkRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreatePaymentLinkResponse(context);
    }

    /**
     * Creates a Square-hosted checkout page. Applications can share the resulting payment link with
     * their buyer to pay for goods and services.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentLinkResponse response from the API call
     */
    public CompletableFuture<CreatePaymentLinkResponse> createPaymentLinkAsync(
            final CreatePaymentLinkRequest body) {
        return makeHttpCallAsync(() -> buildCreatePaymentLinkRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreatePaymentLinkResponse(context));
    }

    /**
     * Builds the HttpRequest object for createPaymentLink.
     */
    private HttpRequest buildCreatePaymentLinkRequest(
            final CreatePaymentLinkRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/online-checkout/payment-links");

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
     * Processes the response for createPaymentLink.
     * @return An object of type CreatePaymentLinkResponse
     */
    private CreatePaymentLinkResponse handleCreatePaymentLinkResponse(
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
        CreatePaymentLinkResponse result = ApiHelper.deserialize(responseBody,
                CreatePaymentLinkResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a payment link.
     * @param  id  Required parameter: The ID of the payment link to delete.
     * @return    Returns the DeletePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeletePaymentLinkResponse deletePaymentLink(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildDeletePaymentLinkRequest(id);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeletePaymentLinkResponse(context);
    }

    /**
     * Deletes a payment link.
     * @param  id  Required parameter: The ID of the payment link to delete.
     * @return    Returns the DeletePaymentLinkResponse response from the API call
     */
    public CompletableFuture<DeletePaymentLinkResponse> deletePaymentLinkAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildDeletePaymentLinkRequest(id),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeletePaymentLinkResponse(context));
    }

    /**
     * Builds the HttpRequest object for deletePaymentLink.
     */
    private HttpRequest buildDeletePaymentLinkRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/online-checkout/payment-links/{id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("id",
                new SimpleEntry<Object, Boolean>(id, true));
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
     * Processes the response for deletePaymentLink.
     * @return An object of type DeletePaymentLinkResponse
     */
    private DeletePaymentLinkResponse handleDeletePaymentLinkResponse(
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
        DeletePaymentLinkResponse result = ApiHelper.deserialize(responseBody,
                DeletePaymentLinkResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a payment link.
     * @param  id  Required parameter: The ID of link to retrieve.
     * @return    Returns the RetrievePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrievePaymentLinkResponse retrievePaymentLink(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildRetrievePaymentLinkRequest(id);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrievePaymentLinkResponse(context);
    }

    /**
     * Retrieves a payment link.
     * @param  id  Required parameter: The ID of link to retrieve.
     * @return    Returns the RetrievePaymentLinkResponse response from the API call
     */
    public CompletableFuture<RetrievePaymentLinkResponse> retrievePaymentLinkAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildRetrievePaymentLinkRequest(id),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrievePaymentLinkResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrievePaymentLink.
     */
    private HttpRequest buildRetrievePaymentLinkRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/online-checkout/payment-links/{id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("id",
                new SimpleEntry<Object, Boolean>(id, true));
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
     * Processes the response for retrievePaymentLink.
     * @return An object of type RetrievePaymentLinkResponse
     */
    private RetrievePaymentLinkResponse handleRetrievePaymentLinkResponse(
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
        RetrievePaymentLinkResponse result = ApiHelper.deserialize(responseBody,
                RetrievePaymentLinkResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a payment link. You can update the `payment_link` fields such as `description`,
     * `checkout_options`, and `pre_populated_data`. You cannot update other fields such as the
     * `order_id`, `version`, `URL`, or `timestamp` field.
     * @param  id  Required parameter: The ID of the payment link to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdatePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdatePaymentLinkResponse updatePaymentLink(
            final String id,
            final UpdatePaymentLinkRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdatePaymentLinkRequest(id, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdatePaymentLinkResponse(context);
    }

    /**
     * Updates a payment link. You can update the `payment_link` fields such as `description`,
     * `checkout_options`, and `pre_populated_data`. You cannot update other fields such as the
     * `order_id`, `version`, `URL`, or `timestamp` field.
     * @param  id  Required parameter: The ID of the payment link to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdatePaymentLinkResponse response from the API call
     */
    public CompletableFuture<UpdatePaymentLinkResponse> updatePaymentLinkAsync(
            final String id,
            final UpdatePaymentLinkRequest body) {
        return makeHttpCallAsync(() -> buildUpdatePaymentLinkRequest(id, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdatePaymentLinkResponse(context));
    }

    /**
     * Builds the HttpRequest object for updatePaymentLink.
     */
    private HttpRequest buildUpdatePaymentLinkRequest(
            final String id,
            final UpdatePaymentLinkRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/online-checkout/payment-links/{id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("id",
                new SimpleEntry<Object, Boolean>(id, true));
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
     * Processes the response for updatePaymentLink.
     * @return An object of type UpdatePaymentLinkResponse
     */
    private UpdatePaymentLinkResponse handleUpdatePaymentLinkResponse(
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
        UpdatePaymentLinkResponse result = ApiHelper.deserialize(responseBody,
                UpdatePaymentLinkResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}