
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEventOrderFilter type.
 */
public class LoyaltyEventOrderFilter {
    private final String orderId;

    /**
     * Initialization constructor.
     * @param  orderId  String value for orderId.
     */
    @JsonCreator
    public LoyaltyEventOrderFilter(
            @JsonProperty("order_id") String orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter for OrderId.
     * The ID of the [order](#type-Order) associated with the event.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventOrderFilter)) {
            return false;
        }
        LoyaltyEventOrderFilter other = (LoyaltyEventOrderFilter) obj;
        return Objects.equals(orderId, other.orderId);
    }

    /**
     * Converts this LoyaltyEventOrderFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEventOrderFilter [" + "orderId=" + orderId + "]";
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
     * Class to build instances of {@link LoyaltyEventOrderFilter}.
     */
    public static class Builder {
        private String orderId;

        /**
         * Initialization constructor.
         * @param  orderId  String value for orderId.
         */
        public Builder(String orderId) {
            this.orderId = orderId;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
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
