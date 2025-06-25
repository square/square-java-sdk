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
 * This is a model class for ListBreakTypesRequest type.
 */
public class ListBreakTypesRequest {
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListBreakTypesRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.locationId = OptionalNullable.of(locationId);
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    protected ListBreakTypesRequest(
            OptionalNullable<String> locationId, OptionalNullable<Integer> limit, OptionalNullable<String> cursor) {
        this.locationId = locationId;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Internal Getter for LocationId.
     * Filter the returned `BreakType` results to only those that are associated with the specified
     * location.
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
     * Filter the returned `BreakType` results to only those that are associated with the specified
     * location.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of `BreakType` results to return per page. The number can range between 1
     * and 200. The default is 200.
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
     * The maximum number of `BreakType` results to return per page. The number can range between 1
     * and 200. The default is 200.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for Cursor.
     * A pointer to the next page of `BreakType` results to fetch.
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
     * A pointer to the next page of `BreakType` results to fetch.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListBreakTypesRequest)) {
            return false;
        }
        ListBreakTypesRequest other = (ListBreakTypesRequest) obj;
        return Objects.equals(locationId, other.locationId)
                && Objects.equals(limit, other.limit)
                && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListBreakTypesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListBreakTypesRequest [" + "locationId=" + locationId + ", limit=" + limit + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListBreakTypesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListBreakTypesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.locationId = internalGetLocationId();
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link ListBreakTypesRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> locationId;
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
         * Builds a new {@link ListBreakTypesRequest} object using the set fields.
         * @return {@link ListBreakTypesRequest}
         */
        public ListBreakTypesRequest build() {
            return new ListBreakTypesRequest(locationId, limit, cursor);
        }
    }
}
