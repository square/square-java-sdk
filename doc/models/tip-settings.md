
# Tip Settings

## Structure

`TipSettings`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AllowTipping` | `Boolean` | Optional | Indicates whether tipping is enabled for this checkout. Defaults to false. | Boolean getAllowTipping() |
| `SeparateTipScreen` | `Boolean` | Optional | Indicates whether tip options should be presented on their own screen before presenting<br>the signature screen during card payment. Defaults to false. | Boolean getSeparateTipScreen() |
| `CustomTipField` | `Boolean` | Optional | Indicates whether custom tip amounts are allowed during the checkout flow. Defaults to false. | Boolean getCustomTipField() |

## Example (as JSON)

```json
{
  "allow_tipping": false,
  "separate_tip_screen": false,
  "custom_tip_field": false
}
```

