package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchTerminalCheckoutsRequest type.
 */
public class SearchTerminalCheckoutsRequest {

    /**
     * Initialization constructor.
     * @param query
     * @param cursor
     * @param limit
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

    private final TerminalCheckoutQuery query;
    private final String cursor;
    private final Integer limit;
    /**
     * Getter for Query.
     */
    @JsonGetter("query")
    public TerminalCheckoutQuery getQuery() {
        return this.query;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for the original query.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Limit.
     * Limit the number of results returned for a single request.
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(query, cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchTerminalCheckoutsRequest)) {
            return false;
        }
        SearchTerminalCheckoutsRequest searchTerminalCheckoutsRequest = (SearchTerminalCheckoutsRequest) obj;
        return Objects.equals(query, searchTerminalCheckoutsRequest.query) &&
            Objects.equals(cursor, searchTerminalCheckoutsRequest.cursor) &&
            Objects.equals(limit, searchTerminalCheckoutsRequest.limit);
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
     * Class to build instances of {@link SearchTerminalCheckoutsRequest}
     */
    public static class Builder {
        private TerminalCheckoutQuery query;
        private String cursor;
        private Integer limit;

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
        public Builder query(TerminalCheckoutQuery query) {
            this.query = query;
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
         * Setter for limit
         * @param limit
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
            return new SearchTerminalCheckoutsRequest(query,
                cursor,
                limit);
        }
    }
}
