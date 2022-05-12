
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogCustomAttributeDefinition type.
 */
public class CatalogCustomAttributeDefinition {
    private final String type;
    private final String name;
    private final String description;
    private final SourceApplication sourceApplication;
    private final List<String> allowedObjectTypes;
    private final String sellerVisibility;
    private final String appVisibility;
    private final CatalogCustomAttributeDefinitionStringConfig stringConfig;
    private final CatalogCustomAttributeDefinitionNumberConfig numberConfig;
    private final CatalogCustomAttributeDefinitionSelectionConfig selectionConfig;
    private final Integer customAttributeUsageCount;
    private final String key;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  name  String value for name.
     * @param  allowedObjectTypes  List of String value for allowedObjectTypes.
     * @param  description  String value for description.
     * @param  sourceApplication  SourceApplication value for sourceApplication.
     * @param  sellerVisibility  String value for sellerVisibility.
     * @param  appVisibility  String value for appVisibility.
     * @param  stringConfig  CatalogCustomAttributeDefinitionStringConfig value for stringConfig.
     * @param  numberConfig  CatalogCustomAttributeDefinitionNumberConfig value for numberConfig.
     * @param  selectionConfig  CatalogCustomAttributeDefinitionSelectionConfig value for
     *         selectionConfig.
     * @param  customAttributeUsageCount  Integer value for customAttributeUsageCount.
     * @param  key  String value for key.
     */
    @JsonCreator
    public CatalogCustomAttributeDefinition(
            @JsonProperty("type") String type,
            @JsonProperty("name") String name,
            @JsonProperty("allowed_object_types") List<String> allowedObjectTypes,
            @JsonProperty("description") String description,
            @JsonProperty("source_application") SourceApplication sourceApplication,
            @JsonProperty("seller_visibility") String sellerVisibility,
            @JsonProperty("app_visibility") String appVisibility,
            @JsonProperty("string_config") CatalogCustomAttributeDefinitionStringConfig stringConfig,
            @JsonProperty("number_config") CatalogCustomAttributeDefinitionNumberConfig numberConfig,
            @JsonProperty("selection_config") CatalogCustomAttributeDefinitionSelectionConfig selectionConfig,
            @JsonProperty("custom_attribute_usage_count") Integer customAttributeUsageCount,
            @JsonProperty("key") String key) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.sourceApplication = sourceApplication;
        this.allowedObjectTypes = allowedObjectTypes;
        this.sellerVisibility = sellerVisibility;
        this.appVisibility = appVisibility;
        this.stringConfig = stringConfig;
        this.numberConfig = numberConfig;
        this.selectionConfig = selectionConfig;
        this.customAttributeUsageCount = customAttributeUsageCount;
        this.key = key;
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
     * Getter for Name.
     * The name of this definition for API and seller-facing UI purposes. The name must be unique
     * within the (merchant, application) pair. Required. May not be empty and may not exceed 255
     * characters. Can be modified after creation.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for Description.
     * Seller-oriented description of the meaning of this Custom Attribute, any constraints that the
     * seller should observe, etc. May be displayed as a tooltip in Square UIs.
     * @return Returns the String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
    }

    /**
     * Getter for SourceApplication.
     * Represents information about the application used to generate a change.
     * @return Returns the SourceApplication
     */
    @JsonGetter("source_application")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SourceApplication getSourceApplication() {
        return sourceApplication;
    }

    /**
     * Getter for AllowedObjectTypes.
     * The set of Catalog Object Types that this Custom Attribute may be applied to. Currently, only
     * `ITEM` and `ITEM_VARIATION` are allowed. At least one type must be included. See
     * [CatalogObjectType](#type-catalogobjecttype) for possible values
     * @return Returns the List of String
     */
    @JsonGetter("allowed_object_types")
    public List<String> getAllowedObjectTypes() {
        return allowedObjectTypes;
    }

    /**
     * Getter for SellerVisibility.
     * Defines the visibility of a custom attribute to sellers in Square client applications, Square
     * APIs or in Square UIs (including Square Point of Sale applications and Square Dashboard).
     * @return Returns the String
     */
    @JsonGetter("seller_visibility")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSellerVisibility() {
        return sellerVisibility;
    }

    /**
     * Getter for AppVisibility.
     * Defines the visibility of a custom attribute to applications other than their creating
     * application.
     * @return Returns the String
     */
    @JsonGetter("app_visibility")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAppVisibility() {
        return appVisibility;
    }

    /**
     * Getter for StringConfig.
     * Configuration associated with Custom Attribute Definitions of type `STRING`.
     * @return Returns the CatalogCustomAttributeDefinitionStringConfig
     */
    @JsonGetter("string_config")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogCustomAttributeDefinitionStringConfig getStringConfig() {
        return stringConfig;
    }

    /**
     * Getter for NumberConfig.
     * @return Returns the CatalogCustomAttributeDefinitionNumberConfig
     */
    @JsonGetter("number_config")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogCustomAttributeDefinitionNumberConfig getNumberConfig() {
        return numberConfig;
    }

    /**
     * Getter for SelectionConfig.
     * Configuration associated with `SELECTION`-type custom attribute definitions.
     * @return Returns the CatalogCustomAttributeDefinitionSelectionConfig
     */
    @JsonGetter("selection_config")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogCustomAttributeDefinitionSelectionConfig getSelectionConfig() {
        return selectionConfig;
    }

    /**
     * Getter for CustomAttributeUsageCount.
     * The number of custom attributes that reference this custom attribute definition. Set by the
     * server in response to a ListCatalog request with `include_counts` set to `true`. If the
     * actual count is greater than 100, `custom_attribute_usage_count` will be set to `100`.
     * @return Returns the Integer
     */
    @JsonGetter("custom_attribute_usage_count")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getCustomAttributeUsageCount() {
        return customAttributeUsageCount;
    }

    /**
     * Getter for Key.
     * The name of the desired custom attribute key that can be used to access the custom attribute
     * value on catalog objects. Cannot be modified after the custom attribute definition has been
     * created. Must be between 1 and 60 characters, and may only contain the characters
     * `[a-zA-Z0-9_-]`.
     * @return Returns the String
     */
    @JsonGetter("key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, description, sourceApplication, allowedObjectTypes,
                sellerVisibility, appVisibility, stringConfig, numberConfig, selectionConfig,
                customAttributeUsageCount, key);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogCustomAttributeDefinition)) {
            return false;
        }
        CatalogCustomAttributeDefinition other = (CatalogCustomAttributeDefinition) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(name, other.name)
            && Objects.equals(description, other.description)
            && Objects.equals(sourceApplication, other.sourceApplication)
            && Objects.equals(allowedObjectTypes, other.allowedObjectTypes)
            && Objects.equals(sellerVisibility, other.sellerVisibility)
            && Objects.equals(appVisibility, other.appVisibility)
            && Objects.equals(stringConfig, other.stringConfig)
            && Objects.equals(numberConfig, other.numberConfig)
            && Objects.equals(selectionConfig, other.selectionConfig)
            && Objects.equals(customAttributeUsageCount, other.customAttributeUsageCount)
            && Objects.equals(key, other.key);
    }

    /**
     * Converts this CatalogCustomAttributeDefinition into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogCustomAttributeDefinition [" + "type=" + type + ", name=" + name
                + ", allowedObjectTypes=" + allowedObjectTypes + ", description=" + description
                + ", sourceApplication=" + sourceApplication + ", sellerVisibility="
                + sellerVisibility + ", appVisibility=" + appVisibility + ", stringConfig="
                + stringConfig + ", numberConfig=" + numberConfig + ", selectionConfig="
                + selectionConfig + ", customAttributeUsageCount=" + customAttributeUsageCount
                + ", key=" + key + "]";
    }

    /**
     * Builds a new {@link CatalogCustomAttributeDefinition.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogCustomAttributeDefinition.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type, name, allowedObjectTypes)
                .description(getDescription())
                .sourceApplication(getSourceApplication())
                .sellerVisibility(getSellerVisibility())
                .appVisibility(getAppVisibility())
                .stringConfig(getStringConfig())
                .numberConfig(getNumberConfig())
                .selectionConfig(getSelectionConfig())
                .customAttributeUsageCount(getCustomAttributeUsageCount())
                .key(getKey());
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogCustomAttributeDefinition}.
     */
    public static class Builder {
        private String type;
        private String name;
        private List<String> allowedObjectTypes;
        private String description;
        private SourceApplication sourceApplication;
        private String sellerVisibility;
        private String appVisibility;
        private CatalogCustomAttributeDefinitionStringConfig stringConfig;
        private CatalogCustomAttributeDefinitionNumberConfig numberConfig;
        private CatalogCustomAttributeDefinitionSelectionConfig selectionConfig;
        private Integer customAttributeUsageCount;
        private String key;

        /**
         * Initialization constructor.
         * @param  type  String value for type.
         * @param  name  String value for name.
         * @param  allowedObjectTypes  List of String value for allowedObjectTypes.
         */
        public Builder(String type, String name, List<String> allowedObjectTypes) {
            this.type = type;
            this.name = name;
            this.allowedObjectTypes = allowedObjectTypes;
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
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for allowedObjectTypes.
         * @param  allowedObjectTypes  List of String value for allowedObjectTypes.
         * @return Builder
         */
        public Builder allowedObjectTypes(List<String> allowedObjectTypes) {
            this.allowedObjectTypes = allowedObjectTypes;
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
         * Setter for sourceApplication.
         * @param  sourceApplication  SourceApplication value for sourceApplication.
         * @return Builder
         */
        public Builder sourceApplication(SourceApplication sourceApplication) {
            this.sourceApplication = sourceApplication;
            return this;
        }

        /**
         * Setter for sellerVisibility.
         * @param  sellerVisibility  String value for sellerVisibility.
         * @return Builder
         */
        public Builder sellerVisibility(String sellerVisibility) {
            this.sellerVisibility = sellerVisibility;
            return this;
        }

        /**
         * Setter for appVisibility.
         * @param  appVisibility  String value for appVisibility.
         * @return Builder
         */
        public Builder appVisibility(String appVisibility) {
            this.appVisibility = appVisibility;
            return this;
        }

        /**
         * Setter for stringConfig.
         * @param  stringConfig  CatalogCustomAttributeDefinitionStringConfig value for
         *         stringConfig.
         * @return Builder
         */
        public Builder stringConfig(CatalogCustomAttributeDefinitionStringConfig stringConfig) {
            this.stringConfig = stringConfig;
            return this;
        }

        /**
         * Setter for numberConfig.
         * @param  numberConfig  CatalogCustomAttributeDefinitionNumberConfig value for
         *         numberConfig.
         * @return Builder
         */
        public Builder numberConfig(CatalogCustomAttributeDefinitionNumberConfig numberConfig) {
            this.numberConfig = numberConfig;
            return this;
        }

        /**
         * Setter for selectionConfig.
         * @param  selectionConfig  CatalogCustomAttributeDefinitionSelectionConfig value for
         *         selectionConfig.
         * @return Builder
         */
        public Builder selectionConfig(
                CatalogCustomAttributeDefinitionSelectionConfig selectionConfig) {
            this.selectionConfig = selectionConfig;
            return this;
        }

        /**
         * Setter for customAttributeUsageCount.
         * @param  customAttributeUsageCount  Integer value for customAttributeUsageCount.
         * @return Builder
         */
        public Builder customAttributeUsageCount(Integer customAttributeUsageCount) {
            this.customAttributeUsageCount = customAttributeUsageCount;
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
         * Builds a new {@link CatalogCustomAttributeDefinition} object using the set fields.
         * @return {@link CatalogCustomAttributeDefinition}
         */
        public CatalogCustomAttributeDefinition build() {
            return new CatalogCustomAttributeDefinition(type, name, allowedObjectTypes, description,
                    sourceApplication, sellerVisibility, appVisibility, stringConfig, numberConfig,
                    selectionConfig, customAttributeUsageCount, key);
        }
    }
}
