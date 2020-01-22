package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderRoundingAdjustment type.
 */
public class OrderRoundingAdjustment {

    /**
     * Initialization constructor.
     * @param uid
     * @param name
     * @param amountMoney
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, name, amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderRoundingAdjustment)) {
            return false;
        }
        OrderRoundingAdjustment orderRoundingAdjustment = (OrderRoundingAdjustment) obj;
        return Objects.equals(uid, orderRoundingAdjustment.uid) &&
            Objects.equals(name, orderRoundingAdjustment.name) &&
            Objects.equals(amountMoney, orderRoundingAdjustment.amountMoney);
    }

    /**
     * Builds a new {@link OrderRoundingAdjustment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderRoundingAdjustment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .name(getName())
            .amountMoney(getAmountMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderRoundingAdjustment}
     */
    public static class Builder {
        private String uid;
        private String name;
        private Money amountMoney;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for uid
         * @param uid
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for amountMoney
         * @param amountMoney
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Builds a new {@link OrderRoundingAdjustment} object using the set fields.
         * @return {@link OrderRoundingAdjustment}
         */
        public OrderRoundingAdjustment build() {
            return new OrderRoundingAdjustment(uid,
                name,
                amountMoney);
        }
    }
}
