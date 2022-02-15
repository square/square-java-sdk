
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Shift type.
 */
public class Shift {
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
    private final String teamMemberId;

    /**
     * Initialization constructor.
     * @param  startAt  String value for startAt.
     * @param  id  String value for id.
     * @param  employeeId  String value for employeeId.
     * @param  locationId  String value for locationId.
     * @param  timezone  String value for timezone.
     * @param  endAt  String value for endAt.
     * @param  wage  ShiftWage value for wage.
     * @param  breaks  List of Break value for breaks.
     * @param  status  String value for status.
     * @param  version  Integer value for version.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  teamMemberId  String value for teamMemberId.
     */
    @JsonCreator
    public Shift(
            @JsonProperty("start_at") String startAt,
            @JsonProperty("id") String id,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("timezone") String timezone,
            @JsonProperty("end_at") String endAt,
            @JsonProperty("wage") ShiftWage wage,
            @JsonProperty("breaks") List<Break> breaks,
            @JsonProperty("status") String status,
            @JsonProperty("version") Integer version,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("team_member_id") String teamMemberId) {
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
        this.teamMemberId = teamMemberId;
    }

    /**
     * Getter for Id.
     * The UUID for this object.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for EmployeeId.
     * The ID of the employee this shift belongs to. DEPRECATED at version 2020-08-26. Use
     * `team_member_id` instead.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Getter for LocationId.
     * The ID of the location this shift occurred at. The location should be based on where the
     * employee clocked in.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for Timezone.
     * The read-only convenience value that is calculated from the location based on the
     * `location_id`. Format: the IANA timezone database identifier for the location timezone.
     * @return Returns the String
     */
    @JsonGetter("timezone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTimezone() {
        return timezone;
    }

    /**
     * Getter for StartAt.
     * RFC 3339; shifted to the location timezone + offset. Precision up to the minute is respected;
     * seconds are truncated.
     * @return Returns the String
     */
    @JsonGetter("start_at")
    public String getStartAt() {
        return startAt;
    }

    /**
     * Getter for EndAt.
     * RFC 3339; shifted to the timezone + offset. Precision up to the minute is respected; seconds
     * are truncated.
     * @return Returns the String
     */
    @JsonGetter("end_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEndAt() {
        return endAt;
    }

    /**
     * Getter for Wage.
     * The hourly wage rate used to compensate an employee for this shift.
     * @return Returns the ShiftWage
     */
    @JsonGetter("wage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ShiftWage getWage() {
        return wage;
    }

    /**
     * Getter for Breaks.
     * A list of all the paid or unpaid breaks that were taken during this shift.
     * @return Returns the List of Break
     */
    @JsonGetter("breaks")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Break> getBreaks() {
        return breaks;
    }

    /**
     * Getter for Status.
     * Enumerates the possible status of a `Shift`.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for Version.
     * Used for resolving concurrency issues. The request fails if the version provided does not
     * match the server version at the time of the request. If not provided, Square executes a blind
     * write; potentially overwriting data from another write.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for CreatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for TeamMemberId.
     * The ID of the team member this shift belongs to. Replaced `employee_id` at version
     * "2020-08-26".
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTeamMemberId() {
        return teamMemberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, locationId, timezone, startAt, endAt, wage, breaks,
                status, version, createdAt, updatedAt, teamMemberId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Shift)) {
            return false;
        }
        Shift other = (Shift) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(timezone, other.timezone)
            && Objects.equals(startAt, other.startAt)
            && Objects.equals(endAt, other.endAt)
            && Objects.equals(wage, other.wage)
            && Objects.equals(breaks, other.breaks)
            && Objects.equals(status, other.status)
            && Objects.equals(version, other.version)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(teamMemberId, other.teamMemberId);
    }

    /**
     * Converts this Shift into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Shift [" + "startAt=" + startAt + ", id=" + id + ", employeeId=" + employeeId
                + ", locationId=" + locationId + ", timezone=" + timezone + ", endAt=" + endAt
                + ", wage=" + wage + ", breaks=" + breaks + ", status=" + status + ", version="
                + version + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", teamMemberId=" + teamMemberId + "]";
    }

    /**
     * Builds a new {@link Shift.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Shift.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(startAt)
                .id(getId())
                .employeeId(getEmployeeId())
                .locationId(getLocationId())
                .timezone(getTimezone())
                .endAt(getEndAt())
                .wage(getWage())
                .breaks(getBreaks())
                .status(getStatus())
                .version(getVersion())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .teamMemberId(getTeamMemberId());
        return builder;
    }

    /**
     * Class to build instances of {@link Shift}.
     */
    public static class Builder {
        private String startAt;
        private String id;
        private String employeeId;
        private String locationId;
        private String timezone;
        private String endAt;
        private ShiftWage wage;
        private List<Break> breaks;
        private String status;
        private Integer version;
        private String createdAt;
        private String updatedAt;
        private String teamMemberId;

        /**
         * Initialization constructor.
         * @param  startAt  String value for startAt.
         */
        public Builder(String startAt) {
            this.startAt = startAt;
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
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for employeeId.
         * @param  employeeId  String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
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
         * Setter for timezone.
         * @param  timezone  String value for timezone.
         * @return Builder
         */
        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        /**
         * Setter for endAt.
         * @param  endAt  String value for endAt.
         * @return Builder
         */
        public Builder endAt(String endAt) {
            this.endAt = endAt;
            return this;
        }

        /**
         * Setter for wage.
         * @param  wage  ShiftWage value for wage.
         * @return Builder
         */
        public Builder wage(ShiftWage wage) {
            this.wage = wage;
            return this;
        }

        /**
         * Setter for breaks.
         * @param  breaks  List of Break value for breaks.
         * @return Builder
         */
        public Builder breaks(List<Break> breaks) {
            this.breaks = breaks;
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
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Builds a new {@link Shift} object using the set fields.
         * @return {@link Shift}
         */
        public Shift build() {
            return new Shift(startAt, id, employeeId, locationId, timezone, endAt, wage, breaks,
                    status, version, createdAt, updatedAt, teamMemberId);
        }
    }
}
