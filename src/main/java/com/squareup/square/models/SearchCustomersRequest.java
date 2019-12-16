package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchCustomersRequest {

    @JsonCreator
    public SearchCustomersRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Long limit,
            @JsonProperty("query") CustomerQuery query) {
        this.cursor = cursor;
        this.limit = limit;
        this.query = query;
    }

    private final String cursor;
    private final Long limit;
    private final CustomerQuery query;

    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit, query);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchCustomersRequest)) {
            return false;
        }
        SearchCustomersRequest searchCustomersRequest = (SearchCustomersRequest) o;
        return Objects.equals(cursor, searchCustomersRequest.cursor) &&
            Objects.equals(limit, searchCustomersRequest.limit) &&
            Objects.equals(query, searchCustomersRequest.query);
    }

    /**
     * Getter for Cursor.
     * Include the pagination cursor in subsequent calls to this endpoint to retrieve
     * the next set of results associated with the original query.
     * See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

    /**
     * Getter for Limit.
     * A limit on the number of results to be returned in a single page.
     * The limit is advisory - the implementation may return more or fewer results.
     * If the supplied limit is negative, zero, or is higher than the maximum limit
     * of 1,000, it will be ignored.
     */
    @JsonGetter("limit")
    public Long getLimit() { 
        return this.limit;
    }

    /**
     * Getter for Query.
     * Represents a query (filtering and sorting criteria) used to search
     * for customer profiles.
     */
    @JsonGetter("query")
    public CustomerQuery getQuery() { 
        return this.query;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .limit(getLimit())
            .query(getQuery());
            return builder;
    }

    public static class Builder {
        private String cursor;
        private Long limit;
        private CustomerQuery query;

        public Builder() { }

        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder limit(Long value) {
            limit = value;
            return this;
        }
        public Builder query(CustomerQuery value) {
            query = value;
            return this;
        }

        public SearchCustomersRequest build() {
            return new SearchCustomersRequest(cursor,
                limit,
                query);
        }
    }
}
