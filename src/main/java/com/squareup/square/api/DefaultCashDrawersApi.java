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
import com.squareup.square.models.ListCashDrawerShiftEventsResponse;
import com.squareup.square.models.ListCashDrawerShiftsResponse;
import com.squareup.square.models.RetrieveCashDrawerShiftResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCashDrawersApi extends BaseApi implements CashDrawersApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultCashDrawersApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultCashDrawersApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Provides the details for all of the cash drawer shifts for a location
     * in a date range.
     * @param    locationId    Required parameter: The ID of the location to query for a list of cash drawer shifts.
     * @param    sortOrder    Optional parameter: The order in which cash drawer shifts are listed in the response, based on their opened_at field. Default value: ASC
     * @param    beginTime    Optional parameter: The inclusive start time of the query on opened_at, in ISO 8601 format.
     * @param    endTime    Optional parameter: The exclusive end date of the query on opened_at, in ISO 8601 format.
     * @param    limit    Optional parameter: Number of cash drawer shift events in a page of results (200 by default, 1000 max).
     * @param    cursor    Optional parameter: Opaque cursor for fetching the next page of results.
     * @return    Returns the ListCashDrawerShiftsResponse response from the API call
     */
    public ListCashDrawerShiftsResponse listCashDrawerShifts(
            final String locationId,
            final String sortOrder,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListCashDrawerShiftsRequest(locationId, sortOrder, beginTime, endTime, limit, cursor);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListCashDrawerShiftsResponse(context);
    }

    /**
     * Provides the details for all of the cash drawer shifts for a location
     * in a date range.
     * @param    locationId    Required parameter: The ID of the location to query for a list of cash drawer shifts.
     * @param    sortOrder    Optional parameter: The order in which cash drawer shifts are listed in the response, based on their opened_at field. Default value: ASC
     * @param    beginTime    Optional parameter: The inclusive start time of the query on opened_at, in ISO 8601 format.
     * @param    endTime    Optional parameter: The exclusive end date of the query on opened_at, in ISO 8601 format.
     * @param    limit    Optional parameter: Number of cash drawer shift events in a page of results (200 by default, 1000 max).
     * @param    cursor    Optional parameter: Opaque cursor for fetching the next page of results.
     * @return    Returns the ListCashDrawerShiftsResponse response from the API call 
     */
    public CompletableFuture<ListCashDrawerShiftsResponse> listCashDrawerShiftsAsync(
            final String locationId,
            final String sortOrder,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor) {
        return makeHttpCallAsync(() -> buildListCashDrawerShiftsRequest(locationId, sortOrder, beginTime, endTime, limit, cursor),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListCashDrawerShiftsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCashDrawerShifts
     */
    private HttpRequest buildListCashDrawerShiftsRequest(
            final String locationId,
            final String sortOrder,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/cash-drawers/shifts");

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("location_id", locationId);
        queryParameters.put("sort_order", sortOrder);
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("limit", limit);
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
     * Processes the response for listCashDrawerShifts
     * @return An object of type ListCashDrawerShiftsResponse
     */
    private ListCashDrawerShiftsResponse handleListCashDrawerShiftsResponse(HttpContext context)
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
        ListCashDrawerShiftsResponse result = ApiHelper.deserialize(responseBody,
                ListCashDrawerShiftsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides the summary details for a single cash drawer shift. See
     * RetrieveCashDrawerShiftEvents for a list of cash drawer shift events.
     * @param    locationId    Required parameter: The ID of the location to retrieve cash drawer shifts from.
     * @param    shiftId    Required parameter: The shift ID.
     * @return    Returns the RetrieveCashDrawerShiftResponse response from the API call
     */
    public RetrieveCashDrawerShiftResponse retrieveCashDrawerShift(
            final String locationId,
            final String shiftId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveCashDrawerShiftRequest(locationId, shiftId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveCashDrawerShiftResponse(context);
    }

    /**
     * Provides the summary details for a single cash drawer shift. See
     * RetrieveCashDrawerShiftEvents for a list of cash drawer shift events.
     * @param    locationId    Required parameter: The ID of the location to retrieve cash drawer shifts from.
     * @param    shiftId    Required parameter: The shift ID.
     * @return    Returns the RetrieveCashDrawerShiftResponse response from the API call 
     */
    public CompletableFuture<RetrieveCashDrawerShiftResponse> retrieveCashDrawerShiftAsync(
            final String locationId,
            final String shiftId) {
        return makeHttpCallAsync(() -> buildRetrieveCashDrawerShiftRequest(locationId, shiftId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveCashDrawerShiftResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveCashDrawerShift
     */
    private HttpRequest buildRetrieveCashDrawerShiftRequest(
            final String locationId,
            final String shiftId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/cash-drawers/shifts/{shift_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("shift_id", shiftId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("location_id", locationId);
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
     * Processes the response for retrieveCashDrawerShift
     * @return An object of type RetrieveCashDrawerShiftResponse
     */
    private RetrieveCashDrawerShiftResponse handleRetrieveCashDrawerShiftResponse(HttpContext context)
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
        RetrieveCashDrawerShiftResponse result = ApiHelper.deserialize(responseBody,
                RetrieveCashDrawerShiftResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides a paginated list of events for a single cash drawer shift.
     * @param    locationId    Required parameter: The ID of the location to list cash drawer shifts for.
     * @param    shiftId    Required parameter: The shift ID.
     * @param    limit    Optional parameter: Number of resources to be returned in a page of results (200 by default, 1000 max).
     * @param    cursor    Optional parameter: Opaque cursor for fetching the next page of results.
     * @return    Returns the ListCashDrawerShiftEventsResponse response from the API call
     */
    public ListCashDrawerShiftEventsResponse listCashDrawerShiftEvents(
            final String locationId,
            final String shiftId,
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListCashDrawerShiftEventsRequest(locationId, shiftId, limit, cursor);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListCashDrawerShiftEventsResponse(context);
    }

    /**
     * Provides a paginated list of events for a single cash drawer shift.
     * @param    locationId    Required parameter: The ID of the location to list cash drawer shifts for.
     * @param    shiftId    Required parameter: The shift ID.
     * @param    limit    Optional parameter: Number of resources to be returned in a page of results (200 by default, 1000 max).
     * @param    cursor    Optional parameter: Opaque cursor for fetching the next page of results.
     * @return    Returns the ListCashDrawerShiftEventsResponse response from the API call 
     */
    public CompletableFuture<ListCashDrawerShiftEventsResponse> listCashDrawerShiftEventsAsync(
            final String locationId,
            final String shiftId,
            final Integer limit,
            final String cursor) {
        return makeHttpCallAsync(() -> buildListCashDrawerShiftEventsRequest(locationId, shiftId, limit, cursor),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListCashDrawerShiftEventsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCashDrawerShiftEvents
     */
    private HttpRequest buildListCashDrawerShiftEventsRequest(
            final String locationId,
            final String shiftId,
            final Integer limit,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/cash-drawers/shifts/{shift_id}/events");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("shift_id", shiftId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("location_id", locationId);
        queryParameters.put("limit", limit);
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
     * Processes the response for listCashDrawerShiftEvents
     * @return An object of type ListCashDrawerShiftEventsResponse
     */
    private ListCashDrawerShiftEventsResponse handleListCashDrawerShiftEventsResponse(HttpContext context)
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
        ListCashDrawerShiftEventsResponse result = ApiHelper.deserialize(responseBody,
                ListCashDrawerShiftEventsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}