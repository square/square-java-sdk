# Devices

```java
DevicesApi devicesApi = client.getDevicesApi();
```

## Class Name

`DevicesApi`

## Methods

* [List Devices](../../doc/api/devices.md#list-devices)
* [List Device Codes](../../doc/api/devices.md#list-device-codes)
* [Create Device Code](../../doc/api/devices.md#create-device-code)
* [Get Device Code](../../doc/api/devices.md#get-device-code)
* [Get Device](../../doc/api/devices.md#get-device)


# List Devices

List devices associated with the merchant. Currently, only Terminal API
devices are supported.

```java
CompletableFuture<ListDevicesResponse> listDevicesAsync(
    final String cursor,
    final String sortOrder,
    final Integer limit,
    final String locationId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br>See [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination) for more information. |
| `sortOrder` | [`String`](../../doc/models/sort-order.md) | Query, Optional | The order in which results are listed.<br><br>- `ASC` - Oldest to newest.<br>- `DESC` - Newest to oldest (default). |
| `limit` | `Integer` | Query, Optional | The number of results to return in a single page. |
| `locationId` | `String` | Query, Optional | If present, only returns devices at the target location. |

## Response Type

[`ListDevicesResponse`](../../doc/models/list-devices-response.md)

## Example Usage

```java
devicesApi.listDevicesAsync(null, null, null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# List Device Codes

Lists all DeviceCodes associated with the merchant.

```java
CompletableFuture<ListDeviceCodesResponse> listDeviceCodesAsync(
    final String cursor,
    final String locationId,
    final String productType,
    final String status)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for your original query.<br><br>See [Paginating results](https://developer.squareup.com/docs/working-with-apis/pagination) for more information. |
| `locationId` | `String` | Query, Optional | If specified, only returns DeviceCodes of the specified location.<br>Returns DeviceCodes of all locations if empty. |
| `productType` | [`String`](../../doc/models/product-type.md) | Query, Optional | If specified, only returns DeviceCodes targeting the specified product type.<br>Returns DeviceCodes of all product types if empty. |
| `status` | [`String`](../../doc/models/device-code-status.md) | Query, Optional | If specified, returns DeviceCodes with the specified statuses.<br>Returns DeviceCodes of status `PAIRED` and `UNPAIRED` if empty. |

## Response Type

[`ListDeviceCodesResponse`](../../doc/models/list-device-codes-response.md)

## Example Usage

```java
devicesApi.listDeviceCodesAsync(null, null, null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Create Device Code

Creates a DeviceCode that can be used to login to a Square Terminal device to enter the connected
terminal mode.

```java
CompletableFuture<CreateDeviceCodeResponse> createDeviceCodeAsync(
    final CreateDeviceCodeRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateDeviceCodeRequest`](../../doc/models/create-device-code-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateDeviceCodeResponse`](../../doc/models/create-device-code-response.md)

## Example Usage

```java
CreateDeviceCodeRequest body = new CreateDeviceCodeRequest.Builder(
    "01bb00a6-0c86-4770-94ed-f5fca973cd56",
    new DeviceCode.Builder(
        "TERMINAL_API"
    )
    .name("Counter 1")
    .locationId("B5E4484SHHNYH")
    .build()
)
.build();

devicesApi.createDeviceCodeAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Get Device Code

Retrieves DeviceCode with the associated ID.

```java
CompletableFuture<GetDeviceCodeResponse> getDeviceCodeAsync(
    final String id)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The unique identifier for the device code. |

## Response Type

[`GetDeviceCodeResponse`](../../doc/models/get-device-code-response.md)

## Example Usage

```java
String id = "id0";

devicesApi.getDeviceCodeAsync(id).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Get Device

Retrieves Device with the associated `device_id`.

```java
CompletableFuture<GetDeviceResponse> getDeviceAsync(
    final String deviceId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `deviceId` | `String` | Template, Required | The unique ID for the desired `Device`. |

## Response Type

[`GetDeviceResponse`](../../doc/models/get-device-response.md)

## Example Usage

```java
String deviceId = "device_id6";

devicesApi.getDeviceAsync(deviceId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```

