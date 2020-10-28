
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CaptureTransactionResponse;
import com.squareup.square.models.ChargeRequest;
import com.squareup.square.models.ChargeResponse;
import com.squareup.square.models.CreateRefundRequest;
import com.squareup.square.models.CreateRefundResponse;
import com.squareup.square.models.ListRefundsResponse;
import com.squareup.square.models.ListTransactionsResponse;
import com.squareup.square.models.RetrieveTransactionResponse;
import com.squareup.square.models.VoidTransactionResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface TransactionsApi {
    /**
     * Lists refunds for one of a business's locations. In addition to full or partial tender
     * refunds processed through Square APIs, refunds may result from itemized returns or exchanges
     * through Square's Point of Sale applications. Refunds with a `status` of `PENDING` are not
     * currently included in this endpoint's response. Max results per [page](#paginatingresults):
     * 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list refunds for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date ranges](#dateranges) for details on date
     *         inclusivity/exclusivity. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     *         Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListRefundsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    ListRefundsResponse listRefunds(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) throws ApiException, IOException;

    /**
     * Lists refunds for one of a business's locations. In addition to full or partial tender
     * refunds processed through Square APIs, refunds may result from itemized returns or exchanges
     * through Square's Point of Sale applications. Refunds with a `status` of `PENDING` are not
     * currently included in this endpoint's response. Max results per [page](#paginatingresults):
     * 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list refunds for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date ranges](#dateranges) for details on date
     *         inclusivity/exclusivity. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     *         Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListRefundsResponse response from the API call
     */
    @Deprecated
    CompletableFuture<ListRefundsResponse> listRefundsAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor);

    /**
     * Lists transactions for a particular location. Transactions include payment information from
     * sales and exchanges and refund information from returns and exchanges. Max results per
     * [page](#paginatingresults): 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list transactions for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date ranges](#dateranges) for details on date
     *         inclusivity/exclusivity. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     *         Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListTransactionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    ListTransactionsResponse listTransactions(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) throws ApiException, IOException;

    /**
     * Lists transactions for a particular location. Transactions include payment information from
     * sales and exchanges and refund information from returns and exchanges. Max results per
     * [page](#paginatingresults): 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list transactions for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date ranges](#dateranges) for details on date
     *         inclusivity/exclusivity. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     *         Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListTransactionsResponse response from the API call
     */
    @Deprecated
    CompletableFuture<ListTransactionsResponse> listTransactionsAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor);

    /**
     * Charges a card represented by a card nonce or a customer's card on file. Your request to this
     * endpoint must include _either_: - A value for the `card_nonce` parameter (to charge a card
     * nonce generated with the `SqPaymentForm`) - Values for the `customer_card_id` and
     * `customer_id` parameters (to charge a customer's card on file) In order for an eCommerce
     * payment to potentially qualify for [Square chargeback
     * protection](https://squareup.com/help/article/5394), you _must_ provide values for the
     * following parameters in your request: - `buyer_email_address` - At least one of
     * `billing_address` or `shipping_address` When this response is returned, the amount of
     * Square's processing fee might not yet be calculated. To obtain the processing fee, wait about
     * ten seconds and call [RetrieveTransaction](#endpoint-retrievetransaction). See the
     * `processing_fee_money` field of each [Tender included](#type-tender) in the transaction.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to associate the created
     *         transaction with.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ChargeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    ChargeResponse charge(
            final String locationId,
            final ChargeRequest body) throws ApiException, IOException;

    /**
     * Charges a card represented by a card nonce or a customer's card on file. Your request to this
     * endpoint must include _either_: - A value for the `card_nonce` parameter (to charge a card
     * nonce generated with the `SqPaymentForm`) - Values for the `customer_card_id` and
     * `customer_id` parameters (to charge a customer's card on file) In order for an eCommerce
     * payment to potentially qualify for [Square chargeback
     * protection](https://squareup.com/help/article/5394), you _must_ provide values for the
     * following parameters in your request: - `buyer_email_address` - At least one of
     * `billing_address` or `shipping_address` When this response is returned, the amount of
     * Square's processing fee might not yet be calculated. To obtain the processing fee, wait about
     * ten seconds and call [RetrieveTransaction](#endpoint-retrievetransaction). See the
     * `processing_fee_money` field of each [Tender included](#type-tender) in the transaction.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to associate the created
     *         transaction with.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ChargeResponse response from the API call
     */
    @Deprecated
    CompletableFuture<ChargeResponse> chargeAsync(
            final String locationId,
            final ChargeRequest body);

    /**
     * Retrieves details for a single transaction.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the transaction's associated location.
     * @param  transactionId  Required parameter: The ID of the transaction to retrieve.
     * @return    Returns the RetrieveTransactionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    RetrieveTransactionResponse retrieveTransaction(
            final String locationId,
            final String transactionId) throws ApiException, IOException;

    /**
     * Retrieves details for a single transaction.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the transaction's associated location.
     * @param  transactionId  Required parameter: The ID of the transaction to retrieve.
     * @return    Returns the RetrieveTransactionResponse response from the API call
     */
    @Deprecated
    CompletableFuture<RetrieveTransactionResponse> retrieveTransactionAsync(
            final String locationId,
            final String transactionId);

    /**
     * Captures a transaction that was created with the [Charge](#endpoint-charge) endpoint with a
     * `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the CaptureTransactionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    CaptureTransactionResponse captureTransaction(
            final String locationId,
            final String transactionId) throws ApiException, IOException;

    /**
     * Captures a transaction that was created with the [Charge](#endpoint-charge) endpoint with a
     * `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the CaptureTransactionResponse response from the API call
     */
    @Deprecated
    CompletableFuture<CaptureTransactionResponse> captureTransactionAsync(
            final String locationId,
            final String transactionId);

    /**
     * Initiates a refund for a previously charged tender. You must issue a refund within 120 days
     * of the associated payment. See [this article](https://squareup.com/help/us/en/article/5060)
     * for more information on refund behavior. NOTE: Card-present transactions with Interac credit
     * cards **cannot be refunded using the Connect API**. Interac transactions must refunded
     * in-person (e.g., dipping the card using POS app).
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the original transaction's associated
     *         location.
     * @param  transactionId  Required parameter: The ID of the original transaction that includes
     *         the tender to refund.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    CreateRefundResponse createRefund(
            final String locationId,
            final String transactionId,
            final CreateRefundRequest body) throws ApiException, IOException;

    /**
     * Initiates a refund for a previously charged tender. You must issue a refund within 120 days
     * of the associated payment. See [this article](https://squareup.com/help/us/en/article/5060)
     * for more information on refund behavior. NOTE: Card-present transactions with Interac credit
     * cards **cannot be refunded using the Connect API**. Interac transactions must refunded
     * in-person (e.g., dipping the card using POS app).
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the original transaction's associated
     *         location.
     * @param  transactionId  Required parameter: The ID of the original transaction that includes
     *         the tender to refund.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateRefundResponse response from the API call
     */
    @Deprecated
    CompletableFuture<CreateRefundResponse> createRefundAsync(
            final String locationId,
            final String transactionId,
            final CreateRefundRequest body);

    /**
     * Cancels a transaction that was created with the [Charge](#endpoint-charge) endpoint with a
     * `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the VoidTransactionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    VoidTransactionResponse voidTransaction(
            final String locationId,
            final String transactionId) throws ApiException, IOException;

    /**
     * Cancels a transaction that was created with the [Charge](#endpoint-charge) endpoint with a
     * `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the VoidTransactionResponse response from the API call
     */
    @Deprecated
    CompletableFuture<VoidTransactionResponse> voidTransactionAsync(
            final String locationId,
            final String transactionId);

}