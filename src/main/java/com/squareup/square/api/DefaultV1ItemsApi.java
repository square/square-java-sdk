package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import com.squareup.square.models.V1AdjustInventoryRequest;
import com.squareup.square.models.V1Category;
import com.squareup.square.models.V1Discount;
import com.squareup.square.models.V1Fee;
import com.squareup.square.models.V1InventoryEntry;
import com.squareup.square.models.V1Item;
import com.squareup.square.models.V1ModifierList;
import com.squareup.square.models.V1ModifierOption;
import com.squareup.square.models.V1Page;
import com.squareup.square.models.V1PageCell;
import com.squareup.square.models.V1UpdateModifierListRequest;
import com.squareup.square.models.V1Variation;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultV1ItemsApi extends BaseApi implements V1ItemsApi {

    /**
     * Initializes the controller.
     * @param config
     * @param httpClient
     * @param authManagers
     */
    public DefaultV1ItemsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config
     * @param httpClient
     * @param authManagers
     * @param httpCallback
     */
    public DefaultV1ItemsApi(Configuration config, HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists all the item categories for a given location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Category> response from the API call
     */
    @Deprecated
    public List<V1Category> listCategories(
            final String locationId) throws ApiException, IOException {
        HttpRequest request = buildListCategoriesRequest(locationId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListCategoriesResponse(context);
    }

    /**
     * Lists all the item categories for a given location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Category> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Category>> listCategoriesAsync(
            final String locationId) {
        return makeHttpCallAsync(() -> buildListCategoriesRequest(locationId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListCategoriesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCategories
     */
    private HttpRequest buildListCategoriesRequest(
            final String locationId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/categories");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for listCategories
     * @return An object of type List<V1Category>
     */
    private List<V1Category> handleListCategoriesResponse(HttpContext context)
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
        List<V1Category> result = ApiHelper.deserializeArray(responseBody,
                V1Category[].class);
        return result;
    }

    /**
     * Creates an item category.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Category response from the API call
     */
    @Deprecated
    public V1Category createCategory(
            final String locationId,
            final V1Category body) throws ApiException, IOException {
        HttpRequest request = buildCreateCategoryRequest(locationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateCategoryResponse(context);
    }

    /**
     * Creates an item category.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Category response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Category> createCategoryAsync(
            final String locationId,
            final V1Category body) {
        return makeHttpCallAsync(() -> buildCreateCategoryRequest(locationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateCategoryResponse(context));
    }

    /**
     * Builds the HttpRequest object for createCategory
     */
    private HttpRequest buildCreateCategoryRequest(
            final String locationId,
            final V1Category body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/categories");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createCategory
     * @return An object of type V1Category
     */
    private V1Category handleCreateCategoryResponse(HttpContext context)
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
        V1Category result = ApiHelper.deserialize(responseBody,
                V1Category.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes an existing item category.
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
            final String categoryId) throws ApiException, IOException {
        HttpRequest request = buildDeleteCategoryRequest(locationId, categoryId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteCategoryResponse(context);
    }

    /**
     * Deletes an existing item category.
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
            final String categoryId) {
        return makeHttpCallAsync(() -> buildDeleteCategoryRequest(locationId, categoryId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteCategoryResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteCategory
     */
    private HttpRequest buildDeleteCategoryRequest(
            final String locationId,
            final String categoryId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/categories/{category_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("category_id", categoryId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteCategory
     * @return An object of type V1Category
     */
    private V1Category handleDeleteCategoryResponse(HttpContext context)
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
        V1Category result = ApiHelper.deserialize(responseBody,
                V1Category.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the details of an existing item category.
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
            final V1Category body) throws ApiException, IOException {
        HttpRequest request = buildUpdateCategoryRequest(locationId, categoryId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateCategoryResponse(context);
    }

    /**
     * Modifies the details of an existing item category.
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
            final V1Category body) {
        return makeHttpCallAsync(() -> buildUpdateCategoryRequest(locationId, categoryId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateCategoryResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateCategory
     */
    private HttpRequest buildUpdateCategoryRequest(
            final String locationId,
            final String categoryId,
            final V1Category body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/categories/{category_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("category_id", categoryId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateCategory
     * @return An object of type V1Category
     */
    private V1Category handleUpdateCategoryResponse(HttpContext context)
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
        V1Category result = ApiHelper.deserialize(responseBody,
                V1Category.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Lists all the discounts for a given location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Discount> response from the API call
     */
    @Deprecated
    public List<V1Discount> listDiscounts(
            final String locationId) throws ApiException, IOException {
        HttpRequest request = buildListDiscountsRequest(locationId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListDiscountsResponse(context);
    }

    /**
     * Lists all the discounts for a given location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Discount> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Discount>> listDiscountsAsync(
            final String locationId) {
        return makeHttpCallAsync(() -> buildListDiscountsRequest(locationId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListDiscountsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listDiscounts
     */
    private HttpRequest buildListDiscountsRequest(
            final String locationId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/discounts");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for listDiscounts
     * @return An object of type List<V1Discount>
     */
    private List<V1Discount> handleListDiscountsResponse(HttpContext context)
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
        List<V1Discount> result = ApiHelper.deserializeArray(responseBody,
                V1Discount[].class);
        return result;
    }

    /**
     * Creates a discount.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Discount response from the API call
     */
    @Deprecated
    public V1Discount createDiscount(
            final String locationId,
            final V1Discount body) throws ApiException, IOException {
        HttpRequest request = buildCreateDiscountRequest(locationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateDiscountResponse(context);
    }

    /**
     * Creates a discount.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Discount response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Discount> createDiscountAsync(
            final String locationId,
            final V1Discount body) {
        return makeHttpCallAsync(() -> buildCreateDiscountRequest(locationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateDiscountResponse(context));
    }

    /**
     * Builds the HttpRequest object for createDiscount
     */
    private HttpRequest buildCreateDiscountRequest(
            final String locationId,
            final V1Discount body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/discounts");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createDiscount
     * @return An object of type V1Discount
     */
    private V1Discount handleCreateDiscountResponse(HttpContext context)
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
        V1Discount result = ApiHelper.deserialize(responseBody,
                V1Discount.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes an existing discount.
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
            final String discountId) throws ApiException, IOException {
        HttpRequest request = buildDeleteDiscountRequest(locationId, discountId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteDiscountResponse(context);
    }

    /**
     * Deletes an existing discount.
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
            final String discountId) {
        return makeHttpCallAsync(() -> buildDeleteDiscountRequest(locationId, discountId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteDiscountResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteDiscount
     */
    private HttpRequest buildDeleteDiscountRequest(
            final String locationId,
            final String discountId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/discounts/{discount_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("discount_id", discountId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteDiscount
     * @return An object of type V1Discount
     */
    private V1Discount handleDeleteDiscountResponse(HttpContext context)
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
        V1Discount result = ApiHelper.deserialize(responseBody,
                V1Discount.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the details of an existing discount.
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
            final V1Discount body) throws ApiException, IOException {
        HttpRequest request = buildUpdateDiscountRequest(locationId, discountId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateDiscountResponse(context);
    }

    /**
     * Modifies the details of an existing discount.
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
            final V1Discount body) {
        return makeHttpCallAsync(() -> buildUpdateDiscountRequest(locationId, discountId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateDiscountResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateDiscount
     */
    private HttpRequest buildUpdateDiscountRequest(
            final String locationId,
            final String discountId,
            final V1Discount body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/discounts/{discount_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("discount_id", discountId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateDiscount
     * @return An object of type V1Discount
     */
    private V1Discount handleUpdateDiscountResponse(HttpContext context)
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
        V1Discount result = ApiHelper.deserialize(responseBody,
                V1Discount.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Lists all the fees (taxes) for a given location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list fees for.
     * @return    Returns the List<V1Fee> response from the API call
     */
    @Deprecated
    public List<V1Fee> listFees(
            final String locationId) throws ApiException, IOException {
        HttpRequest request = buildListFeesRequest(locationId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListFeesResponse(context);
    }

    /**
     * Lists all the fees (taxes) for a given location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list fees for.
     * @return    Returns the List<V1Fee> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Fee>> listFeesAsync(
            final String locationId) {
        return makeHttpCallAsync(() -> buildListFeesRequest(locationId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListFeesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listFees
     */
    private HttpRequest buildListFeesRequest(
            final String locationId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/fees");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for listFees
     * @return An object of type List<V1Fee>
     */
    private List<V1Fee> handleListFeesResponse(HttpContext context)
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
        List<V1Fee> result = ApiHelper.deserializeArray(responseBody,
                V1Fee[].class);
        return result;
    }

    /**
     * Creates a fee (tax).
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a fee for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Fee response from the API call
     */
    @Deprecated
    public V1Fee createFee(
            final String locationId,
            final V1Fee body) throws ApiException, IOException {
        HttpRequest request = buildCreateFeeRequest(locationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateFeeResponse(context);
    }

    /**
     * Creates a fee (tax).
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a fee for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Fee response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Fee> createFeeAsync(
            final String locationId,
            final V1Fee body) {
        return makeHttpCallAsync(() -> buildCreateFeeRequest(locationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateFeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for createFee
     */
    private HttpRequest buildCreateFeeRequest(
            final String locationId,
            final V1Fee body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/fees");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createFee
     * @return An object of type V1Fee
     */
    private V1Fee handleCreateFeeResponse(HttpContext context)
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
        V1Fee result = ApiHelper.deserialize(responseBody,
                V1Fee.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes an existing fee (tax).
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
            final String feeId) throws ApiException, IOException {
        HttpRequest request = buildDeleteFeeRequest(locationId, feeId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteFeeResponse(context);
    }

    /**
     * Deletes an existing fee (tax).
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
            final String feeId) {
        return makeHttpCallAsync(() -> buildDeleteFeeRequest(locationId, feeId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteFeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteFee
     */
    private HttpRequest buildDeleteFeeRequest(
            final String locationId,
            final String feeId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/fees/{fee_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("fee_id", feeId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteFee
     * @return An object of type V1Fee
     */
    private V1Fee handleDeleteFeeResponse(HttpContext context)
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
        V1Fee result = ApiHelper.deserialize(responseBody,
                V1Fee.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the details of an existing fee (tax).
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
            final V1Fee body) throws ApiException, IOException {
        HttpRequest request = buildUpdateFeeRequest(locationId, feeId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateFeeResponse(context);
    }

    /**
     * Modifies the details of an existing fee (tax).
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
            final V1Fee body) {
        return makeHttpCallAsync(() -> buildUpdateFeeRequest(locationId, feeId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateFeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateFee
     */
    private HttpRequest buildUpdateFeeRequest(
            final String locationId,
            final String feeId,
            final V1Fee body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/fees/{fee_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("fee_id", feeId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateFee
     * @return An object of type V1Fee
     */
    private V1Fee handleUpdateFeeResponse(HttpContext context)
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
        V1Fee result = ApiHelper.deserialize(responseBody,
                V1Fee.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides inventory information for all inventory-enabled item
     * variations.
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
            final String batchToken) throws ApiException, IOException {
        HttpRequest request = buildListInventoryRequest(locationId, limit, batchToken);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListInventoryResponse(context);
    }

    /**
     * Provides inventory information for all inventory-enabled item
     * variations.
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
            final String batchToken) {
        return makeHttpCallAsync(() -> buildListInventoryRequest(locationId, limit, batchToken),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListInventoryResponse(context));
    }

    /**
     * Builds the HttpRequest object for listInventory
     */
    private HttpRequest buildListInventoryRequest(
            final String locationId,
            final Integer limit,
            final String batchToken) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/inventory");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("limit", limit);
        queryParameters.put("batch_token", batchToken);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for listInventory
     * @return An object of type List<V1InventoryEntry>
     */
    private List<V1InventoryEntry> handleListInventoryResponse(HttpContext context)
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
        List<V1InventoryEntry> result = ApiHelper.deserializeArray(responseBody,
                V1InventoryEntry[].class);
        return result;
    }

    /**
     * Adjusts the current available inventory of an item variation.
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
            final V1AdjustInventoryRequest body) throws ApiException, IOException {
        HttpRequest request = buildAdjustInventoryRequest(locationId, variationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleAdjustInventoryResponse(context);
    }

    /**
     * Adjusts the current available inventory of an item variation.
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
            final V1AdjustInventoryRequest body) {
        return makeHttpCallAsync(() -> buildAdjustInventoryRequest(locationId, variationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleAdjustInventoryResponse(context));
    }

    /**
     * Builds the HttpRequest object for adjustInventory
     */
    private HttpRequest buildAdjustInventoryRequest(
            final String locationId,
            final String variationId,
            final V1AdjustInventoryRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/inventory/{variation_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("variation_id", variationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for adjustInventory
     * @return An object of type V1InventoryEntry
     */
    private V1InventoryEntry handleAdjustInventoryResponse(HttpContext context)
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
        V1InventoryEntry result = ApiHelper.deserialize(responseBody,
                V1InventoryEntry.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides summary information of all items for a given location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list items for.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Item> response from the API call
     */
    @Deprecated
    public List<V1Item> listItems(
            final String locationId,
            final String batchToken) throws ApiException, IOException {
        HttpRequest request = buildListItemsRequest(locationId, batchToken);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListItemsResponse(context);
    }

    /**
     * Provides summary information of all items for a given location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list items for.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Item> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Item>> listItemsAsync(
            final String locationId,
            final String batchToken) {
        return makeHttpCallAsync(() -> buildListItemsRequest(locationId, batchToken),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListItemsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listItems
     */
    private HttpRequest buildListItemsRequest(
            final String locationId,
            final String batchToken) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("batch_token", batchToken);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for listItems
     * @return An object of type List<V1Item>
     */
    private List<V1Item> handleListItemsResponse(HttpContext context)
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
        List<V1Item> result = ApiHelper.deserializeArray(responseBody,
                V1Item[].class);
        return result;
    }

    /**
     * Creates an item and at least one variation for it.
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
            final V1Item body) throws ApiException, IOException {
        HttpRequest request = buildCreateItemRequest(locationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateItemResponse(context);
    }

    /**
     * Creates an item and at least one variation for it.
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
            final V1Item body) {
        return makeHttpCallAsync(() -> buildCreateItemRequest(locationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateItemResponse(context));
    }

    /**
     * Builds the HttpRequest object for createItem
     */
    private HttpRequest buildCreateItemRequest(
            final String locationId,
            final V1Item body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createItem
     * @return An object of type V1Item
     */
    private V1Item handleCreateItemResponse(HttpContext context)
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
        V1Item result = ApiHelper.deserialize(responseBody,
                V1Item.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes an existing item and all item variations associated with it.
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
            final String itemId) throws ApiException, IOException {
        HttpRequest request = buildDeleteItemRequest(locationId, itemId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteItemResponse(context);
    }

    /**
     * Deletes an existing item and all item variations associated with it.
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
            final String itemId) {
        return makeHttpCallAsync(() -> buildDeleteItemRequest(locationId, itemId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteItemResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteItem
     */
    private HttpRequest buildDeleteItemRequest(
            final String locationId,
            final String itemId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items/{item_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("item_id", itemId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteItem
     * @return An object of type V1Item
     */
    private V1Item handleDeleteItemResponse(HttpContext context)
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
        V1Item result = ApiHelper.deserialize(responseBody,
                V1Item.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides the details for a single item, including associated modifier
     * lists and fees.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The item's ID.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated
    public V1Item retrieveItem(
            final String locationId,
            final String itemId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveItemRequest(locationId, itemId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveItemResponse(context);
    }

    /**
     * Provides the details for a single item, including associated modifier
     * lists and fees.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The item's ID.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Item> retrieveItemAsync(
            final String locationId,
            final String itemId) {
        return makeHttpCallAsync(() -> buildRetrieveItemRequest(locationId, itemId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveItemResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveItem
     */
    private HttpRequest buildRetrieveItemRequest(
            final String locationId,
            final String itemId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items/{item_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("item_id", itemId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for retrieveItem
     * @return An object of type V1Item
     */
    private V1Item handleRetrieveItemResponse(HttpContext context)
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
        V1Item result = ApiHelper.deserialize(responseBody,
                V1Item.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the core details of an existing item.
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
            final V1Item body) throws ApiException, IOException {
        HttpRequest request = buildUpdateItemRequest(locationId, itemId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateItemResponse(context);
    }

    /**
     * Modifies the core details of an existing item.
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
            final V1Item body) {
        return makeHttpCallAsync(() -> buildUpdateItemRequest(locationId, itemId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateItemResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateItem
     */
    private HttpRequest buildUpdateItemRequest(
            final String locationId,
            final String itemId,
            final V1Item body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items/{item_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("item_id", itemId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateItem
     * @return An object of type V1Item
     */
    private V1Item handleUpdateItemResponse(HttpContext context)
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
        V1Item result = ApiHelper.deserialize(responseBody,
                V1Item.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Removes a fee assocation from an item so the fee is no longer
     * automatically applied to the item in Square Point of Sale.
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
            final String feeId) throws ApiException, IOException {
        HttpRequest request = buildRemoveFeeRequest(locationId, itemId, feeId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRemoveFeeResponse(context);
    }

    /**
     * Removes a fee assocation from an item so the fee is no longer
     * automatically applied to the item in Square Point of Sale.
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
            final String feeId) {
        return makeHttpCallAsync(() -> buildRemoveFeeRequest(locationId, itemId, feeId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRemoveFeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for removeFee
     */
    private HttpRequest buildRemoveFeeRequest(
            final String locationId,
            final String itemId,
            final String feeId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items/{item_id}/fees/{fee_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("item_id", itemId);
        templateParameters.put("fee_id", feeId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for removeFee
     * @return An object of type V1Item
     */
    private V1Item handleRemoveFeeResponse(HttpContext context)
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
        V1Item result = ApiHelper.deserialize(responseBody,
                V1Item.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Associates a fee with an item so the fee is automatically applied to
     * the item in Square Point of Sale.
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
            final String feeId) throws ApiException, IOException {
        HttpRequest request = buildApplyFeeRequest(locationId, itemId, feeId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleApplyFeeResponse(context);
    }

    /**
     * Associates a fee with an item so the fee is automatically applied to
     * the item in Square Point of Sale.
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
            final String feeId) {
        return makeHttpCallAsync(() -> buildApplyFeeRequest(locationId, itemId, feeId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleApplyFeeResponse(context));
    }

    /**
     * Builds the HttpRequest object for applyFee
     */
    private HttpRequest buildApplyFeeRequest(
            final String locationId,
            final String itemId,
            final String feeId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items/{item_id}/fees/{fee_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("item_id", itemId);
        templateParameters.put("fee_id", feeId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().put(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for applyFee
     * @return An object of type V1Item
     */
    private V1Item handleApplyFeeResponse(HttpContext context)
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
        V1Item result = ApiHelper.deserialize(responseBody,
                V1Item.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Removes a modifier list association from an item so the modifier
     * options from the list can no longer be applied to the item.
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
            final String itemId) throws ApiException, IOException {
        HttpRequest request = buildRemoveModifierListRequest(locationId, modifierListId, itemId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRemoveModifierListResponse(context);
    }

    /**
     * Removes a modifier list association from an item so the modifier
     * options from the list can no longer be applied to the item.
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
            final String itemId) {
        return makeHttpCallAsync(() -> buildRemoveModifierListRequest(locationId, modifierListId, itemId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRemoveModifierListResponse(context));
    }

    /**
     * Builds the HttpRequest object for removeModifierList
     */
    private HttpRequest buildRemoveModifierListRequest(
            final String locationId,
            final String modifierListId,
            final String itemId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items/{item_id}/modifier-lists/{modifier_list_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("modifier_list_id", modifierListId);
        templateParameters.put("item_id", itemId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for removeModifierList
     * @return An object of type V1Item
     */
    private V1Item handleRemoveModifierListResponse(HttpContext context)
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
        V1Item result = ApiHelper.deserialize(responseBody,
                V1Item.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Associates a modifier list with an item so the associated modifier
     * options can be applied to the item.
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
            final String itemId) throws ApiException, IOException {
        HttpRequest request = buildApplyModifierListRequest(locationId, modifierListId, itemId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleApplyModifierListResponse(context);
    }

    /**
     * Associates a modifier list with an item so the associated modifier
     * options can be applied to the item.
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
            final String itemId) {
        return makeHttpCallAsync(() -> buildApplyModifierListRequest(locationId, modifierListId, itemId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleApplyModifierListResponse(context));
    }

    /**
     * Builds the HttpRequest object for applyModifierList
     */
    private HttpRequest buildApplyModifierListRequest(
            final String locationId,
            final String modifierListId,
            final String itemId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items/{item_id}/modifier-lists/{modifier_list_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("modifier_list_id", modifierListId);
        templateParameters.put("item_id", itemId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().put(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for applyModifierList
     * @return An object of type V1Item
     */
    private V1Item handleApplyModifierListResponse(HttpContext context)
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
        V1Item result = ApiHelper.deserialize(responseBody,
                V1Item.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates an item variation for an existing item.
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
            final V1Variation body) throws ApiException, IOException {
        HttpRequest request = buildCreateVariationRequest(locationId, itemId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateVariationResponse(context);
    }

    /**
     * Creates an item variation for an existing item.
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
            final V1Variation body) {
        return makeHttpCallAsync(() -> buildCreateVariationRequest(locationId, itemId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateVariationResponse(context));
    }

    /**
     * Builds the HttpRequest object for createVariation
     */
    private HttpRequest buildCreateVariationRequest(
            final String locationId,
            final String itemId,
            final V1Variation body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items/{item_id}/variations");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("item_id", itemId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createVariation
     * @return An object of type V1Variation
     */
    private V1Variation handleCreateVariationResponse(HttpContext context)
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
        V1Variation result = ApiHelper.deserialize(responseBody,
                V1Variation.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes an existing item variation from an item.
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
            final String variationId) throws ApiException, IOException {
        HttpRequest request = buildDeleteVariationRequest(locationId, itemId, variationId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteVariationResponse(context);
    }

    /**
     * Deletes an existing item variation from an item.
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
            final String variationId) {
        return makeHttpCallAsync(() -> buildDeleteVariationRequest(locationId, itemId, variationId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteVariationResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteVariation
     */
    private HttpRequest buildDeleteVariationRequest(
            final String locationId,
            final String itemId,
            final String variationId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items/{item_id}/variations/{variation_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("item_id", itemId);
        templateParameters.put("variation_id", variationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteVariation
     * @return An object of type V1Variation
     */
    private V1Variation handleDeleteVariationResponse(HttpContext context)
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
        V1Variation result = ApiHelper.deserialize(responseBody,
                V1Variation.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the details of an existing item variation.
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
            final V1Variation body) throws ApiException, IOException {
        HttpRequest request = buildUpdateVariationRequest(locationId, itemId, variationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateVariationResponse(context);
    }

    /**
     * Modifies the details of an existing item variation.
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
            final V1Variation body) {
        return makeHttpCallAsync(() -> buildUpdateVariationRequest(locationId, itemId, variationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateVariationResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateVariation
     */
    private HttpRequest buildUpdateVariationRequest(
            final String locationId,
            final String itemId,
            final String variationId,
            final V1Variation body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/items/{item_id}/variations/{variation_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("item_id", itemId);
        templateParameters.put("variation_id", variationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateVariation
     * @return An object of type V1Variation
     */
    private V1Variation handleUpdateVariationResponse(HttpContext context)
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
        V1Variation result = ApiHelper.deserialize(responseBody,
                V1Variation.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Lists all the modifier lists for a given location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list modifier lists for.
     * @return    Returns the List<V1ModifierList> response from the API call
     */
    @Deprecated
    public List<V1ModifierList> listModifierLists(
            final String locationId) throws ApiException, IOException {
        HttpRequest request = buildListModifierListsRequest(locationId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListModifierListsResponse(context);
    }

    /**
     * Lists all the modifier lists for a given location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list modifier lists for.
     * @return    Returns the List<V1ModifierList> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1ModifierList>> listModifierListsAsync(
            final String locationId) {
        return makeHttpCallAsync(() -> buildListModifierListsRequest(locationId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListModifierListsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listModifierLists
     */
    private HttpRequest buildListModifierListsRequest(
            final String locationId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/modifier-lists");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for listModifierLists
     * @return An object of type List<V1ModifierList>
     */
    private List<V1ModifierList> handleListModifierListsResponse(HttpContext context)
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
        List<V1ModifierList> result = ApiHelper.deserializeArray(responseBody,
                V1ModifierList[].class);
        return result;
    }

    /**
     * Creates an item modifier list and at least 1 modifier option for it.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a modifier list for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierList response from the API call
     */
    @Deprecated
    public V1ModifierList createModifierList(
            final String locationId,
            final V1ModifierList body) throws ApiException, IOException {
        HttpRequest request = buildCreateModifierListRequest(locationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateModifierListResponse(context);
    }

    /**
     * Creates an item modifier list and at least 1 modifier option for it.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a modifier list for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierList response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1ModifierList> createModifierListAsync(
            final String locationId,
            final V1ModifierList body) {
        return makeHttpCallAsync(() -> buildCreateModifierListRequest(locationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateModifierListResponse(context));
    }

    /**
     * Builds the HttpRequest object for createModifierList
     */
    private HttpRequest buildCreateModifierListRequest(
            final String locationId,
            final V1ModifierList body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/modifier-lists");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createModifierList
     * @return An object of type V1ModifierList
     */
    private V1ModifierList handleCreateModifierListResponse(HttpContext context)
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
        V1ModifierList result = ApiHelper.deserialize(responseBody,
                V1ModifierList.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes an existing item modifier list and all modifier options
     * associated with it.
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
            final String modifierListId) throws ApiException, IOException {
        HttpRequest request = buildDeleteModifierListRequest(locationId, modifierListId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteModifierListResponse(context);
    }

    /**
     * Deletes an existing item modifier list and all modifier options
     * associated with it.
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
            final String modifierListId) {
        return makeHttpCallAsync(() -> buildDeleteModifierListRequest(locationId, modifierListId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteModifierListResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteModifierList
     */
    private HttpRequest buildDeleteModifierListRequest(
            final String locationId,
            final String modifierListId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("modifier_list_id", modifierListId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteModifierList
     * @return An object of type V1ModifierList
     */
    private V1ModifierList handleDeleteModifierListResponse(HttpContext context)
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
        V1ModifierList result = ApiHelper.deserialize(responseBody,
                V1ModifierList.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Provides the details for a single modifier list.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The modifier list's ID.
     * @return    Returns the V1ModifierList response from the API call
     */
    @Deprecated
    public V1ModifierList retrieveModifierList(
            final String locationId,
            final String modifierListId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveModifierListRequest(locationId, modifierListId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveModifierListResponse(context);
    }

    /**
     * Provides the details for a single modifier list.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The modifier list's ID.
     * @return    Returns the V1ModifierList response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1ModifierList> retrieveModifierListAsync(
            final String locationId,
            final String modifierListId) {
        return makeHttpCallAsync(() -> buildRetrieveModifierListRequest(locationId, modifierListId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleRetrieveModifierListResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveModifierList
     */
    private HttpRequest buildRetrieveModifierListRequest(
            final String locationId,
            final String modifierListId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("modifier_list_id", modifierListId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for retrieveModifierList
     * @return An object of type V1ModifierList
     */
    private V1ModifierList handleRetrieveModifierListResponse(HttpContext context)
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
        V1ModifierList result = ApiHelper.deserialize(responseBody,
                V1ModifierList.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the details of an existing item modifier list.
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
            final V1UpdateModifierListRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateModifierListRequest(locationId, modifierListId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateModifierListResponse(context);
    }

    /**
     * Modifies the details of an existing item modifier list.
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
            final V1UpdateModifierListRequest body) {
        return makeHttpCallAsync(() -> buildUpdateModifierListRequest(locationId, modifierListId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateModifierListResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateModifierList
     */
    private HttpRequest buildUpdateModifierListRequest(
            final String locationId,
            final String modifierListId,
            final V1UpdateModifierListRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("modifier_list_id", modifierListId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateModifierList
     * @return An object of type V1ModifierList
     */
    private V1ModifierList handleUpdateModifierListResponse(HttpContext context)
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
        V1ModifierList result = ApiHelper.deserialize(responseBody,
                V1ModifierList.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates an item modifier option and adds it to a modifier list.
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
            final V1ModifierOption body) throws ApiException, IOException {
        HttpRequest request = buildCreateModifierOptionRequest(locationId, modifierListId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreateModifierOptionResponse(context);
    }

    /**
     * Creates an item modifier option and adds it to a modifier list.
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
            final V1ModifierOption body) {
        return makeHttpCallAsync(() -> buildCreateModifierOptionRequest(locationId, modifierListId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreateModifierOptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for createModifierOption
     */
    private HttpRequest buildCreateModifierOptionRequest(
            final String locationId,
            final String modifierListId,
            final V1ModifierOption body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}/modifier-options");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("modifier_list_id", modifierListId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createModifierOption
     * @return An object of type V1ModifierOption
     */
    private V1ModifierOption handleCreateModifierOptionResponse(HttpContext context)
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
        V1ModifierOption result = ApiHelper.deserialize(responseBody,
                V1ModifierOption.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes an existing item modifier option from a modifier list.
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
            final String modifierOptionId) throws ApiException, IOException {
        HttpRequest request = buildDeleteModifierOptionRequest(locationId, modifierListId, modifierOptionId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteModifierOptionResponse(context);
    }

    /**
     * Deletes an existing item modifier option from a modifier list.
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
            final String modifierOptionId) {
        return makeHttpCallAsync(() -> buildDeleteModifierOptionRequest(locationId, modifierListId, modifierOptionId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeleteModifierOptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteModifierOption
     */
    private HttpRequest buildDeleteModifierOptionRequest(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}/modifier-options/{modifier_option_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("modifier_list_id", modifierListId);
        templateParameters.put("modifier_option_id", modifierOptionId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteModifierOption
     * @return An object of type V1ModifierOption
     */
    private V1ModifierOption handleDeleteModifierOptionResponse(HttpContext context)
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
        V1ModifierOption result = ApiHelper.deserialize(responseBody,
                V1ModifierOption.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the details of an existing item modifier option.
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
            final V1ModifierOption body) throws ApiException, IOException {
        HttpRequest request = buildUpdateModifierOptionRequest(locationId, modifierListId, modifierOptionId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateModifierOptionResponse(context);
    }

    /**
     * Modifies the details of an existing item modifier option.
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
            final V1ModifierOption body) {
        return makeHttpCallAsync(() -> buildUpdateModifierOptionRequest(locationId, modifierListId, modifierOptionId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdateModifierOptionResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateModifierOption
     */
    private HttpRequest buildUpdateModifierOptionRequest(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId,
            final V1ModifierOption body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/modifier-lists/{modifier_list_id}/modifier-options/{modifier_option_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("modifier_list_id", modifierListId);
        templateParameters.put("modifier_option_id", modifierOptionId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateModifierOption
     * @return An object of type V1ModifierOption
     */
    private V1ModifierOption handleUpdateModifierOptionResponse(HttpContext context)
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
        V1ModifierOption result = ApiHelper.deserialize(responseBody,
                V1ModifierOption.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Lists all Favorites pages (in Square Point of Sale) for a given
     * location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list Favorites pages for.
     * @return    Returns the List<V1Page> response from the API call
     */
    @Deprecated
    public List<V1Page> listPages(
            final String locationId) throws ApiException, IOException {
        HttpRequest request = buildListPagesRequest(locationId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListPagesResponse(context);
    }

    /**
     * Lists all Favorites pages (in Square Point of Sale) for a given
     * location.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list Favorites pages for.
     * @return    Returns the List<V1Page> response from the API call 
     */
    @Deprecated
    public CompletableFuture<List<V1Page>> listPagesAsync(
            final String locationId) {
        return makeHttpCallAsync(() -> buildListPagesRequest(locationId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleListPagesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listPages
     */
    private HttpRequest buildListPagesRequest(
            final String locationId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/pages");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
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
     * Processes the response for listPages
     * @return An object of type List<V1Page>
     */
    private List<V1Page> handleListPagesResponse(HttpContext context)
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
        List<V1Page> result = ApiHelper.deserializeArray(responseBody,
                V1Page[].class);
        return result;
    }

    /**
     * Creates a Favorites page in Square Point of Sale.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated
    public V1Page createPage(
            final String locationId,
            final V1Page body) throws ApiException, IOException {
        HttpRequest request = buildCreatePageRequest(locationId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleCreatePageResponse(context);
    }

    /**
     * Creates a Favorites page in Square Point of Sale.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    public CompletableFuture<V1Page> createPageAsync(
            final String locationId,
            final V1Page body) {
        return makeHttpCallAsync(() -> buildCreatePageRequest(locationId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleCreatePageResponse(context));
    }

    /**
     * Builds the HttpRequest object for createPage
     */
    private HttpRequest buildCreatePageRequest(
            final String locationId,
            final V1Page body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/pages");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createPage
     * @return An object of type V1Page
     */
    private V1Page handleCreatePageResponse(HttpContext context)
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
        V1Page result = ApiHelper.deserialize(responseBody,
                V1Page.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes an existing Favorites page and all of its cells.
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
            final String pageId) throws ApiException, IOException {
        HttpRequest request = buildDeletePageRequest(locationId, pageId);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeletePageResponse(context);
    }

    /**
     * Deletes an existing Favorites page and all of its cells.
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
            final String pageId) {
        return makeHttpCallAsync(() -> buildDeletePageRequest(locationId, pageId),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeletePageResponse(context));
    }

    /**
     * Builds the HttpRequest object for deletePage
     */
    private HttpRequest buildDeletePageRequest(
            final String locationId,
            final String pageId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/pages/{page_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("page_id", pageId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deletePage
     * @return An object of type V1Page
     */
    private V1Page handleDeletePageResponse(HttpContext context)
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
        V1Page result = ApiHelper.deserialize(responseBody,
                V1Page.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies the details of a Favorites page in Square Point of Sale.
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
            final V1Page body) throws ApiException, IOException {
        HttpRequest request = buildUpdatePageRequest(locationId, pageId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdatePageResponse(context);
    }

    /**
     * Modifies the details of a Favorites page in Square Point of Sale.
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
            final V1Page body) {
        return makeHttpCallAsync(() -> buildUpdatePageRequest(locationId, pageId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdatePageResponse(context));
    }

    /**
     * Builds the HttpRequest object for updatePage
     */
    private HttpRequest buildUpdatePageRequest(
            final String locationId,
            final String pageId,
            final V1Page body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/pages/{page_id}");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("page_id", pageId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updatePage
     * @return An object of type V1Page
     */
    private V1Page handleUpdatePageResponse(HttpContext context)
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
        V1Page result = ApiHelper.deserialize(responseBody,
                V1Page.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a cell from a Favorites page in Square Point of Sale.
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
            final String column) throws ApiException, IOException {
        HttpRequest request = buildDeletePageCellRequest(locationId, pageId, row, column);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleDeletePageCellResponse(context);
    }

    /**
     * Deletes a cell from a Favorites page in Square Point of Sale.
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
            final String column) {
        return makeHttpCallAsync(() -> buildDeletePageCellRequest(locationId, pageId, row, column),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleDeletePageCellResponse(context));
    }

    /**
     * Builds the HttpRequest object for deletePageCell
     */
    private HttpRequest buildDeletePageCellRequest(
            final String locationId,
            final String pageId,
            final String row,
            final String column) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/pages/{page_id}/cells");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("page_id", pageId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);

        //process query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("row", row);
        queryParameters.put("column", column);
        ApiHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryUrl, headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deletePageCell
     * @return An object of type V1Page
     */
    private V1Page handleDeletePageCellResponse(HttpContext context)
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
        V1Page result = ApiHelper.deserialize(responseBody,
                V1Page.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Modifies a cell of a Favorites page in Square Point of Sale.
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
            final V1PageCell body) throws ApiException, IOException {
        HttpRequest request = buildUpdatePageCellRequest(locationId, pageId, body);
        authManagers.get("default").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleUpdatePageCellResponse(context);
    }

    /**
     * Modifies a cell of a Favorites page in Square Point of Sale.
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
            final V1PageCell body) {
        return makeHttpCallAsync(() -> buildUpdatePageCellRequest(locationId, pageId, body),
                req -> authManagers.get("default").applyAsync(req)
                    .thenCompose(request -> getClientInstance().executeAsStringAsync(request)),
                context -> handleUpdatePageCellResponse(context));
    }

    /**
     * Builds the HttpRequest object for updatePageCell
     */
    private HttpRequest buildUpdatePageCellRequest(
            final String locationId,
            final String pageId,
            final V1PageCell body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri + "/v1/{location_id}/pages/{page_id}/cells");

        //process template parameters
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("location_id", locationId);
        templateParameters.put("page_id", pageId);
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters, true);
        //validate and preprocess url
        String queryUrl = ApiHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Square-Version", "2020-06-25");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryUrl, headers, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updatePageCell
     * @return An object of type V1Page
     */
    private V1Page handleUpdatePageCellResponse(HttpContext context)
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
        V1Page result = ApiHelper.deserialize(responseBody,
                V1Page.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}