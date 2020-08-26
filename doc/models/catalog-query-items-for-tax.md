## Catalog Query Items for Tax

The query filter to return the items containing the specified tax IDs.

### Structure

`CatalogQueryItemsForTax`

### Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `TaxIds` | `List<String>` | A set of `CatalogTax` IDs to be used to find associated `CatalogItem`s. | List<String> getTaxIds() |

### Example (as JSON)

```json
{
  "tax_ids": [
    "tax_ids7"
  ]
}
```

