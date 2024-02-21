# Locations

```java
LocationsApi locationsApi = client.getLocationsApi();
```

## Class Name

`LocationsApi`

## Methods

* [List Locations](../../doc/api/locations.md#list-locations)
* [Create Location](../../doc/api/locations.md#create-location)
* [Retrieve Location](../../doc/api/locations.md#retrieve-location)
* [Update Location](../../doc/api/locations.md#update-location)


# List Locations

Provides details about all of the seller's [locations](https://developer.squareup.com/docs/locations-api),
including those with an inactive status. Locations are listed alphabetically by `name`.

```java
CompletableFuture<ListLocationsResponse> listLocationsAsync()
```

## Response Type

[`ListLocationsResponse`](../../doc/models/list-locations-response.md)

## Example Usage

```java
locationsApi.listLocationsAsync().thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Create Location

Creates a [location](https://developer.squareup.com/docs/locations-api).
Creating new locations allows for separate configuration of receipt layouts, item prices,
and sales reports. Developers can use locations to separate sales activity through applications
that integrate with Square from sales activity elsewhere in a seller's account.
Locations created programmatically with the Locations API last forever and
are visible to the seller for their own management. Therefore, ensure that
each location has a sensible and unique name.

```java
CompletableFuture<CreateLocationResponse> createLocationAsync(
    final CreateLocationRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateLocationRequest`](../../doc/models/create-location-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateLocationResponse`](../../doc/models/create-location-response.md)

## Example Usage

```java
CreateLocationRequest body = new CreateLocationRequest.Builder()
    .location(new Location.Builder()
        .name("Midtown")
        .address(new Address.Builder()
            .addressLine1("1234 Peachtree St. NE")
            .locality("Atlanta")
            .administrativeDistrictLevel1("GA")
            .postalCode("30309")
            .build())
        .description("Midtown Atlanta store")
        .build())
    .build();

locationsApi.createLocationAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Location

Retrieves details of a single location. Specify "main"
as the location ID to retrieve details of the [main location](https://developer.squareup.com/docs/locations-api#about-the-main-location).

```java
CompletableFuture<RetrieveLocationResponse> retrieveLocationAsync(
    final String locationId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to retrieve. Specify the string<br>"main" to return the main location. |

## Response Type

[`RetrieveLocationResponse`](../../doc/models/retrieve-location-response.md)

## Example Usage

```java
String locationId = "location_id4";

locationsApi.retrieveLocationAsync(locationId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Update Location

Updates a [location](https://developer.squareup.com/docs/locations-api).

```java
CompletableFuture<UpdateLocationResponse> updateLocationAsync(
    final String locationId,
    final UpdateLocationRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to update. |
| `body` | [`UpdateLocationRequest`](../../doc/models/update-location-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateLocationResponse`](../../doc/models/update-location-response.md)

## Example Usage

```java
String locationId = "location_id4";
UpdateLocationRequest body = new UpdateLocationRequest.Builder()
    .location(new Location.Builder()
        .businessHours(new BusinessHours.Builder()
            .periods(Arrays.asList(
                new BusinessHoursPeriod.Builder()
                    .dayOfWeek("FRI")
                    .startLocalTime("07:00")
                    .endLocalTime("18:00")
                    .build(),
                new BusinessHoursPeriod.Builder()
                    .dayOfWeek("SAT")
                    .startLocalTime("07:00")
                    .endLocalTime("18:00")
                    .build(),
                new BusinessHoursPeriod.Builder()
                    .dayOfWeek("SUN")
                    .startLocalTime("09:00")
                    .endLocalTime("15:00")
                    .build()
            ))
            .build())
        .description("Midtown Atlanta store - Open weekends")
        .build())
    .build();

locationsApi.updateLocationAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```

