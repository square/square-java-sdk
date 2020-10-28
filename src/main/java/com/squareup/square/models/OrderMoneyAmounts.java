
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for OrderMoneyAmounts type.
 */
public class OrderMoneyAmounts {
    private final Money totalMoney;
    private final Money taxMoney;
    private final Money discountMoney;
    private final Money tipMoney;
    private final Money serviceChargeMoney;

    /**
     * Initialization constructor.
     * @param totalMoney Money value for totalMoney.
     * @param taxMoney Money value for taxMoney.
     * @param discountMoney Money value for discountMoney.
     * @param tipMoney Money value for tipMoney.
     * @param serviceChargeMoney Money value for serviceChargeMoney.
     */
    @JsonCreator
    public OrderMoneyAmounts(
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("tax_money") Money taxMoney,
            @JsonProperty("discount_money") Money discountMoney,
            @JsonProperty("tip_money") Money tipMoney,
            @JsonProperty("service_charge_money") Money serviceChargeMoney) {
        this.totalMoney = totalMoney;
        this.taxMoney = taxMoney;
        this.discountMoney = discountMoney;
        this.tipMoney = tipMoney;
        this.serviceChargeMoney = serviceChargeMoney;
    }

    /**
     * Getter for TotalMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_money")
    public Money getTotalMoney() {
        return this.totalMoney;
    }

    /**
     * Getter for TaxMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("tax_money")
    public Money getTaxMoney() {
        return this.taxMoney;
    }

    /**
     * Getter for DiscountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("discount_money")
    public Money getDiscountMoney() {
        return this.discountMoney;
    }

    /**
     * Getter for TipMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("tip_money")
    public Money getTipMoney() {
        return this.tipMoney;
    }

    /**
     * Getter for ServiceChargeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("service_charge_money")
    public Money getServiceChargeMoney() {
        return this.serviceChargeMoney;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(totalMoney, taxMoney, discountMoney, tipMoney, serviceChargeMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderMoneyAmounts)) {
            return false;
        }
        OrderMoneyAmounts other = (OrderMoneyAmounts) obj;
        return Objects.equals(totalMoney, other.totalMoney)
            && Objects.equals(taxMoney, other.taxMoney)
            && Objects.equals(discountMoney, other.discountMoney)
            && Objects.equals(tipMoney, other.tipMoney)
            && Objects.equals(serviceChargeMoney, other.serviceChargeMoney);
    }

    /**
     * Builds a new {@link OrderMoneyAmounts.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderMoneyAmounts.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .totalMoney(getTotalMoney())
            .taxMoney(getTaxMoney())
            .discountMoney(getDiscountMoney())
            .tipMoney(getTipMoney())
            .serviceChargeMoney(getServiceChargeMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderMoneyAmounts}.
     */
    public static class Builder {
        private Money totalMoney;
        private Money taxMoney;
        private Money discountMoney;
        private Money tipMoney;
        private Money serviceChargeMoney;



        /**
         * Setter for totalMoney.
         * @param totalMoney Money value for totalMoney.
         * @return Builder
         */
        public Builder totalMoney(Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        /**
         * Setter for taxMoney.
         * @param taxMoney Money value for taxMoney.
         * @return Builder
         */
        public Builder taxMoney(Money taxMoney) {
            this.taxMoney = taxMoney;
            return this;
        }

        /**
         * Setter for discountMoney.
         * @param discountMoney Money value for discountMoney.
         * @return Builder
         */
        public Builder discountMoney(Money discountMoney) {
            this.discountMoney = discountMoney;
            return this;
        }

        /**
         * Setter for tipMoney.
         * @param tipMoney Money value for tipMoney.
         * @return Builder
         */
        public Builder tipMoney(Money tipMoney) {
            this.tipMoney = tipMoney;
            return this;
        }

        /**
         * Setter for serviceChargeMoney.
         * @param serviceChargeMoney Money value for serviceChargeMoney.
         * @return Builder
         */
        public Builder serviceChargeMoney(Money serviceChargeMoney) {
            this.serviceChargeMoney = serviceChargeMoney;
            return this;
        }

        /**
         * Builds a new {@link OrderMoneyAmounts} object using the set fields.
         * @return {@link OrderMoneyAmounts}
         */
        public OrderMoneyAmounts build() {
            return new OrderMoneyAmounts(totalMoney,
                taxMoney,
                discountMoney,
                tipMoney,
                serviceChargeMoney);
        }
    }
}
