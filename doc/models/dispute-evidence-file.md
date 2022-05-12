
# Dispute Evidence File

A file to be uploaded as dispute evidence.

## Structure

`DisputeEvidenceFile`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Filename` | `String` | Optional | The file name including the file extension. For example: "receipt.tiff".<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `40` | String getFilename() |
| `Filetype` | `String` | Optional | Dispute evidence files must be application/pdf, image/heic, image/heif, image/jpeg, image/png, or image/tiff formats.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `40` | String getFiletype() |

## Example (as JSON)

```json
{
  "filename": null,
  "filetype": null
}
```

