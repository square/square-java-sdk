/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.CancelPaymentByIdempotencyKeyRequest;
import com.squareup.square.types.CancelPaymentByIdempotencyKeyResponse;
import com.squareup.square.types.CancelPaymentResponse;
import com.squareup.square.types.CancelPaymentsRequest;
import com.squareup.square.types.CompletePaymentRequest;
import com.squareup.square.types.CompletePaymentResponse;
import com.squareup.square.types.CreatePaymentRequest;
import com.squareup.square.types.CreatePaymentResponse;
import com.squareup.square.types.GetPaymentResponse;
import com.squareup.square.types.GetPaymentsRequest;
import com.squareup.square.types.ListPaymentsRequest;
import com.squareup.square.types.ListPaymentsResponse;
import com.squareup.square.types.Payment;
import com.squareup.square.types.UpdatePaymentRequest;
import com.squareup.square.types.UpdatePaymentResponse;
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

public class PaymentsClient {
    protected final ClientOptions clientOptions;

    public PaymentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Retrieves a list of payments taken by the account making the request.
     * <p>Results are eventually consistent, and new payments or changes to payments might take several
     * seconds to appear.</p>
     * <p>The maximum results per page is 100.</p>
     */
    public SyncPagingIterable<Payment> list() {
        return list(ListPaymentsRequest.builder().build());
    }

    /**
     * Retrieves a list of payments taken by the account making the request.
     * <p>Results are eventually consistent, and new payments or changes to payments might take several
     * seconds to appear.</p>
     * <p>The maximum results per page is 100.</p>
     */
    public SyncPagingIterable<Payment> list(ListPaymentsRequest request) {
        return list(request, null);
    }

