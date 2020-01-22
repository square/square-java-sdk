package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListWorkweekConfigsRequest type.
 */
public class ListWorkweekConfigsRequest {

    /**
     * Initialization constructor.
     * @param limit
     * @param cursor
     */
    @JsonCreator
    public ListWorkweekConfigsRequest(
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.limit = limit;
        this.cursor = cursor;
    }

    private final Integer limit;
    private final String cursor;
    /**
     * Getter for Limit.
     * Maximum number of Workweek Configs to return per page.
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * Pointer to the next page of Workweek Config results to fetch.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListWorkweekConfigsRequest)) {
            return false;
        }
        ListWorkweekConfigsRequest listWorkweekConfigsRequest = (ListWorkweekConfigsRequest) obj;
        return Objects.equals(limit, listWorkweekConfigsRequest.limit) &&
            Objects.equals(cursor, listWorkweekConfigsRequest.cursor);
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
     * Class to build instances of {@link ListWorkweekConfigsRequest}
     */
    public static class Builder {
        private Integer limit;
        private String cursor;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for cursor
         * @param cursor
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
            return new ListWorkweekConfigsRequest(limit,
                cursor);
        }
    }
}
