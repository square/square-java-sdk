
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ShiftFilter type.
 */
public class ShiftFilter {
    private final List<String> locationIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> employeeIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TimeRange start;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TimeRange end;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final ShiftWorkday workday;
    private final List<String> teamMemberIds;

    /**
     * Initialization constructor.
     * @param  locationIds  List of String value for locationIds.
     * @param  teamMemberIds  List of String value for teamMemberIds.
     * @param  employeeIds  List of String value for employeeIds.
     * @param  status  String value for status.
     * @param  start  TimeRange value for start.
     * @param  end  TimeRange value for end.
     * @param  workday  ShiftWorkday value for workday.
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

    /**
     * Getter for LocationIds.
     * Fetch shifts for the specified location.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return locationIds;
    }

    /**
     * Getter for EmployeeIds.
     * Fetch shifts for the specified employees. DEPRECATED at version 2020-08-26. Use
     * `team_member_ids` instead
     * @return Returns the List of String
     */
    @JsonGetter("employee_ids")
    public List<String> getEmployeeIds() {
        return employeeIds;
    }

    /**
     * Getter for Status.
     * Specifies the `status` of `Shift` records to be returned.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    /**
     * Getter for Start.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("start")
    public TimeRange getStart() {
        return start;
    }

    /**
     * Getter for End.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("end")
    public TimeRange getEnd() {
        return end;
    }

    /**
     * Getter for Workday.
     * A `Shift` search query filter parameter that sets a range of days that a `Shift` must start
     * or end in before passing the filter condition.
     * @return Returns the ShiftWorkday
     */
    @JsonGetter("workday")
    public ShiftWorkday getWorkday() {
        return workday;
    }

    /**
     * Getter for TeamMemberIds.
     * Fetch shifts for the specified team members. Replaced `employee_ids` at version "2020-08-26"
     * @return Returns the List of String
     */
    @JsonGetter("team_member_ids")
    public List<String> getTeamMemberIds() {
        return teamMemberIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationIds, employeeIds, status, start, end, workday, teamMemberIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShiftFilter)) {
            return false;
        }
        ShiftFilter other = (ShiftFilter) obj;
        return Objects.equals(locationIds, other.locationIds)
            && Objects.equals(employeeIds, other.employeeIds)
            && Objects.equals(status, other.status)
            && Objects.equals(start, other.start)
            && Objects.equals(end, other.end)
            && Objects.equals(workday, other.workday)
            && Objects.equals(teamMemberIds, other.teamMemberIds);
    }

    /**
     * Converts this ShiftFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ShiftFilter [" + "locationIds=" + locationIds + ", teamMemberIds=" + teamMemberIds
                + ", employeeIds=" + employeeIds + ", status=" + status + ", start=" + start
                + ", end=" + end + ", workday=" + workday + "]";
    }

    /**
     * Builds a new {@link ShiftFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ShiftFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationIds, teamMemberIds)
                .employeeIds(getEmployeeIds())
                .status(getStatus())
                .start(getStart())
                .end(getEnd())
                .workday(getWorkday());
        return builder;
    }

    /**
     * Class to build instances of {@link ShiftFilter}.
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
         * Initialization constructor.
         * @param  locationIds  List of String value for locationIds.
         * @param  teamMemberIds  List of String value for teamMemberIds.
         */
        public Builder(List<String> locationIds, List<String> teamMemberIds) {
            this.locationIds = locationIds;
            this.teamMemberIds = teamMemberIds;
        }

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        /**
         * Setter for teamMemberIds.
         * @param  teamMemberIds  List of String value for teamMemberIds.
         * @return Builder
         */
        public Builder teamMemberIds(List<String> teamMemberIds) {
            this.teamMemberIds = teamMemberIds;
            return this;
        }

        /**
         * Setter for employeeIds.
         * @param  employeeIds  List of String value for employeeIds.
         * @return Builder
         */
        public Builder employeeIds(List<String> employeeIds) {
            this.employeeIds = employeeIds;
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
         * Setter for start.
         * @param  start  TimeRange value for start.
         * @return Builder
         */
        public Builder start(TimeRange start) {
            this.start = start;
            return this;
        }

        /**
         * Setter for end.
         * @param  end  TimeRange value for end.
         * @return Builder
         */
        public Builder end(TimeRange end) {
            this.end = end;
            return this;
        }

        /**
         * Setter for workday.
         * @param  workday  ShiftWorkday value for workday.
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
            return new ShiftFilter(locationIds, teamMemberIds, employeeIds, status, start, end,
                    workday);
        }
    }
}
