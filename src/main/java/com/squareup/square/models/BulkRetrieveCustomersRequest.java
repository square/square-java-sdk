
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BulkRetrieveCustomersRequest type.
 */
public class BulkRetrieveCustomersRequest {
    private final List<String> customerIds;

    /**
     * Initialization constructor.
     * @param  customerIds  List of String value for customerIds.
     */
    @JsonCreator
    public BulkRetrieveCustomersRequest(
            @JsonProperty("customer_ids") List<String> customerIds) {
        this.customerIds = customerIds;
    }

    /**
     * Getter for CustomerIds.
     * The IDs of the [customer profiles](entity:Customer) to retrieve.
     * @return Returns the List of String
     */
    @JsonGetter("customer_ids")
    public List<String> getCustomerIds() {
        return customerIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkRetrieveCustomersRequest)) {
            return false;
        }
        BulkRetrieveCustomersRequest other = (BulkRetrieveCustomersRequest) obj;
        return Objects.equals(customerIds, other.customerIds);
    }

    /**
     * Converts this BulkRetrieveCustomersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkRetrieveCustomersRequest [" + "customerIds=" + customerIds + "]";
    }

    /**
     * Builds a new {@link BulkRetrieveCustomersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkRetrieveCustomersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customerIds);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkRetrieveCustomersRequest}.
     */
    public static class Builder {
        private List<String> customerIds;

        /**
         * Initialization constructor.
         * @param  customerIds  List of String value for customerIds.
         */
        public Builder(List<String> customerIds) {
            this.customerIds = customerIds;
        }

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
         * Builds a new {@link BulkRetrieveCustomersRequest} object using the set fields.
         * @return {@link BulkRetrieveCustomersRequest}
         */
        public BulkRetrieveCustomersRequest build() {
            return new BulkRetrieveCustomersRequest(customerIds);
        }
    }
}
