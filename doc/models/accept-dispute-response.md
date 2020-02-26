## Accept Dispute Response

Defines fields in a AcceptDispute response.

### Structure

`AcceptDisputeResponse`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Information on errors encountered during the request. |
| `Dispute` | [`Dispute`](/doc/models/dispute.md) | Optional | Represents a dispute a cardholder initiated with their bank. |

### Example (as JSON)

```json
{
  "errors": null,
  "dispute": null
}
```

