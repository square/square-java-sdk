/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Availability.Builder.class)
public final class Availability {
    private final Optional<String> startAt;

    private final Optional<String> locationId;

    private final Optional<List<AppointmentSegment>> appointmentSegments;

    private final Map<String, Object> additionalProperties;

    private Availability(
            Optional<String> startAt,
            Optional<String> locationId,
            Optional<List<AppointmentSegment>> appointmentSegments,
            Map<String, Object> additionalProperties) {
        this.startAt = startAt;
        this.locationId = locationId;
        this.appointmentSegments = appointmentSegments;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The RFC 3339 timestamp specifying the beginning time of the slot available for booking.
     */
    @JsonIgnore
    public Optional<String> getStartAt() {
        if (startAt == null) {
            return Optional.empty();
        }
        return startAt;
    }

    /**
     * @return The ID of the location available for booking.
     */
    @JsonProperty("location_id")
    public Optional<String> getLocationId() {
        return locationId;
    }

    /**
     * @return The list of appointment segments available for booking
     */
    @JsonIgnore
    public Optional<List<AppointmentSegment>> getAppointmentSegments() {
        if (appointmentSegments == null) {
            return Optional.empty();
        }
        return appointmentSegments;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("start_at")
    private Optional<String> _getStartAt() {
        return startAt;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("appointment_segments")
    private Optional<List<AppointmentSegment>> _getAppointmentSegments() {
        return appointmentSegments;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Availability && equalTo((Availability) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Availability other) {
        return startAt.equals(other.startAt)
                && locationId.equals(other.locationId)
                && appointmentSegments.equals(other.appointmentSegments);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.startAt, this.locationId, this.appointmentSegments);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> startAt = Optional.empty();

        private Optional<String> locationId = Optional.empty();

        private Optional<List<AppointmentSegment>> appointmentSegments = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Availability other) {
            startAt(other.getStartAt());
            locationId(other.getLocationId());
            appointmentSegments(other.getAppointmentSegments());
            return this;
        }

        /**
         * <p>The RFC 3339 timestamp specifying the beginning time of the slot available for booking.</p>
         */
        @JsonSetter(value = "start_at", nulls = Nulls.SKIP)
        public Builder startAt(Optional<String> startAt) {
            this.startAt = startAt;
            return this;
        }

        public Builder startAt(String startAt) {
            this.startAt = Optional.ofNullable(startAt);
            return this;
        }

        public Builder startAt(Nullable<String> startAt) {
            if (startAt.isNull()) {
                this.startAt = null;
            } else if (startAt.isEmpty()) {
                this.startAt = Optional.empty();
            } else {
                this.startAt = Optional.of(startAt.get());
            }
            return this;
        }

        /**
         * <p>The ID of the location available for booking.</p>
         */
        @JsonSetter(value = "location_id", nulls = Nulls.SKIP)
        public Builder locationId(Optional<String> locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder locationId(String locationId) {
            this.locationId = Optional.ofNullable(locationId);
            return this;
        }

        /**
         * <p>The list of appointment segments available for booking</p>
         */
        @JsonSetter(value = "appointment_segments", nulls = Nulls.SKIP)
        public Builder appointmentSegments(Optional<List<AppointmentSegment>> appointmentSegments) {
            this.appointmentSegments = appointmentSegments;
            return this;
        }

        public Builder appointmentSegments(List<AppointmentSegment> appointmentSegments) {
            this.appointmentSegments = Optional.ofNullable(appointmentSegments);
            return this;
        }

        public Builder appointmentSegments(Nullable<List<AppointmentSegment>> appointmentSegments) {
            if (appointmentSegments.isNull()) {
                this.appointmentSegments = null;
            } else if (appointmentSegments.isEmpty()) {
                this.appointmentSegments = Optional.empty();
            } else {
                this.appointmentSegments = Optional.of(appointmentSegments.get());
            }
            return this;
        }

        public Availability build() {
            return new Availability(startAt, locationId, appointmentSegments, additionalProperties);
        }
    }
}
