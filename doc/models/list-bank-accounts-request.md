
# List Bank Accounts Request

Request object for fetching all `BankAccount`
objects linked to a account.

## Structure

`ListBankAccountsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Cursor` | `String` | Optional | The pagination cursor returned by a previous call to this endpoint.<br>Use it in the next `ListBankAccounts` request to retrieve the next set<br>of results.<br><br>See the [Pagination](../../https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information. | String getCursor() |
| `Limit` | `Integer` | Optional | Upper limit on the number of bank accounts to return in the response.<br>Currently, 1000 is the largest supported limit. You can specify a limit<br>of up to 1000 bank accounts. This is also the default limit. | Integer getLimit() |
| `LocationId` | `String` | Optional | Location ID. You can specify this optional filter<br>to retrieve only the linked bank accounts belonging to a specific location. | String getLocationId() |

## Example (as JSON)

```json
{
  "cursor": "cursor6",
  "limit": 172,
  "location_id": "location_id4"
}
```

