
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchCatalogItemsRequest type.
 */
public class SearchCatalogItemsRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String textFilter;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> categoryIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> stockLevels;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> enabledLocationIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sortOrder;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> productTypes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CustomAttributeFilter> customAttributeFilters;

    /**
     * Initialization constructor.
     * @param  textFilter  String value for textFilter.
     * @param  categoryIds  List of String value for categoryIds.
     * @param  stockLevels  List of String value for stockLevels.
     * @param  enabledLocationIds  List of String value for enabledLocationIds.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     * @param  sortOrder  String value for sortOrder.
     * @param  productTypes  List of String value for productTypes.
     * @param  customAttributeFilters  List of CustomAttributeFilter value for
     *         customAttributeFilters.
     */
    @JsonCreator
    public SearchCatalogItemsRequest(
            @JsonProperty("text_filter") String textFilter,
            @JsonProperty("category_ids") List<String> categoryIds,
            @JsonProperty("stock_levels") List<String> stockLevels,
            @JsonProperty("enabled_location_ids") List<String> enabledLocationIds,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("product_types") List<String> productTypes,
            @JsonProperty("custom_attribute_filters") List<CustomAttributeFilter> customAttributeFilters) {
        this.textFilter = textFilter;
        this.categoryIds = categoryIds;
        this.stockLevels = stockLevels;
        this.enabledLocationIds = enabledLocationIds;
        this.cursor = cursor;
        this.limit = limit;
        this.sortOrder = sortOrder;
        this.productTypes = productTypes;
        this.customAttributeFilters = customAttributeFilters;
    }

    /**
     * Getter for TextFilter.
     * The text filter expression to return items or item variations containing specified text in
     * the `name`, `description`, or `abbreviation` attribute value of an item, or in the `name`,
     * `sku`, or `upc` attribute value of an item variation.
     * @return Returns the String
     */
    @JsonGetter("text_filter")
    public String getTextFilter() {
        return textFilter;
    }

    /**
     * Getter for CategoryIds.
     * The category id query expression to return items containing the specified category IDs.
     * @return Returns the List of String
     */
    @JsonGetter("category_ids")
    public List<String> getCategoryIds() {
        return categoryIds;
    }

    /**
     * Getter for StockLevels.
     * The stock-level query expression to return item variations with the specified stock levels.
     * See [SearchCatalogItemsRequestStockLevel](#type-searchcatalogitemsrequeststocklevel) for
     * possible values
     * @return Returns the List of String
     */
    @JsonGetter("stock_levels")
    public List<String> getStockLevels() {
        return stockLevels;
    }

    /**
     * Getter for EnabledLocationIds.
     * The enabled-location query expression to return items and item variations having specified
     * enabled locations.
     * @return Returns the List of String
     */
    @JsonGetter("enabled_location_ids")
    public List<String> getEnabledLocationIds() {
        return enabledLocationIds;
    }

    /**
     * Getter for Cursor.
     * The pagination token, returned in the previous response, used to fetch the next batch of
     * pending results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to return per page. The default value is 100.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Getter for ProductTypes.
     * The product types query expression to return items or item variations having the specified
     * product types.
     * @return Returns the List of String
     */
    @JsonGetter("product_types")
    public List<String> getProductTypes() {
        return productTypes;
    }

    /**
     * Getter for CustomAttributeFilters.
     * The customer-attribute filter to return items or item variations matching the specified
     * custom attribute expressions. A maximum number of 10 custom attribute expressions are
     * supported in a single call to the [SearchCatalogItems]($e/Catalog/SearchCatalogItems)
     * endpoint.
     * @return Returns the List of CustomAttributeFilter
     */
    @JsonGetter("custom_attribute_filters")
    public List<CustomAttributeFilter> getCustomAttributeFilters() {
        return customAttributeFilters;
    }

    @Override
    public int hashCode() {
        return Objects.hash(textFilter, categoryIds, stockLevels, enabledLocationIds, cursor, limit,
                sortOrder, productTypes, customAttributeFilters);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCatalogItemsRequest)) {
            return false;
        }
        SearchCatalogItemsRequest other = (SearchCatalogItemsRequest) obj;
        return Objects.equals(textFilter, other.textFilter)
            && Objects.equals(categoryIds, other.categoryIds)
            && Objects.equals(stockLevels, other.stockLevels)
            && Objects.equals(enabledLocationIds, other.enabledLocationIds)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit)
            && Objects.equals(sortOrder, other.sortOrder)
            && Objects.equals(productTypes, other.productTypes)
            && Objects.equals(customAttributeFilters, other.customAttributeFilters);
    }

    /**
     * Converts this SearchCatalogItemsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchCatalogItemsRequest [" + "textFilter=" + textFilter + ", categoryIds="
                + categoryIds + ", stockLevels=" + stockLevels + ", enabledLocationIds="
                + enabledLocationIds + ", cursor=" + cursor + ", limit=" + limit + ", sortOrder="
                + sortOrder + ", productTypes=" + productTypes + ", customAttributeFilters="
                + customAttributeFilters + "]";
    }

    /**
     * Builds a new {@link SearchCatalogItemsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchCatalogItemsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .textFilter(getTextFilter())
                .categoryIds(getCategoryIds())
                .stockLevels(getStockLevels())
                .enabledLocationIds(getEnabledLocationIds())
                .cursor(getCursor())
                .limit(getLimit())
                .sortOrder(getSortOrder())
                .productTypes(getProductTypes())
                .customAttributeFilters(getCustomAttributeFilters());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchCatalogItemsRequest}.
     */
    public static class Builder {
        private String textFilter;
        private List<String> categoryIds;
        private List<String> stockLevels;
        private List<String> enabledLocationIds;
        private String cursor;
        private Integer limit;
        private String sortOrder;
        private List<String> productTypes;
        private List<CustomAttributeFilter> customAttributeFilters;



        /**
         * Setter for textFilter.
         * @param  textFilter  String value for textFilter.
         * @return Builder
         */
        public Builder textFilter(String textFilter) {
            this.textFilter = textFilter;
            return this;
        }

        /**
         * Setter for categoryIds.
         * @param  categoryIds  List of String value for categoryIds.
         * @return Builder
         */
        public Builder categoryIds(List<String> categoryIds) {
            this.categoryIds = categoryIds;
            return this;
        }

        /**
         * Setter for stockLevels.
         * @param  stockLevels  List of String value for stockLevels.
         * @return Builder
         */
        public Builder stockLevels(List<String> stockLevels) {
            this.stockLevels = stockLevels;
            return this;
        }

        /**
         * Setter for enabledLocationIds.
         * @param  enabledLocationIds  List of String value for enabledLocationIds.
         * @return Builder
         */
        public Builder enabledLocationIds(List<String> enabledLocationIds) {
            this.enabledLocationIds = enabledLocationIds;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Setter for productTypes.
         * @param  productTypes  List of String value for productTypes.
         * @return Builder
         */
        public Builder productTypes(List<String> productTypes) {
            this.productTypes = productTypes;
            return this;
        }

        /**
         * Setter for customAttributeFilters.
         * @param  customAttributeFilters  List of CustomAttributeFilter value for
         *         customAttributeFilters.
         * @return Builder
         */
        public Builder customAttributeFilters(
                List<CustomAttributeFilter> customAttributeFilters) {
            this.customAttributeFilters = customAttributeFilters;
            return this;
        }

        /**
         * Builds a new {@link SearchCatalogItemsRequest} object using the set fields.
         * @return {@link SearchCatalogItemsRequest}
         */
        public SearchCatalogItemsRequest build() {
            return new SearchCatalogItemsRequest(textFilter, categoryIds, stockLevels,
                    enabledLocationIds, cursor, limit, sortOrder, productTypes,
                    customAttributeFilters);
        }
    }
}
