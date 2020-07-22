## Search Catalog Items Response

Defines the response body returned from the [SearchCatalogItems](#endpoint-Catalog-SearchCatalogItems) endpoint.

### Structure

`SearchCatalogItemsResponse`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Errors detected when the call to [SearchCatalogItems](#endpoint-Catalog-SearchCatalogItems) endpoint fails. |
| `Items` | [`List<CatalogObject>`](/doc/models/catalog-object.md) | Optional | Returned items matching the specified query expressions. |
| `Cursor` | `String` | Optional | Pagination token used in the next request to return more of the search result. |
| `MatchedVariationIds` | `List<String>` | Optional | Ids of returned item variations matching the specified query expression. |

### Example (as JSON)

```json
{
  "errors": null,
  "items": null,
  "cursor": null,
  "matched_variation_ids": null
}
```

