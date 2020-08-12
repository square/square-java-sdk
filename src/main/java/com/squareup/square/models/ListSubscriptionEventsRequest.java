package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListSubscriptionEventsRequest type.
 */
public class ListSubscriptionEventsRequest {

    /**
     * Initialization constructor.
     * @param cursor
     * @param limit
     */
    @JsonCreator
    public ListSubscriptionEventsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.cursor = cursor;
        this.limit = limit;
    }

    private final String cursor;
    private final Integer limit;
    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for the original query.
     * For more information, see [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination).
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Limit.
     * The upper limit on the number of subscription events to return 
     * in the response. 
     * Default: `200`
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListSubscriptionEventsRequest)) {
            return false;
        }
        ListSubscriptionEventsRequest listSubscriptionEventsRequest = (ListSubscriptionEventsRequest) obj;
        return Objects.equals(cursor, listSubscriptionEventsRequest.cursor) &&
            Objects.equals(limit, listSubscriptionEventsRequest.limit);
    }

    /**
     * Builds a new {@link ListSubscriptionEventsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListSubscriptionEventsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .limit(getLimit());
            return builder;
    }

    /**
     * Class to build instances of {@link ListSubscriptionEventsRequest}
     */
    public static class Builder {
        private String cursor;
        private Integer limit;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds a new {@link ListSubscriptionEventsRequest} object using the set fields.
         * @return {@link ListSubscriptionEventsRequest}
         */
        public ListSubscriptionEventsRequest build() {
            return new ListSubscriptionEventsRequest(cursor,
                limit);
        }
    }
}
