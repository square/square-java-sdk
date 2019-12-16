package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryItemsForModifierList {

    @JsonCreator
    public CatalogQueryItemsForModifierList(
            @JsonProperty("modifier_list_ids") List<String> modifierListIds) {
        this.modifierListIds = modifierListIds;
    }

    private final List<String> modifierListIds;

    @Override
    public int hashCode() {
        return Objects.hash(modifierListIds);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryItemsForModifierList)) {
            return false;
        }
        CatalogQueryItemsForModifierList catalogQueryItemsForModifierList = (CatalogQueryItemsForModifierList) o;
        return Objects.equals(modifierListIds, catalogQueryItemsForModifierList.modifierListIds);
    }

    /**
     * Getter for ModifierListIds.
     * A set of `CatalogModifierList` IDs to be used to find associated `CatalogItem`s.
     */
    @JsonGetter("modifier_list_ids")
    public List<String> getModifierListIds() { 
        return this.modifierListIds;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(modifierListIds);
            return builder;
    }

    public static class Builder {
        private List<String> modifierListIds;

        public Builder(List<String> modifierListIds) {
            this.modifierListIds = modifierListIds;
        }

        public Builder modifierListIds(List<String> value) {
            modifierListIds = value;
            return this;
        }

        public CatalogQueryItemsForModifierList build() {
            return new CatalogQueryItemsForModifierList(modifierListIds);
        }
    }
}
