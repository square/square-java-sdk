
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1PaymentItemDetail type.
 */
public class V1PaymentItemDetail {
    private final String categoryName;
    private final String sku;
    private final String itemId;
    private final String itemVariationId;

    /**
     * Initialization constructor.
     * @param categoryName String value for categoryName.
     * @param sku String value for sku.
     * @param itemId String value for itemId.
     * @param itemVariationId String value for itemVariationId.
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

    /**
     * Getter for CategoryName.
     * The name of the item's merchant-defined category, if any.
     * @return Returns the String
     */
    @JsonGetter("category_name")
    public String getCategoryName() {
        return this.categoryName;
    }

    /**
     * Getter for Sku.
     * The item's merchant-defined SKU, if any.
     * @return Returns the String
     */
    @JsonGetter("sku")
    public String getSku() {
        return this.sku;
    }

    /**
     * Getter for ItemId.
     * The unique ID of the item purchased, if any.
     * @return Returns the String
     */
    @JsonGetter("item_id")
    public String getItemId() {
        return this.itemId;
    }

    /**
     * Getter for ItemVariationId.
     * The unique ID of the item variation purchased, if any.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1PaymentItemDetail)) {
            return false;
        }
        V1PaymentItemDetail other = (V1PaymentItemDetail) obj;
        return Objects.equals(categoryName, other.categoryName)
            && Objects.equals(sku, other.sku)
            && Objects.equals(itemId, other.itemId)
            && Objects.equals(itemVariationId, other.itemVariationId);
    }

    /**
     * Converts this V1PaymentItemDetail into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1PaymentItemDetail [" + "categoryName=" + categoryName + ", sku=" + sku
                + ", itemId=" + itemId + ", itemVariationId=" + itemVariationId + "]";
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
     * Class to build instances of {@link V1PaymentItemDetail}.
     */
    public static class Builder {
        private String categoryName;
        private String sku;
        private String itemId;
        private String itemVariationId;



        /**
         * Setter for categoryName.
         * @param categoryName String value for categoryName.
         * @return Builder
         */
        public Builder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        /**
         * Setter for sku.
         * @param sku String value for sku.
         * @return Builder
         */
        public Builder sku(String sku) {
            this.sku = sku;
            return this;
        }

        /**
         * Setter for itemId.
         * @param itemId String value for itemId.
         * @return Builder
         */
        public Builder itemId(String itemId) {
            this.itemId = itemId;
            return this;
        }

        /**
         * Setter for itemVariationId.
         * @param itemVariationId String value for itemVariationId.
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
            return new V1PaymentItemDetail(categoryName, sku, itemId, itemVariationId);
        }
    }
}
