
# List Jobs Request

Represents a [ListJobs](../../doc/api/team.md#list-jobs) request.

## Structure

`ListJobsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Cursor` | `String` | Optional | The pagination cursor returned by the previous call to this endpoint. Provide this<br>cursor to retrieve the next page of results for your original request. For more information,<br>see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). | String getCursor() |

## Example (as JSON)

```json
{
  "cursor": "cursor4"
}
```

