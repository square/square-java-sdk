
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.utilities.JsonObject;
import java.util.Objects;

/**
 * This is a model class for CustomAttributeDefinition type.
 */
public class CustomAttributeDefinition {
    private final String key;
    private final JsonObject schema;
    private final String name;
    private final String description;
    private final String visibility;
    private final Integer version;
    private final String updatedAt;
    private final String createdAt;

    /**
     * Initialization constructor.
     * @param  key  String value for key.
     * @param  schema  JsonObject value for schema.
     * @param  name  String value for name.
     * @param  description  String value for description.
     * @param  visibility  String value for visibility.
     * @param  version  Integer value for version.
     * @param  updatedAt  String value for updatedAt.
     * @param  createdAt  String value for createdAt.
     */
    @JsonCreator
    public CustomAttributeDefinition(
            @JsonProperty("key") String key,
            @JsonProperty("schema") JsonObject schema,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("visibility") String visibility,
            @JsonProperty("version") Integer version,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("created_at") String createdAt) {
        this.key = key;
        this.schema = schema;
        this.name = name;
        this.description = description;
        this.visibility = visibility;
        this.version = version;
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
     * up to 60 alphanumeric characters, periods (.), underscores (_), and hyphens (-). This field
     * can not be changed after the custom attribute definition is created. This field is required
     * when creating a definition and must be unique per application, seller, and resource type.
     * @return Returns the String
     */
    @JsonGetter("key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getKey() {
        return key;
    }

    /**
     * Getter for Schema.
     * The JSON schema for the custom attribute definition, which determines the data type of the
     * corresponding custom attributes. For more information, see [Custom Attributes
     * Overview](https://developer.squareup.com/docs/devtools/customattributes/overview). This field
     * is required when creating a definition.
     * @return Returns the JsonObject
     */
    @JsonGetter("schema")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public JsonObject getSchema() {
        return schema;
    }

    /**
     * Getter for Name.
     * The name of the custom attribute definition for API and seller-facing UI purposes. The name
     * must be unique within the seller and application pair. This field is required if the
     * `visibility` field is `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.
     * @return Returns the String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    /**
     * Getter for Description.
     * Seller-oriented description of the custom attribute definition, including any constraints
     * that the seller should observe. May be displayed as a tooltip in Square UIs. This field is
     * required if the `visibility` field is `VISIBILITY_READ_ONLY` or
     * `VISIBILITY_READ_WRITE_VALUES`.
     * @return Returns the String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
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
     * Getter for Version.
     * Read only. The current version of the custom attribute definition. The value is incremented
     * each time the custom attribute definition is updated. When updating a custom attribute
     * definition, you can provide this field and specify the current version of the custom
     * attribute definition to enable [optimistic
     * concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency).
     * On writes, this field must be set to the latest version. Stale writes are rejected. This
     * field can also be used to enforce strong consistency for reads. For more information about
     * strong consistency for reads, see [Custom Attributes
     * Overview](https://developer.squareup.com/docs/devtools/customattributes/overview).
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp that indicates when the custom attribute definition was created or most
     * recently updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp that indicates when the custom attribute definition was created, in RFC 3339
     * format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, schema, name, description, visibility, version, updatedAt,
                createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomAttributeDefinition)) {
            return false;
        }
        CustomAttributeDefinition other = (CustomAttributeDefinition) obj;
        return Objects.equals(key, other.key)
            && Objects.equals(schema, other.schema)
            && Objects.equals(name, other.name)
            && Objects.equals(description, other.description)
            && Objects.equals(visibility, other.visibility)
            && Objects.equals(version, other.version)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(createdAt, other.createdAt);
    }

    /**
     * Converts this CustomAttributeDefinition into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomAttributeDefinition [" + "key=" + key + ", schema=" + schema + ", name="
                + name + ", description=" + description + ", visibility=" + visibility
                + ", version=" + version + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt
                + "]";
    }

    /**
     * Builds a new {@link CustomAttributeDefinition.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomAttributeDefinition.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .key(getKey())
                .schema(getSchema())
                .name(getName())
                .description(getDescription())
                .visibility(getVisibility())
                .version(getVersion())
                .updatedAt(getUpdatedAt())
                .createdAt(getCreatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link CustomAttributeDefinition}.
     */
    public static class Builder {
        private String key;
        private JsonObject schema;
        private String name;
        private String description;
        private String visibility;
        private Integer version;
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
         * Setter for schema.
         * @param  schema  JsonObject value for schema.
         * @return Builder
         */
        public Builder schema(JsonObject schema) {
            this.schema = schema;
            return this;
        }

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
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
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
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * Builds a new {@link CustomAttributeDefinition} object using the set fields.
         * @return {@link CustomAttributeDefinition}
         */
        public CustomAttributeDefinition build() {
            return new CustomAttributeDefinition(key, schema, name, description, visibility,
                    version, updatedAt, createdAt);
        }
    }
}
