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
 * This is a model class for OrderLineItemAppliedTax type.
 */
public class OrderLineItemAppliedTax {
    private final OptionalNullable<String> uid;
    private final String taxUid;
    private final Money appliedMoney;

    /**
     * Initialization constructor.
     * @param  taxUid  String value for taxUid.
     * @param  uid  String value for uid.
     * @param  appliedMoney  Money value for appliedMoney.
     */
    @JsonCreator
    public OrderLineItemAppliedTax(
            @JsonProperty("tax_uid") String taxUid,
            @JsonProperty("uid") String uid,
            @JsonProperty("applied_money") Money appliedMoney) {
        this.uid = OptionalNullable.of(uid);
        this.taxUid = taxUid;
        this.appliedMoney = appliedMoney;
    }

    /**
     * Initialization constructor.
     * @param  taxUid  String value for taxUid.
     * @param  uid  String value for uid.
     * @param  appliedMoney  Money value for appliedMoney.
     */
    protected OrderLineItemAppliedTax(String taxUid, OptionalNullable<String> uid, Money appliedMoney) {
        this.uid = uid;
        this.taxUid = taxUid;
        this.appliedMoney = appliedMoney;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the applied tax only within this order.
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
     * A unique ID that identifies the applied tax only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Getter for TaxUid.
     * The `uid` of the tax for which this applied tax represents. It must reference a tax present
     * in the `order.taxes` field. This field is immutable. To change which taxes apply to a line
     * item, delete and add a new `OrderLineItemAppliedTax`.
     * @return Returns the String
     */
    @JsonGetter("tax_uid")
    public String getTaxUid() {
        return taxUid;
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
        return Objects.hash(uid, taxUid, appliedMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLineItemAppliedTax)) {
            return false;
        }
        OrderLineItemAppliedTax other = (OrderLineItemAppliedTax) obj;
        return Objects.equals(uid, other.uid)
                && Objects.equals(taxUid, other.taxUid)
                && Objects.equals(appliedMoney, other.appliedMoney);
    }

    /**
     * Converts this OrderLineItemAppliedTax into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItemAppliedTax [" + "taxUid=" + taxUid + ", uid=" + uid + ", appliedMoney=" + appliedMoney
                + "]";
    }

    /**
     * Builds a new {@link OrderLineItemAppliedTax.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemAppliedTax.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(taxUid).appliedMoney(getAppliedMoney());
        builder.uid = internalGetUid();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemAppliedTax}.
     */
    public static class Builder {
        private String taxUid;
        private OptionalNullable<String> uid;
        private Money appliedMoney;

        /**
         * Initialization constructor.
         * @param  taxUid  String value for taxUid.
         */
        public Builder(String taxUid) {
            this.taxUid = taxUid;
        }

        /**
         * Setter for taxUid.
         * @param  taxUid  String value for taxUid.
         * @return Builder
         */
        public Builder taxUid(String taxUid) {
            this.taxUid = taxUid;
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
         * Builds a new {@link OrderLineItemAppliedTax} object using the set fields.
         * @return {@link OrderLineItemAppliedTax}
         */
        public OrderLineItemAppliedTax build() {
            return new OrderLineItemAppliedTax(taxUid, uid, appliedMoney);
        }
    }
}
