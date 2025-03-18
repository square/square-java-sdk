/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.bookings.CustomAttributeDefinitionsClient;
import com.squareup.square.bookings.CustomAttributesClient;
import com.squareup.square.bookings.LocationProfilesClient;
import com.squareup.square.bookings.TeamMemberProfilesClient;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.Suppliers;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.Booking;
import com.squareup.square.types.BulkRetrieveBookingsRequest;
import com.squareup.square.types.BulkRetrieveBookingsResponse;
import com.squareup.square.types.BulkRetrieveTeamMemberBookingProfilesRequest;
import com.squareup.square.types.BulkRetrieveTeamMemberBookingProfilesResponse;
import com.squareup.square.types.CancelBookingRequest;
import com.squareup.square.types.CancelBookingResponse;
import com.squareup.square.types.CreateBookingRequest;
import com.squareup.square.types.CreateBookingResponse;
import com.squareup.square.types.GetBookingResponse;
import com.squareup.square.types.GetBookingsRequest;
import com.squareup.square.types.GetBusinessBookingProfileResponse;
import com.squareup.square.types.ListBookingsRequest;
import com.squareup.square.types.ListBookingsResponse;
import com.squareup.square.types.RetrieveLocationBookingProfileRequest;
import com.squareup.square.types.RetrieveLocationBookingProfileResponse;
import com.squareup.square.types.SearchAvailabilityRequest;
import com.squareup.square.types.SearchAvailabilityResponse;
import com.squareup.square.types.UpdateBookingRequest;
import com.squareup.square.types.UpdateBookingResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class BookingsClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<CustomAttributeDefinitionsClient> customAttributeDefinitionsClient;

    protected final Supplier<CustomAttributesClient> customAttributesClient;

    protected final Supplier<LocationProfilesClient> locationProfilesClient;

    protected final Supplier<TeamMemberProfilesClient> teamMemberProfilesClient;

    public BookingsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.customAttributeDefinitionsClient =
                Suppliers.memoize(() -> new CustomAttributeDefinitionsClient(clientOptions));
        this.customAttributesClient = Suppliers.memoize(() -> new CustomAttributesClient(clientOptions));
        this.locationProfilesClient = Suppliers.memoize(() -> new LocationProfilesClient(clientOptions));
        this.teamMemberProfilesClient = Suppliers.memoize(() -> new TeamMemberProfilesClient(clientOptions));
    }

    /**
     * Retrieve a collection of bookings.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_READ</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_READ</code> and <code>APPOINTMENTS_READ</code> for the OAuth scope.</p>
     */
    public SyncPagingIterable<Booking> list() {
        return list(ListBookingsRequest.builder().build());
    }

    /**
     * Retrieve a collection of bookings.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_READ</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_READ</code> and <code>APPOINTMENTS_READ</code> for the OAuth scope.</p>
     */
    public SyncPagingIterable<Booking> list(ListBookingsRequest request) {
        return list(request, null);
    }

    /**
     * Retrieve a collection of bookings.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_READ</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_READ</code> and <code>APPOINTMENTS_READ</code> for the OAuth scope.</p>
     */
    public SyncPagingIterable<Booking> list(ListBookingsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings");
        if (request.getLimit().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "limit", request.getLimit().get().toString(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getCustomerId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "customer_id", request.getCustomerId().get(), false);
        }
        if (request.getTeamMemberId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "team_member_id", request.getTeamMemberId().get(), false);
        }
        if (request.getLocationId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "location_id", request.getLocationId().get(), false);
        }
        if (request.getStartAtMin().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "start_at_min", request.getStartAtMin().get(), false);
        }
        if (request.getStartAtMax().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "start_at_max", request.getStartAtMax().get(), false);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                ListBookingsResponse parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListBookingsResponse.class);
                Optional<String> startingAfter = parsedResponse.getCursor();
                ListBookingsRequest nextRequest = ListBookingsRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<Booking> result = parsedResponse.getBookings().orElse(Collections.emptyList());
                return new SyncPagingIterable<Booking>(
                        startingAfter.isPresent(), result, () -> list(nextRequest, requestOptions));
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Creates a booking.
     * <p>The required input must include the following:</p>
     * <ul>
     * <li><code>Booking.location_id</code></li>
     * <li><code>Booking.start_at</code></li>
     * <li><code>Booking.AppointmentSegment.team_member_id</code></li>
     * <li><code>Booking.AppointmentSegment.service_variation_id</code></li>
     * <li><code>Booking.AppointmentSegment.service_variation_version</code></li>
     * </ul>
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_WRITE</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_WRITE</code> and <code>APPOINTMENTS_WRITE</code> for the OAuth scope.</p>
     * <p>For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to <em>Appointments Plus</em>
     * or <em>Appointments Premium</em>.</p>
     */
    public CreateBookingResponse create(CreateBookingRequest request) {
        return create(request, null);
    }

    /**
     * Creates a booking.
     * <p>The required input must include the following:</p>
     * <ul>
     * <li><code>Booking.location_id</code></li>
     * <li><code>Booking.start_at</code></li>
     * <li><code>Booking.AppointmentSegment.team_member_id</code></li>
     * <li><code>Booking.AppointmentSegment.service_variation_id</code></li>
     * <li><code>Booking.AppointmentSegment.service_variation_version</code></li>
     * </ul>
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_WRITE</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_WRITE</code> and <code>APPOINTMENTS_WRITE</code> for the OAuth scope.</p>
     * <p>For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to <em>Appointments Plus</em>
     * or <em>Appointments Premium</em>.</p>
     */
    public CreateBookingResponse create(CreateBookingRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CreateBookingResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Searches for availabilities for booking.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_READ</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_READ</code> and <code>APPOINTMENTS_READ</code> for the OAuth scope.</p>
     */
    public SearchAvailabilityResponse searchAvailability(SearchAvailabilityRequest request) {
        return searchAvailability(request, null);
    }

    /**
     * Searches for availabilities for booking.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_READ</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_READ</code> and <code>APPOINTMENTS_READ</code> for the OAuth scope.</p>
     */
    public SearchAvailabilityResponse searchAvailability(
            SearchAvailabilityRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings/availability/search")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), SearchAvailabilityResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Bulk-Retrieves a list of bookings by booking IDs.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_READ</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_READ</code> and <code>APPOINTMENTS_READ</code> for the OAuth scope.</p>
     */
    public BulkRetrieveBookingsResponse bulkRetrieveBookings(BulkRetrieveBookingsRequest request) {
        return bulkRetrieveBookings(request, null);
    }

    /**
     * Bulk-Retrieves a list of bookings by booking IDs.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_READ</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_READ</code> and <code>APPOINTMENTS_READ</code> for the OAuth scope.</p>
     */
    public BulkRetrieveBookingsResponse bulkRetrieveBookings(
            BulkRetrieveBookingsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings/bulk-retrieve")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), BulkRetrieveBookingsResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Retrieves a seller's booking profile.
     */
    public GetBusinessBookingProfileResponse getBusinessProfile() {
        return getBusinessProfile(null);
    }

    /**
     * Retrieves a seller's booking profile.
     */
    public GetBusinessBookingProfileResponse getBusinessProfile(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings/business-booking-profile")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), GetBusinessBookingProfileResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Retrieves a seller's location booking profile.
     */
    public RetrieveLocationBookingProfileResponse retrieveLocationBookingProfile(
            RetrieveLocationBookingProfileRequest request) {
        return retrieveLocationBookingProfile(request, null);
    }

    /**
     * Retrieves a seller's location booking profile.
     */
    public RetrieveLocationBookingProfileResponse retrieveLocationBookingProfile(
            RetrieveLocationBookingProfileRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings/location-booking-profiles")
                .addPathSegment(request.getLocationId())
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), RetrieveLocationBookingProfileResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Retrieves one or more team members' booking profiles.
     */
    public BulkRetrieveTeamMemberBookingProfilesResponse bulkRetrieveTeamMemberBookingProfiles(
            BulkRetrieveTeamMemberBookingProfilesRequest request) {
        return bulkRetrieveTeamMemberBookingProfiles(request, null);
    }

    /**
     * Retrieves one or more team members' booking profiles.
     */
    public BulkRetrieveTeamMemberBookingProfilesResponse bulkRetrieveTeamMemberBookingProfiles(
            BulkRetrieveTeamMemberBookingProfilesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings/team-member-booking-profiles/bulk-retrieve")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), BulkRetrieveTeamMemberBookingProfilesResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Retrieves a booking.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_READ</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_READ</code> and <code>APPOINTMENTS_READ</code> for the OAuth scope.</p>
     */
    public GetBookingResponse get(GetBookingsRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves a booking.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_READ</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_READ</code> and <code>APPOINTMENTS_READ</code> for the OAuth scope.</p>
     */
    public GetBookingResponse get(GetBookingsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings")
                .addPathSegment(request.getBookingId())
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetBookingResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Updates a booking.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_WRITE</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_WRITE</code> and <code>APPOINTMENTS_WRITE</code> for the OAuth scope.</p>
     * <p>For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to <em>Appointments Plus</em>
     * or <em>Appointments Premium</em>.</p>
     */
    public UpdateBookingResponse update(UpdateBookingRequest request) {
        return update(request, null);
    }

    /**
     * Updates a booking.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_WRITE</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_WRITE</code> and <code>APPOINTMENTS_WRITE</code> for the OAuth scope.</p>
     * <p>For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to <em>Appointments Plus</em>
     * or <em>Appointments Premium</em>.</p>
     */
    public UpdateBookingResponse update(UpdateBookingRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings")
                .addPathSegment(request.getBookingId())
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UpdateBookingResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Cancels an existing booking.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_WRITE</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_WRITE</code> and <code>APPOINTMENTS_WRITE</code> for the OAuth scope.</p>
     * <p>For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to <em>Appointments Plus</em>
     * or <em>Appointments Premium</em>.</p>
     */
    public CancelBookingResponse cancel(CancelBookingRequest request) {
        return cancel(request, null);
    }

    /**
     * Cancels an existing booking.
     * <p>To call this endpoint with buyer-level permissions, set <code>APPOINTMENTS_WRITE</code> for the OAuth scope.
     * To call this endpoint with seller-level permissions, set <code>APPOINTMENTS_ALL_WRITE</code> and <code>APPOINTMENTS_WRITE</code> for the OAuth scope.</p>
     * <p>For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to <em>Appointments Plus</em>
     * or <em>Appointments Premium</em>.</p>
     */
    public CancelBookingResponse cancel(CancelBookingRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings")
                .addPathSegment(request.getBookingId())
                .addPathSegments("cancel")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CancelBookingResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    public CustomAttributeDefinitionsClient customAttributeDefinitions() {
        return this.customAttributeDefinitionsClient.get();
    }

    public CustomAttributesClient customAttributes() {
        return this.customAttributesClient.get();
    }

    public LocationProfilesClient locationProfiles() {
        return this.locationProfilesClient.get();
    }

    public TeamMemberProfilesClient teamMemberProfiles() {
        return this.teamMemberProfilesClient.get();
    }
}
