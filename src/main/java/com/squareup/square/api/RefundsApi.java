package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.GetPaymentRefundResponse;
import com.squareup.square.models.ListPaymentRefundsResponse;
import com.squareup.square.models.RefundPaymentRequest;
import com.squareup.square.models.RefundPaymentResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface RefundsApi {
    /**
     * Retrieves a list of refunds for the account making the request.
     * Max results per page: 100
     * @param    beginTime    Optional parameter: Timestamp for the beginning of the requested reporting period, in RFC 3339 format.  Default: The current time minus one year.
     * @param    endTime    Optional parameter: Timestamp for the end of the requested reporting period, in RFC 3339 format.  Default: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed. - `ASC` - oldest to newest - `DESC` - newest to oldest (default).
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    locationId    Optional parameter: ID of location associated with payment.
     * @param    status    Optional parameter: If provided, only refunds with the given status are returned. For a list of refund status values, see [PaymentRefund](#type-paymentrefund).  Default: If omitted refunds are returned regardless of status.
     * @param    sourceType    Optional parameter: If provided, only refunds with the given source type are returned. - `CARD` - List refunds only for payments where card was specified as payment source.  Default: If omitted refunds are returned regardless of source type.
     * @return    Returns the ListPaymentRefundsResponse response from the API call
     */
    ListPaymentRefundsResponse listPaymentRefunds(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType) throws ApiException, IOException;

    /**
     * Retrieves a list of refunds for the account making the request.
     * Max results per page: 100
     * @param    beginTime    Optional parameter: Timestamp for the beginning of the requested reporting period, in RFC 3339 format.  Default: The current time minus one year.
     * @param    endTime    Optional parameter: Timestamp for the end of the requested reporting period, in RFC 3339 format.  Default: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed. - `ASC` - oldest to newest - `DESC` - newest to oldest (default).
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    locationId    Optional parameter: ID of location associated with payment.
     * @param    status    Optional parameter: If provided, only refunds with the given status are returned. For a list of refund status values, see [PaymentRefund](#type-paymentrefund).  Default: If omitted refunds are returned regardless of status.
     * @param    sourceType    Optional parameter: If provided, only refunds with the given source type are returned. - `CARD` - List refunds only for payments where card was specified as payment source.  Default: If omitted refunds are returned regardless of source type.
     * @return    Returns the ListPaymentRefundsResponse response from the API call 
     */
    CompletableFuture<ListPaymentRefundsResponse> listPaymentRefundsAsync(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType);

    /**
     * Refunds a payment. You can refund the entire payment amount or a 
     * portion of it. For more information, see 
     * [Payments and Refunds Overview](https://developer.squareup.com/docs/payments-api/overview).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the RefundPaymentResponse response from the API call
     */
    RefundPaymentResponse refundPayment(
            final RefundPaymentRequest body) throws ApiException, IOException;

    /**
     * Refunds a payment. You can refund the entire payment amount or a 
     * portion of it. For more information, see 
     * [Payments and Refunds Overview](https://developer.squareup.com/docs/payments-api/overview).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the RefundPaymentResponse response from the API call 
     */
    CompletableFuture<RefundPaymentResponse> refundPaymentAsync(
            final RefundPaymentRequest body);

    /**
     * Retrieves a specific `Refund` using the `refund_id`.
     * @param    refundId    Required parameter: Unique ID for the desired `PaymentRefund`.
     * @return    Returns the GetPaymentRefundResponse response from the API call
     */
    GetPaymentRefundResponse getPaymentRefund(
            final String refundId) throws ApiException, IOException;

    /**
     * Retrieves a specific `Refund` using the `refund_id`.
     * @param    refundId    Required parameter: Unique ID for the desired `PaymentRefund`.
     * @return    Returns the GetPaymentRefundResponse response from the API call 
     */
    CompletableFuture<GetPaymentRefundResponse> getPaymentRefundAsync(
            final String refundId);

}