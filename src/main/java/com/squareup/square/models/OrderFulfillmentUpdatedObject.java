package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderFulfillmentUpdatedObject type.
 */
public class OrderFulfillmentUpdatedObject {

    /**
     * Initialization constructor.
     * @param orderFulfillmentUpdated
     */
    @JsonCreator
    public OrderFulfillmentUpdatedObject(
            @JsonProperty("order_fulfillment_updated") OrderFulfillmentUpdated orderFulfillmentUpdated) {
        this.orderFulfillmentUpdated = orderFulfillmentUpdated;
    }

    private final OrderFulfillmentUpdated orderFulfillmentUpdated;
    /**
     * Getter for OrderFulfillmentUpdated.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderFulfillmentUpdatedObject)) {
            return false;
        }
        OrderFulfillmentUpdatedObject orderFulfillmentUpdatedObject = (OrderFulfillmentUpdatedObject) obj;
        return Objects.equals(orderFulfillmentUpdated, orderFulfillmentUpdatedObject.orderFulfillmentUpdated);
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
     * Class to build instances of {@link OrderFulfillmentUpdatedObject}
     */
    public static class Builder {
        private OrderFulfillmentUpdated orderFulfillmentUpdated;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for orderFulfillmentUpdated
         * @param orderFulfillmentUpdated
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
