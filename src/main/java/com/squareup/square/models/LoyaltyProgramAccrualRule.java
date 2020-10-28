
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for LoyaltyProgramAccrualRule type.
 */
public class LoyaltyProgramAccrualRule {
    private final String accrualType;
    private final Integer points;
    private final Money visitMinimumAmountMoney;
    private final Money spendAmountMoney;
    private final String catalogObjectId;

    /**
     * Initialization constructor.
     * @param accrualType String value for accrualType.
     * @param points Integer value for points.
     * @param visitMinimumAmountMoney Money value for visitMinimumAmountMoney.
     * @param spendAmountMoney Money value for spendAmountMoney.
     * @param catalogObjectId String value for catalogObjectId.
     */
    @JsonCreator
    public LoyaltyProgramAccrualRule(
            @JsonProperty("accrual_type") String accrualType,
            @JsonProperty("points") Integer points,
            @JsonProperty("visit_minimum_amount_money") Money visitMinimumAmountMoney,
            @JsonProperty("spend_amount_money") Money spendAmountMoney,
            @JsonProperty("catalog_object_id") String catalogObjectId) {
        this.accrualType = accrualType;
        this.points = points;
        this.visitMinimumAmountMoney = visitMinimumAmountMoney;
        this.spendAmountMoney = spendAmountMoney;
        this.catalogObjectId = catalogObjectId;
    }

    /**
     * Getter for AccrualType.
     * The type of the accrual rule that defines how buyers can earn points.
     * @return Returns the String
     */
    @JsonGetter("accrual_type")
    public String getAccrualType() {
        return this.accrualType;
    }

    /**
     * Getter for Points.
     * The number of points that buyers earn based on the `accrual_type`.
     * @return Returns the Integer
     */
    @JsonGetter("points")
    public Integer getPoints() {
        return this.points;
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
        return this.visitMinimumAmountMoney;
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
        return this.spendAmountMoney;
    }

    /**
     * Getter for CatalogObjectId.
     * The ID of the [catalog object](#type-CatalogObject) to purchase to earn the number of points
     * defined by the rule. This is either an item variation or a category, depending on the type.
     * This is defined on `ITEM_VARIATION` rules and `CATEGORY` rules.
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(accrualType, points, visitMinimumAmountMoney, spendAmountMoney,
                catalogObjectId);
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
            && Objects.equals(catalogObjectId, other.catalogObjectId);
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
            .catalogObjectId(getCatalogObjectId());
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

        /**
         * Initialization constructor.
         * @param accrualType String value for accrualType.
         */
        public Builder(String accrualType) {
            this.accrualType = accrualType;
        }

        /**
         * Setter for accrualType.
         * @param accrualType String value for accrualType.
         * @return Builder
         */
        public Builder accrualType(String accrualType) {
            this.accrualType = accrualType;
            return this;
        }

        /**
         * Setter for points.
         * @param points Integer value for points.
         * @return Builder
         */
        public Builder points(Integer points) {
            this.points = points;
            return this;
        }

        /**
         * Setter for visitMinimumAmountMoney.
         * @param visitMinimumAmountMoney Money value for visitMinimumAmountMoney.
         * @return Builder
         */
        public Builder visitMinimumAmountMoney(Money visitMinimumAmountMoney) {
            this.visitMinimumAmountMoney = visitMinimumAmountMoney;
            return this;
        }

        /**
         * Setter for spendAmountMoney.
         * @param spendAmountMoney Money value for spendAmountMoney.
         * @return Builder
         */
        public Builder spendAmountMoney(Money spendAmountMoney) {
            this.spendAmountMoney = spendAmountMoney;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param catalogObjectId String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgramAccrualRule} object using the set fields.
         * @return {@link LoyaltyProgramAccrualRule}
         */
        public LoyaltyProgramAccrualRule build() {
            return new LoyaltyProgramAccrualRule(accrualType,
                points,
                visitMinimumAmountMoney,
                spendAmountMoney,
                catalogObjectId);
        }
    }
}
