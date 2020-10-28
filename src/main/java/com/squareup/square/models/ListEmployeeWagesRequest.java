
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for ListEmployeeWagesRequest type.
 */
public class ListEmployeeWagesRequest {
    private final String employeeId;
    private final Integer limit;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param employeeId String value for employeeId.
     * @param limit Integer value for limit.
     * @param cursor String value for cursor.
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

    /**
     * Getter for EmployeeId.
     * Filter wages returned to only those that are associated with the specified employee.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for Limit.
     * Maximum number of Employee Wages to return per page. Can range between 1 and 200. The default
     * is the maximum at 200.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * Pointer to the next page of Employee Wage results to fetch.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListEmployeeWagesRequest)) {
            return false;
        }
        ListEmployeeWagesRequest other = (ListEmployeeWagesRequest) obj;
        return Objects.equals(employeeId, other.employeeId)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
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
     * Class to build instances of {@link ListEmployeeWagesRequest}.
     */
    public static class Builder {
        private String employeeId;
        private Integer limit;
        private String cursor;



        /**
         * Setter for employeeId.
         * @param employeeId String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        /**
         * Setter for limit.
         * @param limit Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
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
