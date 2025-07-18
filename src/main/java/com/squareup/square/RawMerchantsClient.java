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
import com.squareup.square.types.GetMerchantResponse;
import com.squareup.square.types.GetMerchantsRequest;
import com.squareup.square.types.ListMerchantsRequest;
import com.squareup.square.types.ListMerchantsResponse;
import com.squareup.square.types.Merchant;
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

public class RawMerchantsClient {
    protected final ClientOptions clientOptions;

    public RawMerchantsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Provides details about the merchant associated with a given access token.
     * <p>The access token used to connect your application to a Square seller is associated
     * with a single merchant. That means that <code>ListMerchants</code> returns a list
     * with a single <code>Merchant</code> object. You can specify your personal access token
     * to get your own merchant information or specify an OAuth token to get the
     * information for the merchant that granted your application access.</p>
     * <p>If you know the merchant ID, you can also use the <a href="api-endpoint:Merchants-RetrieveMerchant">RetrieveMerchant</a>
     * endpoint to retrieve the merchant information.</p>
     */
    public SquareClientHttpResponse<SyncPagingIterable<Merchant>> list() {
        return list(ListMerchantsRequest.builder().build());
    }

    /**
     * Provides details about the merchant associated with a given access token.
     * <p>The access token used to connect your application to a Square seller is associated
     * with a single merchant. That means that <code>ListMerchants</code> returns a list
     * with a single <code>Merchant</code> object. You can specify your personal access token
     * to get your own merchant information or specify an OAuth token to get the
     * information for the merchant that granted your application access.</p>
     * <p>If you know the merchant ID, you can also use the <a href="api-endpoint:Merchants-RetrieveMerchant">RetrieveMerchant</a>
     * endpoint to retrieve the merchant information.</p>
     */
    public SquareClientHttpResponse<SyncPagingIterable<Merchant>> list(ListMerchantsRequest request) {
        return list(request, null);
    }

    /**
     * Provides details about the merchant associated with a given access token.
     * <p>The access token used to connect your application to a Square seller is associated
     * with a single merchant. That means that <code>ListMerchants</code> returns a list
     * with a single <code>Merchant</code> object. You can specify your personal access token
     * to get your own merchant information or specify an OAuth token to get the
     * information for the merchant that granted your application access.</p>
     * <p>If you know the merchant ID, you can also use the <a href="api-endpoint:Merchants-RetrieveMerchant">RetrieveMerchant</a>
     * endpoint to retrieve the merchant information.</p>
     */
    public SquareClientHttpResponse<SyncPagingIterable<Merchant>> list(
            ListMerchantsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/merchants");
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
                ListMerchantsResponse parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListMerchantsResponse.class);
                Optional<Integer> startingAfter = parsedResponse.getCursor();
                ListMerchantsRequest nextRequest = ListMerchantsRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<Merchant> result = parsedResponse.getMerchant().orElse(Collections.emptyList());
                return new SquareClientHttpResponse<>(
                        new SyncPagingIterable<Merchant>(
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
     * Retrieves the <code>Merchant</code> object for the given <code>merchant_id</code>.
     */
    public SquareClientHttpResponse<GetMerchantResponse> get(GetMerchantsRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves the <code>Merchant</code> object for the given <code>merchant_id</code>.
     */
    public SquareClientHttpResponse<GetMerchantResponse> get(
            GetMerchantsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/merchants")
                .addPathSegment(request.getMerchantId())
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
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetMerchantResponse.class),
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
