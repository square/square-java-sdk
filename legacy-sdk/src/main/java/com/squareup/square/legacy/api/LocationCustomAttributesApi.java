package com.squareup.square.legacy.api;

import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.BulkDeleteLocationCustomAttributesRequest;
import com.squareup.square.legacy.models.BulkDeleteLocationCustomAttributesResponse;
import com.squareup.square.legacy.models.BulkUpsertLocationCustomAttributesRequest;
import com.squareup.square.legacy.models.BulkUpsertLocationCustomAttributesResponse;
import com.squareup.square.legacy.models.CreateLocationCustomAttributeDefinitionRequest;
import com.squareup.square.legacy.models.CreateLocationCustomAttributeDefinitionResponse;
import com.squareup.square.legacy.models.DeleteLocationCustomAttributeDefinitionResponse;
import com.squareup.square.legacy.models.DeleteLocationCustomAttributeResponse;
import com.squareup.square.legacy.models.ListLocationCustomAttributeDefinitionsResponse;
import com.squareup.square.legacy.models.ListLocationCustomAttributesResponse;
import com.squareup.square.legacy.models.RetrieveLocationCustomAttributeDefinitionResponse;
import com.squareup.square.legacy.models.RetrieveLocationCustomAttributeResponse;
import com.squareup.square.legacy.models.UpdateLocationCustomAttributeDefinitionRequest;
import com.squareup.square.legacy.models.UpdateLocationCustomAttributeDefinitionResponse;
import com.squareup.square.legacy.models.UpsertLocationCustomAttributeRequest;
import com.squareup.square.legacy.models.UpsertLocationCustomAttributeResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface LocationCustomAttributesApi {
    /**
     * Lists the location-related [custom attribute definitions]($m/CustomAttributeDefinition) that
     * belong to a Square seller account. When all response pages are retrieved, the results include
     * all custom attribute definitions that are visible to the requesting application, including
     * those that are created by other applications and set to `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  visibilityFilter  Optional parameter: Filters the `CustomAttributeDefinition` results
     *         by their `visibility` values.
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListLocationCustomAttributeDefinitionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListLocationCustomAttributeDefinitionsResponse listLocationCustomAttributeDefinitions(
            final String visibilityFilter, final Integer limit, final String cursor) throws ApiException, IOException;

    /**
     * Lists the location-related [custom attribute definitions]($m/CustomAttributeDefinition) that
     * belong to a Square seller account. When all response pages are retrieved, the results include
     * all custom attribute definitions that are visible to the requesting application, including
     * those that are created by other applications and set to `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  visibilityFilter  Optional parameter: Filters the `CustomAttributeDefinition` results
     *         by their `visibility` values.
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListLocationCustomAttributeDefinitionsResponse response from the API call
     */
    CompletableFuture<ListLocationCustomAttributeDefinitionsResponse> listLocationCustomAttributeDefinitionsAsync(
            final String visibilityFilter, final Integer limit, final String cursor);

    /**
     * Creates a location-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to define a custom attribute that can be associated
     * with locations. A custom attribute definition specifies the `key`, `visibility`, `schema`,
     * and other properties for a custom attribute. After the definition is created, you can call
     * [UpsertLocationCustomAttribute]($e/LocationCustomAttributes/UpsertLocationCustomAttribute) or
     * [BulkUpsertLocationCustomAttributes]($e/LocationCustomAttributes/BulkUpsertLocationCustomAttributes)
     * to set the custom attribute for locations.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLocationCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateLocationCustomAttributeDefinitionResponse createLocationCustomAttributeDefinition(
            final CreateLocationCustomAttributeDefinitionRequest body) throws ApiException, IOException;

    /**
     * Creates a location-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to define a custom attribute that can be associated
     * with locations. A custom attribute definition specifies the `key`, `visibility`, `schema`,
     * and other properties for a custom attribute. After the definition is created, you can call
     * [UpsertLocationCustomAttribute]($e/LocationCustomAttributes/UpsertLocationCustomAttribute) or
     * [BulkUpsertLocationCustomAttributes]($e/LocationCustomAttributes/BulkUpsertLocationCustomAttributes)
     * to set the custom attribute for locations.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLocationCustomAttributeDefinitionResponse response from the API call
     */
    CompletableFuture<CreateLocationCustomAttributeDefinitionResponse> createLocationCustomAttributeDefinitionAsync(
            final CreateLocationCustomAttributeDefinitionRequest body);

    /**
     * Deletes a location-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Deleting a custom attribute definition also deletes the corresponding
     * custom attribute from all locations. Only the definition owner can delete a custom attribute
     * definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteLocationCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteLocationCustomAttributeDefinitionResponse deleteLocationCustomAttributeDefinition(final String key)
            throws ApiException, IOException;

    /**
     * Deletes a location-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Deleting a custom attribute definition also deletes the corresponding
     * custom attribute from all locations. Only the definition owner can delete a custom attribute
     * definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteLocationCustomAttributeDefinitionResponse response from the API call
     */
    CompletableFuture<DeleteLocationCustomAttributeDefinitionResponse> deleteLocationCustomAttributeDefinitionAsync(
            final String key);

    /**
     * Retrieves a location-related [custom attribute definition]($m/CustomAttributeDefinition) from
     * a Square seller account. To retrieve a custom attribute definition created by another
     * application, the `visibility` setting must be `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  key  Required parameter: The key of the custom attribute definition to retrieve. If
     *         the requesting application is not the definition owner, you must use the qualified
     *         key.
     * @param  version  Optional parameter: The current version of the custom attribute definition,
     *         which is used for strongly consistent reads to guarantee that you receive the most
     *         up-to-date data. When included in the request, Square returns the specified version
     *         or a higher version if one exists. If the specified version is higher than the
     *         current version, Square returns a `BAD_REQUEST` error.
     * @return    Returns the RetrieveLocationCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveLocationCustomAttributeDefinitionResponse retrieveLocationCustomAttributeDefinition(
            final String key, final Integer version) throws ApiException, IOException;

    /**
     * Retrieves a location-related [custom attribute definition]($m/CustomAttributeDefinition) from
     * a Square seller account. To retrieve a custom attribute definition created by another
     * application, the `visibility` setting must be `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  key  Required parameter: The key of the custom attribute definition to retrieve. If
     *         the requesting application is not the definition owner, you must use the qualified
     *         key.
     * @param  version  Optional parameter: The current version of the custom attribute definition,
     *         which is used for strongly consistent reads to guarantee that you receive the most
     *         up-to-date data. When included in the request, Square returns the specified version
     *         or a higher version if one exists. If the specified version is higher than the
     *         current version, Square returns a `BAD_REQUEST` error.
     * @return    Returns the RetrieveLocationCustomAttributeDefinitionResponse response from the API call
     */
    CompletableFuture<RetrieveLocationCustomAttributeDefinitionResponse> retrieveLocationCustomAttributeDefinitionAsync(
            final String key, final Integer version);

    /**
     * Updates a location-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to update the following fields: `name`,
     * `description`, `visibility`, or the `schema` for a `Selection` data type. Only the definition
     * owner can update a custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateLocationCustomAttributeDefinitionResponse updateLocationCustomAttributeDefinition(
            final String key, final UpdateLocationCustomAttributeDefinitionRequest body)
            throws ApiException, IOException;

    /**
     * Updates a location-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to update the following fields: `name`,
     * `description`, `visibility`, or the `schema` for a `Selection` data type. Only the definition
     * owner can update a custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationCustomAttributeDefinitionResponse response from the API call
     */
    CompletableFuture<UpdateLocationCustomAttributeDefinitionResponse> updateLocationCustomAttributeDefinitionAsync(
            final String key, final UpdateLocationCustomAttributeDefinitionRequest body);

    /**
     * Deletes [custom attributes]($m/CustomAttribute) for locations as a bulk operation. To delete
     * a custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteLocationCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BulkDeleteLocationCustomAttributesResponse bulkDeleteLocationCustomAttributes(
            final BulkDeleteLocationCustomAttributesRequest body) throws ApiException, IOException;

    /**
     * Deletes [custom attributes]($m/CustomAttribute) for locations as a bulk operation. To delete
     * a custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteLocationCustomAttributesResponse response from the API call
     */
    CompletableFuture<BulkDeleteLocationCustomAttributesResponse> bulkDeleteLocationCustomAttributesAsync(
            final BulkDeleteLocationCustomAttributesRequest body);

    /**
     * Creates or updates [custom attributes]($m/CustomAttribute) for locations as a bulk operation.
     * Use this endpoint to set the value of one or more custom attributes for one or more
     * locations. A custom attribute is based on a custom attribute definition in a Square seller
     * account, which is created using the
     * [CreateLocationCustomAttributeDefinition]($e/LocationCustomAttributes/CreateLocationCustomAttributeDefinition)
     * endpoint. This `BulkUpsertLocationCustomAttributes` endpoint accepts a map of 1 to 25
     * individual upsert requests and returns a map of individual upsert responses. Each upsert
     * request has a unique ID and provides a location ID and custom attribute. Each upsert response
     * is returned with the ID of the corresponding request. To create or update a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertLocationCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BulkUpsertLocationCustomAttributesResponse bulkUpsertLocationCustomAttributes(
            final BulkUpsertLocationCustomAttributesRequest body) throws ApiException, IOException;

    /**
     * Creates or updates [custom attributes]($m/CustomAttribute) for locations as a bulk operation.
     * Use this endpoint to set the value of one or more custom attributes for one or more
     * locations. A custom attribute is based on a custom attribute definition in a Square seller
     * account, which is created using the
     * [CreateLocationCustomAttributeDefinition]($e/LocationCustomAttributes/CreateLocationCustomAttributeDefinition)
     * endpoint. This `BulkUpsertLocationCustomAttributes` endpoint accepts a map of 1 to 25
     * individual upsert requests and returns a map of individual upsert responses. Each upsert
     * request has a unique ID and provides a location ID and custom attribute. Each upsert response
     * is returned with the ID of the corresponding request. To create or update a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertLocationCustomAttributesResponse response from the API call
     */
    CompletableFuture<BulkUpsertLocationCustomAttributesResponse> bulkUpsertLocationCustomAttributesAsync(
            final BulkUpsertLocationCustomAttributesRequest body);

    /**
     * Lists the [custom attributes]($m/CustomAttribute) associated with a location. You can use the
     * `with_definitions` query parameter to also retrieve custom attribute definitions in the same
     * call. When all response pages are retrieved, the results include all custom attributes that
     * are visible to the requesting application, including those that are owned by other
     * applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  locationId  Required parameter: The ID of the target [location](entity:Location).
     * @param  visibilityFilter  Optional parameter: Filters the `CustomAttributeDefinition` results
     *         by their `visibility` values.
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
     *         attribute definition](entity:CustomAttributeDefinition) in the `definition` field of
     *         each custom attribute. Set this parameter to `true` to get the name and description
     *         of each custom attribute, information about the data type, or other definition
     *         details. The default value is `false`.
     * @return    Returns the ListLocationCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListLocationCustomAttributesResponse listLocationCustomAttributes(
            final String locationId,
            final String visibilityFilter,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions)
            throws ApiException, IOException;

    /**
     * Lists the [custom attributes]($m/CustomAttribute) associated with a location. You can use the
     * `with_definitions` query parameter to also retrieve custom attribute definitions in the same
     * call. When all response pages are retrieved, the results include all custom attributes that
     * are visible to the requesting application, including those that are owned by other
     * applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  locationId  Required parameter: The ID of the target [location](entity:Location).
     * @param  visibilityFilter  Optional parameter: Filters the `CustomAttributeDefinition` results
     *         by their `visibility` values.
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
     *         attribute definition](entity:CustomAttributeDefinition) in the `definition` field of
     *         each custom attribute. Set this parameter to `true` to get the name and description
     *         of each custom attribute, information about the data type, or other definition
     *         details. The default value is `false`.
     * @return    Returns the ListLocationCustomAttributesResponse response from the API call
     */
    CompletableFuture<ListLocationCustomAttributesResponse> listLocationCustomAttributesAsync(
            final String locationId,
            final String visibilityFilter,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions);

    /**
     * Deletes a [custom attribute]($m/CustomAttribute) associated with a location. To delete a
     * custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  locationId  Required parameter: The ID of the target [location](entity:Location).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteLocationCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteLocationCustomAttributeResponse deleteLocationCustomAttribute(final String locationId, final String key)
            throws ApiException, IOException;

    /**
     * Deletes a [custom attribute]($m/CustomAttribute) associated with a location. To delete a
     * custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  locationId  Required parameter: The ID of the target [location](entity:Location).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteLocationCustomAttributeResponse response from the API call
     */
    CompletableFuture<DeleteLocationCustomAttributeResponse> deleteLocationCustomAttributeAsync(
            final String locationId, final String key);

    /**
     * Retrieves a [custom attribute]($m/CustomAttribute) associated with a location. You can use
     * the `with_definition` query parameter to also retrieve the custom attribute definition in the
     * same call. To retrieve a custom attribute owned by another application, the `visibility`
     * setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  locationId  Required parameter: The ID of the target [location](entity:Location).
     * @param  key  Required parameter: The key of the custom attribute to retrieve. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @param  withDefinition  Optional parameter: Indicates whether to return the [custom attribute
     *         definition](entity:CustomAttributeDefinition) in the `definition` field of the custom
     *         attribute. Set this parameter to `true` to get the name and description of the custom
     *         attribute, information about the data type, or other definition details. The default
     *         value is `false`.
     * @param  version  Optional parameter: The current version of the custom attribute, which is
     *         used for strongly consistent reads to guarantee that you receive the most up-to-date
     *         data. When included in the request, Square returns the specified version or a higher
     *         version if one exists. If the specified version is higher than the current version,
     *         Square returns a `BAD_REQUEST` error.
     * @return    Returns the RetrieveLocationCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveLocationCustomAttributeResponse retrieveLocationCustomAttribute(
            final String locationId, final String key, final Boolean withDefinition, final Integer version)
            throws ApiException, IOException;

    /**
     * Retrieves a [custom attribute]($m/CustomAttribute) associated with a location. You can use
     * the `with_definition` query parameter to also retrieve the custom attribute definition in the
     * same call. To retrieve a custom attribute owned by another application, the `visibility`
     * setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  locationId  Required parameter: The ID of the target [location](entity:Location).
     * @param  key  Required parameter: The key of the custom attribute to retrieve. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @param  withDefinition  Optional parameter: Indicates whether to return the [custom attribute
     *         definition](entity:CustomAttributeDefinition) in the `definition` field of the custom
     *         attribute. Set this parameter to `true` to get the name and description of the custom
     *         attribute, information about the data type, or other definition details. The default
     *         value is `false`.
     * @param  version  Optional parameter: The current version of the custom attribute, which is
     *         used for strongly consistent reads to guarantee that you receive the most up-to-date
     *         data. When included in the request, Square returns the specified version or a higher
     *         version if one exists. If the specified version is higher than the current version,
     *         Square returns a `BAD_REQUEST` error.
     * @return    Returns the RetrieveLocationCustomAttributeResponse response from the API call
     */
    CompletableFuture<RetrieveLocationCustomAttributeResponse> retrieveLocationCustomAttributeAsync(
            final String locationId, final String key, final Boolean withDefinition, final Integer version);

    /**
     * Creates or updates a [custom attribute]($m/CustomAttribute) for a location. Use this endpoint
     * to set the value of a custom attribute for a specified location. A custom attribute is based
     * on a custom attribute definition in a Square seller account, which is created using the
     * [CreateLocationCustomAttributeDefinition]($e/LocationCustomAttributes/CreateLocationCustomAttributeDefinition)
     * endpoint. To create or update a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`.
     * @param  locationId  Required parameter: The ID of the target [location](entity:Location).
     * @param  key  Required parameter: The key of the custom attribute to create or update. This
     *         key must match the `key` of a custom attribute definition in the Square seller
     *         account. If the requesting application is not the definition owner, you must use the
     *         qualified key.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertLocationCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpsertLocationCustomAttributeResponse upsertLocationCustomAttribute(
            final String locationId, final String key, final UpsertLocationCustomAttributeRequest body)
            throws ApiException, IOException;

    /**
     * Creates or updates a [custom attribute]($m/CustomAttribute) for a location. Use this endpoint
     * to set the value of a custom attribute for a specified location. A custom attribute is based
     * on a custom attribute definition in a Square seller account, which is created using the
     * [CreateLocationCustomAttributeDefinition]($e/LocationCustomAttributes/CreateLocationCustomAttributeDefinition)
     * endpoint. To create or update a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`.
     * @param  locationId  Required parameter: The ID of the target [location](entity:Location).
     * @param  key  Required parameter: The key of the custom attribute to create or update. This
     *         key must match the `key` of a custom attribute definition in the Square seller
     *         account. If the requesting application is not the definition owner, you must use the
     *         qualified key.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertLocationCustomAttributeResponse response from the API call
     */
    CompletableFuture<UpsertLocationCustomAttributeResponse> upsertLocationCustomAttributeAsync(
            final String locationId, final String key, final UpsertLocationCustomAttributeRequest body);
}
