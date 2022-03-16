
# Order Return Service Charge

Represents the service charge applied to the original order.

## Structure

`OrderReturnServiceCharge`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Uid` | `String` | Optional | A unique ID that identifies the return service charge only within this order.<br>**Constraints**: *Maximum Length*: `60` | String getUid() |
| `SourceServiceChargeUid` | `String` | Optional | The service charge `uid` from the order containing the original<br>service charge. `source_service_charge_uid` is `null` for<br>unlinked returns.<br>**Constraints**: *Maximum Length*: `60` | String getSourceServiceChargeUid() |
| `Name` | `String` | Optional | The name of the service charge.<br>**Constraints**: *Maximum Length*: `255` | String getName() |
| `CatalogObjectId` | `String` | Optional | The catalog object ID of the associated [OrderServiceCharge](../../doc/models/order-service-charge.md).<br>**Constraints**: *Maximum Length*: `192` | String getCatalogObjectId() |
| `CatalogVersion` | `Long` | Optional | The version of the catalog object that this service charge references. | Long getCatalogVersion() |
| `Percentage` | `String` | Optional | The percentage of the service charge, as a string representation of<br>a decimal number. For example, a value of `"7.25"` corresponds to a<br>percentage of 7.25%.<br><br>Either `percentage` or `amount_money` should be set, but not both.<br>**Constraints**: *Maximum Length*: `10` | String getPercentage() |
| `AmountMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAmountMoney() |
| `AppliedMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAppliedMoney() |
| `TotalMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getTotalMoney() |
| `TotalTaxMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getTotalTaxMoney() |
| `CalculationPhase` | [`String`](../../doc/models/order-service-charge-calculation-phase.md) | Optional | Represents a phase in the process of calculating order totals.<br>Service charges are applied after the indicated phase.<br><br>[Read more about how order totals are calculated.](https://developer.squareup.com/docs/orders-api/how-it-works#how-totals-are-calculated) | String getCalculationPhase() |
| `Taxable` | `Boolean` | Optional | Indicates whether the surcharge can be taxed. Service charges<br>calculated in the `TOTAL_PHASE` cannot be marked as taxable. | Boolean getTaxable() |
| `AppliedTaxes` | [`List<OrderLineItemAppliedTax>`](../../doc/models/order-line-item-applied-tax.md) | Optional | The list of references to `OrderReturnTax` entities applied to the<br>`OrderReturnServiceCharge`. Each `OrderLineItemAppliedTax` has a `tax_uid`<br>that references the `uid` of a top-level `OrderReturnTax` that is being<br>applied to the `OrderReturnServiceCharge`. On reads, the applied amount is<br>populated. | List<OrderLineItemAppliedTax> getAppliedTaxes() |

## Example (as JSON)

```json
{
  "uid": "uid0",
  "source_service_charge_uid": "source_service_charge_uid6",
  "name": "name0",
  "catalog_object_id": "catalog_object_id6",
  "catalog_version": 126
}
```

