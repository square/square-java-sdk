package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderReward type.
 */
public class OrderReward {

    /**
     * Initialization constructor.
     * @param id
     * @param rewardTierId
     */
    @JsonCreator
    public OrderReward(
            @JsonProperty("id") String id,
            @JsonProperty("reward_tier_id") String rewardTierId) {
        this.id = id;
        this.rewardTierId = rewardTierId;
    }

    private final String id;
    private final String rewardTierId;
    /**
     * Getter for Id.
     * The identifier of the reward.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for RewardTierId.
     * The identifier of the reward tier corresponding to this reward.
     */
    @JsonGetter("reward_tier_id")
    public String getRewardTierId() {
        return this.rewardTierId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, rewardTierId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderReward)) {
            return false;
        }
        OrderReward orderReward = (OrderReward) obj;
        return Objects.equals(id, orderReward.id) &&
            Objects.equals(rewardTierId, orderReward.rewardTierId);
    }

    /**
     * Builds a new {@link OrderReward.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReward.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            rewardTierId);
            return builder;
    }

    /**
     * Class to build instances of {@link OrderReward}
     */
    public static class Builder {
        private String id;
        private String rewardTierId;

        /**
         * Initialization constructor
         */
        public Builder(String id,
                String rewardTierId) {
            this.id = id;
            this.rewardTierId = rewardTierId;
        }

        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for rewardTierId
         * @param rewardTierId
         * @return Builder
         */
        public Builder rewardTierId(String rewardTierId) {
            this.rewardTierId = rewardTierId;
            return this;
        }

        /**
         * Builds a new {@link OrderReward} object using the set fields.
         * @return {@link OrderReward}
         */
        public OrderReward build() {
            return new OrderReward(id,
                rewardTierId);
        }
    }
}
