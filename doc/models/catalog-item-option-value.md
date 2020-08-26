## Catalog Item Option Value

An enumerated value that can link a
`CatalogItemVariation` to an item option as one of
its item option values.

### Structure

`CatalogItemOptionValue`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `ItemOptionId` | `String` | Optional | Unique ID of the associated item option. | String getItemOptionId() |
| `Name` | `String` | Optional | Name of this item option value. This is a searchable attribute for use in applicable query filters. | String getName() |
| `Description` | `String` | Optional | A human-readable description for the option value. This is a searchable attribute for use in applicable query filters. | String getDescription() |
| `Color` | `String` | Optional | The HTML-supported hex color for the item option (e.g., "#ff8d4e85").<br>Only displayed if `show_colors` is enabled on the parent `ItemOption`. When<br>left unset, `color` defaults to white ("#ffffff") when `show_colors` is<br>enabled on the parent `ItemOption`. | String getColor() |
| `Ordinal` | `Integer` | Optional | Determines where this option value appears in a list of option values. | Integer getOrdinal() |
| `ItemVariationCount` | `Long` | Optional | The number of `CatalogItemVariation`s that<br>currently use this item option value. Present only if `retrieve_counts`<br>was specified on the request used to retrieve the parent item option of this<br>value. | Long getItemVariationCount() |

### Example (as JSON)

```json
{
  "item_option_id": "item_option_id2",
  "name": "name0",
  "description": "description0",
  "color": "color6",
  "ordinal": 80
}
```

