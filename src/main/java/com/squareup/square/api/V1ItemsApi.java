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

public final class V1ItemsApi extends BaseApi {
    public V1ItemsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    public V1ItemsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists all the item categories for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Category> response from the API call
     */
    @Deprecated
    public List<V1Category> listCategories(
            final String locationId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListCategoriesRequest(locationId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListCategoriesResponse(_context);
    }

    /**
     * Lists all the item categories for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Category> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Category>> listCategoriesAsync(
            final String locationId
    ) {
        return makeHttpCallAsync(() -> _buildListCategoriesRequest(locationId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListCategoriesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listCategories
     */
    private HttpRequest _buildListCategoriesRequest(
            final String locationId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/categories");

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
     * Processes the response for listCategories
     * @return An object of type List<V1Category>
     */
    private List<V1Category> _handleListCategoriesResponse(HttpContext _context)
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
        List<V1Category> _result = ApiHelper.deserializeArray(_responseBody,
                V1Category[].class);
        return _result;
    }

    /**
     * Creates an item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Category response from the API call
     */
    @Deprecated
    public V1Category createCategory(
            final String locationId,
            final V1Category body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateCategoryRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateCategoryResponse(_context);
    }

    /**
     * Creates an item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Category response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Category> createCategoryAsync(
            final String locationId,
            final V1Category body
    ) {
        return makeHttpCallAsync(() -> _buildCreateCategoryRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateCategoryResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createCategory
     */
    private HttpRequest _buildCreateCategoryRequest(
            final String locationId,
            final V1Category body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/categories");

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
     * Processes the response for createCategory
     * @return An object of type V1Category
     */
    private V1Category _handleCreateCategoryResponse(HttpContext _context)
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
        V1Category _result = ApiHelper.deserialize(_responseBody,
                V1Category.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes an existing item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteCategory__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteCategoryRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    categoryId    Required parameter: The ID of the category to delete.
     * @return    Returns the V1Category response from the API call
     */
    @Deprecated
    public V1Category deleteCategory(
            final String locationId,
            final String categoryId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteCategoryRequest(locationId, categoryId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteCategoryResponse(_context);
    }

    /**
     * Deletes an existing item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteCategory__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteCategoryRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    categoryId    Required parameter: The ID of the category to delete.
     * @return    Returns the V1Category response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Category> deleteCategoryAsync(
            final String locationId,
            final String categoryId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteCategoryRequest(locationId, categoryId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteCategoryResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteCategory
     */
    private HttpRequest _buildDeleteCategoryRequest(
            final String locationId,
            final String categoryId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/categories/{category_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("category_id", categoryId);
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
     * Processes the response for deleteCategory
     * @return An object of type V1Category
     */
    private V1Category _handleDeleteCategoryResponse(HttpContext _context)
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
        V1Category _result = ApiHelper.deserialize(_responseBody,
                V1Category.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies the details of an existing item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the category's associated location.
     * @param    categoryId    Required parameter: The ID of the category to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Category response from the API call
     */
    @Deprecated
    public V1Category updateCategory(
            final String locationId,
            final String categoryId,
            final V1Category body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateCategoryRequest(locationId, categoryId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateCategoryResponse(_context);
    }

    /**
     * Modifies the details of an existing item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the category's associated location.
     * @param    categoryId    Required parameter: The ID of the category to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Category response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Category> updateCategoryAsync(
            final String locationId,
            final String categoryId,
            final V1Category body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateCategoryRequest(locationId, categoryId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateCategoryResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateCategory
     */
    private HttpRequest _buildUpdateCategoryRequest(
            final String locationId,
            final String categoryId,
            final V1Category body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/categories/{category_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("category_id", categoryId);
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
     * Processes the response for updateCategory
     * @return An object of type V1Category
     */
    private V1Category _handleUpdateCategoryResponse(HttpContext _context)
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
        V1Category _result = ApiHelper.deserialize(_responseBody,
                V1Category.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Lists all the discounts for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Discount> response from the API call
     */
    @Deprecated
    public List<V1Discount> listDiscounts(
            final String locationId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListDiscountsRequest(locationId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListDiscountsResponse(_context);
    }

    /**
     * Lists all the discounts for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Discount> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Discount>> listDiscountsAsync(
            final String locationId
    ) {
        return makeHttpCallAsync(() -> _buildListDiscountsRequest(locationId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListDiscountsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listDiscounts
     */
    private HttpRequest _buildListDiscountsRequest(
            final String locationId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/discounts");

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
     * Processes the response for listDiscounts
     * @return An object of type List<V1Discount>
     */
    private List<V1Discount> _handleListDiscountsResponse(HttpContext _context)
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
        List<V1Discount> _result = ApiHelper.deserializeArray(_responseBody,
                V1Discount[].class);
        return _result;
    }

    /**
     * Creates a discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Discount response from the API call
     */
    @Deprecated
    public V1Discount createDiscount(
            final String locationId,
            final V1Discount body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateDiscountRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateDiscountResponse(_context);
    }

    /**
     * Creates a discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Discount response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Discount> createDiscountAsync(
            final String locationId,
            final V1Discount body
    ) {
        return makeHttpCallAsync(() -> _buildCreateDiscountRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateDiscountResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createDiscount
     */
    private HttpRequest _buildCreateDiscountRequest(
            final String locationId,
            final V1Discount body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/discounts");

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
     * Processes the response for createDiscount
     * @return An object of type V1Discount
     */
    private V1Discount _handleCreateDiscountResponse(HttpContext _context)
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
        V1Discount _result = ApiHelper.deserialize(_responseBody,
                V1Discount.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes an existing discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteDiscount__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteDiscountRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    discountId    Required parameter: The ID of the discount to delete.
     * @return    Returns the V1Discount response from the API call
     */
    @Deprecated
    public V1Discount deleteDiscount(
            final String locationId,
            final String discountId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteDiscountRequest(locationId, discountId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteDiscountResponse(_context);
    }

    /**
     * Deletes an existing discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteDiscount__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteDiscountRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    discountId    Required parameter: The ID of the discount to delete.
     * @return    Returns the V1Discount response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Discount> deleteDiscountAsync(
            final String locationId,
            final String discountId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteDiscountRequest(locationId, discountId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteDiscountResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteDiscount
     */
    private HttpRequest _buildDeleteDiscountRequest(
            final String locationId,
            final String discountId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/discounts/{discount_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("discount_id", discountId);
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
     * Processes the response for deleteDiscount
     * @return An object of type V1Discount
     */
    private V1Discount _handleDeleteDiscountResponse(HttpContext _context)
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
        V1Discount _result = ApiHelper.deserialize(_responseBody,
                V1Discount.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies the details of an existing discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the category's associated location.
     * @param    discountId    Required parameter: The ID of the discount to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Discount response from the API call
     */
    @Deprecated
    public V1Discount updateDiscount(
            final String locationId,
            final String discountId,
            final V1Discount body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateDiscountRequest(locationId, discountId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateDiscountResponse(_context);
    }

    /**
     * Modifies the details of an existing discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the category's associated location.
     * @param    discountId    Required parameter: The ID of the discount to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Discount response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Discount> updateDiscountAsync(
            final String locationId,
            final String discountId,
            final V1Discount body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateDiscountRequest(locationId, discountId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateDiscountResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateDiscount
     */
    private HttpRequest _buildUpdateDiscountRequest(
            final String locationId,
            final String discountId,
            final V1Discount body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/discounts/{discount_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("discount_id", discountId);
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
     * Processes the response for updateDiscount
     * @return An object of type V1Discount
     */
    private V1Discount _handleUpdateDiscountResponse(HttpContext _context)
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
        V1Discount _result = ApiHelper.deserialize(_responseBody,
                V1Discount.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Lists all the fees (taxes) for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list fees for.
     * @return    Returns the List<V1Fee> response from the API call
     */
    @Deprecated
    public List<V1Fee> listFees(
            final String locationId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListFeesRequest(locationId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListFeesResponse(_context);
    }

    /**
     * Lists all the fees (taxes) for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list fees for.
     * @return    Returns the List<V1Fee> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Fee>> listFeesAsync(
            final String locationId
    ) {
        return makeHttpCallAsync(() -> _buildListFeesRequest(locationId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListFeesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listFees
     */
    private HttpRequest _buildListFeesRequest(
            final String locationId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/fees");

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
     * Processes the response for listFees
     * @return An object of type List<V1Fee>
     */
    private List<V1Fee> _handleListFeesResponse(HttpContext _context)
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
        List<V1Fee> _result = ApiHelper.deserializeArray(_responseBody,
                V1Fee[].class);
        return _result;
    }

    /**
     * Creates a fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a fee for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Fee response from the API call
     */
    @Deprecated
    public V1Fee createFee(
            final String locationId,
            final V1Fee body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateFeeRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateFeeResponse(_context);
    }

    /**
     * Creates a fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a fee for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Fee response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Fee> createFeeAsync(
            final String locationId,
            final V1Fee body
    ) {
        return makeHttpCallAsync(() -> _buildCreateFeeRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateFeeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createFee
     */
    private HttpRequest _buildCreateFeeRequest(
            final String locationId,
            final V1Fee body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/fees");

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
     * Processes the response for createFee
     * @return An object of type V1Fee
     */
    private V1Fee _handleCreateFeeResponse(HttpContext _context)
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
        V1Fee _result = ApiHelper.deserialize(_responseBody,
                V1Fee.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes an existing fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteFee__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteFeeRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    feeId    Required parameter: The ID of the fee to delete.
     * @return    Returns the V1Fee response from the API call
     */
    @Deprecated
    public V1Fee deleteFee(
            final String locationId,
            final String feeId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteFeeRequest(locationId, feeId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteFeeResponse(_context);
    }

    /**
     * Deletes an existing fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteFee__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteFeeRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    feeId    Required parameter: The ID of the fee to delete.
     * @return    Returns the V1Fee response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Fee> deleteFeeAsync(
            final String locationId,
            final String feeId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteFeeRequest(locationId, feeId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteFeeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteFee
     */
    private HttpRequest _buildDeleteFeeRequest(
            final String locationId,
            final String feeId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/fees/{fee_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("fee_id", feeId);
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
     * Processes the response for deleteFee
     * @return An object of type V1Fee
     */
    private V1Fee _handleDeleteFeeResponse(HttpContext _context)
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
        V1Fee _result = ApiHelper.deserialize(_responseBody,
                V1Fee.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies the details of an existing fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    feeId    Required parameter: The ID of the fee to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Fee response from the API call
     */
    @Deprecated
    public V1Fee updateFee(
            final String locationId,
            final String feeId,
            final V1Fee body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateFeeRequest(locationId, feeId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateFeeResponse(_context);
    }

    /**
     * Modifies the details of an existing fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    feeId    Required parameter: The ID of the fee to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Fee response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Fee> updateFeeAsync(
            final String locationId,
            final String feeId,
            final V1Fee body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateFeeRequest(locationId, feeId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateFeeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateFee
     */
    private HttpRequest _buildUpdateFeeRequest(
            final String locationId,
            final String feeId,
            final V1Fee body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/fees/{fee_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("fee_id", feeId);
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
     * Processes the response for updateFee
     * @return An object of type V1Fee
     */
    private V1Fee _handleUpdateFeeResponse(HttpContext _context)
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
        V1Fee _result = ApiHelper.deserialize(_responseBody,
                V1Fee.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides inventory information for all inventory-enabled item
     * variations.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    limit    Optional parameter: The maximum number of inventory entries to return in a single response. This value cannot exceed 1000.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1InventoryEntry> response from the API call
     */
    @Deprecated
    public List<V1InventoryEntry> listInventory(
            final String locationId,
            final Integer limit,
            final String batchToken
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListInventoryRequest(locationId, limit, batchToken);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListInventoryResponse(_context);
    }

    /**
     * Provides inventory information for all inventory-enabled item
     * variations.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    limit    Optional parameter: The maximum number of inventory entries to return in a single response. This value cannot exceed 1000.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1InventoryEntry> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1InventoryEntry>> listInventoryAsync(
            final String locationId,
            final Integer limit,
            final String batchToken
    ) {
        return makeHttpCallAsync(() -> _buildListInventoryRequest(locationId, limit, batchToken),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListInventoryResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listInventory
     */
    private HttpRequest _buildListInventoryRequest(
            final String locationId,
            final Integer limit,
            final String batchToken
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/inventory");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("limit", limit);
        _queryParameters.put("batch_token", batchToken);
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
     * Processes the response for listInventory
     * @return An object of type List<V1InventoryEntry>
     */
    private List<V1InventoryEntry> _handleListInventoryResponse(HttpContext _context)
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
        List<V1InventoryEntry> _result = ApiHelper.deserializeArray(_responseBody,
                V1InventoryEntry[].class);
        return _result;
    }

    /**
     * Adjusts the current available inventory of an item variation.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    variationId    Required parameter: The ID of the variation to adjust inventory information for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1InventoryEntry response from the API call
     */
    @Deprecated
    public V1InventoryEntry adjustInventory(
            final String locationId,
            final String variationId,
            final V1AdjustInventoryRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildAdjustInventoryRequest(locationId, variationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleAdjustInventoryResponse(_context);
    }

    /**
     * Adjusts the current available inventory of an item variation.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    variationId    Required parameter: The ID of the variation to adjust inventory information for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1InventoryEntry response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1InventoryEntry> adjustInventoryAsync(
            final String locationId,
            final String variationId,
            final V1AdjustInventoryRequest body
    ) {
        return makeHttpCallAsync(() -> _buildAdjustInventoryRequest(locationId, variationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleAdjustInventoryResponse(_context));
    }

    /**
     * Builds the HttpRequest object for adjustInventory
     */
    private HttpRequest _buildAdjustInventoryRequest(
            final String locationId,
            final String variationId,
            final V1AdjustInventoryRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/inventory/{variation_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("variation_id", variationId);
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
     * Processes the response for adjustInventory
     * @return An object of type V1InventoryEntry
     */
    private V1InventoryEntry _handleAdjustInventoryResponse(HttpContext _context)
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
        V1InventoryEntry _result = ApiHelper.deserialize(_responseBody,
                V1InventoryEntry.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides summary information of all items for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list items for.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Item> response from the API call
     */
    @Deprecated
    public List<V1Item> listItems(
            final String locationId,
            final String batchToken
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListItemsRequest(locationId, batchToken);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListItemsResponse(_context);
    }

    /**
     * Provides summary information of all items for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list items for.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Item> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Item>> listItemsAsync(
            final String locationId,
            final String batchToken
    ) {
        return makeHttpCallAsync(() -> _buildListItemsRequest(locationId, batchToken),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListItemsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listItems
     */
    private HttpRequest _buildListItemsRequest(
            final String locationId,
            final String batchToken
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("batch_token", batchToken);
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
     * Processes the response for listItems
     * @return An object of type List<V1Item>
     */
    private List<V1Item> _handleListItemsResponse(HttpContext _context)
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
        List<V1Item> _result = ApiHelper.deserializeArray(_responseBody,
                V1Item[].class);
        return _result;
    }

    /**
     * Creates an item and at least one variation for it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * Item-related entities include fields you can use to associate them with
     * entities in a non-Square system.
     * When you create an item-related entity, you can optionally specify `id`.
     * This value must be unique among all IDs ever specified for the account,
     * including those specified by other applications. You can never reuse an
     * entity ID. If you do not specify an ID, Square generates one for the entity.
     * Item variations have a `user_data` string that lets you associate arbitrary
     * metadata with the variation. The string cannot exceed 255 characters.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated
    public V1Item createItem(
            final String locationId,
            final V1Item body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateItemRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateItemResponse(_context);
    }

    /**
     * Creates an item and at least one variation for it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * Item-related entities include fields you can use to associate them with
     * entities in a non-Square system.
     * When you create an item-related entity, you can optionally specify `id`.
     * This value must be unique among all IDs ever specified for the account,
     * including those specified by other applications. You can never reuse an
     * entity ID. If you do not specify an ID, Square generates one for the entity.
     * Item variations have a `user_data` string that lets you associate arbitrary
     * metadata with the variation. The string cannot exceed 255 characters.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Item> createItemAsync(
            final String locationId,
            final V1Item body
    ) {
        return makeHttpCallAsync(() -> _buildCreateItemRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateItemResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createItem
     */
    private HttpRequest _buildCreateItemRequest(
            final String locationId,
            final V1Item body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items");

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
     * Processes the response for createItem
     * @return An object of type V1Item
     */
    private V1Item _handleCreateItemResponse(HttpContext _context)
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
        V1Item _result = ApiHelper.deserialize(_responseBody,
                V1Item.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes an existing item and all item variations associated with it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteItem__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteItemRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated
    public V1Item deleteItem(
            final String locationId,
            final String itemId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteItemRequest(locationId, itemId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteItemResponse(_context);
    }

    /**
     * Deletes an existing item and all item variations associated with it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteItem__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteItemRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Item> deleteItemAsync(
            final String locationId,
            final String itemId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteItemRequest(locationId, itemId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteItemResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteItem
     */
    private HttpRequest _buildDeleteItemRequest(
            final String locationId,
            final String itemId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items/{item_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("item_id", itemId);
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
     * Processes the response for deleteItem
     * @return An object of type V1Item
     */
    private V1Item _handleDeleteItemResponse(HttpContext _context)
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
        V1Item _result = ApiHelper.deserialize(_responseBody,
                V1Item.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides the details for a single item, including associated modifier
     * lists and fees.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The item's ID.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated
    public V1Item retrieveItem(
            final String locationId,
            final String itemId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveItemRequest(locationId, itemId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveItemResponse(_context);
    }

    /**
     * Provides the details for a single item, including associated modifier
     * lists and fees.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The item's ID.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Item> retrieveItemAsync(
            final String locationId,
            final String itemId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveItemRequest(locationId, itemId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveItemResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveItem
     */
    private HttpRequest _buildRetrieveItemRequest(
            final String locationId,
            final String itemId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items/{item_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("item_id", itemId);
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
     * Processes the response for retrieveItem
     * @return An object of type V1Item
     */
    private V1Item _handleRetrieveItemResponse(HttpContext _context)
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
        V1Item _result = ApiHelper.deserialize(_responseBody,
                V1Item.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies the core details of an existing item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated
    public V1Item updateItem(
            final String locationId,
            final String itemId,
            final V1Item body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateItemRequest(locationId, itemId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateItemResponse(_context);
    }

    /**
     * Modifies the core details of an existing item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Item> updateItemAsync(
            final String locationId,
            final String itemId,
            final V1Item body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateItemRequest(locationId, itemId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateItemResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateItem
     */
    private HttpRequest _buildUpdateItemRequest(
            final String locationId,
            final String itemId,
            final V1Item body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items/{item_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("item_id", itemId);
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
     * Processes the response for updateItem
     * @return An object of type V1Item
     */
    private V1Item _handleUpdateItemResponse(HttpContext _context)
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
        V1Item _result = ApiHelper.deserialize(_responseBody,
                V1Item.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Removes a fee assocation from an item so the fee is no longer
     * automatically applied to the item in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    itemId    Required parameter: The ID of the item to add the fee to.
     * @param    feeId    Required parameter: The ID of the fee to apply.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated
    public V1Item removeFee(
            final String locationId,
            final String itemId,
            final String feeId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRemoveFeeRequest(locationId, itemId, feeId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRemoveFeeResponse(_context);
    }

    /**
     * Removes a fee assocation from an item so the fee is no longer
     * automatically applied to the item in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    itemId    Required parameter: The ID of the item to add the fee to.
     * @param    feeId    Required parameter: The ID of the fee to apply.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Item> removeFeeAsync(
            final String locationId,
            final String itemId,
            final String feeId
    ) {
        return makeHttpCallAsync(() -> _buildRemoveFeeRequest(locationId, itemId, feeId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRemoveFeeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for removeFee
     */
    private HttpRequest _buildRemoveFeeRequest(
            final String locationId,
            final String itemId,
            final String feeId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items/{item_id}/fees/{fee_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("item_id", itemId);
        _templateParameters.put("fee_id", feeId);
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
     * Processes the response for removeFee
     * @return An object of type V1Item
     */
    private V1Item _handleRemoveFeeResponse(HttpContext _context)
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
        V1Item _result = ApiHelper.deserialize(_responseBody,
                V1Item.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Associates a fee with an item so the fee is automatically applied to
     * the item in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    itemId    Required parameter: The ID of the item to add the fee to.
     * @param    feeId    Required parameter: The ID of the fee to apply.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated
    public V1Item applyFee(
            final String locationId,
            final String itemId,
            final String feeId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildApplyFeeRequest(locationId, itemId, feeId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleApplyFeeResponse(_context);
    }

    /**
     * Associates a fee with an item so the fee is automatically applied to
     * the item in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    itemId    Required parameter: The ID of the item to add the fee to.
     * @param    feeId    Required parameter: The ID of the fee to apply.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Item> applyFeeAsync(
            final String locationId,
            final String itemId,
            final String feeId
    ) {
        return makeHttpCallAsync(() -> _buildApplyFeeRequest(locationId, itemId, feeId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleApplyFeeResponse(_context));
    }

    /**
     * Builds the HttpRequest object for applyFee
     */
    private HttpRequest _buildApplyFeeRequest(
            final String locationId,
            final String itemId,
            final String feeId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items/{item_id}/fees/{fee_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("item_id", itemId);
        _templateParameters.put("fee_id", feeId);
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
        HttpRequest _request = getClientInstance().put(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for applyFee
     * @return An object of type V1Item
     */
    private V1Item _handleApplyFeeResponse(HttpContext _context)
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
        V1Item _result = ApiHelper.deserialize(_responseBody,
                V1Item.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Removes a modifier list association from an item so the modifier
     * options from the list can no longer be applied to the item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to remove.
     * @param    itemId    Required parameter: The ID of the item to remove the modifier list from.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated
    public V1Item removeModifierList(
            final String locationId,
            final String modifierListId,
            final String itemId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRemoveModifierListRequest(locationId, modifierListId, itemId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRemoveModifierListResponse(_context);
    }

    /**
     * Removes a modifier list association from an item so the modifier
     * options from the list can no longer be applied to the item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to remove.
     * @param    itemId    Required parameter: The ID of the item to remove the modifier list from.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Item> removeModifierListAsync(
            final String locationId,
            final String modifierListId,
            final String itemId
    ) {
        return makeHttpCallAsync(() -> _buildRemoveModifierListRequest(locationId, modifierListId, itemId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRemoveModifierListResponse(_context));
    }

    /**
     * Builds the HttpRequest object for removeModifierList
     */
    private HttpRequest _buildRemoveModifierListRequest(
            final String locationId,
            final String modifierListId,
            final String itemId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items/{item_id}/modifier-lists/{modifier_list_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("modifier_list_id", modifierListId);
        _templateParameters.put("item_id", itemId);
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
     * Processes the response for removeModifierList
     * @return An object of type V1Item
     */
    private V1Item _handleRemoveModifierListResponse(HttpContext _context)
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
        V1Item _result = ApiHelper.deserialize(_responseBody,
                V1Item.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Associates a modifier list with an item so the associated modifier
     * options can be applied to the item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to apply.
     * @param    itemId    Required parameter: The ID of the item to add the modifier list to.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated
    public V1Item applyModifierList(
            final String locationId,
            final String modifierListId,
            final String itemId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildApplyModifierListRequest(locationId, modifierListId, itemId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleApplyModifierListResponse(_context);
    }

    /**
     * Associates a modifier list with an item so the associated modifier
     * options can be applied to the item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to apply.
     * @param    itemId    Required parameter: The ID of the item to add the modifier list to.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Item> applyModifierListAsync(
            final String locationId,
            final String modifierListId,
            final String itemId
    ) {
        return makeHttpCallAsync(() -> _buildApplyModifierListRequest(locationId, modifierListId, itemId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleApplyModifierListResponse(_context));
    }

    /**
     * Builds the HttpRequest object for applyModifierList
     */
    private HttpRequest _buildApplyModifierListRequest(
            final String locationId,
            final String modifierListId,
            final String itemId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items/{item_id}/modifier-lists/{modifier_list_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("modifier_list_id", modifierListId);
        _templateParameters.put("item_id", itemId);
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
        HttpRequest _request = getClientInstance().put(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for applyModifierList
     * @return An object of type V1Item
     */
    private V1Item _handleApplyModifierListResponse(HttpContext _context)
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
        V1Item _result = ApiHelper.deserialize(_responseBody,
                V1Item.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Creates an item variation for an existing item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The item's ID.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Variation response from the API call
     */
    @Deprecated
    public V1Variation createVariation(
            final String locationId,
            final String itemId,
            final V1Variation body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateVariationRequest(locationId, itemId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateVariationResponse(_context);
    }

    /**
     * Creates an item variation for an existing item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The item's ID.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Variation response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Variation> createVariationAsync(
            final String locationId,
            final String itemId,
            final V1Variation body
    ) {
        return makeHttpCallAsync(() -> _buildCreateVariationRequest(locationId, itemId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateVariationResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createVariation
     */
    private HttpRequest _buildCreateVariationRequest(
            final String locationId,
            final String itemId,
            final V1Variation body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items/{item_id}/variations");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("item_id", itemId);
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
     * Processes the response for createVariation
     * @return An object of type V1Variation
     */
    private V1Variation _handleCreateVariationResponse(HttpContext _context)
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
        V1Variation _result = ApiHelper.deserialize(_responseBody,
                V1Variation.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes an existing item variation from an item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteVariation__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteVariationRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to delete.
     * @param    variationId    Required parameter: The ID of the variation to delete.
     * @return    Returns the V1Variation response from the API call
     */
    @Deprecated
    public V1Variation deleteVariation(
            final String locationId,
            final String itemId,
            final String variationId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteVariationRequest(locationId, itemId, variationId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteVariationResponse(_context);
    }

    /**
     * Deletes an existing item variation from an item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteVariation__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteVariationRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to delete.
     * @param    variationId    Required parameter: The ID of the variation to delete.
     * @return    Returns the V1Variation response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Variation> deleteVariationAsync(
            final String locationId,
            final String itemId,
            final String variationId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteVariationRequest(locationId, itemId, variationId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteVariationResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteVariation
     */
    private HttpRequest _buildDeleteVariationRequest(
            final String locationId,
            final String itemId,
            final String variationId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items/{item_id}/variations/{variation_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("item_id", itemId);
        _templateParameters.put("variation_id", variationId);
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
     * Processes the response for deleteVariation
     * @return An object of type V1Variation
     */
    private V1Variation _handleDeleteVariationResponse(HttpContext _context)
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
        V1Variation _result = ApiHelper.deserialize(_responseBody,
                V1Variation.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies the details of an existing item variation.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @param    variationId    Required parameter: The ID of the variation to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Variation response from the API call
     */
    @Deprecated
    public V1Variation updateVariation(
            final String locationId,
            final String itemId,
            final String variationId,
            final V1Variation body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateVariationRequest(locationId, itemId, variationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateVariationResponse(_context);
    }

    /**
     * Modifies the details of an existing item variation.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @param    variationId    Required parameter: The ID of the variation to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Variation response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Variation> updateVariationAsync(
            final String locationId,
            final String itemId,
            final String variationId,
            final V1Variation body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateVariationRequest(locationId, itemId, variationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateVariationResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateVariation
     */
    private HttpRequest _buildUpdateVariationRequest(
            final String locationId,
            final String itemId,
            final String variationId,
            final V1Variation body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/items/{item_id}/variations/{variation_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("item_id", itemId);
        _templateParameters.put("variation_id", variationId);
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
     * Processes the response for updateVariation
     * @return An object of type V1Variation
     */
    private V1Variation _handleUpdateVariationResponse(HttpContext _context)
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
        V1Variation _result = ApiHelper.deserialize(_responseBody,
                V1Variation.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Lists all the modifier lists for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list modifier lists for.
     * @return    Returns the List<V1ModifierList> response from the API call
     */
    @Deprecated
    public List<V1ModifierList> listModifierLists(
            final String locationId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListModifierListsRequest(locationId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListModifierListsResponse(_context);
    }

    /**
     * Lists all the modifier lists for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list modifier lists for.
     * @return    Returns the List<V1ModifierList> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1ModifierList>> listModifierListsAsync(
            final String locationId
    ) {
        return makeHttpCallAsync(() -> _buildListModifierListsRequest(locationId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListModifierListsResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listModifierLists
     */
    private HttpRequest _buildListModifierListsRequest(
            final String locationId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/modifier-lists");

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
     * Processes the response for listModifierLists
     * @return An object of type List<V1ModifierList>
     */
    private List<V1ModifierList> _handleListModifierListsResponse(HttpContext _context)
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
        List<V1ModifierList> _result = ApiHelper.deserializeArray(_responseBody,
                V1ModifierList[].class);
        return _result;
    }

    /**
     * Creates an item modifier list and at least 1 modifier option for it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a modifier list for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierList response from the API call
     */
    @Deprecated
    public V1ModifierList createModifierList(
            final String locationId,
            final V1ModifierList body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateModifierListRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateModifierListResponse(_context);
    }

    /**
     * Creates an item modifier list and at least 1 modifier option for it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a modifier list for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierList response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1ModifierList> createModifierListAsync(
            final String locationId,
            final V1ModifierList body
    ) {
        return makeHttpCallAsync(() -> _buildCreateModifierListRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateModifierListResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createModifierList
     */
    private HttpRequest _buildCreateModifierListRequest(
            final String locationId,
            final V1ModifierList body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/modifier-lists");

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
     * Processes the response for createModifierList
     * @return An object of type V1ModifierList
     */
    private V1ModifierList _handleCreateModifierListResponse(HttpContext _context)
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
        V1ModifierList _result = ApiHelper.deserialize(_responseBody,
                V1ModifierList.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes an existing item modifier list and all modifier options
     * associated with it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteModifierList__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteModifierListRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to delete.
     * @return    Returns the V1ModifierList response from the API call
     */
    @Deprecated
    public V1ModifierList deleteModifierList(
            final String locationId,
            final String modifierListId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteModifierListRequest(locationId, modifierListId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteModifierListResponse(_context);
    }

    /**
     * Deletes an existing item modifier list and all modifier options
     * associated with it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteModifierList__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteModifierListRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to delete.
     * @return    Returns the V1ModifierList response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1ModifierList> deleteModifierListAsync(
            final String locationId,
            final String modifierListId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteModifierListRequest(locationId, modifierListId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteModifierListResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteModifierList
     */
    private HttpRequest _buildDeleteModifierListRequest(
            final String locationId,
            final String modifierListId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("modifier_list_id", modifierListId);
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
     * Processes the response for deleteModifierList
     * @return An object of type V1ModifierList
     */
    private V1ModifierList _handleDeleteModifierListResponse(HttpContext _context)
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
        V1ModifierList _result = ApiHelper.deserialize(_responseBody,
                V1ModifierList.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Provides the details for a single modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The modifier list's ID.
     * @return    Returns the V1ModifierList response from the API call
     */
    @Deprecated
    public V1ModifierList retrieveModifierList(
            final String locationId,
            final String modifierListId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildRetrieveModifierListRequest(locationId, modifierListId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveModifierListResponse(_context);
    }

    /**
     * Provides the details for a single modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The modifier list's ID.
     * @return    Returns the V1ModifierList response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1ModifierList> retrieveModifierListAsync(
            final String locationId,
            final String modifierListId
    ) {
        return makeHttpCallAsync(() -> _buildRetrieveModifierListRequest(locationId, modifierListId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleRetrieveModifierListResponse(_context));
    }

    /**
     * Builds the HttpRequest object for retrieveModifierList
     */
    private HttpRequest _buildRetrieveModifierListRequest(
            final String locationId,
            final String modifierListId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("modifier_list_id", modifierListId);
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
     * Processes the response for retrieveModifierList
     * @return An object of type V1ModifierList
     */
    private V1ModifierList _handleRetrieveModifierListResponse(HttpContext _context)
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
        V1ModifierList _result = ApiHelper.deserialize(_responseBody,
                V1ModifierList.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies the details of an existing item modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierList response from the API call
     */
    @Deprecated
    public V1ModifierList updateModifierList(
            final String locationId,
            final String modifierListId,
            final V1UpdateModifierListRequest body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateModifierListRequest(locationId, modifierListId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateModifierListResponse(_context);
    }

    /**
     * Modifies the details of an existing item modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierList response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1ModifierList> updateModifierListAsync(
            final String locationId,
            final String modifierListId,
            final V1UpdateModifierListRequest body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateModifierListRequest(locationId, modifierListId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateModifierListResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateModifierList
     */
    private HttpRequest _buildUpdateModifierListRequest(
            final String locationId,
            final String modifierListId,
            final V1UpdateModifierListRequest body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("modifier_list_id", modifierListId);
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
     * Processes the response for updateModifierList
     * @return An object of type V1ModifierList
     */
    private V1ModifierList _handleUpdateModifierListResponse(HttpContext _context)
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
        V1ModifierList _result = ApiHelper.deserialize(_responseBody,
                V1ModifierList.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Creates an item modifier option and adds it to a modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierOption response from the API call
     */
    @Deprecated
    public V1ModifierOption createModifierOption(
            final String locationId,
            final String modifierListId,
            final V1ModifierOption body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreateModifierOptionRequest(locationId, modifierListId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateModifierOptionResponse(_context);
    }

    /**
     * Creates an item modifier option and adds it to a modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierOption response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1ModifierOption> createModifierOptionAsync(
            final String locationId,
            final String modifierListId,
            final V1ModifierOption body
    ) {
        return makeHttpCallAsync(() -> _buildCreateModifierOptionRequest(locationId, modifierListId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreateModifierOptionResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createModifierOption
     */
    private HttpRequest _buildCreateModifierOptionRequest(
            final String locationId,
            final String modifierListId,
            final V1ModifierOption body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}/modifier-options");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("modifier_list_id", modifierListId);
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
     * Processes the response for createModifierOption
     * @return An object of type V1ModifierOption
     */
    private V1ModifierOption _handleCreateModifierOptionResponse(HttpContext _context)
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
        V1ModifierOption _result = ApiHelper.deserialize(_responseBody,
                V1ModifierOption.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes an existing item modifier option from a modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteModifierOption__ returns nothing on success but Connect
     * SDKs map the empty response to an empty `V1DeleteModifierOptionRequest`
     * object.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to delete.
     * @param    modifierOptionId    Required parameter: The ID of the modifier list to edit.
     * @return    Returns the V1ModifierOption response from the API call
     */
    @Deprecated
    public V1ModifierOption deleteModifierOption(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeleteModifierOptionRequest(locationId, modifierListId, modifierOptionId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteModifierOptionResponse(_context);
    }

    /**
     * Deletes an existing item modifier option from a modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteModifierOption__ returns nothing on success but Connect
     * SDKs map the empty response to an empty `V1DeleteModifierOptionRequest`
     * object.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to delete.
     * @param    modifierOptionId    Required parameter: The ID of the modifier list to edit.
     * @return    Returns the V1ModifierOption response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1ModifierOption> deleteModifierOptionAsync(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId
    ) {
        return makeHttpCallAsync(() -> _buildDeleteModifierOptionRequest(locationId, modifierListId, modifierOptionId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeleteModifierOptionResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deleteModifierOption
     */
    private HttpRequest _buildDeleteModifierOptionRequest(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}/modifier-options/{modifier_option_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("modifier_list_id", modifierListId);
        _templateParameters.put("modifier_option_id", modifierOptionId);
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
     * Processes the response for deleteModifierOption
     * @return An object of type V1ModifierOption
     */
    private V1ModifierOption _handleDeleteModifierOptionResponse(HttpContext _context)
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
        V1ModifierOption _result = ApiHelper.deserialize(_responseBody,
                V1ModifierOption.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies the details of an existing item modifier option.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    modifierOptionId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierOption response from the API call
     */
    @Deprecated
    public V1ModifierOption updateModifierOption(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId,
            final V1ModifierOption body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdateModifierOptionRequest(locationId, modifierListId, modifierOptionId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateModifierOptionResponse(_context);
    }

    /**
     * Modifies the details of an existing item modifier option.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    modifierOptionId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierOption response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1ModifierOption> updateModifierOptionAsync(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId,
            final V1ModifierOption body
    ) {
        return makeHttpCallAsync(() -> _buildUpdateModifierOptionRequest(locationId, modifierListId, modifierOptionId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdateModifierOptionResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updateModifierOption
     */
    private HttpRequest _buildUpdateModifierOptionRequest(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId,
            final V1ModifierOption body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}/modifier-options/{modifier_option_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("modifier_list_id", modifierListId);
        _templateParameters.put("modifier_option_id", modifierOptionId);
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
     * Processes the response for updateModifierOption
     * @return An object of type V1ModifierOption
     */
    private V1ModifierOption _handleUpdateModifierOptionResponse(HttpContext _context)
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
        V1ModifierOption _result = ApiHelper.deserialize(_responseBody,
                V1ModifierOption.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Lists all Favorites pages (in Square Point of Sale) for a given
     * location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list Favorites pages for.
     * @return    Returns the List<V1Page> response from the API call
     */
    @Deprecated
    public List<V1Page> listPages(
            final String locationId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildListPagesRequest(locationId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListPagesResponse(_context);
    }

    /**
     * Lists all Favorites pages (in Square Point of Sale) for a given
     * location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list Favorites pages for.
     * @return    Returns the List<V1Page> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Page>> listPagesAsync(
            final String locationId
    ) {
        return makeHttpCallAsync(() -> _buildListPagesRequest(locationId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleListPagesResponse(_context));
    }

    /**
     * Builds the HttpRequest object for listPages
     */
    private HttpRequest _buildListPagesRequest(
            final String locationId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/pages");

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
     * Processes the response for listPages
     * @return An object of type List<V1Page>
     */
    private List<V1Page> _handleListPagesResponse(HttpContext _context)
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
        List<V1Page> _result = ApiHelper.deserializeArray(_responseBody,
                V1Page[].class);
        return _result;
    }

    /**
     * Creates a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated
    public V1Page createPage(
            final String locationId,
            final V1Page body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildCreatePageRequest(locationId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreatePageResponse(_context);
    }

    /**
     * Creates a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Page> createPageAsync(
            final String locationId,
            final V1Page body
    ) {
        return makeHttpCallAsync(() -> _buildCreatePageRequest(locationId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleCreatePageResponse(_context));
    }

    /**
     * Builds the HttpRequest object for createPage
     */
    private HttpRequest _buildCreatePageRequest(
            final String locationId,
            final V1Page body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/pages");

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
     * Processes the response for createPage
     * @return An object of type V1Page
     */
    private V1Page _handleCreatePageResponse(HttpContext _context)
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
        V1Page _result = ApiHelper.deserialize(_responseBody,
                V1Page.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes an existing Favorites page and all of its cells.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeletePage__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeletePageRequest` object.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page to delete.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated
    public V1Page deletePage(
            final String locationId,
            final String pageId
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeletePageRequest(locationId, pageId);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeletePageResponse(_context);
    }

    /**
     * Deletes an existing Favorites page and all of its cells.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeletePage__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeletePageRequest` object.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page to delete.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Page> deletePageAsync(
            final String locationId,
            final String pageId
    ) {
        return makeHttpCallAsync(() -> _buildDeletePageRequest(locationId, pageId),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeletePageResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deletePage
     */
    private HttpRequest _buildDeletePageRequest(
            final String locationId,
            final String pageId
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/pages/{page_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("page_id", pageId);
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
     * Processes the response for deletePage
     * @return An object of type V1Page
     */
    private V1Page _handleDeletePageResponse(HttpContext _context)
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
        V1Page _result = ApiHelper.deserialize(_responseBody,
                V1Page.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies the details of a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location
     * @param    pageId    Required parameter: The ID of the page to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated
    public V1Page updatePage(
            final String locationId,
            final String pageId,
            final V1Page body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdatePageRequest(locationId, pageId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdatePageResponse(_context);
    }

    /**
     * Modifies the details of a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location
     * @param    pageId    Required parameter: The ID of the page to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Page> updatePageAsync(
            final String locationId,
            final String pageId,
            final V1Page body
    ) {
        return makeHttpCallAsync(() -> _buildUpdatePageRequest(locationId, pageId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdatePageResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updatePage
     */
    private HttpRequest _buildUpdatePageRequest(
            final String locationId,
            final String pageId,
            final V1Page body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/pages/{page_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("page_id", pageId);
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
     * Processes the response for updatePage
     * @return An object of type V1Page
     */
    private V1Page _handleUpdatePageResponse(HttpContext _context)
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
        V1Page _result = ApiHelper.deserialize(_responseBody,
                V1Page.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Deletes a cell from a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeletePageCell__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeletePageCellRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page to delete.
     * @param    row    Optional parameter: The row of the cell to clear. Always an integer between 0 and 4, inclusive. Row 0 is the top row.
     * @param    column    Optional parameter: The column of the cell to clear. Always an integer between 0 and 4, inclusive. Column 0 is the leftmost column.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated
    public V1Page deletePageCell(
            final String locationId,
            final String pageId,
            final String row,
            final String column
    ) throws ApiException, IOException {
        HttpRequest _request = _buildDeletePageCellRequest(locationId, pageId, row, column);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeletePageCellResponse(_context);
    }

    /**
     * Deletes a cell from a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeletePageCell__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeletePageCellRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page to delete.
     * @param    row    Optional parameter: The row of the cell to clear. Always an integer between 0 and 4, inclusive. Row 0 is the top row.
     * @param    column    Optional parameter: The column of the cell to clear. Always an integer between 0 and 4, inclusive. Column 0 is the leftmost column.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Page> deletePageCellAsync(
            final String locationId,
            final String pageId,
            final String row,
            final String column
    ) {
        return makeHttpCallAsync(() -> _buildDeletePageCellRequest(locationId, pageId, row, column),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleDeletePageCellResponse(_context));
    }

    /**
     * Builds the HttpRequest object for deletePageCell
     */
    private HttpRequest _buildDeletePageCellRequest(
            final String locationId,
            final String pageId,
            final String row,
            final String column
    ) {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/pages/{page_id}/cells");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("page_id", pageId);
        ApiHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters, true);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("row", row);
        _queryParameters.put("column", column);
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
        HttpRequest _request = getClientInstance().delete(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for deletePageCell
     * @return An object of type V1Page
     */
    private V1Page _handleDeletePageCellResponse(HttpContext _context)
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
        V1Page _result = ApiHelper.deserialize(_responseBody,
                V1Page.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

    /**
     * Modifies a cell of a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page the cell belongs to.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated
    public V1Page updatePageCell(
            final String locationId,
            final String pageId,
            final V1PageCell body
    ) throws ApiException, IOException {
        HttpRequest _request = _buildUpdatePageCellRequest(locationId, pageId, body);
        authManagers.get("default").apply(_request);

        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdatePageCellResponse(_context);
    }

    /**
     * Modifies a cell of a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page the cell belongs to.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Page> updatePageCellAsync(
            final String locationId,
            final String pageId,
            final V1PageCell body
    ) {
        return makeHttpCallAsync(() -> _buildUpdatePageCellRequest(locationId, pageId, body),
                _req -> authManagers.get("default").applyAsync(_req)
                    .thenCompose(_request -> getClientInstance().executeAsStringAsync(_request)),
                _context -> _handleUpdatePageCellResponse(_context));
    }

    /**
     * Builds the HttpRequest object for updatePageCell
     */
    private HttpRequest _buildUpdatePageCellRequest(
            final String locationId,
            final String pageId,
            final V1PageCell body
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/{location_id}/pages/{page_id}/cells");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("location_id", locationId);
        _templateParameters.put("page_id", pageId);
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
     * Processes the response for updatePageCell
     * @return An object of type V1Page
     */
    private V1Page _handleUpdatePageCellResponse(HttpContext _context)
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
        V1Page _result = ApiHelper.deserialize(_responseBody,
                V1Page.class);

        _result = _result.toBuilder().httpContext(_context).build();
        return _result;
    }

}
