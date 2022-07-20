
# List Bookings Response

## Structure

`ListBookingsResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Bookings` | [`List<Booking>`](../../doc/models/booking.md) | Optional | The list of targeted bookings. | List<Booking> getBookings() |
| `Cursor` | `String` | Optional | The pagination cursor to be used in the subsequent request to get the next page of the results. Stop retrieving the next page of the results when the cursor is not set.<br>**Constraints**: *Maximum Length*: `65536` | String getCursor() |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Errors that occurred during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "bookings": null,
  "cursor": null,
  "errors": null
}
```

