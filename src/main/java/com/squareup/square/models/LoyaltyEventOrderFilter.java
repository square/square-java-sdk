package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEventOrderFilter type.
 */
public class LoyaltyEventOrderFilter {

    /**
     * Initialization constructor.
     * @param orderId
     */
    @JsonCreator
    public LoyaltyEventOrderFilter(
            @JsonProperty("order_id") String orderId) {
        this.orderId = orderId;
    }

    private final String orderId;
    /**
     * Getter for OrderId.
     * The ID of the [order](#type-Order) associated with the event.
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return this.orderId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEventOrderFilter)) {
            return false;
        }
        LoyaltyEventOrderFilter loyaltyEventOrderFilter = (LoyaltyEventOrderFilter) obj;
        return Objects.equals(orderId, loyaltyEventOrderFilter.orderId);
    }

    /**
     * Builds a new {@link LoyaltyEventOrderFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventOrderFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(orderId);
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventOrderFilter}
     */
    public static class Builder {
        private String orderId;

        /**
         * Initialization constructor
         */
        public Builder(String orderId) {
            this.orderId = orderId;
        }

        /**
         * Setter for orderId
         * @param orderId
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventOrderFilter} object using the set fields.
         * @return {@link LoyaltyEventOrderFilter}
         */
        public LoyaltyEventOrderFilter build() {
            return new LoyaltyEventOrderFilter(orderId);
        }
    }
}
