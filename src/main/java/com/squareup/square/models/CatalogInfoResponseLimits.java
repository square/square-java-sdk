
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CatalogInfoResponseLimits type.
 */
public class CatalogInfoResponseLimits {
    private final OptionalNullable<Integer> batchUpsertMaxObjectsPerBatch;
    private final OptionalNullable<Integer> batchUpsertMaxTotalObjects;
    private final OptionalNullable<Integer> batchRetrieveMaxObjectIds;
    private final OptionalNullable<Integer> searchMaxPageLimit;
    private final OptionalNullable<Integer> batchDeleteMaxObjectIds;
    private final OptionalNullable<Integer> updateItemTaxesMaxItemIds;
    private final OptionalNullable<Integer> updateItemTaxesMaxTaxesToEnable;
    private final OptionalNullable<Integer> updateItemTaxesMaxTaxesToDisable;
    private final OptionalNullable<Integer> updateItemModifierListsMaxItemIds;
    private final OptionalNullable<Integer> updateItemModifierListsMaxModifierListsToEnable;
    private final OptionalNullable<Integer> updateItemModifierListsMaxModifierListsToDisable;

    /**
     * Initialization constructor.
     * @param  batchUpsertMaxObjectsPerBatch  Integer value for batchUpsertMaxObjectsPerBatch.
     * @param  batchUpsertMaxTotalObjects  Integer value for batchUpsertMaxTotalObjects.
     * @param  batchRetrieveMaxObjectIds  Integer value for batchRetrieveMaxObjectIds.
     * @param  searchMaxPageLimit  Integer value for searchMaxPageLimit.
     * @param  batchDeleteMaxObjectIds  Integer value for batchDeleteMaxObjectIds.
     * @param  updateItemTaxesMaxItemIds  Integer value for updateItemTaxesMaxItemIds.
     * @param  updateItemTaxesMaxTaxesToEnable  Integer value for updateItemTaxesMaxTaxesToEnable.
     * @param  updateItemTaxesMaxTaxesToDisable  Integer value for updateItemTaxesMaxTaxesToDisable.
     * @param  updateItemModifierListsMaxItemIds  Integer value for
     *         updateItemModifierListsMaxItemIds.
     * @param  updateItemModifierListsMaxModifierListsToEnable  Integer value for
     *         updateItemModifierListsMaxModifierListsToEnable.
     * @param  updateItemModifierListsMaxModifierListsToDisable  Integer value for
     *         updateItemModifierListsMaxModifierListsToDisable.
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
        this.batchUpsertMaxObjectsPerBatch = OptionalNullable.of(batchUpsertMaxObjectsPerBatch);
        this.batchUpsertMaxTotalObjects = OptionalNullable.of(batchUpsertMaxTotalObjects);
        this.batchRetrieveMaxObjectIds = OptionalNullable.of(batchRetrieveMaxObjectIds);
        this.searchMaxPageLimit = OptionalNullable.of(searchMaxPageLimit);
        this.batchDeleteMaxObjectIds = OptionalNullable.of(batchDeleteMaxObjectIds);
        this.updateItemTaxesMaxItemIds = OptionalNullable.of(updateItemTaxesMaxItemIds);
        this.updateItemTaxesMaxTaxesToEnable = OptionalNullable.of(updateItemTaxesMaxTaxesToEnable);
        this.updateItemTaxesMaxTaxesToDisable =
                OptionalNullable.of(updateItemTaxesMaxTaxesToDisable);
        this.updateItemModifierListsMaxItemIds =
                OptionalNullable.of(updateItemModifierListsMaxItemIds);
        this.updateItemModifierListsMaxModifierListsToEnable =
                OptionalNullable.of(updateItemModifierListsMaxModifierListsToEnable);
        this.updateItemModifierListsMaxModifierListsToDisable =
                OptionalNullable.of(updateItemModifierListsMaxModifierListsToDisable);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogInfoResponseLimits(OptionalNullable<Integer> batchUpsertMaxObjectsPerBatch,
            OptionalNullable<Integer> batchUpsertMaxTotalObjects,
            OptionalNullable<Integer> batchRetrieveMaxObjectIds,
            OptionalNullable<Integer> searchMaxPageLimit,
            OptionalNullable<Integer> batchDeleteMaxObjectIds,
            OptionalNullable<Integer> updateItemTaxesMaxItemIds,
            OptionalNullable<Integer> updateItemTaxesMaxTaxesToEnable,
            OptionalNullable<Integer> updateItemTaxesMaxTaxesToDisable,
            OptionalNullable<Integer> updateItemModifierListsMaxItemIds,
            OptionalNullable<Integer> updateItemModifierListsMaxModifierListsToEnable,
            OptionalNullable<Integer> updateItemModifierListsMaxModifierListsToDisable) {
        this.batchUpsertMaxObjectsPerBatch = batchUpsertMaxObjectsPerBatch;
        this.batchUpsertMaxTotalObjects = batchUpsertMaxTotalObjects;
        this.batchRetrieveMaxObjectIds = batchRetrieveMaxObjectIds;
        this.searchMaxPageLimit = searchMaxPageLimit;
        this.batchDeleteMaxObjectIds = batchDeleteMaxObjectIds;
        this.updateItemTaxesMaxItemIds = updateItemTaxesMaxItemIds;
        this.updateItemTaxesMaxTaxesToEnable = updateItemTaxesMaxTaxesToEnable;
        this.updateItemTaxesMaxTaxesToDisable = updateItemTaxesMaxTaxesToDisable;
        this.updateItemModifierListsMaxItemIds = updateItemModifierListsMaxItemIds;
        this.updateItemModifierListsMaxModifierListsToEnable =
                updateItemModifierListsMaxModifierListsToEnable;
        this.updateItemModifierListsMaxModifierListsToDisable =
                updateItemModifierListsMaxModifierListsToDisable;
    }

    /**
     * Internal Getter for BatchUpsertMaxObjectsPerBatch.
     * The maximum number of objects that may appear within a single batch in a
     * `/v2/catalog/batch-upsert` request.
     * @return Returns the Internal Integer
     */
    @JsonGetter("batch_upsert_max_objects_per_batch")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetBatchUpsertMaxObjectsPerBatch() {
        return this.batchUpsertMaxObjectsPerBatch;
    }

