
# Search Orders State Filter

Filter by the current order `state`.

## Structure

`SearchOrdersStateFilter`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `States` | [`List<String>`](../../doc/models/order-state.md) | Required | States to filter for.<br>See [OrderState](../../#type-orderstate) for possible values | List<String> getStates() |

## Example (as JSON)

```json
{
  "states": [
    "OPEN",
    "COMPLETED"
  ]
}
```

