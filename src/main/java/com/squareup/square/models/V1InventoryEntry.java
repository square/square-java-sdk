package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1InventoryEntry type.
 */
public class V1InventoryEntry {

    /**
     * Initialization constructor.
     * @param variationId
     * @param quantityOnHand
     */
    @JsonCreator
    public V1InventoryEntry(
            @JsonProperty("variation_id") String variationId,
            @JsonProperty("quantity_on_hand") Double quantityOnHand) {
        this.variationId = variationId;
        this.quantityOnHand = quantityOnHand;
    }

    private HttpContext httpContext;
    private final String variationId;
    private final Double quantityOnHand;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for VariationId.
     * The variation that the entry corresponds to.
     */
    @JsonGetter("variation_id")
    public String getVariationId() {
        return this.variationId;
    }

    /**
     * Getter for QuantityOnHand.
     * The current available quantity of the item variation.
     */
    @JsonGetter("quantity_on_hand")
    public Double getQuantityOnHand() {
        return this.quantityOnHand;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(variationId, quantityOnHand);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1InventoryEntry)) {
            return false;
        }
        V1InventoryEntry v1InventoryEntry = (V1InventoryEntry) obj;
        return Objects.equals(variationId, v1InventoryEntry.variationId) &&
            Objects.equals(quantityOnHand, v1InventoryEntry.quantityOnHand);
    }

    /**
     * Builds a new {@link V1InventoryEntry.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1InventoryEntry.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .variationId(getVariationId())
            .quantityOnHand(getQuantityOnHand());
            return builder;
    }

    /**
     * Class to build instances of {@link V1InventoryEntry}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String variationId;
        private Double quantityOnHand;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for variationId
         * @param variationId
         * @return Builder
         */
        public Builder variationId(String variationId) {
            this.variationId = variationId;
            return this;
        }
        /**
         * Setter for quantityOnHand
         * @param quantityOnHand
         * @return Builder
         */
        public Builder quantityOnHand(Double quantityOnHand) {
            this.quantityOnHand = quantityOnHand;
            return this;
        }

        /**
         * Builds a new {@link V1InventoryEntry} object using the set fields.
         * @return {@link V1InventoryEntry}
         */
        public V1InventoryEntry build() {
            V1InventoryEntry model = new V1InventoryEntry(variationId,
                quantityOnHand);
            model.httpContext = httpContext;
            return model;
        }
    }
}
