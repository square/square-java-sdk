
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for OrderUpdatedObject type.
 */
public class OrderUpdatedObject {
    private final OrderUpdated orderUpdated;

    /**
     * Initialization constructor.
     * @param orderUpdated OrderUpdated value for orderUpdated.
     */
    @JsonCreator
    public OrderUpdatedObject(
            @JsonProperty("order_updated") OrderUpdated orderUpdated) {
        this.orderUpdated = orderUpdated;
    }

    /**
     * Getter for OrderUpdated.
     * @return Returns the OrderUpdated
     */
    @JsonGetter("order_updated")
    public OrderUpdated getOrderUpdated() {
        return this.orderUpdated;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(orderUpdated);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderUpdatedObject)) {
            return false;
        }
        OrderUpdatedObject other = (OrderUpdatedObject) obj;
        return Objects.equals(orderUpdated, other.orderUpdated);
    }

    /**
     * Builds a new {@link OrderUpdatedObject.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderUpdatedObject.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .orderUpdated(getOrderUpdated());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderUpdatedObject}.
     */
    public static class Builder {
        private OrderUpdated orderUpdated;



        /**
         * Setter for orderUpdated.
         * @param orderUpdated OrderUpdated value for orderUpdated.
         * @return Builder
         */
        public Builder orderUpdated(OrderUpdated orderUpdated) {
            this.orderUpdated = orderUpdated;
            return this;
        }

        /**
         * Builds a new {@link OrderUpdatedObject} object using the set fields.
         * @return {@link OrderUpdatedObject}
         */
        public OrderUpdatedObject build() {
            return new OrderUpdatedObject(orderUpdated);
        }
    }
}
