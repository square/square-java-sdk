package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1PaymentItemDetail type.
 */
public class V1PaymentItemDetail {

    /**
     * Initialization constructor.
     * @param categoryName
     * @param sku
     * @param itemId
     * @param itemVariationId
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(categoryName, sku, itemId, itemVariationId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1PaymentItemDetail)) {
            return false;
        }
        V1PaymentItemDetail v1PaymentItemDetail = (V1PaymentItemDetail) obj;
        return Objects.equals(categoryName, v1PaymentItemDetail.categoryName) &&
            Objects.equals(sku, v1PaymentItemDetail.sku) &&
            Objects.equals(itemId, v1PaymentItemDetail.itemId) &&
            Objects.equals(itemVariationId, v1PaymentItemDetail.itemVariationId);
    }

    /**
     * Builds a new {@link V1PaymentItemDetail.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1PaymentItemDetail.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .categoryName(getCategoryName())
            .sku(getSku())
            .itemId(getItemId())
            .itemVariationId(getItemVariationId());
            return builder;
    }

    /**
     * Class to build instances of {@link V1PaymentItemDetail}
     */
    public static class Builder {
        private String categoryName;
        private String sku;
        private String itemId;
        private String itemVariationId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for categoryName
         * @param categoryName
         * @return Builder
         */
        public Builder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }
        /**
         * Setter for sku
         * @param sku
         * @return Builder
         */
        public Builder sku(String sku) {
            this.sku = sku;
            return this;
        }
        /**
         * Setter for itemId
         * @param itemId
         * @return Builder
         */
        public Builder itemId(String itemId) {
            this.itemId = itemId;
            return this;
        }
        /**
         * Setter for itemVariationId
         * @param itemVariationId
         * @return Builder
         */
        public Builder itemVariationId(String itemVariationId) {
            this.itemVariationId = itemVariationId;
            return this;
        }

        /**
         * Builds a new {@link V1PaymentItemDetail} object using the set fields.
         * @return {@link V1PaymentItemDetail}
         */
        public V1PaymentItemDetail build() {
            return new V1PaymentItemDetail(categoryName,
                sku,
                itemId,
                itemVariationId);
        }
    }
}
