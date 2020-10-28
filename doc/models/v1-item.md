
# V1 Item

V1Item

## Structure

`V1Item`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The item's ID. Must be unique among all entity IDs ever provided on behalf of the merchant. You can never reuse an ID. This value can include alphanumeric characters, dashes (-), and underscores (_). | String getId() |
| `Name` | `String` | Optional | The item's name. | String getName() |
| `Description` | `String` | Optional | The item's description. | String getDescription() |
| `Type` | [`String`](/doc/models/v1-item-type.md) | Optional | - | String getType() |
| `Color` | [`String`](/doc/models/v1-item-color.md) | Optional | - | String getColor() |
| `Abbreviation` | `String` | Optional | The text of the item's display label in Square Point of Sale. Only up to the first five characters of the string are used. | String getAbbreviation() |
| `Visibility` | [`String`](/doc/models/v1-item-visibility.md) | Optional | - | String getVisibility() |
| `AvailableOnline` | `Boolean` | Optional | If true, the item can be added to shipping orders from the merchant's online store. | Boolean getAvailableOnline() |
| `MasterImage` | [`V1ItemImage`](/doc/models/v1-item-image.md) | Optional | V1ItemImage | V1ItemImage getMasterImage() |
| `Category` | [`V1Category`](/doc/models/v1-category.md) | Optional | V1Category | V1Category getCategory() |
| `Variations` | [`List<V1Variation>`](/doc/models/v1-variation.md) | Optional | The item's variations. You must specify at least one variation. | List<V1Variation> getVariations() |
| `ModifierLists` | [`List<V1ModifierList>`](/doc/models/v1-modifier-list.md) | Optional | The modifier lists that apply to the item, if any. | List<V1ModifierList> getModifierLists() |
| `Fees` | [`List<V1Fee>`](/doc/models/v1-fee.md) | Optional | The fees that apply to the item, if any. | List<V1Fee> getFees() |
| `Taxable` | `Boolean` | Optional | Deprecated. This field is not used. | Boolean getTaxable() |
| `CategoryId` | `String` | Optional | The ID of the item's category, if any. | String getCategoryId() |
| `AvailableForPickup` | `Boolean` | Optional | If true, the item can be added to pickup orders from the merchant's online store. Default value: false | Boolean getAvailableForPickup() |
| `V2Id` | `String` | Optional | The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID. | String getV2Id() |

## Example (as JSON)

```json
{
  "id": "id0",
  "name": "name0",
  "description": "description0",
  "type": "OTHER",
  "color": "0b8000"
}
```

