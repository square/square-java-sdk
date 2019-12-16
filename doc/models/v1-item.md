## V1 Item

V1Item

### Structure

`V1Item`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Id` | `String` | Optional | The item's ID. Must be unique among all entity IDs ever provided on behalf of the merchant. You can never reuse an ID. This value can include alphanumeric characters, dashes (-), and underscores (_). |
| `Name` | `String` | Optional | The item's name. |
| `Description` | `String` | Optional | The item's description. |
| `Type` | [`String`](/doc/models/v1-item-type.md) | Optional | - |
| `Color` | [`String`](/doc/models/v1-item-color.md) | Optional | - |
| `Abbreviation` | `String` | Optional | The text of the item's display label in Square Point of Sale. Only up to the first five characters of the string are used. |
| `Visibility` | [`String`](/doc/models/v1-item-visibility.md) | Optional | - |
| `AvailableOnline` | `Boolean` | Optional | If true, the item can be added to shipping orders from the merchant's online store. |
| `MasterImage` | [`V1ItemImage`](/doc/models/v1-item-image.md) | Optional | V1ItemImage |
| `Category` | [`V1Category`](/doc/models/v1-category.md) | Optional | V1Category |
| `Variations` | [`List<V1Variation>`](/doc/models/v1-variation.md) | Optional | The item's variations. You must specify at least one variation. |
| `ModifierLists` | [`List<V1ModifierList>`](/doc/models/v1-modifier-list.md) | Optional | The modifier lists that apply to the item, if any. |
| `Fees` | [`List<V1Fee>`](/doc/models/v1-fee.md) | Optional | The fees that apply to the item, if any. |
| `Taxable` | `Boolean` | Optional | Deprecated. This field is not used. |
| `CategoryId` | `String` | Optional | The ID of the item's category, if any. |
| `AvailableForPickup` | `Boolean` | Optional | If true, the item can be added to pickup orders from the merchant's online store. Default value: false |
| `V2Id` | `String` | Optional | The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID. |

### Example (as JSON)

```json
{
  "id": null,
  "name": null,
  "description": null,
  "type": null,
  "color": null,
  "abbreviation": null,
  "visibility": null,
  "available_online": null,
  "master_image": null,
  "category": null,
  "variations": null,
  "modifier_lists": null,
  "fees": null,
  "taxable": null,
  "category_id": null,
  "available_for_pickup": null,
  "v2_id": null
}
```

