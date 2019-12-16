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

public final class ReportingApi extends BaseApi {
    public ReportingApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public ReportingApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Returns a list of refunded transactions (across all possible originating locations) relating to monies
     * credited to the provided location ID by another Square account using the `additional_recipients` field in a transaction.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list AdditionalRecipientReceivableRefunds for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListAdditionalRecipientReceivableRefundsResponse response from the API call
     */
    @Deprecated
    public ListAdditionalRecipientReceivableRefundsResponse listAdditionalRecipientReceivableRefunds(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListAdditionalRecipientReceivableRefundsRequest(locationId, beginTime, endTime, sortOrder, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListAdditionalRecipientReceivableRefundsResponse(_context);
    }

    /**
     * Returns a list of refunded transactions (across all possible originating locations) relating to monies
     * credited to the provided location ID by another Square account using the `additional_recipients` field in a transaction.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list AdditionalRecipientReceivableRefunds for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListAdditionalRecipientReceivableRefundsResponse response from the API call 
     */
    @Deprecated
    public CompletableFuture<ListAdditionalRecipientReceivableRefundsResponse> listAdditionalRecipientReceivableRefundsAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildListAdditionalRecipientReceivableRefundsRequest(locationId, beginTime, endTime, sortOrder, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListAdditionalRecipientReceivableRefundsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listAdditionalRecipientReceivableRefunds
     */
    private HttpRequest _buildListAdditionalRecipientReceivableRefundsRequest(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/additional-recipient-receivable-refunds");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
        _queryParameters.put("sort_order", sortOrder);
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
     * Processes the response for listAdditionalRecipientReceivableRefunds
     * @return An object of type ListAdditionalRecipientReceivableRefundsResponse
     */
    private ListAdditionalRecipientReceivableRefundsResponse _handleListAdditionalRecipientReceivableRefundsResponse(HttpContext _context)
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
        ListAdditionalRecipientReceivableRefundsResponse _result = ApiHelper.deserialize(_responseBody,
                ListAdditionalRecipientReceivableRefundsResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns a list of receivables (across all possible sending locations) representing monies credited
     * to the provided location ID by another Square account using the `additional_recipients` field in a transaction.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list AdditionalRecipientReceivables for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListAdditionalRecipientReceivablesResponse response from the API call
     */
    @Deprecated
    public ListAdditionalRecipientReceivablesResponse listAdditionalRecipientReceivables(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListAdditionalRecipientReceivablesRequest(locationId, beginTime, endTime, sortOrder, cursor);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListAdditionalRecipientReceivablesResponse(_context);
    }

    /**
     * Returns a list of receivables (across all possible sending locations) representing monies credited
     * to the provided location ID by another Square account using the `additional_recipients` field in a transaction.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list AdditionalRecipientReceivables for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListAdditionalRecipientReceivablesResponse response from the API call 
     */
    @Deprecated
    public CompletableFuture<ListAdditionalRecipientReceivablesResponse> listAdditionalRecipientReceivablesAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) {
        return makeHttpCallAsync(() -> _buildListAdditionalRecipientReceivablesRequest(locationId, beginTime, endTime, sortOrder, cursor),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListAdditionalRecipientReceivablesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listAdditionalRecipientReceivables
     */
    private HttpRequest _buildListAdditionalRecipientReceivablesRequest(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/additional-recipient-receivables");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("begin_time", beginTime);
        _queryParameters.put("end_time", endTime);
        _queryParameters.put("sort_order", sortOrder);
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
     * Processes the response for listAdditionalRecipientReceivables
     * @return An object of type ListAdditionalRecipientReceivablesResponse
     */
    private ListAdditionalRecipientReceivablesResponse _handleListAdditionalRecipientReceivablesResponse(HttpContext _context)
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
        ListAdditionalRecipientReceivablesResponse _result = ApiHelper.deserialize(_responseBody,
                ListAdditionalRecipientReceivablesResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
