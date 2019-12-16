package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class TenderCashDetails {

    @JsonCreator
    public TenderCashDetails(
            @JsonProperty("buyer_tendered_money") Money buyerTenderedMoney,
            @JsonProperty("change_back_money") Money changeBackMoney) {
        this.buyerTenderedMoney = buyerTenderedMoney;
        this.changeBackMoney = changeBackMoney;
    }

    private final Money buyerTenderedMoney;
    private final Money changeBackMoney;

    @Override
    public int hashCode() {
        return Objects.hash(buyerTenderedMoney, changeBackMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TenderCashDetails)) {
            return false;
        }
        TenderCashDetails tenderCashDetails = (TenderCashDetails) o;
        return Objects.equals(buyerTenderedMoney, tenderCashDetails.buyerTenderedMoney) &&
            Objects.equals(changeBackMoney, tenderCashDetails.changeBackMoney);
    }

    /**
     * Getter for BuyerTenderedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("buyer_tendered_money")
    public Money getBuyerTenderedMoney() { 
        return this.buyerTenderedMoney;
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
        Builder builder = new Builder()
            .buyerTenderedMoney(getBuyerTenderedMoney())
            .changeBackMoney(getChangeBackMoney());
            return builder;
    }

    public static class Builder {
        private Money buyerTenderedMoney;
        private Money changeBackMoney;

        public Builder() { }

        public Builder buyerTenderedMoney(Money value) {
            buyerTenderedMoney = value;
            return this;
        }
        public Builder changeBackMoney(Money value) {
            changeBackMoney = value;
            return this;
        }

        public TenderCashDetails build() {
            return new TenderCashDetails(buyerTenderedMoney,
                changeBackMoney);
        }
    }
}