    /**
     * Retrieves a list of payments taken by the account making the request.
     * <p>Results are eventually consistent, and new payments or changes to payments might take several
     * seconds to appear.</p>
     * <p>The maximum results per page is 100.</p>
     */
    public SyncPagingIterable<Payment> list(ListPaymentsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/payments");
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
                    httpUrl, "sort_order", request.getSortOrder().get(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getLocationId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "location_id", request.getLocationId().get(), false);
        }
        if (request.getTotal().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "total", request.getTotal().get().toString(), false);
        }
        if (request.getLast4().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "last_4", request.getLast4().get(), false);
        }
        if (request.getCardBrand().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "card_brand", request.getCardBrand().get(), false);
        }
        if (request.getLimit().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "limit", request.getLimit().get().toString(), false);
        }
        if (request.getIsOfflinePayment().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "is_offline_payment",
                    request.getIsOfflinePayment().get().toString(),
                    false);
        }
        if (request.getOfflineBeginTime().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "offline_begin_time", request.getOfflineBeginTime().get(), false);
        }
        if (request.getOfflineEndTime().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "offline_end_time", request.getOfflineEndTime().get(), false);
        }
        if (request.getUpdatedAtBeginTime().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "updated_at_begin_time",
                    request.getUpdatedAtBeginTime().get(),
                    false);
        }
        if (request.getUpdatedAtEndTime().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "updated_at_end_time",
                    request.getUpdatedAtEndTime().get(),
                    false);
        }
        if (request.getSortField().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "sort_field", request.getSortField().get().toString(), false);
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
                ListPaymentsResponse parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListPaymentsResponse.class);
                Optional<String> startingAfter = parsedResponse.getCursor();
                ListPaymentsRequest nextRequest = ListPaymentsRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<Payment> result = parsedResponse.getPayments().orElse(Collections.emptyList());
                return new SyncPagingIterable<Payment>(
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
     * Creates a payment using the provided source. You can use this endpoint
     * to charge a card (credit/debit card or
     * Square gift card) or record a payment that the seller received outside of Square
     * (cash payment from a buyer or a payment that an external entity
     * processed on behalf of the seller).
     * <p>The endpoint creates a
     * <code>Payment</code> object and returns it in the response.</p>
     */
    public CreatePaymentResponse create(CreatePaymentRequest request) {
        return create(request, null);
    }

    /**
     * Creates a payment using the provided source. You can use this endpoint
     * to charge a card (credit/debit card or
     * Square gift card) or record a payment that the seller received outside of Square
     * (cash payment from a buyer or a payment that an external entity
     * processed on behalf of the seller).
     * <p>The endpoint creates a
     * <code>Payment</code> object and returns it in the response.</p>
     */
    public CreatePaymentResponse create(CreatePaymentRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/payments")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CreatePaymentResponse.class);
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
     * Cancels (voids) a payment identified by the idempotency key that is specified in the
     * request.
     * <p>Use this method when the status of a <code>CreatePayment</code> request is unknown (for example, after you send a
     * <code>CreatePayment</code> request, a network error occurs and you do not get a response). In this case, you can
     * direct Square to cancel the payment using this endpoint. In the request, you provide the same
     * idempotency key that you provided in your <code>CreatePayment</code> request that you want to cancel. After
     * canceling the payment, you can submit your <code>CreatePayment</code> request again.</p>
     * <p>Note that if no payment with the specified idempotency key is found, no action is taken and the endpoint
     * returns successfully.</p>
     */
    public CancelPaymentByIdempotencyKeyResponse cancelByIdempotencyKey(CancelPaymentByIdempotencyKeyRequest request) {
        return cancelByIdempotencyKey(request, null);
    }

    /**
     * Cancels (voids) a payment identified by the idempotency key that is specified in the
     * request.
     * <p>Use this method when the status of a <code>CreatePayment</code> request is unknown (for example, after you send a
     * <code>CreatePayment</code> request, a network error occurs and you do not get a response). In this case, you can
     * direct Square to cancel the payment using this endpoint. In the request, you provide the same
     * idempotency key that you provided in your <code>CreatePayment</code> request that you want to cancel. After
     * canceling the payment, you can submit your <code>CreatePayment</code> request again.</p>
     * <p>Note that if no payment with the specified idempotency key is found, no action is taken and the endpoint
     * returns successfully.</p>
     */
    public CancelPaymentByIdempotencyKeyResponse cancelByIdempotencyKey(
            CancelPaymentByIdempotencyKeyRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/payments/cancel")
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
                        responseBody.string(), CancelPaymentByIdempotencyKeyResponse.class);
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
     * Retrieves details for a specific payment.
     */
    public GetPaymentResponse get(GetPaymentsRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves details for a specific payment.
     */
    public GetPaymentResponse get(GetPaymentsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/payments")
                .addPathSegment(request.getPaymentId())
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetPaymentResponse.class);
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
     * Updates a payment with the APPROVED status.
     * You can update the <code>amount_money</code> and <code>tip_money</code> using this endpoint.
     */
    public UpdatePaymentResponse update(UpdatePaymentRequest request) {
        return update(request, null);
    }

    /**
     * Updates a payment with the APPROVED status.
     * You can update the <code>amount_money</code> and <code>tip_money</code> using this endpoint.
     */
    public UpdatePaymentResponse update(UpdatePaymentRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/payments")
                .addPathSegment(request.getPaymentId())
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UpdatePaymentResponse.class);
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
     * Cancels (voids) a payment. You can use this endpoint to cancel a payment with
     * the APPROVED <code>status</code>.
     */
    public CancelPaymentResponse cancel(CancelPaymentsRequest request) {
        return cancel(request, null);
    }

    /**
     * Cancels (voids) a payment. You can use this endpoint to cancel a payment with
     * the APPROVED <code>status</code>.
     */
    public CancelPaymentResponse cancel(CancelPaymentsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/payments")
                .addPathSegment(request.getPaymentId())
                .addPathSegments("cancel")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CancelPaymentResponse.class);
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
     * Completes (captures) a payment.
     * By default, payments are set to complete immediately after they are created.
     * <p>You can use this endpoint to complete a payment with the APPROVED <code>status</code>.</p>
     */
    public CompletePaymentResponse complete(CompletePaymentRequest request) {
        return complete(request, null);
    }

    /**
     * Completes (captures) a payment.
     * By default, payments are set to complete immediately after they are created.
     * <p>You can use this endpoint to complete a payment with the APPROVED <code>status</code>.</p>
     */
    public CompletePaymentResponse complete(CompletePaymentRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/payments")
                .addPathSegment(request.getPaymentId())
                .addPathSegments("complete")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CompletePaymentResponse.class);
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
