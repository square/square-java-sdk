
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListEmployeeWagesRequest type.
 */
public class ListEmployeeWagesRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String employeeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  employeeId  String value for employeeId.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
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
     * Filter the returned wages to only those that are associated with the specified employee.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Getter for Limit.
     * The maximum number of `EmployeeWage` results to return per page. The number can range between
     * 1 and 200. The default is 200.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Cursor.
     * A pointer to the next page of `EmployeeWage` results to fetch.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
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
     * Converts this ListEmployeeWagesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListEmployeeWagesRequest [" + "employeeId=" + employeeId + ", limit=" + limit
                + ", cursor=" + cursor + "]";
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
         * @param  employeeId  String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
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
            return new ListEmployeeWagesRequest(employeeId, limit, cursor);
        }
    }
}
