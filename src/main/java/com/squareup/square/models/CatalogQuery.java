package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQuery {

    @JsonCreator
    public CatalogQuery(
            @JsonProperty("sorted_attribute_query") CatalogQuerySortedAttribute sortedAttributeQuery,
            @JsonProperty("exact_query") CatalogQueryExact exactQuery,
            @JsonProperty("prefix_query") CatalogQueryPrefix prefixQuery,
            @JsonProperty("range_query") CatalogQueryRange rangeQuery,
            @JsonProperty("text_query") CatalogQueryText textQuery,
            @JsonProperty("items_for_tax_query") CatalogQueryItemsForTax itemsForTaxQuery,
            @JsonProperty("items_for_modifier_list_query") CatalogQueryItemsForModifierList itemsForModifierListQuery,
            @JsonProperty("items_for_item_options_query") CatalogQueryItemsForItemOptions itemsForItemOptionsQuery,
            @JsonProperty("item_variations_for_item_option_values_query") CatalogQueryItemVariationsForItemOptionValues itemVariationsForItemOptionValuesQuery) {
        this.sortedAttributeQuery = sortedAttributeQuery;
        this.exactQuery = exactQuery;
        this.prefixQuery = prefixQuery;
        this.rangeQuery = rangeQuery;
        this.textQuery = textQuery;
        this.itemsForTaxQuery = itemsForTaxQuery;
        this.itemsForModifierListQuery = itemsForModifierListQuery;
        this.itemsForItemOptionsQuery = itemsForItemOptionsQuery;
        this.itemVariationsForItemOptionValuesQuery = itemVariationsForItemOptionValuesQuery;
    }

    private final CatalogQuerySortedAttribute sortedAttributeQuery;
    private final CatalogQueryExact exactQuery;
    private final CatalogQueryPrefix prefixQuery;
    private final CatalogQueryRange rangeQuery;
    private final CatalogQueryText textQuery;
    private final CatalogQueryItemsForTax itemsForTaxQuery;
    private final CatalogQueryItemsForModifierList itemsForModifierListQuery;
    private final CatalogQueryItemsForItemOptions itemsForItemOptionsQuery;
    private final CatalogQueryItemVariationsForItemOptionValues itemVariationsForItemOptionValuesQuery;

    @Override
    public int hashCode() {
        return Objects.hash(sortedAttributeQuery, exactQuery, prefixQuery, rangeQuery, textQuery, itemsForTaxQuery, itemsForModifierListQuery, itemsForItemOptionsQuery, itemVariationsForItemOptionValuesQuery);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQuery)) {
            return false;
        }
        CatalogQuery catalogQuery = (CatalogQuery) o;
        return Objects.equals(sortedAttributeQuery, catalogQuery.sortedAttributeQuery) &&
            Objects.equals(exactQuery, catalogQuery.exactQuery) &&
            Objects.equals(prefixQuery, catalogQuery.prefixQuery) &&
            Objects.equals(rangeQuery, catalogQuery.rangeQuery) &&
            Objects.equals(textQuery, catalogQuery.textQuery) &&
            Objects.equals(itemsForTaxQuery, catalogQuery.itemsForTaxQuery) &&
            Objects.equals(itemsForModifierListQuery, catalogQuery.itemsForModifierListQuery) &&
            Objects.equals(itemsForItemOptionsQuery, catalogQuery.itemsForItemOptionsQuery) &&
            Objects.equals(itemVariationsForItemOptionValuesQuery, catalogQuery.itemVariationsForItemOptionValuesQuery);
    }

    /**
     * Getter for SortedAttributeQuery.
     */
    @JsonGetter("sorted_attribute_query")
    public CatalogQuerySortedAttribute getSortedAttributeQuery() { 
        return this.sortedAttributeQuery;
    }

    /**
     * Getter for ExactQuery.
     */
    @JsonGetter("exact_query")
    public CatalogQueryExact getExactQuery() { 
        return this.exactQuery;
    }

    /**
     * Getter for PrefixQuery.
     */
    @JsonGetter("prefix_query")
    public CatalogQueryPrefix getPrefixQuery() { 
        return this.prefixQuery;
    }

    /**
     * Getter for RangeQuery.
     */
    @JsonGetter("range_query")
    public CatalogQueryRange getRangeQuery() { 
        return this.rangeQuery;
    }

    /**
     * Getter for TextQuery.
     */
    @JsonGetter("text_query")
    public CatalogQueryText getTextQuery() { 
        return this.textQuery;
    }

    /**
     * Getter for ItemsForTaxQuery.
     */
    @JsonGetter("items_for_tax_query")
    public CatalogQueryItemsForTax getItemsForTaxQuery() { 
        return this.itemsForTaxQuery;
    }

    /**
     * Getter for ItemsForModifierListQuery.
     */
    @JsonGetter("items_for_modifier_list_query")
    public CatalogQueryItemsForModifierList getItemsForModifierListQuery() { 
        return this.itemsForModifierListQuery;
    }

    /**
     * Getter for ItemsForItemOptionsQuery.
     */
    @JsonGetter("items_for_item_options_query")
    public CatalogQueryItemsForItemOptions getItemsForItemOptionsQuery() { 
        return this.itemsForItemOptionsQuery;
    }

    /**
     * Getter for ItemVariationsForItemOptionValuesQuery.
     */
    @JsonGetter("item_variations_for_item_option_values_query")
    public CatalogQueryItemVariationsForItemOptionValues getItemVariationsForItemOptionValuesQuery() { 
        return this.itemVariationsForItemOptionValuesQuery;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .sortedAttributeQuery(getSortedAttributeQuery())
            .exactQuery(getExactQuery())
            .prefixQuery(getPrefixQuery())
            .rangeQuery(getRangeQuery())
            .textQuery(getTextQuery())
            .itemsForTaxQuery(getItemsForTaxQuery())
            .itemsForModifierListQuery(getItemsForModifierListQuery())
            .itemsForItemOptionsQuery(getItemsForItemOptionsQuery())
            .itemVariationsForItemOptionValuesQuery(getItemVariationsForItemOptionValuesQuery());
            return builder;
    }

    public static class Builder {
        private CatalogQuerySortedAttribute sortedAttributeQuery;
        private CatalogQueryExact exactQuery;
        private CatalogQueryPrefix prefixQuery;
        private CatalogQueryRange rangeQuery;
        private CatalogQueryText textQuery;
        private CatalogQueryItemsForTax itemsForTaxQuery;
        private CatalogQueryItemsForModifierList itemsForModifierListQuery;
        private CatalogQueryItemsForItemOptions itemsForItemOptionsQuery;
        private CatalogQueryItemVariationsForItemOptionValues itemVariationsForItemOptionValuesQuery;

        public Builder() { }

        public Builder sortedAttributeQuery(CatalogQuerySortedAttribute value) {
            sortedAttributeQuery = value;
            return this;
        }
        public Builder exactQuery(CatalogQueryExact value) {
            exactQuery = value;
            return this;
        }
        public Builder prefixQuery(CatalogQueryPrefix value) {
            prefixQuery = value;
            return this;
        }
        public Builder rangeQuery(CatalogQueryRange value) {
            rangeQuery = value;
            return this;
        }
        public Builder textQuery(CatalogQueryText value) {
            textQuery = value;
            return this;
        }
        public Builder itemsForTaxQuery(CatalogQueryItemsForTax value) {
            itemsForTaxQuery = value;
            return this;
        }
        public Builder itemsForModifierListQuery(CatalogQueryItemsForModifierList value) {
            itemsForModifierListQuery = value;
            return this;
        }
        public Builder itemsForItemOptionsQuery(CatalogQueryItemsForItemOptions value) {
            itemsForItemOptionsQuery = value;
            return this;
        }
        public Builder itemVariationsForItemOptionValuesQuery(CatalogQueryItemVariationsForItemOptionValues value) {
            itemVariationsForItemOptionValuesQuery = value;
            return this;
        }

        public CatalogQuery build() {
            return new CatalogQuery(sortedAttributeQuery,
                exactQuery,
                prefixQuery,
                rangeQuery,
                textQuery,
                itemsForTaxQuery,
                itemsForModifierListQuery,
                itemsForItemOptionsQuery,
                itemVariationsForItemOptionValuesQuery);
        }
    }
}
