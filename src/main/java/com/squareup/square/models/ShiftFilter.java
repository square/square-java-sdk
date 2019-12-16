package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ShiftFilter {

    @JsonCreator
    public ShiftFilter(
            @JsonProperty("location_ids") List<String> locationIds,
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
    }

    private final List<String> locationIds;
    private final List<String> employeeIds;
    private final String status;
    private final TimeRange start;
    private final TimeRange end;
    private final ShiftWorkday workday;

    @Override
    public int hashCode() {
        return Objects.hash(locationIds, employeeIds, status, start, end, workday);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ShiftFilter)) {
            return false;
        }
        ShiftFilter shiftFilter = (ShiftFilter) o;
        return Objects.equals(locationIds, shiftFilter.locationIds) &&
            Objects.equals(employeeIds, shiftFilter.employeeIds) &&
            Objects.equals(status, shiftFilter.status) &&
            Objects.equals(start, shiftFilter.start) &&
            Objects.equals(end, shiftFilter.end) &&
            Objects.equals(workday, shiftFilter.workday);
    }

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
     * Fetch shifts for the specified employee.
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
     * represented in RFC-3339 format. Time ranges are customized to be
     * inclusive or exclusive based on the needs of a particular endpoint.
     * Refer to the relevent endpoint-specific documentation to determine
     * how time ranges are handled.
     */
    @JsonGetter("start")
    public TimeRange getStart() { 
        return this.start;
    }

    /**
     * Getter for End.
     * Represents a generic time range. The start and end values are
     * represented in RFC-3339 format. Time ranges are customized to be
     * inclusive or exclusive based on the needs of a particular endpoint.
     * Refer to the relevent endpoint-specific documentation to determine
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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationIds(getLocationIds())
            .employeeIds(getEmployeeIds())
            .status(getStatus())
            .start(getStart())
            .end(getEnd())
            .workday(getWorkday());
            return builder;
    }

    public static class Builder {
        private List<String> locationIds;
        private List<String> employeeIds;
        private String status;
        private TimeRange start;
        private TimeRange end;
        private ShiftWorkday workday;

        public Builder() { }

        public Builder locationIds(List<String> value) {
            locationIds = value;
            return this;
        }
        public Builder employeeIds(List<String> value) {
            employeeIds = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder start(TimeRange value) {
            start = value;
            return this;
        }
        public Builder end(TimeRange value) {
            end = value;
            return this;
        }
        public Builder workday(ShiftWorkday value) {
            workday = value;
            return this;
        }

        public ShiftFilter build() {
            return new ShiftFilter(locationIds,
                employeeIds,
                status,
                start,
                end,
                workday);
        }
    }
}
