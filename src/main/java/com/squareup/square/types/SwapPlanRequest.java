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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SwapPlanRequest.Builder.class)
public final class SwapPlanRequest {
    private final String subscriptionId;

    private final Optional<String> newPlanVariationId;

    private final Optional<List<PhaseInput>> phases;

    private final Map<String, Object> additionalProperties;

    private SwapPlanRequest(
            String subscriptionId,
            Optional<String> newPlanVariationId,
            Optional<List<PhaseInput>> phases,
            Map<String, Object> additionalProperties) {
        this.subscriptionId = subscriptionId;
        this.newPlanVariationId = newPlanVariationId;
        this.phases = phases;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the subscription to swap the subscription plan for.
     */
    @JsonProperty("subscription_id")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * @return The ID of the new subscription plan variation.
     * <p>This field is required.</p>
     */
    @JsonIgnore
    public Optional<String> getNewPlanVariationId() {
        if (newPlanVariationId == null) {
            return Optional.empty();
        }
        return newPlanVariationId;
    }

    /**
     * @return A list of PhaseInputs, to pass phase-specific information used in the swap.
     */
    @JsonIgnore
    public Optional<List<PhaseInput>> getPhases() {
        if (phases == null) {
            return Optional.empty();
        }
        return phases;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("new_plan_variation_id")
    private Optional<String> _getNewPlanVariationId() {
        return newPlanVariationId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("phases")
    private Optional<List<PhaseInput>> _getPhases() {
        return phases;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SwapPlanRequest && equalTo((SwapPlanRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SwapPlanRequest other) {
        return subscriptionId.equals(other.subscriptionId)
                && newPlanVariationId.equals(other.newPlanVariationId)
                && phases.equals(other.phases);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.subscriptionId, this.newPlanVariationId, this.phases);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SubscriptionIdStage builder() {
        return new Builder();
    }

    public interface SubscriptionIdStage {
        _FinalStage subscriptionId(@NotNull String subscriptionId);

        Builder from(SwapPlanRequest other);
    }

    public interface _FinalStage {
        SwapPlanRequest build();

        _FinalStage newPlanVariationId(Optional<String> newPlanVariationId);

        _FinalStage newPlanVariationId(String newPlanVariationId);

        _FinalStage newPlanVariationId(Nullable<String> newPlanVariationId);

        _FinalStage phases(Optional<List<PhaseInput>> phases);

        _FinalStage phases(List<PhaseInput> phases);

        _FinalStage phases(Nullable<List<PhaseInput>> phases);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SubscriptionIdStage, _FinalStage {
        private String subscriptionId;

        private Optional<List<PhaseInput>> phases = Optional.empty();

        private Optional<String> newPlanVariationId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(SwapPlanRequest other) {
            subscriptionId(other.getSubscriptionId());
            newPlanVariationId(other.getNewPlanVariationId());
            phases(other.getPhases());
            return this;
        }

        /**
         * <p>The ID of the subscription to swap the subscription plan for.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("subscription_id")
        public _FinalStage subscriptionId(@NotNull String subscriptionId) {
            this.subscriptionId = Objects.requireNonNull(subscriptionId, "subscriptionId must not be null");
            return this;
        }

        /**
         * <p>A list of PhaseInputs, to pass phase-specific information used in the swap.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage phases(Nullable<List<PhaseInput>> phases) {
            if (phases.isNull()) {
                this.phases = null;
            } else if (phases.isEmpty()) {
                this.phases = Optional.empty();
            } else {
                this.phases = Optional.of(phases.get());
            }
            return this;
        }

        /**
         * <p>A list of PhaseInputs, to pass phase-specific information used in the swap.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage phases(List<PhaseInput> phases) {
            this.phases = Optional.ofNullable(phases);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "phases", nulls = Nulls.SKIP)
        public _FinalStage phases(Optional<List<PhaseInput>> phases) {
            this.phases = phases;
            return this;
        }

        /**
         * <p>The ID of the new subscription plan variation.</p>
         * <p>This field is required.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage newPlanVariationId(Nullable<String> newPlanVariationId) {
            if (newPlanVariationId.isNull()) {
                this.newPlanVariationId = null;
            } else if (newPlanVariationId.isEmpty()) {
                this.newPlanVariationId = Optional.empty();
            } else {
                this.newPlanVariationId = Optional.of(newPlanVariationId.get());
            }
            return this;
        }

        /**
         * <p>The ID of the new subscription plan variation.</p>
         * <p>This field is required.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage newPlanVariationId(String newPlanVariationId) {
            this.newPlanVariationId = Optional.ofNullable(newPlanVariationId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "new_plan_variation_id", nulls = Nulls.SKIP)
        public _FinalStage newPlanVariationId(Optional<String> newPlanVariationId) {
            this.newPlanVariationId = newPlanVariationId;
            return this;
        }

        @java.lang.Override
        public SwapPlanRequest build() {
            return new SwapPlanRequest(subscriptionId, newPlanVariationId, phases, additionalProperties);
        }
    }
}
