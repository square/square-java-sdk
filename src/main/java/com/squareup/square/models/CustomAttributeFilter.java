
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CustomAttributeFilter type.
 */
public class CustomAttributeFilter {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customAttributeDefinitionId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String key;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String stringFilter;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Range numberFilter;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> selectionUidsFilter;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean boolFilter;

    /**
     * Initialization constructor.
     * @param  customAttributeDefinitionId  String value for customAttributeDefinitionId.
     * @param  key  String value for key.
     * @param  stringFilter  String value for stringFilter.
     * @param  numberFilter  Range value for numberFilter.
     * @param  selectionUidsFilter  List of String value for selectionUidsFilter.
     * @param  boolFilter  Boolean value for boolFilter.
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

    /**
     * Getter for CustomAttributeDefinitionId.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `custom_attribute_definition_id` property value against the the specified id.
     * @return Returns the String
     */
    @JsonGetter("custom_attribute_definition_id")
    public String getCustomAttributeDefinitionId() {
        return customAttributeDefinitionId;
    }

    /**
     * Getter for Key.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `key` property value against the specified key.
     * @return Returns the String
     */
    @JsonGetter("key")
    public String getKey() {
        return key;
    }

    /**
     * Getter for StringFilter.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `string_value` property value against the specified text.
     * @return Returns the String
     */
    @JsonGetter("string_filter")
    public String getStringFilter() {
        return stringFilter;
    }

    /**
     * Getter for NumberFilter.
     * The range of a number value between the specified lower and upper bounds.
     * @return Returns the Range
     */
    @JsonGetter("number_filter")
    public Range getNumberFilter() {
        return numberFilter;
    }

    /**
     * Getter for SelectionUidsFilter.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `selection_uid_values` values against the specified selection uids.
     * @return Returns the List of String
     */
    @JsonGetter("selection_uids_filter")
    public List<String> getSelectionUidsFilter() {
        return selectionUidsFilter;
    }

    /**
     * Getter for BoolFilter.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `boolean_value` property values against the specified Boolean expression.
     * @return Returns the Boolean
     */
    @JsonGetter("bool_filter")
    public Boolean getBoolFilter() {
        return boolFilter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customAttributeDefinitionId, key, stringFilter, numberFilter,
                selectionUidsFilter, boolFilter);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomAttributeFilter)) {
            return false;
        }
        CustomAttributeFilter other = (CustomAttributeFilter) obj;
        return Objects.equals(customAttributeDefinitionId, other.customAttributeDefinitionId)
            && Objects.equals(key, other.key)
            && Objects.equals(stringFilter, other.stringFilter)
            && Objects.equals(numberFilter, other.numberFilter)
            && Objects.equals(selectionUidsFilter, other.selectionUidsFilter)
            && Objects.equals(boolFilter, other.boolFilter);
    }

    /**
     * Converts this CustomAttributeFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomAttributeFilter [" + "customAttributeDefinitionId="
                + customAttributeDefinitionId + ", key=" + key + ", stringFilter=" + stringFilter
                + ", numberFilter=" + numberFilter + ", selectionUidsFilter=" + selectionUidsFilter
                + ", boolFilter=" + boolFilter + "]";
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
     * Class to build instances of {@link CustomAttributeFilter}.
     */
    public static class Builder {
        private String customAttributeDefinitionId;
        private String key;
        private String stringFilter;
        private Range numberFilter;
        private List<String> selectionUidsFilter;
        private Boolean boolFilter;



        /**
         * Setter for customAttributeDefinitionId.
         * @param  customAttributeDefinitionId  String value for customAttributeDefinitionId.
         * @return Builder
         */
        public Builder customAttributeDefinitionId(String customAttributeDefinitionId) {
            this.customAttributeDefinitionId = customAttributeDefinitionId;
            return this;
        }

        /**
         * Setter for key.
         * @param  key  String value for key.
         * @return Builder
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        /**
         * Setter for stringFilter.
         * @param  stringFilter  String value for stringFilter.
         * @return Builder
         */
        public Builder stringFilter(String stringFilter) {
            this.stringFilter = stringFilter;
            return this;
        }

        /**
         * Setter for numberFilter.
         * @param  numberFilter  Range value for numberFilter.
         * @return Builder
         */
        public Builder numberFilter(Range numberFilter) {
            this.numberFilter = numberFilter;
            return this;
        }

        /**
         * Setter for selectionUidsFilter.
         * @param  selectionUidsFilter  List of String value for selectionUidsFilter.
         * @return Builder
         */
        public Builder selectionUidsFilter(List<String> selectionUidsFilter) {
            this.selectionUidsFilter = selectionUidsFilter;
            return this;
        }

        /**
         * Setter for boolFilter.
         * @param  boolFilter  Boolean value for boolFilter.
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
            return new CustomAttributeFilter(customAttributeDefinitionId, key, stringFilter,
                    numberFilter, selectionUidsFilter, boolFilter);
        }
    }
}