    /**
     * Getter for BatchUpsertMaxObjectsPerBatch.
     * The maximum number of objects that may appear within a single batch in a
     * `/v2/catalog/batch-upsert` request.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getBatchUpsertMaxObjectsPerBatch() {
        return OptionalNullable.getFrom(batchUpsertMaxObjectsPerBatch);
    }

    /**
     * Internal Getter for BatchUpsertMaxTotalObjects.
     * The maximum number of objects that may appear across all batches in a
     * `/v2/catalog/batch-upsert` request.
     * @return Returns the Internal Integer
     */
    @JsonGetter("batch_upsert_max_total_objects")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetBatchUpsertMaxTotalObjects() {
        return this.batchUpsertMaxTotalObjects;
    }

    /**
     * Getter for BatchUpsertMaxTotalObjects.
     * The maximum number of objects that may appear across all batches in a
     * `/v2/catalog/batch-upsert` request.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getBatchUpsertMaxTotalObjects() {
        return OptionalNullable.getFrom(batchUpsertMaxTotalObjects);
    }

    /**
     * Internal Getter for BatchRetrieveMaxObjectIds.
     * The maximum number of object IDs that may appear in a `/v2/catalog/batch-retrieve` request.
     * @return Returns the Internal Integer
     */
    @JsonGetter("batch_retrieve_max_object_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetBatchRetrieveMaxObjectIds() {
        return this.batchRetrieveMaxObjectIds;
    }

    /**
     * Getter for BatchRetrieveMaxObjectIds.
     * The maximum number of object IDs that may appear in a `/v2/catalog/batch-retrieve` request.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getBatchRetrieveMaxObjectIds() {
        return OptionalNullable.getFrom(batchRetrieveMaxObjectIds);
    }

    /**
     * Internal Getter for SearchMaxPageLimit.
     * The maximum number of results that may be returned in a page of a `/v2/catalog/search`
     * response.
     * @return Returns the Internal Integer
     */
    @JsonGetter("search_max_page_limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetSearchMaxPageLimit() {
        return this.searchMaxPageLimit;
    }

    /**
     * Getter for SearchMaxPageLimit.
     * The maximum number of results that may be returned in a page of a `/v2/catalog/search`
     * response.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getSearchMaxPageLimit() {
        return OptionalNullable.getFrom(searchMaxPageLimit);
    }

    /**
     * Internal Getter for BatchDeleteMaxObjectIds.
     * The maximum number of object IDs that may be included in a single `/v2/catalog/batch-delete`
     * request.
     * @return Returns the Internal Integer
     */
    @JsonGetter("batch_delete_max_object_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetBatchDeleteMaxObjectIds() {
        return this.batchDeleteMaxObjectIds;
    }

