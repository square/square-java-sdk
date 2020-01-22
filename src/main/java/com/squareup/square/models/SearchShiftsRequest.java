package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchShiftsRequest type.
 */
public class SearchShiftsRequest {

    /**
     * Initialization constructor.
     * @param query
     * @param limit
     * @param cursor
     */
    @JsonCreator
    public SearchShiftsRequest(
            @JsonProperty("query") ShiftQuery query,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.query = query;
        this.limit = limit;
        this.cursor = cursor;
    }

    private final ShiftQuery query;
    private final Integer limit;
    private final String cursor;
    /**
     * Getter for Query.
     * The parameters of a `Shift` search query. Includes filter and sort options.
     */
    @JsonGetter("query")
    public ShiftQuery getQuery() {
        return this.query;
    }

    /**
     * Getter for Limit.
     * number of resources in a page (200 by default).
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * opaque cursor for fetching the next page.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(query, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchShiftsRequest)) {
            return false;
        }
        SearchShiftsRequest searchShiftsRequest = (SearchShiftsRequest) obj;
        return Objects.equals(query, searchShiftsRequest.query) &&
            Objects.equals(limit, searchShiftsRequest.limit) &&
            Objects.equals(cursor, searchShiftsRequest.cursor);
    }

    /**
     * Builds a new {@link SearchShiftsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchShiftsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .query(getQuery())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchShiftsRequest}
     */
    public static class Builder {
        private ShiftQuery query;
        private Integer limit;
        private String cursor;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for query
         * @param query
         * @return Builder
         */
        public Builder query(ShiftQuery query) {
            this.query = query;
            return this;
        }
        /**
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
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
         * Builds a new {@link SearchShiftsRequest} object using the set fields.
         * @return {@link SearchShiftsRequest}
         */
        public SearchShiftsRequest build() {
            return new SearchShiftsRequest(query,
                limit,
                cursor);
        }
    }
}
