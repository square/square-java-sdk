## Catalog Modifier Override

Options to control how to override the default behavior of the specified modifier.

### Structure

`CatalogModifierOverride`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `ModifierId` | `String` |  | The ID of the `CatalogModifier` whose default behavior is being overridden. | String getModifierId() |
| `OnByDefault` | `Boolean` | Optional | If `true`, this `CatalogModifier` should be selected by default for this `CatalogItem`. | Boolean getOnByDefault() |

### Example (as JSON)

```json
{
  "modifier_id": "modifier_id2",
  "on_by_default": false
}
```

