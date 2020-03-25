package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogCustomAttributeDefinitionSelectionConfig type.
 */
public class CatalogCustomAttributeDefinitionSelectionConfig {

    /**
     * Initialization constructor.
     * @param maxAllowedSelections
     * @param allowedSelections
     */
    @JsonCreator
    public CatalogCustomAttributeDefinitionSelectionConfig(
            @JsonProperty("max_allowed_selections") Integer maxAllowedSelections,
            @JsonProperty("allowed_selections") List<CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection> allowedSelections) {
        this.maxAllowedSelections = maxAllowedSelections;
        this.allowedSelections = allowedSelections;
    }

    private final Integer maxAllowedSelections;
    private final List<CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection> allowedSelections;
    /**
     * Getter for MaxAllowedSelections.
     * The maximum number of selections that can be set. The maximum value for this
     * attribute is 100. May be modified, but changing the value will not
     * affect existing custom attribute values on objects. Clients need to
     * handle Custom Attributes with more selected values than allowed by this limit.
     */
    @JsonGetter("max_allowed_selections")
    public Integer getMaxAllowedSelections() {
        return this.maxAllowedSelections;
    }

    /**
     * Getter for AllowedSelections.
     * The set of valid `CatalogCustomAttributeSelections`. Up to a maximum of 100
     * selections can be defined. Can be modified.
     */
    @JsonGetter("allowed_selections")
    public List<CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection> getAllowedSelections() {
        return this.allowedSelections;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(maxAllowedSelections, allowedSelections);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogCustomAttributeDefinitionSelectionConfig)) {
            return false;
        }
        CatalogCustomAttributeDefinitionSelectionConfig catalogCustomAttributeDefinitionSelectionConfig = (CatalogCustomAttributeDefinitionSelectionConfig) obj;
        return Objects.equals(maxAllowedSelections, catalogCustomAttributeDefinitionSelectionConfig.maxAllowedSelections) &&
            Objects.equals(allowedSelections, catalogCustomAttributeDefinitionSelectionConfig.allowedSelections);
    }

    /**
     * Builds a new {@link CatalogCustomAttributeDefinitionSelectionConfig.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogCustomAttributeDefinitionSelectionConfig.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .maxAllowedSelections(getMaxAllowedSelections())
            .allowedSelections(getAllowedSelections());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogCustomAttributeDefinitionSelectionConfig}
     */
    public static class Builder {
        private Integer maxAllowedSelections;
        private List<CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection> allowedSelections;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for maxAllowedSelections
         * @param maxAllowedSelections
         * @return Builder
         */
        public Builder maxAllowedSelections(Integer maxAllowedSelections) {
            this.maxAllowedSelections = maxAllowedSelections;
            return this;
        }
        /**
         * Setter for allowedSelections
         * @param allowedSelections
         * @return Builder
         */
        public Builder allowedSelections(List<CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection> allowedSelections) {
            this.allowedSelections = allowedSelections;
            return this;
        }

        /**
         * Builds a new {@link CatalogCustomAttributeDefinitionSelectionConfig} object using the set fields.
         * @return {@link CatalogCustomAttributeDefinitionSelectionConfig}
         */
        public CatalogCustomAttributeDefinitionSelectionConfig build() {
            return new CatalogCustomAttributeDefinitionSelectionConfig(maxAllowedSelections,
                allowedSelections);
        }
    }
}
