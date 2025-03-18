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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogQueryRange.Builder.class)
public final class CatalogQueryRange {
    private final String attributeName;

    private final Optional<Long> attributeMinValue;

    private final Optional<Long> attributeMaxValue;

    private final Map<String, Object> additionalProperties;

    private CatalogQueryRange(
            String attributeName,
            Optional<Long> attributeMinValue,
            Optional<Long> attributeMaxValue,
            Map<String, Object> additionalProperties) {
        this.attributeName = attributeName;
        this.attributeMinValue = attributeMinValue;
        this.attributeMaxValue = attributeMaxValue;
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
     * @return The desired minimum value for the search attribute (inclusive).
     */
    @JsonIgnore
    public Optional<Long> getAttributeMinValue() {
        if (attributeMinValue == null) {
            return Optional.empty();
        }
        return attributeMinValue;
    }

    /**
     * @return The desired maximum value for the search attribute (inclusive).
     */
    @JsonIgnore
    public Optional<Long> getAttributeMaxValue() {
        if (attributeMaxValue == null) {
            return Optional.empty();
        }
        return attributeMaxValue;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("attribute_min_value")
    private Optional<Long> _getAttributeMinValue() {
        return attributeMinValue;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("attribute_max_value")
    private Optional<Long> _getAttributeMaxValue() {
        return attributeMaxValue;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogQueryRange && equalTo((CatalogQueryRange) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogQueryRange other) {
        return attributeName.equals(other.attributeName)
                && attributeMinValue.equals(other.attributeMinValue)
                && attributeMaxValue.equals(other.attributeMaxValue);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.attributeName, this.attributeMinValue, this.attributeMaxValue);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static AttributeNameStage builder() {
        return new Builder();
    }

    public interface AttributeNameStage {
        _FinalStage attributeName(@NotNull String attributeName);

        Builder from(CatalogQueryRange other);
    }

    public interface _FinalStage {
        CatalogQueryRange build();

        _FinalStage attributeMinValue(Optional<Long> attributeMinValue);

        _FinalStage attributeMinValue(Long attributeMinValue);

        _FinalStage attributeMinValue(Nullable<Long> attributeMinValue);

        _FinalStage attributeMaxValue(Optional<Long> attributeMaxValue);

        _FinalStage attributeMaxValue(Long attributeMaxValue);

        _FinalStage attributeMaxValue(Nullable<Long> attributeMaxValue);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AttributeNameStage, _FinalStage {
        private String attributeName;

        private Optional<Long> attributeMaxValue = Optional.empty();

        private Optional<Long> attributeMinValue = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CatalogQueryRange other) {
            attributeName(other.getAttributeName());
            attributeMinValue(other.getAttributeMinValue());
            attributeMaxValue(other.getAttributeMaxValue());
            return this;
        }

        /**
         * <p>The name of the attribute to be searched.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("attribute_name")
        public _FinalStage attributeName(@NotNull String attributeName) {
            this.attributeName = Objects.requireNonNull(attributeName, "attributeName must not be null");
            return this;
        }

        /**
         * <p>The desired maximum value for the search attribute (inclusive).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage attributeMaxValue(Nullable<Long> attributeMaxValue) {
            if (attributeMaxValue.isNull()) {
                this.attributeMaxValue = null;
            } else if (attributeMaxValue.isEmpty()) {
                this.attributeMaxValue = Optional.empty();
            } else {
                this.attributeMaxValue = Optional.of(attributeMaxValue.get());
            }
            return this;
        }

        /**
         * <p>The desired maximum value for the search attribute (inclusive).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage attributeMaxValue(Long attributeMaxValue) {
            this.attributeMaxValue = Optional.ofNullable(attributeMaxValue);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "attribute_max_value", nulls = Nulls.SKIP)
        public _FinalStage attributeMaxValue(Optional<Long> attributeMaxValue) {
            this.attributeMaxValue = attributeMaxValue;
            return this;
        }

        /**
         * <p>The desired minimum value for the search attribute (inclusive).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage attributeMinValue(Nullable<Long> attributeMinValue) {
            if (attributeMinValue.isNull()) {
                this.attributeMinValue = null;
            } else if (attributeMinValue.isEmpty()) {
                this.attributeMinValue = Optional.empty();
            } else {
                this.attributeMinValue = Optional.of(attributeMinValue.get());
            }
            return this;
        }

        /**
         * <p>The desired minimum value for the search attribute (inclusive).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage attributeMinValue(Long attributeMinValue) {
            this.attributeMinValue = Optional.ofNullable(attributeMinValue);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "attribute_min_value", nulls = Nulls.SKIP)
        public _FinalStage attributeMinValue(Optional<Long> attributeMinValue) {
            this.attributeMinValue = attributeMinValue;
            return this;
        }

        @java.lang.Override
        public CatalogQueryRange build() {
            return new CatalogQueryRange(attributeName, attributeMinValue, attributeMaxValue, additionalProperties);
        }
    }
}
