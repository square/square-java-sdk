
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CatalogQuery type.
 */
public class CatalogQuery {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQuerySortedAttribute sortedAttributeQuery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQueryExact exactQuery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQuerySet setQuery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQueryPrefix prefixQuery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQueryRange rangeQuery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQueryText textQuery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQueryItemsForTax itemsForTaxQuery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQueryItemsForModifierList itemsForModifierListQuery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQueryItemsForItemOptions itemsForItemOptionsQuery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQueryItemVariationsForItemOptionValues itemVariationsForItemOptionValuesQuery;

    /**
     * Initialization constructor.
     * @param  sortedAttributeQuery  CatalogQuerySortedAttribute value for sortedAttributeQuery.
     * @param  exactQuery  CatalogQueryExact value for exactQuery.
     * @param  setQuery  CatalogQuerySet value for setQuery.
     * @param  prefixQuery  CatalogQueryPrefix value for prefixQuery.
     * @param  rangeQuery  CatalogQueryRange value for rangeQuery.
     * @param  textQuery  CatalogQueryText value for textQuery.
     * @param  itemsForTaxQuery  CatalogQueryItemsForTax value for itemsForTaxQuery.
     * @param  itemsForModifierListQuery  CatalogQueryItemsForModifierList value for
     *         itemsForModifierListQuery.
     * @param  itemsForItemOptionsQuery  CatalogQueryItemsForItemOptions value for
     *         itemsForItemOptionsQuery.
     * @param  itemVariationsForItemOptionValuesQuery  CatalogQueryItemVariationsForItemOptionValues
     *         value for itemVariationsForItemOptionValuesQuery.
     */
    @JsonCreator
    public CatalogQuery(
            @JsonProperty("sorted_attribute_query") CatalogQuerySortedAttribute sortedAttributeQuery,
            @JsonProperty("exact_query") CatalogQueryExact exactQuery,
            @JsonProperty("set_query") CatalogQuerySet setQuery,
            @JsonProperty("prefix_query") CatalogQueryPrefix prefixQuery,
            @JsonProperty("range_query") CatalogQueryRange rangeQuery,
            @JsonProperty("text_query") CatalogQueryText textQuery,
            @JsonProperty("items_for_tax_query") CatalogQueryItemsForTax itemsForTaxQuery,
            @JsonProperty("items_for_modifier_list_query") CatalogQueryItemsForModifierList itemsForModifierListQuery,
            @JsonProperty("items_for_item_options_query") CatalogQueryItemsForItemOptions itemsForItemOptionsQuery,
            @JsonProperty("item_variations_for_item_option_values_query") CatalogQueryItemVariationsForItemOptionValues itemVariationsForItemOptionValuesQuery) {
        this.sortedAttributeQuery = sortedAttributeQuery;
        this.exactQuery = exactQuery;
        this.setQuery = setQuery;
        this.prefixQuery = prefixQuery;
        this.rangeQuery = rangeQuery;
        this.textQuery = textQuery;
        this.itemsForTaxQuery = itemsForTaxQuery;
        this.itemsForModifierListQuery = itemsForModifierListQuery;
        this.itemsForItemOptionsQuery = itemsForItemOptionsQuery;
        this.itemVariationsForItemOptionValuesQuery = itemVariationsForItemOptionValuesQuery;
    }

    /**
     * Getter for SortedAttributeQuery.
     * The query expression to specify the key to sort search results.
     * @return Returns the CatalogQuerySortedAttribute
     */
    @JsonGetter("sorted_attribute_query")
    public CatalogQuerySortedAttribute getSortedAttributeQuery() {
        return sortedAttributeQuery;
    }

    /**
     * Getter for ExactQuery.
     * The query filter to return the search result by exact match of the specified attribute name
     * and value.
     * @return Returns the CatalogQueryExact
     */
    @JsonGetter("exact_query")
    public CatalogQueryExact getExactQuery() {
        return exactQuery;
    }

    /**
     * Getter for SetQuery.
     * The query filter to return the search result(s) by exact match of the specified
     * `attribute_name` and any of the `attribute_values`.
     * @return Returns the CatalogQuerySet
     */
    @JsonGetter("set_query")
    public CatalogQuerySet getSetQuery() {
        return setQuery;
    }

    /**
     * Getter for PrefixQuery.
     * The query filter to return the search result whose named attribute values are prefixed by the
     * specified attribute value.
     * @return Returns the CatalogQueryPrefix
     */
    @JsonGetter("prefix_query")
    public CatalogQueryPrefix getPrefixQuery() {
        return prefixQuery;
    }

