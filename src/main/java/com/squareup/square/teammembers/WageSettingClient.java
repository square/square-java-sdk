/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.teammembers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.teammembers.types.GetWageSettingRequest;
import com.squareup.square.teammembers.types.UpdateWageSettingRequest;
import com.squareup.square.types.GetWageSettingResponse;
import com.squareup.square.types.UpdateWageSettingResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class WageSettingClient {
    protected final ClientOptions clientOptions;

    public WageSettingClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Retrieves a <code>WageSetting</code> object for a team member specified
     * by <code>TeamMember.id</code>. For more information, see
     * <a href="https://developer.squareup.com/docs/team/troubleshooting#retrievewagesetting">Troubleshooting the Team API</a>.
     * <p>Square recommends using <a href="api-endpoint:Team-RetrieveTeamMember">RetrieveTeamMember</a> or <a href="api-endpoint:Team-SearchTeamMembers">SearchTeamMembers</a>
     * to get this information directly from the <code>TeamMember.wage_setting</code> field.</p>
     */
    public GetWageSettingResponse get(GetWageSettingRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves a <code>WageSetting</code> object for a team member specified
     * by <code>TeamMember.id</code>. For more information, see
     * <a href="https://developer.squareup.com/docs/team/troubleshooting#retrievewagesetting">Troubleshooting the Team API</a>.
     * <p>Square recommends using <a href="api-endpoint:Team-RetrieveTeamMember">RetrieveTeamMember</a> or <a href="api-endpoint:Team-SearchTeamMembers">SearchTeamMembers</a>
     * to get this information directly from the <code>TeamMember.wage_setting</code> field.</p>
     */
    public GetWageSettingResponse get(GetWageSettingRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/team-members")
                .addPathSegment(request.getTeamMemberId())
                .addPathSegments("wage-setting")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetWageSettingResponse.class);
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
     * Creates or updates a <code>WageSetting</code> object. The object is created if a
     * <code>WageSetting</code> with the specified <code>team_member_id</code> doesn't exist. Otherwise,
     * it fully replaces the <code>WageSetting</code> object for the team member.
     * The <code>WageSetting</code> is returned on a successful update. For more information, see
     * <a href="https://developer.squareup.com/docs/team/troubleshooting#create-or-update-a-wage-setting">Troubleshooting the Team API</a>.
     * <p>Square recommends using <a href="api-endpoint:Team-CreateTeamMember">CreateTeamMember</a> or <a href="api-endpoint:Team-UpdateTeamMember">UpdateTeamMember</a>
     * to manage the <code>TeamMember.wage_setting</code> field directly.</p>
     */
    public UpdateWageSettingResponse update(UpdateWageSettingRequest request) {
        return update(request, null);
    }

    /**
     * Creates or updates a <code>WageSetting</code> object. The object is created if a
     * <code>WageSetting</code> with the specified <code>team_member_id</code> doesn't exist. Otherwise,
     * it fully replaces the <code>WageSetting</code> object for the team member.
     * The <code>WageSetting</code> is returned on a successful update. For more information, see
     * <a href="https://developer.squareup.com/docs/team/troubleshooting#create-or-update-a-wage-setting">Troubleshooting the Team API</a>.
     * <p>Square recommends using <a href="api-endpoint:Team-CreateTeamMember">CreateTeamMember</a> or <a href="api-endpoint:Team-UpdateTeamMember">UpdateTeamMember</a>
     * to manage the <code>TeamMember.wage_setting</code> field directly.</p>
     */
    public UpdateWageSettingResponse update(UpdateWageSettingRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/team-members")
                .addPathSegment(request.getTeamMemberId())
                .addPathSegments("wage-setting")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UpdateWageSettingResponse.class);
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
