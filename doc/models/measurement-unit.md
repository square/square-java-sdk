## Measurement Unit

Represents a unit of measurement to use with a quantity, such as ounces
or inches. Exactly one of the following fields are required: `custom_unit`,
`area_unit`, `length_unit`, `volume_unit`, and `weight_unit`.

### Structure

`MeasurementUnit`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CustomUnit` | [`MeasurementUnitCustom`](/doc/models/measurement-unit-custom.md) | Optional | The information needed to define a custom unit, provided by the seller. | MeasurementUnitCustom getCustomUnit() |
| `AreaUnit` | [`String`](/doc/models/measurement-unit-area.md) | Optional | Unit of area used to measure a quantity. | String getAreaUnit() |
| `LengthUnit` | [`String`](/doc/models/measurement-unit-length.md) | Optional | The unit of length used to measure a quantity. | String getLengthUnit() |
| `VolumeUnit` | [`String`](/doc/models/measurement-unit-volume.md) | Optional | The unit of volume used to measure a quantity. | String getVolumeUnit() |
| `WeightUnit` | [`String`](/doc/models/measurement-unit-weight.md) | Optional | Unit of weight used to measure a quantity. | String getWeightUnit() |
| `GenericUnit` | [`String`](/doc/models/measurement-unit-generic.md) | Optional | - | String getGenericUnit() |
| `TimeUnit` | [`String`](/doc/models/measurement-unit-time.md) | Optional | Unit of time used to measure a quantity (a duration). | String getTimeUnit() |
| `Type` | [`String`](/doc/models/measurement-unit-unit-type.md) | Optional | Describes the type of this unit and indicates which field contains the unit information. This is an ‘open’ enum. | String getType() |

### Example (as JSON)

```json
{
  "custom_unit": {
    "name": "name2",
    "abbreviation": "abbreviation4"
  },
  "area_unit": "IMPERIAL_SQUARE_MILE",
  "length_unit": "METRIC_MILLIMETER",
  "volume_unit": "GENERIC_CUP",
  "weight_unit": "IMPERIAL_STONE"
}
```

