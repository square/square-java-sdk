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
@JsonDeserialize(builder = Destination.Builder.class)
public final class Destination {
    private final Optional<DestinationType> type;

    private final Optional<String> id;

    private final Map<String, Object> additionalProperties;

    private Destination(Optional<DestinationType> type, Optional<String> id, Map<String, Object> additionalProperties) {
        this.type = type;
        this.id = id;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Type of the destination such as a bank account or debit card.
     * See <a href="#type-destinationtype">DestinationType</a> for possible values
     */
    @JsonProperty("type")
    public Optional<DestinationType> getType() {
        return type;
    }

    /**
     * @return Square issued unique ID (also known as the instrument ID) associated with this destination.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Destination && equalTo((Destination) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Destination other) {
        return type.equals(other.type) && id.equals(other.id);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type, this.id);
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
        private Optional<DestinationType> type = Optional.empty();

        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Destination other) {
            type(other.getType());
            id(other.getId());
            return this;
        }

        /**
         * <p>Type of the destination such as a bank account or debit card.
         * See <a href="#type-destinationtype">DestinationType</a> for possible values</p>
         */
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<DestinationType> type) {
            this.type = type;
            return this;
        }

        public Builder type(DestinationType type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        /**
         * <p>Square issued unique ID (also known as the instrument ID) associated with this destination.</p>
         */
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        public Destination build() {
            return new Destination(type, id, additionalProperties);
        }
    }
}
