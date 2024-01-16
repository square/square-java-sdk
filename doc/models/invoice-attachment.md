
# Invoice Attachment

Represents a file attached to an [invoice](../../doc/models/invoice.md).

## Structure

`InvoiceAttachment`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The Square-assigned ID of the attachment. | String getId() |
| `Filename` | `String` | Optional | The file name of the attachment, which is displayed on the invoice. | String getFilename() |
| `Description` | `String` | Optional | The description of the attachment, which is displayed on the invoice.<br>This field maps to the seller-defined **Message** field. | String getDescription() |
| `Filesize` | `Integer` | Optional | The file size of the attachment in bytes. | Integer getFilesize() |
| `Hash` | `String` | Optional | The MD5 hash that was generated from the file contents. | String getHash() |
| `MimeType` | `String` | Optional | The mime type of the attachment.<br>The following mime types are supported:<br>image/gif, image/jpeg, image/png, image/tiff, image/bmp, application/pdf. | String getMimeType() |
| `UploadedAt` | `String` | Optional | The timestamp when the attachment was uploaded, in RFC 3339 format. | String getUploadedAt() |

## Example (as JSON)

```json
{
  "id": "id4",
  "filename": "filename6",
  "description": "description6",
  "filesize": 164,
  "hash": "hash0"
}
```

