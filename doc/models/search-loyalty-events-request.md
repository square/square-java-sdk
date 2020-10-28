
# Search Loyalty Events Request

A request to search for loyalty events.

## Structure

`SearchLoyaltyEventsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Query` | [`LoyaltyEventQuery`](/doc/models/loyalty-event-query.md) | Optional | Represents a query used to search for loyalty events. | LoyaltyEventQuery getQuery() |
| `Limit` | `Integer` | Optional | The maximum number of results to include in the response.<br>The last page might contain fewer events.<br>The default is 30 events. | Integer getLimit() |
| `Cursor` | `String` | Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for your original query.<br>For more information, see [Pagination](https://developer.squareup.com/docs/docs/basics/api101/pagination). | String getCursor() |

## Example (as JSON)

```json
{
  "limit": 30,
  "query": {
    "filter": {
      "order_filter": {
        "order_id": "PyATxhYLfsMqpVkcKJITPydgEYfZY"
      }
    }
  }
}
```

