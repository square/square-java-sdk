
# Site

Represents a Square Online site, which is an online store for a Square seller.

## Structure

`Site`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The Square-assigned ID of the site.<br>**Constraints**: *Maximum Length*: `32` | String getId() |
| `SiteTitle` | `String` | Optional | The title of the site. | String getSiteTitle() |
| `Domain` | `String` | Optional | The domain of the site (without the protocol). For example, `mysite1.square.site`. | String getDomain() |
| `IsPublished` | `Boolean` | Optional | Indicates whether the site is published. | Boolean getIsPublished() |
| `CreatedAt` | `String` | Optional | The timestamp of when the site was created, in RFC 3339 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp of when the site was last updated, in RFC 3339 format. | String getUpdatedAt() |

## Example (as JSON)

```json
{
  "site_title": null,
  "domain": null,
  "is_published": null
}
```

