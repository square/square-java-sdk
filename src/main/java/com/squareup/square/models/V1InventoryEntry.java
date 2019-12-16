package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1InventoryEntry {

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

    @Override
    public int hashCode() {
        return Objects.hash(variationId, quantityOnHand);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1InventoryEntry)) {
            return false;
        }
        V1InventoryEntry v1InventoryEntry = (V1InventoryEntry) o;
        return Objects.equals(variationId, v1InventoryEntry.variationId) &&
            Objects.equals(quantityOnHand, v1InventoryEntry.quantityOnHand);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .variationId(getVariationId())
            .quantityOnHand(getQuantityOnHand());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private String variationId;
        private Double quantityOnHand;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder variationId(String value) {
            variationId = value;
            return this;
        }
        public Builder quantityOnHand(Double value) {
            quantityOnHand = value;
            return this;
        }

        public V1InventoryEntry build() {
            V1InventoryEntry model = new V1InventoryEntry(variationId,
                quantityOnHand);
            model.httpContext = httpContext;
            return model;
        }
    }
}
