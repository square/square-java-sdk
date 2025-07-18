/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = LoyaltyPromotionTriggerLimit.Builder.class)
public final class LoyaltyPromotionTriggerLimit {
    private final int times;

    private final Optional<LoyaltyPromotionTriggerLimitInterval> interval;

    private final Map<String, Object> additionalProperties;

    private LoyaltyPromotionTriggerLimit(
            int times,
            Optional<LoyaltyPromotionTriggerLimitInterval> interval,
            Map<String, Object> additionalProperties) {
        this.times = times;
        this.interval = interval;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The maximum number of times a buyer can trigger the promotion during the specified <code>interval</code>.
     */
    @JsonProperty("times")
    public int getTimes() {
        return times;
    }

    /**
     * @return The time period the limit applies to.
     * See <a href="#type-loyaltypromotiontriggerlimitinterval">LoyaltyPromotionTriggerLimitInterval</a> for possible values
     */
    @JsonProperty("interval")
    public Optional<LoyaltyPromotionTriggerLimitInterval> getInterval() {
        return interval;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoyaltyPromotionTriggerLimit && equalTo((LoyaltyPromotionTriggerLimit) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LoyaltyPromotionTriggerLimit other) {
        return times == other.times && interval.equals(other.interval);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.times, this.interval);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TimesStage builder() {
        return new Builder();
    }

    public interface TimesStage {
        /**
         * <p>The maximum number of times a buyer can trigger the promotion during the specified <code>interval</code>.</p>
         */
        _FinalStage times(int times);

        Builder from(LoyaltyPromotionTriggerLimit other);
    }

    public interface _FinalStage {
        LoyaltyPromotionTriggerLimit build();

        /**
         * <p>The time period the limit applies to.
         * See <a href="#type-loyaltypromotiontriggerlimitinterval">LoyaltyPromotionTriggerLimitInterval</a> for possible values</p>
         */
        _FinalStage interval(Optional<LoyaltyPromotionTriggerLimitInterval> interval);

        _FinalStage interval(LoyaltyPromotionTriggerLimitInterval interval);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TimesStage, _FinalStage {
        private int times;

        private Optional<LoyaltyPromotionTriggerLimitInterval> interval = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LoyaltyPromotionTriggerLimit other) {
            times(other.getTimes());
            interval(other.getInterval());
            return this;
        }

        /**
         * <p>The maximum number of times a buyer can trigger the promotion during the specified <code>interval</code>.</p>
         * <p>The maximum number of times a buyer can trigger the promotion during the specified <code>interval</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("times")
        public _FinalStage times(int times) {
            this.times = times;
            return this;
        }

        /**
         * <p>The time period the limit applies to.
         * See <a href="#type-loyaltypromotiontriggerlimitinterval">LoyaltyPromotionTriggerLimitInterval</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage interval(LoyaltyPromotionTriggerLimitInterval interval) {
            this.interval = Optional.ofNullable(interval);
            return this;
        }

        /**
         * <p>The time period the limit applies to.
         * See <a href="#type-loyaltypromotiontriggerlimitinterval">LoyaltyPromotionTriggerLimitInterval</a> for possible values</p>
         */
        @java.lang.Override
        @JsonSetter(value = "interval", nulls = Nulls.SKIP)
        public _FinalStage interval(Optional<LoyaltyPromotionTriggerLimitInterval> interval) {
            this.interval = interval;
            return this;
        }

        @java.lang.Override
        public LoyaltyPromotionTriggerLimit build() {
            return new LoyaltyPromotionTriggerLimit(times, interval, additionalProperties);
        }
    }
}
