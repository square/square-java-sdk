package com.squareup.square.legacy.api;

import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.CancelInvoiceRequest;
import com.squareup.square.legacy.models.CancelInvoiceResponse;
import com.squareup.square.legacy.models.CreateInvoiceAttachmentRequest;
import com.squareup.square.legacy.models.CreateInvoiceAttachmentResponse;
import com.squareup.square.legacy.models.CreateInvoiceRequest;
import com.squareup.square.legacy.models.CreateInvoiceResponse;
import com.squareup.square.legacy.models.DeleteInvoiceAttachmentResponse;
import com.squareup.square.legacy.models.DeleteInvoiceResponse;
import com.squareup.square.legacy.models.GetInvoiceResponse;
import com.squareup.square.legacy.models.ListInvoicesResponse;
import com.squareup.square.legacy.models.PublishInvoiceRequest;
import com.squareup.square.legacy.models.PublishInvoiceResponse;
import com.squareup.square.legacy.models.SearchInvoicesRequest;
import com.squareup.square.legacy.models.SearchInvoicesResponse;
import com.squareup.square.legacy.models.UpdateInvoiceRequest;
import com.squareup.square.legacy.models.UpdateInvoiceResponse;
import com.squareup.square.legacy.utilities.FileWrapper;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface InvoicesApi {
    /**
     * Returns a list of invoices for a given location. The response is paginated. If truncated, the
     * response includes a `cursor` that you use in a subsequent request to retrieve the next set of
     * invoices.
     * @param  locationId  Required parameter: The ID of the location for which to list invoices.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The maximum number of invoices to return (200 is the
     *         maximum `limit`). If not provided, the server uses a default limit of 100 invoices.
     * @return    Returns the ListInvoicesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListInvoicesResponse listInvoices(final String locationId, final String cursor, final Integer limit)
            throws ApiException, IOException;

    /**
     * Returns a list of invoices for a given location. The response is paginated. If truncated, the
     * response includes a `cursor` that you use in a subsequent request to retrieve the next set of
     * invoices.
     * @param  locationId  Required parameter: The ID of the location for which to list invoices.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The maximum number of invoices to return (200 is the
     *         maximum `limit`). If not provided, the server uses a default limit of 100 invoices.
     * @return    Returns the ListInvoicesResponse response from the API call
     */
    CompletableFuture<ListInvoicesResponse> listInvoicesAsync(
            final String locationId, final String cursor, final Integer limit);

    /**
     * Creates a draft [invoice]($m/Invoice) for an order created using the Orders API. A draft
     * invoice remains in your account and no action is taken. You must publish the invoice before
     * Square can process it (send it to the customer's email address or charge the customer’s card
     * on file).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateInvoiceResponse createInvoice(final CreateInvoiceRequest body) throws ApiException, IOException;

    /**
     * Creates a draft [invoice]($m/Invoice) for an order created using the Orders API. A draft
     * invoice remains in your account and no action is taken. You must publish the invoice before
     * Square can process it (send it to the customer's email address or charge the customer’s card
     * on file).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateInvoiceResponse response from the API call
     */
    CompletableFuture<CreateInvoiceResponse> createInvoiceAsync(final CreateInvoiceRequest body);

    /**
     * Searches for invoices from a location specified in the filter. You can optionally specify
     * customers in the filter for whom to retrieve invoices. In the current implementation, you can
     * only specify one location and optionally one customer. The response is paginated. If
     * truncated, the response includes a `cursor` that you use in a subsequent request to retrieve
     * the next set of invoices.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchInvoicesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchInvoicesResponse searchInvoices(final SearchInvoicesRequest body) throws ApiException, IOException;

    /**
     * Searches for invoices from a location specified in the filter. You can optionally specify
     * customers in the filter for whom to retrieve invoices. In the current implementation, you can
     * only specify one location and optionally one customer. The response is paginated. If
     * truncated, the response includes a `cursor` that you use in a subsequent request to retrieve
     * the next set of invoices.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchInvoicesResponse response from the API call
     */
    CompletableFuture<SearchInvoicesResponse> searchInvoicesAsync(final SearchInvoicesRequest body);

    /**
     * Deletes the specified invoice. When an invoice is deleted, the associated order status
     * changes to CANCELED. You can only delete a draft invoice (you cannot delete a published
     * invoice, including one that is scheduled for processing).
     * @param  invoiceId  Required parameter: The ID of the invoice to delete.
     * @param  version  Optional parameter: The version of the [invoice](entity:Invoice) to delete.
     *         If you do not know the version, you can call
     *         [GetInvoice](api-endpoint:Invoices-GetInvoice) or
     *         [ListInvoices](api-endpoint:Invoices-ListInvoices).
     * @return    Returns the DeleteInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteInvoiceResponse deleteInvoice(final String invoiceId, final Integer version) throws ApiException, IOException;

    /**
     * Deletes the specified invoice. When an invoice is deleted, the associated order status
     * changes to CANCELED. You can only delete a draft invoice (you cannot delete a published
     * invoice, including one that is scheduled for processing).
     * @param  invoiceId  Required parameter: The ID of the invoice to delete.
     * @param  version  Optional parameter: The version of the [invoice](entity:Invoice) to delete.
     *         If you do not know the version, you can call
     *         [GetInvoice](api-endpoint:Invoices-GetInvoice) or
     *         [ListInvoices](api-endpoint:Invoices-ListInvoices).
     * @return    Returns the DeleteInvoiceResponse response from the API call
     */
    CompletableFuture<DeleteInvoiceResponse> deleteInvoiceAsync(final String invoiceId, final Integer version);

    /**
     * Retrieves an invoice by invoice ID.
     * @param  invoiceId  Required parameter: The ID of the invoice to retrieve.
     * @return    Returns the GetInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetInvoiceResponse getInvoice(final String invoiceId) throws ApiException, IOException;

    /**
     * Retrieves an invoice by invoice ID.
     * @param  invoiceId  Required parameter: The ID of the invoice to retrieve.
     * @return    Returns the GetInvoiceResponse response from the API call
     */
    CompletableFuture<GetInvoiceResponse> getInvoiceAsync(final String invoiceId);

    /**
     * Updates an invoice. This endpoint supports sparse updates, so you only need to specify the
     * fields you want to change along with the required `version` field. Some restrictions apply to
     * updating invoices. For example, you cannot change the `order_id` or `location_id` field.
     * @param  invoiceId  Required parameter: The ID of the invoice to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateInvoiceResponse updateInvoice(final String invoiceId, final UpdateInvoiceRequest body)
            throws ApiException, IOException;

    /**
     * Updates an invoice. This endpoint supports sparse updates, so you only need to specify the
     * fields you want to change along with the required `version` field. Some restrictions apply to
     * updating invoices. For example, you cannot change the `order_id` or `location_id` field.
     * @param  invoiceId  Required parameter: The ID of the invoice to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateInvoiceResponse response from the API call
     */
    CompletableFuture<UpdateInvoiceResponse> updateInvoiceAsync(
            final String invoiceId, final UpdateInvoiceRequest body);

    /**
     * Uploads a file and attaches it to an invoice. This endpoint accepts HTTP multipart/form-data
     * file uploads with a JSON `request` part and a `file` part. The `file` part must be a
     * `readable stream` that contains a file in a supported format: GIF, JPEG, PNG, TIFF, BMP, or
     * PDF. Invoices can have up to 10 attachments with a total file size of 25 MB. Attachments can
     * be added only to invoices in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to attach the
     *         file to.
     * @param  request  Optional parameter: Represents a
     *         [CreateInvoiceAttachment]($e/Invoices/CreateInvoiceAttachment) request.
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateInvoiceAttachmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateInvoiceAttachmentResponse createInvoiceAttachment(
            final String invoiceId, final CreateInvoiceAttachmentRequest request, final FileWrapper imageFile)
            throws ApiException, IOException;

    /**
     * Uploads a file and attaches it to an invoice. This endpoint accepts HTTP multipart/form-data
     * file uploads with a JSON `request` part and a `file` part. The `file` part must be a
     * `readable stream` that contains a file in a supported format: GIF, JPEG, PNG, TIFF, BMP, or
     * PDF. Invoices can have up to 10 attachments with a total file size of 25 MB. Attachments can
     * be added only to invoices in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to attach the
     *         file to.
     * @param  request  Optional parameter: Represents a
     *         [CreateInvoiceAttachment]($e/Invoices/CreateInvoiceAttachment) request.
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateInvoiceAttachmentResponse response from the API call
     */
    CompletableFuture<CreateInvoiceAttachmentResponse> createInvoiceAttachmentAsync(
            final String invoiceId, final CreateInvoiceAttachmentRequest request, final FileWrapper imageFile);

    /**
     * Removes an attachment from an invoice and permanently deletes the file. Attachments can be
     * removed only from invoices in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to delete the
     *         attachment from.
     * @param  attachmentId  Required parameter: The ID of the
     *         [attachment](entity:InvoiceAttachment) to delete.
     * @return    Returns the DeleteInvoiceAttachmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteInvoiceAttachmentResponse deleteInvoiceAttachment(final String invoiceId, final String attachmentId)
            throws ApiException, IOException;

    /**
     * Removes an attachment from an invoice and permanently deletes the file. Attachments can be
     * removed only from invoices in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to delete the
     *         attachment from.
     * @param  attachmentId  Required parameter: The ID of the
     *         [attachment](entity:InvoiceAttachment) to delete.
     * @return    Returns the DeleteInvoiceAttachmentResponse response from the API call
     */
    CompletableFuture<DeleteInvoiceAttachmentResponse> deleteInvoiceAttachmentAsync(
            final String invoiceId, final String attachmentId);

    /**
     * Cancels an invoice. The seller cannot collect payments for the canceled invoice. You cannot
     * cancel an invoice in the `DRAFT` state or in a terminal state: `PAID`, `REFUNDED`,
     * `CANCELED`, or `FAILED`.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to cancel.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelInvoiceResponse cancelInvoice(final String invoiceId, final CancelInvoiceRequest body)
            throws ApiException, IOException;

    /**
     * Cancels an invoice. The seller cannot collect payments for the canceled invoice. You cannot
     * cancel an invoice in the `DRAFT` state or in a terminal state: `PAID`, `REFUNDED`,
     * `CANCELED`, or `FAILED`.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to cancel.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelInvoiceResponse response from the API call
     */
    CompletableFuture<CancelInvoiceResponse> cancelInvoiceAsync(
            final String invoiceId, final CancelInvoiceRequest body);

    /**
     * Publishes the specified draft invoice. After an invoice is published, Square follows up based
     * on the invoice configuration. For example, Square sends the invoice to the customer's email
     * address, charges the customer's card on file, or does nothing. Square also makes the invoice
     * available on a Square-hosted invoice page. The invoice `status` also changes from `DRAFT` to
     * a status based on the invoice configuration. For example, the status changes to `UNPAID` if
     * Square emails the invoice or `PARTIALLY_PAID` if Square charges a card on file for a portion
     * of the invoice amount. In addition to the required `ORDERS_WRITE` and `INVOICES_WRITE`
     * permissions, `CUSTOMERS_READ` and `PAYMENTS_WRITE` are required when publishing invoices
     * configured for card-on-file payments.
     * @param  invoiceId  Required parameter: The ID of the invoice to publish.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PublishInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    PublishInvoiceResponse publishInvoice(final String invoiceId, final PublishInvoiceRequest body)
            throws ApiException, IOException;

    /**
     * Publishes the specified draft invoice. After an invoice is published, Square follows up based
     * on the invoice configuration. For example, Square sends the invoice to the customer's email
     * address, charges the customer's card on file, or does nothing. Square also makes the invoice
     * available on a Square-hosted invoice page. The invoice `status` also changes from `DRAFT` to
     * a status based on the invoice configuration. For example, the status changes to `UNPAID` if
     * Square emails the invoice or `PARTIALLY_PAID` if Square charges a card on file for a portion
     * of the invoice amount. In addition to the required `ORDERS_WRITE` and `INVOICES_WRITE`
     * permissions, `CUSTOMERS_READ` and `PAYMENTS_WRITE` are required when publishing invoices
     * configured for card-on-file payments.
     * @param  invoiceId  Required parameter: The ID of the invoice to publish.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PublishInvoiceResponse response from the API call
     */
    CompletableFuture<PublishInvoiceResponse> publishInvoiceAsync(
            final String invoiceId, final PublishInvoiceRequest body);
}
