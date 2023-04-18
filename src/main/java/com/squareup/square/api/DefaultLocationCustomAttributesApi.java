
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.BulkDeleteLocationCustomAttributesRequest;
import com.squareup.square.models.BulkDeleteLocationCustomAttributesResponse;
import com.squareup.square.models.BulkUpsertLocationCustomAttributesRequest;
import com.squareup.square.models.BulkUpsertLocationCustomAttributesResponse;
import com.squareup.square.models.CreateLocationCustomAttributeDefinitionRequest;
import com.squareup.square.models.CreateLocationCustomAttributeDefinitionResponse;
import com.squareup.square.models.DeleteLocationCustomAttributeDefinitionResponse;
import com.squareup.square.models.DeleteLocationCustomAttributeResponse;
import com.squareup.square.models.ListLocationCustomAttributeDefinitionsResponse;
import com.squareup.square.models.ListLocationCustomAttributesResponse;
import com.squareup.square.models.RetrieveLocationCustomAttributeDefinitionResponse;
import com.squareup.square.models.RetrieveLocationCustomAttributeResponse;
import com.squareup.square.models.UpdateLocationCustomAttributeDefinitionRequest;
import com.squareup.square.models.UpdateLocationCustomAttributeDefinitionResponse;
import com.squareup.square.models.UpsertLocationCustomAttributeRequest;
import com.squareup.square.models.UpsertLocationCustomAttributeResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultLocationCustomAttributesApi extends BaseApi implements LocationCustomAttributesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultLocationCustomAttributesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

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
    public ListLocationCustomAttributeDefinitionsResponse listLocationCustomAttributeDefinitions(
            final String visibilityFilter,
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        return prepareListLocationCustomAttributeDefinitionsRequest(visibilityFilter, limit,
                cursor).execute();
    }

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
    public CompletableFuture<ListLocationCustomAttributeDefinitionsResponse> listLocationCustomAttributeDefinitionsAsync(
            final String visibilityFilter,
            final Integer limit,
            final String cursor) {
        try { 
            return prepareListLocationCustomAttributeDefinitionsRequest(visibilityFilter, limit,
            cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listLocationCustomAttributeDefinitions.
     */
    private ApiCall<ListLocationCustomAttributeDefinitionsResponse, ApiException> prepareListLocationCustomAttributeDefinitionsRequest(
            final String visibilityFilter,
            final Integer limit,
            final String cursor) throws IOException {
        return new ApiCall.Builder<ListLocationCustomAttributeDefinitionsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/custom-attribute-definitions")
                        .queryParam(param -> param.key("visibility_filter")
                                .value(visibilityFilter).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListLocationCustomAttributeDefinitionsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public CreateLocationCustomAttributeDefinitionResponse createLocationCustomAttributeDefinition(
            final CreateLocationCustomAttributeDefinitionRequest body) throws ApiException, IOException {
        return prepareCreateLocationCustomAttributeDefinitionRequest(body).execute();
    }

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
    public CompletableFuture<CreateLocationCustomAttributeDefinitionResponse> createLocationCustomAttributeDefinitionAsync(
            final CreateLocationCustomAttributeDefinitionRequest body) {
        try { 
            return prepareCreateLocationCustomAttributeDefinitionRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createLocationCustomAttributeDefinition.
     */
    private ApiCall<CreateLocationCustomAttributeDefinitionResponse, ApiException> prepareCreateLocationCustomAttributeDefinitionRequest(
            final CreateLocationCustomAttributeDefinitionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateLocationCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/custom-attribute-definitions")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateLocationCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public DeleteLocationCustomAttributeDefinitionResponse deleteLocationCustomAttributeDefinition(
            final String key) throws ApiException, IOException {
        return prepareDeleteLocationCustomAttributeDefinitionRequest(key).execute();
    }

    /**
     * Deletes a location-related [custom attribute definition]($m/CustomAttributeDefinition) from a
     * Square seller account. Deleting a custom attribute definition also deletes the corresponding
     * custom attribute from all locations. Only the definition owner can delete a custom attribute
     * definition.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteLocationCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<DeleteLocationCustomAttributeDefinitionResponse> deleteLocationCustomAttributeDefinitionAsync(
            final String key) {
        try { 
            return prepareDeleteLocationCustomAttributeDefinitionRequest(key).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteLocationCustomAttributeDefinition.
     */
    private ApiCall<DeleteLocationCustomAttributeDefinitionResponse, ApiException> prepareDeleteLocationCustomAttributeDefinitionRequest(
            final String key) throws IOException {
        return new ApiCall.Builder<DeleteLocationCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/custom-attribute-definitions/{key}")
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteLocationCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public RetrieveLocationCustomAttributeDefinitionResponse retrieveLocationCustomAttributeDefinition(
            final String key,
            final Integer version) throws ApiException, IOException {
        return prepareRetrieveLocationCustomAttributeDefinitionRequest(key, version).execute();
    }

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
    public CompletableFuture<RetrieveLocationCustomAttributeDefinitionResponse> retrieveLocationCustomAttributeDefinitionAsync(
            final String key,
            final Integer version) {
        try { 
            return prepareRetrieveLocationCustomAttributeDefinitionRequest(key, version).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveLocationCustomAttributeDefinition.
     */
    private ApiCall<RetrieveLocationCustomAttributeDefinitionResponse, ApiException> prepareRetrieveLocationCustomAttributeDefinitionRequest(
            final String key,
            final Integer version) throws IOException {
        return new ApiCall.Builder<RetrieveLocationCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/custom-attribute-definitions/{key}")
                        .queryParam(param -> param.key("version")
                                .value(version).isRequired(false))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveLocationCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public UpdateLocationCustomAttributeDefinitionResponse updateLocationCustomAttributeDefinition(
            final String key,
            final UpdateLocationCustomAttributeDefinitionRequest body) throws ApiException, IOException {
        return prepareUpdateLocationCustomAttributeDefinitionRequest(key, body).execute();
    }

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
    public CompletableFuture<UpdateLocationCustomAttributeDefinitionResponse> updateLocationCustomAttributeDefinitionAsync(
            final String key,
            final UpdateLocationCustomAttributeDefinitionRequest body) {
        try { 
            return prepareUpdateLocationCustomAttributeDefinitionRequest(key, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateLocationCustomAttributeDefinition.
     */
    private ApiCall<UpdateLocationCustomAttributeDefinitionResponse, ApiException> prepareUpdateLocationCustomAttributeDefinitionRequest(
            final String key,
            final UpdateLocationCustomAttributeDefinitionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateLocationCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/custom-attribute-definitions/{key}")
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
                                response -> ApiHelper.deserialize(response, UpdateLocationCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public BulkDeleteLocationCustomAttributesResponse bulkDeleteLocationCustomAttributes(
            final BulkDeleteLocationCustomAttributesRequest body) throws ApiException, IOException {
        return prepareBulkDeleteLocationCustomAttributesRequest(body).execute();
    }

    /**
     * Deletes [custom attributes]($m/CustomAttribute) for locations as a bulk operation. To delete
     * a custom attribute owned by another application, the `visibility` setting must be
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteLocationCustomAttributesResponse response from the API call
     */
    public CompletableFuture<BulkDeleteLocationCustomAttributesResponse> bulkDeleteLocationCustomAttributesAsync(
            final BulkDeleteLocationCustomAttributesRequest body) {
        try { 
            return prepareBulkDeleteLocationCustomAttributesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkDeleteLocationCustomAttributes.
     */
    private ApiCall<BulkDeleteLocationCustomAttributesResponse, ApiException> prepareBulkDeleteLocationCustomAttributesRequest(
            final BulkDeleteLocationCustomAttributesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkDeleteLocationCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/custom-attributes/bulk-delete")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkDeleteLocationCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public BulkUpsertLocationCustomAttributesResponse bulkUpsertLocationCustomAttributes(
            final BulkUpsertLocationCustomAttributesRequest body) throws ApiException, IOException {
        return prepareBulkUpsertLocationCustomAttributesRequest(body).execute();
    }

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
    public CompletableFuture<BulkUpsertLocationCustomAttributesResponse> bulkUpsertLocationCustomAttributesAsync(
            final BulkUpsertLocationCustomAttributesRequest body) {
        try { 
            return prepareBulkUpsertLocationCustomAttributesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkUpsertLocationCustomAttributes.
     */
    private ApiCall<BulkUpsertLocationCustomAttributesResponse, ApiException> prepareBulkUpsertLocationCustomAttributesRequest(
            final BulkUpsertLocationCustomAttributesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkUpsertLocationCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/custom-attributes/bulk-upsert")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkUpsertLocationCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public ListLocationCustomAttributesResponse listLocationCustomAttributes(
            final String locationId,
            final String visibilityFilter,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws ApiException, IOException {
        return prepareListLocationCustomAttributesRequest(locationId, visibilityFilter, limit,
                cursor, withDefinitions).execute();
    }

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
    public CompletableFuture<ListLocationCustomAttributesResponse> listLocationCustomAttributesAsync(
            final String locationId,
            final String visibilityFilter,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) {
        try { 
            return prepareListLocationCustomAttributesRequest(locationId, visibilityFilter, limit, cursor,
            withDefinitions).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listLocationCustomAttributes.
     */
    private ApiCall<ListLocationCustomAttributesResponse, ApiException> prepareListLocationCustomAttributesRequest(
            final String locationId,
            final String visibilityFilter,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws IOException {
        return new ApiCall.Builder<ListLocationCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}/custom-attributes")
                        .queryParam(param -> param.key("visibility_filter")
                                .value(visibilityFilter).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("with_definitions")
                                .value((withDefinitions != null) ? withDefinitions : false).isRequired(false))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListLocationCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public DeleteLocationCustomAttributeResponse deleteLocationCustomAttribute(
            final String locationId,
            final String key) throws ApiException, IOException {
        return prepareDeleteLocationCustomAttributeRequest(locationId, key).execute();
    }

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
    public CompletableFuture<DeleteLocationCustomAttributeResponse> deleteLocationCustomAttributeAsync(
            final String locationId,
            final String key) {
        try { 
            return prepareDeleteLocationCustomAttributeRequest(locationId, key).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteLocationCustomAttribute.
     */
    private ApiCall<DeleteLocationCustomAttributeResponse, ApiException> prepareDeleteLocationCustomAttributeRequest(
            final String locationId,
            final String key) throws IOException {
        return new ApiCall.Builder<DeleteLocationCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}/custom-attributes/{key}")
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteLocationCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public RetrieveLocationCustomAttributeResponse retrieveLocationCustomAttribute(
            final String locationId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws ApiException, IOException {
        return prepareRetrieveLocationCustomAttributeRequest(locationId, key, withDefinition,
                version).execute();
    }

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
    public CompletableFuture<RetrieveLocationCustomAttributeResponse> retrieveLocationCustomAttributeAsync(
            final String locationId,
            final String key,
            final Boolean withDefinition,
            final Integer version) {
        try { 
            return prepareRetrieveLocationCustomAttributeRequest(locationId, key, withDefinition,
            version).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveLocationCustomAttribute.
     */
    private ApiCall<RetrieveLocationCustomAttributeResponse, ApiException> prepareRetrieveLocationCustomAttributeRequest(
            final String locationId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws IOException {
        return new ApiCall.Builder<RetrieveLocationCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}/custom-attributes/{key}")
                        .queryParam(param -> param.key("with_definition")
                                .value((withDefinition != null) ? withDefinition : false).isRequired(false))
                        .queryParam(param -> param.key("version")
                                .value(version).isRequired(false))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveLocationCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public UpsertLocationCustomAttributeResponse upsertLocationCustomAttribute(
            final String locationId,
            final String key,
            final UpsertLocationCustomAttributeRequest body) throws ApiException, IOException {
        return prepareUpsertLocationCustomAttributeRequest(locationId, key, body).execute();
    }

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
    public CompletableFuture<UpsertLocationCustomAttributeResponse> upsertLocationCustomAttributeAsync(
            final String locationId,
            final String key,
            final UpsertLocationCustomAttributeRequest body) {
        try { 
            return prepareUpsertLocationCustomAttributeRequest(locationId, key, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for upsertLocationCustomAttribute.
     */
    private ApiCall<UpsertLocationCustomAttributeResponse, ApiException> prepareUpsertLocationCustomAttributeRequest(
            final String locationId,
            final String key,
            final UpsertLocationCustomAttributeRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpsertLocationCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}/custom-attributes/{key}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("location_id").value(locationId)
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
                                response -> ApiHelper.deserialize(response, UpsertLocationCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}