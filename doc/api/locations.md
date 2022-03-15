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

Provides details about all of the seller's [locations](../../https://developer.squareup.com/docs/locations-api),
including those with an inactive status.

```java
CompletableFuture<ListLocationsResponse> listLocationsAsync()
```

## Response Type

[`ListLocationsResponse`](../../doc/models/list-locations-response.md)

## Example Usage

```java
locationsApi.listLocationsAsync().thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Location

Creates a [location](../../https://developer.squareup.com/docs/locations-api).
Creating new locations allows for separate configuration of receipt layouts, item prices,
and sales reports. Developers can use locations to separate sales activity via applications
that integrate with Square from sales activity elsewhere in a seller's account.
Locations created programmatically with the Locations API will last forever and
are visible to the seller for their own management, so ensure that
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
Address address = new Address.Builder()
    .addressLine1("1234 Peachtree St. NE")
    .addressLine2("address_line_26")
    .addressLine3("address_line_32")
    .locality("Atlanta")
    .sublocality("sublocality6")
    .administrativeDistrictLevel1("GA")
    .postalCode("30309")
    .build();
List<String> bodyLocationCapabilities = new LinkedList<>();
bodyLocationCapabilities.add("AUTOMATIC_TRANSFERS");
bodyLocationCapabilities.add("CREDIT_CARD_PROCESSING");
bodyLocationCapabilities.add("AUTOMATIC_TRANSFERS");
Location location = new Location.Builder()
    .id("id0")
    .name("Midtown")
    .address(locationAddress)
    .timezone("timezone0")
    .capabilities(locationCapabilities)
    .description("Midtown Atlanta store")
    .build();
CreateLocationRequest body = new CreateLocationRequest.Builder()
    .location(bodyLocation)
    .build();

locationsApi.createLocationAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Location

Retrieves details of a single location. Specify "main"
as the location ID to retrieve details of the [main location](../../https://developer.squareup.com/docs/locations-api#about-the-main-location).

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
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Location

Updates a [location](../../https://developer.squareup.com/docs/locations-api).

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
Address address = new Address.Builder()
    .addressLine1("address_line_16")
    .addressLine2("address_line_26")
    .addressLine3("address_line_32")
    .locality("locality6")
    .sublocality("sublocality6")
    .build();
List<String> bodyLocationCapabilities = new LinkedList<>();
bodyLocationCapabilities.add("AUTOMATIC_TRANSFERS");
bodyLocationCapabilities.add("CREDIT_CARD_PROCESSING");
bodyLocationCapabilities.add("AUTOMATIC_TRANSFERS");
List<BusinessHoursPeriod> bodyLocationBusinessHoursPeriods = new LinkedList<>();

BusinessHoursPeriod bodyLocationBusinessHoursPeriods0 = new BusinessHoursPeriod.Builder()
    .dayOfWeek("FRI")
    .startLocalTime("07:00")
    .endLocalTime("18:00")
    .build();
bodyLocationBusinessHoursPeriods.add(bodyLocationBusinessHoursPeriods0);

BusinessHoursPeriod bodyLocationBusinessHoursPeriods1 = new BusinessHoursPeriod.Builder()
    .dayOfWeek("SAT")
    .startLocalTime("07:00")
    .endLocalTime("18:00")
    .build();
bodyLocationBusinessHoursPeriods.add(bodyLocationBusinessHoursPeriods1);

BusinessHoursPeriod bodyLocationBusinessHoursPeriods2 = new BusinessHoursPeriod.Builder()
    .dayOfWeek("SUN")
    .startLocalTime("09:00")
    .endLocalTime("15:00")
    .build();
bodyLocationBusinessHoursPeriods.add(bodyLocationBusinessHoursPeriods2);

BusinessHours businessHours = new BusinessHours.Builder()
    .periods(businessHoursPeriods)
    .build();
Location location = new Location.Builder()
    .id("id0")
    .name("name0")
    .address(locationAddress)
    .timezone("timezone0")
    .capabilities(locationCapabilities)
    .businessHours(locationBusinessHours)
    .description("Midtown Atlanta store - Open weekends")
    .build();
UpdateLocationRequest body = new UpdateLocationRequest.Builder()
    .location(bodyLocation)
    .build();

locationsApi.updateLocationAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

