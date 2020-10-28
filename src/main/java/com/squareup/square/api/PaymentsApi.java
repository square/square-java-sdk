
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CancelPaymentByIdempotencyKeyRequest;
import com.squareup.square.models.CancelPaymentByIdempotencyKeyResponse;
import com.squareup.square.models.CancelPaymentResponse;
import com.squareup.square.models.CompletePaymentResponse;
import com.squareup.square.models.CreatePaymentRequest;
import com.squareup.square.models.CreatePaymentResponse;
import com.squareup.square.models.GetPaymentResponse;
import com.squareup.square.models.ListPaymentsResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface PaymentsApi {
    /**
     * Retrieves a list of payments taken by the account making the request. The maximum results per
     * page is 100.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the reporting
     *         period, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the reporting period, in
     *         RFC 3339 format. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed: - `ASC` -
     *         Oldest to newest. - `DESC` - Newest to oldest (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
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
    ListPaymentsResponse listPayments(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand,
            final Integer limit) throws ApiException, IOException;

    /**
     * Retrieves a list of payments taken by the account making the request. The maximum results per
     * page is 100.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the reporting
     *         period, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the reporting period, in
     *         RFC 3339 format. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed: - `ASC` -
     *         Oldest to newest. - `DESC` - Newest to oldest (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
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
    CompletableFuture<ListPaymentsResponse> listPaymentsAsync(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final Long total,
            final String last4,
            final String cardBrand,
            final Integer limit);

    /**
     * Charges a payment source (for example, a card represented by customer's card on file or a
     * card nonce). In addition to the payment source, the request must include the amount to accept
     * for the payment. There are several optional parameters that you can include in the request
     * (for example, tip money, whether to autocomplete the payment, or a reference ID to correlate
     * this payment with another system). The `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth
     * permission is required to enable application fees.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreatePaymentResponse createPayment(
            final CreatePaymentRequest body) throws ApiException, IOException;

    /**
     * Charges a payment source (for example, a card represented by customer's card on file or a
     * card nonce). In addition to the payment source, the request must include the amount to accept
     * for the payment. There are several optional parameters that you can include in the request
     * (for example, tip money, whether to autocomplete the payment, or a reference ID to correlate
     * this payment with another system). The `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth
     * permission is required to enable application fees.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentResponse response from the API call
     */
    CompletableFuture<CreatePaymentResponse> createPaymentAsync(
            final CreatePaymentRequest body);

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
    CancelPaymentByIdempotencyKeyResponse cancelPaymentByIdempotencyKey(
            final CancelPaymentByIdempotencyKeyRequest body) throws ApiException, IOException;

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
    CompletableFuture<CancelPaymentByIdempotencyKeyResponse> cancelPaymentByIdempotencyKeyAsync(
            final CancelPaymentByIdempotencyKeyRequest body);

    /**
     * Retrieves details for a specific payment.
     * @param  paymentId  Required parameter: A unique ID for the desired payment.
     * @return    Returns the GetPaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetPaymentResponse getPayment(
            final String paymentId) throws ApiException, IOException;

    /**
     * Retrieves details for a specific payment.
     * @param  paymentId  Required parameter: A unique ID for the desired payment.
     * @return    Returns the GetPaymentResponse response from the API call
     */
    CompletableFuture<GetPaymentResponse> getPaymentAsync(
            final String paymentId);

    /**
     * Cancels (voids) a payment. If you set `autocomplete` to `false` when creating a payment, you
     * can cancel the payment using this endpoint.
     * @param  paymentId  Required parameter: The `payment_id` identifying the payment to be
     *         canceled.
     * @return    Returns the CancelPaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelPaymentResponse cancelPayment(
            final String paymentId) throws ApiException, IOException;

    /**
     * Cancels (voids) a payment. If you set `autocomplete` to `false` when creating a payment, you
     * can cancel the payment using this endpoint.
     * @param  paymentId  Required parameter: The `payment_id` identifying the payment to be
     *         canceled.
     * @return    Returns the CancelPaymentResponse response from the API call
     */
    CompletableFuture<CancelPaymentResponse> cancelPaymentAsync(
            final String paymentId);

    /**
     * Completes (captures) a payment. By default, payments are set to complete immediately after
     * they are created. If you set `autocomplete` to `false` when creating a payment, you can
     * complete (capture) the payment using this endpoint.
     * @param  paymentId  Required parameter: The unique ID identifying the payment to be completed.
     * @return    Returns the CompletePaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CompletePaymentResponse completePayment(
            final String paymentId) throws ApiException, IOException;

    /**
     * Completes (captures) a payment. By default, payments are set to complete immediately after
     * they are created. If you set `autocomplete` to `false` when creating a payment, you can
     * complete (capture) the payment using this endpoint.
     * @param  paymentId  Required parameter: The unique ID identifying the payment to be completed.
     * @return    Returns the CompletePaymentResponse response from the API call
     */
    CompletableFuture<CompletePaymentResponse> completePaymentAsync(
            final String paymentId);

}