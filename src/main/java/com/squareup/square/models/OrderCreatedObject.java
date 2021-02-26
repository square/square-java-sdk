
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderCreatedObject type.
 */
public class OrderCreatedObject {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final OrderCreated orderCreated;

    /**
     * Initialization constructor.
     * @param  orderCreated  OrderCreated value for orderCreated.
     */
    @JsonCreator
    public OrderCreatedObject(
            @JsonProperty("order_created") OrderCreated orderCreated) {
        this.orderCreated = orderCreated;
    }

    /**
     * Getter for OrderCreated.
     * @return Returns the OrderCreated
     */
    @JsonGetter("order_created")
    public OrderCreated getOrderCreated() {
        return orderCreated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderCreated);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderCreatedObject)) {
            return false;
        }
        OrderCreatedObject other = (OrderCreatedObject) obj;
        return Objects.equals(orderCreated, other.orderCreated);
    }

    /**
     * Converts this OrderCreatedObject into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderCreatedObject [" + "orderCreated=" + orderCreated + "]";
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
     * Class to build instances of {@link OrderCreatedObject}.
     */
    public static class Builder {
        private OrderCreated orderCreated;



        /**
         * Setter for orderCreated.
         * @param  orderCreated  OrderCreated value for orderCreated.
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
