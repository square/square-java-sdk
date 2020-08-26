## Loyalty Event Expire Points

Provides metadata when the event `type` is `EXPIRE_POINTS`.

### Structure

`LoyaltyEventExpirePoints`

### Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `LoyaltyProgramId` | `String` | The Square-assigned ID of the [loyalty program](#type-LoyaltyProgram). | String getLoyaltyProgramId() |
| `Points` | `int` | The number of points expired. | int getPoints() |

### Example (as JSON)

```json
{
  "loyalty_program_id": "loyalty_program_id0",
  "points": 236
}
```

