
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchAvailabilityFilter type.
 */
public class SearchAvailabilityFilter {
    private final TimeRange startAtRange;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<List<SegmentFilter>> segmentFilters;
    private final OptionalNullable<String> bookingId;

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
        this.locationId = OptionalNullable.of(locationId);
        this.segmentFilters = OptionalNullable.of(segmentFilters);
        this.bookingId = OptionalNullable.of(bookingId);
    }

    /**
     * Internal initialization constructor.
     */
    protected SearchAvailabilityFilter(TimeRange startAtRange, OptionalNullable<String> locationId,
            OptionalNullable<List<SegmentFilter>> segmentFilters,
            OptionalNullable<String> bookingId) {
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
     * Internal Getter for LocationId.
     * The query expression to search for buyer-accessible availabilities with their location IDs
     * matching the specified location ID. This query expression cannot be set if `booking_id` is
     * set.
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
     * The query expression to search for buyer-accessible availabilities with their location IDs
     * matching the specified location ID. This query expression cannot be set if `booking_id` is
     * set.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for SegmentFilters.
     * The query expression to search for buyer-accessible availabilities matching the specified
     * list of segment filters. If the size of the `segment_filters` list is `n`, the search returns
     * availabilities with `n` segments per availability. This query expression cannot be set if
     * `booking_id` is set.
     * @return Returns the Internal List of SegmentFilter
     */
    @JsonGetter("segment_filters")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<SegmentFilter>> internalGetSegmentFilters() {
        return this.segmentFilters;
    }

    /**
     * Getter for SegmentFilters.
     * The query expression to search for buyer-accessible availabilities matching the specified
     * list of segment filters. If the size of the `segment_filters` list is `n`, the search returns
     * availabilities with `n` segments per availability. This query expression cannot be set if
     * `booking_id` is set.
     * @return Returns the List of SegmentFilter
     */
    @JsonIgnore
    public List<SegmentFilter> getSegmentFilters() {
        return OptionalNullable.getFrom(segmentFilters);
    }

    /**
     * Internal Getter for BookingId.
     * The query expression to search for buyer-accessible availabilities for an existing booking by
     * matching the specified `booking_id` value. This is commonly used to reschedule an
     * appointment. If this expression is set, the `location_id` and `segment_filters` expressions
     * cannot be set.
     * @return Returns the Internal String
     */
    @JsonGetter("booking_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBookingId() {
        return this.bookingId;
    }

    /**
     * Getter for BookingId.
     * The query expression to search for buyer-accessible availabilities for an existing booking by
     * matching the specified `booking_id` value. This is commonly used to reschedule an
     * appointment. If this expression is set, the `location_id` and `segment_filters` expressions
     * cannot be set.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBookingId() {
        return OptionalNullable.getFrom(bookingId);
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
        Builder builder = new Builder(startAtRange);
        builder.locationId = internalGetLocationId();
        builder.segmentFilters = internalGetSegmentFilters();
        builder.bookingId = internalGetBookingId();
        return builder;
    }

    /**
     * Class to build instances of {@link SearchAvailabilityFilter}.
     */
    public static class Builder {
        private TimeRange startAtRange;
        private OptionalNullable<String> locationId;
        private OptionalNullable<List<SegmentFilter>> segmentFilters;
        private OptionalNullable<String> bookingId;

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
         * Setter for segmentFilters.
         * @param  segmentFilters  List of SegmentFilter value for segmentFilters.
         * @return Builder
         */
        public Builder segmentFilters(List<SegmentFilter> segmentFilters) {
            this.segmentFilters = OptionalNullable.of(segmentFilters);
            return this;
        }

        /**
         * UnSetter for segmentFilters.
         * @return Builder
         */
        public Builder unsetSegmentFilters() {
            segmentFilters = null;
            return this;
        }

        /**
         * Setter for bookingId.
         * @param  bookingId  String value for bookingId.
         * @return Builder
         */
        public Builder bookingId(String bookingId) {
            this.bookingId = OptionalNullable.of(bookingId);
            return this;
        }

        /**
         * UnSetter for bookingId.
         * @return Builder
         */
        public Builder unsetBookingId() {
            bookingId = null;
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
