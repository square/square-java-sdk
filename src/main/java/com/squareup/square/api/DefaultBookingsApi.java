
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.BulkRetrieveBookingsRequest;
import com.squareup.square.models.BulkRetrieveBookingsResponse;
import com.squareup.square.models.BulkRetrieveTeamMemberBookingProfilesRequest;
import com.squareup.square.models.BulkRetrieveTeamMemberBookingProfilesResponse;
import com.squareup.square.models.CancelBookingRequest;
import com.squareup.square.models.CancelBookingResponse;
import com.squareup.square.models.CreateBookingRequest;
import com.squareup.square.models.CreateBookingResponse;
import com.squareup.square.models.ListBookingsResponse;
import com.squareup.square.models.ListLocationBookingProfilesResponse;
import com.squareup.square.models.ListTeamMemberBookingProfilesResponse;
import com.squareup.square.models.RetrieveBookingResponse;
import com.squareup.square.models.RetrieveBusinessBookingProfileResponse;
import com.squareup.square.models.RetrieveLocationBookingProfileResponse;
import com.squareup.square.models.RetrieveTeamMemberBookingProfileResponse;
import com.squareup.square.models.SearchAvailabilityRequest;
import com.squareup.square.models.SearchAvailabilityResponse;
import com.squareup.square.models.UpdateBookingRequest;
import com.squareup.square.models.UpdateBookingResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultBookingsApi extends BaseApi implements BookingsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultBookingsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

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
    public ListBookingsResponse listBookings(
            final Integer limit,
            final String cursor,
            final String customerId,
            final String teamMemberId,
            final String locationId,
            final String startAtMin,
            final String startAtMax) throws ApiException, IOException {
        return prepareListBookingsRequest(limit, cursor, customerId, teamMemberId, locationId,
                startAtMin, startAtMax).execute();
    }

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
    public CompletableFuture<ListBookingsResponse> listBookingsAsync(
            final Integer limit,
            final String cursor,
            final String customerId,
            final String teamMemberId,
            final String locationId,
            final String startAtMin,
            final String startAtMax) {
        try { 
            return prepareListBookingsRequest(limit, cursor, customerId, teamMemberId, locationId,
            startAtMin, startAtMax).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listBookings.
     */
    private ApiCall<ListBookingsResponse, ApiException> prepareListBookingsRequest(
            final Integer limit,
            final String cursor,
            final String customerId,
            final String teamMemberId,
            final String locationId,
            final String startAtMin,
            final String startAtMax) throws IOException {
        return new ApiCall.Builder<ListBookingsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings")
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("customer_id")
                                .value(customerId).isRequired(false))
                        .queryParam(param -> param.key("team_member_id")
                                .value(teamMemberId).isRequired(false))
                        .queryParam(param -> param.key("location_id")
                                .value(locationId).isRequired(false))
                        .queryParam(param -> param.key("start_at_min")
                                .value(startAtMin).isRequired(false))
                        .queryParam(param -> param.key("start_at_max")
                                .value(startAtMax).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListBookingsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a booking. The required input must include the following: - `Booking.location_id` -
     * `Booking.start_at` - `Booking.team_member_id` -
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
    public CreateBookingResponse createBooking(
            final CreateBookingRequest body) throws ApiException, IOException {
        return prepareCreateBookingRequest(body).execute();
    }

    /**
     * Creates a booking. The required input must include the following: - `Booking.location_id` -
     * `Booking.start_at` - `Booking.team_member_id` -
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
    public CompletableFuture<CreateBookingResponse> createBookingAsync(
            final CreateBookingRequest body) {
        try { 
            return prepareCreateBookingRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createBooking.
     */
    private ApiCall<CreateBookingResponse, ApiException> prepareCreateBookingRequest(
            final CreateBookingRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateBookingResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateBookingResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public SearchAvailabilityResponse searchAvailability(
            final SearchAvailabilityRequest body) throws ApiException, IOException {
        return prepareSearchAvailabilityRequest(body).execute();
    }

    /**
     * Searches for availabilities for booking. To call this endpoint with buyer-level permissions,
     * set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level
     * permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchAvailabilityResponse response from the API call
     */
    public CompletableFuture<SearchAvailabilityResponse> searchAvailabilityAsync(
            final SearchAvailabilityRequest body) {
        try { 
            return prepareSearchAvailabilityRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchAvailability.
     */
    private ApiCall<SearchAvailabilityResponse, ApiException> prepareSearchAvailabilityRequest(
            final SearchAvailabilityRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchAvailabilityResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/availability/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchAvailabilityResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public BulkRetrieveBookingsResponse bulkRetrieveBookings(
            final BulkRetrieveBookingsRequest body) throws ApiException, IOException {
        return prepareBulkRetrieveBookingsRequest(body).execute();
    }

    /**
     * Bulk-Retrieves a list of bookings by booking IDs. To call this endpoint with buyer-level
     * permissions, set `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with
     * seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth
     * scope.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveBookingsResponse response from the API call
     */
    public CompletableFuture<BulkRetrieveBookingsResponse> bulkRetrieveBookingsAsync(
            final BulkRetrieveBookingsRequest body) {
        try { 
            return prepareBulkRetrieveBookingsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkRetrieveBookings.
     */
    private ApiCall<BulkRetrieveBookingsResponse, ApiException> prepareBulkRetrieveBookingsRequest(
            final BulkRetrieveBookingsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkRetrieveBookingsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/bulk-retrieve")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkRetrieveBookingsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a seller's booking profile.
     * @return    Returns the RetrieveBusinessBookingProfileResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveBusinessBookingProfileResponse retrieveBusinessBookingProfile() throws ApiException, IOException {
        return prepareRetrieveBusinessBookingProfileRequest().execute();
    }

    /**
     * Retrieves a seller's booking profile.
     * @return    Returns the RetrieveBusinessBookingProfileResponse response from the API call
     */
    public CompletableFuture<RetrieveBusinessBookingProfileResponse> retrieveBusinessBookingProfileAsync() {
        try { 
            return prepareRetrieveBusinessBookingProfileRequest().executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveBusinessBookingProfile.
     */
    private ApiCall<RetrieveBusinessBookingProfileResponse, ApiException> prepareRetrieveBusinessBookingProfileRequest() throws IOException {
        return new ApiCall.Builder<RetrieveBusinessBookingProfileResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/business-booking-profile")
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveBusinessBookingProfileResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public ListLocationBookingProfilesResponse listLocationBookingProfiles(
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        return prepareListLocationBookingProfilesRequest(limit, cursor).execute();
    }

    /**
     * Lists location booking profiles of a seller.
     * @param  limit  Optional parameter: The maximum number of results to return in a paged
     *         response.
     * @param  cursor  Optional parameter: The pagination cursor from the preceding response to
     *         return the next page of the results. Do not set this when retrieving the first page
     *         of the results.
     * @return    Returns the ListLocationBookingProfilesResponse response from the API call
     */
    public CompletableFuture<ListLocationBookingProfilesResponse> listLocationBookingProfilesAsync(
            final Integer limit,
            final String cursor) {
        try { 
            return prepareListLocationBookingProfilesRequest(limit, cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listLocationBookingProfiles.
     */
    private ApiCall<ListLocationBookingProfilesResponse, ApiException> prepareListLocationBookingProfilesRequest(
            final Integer limit,
            final String cursor) throws IOException {
        return new ApiCall.Builder<ListLocationBookingProfilesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/location-booking-profiles")
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListLocationBookingProfilesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a seller's location booking profile.
     * @param  locationId  Required parameter: The ID of the location to retrieve the booking
     *         profile.
     * @return    Returns the RetrieveLocationBookingProfileResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveLocationBookingProfileResponse retrieveLocationBookingProfile(
            final String locationId) throws ApiException, IOException {
        return prepareRetrieveLocationBookingProfileRequest(locationId).execute();
    }

    /**
     * Retrieves a seller's location booking profile.
     * @param  locationId  Required parameter: The ID of the location to retrieve the booking
     *         profile.
     * @return    Returns the RetrieveLocationBookingProfileResponse response from the API call
     */
    public CompletableFuture<RetrieveLocationBookingProfileResponse> retrieveLocationBookingProfileAsync(
            final String locationId) {
        try { 
            return prepareRetrieveLocationBookingProfileRequest(locationId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveLocationBookingProfile.
     */
    private ApiCall<RetrieveLocationBookingProfileResponse, ApiException> prepareRetrieveLocationBookingProfileRequest(
            final String locationId) throws IOException {
        return new ApiCall.Builder<RetrieveLocationBookingProfileResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/location-booking-profiles/{location_id}")
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveLocationBookingProfileResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public ListTeamMemberBookingProfilesResponse listTeamMemberBookingProfiles(
            final Boolean bookableOnly,
            final Integer limit,
            final String cursor,
            final String locationId) throws ApiException, IOException {
        return prepareListTeamMemberBookingProfilesRequest(bookableOnly, limit, cursor,
                locationId).execute();
    }

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
    public CompletableFuture<ListTeamMemberBookingProfilesResponse> listTeamMemberBookingProfilesAsync(
            final Boolean bookableOnly,
            final Integer limit,
            final String cursor,
            final String locationId) {
        try { 
            return prepareListTeamMemberBookingProfilesRequest(bookableOnly, limit, cursor,
            locationId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listTeamMemberBookingProfiles.
     */
    private ApiCall<ListTeamMemberBookingProfilesResponse, ApiException> prepareListTeamMemberBookingProfilesRequest(
            final Boolean bookableOnly,
            final Integer limit,
            final String cursor,
            final String locationId) throws IOException {
        return new ApiCall.Builder<ListTeamMemberBookingProfilesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/team-member-booking-profiles")
                        .queryParam(param -> param.key("bookable_only")
                                .value((bookableOnly != null) ? bookableOnly : false).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("location_id")
                                .value(locationId).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListTeamMemberBookingProfilesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves one or more team members' booking profiles.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveTeamMemberBookingProfilesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkRetrieveTeamMemberBookingProfilesResponse bulkRetrieveTeamMemberBookingProfiles(
            final BulkRetrieveTeamMemberBookingProfilesRequest body) throws ApiException, IOException {
        return prepareBulkRetrieveTeamMemberBookingProfilesRequest(body).execute();
    }

    /**
     * Retrieves one or more team members' booking profiles.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveTeamMemberBookingProfilesResponse response from the API call
     */
    public CompletableFuture<BulkRetrieveTeamMemberBookingProfilesResponse> bulkRetrieveTeamMemberBookingProfilesAsync(
            final BulkRetrieveTeamMemberBookingProfilesRequest body) {
        try { 
            return prepareBulkRetrieveTeamMemberBookingProfilesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkRetrieveTeamMemberBookingProfiles.
     */
    private ApiCall<BulkRetrieveTeamMemberBookingProfilesResponse, ApiException> prepareBulkRetrieveTeamMemberBookingProfilesRequest(
            final BulkRetrieveTeamMemberBookingProfilesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkRetrieveTeamMemberBookingProfilesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/team-member-booking-profiles/bulk-retrieve")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkRetrieveTeamMemberBookingProfilesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a team member's booking profile.
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberBookingProfileResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveTeamMemberBookingProfileResponse retrieveTeamMemberBookingProfile(
            final String teamMemberId) throws ApiException, IOException {
        return prepareRetrieveTeamMemberBookingProfileRequest(teamMemberId).execute();
    }

    /**
     * Retrieves a team member's booking profile.
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberBookingProfileResponse response from the API call
     */
    public CompletableFuture<RetrieveTeamMemberBookingProfileResponse> retrieveTeamMemberBookingProfileAsync(
            final String teamMemberId) {
        try { 
            return prepareRetrieveTeamMemberBookingProfileRequest(teamMemberId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveTeamMemberBookingProfile.
     */
    private ApiCall<RetrieveTeamMemberBookingProfileResponse, ApiException> prepareRetrieveTeamMemberBookingProfileRequest(
            final String teamMemberId) throws IOException {
        return new ApiCall.Builder<RetrieveTeamMemberBookingProfileResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/team-member-booking-profiles/{team_member_id}")
                        .templateParam(param -> param.key("team_member_id").value(teamMemberId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveTeamMemberBookingProfileResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public RetrieveBookingResponse retrieveBooking(
            final String bookingId) throws ApiException, IOException {
        return prepareRetrieveBookingRequest(bookingId).execute();
    }

    /**
     * Retrieves a booking. To call this endpoint with buyer-level permissions, set
     * `APPOINTMENTS_READ` for the OAuth scope. To call this endpoint with seller-level permissions,
     * set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
     * @param  bookingId  Required parameter: The ID of the [Booking](entity:Booking) object
     *         representing the to-be-retrieved booking.
     * @return    Returns the RetrieveBookingResponse response from the API call
     */
    public CompletableFuture<RetrieveBookingResponse> retrieveBookingAsync(
            final String bookingId) {
        try { 
            return prepareRetrieveBookingRequest(bookingId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveBooking.
     */
    private ApiCall<RetrieveBookingResponse, ApiException> prepareRetrieveBookingRequest(
            final String bookingId) throws IOException {
        return new ApiCall.Builder<RetrieveBookingResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/{booking_id}")
                        .templateParam(param -> param.key("booking_id").value(bookingId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveBookingResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public UpdateBookingResponse updateBooking(
            final String bookingId,
            final UpdateBookingRequest body) throws ApiException, IOException {
        return prepareUpdateBookingRequest(bookingId, body).execute();
    }

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
    public CompletableFuture<UpdateBookingResponse> updateBookingAsync(
            final String bookingId,
            final UpdateBookingRequest body) {
        try { 
            return prepareUpdateBookingRequest(bookingId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateBooking.
     */
    private ApiCall<UpdateBookingResponse, ApiException> prepareUpdateBookingRequest(
            final String bookingId,
            final UpdateBookingRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateBookingResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/{booking_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("booking_id").value(bookingId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateBookingResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public CancelBookingResponse cancelBooking(
            final String bookingId,
            final CancelBookingRequest body) throws ApiException, IOException {
        return prepareCancelBookingRequest(bookingId, body).execute();
    }

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
    public CompletableFuture<CancelBookingResponse> cancelBookingAsync(
            final String bookingId,
            final CancelBookingRequest body) {
        try { 
            return prepareCancelBookingRequest(bookingId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for cancelBooking.
     */
    private ApiCall<CancelBookingResponse, ApiException> prepareCancelBookingRequest(
            final String bookingId,
            final CancelBookingRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CancelBookingResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bookings/{booking_id}/cancel")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("booking_id").value(bookingId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CancelBookingResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}