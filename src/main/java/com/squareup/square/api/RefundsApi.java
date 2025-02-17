
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.GetPaymentRefundResponse;
import com.squareup.square.models.ListPaymentRefundsResponse;
import com.squareup.square.models.RefundPaymentRequest;
import com.squareup.square.models.RefundPaymentResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface RefundsApi {
    /**
     * Retrieves a list of refunds for the account making the request. Results are eventually
     * consistent, and new refunds or changes to refunds might take several seconds to appear. The
     * maximum results per page is 100.
     * @param  beginTime  Optional parameter: Indicates the start of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `created_at` field for each `PaymentRefund`. Default: The current time minus one
     *         year.
     * @param  endTime  Optional parameter: Indicates the end of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `created_at` field for each `PaymentRefund`. Default: The current time.
     * @param  updatedAtBeginTime  Optional parameter: Indicates the start of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `updated_at` field for each `PaymentRefund`. Default: if omitted, the time range starts at `beginTime`.
     * @param  updatedAtEndTime  Optional parameter: Indicates the end of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `updated_at` field for each `PaymentRefund`. Default: The current time.
     * @param  sortField  Optional parameter: The field used to sort results by. The default is `CREATED_AT`.
     *         Current values include `CREATED_AT` and `UPDATED_AT`.
     * @param  sortOrder  Optional parameter: The order in which results are listed by
     *         `PaymentRefund.created_at`: - `ASC` - Oldest to newest. - `DESC` - Newest to oldest
     *         (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  locationId  Optional parameter: Limit results to the location supplied. By default,
     *         results are returned for all locations associated with the seller.
     * @param  status  Optional parameter: If provided, only refunds with the given status are
     *         returned. For a list of refund status values, see
     *         [PaymentRefund](entity:PaymentRefund). Default: If omitted, refunds are returned
     *         regardless of their status.
     * @param  sourceType  Optional parameter: If provided, only returns refunds whose payments have
     *         the indicated source type. Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`,
     *         `CASH`, and `EXTERNAL`. For information about these payment source types, see [Take
     *         Payments](https://developer.squareup.com/docs/payments-api/take-payments). Default:
     *         If omitted, refunds are returned regardless of the source type.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. If the supplied value is greater than 100, no more than 100 results are
     *         returned. Default: 100
     * @return    Returns the ListPaymentRefundsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListPaymentRefundsResponse listPaymentRefunds(
            final String beginTime,
            final String endTime,
            final String updatedAtBeginTime,
            final String updatedAtEndTime,
            final String sortField,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType,
            final Integer limit) throws ApiException, IOException;

    /**
     * Retrieves a list of refunds for the account making the request. Results are eventually
     * consistent, and new refunds or changes to refunds might take several seconds to appear. The
     * maximum results per page is 100.
     * @param  beginTime  Optional parameter: Indicates the start of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `created_at` field for each `PaymentRefund`. Default: The current time minus one
     *         year.
     * @param  endTime  Optional parameter: Indicates the end of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `created_at` field for each `PaymentRefund`. Default: The current time.
     * @param  updatedAtBeginTime  Optional parameter: Indicates the start of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `updated_at` field for each `PaymentRefund`. Default: if omitted, the time range starts at `beginTime`.
     * @param  updatedAtEndTime  Optional parameter: Indicates the end of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `updated_at` field for each `PaymentRefund`. Default: The current time.
     * @param  sortField  Optional parameter: The field used to sort results by. The default is `CREATED_AT`.
     *         Current values include `CREATED_AT` and `UPDATED_AT`.
     * @param  sortOrder  Optional parameter: The order in which results are listed by
     *         `PaymentRefund.created_at`: - `ASC` - Oldest to newest. - `DESC` - Newest to oldest
     *         (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  locationId  Optional parameter: Limit results to the location supplied. By default,
     *         results are returned for all locations associated with the seller.
     * @param  status  Optional parameter: If provided, only refunds with the given status are
     *         returned. For a list of refund status values, see
     *         [PaymentRefund](entity:PaymentRefund). Default: If omitted, refunds are returned
     *         regardless of their status.
     * @param  sourceType  Optional parameter: If provided, only returns refunds whose payments have
     *         the indicated source type. Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`,
     *         `CASH`, and `EXTERNAL`. For information about these payment source types, see [Take
     *         Payments](https://developer.squareup.com/docs/payments-api/take-payments). Default:
     *         If omitted, refunds are returned regardless of the source type.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. If the supplied value is greater than 100, no more than 100 results are
     *         returned. Default: 100
     * @return    Returns the ListPaymentRefundsResponse response from the API call
     */
    CompletableFuture<ListPaymentRefundsResponse> listPaymentRefundsAsync(
            final String beginTime,
            final String endTime,
            final String updatedAtBeginTime,
            final String updatedAtEndTime,
            final String sortField,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType,
            final Integer limit);

    /**
     * Refunds a payment. You can refund the entire payment amount or a portion of it. You can use
     * this endpoint to refund a card payment or record a refund of a cash or external payment. For
     * more information, see [Refund
     * Payment](https://developer.squareup.com/docs/payments-api/refund-payments).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RefundPaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RefundPaymentResponse refundPayment(
            final RefundPaymentRequest body) throws ApiException, IOException;

    /**
     * Refunds a payment. You can refund the entire payment amount or a portion of it. You can use
     * this endpoint to refund a card payment or record a refund of a cash or external payment. For
     * more information, see [Refund
     * Payment](https://developer.squareup.com/docs/payments-api/refund-payments).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RefundPaymentResponse response from the API call
     */
    CompletableFuture<RefundPaymentResponse> refundPaymentAsync(
            final RefundPaymentRequest body);

    /**
     * Retrieves a specific refund using the `refund_id`.
     * @param  refundId  Required parameter: The unique ID for the desired `PaymentRefund`.
     * @return    Returns the GetPaymentRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetPaymentRefundResponse getPaymentRefund(
            final String refundId) throws ApiException, IOException;

    /**
     * Retrieves a specific refund using the `refund_id`.
     * @param  refundId  Required parameter: The unique ID for the desired `PaymentRefund`.
     * @return    Returns the GetPaymentRefundResponse response from the API call
     */
    CompletableFuture<GetPaymentRefundResponse> getPaymentRefundAsync(
            final String refundId);

}