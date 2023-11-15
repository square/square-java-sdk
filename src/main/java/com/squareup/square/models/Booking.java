
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Booking type.
 */
public class Booking {
    private final String id;
    private final Integer version;
    private final String status;
    private final String createdAt;
    private final String updatedAt;
    private final OptionalNullable<String> startAt;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> customerId;
    private final OptionalNullable<String> customerNote;
    private final OptionalNullable<String> sellerNote;
    private final OptionalNullable<List<AppointmentSegment>> appointmentSegments;
    private final Integer transitionTimeMinutes;
    private final Boolean allDay;
    private final String locationType;
    private final BookingCreatorDetails creatorDetails;
    private final String source;

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
     * @param  transitionTimeMinutes  Integer value for transitionTimeMinutes.
     * @param  allDay  Boolean value for allDay.
     * @param  locationType  String value for locationType.
     * @param  creatorDetails  BookingCreatorDetails value for creatorDetails.
     * @param  source  String value for source.
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
            @JsonProperty("appointment_segments") List<AppointmentSegment> appointmentSegments,
            @JsonProperty("transition_time_minutes") Integer transitionTimeMinutes,
            @JsonProperty("all_day") Boolean allDay,
            @JsonProperty("location_type") String locationType,
            @JsonProperty("creator_details") BookingCreatorDetails creatorDetails,
            @JsonProperty("source") String source) {
        this.id = id;
        this.version = version;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.startAt = OptionalNullable.of(startAt);
        this.locationId = OptionalNullable.of(locationId);
        this.customerId = OptionalNullable.of(customerId);
        this.customerNote = OptionalNullable.of(customerNote);
        this.sellerNote = OptionalNullable.of(sellerNote);
        this.appointmentSegments = OptionalNullable.of(appointmentSegments);
        this.transitionTimeMinutes = transitionTimeMinutes;
        this.allDay = allDay;
        this.locationType = locationType;
        this.creatorDetails = creatorDetails;
        this.source = source;
    }

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
     * @param  transitionTimeMinutes  Integer value for transitionTimeMinutes.
     * @param  allDay  Boolean value for allDay.
     * @param  locationType  String value for locationType.
     * @param  creatorDetails  BookingCreatorDetails value for creatorDetails.
     * @param  source  String value for source.
     */

    protected Booking(String id, Integer version, String status, String createdAt, String updatedAt,
            OptionalNullable<String> startAt, OptionalNullable<String> locationId,
            OptionalNullable<String> customerId, OptionalNullable<String> customerNote,
            OptionalNullable<String> sellerNote,
            OptionalNullable<List<AppointmentSegment>> appointmentSegments,
            Integer transitionTimeMinutes, Boolean allDay, String locationType,
            BookingCreatorDetails creatorDetails, String source) {
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
        this.transitionTimeMinutes = transitionTimeMinutes;
        this.allDay = allDay;
        this.locationType = locationType;
        this.creatorDetails = creatorDetails;
        this.source = source;
    }

    /**
     * Getter for Id.
     * A unique ID of this object representing a booking.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Version.
     * The revision number for the booking used for optimistic concurrency.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for Status.
     * Supported booking statuses.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for CreatedAt.
     * The RFC 3339 timestamp specifying the creation time of this booking.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The RFC 3339 timestamp specifying the most recent update time of this booking.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Internal Getter for StartAt.
     * The RFC 3339 timestamp specifying the starting time of this booking.
     * @return Returns the Internal String
     */
    @JsonGetter("start_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStartAt() {
        return this.startAt;
    }

    /**
     * Getter for StartAt.
     * The RFC 3339 timestamp specifying the starting time of this booking.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStartAt() {
        return OptionalNullable.getFrom(startAt);
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the [Location](entity:Location) object representing the location where the booked
     * service is provided. Once set when the booking is created, its value cannot be changed.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The ID of the [Location](entity:Location) object representing the location where the booked
     * service is provided. Once set when the booking is created, its value cannot be changed.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for CustomerId.
     * The ID of the [Customer](entity:Customer) object representing the customer receiving the
     * booked service.
     * @return Returns the Internal String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the [Customer](entity:Customer) object representing the customer receiving the
     * booked service.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerId() {
        return OptionalNullable.getFrom(customerId);
    }

    /**
     * Internal Getter for CustomerNote.
     * The free-text field for the customer to supply notes about the booking. For example, the note
     * can be preferences that cannot be expressed by supported attributes of a relevant
     * [CatalogObject](entity:CatalogObject) instance.
     * @return Returns the Internal String
     */
    @JsonGetter("customer_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomerNote() {
        return this.customerNote;
    }

    /**
     * Getter for CustomerNote.
     * The free-text field for the customer to supply notes about the booking. For example, the note
     * can be preferences that cannot be expressed by supported attributes of a relevant
     * [CatalogObject](entity:CatalogObject) instance.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerNote() {
        return OptionalNullable.getFrom(customerNote);
    }

    /**
     * Internal Getter for SellerNote.
     * The free-text field for the seller to supply notes about the booking. For example, the note
     * can be preferences that cannot be expressed by supported attributes of a specific
     * [CatalogObject](entity:CatalogObject) instance. This field should not be visible to
     * customers.
     * @return Returns the Internal String
     */
    @JsonGetter("seller_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSellerNote() {
        return this.sellerNote;
    }

    /**
     * Getter for SellerNote.
     * The free-text field for the seller to supply notes about the booking. For example, the note
     * can be preferences that cannot be expressed by supported attributes of a specific
     * [CatalogObject](entity:CatalogObject) instance. This field should not be visible to
     * customers.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSellerNote() {
        return OptionalNullable.getFrom(sellerNote);
    }

    /**
     * Internal Getter for AppointmentSegments.
     * A list of appointment segments for this booking.
     * @return Returns the Internal List of AppointmentSegment
     */
    @JsonGetter("appointment_segments")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<AppointmentSegment>> internalGetAppointmentSegments() {
        return this.appointmentSegments;
    }

    /**
     * Getter for AppointmentSegments.
     * A list of appointment segments for this booking.
     * @return Returns the List of AppointmentSegment
     */
    @JsonIgnore
    public List<AppointmentSegment> getAppointmentSegments() {
        return OptionalNullable.getFrom(appointmentSegments);
    }

    /**
     * Getter for TransitionTimeMinutes.
     * Additional time at the end of a booking. Applications should not make this field visible to
     * customers of a seller.
     * @return Returns the Integer
     */
    @JsonGetter("transition_time_minutes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getTransitionTimeMinutes() {
        return transitionTimeMinutes;
    }

    /**
     * Getter for AllDay.
     * Whether the booking is of a full business day.
     * @return Returns the Boolean
     */
    @JsonGetter("all_day")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getAllDay() {
        return allDay;
    }

    /**
     * Getter for LocationType.
     * Supported types of location where service is provided.
     * @return Returns the String
     */
    @JsonGetter("location_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationType() {
        return locationType;
    }

    /**
     * Getter for CreatorDetails.
     * Information about a booking creator.
     * @return Returns the BookingCreatorDetails
     */
    @JsonGetter("creator_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public BookingCreatorDetails getCreatorDetails() {
        return creatorDetails;
    }

    /**
     * Getter for Source.
     * Supported sources a booking was created from.
     * @return Returns the String
     */
    @JsonGetter("source")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSource() {
        return source;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, status, createdAt, updatedAt, startAt, locationId,
                customerId, customerNote, sellerNote, appointmentSegments, transitionTimeMinutes,
                allDay, locationType, creatorDetails, source);
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
            && Objects.equals(appointmentSegments, other.appointmentSegments)
            && Objects.equals(transitionTimeMinutes, other.transitionTimeMinutes)
            && Objects.equals(allDay, other.allDay)
            && Objects.equals(locationType, other.locationType)
            && Objects.equals(creatorDetails, other.creatorDetails)
            && Objects.equals(source, other.source);
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
                + appointmentSegments + ", transitionTimeMinutes=" + transitionTimeMinutes
                + ", allDay=" + allDay + ", locationType=" + locationType + ", creatorDetails="
                + creatorDetails + ", source=" + source + "]";
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
                .transitionTimeMinutes(getTransitionTimeMinutes())
                .allDay(getAllDay())
                .locationType(getLocationType())
                .creatorDetails(getCreatorDetails())
                .source(getSource());
        builder.startAt = internalGetStartAt();
        builder.locationId = internalGetLocationId();
        builder.customerId = internalGetCustomerId();
        builder.customerNote = internalGetCustomerNote();
        builder.sellerNote = internalGetSellerNote();
        builder.appointmentSegments = internalGetAppointmentSegments();
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
        private OptionalNullable<String> startAt;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> customerId;
        private OptionalNullable<String> customerNote;
        private OptionalNullable<String> sellerNote;
        private OptionalNullable<List<AppointmentSegment>> appointmentSegments;
        private Integer transitionTimeMinutes;
        private Boolean allDay;
        private String locationType;
        private BookingCreatorDetails creatorDetails;
        private String source;



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
            this.startAt = OptionalNullable.of(startAt);
            return this;
        }

        /**
         * UnSetter for startAt.
         * @return Builder
         */
        public Builder unsetStartAt() {
            startAt = null;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = OptionalNullable.of(customerId);
            return this;
        }

        /**
         * UnSetter for customerId.
         * @return Builder
         */
        public Builder unsetCustomerId() {
            customerId = null;
            return this;
        }

        /**
         * Setter for customerNote.
         * @param  customerNote  String value for customerNote.
         * @return Builder
         */
        public Builder customerNote(String customerNote) {
            this.customerNote = OptionalNullable.of(customerNote);
            return this;
        }

        /**
         * UnSetter for customerNote.
         * @return Builder
         */
        public Builder unsetCustomerNote() {
            customerNote = null;
            return this;
        }

        /**
         * Setter for sellerNote.
         * @param  sellerNote  String value for sellerNote.
         * @return Builder
         */
        public Builder sellerNote(String sellerNote) {
            this.sellerNote = OptionalNullable.of(sellerNote);
            return this;
        }

        /**
         * UnSetter for sellerNote.
         * @return Builder
         */
        public Builder unsetSellerNote() {
            sellerNote = null;
            return this;
        }

        /**
         * Setter for appointmentSegments.
         * @param  appointmentSegments  List of AppointmentSegment value for appointmentSegments.
         * @return Builder
         */
        public Builder appointmentSegments(List<AppointmentSegment> appointmentSegments) {
            this.appointmentSegments = OptionalNullable.of(appointmentSegments);
            return this;
        }

        /**
         * UnSetter for appointmentSegments.
         * @return Builder
         */
        public Builder unsetAppointmentSegments() {
            appointmentSegments = null;
            return this;
        }

        /**
         * Setter for transitionTimeMinutes.
         * @param  transitionTimeMinutes  Integer value for transitionTimeMinutes.
         * @return Builder
         */
        public Builder transitionTimeMinutes(Integer transitionTimeMinutes) {
            this.transitionTimeMinutes = transitionTimeMinutes;
            return this;
        }

        /**
         * Setter for allDay.
         * @param  allDay  Boolean value for allDay.
         * @return Builder
         */
        public Builder allDay(Boolean allDay) {
            this.allDay = allDay;
            return this;
        }

        /**
         * Setter for locationType.
         * @param  locationType  String value for locationType.
         * @return Builder
         */
        public Builder locationType(String locationType) {
            this.locationType = locationType;
            return this;
        }

        /**
         * Setter for creatorDetails.
         * @param  creatorDetails  BookingCreatorDetails value for creatorDetails.
         * @return Builder
         */
        public Builder creatorDetails(BookingCreatorDetails creatorDetails) {
            this.creatorDetails = creatorDetails;
            return this;
        }

        /**
         * Setter for source.
         * @param  source  String value for source.
         * @return Builder
         */
        public Builder source(String source) {
            this.source = source;
            return this;
        }

        /**
         * Builds a new {@link Booking} object using the set fields.
         * @return {@link Booking}
         */
        public Booking build() {
            return new Booking(id, version, status, createdAt, updatedAt, startAt, locationId,
                    customerId, customerNote, sellerNote, appointmentSegments,
                    transitionTimeMinutes, allDay, locationType, creatorDetails, source);
        }
    }
}
