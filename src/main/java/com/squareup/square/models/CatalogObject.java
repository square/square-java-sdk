package com.squareup.square.models;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogObject type.
 */
public class CatalogObject {

    /**
     * Initialization constructor.
     * @param type
     * @param id
     * @param updatedAt
     * @param version
     * @param isDeleted
     * @param customAttributeValues
     * @param catalogV1Ids
     * @param presentAtAllLocations
     * @param presentAtLocationIds
     * @param absentAtLocationIds
     * @param imageId
     * @param itemData
     * @param categoryData
     * @param itemVariationData
     * @param taxData
     * @param discountData
     * @param modifierListData
     * @param modifierData
     * @param timePeriodData
     * @param productSetData
     * @param pricingRuleData
     * @param imageData
     * @param measurementUnitData
     * @param itemOptionData
     * @param itemOptionValueData
     * @param customAttributeDefinitionData
     * @param quickAmountsSettingsData
     */
    @JsonCreator
    public CatalogObject(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("version") Long version,
            @JsonProperty("is_deleted") Boolean isDeleted,
            @JsonProperty("custom_attribute_values") Map<String, CatalogCustomAttributeValue> customAttributeValues,
            @JsonProperty("catalog_v1_ids") List<CatalogV1Id> catalogV1Ids,
            @JsonProperty("present_at_all_locations") Boolean presentAtAllLocations,
            @JsonProperty("present_at_location_ids") List<String> presentAtLocationIds,
            @JsonProperty("absent_at_location_ids") List<String> absentAtLocationIds,
            @JsonProperty("image_id") String imageId,
            @JsonProperty("item_data") CatalogItem itemData,
            @JsonProperty("category_data") CatalogCategory categoryData,
            @JsonProperty("item_variation_data") CatalogItemVariation itemVariationData,
            @JsonProperty("tax_data") CatalogTax taxData,
            @JsonProperty("discount_data") CatalogDiscount discountData,
            @JsonProperty("modifier_list_data") CatalogModifierList modifierListData,
            @JsonProperty("modifier_data") CatalogModifier modifierData,
            @JsonProperty("time_period_data") CatalogTimePeriod timePeriodData,
            @JsonProperty("product_set_data") CatalogProductSet productSetData,
            @JsonProperty("pricing_rule_data") CatalogPricingRule pricingRuleData,
            @JsonProperty("image_data") CatalogImage imageData,
            @JsonProperty("measurement_unit_data") CatalogMeasurementUnit measurementUnitData,
            @JsonProperty("item_option_data") CatalogItemOption itemOptionData,
            @JsonProperty("item_option_value_data") CatalogItemOptionValue itemOptionValueData,
            @JsonProperty("custom_attribute_definition_data") CatalogCustomAttributeDefinition customAttributeDefinitionData,
            @JsonProperty("quick_amounts_settings_data") CatalogQuickAmountsSettings quickAmountsSettingsData) {
        this.type = type;
        this.id = id;
        this.updatedAt = updatedAt;
        this.version = version;
        this.isDeleted = isDeleted;
        this.customAttributeValues = customAttributeValues;
        this.catalogV1Ids = catalogV1Ids;
        this.presentAtAllLocations = presentAtAllLocations;
        this.presentAtLocationIds = presentAtLocationIds;
        this.absentAtLocationIds = absentAtLocationIds;
        this.imageId = imageId;
        this.itemData = itemData;
        this.categoryData = categoryData;
        this.itemVariationData = itemVariationData;
        this.taxData = taxData;
        this.discountData = discountData;
        this.modifierListData = modifierListData;
        this.modifierData = modifierData;
        this.timePeriodData = timePeriodData;
        this.productSetData = productSetData;
        this.pricingRuleData = pricingRuleData;
        this.imageData = imageData;
        this.measurementUnitData = measurementUnitData;
        this.itemOptionData = itemOptionData;
        this.itemOptionValueData = itemOptionValueData;
        this.customAttributeDefinitionData = customAttributeDefinitionData;
        this.quickAmountsSettingsData = quickAmountsSettingsData;
    }

