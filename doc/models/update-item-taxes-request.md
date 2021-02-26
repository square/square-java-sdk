
# Update Item Taxes Request

## Structure

`UpdateItemTaxesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `ItemIds` | `List<String>` | Required | IDs for the CatalogItems associated with the CatalogTax objects being updated. | List<String> getItemIds() |
| `TaxesToEnable` | `List<String>` | Optional | IDs of the CatalogTax objects to enable. | List<String> getTaxesToEnable() |
| `TaxesToDisable` | `List<String>` | Optional | IDs of the CatalogTax objects to disable. | List<String> getTaxesToDisable() |

## Example (as JSON)

```json
{
  "item_ids": [
    "H42BRLUJ5KTZTTMPVSLFAACQ",
    "2JXOBJIHCWBQ4NZ3RIXQGJA6"
  ],
  "taxes_to_disable": [
    "AQCEGCEBBQONINDOHRGZISEX"
  ],
  "taxes_to_enable": [
    "4WRCNHCJZDVLSNDQ35PP6YAD"
  ]
}
```

