
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogCustomAttributeValue type.
 */
public class CatalogCustomAttributeValue {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String stringValue;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customAttributeDefinitionId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String numberValue;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean booleanValue;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> selectionUidValues;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String key;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  stringValue  String value for stringValue.
     * @param  customAttributeDefinitionId  String value for customAttributeDefinitionId.
     * @param  type  String value for type.
     * @param  numberValue  String value for numberValue.
     * @param  booleanValue  Boolean value for booleanValue.
     * @param  selectionUidValues  List of String value for selectionUidValues.
     * @param  key  String value for key.
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

    /**
     * Getter for Name.
     * The name of the custom attribute.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for StringValue.
     * The string value of the custom attribute. Populated if `type` = `STRING`.
     * @return Returns the String
     */
    @JsonGetter("string_value")
    public String getStringValue() {
        return stringValue;
    }

    /**
     * Getter for CustomAttributeDefinitionId.
     * __Read-only.__ The id of the
     * [CatalogCustomAttributeDefinition](#type-CatalogCustomAttributeDefinition) this value belongs
     * to.
     * @return Returns the String
     */
    @JsonGetter("custom_attribute_definition_id")
    public String getCustomAttributeDefinitionId() {
        return customAttributeDefinitionId;
    }

    /**
     * Getter for Type.
     * Defines the possible types for a custom attribute.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for NumberValue.
     * Populated if `type` = `NUMBER`. Contains a string representation of a decimal number, using a
     * `.` as the decimal separator.
     * @return Returns the String
     */
    @JsonGetter("number_value")
    public String getNumberValue() {
        return numberValue;
    }

    /**
     * Getter for BooleanValue.
     * A `true` or `false` value. Populated if `type` = `BOOLEAN`.
     * @return Returns the Boolean
     */
    @JsonGetter("boolean_value")
    public Boolean getBooleanValue() {
        return booleanValue;
    }

    /**
     * Getter for SelectionUidValues.
     * One or more choices from `allowed_selections`. Populated if `type` = `SELECTION`.
     * @return Returns the List of String
     */
    @JsonGetter("selection_uid_values")
    public List<String> getSelectionUidValues() {
        return selectionUidValues;
    }

    /**
     * Getter for Key.
     * __Read-only.__ A copy of key from the associated `CatalogCustomAttributeDefinition`.
     * @return Returns the String
     */
    @JsonGetter("key")
    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stringValue, customAttributeDefinitionId, type, numberValue,
                booleanValue, selectionUidValues, key);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogCustomAttributeValue)) {
            return false;
        }
        CatalogCustomAttributeValue other = (CatalogCustomAttributeValue) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(stringValue, other.stringValue)
            && Objects.equals(customAttributeDefinitionId, other.customAttributeDefinitionId)
            && Objects.equals(type, other.type)
            && Objects.equals(numberValue, other.numberValue)
            && Objects.equals(booleanValue, other.booleanValue)
            && Objects.equals(selectionUidValues, other.selectionUidValues)
            && Objects.equals(key, other.key);
    }

    /**
     * Converts this CatalogCustomAttributeValue into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogCustomAttributeValue [" + "name=" + name + ", stringValue=" + stringValue
                + ", customAttributeDefinitionId=" + customAttributeDefinitionId + ", type=" + type
                + ", numberValue=" + numberValue + ", booleanValue=" + booleanValue
                + ", selectionUidValues=" + selectionUidValues + ", key=" + key + "]";
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
     * Class to build instances of {@link CatalogCustomAttributeValue}.
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
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for stringValue.
         * @param  stringValue  String value for stringValue.
         * @return Builder
         */
        public Builder stringValue(String stringValue) {
            this.stringValue = stringValue;
            return this;
        }

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
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for numberValue.
         * @param  numberValue  String value for numberValue.
         * @return Builder
         */
        public Builder numberValue(String numberValue) {
            this.numberValue = numberValue;
            return this;
        }

        /**
         * Setter for booleanValue.
         * @param  booleanValue  Boolean value for booleanValue.
         * @return Builder
         */
        public Builder booleanValue(Boolean booleanValue) {
            this.booleanValue = booleanValue;
            return this;
        }

        /**
         * Setter for selectionUidValues.
         * @param  selectionUidValues  List of String value for selectionUidValues.
         * @return Builder
         */
        public Builder selectionUidValues(List<String> selectionUidValues) {
            this.selectionUidValues = selectionUidValues;
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
         * Builds a new {@link CatalogCustomAttributeValue} object using the set fields.
         * @return {@link CatalogCustomAttributeValue}
         */
        public CatalogCustomAttributeValue build() {
            return new CatalogCustomAttributeValue(name, stringValue, customAttributeDefinitionId,
                    type, numberValue, booleanValue, selectionUidValues, key);
        }
    }
}
