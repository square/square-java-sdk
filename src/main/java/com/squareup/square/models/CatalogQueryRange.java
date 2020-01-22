package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQueryRange type.
 */
public class CatalogQueryRange {

    /**
     * Initialization constructor.
     * @param attributeName
     * @param attributeMinValue
     * @param attributeMaxValue
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(attributeName, attributeMinValue, attributeMaxValue);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQueryRange)) {
            return false;
        }
        CatalogQueryRange catalogQueryRange = (CatalogQueryRange) obj;
        return Objects.equals(attributeName, catalogQueryRange.attributeName) &&
            Objects.equals(attributeMinValue, catalogQueryRange.attributeMinValue) &&
            Objects.equals(attributeMaxValue, catalogQueryRange.attributeMaxValue);
    }

    /**
     * Builds a new {@link CatalogQueryRange.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryRange.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName)
            .attributeMinValue(getAttributeMinValue())
            .attributeMaxValue(getAttributeMaxValue());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryRange}
     */
    public static class Builder {
        private String attributeName;
        private Long attributeMinValue;
        private Long attributeMaxValue;

        /**
         * Initialization constructor
         */
        public Builder(String attributeName) {
            this.attributeName = attributeName;
        }

        /**
         * Setter for attributeName
         * @param attributeName
         * @return Builder
         */
        public Builder attributeName(String attributeName) {
            this.attributeName = attributeName;
            return this;
        }
        /**
         * Setter for attributeMinValue
         * @param attributeMinValue
         * @return Builder
         */
        public Builder attributeMinValue(Long attributeMinValue) {
            this.attributeMinValue = attributeMinValue;
            return this;
        }
        /**
         * Setter for attributeMaxValue
         * @param attributeMaxValue
         * @return Builder
         */
        public Builder attributeMaxValue(Long attributeMaxValue) {
            this.attributeMaxValue = attributeMaxValue;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryRange} object using the set fields.
         * @return {@link CatalogQueryRange}
         */
        public CatalogQueryRange build() {
            return new CatalogQueryRange(attributeName,
                attributeMinValue,
                attributeMaxValue);
        }
    }
}
