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
@JsonDeserialize(builder = ListEventTypesRequest.Builder.class)
public final class ListEventTypesRequest {
    private final Optional<String> apiVersion;

    private final Map<String, Object> additionalProperties;

    private ListEventTypesRequest(Optional<String> apiVersion, Map<String, Object> additionalProperties) {
        this.apiVersion = apiVersion;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The API version for which to list event types. Setting this field overrides the default version used by the application.
     */
    @JsonIgnore
    public Optional<String> getApiVersion() {
        if (apiVersion == null) {
            return Optional.empty();
        }
        return apiVersion;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("api_version")
    private Optional<String> _getApiVersion() {
        return apiVersion;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListEventTypesRequest && equalTo((ListEventTypesRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListEventTypesRequest other) {
        return apiVersion.equals(other.apiVersion);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.apiVersion);
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
        private Optional<String> apiVersion = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListEventTypesRequest other) {
            apiVersion(other.getApiVersion());
            return this;
        }

        @JsonSetter(value = "api_version", nulls = Nulls.SKIP)
        public Builder apiVersion(Optional<String> apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        public Builder apiVersion(String apiVersion) {
            this.apiVersion = Optional.ofNullable(apiVersion);
            return this;
        }

        public Builder apiVersion(Nullable<String> apiVersion) {
            if (apiVersion.isNull()) {
                this.apiVersion = null;
            } else if (apiVersion.isEmpty()) {
                this.apiVersion = Optional.empty();
            } else {
                this.apiVersion = Optional.of(apiVersion.get());
            }
            return this;
        }

        public ListEventTypesRequest build() {
            return new ListEventTypesRequest(apiVersion, additionalProperties);
        }
    }
}
