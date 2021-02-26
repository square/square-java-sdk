
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Booking type.
 */
public class Booking {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer version;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String startAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customerNote;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sellerNote;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<AppointmentSegment> appointmentSegments;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  version  Integer value for version.
     * @param  status  String value for status.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  startAt  String value for startAt.
     * @param  locationId  String value for locationId.
     * @param  customerId  String value for customerId.
     * @param  customerNote  String value for customerNote.
     * @param  sellerNote  String value for sellerNote.
     * @param  appointmentSegments  List of AppointmentSegment value for appointmentSegments.
     */
    @JsonCreator
    public Booking(
            @JsonProperty("id") String id,
            @JsonProperty("version") Integer version,
            @JsonProperty("status") String status,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("start_at") String startAt,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("customer_note") String customerNote,
            @JsonProperty("seller_note") String sellerNote,
            @JsonProperty("appointment_segments") List<AppointmentSegment> appointmentSegments) {
        this.id = id;
        this.version = version;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.startAt = startAt;
        this.locationId = locationId;
        this.customerId = customerId;
        this.customerNote = customerNote;
        this.sellerNote = sellerNote;
        this.appointmentSegments = appointmentSegments;
    }

    /**
     * Getter for Id.
     * A unique ID of this object representing a booking.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Version.
     * The revision number for the booking used for optimistic concurrency.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for Status.
     * Supported booking statuses.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp specifying the creation time of this booking.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp specifying the most recent update time of this booking.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for StartAt.
     * The timestamp specifying the starting time of this booking.
     * @return Returns the String
     */
    @JsonGetter("start_at")
    public String getStartAt() {
        return startAt;
    }

    /**
     * Getter for LocationId.
     * The ID of the [Location](#type-location) object representing the location where the booked
     * service is provided.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the [Customer](#type-Customer) object representing the customer attending this
     * booking
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for CustomerNote.
     * The free-text field for the customer to supply notes about the booking. For example, the note
     * can be preferences that cannot be expressed by supported attributes of a relevant
     * [CatalogObject](#type-CatalogObject) instance.
     * @return Returns the String
     */
    @JsonGetter("customer_note")
    public String getCustomerNote() {
        return customerNote;
    }

    /**
     * Getter for SellerNote.
     * The free-text field for the seller to supply notes about the booking. For example, the note
     * can be preferences that cannot be expressed by supported attributes of a specific
     * [CatalogObject](#type-CatalogObject) instance. This field should not be visible to customers.
     * @return Returns the String
     */
    @JsonGetter("seller_note")
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * Getter for AppointmentSegments.
     * A list of appointment segments for this booking.
     * @return Returns the List of AppointmentSegment
     */
    @JsonGetter("appointment_segments")
    public List<AppointmentSegment> getAppointmentSegments() {
        return appointmentSegments;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, status, createdAt, updatedAt, startAt, locationId,
                customerId, customerNote, sellerNote, appointmentSegments);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(version, other.version)
            && Objects.equals(status, other.status)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(startAt, other.startAt)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(customerNote, other.customerNote)
            && Objects.equals(sellerNote, other.sellerNote)
            && Objects.equals(appointmentSegments, other.appointmentSegments);
    }

    /**
     * Converts this Booking into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Booking [" + "id=" + id + ", version=" + version + ", status=" + status
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", startAt=" + startAt
                + ", locationId=" + locationId + ", customerId=" + customerId + ", customerNote="
                + customerNote + ", sellerNote=" + sellerNote + ", appointmentSegments="
                + appointmentSegments + "]";
    }

    /**
     * Builds a new {@link Booking.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Booking.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .version(getVersion())
                .status(getStatus())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .startAt(getStartAt())
                .locationId(getLocationId())
                .customerId(getCustomerId())
                .customerNote(getCustomerNote())
                .sellerNote(getSellerNote())
                .appointmentSegments(getAppointmentSegments());
        return builder;
    }

    /**
     * Class to build instances of {@link Booking}.
     */
    public static class Builder {
        private String id;
        private Integer version;
        private String status;
        private String createdAt;
        private String updatedAt;
        private String startAt;
        private String locationId;
        private String customerId;
        private String customerNote;
        private String sellerNote;
        private List<AppointmentSegment> appointmentSegments;



        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for startAt.
         * @param  startAt  String value for startAt.
         * @return Builder
         */
        public Builder startAt(String startAt) {
            this.startAt = startAt;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Setter for customerNote.
         * @param  customerNote  String value for customerNote.
         * @return Builder
         */
        public Builder customerNote(String customerNote) {
            this.customerNote = customerNote;
            return this;
        }

        /**
         * Setter for sellerNote.
         * @param  sellerNote  String value for sellerNote.
         * @return Builder
         */
        public Builder sellerNote(String sellerNote) {
            this.sellerNote = sellerNote;
            return this;
        }

        /**
         * Setter for appointmentSegments.
         * @param  appointmentSegments  List of AppointmentSegment value for appointmentSegments.
         * @return Builder
         */
        public Builder appointmentSegments(List<AppointmentSegment> appointmentSegments) {
            this.appointmentSegments = appointmentSegments;
            return this;
        }

        /**
         * Builds a new {@link Booking} object using the set fields.
         * @return {@link Booking}
         */
        public Booking build() {
            return new Booking(id, version, status, createdAt, updatedAt, startAt, locationId,
                    customerId, customerNote, sellerNote, appointmentSegments);
        }
    }
}
