
# Loyalty Account Mapping

Represents the mapping that associates a loyalty account with a buyer.

Currently, a loyalty account can only be mapped to a buyer by phone number. For more information, see
[Loyalty Overview](https://developer.squareup.com/docs/loyalty/overview).

## Structure

`LoyaltyAccountMapping`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The Square-assigned ID of the mapping.<br>**Constraints**: *Maximum Length*: `36` | String getId() |
| `CreatedAt` | `String` | Optional | The timestamp when the mapping was created, in RFC 3339 format. | String getCreatedAt() |
| `PhoneNumber` | `String` | Optional | The phone number of the buyer, in E.164 format. For example, "+14155551111". | String getPhoneNumber() |

## Example (as JSON)

```json
{
  "id": "id0",
  "created_at": "created_at2",
  "phone_number": "phone_number2"
}
```

