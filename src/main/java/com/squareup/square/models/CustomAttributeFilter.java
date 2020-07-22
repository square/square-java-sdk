package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CustomAttributeFilter type.
 */
public class CustomAttributeFilter {

    /**
     * Initialization constructor.
     * @param customAttributeDefinitionId
     * @param key
     * @param stringFilter
     * @param numberFilter
     * @param selectionUidsFilter
     * @param boolFilter
     */
    @JsonCreator
    public CustomAttributeFilter(
            @JsonProperty("custom_attribute_definition_id") String customAttributeDefinitionId,
            @JsonProperty("key") String key,
            @JsonProperty("string_filter") String stringFilter,
            @JsonProperty("number_filter") Range numberFilter,
            @JsonProperty("selection_uids_filter") List<String> selectionUidsFilter,
            @JsonProperty("bool_filter") Boolean boolFilter) {
        this.customAttributeDefinitionId = customAttributeDefinitionId;
        this.key = key;
        this.stringFilter = stringFilter;
        this.numberFilter = numberFilter;
        this.selectionUidsFilter = selectionUidsFilter;
        this.boolFilter = boolFilter;
    }

    private final String customAttributeDefinitionId;
    private final String key;
    private final String stringFilter;
    private final Range numberFilter;
    private final List<String> selectionUidsFilter;
    private final Boolean boolFilter;
    /**
     * Getter for CustomAttributeDefinitionId.
     * A query expression to filter items or item variations by matching their custom attributes' 
     * `custom_attribute_definition_id`  
     * property value against the the specified id.
     */
    @JsonGetter("custom_attribute_definition_id")
    public String getCustomAttributeDefinitionId() {
        return this.customAttributeDefinitionId;
    }

    /**
     * Getter for Key.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `key` property value against 
     * the specified key.
     */
    @JsonGetter("key")
    public String getKey() {
        return this.key;
    }

    /**
     * Getter for StringFilter.
     * A query expression to filter items or item variations by matching their custom attributes' 
     * `string_value`  property value 
     * against the specified text.
     */
    @JsonGetter("string_filter")
    public String getStringFilter() {
        return this.stringFilter;
    }

    /**
     * Getter for NumberFilter.
     * The range of a number value between the specified lower and upper bounds.
     */
    @JsonGetter("number_filter")
    public Range getNumberFilter() {
        return this.numberFilter;
    }

    /**
     * Getter for SelectionUidsFilter.
     * A query expression to filter items or item variations by matching  their custom attributes' 
     * `selection_uid_values` 
     * values against the specified selection uids.
     */
    @JsonGetter("selection_uids_filter")
    public List<String> getSelectionUidsFilter() {
        return this.selectionUidsFilter;
    }

    /**
     * Getter for BoolFilter.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `boolean_value` property values 
     * against the specified Boolean expression.
     */
    @JsonGetter("bool_filter")
    public Boolean getBoolFilter() {
        return this.boolFilter;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(customAttributeDefinitionId, key, stringFilter, numberFilter,
            selectionUidsFilter, boolFilter);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CustomAttributeFilter)) {
            return false;
        }
        CustomAttributeFilter customAttributeFilter = (CustomAttributeFilter) obj;
        return Objects.equals(customAttributeDefinitionId, customAttributeFilter.customAttributeDefinitionId) &&
            Objects.equals(key, customAttributeFilter.key) &&
            Objects.equals(stringFilter, customAttributeFilter.stringFilter) &&
            Objects.equals(numberFilter, customAttributeFilter.numberFilter) &&
            Objects.equals(selectionUidsFilter, customAttributeFilter.selectionUidsFilter) &&
            Objects.equals(boolFilter, customAttributeFilter.boolFilter);
    }

    /**
     * Builds a new {@link CustomAttributeFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomAttributeFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .customAttributeDefinitionId(getCustomAttributeDefinitionId())
            .key(getKey())
            .stringFilter(getStringFilter())
            .numberFilter(getNumberFilter())
            .selectionUidsFilter(getSelectionUidsFilter())
            .boolFilter(getBoolFilter());
            return builder;
    }

    /**
     * Class to build instances of {@link CustomAttributeFilter}
     */
    public static class Builder {
        private String customAttributeDefinitionId;
        private String key;
        private String stringFilter;
        private Range numberFilter;
        private List<String> selectionUidsFilter;
        private Boolean boolFilter;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for customAttributeDefinitionId
         * @param customAttributeDefinitionId
         * @return Builder
         */
        public Builder customAttributeDefinitionId(String customAttributeDefinitionId) {
            this.customAttributeDefinitionId = customAttributeDefinitionId;
            return this;
        }
        /**
         * Setter for key
         * @param key
         * @return Builder
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }
        /**
         * Setter for stringFilter
         * @param stringFilter
         * @return Builder
         */
        public Builder stringFilter(String stringFilter) {
            this.stringFilter = stringFilter;
            return this;
        }
        /**
         * Setter for numberFilter
         * @param numberFilter
         * @return Builder
         */
        public Builder numberFilter(Range numberFilter) {
            this.numberFilter = numberFilter;
            return this;
        }
        /**
         * Setter for selectionUidsFilter
         * @param selectionUidsFilter
         * @return Builder
         */
        public Builder selectionUidsFilter(List<String> selectionUidsFilter) {
            this.selectionUidsFilter = selectionUidsFilter;
            return this;
        }
        /**
         * Setter for boolFilter
         * @param boolFilter
         * @return Builder
         */
        public Builder boolFilter(Boolean boolFilter) {
            this.boolFilter = boolFilter;
            return this;
        }

        /**
         * Builds a new {@link CustomAttributeFilter} object using the set fields.
         * @return {@link CustomAttributeFilter}
         */
        public CustomAttributeFilter build() {
            return new CustomAttributeFilter(customAttributeDefinitionId,
                key,
                stringFilter,
                numberFilter,
                selectionUidsFilter,
                boolFilter);
        }
    }
}
