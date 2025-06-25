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
 * This is a model class for ListPayoutEntriesRequest type.
 */
public class ListPayoutEntriesRequest {
    private final String sortOrder;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<Integer> limit;

    /**
     * Initialization constructor.
     * @param  sortOrder  String value for sortOrder.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public ListPayoutEntriesRequest(
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.sortOrder = sortOrder;
        this.cursor = OptionalNullable.of(cursor);
        this.limit = OptionalNullable.of(limit);
    }

    /**
     * Initialization constructor.
     * @param  sortOrder  String value for sortOrder.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    protected ListPayoutEntriesRequest(
            String sortOrder, OptionalNullable<String> cursor, OptionalNullable<Integer> limit) {
        this.sortOrder = sortOrder;
        this.cursor = cursor;
        this.limit = limit;
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
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * If request parameters change between requests, subsequent results may contain duplicates or
     * missing records.
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
     * retrieve the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * If request parameters change between requests, subsequent results may contain duplicates or
     * missing records.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of results to be returned in a single page. It is possible to receive
     * fewer results than the specified limit on a given page. The default value of 100 is also the
     * maximum allowed value. If the provided value is greater than 100, it is ignored and the
     * default value is used instead. Default: `100`
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
     * The maximum number of results to be returned in a single page. It is possible to receive
     * fewer results than the specified limit on a given page. The default value of 100 is also the
     * maximum allowed value. If the provided value is greater than 100, it is ignored and the
     * default value is used instead. Default: `100`
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortOrder, cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListPayoutEntriesRequest)) {
            return false;
        }
        ListPayoutEntriesRequest other = (ListPayoutEntriesRequest) obj;
        return Objects.equals(sortOrder, other.sortOrder)
                && Objects.equals(cursor, other.cursor)
                && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListPayoutEntriesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListPayoutEntriesRequest [" + "sortOrder=" + sortOrder + ", cursor=" + cursor + ", limit=" + limit
                + "]";
    }

    /**
     * Builds a new {@link ListPayoutEntriesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPayoutEntriesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().sortOrder(getSortOrder());
        builder.cursor = internalGetCursor();
        builder.limit = internalGetLimit();
        return builder;
    }

    /**
     * Class to build instances of {@link ListPayoutEntriesRequest}.
     */
    public static class Builder {
        private String sortOrder;
        private OptionalNullable<String> cursor;
        private OptionalNullable<Integer> limit;

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
         * Builds a new {@link ListPayoutEntriesRequest} object using the set fields.
         * @return {@link ListPayoutEntriesRequest}
         */
        public ListPayoutEntriesRequest build() {
            return new ListPayoutEntriesRequest(sortOrder, cursor, limit);
        }
    }
}
