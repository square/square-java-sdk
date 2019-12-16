package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderQuantityUnit {

    @JsonCreator
    public OrderQuantityUnit(
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
        if (!(o instanceof OrderQuantityUnit)) {
            return false;
        }
        OrderQuantityUnit orderQuantityUnit = (OrderQuantityUnit) o;
        return Objects.equals(measurementUnit, orderQuantityUnit.measurementUnit) &&
            Objects.equals(precision, orderQuantityUnit.precision);
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
     * For non-integer quantities, represents the number of digits after the decimal point that are
     * recorded for this quantity.
     * For example, a precision of 1 allows quantities like `"1.0"` and `"1.1"`, but not `"1.01"`.
     * Min: 0. Max: 5.
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

        public OrderQuantityUnit build() {
            return new OrderQuantityUnit(measurementUnit,
                precision);
        }
    }
}
