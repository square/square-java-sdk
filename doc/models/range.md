
# Range

The range of a number value between the specified lower and upper bounds.

## Structure

`Range`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Min` | `String` | Optional | The lower bound of the number range. At least one of `min` or `max` must be specified.<br>If unspecified, the results will have no minimum value. | String getMin() |
| `Max` | `String` | Optional | The upper bound of the number range. At least one of `min` or `max` must be specified.<br>If unspecified, the results will have no maximum value. | String getMax() |

## Example (as JSON)

```json
{
  "min": null,
  "max": null
}
```

