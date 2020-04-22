package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderCreatedObject type.
 */
public class OrderCreatedObject {

    /**
     * Initialization constructor.
     * @param orderCreated
     */
    @JsonCreator
    public OrderCreatedObject(
            @JsonProperty("order_created") OrderCreated orderCreated) {
        this.orderCreated = orderCreated;
    }

    private final OrderCreated orderCreated;
    /**
     * Getter for OrderCreated.
     */
    @JsonGetter("order_created")
    public OrderCreated getOrderCreated() {
        return this.orderCreated;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(orderCreated);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderCreatedObject)) {
            return false;
        }
        OrderCreatedObject orderCreatedObject = (OrderCreatedObject) obj;
        return Objects.equals(orderCreated, orderCreatedObject.orderCreated);
    }

    /**
     * Builds a new {@link OrderCreatedObject.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderCreatedObject.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .orderCreated(getOrderCreated());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderCreatedObject}
     */
    public static class Builder {
        private OrderCreated orderCreated;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for orderCreated
         * @param orderCreated
         * @return Builder
         */
        public Builder orderCreated(OrderCreated orderCreated) {
            this.orderCreated = orderCreated;
            return this;
        }

        /**
         * Builds a new {@link OrderCreatedObject} object using the set fields.
         * @return {@link OrderCreatedObject}
         */
        public OrderCreatedObject build() {
            return new OrderCreatedObject(orderCreated);
        }
    }
}
