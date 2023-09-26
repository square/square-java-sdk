
# Confirmation Options

## Structure

`ConfirmationOptions`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Title` | `String` | Required | The title text to display in the confirmation screen flow on the Terminal.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `250` | String getTitle() |
| `Body` | `String` | Required | The agreement details to display in the confirmation flow on the Terminal.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `10000` | String getBody() |
| `AgreeButtonText` | `String` | Required | The button text to display indicating the customer agrees to the displayed terms.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `250` | String getAgreeButtonText() |
| `DisagreeButtonText` | `String` | Optional | The button text to display indicating the customer does not agree to the displayed terms.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `250` | String getDisagreeButtonText() |
| `Decision` | [`ConfirmationDecision`](../../doc/models/confirmation-decision.md) | Optional | - | ConfirmationDecision getDecision() |

## Example (as JSON)

```json
{
  "title": "title0",
  "body": "body0",
  "agree_button_text": "agree_button_text8",
  "disagree_button_text": "disagree_button_text8",
  "decision": {
    "has_agreed": false
  }
}
```

