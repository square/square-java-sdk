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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CalculateLoyaltyPointsResponse.Builder.class)
public final class CalculateLoyaltyPointsResponse {
    private final Optional<List<Error>> errors;

    private final Optional<Integer> points;

    private final Optional<Integer> promotionPoints;

    private final Map<String, Object> additionalProperties;

    private CalculateLoyaltyPointsResponse(
            Optional<List<Error>> errors,
            Optional<Integer> points,
            Optional<Integer> promotionPoints,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.points = points;
        this.promotionPoints = promotionPoints;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Any errors that occurred during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The number of points that the buyer can earn from the base loyalty program.
     */
    @JsonProperty("points")
    public Optional<Integer> getPoints() {
        return points;
    }

    /**
     * @return The number of points that the buyer can earn from a loyalty promotion. To be eligible
     * to earn promotion points, the purchase must first qualify for program points. When <code>order_id</code>
     * is not provided in the request, this value is always 0.
     */
    @JsonProperty("promotion_points")
    public Optional<Integer> getPromotionPoints() {
        return promotionPoints;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CalculateLoyaltyPointsResponse && equalTo((CalculateLoyaltyPointsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CalculateLoyaltyPointsResponse other) {
        return errors.equals(other.errors)
                && points.equals(other.points)
                && promotionPoints.equals(other.promotionPoints);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.points, this.promotionPoints);
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
        private Optional<List<Error>> errors = Optional.empty();

        private Optional<Integer> points = Optional.empty();

        private Optional<Integer> promotionPoints = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CalculateLoyaltyPointsResponse other) {
            errors(other.getErrors());
            points(other.getPoints());
            promotionPoints(other.getPromotionPoints());
            return this;
        }

        /**
         * <p>Any errors that occurred during the request.</p>
         */
        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        /**
         * <p>The number of points that the buyer can earn from the base loyalty program.</p>
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

        /**
         * <p>The number of points that the buyer can earn from a loyalty promotion. To be eligible
         * to earn promotion points, the purchase must first qualify for program points. When <code>order_id</code>
         * is not provided in the request, this value is always 0.</p>
         */
        @JsonSetter(value = "promotion_points", nulls = Nulls.SKIP)
        public Builder promotionPoints(Optional<Integer> promotionPoints) {
            this.promotionPoints = promotionPoints;
            return this;
        }

        public Builder promotionPoints(Integer promotionPoints) {
            this.promotionPoints = Optional.ofNullable(promotionPoints);
            return this;
        }

        public CalculateLoyaltyPointsResponse build() {
            return new CalculateLoyaltyPointsResponse(errors, points, promotionPoints, additionalProperties);
        }
    }
}
