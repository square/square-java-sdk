
# Payment

Represents a payment processed by the Square API.

## Structure

`Payment`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A unique ID for the payment.<br>**Constraints**: *Maximum Length*: `192` | String getId() |
| `CreatedAt` | `String` | Optional | The timestamp of when the payment was created, in RFC 3339 format.<br>**Constraints**: *Maximum Length*: `32` | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp of when the payment was last updated, in RFC 3339 format.<br>**Constraints**: *Maximum Length*: `32` | String getUpdatedAt() |
| `AmountMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAmountMoney() |
| `TipMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getTipMoney() |
| `TotalMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getTotalMoney() |
| `AppFeeMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAppFeeMoney() |
| `ApprovedMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getApprovedMoney() |
| `ProcessingFee` | [`List<ProcessingFee>`](/doc/models/processing-fee.md) | Optional | The processing fees and fee adjustments assessed by Square for this payment. | List<ProcessingFee> getProcessingFee() |
| `RefundedMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getRefundedMoney() |
| `Status` | `String` | Optional | Indicates whether the payment is APPROVED, PENDING, COMPLETED, CANCELED, or FAILED.<br>**Constraints**: *Maximum Length*: `50` | String getStatus() |
| `DelayDuration` | `String` | Optional | The duration of time after the payment's creation when Square automatically applies the<br>`delay_action` to the payment. This automatic `delay_action` applies only to payments that<br>do not reach a terminal state (COMPLETED, CANCELED, or FAILED) before the `delay_duration`<br>time period.<br><br>This field is specified as a time duration, in RFC 3339 format.<br><br>Notes:<br>This feature is only supported for card payments.<br><br>Default:<br><br>- Card-present payments: "PT36H" (36 hours) from the creation time.<br>- Card-not-present payments: "P7D" (7 days) from the creation time. | String getDelayDuration() |
| `DelayAction` | `String` | Optional | The action to be applied to the payment when the `delay_duration` has elapsed. This field<br>is read-only.<br><br>Current values include `CANCEL`. | String getDelayAction() |
| `DelayedUntil` | `String` | Optional | The read-only timestamp of when the `delay_action` is automatically applied,<br>in RFC 3339 format.<br><br>Note that this field is calculated by summing the payment's `delay_duration` and `created_at`<br>fields. The `created_at` field is generated by Square and might not exactly match the<br>time on your local machine. | String getDelayedUntil() |
| `SourceType` | `String` | Optional | The source type for this payment.<br><br>Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`, `CASH`, or `EXTERNAL`.<br>**Constraints**: *Maximum Length*: `50` | String getSourceType() |
| `CardDetails` | [`CardPaymentDetails`](/doc/models/card-payment-details.md) | Optional | Reflects the current status of a card payment. Contains only non-confidential information. | CardPaymentDetails getCardDetails() |
| `CashDetails` | [`CashPaymentDetails`](/doc/models/cash-payment-details.md) | Optional | Stores details about a cash payment. Contains only non-confidential information. For more information, see<br>[Take Cash Payments](https://developer.squareup.com/docs/payments-api/take-payments/cash-payments). | CashPaymentDetails getCashDetails() |
| `BankAccountDetails` | [`BankAccountPaymentDetails`](/doc/models/bank-account-payment-details.md) | Optional | Additional details about BANK_ACCOUNT type payments. | BankAccountPaymentDetails getBankAccountDetails() |
| `ExternalDetails` | [`ExternalPaymentDetails`](/doc/models/external-payment-details.md) | Optional | Stores details about an external payment. Contains only non-confidential information.<br>For more information, see<br>[Take External Payments](https://developer.squareup.com/docs/payments-api/take-payments/external-payments). | ExternalPaymentDetails getExternalDetails() |
| `WalletDetails` | [`DigitalWalletDetails`](/doc/models/digital-wallet-details.md) | Optional | Additional details about `WALLET` type payments. Contains only non-confidential information. | DigitalWalletDetails getWalletDetails() |
| `LocationId` | `String` | Optional | The ID of the location associated with the payment.<br>**Constraints**: *Maximum Length*: `50` | String getLocationId() |
| `OrderId` | `String` | Optional | The ID of the order associated with the payment.<br>**Constraints**: *Maximum Length*: `192` | String getOrderId() |
| `ReferenceId` | `String` | Optional | An optional ID that associates the payment with an entity in<br>another system.<br>**Constraints**: *Maximum Length*: `40` | String getReferenceId() |
| `CustomerId` | `String` | Optional | The [Customer](/doc/models/customer.md) ID of the customer associated with the payment.<br>**Constraints**: *Maximum Length*: `191` | String getCustomerId() |
| `EmployeeId` | `String` | Optional | An optional ID of the employee associated with taking the payment.<br>**Constraints**: *Maximum Length*: `192` | String getEmployeeId() |
| `RefundIds` | `List<String>` | Optional | A list of `refund_id`s identifying refunds for the payment. | List<String> getRefundIds() |
| `RiskEvaluation` | [`RiskEvaluation`](/doc/models/risk-evaluation.md) | Optional | Represents fraud risk information for the associated payment.<br><br>When you take a payment through Square's Payments API (using the `CreatePayment`<br>endpoint), Square evaluates it and assigns a risk level to the payment. Sellers<br>can use this information to determine the course of action (for example,<br>provide the goods/services or refund the payment). | RiskEvaluation getRiskEvaluation() |
| `BuyerEmailAddress` | `String` | Optional | The buyer's email address.<br>**Constraints**: *Maximum Length*: `255` | String getBuyerEmailAddress() |
| `BillingAddress` | [`Address`](/doc/models/address.md) | Optional | Represents a physical address. | Address getBillingAddress() |
| `ShippingAddress` | [`Address`](/doc/models/address.md) | Optional | Represents a physical address. | Address getShippingAddress() |
| `Note` | `String` | Optional | An optional note to include when creating a payment.<br>**Constraints**: *Maximum Length*: `500` | String getNote() |
| `StatementDescriptionIdentifier` | `String` | Optional | Additional payment information that gets added to the customer's card statement<br>as part of the statement description.<br><br>Note that the `statement_description_identifier` might get truncated on the statement description<br>to fit the required information including the Square identifier (SQ *) and the name of the<br>seller taking the payment. | String getStatementDescriptionIdentifier() |
| `Capabilities` | `List<String>` | Optional | Actions that can be performed on this payment:<br><br>- `EDIT_AMOUNT_UP` - The payment amount can be edited up.<br>- `EDIT_AMOUNT_DOWN` - The payment amount can be edited down.<br>- `EDIT_TIP_AMOUNT_UP` - The tip amount can be edited up.<br>- `EDIT_TIP_AMOUNT_DOWN` - The tip amount can be edited down. | List<String> getCapabilities() |
| `ReceiptNumber` | `String` | Optional | The payment's receipt number.<br>The field is missing if a payment is canceled.<br>**Constraints**: *Maximum Length*: `4` | String getReceiptNumber() |
| `ReceiptUrl` | `String` | Optional | The URL for the payment's receipt.<br>The field is only populated for COMPLETED payments.<br>**Constraints**: *Maximum Length*: `255` | String getReceiptUrl() |
| `VersionToken` | `String` | Optional | Used for optimistic concurrency. This opaque token identifies a specific version of the<br>`Payment` object. | String getVersionToken() |

## Example (as JSON)

```json
{
  "id": "id0",
  "created_at": "created_at2",
  "updated_at": "updated_at4",
  "amount_money": {
    "amount": 186,
    "currency": "NGN"
  },
  "tip_money": {
    "amount": 190,
    "currency": "CHE"
  }
}
```

