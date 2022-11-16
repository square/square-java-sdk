
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogItemModifierListInfo type.
 */
public class CatalogItemModifierListInfo {
    private final String modifierListId;
    private final OptionalNullable<List<CatalogModifierOverride>> modifierOverrides;
    private final OptionalNullable<Integer> minSelectedModifiers;
    private final OptionalNullable<Integer> maxSelectedModifiers;
    private final OptionalNullable<Boolean> enabled;

    /**
     * Initialization constructor.
     * @param  modifierListId  String value for modifierListId.
     * @param  modifierOverrides  List of CatalogModifierOverride value for modifierOverrides.
     * @param  minSelectedModifiers  Integer value for minSelectedModifiers.
     * @param  maxSelectedModifiers  Integer value for maxSelectedModifiers.
     * @param  enabled  Boolean value for enabled.
     */
    @JsonCreator
    public CatalogItemModifierListInfo(
            @JsonProperty("modifier_list_id") String modifierListId,
            @JsonProperty("modifier_overrides") List<CatalogModifierOverride> modifierOverrides,
            @JsonProperty("min_selected_modifiers") Integer minSelectedModifiers,
            @JsonProperty("max_selected_modifiers") Integer maxSelectedModifiers,
            @JsonProperty("enabled") Boolean enabled) {
        this.modifierListId = modifierListId;
        this.modifierOverrides = OptionalNullable.of(modifierOverrides);
        this.minSelectedModifiers = OptionalNullable.of(minSelectedModifiers);
        this.maxSelectedModifiers = OptionalNullable.of(maxSelectedModifiers);
        this.enabled = OptionalNullable.of(enabled);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogItemModifierListInfo(String modifierListId,
            OptionalNullable<List<CatalogModifierOverride>> modifierOverrides,
            OptionalNullable<Integer> minSelectedModifiers,
            OptionalNullable<Integer> maxSelectedModifiers, OptionalNullable<Boolean> enabled) {
        this.modifierListId = modifierListId;
        this.modifierOverrides = modifierOverrides;
        this.minSelectedModifiers = minSelectedModifiers;
        this.maxSelectedModifiers = maxSelectedModifiers;
        this.enabled = enabled;
    }

    /**
     * Getter for ModifierListId.
     * The ID of the `CatalogModifierList` controlled by this `CatalogModifierListInfo`.
     * @return Returns the String
     */
    @JsonGetter("modifier_list_id")
    public String getModifierListId() {
        return modifierListId;
    }

    /**
     * Internal Getter for ModifierOverrides.
     * A set of `CatalogModifierOverride` objects that override whether a given `CatalogModifier` is
     * enabled by default.
     * @return Returns the Internal List of CatalogModifierOverride
     */
    @JsonGetter("modifier_overrides")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogModifierOverride>> internalGetModifierOverrides() {
        return this.modifierOverrides;
    }

    /**
     * Getter for ModifierOverrides.
     * A set of `CatalogModifierOverride` objects that override whether a given `CatalogModifier` is
     * enabled by default.
     * @return Returns the List of CatalogModifierOverride
     */
    @JsonIgnore
    public List<CatalogModifierOverride> getModifierOverrides() {
        return OptionalNullable.getFrom(modifierOverrides);
    }

    /**
     * Internal Getter for MinSelectedModifiers.
     * If 0 or larger, the smallest number of `CatalogModifier`s that must be selected from this
     * `CatalogModifierList`.
     * @return Returns the Internal Integer
     */
    @JsonGetter("min_selected_modifiers")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetMinSelectedModifiers() {
        return this.minSelectedModifiers;
    }

    /**
     * Getter for MinSelectedModifiers.
     * If 0 or larger, the smallest number of `CatalogModifier`s that must be selected from this
     * `CatalogModifierList`.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getMinSelectedModifiers() {
        return OptionalNullable.getFrom(minSelectedModifiers);
    }

    /**
     * Internal Getter for MaxSelectedModifiers.
     * If 0 or larger, the largest number of `CatalogModifier`s that can be selected from this
     * `CatalogModifierList`.
     * @return Returns the Internal Integer
     */
    @JsonGetter("max_selected_modifiers")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetMaxSelectedModifiers() {
        return this.maxSelectedModifiers;
    }

    /**
     * Getter for MaxSelectedModifiers.
     * If 0 or larger, the largest number of `CatalogModifier`s that can be selected from this
     * `CatalogModifierList`.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getMaxSelectedModifiers() {
        return OptionalNullable.getFrom(maxSelectedModifiers);
    }

    /**
     * Internal Getter for Enabled.
     * If `true`, enable this `CatalogModifierList`. The default value is `true`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("enabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetEnabled() {
        return this.enabled;
    }

    /**
     * Getter for Enabled.
     * If `true`, enable this `CatalogModifierList`. The default value is `true`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getEnabled() {
        return OptionalNullable.getFrom(enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modifierListId, modifierOverrides, minSelectedModifiers,
                maxSelectedModifiers, enabled);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogItemModifierListInfo)) {
            return false;
        }
        CatalogItemModifierListInfo other = (CatalogItemModifierListInfo) obj;
        return Objects.equals(modifierListId, other.modifierListId)
            && Objects.equals(modifierOverrides, other.modifierOverrides)
            && Objects.equals(minSelectedModifiers, other.minSelectedModifiers)
            && Objects.equals(maxSelectedModifiers, other.maxSelectedModifiers)
            && Objects.equals(enabled, other.enabled);
    }

    /**
     * Converts this CatalogItemModifierListInfo into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogItemModifierListInfo [" + "modifierListId=" + modifierListId
                + ", modifierOverrides=" + modifierOverrides + ", minSelectedModifiers="
                + minSelectedModifiers + ", maxSelectedModifiers=" + maxSelectedModifiers
                + ", enabled=" + enabled + "]";
    }

    /**
     * Builds a new {@link CatalogItemModifierListInfo.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemModifierListInfo.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(modifierListId);
        builder.modifierOverrides = internalGetModifierOverrides();
        builder.minSelectedModifiers = internalGetMinSelectedModifiers();
        builder.maxSelectedModifiers = internalGetMaxSelectedModifiers();
        builder.enabled = internalGetEnabled();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemModifierListInfo}.
     */
    public static class Builder {
        private String modifierListId;
        private OptionalNullable<List<CatalogModifierOverride>> modifierOverrides;
        private OptionalNullable<Integer> minSelectedModifiers;
        private OptionalNullable<Integer> maxSelectedModifiers;
        private OptionalNullable<Boolean> enabled;

        /**
         * Initialization constructor.
         * @param  modifierListId  String value for modifierListId.
         */
        public Builder(String modifierListId) {
            this.modifierListId = modifierListId;
        }

        /**
         * Setter for modifierListId.
         * @param  modifierListId  String value for modifierListId.
         * @return Builder
         */
        public Builder modifierListId(String modifierListId) {
            this.modifierListId = modifierListId;
            return this;
        }

        /**
         * Setter for modifierOverrides.
         * @param  modifierOverrides  List of CatalogModifierOverride value for modifierOverrides.
         * @return Builder
         */
        public Builder modifierOverrides(List<CatalogModifierOverride> modifierOverrides) {
            this.modifierOverrides = OptionalNullable.of(modifierOverrides);
            return this;
        }

        /**
         * UnSetter for modifierOverrides.
         * @return Builder
         */
        public Builder unsetModifierOverrides() {
            modifierOverrides = null;
            return this;
        }

        /**
         * Setter for minSelectedModifiers.
         * @param  minSelectedModifiers  Integer value for minSelectedModifiers.
         * @return Builder
         */
        public Builder minSelectedModifiers(Integer minSelectedModifiers) {
            this.minSelectedModifiers = OptionalNullable.of(minSelectedModifiers);
            return this;
        }

        /**
         * UnSetter for minSelectedModifiers.
         * @return Builder
         */
        public Builder unsetMinSelectedModifiers() {
            minSelectedModifiers = null;
            return this;
        }

        /**
         * Setter for maxSelectedModifiers.
         * @param  maxSelectedModifiers  Integer value for maxSelectedModifiers.
         * @return Builder
         */
        public Builder maxSelectedModifiers(Integer maxSelectedModifiers) {
            this.maxSelectedModifiers = OptionalNullable.of(maxSelectedModifiers);
            return this;
        }

        /**
         * UnSetter for maxSelectedModifiers.
         * @return Builder
         */
        public Builder unsetMaxSelectedModifiers() {
            maxSelectedModifiers = null;
            return this;
        }

        /**
         * Setter for enabled.
         * @param  enabled  Boolean value for enabled.
         * @return Builder
         */
        public Builder enabled(Boolean enabled) {
            this.enabled = OptionalNullable.of(enabled);
            return this;
        }

        /**
         * UnSetter for enabled.
         * @return Builder
         */
        public Builder unsetEnabled() {
            enabled = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemModifierListInfo} object using the set fields.
         * @return {@link CatalogItemModifierListInfo}
         */
        public CatalogItemModifierListInfo build() {
            return new CatalogItemModifierListInfo(modifierListId, modifierOverrides,
                    minSelectedModifiers, maxSelectedModifiers, enabled);
        }
    }
}
