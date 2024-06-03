# Events

```java
EventsApi eventsApi = client.getEventsApi();
```

## Class Name

`EventsApi`

## Methods

* [Search Events](../../doc/api/events.md#search-events)
* [Disable Events](../../doc/api/events.md#disable-events)
* [Enable Events](../../doc/api/events.md#enable-events)
* [List Event Types](../../doc/api/events.md#list-event-types)


# Search Events

Search for Square API events that occur within a 28-day timeframe.

```java
CompletableFuture<SearchEventsResponse> searchEventsAsync(
    final SearchEventsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchEventsRequest`](../../doc/models/search-events-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchEventsResponse`](../../doc/models/search-events-response.md)

## Example Usage

```java
SearchEventsRequest body = new SearchEventsRequest.Builder()
    .build();

eventsApi.searchEventsAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Disable Events

Disables events to prevent them from being searchable.
All events are disabled by default. You must enable events to make them searchable.
Disabling events for a specific time period prevents them from being searchable, even if you re-enable them later.

```java
CompletableFuture<DisableEventsResponse> disableEventsAsync()
```

## Response Type

[`DisableEventsResponse`](../../doc/models/disable-events-response.md)

## Example Usage

```java
eventsApi.disableEventsAsync().thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Enable Events

Enables events to make them searchable. Only events that occur while in the enabled state are searchable.

```java
CompletableFuture<EnableEventsResponse> enableEventsAsync()
```

## Response Type

[`EnableEventsResponse`](../../doc/models/enable-events-response.md)

## Example Usage

```java
eventsApi.enableEventsAsync().thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# List Event Types

Lists all event types that you can subscribe to as webhooks or query using the Events API.

```java
CompletableFuture<ListEventTypesResponse> listEventTypesAsync(
    final String apiVersion)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `apiVersion` | `String` | Query, Optional | The API version for which to list event types. Setting this field overrides the default version used by the application. |

## Response Type

[`ListEventTypesResponse`](../../doc/models/list-event-types-response.md)

## Example Usage

```java
eventsApi.listEventTypesAsync(null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```

