
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListTeamMemberBookingProfilesRequest type.
 */
public class ListTeamMemberBookingProfilesRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean bookableOnly;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;

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
        this.bookableOnly = bookableOnly;
        this.limit = limit;
        this.cursor = cursor;
        this.locationId = locationId;
    }

    /**
     * Getter for BookableOnly.
     * Indicates whether to include only bookable team members in the returned result (`true`) or
     * not (`false`).
     * @return Returns the Boolean
     */
    @JsonGetter("bookable_only")
    public Boolean getBookableOnly() {
        return bookableOnly;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to return.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Cursor.
     * The cursor for paginating through the results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for LocationId.
     * Indicates whether to include only team members enabled at the given location in the returned
     * result.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
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
        Builder builder = new Builder()
                .bookableOnly(getBookableOnly())
                .limit(getLimit())
                .cursor(getCursor())
                .locationId(getLocationId());
        return builder;
    }

    /**
     * Class to build instances of {@link ListTeamMemberBookingProfilesRequest}.
     */
    public static class Builder {
        private Boolean bookableOnly;
        private Integer limit;
        private String cursor;
        private String locationId;



        /**
         * Setter for bookableOnly.
         * @param  bookableOnly  Boolean value for bookableOnly.
         * @return Builder
         */
        public Builder bookableOnly(Boolean bookableOnly) {
            this.bookableOnly = bookableOnly;
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
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
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
