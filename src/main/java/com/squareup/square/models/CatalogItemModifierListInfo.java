package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogItemModifierListInfo {

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

    @Override
    public int hashCode() {
        return Objects.hash(modifierListId, modifierOverrides, minSelectedModifiers, maxSelectedModifiers, enabled);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogItemModifierListInfo)) {
            return false;
        }
        CatalogItemModifierListInfo catalogItemModifierListInfo = (CatalogItemModifierListInfo) o;
        return Objects.equals(modifierListId, catalogItemModifierListInfo.modifierListId) &&
            Objects.equals(modifierOverrides, catalogItemModifierListInfo.modifierOverrides) &&
            Objects.equals(minSelectedModifiers, catalogItemModifierListInfo.minSelectedModifiers) &&
            Objects.equals(maxSelectedModifiers, catalogItemModifierListInfo.maxSelectedModifiers) &&
            Objects.equals(enabled, catalogItemModifierListInfo.enabled);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder(modifierListId)
            .modifierOverrides(getModifierOverrides())
            .minSelectedModifiers(getMinSelectedModifiers())
            .maxSelectedModifiers(getMaxSelectedModifiers())
            .enabled(getEnabled());
            return builder;
    }

    public static class Builder {
        private String modifierListId;
        private List<CatalogModifierOverride> modifierOverrides;
        private Integer minSelectedModifiers;
        private Integer maxSelectedModifiers;
        private Boolean enabled;

        public Builder(String modifierListId) {
            this.modifierListId = modifierListId;
        }

        public Builder modifierListId(String value) {
            modifierListId = value;
            return this;
        }
        public Builder modifierOverrides(List<CatalogModifierOverride> value) {
            modifierOverrides = value;
            return this;
        }
        public Builder minSelectedModifiers(Integer value) {
            minSelectedModifiers = value;
            return this;
        }
        public Builder maxSelectedModifiers(Integer value) {
            maxSelectedModifiers = value;
            return this;
        }
        public Builder enabled(Boolean value) {
            enabled = value;
            return this;
        }

        public CatalogItemModifierListInfo build() {
            return new CatalogItemModifierListInfo(modifierListId,
                modifierOverrides,
                minSelectedModifiers,
                maxSelectedModifiers,
                enabled);
        }
    }
}
