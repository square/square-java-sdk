package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderLineItemAppliedTax type.
 */
public class OrderLineItemAppliedTax {

    /**
     * Initialization constructor.
     * @param taxUid
     * @param uid
     * @param appliedMoney
     */
    @JsonCreator
    public OrderLineItemAppliedTax(
            @JsonProperty("tax_uid") String taxUid,
            @JsonProperty("uid") String uid,
            @JsonProperty("applied_money") Money appliedMoney) {
        this.uid = uid;
        this.taxUid = taxUid;
        this.appliedMoney = appliedMoney;
    }

    private final String uid;
    private final String taxUid;
    private final Money appliedMoney;
    /**
     * Getter for Uid.
     * Unique ID that identifies the applied tax only within this order.
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for TaxUid.
     * The `uid` of the tax for which this applied tax represents.  Must reference
     * a tax present in the `order.taxes` field.
     * This field is immutable. To change which taxes apply to a line item, delete and add new
     * `OrderLineItemAppliedTax`s.
     */
    @JsonGetter("tax_uid")
    public String getTaxUid() {
        return this.taxUid;
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
        return Objects.hash(uid, taxUid, appliedMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderLineItemAppliedTax)) {
            return false;
        }
        OrderLineItemAppliedTax orderLineItemAppliedTax = (OrderLineItemAppliedTax) obj;
        return Objects.equals(uid, orderLineItemAppliedTax.uid) &&
            Objects.equals(taxUid, orderLineItemAppliedTax.taxUid) &&
            Objects.equals(appliedMoney, orderLineItemAppliedTax.appliedMoney);
    }

    /**
     * Builds a new {@link OrderLineItemAppliedTax.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemAppliedTax.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(taxUid)
            .uid(getUid())
            .appliedMoney(getAppliedMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemAppliedTax}
     */
    public static class Builder {
        private String taxUid;
        private String uid;
        private Money appliedMoney;

        /**
         * Initialization constructor
         */
        public Builder(String taxUid) {
            this.taxUid = taxUid;
        }

        /**
         * Setter for taxUid
         * @param taxUid
         * @return Builder
         */
        public Builder taxUid(String taxUid) {
            this.taxUid = taxUid;
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
         * Builds a new {@link OrderLineItemAppliedTax} object using the set fields.
         * @return {@link OrderLineItemAppliedTax}
         */
        public OrderLineItemAppliedTax build() {
            return new OrderLineItemAppliedTax(taxUid,
                uid,
                appliedMoney);
        }
    }
}
