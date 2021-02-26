
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogQueryItemsForTax type.
 */
public class CatalogQueryItemsForTax {
    private final List<String> taxIds;

    /**
     * Initialization constructor.
     * @param  taxIds  List of String value for taxIds.
     */
    @JsonCreator
    public CatalogQueryItemsForTax(
            @JsonProperty("tax_ids") List<String> taxIds) {
        this.taxIds = taxIds;
    }

    /**
     * Getter for TaxIds.
     * A set of `CatalogTax` IDs to be used to find associated `CatalogItem`s.
     * @return Returns the List of String
     */
    @JsonGetter("tax_ids")
    public List<String> getTaxIds() {
        return taxIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogQueryItemsForTax)) {
            return false;
        }
        CatalogQueryItemsForTax other = (CatalogQueryItemsForTax) obj;
        return Objects.equals(taxIds, other.taxIds);
    }

    /**
     * Converts this CatalogQueryItemsForTax into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogQueryItemsForTax [" + "taxIds=" + taxIds + "]";
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
     * Class to build instances of {@link CatalogQueryItemsForTax}.
     */
    public static class Builder {
        private List<String> taxIds;

        /**
         * Initialization constructor.
         * @param  taxIds  List of String value for taxIds.
         */
        public Builder(List<String> taxIds) {
            this.taxIds = taxIds;
        }

        /**
         * Setter for taxIds.
         * @param  taxIds  List of String value for taxIds.
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
