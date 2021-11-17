
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListBookingsRequest type.
 */
public class ListBookingsRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String teamMemberId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String startAtMin;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String startAtMax;

    /**
     * Initialization constructor.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  locationId  String value for locationId.
     * @param  startAtMin  String value for startAtMin.
     * @param  startAtMax  String value for startAtMax.
     */
    @JsonCreator
    public ListBookingsRequest(
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("start_at_min") String startAtMin,
            @JsonProperty("start_at_max") String startAtMax) {
        this.limit = limit;
        this.cursor = cursor;
        this.teamMemberId = teamMemberId;
        this.locationId = locationId;
        this.startAtMin = startAtMin;
        this.startAtMax = startAtMax;
    }

    /**
     * Getter for Limit.
     * The maximum number of results per page to return in a paged response.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor from the preceding response to return the next page of the results. Do
     * not set this when retrieving the first page of the results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for TeamMemberId.
     * The team member for whom to retrieve bookings. If this is not set, bookings of all members
     * are retrieved.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Getter for LocationId.
     * The location for which to retrieve bookings. If this is not set, all locations' bookings are
     * retrieved.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for StartAtMin.
     * The RFC 3339 timestamp specifying the earliest of the start time. If this is not set, the
     * current time is used.
     * @return Returns the String
     */
    @JsonGetter("start_at_min")
    public String getStartAtMin() {
        return startAtMin;
    }

    /**
     * Getter for StartAtMax.
     * The RFC 3339 timestamp specifying the latest of the start time. If this is not set, the time
     * of 31 days after `start_at_min` is used.
     * @return Returns the String
     */
    @JsonGetter("start_at_max")
    public String getStartAtMax() {
        return startAtMax;
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, cursor, teamMemberId, locationId, startAtMin, startAtMax);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListBookingsRequest)) {
            return false;
        }
        ListBookingsRequest other = (ListBookingsRequest) obj;
        return Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(teamMemberId, other.teamMemberId)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(startAtMin, other.startAtMin)
            && Objects.equals(startAtMax, other.startAtMax);
    }

    /**
     * Converts this ListBookingsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListBookingsRequest [" + "limit=" + limit + ", cursor=" + cursor + ", teamMemberId="
                + teamMemberId + ", locationId=" + locationId + ", startAtMin=" + startAtMin
                + ", startAtMax=" + startAtMax + "]";
    }

    /**
     * Builds a new {@link ListBookingsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListBookingsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .limit(getLimit())
                .cursor(getCursor())
                .teamMemberId(getTeamMemberId())
                .locationId(getLocationId())
                .startAtMin(getStartAtMin())
                .startAtMax(getStartAtMax());
        return builder;
    }

    /**
     * Class to build instances of {@link ListBookingsRequest}.
     */
    public static class Builder {
        private Integer limit;
        private String cursor;
        private String teamMemberId;
        private String locationId;
        private String startAtMin;
        private String startAtMax;



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
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
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
         * Setter for startAtMin.
         * @param  startAtMin  String value for startAtMin.
         * @return Builder
         */
        public Builder startAtMin(String startAtMin) {
            this.startAtMin = startAtMin;
            return this;
        }

        /**
         * Setter for startAtMax.
         * @param  startAtMax  String value for startAtMax.
         * @return Builder
         */
        public Builder startAtMax(String startAtMax) {
            this.startAtMax = startAtMax;
            return this;
        }

        /**
         * Builds a new {@link ListBookingsRequest} object using the set fields.
         * @return {@link ListBookingsRequest}
         */
        public ListBookingsRequest build() {
            return new ListBookingsRequest(limit, cursor, teamMemberId, locationId, startAtMin,
                    startAtMax);
        }
    }
}
