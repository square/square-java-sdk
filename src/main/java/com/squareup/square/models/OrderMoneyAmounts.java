package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderMoneyAmounts {

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

    private final Money totalMoney;
    private final Money taxMoney;
    private final Money discountMoney;
    private final Money tipMoney;
    private final Money serviceChargeMoney;

    @Override
    public int hashCode() {
        return Objects.hash(totalMoney, taxMoney, discountMoney, tipMoney, serviceChargeMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderMoneyAmounts)) {
            return false;
        }
        OrderMoneyAmounts orderMoneyAmounts = (OrderMoneyAmounts) o;
        return Objects.equals(totalMoney, orderMoneyAmounts.totalMoney) &&
            Objects.equals(taxMoney, orderMoneyAmounts.taxMoney) &&
            Objects.equals(discountMoney, orderMoneyAmounts.discountMoney) &&
            Objects.equals(tipMoney, orderMoneyAmounts.tipMoney) &&
            Objects.equals(serviceChargeMoney, orderMoneyAmounts.serviceChargeMoney);
    }

    /**
     * Getter for TotalMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("total_money")
    public Money getTotalMoney() { 
        return this.totalMoney;
    }

    /**
     * Getter for TaxMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("tax_money")
    public Money getTaxMoney() { 
        return this.taxMoney;
    }

    /**
     * Getter for DiscountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("discount_money")
    public Money getDiscountMoney() { 
        return this.discountMoney;
    }

    /**
     * Getter for TipMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("tip_money")
    public Money getTipMoney() { 
        return this.tipMoney;
    }

    /**
     * Getter for ServiceChargeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("service_charge_money")
    public Money getServiceChargeMoney() { 
        return this.serviceChargeMoney;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .totalMoney(getTotalMoney())
            .taxMoney(getTaxMoney())
            .discountMoney(getDiscountMoney())
            .tipMoney(getTipMoney())
            .serviceChargeMoney(getServiceChargeMoney());
            return builder;
    }

    public static class Builder {
        private Money totalMoney;
        private Money taxMoney;
        private Money discountMoney;
        private Money tipMoney;
        private Money serviceChargeMoney;

        public Builder() { }

        public Builder totalMoney(Money value) {
            totalMoney = value;
            return this;
        }
        public Builder taxMoney(Money value) {
            taxMoney = value;
            return this;
        }
        public Builder discountMoney(Money value) {
            discountMoney = value;
            return this;
        }
        public Builder tipMoney(Money value) {
            tipMoney = value;
            return this;
        }
        public Builder serviceChargeMoney(Money value) {
            serviceChargeMoney = value;
            return this;
        }

        public OrderMoneyAmounts build() {
            return new OrderMoneyAmounts(totalMoney,
                taxMoney,
                discountMoney,
                tipMoney,
                serviceChargeMoney);
        }
    }
}
