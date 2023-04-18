
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for OrderLineItemAppliedServiceCharge type.
 */
public class OrderLineItemAppliedServiceCharge {
    private final OptionalNullable<String> uid;
    private final String serviceChargeUid;
    private final Money appliedMoney;

    /**
     * Initialization constructor.
     * @param  serviceChargeUid  String value for serviceChargeUid.
     * @param  uid  String value for uid.
     * @param  appliedMoney  Money value for appliedMoney.
     */
    @JsonCreator
    public OrderLineItemAppliedServiceCharge(
            @JsonProperty("service_charge_uid") String serviceChargeUid,
            @JsonProperty("uid") String uid,
            @JsonProperty("applied_money") Money appliedMoney) {
        this.uid = OptionalNullable.of(uid);
        this.serviceChargeUid = serviceChargeUid;
        this.appliedMoney = appliedMoney;
    }

    /**
     * Internal initialization constructor.
     */
    protected OrderLineItemAppliedServiceCharge(String serviceChargeUid,
            OptionalNullable<String> uid, Money appliedMoney) {
        this.uid = uid;
        this.serviceChargeUid = serviceChargeUid;
        this.appliedMoney = appliedMoney;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the applied service charge only within this order.
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
     * A unique ID that identifies the applied service charge only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Getter for ServiceChargeUid.
     * The `uid` of the service charge that the applied service charge represents. It must reference
     * a service charge present in the `order.service_charges` field. This field is immutable. To
     * change which service charges apply to a line item, delete and add a new
     * `OrderLineItemAppliedServiceCharge`.
     * @return Returns the String
     */
    @JsonGetter("service_charge_uid")
    public String getServiceChargeUid() {
        return serviceChargeUid;
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
        return Objects.hash(uid, serviceChargeUid, appliedMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLineItemAppliedServiceCharge)) {
            return false;
        }
        OrderLineItemAppliedServiceCharge other = (OrderLineItemAppliedServiceCharge) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(serviceChargeUid, other.serviceChargeUid)
            && Objects.equals(appliedMoney, other.appliedMoney);
    }

    /**
     * Converts this OrderLineItemAppliedServiceCharge into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItemAppliedServiceCharge [" + "serviceChargeUid=" + serviceChargeUid
                + ", uid=" + uid + ", appliedMoney=" + appliedMoney + "]";
    }

    /**
     * Builds a new {@link OrderLineItemAppliedServiceCharge.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemAppliedServiceCharge.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(serviceChargeUid)
                .appliedMoney(getAppliedMoney());
        builder.uid = internalGetUid();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemAppliedServiceCharge}.
     */
    public static class Builder {
        private String serviceChargeUid;
        private OptionalNullable<String> uid;
        private Money appliedMoney;

        /**
         * Initialization constructor.
         * @param  serviceChargeUid  String value for serviceChargeUid.
         */
        public Builder(String serviceChargeUid) {
            this.serviceChargeUid = serviceChargeUid;
        }

        /**
         * Setter for serviceChargeUid.
         * @param  serviceChargeUid  String value for serviceChargeUid.
         * @return Builder
         */
        public Builder serviceChargeUid(String serviceChargeUid) {
            this.serviceChargeUid = serviceChargeUid;
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
         * Builds a new {@link OrderLineItemAppliedServiceCharge} object using the set fields.
         * @return {@link OrderLineItemAppliedServiceCharge}
         */
        public OrderLineItemAppliedServiceCharge build() {
            return new OrderLineItemAppliedServiceCharge(serviceChargeUid, uid, appliedMoney);
        }
    }
}