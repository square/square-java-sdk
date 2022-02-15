
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CalculateOrderRequest type.
 */
public class CalculateOrderRequest {
    private final Order order;
    private final List<OrderReward> proposedRewards;

    /**
     * Initialization constructor.
     * @param  order  Order value for order.
     * @param  proposedRewards  List of OrderReward value for proposedRewards.
     */
    @JsonCreator
    public CalculateOrderRequest(
            @JsonProperty("order") Order order,
            @JsonProperty("proposed_rewards") List<OrderReward> proposedRewards) {
        this.order = order;
        this.proposedRewards = proposedRewards;
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square, including line
     * items that specify the products to purchase. `Order` objects also include information about
     * any associated tenders, refunds, and returns. All Connect V2 Transactions have all been
     * converted to Orders including all associated itemization data.
     * @return Returns the Order
     */
    @JsonGetter("order")
    public Order getOrder() {
        return order;
    }

    /**
     * Getter for ProposedRewards.
     * Identifies one or more loyalty reward tiers to apply during the order calculation. The
     * discounts defined by the reward tiers are added to the order only to preview the effect of
     * applying the specified rewards. The rewards do not correspond to actual redemptions; that is,
     * no `reward`s are created. Therefore, the reward `id`s are random strings used only to
     * reference the reward tier.
     * @return Returns the List of OrderReward
     */
    @JsonGetter("proposed_rewards")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<OrderReward> getProposedRewards() {
        return proposedRewards;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, proposedRewards);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CalculateOrderRequest)) {
            return false;
        }
        CalculateOrderRequest other = (CalculateOrderRequest) obj;
        return Objects.equals(order, other.order)
            && Objects.equals(proposedRewards, other.proposedRewards);
    }

    /**
     * Converts this CalculateOrderRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CalculateOrderRequest [" + "order=" + order + ", proposedRewards=" + proposedRewards
                + "]";
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
     * Class to build instances of {@link CalculateOrderRequest}.
     */
    public static class Builder {
        private Order order;
        private List<OrderReward> proposedRewards;

        /**
         * Initialization constructor.
         * @param  order  Order value for order.
         */
        public Builder(Order order) {
            this.order = order;
        }

        /**
         * Setter for order.
         * @param  order  Order value for order.
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
            return this;
        }

        /**
         * Setter for proposedRewards.
         * @param  proposedRewards  List of OrderReward value for proposedRewards.
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
            return new CalculateOrderRequest(order, proposedRewards);
        }
    }
}
