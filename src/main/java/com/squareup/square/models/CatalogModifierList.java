package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogModifierList type.
 */
public class CatalogModifierList {

    /**
     * Initialization constructor.
     * @param name
     * @param selectionType
     * @param modifiers
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(name, selectionType, modifiers);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogModifierList)) {
            return false;
        }
        CatalogModifierList catalogModifierList = (CatalogModifierList) obj;
        return Objects.equals(name, catalogModifierList.name) &&
            Objects.equals(selectionType, catalogModifierList.selectionType) &&
            Objects.equals(modifiers, catalogModifierList.modifiers);
    }

    /**
     * Builds a new {@link CatalogModifierList.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogModifierList.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .selectionType(getSelectionType())
            .modifiers(getModifiers());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogModifierList}
     */
    public static class Builder {
        private String name;
        private String selectionType;
        private List<CatalogObject> modifiers;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for selectionType
         * @param selectionType
         * @return Builder
         */
        public Builder selectionType(String selectionType) {
            this.selectionType = selectionType;
            return this;
        }
        /**
         * Setter for modifiers
         * @param modifiers
         * @return Builder
         */
        public Builder modifiers(List<CatalogObject> modifiers) {
            this.modifiers = modifiers;
            return this;
        }

        /**
         * Builds a new {@link CatalogModifierList} object using the set fields.
         * @return {@link CatalogModifierList}
         */
        public CatalogModifierList build() {
            return new CatalogModifierList(name,
                selectionType,
                modifiers);
        }
    }
}
