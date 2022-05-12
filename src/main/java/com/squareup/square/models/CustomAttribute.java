
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.utilities.JsonValue;
import java.util.Objects;

/**
 * This is a model class for CustomAttribute type.
 */
public class CustomAttribute {
    private final String key;
    private final JsonValue value;
    private final Integer version;
    private final String visibility;
    private final CustomAttributeDefinition definition;
    private final String updatedAt;
    private final String createdAt;

    /**
     * Initialization constructor.
     * @param  key  String value for key.
     * @param  value  JsonValue value for value.
     * @param  version  Integer value for version.
     * @param  visibility  String value for visibility.
     * @param  definition  CustomAttributeDefinition value for definition.
     * @param  updatedAt  String value for updatedAt.
     * @param  createdAt  String value for createdAt.
     */
    @JsonCreator
    public CustomAttribute(
            @JsonProperty("key") String key,
            @JsonProperty("value") JsonValue value,
            @JsonProperty("version") Integer version,
            @JsonProperty("visibility") String visibility,
            @JsonProperty("definition") CustomAttributeDefinition definition,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("created_at") String createdAt) {
        this.key = key;
        this.value = value;
        this.version = version;
        this.visibility = visibility;
        this.definition = definition;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    /**
     * Getter for Key.
     * The identifier of the custom attribute definition and its corresponding custom attributes.
     * This value can be a simple key, which is the key that is provided when the custom attribute
     * definition is created, or a qualified key, if the requesting application is not the
     * definition owner. The qualified key consists of the application ID of the custom attribute
     * definition owner followed by the simple key that was provided when the definition was
     * created. It has the format application_id:simple key. The value for a simple key can contain
     * up to 60 alphanumeric characters, periods (.), underscores (_), and hyphens (-).
     * @return Returns the String
     */
    @JsonGetter("key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getKey() {
        return key;
    }

    /**
     * Getter for Value.
     * The value assigned to the custom attribute. It is validated against the custom attribute
     * definition's schema on write operations. For more information about custom attribute values,
     * see [Custom Attributes
     * Overview](https://developer.squareup.com/docs/devtools/customattributes/overview).
     * @return Returns the JsonValue
     */
    @JsonGetter("value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public JsonValue getValue() {
        return value;
    }

    /**
     * Getter for Version.
     * Read only. The current version of the custom attribute. This field is incremented when the
     * custom attribute is changed. When updating an existing custom attribute value, you can
     * provide this field and specify the current version of the custom attribute to enable
     * [optimistic
     * concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency).
     * This field can also be used to enforce strong consistency for reads. For more information
     * about strong consistency for reads, see [Custom Attributes
     * Overview](https://developer.squareup.com/docs/devtools/customattributes/overview).
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for Visibility.
     * The level of permission that a seller or other applications requires to view this custom
     * attribute definition. The `Visibility` field controls who can read and write the custom
     * attribute values and custom attribute definition.
     * @return Returns the String
     */
    @JsonGetter("visibility")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getVisibility() {
        return visibility;
    }

    /**
     * Getter for Definition.
     * Represents a definition for custom attribute values. A custom attribute definition specifies
     * the key, visibility, schema, and other properties for a custom attribute.
     * @return Returns the CustomAttributeDefinition
     */
    @JsonGetter("definition")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomAttributeDefinition getDefinition() {
        return definition;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp that indicates when the custom attribute was created or was most recently
     * updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp that indicates when the custom attribute was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, version, visibility, definition, updatedAt, createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomAttribute)) {
            return false;
        }
        CustomAttribute other = (CustomAttribute) obj;
        return Objects.equals(key, other.key)
            && Objects.equals(value, other.value)
            && Objects.equals(version, other.version)
            && Objects.equals(visibility, other.visibility)
            && Objects.equals(definition, other.definition)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(createdAt, other.createdAt);
    }

    /**
     * Converts this CustomAttribute into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomAttribute [" + "key=" + key + ", value=" + value + ", version=" + version
                + ", visibility=" + visibility + ", definition=" + definition + ", updatedAt="
                + updatedAt + ", createdAt=" + createdAt + "]";
    }

    /**
     * Builds a new {@link CustomAttribute.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomAttribute.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .key(getKey())
                .value(getValue())
                .version(getVersion())
                .visibility(getVisibility())
                .definition(getDefinition())
                .updatedAt(getUpdatedAt())
                .createdAt(getCreatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link CustomAttribute}.
     */
    public static class Builder {
        private String key;
        private JsonValue value;
        private Integer version;
        private String visibility;
        private CustomAttributeDefinition definition;
        private String updatedAt;
        private String createdAt;



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
         * Setter for value.
         * @param  value  JsonValue value for value.
         * @return Builder
         */
        public Builder value(JsonValue value) {
            this.value = value;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for visibility.
         * @param  visibility  String value for visibility.
         * @return Builder
         */
        public Builder visibility(String visibility) {
            this.visibility = visibility;
            return this;
        }

        /**
         * Setter for definition.
         * @param  definition  CustomAttributeDefinition value for definition.
         * @return Builder
         */
        public Builder definition(CustomAttributeDefinition definition) {
            this.definition = definition;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Builds a new {@link CustomAttribute} object using the set fields.
         * @return {@link CustomAttribute}
         */
        public CustomAttribute build() {
            return new CustomAttribute(key, value, version, visibility, definition, updatedAt,
                    createdAt);
        }
    }
}
