
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchSubscriptionsFilter type.
 */
public class SearchSubscriptionsFilter {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> customerIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> locationIds;

    /**
     * Initialization constructor.
     * @param  customerIds  List of String value for customerIds.
     * @param  locationIds  List of String value for locationIds.
     */
    @JsonCreator
    public SearchSubscriptionsFilter(
            @JsonProperty("customer_ids") List<String> customerIds,
            @JsonProperty("location_ids") List<String> locationIds) {
        this.customerIds = customerIds;
        this.locationIds = locationIds;
    }

    /**
     * Getter for CustomerIds.
     * A filter to select subscriptions based on the customer.
     * @return Returns the List of String
     */
    @JsonGetter("customer_ids")
    public List<String> getCustomerIds() {
        return customerIds;
    }

    /**
     * Getter for LocationIds.
     * A filter to select subscriptions based the location.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return locationIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerIds, locationIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchSubscriptionsFilter)) {
            return false;
        }
        SearchSubscriptionsFilter other = (SearchSubscriptionsFilter) obj;
        return Objects.equals(customerIds, other.customerIds)
            && Objects.equals(locationIds, other.locationIds);
    }

    /**
     * Converts this SearchSubscriptionsFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchSubscriptionsFilter [" + "customerIds=" + customerIds + ", locationIds="
                + locationIds + "]";
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
     * Class to build instances of {@link SearchSubscriptionsFilter}.
     */
    public static class Builder {
        private List<String> customerIds;
        private List<String> locationIds;



        /**
         * Setter for customerIds.
         * @param  customerIds  List of String value for customerIds.
         * @return Builder
         */
        public Builder customerIds(List<String> customerIds) {
            this.customerIds = customerIds;
            return this;
        }

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
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
            return new SearchSubscriptionsFilter(customerIds, locationIds);
        }
    }
}
