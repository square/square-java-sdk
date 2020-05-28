package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEventRedeemReward type.
 */
public class LoyaltyEventRedeemReward {

    /**
     * Initialization constructor.
     * @param loyaltyProgramId
     * @param rewardId
     * @param orderId
     */
    @JsonCreator
    public LoyaltyEventRedeemReward(
            @JsonProperty("loyalty_program_id") String loyaltyProgramId,
            @JsonProperty("reward_id") String rewardId,
            @JsonProperty("order_id") String orderId) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.rewardId = rewardId;
        this.orderId = orderId;
    }

    private final String loyaltyProgramId;
    private final String rewardId;
    private final String orderId;
    /**
     * Getter for LoyaltyProgramId.
     * The ID of the [loyalty program](#type-LoyaltyProgram).
     */
    @JsonGetter("loyalty_program_id")
    public String getLoyaltyProgramId() {
        return this.loyaltyProgramId;
    }

    /**
     * Getter for RewardId.
     * The ID of the redeemed [loyalty reward](#type-LoyaltyReward).
     * This field is returned only if the event source is `LOYALTY_API`.
     */
    @JsonGetter("reward_id")
    public String getRewardId() {
        return this.rewardId;
    }

    /**
     * Getter for OrderId.
     * The ID of the [order](#type-Order) that redeemed the reward.
     * This field is returned only if the Orders API is used to process orders.
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return this.orderId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(loyaltyProgramId, rewardId, orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEventRedeemReward)) {
            return false;
        }
        LoyaltyEventRedeemReward loyaltyEventRedeemReward = (LoyaltyEventRedeemReward) obj;
        return Objects.equals(loyaltyProgramId, loyaltyEventRedeemReward.loyaltyProgramId) &&
            Objects.equals(rewardId, loyaltyEventRedeemReward.rewardId) &&
            Objects.equals(orderId, loyaltyEventRedeemReward.orderId);
    }

    /**
     * Builds a new {@link LoyaltyEventRedeemReward.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventRedeemReward.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyProgramId)
            .rewardId(getRewardId())
            .orderId(getOrderId());
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventRedeemReward}
     */
    public static class Builder {
        private String loyaltyProgramId;
        private String rewardId;
        private String orderId;

        /**
         * Initialization constructor
         */
        public Builder(String loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
        }

        /**
         * Setter for loyaltyProgramId
         * @param loyaltyProgramId
         * @return Builder
         */
        public Builder loyaltyProgramId(String loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
            return this;
        }
        /**
         * Setter for rewardId
         * @param rewardId
         * @return Builder
         */
        public Builder rewardId(String rewardId) {
            this.rewardId = rewardId;
            return this;
        }
        /**
         * Setter for orderId
         * @param orderId
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventRedeemReward} object using the set fields.
         * @return {@link LoyaltyEventRedeemReward}
         */
        public LoyaltyEventRedeemReward build() {
            return new LoyaltyEventRedeemReward(loyaltyProgramId,
                rewardId,
                orderId);
        }
    }
}
