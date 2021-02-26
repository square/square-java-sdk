
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchCustomersRequest type.
 */
public class SearchCustomersRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CustomerQuery query;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Long value for limit.
     * @param  query  CustomerQuery value for query.
     */
    @JsonCreator
    public SearchCustomersRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Long limit,
            @JsonProperty("query") CustomerQuery query) {
        this.cursor = cursor;
        this.limit = limit;
        this.query = query;
    }

    /**
     * Getter for Cursor.
     * Include the pagination cursor in subsequent calls to this endpoint to retrieve the next set
     * of results associated with the original query. See the [Pagination
     * guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Limit.
     * A limit on the number of results to be returned in a single page. The limit is advisory - the
     * implementation may return more or fewer results. If the supplied limit is negative, zero, or
     * is higher than the maximum limit of 100, it will be ignored.
     * @return Returns the Long
     */
    @JsonGetter("limit")
    public Long getLimit() {
        return limit;
    }

    /**
     * Getter for Query.
     * Represents a query (including filtering criteria, sorting criteria, or both) used to search
     * for customer profiles.
     * @return Returns the CustomerQuery
     */
    @JsonGetter("query")
    public CustomerQuery getQuery() {
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
        if (!(obj instanceof SearchCustomersRequest)) {
            return false;
        }
        SearchCustomersRequest other = (SearchCustomersRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit)
            && Objects.equals(query, other.query);
    }

    /**
     * Converts this SearchCustomersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchCustomersRequest [" + "cursor=" + cursor + ", limit=" + limit + ", query="
                + query + "]";
    }

    /**
     * Builds a new {@link SearchCustomersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchCustomersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .cursor(getCursor())
                .limit(getLimit())
                .query(getQuery());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchCustomersRequest}.
     */
    public static class Builder {
        private String cursor;
        private Long limit;
        private CustomerQuery query;



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
         * @param  limit  Long value for limit.
         * @return Builder
         */
        public Builder limit(Long limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for query.
         * @param  query  CustomerQuery value for query.
         * @return Builder
         */
        public Builder query(CustomerQuery query) {
            this.query = query;
            return this;
        }

        /**
         * Builds a new {@link SearchCustomersRequest} object using the set fields.
         * @return {@link SearchCustomersRequest}
         */
        public SearchCustomersRequest build() {
            return new SearchCustomersRequest(cursor, limit, query);
        }
    }
}
