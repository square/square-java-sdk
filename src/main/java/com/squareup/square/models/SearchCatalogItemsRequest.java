package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchCatalogItemsRequest type.
 */
public class SearchCatalogItemsRequest {

    /**
     * Initialization constructor.
     * @param textFilter
     * @param categoryIds
     * @param stockLevels
     * @param enabledLocationIds
     * @param cursor
     * @param limit
     * @param sortOrder
     * @param productTypes
     * @param customAttributeFilters
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

    private final String textFilter;
    private final List<String> categoryIds;
    private final List<String> stockLevels;
    private final List<String> enabledLocationIds;
    private final String cursor;
    private final Integer limit;
    private final String sortOrder;
    private final List<String> productTypes;
    private final List<CustomAttributeFilter> customAttributeFilters;
    /**
     * Getter for TextFilter.
     * The text filter expression to return items or item variations containing specified text in
     * the `name`, `description`, or `abbreviation` attribute value of an item, or in
     * the `name`, `sku`, or `upc` attribute value of an item variation.
     */
    @JsonGetter("text_filter")
    public String getTextFilter() {
        return this.textFilter;
    }

    /**
     * Getter for CategoryIds.
     * The category id query expression to return items containing the specified category IDs.
     */
    @JsonGetter("category_ids")
    public List<String> getCategoryIds() {
        return this.categoryIds;
    }

    /**
     * Getter for StockLevels.
     * The stock-level query expression to return item variations with the specified stock levels.
     * See [SearchCatalogItemsRequestStockLevel](#type-searchcatalogitemsrequeststocklevel) for possible values
     */
    @JsonGetter("stock_levels")
    public List<String> getStockLevels() {
        return this.stockLevels;
    }

    /**
     * Getter for EnabledLocationIds.
     * The enabled-location query expression to return items and item variations having specified enabled locations.
     */
    @JsonGetter("enabled_location_ids")
    public List<String> getEnabledLocationIds() {
        return this.enabledLocationIds;
    }

    /**
     * Getter for Cursor.
     * The pagination token, returned in the previous response, used to fetch the next batch of pending results.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to return per page. The default value is 100.
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     */
    @JsonGetter("sort_order")
    public String getSortOrder() {
        return this.sortOrder;
    }

    /**
     * Getter for ProductTypes.
     * The product types query expression to return items or item variations having the specified product types.
     * See [CatalogItemProductType](#type-catalogitemproducttype) for possible values
     */
    @JsonGetter("product_types")
    public List<String> getProductTypes() {
        return this.productTypes;
    }

    /**
     * Getter for CustomAttributeFilters.
     * The customer-attribute filter to return items or item variations matching the specified
     * custom attribute expressions. A maximum number of 10 custom attribute expressions are supported in
     * a single call to the [SearchCatalogItems](#endpoint-Catalog-SearchCatalogItems) endpoint.
     */
    @JsonGetter("custom_attribute_filters")
    public List<CustomAttributeFilter> getCustomAttributeFilters() {
        return this.customAttributeFilters;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(textFilter, categoryIds, stockLevels, enabledLocationIds, cursor, limit,
            sortOrder, productTypes, customAttributeFilters);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchCatalogItemsRequest)) {
            return false;
        }
        SearchCatalogItemsRequest searchCatalogItemsRequest = (SearchCatalogItemsRequest) obj;
        return Objects.equals(textFilter, searchCatalogItemsRequest.textFilter) &&
            Objects.equals(categoryIds, searchCatalogItemsRequest.categoryIds) &&
            Objects.equals(stockLevels, searchCatalogItemsRequest.stockLevels) &&
            Objects.equals(enabledLocationIds, searchCatalogItemsRequest.enabledLocationIds) &&
            Objects.equals(cursor, searchCatalogItemsRequest.cursor) &&
            Objects.equals(limit, searchCatalogItemsRequest.limit) &&
            Objects.equals(sortOrder, searchCatalogItemsRequest.sortOrder) &&
            Objects.equals(productTypes, searchCatalogItemsRequest.productTypes) &&
            Objects.equals(customAttributeFilters, searchCatalogItemsRequest.customAttributeFilters);
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
     * Class to build instances of {@link SearchCatalogItemsRequest}
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
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for textFilter
         * @param textFilter
         * @return Builder
         */
        public Builder textFilter(String textFilter) {
            this.textFilter = textFilter;
            return this;
        }
        /**
         * Setter for categoryIds
         * @param categoryIds
         * @return Builder
         */
        public Builder categoryIds(List<String> categoryIds) {
            this.categoryIds = categoryIds;
            return this;
        }
        /**
         * Setter for stockLevels
         * @param stockLevels
         * @return Builder
         */
        public Builder stockLevels(List<String> stockLevels) {
            this.stockLevels = stockLevels;
            return this;
        }
        /**
         * Setter for enabledLocationIds
         * @param enabledLocationIds
         * @return Builder
         */
        public Builder enabledLocationIds(List<String> enabledLocationIds) {
            this.enabledLocationIds = enabledLocationIds;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }
        /**
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }
        /**
         * Setter for sortOrder
         * @param sortOrder
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }
        /**
         * Setter for productTypes
         * @param productTypes
         * @return Builder
         */
        public Builder productTypes(List<String> productTypes) {
            this.productTypes = productTypes;
            return this;
        }
        /**
         * Setter for customAttributeFilters
         * @param customAttributeFilters
         * @return Builder
         */
        public Builder customAttributeFilters(List<CustomAttributeFilter> customAttributeFilters) {
            this.customAttributeFilters = customAttributeFilters;
            return this;
        }

        /**
         * Builds a new {@link SearchCatalogItemsRequest} object using the set fields.
         * @return {@link SearchCatalogItemsRequest}
         */
        public SearchCatalogItemsRequest build() {
            return new SearchCatalogItemsRequest(textFilter,
                categoryIds,
                stockLevels,
                enabledLocationIds,
                cursor,
                limit,
                sortOrder,
                productTypes,
                customAttributeFilters);
        }
    }
}
