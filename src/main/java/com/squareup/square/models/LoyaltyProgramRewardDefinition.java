package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyProgramRewardDefinition type.
 */
public class LoyaltyProgramRewardDefinition {

    /**
     * Initialization constructor.
     * @param scope
     * @param discountType
     * @param percentageDiscount
     * @param catalogObjectIds
     * @param fixedDiscountMoney
     * @param maxDiscountMoney
     */
    @JsonCreator
    public LoyaltyProgramRewardDefinition(
            @JsonProperty("scope") String scope,
            @JsonProperty("discount_type") String discountType,
            @JsonProperty("percentage_discount") String percentageDiscount,
            @JsonProperty("catalog_object_ids") List<String> catalogObjectIds,
            @JsonProperty("fixed_discount_money") Money fixedDiscountMoney,
            @JsonProperty("max_discount_money") Money maxDiscountMoney) {
        this.scope = scope;
        this.discountType = discountType;
        this.percentageDiscount = percentageDiscount;
        this.catalogObjectIds = catalogObjectIds;
        this.fixedDiscountMoney = fixedDiscountMoney;
        this.maxDiscountMoney = maxDiscountMoney;
    }

    private final String scope;
    private final String discountType;
    private final String percentageDiscount;
    private final List<String> catalogObjectIds;
    private final Money fixedDiscountMoney;
    private final Money maxDiscountMoney;
    /**
     * Getter for Scope.
     * Indicates the scope of the reward tier.
     */
    @JsonGetter("scope")
    public String getScope() {
        return this.scope;
    }

    /**
     * Getter for DiscountType.
     * The type of discount the reward tier offers.
     */
    @JsonGetter("discount_type")
    public String getDiscountType() {
        return this.discountType;
    }

    /**
     * Getter for PercentageDiscount.
     * Present if `discount_type` is `FIXED_PERCENTAGE`.
     * For example, a 7.25% off discount will be represented as "7.25".
     */
    @JsonGetter("percentage_discount")
    public String getPercentageDiscount() {
        return this.percentageDiscount;
    }

    /**
     * Getter for CatalogObjectIds.
     * A list of [catalog object](#type-CatalogObject) ids to which this reward can be applied. They are either all item-variation ids or category ids, depending on the `type` field.
     */
    @JsonGetter("catalog_object_ids")
    public List<String> getCatalogObjectIds() {
        return this.catalogObjectIds;
    }

    /**
     * Getter for FixedDiscountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("fixed_discount_money")
    public Money getFixedDiscountMoney() {
        return this.fixedDiscountMoney;
    }

    /**
     * Getter for MaxDiscountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("max_discount_money")
    public Money getMaxDiscountMoney() {
        return this.maxDiscountMoney;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(scope, discountType, percentageDiscount, catalogObjectIds,
            fixedDiscountMoney, maxDiscountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyProgramRewardDefinition)) {
            return false;
        }
        LoyaltyProgramRewardDefinition loyaltyProgramRewardDefinition = (LoyaltyProgramRewardDefinition) obj;
        return Objects.equals(scope, loyaltyProgramRewardDefinition.scope) &&
            Objects.equals(discountType, loyaltyProgramRewardDefinition.discountType) &&
            Objects.equals(percentageDiscount, loyaltyProgramRewardDefinition.percentageDiscount) &&
            Objects.equals(catalogObjectIds, loyaltyProgramRewardDefinition.catalogObjectIds) &&
            Objects.equals(fixedDiscountMoney, loyaltyProgramRewardDefinition.fixedDiscountMoney) &&
            Objects.equals(maxDiscountMoney, loyaltyProgramRewardDefinition.maxDiscountMoney);
    }

    /**
     * Builds a new {@link LoyaltyProgramRewardDefinition.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramRewardDefinition.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(scope,
            discountType)
            .percentageDiscount(getPercentageDiscount())
            .catalogObjectIds(getCatalogObjectIds())
            .fixedDiscountMoney(getFixedDiscountMoney())
            .maxDiscountMoney(getMaxDiscountMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramRewardDefinition}
     */
    public static class Builder {
        private String scope;
        private String discountType;
        private String percentageDiscount;
        private List<String> catalogObjectIds;
        private Money fixedDiscountMoney;
        private Money maxDiscountMoney;

        /**
         * Initialization constructor
         */
        public Builder(String scope,
                String discountType) {
            this.scope = scope;
            this.discountType = discountType;
        }

        /**
         * Setter for scope
         * @param scope
         * @return Builder
         */
        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }
        /**
         * Setter for discountType
         * @param discountType
         * @return Builder
         */
        public Builder discountType(String discountType) {
            this.discountType = discountType;
            return this;
        }
        /**
         * Setter for percentageDiscount
         * @param percentageDiscount
         * @return Builder
         */
        public Builder percentageDiscount(String percentageDiscount) {
            this.percentageDiscount = percentageDiscount;
            return this;
        }
        /**
         * Setter for catalogObjectIds
         * @param catalogObjectIds
         * @return Builder
         */
        public Builder catalogObjectIds(List<String> catalogObjectIds) {
            this.catalogObjectIds = catalogObjectIds;
            return this;
        }
        /**
         * Setter for fixedDiscountMoney
         * @param fixedDiscountMoney
         * @return Builder
         */
        public Builder fixedDiscountMoney(Money fixedDiscountMoney) {
            this.fixedDiscountMoney = fixedDiscountMoney;
            return this;
        }
        /**
         * Setter for maxDiscountMoney
         * @param maxDiscountMoney
         * @return Builder
         */
        public Builder maxDiscountMoney(Money maxDiscountMoney) {
            this.maxDiscountMoney = maxDiscountMoney;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgramRewardDefinition} object using the set fields.
         * @return {@link LoyaltyProgramRewardDefinition}
         */
        public LoyaltyProgramRewardDefinition build() {
            return new LoyaltyProgramRewardDefinition(scope,
                discountType,
                percentageDiscount,
                catalogObjectIds,
                fixedDiscountMoney,
                maxDiscountMoney);
        }
    }
}
