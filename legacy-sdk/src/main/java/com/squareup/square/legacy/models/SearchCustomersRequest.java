package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchCustomersRequest type.
 */
public class SearchCustomersRequest {
    private final String cursor;
    private final Long limit;
    private final CustomerQuery query;
    private final Boolean count;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Long value for limit.
     * @param  query  CustomerQuery value for query.
     * @param  count  Boolean value for count.
     */
    @JsonCreator
    public SearchCustomersRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Long limit,
            @JsonProperty("query") CustomerQuery query,
            @JsonProperty("count") Boolean count) {
        this.cursor = cursor;
        this.limit = limit;
        this.query = query;
        this.count = count;
    }

    /**
     * Getter for Cursor.
     * Include the pagination cursor in subsequent calls to this endpoint to retrieve the next set
     * of results associated with the original query. For more information, see
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
     * The maximum number of results to return in a single page. This limit is advisory. The
     * response might contain more or fewer results. If the specified limit is invalid, Square
     * returns a `400 VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The default value is 100. For
     * more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the Long
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getLimit() {
        return limit;
    }

    /**
     * Getter for Query.
     * Represents filtering and sorting criteria for a
     * [SearchCustomers]($e/Customers/SearchCustomers) request.
     * @return Returns the CustomerQuery
     */
    @JsonGetter("query")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomerQuery getQuery() {
        return query;
    }

    /**
     * Getter for Count.
     * Indicates whether to return the total count of matching customers in the `count` field of the
     * response. The default value is `false`.
     * @return Returns the Boolean
     */
    @JsonGetter("count")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getCount() {
        return count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit, query, count);
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
                && Objects.equals(query, other.query)
                && Objects.equals(count, other.count);
    }

    /**
     * Converts this SearchCustomersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchCustomersRequest [" + "cursor=" + cursor + ", limit=" + limit + ", query=" + query + ", count="
                + count + "]";
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
                .query(getQuery())
                .count(getCount());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchCustomersRequest}.
     */
    public static class Builder {
        private String cursor;
        private Long limit;
        private CustomerQuery query;
        private Boolean count;

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
         * Setter for count.
         * @param  count  Boolean value for count.
         * @return Builder
         */
        public Builder count(Boolean count) {
            this.count = count;
            return this;
        }

        /**
         * Builds a new {@link SearchCustomersRequest} object using the set fields.
         * @return {@link SearchCustomersRequest}
         */
        public SearchCustomersRequest build() {
            return new SearchCustomersRequest(cursor, limit, query, count);
        }
    }
}
