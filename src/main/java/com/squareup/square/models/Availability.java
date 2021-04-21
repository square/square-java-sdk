
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Availability type.
 */
public class Availability {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String startAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<AppointmentSegment> appointmentSegments;

    /**
     * Initialization constructor.
     * @param  startAt  String value for startAt.
     * @param  locationId  String value for locationId.
     * @param  appointmentSegments  List of AppointmentSegment value for appointmentSegments.
     */
    @JsonCreator
    public Availability(
            @JsonProperty("start_at") String startAt,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("appointment_segments") List<AppointmentSegment> appointmentSegments) {
        this.startAt = startAt;
        this.locationId = locationId;
        this.appointmentSegments = appointmentSegments;
    }

    /**
     * Getter for StartAt.
     * The RFC 3339 timestamp specifying the beginning time of the slot available for booking.
     * @return Returns the String
     */
    @JsonGetter("start_at")
    public String getStartAt() {
        return startAt;
    }

    /**
     * Getter for LocationId.
     * The ID of the location available for booking.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for AppointmentSegments.
     * The list of appointment segments available for booking
     * @return Returns the List of AppointmentSegment
     */
    @JsonGetter("appointment_segments")
    public List<AppointmentSegment> getAppointmentSegments() {
        return appointmentSegments;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startAt, locationId, appointmentSegments);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Availability)) {
            return false;
        }
        Availability other = (Availability) obj;
        return Objects.equals(startAt, other.startAt)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(appointmentSegments, other.appointmentSegments);
    }

    /**
     * Converts this Availability into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Availability [" + "startAt=" + startAt + ", locationId=" + locationId
                + ", appointmentSegments=" + appointmentSegments + "]";
    }

    /**
     * Builds a new {@link Availability.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Availability.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .startAt(getStartAt())
                .locationId(getLocationId())
                .appointmentSegments(getAppointmentSegments());
        return builder;
    }

    /**
     * Class to build instances of {@link Availability}.
     */
    public static class Builder {
        private String startAt;
        private String locationId;
        private List<AppointmentSegment> appointmentSegments;



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
         * Setter for appointmentSegments.
         * @param  appointmentSegments  List of AppointmentSegment value for appointmentSegments.
         * @return Builder
         */
        public Builder appointmentSegments(List<AppointmentSegment> appointmentSegments) {
            this.appointmentSegments = appointmentSegments;
            return this;
        }

        /**
         * Builds a new {@link Availability} object using the set fields.
         * @return {@link Availability}
         */
        public Availability build() {
            return new Availability(startAt, locationId, appointmentSegments);
        }
    }
}
