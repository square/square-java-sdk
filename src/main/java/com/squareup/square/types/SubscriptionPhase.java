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
@JsonDeserialize(builder = SubscriptionPhase.Builder.class)
public final class SubscriptionPhase {
    private final Optional<String> uid;

    private final SubscriptionCadence cadence;

    private final Optional<Integer> periods;

    private final Optional<Money> recurringPriceMoney;

    private final Optional<Long> ordinal;

    private final Optional<SubscriptionPricing> pricing;

    private final Map<String, Object> additionalProperties;

    private SubscriptionPhase(
            Optional<String> uid,
            SubscriptionCadence cadence,
            Optional<Integer> periods,
            Optional<Money> recurringPriceMoney,
            Optional<Long> ordinal,
            Optional<SubscriptionPricing> pricing,
            Map<String, Object> additionalProperties) {
        this.uid = uid;
        this.cadence = cadence;
        this.periods = periods;
        this.recurringPriceMoney = recurringPriceMoney;
        this.ordinal = ordinal;
        this.pricing = pricing;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The Square-assigned ID of the subscription phase. This field cannot be changed after a <code>SubscriptionPhase</code> is created.
     */
    @JsonIgnore
    public Optional<String> getUid() {
        if (uid == null) {
            return Optional.empty();
        }
        return uid;
    }

    /**
     * @return The billing cadence of the phase. For example, weekly or monthly. This field cannot be changed after a <code>SubscriptionPhase</code> is created.
     * See <a href="#type-subscriptioncadence">SubscriptionCadence</a> for possible values
     */
    @JsonProperty("cadence")
    public SubscriptionCadence getCadence() {
        return cadence;
    }

    /**
     * @return The number of <code>cadence</code>s the phase lasts. If not set, the phase never ends. Only the last phase can be indefinite. This field cannot be changed after a <code>SubscriptionPhase</code> is created.
     */
    @JsonIgnore
    public Optional<Integer> getPeriods() {
        if (periods == null) {
            return Optional.empty();
        }
        return periods;
    }

    /**
     * @return The amount to bill for each <code>cadence</code>. Failure to specify this field results in a <code>MISSING_REQUIRED_PARAMETER</code> error at runtime.
     */
    @JsonProperty("recurring_price_money")
    public Optional<Money> getRecurringPriceMoney() {
        return recurringPriceMoney;
    }

    /**
     * @return The position this phase appears in the sequence of phases defined for the plan, indexed from 0. This field cannot be changed after a <code>SubscriptionPhase</code> is created.
     */
    @JsonIgnore
    public Optional<Long> getOrdinal() {
        if (ordinal == null) {
            return Optional.empty();
        }
        return ordinal;
    }

    /**
     * @return The subscription pricing.
     */
    @JsonProperty("pricing")
    public Optional<SubscriptionPricing> getPricing() {
        return pricing;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("uid")
    private Optional<String> _getUid() {
        return uid;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("periods")
    private Optional<Integer> _getPeriods() {
        return periods;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("ordinal")
    private Optional<Long> _getOrdinal() {
        return ordinal;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SubscriptionPhase && equalTo((SubscriptionPhase) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SubscriptionPhase other) {
        return uid.equals(other.uid)
                && cadence.equals(other.cadence)
                && periods.equals(other.periods)
                && recurringPriceMoney.equals(other.recurringPriceMoney)
                && ordinal.equals(other.ordinal)
                && pricing.equals(other.pricing);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.uid, this.cadence, this.periods, this.recurringPriceMoney, this.ordinal, this.pricing);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CadenceStage builder() {
        return new Builder();
    }

    public interface CadenceStage {
        _FinalStage cadence(@NotNull SubscriptionCadence cadence);

        Builder from(SubscriptionPhase other);
    }

    public interface _FinalStage {
        SubscriptionPhase build();

        _FinalStage uid(Optional<String> uid);

        _FinalStage uid(String uid);

        _FinalStage uid(Nullable<String> uid);

        _FinalStage periods(Optional<Integer> periods);

        _FinalStage periods(Integer periods);

        _FinalStage periods(Nullable<Integer> periods);

        _FinalStage recurringPriceMoney(Optional<Money> recurringPriceMoney);

        _FinalStage recurringPriceMoney(Money recurringPriceMoney);

        _FinalStage ordinal(Optional<Long> ordinal);

        _FinalStage ordinal(Long ordinal);

        _FinalStage ordinal(Nullable<Long> ordinal);

        _FinalStage pricing(Optional<SubscriptionPricing> pricing);

        _FinalStage pricing(SubscriptionPricing pricing);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CadenceStage, _FinalStage {
        private SubscriptionCadence cadence;

        private Optional<SubscriptionPricing> pricing = Optional.empty();

        private Optional<Long> ordinal = Optional.empty();

        private Optional<Money> recurringPriceMoney = Optional.empty();

        private Optional<Integer> periods = Optional.empty();

        private Optional<String> uid = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(SubscriptionPhase other) {
            uid(other.getUid());
            cadence(other.getCadence());
            periods(other.getPeriods());
            recurringPriceMoney(other.getRecurringPriceMoney());
            ordinal(other.getOrdinal());
            pricing(other.getPricing());
            return this;
        }

        /**
         * <p>The billing cadence of the phase. For example, weekly or monthly. This field cannot be changed after a <code>SubscriptionPhase</code> is created.
         * See <a href="#type-subscriptioncadence">SubscriptionCadence</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("cadence")
        public _FinalStage cadence(@NotNull SubscriptionCadence cadence) {
            this.cadence = Objects.requireNonNull(cadence, "cadence must not be null");
            return this;
        }

        /**
         * <p>The subscription pricing.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage pricing(SubscriptionPricing pricing) {
            this.pricing = Optional.ofNullable(pricing);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "pricing", nulls = Nulls.SKIP)
        public _FinalStage pricing(Optional<SubscriptionPricing> pricing) {
            this.pricing = pricing;
            return this;
        }

        /**
         * <p>The position this phase appears in the sequence of phases defined for the plan, indexed from 0. This field cannot be changed after a <code>SubscriptionPhase</code> is created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage ordinal(Nullable<Long> ordinal) {
            if (ordinal.isNull()) {
                this.ordinal = null;
            } else if (ordinal.isEmpty()) {
                this.ordinal = Optional.empty();
            } else {
                this.ordinal = Optional.of(ordinal.get());
            }
            return this;
        }

        /**
         * <p>The position this phase appears in the sequence of phases defined for the plan, indexed from 0. This field cannot be changed after a <code>SubscriptionPhase</code> is created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage ordinal(Long ordinal) {
            this.ordinal = Optional.ofNullable(ordinal);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "ordinal", nulls = Nulls.SKIP)
        public _FinalStage ordinal(Optional<Long> ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        /**
         * <p>The amount to bill for each <code>cadence</code>. Failure to specify this field results in a <code>MISSING_REQUIRED_PARAMETER</code> error at runtime.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage recurringPriceMoney(Money recurringPriceMoney) {
            this.recurringPriceMoney = Optional.ofNullable(recurringPriceMoney);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "recurring_price_money", nulls = Nulls.SKIP)
        public _FinalStage recurringPriceMoney(Optional<Money> recurringPriceMoney) {
            this.recurringPriceMoney = recurringPriceMoney;
            return this;
        }

        /**
         * <p>The number of <code>cadence</code>s the phase lasts. If not set, the phase never ends. Only the last phase can be indefinite. This field cannot be changed after a <code>SubscriptionPhase</code> is created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage periods(Nullable<Integer> periods) {
            if (periods.isNull()) {
                this.periods = null;
            } else if (periods.isEmpty()) {
                this.periods = Optional.empty();
            } else {
                this.periods = Optional.of(periods.get());
            }
            return this;
        }

        /**
         * <p>The number of <code>cadence</code>s the phase lasts. If not set, the phase never ends. Only the last phase can be indefinite. This field cannot be changed after a <code>SubscriptionPhase</code> is created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage periods(Integer periods) {
            this.periods = Optional.ofNullable(periods);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "periods", nulls = Nulls.SKIP)
        public _FinalStage periods(Optional<Integer> periods) {
            this.periods = periods;
            return this;
        }

        /**
         * <p>The Square-assigned ID of the subscription phase. This field cannot be changed after a <code>SubscriptionPhase</code> is created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage uid(Nullable<String> uid) {
            if (uid.isNull()) {
                this.uid = null;
            } else if (uid.isEmpty()) {
                this.uid = Optional.empty();
            } else {
                this.uid = Optional.of(uid.get());
            }
            return this;
        }

        /**
         * <p>The Square-assigned ID of the subscription phase. This field cannot be changed after a <code>SubscriptionPhase</code> is created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage uid(String uid) {
            this.uid = Optional.ofNullable(uid);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "uid", nulls = Nulls.SKIP)
        public _FinalStage uid(Optional<String> uid) {
            this.uid = uid;
            return this;
        }

        @java.lang.Override
        public SubscriptionPhase build() {
            return new SubscriptionPhase(
                    uid, cadence, periods, recurringPriceMoney, ordinal, pricing, additionalProperties);
        }
    }
}
