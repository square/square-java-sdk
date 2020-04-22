package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogCustomAttributeValue type.
 */
public class CatalogCustomAttributeValue {

    /**
     * Initialization constructor.
     * @param name
     * @param stringValue
     * @param customAttributeDefinitionId
     * @param type
     * @param numberValue
     * @param booleanValue
     * @param selectionUidValues
     * @param key
     */
    @JsonCreator
    public CatalogCustomAttributeValue(
            @JsonProperty("name") String name,
            @JsonProperty("string_value") String stringValue,
            @JsonProperty("custom_attribute_definition_id") String customAttributeDefinitionId,
            @JsonProperty("type") String type,
            @JsonProperty("number_value") String numberValue,
            @JsonProperty("boolean_value") Boolean booleanValue,
            @JsonProperty("selection_uid_values") List<String> selectionUidValues,
            @JsonProperty("key") String key) {
        this.name = name;
        this.stringValue = stringValue;
        this.customAttributeDefinitionId = customAttributeDefinitionId;
        this.type = type;
        this.numberValue = numberValue;
        this.booleanValue = booleanValue;
        this.selectionUidValues = selectionUidValues;
        this.key = key;
    }

    private final String name;
    private final String stringValue;
    private final String customAttributeDefinitionId;
    private final String type;
    private final String numberValue;
    private final Boolean booleanValue;
    private final List<String> selectionUidValues;
    private final String key;
    /**
     * Getter for Name.
     * The name of the custom attribute.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for StringValue.
     * The string value of the custom attribute.  Populated if `type` = `STRING`.
     */
    @JsonGetter("string_value")
    public String getStringValue() {
        return this.stringValue;
    }

    /**
     * Getter for CustomAttributeDefinitionId.
     * __Read-only.__ The id of the [CatalogCustomAttributeDefinition](#type-CatalogCustomAttributeDefinition) this value belongs to.
     */
    @JsonGetter("custom_attribute_definition_id")
    public String getCustomAttributeDefinitionId() {
        return this.customAttributeDefinitionId;
    }

    /**
     * Getter for Type.
     * Defines the possible types for a custom attribute.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for NumberValue.
     * Populated if `type` = `NUMBER`. Contains a string
     * representation of a decimal number, using a `.` as the decimal separator.
     */
    @JsonGetter("number_value")
    public String getNumberValue() {
        return this.numberValue;
    }

    /**
     * Getter for BooleanValue.
     * A `true` or `false` value. Populated if `type` = `BOOLEAN`.
     */
    @JsonGetter("boolean_value")
    public Boolean getBooleanValue() {
        return this.booleanValue;
    }

    /**
     * Getter for SelectionUidValues.
     * One or more choices from `allowed_selections`. Populated if `type` = `SELECTION`.
     */
    @JsonGetter("selection_uid_values")
    public List<String> getSelectionUidValues() {
        return this.selectionUidValues;
    }

    /**
     * Getter for Key.
     * __Read-only.__ A copy of key from the associated `CatalogCustomAttributeDefinition`.
     */
    @JsonGetter("key")
    public String getKey() {
        return this.key;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, stringValue, customAttributeDefinitionId, type, numberValue,
            booleanValue, selectionUidValues, key);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogCustomAttributeValue)) {
            return false;
        }
        CatalogCustomAttributeValue catalogCustomAttributeValue = (CatalogCustomAttributeValue) obj;
        return Objects.equals(name, catalogCustomAttributeValue.name) &&
            Objects.equals(stringValue, catalogCustomAttributeValue.stringValue) &&
            Objects.equals(customAttributeDefinitionId, catalogCustomAttributeValue.customAttributeDefinitionId) &&
            Objects.equals(type, catalogCustomAttributeValue.type) &&
            Objects.equals(numberValue, catalogCustomAttributeValue.numberValue) &&
            Objects.equals(booleanValue, catalogCustomAttributeValue.booleanValue) &&
            Objects.equals(selectionUidValues, catalogCustomAttributeValue.selectionUidValues) &&
            Objects.equals(key, catalogCustomAttributeValue.key);
    }

    /**
     * Builds a new {@link CatalogCustomAttributeValue.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogCustomAttributeValue.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .stringValue(getStringValue())
            .customAttributeDefinitionId(getCustomAttributeDefinitionId())
            .type(getType())
            .numberValue(getNumberValue())
            .booleanValue(getBooleanValue())
            .selectionUidValues(getSelectionUidValues())
            .key(getKey());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogCustomAttributeValue}
     */
    public static class Builder {
        private String name;
        private String stringValue;
        private String customAttributeDefinitionId;
        private String type;
        private String numberValue;
        private Boolean booleanValue;
        private List<String> selectionUidValues;
        private String key;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for stringValue
         * @param stringValue
         * @return Builder
         */
        public Builder stringValue(String stringValue) {
            this.stringValue = stringValue;
            return this;
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
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for numberValue
         * @param numberValue
         * @return Builder
         */
        public Builder numberValue(String numberValue) {
            this.numberValue = numberValue;
            return this;
        }
        /**
         * Setter for booleanValue
         * @param booleanValue
         * @return Builder
         */
        public Builder booleanValue(Boolean booleanValue) {
            this.booleanValue = booleanValue;
            return this;
        }
        /**
         * Setter for selectionUidValues
         * @param selectionUidValues
         * @return Builder
         */
        public Builder selectionUidValues(List<String> selectionUidValues) {
            this.selectionUidValues = selectionUidValues;
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
         * Builds a new {@link CatalogCustomAttributeValue} object using the set fields.
         * @return {@link CatalogCustomAttributeValue}
         */
        public CatalogCustomAttributeValue build() {
            return new CatalogCustomAttributeValue(name,
                stringValue,
                customAttributeDefinitionId,
                type,
                numberValue,
                booleanValue,
                selectionUidValues,
                key);
        }
    }
}
