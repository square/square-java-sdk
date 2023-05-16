
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogCustomAttributeValue type.
 */
public class CatalogCustomAttributeValue {
    private final OptionalNullable<String> name;
    private final OptionalNullable<String> stringValue;
    private final String customAttributeDefinitionId;
    private final String type;
    private final OptionalNullable<String> numberValue;
    private final OptionalNullable<Boolean> booleanValue;
    private final OptionalNullable<List<String>> selectionUidValues;
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
        this.name = OptionalNullable.of(name);
        this.stringValue = OptionalNullable.of(stringValue);
        this.customAttributeDefinitionId = customAttributeDefinitionId;
        this.type = type;
        this.numberValue = OptionalNullable.of(numberValue);
        this.booleanValue = OptionalNullable.of(booleanValue);
        this.selectionUidValues = OptionalNullable.of(selectionUidValues);
        this.key = key;
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogCustomAttributeValue(OptionalNullable<String> name,
            OptionalNullable<String> stringValue, String customAttributeDefinitionId, String type,
            OptionalNullable<String> numberValue, OptionalNullable<Boolean> booleanValue,
            OptionalNullable<List<String>> selectionUidValues, String key) {
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
     * Internal Getter for Name.
     * The name of the custom attribute.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * The name of the custom attribute.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for StringValue.
     * The string value of the custom attribute. Populated if `type` = `STRING`.
     * @return Returns the Internal String
     */
    @JsonGetter("string_value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStringValue() {
        return this.stringValue;
    }

    /**
     * Getter for StringValue.
     * The string value of the custom attribute. Populated if `type` = `STRING`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStringValue() {
        return OptionalNullable.getFrom(stringValue);
    }

    /**
     * Getter for CustomAttributeDefinitionId.
     * The id of the [CatalogCustomAttributeDefinition](entity:CatalogCustomAttributeDefinition)
     * this value belongs to.
     * @return Returns the String
     */
    @JsonGetter("custom_attribute_definition_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCustomAttributeDefinitionId() {
        return customAttributeDefinitionId;
    }

    /**
     * Getter for Type.
     * Defines the possible types for a custom attribute.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Internal Getter for NumberValue.
     * Populated if `type` = `NUMBER`. Contains a string representation of a decimal number, using a
     * `.` as the decimal separator.
     * @return Returns the Internal String
     */
    @JsonGetter("number_value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNumberValue() {
        return this.numberValue;
    }

    /**
     * Getter for NumberValue.
     * Populated if `type` = `NUMBER`. Contains a string representation of a decimal number, using a
     * `.` as the decimal separator.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNumberValue() {
        return OptionalNullable.getFrom(numberValue);
    }

    /**
     * Internal Getter for BooleanValue.
     * A `true` or `false` value. Populated if `type` = `BOOLEAN`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("boolean_value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetBooleanValue() {
        return this.booleanValue;
    }

    /**
     * Getter for BooleanValue.
     * A `true` or `false` value. Populated if `type` = `BOOLEAN`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getBooleanValue() {
        return OptionalNullable.getFrom(booleanValue);
    }

    /**
     * Internal Getter for SelectionUidValues.
     * One or more choices from `allowed_selections`. Populated if `type` = `SELECTION`.
     * @return Returns the Internal List of String
     */
    @JsonGetter("selection_uid_values")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetSelectionUidValues() {
        return this.selectionUidValues;
    }

    /**
     * Getter for SelectionUidValues.
     * One or more choices from `allowed_selections`. Populated if `type` = `SELECTION`.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getSelectionUidValues() {
        return OptionalNullable.getFrom(selectionUidValues);
    }

    /**
     * Getter for Key.
     * If the associated `CatalogCustomAttributeDefinition` object is defined by another
     * application, this key is prefixed by the defining application ID. For example, if the
     * CatalogCustomAttributeDefinition has a key attribute of "cocoa_brand" and the defining
     * application ID is "abcd1234", this key is "abcd1234:cocoa_brand" when the application making
     * the request is different from the application defining the custom attribute definition.
     * Otherwise, the key is simply "cocoa_brand".
     * @return Returns the String
     */
    @JsonGetter("key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
                .customAttributeDefinitionId(getCustomAttributeDefinitionId())
                .type(getType())
                .key(getKey());
        builder.name = internalGetName();
        builder.stringValue = internalGetStringValue();
        builder.numberValue = internalGetNumberValue();
        builder.booleanValue = internalGetBooleanValue();
        builder.selectionUidValues = internalGetSelectionUidValues();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogCustomAttributeValue}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private OptionalNullable<String> stringValue;
        private String customAttributeDefinitionId;
        private String type;
        private OptionalNullable<String> numberValue;
        private OptionalNullable<Boolean> booleanValue;
        private OptionalNullable<List<String>> selectionUidValues;
        private String key;



        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for stringValue.
         * @param  stringValue  String value for stringValue.
         * @return Builder
         */
        public Builder stringValue(String stringValue) {
            this.stringValue = OptionalNullable.of(stringValue);
            return this;
        }

        /**
         * UnSetter for stringValue.
         * @return Builder
         */
        public Builder unsetStringValue() {
            stringValue = null;
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
            this.numberValue = OptionalNullable.of(numberValue);
            return this;
        }

        /**
         * UnSetter for numberValue.
         * @return Builder
         */
        public Builder unsetNumberValue() {
            numberValue = null;
            return this;
        }

        /**
         * Setter for booleanValue.
         * @param  booleanValue  Boolean value for booleanValue.
         * @return Builder
         */
        public Builder booleanValue(Boolean booleanValue) {
            this.booleanValue = OptionalNullable.of(booleanValue);
            return this;
        }

        /**
         * UnSetter for booleanValue.
         * @return Builder
         */
        public Builder unsetBooleanValue() {
            booleanValue = null;
            return this;
        }

        /**
         * Setter for selectionUidValues.
         * @param  selectionUidValues  List of String value for selectionUidValues.
         * @return Builder
         */
        public Builder selectionUidValues(List<String> selectionUidValues) {
            this.selectionUidValues = OptionalNullable.of(selectionUidValues);
            return this;
        }

        /**
         * UnSetter for selectionUidValues.
         * @return Builder
         */
        public Builder unsetSelectionUidValues() {
            selectionUidValues = null;
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
