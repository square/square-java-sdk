
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CancelInvoiceRequest;
import com.squareup.square.models.CancelInvoiceResponse;
import com.squareup.square.models.CreateInvoiceRequest;
import com.squareup.square.models.CreateInvoiceResponse;
import com.squareup.square.models.DeleteInvoiceResponse;
import com.squareup.square.models.GetInvoiceResponse;
import com.squareup.square.models.ListInvoicesResponse;
import com.squareup.square.models.PublishInvoiceRequest;
import com.squareup.square.models.PublishInvoiceResponse;
import com.squareup.square.models.SearchInvoicesRequest;
import com.squareup.square.models.SearchInvoicesResponse;
import com.squareup.square.models.UpdateInvoiceRequest;
import com.squareup.square.models.UpdateInvoiceResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface InvoicesApi {
    /**
     * Returns a list of invoices for a given location. The response is paginated. If truncated, the
     * response includes a `cursor` that you use in a subsequent request to fetch the next set of
     * invoices.
     * @param  locationId  Required parameter: The ID of the location for which to list invoices.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of invoices to return (200 is the
     *         maximum `limit`). If not provided, the server uses a default limit of 100 invoices.
     * @return    Returns the ListInvoicesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListInvoicesResponse listInvoices(
            final String locationId,
            final String cursor,
            final Integer limit) throws ApiException, IOException;

    /**
     * Returns a list of invoices for a given location. The response is paginated. If truncated, the
     * response includes a `cursor` that you use in a subsequent request to fetch the next set of
     * invoices.
     * @param  locationId  Required parameter: The ID of the location for which to list invoices.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of invoices to return (200 is the
     *         maximum `limit`). If not provided, the server uses a default limit of 100 invoices.
     * @return    Returns the ListInvoicesResponse response from the API call
     */
    CompletableFuture<ListInvoicesResponse> listInvoicesAsync(
            final String locationId,
            final String cursor,
            final Integer limit);

    /**
     * Creates a draft [invoice](#type-invoice) for an order created using the Orders API. A draft
     * invoice remains in your account and no action is taken. You must publish the invoice before
     * Square can process it (send it to the customer's email address or charge the customer’s card
     * on file).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateInvoiceResponse createInvoice(
            final CreateInvoiceRequest body) throws ApiException, IOException;

    /**
     * Creates a draft [invoice](#type-invoice) for an order created using the Orders API. A draft
     * invoice remains in your account and no action is taken. You must publish the invoice before
     * Square can process it (send it to the customer's email address or charge the customer’s card
     * on file).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateInvoiceResponse response from the API call
     */
    CompletableFuture<CreateInvoiceResponse> createInvoiceAsync(
            final CreateInvoiceRequest body);

    /**
     * Searches for invoices from a location specified in the filter. You can optionally specify
     * customers in the filter for whom to retrieve invoices. In the current implementation, you can
     * only specify one location and optionally one customer. The response is paginated. If
     * truncated, the response includes a `cursor` that you use in a subsequent request to fetch the
     * next set of invoices.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchInvoicesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchInvoicesResponse searchInvoices(
            final SearchInvoicesRequest body) throws ApiException, IOException;

    /**
     * Searches for invoices from a location specified in the filter. You can optionally specify
     * customers in the filter for whom to retrieve invoices. In the current implementation, you can
     * only specify one location and optionally one customer. The response is paginated. If
     * truncated, the response includes a `cursor` that you use in a subsequent request to fetch the
     * next set of invoices.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchInvoicesResponse response from the API call
     */
    CompletableFuture<SearchInvoicesResponse> searchInvoicesAsync(
            final SearchInvoicesRequest body);

    /**
     * Deletes the specified invoice. When an invoice is deleted, the associated Order status
     * changes to CANCELED. You can only delete a draft invoice (you cannot delete a published
     * invoice, including one that is scheduled for processing).
     * @param  invoiceId  Required parameter: The ID of the invoice to delete.
     * @param  version  Optional parameter: The version of the [invoice](#type-invoice) to delete.
     *         If you do not know the version, you can call
     *         [GetInvoice](#endpoint-Invoices-GetInvoice) or
     *         [ListInvoices](#endpoint-Invoices-ListInvoices).
     * @return    Returns the DeleteInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteInvoiceResponse deleteInvoice(
            final String invoiceId,
            final Integer version) throws ApiException, IOException;

    /**
     * Deletes the specified invoice. When an invoice is deleted, the associated Order status
     * changes to CANCELED. You can only delete a draft invoice (you cannot delete a published
     * invoice, including one that is scheduled for processing).
     * @param  invoiceId  Required parameter: The ID of the invoice to delete.
     * @param  version  Optional parameter: The version of the [invoice](#type-invoice) to delete.
     *         If you do not know the version, you can call
     *         [GetInvoice](#endpoint-Invoices-GetInvoice) or
     *         [ListInvoices](#endpoint-Invoices-ListInvoices).
     * @return    Returns the DeleteInvoiceResponse response from the API call
     */
    CompletableFuture<DeleteInvoiceResponse> deleteInvoiceAsync(
            final String invoiceId,
            final Integer version);

    /**
     * Retrieves an invoice by invoice ID.
     * @param  invoiceId  Required parameter: The id of the invoice to retrieve.
     * @return    Returns the GetInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetInvoiceResponse getInvoice(
            final String invoiceId) throws ApiException, IOException;

    /**
     * Retrieves an invoice by invoice ID.
     * @param  invoiceId  Required parameter: The id of the invoice to retrieve.
     * @return    Returns the GetInvoiceResponse response from the API call
     */
    CompletableFuture<GetInvoiceResponse> getInvoiceAsync(
            final String invoiceId);

    /**
     * Updates an invoice by modifying fields, clearing fields, or both. For most updates, you can
     * use a sparse `Invoice` object to add fields or change values, and use the `fields_to_clear`
     * field to specify fields to clear. However, some restrictions apply. For example, you cannot
     * change the `order_id` or `location_id` field, and you must provide the complete
     * `custom_fields` list to update a custom field. Published invoices have additional
     * restrictions.
     * @param  invoiceId  Required parameter: The ID of the invoice to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateInvoiceResponse updateInvoice(
            final String invoiceId,
            final UpdateInvoiceRequest body) throws ApiException, IOException;

    /**
     * Updates an invoice by modifying fields, clearing fields, or both. For most updates, you can
     * use a sparse `Invoice` object to add fields or change values, and use the `fields_to_clear`
     * field to specify fields to clear. However, some restrictions apply. For example, you cannot
     * change the `order_id` or `location_id` field, and you must provide the complete
     * `custom_fields` list to update a custom field. Published invoices have additional
     * restrictions.
     * @param  invoiceId  Required parameter: The ID of the invoice to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateInvoiceResponse response from the API call
     */
    CompletableFuture<UpdateInvoiceResponse> updateInvoiceAsync(
            final String invoiceId,
            final UpdateInvoiceRequest body);

    /**
     * Cancels an invoice. The seller cannot collect payments for the canceled invoice. You cannot
     * cancel an invoice in the `DRAFT` state or in a terminal state: `PAID`, `REFUNDED`,
     * `CANCELED`, or `FAILED`.
     * @param  invoiceId  Required parameter: The ID of the [invoice](#type-invoice) to cancel.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelInvoiceResponse cancelInvoice(
            final String invoiceId,
            final CancelInvoiceRequest body) throws ApiException, IOException;

    /**
     * Cancels an invoice. The seller cannot collect payments for the canceled invoice. You cannot
     * cancel an invoice in the `DRAFT` state or in a terminal state: `PAID`, `REFUNDED`,
     * `CANCELED`, or `FAILED`.
     * @param  invoiceId  Required parameter: The ID of the [invoice](#type-invoice) to cancel.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelInvoiceResponse response from the API call
     */
    CompletableFuture<CancelInvoiceResponse> cancelInvoiceAsync(
            final String invoiceId,
            final CancelInvoiceRequest body);

    /**
     * Publishes the specified draft invoice. After an invoice is published, Square follows up based
     * on the invoice configuration. For example, Square sends the invoice to the customer's email
     * address, charges the customer's card on file, or does nothing. Square also makes the invoice
     * available on a Square-hosted invoice page. The invoice `status` also changes from `DRAFT` to
     * a status based on the invoice configuration. For example, the status changes to `UNPAID` if
     * Square emails the invoice or `PARTIALLY_PAID` if Square charge a card on file for a portion
     * of the invoice amount).
     * @param  invoiceId  Required parameter: The id of the invoice to publish.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PublishInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    PublishInvoiceResponse publishInvoice(
            final String invoiceId,
            final PublishInvoiceRequest body) throws ApiException, IOException;

    /**
     * Publishes the specified draft invoice. After an invoice is published, Square follows up based
     * on the invoice configuration. For example, Square sends the invoice to the customer's email
     * address, charges the customer's card on file, or does nothing. Square also makes the invoice
     * available on a Square-hosted invoice page. The invoice `status` also changes from `DRAFT` to
     * a status based on the invoice configuration. For example, the status changes to `UNPAID` if
     * Square emails the invoice or `PARTIALLY_PAID` if Square charge a card on file for a portion
     * of the invoice amount).
     * @param  invoiceId  Required parameter: The id of the invoice to publish.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PublishInvoiceResponse response from the API call
     */
    CompletableFuture<PublishInvoiceResponse> publishInvoiceAsync(
            final String invoiceId,
            final PublishInvoiceRequest body);

}