package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchCustomersRequest type.
 */
public class SearchCustomersRequest {

    /**
     * Initialization constructor.
     * @param cursor
     * @param limit
     * @param query
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit, query);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchCustomersRequest)) {
            return false;
        }
        SearchCustomersRequest searchCustomersRequest = (SearchCustomersRequest) obj;
        return Objects.equals(cursor, searchCustomersRequest.cursor) &&
            Objects.equals(limit, searchCustomersRequest.limit) &&
            Objects.equals(query, searchCustomersRequest.query);
    }

    /**
     * Builds a new {@link SearchCustomersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchCustomersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .limit(getLimit())
            .query(getQuery());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchCustomersRequest}
     */
    public static class Builder {
        private String cursor;
        private Long limit;
        private CustomerQuery query;

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
         * Setter for query
         * @param query
         * @return Builder
         */
        public Builder query(CustomerQuery query) {
            this.query = query;
            return this;
        }

        /**
         * Builds a new {@link SearchCustomersRequest} object using the set fields.
         * @return {@link SearchCustomersRequest}
         */
        public SearchCustomersRequest build() {
            return new SearchCustomersRequest(cursor,
                limit,
                query);
        }
    }
}
