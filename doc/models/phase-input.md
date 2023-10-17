
# Phase Input

Represents the arguments used to construct a new phase.

## Structure

`PhaseInput`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Ordinal` | `long` | Required | index of phase in total subscription plan | long getOrdinal() |
| `OrderTemplateId` | `String` | Optional | id of order to be used in billing | String getOrderTemplateId() |

## Example (as JSON)

```json
{
  "ordinal": 234,
  "order_template_id": "order_template_id4"
}
```

