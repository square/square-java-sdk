package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQuerySortedAttribute type.
 */
public class CatalogQuerySortedAttribute {

    /**
     * Initialization constructor.
     * @param attributeName
     * @param initialAttributeValue
     * @param sortOrder
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(attributeName, initialAttributeValue, sortOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQuerySortedAttribute)) {
            return false;
        }
        CatalogQuerySortedAttribute catalogQuerySortedAttribute = (CatalogQuerySortedAttribute) obj;
        return Objects.equals(attributeName, catalogQuerySortedAttribute.attributeName) &&
            Objects.equals(initialAttributeValue, catalogQuerySortedAttribute.initialAttributeValue) &&
            Objects.equals(sortOrder, catalogQuerySortedAttribute.sortOrder);
    }

    /**
     * Builds a new {@link CatalogQuerySortedAttribute.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQuerySortedAttribute.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName)
            .initialAttributeValue(getInitialAttributeValue())
            .sortOrder(getSortOrder());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQuerySortedAttribute}
     */
    public static class Builder {
        private String attributeName;
        private String initialAttributeValue;
        private String sortOrder;

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
         * Setter for initialAttributeValue
         * @param initialAttributeValue
         * @return Builder
         */
        public Builder initialAttributeValue(String initialAttributeValue) {
            this.initialAttributeValue = initialAttributeValue;
            return this;
        }
        /**
         * Setter for sortOrder
         * @param sortOrder
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Builds a new {@link CatalogQuerySortedAttribute} object using the set fields.
         * @return {@link CatalogQuerySortedAttribute}
         */
        public CatalogQuerySortedAttribute build() {
            return new CatalogQuerySortedAttribute(attributeName,
                initialAttributeValue,
                sortOrder);
        }
    }
}
