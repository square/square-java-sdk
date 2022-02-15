
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchShiftsRequest type.
 */
public class SearchShiftsRequest {
    private final ShiftQuery query;
    private final Integer limit;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  query  ShiftQuery value for query.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public SearchShiftsRequest(
            @JsonProperty("query") ShiftQuery query,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.query = query;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Getter for Query.
     * The parameters of a `Shift` search query, which includes filter and sort options.
     * @return Returns the ShiftQuery
     */
    @JsonGetter("query")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ShiftQuery getQuery() {
        return query;
    }

    /**
     * Getter for Limit.
     * The number of resources in a page (200 by default).
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Cursor.
     * An opaque cursor for fetching the next page.
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
        if (!(obj instanceof SearchShiftsRequest)) {
            return false;
        }
        SearchShiftsRequest other = (SearchShiftsRequest) obj;
        return Objects.equals(query, other.query)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchShiftsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchShiftsRequest [" + "query=" + query + ", limit=" + limit + ", cursor="
                + cursor + "]";
    }

    /**
     * Builds a new {@link SearchShiftsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchShiftsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .query(getQuery())
                .limit(getLimit())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchShiftsRequest}.
     */
    public static class Builder {
        private ShiftQuery query;
        private Integer limit;
        private String cursor;



        /**
         * Setter for query.
         * @param  query  ShiftQuery value for query.
         * @return Builder
         */
        public Builder query(ShiftQuery query) {
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
         * Builds a new {@link SearchShiftsRequest} object using the set fields.
         * @return {@link SearchShiftsRequest}
         */
        public SearchShiftsRequest build() {
            return new SearchShiftsRequest(query, limit, cursor);
        }
    }
}
