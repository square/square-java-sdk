
# Search Vendors Request Filter

Defines supported query expressions to search for vendors by.

## Structure

`SearchVendorsRequestFilter`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Name` | `List<String>` | Optional | The names of the [Vendor](../../doc/models/vendor.md) objects to retrieve. | List<String> getName() |
| `Status` | [`List<String>`](../../doc/models/vendor-status.md) | Optional | The statuses of the [Vendor](../../doc/models/vendor.md) objects to retrieve.<br>See [VendorStatus](#type-vendorstatus) for possible values | List<String> getStatus() |

## Example (as JSON)

```json
{
  "name": [
    "name0",
    "name1",
    "name2"
  ],
  "status": [
    "ACTIVE",
    "INACTIVE",
    "ACTIVE"
  ]
}
```

