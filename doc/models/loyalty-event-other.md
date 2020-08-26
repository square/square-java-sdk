## Loyalty Event Other

Provides metadata when the event `type` is `OTHER`.

### Structure

`LoyaltyEventOther`

### Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `LoyaltyProgramId` | `String` | The Square-assigned ID of the [loyalty program](#type-LoyaltyProgram). | String getLoyaltyProgramId() |
| `Points` | `int` | The number of points added or removed. | int getPoints() |

### Example (as JSON)

```json
{
  "loyalty_program_id": "loyalty_program_id0",
  "points": 236
}
```