    /**
     * Getter for BatchDeleteMaxObjectIds.
     * The maximum number of object IDs that may be included in a single `/v2/catalog/batch-delete`
     * request.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getBatchDeleteMaxObjectIds() {
        return OptionalNullable.getFrom(batchDeleteMaxObjectIds);
    }

    /**
     * Internal Getter for UpdateItemTaxesMaxItemIds.
     * The maximum number of item IDs that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     * @return Returns the Internal Integer
     */
    @JsonGetter("update_item_taxes_max_item_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetUpdateItemTaxesMaxItemIds() {
        return this.updateItemTaxesMaxItemIds;
    }

    /**
     * Getter for UpdateItemTaxesMaxItemIds.
     * The maximum number of item IDs that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getUpdateItemTaxesMaxItemIds() {
        return OptionalNullable.getFrom(updateItemTaxesMaxItemIds);
    }

    /**
     * Internal Getter for UpdateItemTaxesMaxTaxesToEnable.
     * The maximum number of tax IDs to be enabled that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     * @return Returns the Internal Integer
     */
    @JsonGetter("update_item_taxes_max_taxes_to_enable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetUpdateItemTaxesMaxTaxesToEnable() {
        return this.updateItemTaxesMaxTaxesToEnable;
    }

    /**
     * Getter for UpdateItemTaxesMaxTaxesToEnable.
     * The maximum number of tax IDs to be enabled that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getUpdateItemTaxesMaxTaxesToEnable() {
        return OptionalNullable.getFrom(updateItemTaxesMaxTaxesToEnable);
    }

    /**
     * Internal Getter for UpdateItemTaxesMaxTaxesToDisable.
     * The maximum number of tax IDs to be disabled that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     * @return Returns the Internal Integer
     */
    @JsonGetter("update_item_taxes_max_taxes_to_disable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetUpdateItemTaxesMaxTaxesToDisable() {
        return this.updateItemTaxesMaxTaxesToDisable;
    }

    /**
     * Getter for UpdateItemTaxesMaxTaxesToDisable.
     * The maximum number of tax IDs to be disabled that may be included in a single
     * `/v2/catalog/update-item-taxes` request.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getUpdateItemTaxesMaxTaxesToDisable() {
        return OptionalNullable.getFrom(updateItemTaxesMaxTaxesToDisable);
    }

    /**
     * Internal Getter for UpdateItemModifierListsMaxItemIds.
     * The maximum number of item IDs that may be included in a single
     * `/v2/catalog/update-item-modifier-lists` request.
     * @return Returns the Internal Integer
     */
    @JsonGetter("update_item_modifier_lists_max_item_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetUpdateItemModifierListsMaxItemIds() {
        return this.updateItemModifierListsMaxItemIds;
    }

    /**
     * Getter for UpdateItemModifierListsMaxItemIds.
     * The maximum number of item IDs that may be included in a single
     * `/v2/catalog/update-item-modifier-lists` request.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getUpdateItemModifierListsMaxItemIds() {
        return OptionalNullable.getFrom(updateItemModifierListsMaxItemIds);
    }

    /**
     * Internal Getter for UpdateItemModifierListsMaxModifierListsToEnable.
     * The maximum number of modifier list IDs to be enabled that may be included in a single
     * `/v2/catalog/update-item-modifier-lists` request.
     * @return Returns the Internal Integer
     */
    @JsonGetter("update_item_modifier_lists_max_modifier_lists_to_enable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetUpdateItemModifierListsMaxModifierListsToEnable() {
        return this.updateItemModifierListsMaxModifierListsToEnable;
    }

    /**
     * Getter for UpdateItemModifierListsMaxModifierListsToEnable.
     * The maximum number of modifier list IDs to be enabled that may be included in a single
     * `/v2/catalog/update-item-modifier-lists` request.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getUpdateItemModifierListsMaxModifierListsToEnable() {
        return OptionalNullable.getFrom(updateItemModifierListsMaxModifierListsToEnable);
    }

    /**
     * Internal Getter for UpdateItemModifierListsMaxModifierListsToDisable.
     * The maximum number of modifier list IDs to be disabled that may be included in a single
     * `/v2/catalog/update-item-modifier-lists` request.
     * @return Returns the Internal Integer
     */
    @JsonGetter("update_item_modifier_lists_max_modifier_lists_to_disable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetUpdateItemModifierListsMaxModifierListsToDisable() {
        return this.updateItemModifierListsMaxModifierListsToDisable;
    }

