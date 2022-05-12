
# Standard Unit Description Group

Group of standard measurement units.

## Structure

`StandardUnitDescriptionGroup`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `StandardUnitDescriptions` | [`List<StandardUnitDescription>`](../../doc/models/standard-unit-description.md) | Optional | List of standard (non-custom) measurement units in this description group. | List<StandardUnitDescription> getStandardUnitDescriptions() |
| `LanguageCode` | `String` | Optional | IETF language tag. | String getLanguageCode() |

## Example (as JSON)

```json
{
  "standard_unit_descriptions": null,
  "language_code": null
}
```

