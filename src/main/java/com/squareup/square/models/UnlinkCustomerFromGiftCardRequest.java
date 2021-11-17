
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UnlinkCustomerFromGiftCardRequest type.
 */
public class UnlinkCustomerFromGiftCardRequest {
    private final String customerId;

    /**
     * Initialization constructor.
     * @param  customerId  String value for customerId.
     */
    @JsonCreator
    public UnlinkCustomerFromGiftCardRequest(
            @JsonProperty("customer_id") String customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the customer to unlink from the gift card.
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
        if (!(obj instanceof UnlinkCustomerFromGiftCardRequest)) {
            return false;
        }
        UnlinkCustomerFromGiftCardRequest other = (UnlinkCustomerFromGiftCardRequest) obj;
        return Objects.equals(customerId, other.customerId);
    }

    /**
     * Converts this UnlinkCustomerFromGiftCardRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UnlinkCustomerFromGiftCardRequest [" + "customerId=" + customerId + "]";
    }

    /**
     * Builds a new {@link UnlinkCustomerFromGiftCardRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UnlinkCustomerFromGiftCardRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customerId);
        return builder;
    }

    /**
     * Class to build instances of {@link UnlinkCustomerFromGiftCardRequest}.
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
         * Builds a new {@link UnlinkCustomerFromGiftCardRequest} object using the set fields.
         * @return {@link UnlinkCustomerFromGiftCardRequest}
         */
        public UnlinkCustomerFromGiftCardRequest build() {
            return new UnlinkCustomerFromGiftCardRequest(customerId);
        }
    }
}
