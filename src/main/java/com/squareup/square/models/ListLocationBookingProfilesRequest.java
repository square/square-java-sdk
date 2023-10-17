
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
 * This is a model class for ListLocationBookingProfilesRequest type.
 */
public class ListLocationBookingProfilesRequest {
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;

    /**
     * Initialization constructor.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListLocationBookingProfilesRequest(
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListLocationBookingProfilesRequest(OptionalNullable<Integer> limit,
            OptionalNullable<String> cursor) {
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of results to return in a paged response.
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
     * The maximum number of results to return in a paged response.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for Cursor.
     * The pagination cursor from the preceding response to return the next page of the results. Do
     * not set this when retrieving the first page of the results.
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
     * The pagination cursor from the preceding response to return the next page of the results. Do
     * not set this when retrieving the first page of the results.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
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
        if (!(obj instanceof ListLocationBookingProfilesRequest)) {
            return false;
        }
        ListLocationBookingProfilesRequest other = (ListLocationBookingProfilesRequest) obj;
        return Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListLocationBookingProfilesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListLocationBookingProfilesRequest [" + "limit=" + limit + ", cursor=" + cursor
                + "]";
    }

    /**
     * Builds a new {@link ListLocationBookingProfilesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListLocationBookingProfilesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link ListLocationBookingProfilesRequest}.
     */
    public static class Builder {
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> cursor;



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
         * Builds a new {@link ListLocationBookingProfilesRequest} object using the set fields.
         * @return {@link ListLocationBookingProfilesRequest}
         */
        public ListLocationBookingProfilesRequest build() {
            return new ListLocationBookingProfilesRequest(limit, cursor);
        }
    }
}
