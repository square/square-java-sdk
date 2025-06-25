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
 * This is a model class for CalculateLoyaltyPointsRequest type.
 */
public class CalculateLoyaltyPointsRequest {
    private final OptionalNullable<String> orderId;
    private final Money transactionAmountMoney;
    private final OptionalNullable<String> loyaltyAccountId;

    /**
     * Initialization constructor.
     * @param  orderId  String value for orderId.
     * @param  transactionAmountMoney  Money value for transactionAmountMoney.
     * @param  loyaltyAccountId  String value for loyaltyAccountId.
     */
    @JsonCreator
    public CalculateLoyaltyPointsRequest(
            @JsonProperty("order_id") String orderId,
            @JsonProperty("transaction_amount_money") Money transactionAmountMoney,
            @JsonProperty("loyalty_account_id") String loyaltyAccountId) {
        this.orderId = OptionalNullable.of(orderId);
        this.transactionAmountMoney = transactionAmountMoney;
        this.loyaltyAccountId = OptionalNullable.of(loyaltyAccountId);
    }

    /**
     * Initialization constructor.
     * @param  orderId  String value for orderId.
     * @param  transactionAmountMoney  Money value for transactionAmountMoney.
     * @param  loyaltyAccountId  String value for loyaltyAccountId.
     */
    protected CalculateLoyaltyPointsRequest(
            OptionalNullable<String> orderId, Money transactionAmountMoney, OptionalNullable<String> loyaltyAccountId) {
        this.orderId = orderId;
        this.transactionAmountMoney = transactionAmountMoney;
        this.loyaltyAccountId = loyaltyAccountId;
    }

    /**
     * Internal Getter for OrderId.
     * The [order](entity:Order) ID for which to calculate the points. Specify this field if your
     * application uses the Orders API to process orders. Otherwise, specify the
     * `transaction_amount_money`.
     * @return Returns the Internal String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOrderId() {
        return this.orderId;
    }

    /**
     * Getter for OrderId.
     * The [order](entity:Order) ID for which to calculate the points. Specify this field if your
     * application uses the Orders API to process orders. Otherwise, specify the
     * `transaction_amount_money`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOrderId() {
        return OptionalNullable.getFrom(orderId);
    }

    /**
     * Getter for TransactionAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("transaction_amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getTransactionAmountMoney() {
        return transactionAmountMoney;
    }

    /**
     * Internal Getter for LoyaltyAccountId.
     * The ID of the target [loyalty account](entity:LoyaltyAccount). Optionally specify this field
     * if your application uses the Orders API to process orders. If specified, the
     * `promotion_points` field in the response shows the number of points the buyer would earn from
     * the purchase. In this case, Square uses the account ID to determine whether the promotion's
     * `trigger_limit` (the maximum number of times that a buyer can trigger the promotion) has been
     * reached. If not specified, the `promotion_points` field shows the number of points the
     * purchase qualifies for regardless of the trigger limit.
     * @return Returns the Internal String
     */
    @JsonGetter("loyalty_account_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLoyaltyAccountId() {
        return this.loyaltyAccountId;
    }

    /**
     * Getter for LoyaltyAccountId.
     * The ID of the target [loyalty account](entity:LoyaltyAccount). Optionally specify this field
     * if your application uses the Orders API to process orders. If specified, the
     * `promotion_points` field in the response shows the number of points the buyer would earn from
     * the purchase. In this case, Square uses the account ID to determine whether the promotion's
     * `trigger_limit` (the maximum number of times that a buyer can trigger the promotion) has been
     * reached. If not specified, the `promotion_points` field shows the number of points the
     * purchase qualifies for regardless of the trigger limit.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLoyaltyAccountId() {
        return OptionalNullable.getFrom(loyaltyAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, transactionAmountMoney, loyaltyAccountId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CalculateLoyaltyPointsRequest)) {
            return false;
        }
        CalculateLoyaltyPointsRequest other = (CalculateLoyaltyPointsRequest) obj;
        return Objects.equals(orderId, other.orderId)
                && Objects.equals(transactionAmountMoney, other.transactionAmountMoney)
                && Objects.equals(loyaltyAccountId, other.loyaltyAccountId);
    }

    /**
     * Converts this CalculateLoyaltyPointsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CalculateLoyaltyPointsRequest [" + "orderId=" + orderId
                + ", transactionAmountMoney=" + transactionAmountMoney + ", loyaltyAccountId="
                + loyaltyAccountId + "]";
    }

    /**
     * Builds a new {@link CalculateLoyaltyPointsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CalculateLoyaltyPointsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().transactionAmountMoney(getTransactionAmountMoney());
        builder.orderId = internalGetOrderId();
        builder.loyaltyAccountId = internalGetLoyaltyAccountId();
        return builder;
    }

    /**
     * Class to build instances of {@link CalculateLoyaltyPointsRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> orderId;
        private Money transactionAmountMoney;
        private OptionalNullable<String> loyaltyAccountId;

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = OptionalNullable.of(orderId);
            return this;
        }

        /**
         * UnSetter for orderId.
         * @return Builder
         */
        public Builder unsetOrderId() {
            orderId = null;
            return this;
        }

        /**
         * Setter for transactionAmountMoney.
         * @param  transactionAmountMoney  Money value for transactionAmountMoney.
         * @return Builder
         */
        public Builder transactionAmountMoney(Money transactionAmountMoney) {
            this.transactionAmountMoney = transactionAmountMoney;
            return this;
        }

        /**
         * Setter for loyaltyAccountId.
         * @param  loyaltyAccountId  String value for loyaltyAccountId.
         * @return Builder
         */
        public Builder loyaltyAccountId(String loyaltyAccountId) {
            this.loyaltyAccountId = OptionalNullable.of(loyaltyAccountId);
            return this;
        }

        /**
         * UnSetter for loyaltyAccountId.
         * @return Builder
         */
        public Builder unsetLoyaltyAccountId() {
            loyaltyAccountId = null;
            return this;
        }

        /**
         * Builds a new {@link CalculateLoyaltyPointsRequest} object using the set fields.
         * @return {@link CalculateLoyaltyPointsRequest}
         */
        public CalculateLoyaltyPointsRequest build() {
            return new CalculateLoyaltyPointsRequest(orderId, transactionAmountMoney, loyaltyAccountId);
        }
    }
}
