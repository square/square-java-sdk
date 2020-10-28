
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for CatalogQuerySet type.
 */
public class CatalogQuerySet {
    private final String attributeName;
    private final List<String> attributeValues;

    /**
     * Initialization constructor.
     * @param attributeName String value for attributeName.
     * @param attributeValues List of String value for attributeValues.
     */
    @JsonCreator
    public CatalogQuerySet(
            @JsonProperty("attribute_name") String attributeName,
            @JsonProperty("attribute_values") List<String> attributeValues) {
        this.attributeName = attributeName;
        this.attributeValues = attributeValues;
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
     * Getter for AttributeValues.
     * The desired values of the search attribute. Matching of the attribute values is exact and
     * case insensitive. A maximum of 250 values may be searched in a request.
     * @return Returns the List of String
     */
    @JsonGetter("attribute_values")
    public List<String> getAttributeValues() {
        return this.attributeValues;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(attributeName, attributeValues);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogQuerySet)) {
            return false;
        }
        CatalogQuerySet other = (CatalogQuerySet) obj;
        return Objects.equals(attributeName, other.attributeName)
            && Objects.equals(attributeValues, other.attributeValues);
    }

    /**
     * Builds a new {@link CatalogQuerySet.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQuerySet.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(attributeName,
            attributeValues);
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogQuerySet}.
     */
    public static class Builder {
        private String attributeName;
        private List<String> attributeValues;

        /**
         * Initialization constructor.
         * @param attributeName String value for attributeName.
         * @param attributeValues List of String value for attributeValues.
         */
        public Builder(String attributeName,
                List<String> attributeValues) {
            this.attributeName = attributeName;
            this.attributeValues = attributeValues;
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
         * Setter for attributeValues.
         * @param attributeValues List of String value for attributeValues.
         * @return Builder
         */
        public Builder attributeValues(List<String> attributeValues) {
            this.attributeValues = attributeValues;
            return this;
        }

        /**
         * Builds a new {@link CatalogQuerySet} object using the set fields.
         * @return {@link CatalogQuerySet}
         */
        public CatalogQuerySet build() {
            return new CatalogQuerySet(attributeName,
                attributeValues);
        }
    }
}
