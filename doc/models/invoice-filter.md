
# Invoice Filter

Describes query filters to apply.

## Structure

`InvoiceFilter`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LocationIds` | `List<String>` | Required | Limits the search to the specified locations. A location is required.<br>In the current implementation, only one location can be specified. | List<String> getLocationIds() |
| `CustomerIds` | `List<String>` | Optional | Limits the search to the specified customers, within the specified locations.<br>Specifying a customer is optional. In the current implementation,<br>a maximum of one customer can be specified. | List<String> getCustomerIds() |

## Example (as JSON)

```json
{
  "location_ids": [
    "location_ids0"
  ],
  "customer_ids": null
}
```

