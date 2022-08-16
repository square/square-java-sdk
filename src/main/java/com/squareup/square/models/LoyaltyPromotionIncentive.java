
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyPromotionIncentive type.
 */
public class LoyaltyPromotionIncentive {
    private final String type;
    private final LoyaltyPromotionIncentivePointsMultiplierData pointsMultiplierData;
    private final LoyaltyPromotionIncentivePointsAdditionData pointsAdditionData;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  pointsMultiplierData  LoyaltyPromotionIncentivePointsMultiplierData value for
     *         pointsMultiplierData.
     * @param  pointsAdditionData  LoyaltyPromotionIncentivePointsAdditionData value for
     *         pointsAdditionData.
     */
    @JsonCreator
    public LoyaltyPromotionIncentive(
            @JsonProperty("type") String type,
            @JsonProperty("points_multiplier_data") LoyaltyPromotionIncentivePointsMultiplierData pointsMultiplierData,
            @JsonProperty("points_addition_data") LoyaltyPromotionIncentivePointsAdditionData pointsAdditionData) {
        this.type = type;
        this.pointsMultiplierData = pointsMultiplierData;
        this.pointsAdditionData = pointsAdditionData;
    }

    /**
     * Getter for Type.
     * Indicates the type of points incentive for a [loyalty promotion]($m/LoyaltyPromotion), which
     * is used to determine how buyers can earn points from the promotion.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for PointsMultiplierData.
     * Represents the metadata for a `POINTS_MULTIPLIER` type of [loyalty promotion
     * incentive]($m/LoyaltyPromotionIncentive).
     * @return Returns the LoyaltyPromotionIncentivePointsMultiplierData
     */
    @JsonGetter("points_multiplier_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyPromotionIncentivePointsMultiplierData getPointsMultiplierData() {
        return pointsMultiplierData;
    }

    /**
     * Getter for PointsAdditionData.
     * Represents the metadata for a `POINTS_ADDITION` type of [loyalty promotion
     * incentive]($m/LoyaltyPromotionIncentive).
     * @return Returns the LoyaltyPromotionIncentivePointsAdditionData
     */
    @JsonGetter("points_addition_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyPromotionIncentivePointsAdditionData getPointsAdditionData() {
        return pointsAdditionData;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, pointsMultiplierData, pointsAdditionData);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyPromotionIncentive)) {
            return false;
        }
        LoyaltyPromotionIncentive other = (LoyaltyPromotionIncentive) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(pointsMultiplierData, other.pointsMultiplierData)
            && Objects.equals(pointsAdditionData, other.pointsAdditionData);
    }

    /**
     * Converts this LoyaltyPromotionIncentive into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyPromotionIncentive [" + "type=" + type + ", pointsMultiplierData="
                + pointsMultiplierData + ", pointsAdditionData=" + pointsAdditionData + "]";
    }

    /**
     * Builds a new {@link LoyaltyPromotionIncentive.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyPromotionIncentive.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type)
                .pointsMultiplierData(getPointsMultiplierData())
                .pointsAdditionData(getPointsAdditionData());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyPromotionIncentive}.
     */
    public static class Builder {
        private String type;
        private LoyaltyPromotionIncentivePointsMultiplierData pointsMultiplierData;
        private LoyaltyPromotionIncentivePointsAdditionData pointsAdditionData;

        /**
         * Initialization constructor.
         * @param  type  String value for type.
         */
        public Builder(String type) {
            this.type = type;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for pointsMultiplierData.
         * @param  pointsMultiplierData  LoyaltyPromotionIncentivePointsMultiplierData value for
         *         pointsMultiplierData.
         * @return Builder
         */
        public Builder pointsMultiplierData(
                LoyaltyPromotionIncentivePointsMultiplierData pointsMultiplierData) {
            this.pointsMultiplierData = pointsMultiplierData;
            return this;
        }

        /**
         * Setter for pointsAdditionData.
         * @param  pointsAdditionData  LoyaltyPromotionIncentivePointsAdditionData value for
         *         pointsAdditionData.
         * @return Builder
         */
        public Builder pointsAdditionData(
                LoyaltyPromotionIncentivePointsAdditionData pointsAdditionData) {
            this.pointsAdditionData = pointsAdditionData;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyPromotionIncentive} object using the set fields.
         * @return {@link LoyaltyPromotionIncentive}
         */
        public LoyaltyPromotionIncentive build() {
            return new LoyaltyPromotionIncentive(type, pointsMultiplierData, pointsAdditionData);
        }
    }
}
