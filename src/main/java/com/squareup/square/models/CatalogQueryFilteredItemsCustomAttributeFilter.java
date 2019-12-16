package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryFilteredItemsCustomAttributeFilter {

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

    @Override
    public int hashCode() {
        return Objects.hash(filterType, customAttributeDefinitionIds, customAttributeValueExact, customAttributeValuePrefix, customAttributeMinValue, customAttributeMaxValue);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryFilteredItemsCustomAttributeFilter)) {
            return false;
        }
        CatalogQueryFilteredItemsCustomAttributeFilter catalogQueryFilteredItemsCustomAttributeFilter = (CatalogQueryFilteredItemsCustomAttributeFilter) o;
        return Objects.equals(filterType, catalogQueryFilteredItemsCustomAttributeFilter.filterType) &&
            Objects.equals(customAttributeDefinitionIds, catalogQueryFilteredItemsCustomAttributeFilter.customAttributeDefinitionIds) &&
            Objects.equals(customAttributeValueExact, catalogQueryFilteredItemsCustomAttributeFilter.customAttributeValueExact) &&
            Objects.equals(customAttributeValuePrefix, catalogQueryFilteredItemsCustomAttributeFilter.customAttributeValuePrefix) &&
            Objects.equals(customAttributeMinValue, catalogQueryFilteredItemsCustomAttributeFilter.customAttributeMinValue) &&
            Objects.equals(customAttributeMaxValue, catalogQueryFilteredItemsCustomAttributeFilter.customAttributeMaxValue);
    }

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

    public static class Builder {
        private String filterType;
        private List<String> customAttributeDefinitionIds;
        private String customAttributeValueExact;
        private String customAttributeValuePrefix;
        private String customAttributeMinValue;
        private String customAttributeMaxValue;

        public Builder() { }

        public Builder filterType(String value) {
            filterType = value;
            return this;
        }
        public Builder customAttributeDefinitionIds(List<String> value) {
            customAttributeDefinitionIds = value;
            return this;
        }
        public Builder customAttributeValueExact(String value) {
            customAttributeValueExact = value;
            return this;
        }
        public Builder customAttributeValuePrefix(String value) {
            customAttributeValuePrefix = value;
            return this;
        }
        public Builder customAttributeMinValue(String value) {
            customAttributeMinValue = value;
            return this;
        }
        public Builder customAttributeMaxValue(String value) {
            customAttributeMaxValue = value;
            return this;
        }

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
