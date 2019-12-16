package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchShiftsRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(query, limit, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchShiftsRequest)) {
            return false;
        }
        SearchShiftsRequest searchShiftsRequest = (SearchShiftsRequest) o;
        return Objects.equals(query, searchShiftsRequest.query) &&
            Objects.equals(limit, searchShiftsRequest.limit) &&
            Objects.equals(cursor, searchShiftsRequest.cursor);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .query(getQuery())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private ShiftQuery query;
        private Integer limit;
        private String cursor;

        public Builder() { }

        public Builder query(ShiftQuery value) {
            query = value;
            return this;
        }
        public Builder limit(Integer value) {
            limit = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public SearchShiftsRequest build() {
            return new SearchShiftsRequest(query,
                limit,
                cursor);
        }
    }
}
