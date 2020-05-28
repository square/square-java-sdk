package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchLoyaltyRewardsRequest type.
 */
public class SearchLoyaltyRewardsRequest {

    /**
     * Initialization constructor.
     * @param query
     * @param limit
     * @param cursor
     */
    @JsonCreator
    public SearchLoyaltyRewardsRequest(
            @JsonProperty("query") SearchLoyaltyRewardsRequestLoyaltyRewardQuery query,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.query = query;
        this.limit = limit;
        this.cursor = cursor;
    }

    private final SearchLoyaltyRewardsRequestLoyaltyRewardQuery query;
    private final Integer limit;
    private final String cursor;
    /**
     * Getter for Query.
     * The set of search requirements.
     */
    @JsonGetter("query")
    public SearchLoyaltyRewardsRequestLoyaltyRewardQuery getQuery() {
        return this.query;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to return in the response.
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
        if(!(obj instanceof SearchLoyaltyRewardsRequest)) {
            return false;
        }
        SearchLoyaltyRewardsRequest searchLoyaltyRewardsRequest = (SearchLoyaltyRewardsRequest) obj;
        return Objects.equals(query, searchLoyaltyRewardsRequest.query) &&
            Objects.equals(limit, searchLoyaltyRewardsRequest.limit) &&
            Objects.equals(cursor, searchLoyaltyRewardsRequest.cursor);
    }

    /**
     * Builds a new {@link SearchLoyaltyRewardsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchLoyaltyRewardsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .query(getQuery())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchLoyaltyRewardsRequest}
     */
    public static class Builder {
        private SearchLoyaltyRewardsRequestLoyaltyRewardQuery query;
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
        public Builder query(SearchLoyaltyRewardsRequestLoyaltyRewardQuery query) {
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
         * Builds a new {@link SearchLoyaltyRewardsRequest} object using the set fields.
         * @return {@link SearchLoyaltyRewardsRequest}
         */
        public SearchLoyaltyRewardsRequest build() {
            return new SearchLoyaltyRewardsRequest(query,
                limit,
                cursor);
        }
    }
}
