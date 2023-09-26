
# Delete Invoice Request

Describes a `DeleteInvoice` request.

## Structure

`DeleteInvoiceRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Version` | `Integer` | Optional | The version of the [invoice](entity:Invoice) to delete.<br>If you do not know the version, you can call [GetInvoice](api-endpoint:Invoices-GetInvoice) or<br>[ListInvoices](api-endpoint:Invoices-ListInvoices). | Integer getVersion() |

## Example (as JSON)

```json
{
  "version": 26
}
```

