package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpdateItemModifierListsRequest type.
 */
public class UpdateItemModifierListsRequest {

    /**
     * Initialization constructor.
     * @param itemIds
     * @param modifierListsToEnable
     * @param modifierListsToDisable
     */
    @JsonCreator
    public UpdateItemModifierListsRequest(
            @JsonProperty("item_ids") List<String> itemIds,
            @JsonProperty("modifier_lists_to_enable") List<String> modifierListsToEnable,
            @JsonProperty("modifier_lists_to_disable") List<String> modifierListsToDisable) {
        this.itemIds = itemIds;
        this.modifierListsToEnable = modifierListsToEnable;
        this.modifierListsToDisable = modifierListsToDisable;
    }

    private final List<String> itemIds;
    private final List<String> modifierListsToEnable;
    private final List<String> modifierListsToDisable;
    /**
     * Getter for ItemIds.
     * The IDs of the catalog items associated with the CatalogModifierList objects being updated.
     */
    @JsonGetter("item_ids")
    public List<String> getItemIds() {
        return this.itemIds;
    }

    /**
     * Getter for ModifierListsToEnable.
     * The IDs of the CatalogModifierList objects to enable for the CatalogItem.
     */
    @JsonGetter("modifier_lists_to_enable")
    public List<String> getModifierListsToEnable() {
        return this.modifierListsToEnable;
    }

    /**
     * Getter for ModifierListsToDisable.
     * The IDs of the CatalogModifierList objects to disable for the CatalogItem.
     */
    @JsonGetter("modifier_lists_to_disable")
    public List<String> getModifierListsToDisable() {
        return this.modifierListsToDisable;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(itemIds, modifierListsToEnable, modifierListsToDisable);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateItemModifierListsRequest)) {
            return false;
        }
        UpdateItemModifierListsRequest updateItemModifierListsRequest = (UpdateItemModifierListsRequest) obj;
        return Objects.equals(itemIds, updateItemModifierListsRequest.itemIds) &&
            Objects.equals(modifierListsToEnable, updateItemModifierListsRequest.modifierListsToEnable) &&
            Objects.equals(modifierListsToDisable, updateItemModifierListsRequest.modifierListsToDisable);
    }

    /**
     * Builds a new {@link UpdateItemModifierListsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateItemModifierListsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(itemIds)
            .modifierListsToEnable(getModifierListsToEnable())
            .modifierListsToDisable(getModifierListsToDisable());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateItemModifierListsRequest}
     */
    public static class Builder {
        private List<String> itemIds;
        private List<String> modifierListsToEnable;
        private List<String> modifierListsToDisable;

        /**
         * Initialization constructor
         */
        public Builder(List<String> itemIds) {
            this.itemIds = itemIds;
        }

        /**
         * Setter for itemIds
         * @param itemIds
         * @return Builder
         */
        public Builder itemIds(List<String> itemIds) {
            this.itemIds = itemIds;
            return this;
        }
        /**
         * Setter for modifierListsToEnable
         * @param modifierListsToEnable
         * @return Builder
         */
        public Builder modifierListsToEnable(List<String> modifierListsToEnable) {
            this.modifierListsToEnable = modifierListsToEnable;
            return this;
        }
        /**
         * Setter for modifierListsToDisable
         * @param modifierListsToDisable
         * @return Builder
         */
        public Builder modifierListsToDisable(List<String> modifierListsToDisable) {
            this.modifierListsToDisable = modifierListsToDisable;
            return this;
        }

        /**
         * Builds a new {@link UpdateItemModifierListsRequest} object using the set fields.
         * @return {@link UpdateItemModifierListsRequest}
         */
        public UpdateItemModifierListsRequest build() {
            return new UpdateItemModifierListsRequest(itemIds,
                modifierListsToEnable,
                modifierListsToDisable);
        }
    }
}
