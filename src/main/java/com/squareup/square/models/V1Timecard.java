package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1Timecard type.
 */
public class V1Timecard {

    /**
     * Initialization constructor.
     * @param employeeId
     * @param id
     * @param deleted
     * @param clockinTime
     * @param clockoutTime
     * @param clockinLocationId
     * @param clockoutLocationId
     * @param createdAt
     * @param updatedAt
     * @param regularSecondsWorked
     * @param overtimeSecondsWorked
     * @param doubletimeSecondsWorked
     */
    @JsonCreator
    public V1Timecard(
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("id") String id,
            @JsonProperty("deleted") Boolean deleted,
            @JsonProperty("clockin_time") String clockinTime,
            @JsonProperty("clockout_time") String clockoutTime,
            @JsonProperty("clockin_location_id") String clockinLocationId,
            @JsonProperty("clockout_location_id") String clockoutLocationId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("regular_seconds_worked") Double regularSecondsWorked,
            @JsonProperty("overtime_seconds_worked") Double overtimeSecondsWorked,
            @JsonProperty("doubletime_seconds_worked") Double doubletimeSecondsWorked) {
        this.id = id;
        this.employeeId = employeeId;
        this.deleted = deleted;
        this.clockinTime = clockinTime;
        this.clockoutTime = clockoutTime;
        this.clockinLocationId = clockinLocationId;
        this.clockoutLocationId = clockoutLocationId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.regularSecondsWorked = regularSecondsWorked;
        this.overtimeSecondsWorked = overtimeSecondsWorked;
        this.doubletimeSecondsWorked = doubletimeSecondsWorked;
    }

    private HttpContext httpContext;
    private final String id;
    private final String employeeId;
    private final Boolean deleted;
    private final String clockinTime;
    private final String clockoutTime;
    private final String clockinLocationId;
    private final String clockoutLocationId;
    private final String createdAt;
    private final String updatedAt;
    private final Double regularSecondsWorked;
    private final Double overtimeSecondsWorked;
    private final Double doubletimeSecondsWorked;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The timecard's unique ID.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for EmployeeId.
     * The ID of the employee the timecard is associated with.
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for Deleted.
     * If true, the timecard was deleted by the merchant, and it is no longer valid.
     */
    @JsonGetter("deleted")
    public Boolean getDeleted() {
        return this.deleted;
    }

    /**
     * Getter for ClockinTime.
     * The clock-in time for the timecard, in ISO 8601 format.
     */
    @JsonGetter("clockin_time")
    public String getClockinTime() {
        return this.clockinTime;
    }

    /**
     * Getter for ClockoutTime.
     * The clock-out time for the timecard, in ISO 8601 format. Provide this value only if importing timecard information from another system.
     */
    @JsonGetter("clockout_time")
    public String getClockoutTime() {
        return this.clockoutTime;
    }

    /**
     * Getter for ClockinLocationId.
     * The ID of the location the employee clocked in from. We strongly reccomend providing a clockin_location_id. Square uses the clockin_location_id to determine a timecard’s timezone and overtime rules.
     */
    @JsonGetter("clockin_location_id")
    public String getClockinLocationId() {
        return this.clockinLocationId;
    }

    /**
     * Getter for ClockoutLocationId.
     * The ID of the location the employee clocked out from. Provide this value only if importing timecard information from another system.
     */
    @JsonGetter("clockout_location_id")
    public String getClockoutLocationId() {
        return this.clockoutLocationId;
    }

    /**
     * Getter for CreatedAt.
     * The time when the timecard was created, in ISO 8601 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the timecard was most recently updated, in ISO 8601 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for RegularSecondsWorked.
     * The total number of regular (non-overtime) seconds worked in the timecard.
     */
    @JsonGetter("regular_seconds_worked")
    public Double getRegularSecondsWorked() {
        return this.regularSecondsWorked;
    }

    /**
     * Getter for OvertimeSecondsWorked.
     * The total number of overtime seconds worked in the timecard.
     */
    @JsonGetter("overtime_seconds_worked")
    public Double getOvertimeSecondsWorked() {
        return this.overtimeSecondsWorked;
    }

