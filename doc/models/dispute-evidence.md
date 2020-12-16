
# Dispute Evidence

## Structure

`DisputeEvidence`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `EvidenceId` | `String` | Optional | The Square-generated ID of the evidence. | String getEvidenceId() |
| `DisputeId` | `String` | Optional | The ID of the dispute the evidence is associated with. | String getDisputeId() |
| `UploadedAt` | `String` | Optional | The time when the next action is due, in RFC 3339 format. | String getUploadedAt() |
| `EvidenceType` | [`String`](/doc/models/dispute-evidence-type.md) | Optional | The type of the dispute evidence. | String getEvidenceType() |

## Example (as JSON)

```json
{
  "evidence_id": "evidence_id2",
  "dispute_id": "dispute_id2",
  "uploaded_at": "uploaded_at4",
  "evidence_type": "RECEIPT"
}
```

