package com.squareup.square.api;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;
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

public final class CheckoutApi extends BaseApi {
    public CheckoutApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public CheckoutApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Links a `checkoutId` to a `checkout_page_url` that customers will
     * be directed to in order to provide their payment information using a
     * payment processing workflow hosted on connect.squareup.com.
     * @param    locationId    Required parameter: The ID of the business location to associate the checkout with.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCheckoutResponse response from the API call
     */
    public CreateCheckoutResponse createCheckout(
            final String locationId,
            final CreateCheckoutRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateCheckoutRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateCheckoutResponse(_context);
    }

    /**
     * Links a `checkoutId` to a `checkout_page_url` that customers will
     * be directed to in order to provide their payment information using a
     * payment processing workflow hosted on connect.squareup.com.
     * @param    locationId    Required parameter: The ID of the business location to associate the checkout with.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCheckoutResponse response from the API call 
     */
    public CompletableFuture<CreateCheckoutResponse> createCheckoutAsync(
            final String locationId,
            final CreateCheckoutRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreateCheckoutRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateCheckoutResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createCheckout
     */
    private HttpRequest _buildCreateCheckoutRequest(
            final String locationId,
            final CreateCheckoutRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/locations/{location_id}/checkouts");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("content-type", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String _bodyJson = ApiHelper.serialize(body);
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for createCheckout
     * @return An object of type CreateCheckoutResponse
     */
    private CreateCheckoutResponse _handleCreateCheckoutResponse(HttpContext _context)
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
        CreateCheckoutResponse _result = ApiHelper.deserialize(_responseBody,
                CreateCheckoutResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
