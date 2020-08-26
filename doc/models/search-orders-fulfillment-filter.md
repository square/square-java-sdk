## Search Orders Fulfillment Filter

Filter based on [Order Fulfillment](#type-orderfulfillment) information.

### Structure

`SearchOrdersFulfillmentFilter`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `FulfillmentTypes` | [`List<String>`](/doc/models/order-fulfillment-type.md) | Optional | List of [fulfillment types](#type-orderfulfillmenttype) to filter<br>for. Will return orders if any of its fulfillments match any of the fulfillment types<br>listed in this field.<br>See [OrderFulfillmentType](#type-orderfulfillmenttype) for possible values | List<String> getFulfillmentTypes() |
| `FulfillmentStates` | [`List<String>`](/doc/models/order-fulfillment-state.md) | Optional | List of [fulfillment states](#type-orderfulfillmentstate) to filter<br>for. Will return orders if any of its fulfillments match any of the<br>fulfillment states listed in this field.<br>See [OrderFulfillmentState](#type-orderfulfillmentstate) for possible values | List<String> getFulfillmentStates() |

### Example (as JSON)

```json
{
  "fulfillment_types": [
    "SHIPMENT",
    "PICKUP"
  ],
  "fulfillment_states": [
    "PROPOSED"
  ]
}
```

