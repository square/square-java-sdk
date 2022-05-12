
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
import com.squareup.square.models.CreateGiftCardActivityRequest;
import com.squareup.square.models.CreateGiftCardActivityResponse;
import com.squareup.square.models.ListGiftCardActivitiesResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultGiftCardActivitiesApi extends BaseApi implements GiftCardActivitiesApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultGiftCardActivitiesApi(Configuration config, HttpClient httpClient,
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
    public DefaultGiftCardActivitiesApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists gift card activities. By default, you get gift card activities for all gift cards in
     * the seller's account. You can optionally specify query parameters to filter the list. For
     * example, you can get a list of gift card activities for a gift card, for all gift cards in a
     * specific region, or for activities within a time window.
     * @param  giftCardId  Optional parameter: If a gift card ID is provided, the endpoint returns
     *         activities related to the specified gift card. Otherwise, the endpoint returns all
     *         gift card activities for the seller.
     * @param  type  Optional parameter: If a [type]($m/GiftCardActivityType) is provided, the
     *         endpoint returns gift card activities of the specified type. Otherwise, the endpoint
     *         returns all types of gift card activities.
     * @param  locationId  Optional parameter: If a location ID is provided, the endpoint returns
     *         gift card activities for the specified location. Otherwise, the endpoint returns gift
     *         card activities for all locations.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the reporting
     *         period, in RFC 3339 format. This start time is inclusive. The default value is the
     *         current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the reporting period, in
     *         RFC 3339 format. This end time is inclusive. The default value is the current time.
     * @param  limit  Optional parameter: If a limit is provided, the endpoint returns the specified
     *         number of results (or fewer) per page. The maximum value is 100. The default value is
     *         50. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  sortOrder  Optional parameter: The order in which the endpoint returns the
     *         activities, based on `created_at`. - `ASC` - Oldest to newest. - `DESC` - Newest to
     *         oldest (default).
     * @return    Returns the ListGiftCardActivitiesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListGiftCardActivitiesResponse listGiftCardActivities(
            final String giftCardId,
            final String type,
            final String locationId,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor,
            final String sortOrder) throws ApiException, IOException {
        HttpRequest request = buildListGiftCardActivitiesRequest(giftCardId, type, locationId,
                beginTime, endTime, limit, cursor, sortOrder);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListGiftCardActivitiesResponse(context);
    }

    /**
     * Lists gift card activities. By default, you get gift card activities for all gift cards in
     * the seller's account. You can optionally specify query parameters to filter the list. For
     * example, you can get a list of gift card activities for a gift card, for all gift cards in a
     * specific region, or for activities within a time window.
     * @param  giftCardId  Optional parameter: If a gift card ID is provided, the endpoint returns
     *         activities related to the specified gift card. Otherwise, the endpoint returns all
     *         gift card activities for the seller.
     * @param  type  Optional parameter: If a [type]($m/GiftCardActivityType) is provided, the
     *         endpoint returns gift card activities of the specified type. Otherwise, the endpoint
     *         returns all types of gift card activities.
     * @param  locationId  Optional parameter: If a location ID is provided, the endpoint returns
     *         gift card activities for the specified location. Otherwise, the endpoint returns gift
     *         card activities for all locations.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the reporting
     *         period, in RFC 3339 format. This start time is inclusive. The default value is the
     *         current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the reporting period, in
     *         RFC 3339 format. This end time is inclusive. The default value is the current time.
     * @param  limit  Optional parameter: If a limit is provided, the endpoint returns the specified
     *         number of results (or fewer) per page. The maximum value is 100. The default value is
     *         50. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  sortOrder  Optional parameter: The order in which the endpoint returns the
     *         activities, based on `created_at`. - `ASC` - Oldest to newest. - `DESC` - Newest to
     *         oldest (default).
     * @return    Returns the ListGiftCardActivitiesResponse response from the API call
     */
    public CompletableFuture<ListGiftCardActivitiesResponse> listGiftCardActivitiesAsync(
            final String giftCardId,
            final String type,
            final String locationId,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor,
            final String sortOrder) {
        return makeHttpCallAsync(() -> buildListGiftCardActivitiesRequest(giftCardId, type,
                locationId, beginTime, endTime, limit, cursor, sortOrder),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListGiftCardActivitiesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listGiftCardActivities.
     */
    private HttpRequest buildListGiftCardActivitiesRequest(
            final String giftCardId,
            final String type,
            final String locationId,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor,
            final String sortOrder) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/gift-cards/activities");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("gift_card_id", giftCardId);
        queryParameters.put("type", type);
        queryParameters.put("location_id", locationId);
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);
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
     * Processes the response for listGiftCardActivities.
     * @return An object of type ListGiftCardActivitiesResponse
     */
    private ListGiftCardActivitiesResponse handleListGiftCardActivitiesResponse(
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
        ListGiftCardActivitiesResponse result = ApiHelper.deserialize(responseBody,
                ListGiftCardActivitiesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a gift card activity to manage the balance or state of a [gift card]($m/GiftCard).
     * For example, you create an `ACTIVATE` activity to activate a gift card with an initial
     * balance before the gift card can be used.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardActivityResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateGiftCardActivityResponse createGiftCardActivity(
            final CreateGiftCardActivityRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateGiftCardActivityRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateGiftCardActivityResponse(context);
    }

    /**
     * Creates a gift card activity to manage the balance or state of a [gift card]($m/GiftCard).
     * For example, you create an `ACTIVATE` activity to activate a gift card with an initial
     * balance before the gift card can be used.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardActivityResponse response from the API call
     */
    public CompletableFuture<CreateGiftCardActivityResponse> createGiftCardActivityAsync(
            final CreateGiftCardActivityRequest body) {
        return makeHttpCallAsync(() -> buildCreateGiftCardActivityRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateGiftCardActivityResponse(context));
    }

    /**
     * Builds the HttpRequest object for createGiftCardActivity.
     */
    private HttpRequest buildCreateGiftCardActivityRequest(
            final CreateGiftCardActivityRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/gift-cards/activities");

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
     * Processes the response for createGiftCardActivity.
     * @return An object of type CreateGiftCardActivityResponse
     */
    private CreateGiftCardActivityResponse handleCreateGiftCardActivityResponse(
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
        CreateGiftCardActivityResponse result = ApiHelper.deserialize(responseBody,
                CreateGiftCardActivityResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}