    private final String type;
    private final String id;
    private final String updatedAt;
    private final Long version;
    private final Boolean isDeleted;
    private final Map<String, CatalogCustomAttributeValue> customAttributeValues;
    private final List<CatalogV1Id> catalogV1Ids;
    private final Boolean presentAtAllLocations;
    private final List<String> presentAtLocationIds;
    private final List<String> absentAtLocationIds;
    private final String imageId;
    private final CatalogItem itemData;
    private final CatalogCategory categoryData;
    private final CatalogItemVariation itemVariationData;
    private final CatalogTax taxData;
    private final CatalogDiscount discountData;
    private final CatalogModifierList modifierListData;
    private final CatalogModifier modifierData;
    private final CatalogTimePeriod timePeriodData;
    private final CatalogProductSet productSetData;
    private final CatalogPricingRule pricingRuleData;
    private final CatalogImage imageData;
    private final CatalogMeasurementUnit measurementUnitData;
    private final CatalogItemOption itemOptionData;
    private final CatalogItemOptionValue itemOptionValueData;
    private final CatalogCustomAttributeDefinition customAttributeDefinitionData;
    private final CatalogQuickAmountsSettings quickAmountsSettingsData;
    /**
     * Getter for Type.
     * Possible types of CatalogObjects returned from the Catalog, each
     * containing type-specific properties in the `*_data` field corresponding to the object type.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Id.
     * An identifier to reference this object in the catalog. When a new `CatalogObject`
     * is inserted, the client should set the id to a temporary identifier starting with
     * a "`#`" character. Other objects being inserted or updated within the same request
     * may use this identifier to refer to the new object.
     * When the server receives the new object, it will supply a unique identifier that
     * replaces the temporary identifier for all future references.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for UpdatedAt.
     * Last modification [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) in RFC 3339 format, e.g., `"2016-08-15T23:59:33.123Z"`
     * would indicate the UTC time (denoted by `Z`) of August 15, 2016 at 23:59:33 and 123 milliseconds.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for Version.
     * The version of the object. When updating an object, the version supplied
     * must match the version in the database, otherwise the write will be rejected as conflicting.
     */
    @JsonGetter("version")
    public Long getVersion() {
        return this.version;
    }

    /**
     * Getter for IsDeleted.
     * If `true`, the object has been deleted from the database. Must be `false` for new objects
     * being inserted. When deleted, the `updated_at` field will equal the deletion time.
     */
    @JsonGetter("is_deleted")
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    /**
     * Getter for CustomAttributeValues.
     * A map (key-value pairs) of application-defined custom attribute values. The value of a key-value pair 
     * is a [CatalogCustomAttributeValue](#type-CatalogCustomAttributeValue) object. The key is the `key` attribute 
     * value defined in the associated [CatalogCustomAttributeDefinition](#type-CatalogCustomAttributeDefinition) 
     * object defined by the application making the request. 
     * If the `CatalogCustomAttributeDefinition` object is 
     * defined by another application, the `CatalogCustomAttributeDefinition`'s key attribute value is prefixed by 
     * the defining application ID. For example, if the `CatalogCustomAttributeDefinition` has a `key` attribute of 
     * "cocoa_brand" and the defining application ID is "abcd1234", the key in the map is "abcd1234:cocoa_brand" if the
     * application making the request is different from the application defining the custom attribute definition. 
     * Otherwise, the key used in the map is simply "cocoa-brand".
     * Application-defined custom attributes that are set at a global (location-independent) level.
     * Custom attribute values are intended to store additional information about a catalog object
     * or associations with an entity in another system. Do not use custom attributes
     * to store any sensitive information (personally identifiable information, card details, etc.).
     */
    @JsonGetter("custom_attribute_values")
    public Map<String, CatalogCustomAttributeValue> getCustomAttributeValues() {
        return this.customAttributeValues;
    }

    /**
     * Getter for CatalogV1Ids.
     * The Connect v1 IDs for this object at each location where it is present, where they
     * differ from the object's Connect V2 ID. The field will only be present for objects that
     * have been created or modified by legacy APIs.
     */
    @JsonGetter("catalog_v1_ids")
    public List<CatalogV1Id> getCatalogV1Ids() {
        return this.catalogV1Ids;
    }

    /**
     * Getter for PresentAtAllLocations.
     * If `true`, this object is present at all locations (including future locations), except where specified in
     * the `absent_at_location_ids` field. If `false`, this object is not present at any locations (including future locations),
     * except where specified in the `present_at_location_ids` field. If not specified, defaults to `true`.
     */
    @JsonGetter("present_at_all_locations")
    public Boolean getPresentAtAllLocations() {
        return this.presentAtAllLocations;
    }

