
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramAccrualRule type.
 */
public class LoyaltyProgramAccrualRule {
    private final String accrualType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer points;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money visitMinimumAmountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money spendAmountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String catalogObjectId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> excludedCategoryIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> excludedItemVariationIds;

    /**
     * Initialization constructor.
     * @param  accrualType  String value for accrualType.
     * @param  points  Integer value for points.
     * @param  visitMinimumAmountMoney  Money value for visitMinimumAmountMoney.
     * @param  spendAmountMoney  Money value for spendAmountMoney.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  excludedCategoryIds  List of String value for excludedCategoryIds.
     * @param  excludedItemVariationIds  List of String value for excludedItemVariationIds.
     */
    @JsonCreator
    public LoyaltyProgramAccrualRule(
            @JsonProperty("accrual_type") String accrualType,
            @JsonProperty("points") Integer points,
            @JsonProperty("visit_minimum_amount_money") Money visitMinimumAmountMoney,
            @JsonProperty("spend_amount_money") Money spendAmountMoney,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("excluded_category_ids") List<String> excludedCategoryIds,
            @JsonProperty("excluded_item_variation_ids") List<String> excludedItemVariationIds) {
        this.accrualType = accrualType;
        this.points = points;
        this.visitMinimumAmountMoney = visitMinimumAmountMoney;
        this.spendAmountMoney = spendAmountMoney;
        this.catalogObjectId = catalogObjectId;
        this.excludedCategoryIds = excludedCategoryIds;
        this.excludedItemVariationIds = excludedItemVariationIds;
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
    public Integer getPoints() {
        return points;
    }

    /**
     * Getter for VisitMinimumAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("visit_minimum_amount_money")
    public Money getVisitMinimumAmountMoney() {
        return visitMinimumAmountMoney;
    }

    /**
     * Getter for SpendAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("spend_amount_money")
    public Money getSpendAmountMoney() {
        return spendAmountMoney;
    }

    /**
     * Getter for CatalogObjectId.
     * When the accrual rule is item-based or category-based, this field specifies the ID of the
     * [catalog object]($m/CatalogObject) that buyers can purchase to earn points. If `accrual_type`
     * is `ITEM_VARIATION`, the object is an item variation. If `accrual_type` is `CATEGORY`, the
     * object is a category.
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return catalogObjectId;
    }

    /**
     * Getter for ExcludedCategoryIds.
     * When the accrual rule is spend-based (`accrual_type` is `SPEND`), this field lists the IDs of
     * any `CATEGORY` catalog objects that are excluded from points accrual. You can use the
     * [BatchRetrieveCatalogObjects]($e/Catalog/BatchRetrieveCatalogObjects) endpoint to retrieve
     * information about the excluded categories.
     * @return Returns the List of String
     */
    @JsonGetter("excluded_category_ids")
    public List<String> getExcludedCategoryIds() {
        return excludedCategoryIds;
    }

    /**
     * Getter for ExcludedItemVariationIds.
     * When the accrual rule is spend-based (`accrual_type` is `SPEND`), this field lists the IDs of
     * any `ITEM_VARIATION` catalog objects that are excluded from points accrual. You can use the
     * [BatchRetrieveCatalogObjects]($e/Catalog/BatchRetrieveCatalogObjects) endpoint to retrieve
     * information about the excluded item variations.
     * @return Returns the List of String
     */
    @JsonGetter("excluded_item_variation_ids")
    public List<String> getExcludedItemVariationIds() {
        return excludedItemVariationIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accrualType, points, visitMinimumAmountMoney, spendAmountMoney,
                catalogObjectId, excludedCategoryIds, excludedItemVariationIds);
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
            && Objects.equals(visitMinimumAmountMoney, other.visitMinimumAmountMoney)
            && Objects.equals(spendAmountMoney, other.spendAmountMoney)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(excludedCategoryIds, other.excludedCategoryIds)
            && Objects.equals(excludedItemVariationIds, other.excludedItemVariationIds);
    }

    /**
     * Converts this LoyaltyProgramAccrualRule into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgramAccrualRule [" + "accrualType=" + accrualType + ", points=" + points
                + ", visitMinimumAmountMoney=" + visitMinimumAmountMoney + ", spendAmountMoney="
                + spendAmountMoney + ", catalogObjectId=" + catalogObjectId
                + ", excludedCategoryIds=" + excludedCategoryIds + ", excludedItemVariationIds="
                + excludedItemVariationIds + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramAccrualRule.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramAccrualRule.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(accrualType)
                .points(getPoints())
                .visitMinimumAmountMoney(getVisitMinimumAmountMoney())
                .spendAmountMoney(getSpendAmountMoney())
                .catalogObjectId(getCatalogObjectId())
                .excludedCategoryIds(getExcludedCategoryIds())
                .excludedItemVariationIds(getExcludedItemVariationIds());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramAccrualRule}.
     */
    public static class Builder {
        private String accrualType;
        private Integer points;
        private Money visitMinimumAmountMoney;
        private Money spendAmountMoney;
        private String catalogObjectId;
        private List<String> excludedCategoryIds;
        private List<String> excludedItemVariationIds;

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
         * Setter for visitMinimumAmountMoney.
         * @param  visitMinimumAmountMoney  Money value for visitMinimumAmountMoney.
         * @return Builder
         */
        public Builder visitMinimumAmountMoney(Money visitMinimumAmountMoney) {
            this.visitMinimumAmountMoney = visitMinimumAmountMoney;
            return this;
        }

        /**
         * Setter for spendAmountMoney.
         * @param  spendAmountMoney  Money value for spendAmountMoney.
         * @return Builder
         */
        public Builder spendAmountMoney(Money spendAmountMoney) {
            this.spendAmountMoney = spendAmountMoney;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param  catalogObjectId  String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
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
         * Builds a new {@link LoyaltyProgramAccrualRule} object using the set fields.
         * @return {@link LoyaltyProgramAccrualRule}
         */
        public LoyaltyProgramAccrualRule build() {
            return new LoyaltyProgramAccrualRule(accrualType, points, visitMinimumAmountMoney,
                    spendAmountMoney, catalogObjectId, excludedCategoryIds,
                    excludedItemVariationIds);
        }
    }
}
