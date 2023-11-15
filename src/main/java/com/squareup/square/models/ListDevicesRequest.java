
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListDevicesRequest type.
 */
public class ListDevicesRequest {
    private final OptionalNullable<String> cursor;
    private final String sortOrder;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> locationId;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  sortOrder  String value for sortOrder.
     * @param  limit  Integer value for limit.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public ListDevicesRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("location_id") String locationId) {
        this.cursor = OptionalNullable.of(cursor);
        this.sortOrder = sortOrder;
        this.limit = OptionalNullable.of(limit);
        this.locationId = OptionalNullable.of(locationId);
    }

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  sortOrder  String value for sortOrder.
     * @param  limit  Integer value for limit.
     * @param  locationId  String value for locationId.
     */

    protected ListDevicesRequest(OptionalNullable<String> cursor, String sortOrder,
            OptionalNullable<Integer> limit, OptionalNullable<String> locationId) {
        this.cursor = cursor;
        this.sortOrder = sortOrder;
        this.limit = limit;
        this.locationId = locationId;
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. See
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     * for more information.
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
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. See
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     * for more information.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Internal Getter for Limit.
     * The number of results to return in a single page.
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
     * The number of results to return in a single page.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for LocationId.
     * If present, only returns devices at the target location.
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
     * If present, only returns devices at the target location.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, sortOrder, limit, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListDevicesRequest)) {
            return false;
        }
        ListDevicesRequest other = (ListDevicesRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(sortOrder, other.sortOrder)
            && Objects.equals(limit, other.limit)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this ListDevicesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListDevicesRequest [" + "cursor=" + cursor + ", sortOrder=" + sortOrder + ", limit="
                + limit + ", locationId=" + locationId + "]";
    }

    /**
     * Builds a new {@link ListDevicesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDevicesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .sortOrder(getSortOrder());
        builder.cursor = internalGetCursor();
        builder.limit = internalGetLimit();
        builder.locationId = internalGetLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link ListDevicesRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> cursor;
        private String sortOrder;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> locationId;



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
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
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
         * Builds a new {@link ListDevicesRequest} object using the set fields.
         * @return {@link ListDevicesRequest}
         */
        public ListDevicesRequest build() {
            return new ListDevicesRequest(cursor, sortOrder, limit, locationId);
        }
    }
}
