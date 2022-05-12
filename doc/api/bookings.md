# Bookings

```java
BookingsApi bookingsApi = client.getBookingsApi();
```

## Class Name

`BookingsApi`

## Methods

* [List Bookings](../../doc/api/bookings.md#list-bookings)
* [Create Booking](../../doc/api/bookings.md#create-booking)
* [Search Availability](../../doc/api/bookings.md#search-availability)
* [Retrieve Business Booking Profile](../../doc/api/bookings.md#retrieve-business-booking-profile)
* [List Team Member Booking Profiles](../../doc/api/bookings.md#list-team-member-booking-profiles)
* [Retrieve Team Member Booking Profile](../../doc/api/bookings.md#retrieve-team-member-booking-profile)
* [Retrieve Booking](../../doc/api/bookings.md#retrieve-booking)
* [Update Booking](../../doc/api/bookings.md#update-booking)
* [Cancel Booking](../../doc/api/bookings.md#cancel-booking)


# List Bookings

Retrieve a collection of bookings.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.

```java
CompletableFuture<ListBookingsResponse> listBookingsAsync(
    final Integer limit,
    final String cursor,
    final String teamMemberId,
    final String locationId,
    final String startAtMin,
    final String startAtMax)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `limit` | `Integer` | Query, Optional | The maximum number of results per page to return in a paged response. |
| `cursor` | `String` | Query, Optional | The pagination cursor from the preceding response to return the next page of the results. Do not set this when retrieving the first page of the results. |
| `teamMemberId` | `String` | Query, Optional | The team member for whom to retrieve bookings. If this is not set, bookings of all members are retrieved. |
| `locationId` | `String` | Query, Optional | The location for which to retrieve bookings. If this is not set, all locations' bookings are retrieved. |
| `startAtMin` | `String` | Query, Optional | The RFC 3339 timestamp specifying the earliest of the start time. If this is not set, the current time is used. |
| `startAtMax` | `String` | Query, Optional | The RFC 3339 timestamp specifying the latest of the start time. If this is not set, the time of 31 days after `start_at_min` is used. |

## Response Type

[`ListBookingsResponse`](../../doc/models/list-bookings-response.md)

## Example Usage

```java
bookingsApi.listBookingsAsync(null, null, null, null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Booking

Creates a booking.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.

```java
CompletableFuture<CreateBookingResponse> createBookingAsync(
    final CreateBookingRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateBookingRequest`](../../doc/models/create-booking-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateBookingResponse`](../../doc/models/create-booking-response.md)

## Example Usage

```java
Booking booking = new Booking.Builder()
    .build();
CreateBookingRequest body = new CreateBookingRequest.Builder(
        booking)
    .build();

bookingsApi.createBookingAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Availability

Searches for availabilities for booking.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.

```java
CompletableFuture<SearchAvailabilityResponse> searchAvailabilityAsync(
    final SearchAvailabilityRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchAvailabilityRequest`](../../doc/models/search-availability-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchAvailabilityResponse`](../../doc/models/search-availability-response.md)

## Example Usage

```java
TimeRange timeRange = new TimeRange.Builder()
    .build();
SearchAvailabilityFilter searchAvailabilityFilter = new SearchAvailabilityFilter.Builder(
        startAtRange)
    .build();
SearchAvailabilityQuery searchAvailabilityQuery = new SearchAvailabilityQuery.Builder(
        filter)
    .build();
SearchAvailabilityRequest body = new SearchAvailabilityRequest.Builder(
        query)
    .build();

bookingsApi.searchAvailabilityAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Business Booking Profile

Retrieves a seller's booking profile.

```java
CompletableFuture<RetrieveBusinessBookingProfileResponse> retrieveBusinessBookingProfileAsync()
```

## Response Type

[`RetrieveBusinessBookingProfileResponse`](../../doc/models/retrieve-business-booking-profile-response.md)

## Example Usage

```java
bookingsApi.retrieveBusinessBookingProfileAsync().thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Team Member Booking Profiles

Lists booking profiles for team members.

```java
CompletableFuture<ListTeamMemberBookingProfilesResponse> listTeamMemberBookingProfilesAsync(
    final Boolean bookableOnly,
    final Integer limit,
    final String cursor,
    final String locationId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `bookableOnly` | `Boolean` | Query, Optional | Indicates whether to include only bookable team members in the returned result (`true`) or not (`false`).<br>**Default**: `false` |
| `limit` | `Integer` | Query, Optional | The maximum number of results to return in a paged response. |
| `cursor` | `String` | Query, Optional | The pagination cursor from the preceding response to return the next page of the results. Do not set this when retrieving the first page of the results. |
| `locationId` | `String` | Query, Optional | Indicates whether to include only team members enabled at the given location in the returned result. |

## Response Type

[`ListTeamMemberBookingProfilesResponse`](../../doc/models/list-team-member-booking-profiles-response.md)

## Example Usage

```java
Boolean bookableOnly = false;

bookingsApi.listTeamMemberBookingProfilesAsync(bookableOnly, null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Team Member Booking Profile

Retrieves a team member's booking profile.

```java
CompletableFuture<RetrieveTeamMemberBookingProfileResponse> retrieveTeamMemberBookingProfileAsync(
    final String teamMemberId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `teamMemberId` | `String` | Template, Required | The ID of the team member to retrieve. |

## Response Type

[`RetrieveTeamMemberBookingProfileResponse`](../../doc/models/retrieve-team-member-booking-profile-response.md)

## Example Usage

```java
String teamMemberId = "team_member_id0";

bookingsApi.retrieveTeamMemberBookingProfileAsync(teamMemberId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Booking

Retrieves a booking.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.

```java
CompletableFuture<RetrieveBookingResponse> retrieveBookingAsync(
    final String bookingId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `bookingId` | `String` | Template, Required | The ID of the [Booking](../../doc/models/booking.md) object representing the to-be-retrieved booking. |

## Response Type

[`RetrieveBookingResponse`](../../doc/models/retrieve-booking-response.md)

## Example Usage

```java
String bookingId = "booking_id4";

bookingsApi.retrieveBookingAsync(bookingId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Booking

Updates a booking.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.

```java
CompletableFuture<UpdateBookingResponse> updateBookingAsync(
    final String bookingId,
    final UpdateBookingRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `bookingId` | `String` | Template, Required | The ID of the [Booking](../../doc/models/booking.md) object representing the to-be-updated booking. |
| `body` | [`UpdateBookingRequest`](../../doc/models/update-booking-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateBookingResponse`](../../doc/models/update-booking-response.md)

## Example Usage

```java
String bookingId = "booking_id4";
Booking booking = new Booking.Builder()
    .build();
UpdateBookingRequest body = new UpdateBookingRequest.Builder(
        booking)
    .build();

bookingsApi.updateBookingAsync(bookingId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Cancel Booking

Cancels an existing booking.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.

```java
CompletableFuture<CancelBookingResponse> cancelBookingAsync(
    final String bookingId,
    final CancelBookingRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `bookingId` | `String` | Template, Required | The ID of the [Booking](../../doc/models/booking.md) object representing the to-be-cancelled booking. |
| `body` | [`CancelBookingRequest`](../../doc/models/cancel-booking-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CancelBookingResponse`](../../doc/models/cancel-booking-response.md)

## Example Usage

```java
String bookingId = "booking_id4";
CancelBookingRequest body = new CancelBookingRequest.Builder()
    .build();

bookingsApi.cancelBookingAsync(bookingId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

