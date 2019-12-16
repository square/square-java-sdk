package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryRange {

    @JsonCreator
    public CatalogQueryRange(
            @JsonProperty("attribute_name") String attributeName,
            @JsonProperty("attribute_min_value") Long attributeMinValue,
            @JsonProperty("attribute_max_value") Long attributeMaxValue) {
        this.attributeName = attributeName;
        this.attributeMinValue = attributeMinValue;
        this.attributeMaxValue = attributeMaxValue;
    }

    private final String attributeName;
    private final Long attributeMinValue;
    private final Long attributeMaxValue;

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, attributeMinValue, attributeMaxValue);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryRange)) {
            return false;
        }
        CatalogQueryRange catalogQueryRange = (CatalogQueryRange) o;
        return Objects.equals(attributeName, catalogQueryRange.attributeName) &&
            Objects.equals(attributeMinValue, catalogQueryRange.attributeMinValue) &&
            Objects.equals(attributeMaxValue, catalogQueryRange.attributeMaxValue);
    }

    /**
     * Getter for AttributeName.
     * The name of the attribute to be searched.
     */
    @JsonGetter("attribute_name")
    public String getAttributeName() { 
        return this.attributeName;
    }

    /**
     * Getter for AttributeMinValue.
     * The desired minimum value for the search attribute (inclusive).
     */
    @JsonGetter("attribute_min_value")
    public Long getAttributeMinValue() { 
        return this.attributeMinValue;
    }

    /**
     * Getter for AttributeMaxValue.
     * The desired maximum value for the search attribute (inclusive).
     */
    @JsonGetter("attribute_max_value")
    public Long getAttributeMaxValue() { 
        return this.attributeMaxValue;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName)
            .attributeMinValue(getAttributeMinValue())
            .attributeMaxValue(getAttributeMaxValue());
            return builder;
    }

    public static class Builder {
        private String attributeName;
        private Long attributeMinValue;
        private Long attributeMaxValue;

        public Builder(String attributeName) {
            this.attributeName = attributeName;
        }

        public Builder attributeName(String value) {
            attributeName = value;
            return this;
        }
        public Builder attributeMinValue(Long value) {
            attributeMinValue = value;
            return this;
        }
        public Builder attributeMaxValue(Long value) {
            attributeMaxValue = value;
            return this;
        }

        public CatalogQueryRange build() {
            return new CatalogQueryRange(attributeName,
                attributeMinValue,
                attributeMaxValue);
        }
    }
}
