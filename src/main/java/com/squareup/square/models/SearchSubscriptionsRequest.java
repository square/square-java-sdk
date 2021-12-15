
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchSubscriptionsRequest type.
 */
public class SearchSubscriptionsRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final SearchSubscriptionsQuery query;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> include;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     * @param  query  SearchSubscriptionsQuery value for query.
     * @param  include  List of String value for include.
     */
    @JsonCreator
    public SearchSubscriptionsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("query") SearchSubscriptionsQuery query,
            @JsonProperty("include") List<String> include) {
        this.cursor = cursor;
        this.limit = limit;
        this.query = query;
        this.include = include;
    }

    /**
     * Getter for Cursor.
     * When the total number of resulting subscriptions exceeds the limit of a paged response,
     * specify the cursor returned from a preceding response here to fetch the next set of results.
     * If the cursor is unset, the response contains the last page of the results. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Limit.
     * The upper limit on the number of subscriptions to return in a paged response.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Query.
     * Represents a query, consisting of specified query expressions, used to search for
     * subscriptions.
     * @return Returns the SearchSubscriptionsQuery
     */
    @JsonGetter("query")
    public SearchSubscriptionsQuery getQuery() {
        return query;
    }

    /**
     * Getter for Include.
     * An option to include related information in the response. The supported values are: -
     * `actions`: to include scheduled actions on the targeted subscriptions.
     * @return Returns the List of String
     */
    @JsonGetter("include")
    public List<String> getInclude() {
        return include;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit, query, include);
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
            && Objects.equals(query, other.query)
            && Objects.equals(include, other.include);
    }

    /**
     * Converts this SearchSubscriptionsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchSubscriptionsRequest [" + "cursor=" + cursor + ", limit=" + limit + ", query="
                + query + ", include=" + include + "]";
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
                .query(getQuery())
                .include(getInclude());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchSubscriptionsRequest}.
     */
    public static class Builder {
        private String cursor;
        private Integer limit;
        private SearchSubscriptionsQuery query;
        private List<String> include;



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
         * @param  query  SearchSubscriptionsQuery value for query.
         * @return Builder
         */
        public Builder query(SearchSubscriptionsQuery query) {
            this.query = query;
            return this;
        }

        /**
         * Setter for include.
         * @param  include  List of String value for include.
         * @return Builder
         */
        public Builder include(List<String> include) {
            this.include = include;
            return this;
        }

        /**
         * Builds a new {@link SearchSubscriptionsRequest} object using the set fields.
         * @return {@link SearchSubscriptionsRequest}
         */
        public SearchSubscriptionsRequest build() {
            return new SearchSubscriptionsRequest(cursor, limit, query, include);
        }
    }
}
