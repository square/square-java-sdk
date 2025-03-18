package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for OrderRoundingAdjustment type.
 */
public class OrderRoundingAdjustment {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> name;
    private final Money amountMoney;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  name  String value for name.
     * @param  amountMoney  Money value for amountMoney.
     */
    @JsonCreator
    public OrderRoundingAdjustment(
            @JsonProperty("uid") String uid,
            @JsonProperty("name") String name,
            @JsonProperty("amount_money") Money amountMoney) {
        this.uid = OptionalNullable.of(uid);
        this.name = OptionalNullable.of(name);
        this.amountMoney = amountMoney;
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  name  String value for name.
     * @param  amountMoney  Money value for amountMoney.
     */
    protected OrderRoundingAdjustment(OptionalNullable<String> uid, OptionalNullable<String> name, Money amountMoney) {
        this.uid = uid;
        this.name = name;
        this.amountMoney = amountMoney;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the rounding adjustment only within this order.
     * @return Returns the Internal String
     */
    @JsonGetter("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUid() {
        return this.uid;
    }

    /**
     * Getter for Uid.
     * A unique ID that identifies the rounding adjustment only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for Name.
     * The name of the rounding adjustment from the original sale order.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * The name of the rounding adjustment from the original sale order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAmountMoney() {
        return amountMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderRoundingAdjustment)) {
            return false;
        }
        OrderRoundingAdjustment other = (OrderRoundingAdjustment) obj;
        return Objects.equals(uid, other.uid)
                && Objects.equals(name, other.name)
                && Objects.equals(amountMoney, other.amountMoney);
    }

    /**
     * Converts this OrderRoundingAdjustment into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderRoundingAdjustment [" + "uid=" + uid + ", name=" + name + ", amountMoney=" + amountMoney + "]";
    }

    /**
     * Builds a new {@link OrderRoundingAdjustment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderRoundingAdjustment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().amountMoney(getAmountMoney());
        builder.uid = internalGetUid();
        builder.name = internalGetName();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderRoundingAdjustment}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<String> name;
        private Money amountMoney;

        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = OptionalNullable.of(uid);
            return this;
        }

        /**
         * UnSetter for uid.
         * @return Builder
         */
        public Builder unsetUid() {
            uid = null;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
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
         * Builds a new {@link OrderRoundingAdjustment} object using the set fields.
         * @return {@link OrderRoundingAdjustment}
         */
        public OrderRoundingAdjustment build() {
            return new OrderRoundingAdjustment(uid, name, amountMoney);
        }
    }
}
