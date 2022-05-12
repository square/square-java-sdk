
# Search Subscriptions Filter

Represents a set of query expressions (filters) to narrow the scope of targeted subscriptions returned by
the [SearchSubscriptions](../../doc/api/subscriptions.md#search-subscriptions) endpoint.

## Structure

`SearchSubscriptionsFilter`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CustomerIds` | `List<String>` | Optional | A filter to select subscriptions based on the subscribing customer IDs. | List<String> getCustomerIds() |
| `LocationIds` | `List<String>` | Optional | A filter to select subscriptions based on the location. | List<String> getLocationIds() |
| `SourceNames` | `List<String>` | Optional | A filter to select subscriptions based on the source application. | List<String> getSourceNames() |

## Example (as JSON)

```json
{
  "customer_ids": null,
  "location_ids": null,
  "source_names": null
}
```

