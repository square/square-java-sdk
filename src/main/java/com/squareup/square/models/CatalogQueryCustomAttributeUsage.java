package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryCustomAttributeUsage {

    @JsonCreator
    public CatalogQueryCustomAttributeUsage(
            @JsonProperty("custom_attribute_definition_ids") List<String> customAttributeDefinitionIds,
            @JsonProperty("has_value") Boolean hasValue) {
        this.customAttributeDefinitionIds = customAttributeDefinitionIds;
        this.hasValue = hasValue;
    }

    private final List<String> customAttributeDefinitionIds;
    private final Boolean hasValue;

    @Override
    public int hashCode() {
        return Objects.hash(customAttributeDefinitionIds, hasValue);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryCustomAttributeUsage)) {
            return false;
        }
        CatalogQueryCustomAttributeUsage catalogQueryCustomAttributeUsage = (CatalogQueryCustomAttributeUsage) o;
        return Objects.equals(customAttributeDefinitionIds, catalogQueryCustomAttributeUsage.customAttributeDefinitionIds) &&
            Objects.equals(hasValue, catalogQueryCustomAttributeUsage.hasValue);
    }

    /**
     * Getter for CustomAttributeDefinitionIds.
     */
    @JsonGetter("custom_attribute_definition_ids")
    public List<String> getCustomAttributeDefinitionIds() { 
        return this.customAttributeDefinitionIds;
    }

    /**
     * Getter for HasValue.
     */
    @JsonGetter("has_value")
    public Boolean getHasValue() { 
        return this.hasValue;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .customAttributeDefinitionIds(getCustomAttributeDefinitionIds())
            .hasValue(getHasValue());
            return builder;
    }

    public static class Builder {
        private List<String> customAttributeDefinitionIds;
        private Boolean hasValue;

        public Builder() { }

        public Builder customAttributeDefinitionIds(List<String> value) {
            customAttributeDefinitionIds = value;
            return this;
        }
        public Builder hasValue(Boolean value) {
            hasValue = value;
            return this;
        }

        public CatalogQueryCustomAttributeUsage build() {
            return new CatalogQueryCustomAttributeUsage(customAttributeDefinitionIds,
                hasValue);
        }
    }
}
