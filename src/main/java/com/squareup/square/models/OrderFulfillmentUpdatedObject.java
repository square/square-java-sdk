
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderFulfillmentUpdatedObject type.
 */
public class OrderFulfillmentUpdatedObject {
    private final OrderFulfillmentUpdated orderFulfillmentUpdated;

    /**
     * Initialization constructor.
     * @param orderFulfillmentUpdated OrderFulfillmentUpdated value for orderFulfillmentUpdated.
     */
    @JsonCreator
    public OrderFulfillmentUpdatedObject(
            @JsonProperty("order_fulfillment_updated") OrderFulfillmentUpdated orderFulfillmentUpdated) {
        this.orderFulfillmentUpdated = orderFulfillmentUpdated;
    }

    /**
     * Getter for OrderFulfillmentUpdated.
     * @return Returns the OrderFulfillmentUpdated
     */
    @JsonGetter("order_fulfillment_updated")
    public OrderFulfillmentUpdated getOrderFulfillmentUpdated() {
        return this.orderFulfillmentUpdated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderFulfillmentUpdated);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFulfillmentUpdatedObject)) {
            return false;
        }
        OrderFulfillmentUpdatedObject other = (OrderFulfillmentUpdatedObject) obj;
        return Objects.equals(orderFulfillmentUpdated, other.orderFulfillmentUpdated);
    }

    /**
     * Converts this OrderFulfillmentUpdatedObject into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderFulfillmentUpdatedObject [" + "orderFulfillmentUpdated="
                + orderFulfillmentUpdated + "]";
    }

    /**
     * Builds a new {@link OrderFulfillmentUpdatedObject.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderFulfillmentUpdatedObject.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .orderFulfillmentUpdated(getOrderFulfillmentUpdated());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentUpdatedObject}.
     */
    public static class Builder {
        private OrderFulfillmentUpdated orderFulfillmentUpdated;



        /**
         * Setter for orderFulfillmentUpdated.
         * @param orderFulfillmentUpdated OrderFulfillmentUpdated value for orderFulfillmentUpdated.
         * @return Builder
         */
        public Builder orderFulfillmentUpdated(OrderFulfillmentUpdated orderFulfillmentUpdated) {
            this.orderFulfillmentUpdated = orderFulfillmentUpdated;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillmentUpdatedObject} object using the set fields.
         * @return {@link OrderFulfillmentUpdatedObject}
         */
        public OrderFulfillmentUpdatedObject build() {
            return new OrderFulfillmentUpdatedObject(orderFulfillmentUpdated);
        }
    }
}
