
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CatalogCustomAttributeDefinitionStringConfig type.
 */
public class CatalogCustomAttributeDefinitionStringConfig {
    private final Boolean enforceUniqueness;

    /**
     * Initialization constructor.
     * @param  enforceUniqueness  Boolean value for enforceUniqueness.
     */
    @JsonCreator
    public CatalogCustomAttributeDefinitionStringConfig(
            @JsonProperty("enforce_uniqueness") Boolean enforceUniqueness) {
        this.enforceUniqueness = enforceUniqueness;
    }

    /**
     * Getter for EnforceUniqueness.
     * If true, each Custom Attribute instance associated with this Custom Attribute Definition must
     * have a unique value within the seller's catalog. For example, this may be used for a value
     * like a SKU that should not be duplicated within a seller's catalog. May not be modified after
     * the definition has been created.
     * @return Returns the Boolean
     */
    @JsonGetter("enforce_uniqueness")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getEnforceUniqueness() {
        return enforceUniqueness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enforceUniqueness);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogCustomAttributeDefinitionStringConfig)) {
            return false;
        }
        CatalogCustomAttributeDefinitionStringConfig other =
                (CatalogCustomAttributeDefinitionStringConfig) obj;
        return Objects.equals(enforceUniqueness, other.enforceUniqueness);
    }

    /**
     * Converts this CatalogCustomAttributeDefinitionStringConfig into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogCustomAttributeDefinitionStringConfig [" + "enforceUniqueness="
                + enforceUniqueness + "]";
    }

    /**
     * Builds a new {@link CatalogCustomAttributeDefinitionStringConfig.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogCustomAttributeDefinitionStringConfig.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .enforceUniqueness(getEnforceUniqueness());
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogCustomAttributeDefinitionStringConfig}.
     */
    public static class Builder {
        private Boolean enforceUniqueness;



        /**
         * Setter for enforceUniqueness.
         * @param  enforceUniqueness  Boolean value for enforceUniqueness.
         * @return Builder
         */
        public Builder enforceUniqueness(Boolean enforceUniqueness) {
            this.enforceUniqueness = enforceUniqueness;
            return this;
        }

        /**
         * Builds a new {@link CatalogCustomAttributeDefinitionStringConfig} object using the set
         * fields.
         * @return {@link CatalogCustomAttributeDefinitionStringConfig}
         */
        public CatalogCustomAttributeDefinitionStringConfig build() {
            return new CatalogCustomAttributeDefinitionStringConfig(enforceUniqueness);
        }
    }
}
