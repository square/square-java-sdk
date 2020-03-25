package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogCustomAttributeDefinition type.
 */
public class CatalogCustomAttributeDefinition {

    /**
     * Initialization constructor.
     * @param type
     * @param name
     * @param description
     * @param sourceApplication
     * @param allowedObjectTypes
     * @param sellerVisibility
     * @param appVisibility
     * @param stringConfig
     * @param selectionConfig
     * @param customAttributeUsageCount
     * @param key
     */
    @JsonCreator
    public CatalogCustomAttributeDefinition(
            @JsonProperty("type") String type,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("source_application") SourceApplication sourceApplication,
            @JsonProperty("allowed_object_types") List<String> allowedObjectTypes,
            @JsonProperty("seller_visibility") String sellerVisibility,
            @JsonProperty("app_visibility") String appVisibility,
            @JsonProperty("string_config") CatalogCustomAttributeDefinitionStringConfig stringConfig,
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
        this.selectionConfig = selectionConfig;
        this.customAttributeUsageCount = customAttributeUsageCount;
        this.key = key;
    }

    private final String type;
    private final String name;
    private final String description;
    private final SourceApplication sourceApplication;
    private final List<String> allowedObjectTypes;
    private final String sellerVisibility;
    private final String appVisibility;
    private final CatalogCustomAttributeDefinitionStringConfig stringConfig;
    private final CatalogCustomAttributeDefinitionSelectionConfig selectionConfig;
    private final Integer customAttributeUsageCount;
    private final String key;
    /**
     * Getter for Type.
     * Defines the possible types for a custom attribute.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Name.
     * The name of this definition for API and seller-facing UI purposes.
     * The name must be unique within the (merchant, application_id) pair. Required.
     * May not be empty and may not exceed 255 characters. Can be modified after creation.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Description.
     * Seller-oriented description of the meaning of this Custom Attribute,
     * any constraints that the seller should observe, etc. May be displayed as a tooltip in Square UIs.
     */
    @JsonGetter("description")
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for SourceApplication.
     * Provides information about the application used to generate an inventory
     * change.
     */
    @JsonGetter("source_application")
    public SourceApplication getSourceApplication() {
        return this.sourceApplication;
    }

    /**
     * Getter for AllowedObjectTypes.
     * The set of Catalog Object Types that this Custom Attribute may be applied to.
     * Currently, only `ITEM` and `ITEM_VARIATION` are allowed.
     * See [CatalogObjectType](#type-catalogobjecttype) for possible values
     */
    @JsonGetter("allowed_object_types")
    public List<String> getAllowedObjectTypes() {
        return this.allowedObjectTypes;
    }

    /**
     * Getter for SellerVisibility.
     * Defines the visibility of a custom attribute to sellers in Square
     * client applications, Square APIs or in Square UIs (including Square Point
     * of Sale applications and Square Dashboard).
     */
    @JsonGetter("seller_visibility")
    public String getSellerVisibility() {
        return this.sellerVisibility;
    }

    /**
     * Getter for AppVisibility.
     * Defines the visibility of a custom attribute to applications other than their
     * creating application.
     */
    @JsonGetter("app_visibility")
    public String getAppVisibility() {
        return this.appVisibility;
    }

    /**
     * Getter for StringConfig.
     * Configuration associated with Custom Attribute Definitions of type `STRING`.
     */
    @JsonGetter("string_config")
    public CatalogCustomAttributeDefinitionStringConfig getStringConfig() {
        return this.stringConfig;
    }

    /**
     * Getter for SelectionConfig.
     * Configuration associated with `SELECTION`-type custom attribute definitions.
     */
    @JsonGetter("selection_config")
    public CatalogCustomAttributeDefinitionSelectionConfig getSelectionConfig() {
        return this.selectionConfig;
    }

    /**
     * Getter for CustomAttributeUsageCount.
     * __Read-only.__ The number of custom attributes that reference this
     * custom attribute definition. Set by the server in response to a ListCatalog
     * request with `include_counts` set to `true`.  If the actual count is greater
     * than 100, `custom_attribute_usage_count` will be set to `100`.
     */
    @JsonGetter("custom_attribute_usage_count")
    public Integer getCustomAttributeUsageCount() {
        return this.customAttributeUsageCount;
    }

