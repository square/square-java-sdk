
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for LoyaltyPromotionIncentivePointsMultiplierData type.
 */
public class LoyaltyPromotionIncentivePointsMultiplierData {
    private final OptionalNullable<Integer> pointsMultiplier;
    private final OptionalNullable<String> multiplier;

    /**
     * Initialization constructor.
     * @param  pointsMultiplier  Integer value for pointsMultiplier.
     * @param  multiplier  String value for multiplier.
     */
    @JsonCreator
    public LoyaltyPromotionIncentivePointsMultiplierData(
            @JsonProperty("points_multiplier") Integer pointsMultiplier,
            @JsonProperty("multiplier") String multiplier) {
        this.pointsMultiplier = OptionalNullable.of(pointsMultiplier);
        this.multiplier = OptionalNullable.of(multiplier);
    }

    /**
     * Internal initialization constructor.
     */
    protected LoyaltyPromotionIncentivePointsMultiplierData(
            OptionalNullable<Integer> pointsMultiplier, OptionalNullable<String> multiplier) {
        this.pointsMultiplier = pointsMultiplier;
        this.multiplier = multiplier;
    }

    /**
     * Internal Getter for PointsMultiplier.
     * The multiplier used to calculate the number of points earned each time the promotion is
     * triggered. For example, suppose a purchase qualifies for 5 points from the base loyalty
     * program. If the purchase also qualifies for a `POINTS_MULTIPLIER` promotion incentive with a
     * `points_multiplier` of 3, the buyer earns a total of 15 points (5 program points x 3
     * promotion multiplier = 15 points). DEPRECATED at version 2023-08-16. Replaced by the
     * `multiplier` field. One of the following is required when specifying a points multiplier: -
     * (Recommended) The `multiplier` field. - This deprecated `points_multiplier` field. If
     * provided in the request, Square also returns `multiplier` with the equivalent value.
     * @return Returns the Internal Integer
     */
    @JsonGetter("points_multiplier")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetPointsMultiplier() {
        return this.pointsMultiplier;
    }

    /**
     * Getter for PointsMultiplier.
     * The multiplier used to calculate the number of points earned each time the promotion is
     * triggered. For example, suppose a purchase qualifies for 5 points from the base loyalty
     * program. If the purchase also qualifies for a `POINTS_MULTIPLIER` promotion incentive with a
     * `points_multiplier` of 3, the buyer earns a total of 15 points (5 program points x 3
     * promotion multiplier = 15 points). DEPRECATED at version 2023-08-16. Replaced by the
     * `multiplier` field. One of the following is required when specifying a points multiplier: -
     * (Recommended) The `multiplier` field. - This deprecated `points_multiplier` field. If
     * provided in the request, Square also returns `multiplier` with the equivalent value.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getPointsMultiplier() {
        return OptionalNullable.getFrom(pointsMultiplier);
    }

    /**
     * Internal Getter for Multiplier.
     * The multiplier used to calculate the number of points earned each time the promotion is
     * triggered, specified as a string representation of a decimal. Square supports multipliers up
     * to 10x, with three point precision for decimal multipliers. For example, suppose a purchase
     * qualifies for 4 points from the base loyalty program. If the purchase also qualifies for a
     * `POINTS_MULTIPLIER` promotion incentive with a `multiplier` of "1.5", the buyer earns a total
     * of 6 points (4 program points x 1.5 promotion multiplier = 6 points). Fractional points are
     * dropped. One of the following is required when specifying a points multiplier: -
     * (Recommended) This `multiplier` field. - The deprecated `points_multiplier` field. If
     * provided in the request, Square also returns `multiplier` with the equivalent value.
     * @return Returns the Internal String
     */
    @JsonGetter("multiplier")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMultiplier() {
        return this.multiplier;
    }

    /**
     * Getter for Multiplier.
     * The multiplier used to calculate the number of points earned each time the promotion is
     * triggered, specified as a string representation of a decimal. Square supports multipliers up
     * to 10x, with three point precision for decimal multipliers. For example, suppose a purchase
     * qualifies for 4 points from the base loyalty program. If the purchase also qualifies for a
     * `POINTS_MULTIPLIER` promotion incentive with a `multiplier` of "1.5", the buyer earns a total
     * of 6 points (4 program points x 1.5 promotion multiplier = 6 points). Fractional points are
     * dropped. One of the following is required when specifying a points multiplier: -
     * (Recommended) This `multiplier` field. - The deprecated `points_multiplier` field. If
     * provided in the request, Square also returns `multiplier` with the equivalent value.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMultiplier() {
        return OptionalNullable.getFrom(multiplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointsMultiplier, multiplier);
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
        return Objects.equals(pointsMultiplier, other.pointsMultiplier)
            && Objects.equals(multiplier, other.multiplier);
    }

    /**
     * Converts this LoyaltyPromotionIncentivePointsMultiplierData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyPromotionIncentivePointsMultiplierData [" + "pointsMultiplier="
                + pointsMultiplier + ", multiplier=" + multiplier + "]";
    }

    /**
     * Builds a new {@link LoyaltyPromotionIncentivePointsMultiplierData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyPromotionIncentivePointsMultiplierData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.pointsMultiplier = internalGetPointsMultiplier();
        builder.multiplier = internalGetMultiplier();
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyPromotionIncentivePointsMultiplierData}.
     */
    public static class Builder {
        private OptionalNullable<Integer> pointsMultiplier;
        private OptionalNullable<String> multiplier;



        /**
         * Setter for pointsMultiplier.
         * @param  pointsMultiplier  Integer value for pointsMultiplier.
         * @return Builder
         */
        public Builder pointsMultiplier(Integer pointsMultiplier) {
            this.pointsMultiplier = OptionalNullable.of(pointsMultiplier);
            return this;
        }

        /**
         * UnSetter for pointsMultiplier.
         * @return Builder
         */
        public Builder unsetPointsMultiplier() {
            pointsMultiplier = null;
            return this;
        }

        /**
         * Setter for multiplier.
         * @param  multiplier  String value for multiplier.
         * @return Builder
         */
        public Builder multiplier(String multiplier) {
            this.multiplier = OptionalNullable.of(multiplier);
            return this;
        }

        /**
         * UnSetter for multiplier.
         * @return Builder
         */
        public Builder unsetMultiplier() {
            multiplier = null;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyPromotionIncentivePointsMultiplierData} object using the set
         * fields.
         * @return {@link LoyaltyPromotionIncentivePointsMultiplierData}
         */
        public LoyaltyPromotionIncentivePointsMultiplierData build() {
            return new LoyaltyPromotionIncentivePointsMultiplierData(pointsMultiplier, multiplier);
        }
    }
}
