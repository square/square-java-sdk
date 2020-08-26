## Void Transaction Response

Defines the fields that are included in the response body of
a request to the [VoidTransaction](#endpoint-voidtransaction) endpoint.

### Structure

`VoidTransactionResponse`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |

### Example (as JSON)

```json
{}
```

