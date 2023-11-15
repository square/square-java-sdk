
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for PaymentLinkRelatedResources type.
 */
public class PaymentLinkRelatedResources {
    private final OptionalNullable<List<Order>> orders;
    private final OptionalNullable<List<CatalogObject>> subscriptionPlans;

    /**
     * Initialization constructor.
     * @param  orders  List of Order value for orders.
     * @param  subscriptionPlans  List of CatalogObject value for subscriptionPlans.
     */
    @JsonCreator
    public PaymentLinkRelatedResources(
            @JsonProperty("orders") List<Order> orders,
            @JsonProperty("subscription_plans") List<CatalogObject> subscriptionPlans) {
        this.orders = OptionalNullable.of(orders);
        this.subscriptionPlans = OptionalNullable.of(subscriptionPlans);
    }

    /**
     * Initialization constructor.
     * @param  orders  List of Order value for orders.
     * @param  subscriptionPlans  List of CatalogObject value for subscriptionPlans.
     */

    protected PaymentLinkRelatedResources(OptionalNullable<List<Order>> orders,
            OptionalNullable<List<CatalogObject>> subscriptionPlans) {
        this.orders = orders;
        this.subscriptionPlans = subscriptionPlans;
    }

    /**
     * Internal Getter for Orders.
     * The order associated with the payment link.
     * @return Returns the Internal List of Order
     */
    @JsonGetter("orders")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Order>> internalGetOrders() {
        return this.orders;
    }

    /**
     * Getter for Orders.
     * The order associated with the payment link.
     * @return Returns the List of Order
     */
    @JsonIgnore
    public List<Order> getOrders() {
        return OptionalNullable.getFrom(orders);
    }

    /**
     * Internal Getter for SubscriptionPlans.
     * The subscription plan associated with the payment link.
     * @return Returns the Internal List of CatalogObject
     */
    @JsonGetter("subscription_plans")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogObject>> internalGetSubscriptionPlans() {
        return this.subscriptionPlans;
    }

    /**
     * Getter for SubscriptionPlans.
     * The subscription plan associated with the payment link.
     * @return Returns the List of CatalogObject
     */
    @JsonIgnore
    public List<CatalogObject> getSubscriptionPlans() {
        return OptionalNullable.getFrom(subscriptionPlans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders, subscriptionPlans);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentLinkRelatedResources)) {
            return false;
        }
        PaymentLinkRelatedResources other = (PaymentLinkRelatedResources) obj;
        return Objects.equals(orders, other.orders)
            && Objects.equals(subscriptionPlans, other.subscriptionPlans);
    }

    /**
     * Converts this PaymentLinkRelatedResources into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentLinkRelatedResources [" + "orders=" + orders + ", subscriptionPlans="
                + subscriptionPlans + "]";
    }

    /**
     * Builds a new {@link PaymentLinkRelatedResources.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentLinkRelatedResources.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.orders = internalGetOrders();
        builder.subscriptionPlans = internalGetSubscriptionPlans();
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentLinkRelatedResources}.
     */
    public static class Builder {
        private OptionalNullable<List<Order>> orders;
        private OptionalNullable<List<CatalogObject>> subscriptionPlans;



        /**
         * Setter for orders.
         * @param  orders  List of Order value for orders.
         * @return Builder
         */
        public Builder orders(List<Order> orders) {
            this.orders = OptionalNullable.of(orders);
            return this;
        }

        /**
         * UnSetter for orders.
         * @return Builder
         */
        public Builder unsetOrders() {
            orders = null;
            return this;
        }

        /**
         * Setter for subscriptionPlans.
         * @param  subscriptionPlans  List of CatalogObject value for subscriptionPlans.
         * @return Builder
         */
        public Builder subscriptionPlans(List<CatalogObject> subscriptionPlans) {
            this.subscriptionPlans = OptionalNullable.of(subscriptionPlans);
            return this;
        }

        /**
         * UnSetter for subscriptionPlans.
         * @return Builder
         */
        public Builder unsetSubscriptionPlans() {
            subscriptionPlans = null;
            return this;
        }

        /**
         * Builds a new {@link PaymentLinkRelatedResources} object using the set fields.
         * @return {@link PaymentLinkRelatedResources}
         */
        public PaymentLinkRelatedResources build() {
            return new PaymentLinkRelatedResources(orders, subscriptionPlans);
        }
    }
}
