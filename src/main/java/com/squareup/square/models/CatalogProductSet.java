
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogProductSet type.
 */
public class CatalogProductSet {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> productIdsAny;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> productIdsAll;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long quantityExact;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long quantityMin;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long quantityMax;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean allProducts;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  productIdsAny  List of String value for productIdsAny.
     * @param  productIdsAll  List of String value for productIdsAll.
     * @param  quantityExact  Long value for quantityExact.
     * @param  quantityMin  Long value for quantityMin.
     * @param  quantityMax  Long value for quantityMax.
     * @param  allProducts  Boolean value for allProducts.
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

    /**
     * Getter for Name.
     * User-defined name for the product set. For example, "Clearance Items" or "Winter Sale Items".
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for ProductIdsAny.
     * Unique IDs for any `CatalogObject` included in this product set. Any number of these catalog
     * objects can be in an order for a pricing rule to apply. This can be used with
     * `product_ids_all` in a parent `CatalogProductSet` to match groups of products for a bulk
     * discount, such as a discount for an entree and side combo. Only one of `product_ids_all`,
     * `product_ids_any`, or `all_products` can be set. Max: 500 catalog object IDs.
     * @return Returns the List of String
     */
    @JsonGetter("product_ids_any")
    public List<String> getProductIdsAny() {
        return productIdsAny;
    }

    /**
     * Getter for ProductIdsAll.
     * Unique IDs for any `CatalogObject` included in this product set. All objects in this set must
     * be included in an order for a pricing rule to apply. Only one of `product_ids_all`,
     * `product_ids_any`, or `all_products` can be set. Max: 500 catalog object IDs.
     * @return Returns the List of String
     */
    @JsonGetter("product_ids_all")
    public List<String> getProductIdsAll() {
        return productIdsAll;
    }

    /**
     * Getter for QuantityExact.
     * If set, there must be exactly this many items from `products_any` or `products_all` in the
     * cart for the discount to apply. Cannot be combined with either `quantity_min` or
     * `quantity_max`.
     * @return Returns the Long
     */
    @JsonGetter("quantity_exact")
    public Long getQuantityExact() {
        return quantityExact;
    }

    /**
     * Getter for QuantityMin.
     * If set, there must be at least this many items from `products_any` or `products_all` in a
     * cart for the discount to apply. See `quantity_exact`. Defaults to 0 if `quantity_exact`,
     * `quantity_min` and `quantity_max` are all unspecified.
     * @return Returns the Long
     */
    @JsonGetter("quantity_min")
    public Long getQuantityMin() {
        return quantityMin;
    }

    /**
     * Getter for QuantityMax.
     * If set, the pricing rule will apply to a maximum of this many items from `products_any` or
     * `products_all`.
     * @return Returns the Long
     */
    @JsonGetter("quantity_max")
    public Long getQuantityMax() {
        return quantityMax;
    }

    /**
     * Getter for AllProducts.
     * If set to `true`, the product set will include every item in the catalog. Only one of
     * `product_ids_all`, `product_ids_any`, or `all_products` can be set.
     * @return Returns the Boolean
     */
    @JsonGetter("all_products")
    public Boolean getAllProducts() {
        return allProducts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productIdsAny, productIdsAll, quantityExact, quantityMin,
                quantityMax, allProducts);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogProductSet)) {
            return false;
        }
        CatalogProductSet other = (CatalogProductSet) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(productIdsAny, other.productIdsAny)
            && Objects.equals(productIdsAll, other.productIdsAll)
            && Objects.equals(quantityExact, other.quantityExact)
            && Objects.equals(quantityMin, other.quantityMin)
            && Objects.equals(quantityMax, other.quantityMax)
            && Objects.equals(allProducts, other.allProducts);
    }

    /**
     * Converts this CatalogProductSet into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogProductSet [" + "name=" + name + ", productIdsAny=" + productIdsAny
                + ", productIdsAll=" + productIdsAll + ", quantityExact=" + quantityExact
                + ", quantityMin=" + quantityMin + ", quantityMax=" + quantityMax + ", allProducts="
                + allProducts + "]";
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
     * Class to build instances of {@link CatalogProductSet}.
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
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for productIdsAny.
         * @param  productIdsAny  List of String value for productIdsAny.
         * @return Builder
         */
        public Builder productIdsAny(List<String> productIdsAny) {
            this.productIdsAny = productIdsAny;
            return this;
        }

        /**
         * Setter for productIdsAll.
         * @param  productIdsAll  List of String value for productIdsAll.
         * @return Builder
         */
        public Builder productIdsAll(List<String> productIdsAll) {
            this.productIdsAll = productIdsAll;
            return this;
        }

        /**
         * Setter for quantityExact.
         * @param  quantityExact  Long value for quantityExact.
         * @return Builder
         */
        public Builder quantityExact(Long quantityExact) {
            this.quantityExact = quantityExact;
            return this;
        }

        /**
         * Setter for quantityMin.
         * @param  quantityMin  Long value for quantityMin.
         * @return Builder
         */
        public Builder quantityMin(Long quantityMin) {
            this.quantityMin = quantityMin;
            return this;
        }

        /**
         * Setter for quantityMax.
         * @param  quantityMax  Long value for quantityMax.
         * @return Builder
         */
        public Builder quantityMax(Long quantityMax) {
            this.quantityMax = quantityMax;
            return this;
        }

        /**
         * Setter for allProducts.
         * @param  allProducts  Boolean value for allProducts.
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
            return new CatalogProductSet(name, productIdsAny, productIdsAll, quantityExact,
                    quantityMin, quantityMax, allProducts);
        }
    }
}
