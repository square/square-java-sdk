
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkUpdateCustomersRequest type.
 */
public class BulkUpdateCustomersRequest {
    private final Map<String, BulkUpdateCustomerData> customers;

    /**
     * Initialization constructor.
     * @param  customers  Map of String, value for customers.
     */
    @JsonCreator
    public BulkUpdateCustomersRequest(
            @JsonProperty("customers") Map<String, BulkUpdateCustomerData> customers) {
        this.customers = customers;
    }

    /**
     * Getter for Customers.
     * A map of 1 to 100 individual update requests, represented by `customer ID: { customer data }`
     * key-value pairs. Each key is the ID of the [customer profile](entity:Customer) to update. To
     * update a customer profile that was created by merging existing profiles, provide the ID of
     * the newly created profile. Each value contains the updated customer data. Only new or changed
     * fields are required. To add or update a field, specify the new value. To remove a field,
     * specify `null`.
     * @return Returns the Map of String, BulkUpdateCustomerData
     */
    @JsonGetter("customers")
    public Map<String, BulkUpdateCustomerData> getCustomers() {
        return customers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpdateCustomersRequest)) {
            return false;
        }
        BulkUpdateCustomersRequest other = (BulkUpdateCustomersRequest) obj;
        return Objects.equals(customers, other.customers);
    }

    /**
     * Converts this BulkUpdateCustomersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpdateCustomersRequest [" + "customers=" + customers + "]";
    }

    /**
     * Builds a new {@link BulkUpdateCustomersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpdateCustomersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customers);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpdateCustomersRequest}.
     */
    public static class Builder {
        private Map<String, BulkUpdateCustomerData> customers;

        /**
         * Initialization constructor.
         * @param  customers  Map of String, value for customers.
         */
        public Builder(Map<String, BulkUpdateCustomerData> customers) {
            this.customers = customers;
        }

        /**
         * Setter for customers.
         * @param  customers  Map of String, value for customers.
         * @return Builder
         */
        public Builder customers(Map<String, BulkUpdateCustomerData> customers) {
            this.customers = customers;
            return this;
        }

        /**
         * Builds a new {@link BulkUpdateCustomersRequest} object using the set fields.
         * @return {@link BulkUpdateCustomersRequest}
         */
        public BulkUpdateCustomersRequest build() {
            return new BulkUpdateCustomersRequest(customers);
        }
    }
}
