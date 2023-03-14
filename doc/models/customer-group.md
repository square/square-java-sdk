
# Customer Group

Represents a group of customer profiles.

Customer groups can be created, be modified, and have their membership defined using
the Customers API or within the Customer Directory in the Square Seller Dashboard or Point of Sale.

## Structure

`CustomerGroup`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A unique Square-generated ID for the customer group.<br>**Constraints**: *Maximum Length*: `255` | String getId() |
| `Name` | `String` | Required | The name of the customer group. | String getName() |
| `CreatedAt` | `String` | Optional | The timestamp when the customer group was created, in RFC 3339 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp when the customer group was last updated, in RFC 3339 format. | String getUpdatedAt() |

## Example (as JSON)

```json
{
  "id": null,
  "name": "name0",
  "created_at": null,
  "updated_at": null
}
```

