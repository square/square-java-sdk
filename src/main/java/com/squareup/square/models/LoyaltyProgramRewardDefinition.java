
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramRewardDefinition type.
 */
public class LoyaltyProgramRewardDefinition {
    private final String scope;
    private final String discountType;
    private final String percentageDiscount;
    private final List<String> catalogObjectIds;
    private final Money fixedDiscountMoney;
    private final Money maxDiscountMoney;

    /**
     * Initialization constructor.
     * @param  scope  String value for scope.
     * @param  discountType  String value for discountType.
     * @param  percentageDiscount  String value for percentageDiscount.
     * @param  catalogObjectIds  List of String value for catalogObjectIds.
     * @param  fixedDiscountMoney  Money value for fixedDiscountMoney.
     * @param  maxDiscountMoney  Money value for maxDiscountMoney.
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

    /**
     * Getter for Scope.
     * Indicates the scope of the reward tier. DEPRECATED at version 2020-12-16. Discount details
     * are now defined using a catalog pricing rule and other catalog objects. For more information,
     * see [Get discount details for the
     * reward](https://developer.squareup.com/docs/loyalty-api/overview#get-discount-details).
     * @return Returns the String
     */
    @JsonGetter("scope")
    public String getScope() {
        return scope;
    }

    /**
     * Getter for DiscountType.
     * The type of discount the reward tier offers. DEPRECATED at version 2020-12-16. Discount
     * details are now defined using a catalog pricing rule and other catalog objects. For more
     * information, see [Get discount details for the
     * reward](https://developer.squareup.com/docs/loyalty-api/overview#get-discount-details).
     * @return Returns the String
     */
    @JsonGetter("discount_type")
    public String getDiscountType() {
        return discountType;
    }

    /**
     * Getter for PercentageDiscount.
     * The fixed percentage of the discount. Present if `discount_type` is `FIXED_PERCENTAGE`. For
     * example, a 7.25% off discount will be represented as "7.25". DEPRECATED at version
     * 2020-12-16. You can find this information in the `discount_data.percentage` field of the
     * `DISCOUNT` catalog object referenced by the pricing rule.
     * @return Returns the String
     */
    @JsonGetter("percentage_discount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPercentageDiscount() {
        return percentageDiscount;
    }

    /**
     * Getter for CatalogObjectIds.
     * The list of catalog objects to which this reward can be applied. They are either all
     * item-variation ids or category ids, depending on the `type` field. DEPRECATED at version
     * 2020-12-16. You can find this information in the `product_set_data.product_ids_any` field of
     * the `PRODUCT_SET` catalog object referenced by the pricing rule.
     * @return Returns the List of String
     */
    @JsonGetter("catalog_object_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getCatalogObjectIds() {
        return catalogObjectIds;
    }

    /**
     * Getter for FixedDiscountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("fixed_discount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getFixedDiscountMoney() {
        return fixedDiscountMoney;
    }

    /**
     * Getter for MaxDiscountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("max_discount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getMaxDiscountMoney() {
        return maxDiscountMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope, discountType, percentageDiscount, catalogObjectIds,
                fixedDiscountMoney, maxDiscountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyProgramRewardDefinition)) {
            return false;
        }
        LoyaltyProgramRewardDefinition other = (LoyaltyProgramRewardDefinition) obj;
        return Objects.equals(scope, other.scope)
            && Objects.equals(discountType, other.discountType)
            && Objects.equals(percentageDiscount, other.percentageDiscount)
            && Objects.equals(catalogObjectIds, other.catalogObjectIds)
            && Objects.equals(fixedDiscountMoney, other.fixedDiscountMoney)
            && Objects.equals(maxDiscountMoney, other.maxDiscountMoney);
    }

    /**
     * Converts this LoyaltyProgramRewardDefinition into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgramRewardDefinition [" + "scope=" + scope + ", discountType="
                + discountType + ", percentageDiscount=" + percentageDiscount
                + ", catalogObjectIds=" + catalogObjectIds + ", fixedDiscountMoney="
                + fixedDiscountMoney + ", maxDiscountMoney=" + maxDiscountMoney + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramRewardDefinition.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramRewardDefinition.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(scope, discountType)
                .percentageDiscount(getPercentageDiscount())
                .catalogObjectIds(getCatalogObjectIds())
                .fixedDiscountMoney(getFixedDiscountMoney())
                .maxDiscountMoney(getMaxDiscountMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramRewardDefinition}.
     */
    public static class Builder {
        private String scope;
        private String discountType;
        private String percentageDiscount;
        private List<String> catalogObjectIds;
        private Money fixedDiscountMoney;
        private Money maxDiscountMoney;

        /**
         * Initialization constructor.
         * @param  scope  String value for scope.
         * @param  discountType  String value for discountType.
         */
        public Builder(String scope, String discountType) {
            this.scope = scope;
            this.discountType = discountType;
        }

        /**
         * Setter for scope.
         * @param  scope  String value for scope.
         * @return Builder
         */
        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        /**
         * Setter for discountType.
         * @param  discountType  String value for discountType.
         * @return Builder
         */
        public Builder discountType(String discountType) {
            this.discountType = discountType;
            return this;
        }

        /**
         * Setter for percentageDiscount.
         * @param  percentageDiscount  String value for percentageDiscount.
         * @return Builder
         */
        public Builder percentageDiscount(String percentageDiscount) {
            this.percentageDiscount = percentageDiscount;
            return this;
        }

        /**
         * Setter for catalogObjectIds.
         * @param  catalogObjectIds  List of String value for catalogObjectIds.
         * @return Builder
         */
        public Builder catalogObjectIds(List<String> catalogObjectIds) {
            this.catalogObjectIds = catalogObjectIds;
            return this;
        }

        /**
         * Setter for fixedDiscountMoney.
         * @param  fixedDiscountMoney  Money value for fixedDiscountMoney.
         * @return Builder
         */
        public Builder fixedDiscountMoney(Money fixedDiscountMoney) {
            this.fixedDiscountMoney = fixedDiscountMoney;
            return this;
        }

        /**
         * Setter for maxDiscountMoney.
         * @param  maxDiscountMoney  Money value for maxDiscountMoney.
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
            return new LoyaltyProgramRewardDefinition(scope, discountType, percentageDiscount,
                    catalogObjectIds, fixedDiscountMoney, maxDiscountMoney);
        }
    }
}
