
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchAvailabilityFilter type.
 */
public class SearchAvailabilityFilter {
    private final TimeRange startAtRange;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<SegmentFilter> segmentFilters;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String bookingId;

    /**
     * Initialization constructor.
     * @param  startAtRange  TimeRange value for startAtRange.
     * @param  locationId  String value for locationId.
     * @param  segmentFilters  List of SegmentFilter value for segmentFilters.
     * @param  bookingId  String value for bookingId.
     */
    @JsonCreator
    public SearchAvailabilityFilter(
            @JsonProperty("start_at_range") TimeRange startAtRange,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("segment_filters") List<SegmentFilter> segmentFilters,
            @JsonProperty("booking_id") String bookingId) {
        this.startAtRange = startAtRange;
        this.locationId = locationId;
        this.segmentFilters = segmentFilters;
        this.bookingId = bookingId;
    }

    /**
     * Getter for StartAtRange.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("start_at_range")
    public TimeRange getStartAtRange() {
        return startAtRange;
    }

    /**
     * Getter for LocationId.
     * The query expression to search for availabilities matching the specified seller location IDs.
     * This query expression is not applicable when `booking_id` is present.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for SegmentFilters.
     * The list of segment filters to apply. A query with `n` segment filters returns availabilities
     * with `n` segments per availability. It is not applicable when `booking_id` is present.
     * @return Returns the List of SegmentFilter
     */
    @JsonGetter("segment_filters")
    public List<SegmentFilter> getSegmentFilters() {
        return segmentFilters;
    }

    /**
     * Getter for BookingId.
     * The query expression to search for availabilities for an existing booking by matching the
     * specified `booking_id` value. This is commonly used to reschedule an appointment. If this
     * expression is specified, the `location_id` and `segment_filters` expressions are not allowed.
     * @return Returns the String
     */
    @JsonGetter("booking_id")
    public String getBookingId() {
        return bookingId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startAtRange, locationId, segmentFilters, bookingId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchAvailabilityFilter)) {
            return false;
        }
        SearchAvailabilityFilter other = (SearchAvailabilityFilter) obj;
        return Objects.equals(startAtRange, other.startAtRange)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(segmentFilters, other.segmentFilters)
            && Objects.equals(bookingId, other.bookingId);
    }

    /**
     * Converts this SearchAvailabilityFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchAvailabilityFilter [" + "startAtRange=" + startAtRange + ", locationId="
                + locationId + ", segmentFilters=" + segmentFilters + ", bookingId=" + bookingId
                + "]";
    }

    /**
     * Builds a new {@link SearchAvailabilityFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchAvailabilityFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(startAtRange)
                .locationId(getLocationId())
                .segmentFilters(getSegmentFilters())
                .bookingId(getBookingId());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchAvailabilityFilter}.
     */
    public static class Builder {
        private TimeRange startAtRange;
        private String locationId;
        private List<SegmentFilter> segmentFilters;
        private String bookingId;

        /**
         * Initialization constructor.
         * @param  startAtRange  TimeRange value for startAtRange.
         */
        public Builder(TimeRange startAtRange) {
            this.startAtRange = startAtRange;
        }

        /**
         * Setter for startAtRange.
         * @param  startAtRange  TimeRange value for startAtRange.
         * @return Builder
         */
        public Builder startAtRange(TimeRange startAtRange) {
            this.startAtRange = startAtRange;
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
         * Setter for segmentFilters.
         * @param  segmentFilters  List of SegmentFilter value for segmentFilters.
         * @return Builder
         */
        public Builder segmentFilters(List<SegmentFilter> segmentFilters) {
            this.segmentFilters = segmentFilters;
            return this;
        }

        /**
         * Setter for bookingId.
         * @param  bookingId  String value for bookingId.
         * @return Builder
         */
        public Builder bookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        /**
         * Builds a new {@link SearchAvailabilityFilter} object using the set fields.
         * @return {@link SearchAvailabilityFilter}
         */
        public SearchAvailabilityFilter build() {
            return new SearchAvailabilityFilter(startAtRange, locationId, segmentFilters,
                    bookingId);
        }
    }
}
