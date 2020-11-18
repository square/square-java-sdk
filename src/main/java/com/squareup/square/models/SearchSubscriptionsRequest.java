
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchSubscriptionsRequest type.
 */
public class SearchSubscriptionsRequest {
    private final String cursor;
    private final Integer limit;
    private final SearchSubscriptionsQuery query;

    /**
     * Initialization constructor.
     * @param cursor String value for cursor.
     * @param limit Integer value for limit.
     * @param query SearchSubscriptionsQuery value for query.
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

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Limit.
     * The upper limit on the number of subscriptions to return in the response. Default: `200`
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Query.
     * Represents a query (including filtering criteria) used to search for subscriptions.
     * @return Returns the SearchSubscriptionsQuery
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchSubscriptionsRequest)) {
            return false;
        }
        SearchSubscriptionsRequest other = (SearchSubscriptionsRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit)
            && Objects.equals(query, other.query);
    }

    /**
     * Converts this SearchSubscriptionsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchSubscriptionsRequest [" + "cursor=" + cursor + ", limit=" + limit + ", query="
                + query + "]";
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
     * Class to build instances of {@link SearchSubscriptionsRequest}.
     */
    public static class Builder {
        private String cursor;
        private Integer limit;
        private SearchSubscriptionsQuery query;



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
         * Setter for limit.
         * @param limit Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for query.
         * @param query SearchSubscriptionsQuery value for query.
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
            return new SearchSubscriptionsRequest(cursor, limit, query);
        }
    }
}
