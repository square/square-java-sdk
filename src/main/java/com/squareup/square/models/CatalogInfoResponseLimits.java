package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogInfoResponseLimits {

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

    @Override
    public int hashCode() {
        return Objects.hash(batchUpsertMaxObjectsPerBatch, batchUpsertMaxTotalObjects, batchRetrieveMaxObjectIds, searchMaxPageLimit, batchDeleteMaxObjectIds, updateItemTaxesMaxItemIds, updateItemTaxesMaxTaxesToEnable, updateItemTaxesMaxTaxesToDisable, updateItemModifierListsMaxItemIds, updateItemModifierListsMaxModifierListsToEnable, updateItemModifierListsMaxModifierListsToDisable);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogInfoResponseLimits)) {
            return false;
        }
        CatalogInfoResponseLimits catalogInfoResponseLimits = (CatalogInfoResponseLimits) o;
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

        public Builder() { }

        public Builder batchUpsertMaxObjectsPerBatch(Integer value) {
            batchUpsertMaxObjectsPerBatch = value;
            return this;
        }
        public Builder batchUpsertMaxTotalObjects(Integer value) {
            batchUpsertMaxTotalObjects = value;
            return this;
        }
        public Builder batchRetrieveMaxObjectIds(Integer value) {
            batchRetrieveMaxObjectIds = value;
            return this;
        }
        public Builder searchMaxPageLimit(Integer value) {
            searchMaxPageLimit = value;
            return this;
        }
        public Builder batchDeleteMaxObjectIds(Integer value) {
            batchDeleteMaxObjectIds = value;
            return this;
        }
        public Builder updateItemTaxesMaxItemIds(Integer value) {
            updateItemTaxesMaxItemIds = value;
            return this;
        }
        public Builder updateItemTaxesMaxTaxesToEnable(Integer value) {
            updateItemTaxesMaxTaxesToEnable = value;
            return this;
        }
        public Builder updateItemTaxesMaxTaxesToDisable(Integer value) {
            updateItemTaxesMaxTaxesToDisable = value;
            return this;
        }
        public Builder updateItemModifierListsMaxItemIds(Integer value) {
            updateItemModifierListsMaxItemIds = value;
            return this;
        }
        public Builder updateItemModifierListsMaxModifierListsToEnable(Integer value) {
            updateItemModifierListsMaxModifierListsToEnable = value;
            return this;
        }
        public Builder updateItemModifierListsMaxModifierListsToDisable(Integer value) {
            updateItemModifierListsMaxModifierListsToDisable = value;
            return this;
        }

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
