package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryItemsForTax {

    @JsonCreator
    public CatalogQueryItemsForTax(
            @JsonProperty("tax_ids") List<String> taxIds) {
        this.taxIds = taxIds;
    }

    private final List<String> taxIds;

    @Override
    public int hashCode() {
        return Objects.hash(taxIds);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryItemsForTax)) {
            return false;
        }
        CatalogQueryItemsForTax catalogQueryItemsForTax = (CatalogQueryItemsForTax) o;
        return Objects.equals(taxIds, catalogQueryItemsForTax.taxIds);
    }

    /**
     * Getter for TaxIds.
     * A set of `CatalogTax` IDs to be used to find associated `CatalogItem`s.
     */
    @JsonGetter("tax_ids")
    public List<String> getTaxIds() { 
        return this.taxIds;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(taxIds);
            return builder;
    }

    public static class Builder {
        private List<String> taxIds;

        public Builder(List<String> taxIds) {
            this.taxIds = taxIds;
        }

        public Builder taxIds(List<String> value) {
            taxIds = value;
            return this;
        }

        public CatalogQueryItemsForTax build() {
            return new CatalogQueryItemsForTax(taxIds);
        }
    }
}
