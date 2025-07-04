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
@JsonDeserialize(builder = ChangeBillingAnchorDateRequest.Builder.class)
public final class ChangeBillingAnchorDateRequest {
    private final String subscriptionId;

    private final Optional<Integer> monthlyBillingAnchorDate;

    private final Optional<String> effectiveDate;

    private final Map<String, Object> additionalProperties;

    private ChangeBillingAnchorDateRequest(
            String subscriptionId,
            Optional<Integer> monthlyBillingAnchorDate,
            Optional<String> effectiveDate,
            Map<String, Object> additionalProperties) {
        this.subscriptionId = subscriptionId;
        this.monthlyBillingAnchorDate = monthlyBillingAnchorDate;
        this.effectiveDate = effectiveDate;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the subscription to update the billing anchor date.
     */
    @JsonProperty("subscription_id")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * @return The anchor day for the billing cycle.
     */
    @JsonIgnore
    public Optional<Integer> getMonthlyBillingAnchorDate() {
        if (monthlyBillingAnchorDate == null) {
            return Optional.empty();
        }
        return monthlyBillingAnchorDate;
    }

    /**
     * @return The <code>YYYY-MM-DD</code>-formatted date when the scheduled <code>BILLING_ANCHOR_CHANGE</code> action takes
     * place on the subscription.
     * <p>When this date is unspecified or falls within the current billing cycle, the billing anchor date
     * is changed immediately.</p>
     */
    @JsonIgnore
    public Optional<String> getEffectiveDate() {
        if (effectiveDate == null) {
            return Optional.empty();
        }
        return effectiveDate;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("monthly_billing_anchor_date")
    private Optional<Integer> _getMonthlyBillingAnchorDate() {
        return monthlyBillingAnchorDate;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("effective_date")
    private Optional<String> _getEffectiveDate() {
        return effectiveDate;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChangeBillingAnchorDateRequest && equalTo((ChangeBillingAnchorDateRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChangeBillingAnchorDateRequest other) {
        return subscriptionId.equals(other.subscriptionId)
                && monthlyBillingAnchorDate.equals(other.monthlyBillingAnchorDate)
                && effectiveDate.equals(other.effectiveDate);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.subscriptionId, this.monthlyBillingAnchorDate, this.effectiveDate);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SubscriptionIdStage builder() {
        return new Builder();
    }

    public interface SubscriptionIdStage {
        /**
         * <p>The ID of the subscription to update the billing anchor date.</p>
         */
        _FinalStage subscriptionId(@NotNull String subscriptionId);

        Builder from(ChangeBillingAnchorDateRequest other);
    }

    public interface _FinalStage {
        ChangeBillingAnchorDateRequest build();

        /**
         * <p>The anchor day for the billing cycle.</p>
         */
        _FinalStage monthlyBillingAnchorDate(Optional<Integer> monthlyBillingAnchorDate);

        _FinalStage monthlyBillingAnchorDate(Integer monthlyBillingAnchorDate);

        _FinalStage monthlyBillingAnchorDate(Nullable<Integer> monthlyBillingAnchorDate);

        /**
         * <p>The <code>YYYY-MM-DD</code>-formatted date when the scheduled <code>BILLING_ANCHOR_CHANGE</code> action takes
         * place on the subscription.</p>
         * <p>When this date is unspecified or falls within the current billing cycle, the billing anchor date
         * is changed immediately.</p>
         */
        _FinalStage effectiveDate(Optional<String> effectiveDate);

        _FinalStage effectiveDate(String effectiveDate);

        _FinalStage effectiveDate(Nullable<String> effectiveDate);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SubscriptionIdStage, _FinalStage {
        private String subscriptionId;

        private Optional<String> effectiveDate = Optional.empty();

        private Optional<Integer> monthlyBillingAnchorDate = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ChangeBillingAnchorDateRequest other) {
            subscriptionId(other.getSubscriptionId());
            monthlyBillingAnchorDate(other.getMonthlyBillingAnchorDate());
            effectiveDate(other.getEffectiveDate());
            return this;
        }

        /**
         * <p>The ID of the subscription to update the billing anchor date.</p>
         * <p>The ID of the subscription to update the billing anchor date.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("subscription_id")
        public _FinalStage subscriptionId(@NotNull String subscriptionId) {
            this.subscriptionId = Objects.requireNonNull(subscriptionId, "subscriptionId must not be null");
            return this;
        }

        /**
         * <p>The <code>YYYY-MM-DD</code>-formatted date when the scheduled <code>BILLING_ANCHOR_CHANGE</code> action takes
         * place on the subscription.</p>
         * <p>When this date is unspecified or falls within the current billing cycle, the billing anchor date
         * is changed immediately.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage effectiveDate(Nullable<String> effectiveDate) {
            if (effectiveDate.isNull()) {
                this.effectiveDate = null;
            } else if (effectiveDate.isEmpty()) {
                this.effectiveDate = Optional.empty();
            } else {
                this.effectiveDate = Optional.of(effectiveDate.get());
            }
            return this;
        }

        /**
         * <p>The <code>YYYY-MM-DD</code>-formatted date when the scheduled <code>BILLING_ANCHOR_CHANGE</code> action takes
         * place on the subscription.</p>
         * <p>When this date is unspecified or falls within the current billing cycle, the billing anchor date
         * is changed immediately.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage effectiveDate(String effectiveDate) {
            this.effectiveDate = Optional.ofNullable(effectiveDate);
            return this;
        }

        /**
         * <p>The <code>YYYY-MM-DD</code>-formatted date when the scheduled <code>BILLING_ANCHOR_CHANGE</code> action takes
         * place on the subscription.</p>
         * <p>When this date is unspecified or falls within the current billing cycle, the billing anchor date
         * is changed immediately.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "effective_date", nulls = Nulls.SKIP)
        public _FinalStage effectiveDate(Optional<String> effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        /**
         * <p>The anchor day for the billing cycle.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage monthlyBillingAnchorDate(Nullable<Integer> monthlyBillingAnchorDate) {
            if (monthlyBillingAnchorDate.isNull()) {
                this.monthlyBillingAnchorDate = null;
            } else if (monthlyBillingAnchorDate.isEmpty()) {
                this.monthlyBillingAnchorDate = Optional.empty();
            } else {
                this.monthlyBillingAnchorDate = Optional.of(monthlyBillingAnchorDate.get());
            }
            return this;
        }

        /**
         * <p>The anchor day for the billing cycle.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage monthlyBillingAnchorDate(Integer monthlyBillingAnchorDate) {
            this.monthlyBillingAnchorDate = Optional.ofNullable(monthlyBillingAnchorDate);
            return this;
        }

        /**
         * <p>The anchor day for the billing cycle.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "monthly_billing_anchor_date", nulls = Nulls.SKIP)
        public _FinalStage monthlyBillingAnchorDate(Optional<Integer> monthlyBillingAnchorDate) {
            this.monthlyBillingAnchorDate = monthlyBillingAnchorDate;
            return this;
        }

        @java.lang.Override
        public ChangeBillingAnchorDateRequest build() {
            return new ChangeBillingAnchorDateRequest(
                    subscriptionId, monthlyBillingAnchorDate, effectiveDate, additionalProperties);
        }
    }
}
