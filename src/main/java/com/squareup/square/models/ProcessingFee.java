package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ProcessingFee {

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

    @Override
    public int hashCode() {
        return Objects.hash(effectiveAt, type, amountMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProcessingFee)) {
            return false;
        }
        ProcessingFee processingFee = (ProcessingFee) o;
        return Objects.equals(effectiveAt, processingFee.effectiveAt) &&
            Objects.equals(type, processingFee.type) &&
            Objects.equals(amountMoney, processingFee.amountMoney);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .effectiveAt(getEffectiveAt())
            .type(getType())
            .amountMoney(getAmountMoney());
            return builder;
    }

    public static class Builder {
        private String effectiveAt;
        private String type;
        private Money amountMoney;

        public Builder() { }

        public Builder effectiveAt(String value) {
            effectiveAt = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }

        public ProcessingFee build() {
            return new ProcessingFee(effectiveAt,
                type,
                amountMoney);
        }
    }
}
