
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramAccrualRuleSpendData type.
 */
public class LoyaltyProgramAccrualRuleSpendData {
    private final Money amountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> excludedCategoryIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> excludedItemVariationIds;
    private final String taxMode;

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     * @param  taxMode  String value for taxMode.
     * @param  excludedCategoryIds  List of String value for excludedCategoryIds.
     * @param  excludedItemVariationIds  List of String value for excludedItemVariationIds.
     */
    @JsonCreator
    public LoyaltyProgramAccrualRuleSpendData(
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("tax_mode") String taxMode,
            @JsonProperty("excluded_category_ids") List<String> excludedCategoryIds,
            @JsonProperty("excluded_item_variation_ids") List<String> excludedItemVariationIds) {
        this.amountMoney = amountMoney;
        this.excludedCategoryIds = excludedCategoryIds;
        this.excludedItemVariationIds = excludedItemVariationIds;
        this.taxMode = taxMode;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for ExcludedCategoryIds.
     * The IDs of any `CATEGORY` catalog objects that are excluded from points accrual. You can use
     * the [BatchRetrieveCatalogObjects]($e/Catalog/BatchRetrieveCatalogObjects) endpoint to
     * retrieve information about the excluded categories.
     * @return Returns the List of String
     */
    @JsonGetter("excluded_category_ids")
    public List<String> getExcludedCategoryIds() {
        return excludedCategoryIds;
    }

    /**
     * Getter for ExcludedItemVariationIds.
     * The IDs of any `ITEM_VARIATION` catalog objects that are excluded from points accrual. You
     * can use the [BatchRetrieveCatalogObjects]($e/Catalog/BatchRetrieveCatalogObjects) endpoint to
     * retrieve information about the excluded item variations.
     * @return Returns the List of String
     */
    @JsonGetter("excluded_item_variation_ids")
    public List<String> getExcludedItemVariationIds() {
        return excludedItemVariationIds;
    }

    /**
     * Getter for TaxMode.
     * Indicates how taxes should be treated when calculating the purchase amount used for loyalty
     * points accrual. This setting applies only to `SPEND` accrual rules or `VISIT` accrual rules
     * that have a minimum spend requirement.
     * @return Returns the String
     */
    @JsonGetter("tax_mode")
    public String getTaxMode() {
        return taxMode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountMoney, excludedCategoryIds, excludedItemVariationIds, taxMode);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyProgramAccrualRuleSpendData)) {
            return false;
        }
        LoyaltyProgramAccrualRuleSpendData other = (LoyaltyProgramAccrualRuleSpendData) obj;
        return Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(excludedCategoryIds, other.excludedCategoryIds)
            && Objects.equals(excludedItemVariationIds, other.excludedItemVariationIds)
            && Objects.equals(taxMode, other.taxMode);
    }

    /**
     * Converts this LoyaltyProgramAccrualRuleSpendData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgramAccrualRuleSpendData [" + "amountMoney=" + amountMoney + ", taxMode="
                + taxMode + ", excludedCategoryIds=" + excludedCategoryIds
                + ", excludedItemVariationIds=" + excludedItemVariationIds + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramAccrualRuleSpendData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramAccrualRuleSpendData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(amountMoney, taxMode)
                .excludedCategoryIds(getExcludedCategoryIds())
                .excludedItemVariationIds(getExcludedItemVariationIds());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramAccrualRuleSpendData}.
     */
    public static class Builder {
        private Money amountMoney;
        private String taxMode;
        private List<String> excludedCategoryIds;
        private List<String> excludedItemVariationIds;

        /**
         * Initialization constructor.
         * @param  amountMoney  Money value for amountMoney.
         * @param  taxMode  String value for taxMode.
         */
        public Builder(Money amountMoney, String taxMode) {
            this.amountMoney = amountMoney;
            this.taxMode = taxMode;
        }

        /**
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for taxMode.
         * @param  taxMode  String value for taxMode.
         * @return Builder
         */
        public Builder taxMode(String taxMode) {
            this.taxMode = taxMode;
            return this;
        }

        /**
         * Setter for excludedCategoryIds.
         * @param  excludedCategoryIds  List of String value for excludedCategoryIds.
         * @return Builder
         */
        public Builder excludedCategoryIds(List<String> excludedCategoryIds) {
            this.excludedCategoryIds = excludedCategoryIds;
            return this;
        }

        /**
         * Setter for excludedItemVariationIds.
         * @param  excludedItemVariationIds  List of String value for excludedItemVariationIds.
         * @return Builder
         */
        public Builder excludedItemVariationIds(List<String> excludedItemVariationIds) {
            this.excludedItemVariationIds = excludedItemVariationIds;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgramAccrualRuleSpendData} object using the set fields.
         * @return {@link LoyaltyProgramAccrualRuleSpendData}
         */
        public LoyaltyProgramAccrualRuleSpendData build() {
            return new LoyaltyProgramAccrualRuleSpendData(amountMoney, taxMode, excludedCategoryIds,
                    excludedItemVariationIds);
        }
    }
}
