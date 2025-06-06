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
@JsonDeserialize(builder = DeviceComponentDetailsMeasurement.Builder.class)
public final class DeviceComponentDetailsMeasurement {
    private final Optional<Integer> value;

    private final Map<String, Object> additionalProperties;

    private DeviceComponentDetailsMeasurement(Optional<Integer> value, Map<String, Object> additionalProperties) {
        this.value = value;
        this.additionalProperties = additionalProperties;
    }

    @JsonIgnore
    public Optional<Integer> getValue() {
        if (value == null) {
            return Optional.empty();
        }
        return value;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("value")
    private Optional<Integer> _getValue() {
        return value;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DeviceComponentDetailsMeasurement && equalTo((DeviceComponentDetailsMeasurement) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DeviceComponentDetailsMeasurement other) {
        return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.value);
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
        private Optional<Integer> value = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(DeviceComponentDetailsMeasurement other) {
            value(other.getValue());
            return this;
        }

        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public Builder value(Optional<Integer> value) {
            this.value = value;
            return this;
        }

        public Builder value(Integer value) {
            this.value = Optional.ofNullable(value);
            return this;
        }

        public Builder value(Nullable<Integer> value) {
            if (value.isNull()) {
                this.value = null;
            } else if (value.isEmpty()) {
                this.value = Optional.empty();
            } else {
                this.value = Optional.of(value.get());
            }
            return this;
        }

        public DeviceComponentDetailsMeasurement build() {
            return new DeviceComponentDetailsMeasurement(value, additionalProperties);
        }
    }
}
