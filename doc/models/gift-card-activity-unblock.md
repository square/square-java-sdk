
# Gift Card Activity Unblock

Present only when `GiftCardActivityType` is UNBLOCK.

## Structure

`GiftCardActivityUnblock`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Reason` | `String` | Required | **Default**: `"CHARGEBACK_UNBLOCK"`<br>*Default: `"CHARGEBACK_UNBLOCK"`* | String getReason() |

## Example (as JSON)

```json
{
  "reason": "CHARGEBACK_UNBLOCK"
}
```

