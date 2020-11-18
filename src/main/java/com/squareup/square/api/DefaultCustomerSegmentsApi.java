
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
import com.squareup.square.models.ListCustomerSegmentsResponse;
import com.squareup.square.models.RetrieveCustomerSegmentResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCustomerSegmentsApi extends BaseApi implements CustomerSegmentsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultCustomerSegmentsApi(Configuration config, HttpClient httpClient,
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
    public DefaultCustomerSegmentsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Retrieves the list of customer segments of a business.
     * @param  cursor  Optional parameter: A pagination cursor returned by previous calls to
     *         __ListCustomerSegments__. Used to retrieve the next set of query results. See the
     *         [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination)
     *         for more information.
     * @return    Returns the ListCustomerSegmentsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCustomerSegmentsResponse listCustomerSegments(
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListCustomerSegmentsRequest(cursor);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListCustomerSegmentsResponse(context);
    }

    /**
     * Retrieves the list of customer segments of a business.
     * @param  cursor  Optional parameter: A pagination cursor returned by previous calls to
     *         __ListCustomerSegments__. Used to retrieve the next set of query results. See the
     *         [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination)
     *         for more information.
     * @return    Returns the ListCustomerSegmentsResponse response from the API call
     */
    public CompletableFuture<ListCustomerSegmentsResponse> listCustomerSegmentsAsync(
            final String cursor) {
        return makeHttpCallAsync(() -> buildListCustomerSegmentsRequest(cursor),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleListCustomerSegmentsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCustomerSegments.
     */
    private HttpRequest buildListCustomerSegmentsRequest(
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/segments");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);

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
     * Processes the response for listCustomerSegments.
     * @return An object of type ListCustomerSegmentsResponse
     */
    private ListCustomerSegmentsResponse handleListCustomerSegmentsResponse(
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
        ListCustomerSegmentsResponse result = ApiHelper.deserialize(responseBody,
                ListCustomerSegmentsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a specific customer segment as identified by the `segment_id` value.
     * @param  segmentId  Required parameter: The Square-issued ID of the customer segment.
     * @return    Returns the RetrieveCustomerSegmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCustomerSegmentResponse retrieveCustomerSegment(
            final String segmentId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveCustomerSegmentRequest(segmentId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveCustomerSegmentResponse(context);
    }

    /**
     * Retrieves a specific customer segment as identified by the `segment_id` value.
     * @param  segmentId  Required parameter: The Square-issued ID of the customer segment.
     * @return    Returns the RetrieveCustomerSegmentResponse response from the API call
     */
    public CompletableFuture<RetrieveCustomerSegmentResponse> retrieveCustomerSegmentAsync(
            final String segmentId) {
        return makeHttpCallAsync(() -> buildRetrieveCustomerSegmentRequest(segmentId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleRetrieveCustomerSegmentResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveCustomerSegment.
     */
    private HttpRequest buildRetrieveCustomerSegmentRequest(
            final String segmentId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/segments/{segment_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("segment_id",
                new SimpleEntry<Object, Boolean>(segmentId, true));
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
     * Processes the response for retrieveCustomerSegment.
     * @return An object of type RetrieveCustomerSegmentResponse
     */
    private RetrieveCustomerSegmentResponse handleRetrieveCustomerSegmentResponse(
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
        RetrieveCustomerSegmentResponse result = ApiHelper.deserialize(responseBody,
                RetrieveCustomerSegmentResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}