package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Shift {

    @JsonCreator
    public Shift(
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("start_at") String startAt,
            @JsonProperty("id") String id,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("timezone") String timezone,
            @JsonProperty("end_at") String endAt,
            @JsonProperty("wage") ShiftWage wage,
            @JsonProperty("breaks") List<Break> breaks,
            @JsonProperty("status") String status,
            @JsonProperty("version") Integer version,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.employeeId = employeeId;
        this.locationId = locationId;
        this.timezone = timezone;
        this.startAt = startAt;
        this.endAt = endAt;
        this.wage = wage;
        this.breaks = breaks;
        this.status = status;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private final String id;
    private final String employeeId;
    private final String locationId;
    private final String timezone;
    private final String startAt;
    private final String endAt;
    private final ShiftWage wage;
    private final List<Break> breaks;
    private final String status;
    private final Integer version;
    private final String createdAt;
    private final String updatedAt;

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, startAt, id, locationId, timezone, endAt, wage, breaks, status, version, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Shift)) {
            return false;
        }
        Shift shift = (Shift) o;
        return Objects.equals(employeeId, shift.employeeId) &&
            Objects.equals(startAt, shift.startAt) &&
            Objects.equals(id, shift.id) &&
            Objects.equals(locationId, shift.locationId) &&
            Objects.equals(timezone, shift.timezone) &&
            Objects.equals(endAt, shift.endAt) &&
            Objects.equals(wage, shift.wage) &&
            Objects.equals(breaks, shift.breaks) &&
            Objects.equals(status, shift.status) &&
            Objects.equals(version, shift.version) &&
            Objects.equals(createdAt, shift.createdAt) &&
            Objects.equals(updatedAt, shift.updatedAt);
    }

    /**
     * Getter for Id.
     * UUID for this object
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for EmployeeId.
     * The ID of the employee this shift belongs to.
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() { 
        return this.employeeId;
    }

    /**
     * Getter for LocationId.
     * The ID of the location this shift occurred at. Should be based on
     * where the employee clocked in.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for Timezone.
     * Read-only convenience value that is calculated from the location based
     * on `location_id`. Format: the IANA Timezone Database identifier for the
     * location timezone.
     */
    @JsonGetter("timezone")
    public String getTimezone() { 
        return this.timezone;
    }

    /**
     * Getter for StartAt.
     * RFC 3339; shifted to location timezone + offset. Precision up to the
     * minute is respected; seconds are truncated.
     */
    @JsonGetter("start_at")
    public String getStartAt() { 
        return this.startAt;
    }

    /**
     * Getter for EndAt.
     * RFC 3339; shifted to timezone + offset. Precision up to the minute is
     * respected; seconds are truncated. The `end_at` minute is not
     * counted when the shift length is calculated. For example, a shift from `00:00`
     * to `08:01` is considered an 8 hour shift (midnight to 8am).
     */
    @JsonGetter("end_at")
    public String getEndAt() { 
        return this.endAt;
    }

    /**
     * Getter for Wage.
     * The hourly wage rate used to compensate an employee for this shift.
     */
    @JsonGetter("wage")
    public ShiftWage getWage() { 
        return this.wage;
    }

    /**
     * Getter for Breaks.
     * A list of any paid or unpaid breaks that were taken during this shift.
     */
    @JsonGetter("breaks")
    public List<Break> getBreaks() { 
        return this.breaks;
    }

    /**
     * Getter for Status.
     * Enumerates the possible status of a `Shift`
     */
    @JsonGetter("status")
    public String getStatus() { 
        return this.status;
    }

    /**
     * Getter for Version.
     * Used for resolving concurrency issues; request will fail if version
     * provided does not match server version at time of request. If not provided,
     * Square executes a blind write; potentially overwriting data from another
     * write.
     */
    @JsonGetter("version")
    public Integer getVersion() { 
        return this.version;
    }

    /**
     * Getter for CreatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() { 
        return this.updatedAt;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(employeeId,
            startAt)
            .id(getId())
            .locationId(getLocationId())
            .timezone(getTimezone())
            .endAt(getEndAt())
            .wage(getWage())
            .breaks(getBreaks())
            .status(getStatus())
            .version(getVersion())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    public static class Builder {
        private String employeeId;
        private String startAt;
        private String id;
        private String locationId;
        private String timezone;
        private String endAt;
        private ShiftWage wage;
        private List<Break> breaks;
        private String status;
        private Integer version;
        private String createdAt;
        private String updatedAt;

        public Builder(String employeeId,
                String startAt) {
            this.employeeId = employeeId;
            this.startAt = startAt;
        }

        public Builder employeeId(String value) {
            employeeId = value;
            return this;
        }
        public Builder startAt(String value) {
            startAt = value;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder timezone(String value) {
            timezone = value;
            return this;
        }
        public Builder endAt(String value) {
            endAt = value;
            return this;
        }
        public Builder wage(ShiftWage value) {
            wage = value;
            return this;
        }
        public Builder breaks(List<Break> value) {
            breaks = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder version(Integer value) {
            version = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder updatedAt(String value) {
            updatedAt = value;
            return this;
        }

        public Shift build() {
            return new Shift(employeeId,
                startAt,
                id,
                locationId,
                timezone,
                endAt,
                wage,
                breaks,
                status,
                version,
                createdAt,
                updatedAt);
        }
    }
}
