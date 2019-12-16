package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQuerySortedAttribute {

    @JsonCreator
    public CatalogQuerySortedAttribute(
            @JsonProperty("attribute_name") String attributeName,
            @JsonProperty("initial_attribute_value") String initialAttributeValue,
            @JsonProperty("sort_order") String sortOrder) {
        this.attributeName = attributeName;
        this.initialAttributeValue = initialAttributeValue;
        this.sortOrder = sortOrder;
    }

    private final String attributeName;
    private final String initialAttributeValue;
    private final String sortOrder;

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, initialAttributeValue, sortOrder);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQuerySortedAttribute)) {
            return false;
        }
        CatalogQuerySortedAttribute catalogQuerySortedAttribute = (CatalogQuerySortedAttribute) o;
        return Objects.equals(attributeName, catalogQuerySortedAttribute.attributeName) &&
            Objects.equals(initialAttributeValue, catalogQuerySortedAttribute.initialAttributeValue) &&
            Objects.equals(sortOrder, catalogQuerySortedAttribute.sortOrder);
    }

    /**
     * Getter for AttributeName.
     * The attribute whose value should be used as the sort key.
     */
    @JsonGetter("attribute_name")
    public String getAttributeName() { 
        return this.attributeName;
    }

    /**
     * Getter for InitialAttributeValue.
     * The first attribute value to be returned by the query. Ascending sorts will return only
     * objects with this value or greater, while descending sorts will return only objects with this value
     * or less. If unset, start at the beginning (for ascending sorts) or end (for descending sorts).
     */
    @JsonGetter("initial_attribute_value")
    public String getInitialAttributeValue() { 
        return this.initialAttributeValue;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     */
    @JsonGetter("sort_order")
    public String getSortOrder() { 
        return this.sortOrder;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName)
            .initialAttributeValue(getInitialAttributeValue())
            .sortOrder(getSortOrder());
            return builder;
    }

    public static class Builder {
        private String attributeName;
        private String initialAttributeValue;
        private String sortOrder;

        public Builder(String attributeName) {
            this.attributeName = attributeName;
        }

        public Builder attributeName(String value) {
            attributeName = value;
            return this;
        }
        public Builder initialAttributeValue(String value) {
            initialAttributeValue = value;
            return this;
        }
        public Builder sortOrder(String value) {
            sortOrder = value;
            return this;
        }

        public CatalogQuerySortedAttribute build() {
            return new CatalogQuerySortedAttribute(attributeName,
                initialAttributeValue,
                sortOrder);
        }
    }
}
