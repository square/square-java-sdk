
# Snippet

Represents the snippet that is added to a Square Online site. The snippet code is injected into the `head` element of all pages on the site, except for checkout pages.

## Structure

`Snippet`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The Square-assigned ID for the snippet.<br>**Constraints**: *Maximum Length*: `48` | String getId() |
| `SiteId` | `String` | Optional | The ID of the site that contains the snippet. | String getSiteId() |
| `Content` | `String` | Required | The snippet code, which can contain valid HTML, JavaScript, or both.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `65535` | String getContent() |
| `CreatedAt` | `String` | Optional | The timestamp of when the snippet was initially added to the site, in RFC 3339 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp of when the snippet was last updated on the site, in RFC 3339 format. | String getUpdatedAt() |

## Example (as JSON)

```json
{
  "content": "content4"
}
```