    /**
     * Getter for DoubletimeSecondsWorked.
     * The total number of doubletime seconds worked in the timecard.
     */
    @JsonGetter("doubletime_seconds_worked")
    public Double getDoubletimeSecondsWorked() {
        return this.doubletimeSecondsWorked;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, deleted, clockinTime, clockoutTime, clockinLocationId,
            clockoutLocationId, createdAt, updatedAt, regularSecondsWorked, overtimeSecondsWorked,
            doubletimeSecondsWorked);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1Timecard)) {
            return false;
        }
        V1Timecard v1Timecard = (V1Timecard) obj;
        return Objects.equals(id, v1Timecard.id) &&
            Objects.equals(employeeId, v1Timecard.employeeId) &&
            Objects.equals(deleted, v1Timecard.deleted) &&
            Objects.equals(clockinTime, v1Timecard.clockinTime) &&
            Objects.equals(clockoutTime, v1Timecard.clockoutTime) &&
            Objects.equals(clockinLocationId, v1Timecard.clockinLocationId) &&
            Objects.equals(clockoutLocationId, v1Timecard.clockoutLocationId) &&
            Objects.equals(createdAt, v1Timecard.createdAt) &&
            Objects.equals(updatedAt, v1Timecard.updatedAt) &&
            Objects.equals(regularSecondsWorked, v1Timecard.regularSecondsWorked) &&
            Objects.equals(overtimeSecondsWorked, v1Timecard.overtimeSecondsWorked) &&
            Objects.equals(doubletimeSecondsWorked, v1Timecard.doubletimeSecondsWorked);
    }

    /**
     * Builds a new {@link V1Timecard.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Timecard.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(employeeId)
            .id(getId())
            .deleted(getDeleted())
            .clockinTime(getClockinTime())
            .clockoutTime(getClockoutTime())
            .clockinLocationId(getClockinLocationId())
            .clockoutLocationId(getClockoutLocationId())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt())
            .regularSecondsWorked(getRegularSecondsWorked())
            .overtimeSecondsWorked(getOvertimeSecondsWorked())
            .doubletimeSecondsWorked(getDoubletimeSecondsWorked());
            return builder;
    }

    /**
     * Class to build instances of {@link V1Timecard}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String employeeId;
        private String id;
        private Boolean deleted;
        private String clockinTime;
        private String clockoutTime;
        private String clockinLocationId;
        private String clockoutLocationId;
        private String createdAt;
        private String updatedAt;
        private Double regularSecondsWorked;
        private Double overtimeSecondsWorked;
        private Double doubletimeSecondsWorked;

        /**
         * Initialization constructor
         */
        public Builder(String employeeId) {
            this.employeeId = employeeId;
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for employeeId
         * @param employeeId
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for deleted
         * @param deleted
         * @return Builder
         */
        public Builder deleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }
        /**
         * Setter for clockinTime
         * @param clockinTime
         * @return Builder
         */
        public Builder clockinTime(String clockinTime) {
            this.clockinTime = clockinTime;
            return this;
        }
        /**
         * Setter for clockoutTime
         * @param clockoutTime
         * @return Builder
         */
        public Builder clockoutTime(String clockoutTime) {
            this.clockoutTime = clockoutTime;
            return this;
        }
        /**
         * Setter for clockinLocationId
         * @param clockinLocationId
         * @return Builder
         */
        public Builder clockinLocationId(String clockinLocationId) {
            this.clockinLocationId = clockinLocationId;
            return this;
        }
        /**
         * Setter for clockoutLocationId
         * @param clockoutLocationId
         * @return Builder
         */
        public Builder clockoutLocationId(String clockoutLocationId) {
            this.clockoutLocationId = clockoutLocationId;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        /**
         * Setter for regularSecondsWorked
         * @param regularSecondsWorked
         * @return Builder
         */
        public Builder regularSecondsWorked(Double regularSecondsWorked) {
            this.regularSecondsWorked = regularSecondsWorked;
            return this;
        }
        /**
         * Setter for overtimeSecondsWorked
         * @param overtimeSecondsWorked
         * @return Builder
         */
        public Builder overtimeSecondsWorked(Double overtimeSecondsWorked) {
            this.overtimeSecondsWorked = overtimeSecondsWorked;
            return this;
        }
        /**
         * Setter for doubletimeSecondsWorked
         * @param doubletimeSecondsWorked
         * @return Builder
         */
        public Builder doubletimeSecondsWorked(Double doubletimeSecondsWorked) {
            this.doubletimeSecondsWorked = doubletimeSecondsWorked;
            return this;
        }

        /**
         * Builds a new {@link V1Timecard} object using the set fields.
         * @return {@link V1Timecard}
         */
        public V1Timecard build() {
            V1Timecard model = new V1Timecard(employeeId,
                id,
                deleted,
                clockinTime,
                clockoutTime,
                clockinLocationId,
                clockoutLocationId,
                createdAt,
                updatedAt,
                regularSecondsWorked,
                overtimeSecondsWorked,
                doubletimeSecondsWorked);
            model.httpContext = httpContext;
            return model;
        }
    }
}
