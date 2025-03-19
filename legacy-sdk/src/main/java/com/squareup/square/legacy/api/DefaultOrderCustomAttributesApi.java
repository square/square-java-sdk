package com.squareup.square.legacy.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.legacy.ApiHelper;
import com.squareup.square.legacy.Server;
import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.http.client.HttpContext;
import com.squareup.square.legacy.http.request.HttpMethod;
import com.squareup.square.legacy.models.BulkDeleteOrderCustomAttributesRequest;
import com.squareup.square.legacy.models.BulkDeleteOrderCustomAttributesResponse;
import com.squareup.square.legacy.models.BulkUpsertOrderCustomAttributesRequest;
import com.squareup.square.legacy.models.BulkUpsertOrderCustomAttributesResponse;
import com.squareup.square.legacy.models.CreateOrderCustomAttributeDefinitionRequest;
import com.squareup.square.legacy.models.CreateOrderCustomAttributeDefinitionResponse;
import com.squareup.square.legacy.models.DeleteOrderCustomAttributeDefinitionResponse;
import com.squareup.square.legacy.models.DeleteOrderCustomAttributeResponse;
import com.squareup.square.legacy.models.ListOrderCustomAttributeDefinitionsResponse;
import com.squareup.square.legacy.models.ListOrderCustomAttributesResponse;
import com.squareup.square.legacy.models.RetrieveOrderCustomAttributeDefinitionResponse;
import com.squareup.square.legacy.models.RetrieveOrderCustomAttributeResponse;
import com.squareup.square.legacy.models.UpdateOrderCustomAttributeDefinitionRequest;
import com.squareup.square.legacy.models.UpdateOrderCustomAttributeDefinitionResponse;
import com.squareup.square.legacy.models.UpsertOrderCustomAttributeRequest;
import com.squareup.square.legacy.models.UpsertOrderCustomAttributeResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultOrderCustomAttributesApi extends BaseApi implements OrderCustomAttributesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultOrderCustomAttributesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Lists the order-related [custom attribute definitions]($m/CustomAttributeDefinition) that
     * belong to a Square seller account. When all response pages are retrieved, the results include
     * all custom attribute definitions that are visible to the requesting application, including
     * those that are created by other applications and set to `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  visibilityFilter  Optional parameter: Requests that all of the custom attributes be
     *         returned, or only those that are read-only or read-write.
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return    Returns the ListOrderCustomAttributeDefinitionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListOrderCustomAttributeDefinitionsResponse listOrderCustomAttributeDefinitions(
            final String visibilityFilter, final String cursor, final Integer limit) throws ApiException, IOException {
        return prepareListOrderCustomAttributeDefinitionsRequest(visibilityFilter, cursor, limit)
                .execute();
    }

    /**
     * Lists the order-related [custom attribute definitions]($m/CustomAttributeDefinition) that
     * belong to a Square seller account. When all response pages are retrieved, the results include
     * all custom attribute definitions that are visible to the requesting application, including
     * those that are created by other applications and set to `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  visibilityFilter  Optional parameter: Requests that all of the custom attributes be
     *         returned, or only those that are read-only or read-write.
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return    Returns the ListOrderCustomAttributeDefinitionsResponse response from the API call
     */
    public CompletableFuture<ListOrderCustomAttributeDefinitionsResponse> listOrderCustomAttributeDefinitionsAsync(
            final String visibilityFilter, final String cursor, final Integer limit) {
        try {
            return prepareListOrderCustomAttributeDefinitionsRequest(visibilityFilter, cursor, limit)
                    .executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for listOrderCustomAttributeDefinitions.
     */
    private ApiCall<ListOrderCustomAttributeDefinitionsResponse, ApiException>
            prepareListOrderCustomAttributeDefinitionsRequest(
                    final String visibilityFilter, final String cursor, final Integer limit) throws IOException {
        return new ApiCall.Builder<ListOrderCustomAttributeDefinitionsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/custom-attribute-definitions")
                        .queryParam(param -> param.key("visibility_filter")
                                .value(visibilityFilter)
                                .isRequired(false))
                        .queryParam(param -> param.key("cursor").value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit").value(limit).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response ->
                                ApiHelper.deserialize(response, ListOrderCustomAttributeDefinitionsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates an order-related custom attribute definition. Use this endpoint to define a custom
     * attribute that can be associated with orders. After creating a custom attribute definition,
     * you can set the custom attribute for orders in the Square seller account.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateOrderCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateOrderCustomAttributeDefinitionResponse createOrderCustomAttributeDefinition(
            final CreateOrderCustomAttributeDefinitionRequest body) throws ApiException, IOException {
        return prepareCreateOrderCustomAttributeDefinitionRequest(body).execute();
    }

    /**
     * Creates an order-related custom attribute definition. Use this endpoint to define a custom
     * attribute that can be associated with orders. After creating a custom attribute definition,
     * you can set the custom attribute for orders in the Square seller account.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateOrderCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<CreateOrderCustomAttributeDefinitionResponse> createOrderCustomAttributeDefinitionAsync(
            final CreateOrderCustomAttributeDefinitionRequest body) {
        try {
            return prepareCreateOrderCustomAttributeDefinitionRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for createOrderCustomAttributeDefinition.
     */
    private ApiCall<CreateOrderCustomAttributeDefinitionResponse, ApiException>
            prepareCreateOrderCustomAttributeDefinitionRequest(final CreateOrderCustomAttributeDefinitionRequest body)
                    throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateOrderCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/custom-attribute-definitions")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response ->
                                ApiHelper.deserialize(response, CreateOrderCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes an order-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Only the definition owner can delete a custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteOrderCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteOrderCustomAttributeDefinitionResponse deleteOrderCustomAttributeDefinition(final String key)
            throws ApiException, IOException {
        return prepareDeleteOrderCustomAttributeDefinitionRequest(key).execute();
    }

    /**
     * Deletes an order-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Only the definition owner can delete a custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteOrderCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<DeleteOrderCustomAttributeDefinitionResponse> deleteOrderCustomAttributeDefinitionAsync(
            final String key) {
        try {
            return prepareDeleteOrderCustomAttributeDefinitionRequest(key).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for deleteOrderCustomAttributeDefinition.
     */
    private ApiCall<DeleteOrderCustomAttributeDefinitionResponse, ApiException>
            prepareDeleteOrderCustomAttributeDefinitionRequest(final String key) throws IOException {
        return new ApiCall.Builder<DeleteOrderCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/custom-attribute-definitions/{key}")
                        .templateParam(param -> param.key("key").value(key).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response ->
                                ApiHelper.deserialize(response, DeleteOrderCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves an order-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. To retrieve a custom attribute definition created by another
     * application, the `visibility` setting must be `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  key  Required parameter: The key of the custom attribute definition to retrieve.
     * @param  version  Optional parameter: To enable [optimistic
     *         concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)
     *         control, include this optional field and specify the current version of the custom
     *         attribute.
     * @return    Returns the RetrieveOrderCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveOrderCustomAttributeDefinitionResponse retrieveOrderCustomAttributeDefinition(
            final String key, final Integer version) throws ApiException, IOException {
        return prepareRetrieveOrderCustomAttributeDefinitionRequest(key, version)
                .execute();
    }

    /**
     * Retrieves an order-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. To retrieve a custom attribute definition created by another
     * application, the `visibility` setting must be `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  key  Required parameter: The key of the custom attribute definition to retrieve.
     * @param  version  Optional parameter: To enable [optimistic
     *         concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)
     *         control, include this optional field and specify the current version of the custom
     *         attribute.
     * @return    Returns the RetrieveOrderCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<RetrieveOrderCustomAttributeDefinitionResponse>
            retrieveOrderCustomAttributeDefinitionAsync(final String key, final Integer version) {
        try {
            return prepareRetrieveOrderCustomAttributeDefinitionRequest(key, version)
                    .executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for retrieveOrderCustomAttributeDefinition.
     */
    private ApiCall<RetrieveOrderCustomAttributeDefinitionResponse, ApiException>
            prepareRetrieveOrderCustomAttributeDefinitionRequest(final String key, final Integer version)
                    throws IOException {
        return new ApiCall.Builder<RetrieveOrderCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/custom-attribute-definitions/{key}")
                        .queryParam(param -> param.key("version").value(version).isRequired(false))
                        .templateParam(param -> param.key("key").value(key).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response ->
                                ApiHelper.deserialize(response, RetrieveOrderCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates an order-related custom attribute definition for a Square seller account. Only the
     * definition owner can update a custom attribute definition. Note that sellers can view all
     * custom attributes in exported customer data, including those set to `VISIBILITY_HIDDEN`.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateOrderCustomAttributeDefinitionResponse updateOrderCustomAttributeDefinition(
            final String key, final UpdateOrderCustomAttributeDefinitionRequest body) throws ApiException, IOException {
        return prepareUpdateOrderCustomAttributeDefinitionRequest(key, body).execute();
    }

    /**
     * Updates an order-related custom attribute definition for a Square seller account. Only the
     * definition owner can update a custom attribute definition. Note that sellers can view all
     * custom attributes in exported customer data, including those set to `VISIBILITY_HIDDEN`.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<UpdateOrderCustomAttributeDefinitionResponse> updateOrderCustomAttributeDefinitionAsync(
            final String key, final UpdateOrderCustomAttributeDefinitionRequest body) {
        try {
            return prepareUpdateOrderCustomAttributeDefinitionRequest(key, body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for updateOrderCustomAttributeDefinition.
     */
    private ApiCall<UpdateOrderCustomAttributeDefinitionResponse, ApiException>
            prepareUpdateOrderCustomAttributeDefinitionRequest(
                    final String key, final UpdateOrderCustomAttributeDefinitionRequest body)
                    throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateOrderCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/custom-attribute-definitions/{key}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .templateParam(param -> param.key("key").value(key).shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response ->
                                ApiHelper.deserialize(response, UpdateOrderCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes order [custom attributes]($m/CustomAttribute) as a bulk operation. Use this endpoint
     * to delete one or more custom attributes from one or more orders. A custom attribute is based
     * on a custom attribute definition in a Square seller account. (To create a custom attribute
     * definition, use the
     * [CreateOrderCustomAttributeDefinition]($e/OrderCustomAttributes/CreateOrderCustomAttributeDefinition)
     * endpoint.) This `BulkDeleteOrderCustomAttributes` endpoint accepts a map of 1 to 25
     * individual delete requests and returns a map of individual delete responses. Each delete
     * request has a unique ID and provides an order ID and custom attribute. Each delete response
     * is returned with the ID of the corresponding request. To delete a custom attribute owned by
     * another application, the `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`. Note
     * that seller-defined custom attributes (also known as custom fields) are always set to
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteOrderCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkDeleteOrderCustomAttributesResponse bulkDeleteOrderCustomAttributes(
            final BulkDeleteOrderCustomAttributesRequest body) throws ApiException, IOException {
        return prepareBulkDeleteOrderCustomAttributesRequest(body).execute();
    }

    /**
     * Deletes order [custom attributes]($m/CustomAttribute) as a bulk operation. Use this endpoint
     * to delete one or more custom attributes from one or more orders. A custom attribute is based
     * on a custom attribute definition in a Square seller account. (To create a custom attribute
     * definition, use the
     * [CreateOrderCustomAttributeDefinition]($e/OrderCustomAttributes/CreateOrderCustomAttributeDefinition)
     * endpoint.) This `BulkDeleteOrderCustomAttributes` endpoint accepts a map of 1 to 25
     * individual delete requests and returns a map of individual delete responses. Each delete
     * request has a unique ID and provides an order ID and custom attribute. Each delete response
     * is returned with the ID of the corresponding request. To delete a custom attribute owned by
     * another application, the `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`. Note
     * that seller-defined custom attributes (also known as custom fields) are always set to
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteOrderCustomAttributesResponse response from the API call
     */
    public CompletableFuture<BulkDeleteOrderCustomAttributesResponse> bulkDeleteOrderCustomAttributesAsync(
            final BulkDeleteOrderCustomAttributesRequest body) {
        try {
            return prepareBulkDeleteOrderCustomAttributesRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for bulkDeleteOrderCustomAttributes.
     */
    private ApiCall<BulkDeleteOrderCustomAttributesResponse, ApiException>
            prepareBulkDeleteOrderCustomAttributesRequest(final BulkDeleteOrderCustomAttributesRequest body)
                    throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkDeleteOrderCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/custom-attributes/bulk-delete")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response ->
                                ApiHelper.deserialize(response, BulkDeleteOrderCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates or updates order [custom attributes]($m/CustomAttribute) as a bulk operation. Use
     * this endpoint to delete one or more custom attributes from one or more orders. A custom
     * attribute is based on a custom attribute definition in a Square seller account. (To create a
     * custom attribute definition, use the
     * [CreateOrderCustomAttributeDefinition]($e/OrderCustomAttributes/CreateOrderCustomAttributeDefinition)
     * endpoint.) This `BulkUpsertOrderCustomAttributes` endpoint accepts a map of 1 to 25
     * individual upsert requests and returns a map of individual upsert responses. Each upsert
     * request has a unique ID and provides an order ID and custom attribute. Each upsert response
     * is returned with the ID of the corresponding request. To create or update a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertOrderCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkUpsertOrderCustomAttributesResponse bulkUpsertOrderCustomAttributes(
            final BulkUpsertOrderCustomAttributesRequest body) throws ApiException, IOException {
        return prepareBulkUpsertOrderCustomAttributesRequest(body).execute();
    }

    /**
     * Creates or updates order [custom attributes]($m/CustomAttribute) as a bulk operation. Use
     * this endpoint to delete one or more custom attributes from one or more orders. A custom
     * attribute is based on a custom attribute definition in a Square seller account. (To create a
     * custom attribute definition, use the
     * [CreateOrderCustomAttributeDefinition]($e/OrderCustomAttributes/CreateOrderCustomAttributeDefinition)
     * endpoint.) This `BulkUpsertOrderCustomAttributes` endpoint accepts a map of 1 to 25
     * individual upsert requests and returns a map of individual upsert responses. Each upsert
     * request has a unique ID and provides an order ID and custom attribute. Each upsert response
     * is returned with the ID of the corresponding request. To create or update a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertOrderCustomAttributesResponse response from the API call
     */
    public CompletableFuture<BulkUpsertOrderCustomAttributesResponse> bulkUpsertOrderCustomAttributesAsync(
            final BulkUpsertOrderCustomAttributesRequest body) {
        try {
            return prepareBulkUpsertOrderCustomAttributesRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for bulkUpsertOrderCustomAttributes.
     */
    private ApiCall<BulkUpsertOrderCustomAttributesResponse, ApiException>
            prepareBulkUpsertOrderCustomAttributesRequest(final BulkUpsertOrderCustomAttributesRequest body)
                    throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkUpsertOrderCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/custom-attributes/bulk-upsert")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response ->
                                ApiHelper.deserialize(response, BulkUpsertOrderCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Lists the [custom attributes]($m/CustomAttribute) associated with an order. You can use the
     * `with_definitions` query parameter to also retrieve custom attribute definitions in the same
     * call. When all response pages are retrieved, the results include all custom attributes that
     * are visible to the requesting application, including those that are owned by other
     * applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  orderId  Required parameter: The ID of the target [order](entity:Order).
     * @param  visibilityFilter  Optional parameter: Requests that all of the custom attributes be
     *         returned, or only those that are read-only or read-write.
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  withDefinitions  Optional parameter: Indicates whether to return the [custom
     *         attribute definition](entity:CustomAttributeDefinition) in the `definition` field of
     *         each custom attribute. Set this parameter to `true` to get the name and description
     *         of each custom attribute, information about the data type, or other definition
     *         details. The default value is `false`.
     * @return    Returns the ListOrderCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListOrderCustomAttributesResponse listOrderCustomAttributes(
            final String orderId,
            final String visibilityFilter,
            final String cursor,
            final Integer limit,
            final Boolean withDefinitions)
            throws ApiException, IOException {
        return prepareListOrderCustomAttributesRequest(orderId, visibilityFilter, cursor, limit, withDefinitions)
                .execute();
    }

    /**
     * Lists the [custom attributes]($m/CustomAttribute) associated with an order. You can use the
     * `with_definitions` query parameter to also retrieve custom attribute definitions in the same
     * call. When all response pages are retrieved, the results include all custom attributes that
     * are visible to the requesting application, including those that are owned by other
     * applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  orderId  Required parameter: The ID of the target [order](entity:Order).
     * @param  visibilityFilter  Optional parameter: Requests that all of the custom attributes be
     *         returned, or only those that are read-only or read-write.
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  withDefinitions  Optional parameter: Indicates whether to return the [custom
     *         attribute definition](entity:CustomAttributeDefinition) in the `definition` field of
     *         each custom attribute. Set this parameter to `true` to get the name and description
     *         of each custom attribute, information about the data type, or other definition
     *         details. The default value is `false`.
     * @return    Returns the ListOrderCustomAttributesResponse response from the API call
     */
    public CompletableFuture<ListOrderCustomAttributesResponse> listOrderCustomAttributesAsync(
            final String orderId,
            final String visibilityFilter,
            final String cursor,
            final Integer limit,
            final Boolean withDefinitions) {
        try {
            return prepareListOrderCustomAttributesRequest(orderId, visibilityFilter, cursor, limit, withDefinitions)
                    .executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for listOrderCustomAttributes.
     */
    private ApiCall<ListOrderCustomAttributesResponse, ApiException> prepareListOrderCustomAttributesRequest(
            final String orderId,
            final String visibilityFilter,
            final String cursor,
            final Integer limit,
            final Boolean withDefinitions)
            throws IOException {
        return new ApiCall.Builder<ListOrderCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/{order_id}/custom-attributes")
                        .queryParam(param -> param.key("visibility_filter")
                                .value(visibilityFilter)
                                .isRequired(false))
                        .queryParam(param -> param.key("cursor").value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit").value(limit).isRequired(false))
                        .queryParam(param -> param.key("with_definitions")
                                .value((withDefinitions != null) ? withDefinitions : false)
                                .isRequired(false))
                        .templateParam(
                                param -> param.key("order_id").value(orderId).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListOrderCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a [custom attribute]($m/CustomAttribute) associated with a customer profile. To
     * delete a custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  orderId  Required parameter: The ID of the target [order](entity:Order).
     * @param  customAttributeKey  Required parameter: The key of the custom attribute to delete.
     *         This key must match the key of an existing custom attribute definition.
     * @return    Returns the DeleteOrderCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteOrderCustomAttributeResponse deleteOrderCustomAttribute(
            final String orderId, final String customAttributeKey) throws ApiException, IOException {
        return prepareDeleteOrderCustomAttributeRequest(orderId, customAttributeKey)
                .execute();
    }

    /**
     * Deletes a [custom attribute]($m/CustomAttribute) associated with a customer profile. To
     * delete a custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  orderId  Required parameter: The ID of the target [order](entity:Order).
     * @param  customAttributeKey  Required parameter: The key of the custom attribute to delete.
     *         This key must match the key of an existing custom attribute definition.
     * @return    Returns the DeleteOrderCustomAttributeResponse response from the API call
     */
    public CompletableFuture<DeleteOrderCustomAttributeResponse> deleteOrderCustomAttributeAsync(
            final String orderId, final String customAttributeKey) {
        try {
            return prepareDeleteOrderCustomAttributeRequest(orderId, customAttributeKey)
                    .executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for deleteOrderCustomAttribute.
     */
    private ApiCall<DeleteOrderCustomAttributeResponse, ApiException> prepareDeleteOrderCustomAttributeRequest(
            final String orderId, final String customAttributeKey) throws IOException {
        return new ApiCall.Builder<DeleteOrderCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/{order_id}/custom-attributes/{custom_attribute_key}")
                        .templateParam(
                                param -> param.key("order_id").value(orderId).shouldEncode(true))
                        .templateParam(param -> param.key("custom_attribute_key")
                                .value(customAttributeKey)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteOrderCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a [custom attribute]($m/CustomAttribute) associated with an order. You can use the
     * `with_definition` query parameter to also retrieve the custom attribute definition in the
     * same call. To retrieve a custom attribute owned by another application, the `visibility`
     * setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`. Note that
     * seller-defined custom attributes also known as custom fields) are always set to
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  orderId  Required parameter: The ID of the target [order](entity:Order).
     * @param  customAttributeKey  Required parameter: The key of the custom attribute to retrieve.
     *         This key must match the key of an existing custom attribute definition.
     * @param  version  Optional parameter: To enable [optimistic
     *         concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)
     *         control, include this optional field and specify the current version of the custom
     *         attribute.
     * @param  withDefinition  Optional parameter: Indicates whether to return the [custom attribute
     *         definition](entity:CustomAttributeDefinition) in the `definition` field of each
     *         custom attribute. Set this parameter to `true` to get the name and description of
     *         each custom attribute, information about the data type, or other definition details.
     *         The default value is `false`.
     * @return    Returns the RetrieveOrderCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveOrderCustomAttributeResponse retrieveOrderCustomAttribute(
            final String orderId, final String customAttributeKey, final Integer version, final Boolean withDefinition)
            throws ApiException, IOException {
        return prepareRetrieveOrderCustomAttributeRequest(orderId, customAttributeKey, version, withDefinition)
                .execute();
    }

    /**
     * Retrieves a [custom attribute]($m/CustomAttribute) associated with an order. You can use the
     * `with_definition` query parameter to also retrieve the custom attribute definition in the
     * same call. To retrieve a custom attribute owned by another application, the `visibility`
     * setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`. Note that
     * seller-defined custom attributes also known as custom fields) are always set to
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  orderId  Required parameter: The ID of the target [order](entity:Order).
     * @param  customAttributeKey  Required parameter: The key of the custom attribute to retrieve.
     *         This key must match the key of an existing custom attribute definition.
     * @param  version  Optional parameter: To enable [optimistic
     *         concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)
     *         control, include this optional field and specify the current version of the custom
     *         attribute.
     * @param  withDefinition  Optional parameter: Indicates whether to return the [custom attribute
     *         definition](entity:CustomAttributeDefinition) in the `definition` field of each
     *         custom attribute. Set this parameter to `true` to get the name and description of
     *         each custom attribute, information about the data type, or other definition details.
     *         The default value is `false`.
     * @return    Returns the RetrieveOrderCustomAttributeResponse response from the API call
     */
    public CompletableFuture<RetrieveOrderCustomAttributeResponse> retrieveOrderCustomAttributeAsync(
            final String orderId,
            final String customAttributeKey,
            final Integer version,
            final Boolean withDefinition) {
        try {
            return prepareRetrieveOrderCustomAttributeRequest(orderId, customAttributeKey, version, withDefinition)
                    .executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for retrieveOrderCustomAttribute.
     */
    private ApiCall<RetrieveOrderCustomAttributeResponse, ApiException> prepareRetrieveOrderCustomAttributeRequest(
            final String orderId, final String customAttributeKey, final Integer version, final Boolean withDefinition)
            throws IOException {
        return new ApiCall.Builder<RetrieveOrderCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/{order_id}/custom-attributes/{custom_attribute_key}")
                        .queryParam(param -> param.key("version").value(version).isRequired(false))
                        .queryParam(param -> param.key("with_definition")
                                .value((withDefinition != null) ? withDefinition : false)
                                .isRequired(false))
                        .templateParam(
                                param -> param.key("order_id").value(orderId).shouldEncode(true))
                        .templateParam(param -> param.key("custom_attribute_key")
                                .value(customAttributeKey)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveOrderCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates or updates a [custom attribute]($m/CustomAttribute) for an order. Use this endpoint
     * to set the value of a custom attribute for a specific order. A custom attribute is based on a
     * custom attribute definition in a Square seller account. (To create a custom attribute
     * definition, use the
     * [CreateOrderCustomAttributeDefinition]($e/OrderCustomAttributes/CreateOrderCustomAttributeDefinition)
     * endpoint.) To create or update a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom
     * attributes (also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  orderId  Required parameter: The ID of the target [order](entity:Order).
     * @param  customAttributeKey  Required parameter: The key of the custom attribute to create or
     *         update. This key must match the key of an existing custom attribute definition.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertOrderCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpsertOrderCustomAttributeResponse upsertOrderCustomAttribute(
            final String orderId, final String customAttributeKey, final UpsertOrderCustomAttributeRequest body)
            throws ApiException, IOException {
        return prepareUpsertOrderCustomAttributeRequest(orderId, customAttributeKey, body)
                .execute();
    }

    /**
     * Creates or updates a [custom attribute]($m/CustomAttribute) for an order. Use this endpoint
     * to set the value of a custom attribute for a specific order. A custom attribute is based on a
     * custom attribute definition in a Square seller account. (To create a custom attribute
     * definition, use the
     * [CreateOrderCustomAttributeDefinition]($e/OrderCustomAttributes/CreateOrderCustomAttributeDefinition)
     * endpoint.) To create or update a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom
     * attributes (also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  orderId  Required parameter: The ID of the target [order](entity:Order).
     * @param  customAttributeKey  Required parameter: The key of the custom attribute to create or
     *         update. This key must match the key of an existing custom attribute definition.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertOrderCustomAttributeResponse response from the API call
     */
    public CompletableFuture<UpsertOrderCustomAttributeResponse> upsertOrderCustomAttributeAsync(
            final String orderId, final String customAttributeKey, final UpsertOrderCustomAttributeRequest body) {
        try {
            return prepareUpsertOrderCustomAttributeRequest(orderId, customAttributeKey, body)
                    .executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for upsertOrderCustomAttribute.
     */
    private ApiCall<UpsertOrderCustomAttributeResponse, ApiException> prepareUpsertOrderCustomAttributeRequest(
            final String orderId, final String customAttributeKey, final UpsertOrderCustomAttributeRequest body)
            throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpsertOrderCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/orders/{order_id}/custom-attributes/{custom_attribute_key}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .templateParam(
                                param -> param.key("order_id").value(orderId).shouldEncode(true))
                        .templateParam(param -> param.key("custom_attribute_key")
                                .value(customAttributeKey)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpsertOrderCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}
