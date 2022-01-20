
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramAccrualRuleVisitData type.
 */
public class LoyaltyProgramAccrualRuleVisitData {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money minimumAmountMoney;
    private final String taxMode;

    /**
     * Initialization constructor.
     * @param  taxMode  String value for taxMode.
     * @param  minimumAmountMoney  Money value for minimumAmountMoney.
     */
    @JsonCreator
    public LoyaltyProgramAccrualRuleVisitData(
            @JsonProperty("tax_mode") String taxMode,
            @JsonProperty("minimum_amount_money") Money minimumAmountMoney) {
        this.minimumAmountMoney = minimumAmountMoney;
        this.taxMode = taxMode;
    }

    /**
     * Getter for MinimumAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("minimum_amount_money")
    public Money getMinimumAmountMoney() {
        return minimumAmountMoney;
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
        return Objects.hash(minimumAmountMoney, taxMode);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyProgramAccrualRuleVisitData)) {
            return false;
        }
        LoyaltyProgramAccrualRuleVisitData other = (LoyaltyProgramAccrualRuleVisitData) obj;
        return Objects.equals(minimumAmountMoney, other.minimumAmountMoney)
            && Objects.equals(taxMode, other.taxMode);
    }

    /**
     * Converts this LoyaltyProgramAccrualRuleVisitData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgramAccrualRuleVisitData [" + "taxMode=" + taxMode
                + ", minimumAmountMoney=" + minimumAmountMoney + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramAccrualRuleVisitData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramAccrualRuleVisitData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(taxMode)
                .minimumAmountMoney(getMinimumAmountMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramAccrualRuleVisitData}.
     */
    public static class Builder {
        private String taxMode;
        private Money minimumAmountMoney;

        /**
         * Initialization constructor.
         * @param  taxMode  String value for taxMode.
         */
        public Builder(String taxMode) {
            this.taxMode = taxMode;
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
         * Setter for minimumAmountMoney.
         * @param  minimumAmountMoney  Money value for minimumAmountMoney.
         * @return Builder
         */
        public Builder minimumAmountMoney(Money minimumAmountMoney) {
            this.minimumAmountMoney = minimumAmountMoney;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgramAccrualRuleVisitData} object using the set fields.
         * @return {@link LoyaltyProgramAccrualRuleVisitData}
         */
        public LoyaltyProgramAccrualRuleVisitData build() {
            return new LoyaltyProgramAccrualRuleVisitData(taxMode, minimumAmountMoney);
        }
    }
}
