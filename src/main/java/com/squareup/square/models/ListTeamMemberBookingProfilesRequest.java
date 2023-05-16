
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
 * This is a model class for ListTeamMemberBookingProfilesRequest type.
 */
public class ListTeamMemberBookingProfilesRequest {
    private final OptionalNullable<Boolean> bookableOnly;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<String> locationId;

    /**
     * Initialization constructor.
     * @param  bookableOnly  Boolean value for bookableOnly.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public ListTeamMemberBookingProfilesRequest(
            @JsonProperty("bookable_only") Boolean bookableOnly,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("location_id") String locationId) {
        this.bookableOnly = OptionalNullable.of(bookableOnly);
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
        this.locationId = OptionalNullable.of(locationId);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListTeamMemberBookingProfilesRequest(OptionalNullable<Boolean> bookableOnly,
            OptionalNullable<Integer> limit, OptionalNullable<String> cursor,
            OptionalNullable<String> locationId) {
        this.bookableOnly = bookableOnly;
        this.limit = limit;
        this.cursor = cursor;
        this.locationId = locationId;
    }

    /**
     * Internal Getter for BookableOnly.
     * Indicates whether to include only bookable team members in the returned result (`true`) or
     * not (`false`).
     * @return Returns the Internal Boolean
     */
    @JsonGetter("bookable_only")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetBookableOnly() {
        return this.bookableOnly;
    }

    /**
     * Getter for BookableOnly.
     * Indicates whether to include only bookable team members in the returned result (`true`) or
     * not (`false`).
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getBookableOnly() {
        return OptionalNullable.getFrom(bookableOnly);
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

    /**
     * Internal Getter for LocationId.
     * Indicates whether to include only team members enabled at the given location in the returned
     * result.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * Indicates whether to include only team members enabled at the given location in the returned
     * result.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookableOnly, limit, cursor, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListTeamMemberBookingProfilesRequest)) {
            return false;
        }
        ListTeamMemberBookingProfilesRequest other = (ListTeamMemberBookingProfilesRequest) obj;
        return Objects.equals(bookableOnly, other.bookableOnly)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this ListTeamMemberBookingProfilesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListTeamMemberBookingProfilesRequest [" + "bookableOnly=" + bookableOnly
                + ", limit=" + limit + ", cursor=" + cursor + ", locationId=" + locationId + "]";
    }

    /**
     * Builds a new {@link ListTeamMemberBookingProfilesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListTeamMemberBookingProfilesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.bookableOnly = internalGetBookableOnly();
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        builder.locationId = internalGetLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link ListTeamMemberBookingProfilesRequest}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> bookableOnly;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> cursor;
        private OptionalNullable<String> locationId;



        /**
         * Setter for bookableOnly.
         * @param  bookableOnly  Boolean value for bookableOnly.
         * @return Builder
         */
        public Builder bookableOnly(Boolean bookableOnly) {
            this.bookableOnly = OptionalNullable.of(bookableOnly);
            return this;
        }

        /**
         * UnSetter for bookableOnly.
         * @return Builder
         */
        public Builder unsetBookableOnly() {
            bookableOnly = null;
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
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Builds a new {@link ListTeamMemberBookingProfilesRequest} object using the set fields.
         * @return {@link ListTeamMemberBookingProfilesRequest}
         */
        public ListTeamMemberBookingProfilesRequest build() {
            return new ListTeamMemberBookingProfilesRequest(bookableOnly, limit, cursor,
                    locationId);
        }
    }
}
