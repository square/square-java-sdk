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
@JsonDeserialize(builder = GiftCardCustomerLinkedEventObject.Builder.class)
public final class GiftCardCustomerLinkedEventObject {
    private final Optional<GiftCard> giftCard;

    private final Optional<String> linkedCustomerId;

    private final Map<String, Object> additionalProperties;

    private GiftCardCustomerLinkedEventObject(
            Optional<GiftCard> giftCard, Optional<String> linkedCustomerId, Map<String, Object> additionalProperties) {
        this.giftCard = giftCard;
        this.linkedCustomerId = linkedCustomerId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The gift card with the updated <code>customer_ids</code> field.
     */
    @JsonProperty("gift_card")
    public Optional<GiftCard> getGiftCard() {
        return giftCard;
    }

    /**
     * @return The ID of the linked <a href="entity:Customer">customer</a>.
     */
    @JsonIgnore
    public Optional<String> getLinkedCustomerId() {
        if (linkedCustomerId == null) {
            return Optional.empty();
        }
        return linkedCustomerId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("linked_customer_id")
    private Optional<String> _getLinkedCustomerId() {
        return linkedCustomerId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GiftCardCustomerLinkedEventObject && equalTo((GiftCardCustomerLinkedEventObject) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GiftCardCustomerLinkedEventObject other) {
        return giftCard.equals(other.giftCard) && linkedCustomerId.equals(other.linkedCustomerId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.giftCard, this.linkedCustomerId);
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
        private Optional<GiftCard> giftCard = Optional.empty();

        private Optional<String> linkedCustomerId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GiftCardCustomerLinkedEventObject other) {
            giftCard(other.getGiftCard());
            linkedCustomerId(other.getLinkedCustomerId());
            return this;
        }

        /**
         * <p>The gift card with the updated <code>customer_ids</code> field.</p>
         */
        @JsonSetter(value = "gift_card", nulls = Nulls.SKIP)
        public Builder giftCard(Optional<GiftCard> giftCard) {
            this.giftCard = giftCard;
            return this;
        }

        public Builder giftCard(GiftCard giftCard) {
            this.giftCard = Optional.ofNullable(giftCard);
            return this;
        }

        /**
         * <p>The ID of the linked <a href="entity:Customer">customer</a>.</p>
         */
        @JsonSetter(value = "linked_customer_id", nulls = Nulls.SKIP)
        public Builder linkedCustomerId(Optional<String> linkedCustomerId) {
            this.linkedCustomerId = linkedCustomerId;
            return this;
        }

        public Builder linkedCustomerId(String linkedCustomerId) {
            this.linkedCustomerId = Optional.ofNullable(linkedCustomerId);
            return this;
        }

        public Builder linkedCustomerId(Nullable<String> linkedCustomerId) {
            if (linkedCustomerId.isNull()) {
                this.linkedCustomerId = null;
            } else if (linkedCustomerId.isEmpty()) {
                this.linkedCustomerId = Optional.empty();
            } else {
                this.linkedCustomerId = Optional.of(linkedCustomerId.get());
            }
            return this;
        }

        public GiftCardCustomerLinkedEventObject build() {
            return new GiftCardCustomerLinkedEventObject(giftCard, linkedCustomerId, additionalProperties);
        }
    }
}
