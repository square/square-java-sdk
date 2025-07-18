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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogItemModifierListInfo.Builder.class)
public final class CatalogItemModifierListInfo {
    private final String modifierListId;

    private final Optional<List<CatalogModifierOverride>> modifierOverrides;

    private final Optional<Integer> minSelectedModifiers;

    private final Optional<Integer> maxSelectedModifiers;

    private final Optional<Boolean> enabled;

    private final Optional<Integer> ordinal;

    private final Optional<Object> allowQuantities;

    private final Optional<Object> isConversational;

    private final Optional<Object> hiddenFromCustomerOverride;

    private final Map<String, Object> additionalProperties;

    private CatalogItemModifierListInfo(
            String modifierListId,
            Optional<List<CatalogModifierOverride>> modifierOverrides,
            Optional<Integer> minSelectedModifiers,
            Optional<Integer> maxSelectedModifiers,
            Optional<Boolean> enabled,
            Optional<Integer> ordinal,
            Optional<Object> allowQuantities,
            Optional<Object> isConversational,
            Optional<Object> hiddenFromCustomerOverride,
            Map<String, Object> additionalProperties) {
        this.modifierListId = modifierListId;
        this.modifierOverrides = modifierOverrides;
        this.minSelectedModifiers = minSelectedModifiers;
        this.maxSelectedModifiers = maxSelectedModifiers;
        this.enabled = enabled;
        this.ordinal = ordinal;
        this.allowQuantities = allowQuantities;
        this.isConversational = isConversational;
        this.hiddenFromCustomerOverride = hiddenFromCustomerOverride;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the <code>CatalogModifierList</code> controlled by this <code>CatalogModifierListInfo</code>.
     */
    @JsonProperty("modifier_list_id")
    public String getModifierListId() {
        return modifierListId;
    }

    /**
     * @return A set of <code>CatalogModifierOverride</code> objects that override default modifier settings for this item.
     */
    @JsonIgnore
    public Optional<List<CatalogModifierOverride>> getModifierOverrides() {
        if (modifierOverrides == null) {
            return Optional.empty();
        }
        return modifierOverrides;
    }

    /**
     * @return The minimum number of modifiers that must be selected from this modifier list.
     * Values:
     * <ul>
     * <li>0: No selection is required.</li>
     * <li>-1: Default value, the attribute was not set by the client. When <code>max_selected_modifiers</code> is
     * also -1, use the minimum and maximum selection values set on the <code>CatalogItemModifierList</code>.</li>
     * <li>&gt;0: The required minimum modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
     * <li>&lt; -1: Invalid. Treated as no selection required.</li>
     * </ul>
     */
    @JsonIgnore
    public Optional<Integer> getMinSelectedModifiers() {
        if (minSelectedModifiers == null) {
            return Optional.empty();
        }
        return minSelectedModifiers;
    }

    /**
     * @return The maximum number of modifiers that can be selected.
     * Values:
     * <ul>
     * <li>0: No maximum limit.</li>
     * <li>-1: Default value, the attribute was not set by the client. When <code>min_selected_modifiers</code> is
     * also -1, use the minimum and maximum selection values set on the <code>CatalogItemModifierList</code>.</li>
     * <li>&gt;0: The maximum total modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
     * <li>&lt; -1: Invalid. Treated as no maximum limit.</li>
     * </ul>
     */
    @JsonIgnore
    public Optional<Integer> getMaxSelectedModifiers() {
        if (maxSelectedModifiers == null) {
            return Optional.empty();
        }
        return maxSelectedModifiers;
    }

    /**
     * @return If <code>true</code>, enable this <code>CatalogModifierList</code>. The default value is <code>true</code>.
     */
    @JsonIgnore
    public Optional<Boolean> getEnabled() {
        if (enabled == null) {
            return Optional.empty();
        }
        return enabled;
    }

    /**
     * @return The position of this <code>CatalogItemModifierListInfo</code> object within the <code>modifier_list_info</code> list applied
     * to a <code>CatalogItem</code> instance.
     */
    @JsonIgnore
    public Optional<Integer> getOrdinal() {
        if (ordinal == null) {
            return Optional.empty();
        }
        return ordinal;
    }

    @JsonProperty("allow_quantities")
    public Optional<Object> getAllowQuantities() {
        return allowQuantities;
    }

    @JsonProperty("is_conversational")
    public Optional<Object> getIsConversational() {
        return isConversational;
    }

    @JsonProperty("hidden_from_customer_override")
    public Optional<Object> getHiddenFromCustomerOverride() {
        return hiddenFromCustomerOverride;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("modifier_overrides")
    private Optional<List<CatalogModifierOverride>> _getModifierOverrides() {
        return modifierOverrides;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("min_selected_modifiers")
    private Optional<Integer> _getMinSelectedModifiers() {
        return minSelectedModifiers;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("max_selected_modifiers")
    private Optional<Integer> _getMaxSelectedModifiers() {
        return maxSelectedModifiers;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("enabled")
    private Optional<Boolean> _getEnabled() {
        return enabled;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("ordinal")
    private Optional<Integer> _getOrdinal() {
        return ordinal;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogItemModifierListInfo && equalTo((CatalogItemModifierListInfo) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogItemModifierListInfo other) {
        return modifierListId.equals(other.modifierListId)
                && modifierOverrides.equals(other.modifierOverrides)
                && minSelectedModifiers.equals(other.minSelectedModifiers)
                && maxSelectedModifiers.equals(other.maxSelectedModifiers)
                && enabled.equals(other.enabled)
                && ordinal.equals(other.ordinal)
                && allowQuantities.equals(other.allowQuantities)
                && isConversational.equals(other.isConversational)
                && hiddenFromCustomerOverride.equals(other.hiddenFromCustomerOverride);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.modifierListId,
                this.modifierOverrides,
                this.minSelectedModifiers,
                this.maxSelectedModifiers,
                this.enabled,
                this.ordinal,
                this.allowQuantities,
                this.isConversational,
                this.hiddenFromCustomerOverride);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModifierListIdStage builder() {
        return new Builder();
    }

    public interface ModifierListIdStage {
        /**
         * <p>The ID of the <code>CatalogModifierList</code> controlled by this <code>CatalogModifierListInfo</code>.</p>
         */
        _FinalStage modifierListId(@NotNull String modifierListId);

        Builder from(CatalogItemModifierListInfo other);
    }

    public interface _FinalStage {
        CatalogItemModifierListInfo build();

        /**
         * <p>A set of <code>CatalogModifierOverride</code> objects that override default modifier settings for this item.</p>
         */
        _FinalStage modifierOverrides(Optional<List<CatalogModifierOverride>> modifierOverrides);

        _FinalStage modifierOverrides(List<CatalogModifierOverride> modifierOverrides);

        _FinalStage modifierOverrides(Nullable<List<CatalogModifierOverride>> modifierOverrides);

        /**
         * <p>The minimum number of modifiers that must be selected from this modifier list.
         * Values:</p>
         * <ul>
         * <li>0: No selection is required.</li>
         * <li>-1: Default value, the attribute was not set by the client. When <code>max_selected_modifiers</code> is
         * also -1, use the minimum and maximum selection values set on the <code>CatalogItemModifierList</code>.</li>
         * <li>&gt;0: The required minimum modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
         * <li>&lt; -1: Invalid. Treated as no selection required.</li>
         * </ul>
         */
        _FinalStage minSelectedModifiers(Optional<Integer> minSelectedModifiers);

        _FinalStage minSelectedModifiers(Integer minSelectedModifiers);

        _FinalStage minSelectedModifiers(Nullable<Integer> minSelectedModifiers);

        /**
         * <p>The maximum number of modifiers that can be selected.
         * Values:</p>
         * <ul>
         * <li>0: No maximum limit.</li>
         * <li>-1: Default value, the attribute was not set by the client. When <code>min_selected_modifiers</code> is
         * also -1, use the minimum and maximum selection values set on the <code>CatalogItemModifierList</code>.</li>
         * <li>&gt;0: The maximum total modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
         * <li>&lt; -1: Invalid. Treated as no maximum limit.</li>
         * </ul>
         */
        _FinalStage maxSelectedModifiers(Optional<Integer> maxSelectedModifiers);

        _FinalStage maxSelectedModifiers(Integer maxSelectedModifiers);

        _FinalStage maxSelectedModifiers(Nullable<Integer> maxSelectedModifiers);

        /**
         * <p>If <code>true</code>, enable this <code>CatalogModifierList</code>. The default value is <code>true</code>.</p>
         */
        _FinalStage enabled(Optional<Boolean> enabled);

        _FinalStage enabled(Boolean enabled);

        _FinalStage enabled(Nullable<Boolean> enabled);

        /**
         * <p>The position of this <code>CatalogItemModifierListInfo</code> object within the <code>modifier_list_info</code> list applied
         * to a <code>CatalogItem</code> instance.</p>
         */
        _FinalStage ordinal(Optional<Integer> ordinal);

        _FinalStage ordinal(Integer ordinal);

        _FinalStage ordinal(Nullable<Integer> ordinal);

        _FinalStage allowQuantities(Optional<Object> allowQuantities);

        _FinalStage allowQuantities(Object allowQuantities);

        _FinalStage isConversational(Optional<Object> isConversational);

        _FinalStage isConversational(Object isConversational);

        _FinalStage hiddenFromCustomerOverride(Optional<Object> hiddenFromCustomerOverride);

        _FinalStage hiddenFromCustomerOverride(Object hiddenFromCustomerOverride);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModifierListIdStage, _FinalStage {
        private String modifierListId;

        private Optional<Object> hiddenFromCustomerOverride = Optional.empty();

        private Optional<Object> isConversational = Optional.empty();

        private Optional<Object> allowQuantities = Optional.empty();

        private Optional<Integer> ordinal = Optional.empty();

        private Optional<Boolean> enabled = Optional.empty();

        private Optional<Integer> maxSelectedModifiers = Optional.empty();

        private Optional<Integer> minSelectedModifiers = Optional.empty();

        private Optional<List<CatalogModifierOverride>> modifierOverrides = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CatalogItemModifierListInfo other) {
            modifierListId(other.getModifierListId());
            modifierOverrides(other.getModifierOverrides());
            minSelectedModifiers(other.getMinSelectedModifiers());
            maxSelectedModifiers(other.getMaxSelectedModifiers());
            enabled(other.getEnabled());
            ordinal(other.getOrdinal());
            allowQuantities(other.getAllowQuantities());
            isConversational(other.getIsConversational());
            hiddenFromCustomerOverride(other.getHiddenFromCustomerOverride());
            return this;
        }

        /**
         * <p>The ID of the <code>CatalogModifierList</code> controlled by this <code>CatalogModifierListInfo</code>.</p>
         * <p>The ID of the <code>CatalogModifierList</code> controlled by this <code>CatalogModifierListInfo</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("modifier_list_id")
        public _FinalStage modifierListId(@NotNull String modifierListId) {
            this.modifierListId = Objects.requireNonNull(modifierListId, "modifierListId must not be null");
            return this;
        }

        @java.lang.Override
        public _FinalStage hiddenFromCustomerOverride(Object hiddenFromCustomerOverride) {
            this.hiddenFromCustomerOverride = Optional.ofNullable(hiddenFromCustomerOverride);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "hidden_from_customer_override", nulls = Nulls.SKIP)
        public _FinalStage hiddenFromCustomerOverride(Optional<Object> hiddenFromCustomerOverride) {
            this.hiddenFromCustomerOverride = hiddenFromCustomerOverride;
            return this;
        }

        @java.lang.Override
        public _FinalStage isConversational(Object isConversational) {
            this.isConversational = Optional.ofNullable(isConversational);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "is_conversational", nulls = Nulls.SKIP)
        public _FinalStage isConversational(Optional<Object> isConversational) {
            this.isConversational = isConversational;
            return this;
        }

        @java.lang.Override
        public _FinalStage allowQuantities(Object allowQuantities) {
            this.allowQuantities = Optional.ofNullable(allowQuantities);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "allow_quantities", nulls = Nulls.SKIP)
        public _FinalStage allowQuantities(Optional<Object> allowQuantities) {
            this.allowQuantities = allowQuantities;
            return this;
        }

        /**
         * <p>The position of this <code>CatalogItemModifierListInfo</code> object within the <code>modifier_list_info</code> list applied
         * to a <code>CatalogItem</code> instance.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage ordinal(Nullable<Integer> ordinal) {
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
         * <p>The position of this <code>CatalogItemModifierListInfo</code> object within the <code>modifier_list_info</code> list applied
         * to a <code>CatalogItem</code> instance.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage ordinal(Integer ordinal) {
            this.ordinal = Optional.ofNullable(ordinal);
            return this;
        }

        /**
         * <p>The position of this <code>CatalogItemModifierListInfo</code> object within the <code>modifier_list_info</code> list applied
         * to a <code>CatalogItem</code> instance.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "ordinal", nulls = Nulls.SKIP)
        public _FinalStage ordinal(Optional<Integer> ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        /**
         * <p>If <code>true</code>, enable this <code>CatalogModifierList</code>. The default value is <code>true</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage enabled(Nullable<Boolean> enabled) {
            if (enabled.isNull()) {
                this.enabled = null;
            } else if (enabled.isEmpty()) {
                this.enabled = Optional.empty();
            } else {
                this.enabled = Optional.of(enabled.get());
            }
            return this;
        }

        /**
         * <p>If <code>true</code>, enable this <code>CatalogModifierList</code>. The default value is <code>true</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage enabled(Boolean enabled) {
            this.enabled = Optional.ofNullable(enabled);
            return this;
        }

        /**
         * <p>If <code>true</code>, enable this <code>CatalogModifierList</code>. The default value is <code>true</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "enabled", nulls = Nulls.SKIP)
        public _FinalStage enabled(Optional<Boolean> enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * <p>The maximum number of modifiers that can be selected.
         * Values:</p>
         * <ul>
         * <li>0: No maximum limit.</li>
         * <li>-1: Default value, the attribute was not set by the client. When <code>min_selected_modifiers</code> is
         * also -1, use the minimum and maximum selection values set on the <code>CatalogItemModifierList</code>.</li>
         * <li>&gt;0: The maximum total modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
         * <li>&lt; -1: Invalid. Treated as no maximum limit.</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage maxSelectedModifiers(Nullable<Integer> maxSelectedModifiers) {
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
         * <p>The maximum number of modifiers that can be selected.
         * Values:</p>
         * <ul>
         * <li>0: No maximum limit.</li>
         * <li>-1: Default value, the attribute was not set by the client. When <code>min_selected_modifiers</code> is
         * also -1, use the minimum and maximum selection values set on the <code>CatalogItemModifierList</code>.</li>
         * <li>&gt;0: The maximum total modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
         * <li>&lt; -1: Invalid. Treated as no maximum limit.</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage maxSelectedModifiers(Integer maxSelectedModifiers) {
            this.maxSelectedModifiers = Optional.ofNullable(maxSelectedModifiers);
            return this;
        }

        /**
         * <p>The maximum number of modifiers that can be selected.
         * Values:</p>
         * <ul>
         * <li>0: No maximum limit.</li>
         * <li>-1: Default value, the attribute was not set by the client. When <code>min_selected_modifiers</code> is
         * also -1, use the minimum and maximum selection values set on the <code>CatalogItemModifierList</code>.</li>
         * <li>&gt;0: The maximum total modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
         * <li>&lt; -1: Invalid. Treated as no maximum limit.</li>
         * </ul>
         */
        @java.lang.Override
        @JsonSetter(value = "max_selected_modifiers", nulls = Nulls.SKIP)
        public _FinalStage maxSelectedModifiers(Optional<Integer> maxSelectedModifiers) {
            this.maxSelectedModifiers = maxSelectedModifiers;
            return this;
        }

        /**
         * <p>The minimum number of modifiers that must be selected from this modifier list.
         * Values:</p>
         * <ul>
         * <li>0: No selection is required.</li>
         * <li>-1: Default value, the attribute was not set by the client. When <code>max_selected_modifiers</code> is
         * also -1, use the minimum and maximum selection values set on the <code>CatalogItemModifierList</code>.</li>
         * <li>&gt;0: The required minimum modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
         * <li>&lt; -1: Invalid. Treated as no selection required.</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage minSelectedModifiers(Nullable<Integer> minSelectedModifiers) {
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
         * <p>The minimum number of modifiers that must be selected from this modifier list.
         * Values:</p>
         * <ul>
         * <li>0: No selection is required.</li>
         * <li>-1: Default value, the attribute was not set by the client. When <code>max_selected_modifiers</code> is
         * also -1, use the minimum and maximum selection values set on the <code>CatalogItemModifierList</code>.</li>
         * <li>&gt;0: The required minimum modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
         * <li>&lt; -1: Invalid. Treated as no selection required.</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage minSelectedModifiers(Integer minSelectedModifiers) {
            this.minSelectedModifiers = Optional.ofNullable(minSelectedModifiers);
            return this;
        }

        /**
         * <p>The minimum number of modifiers that must be selected from this modifier list.
         * Values:</p>
         * <ul>
         * <li>0: No selection is required.</li>
         * <li>-1: Default value, the attribute was not set by the client. When <code>max_selected_modifiers</code> is
         * also -1, use the minimum and maximum selection values set on the <code>CatalogItemModifierList</code>.</li>
         * <li>&gt;0: The required minimum modifier selections. This can be larger than the total <code>CatalogModifiers</code> when <code>allow_quantities</code> is enabled.</li>
         * <li>&lt; -1: Invalid. Treated as no selection required.</li>
         * </ul>
         */
        @java.lang.Override
        @JsonSetter(value = "min_selected_modifiers", nulls = Nulls.SKIP)
        public _FinalStage minSelectedModifiers(Optional<Integer> minSelectedModifiers) {
            this.minSelectedModifiers = minSelectedModifiers;
            return this;
        }

        /**
         * <p>A set of <code>CatalogModifierOverride</code> objects that override default modifier settings for this item.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage modifierOverrides(Nullable<List<CatalogModifierOverride>> modifierOverrides) {
            if (modifierOverrides.isNull()) {
                this.modifierOverrides = null;
            } else if (modifierOverrides.isEmpty()) {
                this.modifierOverrides = Optional.empty();
            } else {
                this.modifierOverrides = Optional.of(modifierOverrides.get());
            }
            return this;
        }

        /**
         * <p>A set of <code>CatalogModifierOverride</code> objects that override default modifier settings for this item.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage modifierOverrides(List<CatalogModifierOverride> modifierOverrides) {
            this.modifierOverrides = Optional.ofNullable(modifierOverrides);
            return this;
        }

        /**
         * <p>A set of <code>CatalogModifierOverride</code> objects that override default modifier settings for this item.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "modifier_overrides", nulls = Nulls.SKIP)
        public _FinalStage modifierOverrides(Optional<List<CatalogModifierOverride>> modifierOverrides) {
            this.modifierOverrides = modifierOverrides;
            return this;
        }

        @java.lang.Override
        public CatalogItemModifierListInfo build() {
            return new CatalogItemModifierListInfo(
                    modifierListId,
                    modifierOverrides,
                    minSelectedModifiers,
                    maxSelectedModifiers,
                    enabled,
                    ordinal,
                    allowQuantities,
                    isConversational,
                    hiddenFromCustomerOverride,
                    additionalProperties);
        }
    }
}
