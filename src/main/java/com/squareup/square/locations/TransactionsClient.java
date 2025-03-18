/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.locations;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.locations.types.CaptureTransactionsRequest;
import com.squareup.square.locations.types.GetTransactionsRequest;
import com.squareup.square.locations.types.ListTransactionsRequest;
import com.squareup.square.locations.types.VoidTransactionsRequest;
import com.squareup.square.types.CaptureTransactionResponse;
import com.squareup.square.types.GetTransactionResponse;
import com.squareup.square.types.ListTransactionsResponse;
import com.squareup.square.types.VoidTransactionResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class TransactionsClient {
    protected final ClientOptions clientOptions;

    public TransactionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Lists transactions for a particular location.
     * <p>Transactions include payment information from sales and exchanges and refund
     * information from returns and exchanges.</p>
     * <p>Max results per <a href="https://developer.squareup.com/docs/working-with-apis/pagination">page</a>: 50</p>
     */
    public ListTransactionsResponse list(ListTransactionsRequest request) {
        return list(request, null);
    }

    /**
     * Lists transactions for a particular location.
     * <p>Transactions include payment information from sales and exchanges and refund
     * information from returns and exchanges.</p>
     * <p>Max results per <a href="https://developer.squareup.com/docs/working-with-apis/pagination">page</a>: 50</p>
     */
    public ListTransactionsResponse list(ListTransactionsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
                .addPathSegments("transactions");
        if (request.getBeginTime().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "begin_time", request.getBeginTime().get(), false);
        }
        if (request.getEndTime().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "end_time", request.getEndTime().get(), false);
        }
        if (request.getSortOrder().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "sort_order", request.getSortOrder().get().toString(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListTransactionsResponse.class);
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
     * Retrieves details for a single transaction.
     */
    public GetTransactionResponse get(GetTransactionsRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves details for a single transaction.
     */
    public GetTransactionResponse get(GetTransactionsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
                .addPathSegments("transactions")
                .addPathSegment(request.getTransactionId())
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetTransactionResponse.class);
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
     * Captures a transaction that was created with the <a href="api-endpoint:Transactions-Charge">Charge</a>
     * endpoint with a <code>delay_capture</code> value of <code>true</code>.
     * <p>See <a href="https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture">Delayed capture transactions</a>
     * for more information.</p>
     */
    public CaptureTransactionResponse capture(CaptureTransactionsRequest request) {
        return capture(request, null);
    }

    /**
     * Captures a transaction that was created with the <a href="api-endpoint:Transactions-Charge">Charge</a>
     * endpoint with a <code>delay_capture</code> value of <code>true</code>.
     * <p>See <a href="https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture">Delayed capture transactions</a>
     * for more information.</p>
     */
    public CaptureTransactionResponse capture(CaptureTransactionsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
                .addPathSegments("transactions")
                .addPathSegment(request.getTransactionId())
                .addPathSegments("capture")
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CaptureTransactionResponse.class);
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
     * Cancels a transaction that was created with the <a href="api-endpoint:Transactions-Charge">Charge</a>
     * endpoint with a <code>delay_capture</code> value of <code>true</code>.
     * <p>See <a href="https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture">Delayed capture transactions</a>
     * for more information.</p>
     */
    public VoidTransactionResponse void_(VoidTransactionsRequest request) {
        return void_(request, null);
    }

    /**
     * Cancels a transaction that was created with the <a href="api-endpoint:Transactions-Charge">Charge</a>
     * endpoint with a <code>delay_capture</code> value of <code>true</code>.
     * <p>See <a href="https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture">Delayed capture transactions</a>
     * for more information.</p>
     */
    public VoidTransactionResponse void_(VoidTransactionsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
                .addPathSegments("transactions")
                .addPathSegment(request.getTransactionId())
                .addPathSegments("void")
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), VoidTransactionResponse.class);
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
