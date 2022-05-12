
# Loyalty Event Query

Represents a query used to search for loyalty events.

## Structure

`LoyaltyEventQuery`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Filter` | [`LoyaltyEventFilter`](../../doc/models/loyalty-event-filter.md) | Optional | The filtering criteria. If the request specifies multiple filters,<br>the endpoint uses a logical AND to evaluate them. | LoyaltyEventFilter getFilter() |

## Example (as JSON)

```json
{
  "filter": null
}
```

