package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchOrdersCustomerFilter type.
 */
public class SearchOrdersCustomerFilter {

    /**
     * Initialization constructor.
     * @param customerIds
     */
    @JsonCreator
    public SearchOrdersCustomerFilter(
            @JsonProperty("customer_ids") List<String> customerIds) {
        this.customerIds = customerIds;
    }

    private final List<String> customerIds;
    /**
     * Getter for CustomerIds.
     * List of customer IDs to filter by.
     * Max: 10 customer IDs.
     */
    @JsonGetter("customer_ids")
    public List<String> getCustomerIds() {
        return this.customerIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(customerIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchOrdersCustomerFilter)) {
            return false;
        }
        SearchOrdersCustomerFilter searchOrdersCustomerFilter = (SearchOrdersCustomerFilter) obj;
        return Objects.equals(customerIds, searchOrdersCustomerFilter.customerIds);
    }

    /**
     * Builds a new {@link SearchOrdersCustomerFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersCustomerFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .customerIds(getCustomerIds());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersCustomerFilter}
     */
    public static class Builder {
        private List<String> customerIds;

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
         * Builds a new {@link SearchOrdersCustomerFilter} object using the set fields.
         * @return {@link SearchOrdersCustomerFilter}
         */
        public SearchOrdersCustomerFilter build() {
            return new SearchOrdersCustomerFilter(customerIds);
        }
    }
}
