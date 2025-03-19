/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.customers.types;

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
@JsonDeserialize(builder = DeleteCardsRequest.Builder.class)
public final class DeleteCardsRequest {
    private final String customerId;

    private final String cardId;

    private final Map<String, Object> additionalProperties;

    private DeleteCardsRequest(String customerId, String cardId, Map<String, Object> additionalProperties) {
        this.customerId = customerId;
        this.cardId = cardId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the customer that the card on file belongs to.
     */
    @JsonProperty("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @return The ID of the card on file to delete.
     */
    @JsonProperty("card_id")
    public String getCardId() {
        return cardId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DeleteCardsRequest && equalTo((DeleteCardsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DeleteCardsRequest other) {
        return customerId.equals(other.customerId) && cardId.equals(other.cardId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.customerId, this.cardId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CustomerIdStage builder() {
        return new Builder();
    }

    public interface CustomerIdStage {
        CardIdStage customerId(@NotNull String customerId);

        Builder from(DeleteCardsRequest other);
    }

    public interface CardIdStage {
        _FinalStage cardId(@NotNull String cardId);
    }

    public interface _FinalStage {
        DeleteCardsRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CustomerIdStage, CardIdStage, _FinalStage {
        private String customerId;

        private String cardId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DeleteCardsRequest other) {
            customerId(other.getCustomerId());
            cardId(other.getCardId());
            return this;
        }

        /**
         * <p>The ID of the customer that the card on file belongs to.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("customer_id")
        public CardIdStage customerId(@NotNull String customerId) {
            this.customerId = Objects.requireNonNull(customerId, "customerId must not be null");
            return this;
        }

        /**
         * <p>The ID of the card on file to delete.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("card_id")
        public _FinalStage cardId(@NotNull String cardId) {
            this.cardId = Objects.requireNonNull(cardId, "cardId must not be null");
            return this;
        }

        @java.lang.Override
        public DeleteCardsRequest build() {
            return new DeleteCardsRequest(customerId, cardId, additionalProperties);
        }
    }
}
