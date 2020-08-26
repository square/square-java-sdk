## Search Orders State Filter

Filter by current Order `state`.

### Structure

`SearchOrdersStateFilter`

### Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `States` | [`List<String>`](/doc/models/order-state.md) | States to filter for.<br>See [OrderState](#type-orderstate) for possible values | List<String> getStates() |

### Example (as JSON)

```json
{
  "states": [
    "CANCELED",
    "OPEN"
  ]
}
```

