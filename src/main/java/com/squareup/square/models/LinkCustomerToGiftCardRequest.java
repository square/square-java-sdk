
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LinkCustomerToGiftCardRequest type.
 */
public class LinkCustomerToGiftCardRequest {
    private final String customerId;

    /**
     * Initialization constructor.
     * @param  customerId  String value for customerId.
     */
    @JsonCreator
    public LinkCustomerToGiftCardRequest(
            @JsonProperty("customer_id") String customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the customer to be linked.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinkCustomerToGiftCardRequest)) {
            return false;
        }
        LinkCustomerToGiftCardRequest other = (LinkCustomerToGiftCardRequest) obj;
        return Objects.equals(customerId, other.customerId);
    }

    /**
     * Converts this LinkCustomerToGiftCardRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LinkCustomerToGiftCardRequest [" + "customerId=" + customerId + "]";
    }

    /**
     * Builds a new {@link LinkCustomerToGiftCardRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LinkCustomerToGiftCardRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customerId);
        return builder;
    }

    /**
     * Class to build instances of {@link LinkCustomerToGiftCardRequest}.
     */
    public static class Builder {
        private String customerId;

        /**
         * Initialization constructor.
         * @param  customerId  String value for customerId.
         */
        public Builder(String customerId) {
            this.customerId = customerId;
        }

        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Builds a new {@link LinkCustomerToGiftCardRequest} object using the set fields.
         * @return {@link LinkCustomerToGiftCardRequest}
         */
        public LinkCustomerToGiftCardRequest build() {
            return new LinkCustomerToGiftCardRequest(customerId);
        }
    }
}
