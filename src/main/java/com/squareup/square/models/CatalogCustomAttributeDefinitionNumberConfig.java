package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogCustomAttributeDefinitionNumberConfig type.
 */
public class CatalogCustomAttributeDefinitionNumberConfig {

    /**
     * Initialization constructor.
     * @param precision
     */
    @JsonCreator
    public CatalogCustomAttributeDefinitionNumberConfig(
            @JsonProperty("precision") Integer precision) {
        this.precision = precision;
    }

    private final Integer precision;
    /**
     * Getter for Precision.
     * An integer between 0 and 5 that represents the maximum number of
     * positions allowed after the decimal in number custom attribute values
     * For example:
     * - if the precision is 0, the quantity can be 1, 2, 3, etc.
     * - if the precision is 1, the quantity can be 0.1, 0.2, etc.
     * - if the precision is 2, the quantity can be 0.01, 0.12, etc.
     * Default: 5
     */
    @JsonGetter("precision")
    public Integer getPrecision() {
        return this.precision;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(precision);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogCustomAttributeDefinitionNumberConfig)) {
            return false;
        }
        CatalogCustomAttributeDefinitionNumberConfig catalogCustomAttributeDefinitionNumberConfig = (CatalogCustomAttributeDefinitionNumberConfig) obj;
        return Objects.equals(precision, catalogCustomAttributeDefinitionNumberConfig.precision);
    }

    /**
     * Builds a new {@link CatalogCustomAttributeDefinitionNumberConfig.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogCustomAttributeDefinitionNumberConfig.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .precision(getPrecision());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogCustomAttributeDefinitionNumberConfig}
     */
    public static class Builder {
        private Integer precision;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for precision
         * @param precision
         * @return Builder
         */
        public Builder precision(Integer precision) {
            this.precision = precision;
            return this;
        }

        /**
         * Builds a new {@link CatalogCustomAttributeDefinitionNumberConfig} object using the set fields.
         * @return {@link CatalogCustomAttributeDefinitionNumberConfig}
         */
        public CatalogCustomAttributeDefinitionNumberConfig build() {
            return new CatalogCustomAttributeDefinitionNumberConfig(precision);
        }
    }
}
