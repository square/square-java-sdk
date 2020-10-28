# Customer Segments

```java
CustomerSegmentsApi customerSegmentsApi = client.getCustomerSegmentsApi();
```

## Class Name

`CustomerSegmentsApi`

## Methods

* [List Customer Segments](/doc/api/customer-segments.md#list-customer-segments)
* [Retrieve Customer Segment](/doc/api/customer-segments.md#retrieve-customer-segment)


# List Customer Segments

Retrieves the list of customer segments of a business.

```java
CompletableFuture<ListCustomerSegmentsResponse> listCustomerSegmentsAsync(
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by previous calls to __ListCustomerSegments__.<br>Used to retrieve the next set of query results.<br><br>See the [Pagination guide](https://developer.squareup.com/docs/docs/working-with-apis/pagination) for more information. |

## Response Type

[`ListCustomerSegmentsResponse`](/doc/models/list-customer-segments-response.md)

## Example Usage

```java
String cursor = "cursor6";

customerSegmentsApi.listCustomerSegmentsAsync(cursor).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Customer Segment

Retrieves a specific customer segment as identified by the `segment_id` value.

```java
CompletableFuture<RetrieveCustomerSegmentResponse> retrieveCustomerSegmentAsync(
    final String segmentId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `segmentId` | `String` | Template, Required | The Square-issued ID of the customer segment. |

## Response Type

[`RetrieveCustomerSegmentResponse`](/doc/models/retrieve-customer-segment-response.md)

## Example Usage

```java
String segmentId = "segment_id4";

customerSegmentsApi.retrieveCustomerSegmentAsync(segmentId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

