package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchSubscriptionsFilter type.
 */
public class SearchSubscriptionsFilter {

    /**
     * Initialization constructor.
     * @param customerIds
     * @param locationIds
     */
    @JsonCreator
    public SearchSubscriptionsFilter(
            @JsonProperty("customer_ids") List<String> customerIds,
            @JsonProperty("location_ids") List<String> locationIds) {
        this.customerIds = customerIds;
        this.locationIds = locationIds;
    }

    private final List<String> customerIds;
    private final List<String> locationIds;
    /**
     * Getter for CustomerIds.
     * A filter to select subscriptions based on the customer.
     */
    @JsonGetter("customer_ids")
    public List<String> getCustomerIds() {
        return this.customerIds;
    }

    /**
     * Getter for LocationIds.
     * A filter to select subscriptions based the location.
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(customerIds, locationIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchSubscriptionsFilter)) {
            return false;
        }
        SearchSubscriptionsFilter searchSubscriptionsFilter = (SearchSubscriptionsFilter) obj;
        return Objects.equals(customerIds, searchSubscriptionsFilter.customerIds) &&
            Objects.equals(locationIds, searchSubscriptionsFilter.locationIds);
    }

    /**
     * Builds a new {@link SearchSubscriptionsFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchSubscriptionsFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .customerIds(getCustomerIds())
            .locationIds(getLocationIds());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchSubscriptionsFilter}
     */
    public static class Builder {
        private List<String> customerIds;
        private List<String> locationIds;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for customerIds
         * @param customerIds
         * @return Builder
         */
        public Builder customerIds(List<String> customerIds) {
            this.customerIds = customerIds;
            return this;
        }
        /**
         * Setter for locationIds
         * @param locationIds
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        /**
         * Builds a new {@link SearchSubscriptionsFilter} object using the set fields.
         * @return {@link SearchSubscriptionsFilter}
         */
        public SearchSubscriptionsFilter build() {
            return new SearchSubscriptionsFilter(customerIds,
                locationIds);
        }
    }
}
