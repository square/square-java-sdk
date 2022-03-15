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
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for your original query.<br><br>For more information, see [Pagination](../../https://developer.squareup.com/docs/working-with-apis/pagination). |
| `limit` | `Integer` | Query, Optional | The maximum number of invoices to return (200 is the maximum `limit`).<br>If not provided, the server uses a default limit of 100 invoices. |

## Response Type

[`ListInvoicesResponse`](../../doc/models/list-invoices-response.md)

## Example Usage

```java
String locationId = "location_id4";
String cursor = "cursor6";
Integer limit = 172;

invoicesApi.listInvoicesAsync(locationId, cursor, limit).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
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
Address address = new Address.Builder()
    .addressLine1("address_line_10")
    .addressLine2("address_line_20")
    .addressLine3("address_line_36")
    .locality("locality0")
    .sublocality("sublocality0")
    .build();
InvoiceRecipient invoiceRecipient = new InvoiceRecipient.Builder()
    .customerId("JDKYHBWT1D4F8MFH63DBMEN8Y4")
    .givenName("given_name6")
    .familyName("family_name8")
    .emailAddress("email_address2")
    .address(invoiceRecipientAddress)
    .build();
List<InvoicePaymentRequest> bodyInvoicePaymentRequests = new LinkedList<>();

Money money = new Money.Builder()
    .amount(52L)
    .currency("USS")
    .build();
List<InvoicePaymentReminder> bodyInvoicePaymentRequests0Reminders = new LinkedList<>();

InvoicePaymentReminder bodyInvoicePaymentRequests0Reminders0 = new InvoicePaymentReminder.Builder()
    .uid("uid2")
    .relativeScheduledDays(-1)
    .message("Your invoice is due tomorrow")
    .status("PENDING")
    .sentAt("sent_at2")
    .build();
bodyInvoicePaymentRequests0Reminders.add(bodyInvoicePaymentRequests0Reminders0);

InvoicePaymentRequest bodyInvoicePaymentRequests0 = new InvoicePaymentRequest.Builder()
    .uid("uid4")
    .requestMethod("SMS_CHARGE_CARD_ON_FILE")
    .requestType("BALANCE")
    .dueDate("2030-01-24")
    .fixedAmountRequestedMoney(bodyInvoicePaymentRequests0FixedAmountRequestedMoney)
    .tippingEnabled(true)
    .automaticPaymentSource("NONE")
    .reminders(bodyInvoicePaymentRequests0Reminders)
    .build();
bodyInvoicePaymentRequests.add(bodyInvoicePaymentRequests0);

InvoiceAcceptedPaymentMethods invoiceAcceptedPaymentMethods = new InvoiceAcceptedPaymentMethods.Builder()
    .card(true)
    .squareGiftCard(false)
    .bankAccount(false)
    .build();
List<InvoiceCustomField> bodyInvoiceCustomFields = new LinkedList<>();

InvoiceCustomField bodyInvoiceCustomFields0 = new InvoiceCustomField.Builder()
    .label("Event Reference Number")
    .value("Ref. #1234")
    .placement("ABOVE_LINE_ITEMS")
    .build();
bodyInvoiceCustomFields.add(bodyInvoiceCustomFields0);

InvoiceCustomField bodyInvoiceCustomFields1 = new InvoiceCustomField.Builder()
    .label("Terms of Service")
    .value("The terms of service are...")
    .placement("BELOW_LINE_ITEMS")
    .build();
bodyInvoiceCustomFields.add(bodyInvoiceCustomFields1);

Invoice invoice = new Invoice.Builder()
    .id("id0")
    .version(38)
    .locationId("ES0RJRZYEC39A")
    .orderId("CAISENgvlJ6jLWAzERDzjyHVybY")
    .primaryRecipient(invoicePrimaryRecipient)
    .paymentRequests(invoicePaymentRequests)
    .deliveryMethod("EMAIL")
    .invoiceNumber("inv-100")
    .title("Event Planning Services")
    .description("We appreciate your business!")
    .scheduledAt("2030-01-13T10:00:00Z")
    .acceptedPaymentMethods(invoiceAcceptedPaymentMethods)
    .customFields(invoiceCustomFields)
    .saleOrServiceDate("2030-01-24")
    .build();
CreateInvoiceRequest body = new CreateInvoiceRequest.Builder(
        invoice)
    .idempotencyKey("ce3748f9-5fc1-4762-aa12-aae5e843f1f4")
    .build();

invoicesApi.createInvoiceAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
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
List<String> bodyQueryFilterLocationIds = new LinkedList<>();
bodyQueryFilterLocationIds.add("ES0RJRZYEC39A");
List<String> bodyQueryFilterCustomerIds = new LinkedList<>();
bodyQueryFilterCustomerIds.add("JDKYHBWT1D4F8MFH63DBMEN8Y4");
InvoiceFilter invoiceFilter = new InvoiceFilter.Builder(
        invoiceFilterLocationIds)
    .customerIds(invoiceFilterCustomerIds)
    .build();
InvoiceSort invoiceSort = new InvoiceSort.Builder(
        null)
    .order("DESC")
    .build();
InvoiceQuery invoiceQuery = new InvoiceQuery.Builder(
        filter)
    .sort(invoiceQuerySort)
    .build();
SearchInvoicesRequest body = new SearchInvoicesRequest.Builder(
        query)
    .limit(164)
    .cursor("cursor0")
    .build();

invoicesApi.searchInvoicesAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
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
| `version` | `Integer` | Query, Optional | The version of the [invoice](../../doc/models/invoice.md) to delete.<br>If you do not know the version, you can call [GetInvoice](../../doc/api/invoices.md#get-invoice) or<br>[ListInvoices](../../doc/api/invoices.md#list-invoices). |

## Response Type

[`DeleteInvoiceResponse`](../../doc/models/delete-invoice-response.md)

## Example Usage

```java
String invoiceId = "invoice_id0";
Integer version = 172;

invoicesApi.deleteInvoiceAsync(invoiceId, version).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
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
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Invoice

Updates an invoice by modifying fields, clearing fields, or both. For most updates, you can use a sparse
`Invoice` object to add fields or change values and use the `fields_to_clear` field to specify fields to clear.
However, some restrictions apply. For example, you cannot change the `order_id` or `location_id` field and you
must provide the complete `custom_fields` list to update a custom field. Published invoices have additional restrictions.

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
Address address = new Address.Builder()
    .addressLine1("address_line_10")
    .addressLine2("address_line_20")
    .addressLine3("address_line_36")
    .locality("locality0")
    .sublocality("sublocality0")
    .build();
InvoiceRecipient invoiceRecipient = new InvoiceRecipient.Builder()
    .customerId("customer_id2")
    .givenName("given_name6")
    .familyName("family_name8")
    .emailAddress("email_address2")
    .address(invoiceRecipientAddress)
    .build();
List<InvoicePaymentRequest> bodyInvoicePaymentRequests = new LinkedList<>();

Money money = new Money.Builder()
    .amount(52L)
    .currency("USS")
    .build();
InvoicePaymentRequest bodyInvoicePaymentRequests0 = new InvoicePaymentRequest.Builder()
    .uid("2da7964f-f3d2-4f43-81e8-5aa220bf3355")
    .requestMethod("SMS_CHARGE_CARD_ON_FILE")
    .requestType("DEPOSIT")
    .dueDate("due_date2")
    .fixedAmountRequestedMoney(bodyInvoicePaymentRequests0FixedAmountRequestedMoney)
    .tippingEnabled(false)
    .build();
bodyInvoicePaymentRequests.add(bodyInvoicePaymentRequests0);

Invoice invoice = new Invoice.Builder()
    .id("id0")
    .version(38)
    .locationId("location_id4")
    .orderId("order_id6")
    .primaryRecipient(invoicePrimaryRecipient)
    .paymentRequests(invoicePaymentRequests)
    .build();
List<String> bodyFieldsToClear = new LinkedList<>();
bodyFieldsToClear.add("payments_requests[2da7964f-f3d2-4f43-81e8-5aa220bf3355].reminders");
UpdateInvoiceRequest body = new UpdateInvoiceRequest.Builder(
        invoice)
    .idempotencyKey("4ee82288-0910-499e-ab4c-5d0071dad1be")
    .fieldsToClear(bodyFieldsToClear)
    .build();

invoicesApi.updateInvoiceAsync(invoiceId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
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
| `invoiceId` | `String` | Template, Required | The ID of the [invoice](../../doc/models/invoice.md) to cancel. |
| `body` | [`CancelInvoiceRequest`](../../doc/models/cancel-invoice-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CancelInvoiceResponse`](../../doc/models/cancel-invoice-response.md)

## Example Usage

```java
String invoiceId = "invoice_id0";
CancelInvoiceRequest body = new CancelInvoiceRequest.Builder(
        0)
    .build();

invoicesApi.cancelInvoiceAsync(invoiceId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
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
Square emails the invoice or `PARTIALLY_PAID` if Square charge a card on file for a portion of the
invoice amount.

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
        1)
    .idempotencyKey("32da42d0-1997-41b0-826b-f09464fc2c2e")
    .build();

invoicesApi.publishInvoiceAsync(invoiceId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

