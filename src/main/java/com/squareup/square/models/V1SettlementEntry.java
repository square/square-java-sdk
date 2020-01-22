package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1SettlementEntry type.
 */
public class V1SettlementEntry {

    /**
     * Initialization constructor.
     * @param paymentId
     * @param type
     * @param amountMoney
     * @param feeMoney
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(paymentId, type, amountMoney, feeMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1SettlementEntry)) {
            return false;
        }
        V1SettlementEntry v1SettlementEntry = (V1SettlementEntry) obj;
        return Objects.equals(paymentId, v1SettlementEntry.paymentId) &&
            Objects.equals(type, v1SettlementEntry.type) &&
            Objects.equals(amountMoney, v1SettlementEntry.amountMoney) &&
            Objects.equals(feeMoney, v1SettlementEntry.feeMoney);
    }

    /**
     * Builds a new {@link V1SettlementEntry.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1SettlementEntry.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .paymentId(getPaymentId())
            .type(getType())
            .amountMoney(getAmountMoney())
            .feeMoney(getFeeMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link V1SettlementEntry}
     */
    public static class Builder {
        private String paymentId;
        private String type;
        private V1Money amountMoney;
        private V1Money feeMoney;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for paymentId
         * @param paymentId
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
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
        public Builder amountMoney(V1Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }
        /**
         * Setter for feeMoney
         * @param feeMoney
         * @return Builder
         */
        public Builder feeMoney(V1Money feeMoney) {
            this.feeMoney = feeMoney;
            return this;
        }

        /**
         * Builds a new {@link V1SettlementEntry} object using the set fields.
         * @return {@link V1SettlementEntry}
         */
        public V1SettlementEntry build() {
            return new V1SettlementEntry(paymentId,
                type,
                amountMoney,
                feeMoney);
        }
    }
}
