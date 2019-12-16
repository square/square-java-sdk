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

public final class CustomersApi extends BaseApi {
    public CustomersApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public CustomersApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists a business's customers.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     * @param    sortField    Optional parameter: Indicates how Customers should be sorted.  Default: `DEFAULT`.
     * @param    sortOrder    Optional parameter: Indicates whether Customers should be sorted in ascending (`ASC`) or descending (`DESC`) order.  Default: `ASC`.
     * @return    Returns the ListCustomersResponse response from the API call
     */
    public ListCustomersResponse listCustomers(
            final String cursor,
            final String sortField,
            final String sortOrder
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListCustomersRequest(cursor, sortField, sortOrder);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListCustomersResponse(_context);
    }

    /**
     * Lists a business's customers.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     * @param    sortField    Optional parameter: Indicates how Customers should be sorted.  Default: `DEFAULT`.
     * @param    sortOrder    Optional parameter: Indicates whether Customers should be sorted in ascending (`ASC`) or descending (`DESC`) order.  Default: `ASC`.
     * @return    Returns the ListCustomersResponse response from the API call 
     */
    public CompletableFuture<ListCustomersResponse> listCustomersAsync(
            final String cursor,
            final String sortField,
            final String sortOrder
    ) {
        return makeHttpCallAsync(() -> _buildListCustomersRequest(cursor, sortField, sortOrder),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListCustomersResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listCustomers
     */
    private HttpRequest _buildListCustomersRequest(
            final String cursor,
            final String sortField,
            final String sortOrder
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/customers");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("cursor", cursor);
        _queryParameters.put("sort_field", sortField);
        _queryParameters.put("sort_order", sortOrder);
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
     * Processes the response for listCustomers
     * @return An object of type ListCustomersResponse
     */
    private ListCustomersResponse _handleListCustomersResponse(HttpContext _context)
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
        ListCustomersResponse _result = ApiHelper.deserialize(_responseBody,
                ListCustomersResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Creates a new customer for a business, which can have associated cards on file.
     * You must provide __at least one__ of the following values in your request to this
     * endpoint:
     * - `given_name`
     * - `family_name`
     * - `company_name`
     * - `email_address`
     * - `phone_number`
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerResponse response from the API call
     */
    public CreateCustomerResponse createCustomer(
            final CreateCustomerRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateCustomerRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateCustomerResponse(_context);
    }

    /**
     * Creates a new customer for a business, which can have associated cards on file.
     * You must provide __at least one__ of the following values in your request to this
     * endpoint:
     * - `given_name`
     * - `family_name`
     * - `company_name`
     * - `email_address`
     * - `phone_number`
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerResponse response from the API call 
     */
    public CompletableFuture<CreateCustomerResponse> createCustomerAsync(
            final CreateCustomerRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreateCustomerRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateCustomerResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createCustomer
     */
    private HttpRequest _buildCreateCustomerRequest(
            final CreateCustomerRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/customers");
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
     * Processes the response for createCustomer
     * @return An object of type CreateCustomerResponse
     */
    private CreateCustomerResponse _handleCreateCustomerResponse(HttpContext _context)
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
        CreateCustomerResponse _result = ApiHelper.deserialize(_responseBody,
                CreateCustomerResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Searches the customer profiles associated with a Square account.
     * Calling SearchCustomers without an explicit query parameter returns all
     * customer profiles ordered alphabetically based on `given_name` and
     * `family_name`.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchCustomersResponse response from the API call
     */
    public SearchCustomersResponse searchCustomers(
            final SearchCustomersRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildSearchCustomersRequest(body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleSearchCustomersResponse(_context);
    }

    /**
     * Searches the customer profiles associated with a Square account.
     * Calling SearchCustomers without an explicit query parameter returns all
     * customer profiles ordered alphabetically based on `given_name` and
     * `family_name`.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchCustomersResponse response from the API call 
     */
    public CompletableFuture<SearchCustomersResponse> searchCustomersAsync(
            final SearchCustomersRequest body
    ) {
        return makeHttpCallAsync(() -> _buildSearchCustomersRequest(body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleSearchCustomersResponse(_context));
    }

    /**
     * Builds the HttpRequest object for searchCustomers
     */
    private HttpRequest _buildSearchCustomersRequest(
            final SearchCustomersRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/customers/search");
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
     * Processes the response for searchCustomers
     * @return An object of type SearchCustomersResponse
     */
    private SearchCustomersResponse _handleSearchCustomersResponse(HttpContext _context)
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
        SearchCustomersResponse _result = ApiHelper.deserialize(_responseBody,
                SearchCustomersResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes a customer from a business, along with any linked cards on file. When two profiles
     * are merged into a single profile, that profile is assigned a new `customer_id`. You must use the
     * new `customer_id` to delete merged profiles.
     * @param    customerId    Required parameter: The ID of the customer to delete.
     * @return    Returns the DeleteCustomerResponse response from the API call
     */
    public DeleteCustomerResponse deleteCustomer(
            final String customerId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteCustomerRequest(customerId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteCustomerResponse(_context);
    }

    /**
     * Deletes a customer from a business, along with any linked cards on file. When two profiles
     * are merged into a single profile, that profile is assigned a new `customer_id`. You must use the
     * new `customer_id` to delete merged profiles.
     * @param    customerId    Required parameter: The ID of the customer to delete.
     * @return    Returns the DeleteCustomerResponse response from the API call 
     */
    public CompletableFuture<DeleteCustomerResponse> deleteCustomerAsync(
            final String customerId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteCustomerRequest(customerId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteCustomerResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteCustomer
     */
    private HttpRequest _buildDeleteCustomerRequest(
            final String customerId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/customers/{customer_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("customer_id", customerId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().delete(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for deleteCustomer
     * @return An object of type DeleteCustomerResponse
     */
    private DeleteCustomerResponse _handleDeleteCustomerResponse(HttpContext _context)
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
        DeleteCustomerResponse _result = ApiHelper.deserialize(_responseBody,
                DeleteCustomerResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Returns details for a single customer.
     * @param    customerId    Required parameter: The ID of the customer to retrieve.
     * @return    Returns the RetrieveCustomerResponse response from the API call
     */
    public RetrieveCustomerResponse retrieveCustomer(
            final String customerId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveCustomerRequest(customerId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveCustomerResponse(_context);
    }

    /**
     * Returns details for a single customer.
     * @param    customerId    Required parameter: The ID of the customer to retrieve.
     * @return    Returns the RetrieveCustomerResponse response from the API call 
     */
    public CompletableFuture<RetrieveCustomerResponse> retrieveCustomerAsync(
            final String customerId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveCustomerRequest(customerId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveCustomerResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveCustomer
     */
    private HttpRequest _buildRetrieveCustomerRequest(
            final String customerId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/customers/{customer_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("customer_id", customerId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
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
     * Processes the response for retrieveCustomer
     * @return An object of type RetrieveCustomerResponse
     */
    private RetrieveCustomerResponse _handleRetrieveCustomerResponse(HttpContext _context)
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
        RetrieveCustomerResponse _result = ApiHelper.deserialize(_responseBody,
                RetrieveCustomerResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Updates the details of an existing customer. When two profiles are merged
     * into a single profile, that profile is assigned a new `customer_id`. You must use
     * the new `customer_id` to update merged profiles.
     * You cannot edit a customer's cards on file with this endpoint. To make changes
     * to a card on file, you must delete the existing card on file with the
     * [DeleteCustomerCard](#endpoint-deletecustomercard) endpoint, then create a new one with the
     * [CreateCustomerCard](#endpoint-createcustomercard) endpoint.
     * @param    customerId    Required parameter: The ID of the customer to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerResponse response from the API call
     */
    public UpdateCustomerResponse updateCustomer(
            final String customerId,
            final UpdateCustomerRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateCustomerRequest(customerId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateCustomerResponse(_context);
    }

    /**
     * Updates the details of an existing customer. When two profiles are merged
     * into a single profile, that profile is assigned a new `customer_id`. You must use
     * the new `customer_id` to update merged profiles.
     * You cannot edit a customer's cards on file with this endpoint. To make changes
     * to a card on file, you must delete the existing card on file with the
     * [DeleteCustomerCard](#endpoint-deletecustomercard) endpoint, then create a new one with the
     * [CreateCustomerCard](#endpoint-createcustomercard) endpoint.
     * @param    customerId    Required parameter: The ID of the customer to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerResponse response from the API call 
     */
    public CompletableFuture<UpdateCustomerResponse> updateCustomerAsync(
            final String customerId,
            final UpdateCustomerRequest body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateCustomerRequest(customerId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateCustomerResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateCustomer
     */
    private HttpRequest _buildUpdateCustomerRequest(
            final String customerId,
            final UpdateCustomerRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/customers/{customer_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("customer_id", customerId);
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
        HttpRequest _request = getClientInstance().putBody(_queryUrl, _headers, _bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for updateCustomer
     * @return An object of type UpdateCustomerResponse
     */
    private UpdateCustomerResponse _handleUpdateCustomerResponse(HttpContext _context)
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
        UpdateCustomerResponse _result = ApiHelper.deserialize(_responseBody,
                UpdateCustomerResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Adds a card on file to an existing customer.
     * As with charges, calls to `CreateCustomerCard` are idempotent. Multiple
     * calls with the same card nonce return the same card record that was created
     * with the provided nonce during the _first_ call.
     * @param    customerId    Required parameter: The Square ID of the customer profile the card is linked to.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerCardResponse response from the API call
     */
    public CreateCustomerCardResponse createCustomerCard(
            final String customerId,
            final CreateCustomerCardRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateCustomerCardRequest(customerId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateCustomerCardResponse(_context);
    }

    /**
     * Adds a card on file to an existing customer.
     * As with charges, calls to `CreateCustomerCard` are idempotent. Multiple
     * calls with the same card nonce return the same card record that was created
     * with the provided nonce during the _first_ call.
     * @param    customerId    Required parameter: The Square ID of the customer profile the card is linked to.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerCardResponse response from the API call 
     */
    public CompletableFuture<CreateCustomerCardResponse> createCustomerCardAsync(
            final String customerId,
            final CreateCustomerCardRequest body
    ) {
        return makeHttpCallAsync(() -> _buildCreateCustomerCardRequest(customerId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateCustomerCardResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createCustomerCard
     */
    private HttpRequest _buildCreateCustomerCardRequest(
            final String customerId,
            final CreateCustomerCardRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/customers/{customer_id}/cards");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("customer_id", customerId);
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
     * Processes the response for createCustomerCard
     * @return An object of type CreateCustomerCardResponse
     */
    private CreateCustomerCardResponse _handleCreateCustomerCardResponse(HttpContext _context)
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
        CreateCustomerCardResponse _result = ApiHelper.deserialize(_responseBody,
                CreateCustomerCardResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Removes a card on file from a customer.
     * @param    customerId    Required parameter: The ID of the customer that the card on file belongs to.
     * @param    cardId    Required parameter: The ID of the card on file to delete.
     * @return    Returns the DeleteCustomerCardResponse response from the API call
     */
    public DeleteCustomerCardResponse deleteCustomerCard(
            final String customerId,
            final String cardId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteCustomerCardRequest(customerId, cardId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteCustomerCardResponse(_context);
    }

    /**
     * Removes a card on file from a customer.
     * @param    customerId    Required parameter: The ID of the customer that the card on file belongs to.
     * @param    cardId    Required parameter: The ID of the card on file to delete.
     * @return    Returns the DeleteCustomerCardResponse response from the API call 
     */
    public CompletableFuture<DeleteCustomerCardResponse> deleteCustomerCardAsync(
            final String customerId,
            final String cardId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteCustomerCardRequest(customerId, cardId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteCustomerCardResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteCustomerCard
     */
    private HttpRequest _buildDeleteCustomerCardRequest(
            final String customerId,
            final String cardId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v2/customers/{customer_id}/cards/{card_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("customer_id", customerId);
        _templateParameters.put("card_id", cardId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);
        //validate and preprocess url
        String _queryUrl = ApiHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Headers _headers = new Headers();
        _headers.add("user-agent", BaseApi.userAgent);
        _headers.add("accept", "application/json");
        _headers.add("Square-Version", "2019-12-17");
        _headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().delete(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for deleteCustomerCard
     * @return An object of type DeleteCustomerCardResponse
     */
    private DeleteCustomerCardResponse _handleDeleteCustomerCardResponse(HttpContext _context)
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
        DeleteCustomerCardResponse _result = ApiHelper.deserialize(_responseBody,
                DeleteCustomerCardResponse.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
