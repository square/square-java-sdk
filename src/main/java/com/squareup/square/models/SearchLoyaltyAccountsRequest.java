package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchLoyaltyAccountsRequest type.
 */
public class SearchLoyaltyAccountsRequest {

    /**
     * Initialization constructor.
     * @param query
     * @param limit
     * @param cursor
     */
    @JsonCreator
    public SearchLoyaltyAccountsRequest(
            @JsonProperty("query") SearchLoyaltyAccountsRequestLoyaltyAccountQuery query,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.query = query;
        this.limit = limit;
        this.cursor = cursor;
    }

    private final SearchLoyaltyAccountsRequestLoyaltyAccountQuery query;
    private final Integer limit;
    private final String cursor;
    /**
     * Getter for Query.
     * The search criteria for the loyalty accounts.
     */
    @JsonGetter("query")
    public SearchLoyaltyAccountsRequestLoyaltyAccountQuery getQuery() {
        return this.query;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to include in the response.
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to 
     * this endpoint. Provide this to retrieve the next set of 
     * results for the original query.
     * For more information, 
     * see [Pagination](https://developer.squareup.com/docs/docs/basics/api101/pagination).
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
        if(!(obj instanceof SearchLoyaltyAccountsRequest)) {
            return false;
        }
        SearchLoyaltyAccountsRequest searchLoyaltyAccountsRequest = (SearchLoyaltyAccountsRequest) obj;
        return Objects.equals(query, searchLoyaltyAccountsRequest.query) &&
            Objects.equals(limit, searchLoyaltyAccountsRequest.limit) &&
            Objects.equals(cursor, searchLoyaltyAccountsRequest.cursor);
    }

    /**
     * Builds a new {@link SearchLoyaltyAccountsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchLoyaltyAccountsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .query(getQuery())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchLoyaltyAccountsRequest}
     */
    public static class Builder {
        private SearchLoyaltyAccountsRequestLoyaltyAccountQuery query;
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
        public Builder query(SearchLoyaltyAccountsRequestLoyaltyAccountQuery query) {
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
         * Builds a new {@link SearchLoyaltyAccountsRequest} object using the set fields.
         * @return {@link SearchLoyaltyAccountsRequest}
         */
        public SearchLoyaltyAccountsRequest build() {
            return new SearchLoyaltyAccountsRequest(query,
                limit,
                cursor);
        }
    }
}
