
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CaptureTransactionResponse;
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
     * Lists transactions for a particular location. Transactions include payment information from
     * sales and exchanges and refund information from returns and exchanges. Max results per
     * [page](https://developer.squareup.com/docs/working-with-apis/pagination): 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list transactions for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date
     *         ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for
     *         details on date inclusivity/exclusivity. Default value: The current time minus one
     *         year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date
     *         ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for
     *         details on date inclusivity/exclusivity. Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating
     *         results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     *         information.
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
     * [page](https://developer.squareup.com/docs/working-with-apis/pagination): 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list transactions for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date
     *         ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for
     *         details on date inclusivity/exclusivity. Default value: The current time minus one
     *         year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date
     *         ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for
     *         details on date inclusivity/exclusivity. Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating
     *         results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     *         information.
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
     * Captures a transaction that was created with the [Charge]($e/Transactions/Charge) endpoint
     * with a `delay_capture` value of `true`. See [Delayed capture
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
     * Captures a transaction that was created with the [Charge]($e/Transactions/Charge) endpoint
     * with a `delay_capture` value of `true`. See [Delayed capture
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
     * Cancels a transaction that was created with the [Charge]($e/Transactions/Charge) endpoint
     * with a `delay_capture` value of `true`. See [Delayed capture
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
     * Cancels a transaction that was created with the [Charge]($e/Transactions/Charge) endpoint
     * with a `delay_capture` value of `true`. See [Delayed capture
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