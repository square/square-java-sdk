
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for CatalogInfoResponseLimits type.
 */
public class CatalogInfoResponseLimits {
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
     * Initialization constructor.
     * @param batchUpsertMaxObjectsPerBatch Integer value for batchUpsertMaxObjectsPerBatch.
     * @param batchUpsertMaxTotalObjects Integer value for batchUpsertMaxTotalObjects.
     * @param batchRetrieveMaxObjectIds Integer value for batchRetrieveMaxObjectIds.
     * @param searchMaxPageLimit Integer value for searchMaxPageLimit.
     * @param batchDeleteMaxObjectIds Integer value for batchDeleteMaxObjectIds.
     * @param updateItemTaxesMaxItemIds Integer value for updateItemTaxesMaxItemIds.
     * @param updateItemTaxesMaxTaxesToEnable Integer value for updateItemTaxesMaxTaxesToEnable.
     * @param updateItemTaxesMaxTaxesToDisable Integer value for updateItemTaxesMaxTaxesToDisable.
     * @param updateItemModifierListsMaxItemIds Integer value for updateItemModifierListsMaxItemIds.
     * @param updateItemModifierListsMaxModifierListsToEnable Integer value for updateItemModifierListsMaxModifierListsToEnable.
     * @param updateItemModifierListsMaxModifierListsToDisable Integer value for updateItemModifierListsMaxModifierListsToDisable.
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

    /**
     * Getter for BatchUpsertMaxObjectsPerBatch.
     * The maximum number of objects that may appear within a single batch in a
     * `/v2/catalog/batch-upsert` request.
     * @return Returns the Integer
     */
    @JsonGetter("batch_upsert_max_objects_per_batch")
    public Integer getBatchUpsertMaxObjectsPerBatch() {
        return this.batchUpsertMaxObjectsPerBatch;
    }

    /**
     * Getter for BatchUpsertMaxTotalObjects.
     * The maximum number of objects that may appear across all batches in a
     * `/v2/catalog/batch-upsert` request.
     * @return Returns the Integer
     */
    @JsonGetter("batch_upsert_max_total_objects")
    public Integer getBatchUpsertMaxTotalObjects() {
        return this.batchUpsertMaxTotalObjects;
    }

    /**
     * Getter for BatchRetrieveMaxObjectIds.
     * The maximum number of object IDs that may appear in a `/v2/catalog/batch-retrieve` request.
     * @return Returns the Integer
     */
    @JsonGetter("batch_retrieve_max_object_ids")
    public Integer getBatchRetrieveMaxObjectIds() {
        return this.batchRetrieveMaxObjectIds;
    }

    /**
     * Getter for SearchMaxPageLimit.
     * The maximum number of results that may be returned in a page of a `/v2/catalog/search`
     * response.
     * @return Returns the Integer
     */
    @JsonGetter("search_max_page_limit")
    public Integer getSearchMaxPageLimit() {
        return this.searchMaxPageLimit;
    }

    /**
     * Getter for BatchDeleteMaxObjectIds.
     * The maximum number of object IDs that may be included in a single `/v2/catalog/batch-delete`
     * request.
     * @return Returns the Integer
     */
    @JsonGetter("batch_delete_max_object_ids")
    public Integer getBatchDeleteMaxObjectIds() {
        return this.batchDeleteMaxObjectIds;
    }

    /**
     * Getter for UpdateItemTaxesMaxItemIds.
     * The maximum number of item IDs that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     * @return Returns the Integer
     */
    @JsonGetter("update_item_taxes_max_item_ids")
    public Integer getUpdateItemTaxesMaxItemIds() {
        return this.updateItemTaxesMaxItemIds;
    }

    /**
     * Getter for UpdateItemTaxesMaxTaxesToEnable.
     * The maximum number of tax IDs to be enabled that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     * @return Returns the Integer
     */
    @JsonGetter("update_item_taxes_max_taxes_to_enable")
    public Integer getUpdateItemTaxesMaxTaxesToEnable() {
        return this.updateItemTaxesMaxTaxesToEnable;
    }

