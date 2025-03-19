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
@JsonDeserialize(builder = LoyaltyEventQuery.Builder.class)
public final class LoyaltyEventQuery {
    private final Optional<LoyaltyEventFilter> filter;

    private final Map<String, Object> additionalProperties;

    private LoyaltyEventQuery(Optional<LoyaltyEventFilter> filter, Map<String, Object> additionalProperties) {
        this.filter = filter;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The query filter criteria.
     */
    @JsonProperty("filter")
    public Optional<LoyaltyEventFilter> getFilter() {
        return filter;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoyaltyEventQuery && equalTo((LoyaltyEventQuery) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LoyaltyEventQuery other) {
        return filter.equals(other.filter);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.filter);
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
        private Optional<LoyaltyEventFilter> filter = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(LoyaltyEventQuery other) {
            filter(other.getFilter());
            return this;
        }

        @JsonSetter(value = "filter", nulls = Nulls.SKIP)
        public Builder filter(Optional<LoyaltyEventFilter> filter) {
            this.filter = filter;
            return this;
        }

        public Builder filter(LoyaltyEventFilter filter) {
            this.filter = Optional.ofNullable(filter);
            return this;
        }

        public LoyaltyEventQuery build() {
            return new LoyaltyEventQuery(filter, additionalProperties);
        }
    }
}
