/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.Suppliers;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.devices.CodesClient;
import com.squareup.square.types.Device;
import com.squareup.square.types.GetDeviceResponse;
import com.squareup.square.types.GetDevicesRequest;
import com.squareup.square.types.ListDevicesRequest;
import com.squareup.square.types.ListDevicesResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DevicesClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<CodesClient> codesClient;

    public DevicesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.codesClient = Suppliers.memoize(() -> new CodesClient(clientOptions));
    }

    /**
     * List devices associated with the merchant. Currently, only Terminal API
     * devices are supported.
     */
    public SyncPagingIterable<Device> list() {
        return list(ListDevicesRequest.builder().build());
    }

    /**
     * List devices associated with the merchant. Currently, only Terminal API
     * devices are supported.
     */
    public SyncPagingIterable<Device> list(ListDevicesRequest request) {
        return list(request, null);
    }

    /**
     * List devices associated with the merchant. Currently, only Terminal API
     * devices are supported.
     */
    public SyncPagingIterable<Device> list(ListDevicesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/devices");
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getSortOrder().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "sort_order", request.getSortOrder().get().toString(), false);
        }
        if (request.getLimit().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "limit", request.getLimit().get().toString(), false);
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
                ListDevicesResponse parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListDevicesResponse.class);
                Optional<String> startingAfter = parsedResponse.getCursor();
                ListDevicesRequest nextRequest = ListDevicesRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<Device> result = parsedResponse.getDevices().orElse(Collections.emptyList());
                return new SyncPagingIterable<Device>(
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
     * Retrieves Device with the associated <code>device_id</code>.
     */
    public GetDeviceResponse get(GetDevicesRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves Device with the associated <code>device_id</code>.
     */
    public GetDeviceResponse get(GetDevicesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/devices")
                .addPathSegment(request.getDeviceId())
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetDeviceResponse.class);
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

    public CodesClient codes() {
        return this.codesClient.get();
    }
}
