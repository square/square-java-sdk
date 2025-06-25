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
 * This is a model class for ListCustomerGroupsRequest type.
 */
public class ListCustomerGroupsRequest {
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<Integer> limit;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public ListCustomerGroupsRequest(@JsonProperty("cursor") String cursor, @JsonProperty("limit") Integer limit) {
        this.cursor = OptionalNullable.of(cursor);
        this.limit = OptionalNullable.of(limit);
    }

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    protected ListCustomerGroupsRequest(OptionalNullable<String> cursor, OptionalNullable<Integer> limit) {
        this.cursor = cursor;
        this.limit = limit;
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for your original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
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
     * retrieve the next set of results for your original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of results to return in a single page. This limit is advisory. The
     * response might contain more or fewer results. If the limit is less than 1 or greater than 50,
     * Square returns a `400 VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The default value is 50.
     * For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
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
     * The maximum number of results to return in a single page. This limit is advisory. The
     * response might contain more or fewer results. If the limit is less than 1 or greater than 50,
     * Square returns a `400 VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The default value is 50.
     * For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCustomerGroupsRequest)) {
            return false;
        }
        ListCustomerGroupsRequest other = (ListCustomerGroupsRequest) obj;
        return Objects.equals(cursor, other.cursor) && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListCustomerGroupsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomerGroupsRequest [" + "cursor=" + cursor + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link ListCustomerGroupsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerGroupsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.cursor = internalGetCursor();
        builder.limit = internalGetLimit();
        return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerGroupsRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> cursor;
        private OptionalNullable<Integer> limit;

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
         * Builds a new {@link ListCustomerGroupsRequest} object using the set fields.
         * @return {@link ListCustomerGroupsRequest}
         */
        public ListCustomerGroupsRequest build() {
            return new ListCustomerGroupsRequest(cursor, limit);
        }
    }
}
