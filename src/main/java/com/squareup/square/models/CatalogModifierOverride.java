package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogModifierOverride {

    @JsonCreator
    public CatalogModifierOverride(
            @JsonProperty("modifier_id") String modifierId,
            @JsonProperty("on_by_default") Boolean onByDefault) {
        this.modifierId = modifierId;
        this.onByDefault = onByDefault;
    }

    private final String modifierId;
    private final Boolean onByDefault;

    @Override
    public int hashCode() {
        return Objects.hash(modifierId, onByDefault);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogModifierOverride)) {
            return false;
        }
        CatalogModifierOverride catalogModifierOverride = (CatalogModifierOverride) o;
        return Objects.equals(modifierId, catalogModifierOverride.modifierId) &&
            Objects.equals(onByDefault, catalogModifierOverride.onByDefault);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder(modifierId)
            .onByDefault(getOnByDefault());
            return builder;
    }

    public static class Builder {
        private String modifierId;
        private Boolean onByDefault;

        public Builder(String modifierId) {
            this.modifierId = modifierId;
        }

        public Builder modifierId(String value) {
            modifierId = value;
            return this;
        }
        public Builder onByDefault(Boolean value) {
            onByDefault = value;
            return this;
        }

        public CatalogModifierOverride build() {
            return new CatalogModifierOverride(modifierId,
                onByDefault);
        }
    }
}
