
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
 * This is a model class for ListBookingsRequest type.
 */
public class ListBookingsRequest {
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<String> teamMemberId;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> startAtMin;
    private final OptionalNullable<String> startAtMax;

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
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
        this.teamMemberId = OptionalNullable.of(teamMemberId);
        this.locationId = OptionalNullable.of(locationId);
        this.startAtMin = OptionalNullable.of(startAtMin);
        this.startAtMax = OptionalNullable.of(startAtMax);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListBookingsRequest(OptionalNullable<Integer> limit, OptionalNullable<String> cursor,
            OptionalNullable<String> teamMemberId, OptionalNullable<String> locationId,
            OptionalNullable<String> startAtMin, OptionalNullable<String> startAtMax) {
        this.limit = limit;
        this.cursor = cursor;
        this.teamMemberId = teamMemberId;
        this.locationId = locationId;
        this.startAtMin = startAtMin;
        this.startAtMax = startAtMax;
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of results per page to return in a paged response.
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
     * The maximum number of results per page to return in a paged response.
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
     * Internal Getter for TeamMemberId.
     * The team member for whom to retrieve bookings. If this is not set, bookings of all members
     * are retrieved.
     * @return Returns the Internal String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for TeamMemberId.
     * The team member for whom to retrieve bookings. If this is not set, bookings of all members
     * are retrieved.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTeamMemberId() {
        return OptionalNullable.getFrom(teamMemberId);
    }

    /**
     * Internal Getter for LocationId.
     * The location for which to retrieve bookings. If this is not set, all locations' bookings are
     * retrieved.
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
     * The location for which to retrieve bookings. If this is not set, all locations' bookings are
     * retrieved.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for StartAtMin.
     * The RFC 3339 timestamp specifying the earliest of the start time. If this is not set, the
     * current time is used.
     * @return Returns the Internal String
     */
    @JsonGetter("start_at_min")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStartAtMin() {
        return this.startAtMin;
    }

    /**
     * Getter for StartAtMin.
     * The RFC 3339 timestamp specifying the earliest of the start time. If this is not set, the
     * current time is used.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStartAtMin() {
        return OptionalNullable.getFrom(startAtMin);
    }

    /**
     * Internal Getter for StartAtMax.
     * The RFC 3339 timestamp specifying the latest of the start time. If this is not set, the time
     * of 31 days after `start_at_min` is used.
     * @return Returns the Internal String
     */
    @JsonGetter("start_at_max")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStartAtMax() {
        return this.startAtMax;
    }

    /**
     * Getter for StartAtMax.
     * The RFC 3339 timestamp specifying the latest of the start time. If this is not set, the time
     * of 31 days after `start_at_min` is used.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStartAtMax() {
        return OptionalNullable.getFrom(startAtMax);
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
        Builder builder = new Builder();
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        builder.teamMemberId = internalGetTeamMemberId();
        builder.locationId = internalGetLocationId();
        builder.startAtMin = internalGetStartAtMin();
        builder.startAtMax = internalGetStartAtMax();
        return builder;
    }

    /**
     * Class to build instances of {@link ListBookingsRequest}.
     */
    public static class Builder {
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> cursor;
        private OptionalNullable<String> teamMemberId;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> startAtMin;
        private OptionalNullable<String> startAtMax;



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
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = OptionalNullable.of(teamMemberId);
            return this;
        }

        /**
         * UnSetter for teamMemberId.
         * @return Builder
         */
        public Builder unsetTeamMemberId() {
            teamMemberId = null;
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
         * Setter for startAtMin.
         * @param  startAtMin  String value for startAtMin.
         * @return Builder
         */
        public Builder startAtMin(String startAtMin) {
            this.startAtMin = OptionalNullable.of(startAtMin);
            return this;
        }

        /**
         * UnSetter for startAtMin.
         * @return Builder
         */
        public Builder unsetStartAtMin() {
            startAtMin = null;
            return this;
        }

        /**
         * Setter for startAtMax.
         * @param  startAtMax  String value for startAtMax.
         * @return Builder
         */
        public Builder startAtMax(String startAtMax) {
            this.startAtMax = OptionalNullable.of(startAtMax);
            return this;
        }

        /**
         * UnSetter for startAtMax.
         * @return Builder
         */
        public Builder unsetStartAtMax() {
            startAtMax = null;
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
