
# Dispute Evidence

## Structure

`DisputeEvidence`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `EvidenceId` | `String` | Optional | The Square-generated ID of the evidence.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `40` | String getEvidenceId() |
| `Id` | `String` | Optional | The Square-generated ID of the evidence.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `40` | String getId() |
| `DisputeId` | `String` | Optional | The ID of the dispute the evidence is associated with.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `40` | String getDisputeId() |
| `EvidenceFile` | [`DisputeEvidenceFile`](/doc/models/dispute-evidence-file.md) | Optional | A file to be uploaded as dispute evidence. | DisputeEvidenceFile getEvidenceFile() |
| `EvidenceText` | `String` | Optional | Raw text<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `500` | String getEvidenceText() |
| `UploadedAt` | `String` | Optional | The time when the next action is due, in RFC 3339 format.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `40` | String getUploadedAt() |
| `EvidenceType` | [`String`](/doc/models/dispute-evidence-type.md) | Optional | The type of the dispute evidence. | String getEvidenceType() |

## Example (as JSON)

```json
{
  "evidence_id": "evidence_id2",
  "id": "id0",
  "dispute_id": "dispute_id2",
  "evidence_file": {
    "filename": "filename8",
    "filetype": "filetype8"
  },
  "evidence_text": "evidence_text6"
}
```