    /**
     * Getter for PresentAtLocationIds.
     * A list of locations where the object is present, even if `present_at_all_locations` is `false`.
     */
    @JsonGetter("present_at_location_ids")
    public List<String> getPresentAtLocationIds() {
        return this.presentAtLocationIds;
    }

    /**
     * Getter for AbsentAtLocationIds.
     * A list of locations where the object is not present, even if `present_at_all_locations` is `true`.
     */
    @JsonGetter("absent_at_location_ids")
    public List<String> getAbsentAtLocationIds() {
        return this.absentAtLocationIds;
    }

    /**
     * Getter for ImageId.
     * Identifies the `CatalogImage` attached to this `CatalogObject`.
     */
    @JsonGetter("image_id")
    public String getImageId() {
        return this.imageId;
    }

    /**
     * Getter for ItemData.
     * An [CatalogObject](#type-CatalogObject) instance of the `ITEM` type, also referred to as an item, in the catalog.
     */
    @JsonGetter("item_data")
    public CatalogItem getItemData() {
        return this.itemData;
    }

    /**
     * Getter for CategoryData.
     * A category to which a `CatalogItem` instance belongs.
     */
    @JsonGetter("category_data")
    public CatalogCategory getCategoryData() {
        return this.categoryData;
    }

    /**
     * Getter for ItemVariationData.
     * An item variation (i.e., product) in the Catalog object model. Each item
     * may have a maximum of 250 item variations.
     */
    @JsonGetter("item_variation_data")
    public CatalogItemVariation getItemVariationData() {
        return this.itemVariationData;
    }

    /**
     * Getter for TaxData.
     * A tax applicable to an item.
     */
    @JsonGetter("tax_data")
    public CatalogTax getTaxData() {
        return this.taxData;
    }

    /**
     * Getter for DiscountData.
     * A discount applicable to items.
     */
    @JsonGetter("discount_data")
    public CatalogDiscount getDiscountData() {
        return this.discountData;
    }

    /**
     * Getter for ModifierListData.
     * A list of modifiers applicable to items at the time of sale.
     * For example, a "Condiments" modifier list applicable to a "Hot Dog" item
     * may contain "Ketchup", "Mustard", and "Relish" modifiers.
     * Use the `selection_type` field to specify whether or not multiple selections from
     * the modifier list are allowed.
     */
    @JsonGetter("modifier_list_data")
    public CatalogModifierList getModifierListData() {
        return this.modifierListData;
    }

    /**
     * Getter for ModifierData.
     * A modifier applicable to items at the time of sale.
     */
    @JsonGetter("modifier_data")
    public CatalogModifier getModifierData() {
        return this.modifierData;
    }

    /**
     * Getter for TimePeriodData.
     * Represents a time period - either a single period or a repeating period.
     */
    @JsonGetter("time_period_data")
    public CatalogTimePeriod getTimePeriodData() {
        return this.timePeriodData;
    }

    /**
     * Getter for ProductSetData.
     * Represents a collection of catalog objects for the purpose of applying a
     * `PricingRule`. Including a catalog object will include all of its subtypes.
     * For example, including a category in a product set will include all of its
     * items and associated item variations in the product set. Including an item in
     * a product set will also include its item variations.
     */
    @JsonGetter("product_set_data")
    public CatalogProductSet getProductSetData() {
        return this.productSetData;
    }

    /**
     * Getter for PricingRuleData.
     * Defines how discounts are automatically applied to a set of items that match the pricing rule 
     * during the active time period.
     */
    @JsonGetter("pricing_rule_data")
    public CatalogPricingRule getPricingRuleData() {
        return this.pricingRuleData;
    }

    /**
     * Getter for ImageData.
     * An image file to use in Square catalogs. It can be associated with catalog
     * items, item variations, and categories.
     */
    @JsonGetter("image_data")
    public CatalogImage getImageData() {
        return this.imageData;
    }

    /**
     * Getter for MeasurementUnitData.
     * Represents the unit used to measure a `CatalogItemVariation` and
     * specifies the precision for decimal quantities.
     */
    @JsonGetter("measurement_unit_data")
    public CatalogMeasurementUnit getMeasurementUnitData() {
        return this.measurementUnitData;
    }

