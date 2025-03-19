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
@JsonDeserialize(builder = ListGiftCardsResponse.Builder.class)
public final class ListGiftCardsResponse {
    private final Optional<List<Error>> errors;

    private final Optional<List<GiftCard>> giftCards;

    private final Optional<String> cursor;

    private final Map<String, Object> additionalProperties;

    private ListGiftCardsResponse(
            Optional<List<Error>> errors,
            Optional<List<GiftCard>> giftCards,
            Optional<String> cursor,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.giftCards = giftCards;
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
     * @return The requested gift cards or an empty object if none are found.
     */
    @JsonProperty("gift_cards")
    public Optional<List<GiftCard>> getGiftCards() {
        return giftCards;
    }

    /**
     * @return When a response is truncated, it includes a cursor that you can use in a
     * subsequent request to retrieve the next set of gift cards. If a cursor is not present, this is
     * the final response.
     * For more information, see <a href="https://developer.squareup.com/docs/working-with-apis/pagination">Pagination</a>.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListGiftCardsResponse && equalTo((ListGiftCardsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListGiftCardsResponse other) {
        return errors.equals(other.errors) && giftCards.equals(other.giftCards) && cursor.equals(other.cursor);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.giftCards, this.cursor);
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

        private Optional<List<GiftCard>> giftCards = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListGiftCardsResponse other) {
            errors(other.getErrors());
            giftCards(other.getGiftCards());
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

        @JsonSetter(value = "gift_cards", nulls = Nulls.SKIP)
        public Builder giftCards(Optional<List<GiftCard>> giftCards) {
            this.giftCards = giftCards;
            return this;
        }

        public Builder giftCards(List<GiftCard> giftCards) {
            this.giftCards = Optional.ofNullable(giftCards);
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

        public ListGiftCardsResponse build() {
            return new ListGiftCardsResponse(errors, giftCards, cursor, additionalProperties);
        }
    }
}
