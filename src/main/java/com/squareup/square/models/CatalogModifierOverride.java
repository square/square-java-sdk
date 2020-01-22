package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogModifierOverride type.
 */
public class CatalogModifierOverride {

    /**
     * Initialization constructor.
     * @param modifierId
     * @param onByDefault
     */
    @JsonCreator
    public CatalogModifierOverride(
            @JsonProperty("modifier_id") String modifierId,
            @JsonProperty("on_by_default") Boolean onByDefault) {
        this.modifierId = modifierId;
        this.onByDefault = onByDefault;
    }

    private final String modifierId;
    private final Boolean onByDefault;
    /**
     * Getter for ModifierId.
     * The ID of the `CatalogModifier` whose default behavior is being overridden.
     */
    @JsonGetter("modifier_id")
    public String getModifierId() {
        return this.modifierId;
    }

    /**
     * Getter for OnByDefault.
     * If `true`, this `CatalogModifier` should be selected by default for this `CatalogItem`.
     */
    @JsonGetter("on_by_default")
    public Boolean getOnByDefault() {
        return this.onByDefault;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(modifierId, onByDefault);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogModifierOverride)) {
            return false;
        }
        CatalogModifierOverride catalogModifierOverride = (CatalogModifierOverride) obj;
        return Objects.equals(modifierId, catalogModifierOverride.modifierId) &&
            Objects.equals(onByDefault, catalogModifierOverride.onByDefault);
    }

    /**
     * Builds a new {@link CatalogModifierOverride.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogModifierOverride.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(modifierId)
            .onByDefault(getOnByDefault());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogModifierOverride}
     */
    public static class Builder {
        private String modifierId;
        private Boolean onByDefault;

        /**
         * Initialization constructor
         */
        public Builder(String modifierId) {
            this.modifierId = modifierId;
        }

        /**
         * Setter for modifierId
         * @param modifierId
         * @return Builder
         */
        public Builder modifierId(String modifierId) {
            this.modifierId = modifierId;
            return this;
        }
        /**
         * Setter for onByDefault
         * @param onByDefault
         * @return Builder
         */
        public Builder onByDefault(Boolean onByDefault) {
            this.onByDefault = onByDefault;
            return this;
        }

        /**
         * Builds a new {@link CatalogModifierOverride} object using the set fields.
         * @return {@link CatalogModifierOverride}
         */
        public CatalogModifierOverride build() {
            return new CatalogModifierOverride(modifierId,
                onByDefault);
        }
    }
}
