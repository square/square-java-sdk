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
 * This is a model class for ProcessingFee type.
 */
public class ProcessingFee {
    private final OptionalNullable<String> effectiveAt;
    private final OptionalNullable<String> type;
    private final Money amountMoney;

    /**
     * Initialization constructor.
     * @param  effectiveAt  String value for effectiveAt.
     * @param  type  String value for type.
     * @param  amountMoney  Money value for amountMoney.
     */
    @JsonCreator
    public ProcessingFee(
            @JsonProperty("effective_at") String effectiveAt,
            @JsonProperty("type") String type,
            @JsonProperty("amount_money") Money amountMoney) {
        this.effectiveAt = OptionalNullable.of(effectiveAt);
        this.type = OptionalNullable.of(type);
        this.amountMoney = amountMoney;
    }

    /**
     * Initialization constructor.
     * @param  effectiveAt  String value for effectiveAt.
     * @param  type  String value for type.
     * @param  amountMoney  Money value for amountMoney.
     */
    protected ProcessingFee(OptionalNullable<String> effectiveAt, OptionalNullable<String> type, Money amountMoney) {
        this.effectiveAt = effectiveAt;
        this.type = type;
        this.amountMoney = amountMoney;
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
     * Internal Getter for Type.
     * The type of fee assessed or adjusted. The fee type can be `INITIAL` or `ADJUSTMENT`.
     * @return Returns the Internal String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetType() {
        return this.type;
    }

    /**
     * Getter for Type.
     * The type of fee assessed or adjusted. The fee type can be `INITIAL` or `ADJUSTMENT`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getType() {
        return OptionalNullable.getFrom(type);
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
        return Objects.hash(effectiveAt, type, amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProcessingFee)) {
            return false;
        }
        ProcessingFee other = (ProcessingFee) obj;
        return Objects.equals(effectiveAt, other.effectiveAt)
                && Objects.equals(type, other.type)
                && Objects.equals(amountMoney, other.amountMoney);
    }

    /**
     * Converts this ProcessingFee into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ProcessingFee [" + "effectiveAt=" + effectiveAt + ", type=" + type + ", amountMoney=" + amountMoney
                + "]";
    }

    /**
     * Builds a new {@link ProcessingFee.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ProcessingFee.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().amountMoney(getAmountMoney());
        builder.effectiveAt = internalGetEffectiveAt();
        builder.type = internalGetType();
        return builder;
    }

    /**
     * Class to build instances of {@link ProcessingFee}.
     */
    public static class Builder {
        private OptionalNullable<String> effectiveAt;
        private OptionalNullable<String> type;
        private Money amountMoney;

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
            this.type = OptionalNullable.of(type);
            return this;
        }

        /**
         * UnSetter for type.
         * @return Builder
         */
        public Builder unsetType() {
            type = null;
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
         * Builds a new {@link ProcessingFee} object using the set fields.
         * @return {@link ProcessingFee}
         */
        public ProcessingFee build() {
            return new ProcessingFee(effectiveAt, type, amountMoney);
        }
    }
}