    /**
     * Getter for UpdateItemModifierListsMaxModifierListsToDisable.
     * The maximum number of modifier list IDs to be disabled that may be included in a single
     * `/v2/catalog/update-item-modifier-lists` request.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getUpdateItemModifierListsMaxModifierListsToDisable() {
        return OptionalNullable.getFrom(updateItemModifierListsMaxModifierListsToDisable);
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
     * Converts this CatalogInfoResponseLimits into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogInfoResponseLimits [" + "batchUpsertMaxObjectsPerBatch="
                + batchUpsertMaxObjectsPerBatch + ", batchUpsertMaxTotalObjects="
                + batchUpsertMaxTotalObjects + ", batchRetrieveMaxObjectIds="
                + batchRetrieveMaxObjectIds + ", searchMaxPageLimit=" + searchMaxPageLimit
                + ", batchDeleteMaxObjectIds=" + batchDeleteMaxObjectIds
                + ", updateItemTaxesMaxItemIds=" + updateItemTaxesMaxItemIds
                + ", updateItemTaxesMaxTaxesToEnable=" + updateItemTaxesMaxTaxesToEnable
                + ", updateItemTaxesMaxTaxesToDisable=" + updateItemTaxesMaxTaxesToDisable
                + ", updateItemModifierListsMaxItemIds=" + updateItemModifierListsMaxItemIds
                + ", updateItemModifierListsMaxModifierListsToEnable="
                + updateItemModifierListsMaxModifierListsToEnable
                + ", updateItemModifierListsMaxModifierListsToDisable="
                + updateItemModifierListsMaxModifierListsToDisable + "]";
    }

    /**
     * Builds a new {@link CatalogInfoResponseLimits.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogInfoResponseLimits.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.batchUpsertMaxObjectsPerBatch = internalGetBatchUpsertMaxObjectsPerBatch();
        builder.batchUpsertMaxTotalObjects = internalGetBatchUpsertMaxTotalObjects();
        builder.batchRetrieveMaxObjectIds = internalGetBatchRetrieveMaxObjectIds();
        builder.searchMaxPageLimit = internalGetSearchMaxPageLimit();
        builder.batchDeleteMaxObjectIds = internalGetBatchDeleteMaxObjectIds();
        builder.updateItemTaxesMaxItemIds = internalGetUpdateItemTaxesMaxItemIds();
        builder.updateItemTaxesMaxTaxesToEnable = internalGetUpdateItemTaxesMaxTaxesToEnable();
        builder.updateItemTaxesMaxTaxesToDisable = internalGetUpdateItemTaxesMaxTaxesToDisable();
        builder.updateItemModifierListsMaxItemIds = internalGetUpdateItemModifierListsMaxItemIds();
        builder.updateItemModifierListsMaxModifierListsToEnable =
                internalGetUpdateItemModifierListsMaxModifierListsToEnable();
        builder.updateItemModifierListsMaxModifierListsToDisable =
                internalGetUpdateItemModifierListsMaxModifierListsToDisable();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogInfoResponseLimits}.
     */
    public static class Builder {
        private OptionalNullable<Integer> batchUpsertMaxObjectsPerBatch;
        private OptionalNullable<Integer> batchUpsertMaxTotalObjects;
        private OptionalNullable<Integer> batchRetrieveMaxObjectIds;
        private OptionalNullable<Integer> searchMaxPageLimit;
        private OptionalNullable<Integer> batchDeleteMaxObjectIds;
        private OptionalNullable<Integer> updateItemTaxesMaxItemIds;
        private OptionalNullable<Integer> updateItemTaxesMaxTaxesToEnable;
        private OptionalNullable<Integer> updateItemTaxesMaxTaxesToDisable;
        private OptionalNullable<Integer> updateItemModifierListsMaxItemIds;
        private OptionalNullable<Integer> updateItemModifierListsMaxModifierListsToEnable;
        private OptionalNullable<Integer> updateItemModifierListsMaxModifierListsToDisable;



