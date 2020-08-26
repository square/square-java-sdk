package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListEmployeeWagesRequest type.
 */
public class ListEmployeeWagesRequest {

    /**
     * Initialization constructor.
     * @param employeeId
     * @param limit
     * @param cursor
     */
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
    /**
     * Getter for EmployeeId.
     * Filter wages returned to only those that are associated with the specified employee.
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

 
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListEmployeeWagesRequest)) {
            return false;
        }
        ListEmployeeWagesRequest listEmployeeWagesRequest = (ListEmployeeWagesRequest) obj;
        return Objects.equals(employeeId, listEmployeeWagesRequest.employeeId) &&
            Objects.equals(limit, listEmployeeWagesRequest.limit) &&
            Objects.equals(cursor, listEmployeeWagesRequest.cursor);
    }

    /**
     * Builds a new {@link ListEmployeeWagesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListEmployeeWagesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .employeeId(getEmployeeId())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListEmployeeWagesRequest}
     */
    public static class Builder {
        private String employeeId;
        private Integer limit;
        private String cursor;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListEmployeeWagesRequest} object using the set fields.
         * @return {@link ListEmployeeWagesRequest}
         */
        public ListEmployeeWagesRequest build() {
            return new ListEmployeeWagesRequest(employeeId,
                limit,
                cursor);
        }
    }
}
