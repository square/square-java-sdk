
# List Payments Request

Describes a request to list payments using
[ListPayments](../../doc/api/payments.md#list-payments).

The maximum results per page is 100.

## Structure

`ListPaymentsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `BeginTime` | `String` | Optional | Indicates the start of the time range to retrieve payments for, in RFC 3339 format.  <br>The range is determined using the `created_at` field for each Payment.<br>Inclusive. Default: The current time minus one year. | String getBeginTime() |
| `EndTime` | `String` | Optional | Indicates the end of the time range to retrieve payments for, in RFC 3339 format.  The<br>range is determined using the `created_at` field for each Payment.<br><br>Default: The current time. | String getEndTime() |
| `SortOrder` | `String` | Optional | The order in which results are listed by `ListPaymentsRequest.sort_field`:<br><br>- `ASC` - Oldest to newest.<br>- `DESC` - Newest to oldest (default). | String getSortOrder() |
| `Cursor` | `String` | Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br><br>For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). | String getCursor() |
| `LocationId` | `String` | Optional | Limit results to the location supplied. By default, results are returned<br>for the default (main) location associated with the seller. | String getLocationId() |
| `Total` | `Long` | Optional | The exact amount in the `total_money` for a payment. | Long getTotal() |
| `Last4` | `String` | Optional | The last four digits of a payment card. | String getLast4() |
| `CardBrand` | `String` | Optional | The brand of the payment card (for example, VISA). | String getCardBrand() |
| `Limit` | `Integer` | Optional | The maximum number of results to be returned in a single page.<br>It is possible to receive fewer results than the specified limit on a given page.<br><br>The default value of 100 is also the maximum allowed value. If the provided value is<br>greater than 100, it is ignored and the default value is used instead.<br><br>Default: `100` | Integer getLimit() |
| `IsOfflinePayment` | `Boolean` | Optional | Whether the payment was taken offline or not. | Boolean getIsOfflinePayment() |
| `OfflineBeginTime` | `String` | Optional | Indicates the start of the time range for which to retrieve offline payments, in RFC 3339<br>format for timestamps. The range is determined using the<br>`offline_payment_details.client_created_at` field for each Payment. If set, payments without a<br>value set in `offline_payment_details.client_created_at` will not be returned.<br><br>Default: The current time. | String getOfflineBeginTime() |
| `OfflineEndTime` | `String` | Optional | Indicates the end of the time range for which to retrieve offline payments, in RFC 3339<br>format for timestamps. The range is determined using the<br>`offline_payment_details.client_created_at` field for each Payment. If set, payments without a<br>value set in `offline_payment_details.client_created_at` will not be returned.<br><br>Default: The current time. | String getOfflineEndTime() |
| `UpdatedAtBeginTime` | `String` | Optional | Indicates the start of the time range to retrieve payments for, in RFC 3339 format.  The<br>range is determined using the `updated_at` field for each Payment. | String getUpdatedAtBeginTime() |
| `UpdatedAtEndTime` | `String` | Optional | Indicates the end of the time range to retrieve payments for, in RFC 3339 format.  The<br>range is determined using the `updated_at` field for each Payment. | String getUpdatedAtEndTime() |
| `SortField` | [`String`](../../doc/models/payment-sort-field.md) | Optional | - | String getSortField() |

## Example (as JSON)

```json
{
  "begin_time": "begin_time0",
  "end_time": "end_time4",
  "sort_order": "sort_order2",
  "cursor": "cursor4",
  "location_id": "location_id6"
}
```

