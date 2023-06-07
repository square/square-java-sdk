
# Data Collection Options

## Structure

`DataCollectionOptions`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Title` | `String` | Required | The title text to display in the data collection flow on the Terminal.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `250` | String getTitle() |
| `Body` | `String` | Required | The body text to display under the title in the data collection screen flow on the<br>Terminal.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `10000` | String getBody() |
| `InputType` | [`String`](../../doc/models/data-collection-options-input-type.md) | Required | Describes the input type of the data. | String getInputType() |
| `CollectedData` | [`CollectedData`](../../doc/models/collected-data.md) | Optional | - | CollectedData getCollectedData() |

## Example (as JSON)

```json
{
  "title": "title4",
  "body": "body6",
  "input_type": "EMAIL",
  "collected_data": {
    "input_text": "input_text0"
  }
}
```

