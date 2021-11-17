
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.AuthManager;
import com.squareup.square.Configuration;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.Headers;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.CancelBookingRequest;
import com.squareup.square.models.CancelBookingResponse;
import com.squareup.square.models.CreateBookingRequest;
import com.squareup.square.models.CreateBookingResponse;
import com.squareup.square.models.ListBookingsResponse;
import com.squareup.square.models.ListTeamMemberBookingProfilesResponse;
import com.squareup.square.models.RetrieveBookingResponse;
import com.squareup.square.models.RetrieveBusinessBookingProfileResponse;
import com.squareup.square.models.RetrieveTeamMemberBookingProfileResponse;
import com.squareup.square.models.SearchAvailabilityRequest;
import com.squareup.square.models.SearchAvailabilityResponse;
import com.squareup.square.models.UpdateBookingRequest;
import com.squareup.square.models.UpdateBookingResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultBookingsApi extends BaseApi implements BookingsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultBookingsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     * @param httpCallback    Callback to be called before and after the HTTP call.
     */
    public DefaultBookingsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Retrieve a collection of bookings.
     * @param  limit  Optional parameter: The maximum number of results per page to return in a
     *         paged response.
     * @param  cursor  Optional parameter: The pagination cursor from the preceding response to
     *         return the next page of the results. Do not set this when retrieving the first page
     *         of the results.
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
            final String teamMemberId,
            final String locationId,
            final String startAtMin,
            final String startAtMax) throws ApiException, IOException {
        HttpRequest request = buildListBookingsRequest(limit, cursor, teamMemberId, locationId,
                startAtMin, startAtMax);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListBookingsResponse(context);
    }

    /**
     * Retrieve a collection of bookings.
     * @param  limit  Optional parameter: The maximum number of results per page to return in a
     *         paged response.
     * @param  cursor  Optional parameter: The pagination cursor from the preceding response to
     *         return the next page of the results. Do not set this when retrieving the first page
     *         of the results.
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
            final String teamMemberId,
            final String locationId,
            final String startAtMin,
            final String startAtMax) {
        return makeHttpCallAsync(() -> buildListBookingsRequest(limit, cursor, teamMemberId,
                locationId, startAtMin, startAtMax),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListBookingsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listBookings.
     */
    private HttpRequest buildListBookingsRequest(
            final Integer limit,
            final String cursor,
            final String teamMemberId,
            final String locationId,
            final String startAtMin,
            final String startAtMax) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bookings");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);
        queryParameters.put("team_member_id", teamMemberId);
        queryParameters.put("location_id", locationId);
        queryParameters.put("start_at_min", startAtMin);
        queryParameters.put("start_at_max", startAtMax);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listBookings.
     * @return An object of type ListBookingsResponse
     */
    private ListBookingsResponse handleListBookingsResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        ListBookingsResponse result = ApiHelper.deserialize(responseBody,
                ListBookingsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBookingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateBookingResponse createBooking(
            final CreateBookingRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateBookingRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateBookingResponse(context);
    }

    /**
     * Creates a booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBookingResponse response from the API call
     */
    public CompletableFuture<CreateBookingResponse> createBookingAsync(
            final CreateBookingRequest body) {
        return makeHttpCallAsync(() -> buildCreateBookingRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateBookingResponse(context));
    }

    /**
     * Builds the HttpRequest object for createBooking.
     */
    private HttpRequest buildCreateBookingRequest(
            final CreateBookingRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bookings");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createBooking.
     * @return An object of type CreateBookingResponse
     */
    private CreateBookingResponse handleCreateBookingResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        CreateBookingResponse result = ApiHelper.deserialize(responseBody,
                CreateBookingResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches for availabilities for booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchAvailabilityResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchAvailabilityResponse searchAvailability(
            final SearchAvailabilityRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchAvailabilityRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchAvailabilityResponse(context);
    }

    /**
     * Searches for availabilities for booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchAvailabilityResponse response from the API call
     */
    public CompletableFuture<SearchAvailabilityResponse> searchAvailabilityAsync(
            final SearchAvailabilityRequest body) {
        return makeHttpCallAsync(() -> buildSearchAvailabilityRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchAvailabilityResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchAvailability.
     */
    private HttpRequest buildSearchAvailabilityRequest(
            final SearchAvailabilityRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bookings/availability/search");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for searchAvailability.
     * @return An object of type SearchAvailabilityResponse
     */
    private SearchAvailabilityResponse handleSearchAvailabilityResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        SearchAvailabilityResponse result = ApiHelper.deserialize(responseBody,
                SearchAvailabilityResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a seller's booking profile.
     * @return    Returns the RetrieveBusinessBookingProfileResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveBusinessBookingProfileResponse retrieveBusinessBookingProfile() throws ApiException, IOException {
        HttpRequest request = buildRetrieveBusinessBookingProfileRequest();
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveBusinessBookingProfileResponse(context);
    }

    /**
     * Retrieves a seller's booking profile.
     * @return    Returns the RetrieveBusinessBookingProfileResponse response from the API call
     */
    public CompletableFuture<RetrieveBusinessBookingProfileResponse> retrieveBusinessBookingProfileAsync() {
        return makeHttpCallAsync(() -> buildRetrieveBusinessBookingProfileRequest(),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveBusinessBookingProfileResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveBusinessBookingProfile.
     */
    private HttpRequest buildRetrieveBusinessBookingProfileRequest() {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bookings/business-booking-profile");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveBusinessBookingProfile.
     * @return An object of type RetrieveBusinessBookingProfileResponse
     */
    private RetrieveBusinessBookingProfileResponse handleRetrieveBusinessBookingProfileResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        RetrieveBusinessBookingProfileResponse result = ApiHelper.deserialize(responseBody,
                RetrieveBusinessBookingProfileResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

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
    public ListTeamMemberBookingProfilesResponse listTeamMemberBookingProfiles(
            final Boolean bookableOnly,
            final Integer limit,
            final String cursor,
            final String locationId) throws ApiException, IOException {
        HttpRequest request = buildListTeamMemberBookingProfilesRequest(bookableOnly, limit, cursor,
                locationId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListTeamMemberBookingProfilesResponse(context);
    }

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
    public CompletableFuture<ListTeamMemberBookingProfilesResponse> listTeamMemberBookingProfilesAsync(
            final Boolean bookableOnly,
            final Integer limit,
            final String cursor,
            final String locationId) {
        return makeHttpCallAsync(() -> buildListTeamMemberBookingProfilesRequest(bookableOnly,
                limit, cursor, locationId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListTeamMemberBookingProfilesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listTeamMemberBookingProfiles.
     */
    private HttpRequest buildListTeamMemberBookingProfilesRequest(
            final Boolean bookableOnly,
            final Integer limit,
            final String cursor,
            final String locationId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bookings/team-member-booking-profiles");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("bookable_only",
                (bookableOnly != null) ? bookableOnly : false);
        queryParameters.put("limit", limit);
        queryParameters.put("cursor", cursor);
        queryParameters.put("location_id", locationId);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listTeamMemberBookingProfiles.
     * @return An object of type ListTeamMemberBookingProfilesResponse
     */
    private ListTeamMemberBookingProfilesResponse handleListTeamMemberBookingProfilesResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        ListTeamMemberBookingProfilesResponse result = ApiHelper.deserialize(responseBody,
                ListTeamMemberBookingProfilesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
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
        HttpRequest request = buildRetrieveTeamMemberBookingProfileRequest(teamMemberId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveTeamMemberBookingProfileResponse(context);
    }

    /**
     * Retrieves a team member's booking profile.
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberBookingProfileResponse response from the API call
     */
    public CompletableFuture<RetrieveTeamMemberBookingProfileResponse> retrieveTeamMemberBookingProfileAsync(
            final String teamMemberId) {
        return makeHttpCallAsync(() -> buildRetrieveTeamMemberBookingProfileRequest(teamMemberId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveTeamMemberBookingProfileResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveTeamMemberBookingProfile.
     */
    private HttpRequest buildRetrieveTeamMemberBookingProfileRequest(
            final String teamMemberId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bookings/team-member-booking-profiles/{team_member_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("team_member_id",
                new SimpleEntry<Object, Boolean>(teamMemberId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveTeamMemberBookingProfile.
     * @return An object of type RetrieveTeamMemberBookingProfileResponse
     */
    private RetrieveTeamMemberBookingProfileResponse handleRetrieveTeamMemberBookingProfileResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        RetrieveTeamMemberBookingProfileResponse result = ApiHelper.deserialize(responseBody,
                RetrieveTeamMemberBookingProfileResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves a booking.
     * @param  bookingId  Required parameter: The ID of the [Booking]($m/Booking) object
     *         representing the to-be-retrieved booking.
     * @return    Returns the RetrieveBookingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveBookingResponse retrieveBooking(
            final String bookingId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveBookingRequest(bookingId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveBookingResponse(context);
    }

    /**
     * Retrieves a booking.
     * @param  bookingId  Required parameter: The ID of the [Booking]($m/Booking) object
     *         representing the to-be-retrieved booking.
     * @return    Returns the RetrieveBookingResponse response from the API call
     */
    public CompletableFuture<RetrieveBookingResponse> retrieveBookingAsync(
            final String bookingId) {
        return makeHttpCallAsync(() -> buildRetrieveBookingRequest(bookingId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveBookingResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveBooking.
     */
    private HttpRequest buildRetrieveBookingRequest(
            final String bookingId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bookings/{booking_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("booking_id",
                new SimpleEntry<Object, Boolean>(bookingId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for retrieveBooking.
     * @return An object of type RetrieveBookingResponse
     */
    private RetrieveBookingResponse handleRetrieveBookingResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        RetrieveBookingResponse result = ApiHelper.deserialize(responseBody,
                RetrieveBookingResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates a booking.
     * @param  bookingId  Required parameter: The ID of the [Booking]($m/Booking) object
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
        HttpRequest request = buildUpdateBookingRequest(bookingId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateBookingResponse(context);
    }

    /**
     * Updates a booking.
     * @param  bookingId  Required parameter: The ID of the [Booking]($m/Booking) object
     *         representing the to-be-updated booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBookingResponse response from the API call
     */
    public CompletableFuture<UpdateBookingResponse> updateBookingAsync(
            final String bookingId,
            final UpdateBookingRequest body) {
        return makeHttpCallAsync(() -> buildUpdateBookingRequest(bookingId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateBookingResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateBooking.
     */
    private HttpRequest buildUpdateBookingRequest(
            final String bookingId,
            final UpdateBookingRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bookings/{booking_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("booking_id",
                new SimpleEntry<Object, Boolean>(bookingId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateBooking.
     * @return An object of type UpdateBookingResponse
     */
    private UpdateBookingResponse handleUpdateBookingResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        UpdateBookingResponse result = ApiHelper.deserialize(responseBody,
                UpdateBookingResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels an existing booking.
     * @param  bookingId  Required parameter: The ID of the [Booking]($m/Booking) object
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
        HttpRequest request = buildCancelBookingRequest(bookingId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCancelBookingResponse(context);
    }

    /**
     * Cancels an existing booking.
     * @param  bookingId  Required parameter: The ID of the [Booking]($m/Booking) object
     *         representing the to-be-cancelled booking.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelBookingResponse response from the API call
     */
    public CompletableFuture<CancelBookingResponse> cancelBookingAsync(
            final String bookingId,
            final CancelBookingRequest body) {
        return makeHttpCallAsync(() -> buildCancelBookingRequest(bookingId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCancelBookingResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelBooking.
     */
    private HttpRequest buildCancelBookingRequest(
            final String bookingId,
            final CancelBookingRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bookings/{booking_id}/cancel");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("booking_id",
                new SimpleEntry<Object, Boolean>(bookingId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for cancelBooking.
     * @return An object of type CancelBookingResponse
     */
    private CancelBookingResponse handleCancelBookingResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        CancelBookingResponse result = ApiHelper.deserialize(responseBody,
                CancelBookingResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}