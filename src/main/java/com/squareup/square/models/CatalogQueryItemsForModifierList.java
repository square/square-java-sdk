package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQueryItemsForModifierList type.
 */
public class CatalogQueryItemsForModifierList {

    /**
     * Initialization constructor.
     * @param modifierListIds
     */
    @JsonCreator
    public CatalogQueryItemsForModifierList(
            @JsonProperty("modifier_list_ids") List<String> modifierListIds) {
        this.modifierListIds = modifierListIds;
    }

    private final List<String> modifierListIds;
    /**
     * Getter for ModifierListIds.
     * A set of `CatalogModifierList` IDs to be used to find associated `CatalogItem`s.
     */
    @JsonGetter("modifier_list_ids")
    public List<String> getModifierListIds() {
        return this.modifierListIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(modifierListIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQueryItemsForModifierList)) {
            return false;
        }
        CatalogQueryItemsForModifierList catalogQueryItemsForModifierList = (CatalogQueryItemsForModifierList) obj;
        return Objects.equals(modifierListIds, catalogQueryItemsForModifierList.modifierListIds);
    }

    /**
     * Builds a new {@link CatalogQueryItemsForModifierList.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryItemsForModifierList.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(modifierListIds);
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryItemsForModifierList}
     */
    public static class Builder {
        private List<String> modifierListIds;

        /**
         * Initialization constructor
         */
        public Builder(List<String> modifierListIds) {
            this.modifierListIds = modifierListIds;
        }

        /**
         * Setter for modifierListIds
         * @param modifierListIds
         * @return Builder
         */
        public Builder modifierListIds(List<String> modifierListIds) {
            this.modifierListIds = modifierListIds;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryItemsForModifierList} object using the set fields.
         * @return {@link CatalogQueryItemsForModifierList}
         */
        public CatalogQueryItemsForModifierList build() {
            return new CatalogQueryItemsForModifierList(modifierListIds);
        }
    }
}
