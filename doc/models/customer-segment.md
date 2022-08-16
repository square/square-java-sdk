
# Customer Segment

Represents a group of customer profiles that match one or more predefined filter criteria.

Segments (also known as Smart Groups) are defined and created within the Customer Directory in the
Square Seller Dashboard or Point of Sale.

## Structure

`CustomerSegment`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A unique Square-generated ID for the segment.<br>**Constraints**: *Maximum Length*: `255` | String getId() |
| `Name` | `String` | Required | The name of the segment. | String getName() |
| `CreatedAt` | `String` | Optional | The timestamp when the segment was created, in RFC 3339 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp when the segment was last updated, in RFC 3339 format. | String getUpdatedAt() |

## Example (as JSON)

```json
{}
```

