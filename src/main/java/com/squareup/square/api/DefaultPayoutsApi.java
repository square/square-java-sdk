
package com.squareup.square.api;

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
import com.squareup.square.models.GetPayoutResponse;
import com.squareup.square.models.ListPayoutEntriesResponse;
import com.squareup.square.models.ListPayoutsResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultPayoutsApi extends BaseApi implements PayoutsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultPayoutsApi(Configuration config, HttpClient httpClient,
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
    public DefaultPayoutsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Retrieves a list of all payouts for the default location. You can filter payouts by location
     * ID, status, time range, and order them in ascending or descending order. To call this
     * endpoint, set `PAYOUTS_READ` for the OAuth scope.
     * @param  locationId  Optional parameter: The ID of the location for which to list the payouts.
     *         By default, payouts are returned for the default (main) location associated with the
     *         seller.
     * @param  status  Optional parameter: If provided, only payouts with the given status are
     *         returned.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the payout creation
     *         time, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the payout creation time,
     *         in RFC 3339 format. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which payouts are listed.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). If
     *         request parameters change between requests, subsequent results may contain duplicates
     *         or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListPayoutsResponse listPayouts(
            final String locationId,
            final String status,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        HttpRequest request = buildListPayoutsRequest(locationId, status, beginTime, endTime,
                sortOrder, cursor, limit);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListPayoutsResponse(context);
    }

    /**
     * Retrieves a list of all payouts for the default location. You can filter payouts by location
     * ID, status, time range, and order them in ascending or descending order. To call this
     * endpoint, set `PAYOUTS_READ` for the OAuth scope.
     * @param  locationId  Optional parameter: The ID of the location for which to list the payouts.
     *         By default, payouts are returned for the default (main) location associated with the
     *         seller.
     * @param  status  Optional parameter: If provided, only payouts with the given status are
     *         returned.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the payout creation
     *         time, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the payout creation time,
     *         in RFC 3339 format. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which payouts are listed.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). If
     *         request parameters change between requests, subsequent results may contain duplicates
     *         or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutsResponse response from the API call
     */
    public CompletableFuture<ListPayoutsResponse> listPayoutsAsync(
            final String locationId,
            final String status,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final Integer limit) {
        return makeHttpCallAsync(() -> buildListPayoutsRequest(locationId, status, beginTime,
                endTime, sortOrder, cursor, limit),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListPayoutsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listPayouts.
     */
    private HttpRequest buildListPayoutsRequest(
            final String locationId,
            final String status,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final Integer limit) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/payouts");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("location_id", locationId);
        queryParameters.put("status", status);
        queryParameters.put("begin_time", beginTime);
        queryParameters.put("end_time", endTime);
        queryParameters.put("sort_order", sortOrder);
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
     * Processes the response for listPayouts.
     * @return An object of type ListPayoutsResponse
     */
    private ListPayoutsResponse handleListPayoutsResponse(
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
        ListPayoutsResponse result = ApiHelper.deserialize(responseBody,
                ListPayoutsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves details of a specific payout identified by a payout ID. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @return    Returns the GetPayoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetPayoutResponse getPayout(
            final String payoutId) throws ApiException, IOException {
        HttpRequest request = buildGetPayoutRequest(payoutId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleGetPayoutResponse(context);
    }

    /**
     * Retrieves details of a specific payout identified by a payout ID. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @return    Returns the GetPayoutResponse response from the API call
     */
    public CompletableFuture<GetPayoutResponse> getPayoutAsync(
            final String payoutId) {
        return makeHttpCallAsync(() -> buildGetPayoutRequest(payoutId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleGetPayoutResponse(context));
    }

    /**
     * Builds the HttpRequest object for getPayout.
     */
    private HttpRequest buildGetPayoutRequest(
            final String payoutId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/payouts/{payout_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("payout_id",
                new SimpleEntry<Object, Boolean>(payoutId, true));
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
     * Processes the response for getPayout.
     * @return An object of type GetPayoutResponse
     */
    private GetPayoutResponse handleGetPayoutResponse(
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
        GetPayoutResponse result = ApiHelper.deserialize(responseBody,
                GetPayoutResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a list of all payout entries for a specific payout. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @param  sortOrder  Optional parameter: The order in which payout entries are listed.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). If
     *         request parameters change between requests, subsequent results may contain duplicates
     *         or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutEntriesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListPayoutEntriesResponse listPayoutEntries(
            final String payoutId,
            final String sortOrder,
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        HttpRequest request = buildListPayoutEntriesRequest(payoutId, sortOrder, cursor, limit);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListPayoutEntriesResponse(context);
    }

    /**
     * Retrieves a list of all payout entries for a specific payout. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @param  sortOrder  Optional parameter: The order in which payout entries are listed.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). If
     *         request parameters change between requests, subsequent results may contain duplicates
     *         or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutEntriesResponse response from the API call
     */
    public CompletableFuture<ListPayoutEntriesResponse> listPayoutEntriesAsync(
            final String payoutId,
            final String sortOrder,
            final String cursor,
            final Integer limit) {
        return makeHttpCallAsync(() -> buildListPayoutEntriesRequest(payoutId, sortOrder, cursor,
                limit),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListPayoutEntriesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listPayoutEntries.
     */
    private HttpRequest buildListPayoutEntriesRequest(
            final String payoutId,
            final String sortOrder,
            final String cursor,
            final Integer limit) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/payouts/{payout_id}/payout-entries");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("payout_id",
                new SimpleEntry<Object, Boolean>(payoutId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("sort_order", sortOrder);
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
     * Processes the response for listPayoutEntries.
     * @return An object of type ListPayoutEntriesResponse
     */
    private ListPayoutEntriesResponse handleListPayoutEntriesResponse(
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
        ListPayoutEntriesResponse result = ApiHelper.deserialize(responseBody,
                ListPayoutEntriesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}