
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
import com.squareup.square.models.CreateGiftCardRequest;
import com.squareup.square.models.CreateGiftCardResponse;
import com.squareup.square.models.LinkCustomerToGiftCardRequest;
import com.squareup.square.models.LinkCustomerToGiftCardResponse;
import com.squareup.square.models.ListGiftCardsResponse;
import com.squareup.square.models.RetrieveGiftCardFromGANRequest;
import com.squareup.square.models.RetrieveGiftCardFromGANResponse;
import com.squareup.square.models.RetrieveGiftCardFromNonceRequest;
import com.squareup.square.models.RetrieveGiftCardFromNonceResponse;
import com.squareup.square.models.RetrieveGiftCardResponse;
import com.squareup.square.models.UnlinkCustomerFromGiftCardRequest;
import com.squareup.square.models.UnlinkCustomerFromGiftCardResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultGiftCardsApi extends BaseApi implements GiftCardsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultGiftCardsApi(Configuration config, HttpClient httpClient,
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
    public DefaultGiftCardsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists all gift cards. You can specify optional filters to retrieve a subset of the gift
     * cards.
     * @param  type  Optional parameter: If a type is provided, gift cards of this type are returned
     *         (see [GiftCardType]($m/GiftCardType)). If no type is provided, it returns gift cards
     *         of all types.
     * @param  state  Optional parameter: If the state is provided, it returns the gift cards in the
     *         specified state (see [GiftCardStatus]($m/GiftCardStatus)). Otherwise, it returns the
     *         gift cards of all states.
     * @param  limit  Optional parameter: If a value is provided, it returns only that number of
     *         results per page. The maximum number of results allowed per page is 50. The default
     *         value is 30.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, it returns the first page of the results. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  customerId  Optional parameter: If a value is provided, returns only the gift cards
     *         linked to the specified customer
     * @return    Returns the ListGiftCardsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListGiftCardsResponse listGiftCards(
            final String type,
            final String state,
            final Integer limit,
            final String cursor,
            final String customerId) throws ApiException, IOException {
        HttpRequest request = buildListGiftCardsRequest(type, state, limit, cursor, customerId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListGiftCardsResponse(context);
    }

    /**
     * Lists all gift cards. You can specify optional filters to retrieve a subset of the gift
     * cards.
     * @param  type  Optional parameter: If a type is provided, gift cards of this type are returned
     *         (see [GiftCardType]($m/GiftCardType)). If no type is provided, it returns gift cards
     *         of all types.
     * @param  state  Optional parameter: If the state is provided, it returns the gift cards in the
     *         specified state (see [GiftCardStatus]($m/GiftCardStatus)). Otherwise, it returns the
     *         gift cards of all states.
     * @param  limit  Optional parameter: If a value is provided, it returns only that number of
     *         results per page. The maximum number of results allowed per page is 50. The default
     *         value is 30.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, it returns the first page of the results. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  customerId  Optional parameter: If a value is provided, returns only the gift cards
     *         linked to the specified customer
     * @return    Returns the ListGiftCardsResponse response from the API call
     */
    public CompletableFuture<ListGiftCardsResponse> listGiftCardsAsync(
            final String type,
            final String state,
            final Integer limit,
            final String cursor,
            final String customerId) {
        return makeHttpCallAsync(() -> buildListGiftCardsRequest(type, state, limit, cursor,
                customerId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListGiftCardsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listGiftCards.
     */
    private HttpRequest buildListGiftCardsRequest(
            final String type,
            final String state,
            final Integer limit,
            final String cursor,
            final String customerId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/gift-cards");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("type", type);
        queryParameters.put("state", state);
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);
        queryParameters.put("customer_id", customerId);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
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
     * Processes the response for listGiftCards.
     * @return An object of type ListGiftCardsResponse
     */
    private ListGiftCardsResponse handleListGiftCardsResponse(
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
        ListGiftCardsResponse result = ApiHelper.deserialize(responseBody,
                ListGiftCardsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a digital gift card. You must activate the gift card before it can be used. For more
     * information, see [Selling gift
     * cards](https://developer.squareup.com/docs/gift-cards/using-gift-cards-api#selling-square-gift-cards).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateGiftCardResponse createGiftCard(
            final CreateGiftCardRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateGiftCardRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateGiftCardResponse(context);
    }

    /**
     * Creates a digital gift card. You must activate the gift card before it can be used. For more
     * information, see [Selling gift
     * cards](https://developer.squareup.com/docs/gift-cards/using-gift-cards-api#selling-square-gift-cards).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardResponse response from the API call
     */
    public CompletableFuture<CreateGiftCardResponse> createGiftCardAsync(
            final CreateGiftCardRequest body) {
        return makeHttpCallAsync(() -> buildCreateGiftCardRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateGiftCardResponse(context));
    }

    /**
     * Builds the HttpRequest object for createGiftCard.
     */
    private HttpRequest buildCreateGiftCardRequest(
            final CreateGiftCardRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/gift-cards");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
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
     * Processes the response for createGiftCard.
     * @return An object of type CreateGiftCardResponse
     */
    private CreateGiftCardResponse handleCreateGiftCardResponse(
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
        CreateGiftCardResponse result = ApiHelper.deserialize(responseBody,
                CreateGiftCardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a gift card using the gift card account number (GAN).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromGANResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveGiftCardFromGANResponse retrieveGiftCardFromGAN(
            final RetrieveGiftCardFromGANRequest body) throws ApiException, IOException {
        HttpRequest request = buildRetrieveGiftCardFromGANRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveGiftCardFromGANResponse(context);
    }

    /**
     * Retrieves a gift card using the gift card account number (GAN).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromGANResponse response from the API call
     */
    public CompletableFuture<RetrieveGiftCardFromGANResponse> retrieveGiftCardFromGANAsync(
            final RetrieveGiftCardFromGANRequest body) {
        return makeHttpCallAsync(() -> buildRetrieveGiftCardFromGANRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveGiftCardFromGANResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveGiftCardFromGAN.
     */
    private HttpRequest buildRetrieveGiftCardFromGANRequest(
            final RetrieveGiftCardFromGANRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/gift-cards/from-gan");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
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
     * Processes the response for retrieveGiftCardFromGAN.
     * @return An object of type RetrieveGiftCardFromGANResponse
     */
    private RetrieveGiftCardFromGANResponse handleRetrieveGiftCardFromGANResponse(
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
        RetrieveGiftCardFromGANResponse result = ApiHelper.deserialize(responseBody,
                RetrieveGiftCardFromGANResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a gift card using a nonce (a secure token) that represents the gift card.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromNonceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveGiftCardFromNonceResponse retrieveGiftCardFromNonce(
            final RetrieveGiftCardFromNonceRequest body) throws ApiException, IOException {
        HttpRequest request = buildRetrieveGiftCardFromNonceRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveGiftCardFromNonceResponse(context);
    }

    /**
     * Retrieves a gift card using a nonce (a secure token) that represents the gift card.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromNonceResponse response from the API call
     */
    public CompletableFuture<RetrieveGiftCardFromNonceResponse> retrieveGiftCardFromNonceAsync(
            final RetrieveGiftCardFromNonceRequest body) {
        return makeHttpCallAsync(() -> buildRetrieveGiftCardFromNonceRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveGiftCardFromNonceResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveGiftCardFromNonce.
     */
    private HttpRequest buildRetrieveGiftCardFromNonceRequest(
            final RetrieveGiftCardFromNonceRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/gift-cards/from-nonce");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
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
     * Processes the response for retrieveGiftCardFromNonce.
     * @return An object of type RetrieveGiftCardFromNonceResponse
     */
    private RetrieveGiftCardFromNonceResponse handleRetrieveGiftCardFromNonceResponse(
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
        RetrieveGiftCardFromNonceResponse result = ApiHelper.deserialize(responseBody,
                RetrieveGiftCardFromNonceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Links a customer to a gift card.
     * @param  giftCardId  Required parameter: The ID of the gift card to link.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the LinkCustomerToGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public LinkCustomerToGiftCardResponse linkCustomerToGiftCard(
            final String giftCardId,
            final LinkCustomerToGiftCardRequest body) throws ApiException, IOException {
        HttpRequest request = buildLinkCustomerToGiftCardRequest(giftCardId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleLinkCustomerToGiftCardResponse(context);
    }

    /**
     * Links a customer to a gift card.
     * @param  giftCardId  Required parameter: The ID of the gift card to link.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the LinkCustomerToGiftCardResponse response from the API call
     */
    public CompletableFuture<LinkCustomerToGiftCardResponse> linkCustomerToGiftCardAsync(
            final String giftCardId,
            final LinkCustomerToGiftCardRequest body) {
        return makeHttpCallAsync(() -> buildLinkCustomerToGiftCardRequest(giftCardId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleLinkCustomerToGiftCardResponse(context));
    }

    /**
     * Builds the HttpRequest object for linkCustomerToGiftCard.
     */
    private HttpRequest buildLinkCustomerToGiftCardRequest(
            final String giftCardId,
            final LinkCustomerToGiftCardRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/gift-cards/{gift_card_id}/link-customer");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("gift_card_id",
                new SimpleEntry<Object, Boolean>(giftCardId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
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
     * Processes the response for linkCustomerToGiftCard.
     * @return An object of type LinkCustomerToGiftCardResponse
     */
    private LinkCustomerToGiftCardResponse handleLinkCustomerToGiftCardResponse(
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
        LinkCustomerToGiftCardResponse result = ApiHelper.deserialize(responseBody,
                LinkCustomerToGiftCardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Unlinks a customer from a gift card.
     * @param  giftCardId  Required parameter: Example:
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UnlinkCustomerFromGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UnlinkCustomerFromGiftCardResponse unlinkCustomerFromGiftCard(
            final String giftCardId,
            final UnlinkCustomerFromGiftCardRequest body) throws ApiException, IOException {
        HttpRequest request = buildUnlinkCustomerFromGiftCardRequest(giftCardId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUnlinkCustomerFromGiftCardResponse(context);
    }

    /**
     * Unlinks a customer from a gift card.
     * @param  giftCardId  Required parameter: Example:
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UnlinkCustomerFromGiftCardResponse response from the API call
     */
    public CompletableFuture<UnlinkCustomerFromGiftCardResponse> unlinkCustomerFromGiftCardAsync(
            final String giftCardId,
            final UnlinkCustomerFromGiftCardRequest body) {
        return makeHttpCallAsync(() -> buildUnlinkCustomerFromGiftCardRequest(giftCardId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUnlinkCustomerFromGiftCardResponse(context));
    }

    /**
     * Builds the HttpRequest object for unlinkCustomerFromGiftCard.
     */
    private HttpRequest buildUnlinkCustomerFromGiftCardRequest(
            final String giftCardId,
            final UnlinkCustomerFromGiftCardRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/gift-cards/{gift_card_id}/unlink-customer");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("gift_card_id",
                new SimpleEntry<Object, Boolean>(giftCardId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
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
     * Processes the response for unlinkCustomerFromGiftCard.
     * @return An object of type UnlinkCustomerFromGiftCardResponse
     */
    private UnlinkCustomerFromGiftCardResponse handleUnlinkCustomerFromGiftCardResponse(
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
        UnlinkCustomerFromGiftCardResponse result = ApiHelper.deserialize(responseBody,
                UnlinkCustomerFromGiftCardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a gift card using its ID.
     * @param  id  Required parameter: The ID of the gift card to retrieve.
     * @return    Returns the RetrieveGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveGiftCardResponse retrieveGiftCard(
            final String id) throws ApiException, IOException {
        HttpRequest request = buildRetrieveGiftCardRequest(id);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveGiftCardResponse(context);
    }

    /**
     * Retrieves a gift card using its ID.
     * @param  id  Required parameter: The ID of the gift card to retrieve.
     * @return    Returns the RetrieveGiftCardResponse response from the API call
     */
    public CompletableFuture<RetrieveGiftCardResponse> retrieveGiftCardAsync(
            final String id) {
        return makeHttpCallAsync(() -> buildRetrieveGiftCardRequest(id),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveGiftCardResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveGiftCard.
     */
    private HttpRequest buildRetrieveGiftCardRequest(
            final String id) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/gift-cards/{id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("id",
                new SimpleEntry<Object, Boolean>(id, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

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
     * Processes the response for retrieveGiftCard.
     * @return An object of type RetrieveGiftCardResponse
     */
    private RetrieveGiftCardResponse handleRetrieveGiftCardResponse(
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
        RetrieveGiftCardResponse result = ApiHelper.deserialize(responseBody,
                RetrieveGiftCardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}