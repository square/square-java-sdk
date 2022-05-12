
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListPaymentLinksRequest type.
 */
public class ListPaymentLinksRequest {
    private final String cursor;
    private final Integer limit;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public ListPaymentLinksRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.cursor = cursor;
        this.limit = limit;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. If a cursor is not provided, the
     * endpoint returns the first page of the results. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Limit.
     * A limit on the number of results to return per page. The limit is advisory and the
     * implementation might return more or less results. If the supplied limit is negative, zero, or
     * greater than the maximum limit of 1000, it is ignored. Default value: `100`
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
        if (!(obj instanceof ListPaymentLinksRequest)) {
            return false;
        }
        ListPaymentLinksRequest other = (ListPaymentLinksRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListPaymentLinksRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListPaymentLinksRequest [" + "cursor=" + cursor + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link ListPaymentLinksRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPaymentLinksRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .cursor(getCursor())
                .limit(getLimit());
        return builder;
    }

    /**
     * Class to build instances of {@link ListPaymentLinksRequest}.
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
         * Builds a new {@link ListPaymentLinksRequest} object using the set fields.
         * @return {@link ListPaymentLinksRequest}
         */
        public ListPaymentLinksRequest build() {
            return new ListPaymentLinksRequest(cursor, limit);
        }
    }
}
