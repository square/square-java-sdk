package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryExact {

    @JsonCreator
    public CatalogQueryExact(
            @JsonProperty("attribute_name") String attributeName,
            @JsonProperty("attribute_value") String attributeValue) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    private final String attributeName;
    private final String attributeValue;

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, attributeValue);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryExact)) {
            return false;
        }
        CatalogQueryExact catalogQueryExact = (CatalogQueryExact) o;
        return Objects.equals(attributeName, catalogQueryExact.attributeName) &&
            Objects.equals(attributeValue, catalogQueryExact.attributeValue);
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
     * Getter for AttributeValue.
     * The desired value of the search attribute.
     */
    @JsonGetter("attribute_value")
    public String getAttributeValue() { 
        return this.attributeValue;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName,
            attributeValue);
            return builder;
    }

    public static class Builder {
        private String attributeName;
        private String attributeValue;

        public Builder(String attributeName,
                String attributeValue) {
            this.attributeName = attributeName;
            this.attributeValue = attributeValue;
        }

        public Builder attributeName(String value) {
            attributeName = value;
            return this;
        }
        public Builder attributeValue(String value) {
            attributeValue = value;
            return this;
        }

        public CatalogQueryExact build() {
            return new CatalogQueryExact(attributeName,
                attributeValue);
        }
    }
}
