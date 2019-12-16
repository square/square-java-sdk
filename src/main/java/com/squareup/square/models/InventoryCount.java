package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class InventoryCount {

    @JsonCreator
    public InventoryCount(
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_object_type") String catalogObjectType,
            @JsonProperty("state") String state,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("quantity") String quantity,
            @JsonProperty("calculated_at") String calculatedAt) {
        this.catalogObjectId = catalogObjectId;
        this.catalogObjectType = catalogObjectType;
        this.state = state;
        this.locationId = locationId;
        this.quantity = quantity;
        this.calculatedAt = calculatedAt;
    }

    private final String catalogObjectId;
    private final String catalogObjectType;
    private final String state;
    private final String locationId;
    private final String quantity;
    private final String calculatedAt;

    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectId, catalogObjectType, state, locationId, quantity, calculatedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof InventoryCount)) {
            return false;
        }
        InventoryCount inventoryCount = (InventoryCount) o;
        return Objects.equals(catalogObjectId, inventoryCount.catalogObjectId) &&
            Objects.equals(catalogObjectType, inventoryCount.catalogObjectType) &&
            Objects.equals(state, inventoryCount.state) &&
            Objects.equals(locationId, inventoryCount.locationId) &&
            Objects.equals(quantity, inventoryCount.quantity) &&
            Objects.equals(calculatedAt, inventoryCount.calculatedAt);
    }

    /**
     * Getter for CatalogObjectId.
     * The Square generated ID of the
     * `CatalogObject` being tracked.
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() { 
        return this.catalogObjectId;
    }

    /**
     * Getter for CatalogObjectType.
     * The `CatalogObjectType` of the
     * `CatalogObject` being tracked. Tracking is only
     * supported for the `ITEM_VARIATION` type.
     */
    @JsonGetter("catalog_object_type")
    public String getCatalogObjectType() { 
        return this.catalogObjectType;
    }

    /**
     * Getter for State.
     * Indicates the state of a tracked item quantity in the lifecycle of goods.
     */
    @JsonGetter("state")
    public String getState() { 
        return this.state;
    }

    /**
     * Getter for LocationId.
     * The Square ID of the [Location](#type-location) where the related
     * quantity of items are being tracked.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for Quantity.
     * The number of items affected by the estimated count as a decimal string.
     * Can support up to 5 digits after the decimal point.
     * _Important_: The Point of Sale app and Dashboard do not currently support
     * decimal quantities. If a Point of Sale app or Dashboard attempts to read a
     * decimal quantity on inventory counts or adjustments, the quantity will be rounded
     * down to the nearest integer. For example, `2.5` will become `2`, and `-2.5`
     * will become `-3`.
     * Read [Decimal Quantities (BETA)](https://developer.squareup.com/docs/docs/inventory-api/what-it-does#decimal-quantities-beta) for more information.
     */
    @JsonGetter("quantity")
    public String getQuantity() { 
        return this.quantity;
    }

    /**
     * Getter for CalculatedAt.
     * A read-only timestamp in RFC 3339 format that indicates when Square
     * received the most recent physical count or adjustment that had an affect
     * on the estimated count.
     */
    @JsonGetter("calculated_at")
    public String getCalculatedAt() { 
        return this.calculatedAt;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogObjectId(getCatalogObjectId())
            .catalogObjectType(getCatalogObjectType())
            .state(getState())
            .locationId(getLocationId())
            .quantity(getQuantity())
            .calculatedAt(getCalculatedAt());
            return builder;
    }

    public static class Builder {
        private String catalogObjectId;
        private String catalogObjectType;
        private String state;
        private String locationId;
        private String quantity;
        private String calculatedAt;

        public Builder() { }

        public Builder catalogObjectId(String value) {
            catalogObjectId = value;
            return this;
        }
        public Builder catalogObjectType(String value) {
            catalogObjectType = value;
            return this;
        }
        public Builder state(String value) {
            state = value;
            return this;
        }
        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder quantity(String value) {
            quantity = value;
            return this;
        }
        public Builder calculatedAt(String value) {
            calculatedAt = value;
            return this;
        }

        public InventoryCount build() {
            return new InventoryCount(catalogObjectId,
                catalogObjectType,
                state,
                locationId,
                quantity,
                calculatedAt);
        }
    }
}
