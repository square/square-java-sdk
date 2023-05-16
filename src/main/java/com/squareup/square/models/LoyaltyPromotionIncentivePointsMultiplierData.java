
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyPromotionIncentivePointsMultiplierData type.
 */
public class LoyaltyPromotionIncentivePointsMultiplierData {
    private final int pointsMultiplier;

    /**
     * Initialization constructor.
     * @param  pointsMultiplier  int value for pointsMultiplier.
     */
    @JsonCreator
    public LoyaltyPromotionIncentivePointsMultiplierData(
            @JsonProperty("points_multiplier") int pointsMultiplier) {
        this.pointsMultiplier = pointsMultiplier;
    }

    /**
     * Getter for PointsMultiplier.
     * The multiplier used to calculate the number of points earned each time the promotion is
     * triggered. For example, suppose a purchase qualifies for 5 points from the base loyalty
     * program. If the purchase also qualifies for a `POINTS_MULTIPLIER` promotion incentive with a
     * `points_multiplier` of 3, the buyer earns a total of 15 points (5 program points x 3
     * promotion multiplier = 15 points).
     * @return Returns the int
     */
    @JsonGetter("points_multiplier")
    public int getPointsMultiplier() {
        return pointsMultiplier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointsMultiplier);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyPromotionIncentivePointsMultiplierData)) {
            return false;
        }
        LoyaltyPromotionIncentivePointsMultiplierData other =
                (LoyaltyPromotionIncentivePointsMultiplierData) obj;
        return Objects.equals(pointsMultiplier, other.pointsMultiplier);
    }

    /**
     * Converts this LoyaltyPromotionIncentivePointsMultiplierData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyPromotionIncentivePointsMultiplierData [" + "pointsMultiplier="
                + pointsMultiplier + "]";
    }

    /**
     * Builds a new {@link LoyaltyPromotionIncentivePointsMultiplierData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyPromotionIncentivePointsMultiplierData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(pointsMultiplier);
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyPromotionIncentivePointsMultiplierData}.
     */
    public static class Builder {
        private int pointsMultiplier;

        /**
         * Initialization constructor.
         * @param  pointsMultiplier  int value for pointsMultiplier.
         */
        public Builder(int pointsMultiplier) {
            this.pointsMultiplier = pointsMultiplier;
        }

        /**
         * Setter for pointsMultiplier.
         * @param  pointsMultiplier  int value for pointsMultiplier.
         * @return Builder
         */
        public Builder pointsMultiplier(int pointsMultiplier) {
            this.pointsMultiplier = pointsMultiplier;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyPromotionIncentivePointsMultiplierData} object using the set
         * fields.
         * @return {@link LoyaltyPromotionIncentivePointsMultiplierData}
         */
        public LoyaltyPromotionIncentivePointsMultiplierData build() {
            return new LoyaltyPromotionIncentivePointsMultiplierData(pointsMultiplier);
        }
    }
}
