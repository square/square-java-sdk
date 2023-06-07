
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListSubscriptionEventsRequest type.
 */
public class ListSubscriptionEventsRequest {
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<Integer> limit;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public ListSubscriptionEventsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.cursor = OptionalNullable.of(cursor);
        this.limit = OptionalNullable.of(limit);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListSubscriptionEventsRequest(OptionalNullable<String> cursor,
            OptionalNullable<Integer> limit) {
        this.cursor = cursor;
        this.limit = limit;
    }

    /**
     * Internal Getter for Cursor.
     * When the total number of resulting subscription events exceeds the limit of a paged response,
     * specify the cursor returned from a preceding response here to fetch the next set of results.
     * If the cursor is unset, the response contains the last page of the results. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the Internal String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCursor() {
        return this.cursor;
    }

    /**
     * Getter for Cursor.
     * When the total number of resulting subscription events exceeds the limit of a paged response,
     * specify the cursor returned from a preceding response here to fetch the next set of results.
     * If the cursor is unset, the response contains the last page of the results. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for Limit.
     * The upper limit on the number of subscription events to return in a paged response.
     * @return Returns the Internal Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetLimit() {
        return this.limit;
    }

    /**
     * Getter for Limit.
     * The upper limit on the number of subscription events to return in a paged response.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
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
        if (!(obj instanceof ListSubscriptionEventsRequest)) {
            return false;
        }
        ListSubscriptionEventsRequest other = (ListSubscriptionEventsRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListSubscriptionEventsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListSubscriptionEventsRequest [" + "cursor=" + cursor + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link ListSubscriptionEventsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListSubscriptionEventsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.cursor = internalGetCursor();
        builder.limit = internalGetLimit();
        return builder;
    }

    /**
     * Class to build instances of {@link ListSubscriptionEventsRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> cursor;
        private OptionalNullable<Integer> limit;



        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = OptionalNullable.of(cursor);
            return this;
        }

        /**
         * UnSetter for cursor.
         * @return Builder
         */
        public Builder unsetCursor() {
            cursor = null;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = OptionalNullable.of(limit);
            return this;
        }

        /**
         * UnSetter for limit.
         * @return Builder
         */
        public Builder unsetLimit() {
            limit = null;
            return this;
        }

        /**
         * Builds a new {@link ListSubscriptionEventsRequest} object using the set fields.
         * @return {@link ListSubscriptionEventsRequest}
         */
        public ListSubscriptionEventsRequest build() {
            return new ListSubscriptionEventsRequest(cursor, limit);
        }
    }
}
