
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListCustomerGroupsRequest type.
 */
public class ListCustomerGroupsRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public ListCustomerGroupsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.cursor = cursor;
        this.limit = limit;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for your original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to return in a single page. This limit is advisory. The
     * response might contain more or fewer results. The limit is ignored if it is less than 1 or
     * greater than 50. The default value is 50. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCustomerGroupsRequest)) {
            return false;
        }
        ListCustomerGroupsRequest other = (ListCustomerGroupsRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListCustomerGroupsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomerGroupsRequest [" + "cursor=" + cursor + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link ListCustomerGroupsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerGroupsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .cursor(getCursor())
                .limit(getLimit());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerGroupsRequest}.
     */
    public static class Builder {
        private String cursor;
        private Integer limit;



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
         * Builds a new {@link ListCustomerGroupsRequest} object using the set fields.
         * @return {@link ListCustomerGroupsRequest}
         */
        public ListCustomerGroupsRequest build() {
            return new ListCustomerGroupsRequest(cursor, limit);
        }
    }
}
