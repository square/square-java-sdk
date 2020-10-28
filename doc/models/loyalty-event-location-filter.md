
# Loyalty Event Location Filter

Filter events by location.

## Structure

`LoyaltyEventLocationFilter`

## Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `LocationIds` | `List<String>` | The [location](#type-Location) IDs for loyalty events to query.<br>If multiple values are specified, the endpoint uses<br>a logical OR to combine them. | List<String> getLocationIds() |

## Example (as JSON)

```json
{
  "location_ids": [
    "location_ids0"
  ]
}
```

