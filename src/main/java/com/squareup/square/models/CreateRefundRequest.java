
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateRefundRequest type.
 */
public class CreateRefundRequest {
    private final String idempotencyKey;
    private final String tenderId;
    private final String reason;
    private final Money amountMoney;

    /**
     * Initialization constructor.
     * @param idempotencyKey String value for idempotencyKey.
     * @param tenderId String value for tenderId.
     * @param amountMoney Money value for amountMoney.
     * @param reason String value for reason.
     */
    @JsonCreator
    public CreateRefundRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("tender_id") String tenderId,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("reason") String reason) {
        this.idempotencyKey = idempotencyKey;
        this.tenderId = tenderId;
        this.reason = reason;
        this.amountMoney = amountMoney;
    }

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this refund among refunds you've created for the
     * tender. If you're unsure whether a particular refund succeeded, you can reattempt it with the
     * same idempotency key without worrying about duplicating the refund. See [Idempotency
     * keys](#idempotencykeys) for more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for TenderId.
     * The ID of the tender to refund. A [`Transaction`](#type-transaction) has one or more
     * `tenders` (i.e., methods of payment) associated with it, and you refund each tender
     * separately with the Connect API.
     * @return Returns the String
     */
    @JsonGetter("tender_id")
    public String getTenderId() {
        return this.tenderId;
    }

    /**
     * Getter for Reason.
     * A description of the reason for the refund. Default value: `Refund via API`
     * @return Returns the String
     */
    @JsonGetter("reason")
    public String getReason() {
        return this.reason;
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
    public Money getAmountMoney() {
        return this.amountMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, tenderId, reason, amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateRefundRequest)) {
            return false;
        }
        CreateRefundRequest other = (CreateRefundRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(tenderId, other.tenderId)
            && Objects.equals(reason, other.reason)
            && Objects.equals(amountMoney, other.amountMoney);
    }

    /**
     * Converts this CreateRefundRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateRefundRequest [" + "idempotencyKey=" + idempotencyKey + ", tenderId="
                + tenderId + ", amountMoney=" + amountMoney + ", reason=" + reason + "]";
    }

    /**
     * Builds a new {@link CreateRefundRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateRefundRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, tenderId, amountMoney)
                .reason(getReason());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateRefundRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private String tenderId;
        private Money amountMoney;
        private String reason;

        /**
         * Initialization constructor.
         * @param idempotencyKey String value for idempotencyKey.
         * @param tenderId String value for tenderId.
         * @param amountMoney Money value for amountMoney.
         */
        public Builder(String idempotencyKey,
                String tenderId,
                Money amountMoney) {
            this.idempotencyKey = idempotencyKey;
            this.tenderId = tenderId;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for idempotencyKey.
         * @param idempotencyKey String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for tenderId.
         * @param tenderId String value for tenderId.
         * @return Builder
         */
        public Builder tenderId(String tenderId) {
            this.tenderId = tenderId;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param amountMoney Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for reason.
         * @param reason String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Builds a new {@link CreateRefundRequest} object using the set fields.
         * @return {@link CreateRefundRequest}
         */
        public CreateRefundRequest build() {
            return new CreateRefundRequest(idempotencyKey, tenderId, amountMoney, reason);
        }
    }
}
