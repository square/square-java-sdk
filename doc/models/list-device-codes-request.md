## List Device Codes Request

### Structure

`ListDeviceCodesRequest`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Cursor` | `String` | Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for your original query.<br><br>See [Paginating results](#paginatingresults) for more information. | String getCursor() |
| `LocationId` | `String` | Optional | If specified, only returns DeviceCodes of the specified location.<br>Returns DeviceCodes of all locations if empty. | String getLocationId() |
| `ProductType` | [`String`](/doc/models/product-type.md) | Optional | - | String getProductType() |

### Example (as JSON)

```json
{}
```

