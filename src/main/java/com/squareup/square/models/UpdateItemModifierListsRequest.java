package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class UpdateItemModifierListsRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(itemIds, modifierListsToEnable, modifierListsToDisable);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateItemModifierListsRequest)) {
            return false;
        }
        UpdateItemModifierListsRequest updateItemModifierListsRequest = (UpdateItemModifierListsRequest) o;
        return Objects.equals(itemIds, updateItemModifierListsRequest.itemIds) &&
            Objects.equals(modifierListsToEnable, updateItemModifierListsRequest.modifierListsToEnable) &&
            Objects.equals(modifierListsToDisable, updateItemModifierListsRequest.modifierListsToDisable);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder(itemIds)
            .modifierListsToEnable(getModifierListsToEnable())
            .modifierListsToDisable(getModifierListsToDisable());
            return builder;
    }

    public static class Builder {
        private List<String> itemIds;
        private List<String> modifierListsToEnable;
        private List<String> modifierListsToDisable;

        public Builder(List<String> itemIds) {
            this.itemIds = itemIds;
        }

        public Builder itemIds(List<String> value) {
            itemIds = value;
            return this;
        }
        public Builder modifierListsToEnable(List<String> value) {
            modifierListsToEnable = value;
            return this;
        }
        public Builder modifierListsToDisable(List<String> value) {
            modifierListsToDisable = value;
            return this;
        }

        public UpdateItemModifierListsRequest build() {
            return new UpdateItemModifierListsRequest(itemIds,
                modifierListsToEnable,
                modifierListsToDisable);
        }
    }
}
