
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for SearchLoyaltyRewardsRequest type.
 */
public class SearchLoyaltyRewardsRequest {
    private final SearchLoyaltyRewardsRequestLoyaltyRewardQuery query;
    private final Integer limit;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param query SearchLoyaltyRewardsRequestLoyaltyRewardQuery value for query.
     * @param limit Integer value for limit.
     * @param cursor String value for cursor.
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

    /**
     * Getter for Query.
     * The set of search requirements.
     * @return Returns the SearchLoyaltyRewardsRequestLoyaltyRewardQuery
     */
    @JsonGetter("query")
    public SearchLoyaltyRewardsRequestLoyaltyRewardQuery getQuery() {
        return this.query;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to return in the response.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/docs/basics/api101/pagination).
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchLoyaltyRewardsRequest)) {
            return false;
        }
        SearchLoyaltyRewardsRequest other = (SearchLoyaltyRewardsRequest) obj;
        return Objects.equals(query, other.query)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
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
     * Class to build instances of {@link SearchLoyaltyRewardsRequest}.
     */
    public static class Builder {
        private SearchLoyaltyRewardsRequestLoyaltyRewardQuery query;
        private Integer limit;
        private String cursor;



        /**
         * Setter for query.
         * @param query SearchLoyaltyRewardsRequestLoyaltyRewardQuery value for query.
         * @return Builder
         */
        public Builder query(SearchLoyaltyRewardsRequestLoyaltyRewardQuery query) {
            this.query = query;
            return this;
        }

        /**
         * Setter for limit.
         * @param limit Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
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
