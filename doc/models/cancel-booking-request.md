
# Cancel Booking Request

## Structure

`CancelBookingRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `IdempotencyKey` | `String` | Optional | A unique key to make this request an idempotent operation. | String getIdempotencyKey() |
| `BookingVersion` | `Integer` | Optional | The revision number for the booking used for optimistic concurrency. | Integer getBookingVersion() |

## Example (as JSON)

```json
{
  "idempotency_key": "idempotency_key6",
  "booking_version": 0
}
```

