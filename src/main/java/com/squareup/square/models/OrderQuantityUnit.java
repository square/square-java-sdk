
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderQuantityUnit type.
 */
public class OrderQuantityUnit {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final MeasurementUnit measurementUnit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer precision;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long catalogVersion;

    /**
     * Initialization constructor.
     * @param  measurementUnit  MeasurementUnit value for measurementUnit.
     * @param  precision  Integer value for precision.
     * @param  catalogVersion  Long value for catalogVersion.
     */
    @JsonCreator
    public OrderQuantityUnit(
            @JsonProperty("measurement_unit") MeasurementUnit measurementUnit,
            @JsonProperty("precision") Integer precision,
            @JsonProperty("catalog_version") Long catalogVersion) {
        this.measurementUnit = measurementUnit;
        this.precision = precision;
        this.catalogVersion = catalogVersion;
    }

    /**
     * Getter for MeasurementUnit.
     * Represents a unit of measurement to use with a quantity, such as ounces or inches. Exactly
     * one of the following fields are required: `custom_unit`, `area_unit`, `length_unit`,
     * `volume_unit`, and `weight_unit`.
     * @return Returns the MeasurementUnit
     */
    @JsonGetter("measurement_unit")
    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    /**
     * Getter for Precision.
     * For non-integer quantities, represents the number of digits after the decimal point that are
     * recorded for this quantity. For example, a precision of 1 allows quantities such as `"1.0"`
     * and `"1.1"`, but not `"1.01"`. Min: 0. Max: 5.
     * @return Returns the Integer
     */
    @JsonGetter("precision")
    public Integer getPrecision() {
        return precision;
    }

    /**
     * Getter for CatalogVersion.
     * The version of the catalog object that this measurement unit references. This field is set
     * when this is a catalog-backed measurement unit.
     * @return Returns the Long
     */
    @JsonGetter("catalog_version")
    public Long getCatalogVersion() {
        return catalogVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurementUnit, precision, catalogVersion);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderQuantityUnit)) {
            return false;
        }
        OrderQuantityUnit other = (OrderQuantityUnit) obj;
        return Objects.equals(measurementUnit, other.measurementUnit)
            && Objects.equals(precision, other.precision)
            && Objects.equals(catalogVersion, other.catalogVersion);
    }

    /**
     * Converts this OrderQuantityUnit into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderQuantityUnit [" + "measurementUnit=" + measurementUnit + ", precision="
                + precision + ", catalogVersion=" + catalogVersion + "]";
    }

    /**
     * Builds a new {@link OrderQuantityUnit.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderQuantityUnit.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .measurementUnit(getMeasurementUnit())
                .precision(getPrecision())
                .catalogVersion(getCatalogVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderQuantityUnit}.
     */
    public static class Builder {
        private MeasurementUnit measurementUnit;
        private Integer precision;
        private Long catalogVersion;



        /**
         * Setter for measurementUnit.
         * @param  measurementUnit  MeasurementUnit value for measurementUnit.
         * @return Builder
         */
        public Builder measurementUnit(MeasurementUnit measurementUnit) {
            this.measurementUnit = measurementUnit;
            return this;
        }

        /**
         * Setter for precision.
         * @param  precision  Integer value for precision.
         * @return Builder
         */
        public Builder precision(Integer precision) {
            this.precision = precision;
            return this;
        }

        /**
         * Setter for catalogVersion.
         * @param  catalogVersion  Long value for catalogVersion.
         * @return Builder
         */
        public Builder catalogVersion(Long catalogVersion) {
            this.catalogVersion = catalogVersion;
            return this;
        }

        /**
         * Builds a new {@link OrderQuantityUnit} object using the set fields.
         * @return {@link OrderQuantityUnit}
         */
        public OrderQuantityUnit build() {
            return new OrderQuantityUnit(measurementUnit, precision, catalogVersion);
        }
    }
}
