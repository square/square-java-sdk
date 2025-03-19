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
@JsonDeserialize(builder = ListOrderCustomAttributesResponse.Builder.class)
public final class ListOrderCustomAttributesResponse {
    private final Optional<List<CustomAttribute>> customAttributes;

    private final Optional<String> cursor;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private ListOrderCustomAttributesResponse(
            Optional<List<CustomAttribute>> customAttributes,
            Optional<String> cursor,
            Optional<List<Error>> errors,
            Map<String, Object> additionalProperties) {
        this.customAttributes = customAttributes;
        this.cursor = cursor;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The retrieved custom attributes. If no custom attribute are found, Square returns an empty object (<code>{}</code>).
     */
    @JsonProperty("custom_attributes")
    public Optional<List<CustomAttribute>> getCustomAttributes() {
        return customAttributes;
    }

    /**
     * @return The cursor to provide in your next call to this endpoint to retrieve the next page of results for your original request.
     * This field is present only if the request succeeded and additional results are available.
     * For more information, see <a href="https://developer.squareup.com/docs/working-with-apis/pagination">Pagination</a>.
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
        return other instanceof ListOrderCustomAttributesResponse && equalTo((ListOrderCustomAttributesResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListOrderCustomAttributesResponse other) {
        return customAttributes.equals(other.customAttributes)
                && cursor.equals(other.cursor)
                && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.customAttributes, this.cursor, this.errors);
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
        private Optional<List<CustomAttribute>> customAttributes = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListOrderCustomAttributesResponse other) {
            customAttributes(other.getCustomAttributes());
            cursor(other.getCursor());
            errors(other.getErrors());
            return this;
        }

        @JsonSetter(value = "custom_attributes", nulls = Nulls.SKIP)
        public Builder customAttributes(Optional<List<CustomAttribute>> customAttributes) {
            this.customAttributes = customAttributes;
            return this;
        }

        public Builder customAttributes(List<CustomAttribute> customAttributes) {
            this.customAttributes = Optional.ofNullable(customAttributes);
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

        public ListOrderCustomAttributesResponse build() {
            return new ListOrderCustomAttributesResponse(customAttributes, cursor, errors, additionalProperties);
        }
    }
}
