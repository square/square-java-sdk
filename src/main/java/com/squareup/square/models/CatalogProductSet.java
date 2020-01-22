package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogProductSet type.
 */
public class CatalogProductSet {

    /**
     * Initialization constructor.
     * @param name
     * @param productIdsAny
     * @param productIdsAll
     * @param quantityExact
     * @param quantityMin
     * @param quantityMax
     * @param allProducts
     */
    @JsonCreator
    public CatalogProductSet(
            @JsonProperty("name") String name,
            @JsonProperty("product_ids_any") List<String> productIdsAny,
            @JsonProperty("product_ids_all") List<String> productIdsAll,
            @JsonProperty("quantity_exact") Long quantityExact,
            @JsonProperty("quantity_min") Long quantityMin,
            @JsonProperty("quantity_max") Long quantityMax,
            @JsonProperty("all_products") Boolean allProducts) {
        this.name = name;
        this.productIdsAny = productIdsAny;
        this.productIdsAll = productIdsAll;
        this.quantityExact = quantityExact;
        this.quantityMin = quantityMin;
        this.quantityMax = quantityMax;
        this.allProducts = allProducts;
    }

    private final String name;
    private final List<String> productIdsAny;
    private final List<String> productIdsAll;
    private final Long quantityExact;
    private final Long quantityMin;
    private final Long quantityMax;
    private final Boolean allProducts;
    /**
     * Getter for Name.
     * User-defined name for the product set. For example, "Clearance Items"
     * or "Winter Sale Items".
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for ProductIdsAny.
     * Unique IDs for any `CatalogObject` included in this product set. Any
     * number of these catalog objects can be in an order for a pricing rule to apply.
     * This can be used with `product_ids_all` in a parent `CatalogProductSet` to
     * match groups of products for a bulk discount, such as a discount for an
     * entree and side combo.
     * Only one of `product_ids_all`, `product_ids_any`, or `all_products` can be set.
     * Max: 500 catalog object IDs.
     */
    @JsonGetter("product_ids_any")
    public List<String> getProductIdsAny() {
        return this.productIdsAny;
    }

    /**
     * Getter for ProductIdsAll.
     * Unique IDs for any `CatalogObject` included in this product set.
     * All objects in this set must be included in an order for a pricing rule to apply.
     * Only one of `product_ids_all`, `product_ids_any`, or `all_products` can be set.
     * Max: 500 catalog object IDs.
     */
    @JsonGetter("product_ids_all")
    public List<String> getProductIdsAll() {
        return this.productIdsAll;
    }

    /**
     * Getter for QuantityExact.
     * If set, there must be exactly this many items from `products_any` or `products_all`
     * in the cart for the discount to apply.
     * Cannot be combined with either `quantity_min` or `quantity_max`.
     */
    @JsonGetter("quantity_exact")
    public Long getQuantityExact() {
        return this.quantityExact;
    }

    /**
     * Getter for QuantityMin.
     * If set, there must be at least this many items from `products_any` or `products_all`
     * in a cart for the discount to apply. See `quantity_exact`. Defaults to 0 if
     * `quantity_exact`, `quantity_min` and `quantity_max` are all unspecified.
     */
    @JsonGetter("quantity_min")
    public Long getQuantityMin() {
        return this.quantityMin;
    }

    /**
     * Getter for QuantityMax.
     * If set, the pricing rule will apply to a maximum of this many items from
     * `products_any` or `products_all`.
     */
    @JsonGetter("quantity_max")
    public Long getQuantityMax() {
        return this.quantityMax;
    }

    /**
     * Getter for AllProducts.
     * If set to `true`, the product set will include every item in the catalog.
     * Only one of `product_ids_all`, `product_ids_any`, or `all_products` can be set.
     */
    @JsonGetter("all_products")
    public Boolean getAllProducts() {
        return this.allProducts;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, productIdsAny, productIdsAll, quantityExact, quantityMin,
            quantityMax, allProducts);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogProductSet)) {
            return false;
        }
        CatalogProductSet catalogProductSet = (CatalogProductSet) obj;
        return Objects.equals(name, catalogProductSet.name) &&
            Objects.equals(productIdsAny, catalogProductSet.productIdsAny) &&
            Objects.equals(productIdsAll, catalogProductSet.productIdsAll) &&
            Objects.equals(quantityExact, catalogProductSet.quantityExact) &&
            Objects.equals(quantityMin, catalogProductSet.quantityMin) &&
            Objects.equals(quantityMax, catalogProductSet.quantityMax) &&
            Objects.equals(allProducts, catalogProductSet.allProducts);
    }

    /**
     * Builds a new {@link CatalogProductSet.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogProductSet.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .productIdsAny(getProductIdsAny())
            .productIdsAll(getProductIdsAll())
            .quantityExact(getQuantityExact())
            .quantityMin(getQuantityMin())
            .quantityMax(getQuantityMax())
            .allProducts(getAllProducts());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogProductSet}
     */
    public static class Builder {
        private String name;
        private List<String> productIdsAny;
        private List<String> productIdsAll;
        private Long quantityExact;
        private Long quantityMin;
        private Long quantityMax;
        private Boolean allProducts;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for productIdsAny
         * @param productIdsAny
         * @return Builder
         */
        public Builder productIdsAny(List<String> productIdsAny) {
            this.productIdsAny = productIdsAny;
            return this;
        }
        /**
         * Setter for productIdsAll
         * @param productIdsAll
         * @return Builder
         */
        public Builder productIdsAll(List<String> productIdsAll) {
            this.productIdsAll = productIdsAll;
            return this;
        }
        /**
         * Setter for quantityExact
         * @param quantityExact
         * @return Builder
         */
        public Builder quantityExact(Long quantityExact) {
            this.quantityExact = quantityExact;
            return this;
        }
        /**
         * Setter for quantityMin
         * @param quantityMin
         * @return Builder
         */
        public Builder quantityMin(Long quantityMin) {
            this.quantityMin = quantityMin;
            return this;
        }
        /**
         * Setter for quantityMax
         * @param quantityMax
         * @return Builder
         */
        public Builder quantityMax(Long quantityMax) {
            this.quantityMax = quantityMax;
            return this;
        }
        /**
         * Setter for allProducts
         * @param allProducts
         * @return Builder
         */
        public Builder allProducts(Boolean allProducts) {
            this.allProducts = allProducts;
            return this;
        }

        /**
         * Builds a new {@link CatalogProductSet} object using the set fields.
         * @return {@link CatalogProductSet}
         */
        public CatalogProductSet build() {
            return new CatalogProductSet(name,
                productIdsAny,
                productIdsAll,
                quantityExact,
                quantityMin,
                quantityMax,
                allProducts);
        }
    }
}
