package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for InvoiceFilter type.
 */
public class InvoiceFilter {

    /**
     * Initialization constructor.
     * @param locationIds
     * @param customerIds
     */
    @JsonCreator
    public InvoiceFilter(
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("customer_ids") List<String> customerIds) {
        this.locationIds = locationIds;
        this.customerIds = customerIds;
    }

    private final List<String> locationIds;
    private final List<String> customerIds;
    /**
     * Getter for LocationIds.
     * Limits the search to the specified locations. A location is required. 
     * In the current implementation, only one location can be specified.
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for CustomerIds.
     * Limits the search to the specified customers, within the specified locations. 
     * Specifying a customer is optional. In the current implementation, 
     * a maximum of one customer can be specified.
     */
    @JsonGetter("customer_ids")
    public List<String> getCustomerIds() {
        return this.customerIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationIds, customerIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof InvoiceFilter)) {
            return false;
        }
        InvoiceFilter invoiceFilter = (InvoiceFilter) obj;
        return Objects.equals(locationIds, invoiceFilter.locationIds) &&
            Objects.equals(customerIds, invoiceFilter.customerIds);
    }

    /**
     * Builds a new {@link InvoiceFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoiceFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationIds)
            .customerIds(getCustomerIds());
            return builder;
    }

    /**
     * Class to build instances of {@link InvoiceFilter}
     */
    public static class Builder {
        private List<String> locationIds;
        private List<String> customerIds;

        /**
         * Initialization constructor
         */
        public Builder(List<String> locationIds) {
            this.locationIds = locationIds;
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
         * Setter for customerIds
         * @param customerIds
         * @return Builder
         */
        public Builder customerIds(List<String> customerIds) {
            this.customerIds = customerIds;
            return this;
        }

        /**
         * Builds a new {@link InvoiceFilter} object using the set fields.
         * @return {@link InvoiceFilter}
         */
        public InvoiceFilter build() {
            return new InvoiceFilter(locationIds,
                customerIds);
        }
    }
}
