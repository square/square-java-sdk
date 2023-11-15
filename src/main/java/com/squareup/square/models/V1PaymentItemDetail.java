
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for V1PaymentItemDetail type.
 */
public class V1PaymentItemDetail {
    private final OptionalNullable<String> categoryName;
    private final OptionalNullable<String> sku;
    private final OptionalNullable<String> itemId;
    private final OptionalNullable<String> itemVariationId;

    /**
     * Initialization constructor.
     * @param  categoryName  String value for categoryName.
     * @param  sku  String value for sku.
     * @param  itemId  String value for itemId.
     * @param  itemVariationId  String value for itemVariationId.
     */
    @JsonCreator
    public V1PaymentItemDetail(
            @JsonProperty("category_name") String categoryName,
            @JsonProperty("sku") String sku,
            @JsonProperty("item_id") String itemId,
            @JsonProperty("item_variation_id") String itemVariationId) {
        this.categoryName = OptionalNullable.of(categoryName);
        this.sku = OptionalNullable.of(sku);
        this.itemId = OptionalNullable.of(itemId);
        this.itemVariationId = OptionalNullable.of(itemVariationId);
    }

    /**
     * Initialization constructor.
     * @param  categoryName  String value for categoryName.
     * @param  sku  String value for sku.
     * @param  itemId  String value for itemId.
     * @param  itemVariationId  String value for itemVariationId.
     */

    protected V1PaymentItemDetail(OptionalNullable<String> categoryName,
            OptionalNullable<String> sku, OptionalNullable<String> itemId,
            OptionalNullable<String> itemVariationId) {
        this.categoryName = categoryName;
        this.sku = sku;
        this.itemId = itemId;
        this.itemVariationId = itemVariationId;
    }

    /**
     * Internal Getter for CategoryName.
     * The name of the item's merchant-defined category, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("category_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCategoryName() {
        return this.categoryName;
    }

    /**
     * Getter for CategoryName.
     * The name of the item's merchant-defined category, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCategoryName() {
        return OptionalNullable.getFrom(categoryName);
    }

    /**
     * Internal Getter for Sku.
     * The item's merchant-defined SKU, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("sku")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSku() {
        return this.sku;
    }

    /**
     * Getter for Sku.
     * The item's merchant-defined SKU, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSku() {
        return OptionalNullable.getFrom(sku);
    }

    /**
     * Internal Getter for ItemId.
     * The unique ID of the item purchased, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("item_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetItemId() {
        return this.itemId;
    }

    /**
     * Getter for ItemId.
     * The unique ID of the item purchased, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getItemId() {
        return OptionalNullable.getFrom(itemId);
    }

    /**
     * Internal Getter for ItemVariationId.
     * The unique ID of the item variation purchased, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("item_variation_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetItemVariationId() {
        return this.itemVariationId;
    }

    /**
     * Getter for ItemVariationId.
     * The unique ID of the item variation purchased, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getItemVariationId() {
        return OptionalNullable.getFrom(itemVariationId);
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
        Builder builder = new Builder();
        builder.categoryName = internalGetCategoryName();
        builder.sku = internalGetSku();
        builder.itemId = internalGetItemId();
        builder.itemVariationId = internalGetItemVariationId();
        return builder;
    }

    /**
     * Class to build instances of {@link V1PaymentItemDetail}.
     */
    public static class Builder {
        private OptionalNullable<String> categoryName;
        private OptionalNullable<String> sku;
        private OptionalNullable<String> itemId;
        private OptionalNullable<String> itemVariationId;



        /**
         * Setter for categoryName.
         * @param  categoryName  String value for categoryName.
         * @return Builder
         */
        public Builder categoryName(String categoryName) {
            this.categoryName = OptionalNullable.of(categoryName);
            return this;
        }

        /**
         * UnSetter for categoryName.
         * @return Builder
         */
        public Builder unsetCategoryName() {
            categoryName = null;
            return this;
        }

        /**
         * Setter for sku.
         * @param  sku  String value for sku.
         * @return Builder
         */
        public Builder sku(String sku) {
            this.sku = OptionalNullable.of(sku);
            return this;
        }

        /**
         * UnSetter for sku.
         * @return Builder
         */
        public Builder unsetSku() {
            sku = null;
            return this;
        }

        /**
         * Setter for itemId.
         * @param  itemId  String value for itemId.
         * @return Builder
         */
        public Builder itemId(String itemId) {
            this.itemId = OptionalNullable.of(itemId);
            return this;
        }

        /**
         * UnSetter for itemId.
         * @return Builder
         */
        public Builder unsetItemId() {
            itemId = null;
            return this;
        }

        /**
         * Setter for itemVariationId.
         * @param  itemVariationId  String value for itemVariationId.
         * @return Builder
         */
        public Builder itemVariationId(String itemVariationId) {
            this.itemVariationId = OptionalNullable.of(itemVariationId);
            return this;
        }

        /**
         * UnSetter for itemVariationId.
         * @return Builder
         */
        public Builder unsetItemVariationId() {
            itemVariationId = null;
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
