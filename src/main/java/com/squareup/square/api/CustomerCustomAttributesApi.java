
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
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
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CustomerCustomAttributesApi {
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
    ListCustomerCustomAttributeDefinitionsResponse listCustomerCustomAttributeDefinitions(
            final Integer limit,
            final String cursor) throws ApiException, IOException;

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
    CompletableFuture<ListCustomerCustomAttributeDefinitionsResponse> listCustomerCustomAttributeDefinitionsAsync(
            final Integer limit,
            final String cursor);

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
    CreateCustomerCustomAttributeDefinitionResponse createCustomerCustomAttributeDefinition(
            final CreateCustomerCustomAttributeDefinitionRequest body) throws ApiException, IOException;

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
    CompletableFuture<CreateCustomerCustomAttributeDefinitionResponse> createCustomerCustomAttributeDefinitionAsync(
            final CreateCustomerCustomAttributeDefinitionRequest body);

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
    DeleteCustomerCustomAttributeDefinitionResponse deleteCustomerCustomAttributeDefinition(
            final String key) throws ApiException, IOException;

    /**
     * Deletes a customer-related custom attribute definition from a Square seller account. Deleting
     * a custom attribute definition also deletes the corresponding custom attribute from all
     * customer profiles in the seller's Customer Directory. Only the definition owner can delete a
     * custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteCustomerCustomAttributeDefinitionResponse response from the API call
     */
    CompletableFuture<DeleteCustomerCustomAttributeDefinitionResponse> deleteCustomerCustomAttributeDefinitionAsync(
            final String key);

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
    RetrieveCustomerCustomAttributeDefinitionResponse retrieveCustomerCustomAttributeDefinition(
            final String key,
            final Integer version) throws ApiException, IOException;

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
    CompletableFuture<RetrieveCustomerCustomAttributeDefinitionResponse> retrieveCustomerCustomAttributeDefinitionAsync(
            final String key,
            final Integer version);

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
    UpdateCustomerCustomAttributeDefinitionResponse updateCustomerCustomAttributeDefinition(
            final String key,
            final UpdateCustomerCustomAttributeDefinitionRequest body) throws ApiException, IOException;

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
    CompletableFuture<UpdateCustomerCustomAttributeDefinitionResponse> updateCustomerCustomAttributeDefinitionAsync(
            final String key,
            final UpdateCustomerCustomAttributeDefinitionRequest body);

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
    BulkUpsertCustomerCustomAttributesResponse bulkUpsertCustomerCustomAttributes(
            final BulkUpsertCustomerCustomAttributesRequest body) throws ApiException, IOException;

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
    CompletableFuture<BulkUpsertCustomerCustomAttributesResponse> bulkUpsertCustomerCustomAttributesAsync(
            final BulkUpsertCustomerCustomAttributesRequest body);

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
    ListCustomerCustomAttributesResponse listCustomerCustomAttributes(
            final String customerId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws ApiException, IOException;

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
    CompletableFuture<ListCustomerCustomAttributesResponse> listCustomerCustomAttributesAsync(
            final String customerId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions);

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
    DeleteCustomerCustomAttributeResponse deleteCustomerCustomAttribute(
            final String customerId,
            final String key) throws ApiException, IOException;

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
    CompletableFuture<DeleteCustomerCustomAttributeResponse> deleteCustomerCustomAttributeAsync(
            final String customerId,
            final String key);

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
    RetrieveCustomerCustomAttributeResponse retrieveCustomerCustomAttribute(
            final String customerId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws ApiException, IOException;

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
    CompletableFuture<RetrieveCustomerCustomAttributeResponse> retrieveCustomerCustomAttributeAsync(
            final String customerId,
            final String key,
            final Boolean withDefinition,
            final Integer version);

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
    UpsertCustomerCustomAttributeResponse upsertCustomerCustomAttribute(
            final String customerId,
            final String key,
            final UpsertCustomerCustomAttributeRequest body) throws ApiException, IOException;

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
    CompletableFuture<UpsertCustomerCustomAttributeResponse> upsertCustomerCustomAttributeAsync(
            final String customerId,
            final String key,
            final UpsertCustomerCustomAttributeRequest body);

}