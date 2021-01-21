
# Catalog Query Range

The query filter to return the search result whose named attribute values fall between the specified range.

## Structure

`CatalogQueryRange`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AttributeName` | `String` |  | The name of the attribute to be searched.<br>**Constraints**: *Minimum Length*: `1` | String getAttributeName() |
| `AttributeMinValue` | `Long` | Optional | The desired minimum value for the search attribute (inclusive). | Long getAttributeMinValue() |
| `AttributeMaxValue` | `Long` | Optional | The desired maximum value for the search attribute (inclusive). | Long getAttributeMaxValue() |

## Example (as JSON)

```json
{
  "attribute_name": "attribute_name4",
  "attribute_min_value": 232,
  "attribute_max_value": 114
}
```

