/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.merchants.types;

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
@JsonDeserialize(builder = GetCustomAttributeDefinitionsRequest.Builder.class)
public final class GetCustomAttributeDefinitionsRequest {
    private final String key;

    private final Optional<Integer> version;

    private final Map<String, Object> additionalProperties;

    private GetCustomAttributeDefinitionsRequest(
            String key, Optional<Integer> version, Map<String, Object> additionalProperties) {
        this.key = key;
        this.version = version;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The key of the custom attribute definition to retrieve. If the requesting application
     * is not the definition owner, you must use the qualified key.
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * @return The current version of the custom attribute definition, which is used for strongly consistent
     * reads to guarantee that you receive the most up-to-date data. When included in the request,
     * Square returns the specified version or a higher version if one exists. If the specified version
     * is higher than the current version, Square returns a <code>BAD_REQUEST</code> error.
     */
    @JsonIgnore
    public Optional<Integer> getVersion() {
        if (version == null) {
            return Optional.empty();
        }
        return version;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("version")
    private Optional<Integer> _getVersion() {
        return version;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetCustomAttributeDefinitionsRequest
                && equalTo((GetCustomAttributeDefinitionsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetCustomAttributeDefinitionsRequest other) {
        return key.equals(other.key) && version.equals(other.version);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.key, this.version);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static KeyStage builder() {
        return new Builder();
    }

    public interface KeyStage {
        _FinalStage key(@NotNull String key);

        Builder from(GetCustomAttributeDefinitionsRequest other);
    }

    public interface _FinalStage {
        GetCustomAttributeDefinitionsRequest build();

        _FinalStage version(Optional<Integer> version);

        _FinalStage version(Integer version);

        _FinalStage version(Nullable<Integer> version);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements KeyStage, _FinalStage {
        private String key;

        private Optional<Integer> version = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GetCustomAttributeDefinitionsRequest other) {
            key(other.getKey());
            version(other.getVersion());
            return this;
        }

        /**
         * <p>The key of the custom attribute definition to retrieve. If the requesting application
         * is not the definition owner, you must use the qualified key.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("key")
        public _FinalStage key(@NotNull String key) {
            this.key = Objects.requireNonNull(key, "key must not be null");
            return this;
        }

        /**
         * <p>The current version of the custom attribute definition, which is used for strongly consistent
         * reads to guarantee that you receive the most up-to-date data. When included in the request,
         * Square returns the specified version or a higher version if one exists. If the specified version
         * is higher than the current version, Square returns a <code>BAD_REQUEST</code> error.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage version(Nullable<Integer> version) {
            if (version.isNull()) {
                this.version = null;
            } else if (version.isEmpty()) {
                this.version = Optional.empty();
            } else {
                this.version = Optional.of(version.get());
            }
            return this;
        }

        /**
         * <p>The current version of the custom attribute definition, which is used for strongly consistent
         * reads to guarantee that you receive the most up-to-date data. When included in the request,
         * Square returns the specified version or a higher version if one exists. If the specified version
         * is higher than the current version, Square returns a <code>BAD_REQUEST</code> error.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage version(Integer version) {
            this.version = Optional.ofNullable(version);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "version", nulls = Nulls.SKIP)
        public _FinalStage version(Optional<Integer> version) {
            this.version = version;
            return this;
        }

        @java.lang.Override
        public GetCustomAttributeDefinitionsRequest build() {
            return new GetCustomAttributeDefinitionsRequest(key, version, additionalProperties);
        }
    }
}
