package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for InventoryChange type.
 */
public class InventoryChange {

    /**
     * Initialization constructor.
     * @param type
     * @param physicalCount
     * @param adjustment
     * @param transfer
     */
    @JsonCreator
    public InventoryChange(
            @JsonProperty("type") String type,
            @JsonProperty("physical_count") InventoryPhysicalCount physicalCount,
            @JsonProperty("adjustment") InventoryAdjustment adjustment,
            @JsonProperty("transfer") InventoryTransfer transfer) {
        this.type = type;
        this.physicalCount = physicalCount;
        this.adjustment = adjustment;
        this.transfer = transfer;
    }

    private final String type;
    private final InventoryPhysicalCount physicalCount;
    private final InventoryAdjustment adjustment;
    private final InventoryTransfer transfer;
    /**
     * Getter for Type.
     * Indicates how the inventory change was applied to a tracked quantity of items.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for PhysicalCount.
     * Represents the quantity of an item variation that is physically present
     * at a specific location, verified by a seller or a seller's employee. For example,
     * a physical count might come from an employee counting the item variations on
     * hand or from syncing with an external system.
     */
    @JsonGetter("physical_count")
    public InventoryPhysicalCount getPhysicalCount() {
        return this.physicalCount;
    }

    /**
     * Getter for Adjustment.
     * Represents a change in state or quantity of product inventory at a
     * particular time and location.
     */
    @JsonGetter("adjustment")
    public InventoryAdjustment getAdjustment() {
        return this.adjustment;
    }

    /**
     * Getter for Transfer.
     * Represents the transfer of a quantity of product inventory at a
     * particular time from one location to another.
     */
    @JsonGetter("transfer")
    public InventoryTransfer getTransfer() {
        return this.transfer;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(type, physicalCount, adjustment, transfer);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof InventoryChange)) {
            return false;
        }
        InventoryChange inventoryChange = (InventoryChange) obj;
        return Objects.equals(type, inventoryChange.type) &&
            Objects.equals(physicalCount, inventoryChange.physicalCount) &&
            Objects.equals(adjustment, inventoryChange.adjustment) &&
            Objects.equals(transfer, inventoryChange.transfer);
    }

    /**
     * Builds a new {@link InventoryChange.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InventoryChange.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .type(getType())
            .physicalCount(getPhysicalCount())
            .adjustment(getAdjustment())
            .transfer(getTransfer());
            return builder;
    }

    /**
     * Class to build instances of {@link InventoryChange}
     */
    public static class Builder {
        private String type;
        private InventoryPhysicalCount physicalCount;
        private InventoryAdjustment adjustment;
        private InventoryTransfer transfer;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for physicalCount
         * @param physicalCount
         * @return Builder
         */
        public Builder physicalCount(InventoryPhysicalCount physicalCount) {
            this.physicalCount = physicalCount;
            return this;
        }
        /**
         * Setter for adjustment
         * @param adjustment
         * @return Builder
         */
        public Builder adjustment(InventoryAdjustment adjustment) {
            this.adjustment = adjustment;
            return this;
        }
        /**
         * Setter for transfer
         * @param transfer
         * @return Builder
         */
        public Builder transfer(InventoryTransfer transfer) {
            this.transfer = transfer;
            return this;
        }

        /**
         * Builds a new {@link InventoryChange} object using the set fields.
         * @return {@link InventoryChange}
         */
        public InventoryChange build() {
            return new InventoryChange(type,
                physicalCount,
                adjustment,
                transfer);
        }
    }
}
