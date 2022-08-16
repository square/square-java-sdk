
# Create Payment Link Response

## Structure

`CreatePaymentLinkResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `PaymentLink` | [`PaymentLink`](../../doc/models/payment-link.md) | Optional | - | PaymentLink getPaymentLink() |
| `RelatedResources` | [`PaymentLinkRelatedResources`](../../doc/models/payment-link-related-resources.md) | Optional | - | PaymentLinkRelatedResources getRelatedResources() |

## Example (as JSON)

```json
{
  "errors": null,
  "payment_link": null,
  "related_resources": null
}
```

