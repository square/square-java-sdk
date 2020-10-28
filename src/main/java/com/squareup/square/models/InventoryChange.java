
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for InventoryChange type.
 */
public class InventoryChange {
    private final String type;
    private final InventoryPhysicalCount physicalCount;
    private final InventoryAdjustment adjustment;
    private final InventoryTransfer transfer;

    /**
     * Initialization constructor.
     * @param type String value for type.
     * @param physicalCount InventoryPhysicalCount value for physicalCount.
     * @param adjustment InventoryAdjustment value for adjustment.
     * @param transfer InventoryTransfer value for transfer.
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

    /**
     * Getter for Type.
     * Indicates how the inventory change was applied to a tracked quantity of items.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for PhysicalCount.
     * Represents the quantity of an item variation that is physically present at a specific
     * location, verified by a seller or a seller's employee. For example, a physical count might
     * come from an employee counting the item variations on hand or from syncing with an external
     * system.
     * @return Returns the InventoryPhysicalCount
     */
    @JsonGetter("physical_count")
    public InventoryPhysicalCount getPhysicalCount() {
        return this.physicalCount;
    }

    /**
     * Getter for Adjustment.
     * Represents a change in state or quantity of product inventory at a particular time and
     * location.
     * @return Returns the InventoryAdjustment
     */
    @JsonGetter("adjustment")
    public InventoryAdjustment getAdjustment() {
        return this.adjustment;
    }

    /**
     * Getter for Transfer.
     * Represents the transfer of a quantity of product inventory at a particular time from one
     * location to another.
     * @return Returns the InventoryTransfer
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InventoryChange)) {
            return false;
        }
        InventoryChange other = (InventoryChange) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(physicalCount, other.physicalCount)
            && Objects.equals(adjustment, other.adjustment)
            && Objects.equals(transfer, other.transfer);
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
     * Class to build instances of {@link InventoryChange}.
     */
    public static class Builder {
        private String type;
        private InventoryPhysicalCount physicalCount;
        private InventoryAdjustment adjustment;
        private InventoryTransfer transfer;



        /**
         * Setter for type.
         * @param type String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for physicalCount.
         * @param physicalCount InventoryPhysicalCount value for physicalCount.
         * @return Builder
         */
        public Builder physicalCount(InventoryPhysicalCount physicalCount) {
            this.physicalCount = physicalCount;
            return this;
        }

        /**
         * Setter for adjustment.
         * @param adjustment InventoryAdjustment value for adjustment.
         * @return Builder
         */
        public Builder adjustment(InventoryAdjustment adjustment) {
            this.adjustment = adjustment;
            return this;
        }

        /**
         * Setter for transfer.
         * @param transfer InventoryTransfer value for transfer.
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
