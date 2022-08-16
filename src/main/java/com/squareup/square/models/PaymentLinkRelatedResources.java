
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for PaymentLinkRelatedResources type.
 */
public class PaymentLinkRelatedResources {
    private final List<Order> orders;
    private final List<CatalogObject> subscriptionPlans;

    /**
     * Initialization constructor.
     * @param  orders  List of Order value for orders.
     * @param  subscriptionPlans  List of CatalogObject value for subscriptionPlans.
     */
    @JsonCreator
    public PaymentLinkRelatedResources(
            @JsonProperty("orders") List<Order> orders,
            @JsonProperty("subscription_plans") List<CatalogObject> subscriptionPlans) {
        this.orders = orders;
        this.subscriptionPlans = subscriptionPlans;
    }

    /**
     * Getter for Orders.
     * The order associated with the payment link.
     * @return Returns the List of Order
     */
    @JsonGetter("orders")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Getter for SubscriptionPlans.
     * The subscription plan associated with the payment link.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("subscription_plans")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CatalogObject> getSubscriptionPlans() {
        return subscriptionPlans;
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
        Builder builder = new Builder()
                .orders(getOrders())
                .subscriptionPlans(getSubscriptionPlans());
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentLinkRelatedResources}.
     */
    public static class Builder {
        private List<Order> orders;
        private List<CatalogObject> subscriptionPlans;



        /**
         * Setter for orders.
         * @param  orders  List of Order value for orders.
         * @return Builder
         */
        public Builder orders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        /**
         * Setter for subscriptionPlans.
         * @param  subscriptionPlans  List of CatalogObject value for subscriptionPlans.
         * @return Builder
         */
        public Builder subscriptionPlans(List<CatalogObject> subscriptionPlans) {
            this.subscriptionPlans = subscriptionPlans;
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
