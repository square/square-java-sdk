
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
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
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCustomerCustomAttributesApi extends BaseApi implements CustomerCustomAttributesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultCustomerCustomAttributesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Lists the customer-related [custom attribute definitions]($m/CustomAttributeDefinition) that
     * belong to a Square seller account. When all response pages are retrieved, the results include
     * all custom attribute definitions that are visible to the requesting application, including
     * those that are created by other applications and set to `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
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
        return prepareListCustomerCustomAttributeDefinitionsRequest(limit, cursor).execute();
    }

    /**
     * Lists the customer-related [custom attribute definitions]($m/CustomAttributeDefinition) that
     * belong to a Square seller account. When all response pages are retrieved, the results include
     * all custom attribute definitions that are visible to the requesting application, including
     * those that are created by other applications and set to `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
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
        try { 
            return prepareListCustomerCustomAttributeDefinitionsRequest(limit, cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listCustomerCustomAttributeDefinitions.
     */
    private ApiCall<ListCustomerCustomAttributeDefinitionsResponse, ApiException> prepareListCustomerCustomAttributeDefinitionsRequest(
            final Integer limit,
            final String cursor) throws IOException {
        return new ApiCall.Builder<ListCustomerCustomAttributeDefinitionsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/custom-attribute-definitions")
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListCustomerCustomAttributeDefinitionsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a customer-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to define a custom attribute that can be associated
     * with customer profiles. A custom attribute definition specifies the `key`, `visibility`,
     * `schema`, and other properties for a custom attribute. After the definition is created, you
     * can call
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
        return prepareCreateCustomerCustomAttributeDefinitionRequest(body).execute();
    }

    /**
     * Creates a customer-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to define a custom attribute that can be associated
     * with customer profiles. A custom attribute definition specifies the `key`, `visibility`,
     * `schema`, and other properties for a custom attribute. After the definition is created, you
     * can call
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
        try { 
            return prepareCreateCustomerCustomAttributeDefinitionRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createCustomerCustomAttributeDefinition.
     */
    private ApiCall<CreateCustomerCustomAttributeDefinitionResponse, ApiException> prepareCreateCustomerCustomAttributeDefinitionRequest(
            final CreateCustomerCustomAttributeDefinitionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateCustomerCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/custom-attribute-definitions")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateCustomerCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a customer-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Deleting a custom attribute definition also deletes the corresponding
     * custom attribute from all customer profiles in the seller's Customer Directory. Only the
     * definition owner can delete a custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteCustomerCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteCustomerCustomAttributeDefinitionResponse deleteCustomerCustomAttributeDefinition(
            final String key) throws ApiException, IOException {
        return prepareDeleteCustomerCustomAttributeDefinitionRequest(key).execute();
    }

    /**
     * Deletes a customer-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Deleting a custom attribute definition also deletes the corresponding
     * custom attribute from all customer profiles in the seller's Customer Directory. Only the
     * definition owner can delete a custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteCustomerCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<DeleteCustomerCustomAttributeDefinitionResponse> deleteCustomerCustomAttributeDefinitionAsync(
            final String key) {
        try { 
            return prepareDeleteCustomerCustomAttributeDefinitionRequest(key).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteCustomerCustomAttributeDefinition.
     */
    private ApiCall<DeleteCustomerCustomAttributeDefinitionResponse, ApiException> prepareDeleteCustomerCustomAttributeDefinitionRequest(
            final String key) throws IOException {
        return new ApiCall.Builder<DeleteCustomerCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/custom-attribute-definitions/{key}")
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteCustomerCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a customer-related [custom attribute definition]($m/CustomAttributeDefinition) from
     * a Square seller account. To retrieve a custom attribute definition created by another
     * application, the `visibility` setting must be `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
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
        return prepareRetrieveCustomerCustomAttributeDefinitionRequest(key, version).execute();
    }

    /**
     * Retrieves a customer-related [custom attribute definition]($m/CustomAttributeDefinition) from
     * a Square seller account. To retrieve a custom attribute definition created by another
     * application, the `visibility` setting must be `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
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
        try { 
            return prepareRetrieveCustomerCustomAttributeDefinitionRequest(key, version).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveCustomerCustomAttributeDefinition.
     */
    private ApiCall<RetrieveCustomerCustomAttributeDefinitionResponse, ApiException> prepareRetrieveCustomerCustomAttributeDefinitionRequest(
            final String key,
            final Integer version) throws IOException {
        return new ApiCall.Builder<RetrieveCustomerCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/custom-attribute-definitions/{key}")
                        .queryParam(param -> param.key("version")
                                .value(version).isRequired(false))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveCustomerCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates a customer-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to update the following fields: `name`,
     * `description`, `visibility`, or the `schema` for a `Selection` data type. Only the definition
     * owner can update a custom attribute definition. Note that sellers can view all custom
     * attributes in exported customer data, including those set to `VISIBILITY_HIDDEN`.
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
        return prepareUpdateCustomerCustomAttributeDefinitionRequest(key, body).execute();
    }

    /**
     * Updates a customer-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to update the following fields: `name`,
     * `description`, `visibility`, or the `schema` for a `Selection` data type. Only the definition
     * owner can update a custom attribute definition. Note that sellers can view all custom
     * attributes in exported customer data, including those set to `VISIBILITY_HIDDEN`.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<UpdateCustomerCustomAttributeDefinitionResponse> updateCustomerCustomAttributeDefinitionAsync(
            final String key,
            final UpdateCustomerCustomAttributeDefinitionRequest body) {
        try { 
            return prepareUpdateCustomerCustomAttributeDefinitionRequest(key, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateCustomerCustomAttributeDefinition.
     */
    private ApiCall<UpdateCustomerCustomAttributeDefinitionResponse, ApiException> prepareUpdateCustomerCustomAttributeDefinitionRequest(
            final String key,
            final UpdateCustomerCustomAttributeDefinitionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateCustomerCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/custom-attribute-definitions/{key}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateCustomerCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates or updates [custom attributes]($m/CustomAttribute) for customer profiles as a bulk
     * operation. Use this endpoint to set the value of one or more custom attributes for one or
     * more customer profiles. A custom attribute is based on a custom attribute definition in a
     * Square seller account, which is created using the
     * [CreateCustomerCustomAttributeDefinition]($e/CustomerCustomAttributes/CreateCustomerCustomAttributeDefinition)
     * endpoint. This `BulkUpsertCustomerCustomAttributes` endpoint accepts a map of 1 to 25
     * individual upsert requests and returns a map of individual upsert responses. Each upsert
     * request has a unique ID and provides a customer ID and custom attribute. Each upsert response
     * is returned with the ID of the corresponding request. To create or update a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertCustomerCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkUpsertCustomerCustomAttributesResponse bulkUpsertCustomerCustomAttributes(
            final BulkUpsertCustomerCustomAttributesRequest body) throws ApiException, IOException {
        return prepareBulkUpsertCustomerCustomAttributesRequest(body).execute();
    }

    /**
     * Creates or updates [custom attributes]($m/CustomAttribute) for customer profiles as a bulk
     * operation. Use this endpoint to set the value of one or more custom attributes for one or
     * more customer profiles. A custom attribute is based on a custom attribute definition in a
     * Square seller account, which is created using the
     * [CreateCustomerCustomAttributeDefinition]($e/CustomerCustomAttributes/CreateCustomerCustomAttributeDefinition)
     * endpoint. This `BulkUpsertCustomerCustomAttributes` endpoint accepts a map of 1 to 25
     * individual upsert requests and returns a map of individual upsert responses. Each upsert
     * request has a unique ID and provides a customer ID and custom attribute. Each upsert response
     * is returned with the ID of the corresponding request. To create or update a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertCustomerCustomAttributesResponse response from the API call
     */
    public CompletableFuture<BulkUpsertCustomerCustomAttributesResponse> bulkUpsertCustomerCustomAttributesAsync(
            final BulkUpsertCustomerCustomAttributesRequest body) {
        try { 
            return prepareBulkUpsertCustomerCustomAttributesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkUpsertCustomerCustomAttributes.
     */
    private ApiCall<BulkUpsertCustomerCustomAttributesResponse, ApiException> prepareBulkUpsertCustomerCustomAttributesRequest(
            final BulkUpsertCustomerCustomAttributesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkUpsertCustomerCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/custom-attributes/bulk-upsert")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkUpsertCustomerCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Lists the [custom attributes]($m/CustomAttribute) associated with a customer profile. You can
     * use the `with_definitions` query parameter to also retrieve custom attribute definitions in
     * the same call. When all response pages are retrieved, the results include all custom
     * attributes that are visible to the requesting application, including those that are owned by
     * other applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer
     *         profile](entity:Customer).
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
     * @return    Returns the ListCustomerCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCustomerCustomAttributesResponse listCustomerCustomAttributes(
            final String customerId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws ApiException, IOException {
        return prepareListCustomerCustomAttributesRequest(customerId, limit, cursor,
                withDefinitions).execute();
    }

    /**
     * Lists the [custom attributes]($m/CustomAttribute) associated with a customer profile. You can
     * use the `with_definitions` query parameter to also retrieve custom attribute definitions in
     * the same call. When all response pages are retrieved, the results include all custom
     * attributes that are visible to the requesting application, including those that are owned by
     * other applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer
     *         profile](entity:Customer).
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
     * @return    Returns the ListCustomerCustomAttributesResponse response from the API call
     */
    public CompletableFuture<ListCustomerCustomAttributesResponse> listCustomerCustomAttributesAsync(
            final String customerId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) {
        try { 
            return prepareListCustomerCustomAttributesRequest(customerId, limit, cursor,
            withDefinitions).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listCustomerCustomAttributes.
     */
    private ApiCall<ListCustomerCustomAttributesResponse, ApiException> prepareListCustomerCustomAttributesRequest(
            final String customerId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws IOException {
        return new ApiCall.Builder<ListCustomerCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}/custom-attributes")
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("with_definitions")
                                .value((withDefinitions != null) ? withDefinitions : false).isRequired(false))
                        .templateParam(param -> param.key("customer_id").value(customerId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListCustomerCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a [custom attribute]($m/CustomAttribute) associated with a customer profile. To
     * delete a custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer
     *         profile](entity:Customer).
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
        return prepareDeleteCustomerCustomAttributeRequest(customerId, key).execute();
    }

    /**
     * Deletes a [custom attribute]($m/CustomAttribute) associated with a customer profile. To
     * delete a custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes (also known as
     * custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer
     *         profile](entity:Customer).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteCustomerCustomAttributeResponse response from the API call
     */
    public CompletableFuture<DeleteCustomerCustomAttributeResponse> deleteCustomerCustomAttributeAsync(
            final String customerId,
            final String key) {
        try { 
            return prepareDeleteCustomerCustomAttributeRequest(customerId, key).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteCustomerCustomAttribute.
     */
    private ApiCall<DeleteCustomerCustomAttributeResponse, ApiException> prepareDeleteCustomerCustomAttributeRequest(
            final String customerId,
            final String key) throws IOException {
        return new ApiCall.Builder<DeleteCustomerCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}/custom-attributes/{key}")
                        .templateParam(param -> param.key("customer_id").value(customerId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteCustomerCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a [custom attribute]($m/CustomAttribute) associated with a customer profile. You
     * can use the `with_definition` query parameter to also retrieve the custom attribute
     * definition in the same call. To retrieve a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`. Note
     * that seller-defined custom attributes (also known as custom fields) are always set to
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer
     *         profile](entity:Customer).
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
     * @return    Returns the RetrieveCustomerCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCustomerCustomAttributeResponse retrieveCustomerCustomAttribute(
            final String customerId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws ApiException, IOException {
        return prepareRetrieveCustomerCustomAttributeRequest(customerId, key, withDefinition,
                version).execute();
    }

    /**
     * Retrieves a [custom attribute]($m/CustomAttribute) associated with a customer profile. You
     * can use the `with_definition` query parameter to also retrieve the custom attribute
     * definition in the same call. To retrieve a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`. Note
     * that seller-defined custom attributes (also known as custom fields) are always set to
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer
     *         profile](entity:Customer).
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
     * @return    Returns the RetrieveCustomerCustomAttributeResponse response from the API call
     */
    public CompletableFuture<RetrieveCustomerCustomAttributeResponse> retrieveCustomerCustomAttributeAsync(
            final String customerId,
            final String key,
            final Boolean withDefinition,
            final Integer version) {
        try { 
            return prepareRetrieveCustomerCustomAttributeRequest(customerId, key, withDefinition,
            version).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveCustomerCustomAttribute.
     */
    private ApiCall<RetrieveCustomerCustomAttributeResponse, ApiException> prepareRetrieveCustomerCustomAttributeRequest(
            final String customerId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws IOException {
        return new ApiCall.Builder<RetrieveCustomerCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}/custom-attributes/{key}")
                        .queryParam(param -> param.key("with_definition")
                                .value((withDefinition != null) ? withDefinition : false).isRequired(false))
                        .queryParam(param -> param.key("version")
                                .value(version).isRequired(false))
                        .templateParam(param -> param.key("customer_id").value(customerId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveCustomerCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates or updates a [custom attribute]($m/CustomAttribute) for a customer profile. Use this
     * endpoint to set the value of a custom attribute for a specified customer profile. A custom
     * attribute is based on a custom attribute definition in a Square seller account, which is
     * created using the
     * [CreateCustomerCustomAttributeDefinition]($e/CustomerCustomAttributes/CreateCustomerCustomAttributeDefinition)
     * endpoint. To create or update a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom
     * attributes (also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer
     *         profile](entity:Customer).
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
        return prepareUpsertCustomerCustomAttributeRequest(customerId, key, body).execute();
    }

    /**
     * Creates or updates a [custom attribute]($m/CustomAttribute) for a customer profile. Use this
     * endpoint to set the value of a custom attribute for a specified customer profile. A custom
     * attribute is based on a custom attribute definition in a Square seller account, which is
     * created using the
     * [CreateCustomerCustomAttributeDefinition]($e/CustomerCustomAttributes/CreateCustomerCustomAttributeDefinition)
     * endpoint. To create or update a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom
     * attributes (also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.
     * @param  customerId  Required parameter: The ID of the target [customer
     *         profile](entity:Customer).
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
        try { 
            return prepareUpsertCustomerCustomAttributeRequest(customerId, key, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for upsertCustomerCustomAttribute.
     */
    private ApiCall<UpsertCustomerCustomAttributeResponse, ApiException> prepareUpsertCustomerCustomAttributeRequest(
            final String customerId,
            final String key,
            final UpsertCustomerCustomAttributeRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpsertCustomerCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}/custom-attributes/{key}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("customer_id").value(customerId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpsertCustomerCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}