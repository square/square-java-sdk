package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchEventsRequest type.
 */
public class SearchEventsRequest {
    private final String cursor;
    private final Integer limit;
    private final SearchEventsQuery query;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     * @param  query  SearchEventsQuery value for query.
     */
    @JsonCreator
    public SearchEventsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("query") SearchEventsQuery query) {
        this.cursor = cursor;
        this.limit = limit;
        this.query = query;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of events for your original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Limit.
     * The maximum number of events to return in a single page. The response might contain fewer
     * events. The default value is 100, which is also the maximum allowed value. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * Default: 100
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Query.
     * Contains query criteria for the search.
     * @return Returns the SearchEventsQuery
     */
    @JsonGetter("query")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SearchEventsQuery getQuery() {
        return query;
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
        if (!(obj instanceof SearchEventsRequest)) {
            return false;
        }
        SearchEventsRequest other = (SearchEventsRequest) obj;
        return Objects.equals(cursor, other.cursor)
                && Objects.equals(limit, other.limit)
                && Objects.equals(query, other.query);
    }

    /**
     * Converts this SearchEventsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchEventsRequest [" + "cursor=" + cursor + ", limit=" + limit + ", query=" + query + "]";
    }

    /**
     * Builds a new {@link SearchEventsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchEventsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().cursor(getCursor()).limit(getLimit()).query(getQuery());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchEventsRequest}.
     */
    public static class Builder {
        private String cursor;
        private Integer limit;
        private SearchEventsQuery query;

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
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for query.
         * @param  query  SearchEventsQuery value for query.
         * @return Builder
         */
        public Builder query(SearchEventsQuery query) {
            this.query = query;
            return this;
        }

        /**
         * Builds a new {@link SearchEventsRequest} object using the set fields.
         * @return {@link SearchEventsRequest}
         */
        public SearchEventsRequest build() {
            return new SearchEventsRequest(cursor, limit, query);
        }
    }
}
