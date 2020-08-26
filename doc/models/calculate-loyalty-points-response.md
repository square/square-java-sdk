## Calculate Loyalty Points Response

A response that includes the points that the buyer can earn from 
a specified purchase.

### Structure

`CalculateLoyaltyPointsResponse`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `Points` | `Integer` | Optional | The points that the buyer can earn from a specified purchase. | Integer getPoints() |

### Example (as JSON)

```json
{
  "points": 6
}
```

