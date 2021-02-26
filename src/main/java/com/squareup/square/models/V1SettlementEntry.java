
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1SettlementEntry type.
 */
public class V1SettlementEntry {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String paymentId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final V1Money amountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final V1Money feeMoney;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  type  String value for type.
     * @param  amountMoney  V1Money value for amountMoney.
     * @param  feeMoney  V1Money value for feeMoney.
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

    /**
     * Getter for PaymentId.
     * The settlement's unique identifier.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Getter for Type.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for AmountMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("amount_money")
    public V1Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for FeeMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("fee_money")
    public V1Money getFeeMoney() {
        return feeMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, type, amountMoney, feeMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1SettlementEntry)) {
            return false;
        }
        V1SettlementEntry other = (V1SettlementEntry) obj;
        return Objects.equals(paymentId, other.paymentId)
            && Objects.equals(type, other.type)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(feeMoney, other.feeMoney);
    }

    /**
     * Converts this V1SettlementEntry into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1SettlementEntry [" + "paymentId=" + paymentId + ", type=" + type
                + ", amountMoney=" + amountMoney + ", feeMoney=" + feeMoney + "]";
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
     * Class to build instances of {@link V1SettlementEntry}.
     */
    public static class Builder {
        private String paymentId;
        private String type;
        private V1Money amountMoney;
        private V1Money feeMoney;



        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
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
         * Setter for amountMoney.
         * @param  amountMoney  V1Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(V1Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for feeMoney.
         * @param  feeMoney  V1Money value for feeMoney.
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
            return new V1SettlementEntry(paymentId, type, amountMoney, feeMoney);
        }
    }
}
