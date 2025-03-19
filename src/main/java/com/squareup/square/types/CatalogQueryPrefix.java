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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogQueryPrefix.Builder.class)
public final class CatalogQueryPrefix {
    private final String attributeName;

    private final String attributePrefix;

    private final Map<String, Object> additionalProperties;

    private CatalogQueryPrefix(String attributeName, String attributePrefix, Map<String, Object> additionalProperties) {
        this.attributeName = attributeName;
        this.attributePrefix = attributePrefix;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The name of the attribute to be searched.
     */
    @JsonProperty("attribute_name")
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * @return The desired prefix of the search attribute value.
     */
    @JsonProperty("attribute_prefix")
    public String getAttributePrefix() {
        return attributePrefix;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogQueryPrefix && equalTo((CatalogQueryPrefix) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogQueryPrefix other) {
        return attributeName.equals(other.attributeName) && attributePrefix.equals(other.attributePrefix);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.attributeName, this.attributePrefix);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static AttributeNameStage builder() {
        return new Builder();
    }

    public interface AttributeNameStage {
        AttributePrefixStage attributeName(@NotNull String attributeName);

        Builder from(CatalogQueryPrefix other);
    }

    public interface AttributePrefixStage {
        _FinalStage attributePrefix(@NotNull String attributePrefix);
    }

    public interface _FinalStage {
        CatalogQueryPrefix build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AttributeNameStage, AttributePrefixStage, _FinalStage {
        private String attributeName;

        private String attributePrefix;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CatalogQueryPrefix other) {
            attributeName(other.getAttributeName());
            attributePrefix(other.getAttributePrefix());
            return this;
        }

        /**
         * <p>The name of the attribute to be searched.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("attribute_name")
        public AttributePrefixStage attributeName(@NotNull String attributeName) {
            this.attributeName = Objects.requireNonNull(attributeName, "attributeName must not be null");
            return this;
        }

        /**
         * <p>The desired prefix of the search attribute value.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("attribute_prefix")
        public _FinalStage attributePrefix(@NotNull String attributePrefix) {
            this.attributePrefix = Objects.requireNonNull(attributePrefix, "attributePrefix must not be null");
            return this;
        }

        @java.lang.Override
        public CatalogQueryPrefix build() {
            return new CatalogQueryPrefix(attributeName, attributePrefix, additionalProperties);
        }
    }
}
