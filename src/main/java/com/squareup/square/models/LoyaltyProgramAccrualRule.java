
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramAccrualRule type.
 */
public class LoyaltyProgramAccrualRule {
    private final String accrualType;
    private final Integer points;
    private final LoyaltyProgramAccrualRuleVisitData visitData;
    private final LoyaltyProgramAccrualRuleSpendData spendData;
    private final LoyaltyProgramAccrualRuleItemVariationData itemVariationData;
    private final LoyaltyProgramAccrualRuleCategoryData categoryData;

    /**
     * Initialization constructor.
     * @param  accrualType  String value for accrualType.
     * @param  points  Integer value for points.
     * @param  visitData  LoyaltyProgramAccrualRuleVisitData value for visitData.
     * @param  spendData  LoyaltyProgramAccrualRuleSpendData value for spendData.
     * @param  itemVariationData  LoyaltyProgramAccrualRuleItemVariationData value for
     *         itemVariationData.
     * @param  categoryData  LoyaltyProgramAccrualRuleCategoryData value for categoryData.
     */
    @JsonCreator
    public LoyaltyProgramAccrualRule(
            @JsonProperty("accrual_type") String accrualType,
            @JsonProperty("points") Integer points,
            @JsonProperty("visit_data") LoyaltyProgramAccrualRuleVisitData visitData,
            @JsonProperty("spend_data") LoyaltyProgramAccrualRuleSpendData spendData,
            @JsonProperty("item_variation_data") LoyaltyProgramAccrualRuleItemVariationData itemVariationData,
            @JsonProperty("category_data") LoyaltyProgramAccrualRuleCategoryData categoryData) {
        this.accrualType = accrualType;
        this.points = points;
        this.visitData = visitData;
        this.spendData = spendData;
        this.itemVariationData = itemVariationData;
        this.categoryData = categoryData;
    }

    /**
     * Getter for AccrualType.
     * The type of the accrual rule that defines how buyers can earn points.
     * @return Returns the String
     */
    @JsonGetter("accrual_type")
    public String getAccrualType() {
        return accrualType;
    }

    /**
     * Getter for Points.
     * The number of points that buyers earn based on the `accrual_type`.
     * @return Returns the Integer
     */
    @JsonGetter("points")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getPoints() {
        return points;
    }

    /**
     * Getter for VisitData.
     * Represents additional data for rules with the `VISIT` accrual type.
     * @return Returns the LoyaltyProgramAccrualRuleVisitData
     */
    @JsonGetter("visit_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyProgramAccrualRuleVisitData getVisitData() {
        return visitData;
    }

    /**
     * Getter for SpendData.
     * Represents additional data for rules with the `SPEND` accrual type.
     * @return Returns the LoyaltyProgramAccrualRuleSpendData
     */
    @JsonGetter("spend_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyProgramAccrualRuleSpendData getSpendData() {
        return spendData;
    }

    /**
     * Getter for ItemVariationData.
     * Represents additional data for rules with the `ITEM_VARIATION` accrual type.
     * @return Returns the LoyaltyProgramAccrualRuleItemVariationData
     */
    @JsonGetter("item_variation_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyProgramAccrualRuleItemVariationData getItemVariationData() {
        return itemVariationData;
    }

    /**
     * Getter for CategoryData.
     * Represents additional data for rules with the `CATEGORY` accrual type.
     * @return Returns the LoyaltyProgramAccrualRuleCategoryData
     */
    @JsonGetter("category_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyProgramAccrualRuleCategoryData getCategoryData() {
        return categoryData;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accrualType, points, visitData, spendData, itemVariationData,
                categoryData);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyProgramAccrualRule)) {
            return false;
        }
        LoyaltyProgramAccrualRule other = (LoyaltyProgramAccrualRule) obj;
        return Objects.equals(accrualType, other.accrualType)
            && Objects.equals(points, other.points)
            && Objects.equals(visitData, other.visitData)
            && Objects.equals(spendData, other.spendData)
            && Objects.equals(itemVariationData, other.itemVariationData)
            && Objects.equals(categoryData, other.categoryData);
    }

    /**
     * Converts this LoyaltyProgramAccrualRule into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgramAccrualRule [" + "accrualType=" + accrualType + ", points=" + points
                + ", visitData=" + visitData + ", spendData=" + spendData + ", itemVariationData="
                + itemVariationData + ", categoryData=" + categoryData + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramAccrualRule.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramAccrualRule.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(accrualType)
                .points(getPoints())
                .visitData(getVisitData())
                .spendData(getSpendData())
                .itemVariationData(getItemVariationData())
                .categoryData(getCategoryData());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramAccrualRule}.
     */
    public static class Builder {
        private String accrualType;
        private Integer points;
        private LoyaltyProgramAccrualRuleVisitData visitData;
        private LoyaltyProgramAccrualRuleSpendData spendData;
        private LoyaltyProgramAccrualRuleItemVariationData itemVariationData;
        private LoyaltyProgramAccrualRuleCategoryData categoryData;

        /**
         * Initialization constructor.
         * @param  accrualType  String value for accrualType.
         */
        public Builder(String accrualType) {
            this.accrualType = accrualType;
        }

        /**
         * Setter for accrualType.
         * @param  accrualType  String value for accrualType.
         * @return Builder
         */
        public Builder accrualType(String accrualType) {
            this.accrualType = accrualType;
            return this;
        }

        /**
         * Setter for points.
         * @param  points  Integer value for points.
         * @return Builder
         */
        public Builder points(Integer points) {
            this.points = points;
            return this;
        }

        /**
         * Setter for visitData.
         * @param  visitData  LoyaltyProgramAccrualRuleVisitData value for visitData.
         * @return Builder
         */
        public Builder visitData(LoyaltyProgramAccrualRuleVisitData visitData) {
            this.visitData = visitData;
            return this;
        }

        /**
         * Setter for spendData.
         * @param  spendData  LoyaltyProgramAccrualRuleSpendData value for spendData.
         * @return Builder
         */
        public Builder spendData(LoyaltyProgramAccrualRuleSpendData spendData) {
            this.spendData = spendData;
            return this;
        }

        /**
         * Setter for itemVariationData.
         * @param  itemVariationData  LoyaltyProgramAccrualRuleItemVariationData value for
         *         itemVariationData.
         * @return Builder
         */
        public Builder itemVariationData(
                LoyaltyProgramAccrualRuleItemVariationData itemVariationData) {
            this.itemVariationData = itemVariationData;
            return this;
        }

        /**
         * Setter for categoryData.
         * @param  categoryData  LoyaltyProgramAccrualRuleCategoryData value for categoryData.
         * @return Builder
         */
        public Builder categoryData(LoyaltyProgramAccrualRuleCategoryData categoryData) {
            this.categoryData = categoryData;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgramAccrualRule} object using the set fields.
         * @return {@link LoyaltyProgramAccrualRule}
         */
        public LoyaltyProgramAccrualRule build() {
            return new LoyaltyProgramAccrualRule(accrualType, points, visitData, spendData,
                    itemVariationData, categoryData);
        }
    }
}
