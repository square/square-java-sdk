
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.BulkDeleteOrderCustomAttributesRequest;
import com.squareup.square.models.BulkDeleteOrderCustomAttributesResponse;
import com.squareup.square.models.BulkUpsertOrderCustomAttributesRequest;
import com.squareup.square.models.BulkUpsertOrderCustomAttributesResponse;
import com.squareup.square.models.CreateOrderCustomAttributeDefinitionRequest;
import com.squareup.square.models.CreateOrderCustomAttributeDefinitionResponse;
import com.squareup.square.models.DeleteOrderCustomAttributeDefinitionResponse;
import com.squareup.square.models.DeleteOrderCustomAttributeResponse;
import com.squareup.square.models.ListOrderCustomAttributeDefinitionsResponse;
import com.squareup.square.models.ListOrderCustomAttributesResponse;
import com.squareup.square.models.RetrieveOrderCustomAttributeDefinitionResponse;
import com.squareup.square.models.RetrieveOrderCustomAttributeResponse;
import com.squareup.square.models.UpdateOrderCustomAttributeDefinitionRequest;
import com.squareup.square.models.UpdateOrderCustomAttributeDefinitionResponse;
import com.squareup.square.models.UpsertOrderCustomAttributeRequest;
import com.squareup.square.models.UpsertOrderCustomAttributeResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface OrderCustomAttributesApi {
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
    ListOrderCustomAttributeDefinitionsResponse listOrderCustomAttributeDefinitions(
            final String visibilityFilter,
            final String cursor,
            final Integer limit) throws ApiException, IOException;

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
    CompletableFuture<ListOrderCustomAttributeDefinitionsResponse> listOrderCustomAttributeDefinitionsAsync(
            final String visibilityFilter,
            final String cursor,
            final Integer limit);

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
    CreateOrderCustomAttributeDefinitionResponse createOrderCustomAttributeDefinition(
            final CreateOrderCustomAttributeDefinitionRequest body) throws ApiException, IOException;

    /**
     * Creates an order-related custom attribute definition. Use this endpoint to define a custom
     * attribute that can be associated with orders. After creating a custom attribute definition,
     * you can set the custom attribute for orders in the Square seller account.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateOrderCustomAttributeDefinitionResponse response from the API call
     */
    CompletableFuture<CreateOrderCustomAttributeDefinitionResponse> createOrderCustomAttributeDefinitionAsync(
            final CreateOrderCustomAttributeDefinitionRequest body);

    /**
     * Deletes an order-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Only the definition owner can delete a custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteOrderCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteOrderCustomAttributeDefinitionResponse deleteOrderCustomAttributeDefinition(
            final String key) throws ApiException, IOException;

    /**
     * Deletes an order-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Only the definition owner can delete a custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteOrderCustomAttributeDefinitionResponse response from the API call
     */
    CompletableFuture<DeleteOrderCustomAttributeDefinitionResponse> deleteOrderCustomAttributeDefinitionAsync(
            final String key);

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
    RetrieveOrderCustomAttributeDefinitionResponse retrieveOrderCustomAttributeDefinition(
            final String key,
            final Integer version) throws ApiException, IOException;

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
    CompletableFuture<RetrieveOrderCustomAttributeDefinitionResponse> retrieveOrderCustomAttributeDefinitionAsync(
            final String key,
            final Integer version);

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
    UpdateOrderCustomAttributeDefinitionResponse updateOrderCustomAttributeDefinition(
            final String key,
            final UpdateOrderCustomAttributeDefinitionRequest body) throws ApiException, IOException;

    /**
     * Updates an order-related custom attribute definition for a Square seller account. Only the
     * definition owner can update a custom attribute definition. Note that sellers can view all
     * custom attributes in exported customer data, including those set to `VISIBILITY_HIDDEN`.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateOrderCustomAttributeDefinitionResponse response from the API call
     */
    CompletableFuture<UpdateOrderCustomAttributeDefinitionResponse> updateOrderCustomAttributeDefinitionAsync(
            final String key,
            final UpdateOrderCustomAttributeDefinitionRequest body);

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
    BulkDeleteOrderCustomAttributesResponse bulkDeleteOrderCustomAttributes(
            final BulkDeleteOrderCustomAttributesRequest body) throws ApiException, IOException;

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
    CompletableFuture<BulkDeleteOrderCustomAttributesResponse> bulkDeleteOrderCustomAttributesAsync(
            final BulkDeleteOrderCustomAttributesRequest body);

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
    BulkUpsertOrderCustomAttributesResponse bulkUpsertOrderCustomAttributes(
            final BulkUpsertOrderCustomAttributesRequest body) throws ApiException, IOException;

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
    CompletableFuture<BulkUpsertOrderCustomAttributesResponse> bulkUpsertOrderCustomAttributesAsync(
            final BulkUpsertOrderCustomAttributesRequest body);

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
    ListOrderCustomAttributesResponse listOrderCustomAttributes(
            final String orderId,
            final String visibilityFilter,
            final String cursor,
            final Integer limit,
            final Boolean withDefinitions) throws ApiException, IOException;

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
    CompletableFuture<ListOrderCustomAttributesResponse> listOrderCustomAttributesAsync(
            final String orderId,
            final String visibilityFilter,
            final String cursor,
            final Integer limit,
            final Boolean withDefinitions);

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
    DeleteOrderCustomAttributeResponse deleteOrderCustomAttribute(
            final String orderId,
            final String customAttributeKey) throws ApiException, IOException;

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
    CompletableFuture<DeleteOrderCustomAttributeResponse> deleteOrderCustomAttributeAsync(
            final String orderId,
            final String customAttributeKey);

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
    RetrieveOrderCustomAttributeResponse retrieveOrderCustomAttribute(
            final String orderId,
            final String customAttributeKey,
            final Integer version,
            final Boolean withDefinition) throws ApiException, IOException;

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
    CompletableFuture<RetrieveOrderCustomAttributeResponse> retrieveOrderCustomAttributeAsync(
            final String orderId,
            final String customAttributeKey,
            final Integer version,
            final Boolean withDefinition);

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
    UpsertOrderCustomAttributeResponse upsertOrderCustomAttribute(
            final String orderId,
            final String customAttributeKey,
            final UpsertOrderCustomAttributeRequest body) throws ApiException, IOException;

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
    CompletableFuture<UpsertOrderCustomAttributeResponse> upsertOrderCustomAttributeAsync(
            final String orderId,
            final String customAttributeKey,
            final UpsertOrderCustomAttributeRequest body);

}