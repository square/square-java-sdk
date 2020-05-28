package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEventFilter type.
 */
public class LoyaltyEventFilter {

    /**
     * Initialization constructor.
     * @param loyaltyAccountFilter
     * @param typeFilter
     * @param dateTimeFilter
     * @param locationFilter
     * @param orderFilter
     */
    @JsonCreator
    public LoyaltyEventFilter(
            @JsonProperty("loyalty_account_filter") LoyaltyEventLoyaltyAccountFilter loyaltyAccountFilter,
            @JsonProperty("type_filter") LoyaltyEventTypeFilter typeFilter,
            @JsonProperty("date_time_filter") LoyaltyEventDateTimeFilter dateTimeFilter,
            @JsonProperty("location_filter") LoyaltyEventLocationFilter locationFilter,
            @JsonProperty("order_filter") LoyaltyEventOrderFilter orderFilter) {
        this.loyaltyAccountFilter = loyaltyAccountFilter;
        this.typeFilter = typeFilter;
        this.dateTimeFilter = dateTimeFilter;
        this.locationFilter = locationFilter;
        this.orderFilter = orderFilter;
    }

    private final LoyaltyEventLoyaltyAccountFilter loyaltyAccountFilter;
    private final LoyaltyEventTypeFilter typeFilter;
    private final LoyaltyEventDateTimeFilter dateTimeFilter;
    private final LoyaltyEventLocationFilter locationFilter;
    private final LoyaltyEventOrderFilter orderFilter;
    /**
     * Getter for LoyaltyAccountFilter.
     * Filter events by loyalty account.
     */
    @JsonGetter("loyalty_account_filter")
    public LoyaltyEventLoyaltyAccountFilter getLoyaltyAccountFilter() {
        return this.loyaltyAccountFilter;
    }

    /**
     * Getter for TypeFilter.
     * Filter events by event type.
     */
    @JsonGetter("type_filter")
    public LoyaltyEventTypeFilter getTypeFilter() {
        return this.typeFilter;
    }

    /**
     * Getter for DateTimeFilter.
     * Filter events by date time range.
     */
    @JsonGetter("date_time_filter")
    public LoyaltyEventDateTimeFilter getDateTimeFilter() {
        return this.dateTimeFilter;
    }

    /**
     * Getter for LocationFilter.
     * Filter events by location.
     */
    @JsonGetter("location_filter")
    public LoyaltyEventLocationFilter getLocationFilter() {
        return this.locationFilter;
    }

    /**
     * Getter for OrderFilter.
     * Filter events by the order associated with the event.
     */
    @JsonGetter("order_filter")
    public LoyaltyEventOrderFilter getOrderFilter() {
        return this.orderFilter;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(loyaltyAccountFilter, typeFilter, dateTimeFilter, locationFilter,
            orderFilter);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEventFilter)) {
            return false;
        }
        LoyaltyEventFilter loyaltyEventFilter = (LoyaltyEventFilter) obj;
        return Objects.equals(loyaltyAccountFilter, loyaltyEventFilter.loyaltyAccountFilter) &&
            Objects.equals(typeFilter, loyaltyEventFilter.typeFilter) &&
            Objects.equals(dateTimeFilter, loyaltyEventFilter.dateTimeFilter) &&
            Objects.equals(locationFilter, loyaltyEventFilter.locationFilter) &&
            Objects.equals(orderFilter, loyaltyEventFilter.orderFilter);
    }

    /**
     * Builds a new {@link LoyaltyEventFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .loyaltyAccountFilter(getLoyaltyAccountFilter())
            .typeFilter(getTypeFilter())
            .dateTimeFilter(getDateTimeFilter())
            .locationFilter(getLocationFilter())
            .orderFilter(getOrderFilter());
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventFilter}
     */
    public static class Builder {
        private LoyaltyEventLoyaltyAccountFilter loyaltyAccountFilter;
        private LoyaltyEventTypeFilter typeFilter;
        private LoyaltyEventDateTimeFilter dateTimeFilter;
        private LoyaltyEventLocationFilter locationFilter;
        private LoyaltyEventOrderFilter orderFilter;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for loyaltyAccountFilter
         * @param loyaltyAccountFilter
         * @return Builder
         */
        public Builder loyaltyAccountFilter(LoyaltyEventLoyaltyAccountFilter loyaltyAccountFilter) {
            this.loyaltyAccountFilter = loyaltyAccountFilter;
            return this;
        }
        /**
         * Setter for typeFilter
         * @param typeFilter
         * @return Builder
         */
        public Builder typeFilter(LoyaltyEventTypeFilter typeFilter) {
            this.typeFilter = typeFilter;
            return this;
        }
        /**
         * Setter for dateTimeFilter
         * @param dateTimeFilter
         * @return Builder
         */
        public Builder dateTimeFilter(LoyaltyEventDateTimeFilter dateTimeFilter) {
            this.dateTimeFilter = dateTimeFilter;
            return this;
        }
        /**
         * Setter for locationFilter
         * @param locationFilter
         * @return Builder
         */
        public Builder locationFilter(LoyaltyEventLocationFilter locationFilter) {
            this.locationFilter = locationFilter;
            return this;
        }
        /**
         * Setter for orderFilter
         * @param orderFilter
         * @return Builder
         */
        public Builder orderFilter(LoyaltyEventOrderFilter orderFilter) {
            this.orderFilter = orderFilter;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventFilter} object using the set fields.
         * @return {@link LoyaltyEventFilter}
         */
        public LoyaltyEventFilter build() {
            return new LoyaltyEventFilter(loyaltyAccountFilter,
                typeFilter,
                dateTimeFilter,
                locationFilter,
                orderFilter);
        }
    }
}
