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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateMerchantCustomAttributeDefinitionResponse.Builder.class)
public final class UpdateMerchantCustomAttributeDefinitionResponse {
    private final Optional<CustomAttributeDefinition> customAttributeDefinition;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private UpdateMerchantCustomAttributeDefinitionResponse(
            Optional<CustomAttributeDefinition> customAttributeDefinition,
            Optional<List<Error>> errors,
            Map<String, Object> additionalProperties) {
        this.customAttributeDefinition = customAttributeDefinition;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The updated custom attribute definition.
     */
    @JsonProperty("custom_attribute_definition")
    public Optional<CustomAttributeDefinition> getCustomAttributeDefinition() {
        return customAttributeDefinition;
    }

    /**
     * @return Any errors that occurred during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateMerchantCustomAttributeDefinitionResponse
                && equalTo((UpdateMerchantCustomAttributeDefinitionResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateMerchantCustomAttributeDefinitionResponse other) {
        return customAttributeDefinition.equals(other.customAttributeDefinition) && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.customAttributeDefinition, this.errors);
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
        private Optional<CustomAttributeDefinition> customAttributeDefinition = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdateMerchantCustomAttributeDefinitionResponse other) {
            customAttributeDefinition(other.getCustomAttributeDefinition());
            errors(other.getErrors());
            return this;
        }

        /**
         * <p>The updated custom attribute definition.</p>
         */
        @JsonSetter(value = "custom_attribute_definition", nulls = Nulls.SKIP)
        public Builder customAttributeDefinition(Optional<CustomAttributeDefinition> customAttributeDefinition) {
            this.customAttributeDefinition = customAttributeDefinition;
            return this;
        }

        public Builder customAttributeDefinition(CustomAttributeDefinition customAttributeDefinition) {
            this.customAttributeDefinition = Optional.ofNullable(customAttributeDefinition);
            return this;
        }

        /**
         * <p>Any errors that occurred during the request.</p>
         */
        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        public UpdateMerchantCustomAttributeDefinitionResponse build() {
            return new UpdateMerchantCustomAttributeDefinitionResponse(
                    customAttributeDefinition, errors, additionalProperties);
        }
    }
}
