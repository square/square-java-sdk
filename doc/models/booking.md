
# Booking

Represents a booking as a time-bound service contract for a seller's staff member to provide a specified service
at a given location to a requesting customer in one or more appointment segments.

## Structure

`Booking`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A unique ID of this object representing a booking. | String getId() |
| `Version` | `Integer` | Optional | The revision number for the booking used for optimistic concurrency. | Integer getVersion() |
| `Status` | [`String`](/doc/models/booking-status.md) | Optional | Supported booking statuses. | String getStatus() |
| `CreatedAt` | `String` | Optional | The timestamp specifying the creation time of this booking. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp specifying the most recent update time of this booking. | String getUpdatedAt() |
| `StartAt` | `String` | Optional | The timestamp specifying the starting time of this booking. | String getStartAt() |
| `LocationId` | `String` | Optional | The ID of the [Location](#type-location) object representing the location where the booked service is provided. | String getLocationId() |
| `CustomerId` | `String` | Optional | The ID of the [Customer](#type-Customer) object representing the customer attending this booking | String getCustomerId() |
| `CustomerNote` | `String` | Optional | The free-text field for the customer to supply notes about the booking. For example, the note can be preferences that cannot be expressed by supported attributes of a relevant [CatalogObject](#type-CatalogObject) instance.<br>**Constraints**: *Maximum Length*: `4096` | String getCustomerNote() |
| `SellerNote` | `String` | Optional | The free-text field for the seller to supply notes about the booking. For example, the note can be preferences that cannot be expressed by supported attributes of a specific [CatalogObject](#type-CatalogObject) instance.<br>This field should not be visible to customers.<br>**Constraints**: *Maximum Length*: `4096` | String getSellerNote() |
| `AppointmentSegments` | [`List<AppointmentSegment>`](/doc/models/appointment-segment.md) | Optional | A list of appointment segments for this booking. | List<AppointmentSegment> getAppointmentSegments() |

## Example (as JSON)

```json
{
  "id": "id0",
  "version": 172,
  "status": "CANCELLED_BY_SELLER",
  "created_at": "created_at2",
  "updated_at": "updated_at4"
}
```

