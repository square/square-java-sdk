package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogInfoResponseLimits type.
 */
public class CatalogInfoResponseLimits {

    /**
     * Initialization constructor.
     * @param batchUpsertMaxObjectsPerBatch
     * @param batchUpsertMaxTotalObjects
     * @param batchRetrieveMaxObjectIds
     * @param searchMaxPageLimit
     * @param batchDeleteMaxObjectIds
     * @param updateItemTaxesMaxItemIds
     * @param updateItemTaxesMaxTaxesToEnable
     * @param updateItemTaxesMaxTaxesToDisable
     * @param updateItemModifierListsMaxItemIds
     * @param updateItemModifierListsMaxModifierListsToEnable
     * @param updateItemModifierListsMaxModifierListsToDisable
     */
    @JsonCreator
    public CatalogInfoResponseLimits(
            @JsonProperty("batch_upsert_max_objects_per_batch") Integer batchUpsertMaxObjectsPerBatch,
            @JsonProperty("batch_upsert_max_total_objects") Integer batchUpsertMaxTotalObjects,
            @JsonProperty("batch_retrieve_max_object_ids") Integer batchRetrieveMaxObjectIds,
            @JsonProperty("search_max_page_limit") Integer searchMaxPageLimit,
            @JsonProperty("batch_delete_max_object_ids") Integer batchDeleteMaxObjectIds,
            @JsonProperty("update_item_taxes_max_item_ids") Integer updateItemTaxesMaxItemIds,
            @JsonProperty("update_item_taxes_max_taxes_to_enable") Integer updateItemTaxesMaxTaxesToEnable,
            @JsonProperty("update_item_taxes_max_taxes_to_disable") Integer updateItemTaxesMaxTaxesToDisable,
            @JsonProperty("update_item_modifier_lists_max_item_ids") Integer updateItemModifierListsMaxItemIds,
            @JsonProperty("update_item_modifier_lists_max_modifier_lists_to_enable") Integer updateItemModifierListsMaxModifierListsToEnable,
            @JsonProperty("update_item_modifier_lists_max_modifier_lists_to_disable") Integer updateItemModifierListsMaxModifierListsToDisable) {
        this.batchUpsertMaxObjectsPerBatch = batchUpsertMaxObjectsPerBatch;
        this.batchUpsertMaxTotalObjects = batchUpsertMaxTotalObjects;
        this.batchRetrieveMaxObjectIds = batchRetrieveMaxObjectIds;
        this.searchMaxPageLimit = searchMaxPageLimit;
        this.batchDeleteMaxObjectIds = batchDeleteMaxObjectIds;
        this.updateItemTaxesMaxItemIds = updateItemTaxesMaxItemIds;
        this.updateItemTaxesMaxTaxesToEnable = updateItemTaxesMaxTaxesToEnable;
        this.updateItemTaxesMaxTaxesToDisable = updateItemTaxesMaxTaxesToDisable;
        this.updateItemModifierListsMaxItemIds = updateItemModifierListsMaxItemIds;
        this.updateItemModifierListsMaxModifierListsToEnable = updateItemModifierListsMaxModifierListsToEnable;
        this.updateItemModifierListsMaxModifierListsToDisable = updateItemModifierListsMaxModifierListsToDisable;
    }

    private final Integer batchUpsertMaxObjectsPerBatch;
    private final Integer batchUpsertMaxTotalObjects;
    private final Integer batchRetrieveMaxObjectIds;
    private final Integer searchMaxPageLimit;
    private final Integer batchDeleteMaxObjectIds;
    private final Integer updateItemTaxesMaxItemIds;
    private final Integer updateItemTaxesMaxTaxesToEnable;
    private final Integer updateItemTaxesMaxTaxesToDisable;
    private final Integer updateItemModifierListsMaxItemIds;
    private final Integer updateItemModifierListsMaxModifierListsToEnable;
    private final Integer updateItemModifierListsMaxModifierListsToDisable;
    /**
     * Getter for BatchUpsertMaxObjectsPerBatch.
     * The maximum number of objects that may appear within a single batch in a
     * `/v2/catalog/batch-upsert` request.
     */
    @JsonGetter("batch_upsert_max_objects_per_batch")
    public Integer getBatchUpsertMaxObjectsPerBatch() {
        return this.batchUpsertMaxObjectsPerBatch;
    }

