
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
 * This is a model class for ListCustomersRequest type.
 */
public class ListCustomersRequest {
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<Integer> limit;
    private final String sortField;
    private final String sortOrder;
    private final OptionalNullable<Boolean> count;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     * @param  sortField  String value for sortField.
     * @param  sortOrder  String value for sortOrder.
     * @param  count  Boolean value for count.
     */
    @JsonCreator
    public ListCustomersRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("sort_field") String sortField,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("count") Boolean count) {
        this.cursor = OptionalNullable.of(cursor);
        this.limit = OptionalNullable.of(limit);
        this.sortField = sortField;
        this.sortOrder = sortOrder;
        this.count = OptionalNullable.of(count);
    }

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     * @param  sortField  String value for sortField.
     * @param  sortOrder  String value for sortOrder.
     * @param  count  Boolean value for count.
     */

    protected ListCustomersRequest(OptionalNullable<String> cursor, OptionalNullable<Integer> limit,
            String sortField, String sortOrder, OptionalNullable<Boolean> count) {
        this.cursor = cursor;
        this.limit = limit;
        this.sortField = sortField;
        this.sortOrder = sortOrder;
        this.count = count;
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
     * response might contain more or fewer results. If the specified limit is less than 1 or
     * greater than 100, Square returns a `400 VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The
     * default value is 100. For more information, see
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
     * response might contain more or fewer results. If the specified limit is less than 1 or
     * greater than 100, Square returns a `400 VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The
     * default value is 100. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Getter for SortField.
     * Specifies customer attributes as the sort key to customer profiles returned from a search.
     * @return Returns the String
     */
    @JsonGetter("sort_field")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSortField() {
        return sortField;
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
     * Internal Getter for Count.
     * Indicates whether to return the total count of customers in the `count` field of the
     * response. The default value is `false`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("count")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetCount() {
        return this.count;
    }

    /**
     * Getter for Count.
     * Indicates whether to return the total count of customers in the `count` field of the
     * response. The default value is `false`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getCount() {
        return OptionalNullable.getFrom(count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit, sortField, sortOrder, count);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCustomersRequest)) {
            return false;
        }
        ListCustomersRequest other = (ListCustomersRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit)
            && Objects.equals(sortField, other.sortField)
            && Objects.equals(sortOrder, other.sortOrder)
            && Objects.equals(count, other.count);
    }

    /**
     * Converts this ListCustomersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomersRequest [" + "cursor=" + cursor + ", limit=" + limit + ", sortField="
                + sortField + ", sortOrder=" + sortOrder + ", count=" + count + "]";
    }

    /**
     * Builds a new {@link ListCustomersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .sortField(getSortField())
                .sortOrder(getSortOrder());
        builder.cursor = internalGetCursor();
        builder.limit = internalGetLimit();
        builder.count = internalGetCount();
        return builder;
    }

    /**
     * Class to build instances of {@link ListCustomersRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> cursor;
        private OptionalNullable<Integer> limit;
        private String sortField;
        private String sortOrder;
        private OptionalNullable<Boolean> count;



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
         * Setter for sortField.
         * @param  sortField  String value for sortField.
         * @return Builder
         */
        public Builder sortField(String sortField) {
            this.sortField = sortField;
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
         * Setter for count.
         * @param  count  Boolean value for count.
         * @return Builder
         */
        public Builder count(Boolean count) {
            this.count = OptionalNullable.of(count);
            return this;
        }

        /**
         * UnSetter for count.
         * @return Builder
         */
        public Builder unsetCount() {
            count = null;
            return this;
        }

        /**
         * Builds a new {@link ListCustomersRequest} object using the set fields.
         * @return {@link ListCustomersRequest}
         */
        public ListCustomersRequest build() {
            return new ListCustomersRequest(cursor, limit, sortField, sortOrder, count);
        }
    }
}
