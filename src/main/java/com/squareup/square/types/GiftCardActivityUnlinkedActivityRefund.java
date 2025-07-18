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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GiftCardActivityUnlinkedActivityRefund.Builder.class)
public final class GiftCardActivityUnlinkedActivityRefund {
    private final Money amountMoney;

    private final Optional<String> referenceId;

    private final Optional<String> paymentId;

    private final Map<String, Object> additionalProperties;

    private GiftCardActivityUnlinkedActivityRefund(
            Money amountMoney,
            Optional<String> referenceId,
            Optional<String> paymentId,
            Map<String, Object> additionalProperties) {
        this.amountMoney = amountMoney;
        this.referenceId = referenceId;
        this.paymentId = paymentId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The amount added to the gift card for the refund. This value is a positive integer.
     */
    @JsonProperty("amount_money")
    public Money getAmountMoney() {
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
     * @return The ID of the refunded payment. This field is not used starting in Square version 2022-06-16.
     */
    @JsonProperty("payment_id")
    public Optional<String> getPaymentId() {
        return paymentId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("reference_id")
    private Optional<String> _getReferenceId() {
        return referenceId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GiftCardActivityUnlinkedActivityRefund
                && equalTo((GiftCardActivityUnlinkedActivityRefund) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GiftCardActivityUnlinkedActivityRefund other) {
        return amountMoney.equals(other.amountMoney)
                && referenceId.equals(other.referenceId)
                && paymentId.equals(other.paymentId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.amountMoney, this.referenceId, this.paymentId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static AmountMoneyStage builder() {
        return new Builder();
    }

    public interface AmountMoneyStage {
        /**
         * <p>The amount added to the gift card for the refund. This value is a positive integer.</p>
         */
        _FinalStage amountMoney(@NotNull Money amountMoney);

        Builder from(GiftCardActivityUnlinkedActivityRefund other);
    }

    public interface _FinalStage {
        GiftCardActivityUnlinkedActivityRefund build();

        /**
         * <p>A client-specified ID that associates the gift card activity with an entity in another system.</p>
         */
        _FinalStage referenceId(Optional<String> referenceId);

        _FinalStage referenceId(String referenceId);

        _FinalStage referenceId(Nullable<String> referenceId);

        /**
         * <p>The ID of the refunded payment. This field is not used starting in Square version 2022-06-16.</p>
         */
        _FinalStage paymentId(Optional<String> paymentId);

        _FinalStage paymentId(String paymentId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AmountMoneyStage, _FinalStage {
        private Money amountMoney;

        private Optional<String> paymentId = Optional.empty();

        private Optional<String> referenceId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GiftCardActivityUnlinkedActivityRefund other) {
            amountMoney(other.getAmountMoney());
            referenceId(other.getReferenceId());
            paymentId(other.getPaymentId());
            return this;
        }

        /**
         * <p>The amount added to the gift card for the refund. This value is a positive integer.</p>
         * <p>The amount added to the gift card for the refund. This value is a positive integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("amount_money")
        public _FinalStage amountMoney(@NotNull Money amountMoney) {
            this.amountMoney = Objects.requireNonNull(amountMoney, "amountMoney must not be null");
            return this;
        }

        /**
         * <p>The ID of the refunded payment. This field is not used starting in Square version 2022-06-16.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage paymentId(String paymentId) {
            this.paymentId = Optional.ofNullable(paymentId);
            return this;
        }

        /**
         * <p>The ID of the refunded payment. This field is not used starting in Square version 2022-06-16.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "payment_id", nulls = Nulls.SKIP)
        public _FinalStage paymentId(Optional<String> paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        /**
         * <p>A client-specified ID that associates the gift card activity with an entity in another system.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage referenceId(Nullable<String> referenceId) {
            if (referenceId.isNull()) {
                this.referenceId = null;
            } else if (referenceId.isEmpty()) {
                this.referenceId = Optional.empty();
            } else {
                this.referenceId = Optional.of(referenceId.get());
            }
            return this;
        }

        /**
         * <p>A client-specified ID that associates the gift card activity with an entity in another system.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage referenceId(String referenceId) {
            this.referenceId = Optional.ofNullable(referenceId);
            return this;
        }

        /**
         * <p>A client-specified ID that associates the gift card activity with an entity in another system.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "reference_id", nulls = Nulls.SKIP)
        public _FinalStage referenceId(Optional<String> referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        @java.lang.Override
        public GiftCardActivityUnlinkedActivityRefund build() {
            return new GiftCardActivityUnlinkedActivityRefund(
                    amountMoney, referenceId, paymentId, additionalProperties);
        }
    }
}
