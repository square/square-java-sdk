
# Loyalty Event Other

Provides metadata when the event `type` is `OTHER`.

## Structure

`LoyaltyEventOther`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LoyaltyProgramId` | `String` | Required | The Square-assigned ID of the [loyalty program](#type-LoyaltyProgram).<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `36` | String getLoyaltyProgramId() |
| `Points` | `int` | Required | The number of points added or removed. | int getPoints() |

## Example (as JSON)

```json
{
  "loyalty_program_id": "loyalty_program_id0",
  "points": 236
}
```

