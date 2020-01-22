package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQueryFilteredItemsCustomAttributeFilter type.
 */
public class CatalogQueryFilteredItemsCustomAttributeFilter {

    /**
     * Initialization constructor.
     * @param filterType
     * @param customAttributeDefinitionIds
     * @param customAttributeValueExact
     * @param customAttributeValuePrefix
     * @param customAttributeMinValue
     * @param customAttributeMaxValue
     */
    @JsonCreator
    public CatalogQueryFilteredItemsCustomAttributeFilter(
            @JsonProperty("filter_type") String filterType,
            @JsonProperty("custom_attribute_definition_ids") List<String> customAttributeDefinitionIds,
            @JsonProperty("custom_attribute_value_exact") String customAttributeValueExact,
            @JsonProperty("custom_attribute_value_prefix") String customAttributeValuePrefix,
            @JsonProperty("custom_attribute_min_value") String customAttributeMinValue,
            @JsonProperty("custom_attribute_max_value") String customAttributeMaxValue) {
        this.filterType = filterType;
        this.customAttributeDefinitionIds = customAttributeDefinitionIds;
        this.customAttributeValueExact = customAttributeValueExact;
        this.customAttributeValuePrefix = customAttributeValuePrefix;
        this.customAttributeMinValue = customAttributeMinValue;
        this.customAttributeMaxValue = customAttributeMaxValue;
    }

    private final String filterType;
    private final List<String> customAttributeDefinitionIds;
    private final String customAttributeValueExact;
    private final String customAttributeValuePrefix;
    private final String customAttributeMinValue;
    private final String customAttributeMaxValue;
    /**
     * Getter for FilterType.
     */
    @JsonGetter("filter_type")
    public String getFilterType() {
        return this.filterType;
    }

    /**
     * Getter for CustomAttributeDefinitionIds.
     */
    @JsonGetter("custom_attribute_definition_ids")
    public List<String> getCustomAttributeDefinitionIds() {
        return this.customAttributeDefinitionIds;
    }

    /**
     * Getter for CustomAttributeValueExact.
     */
    @JsonGetter("custom_attribute_value_exact")
    public String getCustomAttributeValueExact() {
        return this.customAttributeValueExact;
    }

    /**
     * Getter for CustomAttributeValuePrefix.
     */
    @JsonGetter("custom_attribute_value_prefix")
    public String getCustomAttributeValuePrefix() {
        return this.customAttributeValuePrefix;
    }

    /**
     * Getter for CustomAttributeMinValue.
     */
    @JsonGetter("custom_attribute_min_value")
    public String getCustomAttributeMinValue() {
        return this.customAttributeMinValue;
    }

    /**
     * Getter for CustomAttributeMaxValue.
     */
    @JsonGetter("custom_attribute_max_value")
    public String getCustomAttributeMaxValue() {
        return this.customAttributeMaxValue;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(filterType, customAttributeDefinitionIds, customAttributeValueExact,
            customAttributeValuePrefix, customAttributeMinValue, customAttributeMaxValue);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQueryFilteredItemsCustomAttributeFilter)) {
            return false;
        }
        CatalogQueryFilteredItemsCustomAttributeFilter catalogQueryFilteredItemsCustomAttributeFilter = (CatalogQueryFilteredItemsCustomAttributeFilter) obj;
        return Objects.equals(filterType, catalogQueryFilteredItemsCustomAttributeFilter.filterType) &&
            Objects.equals(customAttributeDefinitionIds, catalogQueryFilteredItemsCustomAttributeFilter.customAttributeDefinitionIds) &&
            Objects.equals(customAttributeValueExact, catalogQueryFilteredItemsCustomAttributeFilter.customAttributeValueExact) &&
            Objects.equals(customAttributeValuePrefix, catalogQueryFilteredItemsCustomAttributeFilter.customAttributeValuePrefix) &&
            Objects.equals(customAttributeMinValue, catalogQueryFilteredItemsCustomAttributeFilter.customAttributeMinValue) &&
            Objects.equals(customAttributeMaxValue, catalogQueryFilteredItemsCustomAttributeFilter.customAttributeMaxValue);
    }

    /**
     * Builds a new {@link CatalogQueryFilteredItemsCustomAttributeFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryFilteredItemsCustomAttributeFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filterType(getFilterType())
            .customAttributeDefinitionIds(getCustomAttributeDefinitionIds())
            .customAttributeValueExact(getCustomAttributeValueExact())
            .customAttributeValuePrefix(getCustomAttributeValuePrefix())
            .customAttributeMinValue(getCustomAttributeMinValue())
            .customAttributeMaxValue(getCustomAttributeMaxValue());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryFilteredItemsCustomAttributeFilter}
     */
    public static class Builder {
        private String filterType;
        private List<String> customAttributeDefinitionIds;
        private String customAttributeValueExact;
        private String customAttributeValuePrefix;
        private String customAttributeMinValue;
        private String customAttributeMaxValue;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for filterType
         * @param filterType
         * @return Builder
         */
        public Builder filterType(String filterType) {
            this.filterType = filterType;
            return this;
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
         * Setter for customAttributeValueExact
         * @param customAttributeValueExact
         * @return Builder
         */
        public Builder customAttributeValueExact(String customAttributeValueExact) {
            this.customAttributeValueExact = customAttributeValueExact;
            return this;
        }
        /**
         * Setter for customAttributeValuePrefix
         * @param customAttributeValuePrefix
         * @return Builder
         */
        public Builder customAttributeValuePrefix(String customAttributeValuePrefix) {
            this.customAttributeValuePrefix = customAttributeValuePrefix;
            return this;
        }
        /**
         * Setter for customAttributeMinValue
         * @param customAttributeMinValue
         * @return Builder
         */
        public Builder customAttributeMinValue(String customAttributeMinValue) {
            this.customAttributeMinValue = customAttributeMinValue;
            return this;
        }
        /**
         * Setter for customAttributeMaxValue
         * @param customAttributeMaxValue
         * @return Builder
         */
        public Builder customAttributeMaxValue(String customAttributeMaxValue) {
            this.customAttributeMaxValue = customAttributeMaxValue;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryFilteredItemsCustomAttributeFilter} object using the set fields.
         * @return {@link CatalogQueryFilteredItemsCustomAttributeFilter}
         */
        public CatalogQueryFilteredItemsCustomAttributeFilter build() {
            return new CatalogQueryFilteredItemsCustomAttributeFilter(filterType,
                customAttributeDefinitionIds,
                customAttributeValueExact,
                customAttributeValuePrefix,
                customAttributeMinValue,
                customAttributeMaxValue);
        }
    }
}
