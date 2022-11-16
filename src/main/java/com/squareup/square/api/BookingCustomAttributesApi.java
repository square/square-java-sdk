
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
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
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface BookingCustomAttributesApi {
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
    ListBookingCustomAttributeDefinitionsResponse listBookingCustomAttributeDefinitions(
            final Integer limit,
            final String cursor) throws ApiException, IOException;

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
    CompletableFuture<ListBookingCustomAttributeDefinitionsResponse> listBookingCustomAttributeDefinitionsAsync(
            final Integer limit,
            final String cursor);

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
    CreateBookingCustomAttributeDefinitionResponse createBookingCustomAttributeDefinition(
            final CreateBookingCustomAttributeDefinitionRequest body) throws ApiException, IOException;

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
    CompletableFuture<CreateBookingCustomAttributeDefinitionResponse> createBookingCustomAttributeDefinitionAsync(
            final CreateBookingCustomAttributeDefinitionRequest body);

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
    DeleteBookingCustomAttributeDefinitionResponse deleteBookingCustomAttributeDefinition(
            final String key) throws ApiException, IOException;

    /**
     * Deletes a bookings custom attribute definition. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth
     * scope. For calls to this endpoint with seller-level permissions to succeed, the seller must
     * have subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  key  Required parameter: The key of the custom attribute definition to delete.
     * @return    Returns the DeleteBookingCustomAttributeDefinitionResponse response from the API call
     */
    CompletableFuture<DeleteBookingCustomAttributeDefinitionResponse> deleteBookingCustomAttributeDefinitionAsync(
            final String key);

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
    RetrieveBookingCustomAttributeDefinitionResponse retrieveBookingCustomAttributeDefinition(
            final String key,
            final Integer version) throws ApiException, IOException;

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
    CompletableFuture<RetrieveBookingCustomAttributeDefinitionResponse> retrieveBookingCustomAttributeDefinitionAsync(
            final String key,
            final Integer version);

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
    UpdateBookingCustomAttributeDefinitionResponse updateBookingCustomAttributeDefinition(
            final String key,
            final UpdateBookingCustomAttributeDefinitionRequest body) throws ApiException, IOException;

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
    CompletableFuture<UpdateBookingCustomAttributeDefinitionResponse> updateBookingCustomAttributeDefinitionAsync(
            final String key,
            final UpdateBookingCustomAttributeDefinitionRequest body);

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
    BulkDeleteBookingCustomAttributesResponse bulkDeleteBookingCustomAttributes(
            final BulkDeleteBookingCustomAttributesRequest body) throws ApiException, IOException;

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
    CompletableFuture<BulkDeleteBookingCustomAttributesResponse> bulkDeleteBookingCustomAttributesAsync(
            final BulkDeleteBookingCustomAttributesRequest body);

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
    BulkUpsertBookingCustomAttributesResponse bulkUpsertBookingCustomAttributes(
            final BulkUpsertBookingCustomAttributesRequest body) throws ApiException, IOException;

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
    CompletableFuture<BulkUpsertBookingCustomAttributesResponse> bulkUpsertBookingCustomAttributesAsync(
            final BulkUpsertBookingCustomAttributesRequest body);

    /**
     * Lists a booking's custom attributes. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level permissions,
     * set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the target [booking]($m/Booking).
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
     * @return    Returns the ListBookingCustomAttributesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListBookingCustomAttributesResponse listBookingCustomAttributes(
            final String bookingId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions) throws ApiException, IOException;

    /**
     * Lists a booking's custom attributes. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level permissions,
     * set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the target [booking]($m/Booking).
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
     * @return    Returns the ListBookingCustomAttributesResponse response from the API call
     */
    CompletableFuture<ListBookingCustomAttributesResponse> listBookingCustomAttributesAsync(
            final String bookingId,
            final Integer limit,
            final String cursor,
            final Boolean withDefinitions);

    /**
     * Deletes a bookings custom attribute. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the target [booking]($m/Booking).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteBookingCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteBookingCustomAttributeResponse deleteBookingCustomAttribute(
            final String bookingId,
            final String key) throws ApiException, IOException;

    /**
     * Deletes a bookings custom attribute. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the target [booking]($m/Booking).
     * @param  key  Required parameter: The key of the custom attribute to delete. This key must
     *         match the `key` of a custom attribute definition in the Square seller account. If the
     *         requesting application is not the definition owner, you must use the qualified key.
     * @return    Returns the DeleteBookingCustomAttributeResponse response from the API call
     */
    CompletableFuture<DeleteBookingCustomAttributeResponse> deleteBookingCustomAttributeAsync(
            final String bookingId,
            final String key);

    /**
     * Retrieves a bookings custom attribute. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the target [booking]($m/Booking).
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
     * @return    Returns the RetrieveBookingCustomAttributeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveBookingCustomAttributeResponse retrieveBookingCustomAttribute(
            final String bookingId,
            final String key,
            final Boolean withDefinition,
            final Integer version) throws ApiException, IOException;

    /**
     * Retrieves a bookings custom attribute. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the target [booking]($m/Booking).
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
     * @return    Returns the RetrieveBookingCustomAttributeResponse response from the API call
     */
    CompletableFuture<RetrieveBookingCustomAttributeResponse> retrieveBookingCustomAttributeAsync(
            final String bookingId,
            final String key,
            final Boolean withDefinition,
            final Integer version);

    /**
     * Upserts a bookings custom attribute. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the target [booking]($m/Booking).
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
    UpsertBookingCustomAttributeResponse upsertBookingCustomAttribute(
            final String bookingId,
            final String key,
            final UpsertBookingCustomAttributeRequest body) throws ApiException, IOException;

    /**
     * Upserts a bookings custom attribute. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the target [booking]($m/Booking).
     * @param  key  Required parameter: The key of the custom attribute to create or update. This
     *         key must match the `key` of a custom attribute definition in the Square seller
     *         account. If the requesting application is not the definition owner, you must use the
     *         qualified key.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertBookingCustomAttributeResponse response from the API call
     */
    CompletableFuture<UpsertBookingCustomAttributeResponse> upsertBookingCustomAttributeAsync(
            final String bookingId,
            final String key,
            final UpsertBookingCustomAttributeRequest body);

}