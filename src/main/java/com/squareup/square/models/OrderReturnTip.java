
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for OrderReturnTip type.
 */
public class OrderReturnTip {
    private final OptionalNullable<String> uid;
    private final Money appliedMoney;
    private final OptionalNullable<String> sourceTenderUid;
    private final OptionalNullable<String> sourceTenderId;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  appliedMoney  Money value for appliedMoney.
     * @param  sourceTenderUid  String value for sourceTenderUid.
     * @param  sourceTenderId  String value for sourceTenderId.
     */
    @JsonCreator
    public OrderReturnTip(
            @JsonProperty("uid") String uid,
            @JsonProperty("applied_money") Money appliedMoney,
            @JsonProperty("source_tender_uid") String sourceTenderUid,
            @JsonProperty("source_tender_id") String sourceTenderId) {
        this.uid = OptionalNullable.of(uid);
        this.appliedMoney = appliedMoney;
        this.sourceTenderUid = OptionalNullable.of(sourceTenderUid);
        this.sourceTenderId = OptionalNullable.of(sourceTenderId);
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  appliedMoney  Money value for appliedMoney.
     * @param  sourceTenderUid  String value for sourceTenderUid.
     * @param  sourceTenderId  String value for sourceTenderId.
     */

    protected OrderReturnTip(OptionalNullable<String> uid, Money appliedMoney,
            OptionalNullable<String> sourceTenderUid, OptionalNullable<String> sourceTenderId) {
        this.uid = uid;
        this.appliedMoney = appliedMoney;
        this.sourceTenderUid = sourceTenderUid;
        this.sourceTenderId = sourceTenderId;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the tip only within this order.
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
     * A unique ID that identifies the tip only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
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

    /**
     * Internal Getter for SourceTenderUid.
     * The tender `uid` from the order that contains the original application of this tip.
     * @return Returns the Internal String
     */
    @JsonGetter("source_tender_uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSourceTenderUid() {
        return this.sourceTenderUid;
    }

    /**
     * Getter for SourceTenderUid.
     * The tender `uid` from the order that contains the original application of this tip.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSourceTenderUid() {
        return OptionalNullable.getFrom(sourceTenderUid);
    }

    /**
     * Internal Getter for SourceTenderId.
     * The tender `id` from the order that contains the original application of this tip.
     * @return Returns the Internal String
     */
    @JsonGetter("source_tender_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSourceTenderId() {
        return this.sourceTenderId;
    }

    /**
     * Getter for SourceTenderId.
     * The tender `id` from the order that contains the original application of this tip.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSourceTenderId() {
        return OptionalNullable.getFrom(sourceTenderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, appliedMoney, sourceTenderUid, sourceTenderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderReturnTip)) {
            return false;
        }
        OrderReturnTip other = (OrderReturnTip) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(appliedMoney, other.appliedMoney)
            && Objects.equals(sourceTenderUid, other.sourceTenderUid)
            && Objects.equals(sourceTenderId, other.sourceTenderId);
    }

    /**
     * Converts this OrderReturnTip into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderReturnTip [" + "uid=" + uid + ", appliedMoney=" + appliedMoney
                + ", sourceTenderUid=" + sourceTenderUid + ", sourceTenderId=" + sourceTenderId
                + "]";
    }

    /**
     * Builds a new {@link OrderReturnTip.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReturnTip.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .appliedMoney(getAppliedMoney());
        builder.uid = internalGetUid();
        builder.sourceTenderUid = internalGetSourceTenderUid();
        builder.sourceTenderId = internalGetSourceTenderId();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderReturnTip}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private Money appliedMoney;
        private OptionalNullable<String> sourceTenderUid;
        private OptionalNullable<String> sourceTenderId;



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
         * Setter for sourceTenderUid.
         * @param  sourceTenderUid  String value for sourceTenderUid.
         * @return Builder
         */
        public Builder sourceTenderUid(String sourceTenderUid) {
            this.sourceTenderUid = OptionalNullable.of(sourceTenderUid);
            return this;
        }

        /**
         * UnSetter for sourceTenderUid.
         * @return Builder
         */
        public Builder unsetSourceTenderUid() {
            sourceTenderUid = null;
            return this;
        }

        /**
         * Setter for sourceTenderId.
         * @param  sourceTenderId  String value for sourceTenderId.
         * @return Builder
         */
        public Builder sourceTenderId(String sourceTenderId) {
            this.sourceTenderId = OptionalNullable.of(sourceTenderId);
            return this;
        }

        /**
         * UnSetter for sourceTenderId.
         * @return Builder
         */
        public Builder unsetSourceTenderId() {
            sourceTenderId = null;
            return this;
        }

        /**
         * Builds a new {@link OrderReturnTip} object using the set fields.
         * @return {@link OrderReturnTip}
         */
        public OrderReturnTip build() {
            return new OrderReturnTip(uid, appliedMoney, sourceTenderUid, sourceTenderId);
        }
    }
}
