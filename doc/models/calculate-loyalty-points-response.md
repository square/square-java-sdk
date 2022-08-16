
# Calculate Loyalty Points Response

Represents a [CalculateLoyaltyPoints](../../doc/api/loyalty.md#calculate-loyalty-points) response.

## Structure

`CalculateLoyaltyPointsResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `Points` | `Integer` | Optional | The number of points that the buyer can earn from the base loyalty program. | Integer getPoints() |
| `PromotionPoints` | `Integer` | Optional | The number of points that the buyer can earn from a loyalty promotion. To be eligible<br>to earn promotion points, the purchase must first qualify for program points. When `order_id`<br>is not provided in the request, this value is always 0. | Integer getPromotionPoints() |

## Example (as JSON)

```json
{
  "points": 6,
  "promotion_points": 12
}
```

