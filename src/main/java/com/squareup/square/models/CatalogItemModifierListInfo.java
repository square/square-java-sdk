
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for CatalogItemModifierListInfo type.
 */
public class CatalogItemModifierListInfo {
    private final String modifierListId;
    private final List<CatalogModifierOverride> modifierOverrides;
    private final Integer minSelectedModifiers;
    private final Integer maxSelectedModifiers;
    private final Boolean enabled;

    /**
     * Initialization constructor.
     * @param modifierListId String value for modifierListId.
     * @param modifierOverrides List of CatalogModifierOverride value for modifierOverrides.
     * @param minSelectedModifiers Integer value for minSelectedModifiers.
     * @param maxSelectedModifiers Integer value for maxSelectedModifiers.
     * @param enabled Boolean value for enabled.
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

    /**
     * Getter for ModifierListId.
     * The ID of the `CatalogModifierList` controlled by this `CatalogModifierListInfo`.
     * @return Returns the String
     */
    @JsonGetter("modifier_list_id")
    public String getModifierListId() {
        return this.modifierListId;
    }

    /**
     * Getter for ModifierOverrides.
     * A set of `CatalogModifierOverride` objects that override whether a given `CatalogModifier` is
     * enabled by default.
     * @return Returns the List of CatalogModifierOverride
     */
    @JsonGetter("modifier_overrides")
    public List<CatalogModifierOverride> getModifierOverrides() {
        return this.modifierOverrides;
    }

    /**
     * Getter for MinSelectedModifiers.
     * If 0 or larger, the smallest number of `CatalogModifier`s that must be selected from this
     * `CatalogModifierList`.
     * @return Returns the Integer
     */
    @JsonGetter("min_selected_modifiers")
    public Integer getMinSelectedModifiers() {
        return this.minSelectedModifiers;
    }

    /**
     * Getter for MaxSelectedModifiers.
     * If 0 or larger, the largest number of `CatalogModifier`s that can be selected from this
     * `CatalogModifierList`.
     * @return Returns the Integer
     */
    @JsonGetter("max_selected_modifiers")
    public Integer getMaxSelectedModifiers() {
        return this.maxSelectedModifiers;
    }

    /**
     * Getter for Enabled.
     * If `true`, enable this `CatalogModifierList`. The default value is `true`.
     * @return Returns the Boolean
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
     * Class to build instances of {@link CatalogItemModifierListInfo}.
     */
    public static class Builder {
        private String modifierListId;
        private List<CatalogModifierOverride> modifierOverrides;
        private Integer minSelectedModifiers;
        private Integer maxSelectedModifiers;
        private Boolean enabled;

        /**
         * Initialization constructor.
         * @param modifierListId String value for modifierListId.
         */
        public Builder(String modifierListId) {
            this.modifierListId = modifierListId;
        }

        /**
         * Setter for modifierListId.
         * @param modifierListId String value for modifierListId.
         * @return Builder
         */
        public Builder modifierListId(String modifierListId) {
            this.modifierListId = modifierListId;
            return this;
        }

        /**
         * Setter for modifierOverrides.
         * @param modifierOverrides List of CatalogModifierOverride value for modifierOverrides.
         * @return Builder
         */
        public Builder modifierOverrides(List<CatalogModifierOverride> modifierOverrides) {
            this.modifierOverrides = modifierOverrides;
            return this;
        }

        /**
         * Setter for minSelectedModifiers.
         * @param minSelectedModifiers Integer value for minSelectedModifiers.
         * @return Builder
         */
        public Builder minSelectedModifiers(Integer minSelectedModifiers) {
            this.minSelectedModifiers = minSelectedModifiers;
            return this;
        }

        /**
         * Setter for maxSelectedModifiers.
         * @param maxSelectedModifiers Integer value for maxSelectedModifiers.
         * @return Builder
         */
        public Builder maxSelectedModifiers(Integer maxSelectedModifiers) {
            this.maxSelectedModifiers = maxSelectedModifiers;
            return this;
        }

        /**
         * Setter for enabled.
         * @param enabled Boolean value for enabled.
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
