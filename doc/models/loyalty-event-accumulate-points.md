
# Loyalty Event Accumulate Points

Provides metadata when the event `type` is `ACCUMULATE_POINTS`.

## Structure

`LoyaltyEventAccumulatePoints`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LoyaltyProgramId` | `String` | Optional | The ID of the [loyalty program](#type-LoyaltyProgram). | String getLoyaltyProgramId() |
| `Points` | `Integer` | Optional | The number of points accumulated by the event. | Integer getPoints() |
| `OrderId` | `String` | Optional | The ID of the [order](#type-Order) for which the buyer accumulated the points.<br>This field is returned only if the Orders API is used to process orders. | String getOrderId() |

## Example (as JSON)

```json
{
  "loyalty_program_id": "loyalty_program_id0",
  "points": 236,
  "order_id": "order_id6"
}
```

