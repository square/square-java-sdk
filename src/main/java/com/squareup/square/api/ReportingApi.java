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
import com.squareup.square.models.ListAdditionalRecipientReceivableRefundsResponse;
import com.squareup.square.models.ListAdditionalRecipientReceivablesResponse;

/**
 * This class lists all the endpoints of the groups.
 */
public final class ReportingApi extends BaseApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public ReportingApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
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
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListAdditionalRecipientReceivableRefundsRequest(locationId, beginTime, endTime, sortOrder, cursor);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListAdditionalRecipientReceivableRefundsResponse(context);
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
            final String cursor) {
        return makeHttpCallAsync(() -> buildListAdditionalRecipientReceivableRefundsRequest(locationId, beginTime, endTime, sortOrder, cursor),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListAdditionalRecipientReceivableRefundsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listAdditionalRecipientReceivableRefunds
     */
    private HttpRequest buildListAdditionalRecipientReceivableRefundsRequest(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/locations/{location_id}/additional-recipient-receivable-refunds");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("sort_order", sortOrder);
        queryParameters.put("cursor", cursor);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-03-25");
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
     * Processes the response for listAdditionalRecipientReceivableRefunds
     * @return An object of type ListAdditionalRecipientReceivableRefundsResponse
     */
    private ListAdditionalRecipientReceivableRefundsResponse handleListAdditionalRecipientReceivableRefundsResponse(HttpContext context)
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
        ListAdditionalRecipientReceivableRefundsResponse result = ApiHelper.deserialize(responseBody,
                ListAdditionalRecipientReceivableRefundsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListAdditionalRecipientReceivablesRequest(locationId, beginTime, endTime, sortOrder, cursor);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListAdditionalRecipientReceivablesResponse(context);
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
            final String cursor) {
        return makeHttpCallAsync(() -> buildListAdditionalRecipientReceivablesRequest(locationId, beginTime, endTime, sortOrder, cursor),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListAdditionalRecipientReceivablesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listAdditionalRecipientReceivables
     */
    private HttpRequest buildListAdditionalRecipientReceivablesRequest(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v2/locations/{location_id}/additional-recipient-receivables");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("sort_order", sortOrder);
        queryParameters.put("cursor", cursor);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-03-25");
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
     * Processes the response for listAdditionalRecipientReceivables
     * @return An object of type ListAdditionalRecipientReceivablesResponse
     */
    private ListAdditionalRecipientReceivablesResponse handleListAdditionalRecipientReceivablesResponse(HttpContext context)
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
        ListAdditionalRecipientReceivablesResponse result = ApiHelper.deserialize(responseBody,
                ListAdditionalRecipientReceivablesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}