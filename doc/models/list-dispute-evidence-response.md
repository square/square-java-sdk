
# List Dispute Evidence Response

Defines the fields in a `ListDisputeEvidence` response.

## Structure

`ListDisputeEvidenceResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Evidence` | [`List<DisputeEvidence>`](../../doc/models/dispute-evidence.md) | Optional | The list of evidence previously uploaded to the specified dispute. | List<DisputeEvidence> getEvidence() |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Information about errors encountered during the request. | List<Error> getErrors() |
| `Cursor` | `String` | Optional | The pagination cursor to be used in a subsequent request.<br>If unset, this is the final response. For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). | String getCursor() |

## Example (as JSON)

```json
{
  "evidence": null,
  "errors": null,
  "cursor": null
}
```

