
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for CatalogQueryExact type.
 */
public class CatalogQueryExact {
    private final String attributeName;
    private final String attributeValue;

    /**
     * Initialization constructor.
     * @param attributeName String value for attributeName.
     * @param attributeValue String value for attributeValue.
     */
    @JsonCreator
    public CatalogQueryExact(
            @JsonProperty("attribute_name") String attributeName,
            @JsonProperty("attribute_value") String attributeValue) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    /**
     * Getter for AttributeName.
     * The name of the attribute to be searched. Matching of the attribute name is exact.
     * @return Returns the String
     */
    @JsonGetter("attribute_name")
    public String getAttributeName() {
        return this.attributeName;
    }

    /**
     * Getter for AttributeValue.
     * The desired value of the search attribute. Matching of the attribute value is case
     * insensitive and can be partial. For example, if a specified value of "sma", objects with the
     * named attribute value of "Small", "small" are both matched.
     * @return Returns the String
     */
    @JsonGetter("attribute_value")
    public String getAttributeValue() {
        return this.attributeValue;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(attributeName, attributeValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogQueryExact)) {
            return false;
        }
        CatalogQueryExact other = (CatalogQueryExact) obj;
        return Objects.equals(attributeName, other.attributeName)
            && Objects.equals(attributeValue, other.attributeValue);
    }

    /**
     * Builds a new {@link CatalogQueryExact.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryExact.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName,
            attributeValue);
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryExact}.
     */
    public static class Builder {
        private String attributeName;
        private String attributeValue;

        /**
         * Initialization constructor.
         * @param attributeName String value for attributeName.
         * @param attributeValue String value for attributeValue.
         */
        public Builder(String attributeName,
                String attributeValue) {
            this.attributeName = attributeName;
            this.attributeValue = attributeValue;
        }

        /**
         * Setter for attributeName.
         * @param attributeName String value for attributeName.
         * @return Builder
         */
        public Builder attributeName(String attributeName) {
            this.attributeName = attributeName;
            return this;
        }

        /**
         * Setter for attributeValue.
         * @param attributeValue String value for attributeValue.
         * @return Builder
         */
        public Builder attributeValue(String attributeValue) {
            this.attributeValue = attributeValue;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryExact} object using the set fields.
         * @return {@link CatalogQueryExact}
         */
        public CatalogQueryExact build() {
            return new CatalogQueryExact(attributeName,
                attributeValue);
        }
    }
}
