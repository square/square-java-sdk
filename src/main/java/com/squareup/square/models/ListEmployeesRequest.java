
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListEmployeesRequest type.
 */
public class ListEmployeesRequest {
    private final OptionalNullable<String> locationId;
    private final String status;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  status  String value for status.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListEmployeesRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("status") String status,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.locationId = OptionalNullable.of(locationId);
        this.status = status;
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListEmployeesRequest(OptionalNullable<String> locationId, String status,
            OptionalNullable<Integer> limit, OptionalNullable<String> cursor) {
        this.locationId = locationId;
        this.status = status;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Internal Getter for LocationId.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Getter for Status.
     * The status of the Employee being retrieved.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Internal Getter for Limit.
     * The number of employees to be returned on each page.
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
     * The number of employees to be returned on each page.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for Cursor.
     * The token required to retrieve the specified page of results.
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
     * The token required to retrieve the specified page of results.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, status, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListEmployeesRequest)) {
            return false;
        }
        ListEmployeesRequest other = (ListEmployeesRequest) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(status, other.status)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListEmployeesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListEmployeesRequest [" + "locationId=" + locationId + ", status=" + status
                + ", limit=" + limit + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListEmployeesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListEmployeesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .status(getStatus());
        builder.locationId = internalGetLocationId();
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link ListEmployeesRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> locationId;
        private String status;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> cursor;



        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
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
         * Builds a new {@link ListEmployeesRequest} object using the set fields.
         * @return {@link ListEmployeesRequest}
         */
        public ListEmployeesRequest build() {
            return new ListEmployeesRequest(locationId, status, limit, cursor);
        }
    }
}
