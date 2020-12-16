
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CancelBookingRequest;
import com.squareup.square.models.CancelBookingResponse;
import com.squareup.square.models.CreateBookingRequest;
import com.squareup.square.models.CreateBookingResponse;
import com.squareup.square.models.ListTeamMemberBookingProfilesResponse;
import com.squareup.square.models.RetrieveBookingResponse;
import com.squareup.square.models.RetrieveBusinessBookingProfileResponse;
import com.squareup.square.models.RetrieveTeamMemberBookingProfileResponse;
import com.squareup.square.models.SearchAvailabilityRequest;
import com.squareup.square.models.SearchAvailabilityResponse;
import com.squareup.square.models.UpdateBookingRequest;
import com.squareup.square.models.UpdateBookingResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface BookingsApi {
    /**
     * Creates a booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBookingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateBookingResponse createBooking(
            final CreateBookingRequest body) throws ApiException, IOException;

    /**
     * Creates a booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBookingResponse response from the API call
     */
    CompletableFuture<CreateBookingResponse> createBookingAsync(
            final CreateBookingRequest body);

    /**
     * Searches for availabilities for booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchAvailabilityResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchAvailabilityResponse searchAvailability(
            final SearchAvailabilityRequest body) throws ApiException, IOException;

    /**
     * Searches for availabilities for booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchAvailabilityResponse response from the API call
     */
    CompletableFuture<SearchAvailabilityResponse> searchAvailabilityAsync(
            final SearchAvailabilityRequest body);

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
     * Lists booking profiles for team members.
     * @param  bookableOnly  Optional parameter: Indicates whether to include only bookable team
     *         members in the returned result (`true`) or not (`false`).
     * @param  limit  Optional parameter: The maximum number of results to return.
     * @param  cursor  Optional parameter: The cursor for paginating through the results.
     * @param  locationId  Optional parameter: Indicates whether to include only team members
     *         enabled at the given location in the returned result.
     * @return    Returns the ListTeamMemberBookingProfilesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListTeamMemberBookingProfilesResponse listTeamMemberBookingProfiles(
            final Boolean bookableOnly,
            final Integer limit,
            final String cursor,
            final String locationId) throws ApiException, IOException;

    /**
     * Lists booking profiles for team members.
     * @param  bookableOnly  Optional parameter: Indicates whether to include only bookable team
     *         members in the returned result (`true`) or not (`false`).
     * @param  limit  Optional parameter: The maximum number of results to return.
     * @param  cursor  Optional parameter: The cursor for paginating through the results.
     * @param  locationId  Optional parameter: Indicates whether to include only team members
     *         enabled at the given location in the returned result.
     * @return    Returns the ListTeamMemberBookingProfilesResponse response from the API call
     */
    CompletableFuture<ListTeamMemberBookingProfilesResponse> listTeamMemberBookingProfilesAsync(
            final Boolean bookableOnly,
            final Integer limit,
            final String cursor,
            final String locationId);

    /**
     * Retrieves a team member's booking profile.
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberBookingProfileResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveTeamMemberBookingProfileResponse retrieveTeamMemberBookingProfile(
            final String teamMemberId) throws ApiException, IOException;

    /**
     * Retrieves a team member's booking profile.
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberBookingProfileResponse response from the API call
     */
    CompletableFuture<RetrieveTeamMemberBookingProfileResponse> retrieveTeamMemberBookingProfileAsync(
            final String teamMemberId);

    /**
     * Retrieves a booking.
     * @param  bookingId  Required parameter: The ID of the [Booking](#type-booking) object
     *         representing the to-be-retrieved booking.
     * @return    Returns the RetrieveBookingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveBookingResponse retrieveBooking(
            final String bookingId) throws ApiException, IOException;

    /**
     * Retrieves a booking.
     * @param  bookingId  Required parameter: The ID of the [Booking](#type-booking) object
     *         representing the to-be-retrieved booking.
     * @return    Returns the RetrieveBookingResponse response from the API call
     */
    CompletableFuture<RetrieveBookingResponse> retrieveBookingAsync(
            final String bookingId);

    /**
     * Updates a booking.
     * @param  bookingId  Required parameter: The ID of the [Booking](#type-booking) object
     *         representing the to-be-updated booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBookingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateBookingResponse updateBooking(
            final String bookingId,
            final UpdateBookingRequest body) throws ApiException, IOException;

    /**
     * Updates a booking.
     * @param  bookingId  Required parameter: The ID of the [Booking](#type-booking) object
     *         representing the to-be-updated booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBookingResponse response from the API call
     */
    CompletableFuture<UpdateBookingResponse> updateBookingAsync(
            final String bookingId,
            final UpdateBookingRequest body);

    /**
     * Cancels an existing booking.
     * @param  bookingId  Required parameter: The ID of the [Booking](#type-booking) object
     *         representing the to-be-cancelled booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelBookingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelBookingResponse cancelBooking(
            final String bookingId,
            final CancelBookingRequest body) throws ApiException, IOException;

    /**
     * Cancels an existing booking.
     * @param  bookingId  Required parameter: The ID of the [Booking](#type-booking) object
     *         representing the to-be-cancelled booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelBookingResponse response from the API call
     */
    CompletableFuture<CancelBookingResponse> cancelBookingAsync(
            final String bookingId,
            final CancelBookingRequest body);

}