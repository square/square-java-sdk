
# Create Device Code Response

## Structure

`CreateDeviceCodeResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `DeviceCode` | [`DeviceCode`](/doc/models/device-code.md) | Optional | - | DeviceCode getDeviceCode() |

## Example (as JSON)

```json
{
  "device_code": {
    "code": "EBCARJ",
    "created_at": "2020-02-06T18:44:33.000Z",
    "id": "B3Z6NAMYQSMTM",
    "location_id": "B5E4484SHHNYH",
    "name": "Counter 1",
    "pair_by": "2020-02-06T18:49:33.000Z",
    "product_type": "TERMINAL_API",
    "status": "UNPAIRED",
    "status_changed_at": "2020-02-06T18:44:33.000Z"
  }
}
```

