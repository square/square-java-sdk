package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchOrdersCustomerFilter {

    @JsonCreator
    public SearchOrdersCustomerFilter(
            @JsonProperty("customer_ids") List<String> customerIds) {
        this.customerIds = customerIds;
    }

    private final List<String> customerIds;

    @Override
    public int hashCode() {
        return Objects.hash(customerIds);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchOrdersCustomerFilter)) {
            return false;
        }
        SearchOrdersCustomerFilter searchOrdersCustomerFilter = (SearchOrdersCustomerFilter) o;
        return Objects.equals(customerIds, searchOrdersCustomerFilter.customerIds);
    }

    /**
     * Getter for CustomerIds.
     * List of customer IDs to filter by.
     * Max: 10 customer IDs.
     */
    @JsonGetter("customer_ids")
    public List<String> getCustomerIds() { 
        return this.customerIds;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .customerIds(getCustomerIds());
            return builder;
    }

    public static class Builder {
        private List<String> customerIds;

        public Builder() { }

        public Builder customerIds(List<String> value) {
            customerIds = value;
            return this;
        }

        public SearchOrdersCustomerFilter build() {
            return new SearchOrdersCustomerFilter(customerIds);
        }
    }
}
