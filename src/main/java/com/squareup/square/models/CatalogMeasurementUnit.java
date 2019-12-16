package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogMeasurementUnit {

    @JsonCreator
    public CatalogMeasurementUnit(
            @JsonProperty("measurement_unit") MeasurementUnit measurementUnit,
            @JsonProperty("precision") Integer precision) {
        this.measurementUnit = measurementUnit;
        this.precision = precision;
    }

    private final MeasurementUnit measurementUnit;
    private final Integer precision;

    @Override
    public int hashCode() {
        return Objects.hash(measurementUnit, precision);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogMeasurementUnit)) {
            return false;
        }
        CatalogMeasurementUnit catalogMeasurementUnit = (CatalogMeasurementUnit) o;
        return Objects.equals(measurementUnit, catalogMeasurementUnit.measurementUnit) &&
            Objects.equals(precision, catalogMeasurementUnit.precision);
    }

    /**
     * Getter for MeasurementUnit.
     * Represents a unit of measurement to use with a quantity, such as ounces
     * or inches. Exactly one of the following fields are required: `custom_unit`,
     * `area_unit`, `length_unit`, `volume_unit`, and `weight_unit`.
     */
    @JsonGetter("measurement_unit")
    public MeasurementUnit getMeasurementUnit() { 
        return this.measurementUnit;
    }

    /**
     * Getter for Precision.
     * An integer between 0 and 5 that represents the maximum number of
     * positions allowed after the decimal in quantities measured with this unit.
     * For example:
     * - if the precision is 0, the quantity can be 1, 2, 3, etc.
     * - if the precision is 1, the quantity can be 0.1, 0.2, etc.
     * - if the precision is 2, the quantity can be 0.01, 0.12, etc.
     * Default: 3
     */
    @JsonGetter("precision")
    public Integer getPrecision() { 
        return this.precision;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .measurementUnit(getMeasurementUnit())
            .precision(getPrecision());
            return builder;
    }

    public static class Builder {
        private MeasurementUnit measurementUnit;
        private Integer precision;

        public Builder() { }

        public Builder measurementUnit(MeasurementUnit value) {
            measurementUnit = value;
            return this;
        }
        public Builder precision(Integer value) {
            precision = value;
            return this;
        }

        public CatalogMeasurementUnit build() {
            return new CatalogMeasurementUnit(measurementUnit,
                precision);
        }
    }
}
