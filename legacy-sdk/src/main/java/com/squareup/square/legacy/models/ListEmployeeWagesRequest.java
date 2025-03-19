package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListEmployeeWagesRequest type.
 */
public class ListEmployeeWagesRequest {
    private final OptionalNullable<String> employeeId;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;

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
        this.employeeId = OptionalNullable.of(employeeId);
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Initialization constructor.
     * @param  employeeId  String value for employeeId.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    protected ListEmployeeWagesRequest(
            OptionalNullable<String> employeeId, OptionalNullable<Integer> limit, OptionalNullable<String> cursor) {
        this.employeeId = employeeId;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Internal Getter for EmployeeId.
     * Filter the returned wages to only those that are associated with the specified employee.
     * @return Returns the Internal String
     */
    @JsonGetter("employee_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for EmployeeId.
     * Filter the returned wages to only those that are associated with the specified employee.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmployeeId() {
        return OptionalNullable.getFrom(employeeId);
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of `EmployeeWage` results to return per page. The number can range between
     * 1 and 200. The default is 200.
     * @return Returns the Internal Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetLimit() {
        return this.limit;
    }

    /**
     * Getter for Limit.
     * The maximum number of `EmployeeWage` results to return per page. The number can range between
     * 1 and 200. The default is 200.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for Cursor.
     * A pointer to the next page of `EmployeeWage` results to fetch.
     * @return Returns the Internal String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCursor() {
        return this.cursor;
    }

    /**
     * Getter for Cursor.
     * A pointer to the next page of `EmployeeWage` results to fetch.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
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
        return "ListEmployeeWagesRequest [" + "employeeId=" + employeeId + ", limit=" + limit + ", cursor=" + cursor
                + "]";
    }

    /**
     * Builds a new {@link ListEmployeeWagesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListEmployeeWagesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.employeeId = internalGetEmployeeId();
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link ListEmployeeWagesRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> employeeId;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> cursor;

        /**
         * Setter for employeeId.
         * @param  employeeId  String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = OptionalNullable.of(employeeId);
            return this;
        }

        /**
         * UnSetter for employeeId.
         * @return Builder
         */
        public Builder unsetEmployeeId() {
            employeeId = null;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = OptionalNullable.of(limit);
            return this;
        }

        /**
         * UnSetter for limit.
         * @return Builder
         */
        public Builder unsetLimit() {
            limit = null;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = OptionalNullable.of(cursor);
            return this;
        }

        /**
         * UnSetter for cursor.
         * @return Builder
         */
        public Builder unsetCursor() {
            cursor = null;
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
