
# Measurement Unit Custom

The information needed to define a custom unit, provided by the seller.

## Structure

`MeasurementUnitCustom`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Name` | `String` | Required | The name of the custom unit, for example "bushel". | String getName() |
| `Abbreviation` | `String` | Required | The abbreviation of the custom unit, such as "bsh" (bushel). This appears<br>in the cart for the Point of Sale app, and in reports. | String getAbbreviation() |

## Example (as JSON)

```json
{
  "name": "name0",
  "abbreviation": "abbreviation2"
}
```

