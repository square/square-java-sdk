
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEventFilter type.
 */
public class LoyaltyEventFilter {
    private final LoyaltyEventLoyaltyAccountFilter loyaltyAccountFilter;
    private final LoyaltyEventTypeFilter typeFilter;
    private final LoyaltyEventDateTimeFilter dateTimeFilter;
    private final LoyaltyEventLocationFilter locationFilter;
    private final LoyaltyEventOrderFilter orderFilter;

    /**
     * Initialization constructor.
     * @param  loyaltyAccountFilter  LoyaltyEventLoyaltyAccountFilter value for
     *         loyaltyAccountFilter.
     * @param  typeFilter  LoyaltyEventTypeFilter value for typeFilter.
     * @param  dateTimeFilter  LoyaltyEventDateTimeFilter value for dateTimeFilter.
     * @param  locationFilter  LoyaltyEventLocationFilter value for locationFilter.
     * @param  orderFilter  LoyaltyEventOrderFilter value for orderFilter.
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

    /**
     * Getter for LoyaltyAccountFilter.
     * Filter events by loyalty account.
     * @return Returns the LoyaltyEventLoyaltyAccountFilter
     */
    @JsonGetter("loyalty_account_filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventLoyaltyAccountFilter getLoyaltyAccountFilter() {
        return loyaltyAccountFilter;
    }

    /**
     * Getter for TypeFilter.
     * Filter events by event type.
     * @return Returns the LoyaltyEventTypeFilter
     */
    @JsonGetter("type_filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventTypeFilter getTypeFilter() {
        return typeFilter;
    }

    /**
     * Getter for DateTimeFilter.
     * Filter events by date time range.
     * @return Returns the LoyaltyEventDateTimeFilter
     */
    @JsonGetter("date_time_filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventDateTimeFilter getDateTimeFilter() {
        return dateTimeFilter;
    }

    /**
     * Getter for LocationFilter.
     * Filter events by location.
     * @return Returns the LoyaltyEventLocationFilter
     */
    @JsonGetter("location_filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventLocationFilter getLocationFilter() {
        return locationFilter;
    }

    /**
     * Getter for OrderFilter.
     * Filter events by the order associated with the event.
     * @return Returns the LoyaltyEventOrderFilter
     */
    @JsonGetter("order_filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventOrderFilter getOrderFilter() {
        return orderFilter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyAccountFilter, typeFilter, dateTimeFilter, locationFilter,
                orderFilter);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventFilter)) {
            return false;
        }
        LoyaltyEventFilter other = (LoyaltyEventFilter) obj;
        return Objects.equals(loyaltyAccountFilter, other.loyaltyAccountFilter)
            && Objects.equals(typeFilter, other.typeFilter)
            && Objects.equals(dateTimeFilter, other.dateTimeFilter)
            && Objects.equals(locationFilter, other.locationFilter)
            && Objects.equals(orderFilter, other.orderFilter);
    }

    /**
     * Converts this LoyaltyEventFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEventFilter [" + "loyaltyAccountFilter=" + loyaltyAccountFilter
                + ", typeFilter=" + typeFilter + ", dateTimeFilter=" + dateTimeFilter
                + ", locationFilter=" + locationFilter + ", orderFilter=" + orderFilter + "]";
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
     * Class to build instances of {@link LoyaltyEventFilter}.
     */
    public static class Builder {
        private LoyaltyEventLoyaltyAccountFilter loyaltyAccountFilter;
        private LoyaltyEventTypeFilter typeFilter;
        private LoyaltyEventDateTimeFilter dateTimeFilter;
        private LoyaltyEventLocationFilter locationFilter;
        private LoyaltyEventOrderFilter orderFilter;



        /**
         * Setter for loyaltyAccountFilter.
         * @param  loyaltyAccountFilter  LoyaltyEventLoyaltyAccountFilter value for
         *         loyaltyAccountFilter.
         * @return Builder
         */
        public Builder loyaltyAccountFilter(
                LoyaltyEventLoyaltyAccountFilter loyaltyAccountFilter) {
            this.loyaltyAccountFilter = loyaltyAccountFilter;
            return this;
        }

        /**
         * Setter for typeFilter.
         * @param  typeFilter  LoyaltyEventTypeFilter value for typeFilter.
         * @return Builder
         */
        public Builder typeFilter(LoyaltyEventTypeFilter typeFilter) {
            this.typeFilter = typeFilter;
            return this;
        }

        /**
         * Setter for dateTimeFilter.
         * @param  dateTimeFilter  LoyaltyEventDateTimeFilter value for dateTimeFilter.
         * @return Builder
         */
        public Builder dateTimeFilter(LoyaltyEventDateTimeFilter dateTimeFilter) {
            this.dateTimeFilter = dateTimeFilter;
            return this;
        }

        /**
         * Setter for locationFilter.
         * @param  locationFilter  LoyaltyEventLocationFilter value for locationFilter.
         * @return Builder
         */
        public Builder locationFilter(LoyaltyEventLocationFilter locationFilter) {
            this.locationFilter = locationFilter;
            return this;
        }

        /**
         * Setter for orderFilter.
         * @param  orderFilter  LoyaltyEventOrderFilter value for orderFilter.
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
            return new LoyaltyEventFilter(loyaltyAccountFilter, typeFilter, dateTimeFilter,
                    locationFilter, orderFilter);
        }
    }
}
