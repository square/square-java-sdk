
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
import com.squareup.square.models.CreateCardRequest;
import com.squareup.square.models.CreateCardResponse;
import com.squareup.square.models.DisableCardResponse;
import com.squareup.square.models.ListCardsResponse;
import com.squareup.square.models.RetrieveCardResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCardsApi extends BaseApi implements CardsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultCardsApi(Configuration config, HttpClient httpClient,
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
    public DefaultCardsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Retrieves a list of cards owned by the account making the request. A max of 25 cards will be
     * returned.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for
     *         more information.
     * @param  customerId  Optional parameter: Limit results to cards associated with the customer
     *         supplied. By default, all cards owned by the merchant are returned.
     * @param  includeDisabled  Optional parameter: Includes disabled cards. By default, all enabled
     *         cards owned by the merchant are returned.
     * @param  referenceId  Optional parameter: Limit results to cards associated with the
     *         reference_id supplied.
     * @param  sortOrder  Optional parameter: Sorts the returned list by when the card was created
     *         with the specified order. This field defaults to ASC.
     * @return    Returns the ListCardsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCardsResponse listCards(
            final String cursor,
            final String customerId,
            final Boolean includeDisabled,
            final String referenceId,
            final String sortOrder) throws ApiException, IOException {
        HttpRequest request = buildListCardsRequest(cursor, customerId, includeDisabled,
                referenceId, sortOrder);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListCardsResponse(context);
    }

    /**
     * Retrieves a list of cards owned by the account making the request. A max of 25 cards will be
     * returned.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for
     *         more information.
     * @param  customerId  Optional parameter: Limit results to cards associated with the customer
     *         supplied. By default, all cards owned by the merchant are returned.
     * @param  includeDisabled  Optional parameter: Includes disabled cards. By default, all enabled
     *         cards owned by the merchant are returned.
     * @param  referenceId  Optional parameter: Limit results to cards associated with the
     *         reference_id supplied.
     * @param  sortOrder  Optional parameter: Sorts the returned list by when the card was created
     *         with the specified order. This field defaults to ASC.
     * @return    Returns the ListCardsResponse response from the API call
     */
    public CompletableFuture<ListCardsResponse> listCardsAsync(
            final String cursor,
            final String customerId,
            final Boolean includeDisabled,
            final String referenceId,
            final String sortOrder) {
        return makeHttpCallAsync(() -> buildListCardsRequest(cursor, customerId, includeDisabled,
                referenceId, sortOrder),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListCardsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCards.
     */
    private HttpRequest buildListCardsRequest(
            final String cursor,
            final String customerId,
            final Boolean includeDisabled,
            final String referenceId,
            final String sortOrder) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/cards");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
        queryParameters.put("customer_id", customerId);
        queryParameters.put("include_disabled",
                (includeDisabled != null) ? includeDisabled : false);
        queryParameters.put("reference_id", referenceId);
        queryParameters.put("sort_order", sortOrder);

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
     * Processes the response for listCards.
     * @return An object of type ListCardsResponse
     */
    private ListCardsResponse handleListCardsResponse(
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
        ListCardsResponse result = ApiHelper.deserialize(responseBody,
                ListCardsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Adds a card on file to an existing merchant.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateCardResponse createCard(
            final CreateCardRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateCardRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateCardResponse(context);
    }

    /**
     * Adds a card on file to an existing merchant.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCardResponse response from the API call
     */
    public CompletableFuture<CreateCardResponse> createCardAsync(
            final CreateCardRequest body) {
        return makeHttpCallAsync(() -> buildCreateCardRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateCardResponse(context));
    }

    /**
     * Builds the HttpRequest object for createCard.
     */
    private HttpRequest buildCreateCardRequest(
            final CreateCardRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/cards");

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
     * Processes the response for createCard.
     * @return An object of type CreateCardResponse
     */
    private CreateCardResponse handleCreateCardResponse(
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
        CreateCardResponse result = ApiHelper.deserialize(responseBody,
                CreateCardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves details for a specific Card.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the RetrieveCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCardResponse retrieveCard(
            final String cardId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveCardRequest(cardId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveCardResponse(context);
    }

    /**
     * Retrieves details for a specific Card.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the RetrieveCardResponse response from the API call
     */
    public CompletableFuture<RetrieveCardResponse> retrieveCardAsync(
            final String cardId) {
        return makeHttpCallAsync(() -> buildRetrieveCardRequest(cardId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveCardResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveCard.
     */
    private HttpRequest buildRetrieveCardRequest(
            final String cardId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/cards/{card_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("card_id",
                new SimpleEntry<Object, Boolean>(cardId, true));
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
     * Processes the response for retrieveCard.
     * @return An object of type RetrieveCardResponse
     */
    private RetrieveCardResponse handleRetrieveCardResponse(
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
        RetrieveCardResponse result = ApiHelper.deserialize(responseBody,
                RetrieveCardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Disables the card, preventing any further updates or charges. Disabling an already disabled
     * card is allowed but has no effect.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the DisableCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DisableCardResponse disableCard(
            final String cardId) throws ApiException, IOException {
        HttpRequest request = buildDisableCardRequest(cardId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDisableCardResponse(context);
    }

    /**
     * Disables the card, preventing any further updates or charges. Disabling an already disabled
     * card is allowed but has no effect.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the DisableCardResponse response from the API call
     */
    public CompletableFuture<DisableCardResponse> disableCardAsync(
            final String cardId) {
        return makeHttpCallAsync(() -> buildDisableCardRequest(cardId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDisableCardResponse(context));
    }

    /**
     * Builds the HttpRequest object for disableCard.
     */
    private HttpRequest buildDisableCardRequest(
            final String cardId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/cards/{card_id}/disable");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("card_id",
                new SimpleEntry<Object, Boolean>(cardId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().post(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for disableCard.
     * @return An object of type DisableCardResponse
     */
    private DisableCardResponse handleDisableCardResponse(
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
        DisableCardResponse result = ApiHelper.deserialize(responseBody,
                DisableCardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}