
# Dispute Evidence Created Webhook Data

## Structure

`DisputeEvidenceCreatedWebhookData`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Type` | `String` | Optional | Name of the affected dispute's type. | String getType() |
| `Id` | `String` | Optional | ID of the affected dispute. | String getId() |
| `Object` | [`DisputeEvidenceCreatedWebhookObject`](/doc/models/dispute-evidence-created-webhook-object.md) | Optional | - | DisputeEvidenceCreatedWebhookObject getObject() |

## Example (as JSON)

```json
{
  "type": "type0",
  "id": "id0",
  "object": {
    "object": {
      "dispute_id": "dispute_id2",
      "id": "id0",
      "amount_money": {
        "amount": 186,
        "currency": "NGN"
      },
      "reason": "NOT_AS_DESCRIBED",
      "state": "PROCESSING"
    }
  }
}
```

