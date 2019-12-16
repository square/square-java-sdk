package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListEmployeeWagesRequest {

    @JsonCreator
    public ListEmployeeWagesRequest(
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.employeeId = employeeId;
        this.limit = limit;
        this.cursor = cursor;
    }

    private final String employeeId;
    private final Integer limit;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, limit, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListEmployeeWagesRequest)) {
            return false;
        }
        ListEmployeeWagesRequest listEmployeeWagesRequest = (ListEmployeeWagesRequest) o;
        return Objects.equals(employeeId, listEmployeeWagesRequest.employeeId) &&
            Objects.equals(limit, listEmployeeWagesRequest.limit) &&
            Objects.equals(cursor, listEmployeeWagesRequest.cursor);
    }

    /**
     * Getter for EmployeeId.
     * Filter wages returned to only those that are associated with the
     * specified employee.
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() { 
        return this.employeeId;
    }

    /**
     * Getter for Limit.
     * Maximum number of Employee Wages to return per page. Can range between
     * 1 and 200. The default is the maximum at 200.
     */
    @JsonGetter("limit")
    public Integer getLimit() { 
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * Pointer to the next page of Employee Wage results to fetch.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .employeeId(getEmployeeId())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private String employeeId;
        private Integer limit;
        private String cursor;

        public Builder() { }

        public Builder employeeId(String value) {
            employeeId = value;
            return this;
        }
        public Builder limit(Integer value) {
            limit = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public ListEmployeeWagesRequest build() {
            return new ListEmployeeWagesRequest(employeeId,
                limit,
                cursor);
        }
    }
}
