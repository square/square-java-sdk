/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogModifierList.Builder.class)
public final class CatalogModifierList {
    private final Optional<String> name;

    private final Optional<Integer> ordinal;

    private final Optional<CatalogModifierListSelectionType> selectionType;

    private final Optional<List<CatalogObject>> modifiers;

    private final Optional<List<String>> imageIds;

    private final Optional<Boolean> allowQuantities;

    private final Optional<Boolean> isConversational;

    private final Optional<CatalogModifierListModifierType> modifierType;

    private final Optional<Integer> maxLength;

    private final Optional<Boolean> textRequired;

    private final Optional<String> internalName;

    private final Optional<Long> minSelectedModifiers;

    private final Optional<Long> maxSelectedModifiers;

    private final Optional<Boolean> hiddenFromCustomer;

    private final Map<String, Object> additionalProperties;

    private CatalogModifierList(
            Optional<String> name,
            Optional<Integer> ordinal,
            Optional<CatalogModifierListSelectionType> selectionType,
            Optional<List<CatalogObject>> modifiers,
            Optional<List<String>> imageIds,
            Optional<Boolean> allowQuantities,
            Optional<Boolean> isConversational,
            Optional<CatalogModifierListModifierType> modifierType,
            Optional<Integer> maxLength,
            Optional<Boolean> textRequired,
            Optional<String> internalName,
            Optional<Long> minSelectedModifiers,
            Optional<Long> maxSelectedModifiers,
            Optional<Boolean> hiddenFromCustomer,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.ordinal = ordinal;
        this.selectionType = selectionType;
        this.modifiers = modifiers;
        this.imageIds = imageIds;
        this.allowQuantities = allowQuantities;
        this.isConversational = isConversational;
        this.modifierType = modifierType;
        this.maxLength = maxLength;
        this.textRequired = textRequired;
        this.internalName = internalName;
        this.minSelectedModifiers = minSelectedModifiers;
        this.maxSelectedModifiers = maxSelectedModifiers;
        this.hiddenFromCustomer = hiddenFromCustomer;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The name of the <code>CatalogModifierList</code> instance. This is a searchable attribute for use in applicable query filters, and its value length is of
     * Unicode code points.
     */
    @JsonIgnore
    public Optional<String> getName() {
        if (name == null) {
            return Optional.empty();
        }
        return name;
    }

    /**
     * @return The position of this <code>CatalogModifierList</code> within a list of <code>CatalogModifierList</code> instances.
     */
    @JsonIgnore
    public Optional<Integer> getOrdinal() {
        if (ordinal == null) {
            return Optional.empty();
        }
        return ordinal;
    }

    /**
     * @return <strong>Deprecated</strong>: Indicates whether a single (<code>SINGLE</code>) modifier or multiple (<code>MULTIPLE</code>) modifiers can be selected. Use
     * <code>min_selected_modifiers</code> and <code>max_selected_modifiers</code> instead.
     * See <a href="#type-catalogmodifierlistselectiontype">CatalogModifierListSelectionType</a> for possible values
     */
    @JsonProperty("selection_type")
    public Optional<CatalogModifierListSelectionType> getSelectionType() {
        return selectionType;
    }

    /**
     * @return A non-empty list of <code>CatalogModifier</code> objects to be included in the <code>CatalogModifierList</code>,
     * for non text-based modifiers when the <code>modifier_type</code> attribute is <code>LIST</code>. Each element of this list
     * is a <code>CatalogObject</code> instance of the <code>MODIFIER</code> type, containing the following attributes:
     * <pre><code>{
     * &quot;id&quot;: &quot;{{catalog_modifier_id}}&quot;,
     * &quot;type&quot;: &quot;MODIFIER&quot;,
     * &quot;modifier_data&quot;: {{a CatalogModifier instance&gt;}}
     * }
     * </code></pre>
     */
    @JsonIgnore
    public Optional<List<CatalogObject>> getModifiers() {
        if (modifiers == null) {
            return Optional.empty();
        }
        return modifiers;
    }

    /**
     * @return The IDs of images associated with this <code>CatalogModifierList</code> instance.
     * Currently these images are not displayed on Square products, but may be displayed in 3rd-party applications.
     */
    @JsonIgnore
    public Optional<List<String>> getImageIds() {
        if (imageIds == null) {
            return Optional.empty();
        }
        return imageIds;
    }

    /**
     * @return When <code>true</code>, allows multiple quantities of the same modifier to be selected.
     */
    @JsonIgnore
    public Optional<Boolean> getAllowQuantities() {
        if (allowQuantities == null) {
            return Optional.empty();
        }
        return allowQuantities;
    }

    /**
     * @return True if modifiers belonging to this list can be used conversationally.
     */
    @JsonIgnore
    public Optional<Boolean> getIsConversational() {
        if (isConversational == null) {
            return Optional.empty();
        }
        return isConversational;
    }

    /**
     * @return The type of the modifier.
     * <p>When this <code>modifier_type</code> value is <code>TEXT</code>,  the <code>CatalogModifierList</code> represents a text-based modifier.
     * When this <code>modifier_type</code> value is <code>LIST</code>, the <code>CatalogModifierList</code> contains a list of <code>CatalogModifier</code> objects.
     * See <a href="#type-catalogmodifierlistmodifiertype">CatalogModifierListModifierType</a> for possible values</p>
     */
    @JsonProperty("modifier_type")
    public Optional<CatalogModifierListModifierType> getModifierType() {
        return modifierType;
    }

    /**
     * @return The maximum length, in Unicode points, of the text string of the text-based modifier as represented by
     * this <code>CatalogModifierList</code> object with the <code>modifier_type</code> set to <code>TEXT</code>.
     */
    @JsonIgnore
    public Optional<Integer> getMaxLength() {
        if (maxLength == null) {
            return Optional.empty();
        }
        return maxLength;
    }

    /**
     * @return Whether the text string must be a non-empty string (<code>true</code>) or not (<code>false</code>) for a text-based modifier
     * as represented by this <code>CatalogModifierList</code> object with the <code>modifier_type</code> set to <code>TEXT</code>.
     */
    @JsonIgnore
    public Optional<Boolean> getTextRequired() {
        if (textRequired == null) {
            return Optional.empty();
        }
        return textRequired;
    }

    /**
     * @return A note for internal use by the business.
     * <p>For example, for a text-based modifier applied to a T-shirt item, if the buyer-supplied text of &quot;Hello, Kitty!&quot;
     * is to be printed on the T-shirt, this <code>internal_name</code> attribute can be &quot;Use italic face&quot; as
     * an instruction for the business to follow.</p>
     * <p>For non text-based modifiers, this <code>internal_name</code> attribute can be
     * used to include SKUs, internal codes, or supplemental descriptions for internal use.</p>
     */
    @JsonIgnore
    public Optional<String> getInternalName() {
        if (internalName == null) {
            return Optional.empty();
        }
        return internalName;
    }

    /**
     * @return The minimum number of modifiers that must be selected from this list. The value can be overridden with <code>CatalogItemModifierListInfo</code>.
     * <p>Values:</p>
     * <ul>
     * <li>0: No selection is required.</li>
     * <li>-1: Default value, the attribute was not set by the client. Treated as no selection required.</li>
     * <li>&gt;0: The required minimum modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
     * <li>&lt; -1: Invalid. Treated as no selection required.</li>
     * </ul>
     */
    @JsonIgnore
    public Optional<Long> getMinSelectedModifiers() {
        if (minSelectedModifiers == null) {
            return Optional.empty();
        }
        return minSelectedModifiers;
    }

    /**
     * @return The maximum number of modifiers that must be selected from this list. The value can be overridden with <code>CatalogItemModifierListInfo</code>.
     * <p>Values:</p>
     * <ul>
     * <li>0: No maximum limit.</li>
     * <li>-1: Default value, the attribute was not set by the client. Treated as no maximum limit.</li>
     * <li>&gt;0: The maximum total modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
     * <li>&lt; -1: Invalid. Treated as no maximum limit.</li>
     * </ul>
     */
    @JsonIgnore
    public Optional<Long> getMaxSelectedModifiers() {
        if (maxSelectedModifiers == null) {
            return Optional.empty();
        }
        return maxSelectedModifiers;
    }

    /**
     * @return If <code>true</code>, modifiers from this list are hidden from customer receipts. The default value is <code>false</code>.
     * This setting can be overridden with <code>CatalogItemModifierListInfo.hidden_from_customer_override</code>.
     */
    @JsonIgnore
    public Optional<Boolean> getHiddenFromCustomer() {
        if (hiddenFromCustomer == null) {
            return Optional.empty();
        }
        return hiddenFromCustomer;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("name")
    private Optional<String> _getName() {
        return name;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("ordinal")
    private Optional<Integer> _getOrdinal() {
        return ordinal;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("modifiers")
    private Optional<List<CatalogObject>> _getModifiers() {
        return modifiers;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("image_ids")
    private Optional<List<String>> _getImageIds() {
        return imageIds;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("allow_quantities")
    private Optional<Boolean> _getAllowQuantities() {
        return allowQuantities;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("is_conversational")
    private Optional<Boolean> _getIsConversational() {
        return isConversational;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("max_length")
    private Optional<Integer> _getMaxLength() {
        return maxLength;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("text_required")
    private Optional<Boolean> _getTextRequired() {
        return textRequired;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("internal_name")
    private Optional<String> _getInternalName() {
        return internalName;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("min_selected_modifiers")
    private Optional<Long> _getMinSelectedModifiers() {
        return minSelectedModifiers;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("max_selected_modifiers")
    private Optional<Long> _getMaxSelectedModifiers() {
        return maxSelectedModifiers;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("hidden_from_customer")
    private Optional<Boolean> _getHiddenFromCustomer() {
        return hiddenFromCustomer;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogModifierList && equalTo((CatalogModifierList) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogModifierList other) {
        return name.equals(other.name)
                && ordinal.equals(other.ordinal)
                && selectionType.equals(other.selectionType)
                && modifiers.equals(other.modifiers)
                && imageIds.equals(other.imageIds)
                && allowQuantities.equals(other.allowQuantities)
                && isConversational.equals(other.isConversational)
                && modifierType.equals(other.modifierType)
                && maxLength.equals(other.maxLength)
                && textRequired.equals(other.textRequired)
                && internalName.equals(other.internalName)
                && minSelectedModifiers.equals(other.minSelectedModifiers)
                && maxSelectedModifiers.equals(other.maxSelectedModifiers)
                && hiddenFromCustomer.equals(other.hiddenFromCustomer);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.name,
                this.ordinal,
                this.selectionType,
                this.modifiers,
                this.imageIds,
                this.allowQuantities,
                this.isConversational,
                this.modifierType,
                this.maxLength,
                this.textRequired,
                this.internalName,
                this.minSelectedModifiers,
                this.maxSelectedModifiers,
                this.hiddenFromCustomer);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> name = Optional.empty();

        private Optional<Integer> ordinal = Optional.empty();

        private Optional<CatalogModifierListSelectionType> selectionType = Optional.empty();

        private Optional<List<CatalogObject>> modifiers = Optional.empty();

        private Optional<List<String>> imageIds = Optional.empty();

        private Optional<Boolean> allowQuantities = Optional.empty();

        private Optional<Boolean> isConversational = Optional.empty();

        private Optional<CatalogModifierListModifierType> modifierType = Optional.empty();

        private Optional<Integer> maxLength = Optional.empty();

        private Optional<Boolean> textRequired = Optional.empty();

        private Optional<String> internalName = Optional.empty();

        private Optional<Long> minSelectedModifiers = Optional.empty();

        private Optional<Long> maxSelectedModifiers = Optional.empty();

        private Optional<Boolean> hiddenFromCustomer = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CatalogModifierList other) {
            name(other.getName());
            ordinal(other.getOrdinal());
            selectionType(other.getSelectionType());
            modifiers(other.getModifiers());
            imageIds(other.getImageIds());
            allowQuantities(other.getAllowQuantities());
            isConversational(other.getIsConversational());
            modifierType(other.getModifierType());
            maxLength(other.getMaxLength());
            textRequired(other.getTextRequired());
            internalName(other.getInternalName());
            minSelectedModifiers(other.getMinSelectedModifiers());
            maxSelectedModifiers(other.getMaxSelectedModifiers());
            hiddenFromCustomer(other.getHiddenFromCustomer());
            return this;
        }

        /**
         * <p>The name of the <code>CatalogModifierList</code> instance. This is a searchable attribute for use in applicable query filters, and its value length is of
         * Unicode code points.</p>
         */
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        public Builder name(Nullable<String> name) {
            if (name.isNull()) {
                this.name = null;
            } else if (name.isEmpty()) {
                this.name = Optional.empty();
            } else {
                this.name = Optional.of(name.get());
            }
            return this;
        }

        /**
         * <p>The position of this <code>CatalogModifierList</code> within a list of <code>CatalogModifierList</code> instances.</p>
         */
        @JsonSetter(value = "ordinal", nulls = Nulls.SKIP)
        public Builder ordinal(Optional<Integer> ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        public Builder ordinal(Integer ordinal) {
            this.ordinal = Optional.ofNullable(ordinal);
            return this;
        }

        public Builder ordinal(Nullable<Integer> ordinal) {
            if (ordinal.isNull()) {
                this.ordinal = null;
            } else if (ordinal.isEmpty()) {
                this.ordinal = Optional.empty();
            } else {
                this.ordinal = Optional.of(ordinal.get());
            }
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>: Indicates whether a single (<code>SINGLE</code>) modifier or multiple (<code>MULTIPLE</code>) modifiers can be selected. Use
         * <code>min_selected_modifiers</code> and <code>max_selected_modifiers</code> instead.
         * See <a href="#type-catalogmodifierlistselectiontype">CatalogModifierListSelectionType</a> for possible values</p>
         */
        @JsonSetter(value = "selection_type", nulls = Nulls.SKIP)
        public Builder selectionType(Optional<CatalogModifierListSelectionType> selectionType) {
            this.selectionType = selectionType;
            return this;
        }

        public Builder selectionType(CatalogModifierListSelectionType selectionType) {
            this.selectionType = Optional.ofNullable(selectionType);
            return this;
        }

        /**
         * <p>A non-empty list of <code>CatalogModifier</code> objects to be included in the <code>CatalogModifierList</code>,
         * for non text-based modifiers when the <code>modifier_type</code> attribute is <code>LIST</code>. Each element of this list
         * is a <code>CatalogObject</code> instance of the <code>MODIFIER</code> type, containing the following attributes:</p>
         * <pre><code>{
         * &quot;id&quot;: &quot;{{catalog_modifier_id}}&quot;,
         * &quot;type&quot;: &quot;MODIFIER&quot;,
         * &quot;modifier_data&quot;: {{a CatalogModifier instance&gt;}}
         * }
         * </code></pre>
         */
        @JsonSetter(value = "modifiers", nulls = Nulls.SKIP)
        public Builder modifiers(Optional<List<CatalogObject>> modifiers) {
            this.modifiers = modifiers;
            return this;
        }

        public Builder modifiers(List<CatalogObject> modifiers) {
            this.modifiers = Optional.ofNullable(modifiers);
            return this;
        }

        public Builder modifiers(Nullable<List<CatalogObject>> modifiers) {
            if (modifiers.isNull()) {
                this.modifiers = null;
            } else if (modifiers.isEmpty()) {
                this.modifiers = Optional.empty();
            } else {
                this.modifiers = Optional.of(modifiers.get());
            }
            return this;
        }

        /**
         * <p>The IDs of images associated with this <code>CatalogModifierList</code> instance.
         * Currently these images are not displayed on Square products, but may be displayed in 3rd-party applications.</p>
         */
        @JsonSetter(value = "image_ids", nulls = Nulls.SKIP)
        public Builder imageIds(Optional<List<String>> imageIds) {
            this.imageIds = imageIds;
            return this;
        }

        public Builder imageIds(List<String> imageIds) {
            this.imageIds = Optional.ofNullable(imageIds);
            return this;
        }

        public Builder imageIds(Nullable<List<String>> imageIds) {
            if (imageIds.isNull()) {
                this.imageIds = null;
            } else if (imageIds.isEmpty()) {
                this.imageIds = Optional.empty();
            } else {
                this.imageIds = Optional.of(imageIds.get());
            }
            return this;
        }

        /**
         * <p>When <code>true</code>, allows multiple quantities of the same modifier to be selected.</p>
         */
        @JsonSetter(value = "allow_quantities", nulls = Nulls.SKIP)
        public Builder allowQuantities(Optional<Boolean> allowQuantities) {
            this.allowQuantities = allowQuantities;
            return this;
        }

        public Builder allowQuantities(Boolean allowQuantities) {
            this.allowQuantities = Optional.ofNullable(allowQuantities);
            return this;
        }

        public Builder allowQuantities(Nullable<Boolean> allowQuantities) {
            if (allowQuantities.isNull()) {
                this.allowQuantities = null;
            } else if (allowQuantities.isEmpty()) {
                this.allowQuantities = Optional.empty();
            } else {
                this.allowQuantities = Optional.of(allowQuantities.get());
            }
            return this;
        }

        /**
         * <p>True if modifiers belonging to this list can be used conversationally.</p>
         */
        @JsonSetter(value = "is_conversational", nulls = Nulls.SKIP)
        public Builder isConversational(Optional<Boolean> isConversational) {
            this.isConversational = isConversational;
            return this;
        }

        public Builder isConversational(Boolean isConversational) {
            this.isConversational = Optional.ofNullable(isConversational);
            return this;
        }

        public Builder isConversational(Nullable<Boolean> isConversational) {
            if (isConversational.isNull()) {
                this.isConversational = null;
            } else if (isConversational.isEmpty()) {
                this.isConversational = Optional.empty();
            } else {
                this.isConversational = Optional.of(isConversational.get());
            }
            return this;
        }

        /**
         * <p>The type of the modifier.</p>
         * <p>When this <code>modifier_type</code> value is <code>TEXT</code>,  the <code>CatalogModifierList</code> represents a text-based modifier.
         * When this <code>modifier_type</code> value is <code>LIST</code>, the <code>CatalogModifierList</code> contains a list of <code>CatalogModifier</code> objects.
         * See <a href="#type-catalogmodifierlistmodifiertype">CatalogModifierListModifierType</a> for possible values</p>
         */
        @JsonSetter(value = "modifier_type", nulls = Nulls.SKIP)
        public Builder modifierType(Optional<CatalogModifierListModifierType> modifierType) {
            this.modifierType = modifierType;
            return this;
        }

        public Builder modifierType(CatalogModifierListModifierType modifierType) {
            this.modifierType = Optional.ofNullable(modifierType);
            return this;
        }

        /**
         * <p>The maximum length, in Unicode points, of the text string of the text-based modifier as represented by
         * this <code>CatalogModifierList</code> object with the <code>modifier_type</code> set to <code>TEXT</code>.</p>
         */
        @JsonSetter(value = "max_length", nulls = Nulls.SKIP)
        public Builder maxLength(Optional<Integer> maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public Builder maxLength(Integer maxLength) {
            this.maxLength = Optional.ofNullable(maxLength);
            return this;
        }

        public Builder maxLength(Nullable<Integer> maxLength) {
            if (maxLength.isNull()) {
                this.maxLength = null;
            } else if (maxLength.isEmpty()) {
                this.maxLength = Optional.empty();
            } else {
                this.maxLength = Optional.of(maxLength.get());
            }
            return this;
        }

        /**
         * <p>Whether the text string must be a non-empty string (<code>true</code>) or not (<code>false</code>) for a text-based modifier
         * as represented by this <code>CatalogModifierList</code> object with the <code>modifier_type</code> set to <code>TEXT</code>.</p>
         */
        @JsonSetter(value = "text_required", nulls = Nulls.SKIP)
        public Builder textRequired(Optional<Boolean> textRequired) {
            this.textRequired = textRequired;
            return this;
        }

        public Builder textRequired(Boolean textRequired) {
            this.textRequired = Optional.ofNullable(textRequired);
            return this;
        }

        public Builder textRequired(Nullable<Boolean> textRequired) {
            if (textRequired.isNull()) {
                this.textRequired = null;
            } else if (textRequired.isEmpty()) {
                this.textRequired = Optional.empty();
            } else {
                this.textRequired = Optional.of(textRequired.get());
            }
            return this;
        }

        /**
         * <p>A note for internal use by the business.</p>
         * <p>For example, for a text-based modifier applied to a T-shirt item, if the buyer-supplied text of &quot;Hello, Kitty!&quot;
         * is to be printed on the T-shirt, this <code>internal_name</code> attribute can be &quot;Use italic face&quot; as
         * an instruction for the business to follow.</p>
         * <p>For non text-based modifiers, this <code>internal_name</code> attribute can be
         * used to include SKUs, internal codes, or supplemental descriptions for internal use.</p>
         */
        @JsonSetter(value = "internal_name", nulls = Nulls.SKIP)
        public Builder internalName(Optional<String> internalName) {
            this.internalName = internalName;
            return this;
        }

        public Builder internalName(String internalName) {
            this.internalName = Optional.ofNullable(internalName);
            return this;
        }

        public Builder internalName(Nullable<String> internalName) {
            if (internalName.isNull()) {
                this.internalName = null;
            } else if (internalName.isEmpty()) {
                this.internalName = Optional.empty();
            } else {
                this.internalName = Optional.of(internalName.get());
            }
            return this;
        }

        /**
         * <p>The minimum number of modifiers that must be selected from this list. The value can be overridden with <code>CatalogItemModifierListInfo</code>.</p>
         * <p>Values:</p>
         * <ul>
         * <li>0: No selection is required.</li>
         * <li>-1: Default value, the attribute was not set by the client. Treated as no selection required.</li>
         * <li>&gt;0: The required minimum modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
         * <li>&lt; -1: Invalid. Treated as no selection required.</li>
         * </ul>
         */
        @JsonSetter(value = "min_selected_modifiers", nulls = Nulls.SKIP)
        public Builder minSelectedModifiers(Optional<Long> minSelectedModifiers) {
            this.minSelectedModifiers = minSelectedModifiers;
            return this;
        }

        public Builder minSelectedModifiers(Long minSelectedModifiers) {
            this.minSelectedModifiers = Optional.ofNullable(minSelectedModifiers);
            return this;
        }

        public Builder minSelectedModifiers(Nullable<Long> minSelectedModifiers) {
            if (minSelectedModifiers.isNull()) {
                this.minSelectedModifiers = null;
            } else if (minSelectedModifiers.isEmpty()) {
                this.minSelectedModifiers = Optional.empty();
            } else {
                this.minSelectedModifiers = Optional.of(minSelectedModifiers.get());
            }
            return this;
        }

        /**
         * <p>The maximum number of modifiers that must be selected from this list. The value can be overridden with <code>CatalogItemModifierListInfo</code>.</p>
         * <p>Values:</p>
         * <ul>
         * <li>0: No maximum limit.</li>
         * <li>-1: Default value, the attribute was not set by the client. Treated as no maximum limit.</li>
         * <li>&gt;0: The maximum total modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
         * <li>&lt; -1: Invalid. Treated as no maximum limit.</li>
         * </ul>
         */
        @JsonSetter(value = "max_selected_modifiers", nulls = Nulls.SKIP)
        public Builder maxSelectedModifiers(Optional<Long> maxSelectedModifiers) {
            this.maxSelectedModifiers = maxSelectedModifiers;
            return this;
        }

        public Builder maxSelectedModifiers(Long maxSelectedModifiers) {
            this.maxSelectedModifiers = Optional.ofNullable(maxSelectedModifiers);
            return this;
        }

        public Builder maxSelectedModifiers(Nullable<Long> maxSelectedModifiers) {
            if (maxSelectedModifiers.isNull()) {
                this.maxSelectedModifiers = null;
            } else if (maxSelectedModifiers.isEmpty()) {
                this.maxSelectedModifiers = Optional.empty();
            } else {
                this.maxSelectedModifiers = Optional.of(maxSelectedModifiers.get());
            }
            return this;
        }

        /**
         * <p>If <code>true</code>, modifiers from this list are hidden from customer receipts. The default value is <code>false</code>.
         * This setting can be overridden with <code>CatalogItemModifierListInfo.hidden_from_customer_override</code>.</p>
         */
        @JsonSetter(value = "hidden_from_customer", nulls = Nulls.SKIP)
        public Builder hiddenFromCustomer(Optional<Boolean> hiddenFromCustomer) {
            this.hiddenFromCustomer = hiddenFromCustomer;
            return this;
        }

        public Builder hiddenFromCustomer(Boolean hiddenFromCustomer) {
            this.hiddenFromCustomer = Optional.ofNullable(hiddenFromCustomer);
            return this;
        }

        public Builder hiddenFromCustomer(Nullable<Boolean> hiddenFromCustomer) {
            if (hiddenFromCustomer.isNull()) {
                this.hiddenFromCustomer = null;
            } else if (hiddenFromCustomer.isEmpty()) {
                this.hiddenFromCustomer = Optional.empty();
            } else {
                this.hiddenFromCustomer = Optional.of(hiddenFromCustomer.get());
            }
            return this;
        }

        public CatalogModifierList build() {
            return new CatalogModifierList(
                    name,
                    ordinal,
                    selectionType,
                    modifiers,
                    imageIds,
                    allowQuantities,
                    isConversational,
                    modifierType,
                    maxLength,
                    textRequired,
                    internalName,
                    minSelectedModifiers,
                    maxSelectedModifiers,
                    hiddenFromCustomer,
                    additionalProperties);
        }
    }
}
