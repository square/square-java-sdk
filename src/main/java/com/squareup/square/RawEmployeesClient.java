/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareClientHttpResponse;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.Employee;
import com.squareup.square.types.GetEmployeeResponse;
import com.squareup.square.types.GetEmployeesRequest;
import com.squareup.square.types.ListEmployeesRequest;
import com.squareup.square.types.ListEmployeesResponse;
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

public class RawEmployeesClient {
    protected final ClientOptions clientOptions;

    public RawEmployeesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public SquareClientHttpResponse<SyncPagingIterable<Employee>> list() {
        return list(ListEmployeesRequest.builder().build());
    }

    public SquareClientHttpResponse<SyncPagingIterable<Employee>> list(ListEmployeesRequest request) {
        return list(request, null);
    }

    public SquareClientHttpResponse<SyncPagingIterable<Employee>> list(
            ListEmployeesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/employees");
        if (request.getLocationId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "location_id", request.getLocationId().get(), false);
        }
        if (request.getStatus().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "status", request.getStatus().get(), false);
        }
        if (request.getLimit().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "limit", request.getLimit().get(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                ListEmployeesResponse parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListEmployeesResponse.class);
                Optional<String> startingAfter = parsedResponse.getCursor();
                ListEmployeesRequest nextRequest = ListEmployeesRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<Employee> result = parsedResponse.getEmployees().orElse(Collections.emptyList());
                return new SquareClientHttpResponse<>(
                        new SyncPagingIterable<Employee>(
                                startingAfter.isPresent(), result, () -> list(nextRequest, requestOptions)
                                        .body()),
                        response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    public SquareClientHttpResponse<GetEmployeeResponse> get(GetEmployeesRequest request) {
        return get(request, null);
    }

    public SquareClientHttpResponse<GetEmployeeResponse> get(
            GetEmployeesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/employees")
                .addPathSegment(request.getId())
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new SquareClientHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetEmployeeResponse.class),
                        response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }
}
