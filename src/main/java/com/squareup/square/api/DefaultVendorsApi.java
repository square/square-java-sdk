
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
import com.squareup.square.models.BulkCreateVendorsRequest;
import com.squareup.square.models.BulkCreateVendorsResponse;
import com.squareup.square.models.BulkRetrieveVendorsRequest;
import com.squareup.square.models.BulkRetrieveVendorsResponse;
import com.squareup.square.models.BulkUpdateVendorsRequest;
import com.squareup.square.models.BulkUpdateVendorsResponse;
import com.squareup.square.models.CreateVendorRequest;
import com.squareup.square.models.CreateVendorResponse;
import com.squareup.square.models.RetrieveVendorResponse;
import com.squareup.square.models.SearchVendorsRequest;
import com.squareup.square.models.SearchVendorsResponse;
import com.squareup.square.models.UpdateVendorRequest;
import com.squareup.square.models.UpdateVendorResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultVendorsApi extends BaseApi implements VendorsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultVendorsApi(Configuration config, HttpClient httpClient,
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
    public DefaultVendorsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Creates one or more [Vendor]($m/Vendor) objects to represent suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkCreateVendorsResponse bulkCreateVendors(
            final BulkCreateVendorsRequest body) throws ApiException, IOException {
        HttpRequest request = buildBulkCreateVendorsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleBulkCreateVendorsResponse(context);
    }

    /**
     * Creates one or more [Vendor]($m/Vendor) objects to represent suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateVendorsResponse response from the API call
     */
    public CompletableFuture<BulkCreateVendorsResponse> bulkCreateVendorsAsync(
            final BulkCreateVendorsRequest body) {
        return makeHttpCallAsync(() -> buildBulkCreateVendorsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleBulkCreateVendorsResponse(context));
    }

    /**
     * Builds the HttpRequest object for bulkCreateVendors.
     */
    private HttpRequest buildBulkCreateVendorsRequest(
            final BulkCreateVendorsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/vendors/bulk-create");

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
     * Processes the response for bulkCreateVendors.
     * @return An object of type BulkCreateVendorsResponse
     */
    private BulkCreateVendorsResponse handleBulkCreateVendorsResponse(
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
        BulkCreateVendorsResponse result = ApiHelper.deserialize(responseBody,
                BulkCreateVendorsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves one or more vendors of specified [Vendor]($m/Vendor) IDs.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkRetrieveVendorsResponse bulkRetrieveVendors(
            final BulkRetrieveVendorsRequest body) throws ApiException, IOException {
        HttpRequest request = buildBulkRetrieveVendorsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleBulkRetrieveVendorsResponse(context);
    }

    /**
     * Retrieves one or more vendors of specified [Vendor]($m/Vendor) IDs.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveVendorsResponse response from the API call
     */
    public CompletableFuture<BulkRetrieveVendorsResponse> bulkRetrieveVendorsAsync(
            final BulkRetrieveVendorsRequest body) {
        return makeHttpCallAsync(() -> buildBulkRetrieveVendorsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleBulkRetrieveVendorsResponse(context));
    }

    /**
     * Builds the HttpRequest object for bulkRetrieveVendors.
     */
    private HttpRequest buildBulkRetrieveVendorsRequest(
            final BulkRetrieveVendorsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/vendors/bulk-retrieve");

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
     * Processes the response for bulkRetrieveVendors.
     * @return An object of type BulkRetrieveVendorsResponse
     */
    private BulkRetrieveVendorsResponse handleBulkRetrieveVendorsResponse(
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
        BulkRetrieveVendorsResponse result = ApiHelper.deserialize(responseBody,
                BulkRetrieveVendorsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates one or more of existing [Vendor]($m/Vendor) objects as suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkUpdateVendorsResponse bulkUpdateVendors(
            final BulkUpdateVendorsRequest body) throws ApiException, IOException {
        HttpRequest request = buildBulkUpdateVendorsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleBulkUpdateVendorsResponse(context);
    }

    /**
     * Updates one or more of existing [Vendor]($m/Vendor) objects as suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateVendorsResponse response from the API call
     */
    public CompletableFuture<BulkUpdateVendorsResponse> bulkUpdateVendorsAsync(
            final BulkUpdateVendorsRequest body) {
        return makeHttpCallAsync(() -> buildBulkUpdateVendorsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleBulkUpdateVendorsResponse(context));
    }

    /**
     * Builds the HttpRequest object for bulkUpdateVendors.
     */
    private HttpRequest buildBulkUpdateVendorsRequest(
            final BulkUpdateVendorsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/vendors/bulk-update");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for bulkUpdateVendors.
     * @return An object of type BulkUpdateVendorsResponse
     */
    private BulkUpdateVendorsResponse handleBulkUpdateVendorsResponse(
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
        BulkUpdateVendorsResponse result = ApiHelper.deserialize(responseBody,
                BulkUpdateVendorsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a single [Vendor]($m/Vendor) object to represent a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateVendorResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateVendorResponse createVendor(
            final CreateVendorRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateVendorRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateVendorResponse(context);
    }

    /**
     * Creates a single [Vendor]($m/Vendor) object to represent a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateVendorResponse response from the API call
     */
    public CompletableFuture<CreateVendorResponse> createVendorAsync(
            final CreateVendorRequest body) {
        return makeHttpCallAsync(() -> buildCreateVendorRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateVendorResponse(context));
    }

    /**
     * Builds the HttpRequest object for createVendor.
     */
    private HttpRequest buildCreateVendorRequest(
            final CreateVendorRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/vendors/create");

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
     * Processes the response for createVendor.
     * @return An object of type CreateVendorResponse
     */
    private CreateVendorResponse handleCreateVendorResponse(
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
        CreateVendorResponse result = ApiHelper.deserialize(responseBody,
                CreateVendorResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches for vendors using a filter against supported [Vendor]($m/Vendor) properties and a
     * supported sorter.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchVendorsResponse searchVendors(
            final SearchVendorsRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchVendorsRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchVendorsResponse(context);
    }

    /**
     * Searches for vendors using a filter against supported [Vendor]($m/Vendor) properties and a
     * supported sorter.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchVendorsResponse response from the API call
     */
    public CompletableFuture<SearchVendorsResponse> searchVendorsAsync(
            final SearchVendorsRequest body) {
        return makeHttpCallAsync(() -> buildSearchVendorsRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchVendorsResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchVendors.
     */
    private HttpRequest buildSearchVendorsRequest(
            final SearchVendorsRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/vendors/search");

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
     * Processes the response for searchVendors.
     * @return An object of type SearchVendorsResponse
     */
    private SearchVendorsResponse handleSearchVendorsResponse(
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
        SearchVendorsResponse result = ApiHelper.deserialize(responseBody,
                SearchVendorsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves the vendor of a specified [Vendor]($m/Vendor) ID.
     * @param  vendorId  Required parameter: ID of the [Vendor]($m/Vendor) to retrieve.
     * @return    Returns the RetrieveVendorResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveVendorResponse retrieveVendor(
            final String vendorId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveVendorRequest(vendorId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveVendorResponse(context);
    }

    /**
     * Retrieves the vendor of a specified [Vendor]($m/Vendor) ID.
     * @param  vendorId  Required parameter: ID of the [Vendor]($m/Vendor) to retrieve.
     * @return    Returns the RetrieveVendorResponse response from the API call
     */
    public CompletableFuture<RetrieveVendorResponse> retrieveVendorAsync(
            final String vendorId) {
        return makeHttpCallAsync(() -> buildRetrieveVendorRequest(vendorId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveVendorResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveVendor.
     */
    private HttpRequest buildRetrieveVendorRequest(
            final String vendorId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/vendors/{vendor_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("vendor_id",
                new SimpleEntry<Object, Boolean>(vendorId, true));
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
     * Processes the response for retrieveVendor.
     * @return An object of type RetrieveVendorResponse
     */
    private RetrieveVendorResponse handleRetrieveVendorResponse(
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
        RetrieveVendorResponse result = ApiHelper.deserialize(responseBody,
                RetrieveVendorResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates an existing [Vendor]($m/Vendor) object as a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  vendorId  Required parameter: Example:
     * @return    Returns the UpdateVendorResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateVendorResponse updateVendor(
            final UpdateVendorRequest body,
            final String vendorId) throws ApiException, IOException {
        HttpRequest request = buildUpdateVendorRequest(body, vendorId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateVendorResponse(context);
    }

    /**
     * Updates an existing [Vendor]($m/Vendor) object as a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  vendorId  Required parameter: Example:
     * @return    Returns the UpdateVendorResponse response from the API call
     */
    public CompletableFuture<UpdateVendorResponse> updateVendorAsync(
            final UpdateVendorRequest body,
            final String vendorId) {
        return makeHttpCallAsync(() -> buildUpdateVendorRequest(body, vendorId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateVendorResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateVendor.
     */
    private HttpRequest buildUpdateVendorRequest(
            final UpdateVendorRequest body,
            final String vendorId) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/vendors/{vendor_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("vendor_id",
                new SimpleEntry<Object, Boolean>(vendorId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateVendor.
     * @return An object of type UpdateVendorResponse
     */
    private UpdateVendorResponse handleUpdateVendorResponse(
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
        UpdateVendorResponse result = ApiHelper.deserialize(responseBody,
                UpdateVendorResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}