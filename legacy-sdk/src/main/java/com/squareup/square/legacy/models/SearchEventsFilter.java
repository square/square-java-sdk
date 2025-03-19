package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchEventsFilter type.
 */
public class SearchEventsFilter {
    private final OptionalNullable<List<String>> eventTypes;
    private final OptionalNullable<List<String>> merchantIds;
    private final OptionalNullable<List<String>> locationIds;
    private final TimeRange createdAt;

    /**
     * Initialization constructor.
     * @param  eventTypes  List of String value for eventTypes.
     * @param  merchantIds  List of String value for merchantIds.
     * @param  locationIds  List of String value for locationIds.
     * @param  createdAt  TimeRange value for createdAt.
     */
    @JsonCreator
    public SearchEventsFilter(
            @JsonProperty("event_types") List<String> eventTypes,
            @JsonProperty("merchant_ids") List<String> merchantIds,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("created_at") TimeRange createdAt) {
        this.eventTypes = OptionalNullable.of(eventTypes);
        this.merchantIds = OptionalNullable.of(merchantIds);
        this.locationIds = OptionalNullable.of(locationIds);
        this.createdAt = createdAt;
    }

    /**
     * Initialization constructor.
     * @param  eventTypes  List of String value for eventTypes.
     * @param  merchantIds  List of String value for merchantIds.
     * @param  locationIds  List of String value for locationIds.
     * @param  createdAt  TimeRange value for createdAt.
     */
    protected SearchEventsFilter(
            OptionalNullable<List<String>> eventTypes,
            OptionalNullable<List<String>> merchantIds,
            OptionalNullable<List<String>> locationIds,
            TimeRange createdAt) {
        this.eventTypes = eventTypes;
        this.merchantIds = merchantIds;
        this.locationIds = locationIds;
        this.createdAt = createdAt;
    }

    /**
     * Internal Getter for EventTypes.
     * Filter events by event types.
     * @return Returns the Internal List of String
     */
    @JsonGetter("event_types")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetEventTypes() {
        return this.eventTypes;
    }

    /**
     * Getter for EventTypes.
     * Filter events by event types.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getEventTypes() {
        return OptionalNullable.getFrom(eventTypes);
    }

    /**
     * Internal Getter for MerchantIds.
     * Filter events by merchant.
     * @return Returns the Internal List of String
     */
    @JsonGetter("merchant_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetMerchantIds() {
        return this.merchantIds;
    }

    /**
     * Getter for MerchantIds.
     * Filter events by merchant.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getMerchantIds() {
        return OptionalNullable.getFrom(merchantIds);
    }

    /**
     * Internal Getter for LocationIds.
     * Filter events by location.
     * @return Returns the Internal List of String
     */
    @JsonGetter("location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for LocationIds.
     * Filter events by location.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getLocationIds() {
        return OptionalNullable.getFrom(locationIds);
    }

    /**
     * Getter for CreatedAt.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TimeRange getCreatedAt() {
        return createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventTypes, merchantIds, locationIds, createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchEventsFilter)) {
            return false;
        }
        SearchEventsFilter other = (SearchEventsFilter) obj;
        return Objects.equals(eventTypes, other.eventTypes)
                && Objects.equals(merchantIds, other.merchantIds)
                && Objects.equals(locationIds, other.locationIds)
                && Objects.equals(createdAt, other.createdAt);
    }

    /**
     * Converts this SearchEventsFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchEventsFilter [" + "eventTypes=" + eventTypes + ", merchantIds=" + merchantIds + ", locationIds="
                + locationIds + ", createdAt=" + createdAt + "]";
    }

    /**
     * Builds a new {@link SearchEventsFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchEventsFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().createdAt(getCreatedAt());
        builder.eventTypes = internalGetEventTypes();
        builder.merchantIds = internalGetMerchantIds();
        builder.locationIds = internalGetLocationIds();
        return builder;
    }

    /**
     * Class to build instances of {@link SearchEventsFilter}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> eventTypes;
        private OptionalNullable<List<String>> merchantIds;
        private OptionalNullable<List<String>> locationIds;
        private TimeRange createdAt;

        /**
         * Setter for eventTypes.
         * @param  eventTypes  List of String value for eventTypes.
         * @return Builder
         */
        public Builder eventTypes(List<String> eventTypes) {
            this.eventTypes = OptionalNullable.of(eventTypes);
            return this;
        }

        /**
         * UnSetter for eventTypes.
         * @return Builder
         */
        public Builder unsetEventTypes() {
            eventTypes = null;
            return this;
        }

        /**
         * Setter for merchantIds.
         * @param  merchantIds  List of String value for merchantIds.
         * @return Builder
         */
        public Builder merchantIds(List<String> merchantIds) {
            this.merchantIds = OptionalNullable.of(merchantIds);
            return this;
        }

        /**
         * UnSetter for merchantIds.
         * @return Builder
         */
        public Builder unsetMerchantIds() {
            merchantIds = null;
            return this;
        }

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = OptionalNullable.of(locationIds);
            return this;
        }

        /**
         * UnSetter for locationIds.
         * @return Builder
         */
        public Builder unsetLocationIds() {
            locationIds = null;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  TimeRange value for createdAt.
         * @return Builder
         */
        public Builder createdAt(TimeRange createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Builds a new {@link SearchEventsFilter} object using the set fields.
         * @return {@link SearchEventsFilter}
         */
        public SearchEventsFilter build() {
            return new SearchEventsFilter(eventTypes, merchantIds, locationIds, createdAt);
        }
    }
}
