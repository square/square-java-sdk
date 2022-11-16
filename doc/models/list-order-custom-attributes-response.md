
# List Order Custom Attributes Response

Represents a response from listing order custom attributes.

## Structure

`ListOrderCustomAttributesResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CustomAttributes` | [`List<CustomAttribute>`](../../doc/models/custom-attribute.md) | Optional | The retrieved custom attributes. If no custom attribute are found, Square returns an empty object (`{}`). | List<CustomAttribute> getCustomAttributes() |
| `Cursor` | `String` | Optional | The cursor to provide in your next call to this endpoint to retrieve the next page of results for your original request.<br>This field is present only if the request succeeded and additional results are available.<br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). | String getCursor() |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "custom_attributes": null,
  "cursor": null,
  "errors": null
}
```