    /**
     * Getter for RangeQuery.
     * The query filter to return the search result whose named attribute values fall between the
     * specified range.
     * @return Returns the CatalogQueryRange
     */
    @JsonGetter("range_query")
    public CatalogQueryRange getRangeQuery() {
        return rangeQuery;
    }

    /**
     * Getter for TextQuery.
     * The query filter to return the search result whose searchable attribute values contain all of
     * the specified keywords or tokens, independent of the token order or case.
     * @return Returns the CatalogQueryText
     */
    @JsonGetter("text_query")
    public CatalogQueryText getTextQuery() {
        return textQuery;
    }

    /**
     * Getter for ItemsForTaxQuery.
     * The query filter to return the items containing the specified tax IDs.
     * @return Returns the CatalogQueryItemsForTax
     */
    @JsonGetter("items_for_tax_query")
    public CatalogQueryItemsForTax getItemsForTaxQuery() {
        return itemsForTaxQuery;
    }

    /**
     * Getter for ItemsForModifierListQuery.
     * The query filter to return the items containing the specified modifier list IDs.
     * @return Returns the CatalogQueryItemsForModifierList
     */
    @JsonGetter("items_for_modifier_list_query")
    public CatalogQueryItemsForModifierList getItemsForModifierListQuery() {
        return itemsForModifierListQuery;
    }

    /**
     * Getter for ItemsForItemOptionsQuery.
     * The query filter to return the items containing the specified item option IDs.
     * @return Returns the CatalogQueryItemsForItemOptions
     */
    @JsonGetter("items_for_item_options_query")
    public CatalogQueryItemsForItemOptions getItemsForItemOptionsQuery() {
        return itemsForItemOptionsQuery;
    }

