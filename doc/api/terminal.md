# Terminal

```java
TerminalApi terminalApi = client.getTerminalApi();
```

## Class Name

`TerminalApi`

## Methods

* [Create Terminal Action](../../doc/api/terminal.md#create-terminal-action)
* [Search Terminal Actions](../../doc/api/terminal.md#search-terminal-actions)
* [Get Terminal Action](../../doc/api/terminal.md#get-terminal-action)
* [Cancel Terminal Action](../../doc/api/terminal.md#cancel-terminal-action)
* [Create Terminal Checkout](../../doc/api/terminal.md#create-terminal-checkout)
* [Search Terminal Checkouts](../../doc/api/terminal.md#search-terminal-checkouts)
* [Get Terminal Checkout](../../doc/api/terminal.md#get-terminal-checkout)
* [Cancel Terminal Checkout](../../doc/api/terminal.md#cancel-terminal-checkout)
* [Create Terminal Refund](../../doc/api/terminal.md#create-terminal-refund)
* [Search Terminal Refunds](../../doc/api/terminal.md#search-terminal-refunds)
* [Get Terminal Refund](../../doc/api/terminal.md#get-terminal-refund)
* [Cancel Terminal Refund](../../doc/api/terminal.md#cancel-terminal-refund)


# Create Terminal Action

Creates a Terminal action request and sends it to the specified device.

```java
CompletableFuture<CreateTerminalActionResponse> createTerminalActionAsync(
    final CreateTerminalActionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateTerminalActionRequest`](../../doc/models/create-terminal-action-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateTerminalActionResponse`](../../doc/models/create-terminal-action-response.md)

## Example Usage

```java
SaveCardOptions saveCardOptions = new SaveCardOptions.Builder(
        "{{CUSTOMER_ID}}")
    .referenceId("user-id-1")
    .build();
TerminalAction terminalAction = new TerminalAction.Builder()
    .deviceId("{{DEVICE_ID}}")
    .deadlineDuration("PT5M")
    .type("SAVE_CARD")
    .saveCardOptions(terminalActionSaveCardOptions)
    .build();
CreateTerminalActionRequest body = new CreateTerminalActionRequest.Builder(
        "thahn-70e75c10-47f7-4ab6-88cc-aaa4076d065e",
        action)
    .build();

terminalApi.createTerminalActionAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Terminal Actions

Retrieves a filtered list of Terminal action requests created by the account making the request. Terminal action requests are available for 30 days.

```java
CompletableFuture<SearchTerminalActionsResponse> searchTerminalActionsAsync(
    final SearchTerminalActionsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchTerminalActionsRequest`](../../doc/models/search-terminal-actions-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchTerminalActionsResponse`](../../doc/models/search-terminal-actions-response.md)

## Example Usage

```java
TimeRange timeRange = new TimeRange.Builder()
    .startAt("2022-04-01T00:00:00Z")
    .build();
TerminalActionQueryFilter terminalActionQueryFilter = new TerminalActionQueryFilter.Builder()
    .createdAt(terminalActionQueryFilterCreatedAt)
    .build();
TerminalActionQuerySort terminalActionQuerySort = new TerminalActionQuerySort.Builder()
    .sortOrder("DESC")
    .build();
TerminalActionQuery terminalActionQuery = new TerminalActionQuery.Builder()
    .filter(terminalActionQueryFilter)
    .sort(terminalActionQuerySort)
    .build();
SearchTerminalActionsRequest body = new SearchTerminalActionsRequest.Builder()
    .query(bodyQuery)
    .limit(2)
    .build();

terminalApi.searchTerminalActionsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Terminal Action

Retrieves a Terminal action request by `action_id`. Terminal action requests are available for 30 days.

```java
CompletableFuture<GetTerminalActionResponse> getTerminalActionAsync(
    final String actionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `actionId` | `String` | Template, Required | Unique ID for the desired `TerminalAction` |

## Response Type

[`GetTerminalActionResponse`](../../doc/models/get-terminal-action-response.md)

## Example Usage

```java
String actionId = "action_id6";

terminalApi.getTerminalActionAsync(actionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Cancel Terminal Action

Cancels a Terminal action request if the status of the request permits it.

```java
CompletableFuture<CancelTerminalActionResponse> cancelTerminalActionAsync(
    final String actionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `actionId` | `String` | Template, Required | Unique ID for the desired `TerminalAction` |

## Response Type

[`CancelTerminalActionResponse`](../../doc/models/cancel-terminal-action-response.md)

## Example Usage

```java
String actionId = "action_id6";

terminalApi.cancelTerminalActionAsync(actionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Terminal Checkout

Creates a Terminal checkout request and sends it to the specified device to take a payment
for the requested amount.

```java
CompletableFuture<CreateTerminalCheckoutResponse> createTerminalCheckoutAsync(
    final CreateTerminalCheckoutRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateTerminalCheckoutRequest`](../../doc/models/create-terminal-checkout-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateTerminalCheckoutResponse`](../../doc/models/create-terminal-checkout-response.md)

## Example Usage

```java
Money money = new Money.Builder()
    .amount(2610L)
    .currency("USD")
    .build();
DeviceCheckoutOptions deviceCheckoutOptions = new DeviceCheckoutOptions.Builder(
        "dbb5d83a-7838-11ea-bc55-0242ac130003")
    .build();
TerminalCheckout terminalCheckout = new TerminalCheckout.Builder(
        amountMoney,
        deviceOptions)
    .referenceId("id11572")
    .note("A brief note")
    .build();
CreateTerminalCheckoutRequest body = new CreateTerminalCheckoutRequest.Builder(
        "28a0c3bc-7839-11ea-bc55-0242ac130003",
        checkout)
    .build();

terminalApi.createTerminalCheckoutAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Terminal Checkouts

Returns a filtered list of Terminal checkout requests created by the application making the request. Only Terminal checkout requests created for the merchant scoped to the OAuth token are returned. Terminal checkout requests are available for 30 days.

```java
CompletableFuture<SearchTerminalCheckoutsResponse> searchTerminalCheckoutsAsync(
    final SearchTerminalCheckoutsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchTerminalCheckoutsRequest`](../../doc/models/search-terminal-checkouts-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchTerminalCheckoutsResponse`](../../doc/models/search-terminal-checkouts-response.md)

## Example Usage

```java
TerminalCheckoutQueryFilter terminalCheckoutQueryFilter = new TerminalCheckoutQueryFilter.Builder()
    .status("COMPLETED")
    .build();
TerminalCheckoutQuery terminalCheckoutQuery = new TerminalCheckoutQuery.Builder()
    .filter(terminalCheckoutQueryFilter)
    .build();
SearchTerminalCheckoutsRequest body = new SearchTerminalCheckoutsRequest.Builder()
    .query(bodyQuery)
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

Retrieves a Terminal checkout request by `checkout_id`. Terminal checkout requests are available for 30 days.

```java
CompletableFuture<GetTerminalCheckoutResponse> getTerminalCheckoutAsync(
    final String checkoutId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `checkoutId` | `String` | Template, Required | The unique ID for the desired `TerminalCheckout`. |

## Response Type

[`GetTerminalCheckoutResponse`](../../doc/models/get-terminal-checkout-response.md)

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
| `checkoutId` | `String` | Template, Required | The unique ID for the desired `TerminalCheckout`. |

## Response Type

[`CancelTerminalCheckoutResponse`](../../doc/models/cancel-terminal-checkout-response.md)

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

Creates a request to refund an Interac payment completed on a Square Terminal. Refunds for Interac payments on a Square Terminal are supported only for Interac debit cards in Canada. Other refunds for Terminal payments should use the Refunds API. For more information, see [Refunds API](../../doc/api/refunds.md).

```java
CompletableFuture<CreateTerminalRefundResponse> createTerminalRefundAsync(
    final CreateTerminalRefundRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateTerminalRefundRequest`](../../doc/models/create-terminal-refund-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateTerminalRefundResponse`](../../doc/models/create-terminal-refund-response.md)

## Example Usage

```java
Money money = new Money.Builder()
    .amount(111L)
    .currency("CAD")
    .build();
TerminalRefund terminalRefund = new TerminalRefund.Builder(
        "5O5OvgkcNUhl7JBuINflcjKqUzXZY",
        amountMoney,
        "Returning items",
        "f72dfb8e-4d65-4e56-aade-ec3fb8d33291")
    .build();
CreateTerminalRefundRequest body = new CreateTerminalRefundRequest.Builder(
        "402a640b-b26f-401f-b406-46f839590c04")
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

Retrieves a filtered list of Interac Terminal refund requests created by the seller making the request. Terminal refund requests are available for 30 days.

```java
CompletableFuture<SearchTerminalRefundsResponse> searchTerminalRefundsAsync(
    final SearchTerminalRefundsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchTerminalRefundsRequest`](../../doc/models/search-terminal-refunds-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchTerminalRefundsResponse`](../../doc/models/search-terminal-refunds-response.md)

## Example Usage

```java
TerminalRefundQueryFilter terminalRefundQueryFilter = new TerminalRefundQueryFilter.Builder()
    .status("COMPLETED")
    .build();
TerminalRefundQuery terminalRefundQuery = new TerminalRefundQuery.Builder()
    .filter(terminalRefundQueryFilter)
    .build();
SearchTerminalRefundsRequest body = new SearchTerminalRefundsRequest.Builder()
    .query(bodyQuery)
    .limit(1)
    .build();

terminalApi.searchTerminalRefundsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Terminal Refund

Retrieves an Interac Terminal refund object by ID. Terminal refund objects are available for 30 days.

```java
CompletableFuture<GetTerminalRefundResponse> getTerminalRefundAsync(
    final String terminalRefundId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `terminalRefundId` | `String` | Template, Required | The unique ID for the desired `TerminalRefund`. |

## Response Type

[`GetTerminalRefundResponse`](../../doc/models/get-terminal-refund-response.md)

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

Cancels an Interac Terminal refund request by refund request ID if the status of the request permits it.

```java
CompletableFuture<CancelTerminalRefundResponse> cancelTerminalRefundAsync(
    final String terminalRefundId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `terminalRefundId` | `String` | Template, Required | The unique ID for the desired `TerminalRefund`. |

## Response Type

[`CancelTerminalRefundResponse`](../../doc/models/cancel-terminal-refund-response.md)

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

