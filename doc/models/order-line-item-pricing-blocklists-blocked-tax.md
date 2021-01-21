
# Order Line Item Pricing Blocklists Blocked Tax

A tax to block from applying to a line item. The tax must be
identified by either `tax_uid` or `tax_catalog_object_id`, but not both.

## Structure

`OrderLineItemPricingBlocklistsBlockedTax`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Uid` | `String` | Optional | Unique ID of the `BlockedTax` within the order.<br>**Constraints**: *Maximum Length*: `60` | String getUid() |
| `TaxUid` | `String` | Optional | The `uid` of the tax that should be blocked. Use this field to block<br>ad-hoc taxes. For catalog taxes use the `tax_catalog_object_id` field.<br>**Constraints**: *Maximum Length*: `60` | String getTaxUid() |
| `TaxCatalogObjectId` | `String` | Optional | The `catalog_object_id` of the tax that should be blocked.<br>Use this field to block catalog taxes. For ad-hoc taxes use the<br>`tax_uid` field.<br>**Constraints**: *Maximum Length*: `192` | String getTaxCatalogObjectId() |

## Example (as JSON)

```json
{
  "uid": "uid0",
  "tax_uid": "tax_uid4",
  "tax_catalog_object_id": "tax_catalog_object_id4"
}
```