    /**
     * Getter for BatchUpsertMaxTotalObjects.
     * The maximum number of objects that may appear across all batches in a
     * `/v2/catalog/batch-upsert` request.
     */
    @JsonGetter("batch_upsert_max_total_objects")
    public Integer getBatchUpsertMaxTotalObjects() {
        return this.batchUpsertMaxTotalObjects;
    }

    /**
     * Getter for BatchRetrieveMaxObjectIds.
     * The maximum number of object IDs that may appear in a `/v2/catalog/batch-retrieve`
     * request.
     */
    @JsonGetter("batch_retrieve_max_object_ids")
    public Integer getBatchRetrieveMaxObjectIds() {
        return this.batchRetrieveMaxObjectIds;
    }

    /**
     * Getter for SearchMaxPageLimit.
     * The maximum number of results that may be returned in a page of a
     * `/v2/catalog/search` response.
     */
    @JsonGetter("search_max_page_limit")
    public Integer getSearchMaxPageLimit() {
        return this.searchMaxPageLimit;
    }

    /**
     * Getter for BatchDeleteMaxObjectIds.
     * The maximum number of object IDs that may be included in a single
     * `/v2/catalog/batch-delete` request.
     */
    @JsonGetter("batch_delete_max_object_ids")
    public Integer getBatchDeleteMaxObjectIds() {
        return this.batchDeleteMaxObjectIds;
    }

    /**
     * Getter for UpdateItemTaxesMaxItemIds.
     * The maximum number of item IDs that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     */
    @JsonGetter("update_item_taxes_max_item_ids")
    public Integer getUpdateItemTaxesMaxItemIds() {
        return this.updateItemTaxesMaxItemIds;
    }

    /**
     * Getter for UpdateItemTaxesMaxTaxesToEnable.
     * The maximum number of tax IDs to be enabled that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     */
    @JsonGetter("update_item_taxes_max_taxes_to_enable")
    public Integer getUpdateItemTaxesMaxTaxesToEnable() {
        return this.updateItemTaxesMaxTaxesToEnable;
    }

    /**
     * Getter for UpdateItemTaxesMaxTaxesToDisable.
     * The maximum number of tax IDs to be disabled that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     */
    @JsonGetter("update_item_taxes_max_taxes_to_disable")
    public Integer getUpdateItemTaxesMaxTaxesToDisable() {
        return this.updateItemTaxesMaxTaxesToDisable;
    }

    /**
     * Getter for UpdateItemModifierListsMaxItemIds.
     * The maximum number of item IDs that may be included in a single
     * `/v2/catalog/update-item-modifier-lists` request.
     */
    @JsonGetter("update_item_modifier_lists_max_item_ids")
    public Integer getUpdateItemModifierListsMaxItemIds() {
        return this.updateItemModifierListsMaxItemIds;
    }

    /**
     * Getter for UpdateItemModifierListsMaxModifierListsToEnable.
     * The maximum number of modifier list IDs to be enabled that may be included in
     * a single `/v2/catalog/update-item-modifier-lists` request.
     */
    @JsonGetter("update_item_modifier_lists_max_modifier_lists_to_enable")
    public Integer getUpdateItemModifierListsMaxModifierListsToEnable() {
        return this.updateItemModifierListsMaxModifierListsToEnable;
    }

