package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderRoundingAdjustment {

    @JsonCreator
    public OrderRoundingAdjustment(
            @JsonProperty("uid") String uid,
            @JsonProperty("name") String name,
            @JsonProperty("amount_money") Money amountMoney) {
        this.uid = uid;
        this.name = name;
        this.amountMoney = amountMoney;
    }

    private final String uid;
    private final String name;
    private final Money amountMoney;

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, amountMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderRoundingAdjustment)) {
            return false;
        }
        OrderRoundingAdjustment orderRoundingAdjustment = (OrderRoundingAdjustment) o;
        return Objects.equals(uid, orderRoundingAdjustment.uid) &&
            Objects.equals(name, orderRoundingAdjustment.name) &&
            Objects.equals(amountMoney, orderRoundingAdjustment.amountMoney);
    }

    /**
     * Getter for Uid.
     * Unique ID that identifies the rounding adjustment only within this order.
     */
    @JsonGetter("uid")
    public String getUid() { 
        return this.uid;
    }

    /**
     * Getter for Name.
     * The name of the rounding adjustment from the original sale Order.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() { 
        return this.amountMoney;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .name(getName())
            .amountMoney(getAmountMoney());
            return builder;
    }

    public static class Builder {
        private String uid;
        private String name;
        private Money amountMoney;

        public Builder() { }

        public Builder uid(String value) {
            uid = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }

        public OrderRoundingAdjustment build() {
            return new OrderRoundingAdjustment(uid,
                name,
                amountMoney);
        }
    }
}
