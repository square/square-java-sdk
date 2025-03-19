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
@JsonDeserialize(builder = ListMerchantCustomAttributeDefinitionsResponse.Builder.class)
public final class ListMerchantCustomAttributeDefinitionsResponse {
    private final Optional<List<CustomAttributeDefinition>> customAttributeDefinitions;

    private final Optional<String> cursor;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private ListMerchantCustomAttributeDefinitionsResponse(
            Optional<List<CustomAttributeDefinition>> customAttributeDefinitions,
            Optional<String> cursor,
            Optional<List<Error>> errors,
            Map<String, Object> additionalProperties) {
        this.customAttributeDefinitions = customAttributeDefinitions;
        this.cursor = cursor;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The retrieved custom attribute definitions. If no custom attribute definitions are found,
     * Square returns an empty object (<code>{}</code>).
     */
    @JsonProperty("custom_attribute_definitions")
    public Optional<List<CustomAttributeDefinition>> getCustomAttributeDefinitions() {
        return customAttributeDefinitions;
    }

    /**
     * @return The cursor to provide in your next call to this endpoint to retrieve the next page of
     * results for your original request. This field is present only if the request succeeded and
     * additional results are available. For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination">Pagination</a>.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
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
        return other instanceof ListMerchantCustomAttributeDefinitionsResponse
                && equalTo((ListMerchantCustomAttributeDefinitionsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListMerchantCustomAttributeDefinitionsResponse other) {
        return customAttributeDefinitions.equals(other.customAttributeDefinitions)
                && cursor.equals(other.cursor)
                && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.customAttributeDefinitions, this.cursor, this.errors);
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
        private Optional<List<CustomAttributeDefinition>> customAttributeDefinitions = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListMerchantCustomAttributeDefinitionsResponse other) {
            customAttributeDefinitions(other.getCustomAttributeDefinitions());
            cursor(other.getCursor());
            errors(other.getErrors());
            return this;
        }

        @JsonSetter(value = "custom_attribute_definitions", nulls = Nulls.SKIP)
        public Builder customAttributeDefinitions(
                Optional<List<CustomAttributeDefinition>> customAttributeDefinitions) {
            this.customAttributeDefinitions = customAttributeDefinitions;
            return this;
        }

        public Builder customAttributeDefinitions(List<CustomAttributeDefinition> customAttributeDefinitions) {
            this.customAttributeDefinitions = Optional.ofNullable(customAttributeDefinitions);
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        public ListMerchantCustomAttributeDefinitionsResponse build() {
            return new ListMerchantCustomAttributeDefinitionsResponse(
                    customAttributeDefinitions, cursor, errors, additionalProperties);
        }
    }
}
