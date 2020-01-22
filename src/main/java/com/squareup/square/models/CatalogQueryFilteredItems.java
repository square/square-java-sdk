package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQueryFilteredItems type.
 */
public class CatalogQueryFilteredItems {

    /**
     * Initialization constructor.
     * @param textFilter
     * @param searchVendorCode
     * @param categoryIds
     * @param stockLevels
     * @param enabledLocationIds
     * @param vendorIds
     * @param productTypes
     * @param customAttributeFilters
     * @param doesNotExist
     * @param sortOrder
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(textFilter, searchVendorCode, categoryIds, stockLevels,
            enabledLocationIds, vendorIds, productTypes, customAttributeFilters, doesNotExist,
            sortOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQueryFilteredItems)) {
            return false;
        }
        CatalogQueryFilteredItems catalogQueryFilteredItems = (CatalogQueryFilteredItems) obj;
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
     * Builds a new {@link CatalogQueryFilteredItems.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryFilteredItems.Builder} object
     */
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

    /**
     * Class to build instances of {@link CatalogQueryFilteredItems}
     */
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
         * Setter for searchVendorCode
         * @param searchVendorCode
         * @return Builder
         */
        public Builder searchVendorCode(Boolean searchVendorCode) {
            this.searchVendorCode = searchVendorCode;
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
         * Setter for vendorIds
         * @param vendorIds
         * @return Builder
         */
        public Builder vendorIds(List<String> vendorIds) {
            this.vendorIds = vendorIds;
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
        public Builder customAttributeFilters(List<CatalogQueryFilteredItemsCustomAttributeFilter> customAttributeFilters) {
            this.customAttributeFilters = customAttributeFilters;
            return this;
        }
        /**
         * Setter for doesNotExist
         * @param doesNotExist
         * @return Builder
         */
        public Builder doesNotExist(List<String> doesNotExist) {
            this.doesNotExist = doesNotExist;
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
         * Builds a new {@link CatalogQueryFilteredItems} object using the set fields.
         * @return {@link CatalogQueryFilteredItems}
         */
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
