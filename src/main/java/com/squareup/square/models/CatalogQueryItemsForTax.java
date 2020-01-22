package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQueryItemsForTax type.
 */
public class CatalogQueryItemsForTax {

    /**
     * Initialization constructor.
     * @param taxIds
     */
    @JsonCreator
    public CatalogQueryItemsForTax(
            @JsonProperty("tax_ids") List<String> taxIds) {
        this.taxIds = taxIds;
    }

    private final List<String> taxIds;
    /**
     * Getter for TaxIds.
     * A set of `CatalogTax` IDs to be used to find associated `CatalogItem`s.
     */
    @JsonGetter("tax_ids")
    public List<String> getTaxIds() {
        return this.taxIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(taxIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQueryItemsForTax)) {
            return false;
        }
        CatalogQueryItemsForTax catalogQueryItemsForTax = (CatalogQueryItemsForTax) obj;
        return Objects.equals(taxIds, catalogQueryItemsForTax.taxIds);
    }

    /**
     * Builds a new {@link CatalogQueryItemsForTax.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryItemsForTax.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(taxIds);
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryItemsForTax}
     */
    public static class Builder {
        private List<String> taxIds;

        /**
         * Initialization constructor
         */
        public Builder(List<String> taxIds) {
            this.taxIds = taxIds;
        }

        /**
         * Setter for taxIds
         * @param taxIds
         * @return Builder
         */
        public Builder taxIds(List<String> taxIds) {
            this.taxIds = taxIds;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryItemsForTax} object using the set fields.
         * @return {@link CatalogQueryItemsForTax}
         */
        public CatalogQueryItemsForTax build() {
            return new CatalogQueryItemsForTax(taxIds);
        }
    }
}
