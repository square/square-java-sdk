/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.customers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareClientHttpResponse;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.customers.types.DeleteCustomAttributesRequest;
import com.squareup.square.customers.types.GetCustomAttributesRequest;
import com.squareup.square.customers.types.ListCustomAttributesRequest;
import com.squareup.square.customers.types.UpsertCustomerCustomAttributeRequest;
import com.squareup.square.types.CustomAttribute;
import com.squareup.square.types.DeleteCustomerCustomAttributeResponse;
import com.squareup.square.types.GetCustomerCustomAttributeResponse;
import com.squareup.square.types.ListCustomerCustomAttributesResponse;
import com.squareup.square.types.UpsertCustomerCustomAttributeResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RawCustomAttributesClient {
    protected final ClientOptions clientOptions;

    public RawCustomAttributesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Lists the <a href="entity:CustomAttribute">custom attributes</a> associated with a customer profile.
     * <p>You can use the <code>with_definitions</code> query parameter to also retrieve custom attribute definitions
     * in the same call.</p>
     * <p>When all response pages are retrieved, the results include all custom attributes that are
     * visible to the requesting application, including those that are owned by other applications
     * and set to <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.</p>
     */
    public SquareClientHttpResponse<SyncPagingIterable<CustomAttribute>> list(ListCustomAttributesRequest request) {
        return list(request, null);
    }

    /**
     * Lists the <a href="entity:CustomAttribute">custom attributes</a> associated with a customer profile.
     * <p>You can use the <code>with_definitions</code> query parameter to also retrieve custom attribute definitions
     * in the same call.</p>
     * <p>When all response pages are retrieved, the results include all custom attributes that are
     * visible to the requesting application, including those that are owned by other applications
     * and set to <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>.</p>
     */
    public SquareClientHttpResponse<SyncPagingIterable<CustomAttribute>> list(
            ListCustomAttributesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers")
                .addPathSegment(request.getCustomerId())
                .addPathSegments("custom-attributes");
        if (request.getLimit().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "limit", request.getLimit().get(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getWithDefinitions().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "with_definitions", request.getWithDefinitions().get(), false);
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
                ListCustomerCustomAttributesResponse parsedResponse = ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), ListCustomerCustomAttributesResponse.class);
                Optional<String> startingAfter = parsedResponse.getCursor();
                ListCustomAttributesRequest nextRequest = ListCustomAttributesRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<CustomAttribute> result =
                        parsedResponse.getCustomAttributes().orElse(Collections.emptyList());
                return new SquareClientHttpResponse<>(
                        new SyncPagingIterable<CustomAttribute>(
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

    /**
     * Retrieves a <a href="entity:CustomAttribute">custom attribute</a> associated with a customer profile.
     * <p>You can use the <code>with_definition</code> query parameter to also retrieve the custom attribute definition
     * in the same call.</p>
     * <p>To retrieve a custom attribute owned by another application, the <code>visibility</code> setting must be
     * <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>. Note that seller-defined custom attributes
     * (also known as custom fields) are always set to <code>VISIBILITY_READ_WRITE_VALUES</code>.</p>
     */
    public SquareClientHttpResponse<GetCustomerCustomAttributeResponse> get(GetCustomAttributesRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves a <a href="entity:CustomAttribute">custom attribute</a> associated with a customer profile.
     * <p>You can use the <code>with_definition</code> query parameter to also retrieve the custom attribute definition
     * in the same call.</p>
     * <p>To retrieve a custom attribute owned by another application, the <code>visibility</code> setting must be
     * <code>VISIBILITY_READ_ONLY</code> or <code>VISIBILITY_READ_WRITE_VALUES</code>. Note that seller-defined custom attributes
     * (also known as custom fields) are always set to <code>VISIBILITY_READ_WRITE_VALUES</code>.</p>
     */
    public SquareClientHttpResponse<GetCustomerCustomAttributeResponse> get(
            GetCustomAttributesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers")
                .addPathSegment(request.getCustomerId())
                .addPathSegments("custom-attributes")
                .addPathSegment(request.getKey());
        if (request.getWithDefinition().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "with_definition", request.getWithDefinition().get(), false);
        }
        if (request.getVersion().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "version", request.getVersion().get(), false);
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
                return new SquareClientHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), GetCustomerCustomAttributeResponse.class),
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

    /**
     * Creates or updates a <a href="entity:CustomAttribute">custom attribute</a> for a customer profile.
     * <p>Use this endpoint to set the value of a custom attribute for a specified customer profile.
     * A custom attribute is based on a custom attribute definition in a Square seller account, which
     * is created using the <a href="api-endpoint:CustomerCustomAttributes-CreateCustomerCustomAttributeDefinition">CreateCustomerCustomAttributeDefinition</a> endpoint.</p>
     * <p>To create or update a custom attribute owned by another application, the <code>visibility</code> setting
     * must be <code>VISIBILITY_READ_WRITE_VALUES</code>. Note that seller-defined custom attributes
     * (also known as custom fields) are always set to <code>VISIBILITY_READ_WRITE_VALUES</code>.</p>
     */
    public SquareClientHttpResponse<UpsertCustomerCustomAttributeResponse> upsert(
            UpsertCustomerCustomAttributeRequest request) {
        return upsert(request, null);
    }

    /**
     * Creates or updates a <a href="entity:CustomAttribute">custom attribute</a> for a customer profile.
     * <p>Use this endpoint to set the value of a custom attribute for a specified customer profile.
     * A custom attribute is based on a custom attribute definition in a Square seller account, which
     * is created using the <a href="api-endpoint:CustomerCustomAttributes-CreateCustomerCustomAttributeDefinition">CreateCustomerCustomAttributeDefinition</a> endpoint.</p>
     * <p>To create or update a custom attribute owned by another application, the <code>visibility</code> setting
     * must be <code>VISIBILITY_READ_WRITE_VALUES</code>. Note that seller-defined custom attributes
     * (also known as custom fields) are always set to <code>VISIBILITY_READ_WRITE_VALUES</code>.</p>
     */
    public SquareClientHttpResponse<UpsertCustomerCustomAttributeResponse> upsert(
            UpsertCustomerCustomAttributeRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers")
                .addPathSegment(request.getCustomerId())
                .addPathSegments("custom-attributes")
                .addPathSegment(request.getKey())
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
                return new SquareClientHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), UpsertCustomerCustomAttributeResponse.class),
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

    /**
     * Deletes a <a href="entity:CustomAttribute">custom attribute</a> associated with a customer profile.
     * <p>To delete a custom attribute owned by another application, the <code>visibility</code> setting must be
     * <code>VISIBILITY_READ_WRITE_VALUES</code>. Note that seller-defined custom attributes
     * (also known as custom fields) are always set to <code>VISIBILITY_READ_WRITE_VALUES</code>.</p>
     */
    public SquareClientHttpResponse<DeleteCustomerCustomAttributeResponse> delete(
            DeleteCustomAttributesRequest request) {
        return delete(request, null);
    }

    /**
     * Deletes a <a href="entity:CustomAttribute">custom attribute</a> associated with a customer profile.
     * <p>To delete a custom attribute owned by another application, the <code>visibility</code> setting must be
     * <code>VISIBILITY_READ_WRITE_VALUES</code>. Note that seller-defined custom attributes
     * (also known as custom fields) are always set to <code>VISIBILITY_READ_WRITE_VALUES</code>.</p>
     */
    public SquareClientHttpResponse<DeleteCustomerCustomAttributeResponse> delete(
            DeleteCustomAttributesRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers")
                .addPathSegment(request.getCustomerId())
                .addPathSegments("custom-attributes")
                .addPathSegment(request.getKey())
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
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
                        ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), DeleteCustomerCustomAttributeResponse.class),
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
