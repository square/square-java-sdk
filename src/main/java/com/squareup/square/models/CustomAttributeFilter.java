
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CustomAttributeFilter type.
 */
public class CustomAttributeFilter {
    private final OptionalNullable<String> customAttributeDefinitionId;
    private final OptionalNullable<String> key;
    private final OptionalNullable<String> stringFilter;
    private final Range numberFilter;
    private final OptionalNullable<List<String>> selectionUidsFilter;
    private final OptionalNullable<Boolean> boolFilter;

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
        this.customAttributeDefinitionId = OptionalNullable.of(customAttributeDefinitionId);
        this.key = OptionalNullable.of(key);
        this.stringFilter = OptionalNullable.of(stringFilter);
        this.numberFilter = numberFilter;
        this.selectionUidsFilter = OptionalNullable.of(selectionUidsFilter);
        this.boolFilter = OptionalNullable.of(boolFilter);
    }

    /**
     * Internal initialization constructor.
     */
    protected CustomAttributeFilter(OptionalNullable<String> customAttributeDefinitionId,
            OptionalNullable<String> key, OptionalNullable<String> stringFilter, Range numberFilter,
            OptionalNullable<List<String>> selectionUidsFilter,
            OptionalNullable<Boolean> boolFilter) {
        this.customAttributeDefinitionId = customAttributeDefinitionId;
        this.key = key;
        this.stringFilter = stringFilter;
        this.numberFilter = numberFilter;
        this.selectionUidsFilter = selectionUidsFilter;
        this.boolFilter = boolFilter;
    }

    /**
     * Internal Getter for CustomAttributeDefinitionId.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `custom_attribute_definition_id` property value against the the specified id. Exactly one of
     * `custom_attribute_definition_id` or `key` must be specified.
     * @return Returns the Internal String
     */
    @JsonGetter("custom_attribute_definition_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomAttributeDefinitionId() {
        return this.customAttributeDefinitionId;
    }

    /**
     * Getter for CustomAttributeDefinitionId.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `custom_attribute_definition_id` property value against the the specified id. Exactly one of
     * `custom_attribute_definition_id` or `key` must be specified.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomAttributeDefinitionId() {
        return OptionalNullable.getFrom(customAttributeDefinitionId);
    }

    /**
     * Internal Getter for Key.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `key` property value against the specified key. Exactly one of
     * `custom_attribute_definition_id` or `key` must be specified.
     * @return Returns the Internal String
     */
    @JsonGetter("key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetKey() {
        return this.key;
    }

    /**
     * Getter for Key.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `key` property value against the specified key. Exactly one of
     * `custom_attribute_definition_id` or `key` must be specified.
     * @return Returns the String
     */
    @JsonIgnore
    public String getKey() {
        return OptionalNullable.getFrom(key);
    }

    /**
     * Internal Getter for StringFilter.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `string_value` property value against the specified text. Exactly one of `string_filter`,
     * `number_filter`, `selection_uids_filter`, or `bool_filter` must be specified.
     * @return Returns the Internal String
     */
    @JsonGetter("string_filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStringFilter() {
        return this.stringFilter;
    }

    /**
     * Getter for StringFilter.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `string_value` property value against the specified text. Exactly one of `string_filter`,
     * `number_filter`, `selection_uids_filter`, or `bool_filter` must be specified.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStringFilter() {
        return OptionalNullable.getFrom(stringFilter);
    }

    /**
     * Getter for NumberFilter.
     * The range of a number value between the specified lower and upper bounds.
     * @return Returns the Range
     */
    @JsonGetter("number_filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Range getNumberFilter() {
        return numberFilter;
    }

    /**
     * Internal Getter for SelectionUidsFilter.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `selection_uid_values` values against the specified selection uids. Exactly one of
     * `string_filter`, `number_filter`, `selection_uids_filter`, or `bool_filter` must be
     * specified.
     * @return Returns the Internal List of String
     */
    @JsonGetter("selection_uids_filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetSelectionUidsFilter() {
        return this.selectionUidsFilter;
    }

    /**
     * Getter for SelectionUidsFilter.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `selection_uid_values` values against the specified selection uids. Exactly one of
     * `string_filter`, `number_filter`, `selection_uids_filter`, or `bool_filter` must be
     * specified.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getSelectionUidsFilter() {
        return OptionalNullable.getFrom(selectionUidsFilter);
    }

    /**
     * Internal Getter for BoolFilter.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `boolean_value` property values against the specified Boolean expression. Exactly one of
     * `string_filter`, `number_filter`, `selection_uids_filter`, or `bool_filter` must be
     * specified.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("bool_filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetBoolFilter() {
        return this.boolFilter;
    }

    /**
     * Getter for BoolFilter.
     * A query expression to filter items or item variations by matching their custom attributes'
     * `boolean_value` property values against the specified Boolean expression. Exactly one of
     * `string_filter`, `number_filter`, `selection_uids_filter`, or `bool_filter` must be
     * specified.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getBoolFilter() {
        return OptionalNullable.getFrom(boolFilter);
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
                .numberFilter(getNumberFilter());
        builder.customAttributeDefinitionId = internalGetCustomAttributeDefinitionId();
        builder.key = internalGetKey();
        builder.stringFilter = internalGetStringFilter();
        builder.selectionUidsFilter = internalGetSelectionUidsFilter();
        builder.boolFilter = internalGetBoolFilter();
        return builder;
    }

    /**
     * Class to build instances of {@link CustomAttributeFilter}.
     */
    public static class Builder {
        private OptionalNullable<String> customAttributeDefinitionId;
        private OptionalNullable<String> key;
        private OptionalNullable<String> stringFilter;
        private Range numberFilter;
        private OptionalNullable<List<String>> selectionUidsFilter;
        private OptionalNullable<Boolean> boolFilter;



        /**
         * Setter for customAttributeDefinitionId.
         * @param  customAttributeDefinitionId  String value for customAttributeDefinitionId.
         * @return Builder
         */
        public Builder customAttributeDefinitionId(String customAttributeDefinitionId) {
            this.customAttributeDefinitionId = OptionalNullable.of(customAttributeDefinitionId);
            return this;
        }

        /**
         * UnSetter for customAttributeDefinitionId.
         * @return Builder
         */
        public Builder unsetCustomAttributeDefinitionId() {
            customAttributeDefinitionId = null;
            return this;
        }

        /**
         * Setter for key.
         * @param  key  String value for key.
         * @return Builder
         */
        public Builder key(String key) {
            this.key = OptionalNullable.of(key);
            return this;
        }

        /**
         * UnSetter for key.
         * @return Builder
         */
        public Builder unsetKey() {
            key = null;
            return this;
        }

        /**
         * Setter for stringFilter.
         * @param  stringFilter  String value for stringFilter.
         * @return Builder
         */
        public Builder stringFilter(String stringFilter) {
            this.stringFilter = OptionalNullable.of(stringFilter);
            return this;
        }

        /**
         * UnSetter for stringFilter.
         * @return Builder
         */
        public Builder unsetStringFilter() {
            stringFilter = null;
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
            this.selectionUidsFilter = OptionalNullable.of(selectionUidsFilter);
            return this;
        }

        /**
         * UnSetter for selectionUidsFilter.
         * @return Builder
         */
        public Builder unsetSelectionUidsFilter() {
            selectionUidsFilter = null;
            return this;
        }

        /**
         * Setter for boolFilter.
         * @param  boolFilter  Boolean value for boolFilter.
         * @return Builder
         */
        public Builder boolFilter(Boolean boolFilter) {
            this.boolFilter = OptionalNullable.of(boolFilter);
            return this;
        }

        /**
         * UnSetter for boolFilter.
         * @return Builder
         */
        public Builder unsetBoolFilter() {
            boolFilter = null;
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
