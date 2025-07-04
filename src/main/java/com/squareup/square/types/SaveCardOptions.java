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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SaveCardOptions.Builder.class)
public final class SaveCardOptions {
    private final String customerId;

    private final Optional<String> cardId;

    private final Optional<String> referenceId;

    private final Map<String, Object> additionalProperties;

    private SaveCardOptions(
            String customerId,
            Optional<String> cardId,
            Optional<String> referenceId,
            Map<String, Object> additionalProperties) {
        this.customerId = customerId;
        this.cardId = cardId;
        this.referenceId = referenceId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The square-assigned ID of the customer linked to the saved card.
     */
    @JsonProperty("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @return The id of the created card-on-file.
     */
    @JsonProperty("card_id")
    public Optional<String> getCardId() {
        return cardId;
    }

    /**
     * @return An optional user-defined reference ID that can be used to associate
     * this <code>Card</code> to another entity in an external system. For example, a customer
     * ID generated by a third-party system.
     */
    @JsonIgnore
    public Optional<String> getReferenceId() {
        if (referenceId == null) {
            return Optional.empty();
        }
        return referenceId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("reference_id")
    private Optional<String> _getReferenceId() {
        return referenceId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SaveCardOptions && equalTo((SaveCardOptions) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SaveCardOptions other) {
        return customerId.equals(other.customerId)
                && cardId.equals(other.cardId)
                && referenceId.equals(other.referenceId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.customerId, this.cardId, this.referenceId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CustomerIdStage builder() {
        return new Builder();
    }

    public interface CustomerIdStage {
        /**
         * <p>The square-assigned ID of the customer linked to the saved card.</p>
         */
        _FinalStage customerId(@NotNull String customerId);

        Builder from(SaveCardOptions other);
    }

    public interface _FinalStage {
        SaveCardOptions build();

        /**
         * <p>The id of the created card-on-file.</p>
         */
        _FinalStage cardId(Optional<String> cardId);

        _FinalStage cardId(String cardId);

        /**
         * <p>An optional user-defined reference ID that can be used to associate
         * this <code>Card</code> to another entity in an external system. For example, a customer
         * ID generated by a third-party system.</p>
         */
        _FinalStage referenceId(Optional<String> referenceId);

        _FinalStage referenceId(String referenceId);

        _FinalStage referenceId(Nullable<String> referenceId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CustomerIdStage, _FinalStage {
        private String customerId;

        private Optional<String> referenceId = Optional.empty();

        private Optional<String> cardId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(SaveCardOptions other) {
            customerId(other.getCustomerId());
            cardId(other.getCardId());
            referenceId(other.getReferenceId());
            return this;
        }

        /**
         * <p>The square-assigned ID of the customer linked to the saved card.</p>
         * <p>The square-assigned ID of the customer linked to the saved card.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("customer_id")
        public _FinalStage customerId(@NotNull String customerId) {
            this.customerId = Objects.requireNonNull(customerId, "customerId must not be null");
            return this;
        }

        /**
         * <p>An optional user-defined reference ID that can be used to associate
         * this <code>Card</code> to another entity in an external system. For example, a customer
         * ID generated by a third-party system.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage referenceId(Nullable<String> referenceId) {
            if (referenceId.isNull()) {
                this.referenceId = null;
            } else if (referenceId.isEmpty()) {
                this.referenceId = Optional.empty();
            } else {
                this.referenceId = Optional.of(referenceId.get());
            }
            return this;
        }

        /**
         * <p>An optional user-defined reference ID that can be used to associate
         * this <code>Card</code> to another entity in an external system. For example, a customer
         * ID generated by a third-party system.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage referenceId(String referenceId) {
            this.referenceId = Optional.ofNullable(referenceId);
            return this;
        }

        /**
         * <p>An optional user-defined reference ID that can be used to associate
         * this <code>Card</code> to another entity in an external system. For example, a customer
         * ID generated by a third-party system.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "reference_id", nulls = Nulls.SKIP)
        public _FinalStage referenceId(Optional<String> referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        /**
         * <p>The id of the created card-on-file.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage cardId(String cardId) {
            this.cardId = Optional.ofNullable(cardId);
            return this;
        }

        /**
         * <p>The id of the created card-on-file.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "card_id", nulls = Nulls.SKIP)
        public _FinalStage cardId(Optional<String> cardId) {
            this.cardId = cardId;
            return this;
        }

        @java.lang.Override
        public SaveCardOptions build() {
            return new SaveCardOptions(customerId, cardId, referenceId, additionalProperties);
        }
    }
}
