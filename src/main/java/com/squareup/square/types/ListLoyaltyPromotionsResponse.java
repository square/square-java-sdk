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
@JsonDeserialize(builder = ListLoyaltyPromotionsResponse.Builder.class)
public final class ListLoyaltyPromotionsResponse {
    private final Optional<List<Error>> errors;

    private final Optional<List<LoyaltyPromotion>> loyaltyPromotions;

    private final Optional<String> cursor;

    private final Map<String, Object> additionalProperties;

    private ListLoyaltyPromotionsResponse(
            Optional<List<Error>> errors,
            Optional<List<LoyaltyPromotion>> loyaltyPromotions,
            Optional<String> cursor,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.loyaltyPromotions = loyaltyPromotions;
        this.cursor = cursor;
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
     * @return The retrieved loyalty promotions.
     */
    @JsonProperty("loyalty_promotions")
    public Optional<List<LoyaltyPromotion>> getLoyaltyPromotions() {
        return loyaltyPromotions;
    }

    /**
     * @return The cursor to use in your next call to this endpoint to retrieve the next page of results
     * for your original request. This field is present only if the request succeeded and additional
     * results are available. For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination">Pagination</a>.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListLoyaltyPromotionsResponse && equalTo((ListLoyaltyPromotionsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListLoyaltyPromotionsResponse other) {
        return errors.equals(other.errors)
                && loyaltyPromotions.equals(other.loyaltyPromotions)
                && cursor.equals(other.cursor);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.loyaltyPromotions, this.cursor);
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

        private Optional<List<LoyaltyPromotion>> loyaltyPromotions = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListLoyaltyPromotionsResponse other) {
            errors(other.getErrors());
            loyaltyPromotions(other.getLoyaltyPromotions());
            cursor(other.getCursor());
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        @JsonSetter(value = "loyalty_promotions", nulls = Nulls.SKIP)
        public Builder loyaltyPromotions(Optional<List<LoyaltyPromotion>> loyaltyPromotions) {
            this.loyaltyPromotions = loyaltyPromotions;
            return this;
        }

        public Builder loyaltyPromotions(List<LoyaltyPromotion> loyaltyPromotions) {
            this.loyaltyPromotions = Optional.ofNullable(loyaltyPromotions);
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
            return this;
        }

        public ListLoyaltyPromotionsResponse build() {
            return new ListLoyaltyPromotionsResponse(errors, loyaltyPromotions, cursor, additionalProperties);
        }
    }
}
