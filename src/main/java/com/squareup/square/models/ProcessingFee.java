package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ProcessingFee type.
 */
public class ProcessingFee {

    /**
     * Initialization constructor.
     * @param effectiveAt
     * @param type
     * @param amountMoney
     */
    @JsonCreator
    public ProcessingFee(
            @JsonProperty("effective_at") String effectiveAt,
            @JsonProperty("type") String type,
            @JsonProperty("amount_money") Money amountMoney) {
        this.effectiveAt = effectiveAt;
        this.type = type;
        this.amountMoney = amountMoney;
    }

    private final String effectiveAt;
    private final String type;
    private final Money amountMoney;
    /**
     * Getter for EffectiveAt.
     * Timestamp of when the fee takes effect, in RFC 3339 format.
     */
    @JsonGetter("effective_at")
    public String getEffectiveAt() {
        return this.effectiveAt;
    }

    /**
     * Getter for Type.
     * The type of fee assessed or adjusted. Can be one of: `INITIAL`, `ADJUSTMENT`.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return this.amountMoney;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(effectiveAt, type, amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ProcessingFee)) {
            return false;
        }
        ProcessingFee processingFee = (ProcessingFee) obj;
        return Objects.equals(effectiveAt, processingFee.effectiveAt) &&
            Objects.equals(type, processingFee.type) &&
            Objects.equals(amountMoney, processingFee.amountMoney);
    }

    /**
     * Builds a new {@link ProcessingFee.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ProcessingFee.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .effectiveAt(getEffectiveAt())
            .type(getType())
            .amountMoney(getAmountMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link ProcessingFee}
     */
    public static class Builder {
        private String effectiveAt;
        private String type;
        private Money amountMoney;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for effectiveAt
         * @param effectiveAt
         * @return Builder
         */
        public Builder effectiveAt(String effectiveAt) {
            this.effectiveAt = effectiveAt;
            return this;
        }
        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for amountMoney
         * @param amountMoney
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
            return new ProcessingFee(effectiveAt,
                type,
                amountMoney);
        }
    }
}
