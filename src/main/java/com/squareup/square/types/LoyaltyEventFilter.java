/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = LoyaltyEventFilter.Builder.class)
public final class LoyaltyEventFilter {
    private final Optional<LoyaltyEventLoyaltyAccountFilter> loyaltyAccountFilter;

    private final Optional<LoyaltyEventTypeFilter> typeFilter;

    private final Optional<LoyaltyEventDateTimeFilter> dateTimeFilter;

    private final Optional<LoyaltyEventLocationFilter> locationFilter;

    private final Optional<LoyaltyEventOrderFilter> orderFilter;

    private final Map<String, Object> additionalProperties;

    private LoyaltyEventFilter(
            Optional<LoyaltyEventLoyaltyAccountFilter> loyaltyAccountFilter,
            Optional<LoyaltyEventTypeFilter> typeFilter,
            Optional<LoyaltyEventDateTimeFilter> dateTimeFilter,
            Optional<LoyaltyEventLocationFilter> locationFilter,
            Optional<LoyaltyEventOrderFilter> orderFilter,
            Map<String, Object> additionalProperties) {
        this.loyaltyAccountFilter = loyaltyAccountFilter;
        this.typeFilter = typeFilter;
        this.dateTimeFilter = dateTimeFilter;
        this.locationFilter = locationFilter;
        this.orderFilter = orderFilter;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Filter events by loyalty account.
     */
    @JsonProperty("loyalty_account_filter")
    public Optional<LoyaltyEventLoyaltyAccountFilter> getLoyaltyAccountFilter() {
        return loyaltyAccountFilter;
    }

    /**
     * @return Filter events by event type.
     */
    @JsonProperty("type_filter")
    public Optional<LoyaltyEventTypeFilter> getTypeFilter() {
        return typeFilter;
    }

    /**
     * @return Filter events by date time range.
     * For each range, the start time is inclusive and the end time
     * is exclusive.
     */
    @JsonProperty("date_time_filter")
    public Optional<LoyaltyEventDateTimeFilter> getDateTimeFilter() {
        return dateTimeFilter;
    }

    /**
     * @return Filter events by location.
     */
    @JsonProperty("location_filter")
    public Optional<LoyaltyEventLocationFilter> getLocationFilter() {
        return locationFilter;
    }

    /**
     * @return Filter events by the order associated with the event.
     */
    @JsonProperty("order_filter")
    public Optional<LoyaltyEventOrderFilter> getOrderFilter() {
        return orderFilter;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoyaltyEventFilter && equalTo((LoyaltyEventFilter) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LoyaltyEventFilter other) {
        return loyaltyAccountFilter.equals(other.loyaltyAccountFilter)
                && typeFilter.equals(other.typeFilter)
                && dateTimeFilter.equals(other.dateTimeFilter)
                && locationFilter.equals(other.locationFilter)
                && orderFilter.equals(other.orderFilter);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.loyaltyAccountFilter, this.typeFilter, this.dateTimeFilter, this.locationFilter, this.orderFilter);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<LoyaltyEventLoyaltyAccountFilter> loyaltyAccountFilter = Optional.empty();

        private Optional<LoyaltyEventTypeFilter> typeFilter = Optional.empty();

        private Optional<LoyaltyEventDateTimeFilter> dateTimeFilter = Optional.empty();

        private Optional<LoyaltyEventLocationFilter> locationFilter = Optional.empty();

        private Optional<LoyaltyEventOrderFilter> orderFilter = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(LoyaltyEventFilter other) {
            loyaltyAccountFilter(other.getLoyaltyAccountFilter());
            typeFilter(other.getTypeFilter());
            dateTimeFilter(other.getDateTimeFilter());
            locationFilter(other.getLocationFilter());
            orderFilter(other.getOrderFilter());
            return this;
        }

        /**
         * <p>Filter events by loyalty account.</p>
         */
        @JsonSetter(value = "loyalty_account_filter", nulls = Nulls.SKIP)
        public Builder loyaltyAccountFilter(Optional<LoyaltyEventLoyaltyAccountFilter> loyaltyAccountFilter) {
            this.loyaltyAccountFilter = loyaltyAccountFilter;
            return this;
        }

        public Builder loyaltyAccountFilter(LoyaltyEventLoyaltyAccountFilter loyaltyAccountFilter) {
            this.loyaltyAccountFilter = Optional.ofNullable(loyaltyAccountFilter);
            return this;
        }

        /**
         * <p>Filter events by event type.</p>
         */
        @JsonSetter(value = "type_filter", nulls = Nulls.SKIP)
        public Builder typeFilter(Optional<LoyaltyEventTypeFilter> typeFilter) {
            this.typeFilter = typeFilter;
            return this;
        }

        public Builder typeFilter(LoyaltyEventTypeFilter typeFilter) {
            this.typeFilter = Optional.ofNullable(typeFilter);
            return this;
        }

        /**
         * <p>Filter events by date time range.
         * For each range, the start time is inclusive and the end time
         * is exclusive.</p>
         */
        @JsonSetter(value = "date_time_filter", nulls = Nulls.SKIP)
        public Builder dateTimeFilter(Optional<LoyaltyEventDateTimeFilter> dateTimeFilter) {
            this.dateTimeFilter = dateTimeFilter;
            return this;
        }

        public Builder dateTimeFilter(LoyaltyEventDateTimeFilter dateTimeFilter) {
            this.dateTimeFilter = Optional.ofNullable(dateTimeFilter);
            return this;
        }

        /**
         * <p>Filter events by location.</p>
         */
        @JsonSetter(value = "location_filter", nulls = Nulls.SKIP)
        public Builder locationFilter(Optional<LoyaltyEventLocationFilter> locationFilter) {
            this.locationFilter = locationFilter;
            return this;
        }

        public Builder locationFilter(LoyaltyEventLocationFilter locationFilter) {
            this.locationFilter = Optional.ofNullable(locationFilter);
            return this;
        }

        /**
         * <p>Filter events by the order associated with the event.</p>
         */
        @JsonSetter(value = "order_filter", nulls = Nulls.SKIP)
        public Builder orderFilter(Optional<LoyaltyEventOrderFilter> orderFilter) {
            this.orderFilter = orderFilter;
            return this;
        }

        public Builder orderFilter(LoyaltyEventOrderFilter orderFilter) {
            this.orderFilter = Optional.ofNullable(orderFilter);
            return this;
        }

        public LoyaltyEventFilter build() {
            return new LoyaltyEventFilter(
                    loyaltyAccountFilter,
                    typeFilter,
                    dateTimeFilter,
                    locationFilter,
                    orderFilter,
                    additionalProperties);
        }
    }
}
