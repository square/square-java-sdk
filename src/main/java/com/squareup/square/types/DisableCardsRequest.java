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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DisableCardsRequest.Builder.class)
public final class DisableCardsRequest {
    private final String cardId;

    private final Map<String, Object> additionalProperties;

    private DisableCardsRequest(String cardId, Map<String, Object> additionalProperties) {
        this.cardId = cardId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Unique ID for the desired Card.
     */
    @JsonProperty("card_id")
    public String getCardId() {
        return cardId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DisableCardsRequest && equalTo((DisableCardsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DisableCardsRequest other) {
        return cardId.equals(other.cardId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.cardId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CardIdStage builder() {
        return new Builder();
    }

    public interface CardIdStage {
        /**
         * <p>Unique ID for the desired Card.</p>
         */
        _FinalStage cardId(@NotNull String cardId);

        Builder from(DisableCardsRequest other);
    }

    public interface _FinalStage {
        DisableCardsRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CardIdStage, _FinalStage {
        private String cardId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DisableCardsRequest other) {
            cardId(other.getCardId());
            return this;
        }

        /**
         * <p>Unique ID for the desired Card.</p>
         * <p>Unique ID for the desired Card.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("card_id")
        public _FinalStage cardId(@NotNull String cardId) {
            this.cardId = Objects.requireNonNull(cardId, "cardId must not be null");
            return this;
        }

        @java.lang.Override
        public DisableCardsRequest build() {
            return new DisableCardsRequest(cardId, additionalProperties);
        }
    }
}
