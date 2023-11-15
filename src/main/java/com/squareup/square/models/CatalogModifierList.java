
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogModifierList type.
 */
public class CatalogModifierList {
    private final OptionalNullable<String> name;
    private final OptionalNullable<Integer> ordinal;
    private final String selectionType;
    private final OptionalNullable<List<CatalogObject>> modifiers;
    private final OptionalNullable<List<String>> imageIds;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  ordinal  Integer value for ordinal.
     * @param  selectionType  String value for selectionType.
     * @param  modifiers  List of CatalogObject value for modifiers.
     * @param  imageIds  List of String value for imageIds.
     */
    @JsonCreator
    public CatalogModifierList(
            @JsonProperty("name") String name,
            @JsonProperty("ordinal") Integer ordinal,
            @JsonProperty("selection_type") String selectionType,
            @JsonProperty("modifiers") List<CatalogObject> modifiers,
            @JsonProperty("image_ids") List<String> imageIds) {
        this.name = OptionalNullable.of(name);
        this.ordinal = OptionalNullable.of(ordinal);
        this.selectionType = selectionType;
        this.modifiers = OptionalNullable.of(modifiers);
        this.imageIds = OptionalNullable.of(imageIds);
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  ordinal  Integer value for ordinal.
     * @param  selectionType  String value for selectionType.
     * @param  modifiers  List of CatalogObject value for modifiers.
     * @param  imageIds  List of String value for imageIds.
     */

    protected CatalogModifierList(OptionalNullable<String> name, OptionalNullable<Integer> ordinal,
            String selectionType, OptionalNullable<List<CatalogObject>> modifiers,
            OptionalNullable<List<String>> imageIds) {
        this.name = name;
        this.ordinal = ordinal;
        this.selectionType = selectionType;
        this.modifiers = modifiers;
        this.imageIds = imageIds;
    }

    /**
     * Internal Getter for Name.
     * The name for the `CatalogModifierList` instance. This is a searchable attribute for use in
     * applicable query filters, and its value length is of Unicode code points.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * The name for the `CatalogModifierList` instance. This is a searchable attribute for use in
     * applicable query filters, and its value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for Ordinal.
     * Determines where this modifier list appears in a list of `CatalogModifierList` values.
     * @return Returns the Internal Integer
     */
    @JsonGetter("ordinal")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for Ordinal.
     * Determines where this modifier list appears in a list of `CatalogModifierList` values.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getOrdinal() {
        return OptionalNullable.getFrom(ordinal);
    }

    /**
     * Getter for SelectionType.
     * Indicates whether a CatalogModifierList supports multiple selections.
     * @return Returns the String
     */
    @JsonGetter("selection_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSelectionType() {
        return selectionType;
    }

    /**
     * Internal Getter for Modifiers.
     * The options included in the `CatalogModifierList`. You must include at least one
     * `CatalogModifier`. Each CatalogObject must have type `MODIFIER` and contain `CatalogModifier`
     * data.
     * @return Returns the Internal List of CatalogObject
     */
    @JsonGetter("modifiers")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogObject>> internalGetModifiers() {
        return this.modifiers;
    }

    /**
     * Getter for Modifiers.
     * The options included in the `CatalogModifierList`. You must include at least one
     * `CatalogModifier`. Each CatalogObject must have type `MODIFIER` and contain `CatalogModifier`
     * data.
     * @return Returns the List of CatalogObject
     */
    @JsonIgnore
    public List<CatalogObject> getModifiers() {
        return OptionalNullable.getFrom(modifiers);
    }

    /**
     * Internal Getter for ImageIds.
     * The IDs of images associated with this `CatalogModifierList` instance. Currently these images
     * are not displayed by Square, but are free to be displayed in 3rd party applications.
     * @return Returns the Internal List of String
     */
    @JsonGetter("image_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetImageIds() {
        return this.imageIds;
    }

    /**
     * Getter for ImageIds.
     * The IDs of images associated with this `CatalogModifierList` instance. Currently these images
     * are not displayed by Square, but are free to be displayed in 3rd party applications.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getImageIds() {
        return OptionalNullable.getFrom(imageIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ordinal, selectionType, modifiers, imageIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogModifierList)) {
            return false;
        }
        CatalogModifierList other = (CatalogModifierList) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(ordinal, other.ordinal)
            && Objects.equals(selectionType, other.selectionType)
            && Objects.equals(modifiers, other.modifiers)
            && Objects.equals(imageIds, other.imageIds);
    }

    /**
     * Converts this CatalogModifierList into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogModifierList [" + "name=" + name + ", ordinal=" + ordinal
                + ", selectionType=" + selectionType + ", modifiers=" + modifiers + ", imageIds="
                + imageIds + "]";
    }

    /**
     * Builds a new {@link CatalogModifierList.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogModifierList.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .selectionType(getSelectionType());
        builder.name = internalGetName();
        builder.ordinal = internalGetOrdinal();
        builder.modifiers = internalGetModifiers();
        builder.imageIds = internalGetImageIds();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogModifierList}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private OptionalNullable<Integer> ordinal;
        private String selectionType;
        private OptionalNullable<List<CatalogObject>> modifiers;
        private OptionalNullable<List<String>> imageIds;



        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for ordinal.
         * @param  ordinal  Integer value for ordinal.
         * @return Builder
         */
        public Builder ordinal(Integer ordinal) {
            this.ordinal = OptionalNullable.of(ordinal);
            return this;
        }

        /**
         * UnSetter for ordinal.
         * @return Builder
         */
        public Builder unsetOrdinal() {
            ordinal = null;
            return this;
        }

        /**
         * Setter for selectionType.
         * @param  selectionType  String value for selectionType.
         * @return Builder
         */
        public Builder selectionType(String selectionType) {
            this.selectionType = selectionType;
            return this;
        }

        /**
         * Setter for modifiers.
         * @param  modifiers  List of CatalogObject value for modifiers.
         * @return Builder
         */
        public Builder modifiers(List<CatalogObject> modifiers) {
            this.modifiers = OptionalNullable.of(modifiers);
            return this;
        }

        /**
         * UnSetter for modifiers.
         * @return Builder
         */
        public Builder unsetModifiers() {
            modifiers = null;
            return this;
        }

        /**
         * Setter for imageIds.
         * @param  imageIds  List of String value for imageIds.
         * @return Builder
         */
        public Builder imageIds(List<String> imageIds) {
            this.imageIds = OptionalNullable.of(imageIds);
            return this;
        }

        /**
         * UnSetter for imageIds.
         * @return Builder
         */
        public Builder unsetImageIds() {
            imageIds = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogModifierList} object using the set fields.
         * @return {@link CatalogModifierList}
         */
        public CatalogModifierList build() {
            return new CatalogModifierList(name, ordinal, selectionType, modifiers, imageIds);
        }
    }
}
