
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
import com.squareup.square.models.BulkUpsertCustomerCustomAttributesRequest;
import com.squareup.square.models.BulkUpsertCustomerCustomAttributesResponse;
import com.squareup.square.models.CreateCustomerCustomAttributeDefinitionRequest;
import com.squareup.square.models.CreateCustomerCustomAttributeDefinitionResponse;
import com.squareup.square.models.DeleteCustomerCustomAttributeDefinitionResponse;
import com.squareup.square.models.DeleteCustomerCustomAttributeResponse;
import com.squareup.square.models.ListCustomerCustomAttributeDefinitionsResponse;
import com.squareup.square.models.ListCustomerCustomAttributesResponse;
import com.squareup.square.models.RetrieveCustomerCustomAttributeDefinitionResponse;
import com.squareup.square.models.RetrieveCustomerCustomAttributeResponse;
import com.squareup.square.models.UpdateCustomerCustomAttributeDefinitionRequest;
import com.squareup.square.models.UpdateCustomerCustomAttributeDefinitionResponse;
import com.squareup.square.models.UpsertCustomerCustomAttributeRequest;
import com.squareup.square.models.UpsertCustomerCustomAttributeResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCustomerCustomAttributesApi extends BaseApi implements CustomerCustomAttributesApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultCustomerCustomAttributesApi(Configuration config, HttpClient httpClient,
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
    public DefaultCustomerCustomAttributesApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Lists the customer-related custom attribute definitions that belong to a Square seller
     * account. When all response pages are retrieved, the results include all custom attribute
     * definitions that are visible to the requesting application, including those that are created
     * by other applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListCustomerCustomAttributeDefinitionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCustomerCustomAttributeDefinitionsResponse listCustomerCustomAttributeDefinitions(
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListCustomerCustomAttributeDefinitionsRequest(limit, cursor);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListCustomerCustomAttributeDefinitionsResponse(context);
    }

    /**
     * Lists the customer-related custom attribute definitions that belong to a Square seller
     * account. When all response pages are retrieved, the results include all custom attribute
     * definitions that are visible to the requesting application, including those that are created
     * by other applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListCustomerCustomAttributeDefinitionsResponse response from the API call
     */
    public CompletableFuture<ListCustomerCustomAttributeDefinitionsResponse> listCustomerCustomAttributeDefinitionsAsync(
            final Integer limit,
            final String cursor) {
        return makeHttpCallAsync(() -> buildListCustomerCustomAttributeDefinitionsRequest(limit,
                cursor),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListCustomerCustomAttributeDefinitionsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCustomerCustomAttributeDefinitions.
     */
    private HttpRequest buildListCustomerCustomAttributeDefinitionsRequest(
            final Integer limit,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/custom-attribute-definitions");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);

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
     * Processes the response for listCustomerCustomAttributeDefinitions.
     * @return An object of type ListCustomerCustomAttributeDefinitionsResponse
     */
    private ListCustomerCustomAttributeDefinitionsResponse handleListCustomerCustomAttributeDefinitionsResponse(
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
        ListCustomerCustomAttributeDefinitionsResponse result = ApiHelper.deserialize(responseBody,
                ListCustomerCustomAttributeDefinitionsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a customer-related custom attribute definition for a Square seller account. Use this
     * endpoint to define a custom attribute that can be associated with customer profiles. A custom
     * attribute definition specifies the `key`, `visibility`, `schema`, and other properties for a
     * custom attribute. After the definition is created, you can call
     * [UpsertCustomerCustomAttribute]($e/CustomerCustomAttributes/UpsertCustomerCustomAttribute) or
     * [BulkUpsertCustomerCustomAttributes]($e/CustomerCustomAttributes/BulkUpsertCustomerCustomAttributes)
     * to set the custom attribute for customer profiles in the seller's Customer Directory. Sellers
     * can view all custom attributes in exported customer data, including those set to
     * `VISIBILITY_HIDDEN`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateCustomerCustomAttributeDefinitionResponse createCustomerCustomAttributeDefinition(
            final CreateCustomerCustomAttributeDefinitionRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateCustomerCustomAttributeDefinitionRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateCustomerCustomAttributeDefinitionResponse(context);
    }

    /**
     * Creates a customer-related custom attribute definition for a Square seller account. Use this
     * endpoint to define a custom attribute that can be associated with customer profiles. A custom
     * attribute definition specifies the `key`, `visibility`, `schema`, and other properties for a
     * custom attribute. After the definition is created, you can call
     * [UpsertCustomerCustomAttribute]($e/CustomerCustomAttributes/UpsertCustomerCustomAttribute) or
     * [BulkUpsertCustomerCustomAttributes]($e/CustomerCustomAttributes/BulkUpsertCustomerCustomAttributes)
     * to set the custom attribute for customer profiles in the seller's Customer Directory. Sellers
     * can view all custom attributes in exported customer data, including those set to
     * `VISIBILITY_HIDDEN`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<CreateCustomerCustomAttributeDefinitionResponse> createCustomerCustomAttributeDefinitionAsync(
            final CreateCustomerCustomAttributeDefinitionRequest body) {
        return makeHttpCallAsync(() -> buildCreateCustomerCustomAttributeDefinitionRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateCustomerCustomAttributeDefinitionResponse(context));
    }

    /**
     * Builds the HttpRequest object for createCustomerCustomAttributeDefinition.
     */
    private HttpRequest buildCreateCustomerCustomAttributeDefinitionRequest(
            final CreateCustomerCustomAttributeDefinitionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/custom-attribute-definitions");

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
     * Processes the response for createCustomerCustomAttributeDefinition.
     * @return An object of type CreateCustomerCustomAttributeDefinitionResponse
     */
    private CreateCustomerCustomAttributeDefinitionResponse handleCreateCustomerCustomAttributeDefinitionResponse(
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
        CreateCustomerCustomAttributeDefinitionResponse result = ApiHelper.deserialize(responseBody,
                CreateCustomerCustomAttributeDefinitionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a customer-related custom attribute definition from a Square seller account. Deleting
     * a custom attribute definition also deletes the corresponding custom attribute from all
     * customer profiles in the seller's Customer Directory. Only the definition owner can delete a
     * custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteCustomerCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteCustomerCustomAttributeDefinitionResponse deleteCustomerCustomAttributeDefinition(
            final String key) throws ApiException, IOException {
        HttpRequest request = buildDeleteCustomerCustomAttributeDefinitionRequest(key);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteCustomerCustomAttributeDefinitionResponse(context);
    }

    /**
     * Deletes a customer-related custom attribute definition from a Square seller account. Deleting
     * a custom attribute definition also deletes the corresponding custom attribute from all
     * customer profiles in the seller's Customer Directory. Only the definition owner can delete a
     * custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteCustomerCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<DeleteCustomerCustomAttributeDefinitionResponse> deleteCustomerCustomAttributeDefinitionAsync(
            final String key) {
        return makeHttpCallAsync(() -> buildDeleteCustomerCustomAttributeDefinitionRequest(key),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteCustomerCustomAttributeDefinitionResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteCustomerCustomAttributeDefinition.
     */
    private HttpRequest buildDeleteCustomerCustomAttributeDefinitionRequest(
            final String key) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/custom-attribute-definitions/{key}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("key",
                new SimpleEntry<Object, Boolean>(key, true));
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
     * Processes the response for deleteCustomerCustomAttributeDefinition.
     * @return An object of type DeleteCustomerCustomAttributeDefinitionResponse
     */
    private DeleteCustomerCustomAttributeDefinitionResponse handleDeleteCustomerCustomAttributeDefinitionResponse(
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
        DeleteCustomerCustomAttributeDefinitionResponse result = ApiHelper.deserialize(responseBody,
                DeleteCustomerCustomAttributeDefinitionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a customer-related custom attribute definition from a Square seller account. To
     * retrieve a custom attribute definition created by another application, the `visibility`
     * setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  key  Required parameter: The key of the custom attribute definition to retrieve. If
     *         the requesting application is not the definition owner, you must use the qualified
     *         key.
     * @param  version  Optional parameter: The current version of the custom attribute definition,
     *         which is used for strongly consistent reads to guarantee that you receive the most
     *         up-to-date data. When included in the request, Square returns the specified version
     *         or a higher version if one exists. If the specified version is higher than the
     *         current version, Square returns a `BAD_REQUEST` error.
     * @return    Returns the RetrieveCustomerCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCustomerCustomAttributeDefinitionResponse retrieveCustomerCustomAttributeDefinition(
            final String key,
            final Integer version) throws ApiException, IOException {
        HttpRequest request = buildRetrieveCustomerCustomAttributeDefinitionRequest(key, version);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveCustomerCustomAttributeDefinitionResponse(context);
    }

    /**
     * Retrieves a customer-related custom attribute definition from a Square seller account. To
     * retrieve a custom attribute definition created by another application, the `visibility`
     * setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  key  Required parameter: The key of the custom attribute definition to retrieve. If
     *         the requesting application is not the definition owner, you must use the qualified
     *         key.
     * @param  version  Optional parameter: The current version of the custom attribute definition,
     *         which is used for strongly consistent reads to guarantee that you receive the most
     *         up-to-date data. When included in the request, Square returns the specified version
     *         or a higher version if one exists. If the specified version is higher than the
     *         current version, Square returns a `BAD_REQUEST` error.
     * @return    Returns the RetrieveCustomerCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<RetrieveCustomerCustomAttributeDefinitionResponse> retrieveCustomerCustomAttributeDefinitionAsync(
            final String key,
            final Integer version) {
        return makeHttpCallAsync(() -> buildRetrieveCustomerCustomAttributeDefinitionRequest(key,
                version),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveCustomerCustomAttributeDefinitionResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveCustomerCustomAttributeDefinition.
     */
    private HttpRequest buildRetrieveCustomerCustomAttributeDefinitionRequest(
            final String key,
            final Integer version) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/custom-attribute-definitions/{key}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("key",
                new SimpleEntry<Object, Boolean>(key, true));
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
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveCustomerCustomAttributeDefinition.
     * @return An object of type RetrieveCustomerCustomAttributeDefinitionResponse
     */
    private RetrieveCustomerCustomAttributeDefinitionResponse handleRetrieveCustomerCustomAttributeDefinitionResponse(
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
        RetrieveCustomerCustomAttributeDefinitionResponse result = ApiHelper.deserialize(responseBody,
                RetrieveCustomerCustomAttributeDefinitionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a customer-related custom attribute definition for a Square seller account. Use this
     * endpoint to update the following fields: `name`, `description`, `visibility`, or the `schema`
     * for a `Selection` data type. Only the definition owner can update a custom attribute
     * definition. Note that sellers can view all custom attributes in exported customer data,
     * including those set to `VISIBILITY_HIDDEN`.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateCustomerCustomAttributeDefinitionResponse updateCustomerCustomAttributeDefinition(
            final String key,
            final UpdateCustomerCustomAttributeDefinitionRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateCustomerCustomAttributeDefinitionRequest(key, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateCustomerCustomAttributeDefinitionResponse(context);
    }

    /**
     * Updates a customer-related custom attribute definition for a Square seller account. Use this
     * endpoint to update the following fields: `name`, `description`, `visibility`, or the `schema`
     * for a `Selection` data type. Only the definition owner can update a custom attribute
     * definition. Note that sellers can view all custom attributes in exported customer data,
     * including those set to `VISIBILITY_HIDDEN`.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<UpdateCustomerCustomAttributeDefinitionResponse> updateCustomerCustomAttributeDefinitionAsync(
            final String key,
            final UpdateCustomerCustomAttributeDefinitionRequest body) {
        return makeHttpCallAsync(() -> buildUpdateCustomerCustomAttributeDefinitionRequest(key,
                body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateCustomerCustomAttributeDefinitionResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateCustomerCustomAttributeDefinition.
     */
    private HttpRequest buildUpdateCustomerCustomAttributeDefinitionRequest(
            final String key,
            final UpdateCustomerCustomAttributeDefinitionRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/custom-attribute-definitions/{key}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("key",
                new SimpleEntry<Object, Boolean>(key, true));
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
     * Processes the response for updateCustomerCustomAttributeDefinition.
     * @return An object of type UpdateCustomerCustomAttributeDefinitionResponse
     */
    private UpdateCustomerCustomAttributeDefinitionResponse handleUpdateCustomerCustomAttributeDefinitionResponse(
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
        UpdateCustomerCustomAttributeDefinitionResponse result = ApiHelper.deserialize(responseBody,
                UpdateCustomerCustomAttributeDefinitionResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates or updates custom attributes for customer profiles as a bulk operation. Use this
     * endpoint to set the value of one or more custom attributes for one or more customer profiles.
     * A custom attribute is based on a custom attribute definition in a Square seller account,
     * which is created using the
     * [CreateCustomerCustomAttributeDefinition]($e/CustomerCustomAttributes/CreateCustomerCustomAttributeDefinition)
     * endpoint. This `BulkUpsertCustomerCustomAttributes` endpoint accepts a map of 1 to 25
     * individual upsert requests and returns a map of individual upsert responses. Each upsert
     * request has a unique ID and provides a customer ID and custom attribute. Each upsert response
     * is returned with the ID of the corresponding request. To create or update a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertCustomerCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkUpsertCustomerCustomAttributesResponse bulkUpsertCustomerCustomAttributes(
            final BulkUpsertCustomerCustomAttributesRequest body) throws ApiException, IOException {
        HttpRequest request = buildBulkUpsertCustomerCustomAttributesRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleBulkUpsertCustomerCustomAttributesResponse(context);
    }

    /**
     * Creates or updates custom attributes for customer profiles as a bulk operation. Use this
     * endpoint to set the value of one or more custom attributes for one or more customer profiles.
     * A custom attribute is based on a custom attribute definition in a Square seller account,
     * which is created using the
     * [CreateCustomerCustomAttributeDefinition]($e/CustomerCustomAttributes/CreateCustomerCustomAttributeDefinition)
     * endpoint. This `BulkUpsertCustomerCustomAttributes` endpoint accepts a map of 1 to 25
     * individual upsert requests and returns a map of individual upsert responses. Each upsert
     * request has a unique ID and provides a customer ID and custom attribute. Each upsert response
     * is returned with the ID of the corresponding request. To create or update a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertCustomerCustomAttributesResponse response from the API call
     */
    public CompletableFuture<BulkUpsertCustomerCustomAttributesResponse> bulkUpsertCustomerCustomAttributesAsync(
            final BulkUpsertCustomerCustomAttributesRequest body) {
        return makeHttpCallAsync(() -> buildBulkUpsertCustomerCustomAttributesRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleBulkUpsertCustomerCustomAttributesResponse(context));
    }

    /**
     * Builds the HttpRequest object for bulkUpsertCustomerCustomAttributes.
     */
    private HttpRequest buildBulkUpsertCustomerCustomAttributesRequest(
            final BulkUpsertCustomerCustomAttributesRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/custom-attributes/bulk-upsert");

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
     * Processes the response for bulkUpsertCustomerCustomAttributes.
     * @return An object of type BulkUpsertCustomerCustomAttributesResponse
     */
    private BulkUpsertCustomerCustomAttributesResponse handleBulkUpsertCustomerCustomAttributesResponse(
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
        BulkUpsertCustomerCustomAttributesResponse result = ApiHelper.deserialize(responseBody,
                BulkUpsertCustomerCustomAttributesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Lists the custom attributes associated with a customer profile. You can use the
     * `with_definitions` query parameter to also retrieve custom attribute definitions in the same
     * call. When all response pages are retrieved, the results include all custom attributes that
     * are visible to the requesting application, including those that are owned by other
     * applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer profile]($m/Customer).
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  withDefinitions  Optional parameter: Indicates whether to return the [custom
     *         attribute definition]($m/CustomAttributeDefinition) in the `definition` field of each
     *         custom attribute. Set this parameter to `true` to get the name and description of
     *         each custom attribute, information about the data type, or other definition details.
     *         The default value is `false`.
     * @return    Returns the ListCustomerCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCustomerCustomAttributesResponse listCustomerCustomAttributes(
            final String customerId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws ApiException, IOException {
        HttpRequest request = buildListCustomerCustomAttributesRequest(customerId, limit, cursor,
                withDefinitions);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListCustomerCustomAttributesResponse(context);
    }

    /**
     * Lists the custom attributes associated with a customer profile. You can use the
     * `with_definitions` query parameter to also retrieve custom attribute definitions in the same
     * call. When all response pages are retrieved, the results include all custom attributes that
     * are visible to the requesting application, including those that are owned by other
     * applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer profile]($m/Customer).
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  withDefinitions  Optional parameter: Indicates whether to return the [custom
     *         attribute definition]($m/CustomAttributeDefinition) in the `definition` field of each
     *         custom attribute. Set this parameter to `true` to get the name and description of
     *         each custom attribute, information about the data type, or other definition details.
     *         The default value is `false`.
     * @return    Returns the ListCustomerCustomAttributesResponse response from the API call
     */
    public CompletableFuture<ListCustomerCustomAttributesResponse> listCustomerCustomAttributesAsync(
            final String customerId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) {
        return makeHttpCallAsync(() -> buildListCustomerCustomAttributesRequest(customerId, limit,
                cursor, withDefinitions),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListCustomerCustomAttributesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listCustomerCustomAttributes.
     */
    private HttpRequest buildListCustomerCustomAttributesRequest(
            final String customerId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}/custom-attributes");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);
        queryParameters.put("with_definitions",
                (withDefinitions != null) ? withDefinitions : false);

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
     * Processes the response for listCustomerCustomAttributes.
     * @return An object of type ListCustomerCustomAttributesResponse
     */
    private ListCustomerCustomAttributesResponse handleListCustomerCustomAttributesResponse(
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
        ListCustomerCustomAttributesResponse result = ApiHelper.deserialize(responseBody,
                ListCustomerCustomAttributesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes a custom attribute associated with a customer profile. To delete a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer profile]($m/Customer).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteCustomerCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteCustomerCustomAttributeResponse deleteCustomerCustomAttribute(
            final String customerId,
            final String key) throws ApiException, IOException {
        HttpRequest request = buildDeleteCustomerCustomAttributeRequest(customerId, key);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteCustomerCustomAttributeResponse(context);
    }

    /**
     * Deletes a custom attribute associated with a customer profile. To delete a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer profile]($m/Customer).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteCustomerCustomAttributeResponse response from the API call
     */
    public CompletableFuture<DeleteCustomerCustomAttributeResponse> deleteCustomerCustomAttributeAsync(
            final String customerId,
            final String key) {
        return makeHttpCallAsync(() -> buildDeleteCustomerCustomAttributeRequest(customerId, key),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteCustomerCustomAttributeResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteCustomerCustomAttribute.
     */
    private HttpRequest buildDeleteCustomerCustomAttributeRequest(
            final String customerId,
            final String key) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}/custom-attributes/{key}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
        templateParameters.put("key",
                new SimpleEntry<Object, Boolean>(key, true));
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
     * Processes the response for deleteCustomerCustomAttribute.
     * @return An object of type DeleteCustomerCustomAttributeResponse
     */
    private DeleteCustomerCustomAttributeResponse handleDeleteCustomerCustomAttributeResponse(
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
        DeleteCustomerCustomAttributeResponse result = ApiHelper.deserialize(responseBody,
                DeleteCustomerCustomAttributeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a custom attribute associated with a customer profile. You can use the
     * `with_definition` query parameter to also retrieve the custom attribute definition in the
     * same call. To retrieve a custom attribute owned by another application, the `visibility`
     * setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer profile]($m/Customer).
     * @param  key  Required parameter: The key of the custom attribute to retrieve. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @param  withDefinition  Optional parameter: Indicates whether to return the [custom attribute
     *         definition]($m/CustomAttributeDefinition) in the `definition` field of the custom
     *         attribute. Set this parameter to `true` to get the name and description of the custom
     *         attribute, information about the data type, or other definition details. The default
     *         value is `false`.
     * @param  version  Optional parameter: The current version of the custom attribute, which is
     *         used for strongly consistent reads to guarantee that you receive the most up-to-date
     *         data. When included in the request, Square returns the specified version or a higher
     *         version if one exists. If the specified version is higher than the current version,
     *         Square returns a `BAD_REQUEST` error.
     * @return    Returns the RetrieveCustomerCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCustomerCustomAttributeResponse retrieveCustomerCustomAttribute(
            final String customerId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws ApiException, IOException {
        HttpRequest request = buildRetrieveCustomerCustomAttributeRequest(customerId, key,
                withDefinition, version);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveCustomerCustomAttributeResponse(context);
    }

    /**
     * Retrieves a custom attribute associated with a customer profile. You can use the
     * `with_definition` query parameter to also retrieve the custom attribute definition in the
     * same call. To retrieve a custom attribute owned by another application, the `visibility`
     * setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer profile]($m/Customer).
     * @param  key  Required parameter: The key of the custom attribute to retrieve. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @param  withDefinition  Optional parameter: Indicates whether to return the [custom attribute
     *         definition]($m/CustomAttributeDefinition) in the `definition` field of the custom
     *         attribute. Set this parameter to `true` to get the name and description of the custom
     *         attribute, information about the data type, or other definition details. The default
     *         value is `false`.
     * @param  version  Optional parameter: The current version of the custom attribute, which is
     *         used for strongly consistent reads to guarantee that you receive the most up-to-date
     *         data. When included in the request, Square returns the specified version or a higher
     *         version if one exists. If the specified version is higher than the current version,
     *         Square returns a `BAD_REQUEST` error.
     * @return    Returns the RetrieveCustomerCustomAttributeResponse response from the API call
     */
    public CompletableFuture<RetrieveCustomerCustomAttributeResponse> retrieveCustomerCustomAttributeAsync(
            final String customerId,
            final String key,
            final Boolean withDefinition,
            final Integer version) {
        return makeHttpCallAsync(() -> buildRetrieveCustomerCustomAttributeRequest(customerId, key,
                withDefinition, version),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveCustomerCustomAttributeResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveCustomerCustomAttribute.
     */
    private HttpRequest buildRetrieveCustomerCustomAttributeRequest(
            final String customerId,
            final String key,
            final Boolean withDefinition,
            final Integer version) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}/custom-attributes/{key}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
        templateParameters.put("key",
                new SimpleEntry<Object, Boolean>(key, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("with_definition",
                (withDefinition != null) ? withDefinition : false);
        queryParameters.put("version", version);

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
     * Processes the response for retrieveCustomerCustomAttribute.
     * @return An object of type RetrieveCustomerCustomAttributeResponse
     */
    private RetrieveCustomerCustomAttributeResponse handleRetrieveCustomerCustomAttributeResponse(
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
        RetrieveCustomerCustomAttributeResponse result = ApiHelper.deserialize(responseBody,
                RetrieveCustomerCustomAttributeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates or updates a custom attribute for a customer profile. Use this endpoint to set the
     * value of a custom attribute for a specified customer profile. A custom attribute is based on
     * a custom attribute definition in a Square seller account, which is created using the
     * [CreateCustomerCustomAttributeDefinition]($e/CustomerCustomAttributes/CreateCustomerCustomAttributeDefinition)
     * endpoint. To create or update a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer profile]($m/Customer).
     * @param  key  Required parameter: The key of the custom attribute to create or update. This
     *         key must match the `key` of a custom attribute definition in the Square seller
     *         account. If the requesting application is not the definition owner, you must use the
     *         qualified key.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertCustomerCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpsertCustomerCustomAttributeResponse upsertCustomerCustomAttribute(
            final String customerId,
            final String key,
            final UpsertCustomerCustomAttributeRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpsertCustomerCustomAttributeRequest(customerId, key, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpsertCustomerCustomAttributeResponse(context);
    }

    /**
     * Creates or updates a custom attribute for a customer profile. Use this endpoint to set the
     * value of a custom attribute for a specified customer profile. A custom attribute is based on
     * a custom attribute definition in a Square seller account, which is created using the
     * [CreateCustomerCustomAttributeDefinition]($e/CustomerCustomAttributes/CreateCustomerCustomAttributeDefinition)
     * endpoint. To create or update a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer profile]($m/Customer).
     * @param  key  Required parameter: The key of the custom attribute to create or update. This
     *         key must match the `key` of a custom attribute definition in the Square seller
     *         account. If the requesting application is not the definition owner, you must use the
     *         qualified key.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertCustomerCustomAttributeResponse response from the API call
     */
    public CompletableFuture<UpsertCustomerCustomAttributeResponse> upsertCustomerCustomAttributeAsync(
            final String customerId,
            final String key,
            final UpsertCustomerCustomAttributeRequest body) {
        return makeHttpCallAsync(() -> buildUpsertCustomerCustomAttributeRequest(customerId, key,
                body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpsertCustomerCustomAttributeResponse(context));
    }

    /**
     * Builds the HttpRequest object for upsertCustomerCustomAttribute.
     */
    private HttpRequest buildUpsertCustomerCustomAttributeRequest(
            final String customerId,
            final String key,
            final UpsertCustomerCustomAttributeRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/customers/{customer_id}/custom-attributes/{key}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("customer_id",
                new SimpleEntry<Object, Boolean>(customerId, true));
        templateParameters.put("key",
                new SimpleEntry<Object, Boolean>(key, true));
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
     * Processes the response for upsertCustomerCustomAttribute.
     * @return An object of type UpsertCustomerCustomAttributeResponse
     */
    private UpsertCustomerCustomAttributeResponse handleUpsertCustomerCustomAttributeResponse(
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
        UpsertCustomerCustomAttributeResponse result = ApiHelper.deserialize(responseBody,
                UpsertCustomerCustomAttributeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}