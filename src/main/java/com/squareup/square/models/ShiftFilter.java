package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ShiftFilter type.
 */
public class ShiftFilter {

    /**
     * Initialization constructor.
     * @param locationIds
     * @param teamMemberIds
     * @param employeeIds
     * @param status
     * @param start
     * @param end
     * @param workday
     */
    @JsonCreator
    public ShiftFilter(
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("team_member_ids") List<String> teamMemberIds,
            @JsonProperty("employee_ids") List<String> employeeIds,
            @JsonProperty("status") String status,
            @JsonProperty("start") TimeRange start,
            @JsonProperty("end") TimeRange end,
            @JsonProperty("workday") ShiftWorkday workday) {
        this.locationIds = locationIds;
        this.employeeIds = employeeIds;
        this.status = status;
        this.start = start;
        this.end = end;
        this.workday = workday;
        this.teamMemberIds = teamMemberIds;
    }

    private final List<String> locationIds;
    private final List<String> employeeIds;
    private final String status;
    private final TimeRange start;
    private final TimeRange end;
    private final ShiftWorkday workday;
    private final List<String> teamMemberIds;
    /**
     * Getter for LocationIds.
     * Fetch shifts for the specified location.
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for EmployeeIds.
     * Fetch shifts for the specified employees. DEPRECATED at version 2020-08-26. Use `team_member_ids` instead
     */
    @JsonGetter("employee_ids")
    public List<String> getEmployeeIds() {
        return this.employeeIds;
    }

    /**
     * Getter for Status.
     * Specifies the `status` of `Shift` records to be returned.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for Start.
     * Represents a generic time range. The start and end values are
     * represented in RFC 3339 format. Time ranges are customized to be
     * inclusive or exclusive based on the needs of a particular endpoint.
     * Refer to the relevant endpoint-specific documentation to determine
     * how time ranges are handled.
     */
    @JsonGetter("start")
    public TimeRange getStart() {
        return this.start;
    }

    /**
     * Getter for End.
     * Represents a generic time range. The start and end values are
     * represented in RFC 3339 format. Time ranges are customized to be
     * inclusive or exclusive based on the needs of a particular endpoint.
     * Refer to the relevant endpoint-specific documentation to determine
     * how time ranges are handled.
     */
    @JsonGetter("end")
    public TimeRange getEnd() {
        return this.end;
    }

    /**
     * Getter for Workday.
     * A `Shift` search query filter parameter that sets a range of days that
     * a `Shift` must start or end in before passing the filter condition.
     */
    @JsonGetter("workday")
    public ShiftWorkday getWorkday() {
        return this.workday;
    }

    /**
     * Getter for TeamMemberIds.
     * Fetch shifts for the specified team members. Replaced `employee_ids` at version "2020-08-26"
     */
    @JsonGetter("team_member_ids")
    public List<String> getTeamMemberIds() {
        return this.teamMemberIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationIds, employeeIds, status, start, end, workday, teamMemberIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ShiftFilter)) {
            return false;
        }
        ShiftFilter shiftFilter = (ShiftFilter) obj;
        return Objects.equals(locationIds, shiftFilter.locationIds) &&
            Objects.equals(employeeIds, shiftFilter.employeeIds) &&
            Objects.equals(status, shiftFilter.status) &&
            Objects.equals(start, shiftFilter.start) &&
            Objects.equals(end, shiftFilter.end) &&
            Objects.equals(workday, shiftFilter.workday) &&
            Objects.equals(teamMemberIds, shiftFilter.teamMemberIds);
    }

    /**
     * Builds a new {@link ShiftFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ShiftFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationIds,
            teamMemberIds)
            .employeeIds(getEmployeeIds())
            .status(getStatus())
            .start(getStart())
            .end(getEnd())
            .workday(getWorkday());
            return builder;
    }

    /**
     * Class to build instances of {@link ShiftFilter}
     */
    public static class Builder {
        private List<String> locationIds;
        private List<String> teamMemberIds;
        private List<String> employeeIds;
        private String status;
        private TimeRange start;
        private TimeRange end;
        private ShiftWorkday workday;

        /**
         * Initialization constructor
         */
        public Builder(List<String> locationIds,
                List<String> teamMemberIds) {
            this.locationIds = locationIds;
            this.teamMemberIds = teamMemberIds;
        }

        /**
         * Setter for locationIds
         * @param locationIds
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }
        /**
         * Setter for teamMemberIds
         * @param teamMemberIds
         * @return Builder
         */
        public Builder teamMemberIds(List<String> teamMemberIds) {
            this.teamMemberIds = teamMemberIds;
            return this;
        }
        /**
         * Setter for employeeIds
         * @param employeeIds
         * @return Builder
         */
        public Builder employeeIds(List<String> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }
        /**
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        /**
         * Setter for start
         * @param start
         * @return Builder
         */
        public Builder start(TimeRange start) {
            this.start = start;
            return this;
        }
        /**
         * Setter for end
         * @param end
         * @return Builder
         */
        public Builder end(TimeRange end) {
            this.end = end;
            return this;
        }
        /**
         * Setter for workday
         * @param workday
         * @return Builder
         */
        public Builder workday(ShiftWorkday workday) {
            this.workday = workday;
            return this;
        }

        /**
         * Builds a new {@link ShiftFilter} object using the set fields.
         * @return {@link ShiftFilter}
         */
        public ShiftFilter build() {
            return new ShiftFilter(locationIds,
                teamMemberIds,
                employeeIds,
                status,
                start,
                end,
                workday);
        }
    }
}
