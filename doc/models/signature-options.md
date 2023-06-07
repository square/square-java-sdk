
# Signature Options

## Structure

`SignatureOptions`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Title` | `String` | Required | The title text to display in the signature capture flow on the Terminal.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `250` | String getTitle() |
| `Body` | `String` | Required | The body text to display in the signature capture flow on the Terminal.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `10000` | String getBody() |
| `Signature` | [`List<SignatureImage>`](../../doc/models/signature-image.md) | Optional | An image representation of the collected signature. | List<SignatureImage> getSignature() |

## Example (as JSON)

```json
{
  "title": "title4",
  "body": "body6",
  "signature": [
    {
      "image_type": "image_type8",
      "data": "data2"
    }
  ]
}
```

