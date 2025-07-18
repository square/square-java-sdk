/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.devices.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetCodesRequest.Builder.class)
public final class GetCodesRequest {
    private final String id;

    private final Map<String, Object> additionalProperties;

    private GetCodesRequest(String id, Map<String, Object> additionalProperties) {
        this.id = id;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique identifier for the device code.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetCodesRequest && equalTo((GetCodesRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetCodesRequest other) {
        return id.equals(other.id);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        /**
         * <p>The unique identifier for the device code.</p>
         */
        _FinalStage id(@NotNull String id);

        Builder from(GetCodesRequest other);
    }

    public interface _FinalStage {
        GetCodesRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, _FinalStage {
        private String id;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GetCodesRequest other) {
            id(other.getId());
            return this;
        }

        /**
         * <p>The unique identifier for the device code.</p>
         * <p>The unique identifier for the device code.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public _FinalStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        @java.lang.Override
        public GetCodesRequest build() {
            return new GetCodesRequest(id, additionalProperties);
        }
    }
}
