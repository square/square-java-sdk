
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListWorkweekConfigsRequest type.
 */
public class ListWorkweekConfigsRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListWorkweekConfigsRequest(
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Getter for Limit.
     * Maximum number of Workweek Configs to return per page.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Cursor.
     * Pointer to the next page of Workweek Config results to fetch.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListWorkweekConfigsRequest)) {
            return false;
        }
        ListWorkweekConfigsRequest other = (ListWorkweekConfigsRequest) obj;
        return Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListWorkweekConfigsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListWorkweekConfigsRequest [" + "limit=" + limit + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListWorkweekConfigsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListWorkweekConfigsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .limit(getLimit())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListWorkweekConfigsRequest}.
     */
    public static class Builder {
        private Integer limit;
        private String cursor;



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
         * Builds a new {@link ListWorkweekConfigsRequest} object using the set fields.
         * @return {@link ListWorkweekConfigsRequest}
         */
        public ListWorkweekConfigsRequest build() {
            return new ListWorkweekConfigsRequest(limit, cursor);
        }
    }
}
