package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogProductSet type.
 */
public class CatalogProductSet {
    private final OptionalNullable<String> name;
    private final OptionalNullable<List<String>> productIdsAny;
    private final OptionalNullable<List<String>> productIdsAll;
    private final OptionalNullable<Long> quantityExact;
    private final OptionalNullable<Long> quantityMin;
    private final OptionalNullable<Long> quantityMax;
    private final OptionalNullable<Boolean> allProducts;

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
        this.name = OptionalNullable.of(name);
        this.productIdsAny = OptionalNullable.of(productIdsAny);
        this.productIdsAll = OptionalNullable.of(productIdsAll);
        this.quantityExact = OptionalNullable.of(quantityExact);
        this.quantityMin = OptionalNullable.of(quantityMin);
        this.quantityMax = OptionalNullable.of(quantityMax);
        this.allProducts = OptionalNullable.of(allProducts);
    }

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
    protected CatalogProductSet(
            OptionalNullable<String> name,
            OptionalNullable<List<String>> productIdsAny,
            OptionalNullable<List<String>> productIdsAll,
            OptionalNullable<Long> quantityExact,
            OptionalNullable<Long> quantityMin,
            OptionalNullable<Long> quantityMax,
            OptionalNullable<Boolean> allProducts) {
        this.name = name;
        this.productIdsAny = productIdsAny;
        this.productIdsAll = productIdsAll;
        this.quantityExact = quantityExact;
        this.quantityMin = quantityMin;
        this.quantityMax = quantityMax;
        this.allProducts = allProducts;
    }

    /**
     * Internal Getter for Name.
     * User-defined name for the product set. For example, "Clearance Items" or "Winter Sale Items".
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * User-defined name for the product set. For example, "Clearance Items" or "Winter Sale Items".
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for ProductIdsAny.
     * Unique IDs for any `CatalogObject` included in this product set. Any number of these catalog
     * objects can be in an order for a pricing rule to apply. This can be used with
     * `product_ids_all` in a parent `CatalogProductSet` to match groups of products for a bulk
     * discount, such as a discount for an entree and side combo. Only one of `product_ids_all`,
     * `product_ids_any`, or `all_products` can be set. Max: 500 catalog object IDs.
     * @return Returns the Internal List of String
     */
    @JsonGetter("product_ids_any")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetProductIdsAny() {
        return this.productIdsAny;
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
    @JsonIgnore
    public List<String> getProductIdsAny() {
        return OptionalNullable.getFrom(productIdsAny);
    }

    /**
     * Internal Getter for ProductIdsAll.
     * Unique IDs for any `CatalogObject` included in this product set. All objects in this set must
     * be included in an order for a pricing rule to apply. Only one of `product_ids_all`,
     * `product_ids_any`, or `all_products` can be set. Max: 500 catalog object IDs.
     * @return Returns the Internal List of String
     */
    @JsonGetter("product_ids_all")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetProductIdsAll() {
        return this.productIdsAll;
    }

    /**
     * Getter for ProductIdsAll.
     * Unique IDs for any `CatalogObject` included in this product set. All objects in this set must
     * be included in an order for a pricing rule to apply. Only one of `product_ids_all`,
     * `product_ids_any`, or `all_products` can be set. Max: 500 catalog object IDs.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getProductIdsAll() {
        return OptionalNullable.getFrom(productIdsAll);
    }

    /**
     * Internal Getter for QuantityExact.
     * If set, there must be exactly this many items from `products_any` or `products_all` in the
     * cart for the discount to apply. Cannot be combined with either `quantity_min` or
     * `quantity_max`.
     * @return Returns the Internal Long
     */
    @JsonGetter("quantity_exact")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetQuantityExact() {
        return this.quantityExact;
    }

    /**
     * Getter for QuantityExact.
     * If set, there must be exactly this many items from `products_any` or `products_all` in the
     * cart for the discount to apply. Cannot be combined with either `quantity_min` or
     * `quantity_max`.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getQuantityExact() {
        return OptionalNullable.getFrom(quantityExact);
    }

    /**
     * Internal Getter for QuantityMin.
     * If set, there must be at least this many items from `products_any` or `products_all` in a
     * cart for the discount to apply. See `quantity_exact`. Defaults to 0 if `quantity_exact`,
     * `quantity_min` and `quantity_max` are all unspecified.
     * @return Returns the Internal Long
     */
    @JsonGetter("quantity_min")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetQuantityMin() {
        return this.quantityMin;
    }

    /**
     * Getter for QuantityMin.
     * If set, there must be at least this many items from `products_any` or `products_all` in a
     * cart for the discount to apply. See `quantity_exact`. Defaults to 0 if `quantity_exact`,
     * `quantity_min` and `quantity_max` are all unspecified.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getQuantityMin() {
        return OptionalNullable.getFrom(quantityMin);
    }

    /**
     * Internal Getter for QuantityMax.
     * If set, the pricing rule will apply to a maximum of this many items from `products_any` or
     * `products_all`.
     * @return Returns the Internal Long
     */
    @JsonGetter("quantity_max")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetQuantityMax() {
        return this.quantityMax;
    }

    /**
     * Getter for QuantityMax.
     * If set, the pricing rule will apply to a maximum of this many items from `products_any` or
     * `products_all`.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getQuantityMax() {
        return OptionalNullable.getFrom(quantityMax);
    }

    /**
     * Internal Getter for AllProducts.
     * If set to `true`, the product set will include every item in the catalog. Only one of
     * `product_ids_all`, `product_ids_any`, or `all_products` can be set.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("all_products")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAllProducts() {
        return this.allProducts;
    }

    /**
     * Getter for AllProducts.
     * If set to `true`, the product set will include every item in the catalog. Only one of
     * `product_ids_all`, `product_ids_any`, or `all_products` can be set.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAllProducts() {
        return OptionalNullable.getFrom(allProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productIdsAny, productIdsAll, quantityExact, quantityMin, quantityMax, allProducts);
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
        Builder builder = new Builder();
        builder.name = internalGetName();
        builder.productIdsAny = internalGetProductIdsAny();
        builder.productIdsAll = internalGetProductIdsAll();
        builder.quantityExact = internalGetQuantityExact();
        builder.quantityMin = internalGetQuantityMin();
        builder.quantityMax = internalGetQuantityMax();
        builder.allProducts = internalGetAllProducts();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogProductSet}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private OptionalNullable<List<String>> productIdsAny;
        private OptionalNullable<List<String>> productIdsAll;
        private OptionalNullable<Long> quantityExact;
        private OptionalNullable<Long> quantityMin;
        private OptionalNullable<Long> quantityMax;
        private OptionalNullable<Boolean> allProducts;

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for productIdsAny.
         * @param  productIdsAny  List of String value for productIdsAny.
         * @return Builder
         */
        public Builder productIdsAny(List<String> productIdsAny) {
            this.productIdsAny = OptionalNullable.of(productIdsAny);
            return this;
        }

        /**
         * UnSetter for productIdsAny.
         * @return Builder
         */
        public Builder unsetProductIdsAny() {
            productIdsAny = null;
            return this;
        }

        /**
         * Setter for productIdsAll.
         * @param  productIdsAll  List of String value for productIdsAll.
         * @return Builder
         */
        public Builder productIdsAll(List<String> productIdsAll) {
            this.productIdsAll = OptionalNullable.of(productIdsAll);
            return this;
        }

        /**
         * UnSetter for productIdsAll.
         * @return Builder
         */
        public Builder unsetProductIdsAll() {
            productIdsAll = null;
            return this;
        }

        /**
         * Setter for quantityExact.
         * @param  quantityExact  Long value for quantityExact.
         * @return Builder
         */
        public Builder quantityExact(Long quantityExact) {
            this.quantityExact = OptionalNullable.of(quantityExact);
            return this;
        }

        /**
         * UnSetter for quantityExact.
         * @return Builder
         */
        public Builder unsetQuantityExact() {
            quantityExact = null;
            return this;
        }

        /**
         * Setter for quantityMin.
         * @param  quantityMin  Long value for quantityMin.
         * @return Builder
         */
        public Builder quantityMin(Long quantityMin) {
            this.quantityMin = OptionalNullable.of(quantityMin);
            return this;
        }

        /**
         * UnSetter for quantityMin.
         * @return Builder
         */
        public Builder unsetQuantityMin() {
            quantityMin = null;
            return this;
        }

        /**
         * Setter for quantityMax.
         * @param  quantityMax  Long value for quantityMax.
         * @return Builder
         */
        public Builder quantityMax(Long quantityMax) {
            this.quantityMax = OptionalNullable.of(quantityMax);
            return this;
        }

        /**
         * UnSetter for quantityMax.
         * @return Builder
         */
        public Builder unsetQuantityMax() {
            quantityMax = null;
            return this;
        }

        /**
         * Setter for allProducts.
         * @param  allProducts  Boolean value for allProducts.
         * @return Builder
         */
        public Builder allProducts(Boolean allProducts) {
            this.allProducts = OptionalNullable.of(allProducts);
            return this;
        }

        /**
         * UnSetter for allProducts.
         * @return Builder
         */
        public Builder unsetAllProducts() {
            allProducts = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogProductSet} object using the set fields.
         * @return {@link CatalogProductSet}
         */
        public CatalogProductSet build() {
            return new CatalogProductSet(
                    name, productIdsAny, productIdsAll, quantityExact, quantityMin, quantityMax, allProducts);
        }
    }
}
