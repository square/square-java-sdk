package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1SettlementEntry {

    @JsonCreator
    public V1SettlementEntry(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("type") String type,
            @JsonProperty("amount_money") V1Money amountMoney,
            @JsonProperty("fee_money") V1Money feeMoney) {
        this.paymentId = paymentId;
        this.type = type;
        this.amountMoney = amountMoney;
        this.feeMoney = feeMoney;
    }

    private final String paymentId;
    private final String type;
    private final V1Money amountMoney;
    private final V1Money feeMoney;

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, type, amountMoney, feeMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1SettlementEntry)) {
            return false;
        }
        V1SettlementEntry v1SettlementEntry = (V1SettlementEntry) o;
        return Objects.equals(paymentId, v1SettlementEntry.paymentId) &&
            Objects.equals(type, v1SettlementEntry.type) &&
            Objects.equals(amountMoney, v1SettlementEntry.amountMoney) &&
            Objects.equals(feeMoney, v1SettlementEntry.feeMoney);
    }

    /**
     * Getter for PaymentId.
     * The settlement's unique identifier.
     */
    @JsonGetter("payment_id")
    public String getPaymentId() { 
        return this.paymentId;
    }

    /**
     * Getter for Type.
     */
    @JsonGetter("type")
    public String getType() { 
        return this.type;
    }

    /**
     * Getter for AmountMoney.
     */
    @JsonGetter("amount_money")
    public V1Money getAmountMoney() { 
        return this.amountMoney;
    }

    /**
     * Getter for FeeMoney.
     */
    @JsonGetter("fee_money")
    public V1Money getFeeMoney() { 
        return this.feeMoney;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .paymentId(getPaymentId())
            .type(getType())
            .amountMoney(getAmountMoney())
            .feeMoney(getFeeMoney());
            return builder;
    }

    public static class Builder {
        private String paymentId;
        private String type;
        private V1Money amountMoney;
        private V1Money feeMoney;

        public Builder() { }

        public Builder paymentId(String value) {
            paymentId = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder amountMoney(V1Money value) {
            amountMoney = value;
            return this;
        }
        public Builder feeMoney(V1Money value) {
            feeMoney = value;
            return this;
        }

        public V1SettlementEntry build() {
            return new V1SettlementEntry(paymentId,
                type,
                amountMoney,
                feeMoney);
        }
    }
}
