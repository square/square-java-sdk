package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQueryCustomAttributeUsage type.
 */
public class CatalogQueryCustomAttributeUsage {

    /**
     * Initialization constructor.
     * @param customAttributeDefinitionIds
     * @param hasValue
     */
    @JsonCreator
    public CatalogQueryCustomAttributeUsage(
            @JsonProperty("custom_attribute_definition_ids") List<String> customAttributeDefinitionIds,
            @JsonProperty("has_value") Boolean hasValue) {
        this.customAttributeDefinitionIds = customAttributeDefinitionIds;
        this.hasValue = hasValue;
    }

    private final List<String> customAttributeDefinitionIds;
    private final Boolean hasValue;
    /**
     * Getter for CustomAttributeDefinitionIds.
     */
    @JsonGetter("custom_attribute_definition_ids")
    public List<String> getCustomAttributeDefinitionIds() {
        return this.customAttributeDefinitionIds;
    }

    /**
     * Getter for HasValue.
     */
    @JsonGetter("has_value")
    public Boolean getHasValue() {
        return this.hasValue;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(customAttributeDefinitionIds, hasValue);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQueryCustomAttributeUsage)) {
            return false;
        }
        CatalogQueryCustomAttributeUsage catalogQueryCustomAttributeUsage = (CatalogQueryCustomAttributeUsage) obj;
        return Objects.equals(customAttributeDefinitionIds, catalogQueryCustomAttributeUsage.customAttributeDefinitionIds) &&
            Objects.equals(hasValue, catalogQueryCustomAttributeUsage.hasValue);
    }

    /**
     * Builds a new {@link CatalogQueryCustomAttributeUsage.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryCustomAttributeUsage.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .customAttributeDefinitionIds(getCustomAttributeDefinitionIds())
            .hasValue(getHasValue());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryCustomAttributeUsage}
     */
    public static class Builder {
        private List<String> customAttributeDefinitionIds;
        private Boolean hasValue;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for customAttributeDefinitionIds
         * @param customAttributeDefinitionIds
         * @return Builder
         */
        public Builder customAttributeDefinitionIds(List<String> customAttributeDefinitionIds) {
            this.customAttributeDefinitionIds = customAttributeDefinitionIds;
            return this;
        }
        /**
         * Setter for hasValue
         * @param hasValue
         * @return Builder
         */
        public Builder hasValue(Boolean hasValue) {
            this.hasValue = hasValue;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryCustomAttributeUsage} object using the set fields.
         * @return {@link CatalogQueryCustomAttributeUsage}
         */
        public CatalogQueryCustomAttributeUsage build() {
            return new CatalogQueryCustomAttributeUsage(customAttributeDefinitionIds,
                hasValue);
        }
    }
}
