
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
import com.squareup.square.models.AddGroupToCustomerResponse;
import com.squareup.square.models.CreateCustomerCardRequest;
import com.squareup.square.models.CreateCustomerCardResponse;
import com.squareup.square.models.CreateCustomerRequest;
import com.squareup.square.models.CreateCustomerResponse;
import com.squareup.square.models.DeleteCustomerCardResponse;
import com.squareup.square.models.DeleteCustomerResponse;
import com.squareup.square.models.ListCustomersResponse;
import com.squareup.square.models.RemoveGroupFromCustomerResponse;
import com.squareup.square.models.RetrieveCustomerResponse;
import com.squareup.square.models.SearchCustomersRequest;
import com.squareup.square.models.SearchCustomersResponse;
import com.squareup.square.models.UpdateCustomerRequest;
import com.squareup.square.models.UpdateCustomerResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCustomersApi extends BaseApi implements CustomersApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultCustomersApi(Configuration config, HttpClient httpClient,
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
    public DefaultCustomersApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists customer profiles associated with a Square account. Under normal operating conditions,
     * newly created or updated customer profiles become available for the listing operation in well
     * under 30 seconds. Occasionally, propagation of the new or updated profiles can take closer to
     * one minute or longer, especially during network incidents and outages.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. The limit
     *         is ignored if it is less than 1 or greater than 100. The default value is 100. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  sortField  Optional parameter: Indicates how customers should be sorted. The default
     *         value is `DEFAULT`.
     * @param  sortOrder  Optional parameter: Indicates whether customers should be sorted in
     *         ascending (`ASC`) or descending (`DESC`) order. The default value is `ASC`.
     * @return    Returns the ListCustomersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCustomersResponse listCustomers(
            final String cursor,
            final Integer limit,
            final String sortField,
            final String sortOrder) throws ApiException, IOException {
        HttpRequest request = buildListCustomersRequest(cursor, limit, sortField, sortOrder);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListCustomersResponse(context);
    }

    /**
     * Lists customer profiles associated with a Square account. Under normal operating conditions,
     * newly created or updated customer profiles become available for the listing operation in well
     * under 30 seconds. Occasionally, propagation of the new or updated profiles can take closer to
     * one minute or longer, especially during network incidents and outages.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. The limit
     *         is ignored if it is less than 1 or greater than 100. The default value is 100. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  sortField  Optional parameter: Indicates how customers should be sorted. The default
     *         value is `DEFAULT`.
     * @param  sortOrder  Optional parameter: Indicates whether customers should be sorted in
     *         ascending (`ASC`) or descending (`DESC`) order. The default value is `ASC`.
     * @return    Returns the ListCustomersResponse response from the API call
     */
    public CompletableFuture<ListCustomersResponse> listCustomersAsync(
            final String cursor,
            final Integer limit,
            final String sortField,
            final String sortOrder) {
        return makeHttpCallAsync(() -> buildListCustomersRequest(cursor, limit, sortField,
                sortOrder),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListCustomersResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCustomers.
     */
    private HttpRequest buildListCustomersRequest(
            final String cursor,
            final Integer limit,
            final String sortField,
            final String sortOrder) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
        queryParameters.put("limit", limit);
        queryParameters.put("sort_field", sortField);
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
     * Processes the response for listCustomers.
     * @return An object of type ListCustomersResponse
     */
    private ListCustomersResponse handleListCustomersResponse(
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
        ListCustomersResponse result = ApiHelper.deserialize(responseBody,
                ListCustomersResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a new customer for a business. You must provide at least one of the following values
     * in your request to this endpoint: - `given_name` - `family_name` - `company_name` -
     * `email_address` - `phone_number`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateCustomerResponse createCustomer(
            final CreateCustomerRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateCustomerRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateCustomerResponse(context);
    }

    /**
     * Creates a new customer for a business. You must provide at least one of the following values
     * in your request to this endpoint: - `given_name` - `family_name` - `company_name` -
     * `email_address` - `phone_number`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerResponse response from the API call
     */
    public CompletableFuture<CreateCustomerResponse> createCustomerAsync(
            final CreateCustomerRequest body) {
        return makeHttpCallAsync(() -> buildCreateCustomerRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateCustomerResponse(context));
    }

    /**
     * Builds the HttpRequest object for createCustomer.
     */
    private HttpRequest buildCreateCustomerRequest(
            final CreateCustomerRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers");

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
     * Processes the response for createCustomer.
     * @return An object of type CreateCustomerResponse
     */
    private CreateCustomerResponse handleCreateCustomerResponse(
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
        CreateCustomerResponse result = ApiHelper.deserialize(responseBody,
                CreateCustomerResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches the customer profiles associated with a Square account using a supported query
     * filter. Calling `SearchCustomers` without any explicit query filter returns all customer
     * profiles ordered alphabetically based on `given_name` and `family_name`. Under normal
     * operating conditions, newly created or updated customer profiles become available for the
     * search operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and
     * outages.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCustomersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchCustomersResponse searchCustomers(
            final SearchCustomersRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchCustomersRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchCustomersResponse(context);
    }

    /**
     * Searches the customer profiles associated with a Square account using a supported query
     * filter. Calling `SearchCustomers` without any explicit query filter returns all customer
     * profiles ordered alphabetically based on `given_name` and `family_name`. Under normal
     * operating conditions, newly created or updated customer profiles become available for the
     * search operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and
     * outages.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCustomersResponse response from the API call
     */
    public CompletableFuture<SearchCustomersResponse> searchCustomersAsync(
            final SearchCustomersRequest body) {
        return makeHttpCallAsync(() -> buildSearchCustomersRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchCustomersResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchCustomers.
     */
    private HttpRequest buildSearchCustomersRequest(
            final SearchCustomersRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/search");

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
     * Processes the response for searchCustomers.
     * @return An object of type SearchCustomersResponse
     */
    private SearchCustomersResponse handleSearchCustomersResponse(
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
        SearchCustomersResponse result = ApiHelper.deserialize(responseBody,
                SearchCustomersResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a customer profile from a business. This operation also unlinks any associated cards
     * on file. As a best practice, you should include the `version` field in the request to enable
     * [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     * control. The value must be set to the current version of the customer profile. To delete a
     * customer profile that was created by merging existing profiles, you must use the ID of the
     * newly created profile.
     * @param  customerId  Required parameter: The ID of the customer to delete.
     * @param  version  Optional parameter: The current version of the customer profile. As a best
     *         practice, you should include this parameter to enable [optimistic
     *         concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     *         control. For more information, see [Delete a customer
     *         profile](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#delete-customer-profile).
     * @return    Returns the DeleteCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteCustomerResponse deleteCustomer(
            final String customerId,
            final Long version) throws ApiException, IOException {
        HttpRequest request = buildDeleteCustomerRequest(customerId, version);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteCustomerResponse(context);
    }

    /**
     * Deletes a customer profile from a business. This operation also unlinks any associated cards
     * on file. As a best practice, you should include the `version` field in the request to enable
     * [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     * control. The value must be set to the current version of the customer profile. To delete a
     * customer profile that was created by merging existing profiles, you must use the ID of the
     * newly created profile.
     * @param  customerId  Required parameter: The ID of the customer to delete.
     * @param  version  Optional parameter: The current version of the customer profile. As a best
     *         practice, you should include this parameter to enable [optimistic
     *         concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     *         control. For more information, see [Delete a customer
     *         profile](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#delete-customer-profile).
     * @return    Returns the DeleteCustomerResponse response from the API call
     */
    public CompletableFuture<DeleteCustomerResponse> deleteCustomerAsync(
            final String customerId,
            final Long version) {
        return makeHttpCallAsync(() -> buildDeleteCustomerRequest(customerId, version),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteCustomerResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteCustomer.
     */
    private HttpRequest buildDeleteCustomerRequest(
            final String customerId,
            final Long version) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("version", version);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteCustomer.
     * @return An object of type DeleteCustomerResponse
     */
    private DeleteCustomerResponse handleDeleteCustomerResponse(
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
        DeleteCustomerResponse result = ApiHelper.deserialize(responseBody,
                DeleteCustomerResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns details for a single customer.
     * @param  customerId  Required parameter: The ID of the customer to retrieve.
     * @return    Returns the RetrieveCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCustomerResponse retrieveCustomer(
            final String customerId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveCustomerRequest(customerId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveCustomerResponse(context);
    }

    /**
     * Returns details for a single customer.
     * @param  customerId  Required parameter: The ID of the customer to retrieve.
     * @return    Returns the RetrieveCustomerResponse response from the API call
     */
    public CompletableFuture<RetrieveCustomerResponse> retrieveCustomerAsync(
            final String customerId) {
        return makeHttpCallAsync(() -> buildRetrieveCustomerRequest(customerId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveCustomerResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveCustomer.
     */
    private HttpRequest buildRetrieveCustomerRequest(
            final String customerId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
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
     * Processes the response for retrieveCustomer.
     * @return An object of type RetrieveCustomerResponse
     */
    private RetrieveCustomerResponse handleRetrieveCustomerResponse(
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
        RetrieveCustomerResponse result = ApiHelper.deserialize(responseBody,
                RetrieveCustomerResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a customer profile. To change an attribute, specify the new value. To remove an
     * attribute, specify the value as an empty string or empty object. As a best practice, you
     * should include the `version` field in the request to enable [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     * control. The value must be set to the current version of the customer profile. To update a
     * customer profile that was created by merging existing profiles, you must use the ID of the
     * newly created profile. You cannot use this endpoint to change cards on file. To make changes,
     * use the [Cards API]($e/Cards) or [Gift Cards API]($e/GiftCards).
     * @param  customerId  Required parameter: The ID of the customer to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateCustomerResponse updateCustomer(
            final String customerId,
            final UpdateCustomerRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateCustomerRequest(customerId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateCustomerResponse(context);
    }

    /**
     * Updates a customer profile. To change an attribute, specify the new value. To remove an
     * attribute, specify the value as an empty string or empty object. As a best practice, you
     * should include the `version` field in the request to enable [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     * control. The value must be set to the current version of the customer profile. To update a
     * customer profile that was created by merging existing profiles, you must use the ID of the
     * newly created profile. You cannot use this endpoint to change cards on file. To make changes,
     * use the [Cards API]($e/Cards) or [Gift Cards API]($e/GiftCards).
     * @param  customerId  Required parameter: The ID of the customer to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerResponse response from the API call
     */
    public CompletableFuture<UpdateCustomerResponse> updateCustomerAsync(
            final String customerId,
            final UpdateCustomerRequest body) {
        return makeHttpCallAsync(() -> buildUpdateCustomerRequest(customerId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateCustomerResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateCustomer.
     */
    private HttpRequest buildUpdateCustomerRequest(
            final String customerId,
            final UpdateCustomerRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
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
     * Processes the response for updateCustomer.
     * @return An object of type UpdateCustomerResponse
     */
    private UpdateCustomerResponse handleUpdateCustomerResponse(
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
        UpdateCustomerResponse result = ApiHelper.deserialize(responseBody,
                UpdateCustomerResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Adds a card on file to an existing customer. As with charges, calls to `CreateCustomerCard`
     * are idempotent. Multiple calls with the same card nonce return the same card record that was
     * created with the provided nonce during the _first_ call.
     * @deprecated
     * 
     * @param  customerId  Required parameter: The Square ID of the customer profile the card is
     *         linked to.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public CreateCustomerCardResponse createCustomerCard(
            final String customerId,
            final CreateCustomerCardRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateCustomerCardRequest(customerId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateCustomerCardResponse(context);
    }

    /**
     * Adds a card on file to an existing customer. As with charges, calls to `CreateCustomerCard`
     * are idempotent. Multiple calls with the same card nonce return the same card record that was
     * created with the provided nonce during the _first_ call.
     * @deprecated
     * 
     * @param  customerId  Required parameter: The Square ID of the customer profile the card is
     *         linked to.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerCardResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<CreateCustomerCardResponse> createCustomerCardAsync(
            final String customerId,
            final CreateCustomerCardRequest body) {
        return makeHttpCallAsync(() -> buildCreateCustomerCardRequest(customerId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateCustomerCardResponse(context));
    }

    /**
     * Builds the HttpRequest object for createCustomerCard.
     */
    private HttpRequest buildCreateCustomerCardRequest(
            final String customerId,
            final CreateCustomerCardRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}/cards");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
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
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createCustomerCard.
     * @return An object of type CreateCustomerCardResponse
     */
    private CreateCustomerCardResponse handleCreateCustomerCardResponse(
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
        CreateCustomerCardResponse result = ApiHelper.deserialize(responseBody,
                CreateCustomerCardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Removes a card on file from a customer.
     * @deprecated
     * 
     * @param  customerId  Required parameter: The ID of the customer that the card on file belongs
     *         to.
     * @param  cardId  Required parameter: The ID of the card on file to delete.
     * @return    Returns the DeleteCustomerCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public DeleteCustomerCardResponse deleteCustomerCard(
            final String customerId,
            final String cardId) throws ApiException, IOException {
        HttpRequest request = buildDeleteCustomerCardRequest(customerId, cardId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteCustomerCardResponse(context);
    }

    /**
     * Removes a card on file from a customer.
     * @deprecated
     * 
     * @param  customerId  Required parameter: The ID of the customer that the card on file belongs
     *         to.
     * @param  cardId  Required parameter: The ID of the card on file to delete.
     * @return    Returns the DeleteCustomerCardResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<DeleteCustomerCardResponse> deleteCustomerCardAsync(
            final String customerId,
            final String cardId) {
        return makeHttpCallAsync(() -> buildDeleteCustomerCardRequest(customerId, cardId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteCustomerCardResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteCustomerCard.
     */
    private HttpRequest buildDeleteCustomerCardRequest(
            final String customerId,
            final String cardId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}/cards/{card_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
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
        HttpRequest request = getClientInstance().delete(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteCustomerCard.
     * @return An object of type DeleteCustomerCardResponse
     */
    private DeleteCustomerCardResponse handleDeleteCustomerCardResponse(
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
        DeleteCustomerCardResponse result = ApiHelper.deserialize(responseBody,
                DeleteCustomerCardResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Removes a group membership from a customer. The customer is identified by the `customer_id`
     * value and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to remove from the group.
     * @param  groupId  Required parameter: The ID of the customer group to remove the customer
     *         from.
     * @return    Returns the RemoveGroupFromCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RemoveGroupFromCustomerResponse removeGroupFromCustomer(
            final String customerId,
            final String groupId) throws ApiException, IOException {
        HttpRequest request = buildRemoveGroupFromCustomerRequest(customerId, groupId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRemoveGroupFromCustomerResponse(context);
    }

    /**
     * Removes a group membership from a customer. The customer is identified by the `customer_id`
     * value and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to remove from the group.
     * @param  groupId  Required parameter: The ID of the customer group to remove the customer
     *         from.
     * @return    Returns the RemoveGroupFromCustomerResponse response from the API call
     */
    public CompletableFuture<RemoveGroupFromCustomerResponse> removeGroupFromCustomerAsync(
            final String customerId,
            final String groupId) {
        return makeHttpCallAsync(() -> buildRemoveGroupFromCustomerRequest(customerId, groupId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRemoveGroupFromCustomerResponse(context));
    }

    /**
     * Builds the HttpRequest object for removeGroupFromCustomer.
     */
    private HttpRequest buildRemoveGroupFromCustomerRequest(
            final String customerId,
            final String groupId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}/groups/{group_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
        templateParameters.put("group_id",
                new SimpleEntry<Object, Boolean>(groupId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for removeGroupFromCustomer.
     * @return An object of type RemoveGroupFromCustomerResponse
     */
    private RemoveGroupFromCustomerResponse handleRemoveGroupFromCustomerResponse(
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
        RemoveGroupFromCustomerResponse result = ApiHelper.deserialize(responseBody,
                RemoveGroupFromCustomerResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Adds a group membership to a customer. The customer is identified by the `customer_id` value
     * and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to add to a group.
     * @param  groupId  Required parameter: The ID of the customer group to add the customer to.
     * @return    Returns the AddGroupToCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public AddGroupToCustomerResponse addGroupToCustomer(
            final String customerId,
            final String groupId) throws ApiException, IOException {
        HttpRequest request = buildAddGroupToCustomerRequest(customerId, groupId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleAddGroupToCustomerResponse(context);
    }

    /**
     * Adds a group membership to a customer. The customer is identified by the `customer_id` value
     * and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to add to a group.
     * @param  groupId  Required parameter: The ID of the customer group to add the customer to.
     * @return    Returns the AddGroupToCustomerResponse response from the API call
     */
    public CompletableFuture<AddGroupToCustomerResponse> addGroupToCustomerAsync(
            final String customerId,
            final String groupId) {
        return makeHttpCallAsync(() -> buildAddGroupToCustomerRequest(customerId, groupId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleAddGroupToCustomerResponse(context));
    }

    /**
     * Builds the HttpRequest object for addGroupToCustomer.
     */
    private HttpRequest buildAddGroupToCustomerRequest(
            final String customerId,
            final String groupId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}/groups/{group_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
        templateParameters.put("group_id",
                new SimpleEntry<Object, Boolean>(groupId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().put(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for addGroupToCustomer.
     * @return An object of type AddGroupToCustomerResponse
     */
    private AddGroupToCustomerResponse handleAddGroupToCustomerResponse(
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
        AddGroupToCustomerResponse result = ApiHelper.deserialize(responseBody,
                AddGroupToCustomerResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}