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
@JsonDeserialize(builder = LoyaltyPromotionIncentive.Builder.class)
public final class LoyaltyPromotionIncentive {
    private final LoyaltyPromotionIncentiveType type;

    private final Optional<LoyaltyPromotionIncentivePointsMultiplierData> pointsMultiplierData;

    private final Optional<LoyaltyPromotionIncentivePointsAdditionData> pointsAdditionData;

    private final Map<String, Object> additionalProperties;

    private LoyaltyPromotionIncentive(
            LoyaltyPromotionIncentiveType type,
            Optional<LoyaltyPromotionIncentivePointsMultiplierData> pointsMultiplierData,
            Optional<LoyaltyPromotionIncentivePointsAdditionData> pointsAdditionData,
            Map<String, Object> additionalProperties) {
        this.type = type;
        this.pointsMultiplierData = pointsMultiplierData;
        this.pointsAdditionData = pointsAdditionData;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The type of points incentive.
     * See <a href="#type-loyaltypromotionincentivetype">LoyaltyPromotionIncentiveType</a> for possible values
     */
    @JsonProperty("type")
    public LoyaltyPromotionIncentiveType getType() {
        return type;
    }

    /**
     * @return Additional data for a <code>POINTS_MULTIPLIER</code> incentive type.
     */
    @JsonProperty("points_multiplier_data")
    public Optional<LoyaltyPromotionIncentivePointsMultiplierData> getPointsMultiplierData() {
        return pointsMultiplierData;
    }

    /**
     * @return Additional data for a <code>POINTS_ADDITION</code> incentive type.
     */
    @JsonProperty("points_addition_data")
    public Optional<LoyaltyPromotionIncentivePointsAdditionData> getPointsAdditionData() {
        return pointsAdditionData;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoyaltyPromotionIncentive && equalTo((LoyaltyPromotionIncentive) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LoyaltyPromotionIncentive other) {
        return type.equals(other.type)
                && pointsMultiplierData.equals(other.pointsMultiplierData)
                && pointsAdditionData.equals(other.pointsAdditionData);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type, this.pointsMultiplierData, this.pointsAdditionData);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TypeStage builder() {
        return new Builder();
    }

    public interface TypeStage {
        /**
         * <p>The type of points incentive.
         * See <a href="#type-loyaltypromotionincentivetype">LoyaltyPromotionIncentiveType</a> for possible values</p>
         */
        _FinalStage type(@NotNull LoyaltyPromotionIncentiveType type);

        Builder from(LoyaltyPromotionIncentive other);
    }

    public interface _FinalStage {
        LoyaltyPromotionIncentive build();

        /**
         * <p>Additional data for a <code>POINTS_MULTIPLIER</code> incentive type.</p>
         */
        _FinalStage pointsMultiplierData(Optional<LoyaltyPromotionIncentivePointsMultiplierData> pointsMultiplierData);

        _FinalStage pointsMultiplierData(LoyaltyPromotionIncentivePointsMultiplierData pointsMultiplierData);

        /**
         * <p>Additional data for a <code>POINTS_ADDITION</code> incentive type.</p>
         */
        _FinalStage pointsAdditionData(Optional<LoyaltyPromotionIncentivePointsAdditionData> pointsAdditionData);

        _FinalStage pointsAdditionData(LoyaltyPromotionIncentivePointsAdditionData pointsAdditionData);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TypeStage, _FinalStage {
        private LoyaltyPromotionIncentiveType type;

        private Optional<LoyaltyPromotionIncentivePointsAdditionData> pointsAdditionData = Optional.empty();

        private Optional<LoyaltyPromotionIncentivePointsMultiplierData> pointsMultiplierData = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LoyaltyPromotionIncentive other) {
            type(other.getType());
            pointsMultiplierData(other.getPointsMultiplierData());
            pointsAdditionData(other.getPointsAdditionData());
            return this;
        }

        /**
         * <p>The type of points incentive.
         * See <a href="#type-loyaltypromotionincentivetype">LoyaltyPromotionIncentiveType</a> for possible values</p>
         * <p>The type of points incentive.
         * See <a href="#type-loyaltypromotionincentivetype">LoyaltyPromotionIncentiveType</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("type")
        public _FinalStage type(@NotNull LoyaltyPromotionIncentiveType type) {
            this.type = Objects.requireNonNull(type, "type must not be null");
            return this;
        }

        /**
         * <p>Additional data for a <code>POINTS_ADDITION</code> incentive type.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage pointsAdditionData(LoyaltyPromotionIncentivePointsAdditionData pointsAdditionData) {
            this.pointsAdditionData = Optional.ofNullable(pointsAdditionData);
            return this;
        }

        /**
         * <p>Additional data for a <code>POINTS_ADDITION</code> incentive type.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "points_addition_data", nulls = Nulls.SKIP)
        public _FinalStage pointsAdditionData(
                Optional<LoyaltyPromotionIncentivePointsAdditionData> pointsAdditionData) {
            this.pointsAdditionData = pointsAdditionData;
            return this;
        }

        /**
         * <p>Additional data for a <code>POINTS_MULTIPLIER</code> incentive type.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage pointsMultiplierData(LoyaltyPromotionIncentivePointsMultiplierData pointsMultiplierData) {
            this.pointsMultiplierData = Optional.ofNullable(pointsMultiplierData);
            return this;
        }

        /**
         * <p>Additional data for a <code>POINTS_MULTIPLIER</code> incentive type.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "points_multiplier_data", nulls = Nulls.SKIP)
        public _FinalStage pointsMultiplierData(
                Optional<LoyaltyPromotionIncentivePointsMultiplierData> pointsMultiplierData) {
            this.pointsMultiplierData = pointsMultiplierData;
            return this;
        }

        @java.lang.Override
        public LoyaltyPromotionIncentive build() {
            return new LoyaltyPromotionIncentive(type, pointsMultiplierData, pointsAdditionData, additionalProperties);
        }
    }
}
