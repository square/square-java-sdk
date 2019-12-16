package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1PaymentItemDetail {

    @JsonCreator
    public V1PaymentItemDetail(
            @JsonProperty("category_name") String categoryName,
            @JsonProperty("sku") String sku,
            @JsonProperty("item_id") String itemId,
            @JsonProperty("item_variation_id") String itemVariationId) {
        this.categoryName = categoryName;
        this.sku = sku;
        this.itemId = itemId;
        this.itemVariationId = itemVariationId;
    }

    private final String categoryName;
    private final String sku;
    private final String itemId;
    private final String itemVariationId;

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, sku, itemId, itemVariationId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1PaymentItemDetail)) {
            return false;
        }
        V1PaymentItemDetail v1PaymentItemDetail = (V1PaymentItemDetail) o;
        return Objects.equals(categoryName, v1PaymentItemDetail.categoryName) &&
            Objects.equals(sku, v1PaymentItemDetail.sku) &&
            Objects.equals(itemId, v1PaymentItemDetail.itemId) &&
            Objects.equals(itemVariationId, v1PaymentItemDetail.itemVariationId);
    }

    /**
     * Getter for CategoryName.
     * The name of the item's merchant-defined category, if any.
     */
    @JsonGetter("category_name")
    public String getCategoryName() { 
        return this.categoryName;
    }

    /**
     * Getter for Sku.
     * The item's merchant-defined SKU, if any.
     */
    @JsonGetter("sku")
    public String getSku() { 
        return this.sku;
    }

    /**
     * Getter for ItemId.
     * The unique ID of the item purchased, if any.
     */
    @JsonGetter("item_id")
    public String getItemId() { 
        return this.itemId;
    }

    /**
     * Getter for ItemVariationId.
     * The unique ID of the item variation purchased, if any.
     */
    @JsonGetter("item_variation_id")
    public String getItemVariationId() { 
        return this.itemVariationId;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .categoryName(getCategoryName())
            .sku(getSku())
            .itemId(getItemId())
            .itemVariationId(getItemVariationId());
            return builder;
    }

    public static class Builder {
        private String categoryName;
        private String sku;
        private String itemId;
        private String itemVariationId;

        public Builder() { }

        public Builder categoryName(String value) {
            categoryName = value;
            return this;
        }
        public Builder sku(String value) {
            sku = value;
            return this;
        }
        public Builder itemId(String value) {
            itemId = value;
            return this;
        }
        public Builder itemVariationId(String value) {
            itemVariationId = value;
            return this;
        }

        public V1PaymentItemDetail build() {
            return new V1PaymentItemDetail(categoryName,
                sku,
                itemId,
                itemVariationId);
        }
    }
}
