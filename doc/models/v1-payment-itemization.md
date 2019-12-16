## V1 Payment Itemization

Payment include an` itemizations` field that lists the items purchased,
along with associated fees, modifiers, and discounts. Each itemization has an
`itemization_type` field that indicates which of the following the itemization
represents:

<ul>
<li>An item variation from the merchant's item library</li>
<li>A custom monetary amount</li>
<li>
An action performed on a Square gift card, such as activating or
reloading it.
</li>
</ul>

*Note**: itemization information included in a `Payment` object reflects
details collected **at the time of the payment**. Details such as the name or
price of items might have changed since the payment was processed.

### Structure

`V1PaymentItemization`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Name` | `String` | Optional | The item's name. |
| `Quantity` | `Double` | Optional | The quantity of the item purchased. This can be a decimal value. |
| `ItemizationType` | [`String`](/doc/models/v1-payment-itemization-itemization-type.md) | Optional | - |
| `ItemDetail` | [`V1PaymentItemDetail`](/doc/models/v1-payment-item-detail.md) | Optional | V1PaymentItemDetail |
| `Notes` | `String` | Optional | Notes entered by the merchant about the item at the time of payment, if any. |
| `ItemVariationName` | `String` | Optional | The name of the item variation purchased, if any. |
| `TotalMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `SingleQuantityMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `GrossSalesMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `DiscountMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `NetSalesMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `Taxes` | [`List<V1PaymentTax>`](/doc/models/v1-payment-tax.md) | Optional | All taxes applied to this itemization. |
| `Discounts` | [`List<V1PaymentDiscount>`](/doc/models/v1-payment-discount.md) | Optional | All discounts applied to this itemization. |
| `Modifiers` | [`List<V1PaymentModifier>`](/doc/models/v1-payment-modifier.md) | Optional | All modifier options applied to this itemization. |

### Example (as JSON)

```json
{
  "name": null,
  "quantity": null,
  "itemization_type": null,
  "item_detail": null,
  "notes": null,
  "item_variation_name": null,
  "total_money": null,
  "single_quantity_money": null,
  "gross_sales_money": null,
  "discount_money": null,
  "net_sales_money": null,
  "taxes": null,
  "discounts": null,
  "modifiers": null
}
```

