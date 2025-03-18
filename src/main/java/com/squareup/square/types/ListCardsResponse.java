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
@JsonDeserialize(builder = ListCardsResponse.Builder.class)
public final class ListCardsResponse {
    private final Optional<List<Error>> errors;

    private final Optional<List<Card>> cards;

    private final Optional<String> cursor;

    private final Map<String, Object> additionalProperties;

    private ListCardsResponse(
            Optional<List<Error>> errors,
            Optional<List<Card>> cards,
            Optional<String> cursor,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.cards = cards;
        this.cursor = cursor;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Information on errors encountered during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The requested list of <code>Card</code>s.
     */
    @JsonProperty("cards")
    public Optional<List<Card>> getCards() {
        return cards;
    }

    /**
     * @return The pagination cursor to be used in a subsequent request. If empty,
     * this is the final response.
     * <p>See <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination">Pagination</a> for more information.</p>
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListCardsResponse && equalTo((ListCardsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListCardsResponse other) {
        return errors.equals(other.errors) && cards.equals(other.cards) && cursor.equals(other.cursor);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.cards, this.cursor);
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

        private Optional<List<Card>> cards = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListCardsResponse other) {
            errors(other.getErrors());
            cards(other.getCards());
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

        @JsonSetter(value = "cards", nulls = Nulls.SKIP)
        public Builder cards(Optional<List<Card>> cards) {
            this.cards = cards;
            return this;
        }

        public Builder cards(List<Card> cards) {
            this.cards = Optional.ofNullable(cards);
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

        public ListCardsResponse build() {
            return new ListCardsResponse(errors, cards, cursor, additionalProperties);
        }
    }
}
