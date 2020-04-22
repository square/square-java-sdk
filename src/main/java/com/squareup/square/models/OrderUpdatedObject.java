package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderUpdatedObject type.
 */
public class OrderUpdatedObject {

    /**
     * Initialization constructor.
     * @param orderUpdated
     */
    @JsonCreator
    public OrderUpdatedObject(
            @JsonProperty("order_updated") OrderUpdated orderUpdated) {
        this.orderUpdated = orderUpdated;
    }

    private final OrderUpdated orderUpdated;
    /**
     * Getter for OrderUpdated.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderUpdatedObject)) {
            return false;
        }
        OrderUpdatedObject orderUpdatedObject = (OrderUpdatedObject) obj;
        return Objects.equals(orderUpdated, orderUpdatedObject.orderUpdated);
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
     * Class to build instances of {@link OrderUpdatedObject}
     */
    public static class Builder {
        private OrderUpdated orderUpdated;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for orderUpdated
         * @param orderUpdated
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
