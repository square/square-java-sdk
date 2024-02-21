
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
    private final String modifierType;
    private final OptionalNullable<Integer> maxLength;
    private final OptionalNullable<Boolean> textRequired;
    private final OptionalNullable<String> internalName;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  ordinal  Integer value for ordinal.
     * @param  selectionType  String value for selectionType.
     * @param  modifiers  List of CatalogObject value for modifiers.
     * @param  imageIds  List of String value for imageIds.
     * @param  modifierType  String value for modifierType.
     * @param  maxLength  Integer value for maxLength.
     * @param  textRequired  Boolean value for textRequired.
     * @param  internalName  String value for internalName.
     */
    @JsonCreator
    public CatalogModifierList(
            @JsonProperty("name") String name,
            @JsonProperty("ordinal") Integer ordinal,
            @JsonProperty("selection_type") String selectionType,
            @JsonProperty("modifiers") List<CatalogObject> modifiers,
            @JsonProperty("image_ids") List<String> imageIds,
            @JsonProperty("modifier_type") String modifierType,
            @JsonProperty("max_length") Integer maxLength,
            @JsonProperty("text_required") Boolean textRequired,
            @JsonProperty("internal_name") String internalName) {
        this.name = OptionalNullable.of(name);
        this.ordinal = OptionalNullable.of(ordinal);
        this.selectionType = selectionType;
        this.modifiers = OptionalNullable.of(modifiers);
        this.imageIds = OptionalNullable.of(imageIds);
        this.modifierType = modifierType;
        this.maxLength = OptionalNullable.of(maxLength);
        this.textRequired = OptionalNullable.of(textRequired);
        this.internalName = OptionalNullable.of(internalName);
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  ordinal  Integer value for ordinal.
     * @param  selectionType  String value for selectionType.
     * @param  modifiers  List of CatalogObject value for modifiers.
     * @param  imageIds  List of String value for imageIds.
     * @param  modifierType  String value for modifierType.
     * @param  maxLength  Integer value for maxLength.
     * @param  textRequired  Boolean value for textRequired.
     * @param  internalName  String value for internalName.
     */

    protected CatalogModifierList(OptionalNullable<String> name, OptionalNullable<Integer> ordinal,
            String selectionType, OptionalNullable<List<CatalogObject>> modifiers,
            OptionalNullable<List<String>> imageIds, String modifierType,
            OptionalNullable<Integer> maxLength, OptionalNullable<Boolean> textRequired,
            OptionalNullable<String> internalName) {
        this.name = name;
        this.ordinal = ordinal;
        this.selectionType = selectionType;
        this.modifiers = modifiers;
        this.imageIds = imageIds;
        this.modifierType = modifierType;
        this.maxLength = maxLength;
        this.textRequired = textRequired;
        this.internalName = internalName;
    }

    /**
     * Internal Getter for Name.
     * The name of the `CatalogModifierList` instance. This is a searchable attribute for use in
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
     * The name of the `CatalogModifierList` instance. This is a searchable attribute for use in
     * applicable query filters, and its value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for Ordinal.
     * The position of this `CatalogModifierList` within a list of `CatalogModifierList` instances.
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
     * The position of this `CatalogModifierList` within a list of `CatalogModifierList` instances.
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
     * A non-empty list of `CatalogModifier` objects to be included in the `CatalogModifierList`,
     * for non text-based modifiers when the `modifier_type` attribute is `LIST`. Each element of
     * this list is a `CatalogObject` instance of the `MODIFIER` type, containing the following
     * attributes: ``` { "id": "{{catalog_modifier_id}}", "type": "MODIFIER", "modifier_data": {{a
     * CatalogModifier instance&gt;}} } ```
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
     * A non-empty list of `CatalogModifier` objects to be included in the `CatalogModifierList`,
     * for non text-based modifiers when the `modifier_type` attribute is `LIST`. Each element of
     * this list is a `CatalogObject` instance of the `MODIFIER` type, containing the following
     * attributes: ``` { "id": "{{catalog_modifier_id}}", "type": "MODIFIER", "modifier_data": {{a
     * CatalogModifier instance&gt;}} } ```
     * @return Returns the List of CatalogObject
     */
    @JsonIgnore
    public List<CatalogObject> getModifiers() {
        return OptionalNullable.getFrom(modifiers);
    }

    /**
     * Internal Getter for ImageIds.
     * The IDs of images associated with this `CatalogModifierList` instance. Currently these images
     * are not displayed on Square products, but may be displayed in 3rd-party applications.
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
     * are not displayed on Square products, but may be displayed in 3rd-party applications.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getImageIds() {
        return OptionalNullable.getFrom(imageIds);
    }

    /**
     * Getter for ModifierType.
     * Defines the type of `CatalogModifierList`.
     * @return Returns the String
     */
    @JsonGetter("modifier_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getModifierType() {
        return modifierType;
    }

    /**
     * Internal Getter for MaxLength.
     * The maximum length, in Unicode points, of the text string of the text-based modifier as
     * represented by this `CatalogModifierList` object with the `modifier_type` set to `TEXT`.
     * @return Returns the Internal Integer
     */
    @JsonGetter("max_length")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetMaxLength() {
        return this.maxLength;
    }

    /**
     * Getter for MaxLength.
     * The maximum length, in Unicode points, of the text string of the text-based modifier as
     * represented by this `CatalogModifierList` object with the `modifier_type` set to `TEXT`.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getMaxLength() {
        return OptionalNullable.getFrom(maxLength);
    }

    /**
     * Internal Getter for TextRequired.
     * Whether the text string must be a non-empty string (`true`) or not (`false`) for a text-based
     * modifier as represented by this `CatalogModifierList` object with the `modifier_type` set to
     * `TEXT`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("text_required")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetTextRequired() {
        return this.textRequired;
    }

    /**
     * Getter for TextRequired.
     * Whether the text string must be a non-empty string (`true`) or not (`false`) for a text-based
     * modifier as represented by this `CatalogModifierList` object with the `modifier_type` set to
     * `TEXT`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getTextRequired() {
        return OptionalNullable.getFrom(textRequired);
    }

    /**
     * Internal Getter for InternalName.
     * A note for internal use by the business. For example, for a text-based modifier applied to a
     * T-shirt item, if the buyer-supplied text of "Hello, Kitty!" is to be printed on the T-shirt,
     * this `internal_name` attribute can be "Use italic face" as an instruction for the business to
     * follow. For non text-based modifiers, this `internal_name` attribute can be used to include
     * SKUs, internal codes, or supplemental descriptions for internal use.
     * @return Returns the Internal String
     */
    @JsonGetter("internal_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetInternalName() {
        return this.internalName;
    }

    /**
     * Getter for InternalName.
     * A note for internal use by the business. For example, for a text-based modifier applied to a
     * T-shirt item, if the buyer-supplied text of "Hello, Kitty!" is to be printed on the T-shirt,
     * this `internal_name` attribute can be "Use italic face" as an instruction for the business to
     * follow. For non text-based modifiers, this `internal_name` attribute can be used to include
     * SKUs, internal codes, or supplemental descriptions for internal use.
     * @return Returns the String
     */
    @JsonIgnore
    public String getInternalName() {
        return OptionalNullable.getFrom(internalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ordinal, selectionType, modifiers, imageIds, modifierType,
                maxLength, textRequired, internalName);
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
            && Objects.equals(imageIds, other.imageIds)
            && Objects.equals(modifierType, other.modifierType)
            && Objects.equals(maxLength, other.maxLength)
            && Objects.equals(textRequired, other.textRequired)
            && Objects.equals(internalName, other.internalName);
    }

    /**
     * Converts this CatalogModifierList into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogModifierList [" + "name=" + name + ", ordinal=" + ordinal
                + ", selectionType=" + selectionType + ", modifiers=" + modifiers + ", imageIds="
                + imageIds + ", modifierType=" + modifierType + ", maxLength=" + maxLength
                + ", textRequired=" + textRequired + ", internalName=" + internalName + "]";
    }

    /**
     * Builds a new {@link CatalogModifierList.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogModifierList.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .selectionType(getSelectionType())
                .modifierType(getModifierType());
        builder.name = internalGetName();
        builder.ordinal = internalGetOrdinal();
        builder.modifiers = internalGetModifiers();
        builder.imageIds = internalGetImageIds();
        builder.maxLength = internalGetMaxLength();
        builder.textRequired = internalGetTextRequired();
        builder.internalName = internalGetInternalName();
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
        private String modifierType;
        private OptionalNullable<Integer> maxLength;
        private OptionalNullable<Boolean> textRequired;
        private OptionalNullable<String> internalName;



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
         * Setter for modifierType.
         * @param  modifierType  String value for modifierType.
         * @return Builder
         */
        public Builder modifierType(String modifierType) {
            this.modifierType = modifierType;
            return this;
        }

        /**
         * Setter for maxLength.
         * @param  maxLength  Integer value for maxLength.
         * @return Builder
         */
        public Builder maxLength(Integer maxLength) {
            this.maxLength = OptionalNullable.of(maxLength);
            return this;
        }

        /**
         * UnSetter for maxLength.
         * @return Builder
         */
        public Builder unsetMaxLength() {
            maxLength = null;
            return this;
        }

        /**
         * Setter for textRequired.
         * @param  textRequired  Boolean value for textRequired.
         * @return Builder
         */
        public Builder textRequired(Boolean textRequired) {
            this.textRequired = OptionalNullable.of(textRequired);
            return this;
        }

        /**
         * UnSetter for textRequired.
         * @return Builder
         */
        public Builder unsetTextRequired() {
            textRequired = null;
            return this;
        }

        /**
         * Setter for internalName.
         * @param  internalName  String value for internalName.
         * @return Builder
         */
        public Builder internalName(String internalName) {
            this.internalName = OptionalNullable.of(internalName);
            return this;
        }

        /**
         * UnSetter for internalName.
         * @return Builder
         */
        public Builder unsetInternalName() {
            internalName = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogModifierList} object using the set fields.
         * @return {@link CatalogModifierList}
         */
        public CatalogModifierList build() {
            return new CatalogModifierList(name, ordinal, selectionType, modifiers, imageIds,
                    modifierType, maxLength, textRequired, internalName);
        }
    }
}
