
# Checkout Location Settings Policy

## Structure

`CheckoutLocationSettingsPolicy`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Uid` | `String` | Optional | A unique ID to identify the policy when making changes. You must set the UID for policy updates, but it’s optional when setting new policies. | String getUid() |
| `Title` | `String` | Optional | The title of the policy. This is required when setting the description, though you can update it in a different request.<br>**Constraints**: *Maximum Length*: `50` | String getTitle() |
| `Description` | `String` | Optional | The description of the policy.<br>**Constraints**: *Maximum Length*: `4096` | String getDescription() |

## Example (as JSON)

```json
{
  "uid": "uid0",
  "title": "title6",
  "description": "description0"
}
```

