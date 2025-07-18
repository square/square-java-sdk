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
@JsonDeserialize(builder = LoyaltyEventCreateReward.Builder.class)
public final class LoyaltyEventCreateReward {
    private final Optional<String> loyaltyProgramId;

    private final Optional<String> rewardId;

    private final Optional<Integer> points;

    private final Map<String, Object> additionalProperties;

    private LoyaltyEventCreateReward(
            Optional<String> loyaltyProgramId,
            Optional<String> rewardId,
            Optional<Integer> points,
            Map<String, Object> additionalProperties) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.rewardId = rewardId;
        this.points = points;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the <a href="entity:LoyaltyProgram">loyalty program</a>.
     */
    @JsonProperty("loyalty_program_id")
    public Optional<String> getLoyaltyProgramId() {
        return loyaltyProgramId;
    }

    /**
     * @return The Square-assigned ID of the created <a href="entity:LoyaltyReward">loyalty reward</a>.
     * This field is returned only if the event source is <code>LOYALTY_API</code>.
     */
    @JsonProperty("reward_id")
    public Optional<String> getRewardId() {
        return rewardId;
    }

    /**
     * @return The loyalty points used to create the reward.
     */
    @JsonProperty("points")
    public Optional<Integer> getPoints() {
        return points;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoyaltyEventCreateReward && equalTo((LoyaltyEventCreateReward) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LoyaltyEventCreateReward other) {
        return loyaltyProgramId.equals(other.loyaltyProgramId)
                && rewardId.equals(other.rewardId)
                && points.equals(other.points);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.loyaltyProgramId, this.rewardId, this.points);
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
        private Optional<String> loyaltyProgramId = Optional.empty();

        private Optional<String> rewardId = Optional.empty();

        private Optional<Integer> points = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(LoyaltyEventCreateReward other) {
            loyaltyProgramId(other.getLoyaltyProgramId());
            rewardId(other.getRewardId());
            points(other.getPoints());
            return this;
        }

        /**
         * <p>The ID of the <a href="entity:LoyaltyProgram">loyalty program</a>.</p>
         */
        @JsonSetter(value = "loyalty_program_id", nulls = Nulls.SKIP)
        public Builder loyaltyProgramId(Optional<String> loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
            return this;
        }

        public Builder loyaltyProgramId(String loyaltyProgramId) {
            this.loyaltyProgramId = Optional.ofNullable(loyaltyProgramId);
            return this;
        }

        /**
         * <p>The Square-assigned ID of the created <a href="entity:LoyaltyReward">loyalty reward</a>.
         * This field is returned only if the event source is <code>LOYALTY_API</code>.</p>
         */
        @JsonSetter(value = "reward_id", nulls = Nulls.SKIP)
        public Builder rewardId(Optional<String> rewardId) {
            this.rewardId = rewardId;
            return this;
        }

        public Builder rewardId(String rewardId) {
            this.rewardId = Optional.ofNullable(rewardId);
            return this;
        }

        /**
         * <p>The loyalty points used to create the reward.</p>
         */
        @JsonSetter(value = "points", nulls = Nulls.SKIP)
        public Builder points(Optional<Integer> points) {
            this.points = points;
            return this;
        }

        public Builder points(Integer points) {
            this.points = Optional.ofNullable(points);
            return this;
        }

        public LoyaltyEventCreateReward build() {
            return new LoyaltyEventCreateReward(loyaltyProgramId, rewardId, points, additionalProperties);
        }
    }
}
