package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEventDeleteReward type.
 */
public class LoyaltyEventDeleteReward {

    /**
     * Initialization constructor.
     * @param loyaltyProgramId
     * @param points
     * @param rewardId
     */
    @JsonCreator
    public LoyaltyEventDeleteReward(
            @JsonProperty("loyalty_program_id") String loyaltyProgramId,
            @JsonProperty("points") int points,
            @JsonProperty("reward_id") String rewardId) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.rewardId = rewardId;
        this.points = points;
    }

    private final String loyaltyProgramId;
    private final String rewardId;
    private final int points;
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
     * The ID of the deleted [loyalty reward](#type-LoyaltyReward).
     * This field is returned only if the event source is `LOYALTY_API`.
     */
    @JsonGetter("reward_id")
    public String getRewardId() {
        return this.rewardId;
    }

    /**
     * Getter for Points.
     * The number of points returned to the loyalty account.
     */
    @JsonGetter("points")
    public int getPoints() {
        return this.points;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(loyaltyProgramId, rewardId, points);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEventDeleteReward)) {
            return false;
        }
        LoyaltyEventDeleteReward loyaltyEventDeleteReward = (LoyaltyEventDeleteReward) obj;
        return Objects.equals(loyaltyProgramId, loyaltyEventDeleteReward.loyaltyProgramId) &&
            Objects.equals(rewardId, loyaltyEventDeleteReward.rewardId) &&
            Objects.equals(points, loyaltyEventDeleteReward.points);
    }

    /**
     * Builds a new {@link LoyaltyEventDeleteReward.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventDeleteReward.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyProgramId,
            points)
            .rewardId(getRewardId());
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventDeleteReward}
     */
    public static class Builder {
        private String loyaltyProgramId;
        private int points;
        private String rewardId;

        /**
         * Initialization constructor
         */
        public Builder(String loyaltyProgramId,
                int points) {
            this.loyaltyProgramId = loyaltyProgramId;
            this.points = points;
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
         * Setter for points
         * @param points
         * @return Builder
         */
        public Builder points(int points) {
            this.points = points;
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
         * Builds a new {@link LoyaltyEventDeleteReward} object using the set fields.
         * @return {@link LoyaltyEventDeleteReward}
         */
        public LoyaltyEventDeleteReward build() {
            return new LoyaltyEventDeleteReward(loyaltyProgramId,
                points,
                rewardId);
        }
    }
}
