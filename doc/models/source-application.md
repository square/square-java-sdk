
# Source Application

Represents information about the application used to generate a change.

## Structure

`SourceApplication`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Product` | [`String`](../../doc/models/product.md) | Optional | Indicates the Square product used to generate a change. | String getProduct() |
| `ApplicationId` | `String` | Optional | __Read only__ The Square-assigned ID of the application. This field is used only if the<br>[product](entity:Product) type is `EXTERNAL_API`. | String getApplicationId() |
| `Name` | `String` | Optional | __Read only__ The display name of the application<br>(for example, `"Custom Application"` or `"Square POS 4.74 for Android"`). | String getName() |

## Example (as JSON)

```json
{
  "product": "SQUARE_POS",
  "application_id": "application_id4",
  "name": "name0"
}
```

