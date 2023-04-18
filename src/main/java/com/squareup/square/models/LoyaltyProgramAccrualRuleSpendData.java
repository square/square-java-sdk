
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramAccrualRuleSpendData type.
 */
public class LoyaltyProgramAccrualRuleSpendData {
    private final Money amountMoney;
    private final OptionalNullable<List<String>> excludedCategoryIds;
    private final OptionalNullable<List<String>> excludedItemVariationIds;
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
        this.excludedCategoryIds = OptionalNullable.of(excludedCategoryIds);
        this.excludedItemVariationIds = OptionalNullable.of(excludedItemVariationIds);
        this.taxMode = taxMode;
    }

    /**
     * Internal initialization constructor.
     */
    protected LoyaltyProgramAccrualRuleSpendData(Money amountMoney, String taxMode,
            OptionalNullable<List<String>> excludedCategoryIds,
            OptionalNullable<List<String>> excludedItemVariationIds) {
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
     * Internal Getter for ExcludedCategoryIds.
     * The IDs of any `CATEGORY` catalog objects that are excluded from points accrual. You can use
     * the [BatchRetrieveCatalogObjects](api-endpoint:Catalog-BatchRetrieveCatalogObjects) endpoint
     * to retrieve information about the excluded categories.
     * @return Returns the Internal List of String
     */
    @JsonGetter("excluded_category_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetExcludedCategoryIds() {
        return this.excludedCategoryIds;
    }

    /**
     * Getter for ExcludedCategoryIds.
     * The IDs of any `CATEGORY` catalog objects that are excluded from points accrual. You can use
     * the [BatchRetrieveCatalogObjects](api-endpoint:Catalog-BatchRetrieveCatalogObjects) endpoint
     * to retrieve information about the excluded categories.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getExcludedCategoryIds() {
        return OptionalNullable.getFrom(excludedCategoryIds);
    }

    /**
     * Internal Getter for ExcludedItemVariationIds.
     * The IDs of any `ITEM_VARIATION` catalog objects that are excluded from points accrual. You
     * can use the [BatchRetrieveCatalogObjects](api-endpoint:Catalog-BatchRetrieveCatalogObjects)
     * endpoint to retrieve information about the excluded item variations.
     * @return Returns the Internal List of String
     */
    @JsonGetter("excluded_item_variation_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetExcludedItemVariationIds() {
        return this.excludedItemVariationIds;
    }

    /**
     * Getter for ExcludedItemVariationIds.
     * The IDs of any `ITEM_VARIATION` catalog objects that are excluded from points accrual. You
     * can use the [BatchRetrieveCatalogObjects](api-endpoint:Catalog-BatchRetrieveCatalogObjects)
     * endpoint to retrieve information about the excluded item variations.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getExcludedItemVariationIds() {
        return OptionalNullable.getFrom(excludedItemVariationIds);
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
        Builder builder = new Builder(amountMoney, taxMode);
        builder.excludedCategoryIds = internalGetExcludedCategoryIds();
        builder.excludedItemVariationIds = internalGetExcludedItemVariationIds();
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramAccrualRuleSpendData}.
     */
    public static class Builder {
        private Money amountMoney;
        private String taxMode;
        private OptionalNullable<List<String>> excludedCategoryIds;
        private OptionalNullable<List<String>> excludedItemVariationIds;

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
            this.excludedCategoryIds = OptionalNullable.of(excludedCategoryIds);
            return this;
        }

        /**
         * UnSetter for excludedCategoryIds.
         * @return Builder
         */
        public Builder unsetExcludedCategoryIds() {
            excludedCategoryIds = null;
            return this;
        }

        /**
         * Setter for excludedItemVariationIds.
         * @param  excludedItemVariationIds  List of String value for excludedItemVariationIds.
         * @return Builder
         */
        public Builder excludedItemVariationIds(List<String> excludedItemVariationIds) {
            this.excludedItemVariationIds = OptionalNullable.of(excludedItemVariationIds);
            return this;
        }

        /**
         * UnSetter for excludedItemVariationIds.
         * @return Builder
         */
        public Builder unsetExcludedItemVariationIds() {
            excludedItemVariationIds = null;
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
