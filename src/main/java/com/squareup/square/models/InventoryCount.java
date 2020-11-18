
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for InventoryCount type.
 */
public class InventoryCount {
    private final String catalogObjectId;
    private final String catalogObjectType;
    private final String state;
    private final String locationId;
    private final String quantity;
    private final String calculatedAt;

    /**
     * Initialization constructor.
     * @param catalogObjectId String value for catalogObjectId.
     * @param catalogObjectType String value for catalogObjectType.
     * @param state String value for state.
     * @param locationId String value for locationId.
     * @param quantity String value for quantity.
     * @param calculatedAt String value for calculatedAt.
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

    /**
     * Getter for CatalogObjectId.
     * The Square generated ID of the `CatalogObject` being tracked.
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for CatalogObjectType.
     * The `CatalogObjectType` of the `CatalogObject` being tracked. Tracking is only supported for
     * the `ITEM_VARIATION` type.
     * @return Returns the String
     */
    @JsonGetter("catalog_object_type")
    public String getCatalogObjectType() {
        return this.catalogObjectType;
    }

    /**
     * Getter for State.
     * Indicates the state of a tracked item quantity in the lifecycle of goods.
     * @return Returns the String
     */
    @JsonGetter("state")
    public String getState() {
        return this.state;
    }

    /**
     * Getter for LocationId.
     * The Square ID of the [Location](#type-location) where the related quantity of items are being
     * tracked.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Quantity.
     * The number of items affected by the estimated count as a decimal string. Can support up to 5
     * digits after the decimal point.
     * @return Returns the String
     */
    @JsonGetter("quantity")
    public String getQuantity() {
        return this.quantity;
    }

    /**
     * Getter for CalculatedAt.
     * A read-only timestamp in RFC 3339 format that indicates when Square received the most recent
     * physical count or adjustment that had an affect on the estimated count.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InventoryCount)) {
            return false;
        }
        InventoryCount other = (InventoryCount) obj;
        return Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(catalogObjectType, other.catalogObjectType)
            && Objects.equals(state, other.state)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(quantity, other.quantity)
            && Objects.equals(calculatedAt, other.calculatedAt);
    }

    /**
     * Converts this InventoryCount into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InventoryCount [" + "catalogObjectId=" + catalogObjectId + ", catalogObjectType="
                + catalogObjectType + ", state=" + state + ", locationId=" + locationId
                + ", quantity=" + quantity + ", calculatedAt=" + calculatedAt + "]";
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
     * Class to build instances of {@link InventoryCount}.
     */
    public static class Builder {
        private String catalogObjectId;
        private String catalogObjectType;
        private String state;
        private String locationId;
        private String quantity;
        private String calculatedAt;



        /**
         * Setter for catalogObjectId.
         * @param catalogObjectId String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }

        /**
         * Setter for catalogObjectType.
         * @param catalogObjectType String value for catalogObjectType.
         * @return Builder
         */
        public Builder catalogObjectType(String catalogObjectType) {
            this.catalogObjectType = catalogObjectType;
            return this;
        }

        /**
         * Setter for state.
         * @param state String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * Setter for locationId.
         * @param locationId String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for quantity.
         * @param quantity String value for quantity.
         * @return Builder
         */
        public Builder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * Setter for calculatedAt.
         * @param calculatedAt String value for calculatedAt.
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
            return new InventoryCount(catalogObjectId, catalogObjectType, state, locationId,
                    quantity, calculatedAt);
        }
    }
}
