
# Loyalty Event Expire Points

Provides metadata when the event `type` is `EXPIRE_POINTS`.

## Structure

`LoyaltyEventExpirePoints`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LoyaltyProgramId` | `String` | Required | The Square-assigned ID of the [loyalty program](/doc/models/loyalty-program.md).<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `36` | String getLoyaltyProgramId() |
| `Points` | `int` | Required | The number of points expired. | int getPoints() |

## Example (as JSON)

```json
{
  "loyalty_program_id": "loyalty_program_id0",
  "points": 236
}
```

