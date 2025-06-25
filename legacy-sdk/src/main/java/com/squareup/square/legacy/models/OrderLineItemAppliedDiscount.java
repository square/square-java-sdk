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
 * This is a model class for OrderLineItemAppliedDiscount type.
 */
public class OrderLineItemAppliedDiscount {
    private final OptionalNullable<String> uid;
    private final String discountUid;
    private final Money appliedMoney;

    /**
     * Initialization constructor.
     * @param  discountUid  String value for discountUid.
     * @param  uid  String value for uid.
     * @param  appliedMoney  Money value for appliedMoney.
     */
    @JsonCreator
    public OrderLineItemAppliedDiscount(
            @JsonProperty("discount_uid") String discountUid,
            @JsonProperty("uid") String uid,
            @JsonProperty("applied_money") Money appliedMoney) {
        this.uid = OptionalNullable.of(uid);
        this.discountUid = discountUid;
        this.appliedMoney = appliedMoney;
    }

    /**
     * Initialization constructor.
     * @param  discountUid  String value for discountUid.
     * @param  uid  String value for uid.
     * @param  appliedMoney  Money value for appliedMoney.
     */
    protected OrderLineItemAppliedDiscount(String discountUid, OptionalNullable<String> uid, Money appliedMoney) {
        this.uid = uid;
        this.discountUid = discountUid;
        this.appliedMoney = appliedMoney;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the applied discount only within this order.
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
     * A unique ID that identifies the applied discount only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Getter for DiscountUid.
     * The `uid` of the discount that the applied discount represents. It must reference a discount
     * present in the `order.discounts` field. This field is immutable. To change which discounts
     * apply to a line item, you must delete the discount and re-add it as a new
     * `OrderLineItemAppliedDiscount`.
     * @return Returns the String
     */
    @JsonGetter("discount_uid")
    public String getDiscountUid() {
        return discountUid;
    }

    /**
     * Getter for AppliedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("applied_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAppliedMoney() {
        return appliedMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, discountUid, appliedMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLineItemAppliedDiscount)) {
            return false;
        }
        OrderLineItemAppliedDiscount other = (OrderLineItemAppliedDiscount) obj;
        return Objects.equals(uid, other.uid)
                && Objects.equals(discountUid, other.discountUid)
                && Objects.equals(appliedMoney, other.appliedMoney);
    }

    /**
     * Converts this OrderLineItemAppliedDiscount into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItemAppliedDiscount [" + "discountUid=" + discountUid + ", uid=" + uid + ", appliedMoney="
                + appliedMoney + "]";
    }

    /**
     * Builds a new {@link OrderLineItemAppliedDiscount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemAppliedDiscount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(discountUid).appliedMoney(getAppliedMoney());
        builder.uid = internalGetUid();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemAppliedDiscount}.
     */
    public static class Builder {
        private String discountUid;
        private OptionalNullable<String> uid;
        private Money appliedMoney;

        /**
         * Initialization constructor.
         * @param  discountUid  String value for discountUid.
         */
        public Builder(String discountUid) {
            this.discountUid = discountUid;
        }

        /**
         * Setter for discountUid.
         * @param  discountUid  String value for discountUid.
         * @return Builder
         */
        public Builder discountUid(String discountUid) {
            this.discountUid = discountUid;
            return this;
        }

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
         * Setter for appliedMoney.
         * @param  appliedMoney  Money value for appliedMoney.
         * @return Builder
         */
        public Builder appliedMoney(Money appliedMoney) {
            this.appliedMoney = appliedMoney;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItemAppliedDiscount} object using the set fields.
         * @return {@link OrderLineItemAppliedDiscount}
         */
        public OrderLineItemAppliedDiscount build() {
            return new OrderLineItemAppliedDiscount(discountUid, uid, appliedMoney);
        }
    }
}
