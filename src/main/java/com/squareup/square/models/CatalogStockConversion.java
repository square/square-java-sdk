
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CatalogStockConversion type.
 */
public class CatalogStockConversion {
    private final String stockableItemVariationId;
    private final String stockableQuantity;
    private final String nonstockableQuantity;

    /**
     * Initialization constructor.
     * @param  stockableItemVariationId  String value for stockableItemVariationId.
     * @param  stockableQuantity  String value for stockableQuantity.
     * @param  nonstockableQuantity  String value for nonstockableQuantity.
     */
    @JsonCreator
    public CatalogStockConversion(
            @JsonProperty("stockable_item_variation_id") String stockableItemVariationId,
            @JsonProperty("stockable_quantity") String stockableQuantity,
            @JsonProperty("nonstockable_quantity") String nonstockableQuantity) {
        this.stockableItemVariationId = stockableItemVariationId;
        this.stockableQuantity = stockableQuantity;
        this.nonstockableQuantity = nonstockableQuantity;
    }

    /**
     * Getter for StockableItemVariationId.
     * References to the stockable [CatalogItemVariation]($m/CatalogItemVariation) for this stock
     * conversion. Selling, receiving or recounting the non-stockable `CatalogItemVariation` defined
     * with a stock conversion results in adjustments of this stockable `CatalogItemVariation`. This
     * immutable field must reference a stockable `CatalogItemVariation` that shares the parent
     * [CatalogItem]($m/CatalogItem) of the converted `CatalogItemVariation.`
     * @return Returns the String
     */
    @JsonGetter("stockable_item_variation_id")
    public String getStockableItemVariationId() {
        return stockableItemVariationId;
    }

    /**
     * Getter for StockableQuantity.
     * The quantity of the stockable item variation (as identified by `stockable_item_variation_id`)
     * equivalent to the non-stockable item variation quantity (as specified in
     * `nonstockable_quantity`) as defined by this stock conversion. It accepts a decimal number in
     * a string format that can take up to 10 digits before the decimal point and up to 5 digits
     * after the decimal point.
     * @return Returns the String
     */
    @JsonGetter("stockable_quantity")
    public String getStockableQuantity() {
        return stockableQuantity;
    }

    /**
     * Getter for NonstockableQuantity.
     * The converted equivalent quantity of the non-stockable
     * [CatalogItemVariation]($m/CatalogItemVariation) in its measurement unit. The
     * `stockable_quantity` value and this `nonstockable_quantity` value together define the
     * conversion ratio between stockable item variation and the non-stockable item variation. It
     * accepts a decimal number in a string format that can take up to 10 digits before the decimal
     * point and up to 5 digits after the decimal point.
     * @return Returns the String
     */
    @JsonGetter("nonstockable_quantity")
    public String getNonstockableQuantity() {
        return nonstockableQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockableItemVariationId, stockableQuantity, nonstockableQuantity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogStockConversion)) {
            return false;
        }
        CatalogStockConversion other = (CatalogStockConversion) obj;
        return Objects.equals(stockableItemVariationId, other.stockableItemVariationId)
            && Objects.equals(stockableQuantity, other.stockableQuantity)
            && Objects.equals(nonstockableQuantity, other.nonstockableQuantity);
    }

    /**
     * Converts this CatalogStockConversion into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogStockConversion [" + "stockableItemVariationId=" + stockableItemVariationId
                + ", stockableQuantity=" + stockableQuantity + ", nonstockableQuantity="
                + nonstockableQuantity + "]";
    }

    /**
     * Builds a new {@link CatalogStockConversion.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogStockConversion.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(stockableItemVariationId, stockableQuantity,
                nonstockableQuantity);
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogStockConversion}.
     */
    public static class Builder {
        private String stockableItemVariationId;
        private String stockableQuantity;
        private String nonstockableQuantity;

        /**
         * Initialization constructor.
         * @param  stockableItemVariationId  String value for stockableItemVariationId.
         * @param  stockableQuantity  String value for stockableQuantity.
         * @param  nonstockableQuantity  String value for nonstockableQuantity.
         */
        public Builder(String stockableItemVariationId, String stockableQuantity,
                String nonstockableQuantity) {
            this.stockableItemVariationId = stockableItemVariationId;
            this.stockableQuantity = stockableQuantity;
            this.nonstockableQuantity = nonstockableQuantity;
        }

        /**
         * Setter for stockableItemVariationId.
         * @param  stockableItemVariationId  String value for stockableItemVariationId.
         * @return Builder
         */
        public Builder stockableItemVariationId(String stockableItemVariationId) {
            this.stockableItemVariationId = stockableItemVariationId;
            return this;
        }

        /**
         * Setter for stockableQuantity.
         * @param  stockableQuantity  String value for stockableQuantity.
         * @return Builder
         */
        public Builder stockableQuantity(String stockableQuantity) {
            this.stockableQuantity = stockableQuantity;
            return this;
        }

        /**
         * Setter for nonstockableQuantity.
         * @param  nonstockableQuantity  String value for nonstockableQuantity.
         * @return Builder
         */
        public Builder nonstockableQuantity(String nonstockableQuantity) {
            this.nonstockableQuantity = nonstockableQuantity;
            return this;
        }

        /**
         * Builds a new {@link CatalogStockConversion} object using the set fields.
         * @return {@link CatalogStockConversion}
         */
        public CatalogStockConversion build() {
            return new CatalogStockConversion(stockableItemVariationId, stockableQuantity,
                    nonstockableQuantity);
        }
    }
}
