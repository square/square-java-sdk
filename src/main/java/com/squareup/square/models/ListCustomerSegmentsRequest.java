package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListCustomerSegmentsRequest type.
 */
public class ListCustomerSegmentsRequest {

    /**
     * Initialization constructor.
     * @param cursor
     * @param limit
     */
    @JsonCreator
    public ListCustomerSegmentsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Long limit) {
        this.cursor = cursor;
        this.limit = limit;
    }

    private final String cursor;
    private final Long limit;
    /**
     * Getter for Cursor.
     * A pagination cursor returned by previous calls to __ListCustomerSegments__.
     * Used to retrieve the next set of query results.
     * See the [Pagination guide](https://developer.squareup.com/docs/docs/working-with-apis/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Limit.
     * Sets the maximum number of results to be returned in a single page.
     * Limit values outside the supported range are ignored.
     * Minimum value: `1`
     * Maximum value: `1,000`
     */
    @JsonGetter("limit")
    public Long getLimit() {
        return this.limit;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListCustomerSegmentsRequest)) {
            return false;
        }
        ListCustomerSegmentsRequest listCustomerSegmentsRequest = (ListCustomerSegmentsRequest) obj;
        return Objects.equals(cursor, listCustomerSegmentsRequest.cursor) &&
            Objects.equals(limit, listCustomerSegmentsRequest.limit);
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
     * Class to build instances of {@link ListCustomerSegmentsRequest}
     */
    public static class Builder {
        private String cursor;
        private Long limit;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }
        /**
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Long limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds a new {@link ListCustomerSegmentsRequest} object using the set fields.
         * @return {@link ListCustomerSegmentsRequest}
         */
        public ListCustomerSegmentsRequest build() {
            return new ListCustomerSegmentsRequest(cursor,
                limit);
        }
    }
}
