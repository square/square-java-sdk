package com.squareup.square.api;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import com.squareup.square.*;
import com.squareup.square.exceptions.*;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.Headers;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.*;

public final class CashDrawersApi extends BaseApi {
    public CashDrawersApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public CashDrawersApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
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
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListCashDrawerShiftsRequest(locationId, sortOrder, beginTime, endTime, limit, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListCashDrawerShiftsResponse(_context);
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
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildListCashDrawerShiftsRequest(locationId, sortOrder, beginTime, endTime, limit, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListCashDrawerShiftsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listCashDrawerShifts
     */
    private HttpRequest _buildListCashDrawerShiftsRequest(
            final String locationId,
            final String sortOrder,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/cash-drawers/shifts");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("location_id", locationId);
        _queryParameters.put("sort_order", sortOrder);
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
        _queryParameters.put("limit", limit);
        _queryParameters.put("cursor", cursor);
        ApiHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for listCashDrawerShifts
     * @return An object of type ListCashDrawerShiftsResponse
     */
    private ListCashDrawerShiftsResponse _handleListCashDrawerShiftsResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        ListCashDrawerShiftsResponse _result = ApiHelper.deserialize(_responseBody,
                ListCashDrawerShiftsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
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
            final String shiftId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveCashDrawerShiftRequest(locationId, shiftId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveCashDrawerShiftResponse(_context);
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
            final String shiftId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveCashDrawerShiftRequest(locationId, shiftId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveCashDrawerShiftResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveCashDrawerShift
     */
    private HttpRequest _buildRetrieveCashDrawerShiftRequest(
            final String locationId,
            final String shiftId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/cash-drawers/shifts/{shift_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("shift_id", shiftId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for retrieveCashDrawerShift
     * @return An object of type RetrieveCashDrawerShiftResponse
     */
    private RetrieveCashDrawerShiftResponse _handleRetrieveCashDrawerShiftResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        RetrieveCashDrawerShiftResponse _result = ApiHelper.deserialize(_responseBody,
                RetrieveCashDrawerShiftResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
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
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListCashDrawerShiftEventsRequest(locationId, shiftId, limit, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListCashDrawerShiftEventsResponse(_context);
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
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildListCashDrawerShiftEventsRequest(locationId, shiftId, limit, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListCashDrawerShiftEventsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listCashDrawerShiftEvents
     */
    private HttpRequest _buildListCashDrawerShiftEventsRequest(
            final String locationId,
            final String shiftId,
            final Integer limit,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/cash-drawers/shifts/{shift_id}/events");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("shift_id", shiftId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("location_id", locationId);
        _queryParameters.put("limit", limit);
        _queryParameters.put("cursor", cursor);
        ApiHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for listCashDrawerShiftEvents
     * @return An object of type ListCashDrawerShiftEventsResponse
     */
    private ListCashDrawerShiftEventsResponse _handleListCashDrawerShiftEventsResponse(HttpContext _context)
            throws ApiException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        ListCashDrawerShiftEventsResponse _result = ApiHelper.deserialize(_responseBody,
                ListCashDrawerShiftEventsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}