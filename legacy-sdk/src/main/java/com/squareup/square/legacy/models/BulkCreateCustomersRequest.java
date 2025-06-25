package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkCreateCustomersRequest type.
 */
public class BulkCreateCustomersRequest {
    private final Map<String, BulkCreateCustomerData> customers;

    /**
     * Initialization constructor.
     * @param  customers  Map of String, value for customers.
     */
    @JsonCreator
    public BulkCreateCustomersRequest(@JsonProperty("customers") Map<String, BulkCreateCustomerData> customers) {
        this.customers = customers;
    }

    /**
     * Getter for Customers.
     * A map of 1 to 100 individual create requests, represented by `idempotency key: { customer
     * data }` key-value pairs. Each key is an [idempotency
     * key](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency) that
     * uniquely identifies the create request. Each value contains the customer data used to create
     * the customer profile.
     * @return Returns the Map of String, BulkCreateCustomerData
     */
    @JsonGetter("customers")
    public Map<String, BulkCreateCustomerData> getCustomers() {
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
        if (!(obj instanceof BulkCreateCustomersRequest)) {
            return false;
        }
        BulkCreateCustomersRequest other = (BulkCreateCustomersRequest) obj;
        return Objects.equals(customers, other.customers);
    }

    /**
     * Converts this BulkCreateCustomersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkCreateCustomersRequest [" + "customers=" + customers + "]";
    }

    /**
     * Builds a new {@link BulkCreateCustomersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkCreateCustomersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customers);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkCreateCustomersRequest}.
     */
    public static class Builder {
        private Map<String, BulkCreateCustomerData> customers;

        /**
         * Initialization constructor.
         * @param  customers  Map of String, value for customers.
         */
        public Builder(Map<String, BulkCreateCustomerData> customers) {
            this.customers = customers;
        }

        /**
         * Setter for customers.
         * @param  customers  Map of String, value for customers.
         * @return Builder
         */
        public Builder customers(Map<String, BulkCreateCustomerData> customers) {
            this.customers = customers;
            return this;
        }

        /**
         * Builds a new {@link BulkCreateCustomersRequest} object using the set fields.
         * @return {@link BulkCreateCustomersRequest}
         */
        public BulkCreateCustomersRequest build() {
            return new BulkCreateCustomersRequest(customers);
        }
    }
}
