package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryPrefix {

    @JsonCreator
    public CatalogQueryPrefix(
            @JsonProperty("attribute_name") String attributeName,
            @JsonProperty("attribute_prefix") String attributePrefix) {
        this.attributeName = attributeName;
        this.attributePrefix = attributePrefix;
    }

    private final String attributeName;
    private final String attributePrefix;

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, attributePrefix);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryPrefix)) {
            return false;
        }
        CatalogQueryPrefix catalogQueryPrefix = (CatalogQueryPrefix) o;
        return Objects.equals(attributeName, catalogQueryPrefix.attributeName) &&
            Objects.equals(attributePrefix, catalogQueryPrefix.attributePrefix);
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
     * Getter for AttributePrefix.
     * The desired prefix of the search attribute value.
     */
    @JsonGetter("attribute_prefix")
    public String getAttributePrefix() { 
        return this.attributePrefix;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName,
            attributePrefix);
            return builder;
    }

    public static class Builder {
        private String attributeName;
        private String attributePrefix;

        public Builder(String attributeName,
                String attributePrefix) {
            this.attributeName = attributeName;
            this.attributePrefix = attributePrefix;
        }

        public Builder attributeName(String value) {
            attributeName = value;
            return this;
        }
        public Builder attributePrefix(String value) {
            attributePrefix = value;
            return this;
        }

        public CatalogQueryPrefix build() {
            return new CatalogQueryPrefix(attributeName,
                attributePrefix);
        }
    }
}
