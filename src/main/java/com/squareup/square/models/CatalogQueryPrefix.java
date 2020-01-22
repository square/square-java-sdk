package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQueryPrefix type.
 */
public class CatalogQueryPrefix {

    /**
     * Initialization constructor.
     * @param attributeName
     * @param attributePrefix
     */
    @JsonCreator
    public CatalogQueryPrefix(
            @JsonProperty("attribute_name") String attributeName,
            @JsonProperty("attribute_prefix") String attributePrefix) {
        this.attributeName = attributeName;
        this.attributePrefix = attributePrefix;
    }

    private final String attributeName;
    private final String attributePrefix;
    /**
     * Getter for AttributeName.
     * The name of the attribute to be searched.
     */
    @JsonGetter("attribute_name")
    public String getAttributeName() {
        return this.attributeName;
    }

    /**
     * Getter for AttributePrefix.
     * The desired prefix of the search attribute value.
     */
    @JsonGetter("attribute_prefix")
    public String getAttributePrefix() {
        return this.attributePrefix;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(attributeName, attributePrefix);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQueryPrefix)) {
            return false;
        }
        CatalogQueryPrefix catalogQueryPrefix = (CatalogQueryPrefix) obj;
        return Objects.equals(attributeName, catalogQueryPrefix.attributeName) &&
            Objects.equals(attributePrefix, catalogQueryPrefix.attributePrefix);
    }

    /**
     * Builds a new {@link CatalogQueryPrefix.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryPrefix.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName,
            attributePrefix);
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryPrefix}
     */
    public static class Builder {
        private String attributeName;
        private String attributePrefix;

        /**
         * Initialization constructor
         */
        public Builder(String attributeName,
                String attributePrefix) {
            this.attributeName = attributeName;
            this.attributePrefix = attributePrefix;
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
         * Setter for attributePrefix
         * @param attributePrefix
         * @return Builder
         */
        public Builder attributePrefix(String attributePrefix) {
            this.attributePrefix = attributePrefix;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryPrefix} object using the set fields.
         * @return {@link CatalogQueryPrefix}
         */
        public CatalogQueryPrefix build() {
            return new CatalogQueryPrefix(attributeName,
                attributePrefix);
        }
    }
}
