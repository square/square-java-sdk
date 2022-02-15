
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchLoyaltyAccountsRequest type.
 */
public class SearchLoyaltyAccountsRequest {
    private final SearchLoyaltyAccountsRequestLoyaltyAccountQuery query;
    private final Integer limit;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  query  SearchLoyaltyAccountsRequestLoyaltyAccountQuery value for query.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
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

    /**
     * Getter for Query.
     * The search criteria for the loyalty accounts.
     * @return Returns the SearchLoyaltyAccountsRequestLoyaltyAccountQuery
     */
    @JsonGetter("query")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SearchLoyaltyAccountsRequestLoyaltyAccountQuery getQuery() {
        return query;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to include in the response. The default value is 30.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
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
        if (!(obj instanceof SearchLoyaltyAccountsRequest)) {
            return false;
        }
        SearchLoyaltyAccountsRequest other = (SearchLoyaltyAccountsRequest) obj;
        return Objects.equals(query, other.query)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchLoyaltyAccountsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchLoyaltyAccountsRequest [" + "query=" + query + ", limit=" + limit
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link SearchLoyaltyAccountsRequest}.
     */
    public static class Builder {
        private SearchLoyaltyAccountsRequestLoyaltyAccountQuery query;
        private Integer limit;
        private String cursor;



        /**
         * Setter for query.
         * @param  query  SearchLoyaltyAccountsRequestLoyaltyAccountQuery value for query.
         * @return Builder
         */
        public Builder query(SearchLoyaltyAccountsRequestLoyaltyAccountQuery query) {
            this.query = query;
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
         * Setter for cursor.
         * @param  cursor  String value for cursor.
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
            return new SearchLoyaltyAccountsRequest(query, limit, cursor);
        }
    }
}
