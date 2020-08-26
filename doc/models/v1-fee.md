## V1 Fee

V1Fee

### Structure

`V1Fee`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The fee's unique ID. | String getId() |
| `Name` | `String` | Optional | The fee's name. | String getName() |
| `Rate` | `String` | Optional | The rate of the fee, as a string representation of a decimal number. A value of 0.07 corresponds to a rate of 7%. | String getRate() |
| `CalculationPhase` | [`String`](/doc/models/v1-fee-calculation-phase.md) | Optional | - | String getCalculationPhase() |
| `AdjustmentType` | [`String`](/doc/models/v1-fee-adjustment-type.md) | Optional | - | String getAdjustmentType() |
| `AppliesToCustomAmounts` | `Boolean` | Optional | If true, the fee applies to custom amounts entered into Square Point of Sale that are not associated with a particular item. | Boolean getAppliesToCustomAmounts() |
| `Enabled` | `Boolean` | Optional | If true, the fee is applied to all appropriate items. If false, the fee is not applied at all. | Boolean getEnabled() |
| `InclusionType` | [`String`](/doc/models/v1-fee-inclusion-type.md) | Optional | - | String getInclusionType() |
| `Type` | [`String`](/doc/models/v1-fee-type.md) | Optional | - | String getType() |
| `V2Id` | `String` | Optional | The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID. | String getV2Id() |

### Example (as JSON)

```json
{
  "id": "id0",
  "name": "name0",
  "rate": "rate0",
  "calculation_phase": "FEE_TOTAL_PHASE",
  "adjustment_type": "TAX"
}
```

