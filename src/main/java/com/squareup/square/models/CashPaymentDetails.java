package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CashPaymentDetails {

    @JsonCreator
    public CashPaymentDetails(
            @JsonProperty("buyer_supplied_money") Money buyerSuppliedMoney,
            @JsonProperty("change_back_money") Money changeBackMoney) {
        this.buyerSuppliedMoney = buyerSuppliedMoney;
        this.changeBackMoney = changeBackMoney;
    }

    private final Money buyerSuppliedMoney;
    private final Money changeBackMoney;

    @Override
    public int hashCode() {
        return Objects.hash(buyerSuppliedMoney, changeBackMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CashPaymentDetails)) {
            return false;
        }
        CashPaymentDetails cashPaymentDetails = (CashPaymentDetails) o;
        return Objects.equals(buyerSuppliedMoney, cashPaymentDetails.buyerSuppliedMoney) &&
            Objects.equals(changeBackMoney, cashPaymentDetails.changeBackMoney);
    }

    /**
     * Getter for BuyerSuppliedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("buyer_supplied_money")
    public Money getBuyerSuppliedMoney() { 
        return this.buyerSuppliedMoney;
    }

    /**
     * Getter for ChangeBackMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("change_back_money")
    public Money getChangeBackMoney() { 
        return this.changeBackMoney;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(buyerSuppliedMoney)
            .changeBackMoney(getChangeBackMoney());
            return builder;
    }

    public static class Builder {
        private Money buyerSuppliedMoney;
        private Money changeBackMoney;

        public Builder(Money buyerSuppliedMoney) {
            this.buyerSuppliedMoney = buyerSuppliedMoney;
        }

        public Builder buyerSuppliedMoney(Money value) {
            buyerSuppliedMoney = value;
            return this;
        }
        public Builder changeBackMoney(Money value) {
            changeBackMoney = value;
            return this;
        }

        public CashPaymentDetails build() {
            return new CashPaymentDetails(buyerSuppliedMoney,
                changeBackMoney);
        }
    }
}
