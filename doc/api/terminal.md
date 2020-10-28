# Terminal

```java
TerminalApi terminalApi = client.getTerminalApi();
```

## Class Name

`TerminalApi`

## Methods

* [Create Terminal Checkout](/doc/api/terminal.md#create-terminal-checkout)
* [Search Terminal Checkouts](/doc/api/terminal.md#search-terminal-checkouts)
* [Get Terminal Checkout](/doc/api/terminal.md#get-terminal-checkout)
* [Cancel Terminal Checkout](/doc/api/terminal.md#cancel-terminal-checkout)
* [Create Terminal Refund](/doc/api/terminal.md#create-terminal-refund)
* [Search Terminal Refunds](/doc/api/terminal.md#search-terminal-refunds)
* [Get Terminal Refund](/doc/api/terminal.md#get-terminal-refund)
* [Cancel Terminal Refund](/doc/api/terminal.md#cancel-terminal-refund)


# Create Terminal Checkout

Creates a new Terminal checkout request and sends it to the specified device to take a payment for the requested amount.

```java
CompletableFuture<CreateTerminalCheckoutResponse> createTerminalCheckoutAsync(
    final CreateTerminalCheckoutRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateTerminalCheckoutRequest`](/doc/models/create-terminal-checkout-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateTerminalCheckoutResponse`](/doc/models/create-terminal-checkout-response.md)

## Example Usage

```java
Money bodyCheckoutAmountMoney = new Money.Builder()
    .amount(2610L)
    .currency("USD")
    .build();
TipSettings bodyCheckoutDeviceOptionsTipSettings = new TipSettings.Builder()
    .allowTipping(false)
    .separateTipScreen(false)
    .customTipField(false)
    .build();
DeviceCheckoutOptions bodyCheckoutDeviceOptions = new DeviceCheckoutOptions.Builder(
        "dbb5d83a-7838-11ea-bc55-0242ac130003")
    .skipReceiptScreen(false)
    .tipSettings(bodyCheckoutDeviceOptionsTipSettings)
    .build();
TerminalCheckout bodyCheckout = new TerminalCheckout.Builder(
        bodyCheckoutAmountMoney,
        bodyCheckoutDeviceOptions)
    .id("id8")
    .referenceId("id11572")
    .note("A brief note")
    .deadlineDuration("deadline_duration0")
    .status("status0")
    .build();
CreateTerminalCheckoutRequest body = new CreateTerminalCheckoutRequest.Builder(
        "28a0c3bc-7839-11ea-bc55-0242ac130003",
        bodyCheckout)
    .build();

terminalApi.createTerminalCheckoutAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Terminal Checkouts

Retrieves a filtered list of Terminal checkout requests created by the account making the request.

```java
CompletableFuture<SearchTerminalCheckoutsResponse> searchTerminalCheckoutsAsync(
    final SearchTerminalCheckoutsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchTerminalCheckoutsRequest`](/doc/models/search-terminal-checkouts-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchTerminalCheckoutsResponse`](/doc/models/search-terminal-checkouts-response.md)

## Example Usage

```java
TimeRange bodyQueryFilterCreatedAt = new TimeRange.Builder()
    .startAt("start_at2")
    .endAt("end_at0")
    .build();
TerminalCheckoutQueryFilter bodyQueryFilter = new TerminalCheckoutQueryFilter.Builder()
    .deviceId("device_id8")
    .createdAt(bodyQueryFilterCreatedAt)
    .status("COMPLETED")
    .build();
TerminalCheckoutQuerySort bodyQuerySort = new TerminalCheckoutQuerySort.Builder()
    .sortOrder("sort_order8")
    .build();
TerminalCheckoutQuery bodyQuery = new TerminalCheckoutQuery.Builder()
    .filter(bodyQueryFilter)
    .sort(bodyQuerySort)
    .build();
SearchTerminalCheckoutsRequest body = new SearchTerminalCheckoutsRequest.Builder()
    .query(bodyQuery)
    .cursor("cursor0")
    .limit(2)
    .build();

terminalApi.searchTerminalCheckoutsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Terminal Checkout

Retrieves a Terminal checkout request by checkout_id.

```java
CompletableFuture<GetTerminalCheckoutResponse> getTerminalCheckoutAsync(
    final String checkoutId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `checkoutId` | `String` | Template, Required | Unique ID for the desired `TerminalCheckout` |

## Response Type

[`GetTerminalCheckoutResponse`](/doc/models/get-terminal-checkout-response.md)

## Example Usage

```java
String checkoutId = "checkout_id8";

terminalApi.getTerminalCheckoutAsync(checkoutId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Cancel Terminal Checkout

Cancels a Terminal checkout request if the status of the request permits it.

```java
CompletableFuture<CancelTerminalCheckoutResponse> cancelTerminalCheckoutAsync(
    final String checkoutId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `checkoutId` | `String` | Template, Required | Unique ID for the desired `TerminalCheckout` |

## Response Type

[`CancelTerminalCheckoutResponse`](/doc/models/cancel-terminal-checkout-response.md)

## Example Usage

```java
String checkoutId = "checkout_id8";

terminalApi.cancelTerminalCheckoutAsync(checkoutId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Terminal Refund

Creates a request to refund an Interac payment completed on a Square Terminal.

```java
CompletableFuture<CreateTerminalRefundResponse> createTerminalRefundAsync(
    final CreateTerminalRefundRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateTerminalRefundRequest`](/doc/models/create-terminal-refund-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateTerminalRefundResponse`](/doc/models/create-terminal-refund-response.md)

## Example Usage

```java
Money bodyRefundAmountMoney = new Money.Builder()
    .amount(128L)
    .currency("AWG")
    .build();
TerminalRefund bodyRefund = new TerminalRefund.Builder(
        "payment_id4",
        bodyRefundAmountMoney)
    .id("id4")
    .refundId("refund_id8")
    .orderId("order_id8")
    .reason("reason0")
    .deviceId("device_id0")
    .build();
CreateTerminalRefundRequest body = new CreateTerminalRefundRequest.Builder(
        "idempotency_key2")
    .refund(bodyRefund)
    .build();

terminalApi.createTerminalRefundAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Terminal Refunds

Retrieves a filtered list of Terminal Interac refund requests created by the seller making the request.

```java
CompletableFuture<SearchTerminalRefundsResponse> searchTerminalRefundsAsync(
    final SearchTerminalRefundsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchTerminalRefundsRequest`](/doc/models/search-terminal-refunds-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchTerminalRefundsResponse`](/doc/models/search-terminal-refunds-response.md)

## Example Usage

```java
TimeRange bodyQueryFilterCreatedAt = new TimeRange.Builder()
    .startAt("start_at2")
    .endAt("end_at0")
    .build();
TerminalRefundQueryFilter bodyQueryFilter = new TerminalRefundQueryFilter.Builder()
    .deviceId("device_id8")
    .createdAt(bodyQueryFilterCreatedAt)
    .status("status6")
    .build();
TerminalRefundQuerySort bodyQuerySort = new TerminalRefundQuerySort.Builder()
    .sortOrder("sort_order8")
    .build();
TerminalRefundQuery bodyQuery = new TerminalRefundQuery.Builder()
    .filter(bodyQueryFilter)
    .sort(bodyQuerySort)
    .build();
SearchTerminalRefundsRequest body = new SearchTerminalRefundsRequest.Builder()
    .query(bodyQuery)
    .cursor("cursor0")
    .limit(164)
    .build();

terminalApi.searchTerminalRefundsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Terminal Refund

Retrieves an Interac terminal refund object by ID.

```java
CompletableFuture<GetTerminalRefundResponse> getTerminalRefundAsync(
    final String terminalRefundId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `terminalRefundId` | `String` | Template, Required | Unique ID for the desired `TerminalRefund` |

## Response Type

[`GetTerminalRefundResponse`](/doc/models/get-terminal-refund-response.md)

## Example Usage

```java
String terminalRefundId = "terminal_refund_id0";

terminalApi.getTerminalRefundAsync(terminalRefundId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Cancel Terminal Refund

Cancels an Interac terminal refund request by refund request ID if the status of the request permits it.

```java
CompletableFuture<CancelTerminalRefundResponse> cancelTerminalRefundAsync(
    final String terminalRefundId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `terminalRefundId` | `String` | Template, Required | Unique ID for the desired `TerminalRefund` |

## Response Type

[`CancelTerminalRefundResponse`](/doc/models/cancel-terminal-refund-response.md)

## Example Usage

```java
String terminalRefundId = "terminal_refund_id0";

terminalApi.cancelTerminalRefundAsync(terminalRefundId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

