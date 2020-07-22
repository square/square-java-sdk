package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for InventoryCount type.
 */
public class InventoryCount {

    /**
     * Initialization constructor.
     * @param catalogObjectId
     * @param catalogObjectType
     * @param state
     * @param locationId
     * @param quantity
     * @param calculatedAt
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectId, catalogObjectType, state, locationId, quantity,
            calculatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof InventoryCount)) {
            return false;
        }
        InventoryCount inventoryCount = (InventoryCount) obj;
        return Objects.equals(catalogObjectId, inventoryCount.catalogObjectId) &&
            Objects.equals(catalogObjectType, inventoryCount.catalogObjectType) &&
            Objects.equals(state, inventoryCount.state) &&
            Objects.equals(locationId, inventoryCount.locationId) &&
            Objects.equals(quantity, inventoryCount.quantity) &&
            Objects.equals(calculatedAt, inventoryCount.calculatedAt);
    }

    /**
     * Builds a new {@link InventoryCount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InventoryCount.Builder} object
     */
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

    /**
     * Class to build instances of {@link InventoryCount}
     */
    public static class Builder {
        private String catalogObjectId;
        private String catalogObjectType;
        private String state;
        private String locationId;
        private String quantity;
        private String calculatedAt;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for catalogObjectId
         * @param catalogObjectId
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }
        /**
         * Setter for catalogObjectType
         * @param catalogObjectType
         * @return Builder
         */
        public Builder catalogObjectType(String catalogObjectType) {
            this.catalogObjectType = catalogObjectType;
            return this;
        }
        /**
         * Setter for state
         * @param state
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        /**
         * Setter for quantity
         * @param quantity
         * @return Builder
         */
        public Builder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }
        /**
         * Setter for calculatedAt
         * @param calculatedAt
         * @return Builder
         */
        public Builder calculatedAt(String calculatedAt) {
            this.calculatedAt = calculatedAt;
            return this;
        }

        /**
         * Builds a new {@link InventoryCount} object using the set fields.
         * @return {@link InventoryCount}
         */
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
