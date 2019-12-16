package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogObject {

    @JsonCreator
    public CatalogObject(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("version") Long version,
            @JsonProperty("is_deleted") Boolean isDeleted,
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
            @JsonProperty("item_option_value_data") CatalogItemOptionValue itemOptionValueData) {
        this.type = type;
        this.id = id;
        this.updatedAt = updatedAt;
        this.version = version;
        this.isDeleted = isDeleted;
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
    }

    private final String type;
    private final String id;
    private final String updatedAt;
    private final Long version;
    private final Boolean isDeleted;
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

    @Override
    public int hashCode() {
        return Objects.hash(type, id, updatedAt, version, isDeleted, catalogV1Ids, presentAtAllLocations, presentAtLocationIds, absentAtLocationIds, imageId, itemData, categoryData, itemVariationData, taxData, discountData, modifierListData, modifierData, timePeriodData, productSetData, pricingRuleData, imageData, measurementUnitData, itemOptionData, itemOptionValueData);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogObject)) {
            return false;
        }
        CatalogObject catalogObject = (CatalogObject) o;
        return Objects.equals(type, catalogObject.type) &&
            Objects.equals(id, catalogObject.id) &&
            Objects.equals(updatedAt, catalogObject.updatedAt) &&
            Objects.equals(version, catalogObject.version) &&
            Objects.equals(isDeleted, catalogObject.isDeleted) &&
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
            Objects.equals(itemOptionValueData, catalogObject.itemOptionValueData);
    }

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
     * An item (i.e., product family) in the Catalog object model.
     */
    @JsonGetter("item_data")
    public CatalogItem getItemData() { 
        return this.itemData;
    }

    /**
     * Getter for CategoryData.
     * A category to which a `CatalogItem` belongs in the `Catalog` object model.
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
     * A tax in the Catalog object model.
     */
    @JsonGetter("tax_data")
    public CatalogTax getTaxData() { 
        return this.taxData;
    }

    /**
     * Getter for DiscountData.
     * A discount in the Catalog object model.
     */
    @JsonGetter("discount_data")
    public CatalogDiscount getDiscountData() { 
        return this.discountData;
    }

    /**
     * Getter for ModifierListData.
     * A modifier list in the Catalog object model. A `CatalogModifierList`
     * contains `CatalogModifier` objects that can be applied to a `CatalogItem` at
     * the time of sale.
     * For example, a modifier list "Condiments" that would apply to a "Hot Dog"
     * `CatalogItem` might contain `CatalogModifier`s "Ketchup", "Mustard", and "Relish".
     * The `selection_type` field specifies whether or not multiple selections from
     * the modifier list are allowed.
     */
    @JsonGetter("modifier_list_data")
    public CatalogModifierList getModifierListData() { 
        return this.modifierListData;
    }

    /**
     * Getter for ModifierData.
     * A modifier in the Catalog object model.
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
     * Defines how prices are modified or set for items that match the pricing rule
     * during the active time period.
     */
    @JsonGetter("pricing_rule_data")
    public CatalogPricingRule getPricingRuleData() { 
        return this.pricingRuleData;
    }

    /**
     * Getter for ImageData.
     * An image file to use in Square catalogs. Can be associated with catalog
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

 
    public Builder toBuilder() {
        Builder builder = new Builder(type,
            id)
            .updatedAt(getUpdatedAt())
            .version(getVersion())
            .isDeleted(getIsDeleted())
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
            .itemOptionValueData(getItemOptionValueData());
            return builder;
    }

    public static class Builder {
        private String type;
        private String id;
        private String updatedAt;
        private Long version;
        private Boolean isDeleted;
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

        public Builder(String type,
                String id) {
            this.type = type;
            this.id = id;
        }

        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder updatedAt(String value) {
            updatedAt = value;
            return this;
        }
        public Builder version(Long value) {
            version = value;
            return this;
        }
        public Builder isDeleted(Boolean value) {
            isDeleted = value;
            return this;
        }
        public Builder catalogV1Ids(List<CatalogV1Id> value) {
            catalogV1Ids = value;
            return this;
        }
        public Builder presentAtAllLocations(Boolean value) {
            presentAtAllLocations = value;
            return this;
        }
        public Builder presentAtLocationIds(List<String> value) {
            presentAtLocationIds = value;
            return this;
        }
        public Builder absentAtLocationIds(List<String> value) {
            absentAtLocationIds = value;
            return this;
        }
        public Builder imageId(String value) {
            imageId = value;
            return this;
        }
        public Builder itemData(CatalogItem value) {
            itemData = value;
            return this;
        }
        public Builder categoryData(CatalogCategory value) {
            categoryData = value;
            return this;
        }
        public Builder itemVariationData(CatalogItemVariation value) {
            itemVariationData = value;
            return this;
        }
        public Builder taxData(CatalogTax value) {
            taxData = value;
            return this;
        }
        public Builder discountData(CatalogDiscount value) {
            discountData = value;
            return this;
        }
        public Builder modifierListData(CatalogModifierList value) {
            modifierListData = value;
            return this;
        }
        public Builder modifierData(CatalogModifier value) {
            modifierData = value;
            return this;
        }
        public Builder timePeriodData(CatalogTimePeriod value) {
            timePeriodData = value;
            return this;
        }
        public Builder productSetData(CatalogProductSet value) {
            productSetData = value;
            return this;
        }
        public Builder pricingRuleData(CatalogPricingRule value) {
            pricingRuleData = value;
            return this;
        }
        public Builder imageData(CatalogImage value) {
            imageData = value;
            return this;
        }
        public Builder measurementUnitData(CatalogMeasurementUnit value) {
            measurementUnitData = value;
            return this;
        }
        public Builder itemOptionData(CatalogItemOption value) {
            itemOptionData = value;
            return this;
        }
        public Builder itemOptionValueData(CatalogItemOptionValue value) {
            itemOptionValueData = value;
            return this;
        }

        public CatalogObject build() {
            return new CatalogObject(type,
                id,
                updatedAt,
                version,
                isDeleted,
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
                itemOptionValueData);
        }
    }
}
