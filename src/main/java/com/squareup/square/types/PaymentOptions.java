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
@JsonDeserialize(builder = PaymentOptions.Builder.class)
public final class PaymentOptions {
    private final Optional<Boolean> autocomplete;

    private final Optional<String> delayDuration;

    private final Optional<Boolean> acceptPartialAuthorization;

    private final Optional<PaymentOptionsDelayAction> delayAction;

    private final Map<String, Object> additionalProperties;

    private PaymentOptions(
            Optional<Boolean> autocomplete,
            Optional<String> delayDuration,
            Optional<Boolean> acceptPartialAuthorization,
            Optional<PaymentOptionsDelayAction> delayAction,
            Map<String, Object> additionalProperties) {
        this.autocomplete = autocomplete;
        this.delayDuration = delayDuration;
        this.acceptPartialAuthorization = acceptPartialAuthorization;
        this.delayAction = delayAction;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Indicates whether the <code>Payment</code> objects created from this <code>TerminalCheckout</code> are
     * automatically <code>COMPLETED</code> or left in an <code>APPROVED</code> state for later modification.
     * <p>Default: true</p>
     */
    @JsonIgnore
    public Optional<Boolean> getAutocomplete() {
        if (autocomplete == null) {
            return Optional.empty();
        }
        return autocomplete;
    }

    /**
     * @return The duration of time after the payment's creation when Square automatically resolves the
     * payment. This automatic resolution applies only to payments that do not reach a terminal state
     * (<code>COMPLETED</code> or <code>CANCELED</code>) before the <code>delay_duration</code> time period.
     * <p>This parameter should be specified as a time duration, in RFC 3339 format, with a minimum value
     * of 1 minute and a maximum value of 36 hours. This feature is only supported for card payments,
     * and all payments will be considered card-present.</p>
     * <p>This parameter can only be set for a delayed capture payment (<code>autocomplete=false</code>). For more
     * information, see <a href="https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture#time-threshold">Delayed Capture</a>.</p>
     * <p>Default: &quot;PT36H&quot; (36 hours) from the creation time</p>
     */
    @JsonIgnore
    public Optional<String> getDelayDuration() {
        if (delayDuration == null) {
            return Optional.empty();
        }
        return delayDuration;
    }

    /**
     * @return If set to <code>true</code> and charging a Square Gift Card, a payment might be returned with
     * <code>amount_money</code> equal to less than what was requested. For example, a request for $20 when charging
     * a Square Gift Card with a balance of $5 results in an APPROVED payment of $5. You might choose
     * to prompt the buyer for an additional payment to cover the remainder or cancel the Gift Card
     * payment.
     * <p>This parameter can only be set for a delayed capture payment (<code>autocomplete=false</code>).</p>
     * <p>For more information, see <a href="https://developer.squareup.com/docs/payments-api/take-payments/card-payments/partial-payments-with-gift-cards">Take Partial Payments</a>.</p>
     * <p>Default: false</p>
     */
    @JsonIgnore
    public Optional<Boolean> getAcceptPartialAuthorization() {
        if (acceptPartialAuthorization == null) {
            return Optional.empty();
        }
        return acceptPartialAuthorization;
    }

    /**
     * @return The action to be applied to the <code>Payment</code> when the delay_duration has elapsed.
     * The action must be CANCEL or COMPLETE.
     * <p>The action cannot be set to COMPLETE if an <code>order_id</code> is present on the TerminalCheckout.</p>
     * <p>This parameter can only be set for a delayed capture payment (<code>autocomplete=false</code>). For more
     * information, see <a href="https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture#time-threshold">Delayed Capture</a>.</p>
     * <p>Default: CANCEL
     * See <a href="#type-delayaction">DelayAction</a> for possible values</p>
     */
    @JsonProperty("delay_action")
    public Optional<PaymentOptionsDelayAction> getDelayAction() {
        return delayAction;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("autocomplete")
    private Optional<Boolean> _getAutocomplete() {
        return autocomplete;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("delay_duration")
    private Optional<String> _getDelayDuration() {
        return delayDuration;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("accept_partial_authorization")
    private Optional<Boolean> _getAcceptPartialAuthorization() {
        return acceptPartialAuthorization;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaymentOptions && equalTo((PaymentOptions) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PaymentOptions other) {
        return autocomplete.equals(other.autocomplete)
                && delayDuration.equals(other.delayDuration)
                && acceptPartialAuthorization.equals(other.acceptPartialAuthorization)
                && delayAction.equals(other.delayAction);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.autocomplete, this.delayDuration, this.acceptPartialAuthorization, this.delayAction);
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
        private Optional<Boolean> autocomplete = Optional.empty();

        private Optional<String> delayDuration = Optional.empty();

        private Optional<Boolean> acceptPartialAuthorization = Optional.empty();

        private Optional<PaymentOptionsDelayAction> delayAction = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(PaymentOptions other) {
            autocomplete(other.getAutocomplete());
            delayDuration(other.getDelayDuration());
            acceptPartialAuthorization(other.getAcceptPartialAuthorization());
            delayAction(other.getDelayAction());
            return this;
        }

        /**
         * <p>Indicates whether the <code>Payment</code> objects created from this <code>TerminalCheckout</code> are
         * automatically <code>COMPLETED</code> or left in an <code>APPROVED</code> state for later modification.</p>
         * <p>Default: true</p>
         */
        @JsonSetter(value = "autocomplete", nulls = Nulls.SKIP)
        public Builder autocomplete(Optional<Boolean> autocomplete) {
            this.autocomplete = autocomplete;
            return this;
        }

        public Builder autocomplete(Boolean autocomplete) {
            this.autocomplete = Optional.ofNullable(autocomplete);
            return this;
        }

        public Builder autocomplete(Nullable<Boolean> autocomplete) {
            if (autocomplete.isNull()) {
                this.autocomplete = null;
            } else if (autocomplete.isEmpty()) {
                this.autocomplete = Optional.empty();
            } else {
                this.autocomplete = Optional.of(autocomplete.get());
            }
            return this;
        }

        /**
         * <p>The duration of time after the payment's creation when Square automatically resolves the
         * payment. This automatic resolution applies only to payments that do not reach a terminal state
         * (<code>COMPLETED</code> or <code>CANCELED</code>) before the <code>delay_duration</code> time period.</p>
         * <p>This parameter should be specified as a time duration, in RFC 3339 format, with a minimum value
         * of 1 minute and a maximum value of 36 hours. This feature is only supported for card payments,
         * and all payments will be considered card-present.</p>
         * <p>This parameter can only be set for a delayed capture payment (<code>autocomplete=false</code>). For more
         * information, see <a href="https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture#time-threshold">Delayed Capture</a>.</p>
         * <p>Default: &quot;PT36H&quot; (36 hours) from the creation time</p>
         */
        @JsonSetter(value = "delay_duration", nulls = Nulls.SKIP)
        public Builder delayDuration(Optional<String> delayDuration) {
            this.delayDuration = delayDuration;
            return this;
        }

        public Builder delayDuration(String delayDuration) {
            this.delayDuration = Optional.ofNullable(delayDuration);
            return this;
        }

        public Builder delayDuration(Nullable<String> delayDuration) {
            if (delayDuration.isNull()) {
                this.delayDuration = null;
            } else if (delayDuration.isEmpty()) {
                this.delayDuration = Optional.empty();
            } else {
                this.delayDuration = Optional.of(delayDuration.get());
            }
            return this;
        }

        /**
         * <p>If set to <code>true</code> and charging a Square Gift Card, a payment might be returned with
         * <code>amount_money</code> equal to less than what was requested. For example, a request for $20 when charging
         * a Square Gift Card with a balance of $5 results in an APPROVED payment of $5. You might choose
         * to prompt the buyer for an additional payment to cover the remainder or cancel the Gift Card
         * payment.</p>
         * <p>This parameter can only be set for a delayed capture payment (<code>autocomplete=false</code>).</p>
         * <p>For more information, see <a href="https://developer.squareup.com/docs/payments-api/take-payments/card-payments/partial-payments-with-gift-cards">Take Partial Payments</a>.</p>
         * <p>Default: false</p>
         */
        @JsonSetter(value = "accept_partial_authorization", nulls = Nulls.SKIP)
        public Builder acceptPartialAuthorization(Optional<Boolean> acceptPartialAuthorization) {
            this.acceptPartialAuthorization = acceptPartialAuthorization;
            return this;
        }

        public Builder acceptPartialAuthorization(Boolean acceptPartialAuthorization) {
            this.acceptPartialAuthorization = Optional.ofNullable(acceptPartialAuthorization);
            return this;
        }

        public Builder acceptPartialAuthorization(Nullable<Boolean> acceptPartialAuthorization) {
            if (acceptPartialAuthorization.isNull()) {
                this.acceptPartialAuthorization = null;
            } else if (acceptPartialAuthorization.isEmpty()) {
                this.acceptPartialAuthorization = Optional.empty();
            } else {
                this.acceptPartialAuthorization = Optional.of(acceptPartialAuthorization.get());
            }
            return this;
        }

        /**
         * <p>The action to be applied to the <code>Payment</code> when the delay_duration has elapsed.
         * The action must be CANCEL or COMPLETE.</p>
         * <p>The action cannot be set to COMPLETE if an <code>order_id</code> is present on the TerminalCheckout.</p>
         * <p>This parameter can only be set for a delayed capture payment (<code>autocomplete=false</code>). For more
         * information, see <a href="https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture#time-threshold">Delayed Capture</a>.</p>
         * <p>Default: CANCEL
         * See <a href="#type-delayaction">DelayAction</a> for possible values</p>
         */
        @JsonSetter(value = "delay_action", nulls = Nulls.SKIP)
        public Builder delayAction(Optional<PaymentOptionsDelayAction> delayAction) {
            this.delayAction = delayAction;
            return this;
        }

        public Builder delayAction(PaymentOptionsDelayAction delayAction) {
            this.delayAction = Optional.ofNullable(delayAction);
            return this;
        }

        public PaymentOptions build() {
            return new PaymentOptions(
                    autocomplete, delayDuration, acceptPartialAuthorization, delayAction, additionalProperties);
        }
    }
}
