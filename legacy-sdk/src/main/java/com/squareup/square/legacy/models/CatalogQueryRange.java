package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CatalogQueryRange type.
 */
public class CatalogQueryRange {
    private final String attributeName;
    private final OptionalNullable<Long> attributeMinValue;
    private final OptionalNullable<Long> attributeMaxValue;

    /**
     * Initialization constructor.
     * @param  attributeName  String value for attributeName.
     * @param  attributeMinValue  Long value for attributeMinValue.
     * @param  attributeMaxValue  Long value for attributeMaxValue.
     */
    @JsonCreator
    public CatalogQueryRange(
            @JsonProperty("attribute_name") String attributeName,
            @JsonProperty("attribute_min_value") Long attributeMinValue,
            @JsonProperty("attribute_max_value") Long attributeMaxValue) {
        this.attributeName = attributeName;
        this.attributeMinValue = OptionalNullable.of(attributeMinValue);
        this.attributeMaxValue = OptionalNullable.of(attributeMaxValue);
    }

    /**
     * Initialization constructor.
     * @param  attributeName  String value for attributeName.
     * @param  attributeMinValue  Long value for attributeMinValue.
     * @param  attributeMaxValue  Long value for attributeMaxValue.
     */
    protected CatalogQueryRange(
            String attributeName, OptionalNullable<Long> attributeMinValue, OptionalNullable<Long> attributeMaxValue) {
        this.attributeName = attributeName;
        this.attributeMinValue = attributeMinValue;
        this.attributeMaxValue = attributeMaxValue;
    }

    /**
     * Getter for AttributeName.
     * The name of the attribute to be searched.
     * @return Returns the String
     */
    @JsonGetter("attribute_name")
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * Internal Getter for AttributeMinValue.
     * The desired minimum value for the search attribute (inclusive).
     * @return Returns the Internal Long
     */
    @JsonGetter("attribute_min_value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetAttributeMinValue() {
        return this.attributeMinValue;
    }

    /**
     * Getter for AttributeMinValue.
     * The desired minimum value for the search attribute (inclusive).
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getAttributeMinValue() {
        return OptionalNullable.getFrom(attributeMinValue);
    }

    /**
     * Internal Getter for AttributeMaxValue.
     * The desired maximum value for the search attribute (inclusive).
     * @return Returns the Internal Long
     */
    @JsonGetter("attribute_max_value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetAttributeMaxValue() {
        return this.attributeMaxValue;
    }

    /**
     * Getter for AttributeMaxValue.
     * The desired maximum value for the search attribute (inclusive).
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getAttributeMaxValue() {
        return OptionalNullable.getFrom(attributeMaxValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, attributeMinValue, attributeMaxValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogQueryRange)) {
            return false;
        }
        CatalogQueryRange other = (CatalogQueryRange) obj;
        return Objects.equals(attributeName, other.attributeName)
                && Objects.equals(attributeMinValue, other.attributeMinValue)
                && Objects.equals(attributeMaxValue, other.attributeMaxValue);
    }

    /**
     * Converts this CatalogQueryRange into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogQueryRange [" + "attributeName=" + attributeName + ", attributeMinValue=" + attributeMinValue
                + ", attributeMaxValue=" + attributeMaxValue + "]";
    }

    /**
     * Builds a new {@link CatalogQueryRange.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryRange.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName);
        builder.attributeMinValue = internalGetAttributeMinValue();
        builder.attributeMaxValue = internalGetAttributeMaxValue();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryRange}.
     */
    public static class Builder {
        private String attributeName;
        private OptionalNullable<Long> attributeMinValue;
        private OptionalNullable<Long> attributeMaxValue;

        /**
         * Initialization constructor.
         * @param  attributeName  String value for attributeName.
         */
        public Builder(String attributeName) {
            this.attributeName = attributeName;
        }

        /**
         * Setter for attributeName.
         * @param  attributeName  String value for attributeName.
         * @return Builder
         */
        public Builder attributeName(String attributeName) {
            this.attributeName = attributeName;
            return this;
        }

        /**
         * Setter for attributeMinValue.
         * @param  attributeMinValue  Long value for attributeMinValue.
         * @return Builder
         */
        public Builder attributeMinValue(Long attributeMinValue) {
            this.attributeMinValue = OptionalNullable.of(attributeMinValue);
            return this;
        }

        /**
         * UnSetter for attributeMinValue.
         * @return Builder
         */
        public Builder unsetAttributeMinValue() {
            attributeMinValue = null;
            return this;
        }

        /**
         * Setter for attributeMaxValue.
         * @param  attributeMaxValue  Long value for attributeMaxValue.
         * @return Builder
         */
        public Builder attributeMaxValue(Long attributeMaxValue) {
            this.attributeMaxValue = OptionalNullable.of(attributeMaxValue);
            return this;
        }

        /**
         * UnSetter for attributeMaxValue.
         * @return Builder
         */
        public Builder unsetAttributeMaxValue() {
            attributeMaxValue = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryRange} object using the set fields.
         * @return {@link CatalogQueryRange}
         */
        public CatalogQueryRange build() {
            return new CatalogQueryRange(attributeName, attributeMinValue, attributeMaxValue);
        }
    }
}
