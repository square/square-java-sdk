package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderLineItemAppliedDiscount {

    @JsonCreator
    public OrderLineItemAppliedDiscount(
            @JsonProperty("discount_uid") String discountUid,
            @JsonProperty("uid") String uid,
            @JsonProperty("applied_money") Money appliedMoney) {
        this.uid = uid;
        this.discountUid = discountUid;
        this.appliedMoney = appliedMoney;
    }

    private final String uid;
    private final String discountUid;
    private final Money appliedMoney;

    @Override
    public int hashCode() {
        return Objects.hash(discountUid, uid, appliedMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderLineItemAppliedDiscount)) {
            return false;
        }
        OrderLineItemAppliedDiscount orderLineItemAppliedDiscount = (OrderLineItemAppliedDiscount) o;
        return Objects.equals(discountUid, orderLineItemAppliedDiscount.discountUid) &&
            Objects.equals(uid, orderLineItemAppliedDiscount.uid) &&
            Objects.equals(appliedMoney, orderLineItemAppliedDiscount.appliedMoney);
    }

    /**
     * Getter for Uid.
     * Unique ID that identifies the applied discount only within this order.
     */
    @JsonGetter("uid")
    public String getUid() { 
        return this.uid;
    }

    /**
     * Getter for DiscountUid.
     * The `uid` of the discount the applied discount represents. Must
     * reference a discount present in the `order.discounts` field.
     * This field is immutable. To change which discounts apply to a line item,
     * you must delete the discount and re-add it as a new `OrderLineItemAppliedDiscount`.
     */
    @JsonGetter("discount_uid")
    public String getDiscountUid() { 
        return this.discountUid;
    }

    /**
     * Getter for AppliedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("applied_money")
    public Money getAppliedMoney() { 
        return this.appliedMoney;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(discountUid)
            .uid(getUid())
            .appliedMoney(getAppliedMoney());
            return builder;
    }

    public static class Builder {
        private String discountUid;
        private String uid;
        private Money appliedMoney;

        public Builder(String discountUid) {
            this.discountUid = discountUid;
        }

        public Builder discountUid(String value) {
            discountUid = value;
            return this;
        }
        public Builder uid(String value) {
            uid = value;
            return this;
        }
        public Builder appliedMoney(Money value) {
            appliedMoney = value;
            return this;
        }

        public OrderLineItemAppliedDiscount build() {
            return new OrderLineItemAppliedDiscount(discountUid,
                uid,
                appliedMoney);
        }
    }
}