    /**
     * Getter for UpdateItemTaxesMaxTaxesToDisable.
     * The maximum number of tax IDs to be disabled that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     * @return Returns the Integer
     */
    @JsonGetter("update_item_taxes_max_taxes_to_disable")
    public Integer getUpdateItemTaxesMaxTaxesToDisable() {
        return this.updateItemTaxesMaxTaxesToDisable;
    }

    /**
     * Getter for UpdateItemModifierListsMaxItemIds.
     * The maximum number of item IDs that may be included in a single
     * `/v2/catalog/update-item-modifier-lists` request.
     * @return Returns the Integer
     */
    @JsonGetter("update_item_modifier_lists_max_item_ids")
    public Integer getUpdateItemModifierListsMaxItemIds() {
        return this.updateItemModifierListsMaxItemIds;
    }

    /**
     * Getter for UpdateItemModifierListsMaxModifierListsToEnable.
     * The maximum number of modifier list IDs to be enabled that may be included in a single
     * `/v2/catalog/update-item-modifier-lists` request.
     * @return Returns the Integer
     */
    @JsonGetter("update_item_modifier_lists_max_modifier_lists_to_enable")
    public Integer getUpdateItemModifierListsMaxModifierListsToEnable() {
        return this.updateItemModifierListsMaxModifierListsToEnable;
    }

    /**
     * Getter for UpdateItemModifierListsMaxModifierListsToDisable.
     * The maximum number of modifier list IDs to be disabled that may be included in a single
     * `/v2/catalog/update-item-modifier-lists` request.
     * @return Returns the Integer
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogInfoResponseLimits)) {
            return false;
        }
        CatalogInfoResponseLimits other = (CatalogInfoResponseLimits) obj;
        return Objects.equals(batchUpsertMaxObjectsPerBatch, other.batchUpsertMaxObjectsPerBatch)
            && Objects.equals(batchUpsertMaxTotalObjects, other.batchUpsertMaxTotalObjects)
            && Objects.equals(batchRetrieveMaxObjectIds, other.batchRetrieveMaxObjectIds)
            && Objects.equals(searchMaxPageLimit, other.searchMaxPageLimit)
            && Objects.equals(batchDeleteMaxObjectIds, other.batchDeleteMaxObjectIds)
            && Objects.equals(updateItemTaxesMaxItemIds, other.updateItemTaxesMaxItemIds)
            && Objects.equals(updateItemTaxesMaxTaxesToEnable,
                    other.updateItemTaxesMaxTaxesToEnable)
            && Objects.equals(updateItemTaxesMaxTaxesToDisable,
                    other.updateItemTaxesMaxTaxesToDisable)
            && Objects.equals(updateItemModifierListsMaxItemIds,
                    other.updateItemModifierListsMaxItemIds)
            && Objects.equals(updateItemModifierListsMaxModifierListsToEnable,
                    other.updateItemModifierListsMaxModifierListsToEnable)
            && Objects.equals(updateItemModifierListsMaxModifierListsToDisable,
                    other.updateItemModifierListsMaxModifierListsToDisable);
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
     * Class to build instances of {@link CatalogInfoResponseLimits}.
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
         * Setter for batchUpsertMaxObjectsPerBatch.
         * @param batchUpsertMaxObjectsPerBatch Integer value for batchUpsertMaxObjectsPerBatch.
         * @return Builder
         */
        public Builder batchUpsertMaxObjectsPerBatch(Integer batchUpsertMaxObjectsPerBatch) {
            this.batchUpsertMaxObjectsPerBatch = batchUpsertMaxObjectsPerBatch;
            return this;
        }

