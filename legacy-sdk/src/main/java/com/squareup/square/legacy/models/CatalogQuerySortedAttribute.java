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
 * This is a model class for CatalogQuerySortedAttribute type.
 */
public class CatalogQuerySortedAttribute {
    private final String attributeName;
    private final OptionalNullable<String> initialAttributeValue;
    private final String sortOrder;

    /**
     * Initialization constructor.
     * @param  attributeName  String value for attributeName.
     * @param  initialAttributeValue  String value for initialAttributeValue.
     * @param  sortOrder  String value for sortOrder.
     */
    @JsonCreator
    public CatalogQuerySortedAttribute(
            @JsonProperty("attribute_name") String attributeName,
            @JsonProperty("initial_attribute_value") String initialAttributeValue,
            @JsonProperty("sort_order") String sortOrder) {
        this.attributeName = attributeName;
        this.initialAttributeValue = OptionalNullable.of(initialAttributeValue);
        this.sortOrder = sortOrder;
    }

    /**
     * Initialization constructor.
     * @param  attributeName  String value for attributeName.
     * @param  initialAttributeValue  String value for initialAttributeValue.
     * @param  sortOrder  String value for sortOrder.
     */
    protected CatalogQuerySortedAttribute(
            String attributeName, OptionalNullable<String> initialAttributeValue, String sortOrder) {
        this.attributeName = attributeName;
        this.initialAttributeValue = initialAttributeValue;
        this.sortOrder = sortOrder;
    }

    /**
     * Getter for AttributeName.
     * The attribute whose value is used as the sort key.
     * @return Returns the String
     */
    @JsonGetter("attribute_name")
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * Internal Getter for InitialAttributeValue.
     * The first attribute value to be returned by the query. Ascending sorts will return only
     * objects with this value or greater, while descending sorts will return only objects with this
     * value or less. If unset, start at the beginning (for ascending sorts) or end (for descending
     * sorts).
     * @return Returns the Internal String
     */
    @JsonGetter("initial_attribute_value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetInitialAttributeValue() {
        return this.initialAttributeValue;
    }

    /**
     * Getter for InitialAttributeValue.
     * The first attribute value to be returned by the query. Ascending sorts will return only
     * objects with this value or greater, while descending sorts will return only objects with this
     * value or less. If unset, start at the beginning (for ascending sorts) or end (for descending
     * sorts).
     * @return Returns the String
     */
    @JsonIgnore
    public String getInitialAttributeValue() {
        return OptionalNullable.getFrom(initialAttributeValue);
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSortOrder() {
        return sortOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, initialAttributeValue, sortOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogQuerySortedAttribute)) {
            return false;
        }
        CatalogQuerySortedAttribute other = (CatalogQuerySortedAttribute) obj;
        return Objects.equals(attributeName, other.attributeName)
                && Objects.equals(initialAttributeValue, other.initialAttributeValue)
                && Objects.equals(sortOrder, other.sortOrder);
    }

    /**
     * Converts this CatalogQuerySortedAttribute into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogQuerySortedAttribute [" + "attributeName=" + attributeName
                + ", initialAttributeValue=" + initialAttributeValue + ", sortOrder=" + sortOrder
                + "]";
    }

    /**
     * Builds a new {@link CatalogQuerySortedAttribute.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQuerySortedAttribute.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName).sortOrder(getSortOrder());
        builder.initialAttributeValue = internalGetInitialAttributeValue();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogQuerySortedAttribute}.
     */
    public static class Builder {
        private String attributeName;
        private OptionalNullable<String> initialAttributeValue;
        private String sortOrder;

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
         * Setter for initialAttributeValue.
         * @param  initialAttributeValue  String value for initialAttributeValue.
         * @return Builder
         */
        public Builder initialAttributeValue(String initialAttributeValue) {
            this.initialAttributeValue = OptionalNullable.of(initialAttributeValue);
            return this;
        }

        /**
         * UnSetter for initialAttributeValue.
         * @return Builder
         */
        public Builder unsetInitialAttributeValue() {
            initialAttributeValue = null;
            return this;
        }

        /**
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
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
            return new CatalogQuerySortedAttribute(attributeName, initialAttributeValue, sortOrder);
        }
    }
}
