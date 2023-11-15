
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
 * This is a model class for PayoutFee type.
 */
public class PayoutFee {
    private final Money amountMoney;
    private final OptionalNullable<String> effectiveAt;
    private final String type;

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     * @param  effectiveAt  String value for effectiveAt.
     * @param  type  String value for type.
     */
    @JsonCreator
    public PayoutFee(
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("effective_at") String effectiveAt,
            @JsonProperty("type") String type) {
        this.amountMoney = amountMoney;
        this.effectiveAt = OptionalNullable.of(effectiveAt);
        this.type = type;
    }

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     * @param  effectiveAt  String value for effectiveAt.
     * @param  type  String value for type.
     */

    protected PayoutFee(Money amountMoney, OptionalNullable<String> effectiveAt, String type) {
        this.amountMoney = amountMoney;
        this.effectiveAt = effectiveAt;
        this.type = type;
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

    /**
     * Internal Getter for EffectiveAt.
     * The timestamp of when the fee takes effect, in RFC 3339 format.
     * @return Returns the Internal String
     */
    @JsonGetter("effective_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEffectiveAt() {
        return this.effectiveAt;
    }

    /**
     * Getter for EffectiveAt.
     * The timestamp of when the fee takes effect, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEffectiveAt() {
        return OptionalNullable.getFrom(effectiveAt);
    }

    /**
     * Getter for Type.
     * Represents the type of payout fee that can incur as part of a payout.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountMoney, effectiveAt, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayoutFee)) {
            return false;
        }
        PayoutFee other = (PayoutFee) obj;
        return Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(effectiveAt, other.effectiveAt)
            && Objects.equals(type, other.type);
    }

    /**
     * Converts this PayoutFee into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PayoutFee [" + "amountMoney=" + amountMoney + ", effectiveAt=" + effectiveAt
                + ", type=" + type + "]";
    }

    /**
     * Builds a new {@link PayoutFee.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PayoutFee.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .amountMoney(getAmountMoney())
                .type(getType());
        builder.effectiveAt = internalGetEffectiveAt();
        return builder;
    }

    /**
     * Class to build instances of {@link PayoutFee}.
     */
    public static class Builder {
        private Money amountMoney;
        private OptionalNullable<String> effectiveAt;
        private String type;



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
         * Setter for effectiveAt.
         * @param  effectiveAt  String value for effectiveAt.
         * @return Builder
         */
        public Builder effectiveAt(String effectiveAt) {
            this.effectiveAt = OptionalNullable.of(effectiveAt);
            return this;
        }

        /**
         * UnSetter for effectiveAt.
         * @return Builder
         */
        public Builder unsetEffectiveAt() {
            effectiveAt = null;
            return this;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Builds a new {@link PayoutFee} object using the set fields.
         * @return {@link PayoutFee}
         */
        public PayoutFee build() {
            return new PayoutFee(amountMoney, effectiveAt, type);
        }
    }
}
