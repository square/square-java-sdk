package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogItemModifierListInfo type.
 */
public class CatalogItemModifierListInfo {

    /**
     * Initialization constructor.
     * @param modifierListId
     * @param modifierOverrides
     * @param minSelectedModifiers
     * @param maxSelectedModifiers
     * @param enabled
     */
    @JsonCreator
    public CatalogItemModifierListInfo(
            @JsonProperty("modifier_list_id") String modifierListId,
            @JsonProperty("modifier_overrides") List<CatalogModifierOverride> modifierOverrides,
            @JsonProperty("min_selected_modifiers") Integer minSelectedModifiers,
            @JsonProperty("max_selected_modifiers") Integer maxSelectedModifiers,
            @JsonProperty("enabled") Boolean enabled) {
        this.modifierListId = modifierListId;
        this.modifierOverrides = modifierOverrides;
        this.minSelectedModifiers = minSelectedModifiers;
        this.maxSelectedModifiers = maxSelectedModifiers;
        this.enabled = enabled;
    }

    private final String modifierListId;
    private final List<CatalogModifierOverride> modifierOverrides;
    private final Integer minSelectedModifiers;
    private final Integer maxSelectedModifiers;
    private final Boolean enabled;
    /**
     * Getter for ModifierListId.
     * The ID of the `CatalogModifierList` controlled by this `CatalogModifierListInfo`.
     */
    @JsonGetter("modifier_list_id")
    public String getModifierListId() {
        return this.modifierListId;
    }

    /**
     * Getter for ModifierOverrides.
     * A set of `CatalogModifierOverride` objects that override whether a given `CatalogModifier` is enabled by default.
     */
    @JsonGetter("modifier_overrides")
    public List<CatalogModifierOverride> getModifierOverrides() {
        return this.modifierOverrides;
    }

    /**
     * Getter for MinSelectedModifiers.
     * If 0 or larger, the smallest number of `CatalogModifier`s that must be selected from this `CatalogModifierList`.
     */
    @JsonGetter("min_selected_modifiers")
    public Integer getMinSelectedModifiers() {
        return this.minSelectedModifiers;
    }

    /**
     * Getter for MaxSelectedModifiers.
     * If 0 or larger, the largest number of `CatalogModifier`s that can be selected from this `CatalogModifierList`.
     */
    @JsonGetter("max_selected_modifiers")
    public Integer getMaxSelectedModifiers() {
        return this.maxSelectedModifiers;
    }

    /**
     * Getter for Enabled.
     * If `true`, enable this `CatalogModifierList`.
     */
    @JsonGetter("enabled")
    public Boolean getEnabled() {
        return this.enabled;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(modifierListId, modifierOverrides, minSelectedModifiers,
            maxSelectedModifiers, enabled);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogItemModifierListInfo)) {
            return false;
        }
        CatalogItemModifierListInfo catalogItemModifierListInfo = (CatalogItemModifierListInfo) obj;
        return Objects.equals(modifierListId, catalogItemModifierListInfo.modifierListId) &&
            Objects.equals(modifierOverrides, catalogItemModifierListInfo.modifierOverrides) &&
            Objects.equals(minSelectedModifiers, catalogItemModifierListInfo.minSelectedModifiers) &&
            Objects.equals(maxSelectedModifiers, catalogItemModifierListInfo.maxSelectedModifiers) &&
            Objects.equals(enabled, catalogItemModifierListInfo.enabled);
    }

    /**
     * Builds a new {@link CatalogItemModifierListInfo.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemModifierListInfo.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(modifierListId)
            .modifierOverrides(getModifierOverrides())
            .minSelectedModifiers(getMinSelectedModifiers())
            .maxSelectedModifiers(getMaxSelectedModifiers())
            .enabled(getEnabled());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemModifierListInfo}
     */
    public static class Builder {
        private String modifierListId;
        private List<CatalogModifierOverride> modifierOverrides;
        private Integer minSelectedModifiers;
        private Integer maxSelectedModifiers;
        private Boolean enabled;

        /**
         * Initialization constructor
         */
        public Builder(String modifierListId) {
            this.modifierListId = modifierListId;
        }

        /**
         * Setter for modifierListId
         * @param modifierListId
         * @return Builder
         */
        public Builder modifierListId(String modifierListId) {
            this.modifierListId = modifierListId;
            return this;
        }
        /**
         * Setter for modifierOverrides
         * @param modifierOverrides
         * @return Builder
         */
        public Builder modifierOverrides(List<CatalogModifierOverride> modifierOverrides) {
            this.modifierOverrides = modifierOverrides;
            return this;
        }
        /**
         * Setter for minSelectedModifiers
         * @param minSelectedModifiers
         * @return Builder
         */
        public Builder minSelectedModifiers(Integer minSelectedModifiers) {
            this.minSelectedModifiers = minSelectedModifiers;
            return this;
        }
        /**
         * Setter for maxSelectedModifiers
         * @param maxSelectedModifiers
         * @return Builder
         */
        public Builder maxSelectedModifiers(Integer maxSelectedModifiers) {
            this.maxSelectedModifiers = maxSelectedModifiers;
            return this;
        }
        /**
         * Setter for enabled
         * @param enabled
         * @return Builder
         */
        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemModifierListInfo} object using the set fields.
         * @return {@link CatalogItemModifierListInfo}
         */
        public CatalogItemModifierListInfo build() {
            return new CatalogItemModifierListInfo(modifierListId,
                modifierOverrides,
                minSelectedModifiers,
                maxSelectedModifiers,
                enabled);
        }
    }
}
