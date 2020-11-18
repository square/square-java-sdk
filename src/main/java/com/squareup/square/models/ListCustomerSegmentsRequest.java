
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListCustomerSegmentsRequest type.
 */
public class ListCustomerSegmentsRequest {
    private final String cursor;

    /**
     * Initialization constructor.
     * @param cursor String value for cursor.
     */
    @JsonCreator
    public ListCustomerSegmentsRequest(
            @JsonProperty("cursor") String cursor) {
        this.cursor = cursor;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by previous calls to __ListCustomerSegments__. Used to retrieve
     * the next set of query results. See the [Pagination
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
        if (!(obj instanceof ListCustomerSegmentsRequest)) {
            return false;
        }
        ListCustomerSegmentsRequest other = (ListCustomerSegmentsRequest) obj;
        return Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListCustomerSegmentsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomerSegmentsRequest [" + "cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListCustomerSegmentsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerSegmentsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerSegmentsRequest}.
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
         * Builds a new {@link ListCustomerSegmentsRequest} object using the set fields.
         * @return {@link ListCustomerSegmentsRequest}
         */
        public ListCustomerSegmentsRequest build() {
            return new ListCustomerSegmentsRequest(cursor);
        }
    }
}