    /**
     * Getter for ItemVariationsForItemOptionValuesQuery.
     * The query filter to return the item variations containing the specified item option value
     * IDs.
     * @return Returns the CatalogQueryItemVariationsForItemOptionValues
     */
    @JsonGetter("item_variations_for_item_option_values_query")
    public CatalogQueryItemVariationsForItemOptionValues getItemVariationsForItemOptionValuesQuery() {
        return itemVariationsForItemOptionValuesQuery;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortedAttributeQuery, exactQuery, setQuery, prefixQuery, rangeQuery,
                textQuery, itemsForTaxQuery, itemsForModifierListQuery, itemsForItemOptionsQuery,
                itemVariationsForItemOptionValuesQuery);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogQuery)) {
            return false;
        }
        CatalogQuery other = (CatalogQuery) obj;
        return Objects.equals(sortedAttributeQuery, other.sortedAttributeQuery)
            && Objects.equals(exactQuery, other.exactQuery)
            && Objects.equals(setQuery, other.setQuery)
            && Objects.equals(prefixQuery, other.prefixQuery)
            && Objects.equals(rangeQuery, other.rangeQuery)
            && Objects.equals(textQuery, other.textQuery)
            && Objects.equals(itemsForTaxQuery, other.itemsForTaxQuery)
            && Objects.equals(itemsForModifierListQuery, other.itemsForModifierListQuery)
            && Objects.equals(itemsForItemOptionsQuery, other.itemsForItemOptionsQuery)
            && Objects.equals(itemVariationsForItemOptionValuesQuery,
                    other.itemVariationsForItemOptionValuesQuery);
    }

    /**
     * Converts this CatalogQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogQuery [" + "sortedAttributeQuery=" + sortedAttributeQuery + ", exactQuery="
                + exactQuery + ", setQuery=" + setQuery + ", prefixQuery=" + prefixQuery
                + ", rangeQuery=" + rangeQuery + ", textQuery=" + textQuery + ", itemsForTaxQuery="
                + itemsForTaxQuery + ", itemsForModifierListQuery=" + itemsForModifierListQuery
                + ", itemsForItemOptionsQuery=" + itemsForItemOptionsQuery
                + ", itemVariationsForItemOptionValuesQuery="
                + itemVariationsForItemOptionValuesQuery + "]";
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
                .setQuery(getSetQuery())
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
     * Class to build instances of {@link CatalogQuery}.
     */
    public static class Builder {
        private CatalogQuerySortedAttribute sortedAttributeQuery;
        private CatalogQueryExact exactQuery;
        private CatalogQuerySet setQuery;
        private CatalogQueryPrefix prefixQuery;
        private CatalogQueryRange rangeQuery;
        private CatalogQueryText textQuery;
        private CatalogQueryItemsForTax itemsForTaxQuery;
        private CatalogQueryItemsForModifierList itemsForModifierListQuery;
        private CatalogQueryItemsForItemOptions itemsForItemOptionsQuery;
        private CatalogQueryItemVariationsForItemOptionValues itemVariationsForItemOptionValuesQuery;



        /**
         * Setter for sortedAttributeQuery.
         * @param  sortedAttributeQuery  CatalogQuerySortedAttribute value for sortedAttributeQuery.
         * @return Builder
         */
        public Builder sortedAttributeQuery(CatalogQuerySortedAttribute sortedAttributeQuery) {
            this.sortedAttributeQuery = sortedAttributeQuery;
            return this;
        }

        /**
         * Setter for exactQuery.
         * @param  exactQuery  CatalogQueryExact value for exactQuery.
         * @return Builder
         */
        public Builder exactQuery(CatalogQueryExact exactQuery) {
            this.exactQuery = exactQuery;
            return this;
        }

        /**
         * Setter for setQuery.
         * @param  setQuery  CatalogQuerySet value for setQuery.
         * @return Builder
         */
        public Builder setQuery(CatalogQuerySet setQuery) {
            this.setQuery = setQuery;
            return this;
        }

        /**
         * Setter for prefixQuery.
         * @param  prefixQuery  CatalogQueryPrefix value for prefixQuery.
         * @return Builder
         */
        public Builder prefixQuery(CatalogQueryPrefix prefixQuery) {
            this.prefixQuery = prefixQuery;
            return this;
        }

        /**
         * Setter for rangeQuery.
         * @param  rangeQuery  CatalogQueryRange value for rangeQuery.
         * @return Builder
         */
        public Builder rangeQuery(CatalogQueryRange rangeQuery) {
            this.rangeQuery = rangeQuery;
            return this;
        }

        /**
         * Setter for textQuery.
         * @param  textQuery  CatalogQueryText value for textQuery.
         * @return Builder
         */
        public Builder textQuery(CatalogQueryText textQuery) {
            this.textQuery = textQuery;
            return this;
        }

        /**
         * Setter for itemsForTaxQuery.
         * @param  itemsForTaxQuery  CatalogQueryItemsForTax value for itemsForTaxQuery.
         * @return Builder
         */
        public Builder itemsForTaxQuery(CatalogQueryItemsForTax itemsForTaxQuery) {
            this.itemsForTaxQuery = itemsForTaxQuery;
            return this;
        }

        /**
         * Setter for itemsForModifierListQuery.
         * @param  itemsForModifierListQuery  CatalogQueryItemsForModifierList value for
         *         itemsForModifierListQuery.
         * @return Builder
         */
        public Builder itemsForModifierListQuery(
                CatalogQueryItemsForModifierList itemsForModifierListQuery) {
            this.itemsForModifierListQuery = itemsForModifierListQuery;
            return this;
        }

        /**
         * Setter for itemsForItemOptionsQuery.
         * @param  itemsForItemOptionsQuery  CatalogQueryItemsForItemOptions value for
         *         itemsForItemOptionsQuery.
         * @return Builder
         */
        public Builder itemsForItemOptionsQuery(
                CatalogQueryItemsForItemOptions itemsForItemOptionsQuery) {
            this.itemsForItemOptionsQuery = itemsForItemOptionsQuery;
            return this;
        }

        /**
         * Setter for itemVariationsForItemOptionValuesQuery.
         * @param  itemVariationsForItemOptionValuesQuery
         *         CatalogQueryItemVariationsForItemOptionValues value for
         *         itemVariationsForItemOptionValuesQuery.
         * @return Builder
         */
        public Builder itemVariationsForItemOptionValuesQuery(
                CatalogQueryItemVariationsForItemOptionValues itemVariationsForItemOptionValuesQuery) {
            this.itemVariationsForItemOptionValuesQuery = itemVariationsForItemOptionValuesQuery;
            return this;
        }

        /**
         * Builds a new {@link CatalogQuery} object using the set fields.
         * @return {@link CatalogQuery}
         */
        public CatalogQuery build() {
            return new CatalogQuery(sortedAttributeQuery, exactQuery, setQuery, prefixQuery,
                    rangeQuery, textQuery, itemsForTaxQuery, itemsForModifierListQuery,
                    itemsForItemOptionsQuery, itemVariationsForItemOptionValuesQuery);
        }
    }
}
