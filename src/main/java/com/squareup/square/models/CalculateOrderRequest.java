package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CalculateOrderRequest type.
 */
public class CalculateOrderRequest {

    /**
     * Initialization constructor.
     * @param order
     * @param proposedRewards
     */
    @JsonCreator
    public CalculateOrderRequest(
            @JsonProperty("order") Order order,
            @JsonProperty("proposed_rewards") List<OrderReward> proposedRewards) {
        this.order = order;
        this.proposedRewards = proposedRewards;
    }

    private final Order order;
    private final List<OrderReward> proposedRewards;
    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square,
     * including line items that specify the products to purchase. Order objects also
     * include information on any associated tenders, refunds, and returns.
     * All Connect V2 Transactions have all been converted to Orders including all associated
     * itemization data.
     */
    @JsonGetter("order")
    public Order getOrder() {
        return this.order;
    }

    /**
     * Getter for ProposedRewards.
     * Identifies one or more loyalty reward tiers to apply during order calculation.
     * The discounts defined by the reward tiers are added to the order only to preview the
     * effect of applying the specified reward(s). The reward(s) do not correspond to actual
     * redemptions, that is, no `reward`s are created. Therefore, the reward `id`s are
     * random strings used only to reference the reward tier.
     */
    @JsonGetter("proposed_rewards")
    public List<OrderReward> getProposedRewards() {
        return this.proposedRewards;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(order, proposedRewards);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CalculateOrderRequest)) {
            return false;
        }
        CalculateOrderRequest calculateOrderRequest = (CalculateOrderRequest) obj;
        return Objects.equals(order, calculateOrderRequest.order) &&
            Objects.equals(proposedRewards, calculateOrderRequest.proposedRewards);
    }

    /**
     * Builds a new {@link CalculateOrderRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CalculateOrderRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(order)
            .proposedRewards(getProposedRewards());
            return builder;
    }

    /**
     * Class to build instances of {@link CalculateOrderRequest}
     */
    public static class Builder {
        private Order order;
        private List<OrderReward> proposedRewards;

        /**
         * Initialization constructor
         */
        public Builder(Order order) {
            this.order = order;
        }

        /**
         * Setter for order
         * @param order
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
            return this;
        }
        /**
         * Setter for proposedRewards
         * @param proposedRewards
         * @return Builder
         */
        public Builder proposedRewards(List<OrderReward> proposedRewards) {
            this.proposedRewards = proposedRewards;
            return this;
        }

        /**
         * Builds a new {@link CalculateOrderRequest} object using the set fields.
         * @return {@link CalculateOrderRequest}
         */
        public CalculateOrderRequest build() {
            return new CalculateOrderRequest(order,
                proposedRewards);
        }
    }
}
