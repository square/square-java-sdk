
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.BulkDeleteBookingCustomAttributesRequest;
import com.squareup.square.models.BulkDeleteBookingCustomAttributesResponse;
import com.squareup.square.models.BulkUpsertBookingCustomAttributesRequest;
import com.squareup.square.models.BulkUpsertBookingCustomAttributesResponse;
import com.squareup.square.models.CreateBookingCustomAttributeDefinitionRequest;
import com.squareup.square.models.CreateBookingCustomAttributeDefinitionResponse;
import com.squareup.square.models.DeleteBookingCustomAttributeDefinitionResponse;
import com.squareup.square.models.DeleteBookingCustomAttributeResponse;
import com.squareup.square.models.ListBookingCustomAttributeDefinitionsResponse;
import com.squareup.square.models.ListBookingCustomAttributesResponse;
import com.squareup.square.models.RetrieveBookingCustomAttributeDefinitionResponse;
import com.squareup.square.models.RetrieveBookingCustomAttributeResponse;
import com.squareup.square.models.UpdateBookingCustomAttributeDefinitionRequest;
import com.squareup.square.models.UpdateBookingCustomAttributeDefinitionResponse;
import com.squareup.square.models.UpsertBookingCustomAttributeRequest;
import com.squareup.square.models.UpsertBookingCustomAttributeResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultBookingCustomAttributesApi extends BaseApi implements BookingCustomAttributesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultBookingCustomAttributesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Get all bookings custom attribute definitions. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth
     * scope.
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListBookingCustomAttributeDefinitionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListBookingCustomAttributeDefinitionsResponse listBookingCustomAttributeDefinitions(
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        return prepareListBookingCustomAttributeDefinitionsRequest(limit, cursor).execute();
    }

    /**
     * Get all bookings custom attribute definitions. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth
     * scope.
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. This limit is advisory. The response might contain more or fewer results.
     *         The minimum value is 1 and the maximum value is 100. The default value is 20. For
     *         more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListBookingCustomAttributeDefinitionsResponse response from the API call
     */
    public CompletableFuture<ListBookingCustomAttributeDefinitionsResponse> listBookingCustomAttributeDefinitionsAsync(
            final Integer limit,
            final String cursor) {
        try { 
            return prepareListBookingCustomAttributeDefinitionsRequest(limit, cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listBookingCustomAttributeDefinitions.
     */
    private ApiCall<ListBookingCustomAttributeDefinitionsResponse, ApiException> prepareListBookingCustomAttributeDefinitionsRequest(
            final Integer limit,
            final String cursor) throws IOException {
        return new ApiCall.Builder<ListBookingCustomAttributeDefinitionsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/custom-attribute-definitions")
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
                                response -> ApiHelper.deserialize(response, ListBookingCustomAttributeDefinitionsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a bookings custom attribute definition. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth
     * scope. For calls to this endpoint with seller-level permissions to succeed, the seller must
     * have subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBookingCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateBookingCustomAttributeDefinitionResponse createBookingCustomAttributeDefinition(
            final CreateBookingCustomAttributeDefinitionRequest body) throws ApiException, IOException {
        return prepareCreateBookingCustomAttributeDefinitionRequest(body).execute();
    }

    /**
     * Creates a bookings custom attribute definition. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth
     * scope. For calls to this endpoint with seller-level permissions to succeed, the seller must
     * have subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBookingCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<CreateBookingCustomAttributeDefinitionResponse> createBookingCustomAttributeDefinitionAsync(
            final CreateBookingCustomAttributeDefinitionRequest body) {
        try { 
            return prepareCreateBookingCustomAttributeDefinitionRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createBookingCustomAttributeDefinition.
     */
    private ApiCall<CreateBookingCustomAttributeDefinitionResponse, ApiException> prepareCreateBookingCustomAttributeDefinitionRequest(
            final CreateBookingCustomAttributeDefinitionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateBookingCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/custom-attribute-definitions")
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
                                response -> ApiHelper.deserialize(response, CreateBookingCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a bookings custom attribute definition. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth
     * scope. For calls to this endpoint with seller-level permissions to succeed, the seller must
     * have subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteBookingCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteBookingCustomAttributeDefinitionResponse deleteBookingCustomAttributeDefinition(
            final String key) throws ApiException, IOException {
        return prepareDeleteBookingCustomAttributeDefinitionRequest(key).execute();
    }

    /**
     * Deletes a bookings custom attribute definition. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth
     * scope. For calls to this endpoint with seller-level permissions to succeed, the seller must
     * have subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteBookingCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<DeleteBookingCustomAttributeDefinitionResponse> deleteBookingCustomAttributeDefinitionAsync(
            final String key) {
        try { 
            return prepareDeleteBookingCustomAttributeDefinitionRequest(key).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteBookingCustomAttributeDefinition.
     */
    private ApiCall<DeleteBookingCustomAttributeDefinitionResponse, ApiException> prepareDeleteBookingCustomAttributeDefinitionRequest(
            final String key) throws IOException {
        return new ApiCall.Builder<DeleteBookingCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/custom-attribute-definitions/{key}")
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteBookingCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a bookings custom attribute definition. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth
     * scope.
     * @param  key  Required parameter: The key of the custom attribute definition to retrieve. If
     *         the requesting application is not the definition owner, you must use the qualified
     *         key.
     * @param  version  Optional parameter: The current version of the custom attribute definition,
     *         which is used for strongly consistent reads to guarantee that you receive the most
     *         up-to-date data. When included in the request, Square returns the specified version
     *         or a higher version if one exists. If the specified version is higher than the
     *         current version, Square returns a `BAD_REQUEST` error.
     * @return    Returns the RetrieveBookingCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveBookingCustomAttributeDefinitionResponse retrieveBookingCustomAttributeDefinition(
            final String key,
            final Integer version) throws ApiException, IOException {
        return prepareRetrieveBookingCustomAttributeDefinitionRequest(key, version).execute();
    }

    /**
     * Retrieves a bookings custom attribute definition. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth
     * scope.
     * @param  key  Required parameter: The key of the custom attribute definition to retrieve. If
     *         the requesting application is not the definition owner, you must use the qualified
     *         key.
     * @param  version  Optional parameter: The current version of the custom attribute definition,
     *         which is used for strongly consistent reads to guarantee that you receive the most
     *         up-to-date data. When included in the request, Square returns the specified version
     *         or a higher version if one exists. If the specified version is higher than the
     *         current version, Square returns a `BAD_REQUEST` error.
     * @return    Returns the RetrieveBookingCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<RetrieveBookingCustomAttributeDefinitionResponse> retrieveBookingCustomAttributeDefinitionAsync(
            final String key,
            final Integer version) {
        try { 
            return prepareRetrieveBookingCustomAttributeDefinitionRequest(key, version).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveBookingCustomAttributeDefinition.
     */
    private ApiCall<RetrieveBookingCustomAttributeDefinitionResponse, ApiException> prepareRetrieveBookingCustomAttributeDefinitionRequest(
            final String key,
            final Integer version) throws IOException {
        return new ApiCall.Builder<RetrieveBookingCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/custom-attribute-definitions/{key}")
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
                                response -> ApiHelper.deserialize(response, RetrieveBookingCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates a bookings custom attribute definition. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth
     * scope. For calls to this endpoint with seller-level permissions to succeed, the seller must
     * have subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBookingCustomAttributeDefinitionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateBookingCustomAttributeDefinitionResponse updateBookingCustomAttributeDefinition(
            final String key,
            final UpdateBookingCustomAttributeDefinitionRequest body) throws ApiException, IOException {
        return prepareUpdateBookingCustomAttributeDefinitionRequest(key, body).execute();
    }

    /**
     * Updates a bookings custom attribute definition. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth
     * scope. For calls to this endpoint with seller-level permissions to succeed, the seller must
     * have subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  key  Required parameter: The key of the custom attribute definition to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBookingCustomAttributeDefinitionResponse response from the API call
     */
    public CompletableFuture<UpdateBookingCustomAttributeDefinitionResponse> updateBookingCustomAttributeDefinitionAsync(
            final String key,
            final UpdateBookingCustomAttributeDefinitionRequest body) {
        try { 
            return prepareUpdateBookingCustomAttributeDefinitionRequest(key, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateBookingCustomAttributeDefinition.
     */
    private ApiCall<UpdateBookingCustomAttributeDefinitionResponse, ApiException> prepareUpdateBookingCustomAttributeDefinitionRequest(
            final String key,
            final UpdateBookingCustomAttributeDefinitionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateBookingCustomAttributeDefinitionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/custom-attribute-definitions/{key}")
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
                                response -> ApiHelper.deserialize(response, UpdateBookingCustomAttributeDefinitionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Bulk deletes bookings custom attributes. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteBookingCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkDeleteBookingCustomAttributesResponse bulkDeleteBookingCustomAttributes(
            final BulkDeleteBookingCustomAttributesRequest body) throws ApiException, IOException {
        return prepareBulkDeleteBookingCustomAttributesRequest(body).execute();
    }

    /**
     * Bulk deletes bookings custom attributes. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteBookingCustomAttributesResponse response from the API call
     */
    public CompletableFuture<BulkDeleteBookingCustomAttributesResponse> bulkDeleteBookingCustomAttributesAsync(
            final BulkDeleteBookingCustomAttributesRequest body) {
        try { 
            return prepareBulkDeleteBookingCustomAttributesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkDeleteBookingCustomAttributes.
     */
    private ApiCall<BulkDeleteBookingCustomAttributesResponse, ApiException> prepareBulkDeleteBookingCustomAttributesRequest(
            final BulkDeleteBookingCustomAttributesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkDeleteBookingCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/custom-attributes/bulk-delete")
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
                                response -> ApiHelper.deserialize(response, BulkDeleteBookingCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Bulk upserts bookings custom attributes. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertBookingCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkUpsertBookingCustomAttributesResponse bulkUpsertBookingCustomAttributes(
            final BulkUpsertBookingCustomAttributesRequest body) throws ApiException, IOException {
        return prepareBulkUpsertBookingCustomAttributesRequest(body).execute();
    }

    /**
     * Bulk upserts bookings custom attributes. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpsertBookingCustomAttributesResponse response from the API call
     */
    public CompletableFuture<BulkUpsertBookingCustomAttributesResponse> bulkUpsertBookingCustomAttributesAsync(
            final BulkUpsertBookingCustomAttributesRequest body) {
        try { 
            return prepareBulkUpsertBookingCustomAttributesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkUpsertBookingCustomAttributes.
     */
    private ApiCall<BulkUpsertBookingCustomAttributesResponse, ApiException> prepareBulkUpsertBookingCustomAttributesRequest(
            final BulkUpsertBookingCustomAttributesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkUpsertBookingCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/custom-attributes/bulk-upsert")
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
                                response -> ApiHelper.deserialize(response, BulkUpsertBookingCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Lists a booking's custom attributes. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level permissions,
     * set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the target [booking](entity:Booking).
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
     * @return    Returns the ListBookingCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListBookingCustomAttributesResponse listBookingCustomAttributes(
            final String bookingId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws ApiException, IOException {
        return prepareListBookingCustomAttributesRequest(bookingId, limit, cursor,
                withDefinitions).execute();
    }

    /**
     * Lists a booking's custom attributes. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level permissions,
     * set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the target [booking](entity:Booking).
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
     * @return    Returns the ListBookingCustomAttributesResponse response from the API call
     */
    public CompletableFuture<ListBookingCustomAttributesResponse> listBookingCustomAttributesAsync(
            final String bookingId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) {
        try { 
            return prepareListBookingCustomAttributesRequest(bookingId, limit, cursor,
            withDefinitions).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listBookingCustomAttributes.
     */
    private ApiCall<ListBookingCustomAttributesResponse, ApiException> prepareListBookingCustomAttributesRequest(
            final String bookingId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws IOException {
        return new ApiCall.Builder<ListBookingCustomAttributesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/{booking_id}/custom-attributes")
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("with_definitions")
                                .value((withDefinitions != null) ? withDefinitions : false).isRequired(false))
                        .templateParam(param -> param.key("booking_id").value(bookingId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListBookingCustomAttributesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a bookings custom attribute. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the target [booking](entity:Booking).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteBookingCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteBookingCustomAttributeResponse deleteBookingCustomAttribute(
            final String bookingId,
            final String key) throws ApiException, IOException {
        return prepareDeleteBookingCustomAttributeRequest(bookingId, key).execute();
    }

    /**
     * Deletes a bookings custom attribute. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the target [booking](entity:Booking).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteBookingCustomAttributeResponse response from the API call
     */
    public CompletableFuture<DeleteBookingCustomAttributeResponse> deleteBookingCustomAttributeAsync(
            final String bookingId,
            final String key) {
        try { 
            return prepareDeleteBookingCustomAttributeRequest(bookingId, key).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteBookingCustomAttribute.
     */
    private ApiCall<DeleteBookingCustomAttributeResponse, ApiException> prepareDeleteBookingCustomAttributeRequest(
            final String bookingId,
            final String key) throws IOException {
        return new ApiCall.Builder<DeleteBookingCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/{booking_id}/custom-attributes/{key}")
                        .templateParam(param -> param.key("booking_id").value(bookingId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteBookingCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a bookings custom attribute. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the target [booking](entity:Booking).
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
     * @return    Returns the RetrieveBookingCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveBookingCustomAttributeResponse retrieveBookingCustomAttribute(
            final String bookingId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws ApiException, IOException {
        return prepareRetrieveBookingCustomAttributeRequest(bookingId, key, withDefinition,
                version).execute();
    }

    /**
     * Retrieves a bookings custom attribute. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the target [booking](entity:Booking).
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
     * @return    Returns the RetrieveBookingCustomAttributeResponse response from the API call
     */
    public CompletableFuture<RetrieveBookingCustomAttributeResponse> retrieveBookingCustomAttributeAsync(
            final String bookingId,
            final String key,
            final Boolean withDefinition,
            final Integer version) {
        try { 
            return prepareRetrieveBookingCustomAttributeRequest(bookingId, key, withDefinition,
            version).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveBookingCustomAttribute.
     */
    private ApiCall<RetrieveBookingCustomAttributeResponse, ApiException> prepareRetrieveBookingCustomAttributeRequest(
            final String bookingId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws IOException {
        return new ApiCall.Builder<RetrieveBookingCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/{booking_id}/custom-attributes/{key}")
                        .queryParam(param -> param.key("with_definition")
                                .value((withDefinition != null) ? withDefinition : false).isRequired(false))
                        .queryParam(param -> param.key("version")
                                .value(version).isRequired(false))
                        .templateParam(param -> param.key("booking_id").value(bookingId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("key").value(key)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveBookingCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Upserts a bookings custom attribute. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the target [booking](entity:Booking).
     * @param  key  Required parameter: The key of the custom attribute to create or update. This
     *         key must match the `key` of a custom attribute definition in the Square seller
     *         account. If the requesting application is not the definition owner, you must use the
     *         qualified key.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertBookingCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpsertBookingCustomAttributeResponse upsertBookingCustomAttribute(
            final String bookingId,
            final String key,
            final UpsertBookingCustomAttributeRequest body) throws ApiException, IOException {
        return prepareUpsertBookingCustomAttributeRequest(bookingId, key, body).execute();
    }

    /**
     * Upserts a bookings custom attribute. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the target [booking](entity:Booking).
     * @param  key  Required parameter: The key of the custom attribute to create or update. This
     *         key must match the `key` of a custom attribute definition in the Square seller
     *         account. If the requesting application is not the definition owner, you must use the
     *         qualified key.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertBookingCustomAttributeResponse response from the API call
     */
    public CompletableFuture<UpsertBookingCustomAttributeResponse> upsertBookingCustomAttributeAsync(
            final String bookingId,
            final String key,
            final UpsertBookingCustomAttributeRequest body) {
        try { 
            return prepareUpsertBookingCustomAttributeRequest(bookingId, key, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for upsertBookingCustomAttribute.
     */
    private ApiCall<UpsertBookingCustomAttributeResponse, ApiException> prepareUpsertBookingCustomAttributeRequest(
            final String bookingId,
            final String key,
            final UpsertBookingCustomAttributeRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpsertBookingCustomAttributeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/{booking_id}/custom-attributes/{key}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("booking_id").value(bookingId)
                                .shouldEncode(true))
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
                                response -> ApiHelper.deserialize(response, UpsertBookingCustomAttributeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}