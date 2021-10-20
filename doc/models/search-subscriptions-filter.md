
# Search Subscriptions Filter

Represents a set of SearchSubscriptionsQuery filters used to limit the set of Subscriptions returned by SearchSubscriptions.

## Structure

`SearchSubscriptionsFilter`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CustomerIds` | `List<String>` | Optional | A filter to select subscriptions based on the customer. | List<String> getCustomerIds() |
| `LocationIds` | `List<String>` | Optional | A filter to select subscriptions based the location. | List<String> getLocationIds() |
| `SourceNames` | `List<String>` | Optional | A filter to select subscriptions based on the source application. | List<String> getSourceNames() |

## Example (as JSON)

```json
{
  "customer_ids": [
    "customer_ids1",
    "customer_ids2"
  ],
  "location_ids": [
    "location_ids0"
  ],
  "source_names": [
    "source_names8"
  ]
}
```

