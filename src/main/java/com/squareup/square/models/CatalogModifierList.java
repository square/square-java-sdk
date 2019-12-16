package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogModifierList {

    @JsonCreator
    public CatalogModifierList(
            @JsonProperty("name") String name,
            @JsonProperty("selection_type") String selectionType,
            @JsonProperty("modifiers") List<CatalogObject> modifiers) {
        this.name = name;
        this.selectionType = selectionType;
        this.modifiers = modifiers;
    }

    private final String name;
    private final String selectionType;
    private final List<CatalogObject> modifiers;

    @Override
    public int hashCode() {
        return Objects.hash(name, selectionType, modifiers);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogModifierList)) {
            return false;
        }
        CatalogModifierList catalogModifierList = (CatalogModifierList) o;
        return Objects.equals(name, catalogModifierList.name) &&
            Objects.equals(selectionType, catalogModifierList.selectionType) &&
            Objects.equals(modifiers, catalogModifierList.modifiers);
    }

    /**
     * Getter for Name.
     * A searchable name for the `CatalogModifierList`. This field has max length of 255 Unicode code points.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for SelectionType.
     * Indicates whether a CatalogModifierList supports multiple selections.
     */
    @JsonGetter("selection_type")
    public String getSelectionType() { 
        return this.selectionType;
    }

    /**
     * Getter for Modifiers.
     * The options included in the `CatalogModifierList`.
     * You must include at least one `CatalogModifier`.
     * Each CatalogObject must have type `MODIFIER` and contain
     * `CatalogModifier` data.
     */
    @JsonGetter("modifiers")
    public List<CatalogObject> getModifiers() { 
        return this.modifiers;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .selectionType(getSelectionType())
            .modifiers(getModifiers());
            return builder;
    }

    public static class Builder {
        private String name;
        private String selectionType;
        private List<CatalogObject> modifiers;

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder selectionType(String value) {
            selectionType = value;
            return this;
        }
        public Builder modifiers(List<CatalogObject> value) {
            modifiers = value;
            return this;
        }

        public CatalogModifierList build() {
            return new CatalogModifierList(name,
                selectionType,
                modifiers);
        }
    }
}
