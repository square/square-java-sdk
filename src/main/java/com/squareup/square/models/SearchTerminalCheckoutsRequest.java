
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchTerminalCheckoutsRequest type.
 */
public class SearchTerminalCheckoutsRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TerminalCheckoutQuery query;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;

    /**
     * Initialization constructor.
     * @param  query  TerminalCheckoutQuery value for query.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public SearchTerminalCheckoutsRequest(
            @JsonProperty("query") TerminalCheckoutQuery query,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.query = query;
        this.cursor = cursor;
        this.limit = limit;
    }

    /**
     * Getter for Query.
     * @return Returns the TerminalCheckoutQuery
     */
    @JsonGetter("query")
    public TerminalCheckoutQuery getQuery() {
        return query;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. See
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Limit.
     * Limits the number of results returned for a single request.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(query, cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchTerminalCheckoutsRequest)) {
            return false;
        }
        SearchTerminalCheckoutsRequest other = (SearchTerminalCheckoutsRequest) obj;
        return Objects.equals(query, other.query)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this SearchTerminalCheckoutsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchTerminalCheckoutsRequest [" + "query=" + query + ", cursor=" + cursor
                + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link SearchTerminalCheckoutsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchTerminalCheckoutsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .query(getQuery())
                .cursor(getCursor())
                .limit(getLimit());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchTerminalCheckoutsRequest}.
     */
    public static class Builder {
        private TerminalCheckoutQuery query;
        private String cursor;
        private Integer limit;



        /**
         * Setter for query.
         * @param  query  TerminalCheckoutQuery value for query.
         * @return Builder
         */
        public Builder query(TerminalCheckoutQuery query) {
            this.query = query;
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
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds a new {@link SearchTerminalCheckoutsRequest} object using the set fields.
         * @return {@link SearchTerminalCheckoutsRequest}
         */
        public SearchTerminalCheckoutsRequest build() {
            return new SearchTerminalCheckoutsRequest(query, cursor, limit);
        }
    }
}
