
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    private final CatalogMeasurementUnit measurementUnit;
    private final String measurementUnitId;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  physicalCount  InventoryPhysicalCount value for physicalCount.
     * @param  adjustment  InventoryAdjustment value for adjustment.
     * @param  transfer  InventoryTransfer value for transfer.
     * @param  measurementUnit  CatalogMeasurementUnit value for measurementUnit.
     * @param  measurementUnitId  String value for measurementUnitId.
     */
    @JsonCreator
    public InventoryChange(
            @JsonProperty("type") String type,
            @JsonProperty("physical_count") InventoryPhysicalCount physicalCount,
            @JsonProperty("adjustment") InventoryAdjustment adjustment,
            @JsonProperty("transfer") InventoryTransfer transfer,
            @JsonProperty("measurement_unit") CatalogMeasurementUnit measurementUnit,
            @JsonProperty("measurement_unit_id") String measurementUnitId) {
        this.type = type;
        this.physicalCount = physicalCount;
        this.adjustment = adjustment;
        this.transfer = transfer;
        this.measurementUnit = measurementUnit;
        this.measurementUnitId = measurementUnitId;
    }

    /**
     * Getter for Type.
     * Indicates how the inventory change was applied to a tracked product quantity.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public InventoryPhysicalCount getPhysicalCount() {
        return physicalCount;
    }

    /**
     * Getter for Adjustment.
     * Represents a change in state or quantity of product inventory at a particular time and
     * location.
     * @return Returns the InventoryAdjustment
     */
    @JsonGetter("adjustment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public InventoryAdjustment getAdjustment() {
        return adjustment;
    }

    /**
     * Getter for Transfer.
     * Represents the transfer of a quantity of product inventory at a particular time from one
     * location to another.
     * @return Returns the InventoryTransfer
     */
    @JsonGetter("transfer")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public InventoryTransfer getTransfer() {
        return transfer;
    }

    /**
     * Getter for MeasurementUnit.
     * Represents the unit used to measure a `CatalogItemVariation` and specifies the precision for
     * decimal quantities.
     * @return Returns the CatalogMeasurementUnit
     */
    @JsonGetter("measurement_unit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogMeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    /**
     * Getter for MeasurementUnitId.
     * The ID of the [CatalogMeasurementUnit]($m/CatalogMeasurementUnit) object representing the
     * catalog measurement unit associated with the inventory change.
     * @return Returns the String
     */
    @JsonGetter("measurement_unit_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMeasurementUnitId() {
        return measurementUnitId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, physicalCount, adjustment, transfer, measurementUnit,
                measurementUnitId);
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
            && Objects.equals(transfer, other.transfer)
            && Objects.equals(measurementUnit, other.measurementUnit)
            && Objects.equals(measurementUnitId, other.measurementUnitId);
    }

    /**
     * Converts this InventoryChange into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InventoryChange [" + "type=" + type + ", physicalCount=" + physicalCount
                + ", adjustment=" + adjustment + ", transfer=" + transfer + ", measurementUnit="
                + measurementUnit + ", measurementUnitId=" + measurementUnitId + "]";
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
                .transfer(getTransfer())
                .measurementUnit(getMeasurementUnit())
                .measurementUnitId(getMeasurementUnitId());
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
        private CatalogMeasurementUnit measurementUnit;
        private String measurementUnitId;



        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for physicalCount.
         * @param  physicalCount  InventoryPhysicalCount value for physicalCount.
         * @return Builder
         */
        public Builder physicalCount(InventoryPhysicalCount physicalCount) {
            this.physicalCount = physicalCount;
            return this;
        }

        /**
         * Setter for adjustment.
         * @param  adjustment  InventoryAdjustment value for adjustment.
         * @return Builder
         */
        public Builder adjustment(InventoryAdjustment adjustment) {
            this.adjustment = adjustment;
            return this;
        }

        /**
         * Setter for transfer.
         * @param  transfer  InventoryTransfer value for transfer.
         * @return Builder
         */
        public Builder transfer(InventoryTransfer transfer) {
            this.transfer = transfer;
            return this;
        }

        /**
         * Setter for measurementUnit.
         * @param  measurementUnit  CatalogMeasurementUnit value for measurementUnit.
         * @return Builder
         */
        public Builder measurementUnit(CatalogMeasurementUnit measurementUnit) {
            this.measurementUnit = measurementUnit;
            return this;
        }

        /**
         * Setter for measurementUnitId.
         * @param  measurementUnitId  String value for measurementUnitId.
         * @return Builder
         */
        public Builder measurementUnitId(String measurementUnitId) {
            this.measurementUnitId = measurementUnitId;
            return this;
        }

        /**
         * Builds a new {@link InventoryChange} object using the set fields.
         * @return {@link InventoryChange}
         */
        public InventoryChange build() {
            return new InventoryChange(type, physicalCount, adjustment, transfer, measurementUnit,
                    measurementUnitId);
        }
    }
}
