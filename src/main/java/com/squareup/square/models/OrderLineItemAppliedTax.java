package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderLineItemAppliedTax {

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

    @Override
    public int hashCode() {
        return Objects.hash(taxUid, uid, appliedMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderLineItemAppliedTax)) {
            return false;
        }
        OrderLineItemAppliedTax orderLineItemAppliedTax = (OrderLineItemAppliedTax) o;
        return Objects.equals(taxUid, orderLineItemAppliedTax.taxUid) &&
            Objects.equals(uid, orderLineItemAppliedTax.uid) &&
            Objects.equals(appliedMoney, orderLineItemAppliedTax.appliedMoney);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder(taxUid)
            .uid(getUid())
            .appliedMoney(getAppliedMoney());
            return builder;
    }

    public static class Builder {
        private String taxUid;
        private String uid;
        private Money appliedMoney;

        public Builder(String taxUid) {
            this.taxUid = taxUid;
        }

        public Builder taxUid(String value) {
            taxUid = value;
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

        public OrderLineItemAppliedTax build() {
            return new OrderLineItemAppliedTax(taxUid,
                uid,
                appliedMoney);
        }
    }
}
