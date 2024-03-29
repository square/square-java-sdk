
# Catalog Query Prefix

The query filter to return the search result whose named attribute values are prefixed by the specified attribute value.

## Structure

`CatalogQueryPrefix`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AttributeName` | `String` | Required | The name of the attribute to be searched.<br>**Constraints**: *Minimum Length*: `1` | String getAttributeName() |
| `AttributePrefix` | `String` | Required | The desired prefix of the search attribute value.<br>**Constraints**: *Minimum Length*: `1` | String getAttributePrefix() |

## Example (as JSON)

```json
{
  "attribute_name": "attribute_name8",
  "attribute_prefix": "attribute_prefix6"
}
```

