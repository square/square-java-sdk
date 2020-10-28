
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for ListCustomerGroupsRequest type.
 */
public class ListCustomerGroupsRequest {
    private final String cursor;

    /**
     * Initialization constructor.
     * @param cursor String value for cursor.
     */
    @JsonCreator
    public ListCustomerGroupsRequest(
            @JsonProperty("cursor") String cursor) {
        this.cursor = cursor;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See the [Pagination
     * guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(cursor);
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
        return Objects.equals(cursor, other.cursor);
    }

    /**
     * Builds a new {@link ListCustomerGroupsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerGroupsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerGroupsRequest}.
     */
    public static class Builder {
        private String cursor;



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
         * Builds a new {@link ListCustomerGroupsRequest} object using the set fields.
         * @return {@link ListCustomerGroupsRequest}
         */
        public ListCustomerGroupsRequest build() {
            return new ListCustomerGroupsRequest(cursor);
        }
    }
}
