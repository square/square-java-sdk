
# Search Catalog Items Response

Defines the response body returned from the [SearchCatalogItems](../../doc/api/catalog.md#search-catalog-items) endpoint.

## Structure

`SearchCatalogItemsResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `Items` | [`List<CatalogObject>`](../../doc/models/catalog-object.md) | Optional | Returned items matching the specified query expressions. | List<CatalogObject> getItems() |
| `Cursor` | `String` | Optional | Pagination token used in the next request to return more of the search result. | String getCursor() |
| `MatchedVariationIds` | `List<String>` | Optional | Ids of returned item variations matching the specified query expression. | List<String> getMatchedVariationIds() |

## Example (as JSON)

```json
{
  "errors": null,
  "items": null,
  "cursor": null,
  "matched_variation_ids": null
}
```

