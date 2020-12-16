
# Create Dispute Evidence Text Response

Defines the fields in a `CreateDisputeEvidenceText` response.

## Structure

`CreateDisputeEvidenceTextResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `Evidence` | [`DisputeEvidence`](/doc/models/dispute-evidence.md) | Optional | - | DisputeEvidence getEvidence() |

## Example (as JSON)

```json
{
  "evidence": {
    "dispute_id": "bVTprrwk0gygTLZ96VX1oB",
    "evidence_id": "TOomLInj6iWmP3N8qfCXrB",
    "evidence_text": "1Z8888888888888888",
    "uploaded_at": "2018-10-18T16:01:10.000Z"
  }
}
```

