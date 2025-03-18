/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GiftCardActivityRefund.Builder.class)
public final class GiftCardActivityRefund {
    private final Optional<String> redeemActivityId;

    private final Optional<Money> amountMoney;

    private final Optional<String> referenceId;

    private final Optional<String> paymentId;

    private final Map<String, Object> additionalProperties;

    private GiftCardActivityRefund(
            Optional<String> redeemActivityId,
            Optional<Money> amountMoney,
            Optional<String> referenceId,
            Optional<String> paymentId,
            Map<String, Object> additionalProperties) {
        this.redeemActivityId = redeemActivityId;
        this.amountMoney = amountMoney;
        this.referenceId = referenceId;
        this.paymentId = paymentId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the refunded <code>REDEEM</code> gift card activity. Square populates this field if the
     * <code>payment_id</code> in the corresponding <a href="api-endpoint:Refunds-RefundPayment">RefundPayment</a> request
     * represents a gift card redemption.
     * <p>For applications that use a custom payment processing system, this field is required when creating
     * a <code>REFUND</code> activity. The provided <code>REDEEM</code> activity ID must be linked to the same gift card.</p>
     */
    @JsonIgnore
    public Optional<String> getRedeemActivityId() {
        if (redeemActivityId == null) {
            return Optional.empty();
        }
        return redeemActivityId;
    }

    /**
     * @return The amount added to the gift card for the refund. This value is a positive integer.
     * <p>This field is required when creating a <code>REFUND</code> activity. The amount can represent a full or partial refund.</p>
     */
    @JsonProperty("amount_money")
    public Optional<Money> getAmountMoney() {
        return amountMoney;
    }

    /**
     * @return A client-specified ID that associates the gift card activity with an entity in another system.
     */
    @JsonIgnore
    public Optional<String> getReferenceId() {
        if (referenceId == null) {
            return Optional.empty();
        }
        return referenceId;
    }

    /**
     * @return The ID of the refunded payment. Square populates this field if the refund is for a
     * payment processed by Square. This field matches the <code>payment_id</code> in the corresponding
     * <a href="api-endpoint:Refunds-RefundPayment">RefundPayment</a> request.
     */
    @JsonProperty("payment_id")
    public Optional<String> getPaymentId() {
        return paymentId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("redeem_activity_id")
    private Optional<String> _getRedeemActivityId() {
        return redeemActivityId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("reference_id")
    private Optional<String> _getReferenceId() {
        return referenceId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GiftCardActivityRefund && equalTo((GiftCardActivityRefund) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GiftCardActivityRefund other) {
        return redeemActivityId.equals(other.redeemActivityId)
                && amountMoney.equals(other.amountMoney)
                && referenceId.equals(other.referenceId)
                && paymentId.equals(other.paymentId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.redeemActivityId, this.amountMoney, this.referenceId, this.paymentId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> redeemActivityId = Optional.empty();

        private Optional<Money> amountMoney = Optional.empty();

        private Optional<String> referenceId = Optional.empty();

        private Optional<String> paymentId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GiftCardActivityRefund other) {
            redeemActivityId(other.getRedeemActivityId());
            amountMoney(other.getAmountMoney());
            referenceId(other.getReferenceId());
            paymentId(other.getPaymentId());
            return this;
        }

        @JsonSetter(value = "redeem_activity_id", nulls = Nulls.SKIP)
        public Builder redeemActivityId(Optional<String> redeemActivityId) {
            this.redeemActivityId = redeemActivityId;
            return this;
        }

        public Builder redeemActivityId(String redeemActivityId) {
            this.redeemActivityId = Optional.ofNullable(redeemActivityId);
            return this;
        }

        public Builder redeemActivityId(Nullable<String> redeemActivityId) {
            if (redeemActivityId.isNull()) {
                this.redeemActivityId = null;
            } else if (redeemActivityId.isEmpty()) {
                this.redeemActivityId = Optional.empty();
            } else {
                this.redeemActivityId = Optional.of(redeemActivityId.get());
            }
            return this;
        }

        @JsonSetter(value = "amount_money", nulls = Nulls.SKIP)
        public Builder amountMoney(Optional<Money> amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = Optional.ofNullable(amountMoney);
            return this;
        }

        @JsonSetter(value = "reference_id", nulls = Nulls.SKIP)
        public Builder referenceId(Optional<String> referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        public Builder referenceId(String referenceId) {
            this.referenceId = Optional.ofNullable(referenceId);
            return this;
        }

        public Builder referenceId(Nullable<String> referenceId) {
            if (referenceId.isNull()) {
                this.referenceId = null;
            } else if (referenceId.isEmpty()) {
                this.referenceId = Optional.empty();
            } else {
                this.referenceId = Optional.of(referenceId.get());
            }
            return this;
        }

        @JsonSetter(value = "payment_id", nulls = Nulls.SKIP)
        public Builder paymentId(Optional<String> paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder paymentId(String paymentId) {
            this.paymentId = Optional.ofNullable(paymentId);
            return this;
        }

        public GiftCardActivityRefund build() {
            return new GiftCardActivityRefund(
                    redeemActivityId, amountMoney, referenceId, paymentId, additionalProperties);
        }
    }
}
