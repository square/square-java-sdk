package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderLineItemAppliedDiscount type.
 */
public class OrderLineItemAppliedDiscount {

    /**
     * Initialization constructor.
     * @param discountUid
     * @param uid
     * @param appliedMoney
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, discountUid, appliedMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderLineItemAppliedDiscount)) {
            return false;
        }
        OrderLineItemAppliedDiscount orderLineItemAppliedDiscount = (OrderLineItemAppliedDiscount) obj;
        return Objects.equals(uid, orderLineItemAppliedDiscount.uid) &&
            Objects.equals(discountUid, orderLineItemAppliedDiscount.discountUid) &&
            Objects.equals(appliedMoney, orderLineItemAppliedDiscount.appliedMoney);
    }

    /**
     * Builds a new {@link OrderLineItemAppliedDiscount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemAppliedDiscount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(discountUid)
            .uid(getUid())
            .appliedMoney(getAppliedMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemAppliedDiscount}
     */
    public static class Builder {
        private String discountUid;
        private String uid;
        private Money appliedMoney;

        /**
         * Initialization constructor
         */
        public Builder(String discountUid) {
            this.discountUid = discountUid;
        }

        /**
         * Setter for discountUid
         * @param discountUid
         * @return Builder
         */
        public Builder discountUid(String discountUid) {
            this.discountUid = discountUid;
            return this;
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
         * Setter for appliedMoney
         * @param appliedMoney
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
            return new OrderLineItemAppliedDiscount(discountUid,
                uid,
                appliedMoney);
        }
    }
}