        /**
         * Setter for batchUpsertMaxObjectsPerBatch.
         * @param  batchUpsertMaxObjectsPerBatch  Integer value for batchUpsertMaxObjectsPerBatch.
         * @return Builder
         */
        public Builder batchUpsertMaxObjectsPerBatch(Integer batchUpsertMaxObjectsPerBatch) {
            this.batchUpsertMaxObjectsPerBatch = OptionalNullable.of(batchUpsertMaxObjectsPerBatch);
            return this;
        }

        /**
         * UnSetter for batchUpsertMaxObjectsPerBatch.
         * @return Builder
         */
        public Builder unsetBatchUpsertMaxObjectsPerBatch() {
            batchUpsertMaxObjectsPerBatch = null;
            return this;
        }

        /**
         * Setter for batchUpsertMaxTotalObjects.
         * @param  batchUpsertMaxTotalObjects  Integer value for batchUpsertMaxTotalObjects.
         * @return Builder
         */
        public Builder batchUpsertMaxTotalObjects(Integer batchUpsertMaxTotalObjects) {
            this.batchUpsertMaxTotalObjects = OptionalNullable.of(batchUpsertMaxTotalObjects);
            return this;
        }

        /**
         * UnSetter for batchUpsertMaxTotalObjects.
         * @return Builder
         */
        public Builder unsetBatchUpsertMaxTotalObjects() {
            batchUpsertMaxTotalObjects = null;
            return this;
        }

        /**
         * Setter for batchRetrieveMaxObjectIds.
         * @param  batchRetrieveMaxObjectIds  Integer value for batchRetrieveMaxObjectIds.
         * @return Builder
         */
        public Builder batchRetrieveMaxObjectIds(Integer batchRetrieveMaxObjectIds) {
            this.batchRetrieveMaxObjectIds = OptionalNullable.of(batchRetrieveMaxObjectIds);
            return this;
        }

        /**
         * UnSetter for batchRetrieveMaxObjectIds.
         * @return Builder
         */
        public Builder unsetBatchRetrieveMaxObjectIds() {
            batchRetrieveMaxObjectIds = null;
            return this;
        }

        /**
         * Setter for searchMaxPageLimit.
         * @param  searchMaxPageLimit  Integer value for searchMaxPageLimit.
         * @return Builder
         */
        public Builder searchMaxPageLimit(Integer searchMaxPageLimit) {
            this.searchMaxPageLimit = OptionalNullable.of(searchMaxPageLimit);
            return this;
        }

        /**
         * UnSetter for searchMaxPageLimit.
         * @return Builder
         */
        public Builder unsetSearchMaxPageLimit() {
            searchMaxPageLimit = null;
            return this;
        }

        /**
         * Setter for batchDeleteMaxObjectIds.
         * @param  batchDeleteMaxObjectIds  Integer value for batchDeleteMaxObjectIds.
         * @return Builder
         */
        public Builder batchDeleteMaxObjectIds(Integer batchDeleteMaxObjectIds) {
            this.batchDeleteMaxObjectIds = OptionalNullable.of(batchDeleteMaxObjectIds);
            return this;
        }

        /**
         * UnSetter for batchDeleteMaxObjectIds.
         * @return Builder
         */
        public Builder unsetBatchDeleteMaxObjectIds() {
            batchDeleteMaxObjectIds = null;
            return this;
        }

        /**
         * Setter for updateItemTaxesMaxItemIds.
         * @param  updateItemTaxesMaxItemIds  Integer value for updateItemTaxesMaxItemIds.
         * @return Builder
         */
        public Builder updateItemTaxesMaxItemIds(Integer updateItemTaxesMaxItemIds) {
            this.updateItemTaxesMaxItemIds = OptionalNullable.of(updateItemTaxesMaxItemIds);
            return this;
        }

        /**
         * UnSetter for updateItemTaxesMaxItemIds.
         * @return Builder
         */
        public Builder unsetUpdateItemTaxesMaxItemIds() {
            updateItemTaxesMaxItemIds = null;
            return this;
        }

        /**
         * Setter for updateItemTaxesMaxTaxesToEnable.
         * @param  updateItemTaxesMaxTaxesToEnable  Integer value for
         *         updateItemTaxesMaxTaxesToEnable.
         * @return Builder
         */
        public Builder updateItemTaxesMaxTaxesToEnable(Integer updateItemTaxesMaxTaxesToEnable) {
            this.updateItemTaxesMaxTaxesToEnable =
                    OptionalNullable.of(updateItemTaxesMaxTaxesToEnable);
            return this;
        }

