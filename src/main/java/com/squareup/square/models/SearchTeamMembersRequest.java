
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchTeamMembersRequest type.
 */
public class SearchTeamMembersRequest {
    private final SearchTeamMembersQuery query;
    private final Integer limit;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param query SearchTeamMembersQuery value for query.
     * @param limit Integer value for limit.
     * @param cursor String value for cursor.
     */
    @JsonCreator
    public SearchTeamMembersRequest(
            @JsonProperty("query") SearchTeamMembersQuery query,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.query = query;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Getter for Query.
     * Represents the parameters in a search for `TeamMember` objects.
     * @return Returns the SearchTeamMembersQuery
     */
    @JsonGetter("query")
    public SearchTeamMembersQuery getQuery() {
        return this.query;
    }

    /**
     * Getter for Limit.
     * The maximum number of `TeamMember` objects in a page (25 by default).
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * The opaque cursor for fetching the next page. Read about
     * [pagination](https://developer.squareup.com/docs/working-with-apis/pagination) with Square
     * APIs for more information.
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
        if (!(obj instanceof SearchTeamMembersRequest)) {
            return false;
        }
        SearchTeamMembersRequest other = (SearchTeamMembersRequest) obj;
        return Objects.equals(query, other.query)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchTeamMembersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchTeamMembersRequest [" + "query=" + query + ", limit=" + limit + ", cursor="
                + cursor + "]";
    }

    /**
     * Builds a new {@link SearchTeamMembersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchTeamMembersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .query(getQuery())
                .limit(getLimit())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchTeamMembersRequest}.
     */
    public static class Builder {
        private SearchTeamMembersQuery query;
        private Integer limit;
        private String cursor;



        /**
         * Setter for query.
         * @param query SearchTeamMembersQuery value for query.
         * @return Builder
         */
        public Builder query(SearchTeamMembersQuery query) {
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
         * Builds a new {@link SearchTeamMembersRequest} object using the set fields.
         * @return {@link SearchTeamMembersRequest}
         */
        public SearchTeamMembersRequest build() {
            return new SearchTeamMembersRequest(query, limit, cursor);
        }
    }
}
