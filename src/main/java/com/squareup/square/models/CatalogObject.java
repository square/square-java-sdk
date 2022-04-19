
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for CatalogObject type.
 */
public class CatalogObject {
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
    private final CatalogSubscriptionPlan subscriptionPlanData;
    private final CatalogItemOption itemOptionData;
    private final CatalogItemOptionValue itemOptionValueData;
    private final CatalogCustomAttributeDefinition customAttributeDefinitionData;
    private final CatalogQuickAmountsSettings quickAmountsSettingsData;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  id  String value for id.
     * @param  updatedAt  String value for updatedAt.
     * @param  version  Long value for version.
     * @param  isDeleted  Boolean value for isDeleted.
     * @param  customAttributeValues  Map of String, value for customAttributeValues.
     * @param  catalogV1Ids  List of CatalogV1Id value for catalogV1Ids.
     * @param  presentAtAllLocations  Boolean value for presentAtAllLocations.
     * @param  presentAtLocationIds  List of String value for presentAtLocationIds.
     * @param  absentAtLocationIds  List of String value for absentAtLocationIds.
     * @param  itemData  CatalogItem value for itemData.
     * @param  categoryData  CatalogCategory value for categoryData.
     * @param  itemVariationData  CatalogItemVariation value for itemVariationData.
     * @param  taxData  CatalogTax value for taxData.
     * @param  discountData  CatalogDiscount value for discountData.
     * @param  modifierListData  CatalogModifierList value for modifierListData.
     * @param  modifierData  CatalogModifier value for modifierData.
     * @param  timePeriodData  CatalogTimePeriod value for timePeriodData.
     * @param  productSetData  CatalogProductSet value for productSetData.
     * @param  pricingRuleData  CatalogPricingRule value for pricingRuleData.
     * @param  imageData  CatalogImage value for imageData.
     * @param  measurementUnitData  CatalogMeasurementUnit value for measurementUnitData.
     * @param  subscriptionPlanData  CatalogSubscriptionPlan value for subscriptionPlanData.
     * @param  itemOptionData  CatalogItemOption value for itemOptionData.
     * @param  itemOptionValueData  CatalogItemOptionValue value for itemOptionValueData.
     * @param  customAttributeDefinitionData  CatalogCustomAttributeDefinition value for
     *         customAttributeDefinitionData.
     * @param  quickAmountsSettingsData  CatalogQuickAmountsSettings value for
     *         quickAmountsSettingsData.
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
            @JsonProperty("subscription_plan_data") CatalogSubscriptionPlan subscriptionPlanData,
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
        this.subscriptionPlanData = subscriptionPlanData;
        this.itemOptionData = itemOptionData;
        this.itemOptionValueData = itemOptionValueData;
        this.customAttributeDefinitionData = customAttributeDefinitionData;
        this.quickAmountsSettingsData = quickAmountsSettingsData;
    }

    /**
     * Getter for Type.
     * Possible types of CatalogObjects returned from the catalog, each containing type-specific
     * properties in the `*_data` field corresponding to the specfied object type.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for Id.
     * An identifier to reference this object in the catalog. When a new `CatalogObject` is
     * inserted, the client should set the id to a temporary identifier starting with a "`#`"
     * character. Other objects being inserted or updated within the same request may use this
     * identifier to refer to the new object. When the server receives the new object, it will
     * supply a unique identifier that replaces the temporary identifier for all future references.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for UpdatedAt.
     * Last modification
     * [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) in RFC 3339
     * format, e.g., `"2016-08-15T23:59:33.123Z"` would indicate the UTC time (denoted by `Z`) of
     * August 15, 2016 at 23:59:33 and 123 milliseconds.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for Version.
     * The version of the object. When updating an object, the version supplied must match the
     * version in the database, otherwise the write will be rejected as conflicting.
     * @return Returns the Long
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getVersion() {
        return version;
    }

    /**
     * Getter for IsDeleted.
     * If `true`, the object has been deleted from the database. Must be `false` for new objects
     * being inserted. When deleted, the `updated_at` field will equal the deletion time.
     * @return Returns the Boolean
     */
    @JsonGetter("is_deleted")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * Getter for CustomAttributeValues.
     * A map (key-value pairs) of application-defined custom attribute values. The value of a
     * key-value pair is a [CatalogCustomAttributeValue]($m/CatalogCustomAttributeValue) object. The
     * key is the `key` attribute value defined in the associated
     * [CatalogCustomAttributeDefinition]($m/CatalogCustomAttributeDefinition) object defined by the
     * application making the request. If the `CatalogCustomAttributeDefinition` object is defined
     * by another application, the `CatalogCustomAttributeDefinition`'s key attribute value is
     * prefixed by the defining application ID. For example, if the
     * `CatalogCustomAttributeDefinition` has a `key` attribute of `"cocoa_brand"` and the defining
     * application ID is `"abcd1234"`, the key in the map is `"abcd1234:cocoa_brand"` if the
     * application making the request is different from the application defining the custom
     * attribute definition. Otherwise, the key used in the map is simply `"cocoa_brand"`.
     * Application-defined custom attributes are set at a global (location-independent) level.
     * Custom attribute values are intended to store additional information about a catalog object
     * or associations with an entity in another system. Do not use custom attributes to store any
     * sensitive information (personally identifiable information, card details, etc.).
     * @return Returns the Map of String, CatalogCustomAttributeValue
     */
    @JsonGetter("custom_attribute_values")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, CatalogCustomAttributeValue> getCustomAttributeValues() {
        return customAttributeValues;
    }

    /**
     * Getter for CatalogV1Ids.
     * The Connect v1 IDs for this object at each location where it is present, where they differ
     * from the object's Connect V2 ID. The field will only be present for objects that have been
     * created or modified by legacy APIs.
     * @return Returns the List of CatalogV1Id
     */
    @JsonGetter("catalog_v1_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CatalogV1Id> getCatalogV1Ids() {
        return catalogV1Ids;
    }

    /**
     * Getter for PresentAtAllLocations.
     * If `true`, this object is present at all locations (including future locations), except where
     * specified in the `absent_at_location_ids` field. If `false`, this object is not present at
     * any locations (including future locations), except where specified in the
     * `present_at_location_ids` field. If not specified, defaults to `true`.
     * @return Returns the Boolean
     */
    @JsonGetter("present_at_all_locations")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getPresentAtAllLocations() {
        return presentAtAllLocations;
    }

    /**
     * Getter for PresentAtLocationIds.
     * A list of locations where the object is present, even if `present_at_all_locations` is
     * `false`. This can include locations that are deactivated.
     * @return Returns the List of String
     */
    @JsonGetter("present_at_location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getPresentAtLocationIds() {
        return presentAtLocationIds;
    }

    /**
     * Getter for AbsentAtLocationIds.
     * A list of locations where the object is not present, even if `present_at_all_locations` is
     * `true`. This can include locations that are deactivated.
     * @return Returns the List of String
     */
    @JsonGetter("absent_at_location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getAbsentAtLocationIds() {
        return absentAtLocationIds;
    }

    /**
     * Getter for ItemData.
     * A [CatalogObject]($m/CatalogObject) instance of the `ITEM` type, also referred to as an item,
     * in the catalog.
     * @return Returns the CatalogItem
     */
    @JsonGetter("item_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogItem getItemData() {
        return itemData;
    }

    /**
     * Getter for CategoryData.
     * A category to which a `CatalogItem` instance belongs.
     * @return Returns the CatalogCategory
     */
    @JsonGetter("category_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogCategory getCategoryData() {
        return categoryData;
    }

    /**
     * Getter for ItemVariationData.
     * An item variation (i.e., product) in the Catalog object model. Each item may have a maximum
     * of 250 item variations.
     * @return Returns the CatalogItemVariation
     */
    @JsonGetter("item_variation_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogItemVariation getItemVariationData() {
        return itemVariationData;
    }

    /**
     * Getter for TaxData.
     * A tax applicable to an item.
     * @return Returns the CatalogTax
     */
    @JsonGetter("tax_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogTax getTaxData() {
        return taxData;
    }

    /**
     * Getter for DiscountData.
     * A discount applicable to items.
     * @return Returns the CatalogDiscount
     */
    @JsonGetter("discount_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogDiscount getDiscountData() {
        return discountData;
    }

    /**
     * Getter for ModifierListData.
     * A list of modifiers applicable to items at the time of sale. For example, a "Condiments"
     * modifier list applicable to a "Hot Dog" item may contain "Ketchup", "Mustard", and "Relish"
     * modifiers. Use the `selection_type` field to specify whether or not multiple selections from
     * the modifier list are allowed.
     * @return Returns the CatalogModifierList
     */
    @JsonGetter("modifier_list_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogModifierList getModifierListData() {
        return modifierListData;
    }

    /**
     * Getter for ModifierData.
     * A modifier applicable to items at the time of sale.
     * @return Returns the CatalogModifier
     */
    @JsonGetter("modifier_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogModifier getModifierData() {
        return modifierData;
    }

    /**
     * Getter for TimePeriodData.
     * Represents a time period - either a single period or a repeating period.
     * @return Returns the CatalogTimePeriod
     */
    @JsonGetter("time_period_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogTimePeriod getTimePeriodData() {
        return timePeriodData;
    }

    /**
     * Getter for ProductSetData.
     * Represents a collection of catalog objects for the purpose of applying a `PricingRule`.
     * Including a catalog object will include all of its subtypes. For example, including a
     * category in a product set will include all of its items and associated item variations in the
     * product set. Including an item in a product set will also include its item variations.
     * @return Returns the CatalogProductSet
     */
    @JsonGetter("product_set_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogProductSet getProductSetData() {
        return productSetData;
    }

    /**
     * Getter for PricingRuleData.
     * Defines how discounts are automatically applied to a set of items that match the pricing rule
     * during the active time period.
     * @return Returns the CatalogPricingRule
     */
    @JsonGetter("pricing_rule_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogPricingRule getPricingRuleData() {
        return pricingRuleData;
    }

    /**
     * Getter for ImageData.
     * An image file to use in Square catalogs. It can be associated with `CatalogItem`,
     * `CatalogItemVariation`, `CatalogCategory`, and `CatalogModifierList` objects. Only the images
     * on items and item variations are exposed in Dashboard. Only the first image on an item is
     * displayed in Square Point of Sale (SPOS). Images on items and variations are displayed
     * through Square Online Store. Images on other object types are for use by 3rd party
     * application developers.
     * @return Returns the CatalogImage
     */
    @JsonGetter("image_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogImage getImageData() {
        return imageData;
    }

    /**
     * Getter for MeasurementUnitData.
     * Represents the unit used to measure a `CatalogItemVariation` and specifies the precision for
     * decimal quantities.
     * @return Returns the CatalogMeasurementUnit
     */
    @JsonGetter("measurement_unit_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogMeasurementUnit getMeasurementUnitData() {
        return measurementUnitData;
    }

    /**
     * Getter for SubscriptionPlanData.
     * Describes a subscription plan. For more information, see [Set Up and Manage a Subscription
     * Plan](https://developer.squareup.com/docs/subscriptions-api/setup-plan).
     * @return Returns the CatalogSubscriptionPlan
     */
    @JsonGetter("subscription_plan_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogSubscriptionPlan getSubscriptionPlanData() {
        return subscriptionPlanData;
    }

    /**
     * Getter for ItemOptionData.
     * A group of variations for a `CatalogItem`.
     * @return Returns the CatalogItemOption
     */
    @JsonGetter("item_option_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogItemOption getItemOptionData() {
        return itemOptionData;
    }

    /**
     * Getter for ItemOptionValueData.
     * An enumerated value that can link a `CatalogItemVariation` to an item option as one of its
     * item option values.
     * @return Returns the CatalogItemOptionValue
     */
    @JsonGetter("item_option_value_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogItemOptionValue getItemOptionValueData() {
        return itemOptionValueData;
    }

    /**
     * Getter for CustomAttributeDefinitionData.
     * Contains information defining a custom attribute. Custom attributes are intended to store
     * additional information about a catalog object or to associate a catalog object with an entity
     * in another system. Do not use custom attributes to store any sensitive information
     * (personally identifiable information, card details, etc.). [Read more about custom
     * attributes](https://developer.squareup.com/docs/catalog-api/add-custom-attributes)
     * @return Returns the CatalogCustomAttributeDefinition
     */
    @JsonGetter("custom_attribute_definition_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogCustomAttributeDefinition getCustomAttributeDefinitionData() {
        return customAttributeDefinitionData;
    }

    /**
     * Getter for QuickAmountsSettingsData.
     * A parent Catalog Object model represents a set of Quick Amounts and the settings control the
     * amounts.
     * @return Returns the CatalogQuickAmountsSettings
     */
    @JsonGetter("quick_amounts_settings_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogQuickAmountsSettings getQuickAmountsSettingsData() {
        return quickAmountsSettingsData;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, updatedAt, version, isDeleted, customAttributeValues,
                catalogV1Ids, presentAtAllLocations, presentAtLocationIds, absentAtLocationIds,
                itemData, categoryData, itemVariationData, taxData, discountData, modifierListData,
                modifierData, timePeriodData, productSetData, pricingRuleData, imageData,
                measurementUnitData, subscriptionPlanData, itemOptionData, itemOptionValueData,
                customAttributeDefinitionData, quickAmountsSettingsData);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogObject)) {
            return false;
        }
        CatalogObject other = (CatalogObject) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(id, other.id)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(version, other.version)
            && Objects.equals(isDeleted, other.isDeleted)
            && Objects.equals(customAttributeValues, other.customAttributeValues)
            && Objects.equals(catalogV1Ids, other.catalogV1Ids)
            && Objects.equals(presentAtAllLocations, other.presentAtAllLocations)
            && Objects.equals(presentAtLocationIds, other.presentAtLocationIds)
            && Objects.equals(absentAtLocationIds, other.absentAtLocationIds)
            && Objects.equals(itemData, other.itemData)
            && Objects.equals(categoryData, other.categoryData)
            && Objects.equals(itemVariationData, other.itemVariationData)
            && Objects.equals(taxData, other.taxData)
            && Objects.equals(discountData, other.discountData)
            && Objects.equals(modifierListData, other.modifierListData)
            && Objects.equals(modifierData, other.modifierData)
            && Objects.equals(timePeriodData, other.timePeriodData)
            && Objects.equals(productSetData, other.productSetData)
            && Objects.equals(pricingRuleData, other.pricingRuleData)
            && Objects.equals(imageData, other.imageData)
            && Objects.equals(measurementUnitData, other.measurementUnitData)
            && Objects.equals(subscriptionPlanData, other.subscriptionPlanData)
            && Objects.equals(itemOptionData, other.itemOptionData)
            && Objects.equals(itemOptionValueData, other.itemOptionValueData)
            && Objects.equals(customAttributeDefinitionData, other.customAttributeDefinitionData)
            && Objects.equals(quickAmountsSettingsData, other.quickAmountsSettingsData);
    }

    /**
     * Converts this CatalogObject into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogObject [" + "type=" + type + ", id=" + id + ", updatedAt=" + updatedAt
                + ", version=" + version + ", isDeleted=" + isDeleted + ", customAttributeValues="
                + customAttributeValues + ", catalogV1Ids=" + catalogV1Ids
                + ", presentAtAllLocations=" + presentAtAllLocations + ", presentAtLocationIds="
                + presentAtLocationIds + ", absentAtLocationIds=" + absentAtLocationIds
                + ", itemData=" + itemData + ", categoryData=" + categoryData
                + ", itemVariationData=" + itemVariationData + ", taxData=" + taxData
                + ", discountData=" + discountData + ", modifierListData=" + modifierListData
                + ", modifierData=" + modifierData + ", timePeriodData=" + timePeriodData
                + ", productSetData=" + productSetData + ", pricingRuleData=" + pricingRuleData
                + ", imageData=" + imageData + ", measurementUnitData=" + measurementUnitData
                + ", subscriptionPlanData=" + subscriptionPlanData + ", itemOptionData="
                + itemOptionData + ", itemOptionValueData=" + itemOptionValueData
                + ", customAttributeDefinitionData=" + customAttributeDefinitionData
                + ", quickAmountsSettingsData=" + quickAmountsSettingsData + "]";
    }

    /**
     * Builds a new {@link CatalogObject.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogObject.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type, id)
                .updatedAt(getUpdatedAt())
                .version(getVersion())
                .isDeleted(getIsDeleted())
                .customAttributeValues(getCustomAttributeValues())
                .catalogV1Ids(getCatalogV1Ids())
                .presentAtAllLocations(getPresentAtAllLocations())
                .presentAtLocationIds(getPresentAtLocationIds())
                .absentAtLocationIds(getAbsentAtLocationIds())
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
                .subscriptionPlanData(getSubscriptionPlanData())
                .itemOptionData(getItemOptionData())
                .itemOptionValueData(getItemOptionValueData())
                .customAttributeDefinitionData(getCustomAttributeDefinitionData())
                .quickAmountsSettingsData(getQuickAmountsSettingsData());
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogObject}.
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
        private CatalogSubscriptionPlan subscriptionPlanData;
        private CatalogItemOption itemOptionData;
        private CatalogItemOptionValue itemOptionValueData;
        private CatalogCustomAttributeDefinition customAttributeDefinitionData;
        private CatalogQuickAmountsSettings quickAmountsSettingsData;

        /**
         * Initialization constructor.
         * @param  type  String value for type.
         * @param  id  String value for id.
         */
        public Builder(String type, String id) {
            this.type = type;
            this.id = id;
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
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * Setter for version.
         * @param  version  Long value for version.
         * @return Builder
         */
        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for isDeleted.
         * @param  isDeleted  Boolean value for isDeleted.
         * @return Builder
         */
        public Builder isDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        /**
         * Setter for customAttributeValues.
         * @param  customAttributeValues  Map of String, value for customAttributeValues.
         * @return Builder
         */
        public Builder customAttributeValues(
                Map<String, CatalogCustomAttributeValue> customAttributeValues) {
            this.customAttributeValues = customAttributeValues;
            return this;
        }

        /**
         * Setter for catalogV1Ids.
         * @param  catalogV1Ids  List of CatalogV1Id value for catalogV1Ids.
         * @return Builder
         */
        public Builder catalogV1Ids(List<CatalogV1Id> catalogV1Ids) {
            this.catalogV1Ids = catalogV1Ids;
            return this;
        }

        /**
         * Setter for presentAtAllLocations.
         * @param  presentAtAllLocations  Boolean value for presentAtAllLocations.
         * @return Builder
         */
        public Builder presentAtAllLocations(Boolean presentAtAllLocations) {
            this.presentAtAllLocations = presentAtAllLocations;
            return this;
        }

        /**
         * Setter for presentAtLocationIds.
         * @param  presentAtLocationIds  List of String value for presentAtLocationIds.
         * @return Builder
         */
        public Builder presentAtLocationIds(List<String> presentAtLocationIds) {
            this.presentAtLocationIds = presentAtLocationIds;
            return this;
        }

        /**
         * Setter for absentAtLocationIds.
         * @param  absentAtLocationIds  List of String value for absentAtLocationIds.
         * @return Builder
         */
        public Builder absentAtLocationIds(List<String> absentAtLocationIds) {
            this.absentAtLocationIds = absentAtLocationIds;
            return this;
        }

        /**
         * Setter for itemData.
         * @param  itemData  CatalogItem value for itemData.
         * @return Builder
         */
        public Builder itemData(CatalogItem itemData) {
            this.itemData = itemData;
            return this;
        }

        /**
         * Setter for categoryData.
         * @param  categoryData  CatalogCategory value for categoryData.
         * @return Builder
         */
        public Builder categoryData(CatalogCategory categoryData) {
            this.categoryData = categoryData;
            return this;
        }

        /**
         * Setter for itemVariationData.
         * @param  itemVariationData  CatalogItemVariation value for itemVariationData.
         * @return Builder
         */
        public Builder itemVariationData(CatalogItemVariation itemVariationData) {
            this.itemVariationData = itemVariationData;
            return this;
        }

        /**
         * Setter for taxData.
         * @param  taxData  CatalogTax value for taxData.
         * @return Builder
         */
        public Builder taxData(CatalogTax taxData) {
            this.taxData = taxData;
            return this;
        }

        /**
         * Setter for discountData.
         * @param  discountData  CatalogDiscount value for discountData.
         * @return Builder
         */
        public Builder discountData(CatalogDiscount discountData) {
            this.discountData = discountData;
            return this;
        }

        /**
         * Setter for modifierListData.
         * @param  modifierListData  CatalogModifierList value for modifierListData.
         * @return Builder
         */
        public Builder modifierListData(CatalogModifierList modifierListData) {
            this.modifierListData = modifierListData;
            return this;
        }

        /**
         * Setter for modifierData.
         * @param  modifierData  CatalogModifier value for modifierData.
         * @return Builder
         */
        public Builder modifierData(CatalogModifier modifierData) {
            this.modifierData = modifierData;
            return this;
        }

        /**
         * Setter for timePeriodData.
         * @param  timePeriodData  CatalogTimePeriod value for timePeriodData.
         * @return Builder
         */
        public Builder timePeriodData(CatalogTimePeriod timePeriodData) {
            this.timePeriodData = timePeriodData;
            return this;
        }

        /**
         * Setter for productSetData.
         * @param  productSetData  CatalogProductSet value for productSetData.
         * @return Builder
         */
        public Builder productSetData(CatalogProductSet productSetData) {
            this.productSetData = productSetData;
            return this;
        }

        /**
         * Setter for pricingRuleData.
         * @param  pricingRuleData  CatalogPricingRule value for pricingRuleData.
         * @return Builder
         */
        public Builder pricingRuleData(CatalogPricingRule pricingRuleData) {
            this.pricingRuleData = pricingRuleData;
            return this;
        }

        /**
         * Setter for imageData.
         * @param  imageData  CatalogImage value for imageData.
         * @return Builder
         */
        public Builder imageData(CatalogImage imageData) {
            this.imageData = imageData;
            return this;
        }

        /**
         * Setter for measurementUnitData.
         * @param  measurementUnitData  CatalogMeasurementUnit value for measurementUnitData.
         * @return Builder
         */
        public Builder measurementUnitData(CatalogMeasurementUnit measurementUnitData) {
            this.measurementUnitData = measurementUnitData;
            return this;
        }

        /**
         * Setter for subscriptionPlanData.
         * @param  subscriptionPlanData  CatalogSubscriptionPlan value for subscriptionPlanData.
         * @return Builder
         */
        public Builder subscriptionPlanData(CatalogSubscriptionPlan subscriptionPlanData) {
            this.subscriptionPlanData = subscriptionPlanData;
            return this;
        }

        /**
         * Setter for itemOptionData.
         * @param  itemOptionData  CatalogItemOption value for itemOptionData.
         * @return Builder
         */
        public Builder itemOptionData(CatalogItemOption itemOptionData) {
            this.itemOptionData = itemOptionData;
            return this;
        }

        /**
         * Setter for itemOptionValueData.
         * @param  itemOptionValueData  CatalogItemOptionValue value for itemOptionValueData.
         * @return Builder
         */
        public Builder itemOptionValueData(CatalogItemOptionValue itemOptionValueData) {
            this.itemOptionValueData = itemOptionValueData;
            return this;
        }

        /**
         * Setter for customAttributeDefinitionData.
         * @param  customAttributeDefinitionData  CatalogCustomAttributeDefinition value for
         *         customAttributeDefinitionData.
         * @return Builder
         */
        public Builder customAttributeDefinitionData(
                CatalogCustomAttributeDefinition customAttributeDefinitionData) {
            this.customAttributeDefinitionData = customAttributeDefinitionData;
            return this;
        }

        /**
         * Setter for quickAmountsSettingsData.
         * @param  quickAmountsSettingsData  CatalogQuickAmountsSettings value for
         *         quickAmountsSettingsData.
         * @return Builder
         */
        public Builder quickAmountsSettingsData(
                CatalogQuickAmountsSettings quickAmountsSettingsData) {
            this.quickAmountsSettingsData = quickAmountsSettingsData;
            return this;
        }

        /**
         * Builds a new {@link CatalogObject} object using the set fields.
         * @return {@link CatalogObject}
         */
        public CatalogObject build() {
            return new CatalogObject(type, id, updatedAt, version, isDeleted, customAttributeValues,
                    catalogV1Ids, presentAtAllLocations, presentAtLocationIds, absentAtLocationIds,
                    itemData, categoryData, itemVariationData, taxData, discountData,
                    modifierListData, modifierData, timePeriodData, productSetData, pricingRuleData,
                    imageData, measurementUnitData, subscriptionPlanData, itemOptionData,
                    itemOptionValueData, customAttributeDefinitionData, quickAmountsSettingsData);
        }
    }
}
