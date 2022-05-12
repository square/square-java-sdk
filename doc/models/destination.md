
# Destination

Information about the destination against which the payout was made.

## Structure

`Destination`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Type` | [`String`](../../doc/models/destination-type.md) | Optional | List of possible destinations against which a payout can be made. | String getType() |
| `Id` | `String` | Optional | Square issued unique ID (also known as the instrument ID) associated with this destination. | String getId() |

## Example (as JSON)

```json
{
  "type": null,
  "id": null
}
```