    /**
     * Getter for Key.
     * The name of the desired custom attribute key that can be used to access
     * the custom attribute value on catalog objects. Cannot be modified after the
     * custom attribute definition has been created.
     */
    @JsonGetter("key")
    public String getKey() {
        return this.key;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(type, name, description, sourceApplication, allowedObjectTypes,
            sellerVisibility, appVisibility, stringConfig, selectionConfig,
            customAttributeUsageCount, key);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogCustomAttributeDefinition)) {
            return false;
        }
        CatalogCustomAttributeDefinition catalogCustomAttributeDefinition = (CatalogCustomAttributeDefinition) obj;
        return Objects.equals(type, catalogCustomAttributeDefinition.type) &&
            Objects.equals(name, catalogCustomAttributeDefinition.name) &&
            Objects.equals(description, catalogCustomAttributeDefinition.description) &&
            Objects.equals(sourceApplication, catalogCustomAttributeDefinition.sourceApplication) &&
            Objects.equals(allowedObjectTypes, catalogCustomAttributeDefinition.allowedObjectTypes) &&
            Objects.equals(sellerVisibility, catalogCustomAttributeDefinition.sellerVisibility) &&
            Objects.equals(appVisibility, catalogCustomAttributeDefinition.appVisibility) &&
            Objects.equals(stringConfig, catalogCustomAttributeDefinition.stringConfig) &&
            Objects.equals(selectionConfig, catalogCustomAttributeDefinition.selectionConfig) &&
            Objects.equals(customAttributeUsageCount, catalogCustomAttributeDefinition.customAttributeUsageCount) &&
            Objects.equals(key, catalogCustomAttributeDefinition.key);
    }

    /**
     * Builds a new {@link CatalogCustomAttributeDefinition.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogCustomAttributeDefinition.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type,
            name)
            .description(getDescription())
            .sourceApplication(getSourceApplication())
            .allowedObjectTypes(getAllowedObjectTypes())
            .sellerVisibility(getSellerVisibility())
            .appVisibility(getAppVisibility())
            .stringConfig(getStringConfig())
            .selectionConfig(getSelectionConfig())
            .customAttributeUsageCount(getCustomAttributeUsageCount())
            .key(getKey());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogCustomAttributeDefinition}
     */
    public static class Builder {
        private String type;
        private String name;
        private String description;
        private SourceApplication sourceApplication;
        private List<String> allowedObjectTypes;
        private String sellerVisibility;
        private String appVisibility;
        private CatalogCustomAttributeDefinitionStringConfig stringConfig;
        private CatalogCustomAttributeDefinitionSelectionConfig selectionConfig;
        private Integer customAttributeUsageCount;
        private String key;

        /**
         * Initialization constructor
         */
        public Builder(String type,
                String name) {
            this.type = type;
            this.name = name;
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
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for description
         * @param description
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        /**
         * Setter for sourceApplication
         * @param sourceApplication
         * @return Builder
         */
        public Builder sourceApplication(SourceApplication sourceApplication) {
            this.sourceApplication = sourceApplication;
            return this;
        }
        /**
         * Setter for allowedObjectTypes
         * @param allowedObjectTypes
         * @return Builder
         */
        public Builder allowedObjectTypes(List<String> allowedObjectTypes) {
            this.allowedObjectTypes = allowedObjectTypes;
            return this;
        }
        /**
         * Setter for sellerVisibility
         * @param sellerVisibility
         * @return Builder
         */
        public Builder sellerVisibility(String sellerVisibility) {
            this.sellerVisibility = sellerVisibility;
            return this;
        }
        /**
         * Setter for appVisibility
         * @param appVisibility
         * @return Builder
         */
        public Builder appVisibility(String appVisibility) {
            this.appVisibility = appVisibility;
            return this;
        }
        /**
         * Setter for stringConfig
         * @param stringConfig
         * @return Builder
         */
        public Builder stringConfig(CatalogCustomAttributeDefinitionStringConfig stringConfig) {
            this.stringConfig = stringConfig;
            return this;
        }
        /**
         * Setter for selectionConfig
         * @param selectionConfig
         * @return Builder
         */
        public Builder selectionConfig(CatalogCustomAttributeDefinitionSelectionConfig selectionConfig) {
            this.selectionConfig = selectionConfig;
            return this;
        }
        /**
         * Setter for customAttributeUsageCount
         * @param customAttributeUsageCount
         * @return Builder
         */
        public Builder customAttributeUsageCount(Integer customAttributeUsageCount) {
            this.customAttributeUsageCount = customAttributeUsageCount;
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
         * Builds a new {@link CatalogCustomAttributeDefinition} object using the set fields.
         * @return {@link CatalogCustomAttributeDefinition}
         */
        public CatalogCustomAttributeDefinition build() {
            return new CatalogCustomAttributeDefinition(type,
                name,
                description,
                sourceApplication,
                allowedObjectTypes,
                sellerVisibility,
                appVisibility,
                stringConfig,
                selectionConfig,
                customAttributeUsageCount,
                key);
        }
    }
}