        /**
         * Setter for batchUpsertMaxTotalObjects.
         * @param batchUpsertMaxTotalObjects Integer value for batchUpsertMaxTotalObjects.
         * @return Builder
         */
        public Builder batchUpsertMaxTotalObjects(Integer batchUpsertMaxTotalObjects) {
            this.batchUpsertMaxTotalObjects = batchUpsertMaxTotalObjects;
            return this;
        }

        /**
         * Setter for batchRetrieveMaxObjectIds.
         * @param batchRetrieveMaxObjectIds Integer value for batchRetrieveMaxObjectIds.
         * @return Builder
         */
        public Builder batchRetrieveMaxObjectIds(Integer batchRetrieveMaxObjectIds) {
            this.batchRetrieveMaxObjectIds = batchRetrieveMaxObjectIds;
            return this;
        }

        /**
         * Setter for searchMaxPageLimit.
         * @param searchMaxPageLimit Integer value for searchMaxPageLimit.
         * @return Builder
         */
        public Builder searchMaxPageLimit(Integer searchMaxPageLimit) {
            this.searchMaxPageLimit = searchMaxPageLimit;
            return this;
        }

        /**
         * Setter for batchDeleteMaxObjectIds.
         * @param batchDeleteMaxObjectIds Integer value for batchDeleteMaxObjectIds.
         * @return Builder
         */
        public Builder batchDeleteMaxObjectIds(Integer batchDeleteMaxObjectIds) {
            this.batchDeleteMaxObjectIds = batchDeleteMaxObjectIds;
            return this;
        }

        /**
         * Setter for updateItemTaxesMaxItemIds.
         * @param updateItemTaxesMaxItemIds Integer value for updateItemTaxesMaxItemIds.
         * @return Builder
         */
        public Builder updateItemTaxesMaxItemIds(Integer updateItemTaxesMaxItemIds) {
            this.updateItemTaxesMaxItemIds = updateItemTaxesMaxItemIds;
            return this;
        }

        /**
         * Setter for updateItemTaxesMaxTaxesToEnable.
         * @param updateItemTaxesMaxTaxesToEnable Integer value for updateItemTaxesMaxTaxesToEnable.
         * @return Builder
         */
        public Builder updateItemTaxesMaxTaxesToEnable(Integer updateItemTaxesMaxTaxesToEnable) {
            this.updateItemTaxesMaxTaxesToEnable = updateItemTaxesMaxTaxesToEnable;
            return this;
        }

        /**
         * Setter for updateItemTaxesMaxTaxesToDisable.
         * @param updateItemTaxesMaxTaxesToDisable Integer value for updateItemTaxesMaxTaxesToDisable.
         * @return Builder
         */
        public Builder updateItemTaxesMaxTaxesToDisable(Integer updateItemTaxesMaxTaxesToDisable) {
            this.updateItemTaxesMaxTaxesToDisable = updateItemTaxesMaxTaxesToDisable;
            return this;
        }

        /**
         * Setter for updateItemModifierListsMaxItemIds.
         * @param updateItemModifierListsMaxItemIds Integer value for updateItemModifierListsMaxItemIds.
         * @return Builder
         */
        public Builder updateItemModifierListsMaxItemIds(Integer updateItemModifierListsMaxItemIds) {
            this.updateItemModifierListsMaxItemIds = updateItemModifierListsMaxItemIds;
            return this;
        }

        /**
         * Setter for updateItemModifierListsMaxModifierListsToEnable.
         * @param updateItemModifierListsMaxModifierListsToEnable Integer value for updateItemModifierListsMaxModifierListsToEnable.
         * @return Builder
         */
        public Builder updateItemModifierListsMaxModifierListsToEnable(Integer updateItemModifierListsMaxModifierListsToEnable) {
            this.updateItemModifierListsMaxModifierListsToEnable = updateItemModifierListsMaxModifierListsToEnable;
            return this;
        }

        /**
         * Setter for updateItemModifierListsMaxModifierListsToDisable.
         * @param updateItemModifierListsMaxModifierListsToDisable Integer value for updateItemModifierListsMaxModifierListsToDisable.
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
