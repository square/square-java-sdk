
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.BulkDeleteMerchantCustomAttributesRequest;
import com.squareup.square.models.BulkDeleteMerchantCustomAttributesResponse;
import com.squareup.square.models.BulkUpsertMerchantCustomAttributesRequest;
import com.squareup.square.models.BulkUpsertMerchantCustomAttributesResponse;
import com.squareup.square.models.CreateMerchantCustomAttributeDefinitionRequest;
import com.squareup.square.models.CreateMerchantCustomAttributeDefinitionResponse;
import com.squareup.square.models.DeleteMerchantCustomAttributeDefinitionResponse;
import com.squareup.square.models.DeleteMerchantCustomAttributeResponse;
import com.squareup.square.models.ListMerchantCustomAttributeDefinitionsResponse;
import com.squareup.square.models.ListMerchantCustomAttributesResponse;
import com.squareup.square.models.RetrieveMerchantCustomAttributeDefinitionResponse;
import com.squareup.square.models.RetrieveMerchantCustomAttributeResponse;
import com.squareup.square.models.UpdateMerchantCustomAttributeDefinitionRequest;
import com.squareup.square.models.UpdateMerchantCustomAttributeDefinitionResponse;
import com.squareup.square.models.UpsertMerchantCustomAttributeRequest;
import com.squareup.square.models.UpsertMerchantCustomAttributeResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultMerchantCustomAttributesApi extends BaseApi implements MerchantCustomAttributesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultMerchantCustomAttributesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Lists the merchant-related [custom attribute definitions]($m/CustomAttributeDefinition) that
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
     * @return    Returns the ListMerchantCustomAttributeDefinitionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListMerchantCustomAttributeDefinitionsResponse listMerchantCustomAttributeDefinitions(
            final String visibilityFilter,
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        return prepareListMerchantCustomAttributeDefinitionsRequest(visibilityFilter, limit,
                cursor).execute();
    }

    /**
     * Lists the merchant-related [custom attribute definitions]($m/CustomAttributeDefinition) that
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
     * @return    Returns the ListMerchantCustomAttributeDefinitionsResponse response from the API call
     */
    public CompletableFuture<ListMerchantCustomAttributeDefinitionsResponse> listMerchantCustomAttributeDefinitionsAsync(
            final String visibilityFilter,
            final Integer limit,
            final String cursor) {
        try { 
            return prepareListMerchantCustomAttributeDefinitionsRequest(visibilityFilter, limit,
            cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listMerchantCustomAttributeDefinitions.
     */
    private ApiCall<ListMerchantCustomAttributeDefinitionsResponse, ApiException> prepareListMerchantCustomAttributeDefinitionsRequest(
            final String visibilityFilter,
            final Integer limit,
            final String cursor) throws IOException {
        return new ApiCall.Builder<ListMerchantCustomAttributeDefinitionsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/custom-attribute-definitions")
                        .queryParam(param -> param.key("visibility_filter")
                                .value(visibilityFilter).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListMerchantCustomAttributeDefinitionsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a merchant-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to define a custom attribute that can be associated
     * with a merchant connecting to your application. A custom attribute definition specifies the
     * `key`, `visibility`, `schema`, and other properties for a custom attribute. After the
     * definition is created, you can call
     * [UpsertMerchantCustomAttribute]($e/MerchantCustomAttributes/UpsertMerchantCustomAttribute) or
     * [BulkUpsertMerchantCustomAttributes]($e/MerchantCustomAttributes/BulkUpsertMerchantCustomAttributes)
     * to set the custom attribute for a merchant.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateMerchantCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateMerchantCustomAttributeDefinitionResponse createMerchantCustomAttributeDefinition(
            final CreateMerchantCustomAttributeDefinitionRequest body) throws ApiException, IOException {
        return prepareCreateMerchantCustomAttributeDefinitionRequest(body).execute();
    }

    /**
     * Creates a merchant-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to define a custom attribute that can be associated
     * with a merchant connecting to your application. A custom attribute definition specifies the
     * `key`, `visibility`, `schema`, and other properties for a custom attribute. After the
     * definition is created, you can call
     * [UpsertMerchantCustomAttribute]($e/MerchantCustomAttributes/UpsertMerchantCustomAttribute) or
     * [BulkUpsertMerchantCustomAttributes]($e/MerchantCustomAttributes/BulkUpsertMerchantCustomAttributes)
     * to set the custom attribute for a merchant.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateMerchantCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<CreateMerchantCustomAttributeDefinitionResponse> createMerchantCustomAttributeDefinitionAsync(
            final CreateMerchantCustomAttributeDefinitionRequest body) {
        try { 
            return prepareCreateMerchantCustomAttributeDefinitionRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createMerchantCustomAttributeDefinition.
     */
    private ApiCall<CreateMerchantCustomAttributeDefinitionResponse, ApiException> prepareCreateMerchantCustomAttributeDefinitionRequest(
            final CreateMerchantCustomAttributeDefinitionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateMerchantCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/custom-attribute-definitions")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateMerchantCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a merchant-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Deleting a custom attribute definition also deletes the corresponding
     * custom attribute from the merchant. Only the definition owner can delete a custom attribute
     * definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteMerchantCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteMerchantCustomAttributeDefinitionResponse deleteMerchantCustomAttributeDefinition(
            final String key) throws ApiException, IOException {
        return prepareDeleteMerchantCustomAttributeDefinitionRequest(key).execute();
    }

    /**
     * Deletes a merchant-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Deleting a custom attribute definition also deletes the corresponding
     * custom attribute from the merchant. Only the definition owner can delete a custom attribute
     * definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteMerchantCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<DeleteMerchantCustomAttributeDefinitionResponse> deleteMerchantCustomAttributeDefinitionAsync(
            final String key) {
        try { 
            return prepareDeleteMerchantCustomAttributeDefinitionRequest(key).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteMerchantCustomAttributeDefinition.
     */
    private ApiCall<DeleteMerchantCustomAttributeDefinitionResponse, ApiException> prepareDeleteMerchantCustomAttributeDefinitionRequest(
            final String key) throws IOException {
        return new ApiCall.Builder<DeleteMerchantCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/custom-attribute-definitions/{key}")
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteMerchantCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a merchant-related [custom attribute definition]($m/CustomAttributeDefinition) from
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
     * @return    Returns the RetrieveMerchantCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveMerchantCustomAttributeDefinitionResponse retrieveMerchantCustomAttributeDefinition(
            final String key,
            final Integer version) throws ApiException, IOException {
        return prepareRetrieveMerchantCustomAttributeDefinitionRequest(key, version).execute();
    }

    /**
     * Retrieves a merchant-related [custom attribute definition]($m/CustomAttributeDefinition) from
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
     * @return    Returns the RetrieveMerchantCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<RetrieveMerchantCustomAttributeDefinitionResponse> retrieveMerchantCustomAttributeDefinitionAsync(
            final String key,
            final Integer version) {
        try { 
            return prepareRetrieveMerchantCustomAttributeDefinitionRequest(key, version).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveMerchantCustomAttributeDefinition.
     */
    private ApiCall<RetrieveMerchantCustomAttributeDefinitionResponse, ApiException> prepareRetrieveMerchantCustomAttributeDefinitionRequest(
            final String key,
            final Integer version) throws IOException {
        return new ApiCall.Builder<RetrieveMerchantCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/custom-attribute-definitions/{key}")
                        .queryParam(param -> param.key("version")
                                .value(version).isRequired(false))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveMerchantCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates a merchant-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to update the following fields: `name`,
     * `description`, `visibility`, or the `schema` for a `Selection` data type. Only the definition
     * owner can update a custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateMerchantCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateMerchantCustomAttributeDefinitionResponse updateMerchantCustomAttributeDefinition(
            final String key,
            final UpdateMerchantCustomAttributeDefinitionRequest body) throws ApiException, IOException {
        return prepareUpdateMerchantCustomAttributeDefinitionRequest(key, body).execute();
    }

    /**
     * Updates a merchant-related [custom attribute definition]($m/CustomAttributeDefinition) for a
     * Square seller account. Use this endpoint to update the following fields: `name`,
     * `description`, `visibility`, or the `schema` for a `Selection` data type. Only the definition
     * owner can update a custom attribute definition.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateMerchantCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<UpdateMerchantCustomAttributeDefinitionResponse> updateMerchantCustomAttributeDefinitionAsync(
            final String key,
            final UpdateMerchantCustomAttributeDefinitionRequest body) {
        try { 
            return prepareUpdateMerchantCustomAttributeDefinitionRequest(key, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateMerchantCustomAttributeDefinition.
     */
    private ApiCall<UpdateMerchantCustomAttributeDefinitionResponse, ApiException> prepareUpdateMerchantCustomAttributeDefinitionRequest(
            final String key,
            final UpdateMerchantCustomAttributeDefinitionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateMerchantCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/custom-attribute-definitions/{key}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateMerchantCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes [custom attributes]($m/CustomAttribute) for a merchant as a bulk operation. To delete
     * a custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteMerchantCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkDeleteMerchantCustomAttributesResponse bulkDeleteMerchantCustomAttributes(
            final BulkDeleteMerchantCustomAttributesRequest body) throws ApiException, IOException {
        return prepareBulkDeleteMerchantCustomAttributesRequest(body).execute();
    }

    /**
     * Deletes [custom attributes]($m/CustomAttribute) for a merchant as a bulk operation. To delete
     * a custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteMerchantCustomAttributesResponse response from the API call
     */
    public CompletableFuture<BulkDeleteMerchantCustomAttributesResponse> bulkDeleteMerchantCustomAttributesAsync(
            final BulkDeleteMerchantCustomAttributesRequest body) {
        try { 
            return prepareBulkDeleteMerchantCustomAttributesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkDeleteMerchantCustomAttributes.
     */
    private ApiCall<BulkDeleteMerchantCustomAttributesResponse, ApiException> prepareBulkDeleteMerchantCustomAttributesRequest(
            final BulkDeleteMerchantCustomAttributesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkDeleteMerchantCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/custom-attributes/bulk-delete")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkDeleteMerchantCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates or updates [custom attributes]($m/CustomAttribute) for a merchant as a bulk
     * operation. Use this endpoint to set the value of one or more custom attributes for a
     * merchant. A custom attribute is based on a custom attribute definition in a Square seller
     * account, which is created using the
     * [CreateMerchantCustomAttributeDefinition]($e/MerchantCustomAttributes/CreateMerchantCustomAttributeDefinition)
     * endpoint. This `BulkUpsertMerchantCustomAttributes` endpoint accepts a map of 1 to 25
     * individual upsert requests and returns a map of individual upsert responses. Each upsert
     * request has a unique ID and provides a merchant ID and custom attribute. Each upsert response
     * is returned with the ID of the corresponding request. To create or update a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertMerchantCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkUpsertMerchantCustomAttributesResponse bulkUpsertMerchantCustomAttributes(
            final BulkUpsertMerchantCustomAttributesRequest body) throws ApiException, IOException {
        return prepareBulkUpsertMerchantCustomAttributesRequest(body).execute();
    }

    /**
     * Creates or updates [custom attributes]($m/CustomAttribute) for a merchant as a bulk
     * operation. Use this endpoint to set the value of one or more custom attributes for a
     * merchant. A custom attribute is based on a custom attribute definition in a Square seller
     * account, which is created using the
     * [CreateMerchantCustomAttributeDefinition]($e/MerchantCustomAttributes/CreateMerchantCustomAttributeDefinition)
     * endpoint. This `BulkUpsertMerchantCustomAttributes` endpoint accepts a map of 1 to 25
     * individual upsert requests and returns a map of individual upsert responses. Each upsert
     * request has a unique ID and provides a merchant ID and custom attribute. Each upsert response
     * is returned with the ID of the corresponding request. To create or update a custom attribute
     * owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertMerchantCustomAttributesResponse response from the API call
     */
    public CompletableFuture<BulkUpsertMerchantCustomAttributesResponse> bulkUpsertMerchantCustomAttributesAsync(
            final BulkUpsertMerchantCustomAttributesRequest body) {
        try { 
            return prepareBulkUpsertMerchantCustomAttributesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkUpsertMerchantCustomAttributes.
     */
    private ApiCall<BulkUpsertMerchantCustomAttributesResponse, ApiException> prepareBulkUpsertMerchantCustomAttributesRequest(
            final BulkUpsertMerchantCustomAttributesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkUpsertMerchantCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/custom-attributes/bulk-upsert")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkUpsertMerchantCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Lists the [custom attributes]($m/CustomAttribute) associated with a merchant. You can use the
     * `with_definitions` query parameter to also retrieve custom attribute definitions in the same
     * call. When all response pages are retrieved, the results include all custom attributes that
     * are visible to the requesting application, including those that are owned by other
     * applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  merchantId  Required parameter: The ID of the target [merchant](entity:Merchant).
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
     * @return    Returns the ListMerchantCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListMerchantCustomAttributesResponse listMerchantCustomAttributes(
            final String merchantId,
            final String visibilityFilter,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws ApiException, IOException {
        return prepareListMerchantCustomAttributesRequest(merchantId, visibilityFilter, limit,
                cursor, withDefinitions).execute();
    }

    /**
     * Lists the [custom attributes]($m/CustomAttribute) associated with a merchant. You can use the
     * `with_definitions` query parameter to also retrieve custom attribute definitions in the same
     * call. When all response pages are retrieved, the results include all custom attributes that
     * are visible to the requesting application, including those that are owned by other
     * applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  merchantId  Required parameter: The ID of the target [merchant](entity:Merchant).
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
     * @return    Returns the ListMerchantCustomAttributesResponse response from the API call
     */
    public CompletableFuture<ListMerchantCustomAttributesResponse> listMerchantCustomAttributesAsync(
            final String merchantId,
            final String visibilityFilter,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) {
        try { 
            return prepareListMerchantCustomAttributesRequest(merchantId, visibilityFilter, limit, cursor,
            withDefinitions).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listMerchantCustomAttributes.
     */
    private ApiCall<ListMerchantCustomAttributesResponse, ApiException> prepareListMerchantCustomAttributesRequest(
            final String merchantId,
            final String visibilityFilter,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws IOException {
        return new ApiCall.Builder<ListMerchantCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/{merchant_id}/custom-attributes")
                        .queryParam(param -> param.key("visibility_filter")
                                .value(visibilityFilter).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("with_definitions")
                                .value((withDefinitions != null) ? withDefinitions : false).isRequired(false))
                        .templateParam(param -> param.key("merchant_id").value(merchantId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListMerchantCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a [custom attribute]($m/CustomAttribute) associated with a merchant. To delete a
     * custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  merchantId  Required parameter: The ID of the target [merchant](entity:Merchant).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteMerchantCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteMerchantCustomAttributeResponse deleteMerchantCustomAttribute(
            final String merchantId,
            final String key) throws ApiException, IOException {
        return prepareDeleteMerchantCustomAttributeRequest(merchantId, key).execute();
    }

    /**
     * Deletes a [custom attribute]($m/CustomAttribute) associated with a merchant. To delete a
     * custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  merchantId  Required parameter: The ID of the target [merchant](entity:Merchant).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteMerchantCustomAttributeResponse response from the API call
     */
    public CompletableFuture<DeleteMerchantCustomAttributeResponse> deleteMerchantCustomAttributeAsync(
            final String merchantId,
            final String key) {
        try { 
            return prepareDeleteMerchantCustomAttributeRequest(merchantId, key).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteMerchantCustomAttribute.
     */
    private ApiCall<DeleteMerchantCustomAttributeResponse, ApiException> prepareDeleteMerchantCustomAttributeRequest(
            final String merchantId,
            final String key) throws IOException {
        return new ApiCall.Builder<DeleteMerchantCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/{merchant_id}/custom-attributes/{key}")
                        .templateParam(param -> param.key("merchant_id").value(merchantId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteMerchantCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a [custom attribute]($m/CustomAttribute) associated with a merchant. You can use
     * the `with_definition` query parameter to also retrieve the custom attribute definition in the
     * same call. To retrieve a custom attribute owned by another application, the `visibility`
     * setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  merchantId  Required parameter: The ID of the target [merchant](entity:Merchant).
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
     * @return    Returns the RetrieveMerchantCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveMerchantCustomAttributeResponse retrieveMerchantCustomAttribute(
            final String merchantId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws ApiException, IOException {
        return prepareRetrieveMerchantCustomAttributeRequest(merchantId, key, withDefinition,
                version).execute();
    }

    /**
     * Retrieves a [custom attribute]($m/CustomAttribute) associated with a merchant. You can use
     * the `with_definition` query parameter to also retrieve the custom attribute definition in the
     * same call. To retrieve a custom attribute owned by another application, the `visibility`
     * setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @param  merchantId  Required parameter: The ID of the target [merchant](entity:Merchant).
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
     * @return    Returns the RetrieveMerchantCustomAttributeResponse response from the API call
     */
    public CompletableFuture<RetrieveMerchantCustomAttributeResponse> retrieveMerchantCustomAttributeAsync(
            final String merchantId,
            final String key,
            final Boolean withDefinition,
            final Integer version) {
        try { 
            return prepareRetrieveMerchantCustomAttributeRequest(merchantId, key, withDefinition,
            version).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveMerchantCustomAttribute.
     */
    private ApiCall<RetrieveMerchantCustomAttributeResponse, ApiException> prepareRetrieveMerchantCustomAttributeRequest(
            final String merchantId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws IOException {
        return new ApiCall.Builder<RetrieveMerchantCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/{merchant_id}/custom-attributes/{key}")
                        .queryParam(param -> param.key("with_definition")
                                .value((withDefinition != null) ? withDefinition : false).isRequired(false))
                        .queryParam(param -> param.key("version")
                                .value(version).isRequired(false))
                        .templateParam(param -> param.key("merchant_id").value(merchantId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveMerchantCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates or updates a [custom attribute]($m/CustomAttribute) for a merchant. Use this endpoint
     * to set the value of a custom attribute for a specified merchant. A custom attribute is based
     * on a custom attribute definition in a Square seller account, which is created using the
     * [CreateMerchantCustomAttributeDefinition]($e/MerchantCustomAttributes/CreateMerchantCustomAttributeDefinition)
     * endpoint. To create or update a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`.
     * @param  merchantId  Required parameter: The ID of the target [merchant](entity:Merchant).
     * @param  key  Required parameter: The key of the custom attribute to create or update. This
     *         key must match the `key` of a custom attribute definition in the Square seller
     *         account. If the requesting application is not the definition owner, you must use the
     *         qualified key.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertMerchantCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpsertMerchantCustomAttributeResponse upsertMerchantCustomAttribute(
            final String merchantId,
            final String key,
            final UpsertMerchantCustomAttributeRequest body) throws ApiException, IOException {
        return prepareUpsertMerchantCustomAttributeRequest(merchantId, key, body).execute();
    }

    /**
     * Creates or updates a [custom attribute]($m/CustomAttribute) for a merchant. Use this endpoint
     * to set the value of a custom attribute for a specified merchant. A custom attribute is based
     * on a custom attribute definition in a Square seller account, which is created using the
     * [CreateMerchantCustomAttributeDefinition]($e/MerchantCustomAttributes/CreateMerchantCustomAttributeDefinition)
     * endpoint. To create or update a custom attribute owned by another application, the
     * `visibility` setting must be `VISIBILITY_READ_WRITE_VALUES`.
     * @param  merchantId  Required parameter: The ID of the target [merchant](entity:Merchant).
     * @param  key  Required parameter: The key of the custom attribute to create or update. This
     *         key must match the `key` of a custom attribute definition in the Square seller
     *         account. If the requesting application is not the definition owner, you must use the
     *         qualified key.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertMerchantCustomAttributeResponse response from the API call
     */
    public CompletableFuture<UpsertMerchantCustomAttributeResponse> upsertMerchantCustomAttributeAsync(
            final String merchantId,
            final String key,
            final UpsertMerchantCustomAttributeRequest body) {
        try { 
            return prepareUpsertMerchantCustomAttributeRequest(merchantId, key, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for upsertMerchantCustomAttribute.
     */
    private ApiCall<UpsertMerchantCustomAttributeResponse, ApiException> prepareUpsertMerchantCustomAttributeRequest(
            final String merchantId,
            final String key,
            final UpsertMerchantCustomAttributeRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpsertMerchantCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/merchants/{merchant_id}/custom-attributes/{key}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("merchant_id").value(merchantId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpsertMerchantCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}