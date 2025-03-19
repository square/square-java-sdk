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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SubscriptionPricing.Builder.class)
public final class SubscriptionPricing {
    private final Optional<SubscriptionPricingType> type;

    private final Optional<List<String>> discountIds;

    private final Optional<Money> priceMoney;

    private final Map<String, Object> additionalProperties;

    private SubscriptionPricing(
            Optional<SubscriptionPricingType> type,
            Optional<List<String>> discountIds,
            Optional<Money> priceMoney,
            Map<String, Object> additionalProperties) {
        this.type = type;
        this.discountIds = discountIds;
        this.priceMoney = priceMoney;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return RELATIVE or STATIC
     * See <a href="#type-subscriptionpricingtype">SubscriptionPricingType</a> for possible values
     */
    @JsonProperty("type")
    public Optional<SubscriptionPricingType> getType() {
        return type;
    }

    /**
     * @return The ids of the discount catalog objects
     */
    @JsonIgnore
    public Optional<List<String>> getDiscountIds() {
        if (discountIds == null) {
            return Optional.empty();
        }
        return discountIds;
    }

    /**
     * @return The price of the subscription, if STATIC
     */
    @JsonProperty("price_money")
    public Optional<Money> getPriceMoney() {
        return priceMoney;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("discount_ids")
    private Optional<List<String>> _getDiscountIds() {
        return discountIds;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SubscriptionPricing && equalTo((SubscriptionPricing) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SubscriptionPricing other) {
        return type.equals(other.type) && discountIds.equals(other.discountIds) && priceMoney.equals(other.priceMoney);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type, this.discountIds, this.priceMoney);
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
        private Optional<SubscriptionPricingType> type = Optional.empty();

        private Optional<List<String>> discountIds = Optional.empty();

        private Optional<Money> priceMoney = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SubscriptionPricing other) {
            type(other.getType());
            discountIds(other.getDiscountIds());
            priceMoney(other.getPriceMoney());
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<SubscriptionPricingType> type) {
            this.type = type;
            return this;
        }

        public Builder type(SubscriptionPricingType type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        @JsonSetter(value = "discount_ids", nulls = Nulls.SKIP)
        public Builder discountIds(Optional<List<String>> discountIds) {
            this.discountIds = discountIds;
            return this;
        }

        public Builder discountIds(List<String> discountIds) {
            this.discountIds = Optional.ofNullable(discountIds);
            return this;
        }

        public Builder discountIds(Nullable<List<String>> discountIds) {
            if (discountIds.isNull()) {
                this.discountIds = null;
            } else if (discountIds.isEmpty()) {
                this.discountIds = Optional.empty();
            } else {
                this.discountIds = Optional.of(discountIds.get());
            }
            return this;
        }

        @JsonSetter(value = "price_money", nulls = Nulls.SKIP)
        public Builder priceMoney(Optional<Money> priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }

        public Builder priceMoney(Money priceMoney) {
            this.priceMoney = Optional.ofNullable(priceMoney);
            return this;
        }

        public SubscriptionPricing build() {
            return new SubscriptionPricing(type, discountIds, priceMoney, additionalProperties);
        }
    }
}
