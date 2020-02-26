## List Dispute Evidence Response

Defines fields in a ListDisputeEvidence response.

### Structure

`ListDisputeEvidenceResponse`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Evidence` | [`List<DisputeEvidence>`](/doc/models/dispute-evidence.md) | Optional | The list of evidence previously uploaded to the specified dispute. |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Information on errors encountered during the request. |

### Example (as JSON)

```json
{
  "evidence": null,
  "errors": null
}
```

