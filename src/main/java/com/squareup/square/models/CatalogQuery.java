package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQuery type.
 */
public class CatalogQuery {

    /**
     * Initialization constructor.
     * @param sortedAttributeQuery
     * @param exactQuery
     * @param prefixQuery
     * @param rangeQuery
     * @param textQuery
     * @param itemsForTaxQuery
     * @param itemsForModifierListQuery
     * @param itemsForItemOptionsQuery
     * @param itemVariationsForItemOptionValuesQuery
     */
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
    /**
     * Getter for SortedAttributeQuery.
     * The query expression to specify the key to sort search results.
     */
    @JsonGetter("sorted_attribute_query")
    public CatalogQuerySortedAttribute getSortedAttributeQuery() {
        return this.sortedAttributeQuery;
    }

    /**
     * Getter for ExactQuery.
     * The query filter to return the serch result by exact match of the specified attribute name and value.
     */
    @JsonGetter("exact_query")
    public CatalogQueryExact getExactQuery() {
        return this.exactQuery;
    }

    /**
     * Getter for PrefixQuery.
     * The query filter to return the search result whose named attribute values are prefixed by the specified attribute value.
     */
    @JsonGetter("prefix_query")
    public CatalogQueryPrefix getPrefixQuery() {
        return this.prefixQuery;
    }

    /**
     * Getter for RangeQuery.
     * The query filter to return the search result whose named attribute values fall between the specified range.
     */
    @JsonGetter("range_query")
    public CatalogQueryRange getRangeQuery() {
        return this.rangeQuery;
    }

    /**
     * Getter for TextQuery.
     * The query filter to return the search result whose searchable attribute values contain all of the specified keywords or tokens, independent of the token order or case.
     */
    @JsonGetter("text_query")
    public CatalogQueryText getTextQuery() {
        return this.textQuery;
    }

    /**
     * Getter for ItemsForTaxQuery.
     * The query filter to return the items containing the specified tax IDs.
     */
    @JsonGetter("items_for_tax_query")
    public CatalogQueryItemsForTax getItemsForTaxQuery() {
        return this.itemsForTaxQuery;
    }

    /**
     * Getter for ItemsForModifierListQuery.
     * The query filter to return the items containing the specified modifier list IDs.
     */
    @JsonGetter("items_for_modifier_list_query")
    public CatalogQueryItemsForModifierList getItemsForModifierListQuery() {
        return this.itemsForModifierListQuery;
    }

    /**
     * Getter for ItemsForItemOptionsQuery.
     * The query filter to return the items containing the specified item option IDs.
     */
    @JsonGetter("items_for_item_options_query")
    public CatalogQueryItemsForItemOptions getItemsForItemOptionsQuery() {
        return this.itemsForItemOptionsQuery;
    }

    /**
     * Getter for ItemVariationsForItemOptionValuesQuery.
     * The query filter to return the item variations containing the specified item option value IDs.
     */
    @JsonGetter("item_variations_for_item_option_values_query")
    public CatalogQueryItemVariationsForItemOptionValues getItemVariationsForItemOptionValuesQuery() {
        return this.itemVariationsForItemOptionValuesQuery;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(sortedAttributeQuery, exactQuery, prefixQuery, rangeQuery, textQuery,
            itemsForTaxQuery, itemsForModifierListQuery, itemsForItemOptionsQuery,
            itemVariationsForItemOptionValuesQuery);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQuery)) {
            return false;
        }
        CatalogQuery catalogQuery = (CatalogQuery) obj;
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
     * Builds a new {@link CatalogQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQuery.Builder} object
     */
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

    /**
     * Class to build instances of {@link CatalogQuery}
     */
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

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for sortedAttributeQuery
         * @param sortedAttributeQuery
         * @return Builder
         */
        public Builder sortedAttributeQuery(CatalogQuerySortedAttribute sortedAttributeQuery) {
            this.sortedAttributeQuery = sortedAttributeQuery;
            return this;
        }
        /**
         * Setter for exactQuery
         * @param exactQuery
         * @return Builder
         */
        public Builder exactQuery(CatalogQueryExact exactQuery) {
            this.exactQuery = exactQuery;
            return this;
        }
        /**
         * Setter for prefixQuery
         * @param prefixQuery
         * @return Builder
         */
        public Builder prefixQuery(CatalogQueryPrefix prefixQuery) {
            this.prefixQuery = prefixQuery;
            return this;
        }
        /**
         * Setter for rangeQuery
         * @param rangeQuery
         * @return Builder
         */
        public Builder rangeQuery(CatalogQueryRange rangeQuery) {
            this.rangeQuery = rangeQuery;
            return this;
        }
        /**
         * Setter for textQuery
         * @param textQuery
         * @return Builder
         */
        public Builder textQuery(CatalogQueryText textQuery) {
            this.textQuery = textQuery;
            return this;
        }
        /**
         * Setter for itemsForTaxQuery
         * @param itemsForTaxQuery
         * @return Builder
         */
        public Builder itemsForTaxQuery(CatalogQueryItemsForTax itemsForTaxQuery) {
            this.itemsForTaxQuery = itemsForTaxQuery;
            return this;
        }
        /**
         * Setter for itemsForModifierListQuery
         * @param itemsForModifierListQuery
         * @return Builder
         */
        public Builder itemsForModifierListQuery(CatalogQueryItemsForModifierList itemsForModifierListQuery) {
            this.itemsForModifierListQuery = itemsForModifierListQuery;
            return this;
        }
        /**
         * Setter for itemsForItemOptionsQuery
         * @param itemsForItemOptionsQuery
         * @return Builder
         */
        public Builder itemsForItemOptionsQuery(CatalogQueryItemsForItemOptions itemsForItemOptionsQuery) {
            this.itemsForItemOptionsQuery = itemsForItemOptionsQuery;
            return this;
        }
        /**
         * Setter for itemVariationsForItemOptionValuesQuery
         * @param itemVariationsForItemOptionValuesQuery
         * @return Builder
         */
        public Builder itemVariationsForItemOptionValuesQuery(CatalogQueryItemVariationsForItemOptionValues itemVariationsForItemOptionValuesQuery) {
            this.itemVariationsForItemOptionValuesQuery = itemVariationsForItemOptionValuesQuery;
            return this;
        }

        /**
         * Builds a new {@link CatalogQuery} object using the set fields.
         * @return {@link CatalogQuery}
         */
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
