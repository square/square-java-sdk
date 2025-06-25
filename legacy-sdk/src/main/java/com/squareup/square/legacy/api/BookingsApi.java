package com.squareup.square.legacy.api;

import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.BulkRetrieveBookingsRequest;
import com.squareup.square.legacy.models.BulkRetrieveBookingsResponse;
import com.squareup.square.legacy.models.BulkRetrieveTeamMemberBookingProfilesRequest;
import com.squareup.square.legacy.models.BulkRetrieveTeamMemberBookingProfilesResponse;
import com.squareup.square.legacy.models.CancelBookingRequest;
import com.squareup.square.legacy.models.CancelBookingResponse;
import com.squareup.square.legacy.models.CreateBookingRequest;
import com.squareup.square.legacy.models.CreateBookingResponse;
import com.squareup.square.legacy.models.ListBookingsResponse;
import com.squareup.square.legacy.models.ListLocationBookingProfilesResponse;
import com.squareup.square.legacy.models.ListTeamMemberBookingProfilesResponse;
import com.squareup.square.legacy.models.RetrieveBookingResponse;
import com.squareup.square.legacy.models.RetrieveBusinessBookingProfileResponse;
import com.squareup.square.legacy.models.RetrieveLocationBookingProfileResponse;
import com.squareup.square.legacy.models.RetrieveTeamMemberBookingProfileResponse;
import com.squareup.square.legacy.models.SearchAvailabilityRequest;
import com.squareup.square.legacy.models.SearchAvailabilityResponse;
import com.squareup.square.legacy.models.UpdateBookingRequest;
import com.squareup.square.legacy.models.UpdateBookingResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface BookingsApi {
    /**
     * Retrieve a collection of bookings. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level permissions,
     * set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  limit  Optional parameter: The maximum number of results per page to return in a
     *         paged response.
     * @param  cursor  Optional parameter: The pagination cursor from the preceding response to
     *         return the next page of the results. Do not set this when retrieving the first page
     *         of the results.
     * @param  customerId  Optional parameter: The [customer](entity:Customer) for whom to retrieve
     *         bookings. If this is not set, bookings for all customers are retrieved.
     * @param  teamMemberId  Optional parameter: The team member for whom to retrieve bookings. If
     *         this is not set, bookings of all members are retrieved.
     * @param  locationId  Optional parameter: The location for which to retrieve bookings. If this
     *         is not set, all locations' bookings are retrieved.
     * @param  startAtMin  Optional parameter: The RFC 3339 timestamp specifying the earliest of the
     *         start time. If this is not set, the current time is used.
     * @param  startAtMax  Optional parameter: The RFC 3339 timestamp specifying the latest of the
     *         start time. If this is not set, the time of 31 days after `start_at_min` is used.
     * @return    Returns the ListBookingsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListBookingsResponse listBookings(
            final Integer limit,
            final String cursor,
            final String customerId,
            final String teamMemberId,
            final String locationId,
            final String startAtMin,
            final String startAtMax)
            throws ApiException, IOException;

    /**
     * Retrieve a collection of bookings. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level permissions,
     * set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  limit  Optional parameter: The maximum number of results per page to return in a
     *         paged response.
     * @param  cursor  Optional parameter: The pagination cursor from the preceding response to
     *         return the next page of the results. Do not set this when retrieving the first page
     *         of the results.
     * @param  customerId  Optional parameter: The [customer](entity:Customer) for whom to retrieve
     *         bookings. If this is not set, bookings for all customers are retrieved.
     * @param  teamMemberId  Optional parameter: The team member for whom to retrieve bookings. If
     *         this is not set, bookings of all members are retrieved.
     * @param  locationId  Optional parameter: The location for which to retrieve bookings. If this
     *         is not set, all locations' bookings are retrieved.
     * @param  startAtMin  Optional parameter: The RFC 3339 timestamp specifying the earliest of the
     *         start time. If this is not set, the current time is used.
     * @param  startAtMax  Optional parameter: The RFC 3339 timestamp specifying the latest of the
     *         start time. If this is not set, the time of 31 days after `start_at_min` is used.
     * @return    Returns the ListBookingsResponse response from the API call
     */
    CompletableFuture<ListBookingsResponse> listBookingsAsync(
            final Integer limit,
            final String cursor,
            final String customerId,
            final String teamMemberId,
            final String locationId,
            final String startAtMin,
            final String startAtMax);

    /**
     * Creates a booking. The required input must include the following: - `Booking.location_id` -
     * `Booking.start_at` - `Booking.AppointmentSegment.team_member_id` -
     * `Booking.AppointmentSegment.service_variation_id` -
     * `Booking.AppointmentSegment.service_variation_version` To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth
     * scope. For calls to this endpoint with seller-level permissions to succeed, the seller must
     * have subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBookingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateBookingResponse createBooking(final CreateBookingRequest body) throws ApiException, IOException;

    /**
     * Creates a booking. The required input must include the following: - `Booking.location_id` -
     * `Booking.start_at` - `Booking.AppointmentSegment.team_member_id` -
     * `Booking.AppointmentSegment.service_variation_id` -
     * `Booking.AppointmentSegment.service_variation_version` To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth
     * scope. For calls to this endpoint with seller-level permissions to succeed, the seller must
     * have subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBookingResponse response from the API call
     */
    CompletableFuture<CreateBookingResponse> createBookingAsync(final CreateBookingRequest body);

    /**
     * Searches for availabilities for booking. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchAvailabilityResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchAvailabilityResponse searchAvailability(final SearchAvailabilityRequest body)
            throws ApiException, IOException;

    /**
     * Searches for availabilities for booking. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchAvailabilityResponse response from the API call
     */
    CompletableFuture<SearchAvailabilityResponse> searchAvailabilityAsync(final SearchAvailabilityRequest body);

    /**
     * Bulk-Retrieves a list of bookings by booking IDs. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth
     * scope.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveBookingsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BulkRetrieveBookingsResponse bulkRetrieveBookings(final BulkRetrieveBookingsRequest body)
            throws ApiException, IOException;

    /**
     * Bulk-Retrieves a list of bookings by booking IDs. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth
     * scope.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveBookingsResponse response from the API call
     */
    CompletableFuture<BulkRetrieveBookingsResponse> bulkRetrieveBookingsAsync(final BulkRetrieveBookingsRequest body);

    /**
     * Retrieves a seller's booking profile.
     * @return    Returns the RetrieveBusinessBookingProfileResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveBusinessBookingProfileResponse retrieveBusinessBookingProfile() throws ApiException, IOException;

    /**
     * Retrieves a seller's booking profile.
     * @return    Returns the RetrieveBusinessBookingProfileResponse response from the API call
     */
    CompletableFuture<RetrieveBusinessBookingProfileResponse> retrieveBusinessBookingProfileAsync();

    /**
     * Lists location booking profiles of a seller.
     * @param  limit  Optional parameter: The maximum number of results to return in a paged
     *         response.
     * @param  cursor  Optional parameter: The pagination cursor from the preceding response to
     *         return the next page of the results. Do not set this when retrieving the first page
     *         of the results.
     * @return    Returns the ListLocationBookingProfilesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListLocationBookingProfilesResponse listLocationBookingProfiles(final Integer limit, final String cursor)
            throws ApiException, IOException;

    /**
     * Lists location booking profiles of a seller.
     * @param  limit  Optional parameter: The maximum number of results to return in a paged
     *         response.
     * @param  cursor  Optional parameter: The pagination cursor from the preceding response to
     *         return the next page of the results. Do not set this when retrieving the first page
     *         of the results.
     * @return    Returns the ListLocationBookingProfilesResponse response from the API call
     */
    CompletableFuture<ListLocationBookingProfilesResponse> listLocationBookingProfilesAsync(
            final Integer limit, final String cursor);

    /**
     * Retrieves a seller's location booking profile.
     * @param  locationId  Required parameter: The ID of the location to retrieve the booking
     *         profile.
     * @return    Returns the RetrieveLocationBookingProfileResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveLocationBookingProfileResponse retrieveLocationBookingProfile(final String locationId)
            throws ApiException, IOException;

    /**
     * Retrieves a seller's location booking profile.
     * @param  locationId  Required parameter: The ID of the location to retrieve the booking
     *         profile.
     * @return    Returns the RetrieveLocationBookingProfileResponse response from the API call
     */
    CompletableFuture<RetrieveLocationBookingProfileResponse> retrieveLocationBookingProfileAsync(
            final String locationId);

    /**
     * Lists booking profiles for team members.
     * @param  bookableOnly  Optional parameter: Indicates whether to include only bookable team
     *         members in the returned result (`true`) or not (`false`).
     * @param  limit  Optional parameter: The maximum number of results to return in a paged
     *         response.
     * @param  cursor  Optional parameter: The pagination cursor from the preceding response to
     *         return the next page of the results. Do not set this when retrieving the first page
     *         of the results.
     * @param  locationId  Optional parameter: Indicates whether to include only team members
     *         enabled at the given location in the returned result.
     * @return    Returns the ListTeamMemberBookingProfilesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListTeamMemberBookingProfilesResponse listTeamMemberBookingProfiles(
            final Boolean bookableOnly, final Integer limit, final String cursor, final String locationId)
            throws ApiException, IOException;

    /**
     * Lists booking profiles for team members.
     * @param  bookableOnly  Optional parameter: Indicates whether to include only bookable team
     *         members in the returned result (`true`) or not (`false`).
     * @param  limit  Optional parameter: The maximum number of results to return in a paged
     *         response.
     * @param  cursor  Optional parameter: The pagination cursor from the preceding response to
     *         return the next page of the results. Do not set this when retrieving the first page
     *         of the results.
     * @param  locationId  Optional parameter: Indicates whether to include only team members
     *         enabled at the given location in the returned result.
     * @return    Returns the ListTeamMemberBookingProfilesResponse response from the API call
     */
    CompletableFuture<ListTeamMemberBookingProfilesResponse> listTeamMemberBookingProfilesAsync(
            final Boolean bookableOnly, final Integer limit, final String cursor, final String locationId);

    /**
     * Retrieves one or more team members' booking profiles.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveTeamMemberBookingProfilesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BulkRetrieveTeamMemberBookingProfilesResponse bulkRetrieveTeamMemberBookingProfiles(
            final BulkRetrieveTeamMemberBookingProfilesRequest body) throws ApiException, IOException;

    /**
     * Retrieves one or more team members' booking profiles.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveTeamMemberBookingProfilesResponse response from the API call
     */
    CompletableFuture<BulkRetrieveTeamMemberBookingProfilesResponse> bulkRetrieveTeamMemberBookingProfilesAsync(
            final BulkRetrieveTeamMemberBookingProfilesRequest body);

    /**
     * Retrieves a team member's booking profile.
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberBookingProfileResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveTeamMemberBookingProfileResponse retrieveTeamMemberBookingProfile(final String teamMemberId)
            throws ApiException, IOException;

    /**
     * Retrieves a team member's booking profile.
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberBookingProfileResponse response from the API call
     */
    CompletableFuture<RetrieveTeamMemberBookingProfileResponse> retrieveTeamMemberBookingProfileAsync(
            final String teamMemberId);

    /**
     * Retrieves a booking. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level permissions,
     * set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the [Booking](entity:Booking) object
     *         representing the to-be-retrieved booking.
     * @return    Returns the RetrieveBookingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveBookingResponse retrieveBooking(final String bookingId) throws ApiException, IOException;

    /**
     * Retrieves a booking. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level permissions,
     * set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the [Booking](entity:Booking) object
     *         representing the to-be-retrieved booking.
     * @return    Returns the RetrieveBookingResponse response from the API call
     */
    CompletableFuture<RetrieveBookingResponse> retrieveBookingAsync(final String bookingId);

    /**
     * Updates a booking. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the [Booking](entity:Booking) object
     *         representing the to-be-updated booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBookingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateBookingResponse updateBooking(final String bookingId, final UpdateBookingRequest body)
            throws ApiException, IOException;

    /**
     * Updates a booking. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the [Booking](entity:Booking) object
     *         representing the to-be-updated booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBookingResponse response from the API call
     */
    CompletableFuture<UpdateBookingResponse> updateBookingAsync(
            final String bookingId, final UpdateBookingRequest body);

    /**
     * Cancels an existing booking. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the [Booking](entity:Booking) object
     *         representing the to-be-cancelled booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelBookingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelBookingResponse cancelBooking(final String bookingId, final CancelBookingRequest body)
            throws ApiException, IOException;

    /**
     * Cancels an existing booking. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_WRITE` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope. For
     * calls to this endpoint with seller-level permissions to succeed, the seller must have
     * subscribed to *Appointments Plus* or *Appointments Premium*.
     * @param  bookingId  Required parameter: The ID of the [Booking](entity:Booking) object
     *         representing the to-be-cancelled booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelBookingResponse response from the API call
     */
    CompletableFuture<CancelBookingResponse> cancelBookingAsync(
            final String bookingId, final CancelBookingRequest body);
}
