
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for CatalogQueryItemsForModifierList type.
 */
public class CatalogQueryItemsForModifierList {
    private final List<String> modifierListIds;

    /**
     * Initialization constructor.
     * @param modifierListIds List of String value for modifierListIds.
     */
    @JsonCreator
    public CatalogQueryItemsForModifierList(
            @JsonProperty("modifier_list_ids") List<String> modifierListIds) {
        this.modifierListIds = modifierListIds;
    }

    /**
     * Getter for ModifierListIds.
     * A set of `CatalogModifierList` IDs to be used to find associated `CatalogItem`s.
     * @return Returns the List of String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogQueryItemsForModifierList)) {
            return false;
        }
        CatalogQueryItemsForModifierList other = (CatalogQueryItemsForModifierList) obj;
        return Objects.equals(modifierListIds, other.modifierListIds);
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
     * Class to build instances of {@link CatalogQueryItemsForModifierList}.
     */
    public static class Builder {
        private List<String> modifierListIds;

        /**
         * Initialization constructor.
         * @param modifierListIds List of String value for modifierListIds.
         */
        public Builder(List<String> modifierListIds) {
            this.modifierListIds = modifierListIds;
        }

        /**
         * Setter for modifierListIds.
         * @param modifierListIds List of String value for modifierListIds.
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
