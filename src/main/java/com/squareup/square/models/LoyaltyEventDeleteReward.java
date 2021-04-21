
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEventDeleteReward type.
 */
public class LoyaltyEventDeleteReward {
    private final String loyaltyProgramId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String rewardId;
    private final int points;

    /**
     * Initialization constructor.
     * @param  loyaltyProgramId  String value for loyaltyProgramId.
     * @param  points  int value for points.
     * @param  rewardId  String value for rewardId.
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

    /**
     * Getter for LoyaltyProgramId.
     * The ID of the [loyalty program]($m/LoyaltyProgram).
     * @return Returns the String
     */
    @JsonGetter("loyalty_program_id")
    public String getLoyaltyProgramId() {
        return loyaltyProgramId;
    }

    /**
     * Getter for RewardId.
     * The ID of the deleted [loyalty reward]($m/LoyaltyReward). This field is returned only if the
     * event source is `LOYALTY_API`.
     * @return Returns the String
     */
    @JsonGetter("reward_id")
    public String getRewardId() {
        return rewardId;
    }

    /**
     * Getter for Points.
     * The number of points returned to the loyalty account.
     * @return Returns the int
     */
    @JsonGetter("points")
    public int getPoints() {
        return points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyProgramId, rewardId, points);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventDeleteReward)) {
            return false;
        }
        LoyaltyEventDeleteReward other = (LoyaltyEventDeleteReward) obj;
        return Objects.equals(loyaltyProgramId, other.loyaltyProgramId)
            && Objects.equals(rewardId, other.rewardId)
            && Objects.equals(points, other.points);
    }

    /**
     * Converts this LoyaltyEventDeleteReward into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEventDeleteReward [" + "loyaltyProgramId=" + loyaltyProgramId + ", points="
                + points + ", rewardId=" + rewardId + "]";
    }

    /**
     * Builds a new {@link LoyaltyEventDeleteReward.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventDeleteReward.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyProgramId, points)
                .rewardId(getRewardId());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventDeleteReward}.
     */
    public static class Builder {
        private String loyaltyProgramId;
        private int points;
        private String rewardId;

        /**
         * Initialization constructor.
         * @param  loyaltyProgramId  String value for loyaltyProgramId.
         * @param  points  int value for points.
         */
        public Builder(String loyaltyProgramId, int points) {
            this.loyaltyProgramId = loyaltyProgramId;
            this.points = points;
        }

        /**
         * Setter for loyaltyProgramId.
         * @param  loyaltyProgramId  String value for loyaltyProgramId.
         * @return Builder
         */
        public Builder loyaltyProgramId(String loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
            return this;
        }

        /**
         * Setter for points.
         * @param  points  int value for points.
         * @return Builder
         */
        public Builder points(int points) {
            this.points = points;
            return this;
        }

        /**
         * Setter for rewardId.
         * @param  rewardId  String value for rewardId.
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
            return new LoyaltyEventDeleteReward(loyaltyProgramId, points, rewardId);
        }
    }
}
