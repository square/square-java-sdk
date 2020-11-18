
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderReward type.
 */
public class OrderReward {
    private final String id;
    private final String rewardTierId;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param rewardTierId String value for rewardTierId.
     */
    @JsonCreator
    public OrderReward(
            @JsonProperty("id") String id,
            @JsonProperty("reward_tier_id") String rewardTierId) {
        this.id = id;
        this.rewardTierId = rewardTierId;
    }

    /**
     * Getter for Id.
     * The identifier of the reward.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for RewardTierId.
     * The identifier of the reward tier corresponding to this reward.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderReward)) {
            return false;
        }
        OrderReward other = (OrderReward) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(rewardTierId, other.rewardTierId);
    }

    /**
     * Converts this OrderReward into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderReward [" + "id=" + id + ", rewardTierId=" + rewardTierId + "]";
    }

    /**
     * Builds a new {@link OrderReward.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReward.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id, rewardTierId);
        return builder;
    }

    /**
     * Class to build instances of {@link OrderReward}.
     */
    public static class Builder {
        private String id;
        private String rewardTierId;

        /**
         * Initialization constructor.
         * @param id String value for id.
         * @param rewardTierId String value for rewardTierId.
         */
        public Builder(String id,
                String rewardTierId) {
            this.id = id;
            this.rewardTierId = rewardTierId;
        }

        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for rewardTierId.
         * @param rewardTierId String value for rewardTierId.
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
            return new OrderReward(id, rewardTierId);
        }
    }
}
