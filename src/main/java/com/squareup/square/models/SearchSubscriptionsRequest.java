package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchSubscriptionsRequest type.
 */
public class SearchSubscriptionsRequest {

    /**
     * Initialization constructor.
     * @param cursor
     * @param limit
     * @param query
     */
    @JsonCreator
    public SearchSubscriptionsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("query") SearchSubscriptionsQuery query) {
        this.cursor = cursor;
        this.limit = limit;
        this.query = query;
    }

    private final String cursor;
    private final Integer limit;
    private final SearchSubscriptionsQuery query;
    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for the original query.
     * For more information, see [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination).
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Limit.
     * The upper limit on the number of subscriptions to return 
     * in the response. 
     * Default: `200`
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Query.
     * Represents a query (including filtering criteria) used to search for subscriptions.
     */
    @JsonGetter("query")
    public SearchSubscriptionsQuery getQuery() {
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
        if(!(obj instanceof SearchSubscriptionsRequest)) {
            return false;
        }
        SearchSubscriptionsRequest searchSubscriptionsRequest = (SearchSubscriptionsRequest) obj;
        return Objects.equals(cursor, searchSubscriptionsRequest.cursor) &&
            Objects.equals(limit, searchSubscriptionsRequest.limit) &&
            Objects.equals(query, searchSubscriptionsRequest.query);
    }

    /**
     * Builds a new {@link SearchSubscriptionsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchSubscriptionsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .limit(getLimit())
            .query(getQuery());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchSubscriptionsRequest}
     */
    public static class Builder {
        private String cursor;
        private Integer limit;
        private SearchSubscriptionsQuery query;

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
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }
        /**
         * Setter for query
         * @param query
         * @return Builder
         */
        public Builder query(SearchSubscriptionsQuery query) {
            this.query = query;
            return this;
        }

        /**
         * Builds a new {@link SearchSubscriptionsRequest} object using the set fields.
         * @return {@link SearchSubscriptionsRequest}
         */
        public SearchSubscriptionsRequest build() {
            return new SearchSubscriptionsRequest(cursor,
                limit,
                query);
        }
    }
}
