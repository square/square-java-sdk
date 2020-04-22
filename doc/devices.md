# Devices

```java
DevicesApi devicesApi = client.getDevicesApi();
```

## Class Name

`DevicesApi`

## Methods

* [List Device Codes](/doc/devices.md#list-device-codes)
* [Create Device Code](/doc/devices.md#create-device-code)
* [Get Device Code](/doc/devices.md#get-device-code)

## List Device Codes

Lists all DeviceCodes associated with the merchant.

```java
CompletableFuture<ListDeviceCodesResponse> listDeviceCodesAsync(
    final String cursor,
    final String locationId,
    final String productType)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for your original query.<br><br>See [Paginating results](#paginatingresults) for more information. |
| `locationId` | `String` | Query, Optional | If specified, only returns DeviceCodes of the specified location.<br>Returns DeviceCodes of all locations if empty. |
| `productType` | [`String`](/doc/models/product-type.md) | Query, Optional | If specified, only returns DeviceCodes targeting the specified product type.<br>Returns DeviceCodes of all product types if empty. |

### Response Type

[`ListDeviceCodesResponse`](/doc/models/list-device-codes-response.md)

### Example Usage

```java
devicesApi.listDeviceCodesAsync(null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Device Code

Creates a DeviceCode that can be used to login to a Square Terminal device to enter the connected
terminal mode.

```java
CompletableFuture<CreateDeviceCodeResponse> createDeviceCodeAsync(
    final CreateDeviceCodeRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateDeviceCodeRequest`](/doc/models/create-device-code-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CreateDeviceCodeResponse`](/doc/models/create-device-code-response.md)

### Example Usage

```java
DeviceCode bodyDeviceCode = new DeviceCode.Builder(
        "TERMINAL_API")
    .name("Counter 1")
    .locationId("B5E4484SHHNYH")
    .build();
CreateDeviceCodeRequest body = new CreateDeviceCodeRequest.Builder(
        "01bb00a6-0c86-4770-94ed-f5fca973cd56",
        bodyDeviceCode)
    .build();

devicesApi.createDeviceCodeAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Get Device Code

Retrieves DeviceCode with the associated ID.

```java
CompletableFuture<GetDeviceCodeResponse> getDeviceCodeAsync(
    final String id)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The unique identifier for the device code. |

### Response Type

[`GetDeviceCodeResponse`](/doc/models/get-device-code-response.md)

### Example Usage

```java
String id = "id0";

devicesApi.getDeviceCodeAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

