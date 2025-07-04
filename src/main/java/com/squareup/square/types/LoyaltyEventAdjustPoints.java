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
@JsonDeserialize(builder = LoyaltyEventAdjustPoints.Builder.class)
public final class LoyaltyEventAdjustPoints {
    private final Optional<String> loyaltyProgramId;

    private final int points;

    private final Optional<String> reason;

    private final Map<String, Object> additionalProperties;

    private LoyaltyEventAdjustPoints(
            Optional<String> loyaltyProgramId,
            int points,
            Optional<String> reason,
            Map<String, Object> additionalProperties) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.points = points;
        this.reason = reason;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The Square-assigned ID of the <a href="entity:LoyaltyProgram">loyalty program</a>.
     */
    @JsonProperty("loyalty_program_id")
    public Optional<String> getLoyaltyProgramId() {
        return loyaltyProgramId;
    }

    /**
     * @return The number of points added or removed.
     */
    @JsonProperty("points")
    public int getPoints() {
        return points;
    }

    /**
     * @return The reason for the adjustment of points.
     */
    @JsonIgnore
    public Optional<String> getReason() {
        if (reason == null) {
            return Optional.empty();
        }
        return reason;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("reason")
    private Optional<String> _getReason() {
        return reason;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoyaltyEventAdjustPoints && equalTo((LoyaltyEventAdjustPoints) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LoyaltyEventAdjustPoints other) {
        return loyaltyProgramId.equals(other.loyaltyProgramId) && points == other.points && reason.equals(other.reason);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.loyaltyProgramId, this.points, this.reason);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PointsStage builder() {
        return new Builder();
    }

    public interface PointsStage {
        /**
         * <p>The number of points added or removed.</p>
         */
        _FinalStage points(int points);

        Builder from(LoyaltyEventAdjustPoints other);
    }

    public interface _FinalStage {
        LoyaltyEventAdjustPoints build();

        /**
         * <p>The Square-assigned ID of the <a href="entity:LoyaltyProgram">loyalty program</a>.</p>
         */
        _FinalStage loyaltyProgramId(Optional<String> loyaltyProgramId);

        _FinalStage loyaltyProgramId(String loyaltyProgramId);

        /**
         * <p>The reason for the adjustment of points.</p>
         */
        _FinalStage reason(Optional<String> reason);

        _FinalStage reason(String reason);

        _FinalStage reason(Nullable<String> reason);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PointsStage, _FinalStage {
        private int points;

        private Optional<String> reason = Optional.empty();

        private Optional<String> loyaltyProgramId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LoyaltyEventAdjustPoints other) {
            loyaltyProgramId(other.getLoyaltyProgramId());
            points(other.getPoints());
            reason(other.getReason());
            return this;
        }

        /**
         * <p>The number of points added or removed.</p>
         * <p>The number of points added or removed.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("points")
        public _FinalStage points(int points) {
            this.points = points;
            return this;
        }

        /**
         * <p>The reason for the adjustment of points.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage reason(Nullable<String> reason) {
            if (reason.isNull()) {
                this.reason = null;
            } else if (reason.isEmpty()) {
                this.reason = Optional.empty();
            } else {
                this.reason = Optional.of(reason.get());
            }
            return this;
        }

        /**
         * <p>The reason for the adjustment of points.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage reason(String reason) {
            this.reason = Optional.ofNullable(reason);
            return this;
        }

        /**
         * <p>The reason for the adjustment of points.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "reason", nulls = Nulls.SKIP)
        public _FinalStage reason(Optional<String> reason) {
            this.reason = reason;
            return this;
        }

        /**
         * <p>The Square-assigned ID of the <a href="entity:LoyaltyProgram">loyalty program</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage loyaltyProgramId(String loyaltyProgramId) {
            this.loyaltyProgramId = Optional.ofNullable(loyaltyProgramId);
            return this;
        }

        /**
         * <p>The Square-assigned ID of the <a href="entity:LoyaltyProgram">loyalty program</a>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "loyalty_program_id", nulls = Nulls.SKIP)
        public _FinalStage loyaltyProgramId(Optional<String> loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
            return this;
        }

        @java.lang.Override
        public LoyaltyEventAdjustPoints build() {
            return new LoyaltyEventAdjustPoints(loyaltyProgramId, points, reason, additionalProperties);
        }
    }
}
