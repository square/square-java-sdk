
# V1 Payment Itemization

Payment include an`itemizations` field that lists the items purchased,
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

## Structure

`V1PaymentItemization`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Name` | `String` | Optional | The item's name. | String getName() |
| `Quantity` | `Double` | Optional | The quantity of the item purchased. This can be a decimal value. | Double getQuantity() |
| `ItemizationType` | [`String`](../../doc/models/v1-payment-itemization-itemization-type.md) | Optional | - | String getItemizationType() |
| `ItemDetail` | [`V1PaymentItemDetail`](../../doc/models/v1-payment-item-detail.md) | Optional | V1PaymentItemDetail | V1PaymentItemDetail getItemDetail() |
| `Notes` | `String` | Optional | Notes entered by the merchant about the item at the time of payment, if any. | String getNotes() |
| `ItemVariationName` | `String` | Optional | The name of the item variation purchased, if any. | String getItemVariationName() |
| `TotalMoney` | [`V1Money`](../../doc/models/v1-money.md) | Optional | - | V1Money getTotalMoney() |
| `SingleQuantityMoney` | [`V1Money`](../../doc/models/v1-money.md) | Optional | - | V1Money getSingleQuantityMoney() |
| `GrossSalesMoney` | [`V1Money`](../../doc/models/v1-money.md) | Optional | - | V1Money getGrossSalesMoney() |
| `DiscountMoney` | [`V1Money`](../../doc/models/v1-money.md) | Optional | - | V1Money getDiscountMoney() |
| `NetSalesMoney` | [`V1Money`](../../doc/models/v1-money.md) | Optional | - | V1Money getNetSalesMoney() |
| `Taxes` | [`List<V1PaymentTax>`](../../doc/models/v1-payment-tax.md) | Optional | All taxes applied to this itemization. | List<V1PaymentTax> getTaxes() |
| `Discounts` | [`List<V1PaymentDiscount>`](../../doc/models/v1-payment-discount.md) | Optional | All discounts applied to this itemization. | List<V1PaymentDiscount> getDiscounts() |
| `Modifiers` | [`List<V1PaymentModifier>`](../../doc/models/v1-payment-modifier.md) | Optional | All modifier options applied to this itemization. | List<V1PaymentModifier> getModifiers() |

## Example (as JSON)

```json
{
  "name": "name0",
  "quantity": 149.16,
  "itemization_type": "GIFT_CARD_UNKNOWN",
  "item_detail": {
    "category_name": "category_name0",
    "sku": "sku6",
    "item_id": "item_id2",
    "item_variation_id": "item_variation_id2"
  },
  "notes": "notes0"
}
```