    /**
     * Getter for ItemOptionData.
     * A group of variations for a `CatalogItem`.
     */
    @JsonGetter("item_option_data")
    public CatalogItemOption getItemOptionData() {
        return this.itemOptionData;
    }

    /**
     * Getter for ItemOptionValueData.
     * An enumerated value that can link a
     * `CatalogItemVariation` to an item option as one of
     * its item option values.
     */
    @JsonGetter("item_option_value_data")
    public CatalogItemOptionValue getItemOptionValueData() {
        return this.itemOptionValueData;
    }

    /**
     * Getter for CustomAttributeDefinitionData.
     * Contains information defining a custom attribute. Custom attributes are
     * intended to store additional information about a catalog object or to associate a
     * catalog object with an entity in another system. Do not use custom attributes
     * to store any sensitive information (personally identifiable information, card details, etc.).
     * [Read more about custom attributes](https://developer.squareup.com/docs/catalog-api/add-custom-attributes)
     */
    @JsonGetter("custom_attribute_definition_data")
    public CatalogCustomAttributeDefinition getCustomAttributeDefinitionData() {
        return this.customAttributeDefinitionData;
    }

    /**
     * Getter for QuickAmountsSettingsData.
     * A parent Catalog Object model represents a set of Quick Amounts and the settings control the amounts.
     */
    @JsonGetter("quick_amounts_settings_data")
    public CatalogQuickAmountsSettings getQuickAmountsSettingsData() {
        return this.quickAmountsSettingsData;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(type, id, updatedAt, version, isDeleted, customAttributeValues,
            catalogV1Ids, presentAtAllLocations, presentAtLocationIds, absentAtLocationIds, imageId,
            itemData, categoryData, itemVariationData, taxData, discountData, modifierListData,
            modifierData, timePeriodData, productSetData, pricingRuleData, imageData,
            measurementUnitData, itemOptionData, itemOptionValueData, customAttributeDefinitionData,
            quickAmountsSettingsData);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogObject)) {
            return false;
        }
        CatalogObject catalogObject = (CatalogObject) obj;
        return Objects.equals(type, catalogObject.type) &&
            Objects.equals(id, catalogObject.id) &&
            Objects.equals(updatedAt, catalogObject.updatedAt) &&
            Objects.equals(version, catalogObject.version) &&
            Objects.equals(isDeleted, catalogObject.isDeleted) &&
            Objects.equals(customAttributeValues, catalogObject.customAttributeValues) &&
            Objects.equals(catalogV1Ids, catalogObject.catalogV1Ids) &&
            Objects.equals(presentAtAllLocations, catalogObject.presentAtAllLocations) &&
            Objects.equals(presentAtLocationIds, catalogObject.presentAtLocationIds) &&
            Objects.equals(absentAtLocationIds, catalogObject.absentAtLocationIds) &&
            Objects.equals(imageId, catalogObject.imageId) &&
            Objects.equals(itemData, catalogObject.itemData) &&
            Objects.equals(categoryData, catalogObject.categoryData) &&
            Objects.equals(itemVariationData, catalogObject.itemVariationData) &&
            Objects.equals(taxData, catalogObject.taxData) &&
            Objects.equals(discountData, catalogObject.discountData) &&
            Objects.equals(modifierListData, catalogObject.modifierListData) &&
            Objects.equals(modifierData, catalogObject.modifierData) &&
            Objects.equals(timePeriodData, catalogObject.timePeriodData) &&
            Objects.equals(productSetData, catalogObject.productSetData) &&
            Objects.equals(pricingRuleData, catalogObject.pricingRuleData) &&
            Objects.equals(imageData, catalogObject.imageData) &&
            Objects.equals(measurementUnitData, catalogObject.measurementUnitData) &&
            Objects.equals(itemOptionData, catalogObject.itemOptionData) &&
            Objects.equals(itemOptionValueData, catalogObject.itemOptionValueData) &&
            Objects.equals(customAttributeDefinitionData, catalogObject.customAttributeDefinitionData) &&
            Objects.equals(quickAmountsSettingsData, catalogObject.quickAmountsSettingsData);
    }

    /**
     * Builds a new {@link CatalogObject.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogObject.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type,
            id)
            .updatedAt(getUpdatedAt())
            .version(getVersion())
            .isDeleted(getIsDeleted())
            .customAttributeValues(getCustomAttributeValues())
            .catalogV1Ids(getCatalogV1Ids())
            .presentAtAllLocations(getPresentAtAllLocations())
            .presentAtLocationIds(getPresentAtLocationIds())
            .absentAtLocationIds(getAbsentAtLocationIds())
            .imageId(getImageId())
            .itemData(getItemData())
            .categoryData(getCategoryData())
            .itemVariationData(getItemVariationData())
            .taxData(getTaxData())
            .discountData(getDiscountData())
            .modifierListData(getModifierListData())
            .modifierData(getModifierData())
            .timePeriodData(getTimePeriodData())
            .productSetData(getProductSetData())
            .pricingRuleData(getPricingRuleData())
            .imageData(getImageData())
            .measurementUnitData(getMeasurementUnitData())
            .itemOptionData(getItemOptionData())
            .itemOptionValueData(getItemOptionValueData())
            .customAttributeDefinitionData(getCustomAttributeDefinitionData())
            .quickAmountsSettingsData(getQuickAmountsSettingsData());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogObject}
     */
    public static class Builder {
        private String type;
        private String id;
        private String updatedAt;
        private Long version;
        private Boolean isDeleted;
        private Map<String, CatalogCustomAttributeValue> customAttributeValues;
        private List<CatalogV1Id> catalogV1Ids;
        private Boolean presentAtAllLocations;
        private List<String> presentAtLocationIds;
        private List<String> absentAtLocationIds;
        private String imageId;
        private CatalogItem itemData;
        private CatalogCategory categoryData;
        private CatalogItemVariation itemVariationData;
        private CatalogTax taxData;
        private CatalogDiscount discountData;
        private CatalogModifierList modifierListData;
        private CatalogModifier modifierData;
        private CatalogTimePeriod timePeriodData;
        private CatalogProductSet productSetData;
        private CatalogPricingRule pricingRuleData;
        private CatalogImage imageData;
        private CatalogMeasurementUnit measurementUnitData;
        private CatalogItemOption itemOptionData;
        private CatalogItemOptionValue itemOptionValueData;
        private CatalogCustomAttributeDefinition customAttributeDefinitionData;
        private CatalogQuickAmountsSettings quickAmountsSettingsData;

        /**
         * Initialization constructor
         */
        public Builder(String type,
                String id) {
            this.type = type;
            this.id = id;
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
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        /**
         * Setter for version
         * @param version
         * @return Builder
         */
        public Builder version(Long version) {
            this.version = version;
            return this;
        }
        /**
         * Setter for isDeleted
         * @param isDeleted
         * @return Builder
         */
        public Builder isDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }
        /**
         * Setter for customAttributeValues
         * @param customAttributeValues
         * @return Builder
         */
        public Builder customAttributeValues(Map<String, CatalogCustomAttributeValue> customAttributeValues) {
            this.customAttributeValues = customAttributeValues;
            return this;
        }
        /**
         * Setter for catalogV1Ids
         * @param catalogV1Ids
         * @return Builder
         */
        public Builder catalogV1Ids(List<CatalogV1Id> catalogV1Ids) {
            this.catalogV1Ids = catalogV1Ids;
            return this;
        }
        /**
         * Setter for presentAtAllLocations
         * @param presentAtAllLocations
         * @return Builder
         */
        public Builder presentAtAllLocations(Boolean presentAtAllLocations) {
            this.presentAtAllLocations = presentAtAllLocations;
            return this;
        }
        /**
         * Setter for presentAtLocationIds
         * @param presentAtLocationIds
         * @return Builder
         */
        public Builder presentAtLocationIds(List<String> presentAtLocationIds) {
            this.presentAtLocationIds = presentAtLocationIds;
            return this;
        }
        /**
         * Setter for absentAtLocationIds
         * @param absentAtLocationIds
         * @return Builder
         */
        public Builder absentAtLocationIds(List<String> absentAtLocationIds) {
            this.absentAtLocationIds = absentAtLocationIds;
            return this;
        }
        /**
         * Setter for imageId
         * @param imageId
         * @return Builder
         */
        public Builder imageId(String imageId) {
            this.imageId = imageId;
            return this;
        }
        /**
         * Setter for itemData
         * @param itemData
         * @return Builder
         */
        public Builder itemData(CatalogItem itemData) {
            this.itemData = itemData;
            return this;
        }
        /**
         * Setter for categoryData
         * @param categoryData
         * @return Builder
         */
        public Builder categoryData(CatalogCategory categoryData) {
            this.categoryData = categoryData;
            return this;
        }
        /**
         * Setter for itemVariationData
         * @param itemVariationData
         * @return Builder
         */
        public Builder itemVariationData(CatalogItemVariation itemVariationData) {
            this.itemVariationData = itemVariationData;
            return this;
        }
        /**
         * Setter for taxData
         * @param taxData
         * @return Builder
         */
        public Builder taxData(CatalogTax taxData) {
            this.taxData = taxData;
            return this;
        }
        /**
         * Setter for discountData
         * @param discountData
         * @return Builder
         */
        public Builder discountData(CatalogDiscount discountData) {
            this.discountData = discountData;
            return this;
        }
        /**
         * Setter for modifierListData
         * @param modifierListData
         * @return Builder
         */
        public Builder modifierListData(CatalogModifierList modifierListData) {
            this.modifierListData = modifierListData;
            return this;
        }
        /**
         * Setter for modifierData
         * @param modifierData
         * @return Builder
         */
        public Builder modifierData(CatalogModifier modifierData) {
            this.modifierData = modifierData;
            return this;
        }
        /**
         * Setter for timePeriodData
         * @param timePeriodData
         * @return Builder
         */
        public Builder timePeriodData(CatalogTimePeriod timePeriodData) {
            this.timePeriodData = timePeriodData;
            return this;
        }
        /**
         * Setter for productSetData
         * @param productSetData
         * @return Builder
         */
        public Builder productSetData(CatalogProductSet productSetData) {
            this.productSetData = productSetData;
            return this;
        }
        /**
         * Setter for pricingRuleData
         * @param pricingRuleData
         * @return Builder
         */
        public Builder pricingRuleData(CatalogPricingRule pricingRuleData) {
            this.pricingRuleData = pricingRuleData;
            return this;
        }
        /**
         * Setter for imageData
         * @param imageData
         * @return Builder
         */
        public Builder imageData(CatalogImage imageData) {
            this.imageData = imageData;
            return this;
        }
        /**
         * Setter for measurementUnitData
         * @param measurementUnitData
         * @return Builder
         */
        public Builder measurementUnitData(CatalogMeasurementUnit measurementUnitData) {
            this.measurementUnitData = measurementUnitData;
            return this;
        }
        /**
         * Setter for itemOptionData
         * @param itemOptionData
         * @return Builder
         */
        public Builder itemOptionData(CatalogItemOption itemOptionData) {
            this.itemOptionData = itemOptionData;
            return this;
        }
        /**
         * Setter for itemOptionValueData
         * @param itemOptionValueData
         * @return Builder
         */
        public Builder itemOptionValueData(CatalogItemOptionValue itemOptionValueData) {
            this.itemOptionValueData = itemOptionValueData;
            return this;
        }
        /**
         * Setter for customAttributeDefinitionData
         * @param customAttributeDefinitionData
         * @return Builder
         */
        public Builder customAttributeDefinitionData(CatalogCustomAttributeDefinition customAttributeDefinitionData) {
            this.customAttributeDefinitionData = customAttributeDefinitionData;
            return this;
        }
        /**
         * Setter for quickAmountsSettingsData
         * @param quickAmountsSettingsData
         * @return Builder
         */
        public Builder quickAmountsSettingsData(CatalogQuickAmountsSettings quickAmountsSettingsData) {
            this.quickAmountsSettingsData = quickAmountsSettingsData;
            return this;
        }

        /**
         * Builds a new {@link CatalogObject} object using the set fields.
         * @return {@link CatalogObject}
         */
        public CatalogObject build() {
            return new CatalogObject(type,
                id,
                updatedAt,
                version,
                isDeleted,
                customAttributeValues,
                catalogV1Ids,
                presentAtAllLocations,
                presentAtLocationIds,
                absentAtLocationIds,
                imageId,
                itemData,
                categoryData,
                itemVariationData,
                taxData,
                discountData,
                modifierListData,
                modifierData,
                timePeriodData,
                productSetData,
                pricingRuleData,
                imageData,
                measurementUnitData,
                itemOptionData,
                itemOptionValueData,
                customAttributeDefinitionData,
                quickAmountsSettingsData);
        }
    }
}
