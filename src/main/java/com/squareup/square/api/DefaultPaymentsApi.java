
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CancelPaymentByIdempotencyKeyRequest;
import com.squareup.square.models.CancelPaymentByIdempotencyKeyResponse;
import com.squareup.square.models.CancelPaymentResponse;
import com.squareup.square.models.CompletePaymentRequest;
import com.squareup.square.models.CompletePaymentResponse;
import com.squareup.square.models.CreatePaymentRequest;
import com.squareup.square.models.CreatePaymentResponse;
import com.squareup.square.models.GetPaymentResponse;
import com.squareup.square.models.ListPaymentsResponse;
import com.squareup.square.models.UpdatePaymentRequest;
import com.squareup.square.models.UpdatePaymentResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultPaymentsApi extends BaseApi implements PaymentsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultPaymentsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Retrieves a list of payments taken by the account making the request. Results are eventually
     * consistent, and new payments or changes to payments might take several seconds to appear. The
     * maximum results per page is 100.
     * @param  beginTime  Optional parameter: Indicates the start of the time range to retrieve
     *         payments for, in RFC 3339 format. The range is determined using the `created_at`
     *         field for each Payment. Inclusive. Default: The current time minus one year.
     * @param  endTime  Optional parameter: Indicates the end of the time range to retrieve payments
     *         for, in RFC 3339 format. The range is determined using the `created_at` field for
     *         each Payment. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed by
     *         `Payment.created_at`: - `ASC` - Oldest to newest. - `DESC` - Newest to oldest
     *         (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  locationId  Optional parameter: Limit results to the location supplied. By default,
     *         results are returned for the default (main) location associated with the seller.
     * @param  total  Optional parameter: The exact amount in the `total_money` for a payment.
     * @param  last4  Optional parameter: The last four digits of a payment card.
     * @param  cardBrand  Optional parameter: The brand of the payment card (for example, VISA).
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPaymentsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListPaymentsResponse listPayments(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand,
            final Integer limit) throws ApiException, IOException {
        return prepareListPaymentsRequest(beginTime, endTime, sortOrder, cursor, locationId, total,
                last4, cardBrand, limit).execute();
    }

    /**
     * Retrieves a list of payments taken by the account making the request. Results are eventually
     * consistent, and new payments or changes to payments might take several seconds to appear. The
     * maximum results per page is 100.
     * @param  beginTime  Optional parameter: Indicates the start of the time range to retrieve
     *         payments for, in RFC 3339 format. The range is determined using the `created_at`
     *         field for each Payment. Inclusive. Default: The current time minus one year.
     * @param  endTime  Optional parameter: Indicates the end of the time range to retrieve payments
     *         for, in RFC 3339 format. The range is determined using the `created_at` field for
     *         each Payment. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed by
     *         `Payment.created_at`: - `ASC` - Oldest to newest. - `DESC` - Newest to oldest
     *         (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  locationId  Optional parameter: Limit results to the location supplied. By default,
     *         results are returned for the default (main) location associated with the seller.
     * @param  total  Optional parameter: The exact amount in the `total_money` for a payment.
     * @param  last4  Optional parameter: The last four digits of a payment card.
     * @param  cardBrand  Optional parameter: The brand of the payment card (for example, VISA).
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPaymentsResponse response from the API call
     */
    public CompletableFuture<ListPaymentsResponse> listPaymentsAsync(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand,
            final Integer limit) {
        try { 
            return prepareListPaymentsRequest(beginTime, endTime, sortOrder, cursor, locationId, total,
            last4, cardBrand, limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listPayments.
     */
    private ApiCall<ListPaymentsResponse, ApiException> prepareListPaymentsRequest(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand,
            final Integer limit) throws IOException {
        return new ApiCall.Builder<ListPaymentsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/payments")
                        .queryParam(param -> param.key("begin_time")
                                .value(beginTime).isRequired(false))
                        .queryParam(param -> param.key("end_time")
                                .value(endTime).isRequired(false))
                        .queryParam(param -> param.key("sort_order")
                                .value(sortOrder).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("location_id")
                                .value(locationId).isRequired(false))
                        .queryParam(param -> param.key("total")
                                .value(total).isRequired(false))
                        .queryParam(param -> param.key("last_4")
                                .value(last4).isRequired(false))
                        .queryParam(param -> param.key("card_brand")
                                .value(cardBrand).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListPaymentsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a payment using the provided source. You can use this endpoint to charge a card
     * (credit/debit card or Square gift card) or record a payment that the seller received outside
     * of Square (cash payment from a buyer or a payment that an external entity processed on behalf
     * of the seller). The endpoint creates a `Payment` object and returns it in the response.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreatePaymentResponse createPayment(
            final CreatePaymentRequest body) throws ApiException, IOException {
        return prepareCreatePaymentRequest(body).execute();
    }

    /**
     * Creates a payment using the provided source. You can use this endpoint to charge a card
     * (credit/debit card or Square gift card) or record a payment that the seller received outside
     * of Square (cash payment from a buyer or a payment that an external entity processed on behalf
     * of the seller). The endpoint creates a `Payment` object and returns it in the response.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentResponse response from the API call
     */
    public CompletableFuture<CreatePaymentResponse> createPaymentAsync(
            final CreatePaymentRequest body) {
        try { 
            return prepareCreatePaymentRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createPayment.
     */
    private ApiCall<CreatePaymentResponse, ApiException> prepareCreatePaymentRequest(
            final CreatePaymentRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreatePaymentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/payments")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreatePaymentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Cancels (voids) a payment identified by the idempotency key that is specified in the request.
     * Use this method when the status of a `CreatePayment` request is unknown (for example, after
     * you send a `CreatePayment` request, a network error occurs and you do not get a response). In
     * this case, you can direct Square to cancel the payment using this endpoint. In the request,
     * you provide the same idempotency key that you provided in your `CreatePayment` request that
     * you want to cancel. After canceling the payment, you can submit your `CreatePayment` request
     * again. Note that if no payment with the specified idempotency key is found, no action is
     * taken and the endpoint returns successfully.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelPaymentByIdempotencyKeyResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelPaymentByIdempotencyKeyResponse cancelPaymentByIdempotencyKey(
            final CancelPaymentByIdempotencyKeyRequest body) throws ApiException, IOException {
        return prepareCancelPaymentByIdempotencyKeyRequest(body).execute();
    }

    /**
     * Cancels (voids) a payment identified by the idempotency key that is specified in the request.
     * Use this method when the status of a `CreatePayment` request is unknown (for example, after
     * you send a `CreatePayment` request, a network error occurs and you do not get a response). In
     * this case, you can direct Square to cancel the payment using this endpoint. In the request,
     * you provide the same idempotency key that you provided in your `CreatePayment` request that
     * you want to cancel. After canceling the payment, you can submit your `CreatePayment` request
     * again. Note that if no payment with the specified idempotency key is found, no action is
     * taken and the endpoint returns successfully.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelPaymentByIdempotencyKeyResponse response from the API call
     */
    public CompletableFuture<CancelPaymentByIdempotencyKeyResponse> cancelPaymentByIdempotencyKeyAsync(
            final CancelPaymentByIdempotencyKeyRequest body) {
        try { 
            return prepareCancelPaymentByIdempotencyKeyRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for cancelPaymentByIdempotencyKey.
     */
    private ApiCall<CancelPaymentByIdempotencyKeyResponse, ApiException> prepareCancelPaymentByIdempotencyKeyRequest(
            final CancelPaymentByIdempotencyKeyRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CancelPaymentByIdempotencyKeyResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/payments/cancel")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CancelPaymentByIdempotencyKeyResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves details for a specific payment.
     * @param  paymentId  Required parameter: A unique ID for the desired payment.
     * @return    Returns the GetPaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetPaymentResponse getPayment(
            final String paymentId) throws ApiException, IOException {
        return prepareGetPaymentRequest(paymentId).execute();
    }

    /**
     * Retrieves details for a specific payment.
     * @param  paymentId  Required parameter: A unique ID for the desired payment.
     * @return    Returns the GetPaymentResponse response from the API call
     */
    public CompletableFuture<GetPaymentResponse> getPaymentAsync(
            final String paymentId) {
        try { 
            return prepareGetPaymentRequest(paymentId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for getPayment.
     */
    private ApiCall<GetPaymentResponse, ApiException> prepareGetPaymentRequest(
            final String paymentId) throws IOException {
        return new ApiCall.Builder<GetPaymentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/payments/{payment_id}")
                        .templateParam(param -> param.key("payment_id").value(paymentId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, GetPaymentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates a payment with the APPROVED status. You can update the `amount_money` and `tip_money`
     * using this endpoint.
     * @param  paymentId  Required parameter: The ID of the payment to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdatePaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdatePaymentResponse updatePayment(
            final String paymentId,
            final UpdatePaymentRequest body) throws ApiException, IOException {
        return prepareUpdatePaymentRequest(paymentId, body).execute();
    }

    /**
     * Updates a payment with the APPROVED status. You can update the `amount_money` and `tip_money`
     * using this endpoint.
     * @param  paymentId  Required parameter: The ID of the payment to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdatePaymentResponse response from the API call
     */
    public CompletableFuture<UpdatePaymentResponse> updatePaymentAsync(
            final String paymentId,
            final UpdatePaymentRequest body) {
        try { 
            return prepareUpdatePaymentRequest(paymentId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updatePayment.
     */
    private ApiCall<UpdatePaymentResponse, ApiException> prepareUpdatePaymentRequest(
            final String paymentId,
            final UpdatePaymentRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdatePaymentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/payments/{payment_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("payment_id").value(paymentId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdatePaymentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Cancels (voids) a payment. You can use this endpoint to cancel a payment with the APPROVED
     * `status`.
     * @param  paymentId  Required parameter: The ID of the payment to cancel.
     * @return    Returns the CancelPaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelPaymentResponse cancelPayment(
            final String paymentId) throws ApiException, IOException {
        return prepareCancelPaymentRequest(paymentId).execute();
    }

    /**
     * Cancels (voids) a payment. You can use this endpoint to cancel a payment with the APPROVED
     * `status`.
     * @param  paymentId  Required parameter: The ID of the payment to cancel.
     * @return    Returns the CancelPaymentResponse response from the API call
     */
    public CompletableFuture<CancelPaymentResponse> cancelPaymentAsync(
            final String paymentId) {
        try { 
            return prepareCancelPaymentRequest(paymentId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for cancelPayment.
     */
    private ApiCall<CancelPaymentResponse, ApiException> prepareCancelPaymentRequest(
            final String paymentId) throws IOException {
        return new ApiCall.Builder<CancelPaymentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/payments/{payment_id}/cancel")
                        .templateParam(param -> param.key("payment_id").value(paymentId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CancelPaymentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Completes (captures) a payment. By default, payments are set to complete immediately after
     * they are created. You can use this endpoint to complete a payment with the APPROVED `status`.
     * @param  paymentId  Required parameter: The unique ID identifying the payment to be completed.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CompletePaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CompletePaymentResponse completePayment(
            final String paymentId,
            final CompletePaymentRequest body) throws ApiException, IOException {
        return prepareCompletePaymentRequest(paymentId, body).execute();
    }

    /**
     * Completes (captures) a payment. By default, payments are set to complete immediately after
     * they are created. You can use this endpoint to complete a payment with the APPROVED `status`.
     * @param  paymentId  Required parameter: The unique ID identifying the payment to be completed.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CompletePaymentResponse response from the API call
     */
    public CompletableFuture<CompletePaymentResponse> completePaymentAsync(
            final String paymentId,
            final CompletePaymentRequest body) {
        try { 
            return prepareCompletePaymentRequest(paymentId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for completePayment.
     */
    private ApiCall<CompletePaymentResponse, ApiException> prepareCompletePaymentRequest(
            final String paymentId,
            final CompletePaymentRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CompletePaymentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/payments/{payment_id}/complete")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("payment_id").value(paymentId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CompletePaymentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}