        /**
         * UnSetter for updateItemTaxesMaxTaxesToEnable.
         * @return Builder
         */
        public Builder unsetUpdateItemTaxesMaxTaxesToEnable() {
            updateItemTaxesMaxTaxesToEnable = null;
            return this;
        }

        /**
         * Setter for updateItemTaxesMaxTaxesToDisable.
         * @param  updateItemTaxesMaxTaxesToDisable  Integer value for
         *         updateItemTaxesMaxTaxesToDisable.
         * @return Builder
         */
        public Builder updateItemTaxesMaxTaxesToDisable(
                Integer updateItemTaxesMaxTaxesToDisable) {
            this.updateItemTaxesMaxTaxesToDisable =
                    OptionalNullable.of(updateItemTaxesMaxTaxesToDisable);
            return this;
        }

        /**
         * UnSetter for updateItemTaxesMaxTaxesToDisable.
         * @return Builder
         */
        public Builder unsetUpdateItemTaxesMaxTaxesToDisable() {
            updateItemTaxesMaxTaxesToDisable = null;
            return this;
        }

        /**
         * Setter for updateItemModifierListsMaxItemIds.
         * @param  updateItemModifierListsMaxItemIds  Integer value for
         *         updateItemModifierListsMaxItemIds.
         * @return Builder
         */
        public Builder updateItemModifierListsMaxItemIds(
                Integer updateItemModifierListsMaxItemIds) {
            this.updateItemModifierListsMaxItemIds =
                    OptionalNullable.of(updateItemModifierListsMaxItemIds);
            return this;
        }

        /**
         * UnSetter for updateItemModifierListsMaxItemIds.
         * @return Builder
         */
        public Builder unsetUpdateItemModifierListsMaxItemIds() {
            updateItemModifierListsMaxItemIds = null;
            return this;
        }

        /**
         * Setter for updateItemModifierListsMaxModifierListsToEnable.
         * @param  updateItemModifierListsMaxModifierListsToEnable  Integer value for
         *         updateItemModifierListsMaxModifierListsToEnable.
         * @return Builder
         */
        public Builder updateItemModifierListsMaxModifierListsToEnable(
                Integer updateItemModifierListsMaxModifierListsToEnable) {
            this.updateItemModifierListsMaxModifierListsToEnable =
                    OptionalNullable.of(updateItemModifierListsMaxModifierListsToEnable);
            return this;
        }

        /**
         * UnSetter for updateItemModifierListsMaxModifierListsToEnable.
         * @return Builder
         */
        public Builder unsetUpdateItemModifierListsMaxModifierListsToEnable() {
            updateItemModifierListsMaxModifierListsToEnable = null;
            return this;
        }

        /**
         * Setter for updateItemModifierListsMaxModifierListsToDisable.
         * @param  updateItemModifierListsMaxModifierListsToDisable  Integer value for
         *         updateItemModifierListsMaxModifierListsToDisable.
         * @return Builder
         */
        public Builder updateItemModifierListsMaxModifierListsToDisable(
                Integer updateItemModifierListsMaxModifierListsToDisable) {
            this.updateItemModifierListsMaxModifierListsToDisable =
                    OptionalNullable.of(updateItemModifierListsMaxModifierListsToDisable);
            return this;
        }

        /**
         * UnSetter for updateItemModifierListsMaxModifierListsToDisable.
         * @return Builder
         */
        public Builder unsetUpdateItemModifierListsMaxModifierListsToDisable() {
            updateItemModifierListsMaxModifierListsToDisable = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogInfoResponseLimits} object using the set fields.
         * @return {@link CatalogInfoResponseLimits}
         */
        public CatalogInfoResponseLimits build() {
            return new CatalogInfoResponseLimits(batchUpsertMaxObjectsPerBatch,
                    batchUpsertMaxTotalObjects, batchRetrieveMaxObjectIds, searchMaxPageLimit,
                    batchDeleteMaxObjectIds, updateItemTaxesMaxItemIds,
                    updateItemTaxesMaxTaxesToEnable, updateItemTaxesMaxTaxesToDisable,
                    updateItemModifierListsMaxItemIds,
                    updateItemModifierListsMaxModifierListsToEnable,
                    updateItemModifierListsMaxModifierListsToDisable);
        }
    }
}
