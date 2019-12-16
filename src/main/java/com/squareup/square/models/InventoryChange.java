package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class InventoryChange {

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

    @Override
    public int hashCode() {
        return Objects.hash(type, physicalCount, adjustment, transfer);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof InventoryChange)) {
            return false;
        }
        InventoryChange inventoryChange = (InventoryChange) o;
        return Objects.equals(type, inventoryChange.type) &&
            Objects.equals(physicalCount, inventoryChange.physicalCount) &&
            Objects.equals(adjustment, inventoryChange.adjustment) &&
            Objects.equals(transfer, inventoryChange.transfer);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .type(getType())
            .physicalCount(getPhysicalCount())
            .adjustment(getAdjustment())
            .transfer(getTransfer());
            return builder;
    }

    public static class Builder {
        private String type;
        private InventoryPhysicalCount physicalCount;
        private InventoryAdjustment adjustment;
        private InventoryTransfer transfer;

        public Builder() { }

        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder physicalCount(InventoryPhysicalCount value) {
            physicalCount = value;
            return this;
        }
        public Builder adjustment(InventoryAdjustment value) {
            adjustment = value;
            return this;
        }
        public Builder transfer(InventoryTransfer value) {
            transfer = value;
            return this;
        }

        public InventoryChange build() {
            return new InventoryChange(type,
                physicalCount,
                adjustment,
                transfer);
        }
    }
}
