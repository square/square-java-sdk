
# Search Subscriptions Query

Represents a query, consisting of specified query expressions, used to search for subscriptions.

## Structure

`SearchSubscriptionsQuery`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Filter` | [`SearchSubscriptionsFilter`](../../doc/models/search-subscriptions-filter.md) | Optional | Represents a set of query expressions (filters) to narrow the scope of targeted subscriptions returned by<br>the [SearchSubscriptions](../../doc/api/subscriptions.md#search-subscriptions) endpoint. | SearchSubscriptionsFilter getFilter() |

## Example (as JSON)

```json
{
  "filter": null
}
```

