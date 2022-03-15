
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListCustomerSegmentsRequest type.
 */
public class ListCustomerSegmentsRequest {
    private final String cursor;
    private final Integer limit;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public ListCustomerSegmentsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.cursor = cursor;
        this.limit = limit;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by previous calls to `ListCustomerSegments`. This cursor is used
     * to retrieve the next set of query results. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to return in a single page. This limit is advisory. The
     * response might contain more or fewer results. If the specified limit is less than 1 or
     * greater than 50, Square returns a `400 VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The
     * default value is 50. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getLimit() {
        return limit;
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
        if (!(obj instanceof ListCustomerSegmentsRequest)) {
            return false;
        }
        ListCustomerSegmentsRequest other = (ListCustomerSegmentsRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListCustomerSegmentsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomerSegmentsRequest [" + "cursor=" + cursor + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link ListCustomerSegmentsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerSegmentsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .cursor(getCursor())
                .limit(getLimit());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerSegmentsRequest}.
     */
    public static class Builder {
        private String cursor;
        private Integer limit;



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
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds a new {@link ListCustomerSegmentsRequest} object using the set fields.
         * @return {@link ListCustomerSegmentsRequest}
         */
        public ListCustomerSegmentsRequest build() {
            return new ListCustomerSegmentsRequest(cursor, limit);
        }
    }
}
