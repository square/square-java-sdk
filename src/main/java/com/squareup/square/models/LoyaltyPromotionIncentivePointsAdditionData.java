
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyPromotionIncentivePointsAdditionData type.
 */
public class LoyaltyPromotionIncentivePointsAdditionData {
    private final int pointsAddition;

    /**
     * Initialization constructor.
     * @param  pointsAddition  int value for pointsAddition.
     */
    @JsonCreator
    public LoyaltyPromotionIncentivePointsAdditionData(
            @JsonProperty("points_addition") int pointsAddition) {
        this.pointsAddition = pointsAddition;
    }

    /**
     * Getter for PointsAddition.
     * The number of additional points to earn each time the promotion is triggered. For example,
     * suppose a purchase qualifies for 5 points from the base loyalty program. If the purchase also
     * qualifies for a `POINTS_ADDITION` promotion incentive with a `points_addition` of 3, the
     * buyer earns a total of 8 points (5 program points + 3 promotion points = 8 points).
     * @return Returns the int
     */
    @JsonGetter("points_addition")
    public int getPointsAddition() {
        return pointsAddition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointsAddition);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyPromotionIncentivePointsAdditionData)) {
            return false;
        }
        LoyaltyPromotionIncentivePointsAdditionData other =
                (LoyaltyPromotionIncentivePointsAdditionData) obj;
        return Objects.equals(pointsAddition, other.pointsAddition);
    }

    /**
     * Converts this LoyaltyPromotionIncentivePointsAdditionData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyPromotionIncentivePointsAdditionData [" + "pointsAddition=" + pointsAddition
                + "]";
    }

    /**
     * Builds a new {@link LoyaltyPromotionIncentivePointsAdditionData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyPromotionIncentivePointsAdditionData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(pointsAddition);
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyPromotionIncentivePointsAdditionData}.
     */
    public static class Builder {
        private int pointsAddition;

        /**
         * Initialization constructor.
         * @param  pointsAddition  int value for pointsAddition.
         */
        public Builder(int pointsAddition) {
            this.pointsAddition = pointsAddition;
        }

        /**
         * Setter for pointsAddition.
         * @param  pointsAddition  int value for pointsAddition.
         * @return Builder
         */
        public Builder pointsAddition(int pointsAddition) {
            this.pointsAddition = pointsAddition;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyPromotionIncentivePointsAdditionData} object using the set
         * fields.
         * @return {@link LoyaltyPromotionIncentivePointsAdditionData}
         */
        public LoyaltyPromotionIncentivePointsAdditionData build() {
            return new LoyaltyPromotionIncentivePointsAdditionData(pointsAddition);
        }
    }
}
