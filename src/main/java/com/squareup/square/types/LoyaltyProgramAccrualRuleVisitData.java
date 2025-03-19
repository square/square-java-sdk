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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = LoyaltyProgramAccrualRuleVisitData.Builder.class)
public final class LoyaltyProgramAccrualRuleVisitData {
    private final Optional<Money> minimumAmountMoney;

    private final LoyaltyProgramAccrualRuleTaxMode taxMode;

    private final Map<String, Object> additionalProperties;

    private LoyaltyProgramAccrualRuleVisitData(
            Optional<Money> minimumAmountMoney,
            LoyaltyProgramAccrualRuleTaxMode taxMode,
            Map<String, Object> additionalProperties) {
        this.minimumAmountMoney = minimumAmountMoney;
        this.taxMode = taxMode;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The minimum purchase required during the visit to quality for points.
     */
    @JsonProperty("minimum_amount_money")
    public Optional<Money> getMinimumAmountMoney() {
        return minimumAmountMoney;
    }

    /**
     * @return Indicates how taxes should be treated when calculating the purchase amount to determine whether the visit qualifies for points.
     * This setting applies only if <code>minimum_amount_money</code> is specified.
     * See <a href="#type-loyaltyprogramaccrualruletaxmode">LoyaltyProgramAccrualRuleTaxMode</a> for possible values
     */
    @JsonProperty("tax_mode")
    public LoyaltyProgramAccrualRuleTaxMode getTaxMode() {
        return taxMode;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoyaltyProgramAccrualRuleVisitData
                && equalTo((LoyaltyProgramAccrualRuleVisitData) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LoyaltyProgramAccrualRuleVisitData other) {
        return minimumAmountMoney.equals(other.minimumAmountMoney) && taxMode.equals(other.taxMode);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.minimumAmountMoney, this.taxMode);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TaxModeStage builder() {
        return new Builder();
    }

    public interface TaxModeStage {
        _FinalStage taxMode(@NotNull LoyaltyProgramAccrualRuleTaxMode taxMode);

        Builder from(LoyaltyProgramAccrualRuleVisitData other);
    }

    public interface _FinalStage {
        LoyaltyProgramAccrualRuleVisitData build();

        _FinalStage minimumAmountMoney(Optional<Money> minimumAmountMoney);

        _FinalStage minimumAmountMoney(Money minimumAmountMoney);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TaxModeStage, _FinalStage {
        private LoyaltyProgramAccrualRuleTaxMode taxMode;

        private Optional<Money> minimumAmountMoney = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LoyaltyProgramAccrualRuleVisitData other) {
            minimumAmountMoney(other.getMinimumAmountMoney());
            taxMode(other.getTaxMode());
            return this;
        }

        /**
         * <p>Indicates how taxes should be treated when calculating the purchase amount to determine whether the visit qualifies for points.
         * This setting applies only if <code>minimum_amount_money</code> is specified.
         * See <a href="#type-loyaltyprogramaccrualruletaxmode">LoyaltyProgramAccrualRuleTaxMode</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("tax_mode")
        public _FinalStage taxMode(@NotNull LoyaltyProgramAccrualRuleTaxMode taxMode) {
            this.taxMode = Objects.requireNonNull(taxMode, "taxMode must not be null");
            return this;
        }

        /**
         * <p>The minimum purchase required during the visit to quality for points.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage minimumAmountMoney(Money minimumAmountMoney) {
            this.minimumAmountMoney = Optional.ofNullable(minimumAmountMoney);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "minimum_amount_money", nulls = Nulls.SKIP)
        public _FinalStage minimumAmountMoney(Optional<Money> minimumAmountMoney) {
            this.minimumAmountMoney = minimumAmountMoney;
            return this;
        }

        @java.lang.Override
        public LoyaltyProgramAccrualRuleVisitData build() {
            return new LoyaltyProgramAccrualRuleVisitData(minimumAmountMoney, taxMode, additionalProperties);
        }
    }
}
