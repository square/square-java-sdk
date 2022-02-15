
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateItemModifierListsRequest type.
 */
public class UpdateItemModifierListsRequest {
    private final List<String> itemIds;
    private final List<String> modifierListsToEnable;
    private final List<String> modifierListsToDisable;

    /**
     * Initialization constructor.
     * @param  itemIds  List of String value for itemIds.
     * @param  modifierListsToEnable  List of String value for modifierListsToEnable.
     * @param  modifierListsToDisable  List of String value for modifierListsToDisable.
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

    /**
     * Getter for ItemIds.
     * The IDs of the catalog items associated with the CatalogModifierList objects being updated.
     * @return Returns the List of String
     */
    @JsonGetter("item_ids")
    public List<String> getItemIds() {
        return itemIds;
    }

    /**
     * Getter for ModifierListsToEnable.
     * The IDs of the CatalogModifierList objects to enable for the CatalogItem. At least one of
     * `modifier_lists_to_enable` or `modifier_lists_to_disable` must be specified.
     * @return Returns the List of String
     */
    @JsonGetter("modifier_lists_to_enable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getModifierListsToEnable() {
        return modifierListsToEnable;
    }

    /**
     * Getter for ModifierListsToDisable.
     * The IDs of the CatalogModifierList objects to disable for the CatalogItem. At least one of
     * `modifier_lists_to_enable` or `modifier_lists_to_disable` must be specified.
     * @return Returns the List of String
     */
    @JsonGetter("modifier_lists_to_disable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getModifierListsToDisable() {
        return modifierListsToDisable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemIds, modifierListsToEnable, modifierListsToDisable);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateItemModifierListsRequest)) {
            return false;
        }
        UpdateItemModifierListsRequest other = (UpdateItemModifierListsRequest) obj;
        return Objects.equals(itemIds, other.itemIds)
            && Objects.equals(modifierListsToEnable, other.modifierListsToEnable)
            && Objects.equals(modifierListsToDisable, other.modifierListsToDisable);
    }

    /**
     * Converts this UpdateItemModifierListsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateItemModifierListsRequest [" + "itemIds=" + itemIds
                + ", modifierListsToEnable=" + modifierListsToEnable + ", modifierListsToDisable="
                + modifierListsToDisable + "]";
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
     * Class to build instances of {@link UpdateItemModifierListsRequest}.
     */
    public static class Builder {
        private List<String> itemIds;
        private List<String> modifierListsToEnable;
        private List<String> modifierListsToDisable;

        /**
         * Initialization constructor.
         * @param  itemIds  List of String value for itemIds.
         */
        public Builder(List<String> itemIds) {
            this.itemIds = itemIds;
        }

        /**
         * Setter for itemIds.
         * @param  itemIds  List of String value for itemIds.
         * @return Builder
         */
        public Builder itemIds(List<String> itemIds) {
            this.itemIds = itemIds;
            return this;
        }

        /**
         * Setter for modifierListsToEnable.
         * @param  modifierListsToEnable  List of String value for modifierListsToEnable.
         * @return Builder
         */
        public Builder modifierListsToEnable(List<String> modifierListsToEnable) {
            this.modifierListsToEnable = modifierListsToEnable;
            return this;
        }

        /**
         * Setter for modifierListsToDisable.
         * @param  modifierListsToDisable  List of String value for modifierListsToDisable.
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
            return new UpdateItemModifierListsRequest(itemIds, modifierListsToEnable,
                    modifierListsToDisable);
        }
    }
}
