
# Batch Delete Catalog Objects Response

## Structure

`BatchDeleteCatalogObjectsResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `DeletedObjectIds` | `List<String>` | Optional | The IDs of all CatalogObjects deleted by this request. | List<String> getDeletedObjectIds() |
| `DeletedAt` | `String` | Optional | The database [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) of this deletion in RFC 3339 format, e.g., "2016-09-04T23:59:33.123Z". | String getDeletedAt() |

## Example (as JSON)

```json
{
  "deleted_at": "2016-11-16T22:25:24.878Z",
  "deleted_object_ids": [
    "W62UWFY35CWMYGVWK6TWJDNI",
    "AA27W3M2GGTF3H6AVPNB77CK"
  ],
  "errors": [
    {
      "category": "MERCHANT_SUBSCRIPTION_ERROR",
      "code": "INVALID_EXPIRATION",
      "detail": "detail6",
      "field": "field4"
    }
  ]
}
```

