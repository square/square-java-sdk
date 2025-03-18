/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.bookings;

import com.squareup.square.bookings.types.GetTeamMemberProfilesRequest;
import com.squareup.square.bookings.types.ListTeamMemberProfilesRequest;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.GetTeamMemberBookingProfileResponse;
import com.squareup.square.types.ListTeamMemberBookingProfilesResponse;
import com.squareup.square.types.TeamMemberBookingProfile;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class TeamMemberProfilesClient {
    protected final ClientOptions clientOptions;

    public TeamMemberProfilesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Lists booking profiles for team members.
     */
    public SyncPagingIterable<TeamMemberBookingProfile> list() {
        return list(ListTeamMemberProfilesRequest.builder().build());
    }

    /**
     * Lists booking profiles for team members.
     */
    public SyncPagingIterable<TeamMemberBookingProfile> list(ListTeamMemberProfilesRequest request) {
        return list(request, null);
    }

    /**
     * Lists booking profiles for team members.
     */
    public SyncPagingIterable<TeamMemberBookingProfile> list(
            ListTeamMemberProfilesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings/team-member-booking-profiles");
        if (request.getBookableOnly().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "bookable_only", request.getBookableOnly().get().toString(), false);
        }
        if (request.getLimit().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "limit", request.getLimit().get().toString(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getLocationId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "location_id", request.getLocationId().get(), false);
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
                ListTeamMemberBookingProfilesResponse parsedResponse = ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), ListTeamMemberBookingProfilesResponse.class);
                Optional<String> startingAfter = parsedResponse.getCursor();
                ListTeamMemberProfilesRequest nextRequest = ListTeamMemberProfilesRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<TeamMemberBookingProfile> result =
                        parsedResponse.getTeamMemberBookingProfiles().orElse(Collections.emptyList());
                return new SyncPagingIterable<TeamMemberBookingProfile>(
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
     * Retrieves a team member's booking profile.
     */
    public GetTeamMemberBookingProfileResponse get(GetTeamMemberProfilesRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves a team member's booking profile.
     */
    public GetTeamMemberBookingProfileResponse get(
            GetTeamMemberProfilesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/bookings/team-member-booking-profiles")
                .addPathSegment(request.getTeamMemberId())
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
                        responseBody.string(), GetTeamMemberBookingProfileResponse.class);
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
}