    /**
     * Getter for UpdateItemModifierListsMaxModifierListsToDisable.
     * The maximum number of modifier list IDs to be disabled that may be included in
     * a single `/v2/catalog/update-item-modifier-lists` request.
     */
    @JsonGetter("update_item_modifier_lists_max_modifier_lists_to_disable")
    public Integer getUpdateItemModifierListsMaxModifierListsToDisable() {
        return this.updateItemModifierListsMaxModifierListsToDisable;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(batchUpsertMaxObjectsPerBatch, batchUpsertMaxTotalObjects,
            batchRetrieveMaxObjectIds, searchMaxPageLimit, batchDeleteMaxObjectIds,
            updateItemTaxesMaxItemIds, updateItemTaxesMaxTaxesToEnable,
            updateItemTaxesMaxTaxesToDisable, updateItemModifierListsMaxItemIds,
            updateItemModifierListsMaxModifierListsToEnable,
            updateItemModifierListsMaxModifierListsToDisable);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogInfoResponseLimits)) {
            return false;
        }
        CatalogInfoResponseLimits catalogInfoResponseLimits = (CatalogInfoResponseLimits) obj;
        return Objects.equals(batchUpsertMaxObjectsPerBatch, catalogInfoResponseLimits.batchUpsertMaxObjectsPerBatch) &&
            Objects.equals(batchUpsertMaxTotalObjects, catalogInfoResponseLimits.batchUpsertMaxTotalObjects) &&
            Objects.equals(batchRetrieveMaxObjectIds, catalogInfoResponseLimits.batchRetrieveMaxObjectIds) &&
            Objects.equals(searchMaxPageLimit, catalogInfoResponseLimits.searchMaxPageLimit) &&
            Objects.equals(batchDeleteMaxObjectIds, catalogInfoResponseLimits.batchDeleteMaxObjectIds) &&
            Objects.equals(updateItemTaxesMaxItemIds, catalogInfoResponseLimits.updateItemTaxesMaxItemIds) &&
            Objects.equals(updateItemTaxesMaxTaxesToEnable, catalogInfoResponseLimits.updateItemTaxesMaxTaxesToEnable) &&
            Objects.equals(updateItemTaxesMaxTaxesToDisable, catalogInfoResponseLimits.updateItemTaxesMaxTaxesToDisable) &&
            Objects.equals(updateItemModifierListsMaxItemIds, catalogInfoResponseLimits.updateItemModifierListsMaxItemIds) &&
            Objects.equals(updateItemModifierListsMaxModifierListsToEnable, catalogInfoResponseLimits.updateItemModifierListsMaxModifierListsToEnable) &&
            Objects.equals(updateItemModifierListsMaxModifierListsToDisable, catalogInfoResponseLimits.updateItemModifierListsMaxModifierListsToDisable);
    }

    /**
     * Builds a new {@link CatalogInfoResponseLimits.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogInfoResponseLimits.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .batchUpsertMaxObjectsPerBatch(getBatchUpsertMaxObjectsPerBatch())
            .batchUpsertMaxTotalObjects(getBatchUpsertMaxTotalObjects())
            .batchRetrieveMaxObjectIds(getBatchRetrieveMaxObjectIds())
            .searchMaxPageLimit(getSearchMaxPageLimit())
            .batchDeleteMaxObjectIds(getBatchDeleteMaxObjectIds())
            .updateItemTaxesMaxItemIds(getUpdateItemTaxesMaxItemIds())
            .updateItemTaxesMaxTaxesToEnable(getUpdateItemTaxesMaxTaxesToEnable())
            .updateItemTaxesMaxTaxesToDisable(getUpdateItemTaxesMaxTaxesToDisable())
            .updateItemModifierListsMaxItemIds(getUpdateItemModifierListsMaxItemIds())
            .updateItemModifierListsMaxModifierListsToEnable(getUpdateItemModifierListsMaxModifierListsToEnable())
            .updateItemModifierListsMaxModifierListsToDisable(getUpdateItemModifierListsMaxModifierListsToDisable());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogInfoResponseLimits}
     */
    public static class Builder {
        private Integer batchUpsertMaxObjectsPerBatch;
        private Integer batchUpsertMaxTotalObjects;
        private Integer batchRetrieveMaxObjectIds;
        private Integer searchMaxPageLimit;
        private Integer batchDeleteMaxObjectIds;
        private Integer updateItemTaxesMaxItemIds;
        private Integer updateItemTaxesMaxTaxesToEnable;
        private Integer updateItemTaxesMaxTaxesToDisable;
        private Integer updateItemModifierListsMaxItemIds;
        private Integer updateItemModifierListsMaxModifierListsToEnable;
        private Integer updateItemModifierListsMaxModifierListsToDisable;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for batchUpsertMaxObjectsPerBatch
         * @param batchUpsertMaxObjectsPerBatch
         * @return Builder
         */
        public Builder batchUpsertMaxObjectsPerBatch(Integer batchUpsertMaxObjectsPerBatch) {
            this.batchUpsertMaxObjectsPerBatch = batchUpsertMaxObjectsPerBatch;
            return this;
        }
        /**
         * Setter for batchUpsertMaxTotalObjects
         * @param batchUpsertMaxTotalObjects
         * @return Builder
         */
        public Builder batchUpsertMaxTotalObjects(Integer batchUpsertMaxTotalObjects) {
            this.batchUpsertMaxTotalObjects = batchUpsertMaxTotalObjects;
            return this;
        }
        /**
         * Setter for batchRetrieveMaxObjectIds
         * @param batchRetrieveMaxObjectIds
         * @return Builder
         */
        public Builder batchRetrieveMaxObjectIds(Integer batchRetrieveMaxObjectIds) {
            this.batchRetrieveMaxObjectIds = batchRetrieveMaxObjectIds;
            return this;
        }
        /**
         * Setter for searchMaxPageLimit
         * @param searchMaxPageLimit
         * @return Builder
         */
        public Builder searchMaxPageLimit(Integer searchMaxPageLimit) {
            this.searchMaxPageLimit = searchMaxPageLimit;
            return this;
        }
        /**
         * Setter for batchDeleteMaxObjectIds
         * @param batchDeleteMaxObjectIds
         * @return Builder
         */
        public Builder batchDeleteMaxObjectIds(Integer batchDeleteMaxObjectIds) {
            this.batchDeleteMaxObjectIds = batchDeleteMaxObjectIds;
            return this;
        }
        /**
         * Setter for updateItemTaxesMaxItemIds
         * @param updateItemTaxesMaxItemIds
         * @return Builder
         */
        public Builder updateItemTaxesMaxItemIds(Integer updateItemTaxesMaxItemIds) {
            this.updateItemTaxesMaxItemIds = updateItemTaxesMaxItemIds;
            return this;
        }
        /**
         * Setter for updateItemTaxesMaxTaxesToEnable
         * @param updateItemTaxesMaxTaxesToEnable
         * @return Builder
         */
        public Builder updateItemTaxesMaxTaxesToEnable(Integer updateItemTaxesMaxTaxesToEnable) {
            this.updateItemTaxesMaxTaxesToEnable = updateItemTaxesMaxTaxesToEnable;
            return this;
        }
        /**
         * Setter for updateItemTaxesMaxTaxesToDisable
         * @param updateItemTaxesMaxTaxesToDisable
         * @return Builder
         */
        public Builder updateItemTaxesMaxTaxesToDisable(Integer updateItemTaxesMaxTaxesToDisable) {
            this.updateItemTaxesMaxTaxesToDisable = updateItemTaxesMaxTaxesToDisable;
            return this;
        }
        /**
         * Setter for updateItemModifierListsMaxItemIds
         * @param updateItemModifierListsMaxItemIds
         * @return Builder
         */
        public Builder updateItemModifierListsMaxItemIds(Integer updateItemModifierListsMaxItemIds) {
            this.updateItemModifierListsMaxItemIds = updateItemModifierListsMaxItemIds;
            return this;
        }
        /**
         * Setter for updateItemModifierListsMaxModifierListsToEnable
         * @param updateItemModifierListsMaxModifierListsToEnable
         * @return Builder
         */
        public Builder updateItemModifierListsMaxModifierListsToEnable(Integer updateItemModifierListsMaxModifierListsToEnable) {
            this.updateItemModifierListsMaxModifierListsToEnable = updateItemModifierListsMaxModifierListsToEnable;
            return this;
        }
        /**
         * Setter for updateItemModifierListsMaxModifierListsToDisable
         * @param updateItemModifierListsMaxModifierListsToDisable
         * @return Builder
         */
        public Builder updateItemModifierListsMaxModifierListsToDisable(Integer updateItemModifierListsMaxModifierListsToDisable) {
            this.updateItemModifierListsMaxModifierListsToDisable = updateItemModifierListsMaxModifierListsToDisable;
            return this;
        }

        /**
         * Builds a new {@link CatalogInfoResponseLimits} object using the set fields.
         * @return {@link CatalogInfoResponseLimits}
         */
        public CatalogInfoResponseLimits build() {
            return new CatalogInfoResponseLimits(batchUpsertMaxObjectsPerBatch,
                batchUpsertMaxTotalObjects,
                batchRetrieveMaxObjectIds,
                searchMaxPageLimit,
                batchDeleteMaxObjectIds,
                updateItemTaxesMaxItemIds,
                updateItemTaxesMaxTaxesToEnable,
                updateItemTaxesMaxTaxesToDisable,
                updateItemModifierListsMaxItemIds,
                updateItemModifierListsMaxModifierListsToEnable,
                updateItemModifierListsMaxModifierListsToDisable);
        }
    }
}
