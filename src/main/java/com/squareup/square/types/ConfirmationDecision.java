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
@JsonDeserialize(builder = ConfirmationDecision.Builder.class)
public final class ConfirmationDecision {
    private final Optional<Boolean> hasAgreed;

    private final Map<String, Object> additionalProperties;

    private ConfirmationDecision(Optional<Boolean> hasAgreed, Map<String, Object> additionalProperties) {
        this.hasAgreed = hasAgreed;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The buyer's decision to the displayed terms.
     */
    @JsonProperty("has_agreed")
    public Optional<Boolean> getHasAgreed() {
        return hasAgreed;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConfirmationDecision && equalTo((ConfirmationDecision) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ConfirmationDecision other) {
        return hasAgreed.equals(other.hasAgreed);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.hasAgreed);
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
        private Optional<Boolean> hasAgreed = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ConfirmationDecision other) {
            hasAgreed(other.getHasAgreed());
            return this;
        }

        /**
         * <p>The buyer's decision to the displayed terms.</p>
         */
        @JsonSetter(value = "has_agreed", nulls = Nulls.SKIP)
        public Builder hasAgreed(Optional<Boolean> hasAgreed) {
            this.hasAgreed = hasAgreed;
            return this;
        }

        public Builder hasAgreed(Boolean hasAgreed) {
            this.hasAgreed = Optional.ofNullable(hasAgreed);
            return this;
        }

        public ConfirmationDecision build() {
            return new ConfirmationDecision(hasAgreed, additionalProperties);
        }
    }
}
