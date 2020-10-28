
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for CatalogCustomAttributeDefinitionSelectionConfig type.
 */
public class CatalogCustomAttributeDefinitionSelectionConfig {
    private final Integer maxAllowedSelections;
    private final List<CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection> allowedSelections;

    /**
     * Initialization constructor.
     * @param maxAllowedSelections Integer value for maxAllowedSelections.
     * @param allowedSelections List of CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection value for allowedSelections.
     */
    @JsonCreator
    public CatalogCustomAttributeDefinitionSelectionConfig(
            @JsonProperty("max_allowed_selections") Integer maxAllowedSelections,
            @JsonProperty("allowed_selections") List<CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection> allowedSelections) {
        this.maxAllowedSelections = maxAllowedSelections;
        this.allowedSelections = allowedSelections;
    }

    /**
     * Getter for MaxAllowedSelections.
     * The maximum number of selections that can be set. The maximum value for this attribute is
     * 100. The default value is 1. The value can be modified, but changing the value will not
     * affect existing custom attribute values on objects. Clients need to handle custom attributes
     * with more selected values than allowed by this limit.
     * @return Returns the Integer
     */
    @JsonGetter("max_allowed_selections")
    public Integer getMaxAllowedSelections() {
        return this.maxAllowedSelections;
    }

    /**
     * Getter for AllowedSelections.
     * The set of valid `CatalogCustomAttributeSelections`. Up to a maximum of 100 selections can be
     * defined. Can be modified.
     * @return Returns the List of CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogCustomAttributeDefinitionSelectionConfig)) {
            return false;
        }
        CatalogCustomAttributeDefinitionSelectionConfig other =
                (CatalogCustomAttributeDefinitionSelectionConfig) obj;
        return Objects.equals(maxAllowedSelections, other.maxAllowedSelections)
            && Objects.equals(allowedSelections, other.allowedSelections);
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
     * Class to build instances of {@link CatalogCustomAttributeDefinitionSelectionConfig}.
     */
    public static class Builder {
        private Integer maxAllowedSelections;
        private List<CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection> allowedSelections;



        /**
         * Setter for maxAllowedSelections.
         * @param maxAllowedSelections Integer value for maxAllowedSelections.
         * @return Builder
         */
        public Builder maxAllowedSelections(Integer maxAllowedSelections) {
            this.maxAllowedSelections = maxAllowedSelections;
            return this;
        }

        /**
         * Setter for allowedSelections.
         * @param allowedSelections List of CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection value for allowedSelections.
         * @return Builder
         */
        public Builder allowedSelections(List<CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection> allowedSelections) {
            this.allowedSelections = allowedSelections;
            return this;
        }

        /**
         * Builds a new {@link CatalogCustomAttributeDefinitionSelectionConfig} object using the set
         * fields.
         * @return {@link CatalogCustomAttributeDefinitionSelectionConfig}
         */
        public CatalogCustomAttributeDefinitionSelectionConfig build() {
            return new CatalogCustomAttributeDefinitionSelectionConfig(maxAllowedSelections,
                allowedSelections);
        }
    }
}
