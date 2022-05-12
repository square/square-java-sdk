
# Delete Invoice Request

Describes a `DeleteInvoice` request.

## Structure

`DeleteInvoiceRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Version` | `Integer` | Optional | The version of the [invoice](../../doc/models/invoice.md) to delete.<br>If you do not know the version, you can call [GetInvoice](../../doc/api/invoices.md#get-invoice) or<br>[ListInvoices](../../doc/api/invoices.md#list-invoices). | Integer getVersion() |

## Example (as JSON)

```json
{
  "version": null
}
```

