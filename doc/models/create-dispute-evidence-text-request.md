## Create Dispute Evidence Text Request

Defines parameters for a CreateDisputeEvidenceText request.

### Structure

`CreateDisputeEvidenceTextRequest`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `IdempotencyKey` | `String` |  | Unique ID. For more information,<br>see [Idempotency](https://developer.squareup.com/docs/docs/working-with-apis/idempotency). |
| `EvidenceType` | [`String`](/doc/models/dispute-evidence-type.md) | Optional | Type of the dispute evidence. |
| `EvidenceText` | `String` |  | The evidence string. |

### Example (as JSON)

```json
{
  "evidence_type": "TRACKING_NUMBER",
  "evidence_text": "1Z8888888888888888",
  "idempotency_key": "ed3ee3933d946f1514d505d173c82648"
}
```

