package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryFilteredItems {

    @JsonCreator
    public CatalogQueryFilteredItems(
            @JsonProperty("text_filter") String textFilter,
            @JsonProperty("search_vendor_code") Boolean searchVendorCode,
            @JsonProperty("category_ids") List<String> categoryIds,
            @JsonProperty("stock_levels") List<String> stockLevels,
            @JsonProperty("enabled_location_ids") List<String> enabledLocationIds,
            @JsonProperty("vendor_ids") List<String> vendorIds,
            @JsonProperty("product_types") List<String> productTypes,
            @JsonProperty("custom_attribute_filters") List<CatalogQueryFilteredItemsCustomAttributeFilter> customAttributeFilters,
            @JsonProperty("does_not_exist") List<String> doesNotExist,
            @JsonProperty("sort_order") String sortOrder) {
        this.textFilter = textFilter;
        this.searchVendorCode = searchVendorCode;
        this.categoryIds = categoryIds;
        this.stockLevels = stockLevels;
        this.enabledLocationIds = enabledLocationIds;
        this.vendorIds = vendorIds;
        this.productTypes = productTypes;
        this.customAttributeFilters = customAttributeFilters;
        this.doesNotExist = doesNotExist;
        this.sortOrder = sortOrder;
    }

    private final String textFilter;
    private final Boolean searchVendorCode;
    private final List<String> categoryIds;
    private final List<String> stockLevels;
    private final List<String> enabledLocationIds;
    private final List<String> vendorIds;
    private final List<String> productTypes;
    private final List<CatalogQueryFilteredItemsCustomAttributeFilter> customAttributeFilters;
    private final List<String> doesNotExist;
    private final String sortOrder;

    @Override
    public int hashCode() {
        return Objects.hash(textFilter, searchVendorCode, categoryIds, stockLevels, enabledLocationIds, vendorIds, productTypes, customAttributeFilters, doesNotExist, sortOrder);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryFilteredItems)) {
            return false;
        }
        CatalogQueryFilteredItems catalogQueryFilteredItems = (CatalogQueryFilteredItems) o;
        return Objects.equals(textFilter, catalogQueryFilteredItems.textFilter) &&
            Objects.equals(searchVendorCode, catalogQueryFilteredItems.searchVendorCode) &&
            Objects.equals(categoryIds, catalogQueryFilteredItems.categoryIds) &&
            Objects.equals(stockLevels, catalogQueryFilteredItems.stockLevels) &&
            Objects.equals(enabledLocationIds, catalogQueryFilteredItems.enabledLocationIds) &&
            Objects.equals(vendorIds, catalogQueryFilteredItems.vendorIds) &&
            Objects.equals(productTypes, catalogQueryFilteredItems.productTypes) &&
            Objects.equals(customAttributeFilters, catalogQueryFilteredItems.customAttributeFilters) &&
            Objects.equals(doesNotExist, catalogQueryFilteredItems.doesNotExist) &&
            Objects.equals(sortOrder, catalogQueryFilteredItems.sortOrder);
    }

    /**
     * Getter for TextFilter.
     */
    @JsonGetter("text_filter")
    public String getTextFilter() { 
        return this.textFilter;
    }

    /**
     * Getter for SearchVendorCode.
     */
    @JsonGetter("search_vendor_code")
    public Boolean getSearchVendorCode() { 
        return this.searchVendorCode;
    }

    /**
     * Getter for CategoryIds.
     */
    @JsonGetter("category_ids")
    public List<String> getCategoryIds() { 
        return this.categoryIds;
    }

    /**
     * Getter for StockLevels.
     * See [CatalogQueryFilteredItemsStockLevel](#type-catalogqueryfiltereditemsstocklevel) for possible values
     */
    @JsonGetter("stock_levels")
    public List<String> getStockLevels() { 
        return this.stockLevels;
    }

    /**
     * Getter for EnabledLocationIds.
     */
    @JsonGetter("enabled_location_ids")
    public List<String> getEnabledLocationIds() { 
        return this.enabledLocationIds;
    }

    /**
     * Getter for VendorIds.
     */
    @JsonGetter("vendor_ids")
    public List<String> getVendorIds() { 
        return this.vendorIds;
    }

    /**
     * Getter for ProductTypes.
     * See [CatalogItemProductType](#type-catalogitemproducttype) for possible values
     */
    @JsonGetter("product_types")
    public List<String> getProductTypes() { 
        return this.productTypes;
    }

    /**
     * Getter for CustomAttributeFilters.
     */
    @JsonGetter("custom_attribute_filters")
    public List<CatalogQueryFilteredItemsCustomAttributeFilter> getCustomAttributeFilters() { 
        return this.customAttributeFilters;
    }

    /**
     * Getter for DoesNotExist.
     * See [CatalogQueryFilteredItemsNullableAttribute](#type-catalogqueryfiltereditemsnullableattribute) for possible values
     */
    @JsonGetter("does_not_exist")
    public List<String> getDoesNotExist() { 
        return this.doesNotExist;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     */
    @JsonGetter("sort_order")
    public String getSortOrder() { 
        return this.sortOrder;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .textFilter(getTextFilter())
            .searchVendorCode(getSearchVendorCode())
            .categoryIds(getCategoryIds())
            .stockLevels(getStockLevels())
            .enabledLocationIds(getEnabledLocationIds())
            .vendorIds(getVendorIds())
            .productTypes(getProductTypes())
            .customAttributeFilters(getCustomAttributeFilters())
            .doesNotExist(getDoesNotExist())
            .sortOrder(getSortOrder());
            return builder;
    }

    public static class Builder {
        private String textFilter;
        private Boolean searchVendorCode;
        private List<String> categoryIds;
        private List<String> stockLevels;
        private List<String> enabledLocationIds;
        private List<String> vendorIds;
        private List<String> productTypes;
        private List<CatalogQueryFilteredItemsCustomAttributeFilter> customAttributeFilters;
        private List<String> doesNotExist;
        private String sortOrder;

        public Builder() { }

        public Builder textFilter(String value) {
            textFilter = value;
            return this;
        }
        public Builder searchVendorCode(Boolean value) {
            searchVendorCode = value;
            return this;
        }
        public Builder categoryIds(List<String> value) {
            categoryIds = value;
            return this;
        }
        public Builder stockLevels(List<String> value) {
            stockLevels = value;
            return this;
        }
        public Builder enabledLocationIds(List<String> value) {
            enabledLocationIds = value;
            return this;
        }
        public Builder vendorIds(List<String> value) {
            vendorIds = value;
            return this;
        }
        public Builder productTypes(List<String> value) {
            productTypes = value;
            return this;
        }
        public Builder customAttributeFilters(List<CatalogQueryFilteredItemsCustomAttributeFilter> value) {
            customAttributeFilters = value;
            return this;
        }
        public Builder doesNotExist(List<String> value) {
            doesNotExist = value;
            return this;
        }
        public Builder sortOrder(String value) {
            sortOrder = value;
            return this;
        }

        public CatalogQueryFilteredItems build() {
            return new CatalogQueryFilteredItems(textFilter,
                searchVendorCode,
                categoryIds,
                stockLevels,
                enabledLocationIds,
                vendorIds,
                productTypes,
                customAttributeFilters,
                doesNotExist,
                sortOrder);
        }
    }
}
