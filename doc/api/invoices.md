# Invoices

```java
InvoicesApi invoicesApi = client.getInvoicesApi();
```

## Class Name

`InvoicesApi`

## Methods

* [List Invoices](../../doc/api/invoices.md#list-invoices)
* [Create Invoice](../../doc/api/invoices.md#create-invoice)
* [Search Invoices](../../doc/api/invoices.md#search-invoices)
* [Delete Invoice](../../doc/api/invoices.md#delete-invoice)
* [Get Invoice](../../doc/api/invoices.md#get-invoice)
* [Update Invoice](../../doc/api/invoices.md#update-invoice)
* [Create Invoice Attachment](../../doc/api/invoices.md#create-invoice-attachment)
* [Delete Invoice Attachment](../../doc/api/invoices.md#delete-invoice-attachment)
* [Cancel Invoice](../../doc/api/invoices.md#cancel-invoice)
* [Publish Invoice](../../doc/api/invoices.md#publish-invoice)


# List Invoices

Returns a list of invoices for a given location. The response
is paginated. If truncated, the response includes a `cursor` that you  
use in a subsequent request to retrieve the next set of invoices.

```java
CompletableFuture<ListInvoicesResponse> listInvoicesAsync(
    final String locationId,
    final String cursor,
    final Integer limit)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Query, Required | The ID of the location for which to list invoices. |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for your original query.<br><br>For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `limit` | `Integer` | Query, Optional | The maximum number of invoices to return (200 is the maximum `limit`).<br>If not provided, the server uses a default limit of 100 invoices. |

## Response Type

[`ListInvoicesResponse`](../../doc/models/list-invoices-response.md)

## Example Usage

```java
String locationId = "location_id4";

invoicesApi.listInvoicesAsync(locationId, null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Create Invoice

Creates a draft [invoice](../../doc/models/invoice.md)
for an order created using the Orders API.

A draft invoice remains in your account and no action is taken.
You must publish the invoice before Square can process it (send it to the customer's email address or charge the customer’s card on file).

```java
CompletableFuture<CreateInvoiceResponse> createInvoiceAsync(
    final CreateInvoiceRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateInvoiceRequest`](../../doc/models/create-invoice-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateInvoiceResponse`](../../doc/models/create-invoice-response.md)

## Example Usage

```java
CreateInvoiceRequest body = new CreateInvoiceRequest.Builder(
    new Invoice.Builder()
        .locationId("ES0RJRZYEC39A")
        .orderId("CAISENgvlJ6jLWAzERDzjyHVybY")
        .primaryRecipient(new InvoiceRecipient.Builder()
            .customerId("JDKYHBWT1D4F8MFH63DBMEN8Y4")
            .build())
        .paymentRequests(Arrays.asList(
            new InvoicePaymentRequest.Builder()
                .requestType("BALANCE")
                .dueDate("2030-01-24")
                .tippingEnabled(true)
                .automaticPaymentSource("NONE")
                .reminders(Arrays.asList(
                    new InvoicePaymentReminder.Builder()
                        .relativeScheduledDays(-1)
                        .message("Your invoice is due tomorrow")
                        .build()
                ))
                .build()
        ))
        .deliveryMethod("EMAIL")
        .invoiceNumber("inv-100")
        .title("Event Planning Services")
        .description("We appreciate your business!")
        .scheduledAt("2030-01-13T10:00:00Z")
        .acceptedPaymentMethods(new InvoiceAcceptedPaymentMethods.Builder()
            .card(true)
            .squareGiftCard(false)
            .bankAccount(false)
            .buyNowPayLater(false)
            .cashAppPay(false)
            .build())
        .customFields(Arrays.asList(
            new InvoiceCustomField.Builder()
                .label("Event Reference Number")
                .value("Ref. #1234")
                .placement("ABOVE_LINE_ITEMS")
                .build(),
            new InvoiceCustomField.Builder()
                .label("Terms of Service")
                .value("The terms of service are...")
                .placement("BELOW_LINE_ITEMS")
                .build()
        ))
        .saleOrServiceDate("2030-01-24")
        .storePaymentMethodEnabled(false)
        .build()
)
.idempotencyKey("ce3748f9-5fc1-4762-aa12-aae5e843f1f4")
.build();

invoicesApi.createInvoiceAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Search Invoices

Searches for invoices from a location specified in
the filter. You can optionally specify customers in the filter for whom to
retrieve invoices. In the current implementation, you can only specify one location and
optionally one customer.

The response is paginated. If truncated, the response includes a `cursor`
that you use in a subsequent request to retrieve the next set of invoices.

```java
CompletableFuture<SearchInvoicesResponse> searchInvoicesAsync(
    final SearchInvoicesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchInvoicesRequest`](../../doc/models/search-invoices-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchInvoicesResponse`](../../doc/models/search-invoices-response.md)

## Example Usage

```java
SearchInvoicesRequest body = new SearchInvoicesRequest.Builder(
    new InvoiceQuery.Builder(
        new InvoiceFilter.Builder(
            Arrays.asList(
                "ES0RJRZYEC39A"
            )
        )
        .customerIds(Arrays.asList(
                "JDKYHBWT1D4F8MFH63DBMEN8Y4"
            ))
        .build()
    )
    .sort(new InvoiceSort.Builder(
            "INVOICE_SORT_DATE"
        )
        .order("DESC")
        .build())
    .build()
)
.build();

invoicesApi.searchInvoicesAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Delete Invoice

Deletes the specified invoice. When an invoice is deleted, the
associated order status changes to CANCELED. You can only delete a draft
invoice (you cannot delete a published invoice, including one that is scheduled for processing).

```java
CompletableFuture<DeleteInvoiceResponse> deleteInvoiceAsync(
    final String invoiceId,
    final Integer version)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `invoiceId` | `String` | Template, Required | The ID of the invoice to delete. |
| `version` | `Integer` | Query, Optional | The version of the [invoice](entity:Invoice) to delete.<br>If you do not know the version, you can call [GetInvoice](api-endpoint:Invoices-GetInvoice) or<br>[ListInvoices](api-endpoint:Invoices-ListInvoices). |

## Response Type

[`DeleteInvoiceResponse`](../../doc/models/delete-invoice-response.md)

## Example Usage

```java
String invoiceId = "invoice_id0";

invoicesApi.deleteInvoiceAsync(invoiceId, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Get Invoice

Retrieves an invoice by invoice ID.

```java
CompletableFuture<GetInvoiceResponse> getInvoiceAsync(
    final String invoiceId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `invoiceId` | `String` | Template, Required | The ID of the invoice to retrieve. |

## Response Type

[`GetInvoiceResponse`](../../doc/models/get-invoice-response.md)

## Example Usage

```java
String invoiceId = "invoice_id0";

invoicesApi.getInvoiceAsync(invoiceId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Update Invoice

Updates an invoice. This endpoint supports sparse updates, so you only need
to specify the fields you want to change along with the required `version` field.
Some restrictions apply to updating invoices. For example, you cannot change the
`order_id` or `location_id` field.

```java
CompletableFuture<UpdateInvoiceResponse> updateInvoiceAsync(
    final String invoiceId,
    final UpdateInvoiceRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `invoiceId` | `String` | Template, Required | The ID of the invoice to update. |
| `body` | [`UpdateInvoiceRequest`](../../doc/models/update-invoice-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateInvoiceResponse`](../../doc/models/update-invoice-response.md)

## Example Usage

```java
String invoiceId = "invoice_id0";
UpdateInvoiceRequest body = new UpdateInvoiceRequest.Builder(
    new Invoice.Builder()
        .version(1)
        .paymentRequests(Arrays.asList(
            new InvoicePaymentRequest.Builder()
                .uid("2da7964f-f3d2-4f43-81e8-5aa220bf3355")
                .tippingEnabled(false)
                .reminders(Arrays.asList(
                    new InvoicePaymentReminder.Builder()
                        .build(),
                    new InvoicePaymentReminder.Builder()
                        .build(),
                    new InvoicePaymentReminder.Builder()
                        .build()
                ))
                .build()
        ))
        .build()
)
.idempotencyKey("4ee82288-0910-499e-ab4c-5d0071dad1be")
.build();

invoicesApi.updateInvoiceAsync(invoiceId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Create Invoice Attachment

Uploads a file and attaches it to an invoice. This endpoint accepts HTTP multipart/form-data file uploads
with a JSON `request` part and a `file` part. The `file` part must be a `readable stream` that contains a file
in a supported format: GIF, JPEG, PNG, TIFF, BMP, or PDF.

Invoices can have up to 10 attachments with a total file size of 25 MB. Attachments can be added only to invoices
in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.

```java
CompletableFuture<CreateInvoiceAttachmentResponse> createInvoiceAttachmentAsync(
    final String invoiceId,
    final CreateInvoiceAttachmentRequest request,
    final FileWrapper imageFile)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `invoiceId` | `String` | Template, Required | The ID of the [invoice](entity:Invoice) to attach the file to. |
| `request` | [`CreateInvoiceAttachmentRequest`](../../doc/models/create-invoice-attachment-request.md) | Form (JSON-Encoded), Optional | Represents a [CreateInvoiceAttachment](../../doc/api/invoices.md#create-invoice-attachment) request. |
| `imageFile` | `FileWrapper` | Form, Optional | - |

## Response Type

[`CreateInvoiceAttachmentResponse`](../../doc/models/create-invoice-attachment-response.md)

## Example Usage

```java
String invoiceId = "invoice_id0";
CreateInvoiceAttachmentRequest request = new CreateInvoiceAttachmentRequest.Builder()
    .idempotencyKey("ae5e84f9-4742-4fc1-ba12-a3ce3748f1c3")
    .description("Service contract")
    .build();


invoicesApi.createInvoiceAttachmentAsync(invoiceId, request, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Delete Invoice Attachment

Removes an attachment from an invoice and permanently deletes the file. Attachments can be removed only
from invoices in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.

```java
CompletableFuture<DeleteInvoiceAttachmentResponse> deleteInvoiceAttachmentAsync(
    final String invoiceId,
    final String attachmentId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `invoiceId` | `String` | Template, Required | The ID of the [invoice](entity:Invoice) to delete the attachment from. |
| `attachmentId` | `String` | Template, Required | The ID of the [attachment](entity:InvoiceAttachment) to delete. |

## Response Type

[`DeleteInvoiceAttachmentResponse`](../../doc/models/delete-invoice-attachment-response.md)

## Example Usage

```java
String invoiceId = "invoice_id0";
String attachmentId = "attachment_id6";

invoicesApi.deleteInvoiceAttachmentAsync(invoiceId, attachmentId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Cancel Invoice

Cancels an invoice. The seller cannot collect payments for
the canceled invoice.

You cannot cancel an invoice in the `DRAFT` state or in a terminal state: `PAID`, `REFUNDED`, `CANCELED`, or `FAILED`.

```java
CompletableFuture<CancelInvoiceResponse> cancelInvoiceAsync(
    final String invoiceId,
    final CancelInvoiceRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `invoiceId` | `String` | Template, Required | The ID of the [invoice](entity:Invoice) to cancel. |
| `body` | [`CancelInvoiceRequest`](../../doc/models/cancel-invoice-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CancelInvoiceResponse`](../../doc/models/cancel-invoice-response.md)

## Example Usage

```java
String invoiceId = "invoice_id0";
CancelInvoiceRequest body = new CancelInvoiceRequest.Builder(
    0
)
.build();

invoicesApi.cancelInvoiceAsync(invoiceId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Publish Invoice

Publishes the specified draft invoice.

After an invoice is published, Square
follows up based on the invoice configuration. For example, Square
sends the invoice to the customer's email address, charges the customer's card on file, or does
nothing. Square also makes the invoice available on a Square-hosted invoice page.

The invoice `status` also changes from `DRAFT` to a status
based on the invoice configuration. For example, the status changes to `UNPAID` if
Square emails the invoice or `PARTIALLY_PAID` if Square charges a card on file for a portion of the
invoice amount.

In addition to the required `ORDERS_WRITE` and `INVOICES_WRITE` permissions, `CUSTOMERS_READ`
and `PAYMENTS_WRITE` are required when publishing invoices configured for card-on-file payments.

```java
CompletableFuture<PublishInvoiceResponse> publishInvoiceAsync(
    final String invoiceId,
    final PublishInvoiceRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `invoiceId` | `String` | Template, Required | The ID of the invoice to publish. |
| `body` | [`PublishInvoiceRequest`](../../doc/models/publish-invoice-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`PublishInvoiceResponse`](../../doc/models/publish-invoice-response.md)

## Example Usage

```java
String invoiceId = "invoice_id0";
PublishInvoiceRequest body = new PublishInvoiceRequest.Builder(
    1
)
.idempotencyKey("32da42d0-1997-41b0-826b-f09464fc2c2e")
.build();

invoicesApi.publishInvoiceAsync(invoiceId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```

