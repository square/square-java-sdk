/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogMeasurementUnit.Builder.class)
public final class CatalogMeasurementUnit {
    private final Optional<MeasurementUnit> measurementUnit;

    private final Optional<Integer> precision;

    private final Map<String, Object> additionalProperties;

    private CatalogMeasurementUnit(
            Optional<MeasurementUnit> measurementUnit,
            Optional<Integer> precision,
            Map<String, Object> additionalProperties) {
        this.measurementUnit = measurementUnit;
        this.precision = precision;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Indicates the unit used to measure the quantity of a catalog item variation.
     */
    @JsonProperty("measurement_unit")
    public Optional<MeasurementUnit> getMeasurementUnit() {
        return measurementUnit;
    }

    /**
     * @return An integer between 0 and 5 that represents the maximum number of
     * positions allowed after the decimal in quantities measured with this unit.
     * For example:
     * <ul>
     * <li>if the precision is 0, the quantity can be 1, 2, 3, etc.</li>
     * <li>if the precision is 1, the quantity can be 0.1, 0.2, etc.</li>
     * <li>if the precision is 2, the quantity can be 0.01, 0.12, etc.</li>
     * </ul>
     * <p>Default: 3</p>
     */
    @JsonIgnore
    public Optional<Integer> getPrecision() {
        if (precision == null) {
            return Optional.empty();
        }
        return precision;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("precision")
    private Optional<Integer> _getPrecision() {
        return precision;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogMeasurementUnit && equalTo((CatalogMeasurementUnit) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogMeasurementUnit other) {
        return measurementUnit.equals(other.measurementUnit) && precision.equals(other.precision);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.measurementUnit, this.precision);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<MeasurementUnit> measurementUnit = Optional.empty();

        private Optional<Integer> precision = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CatalogMeasurementUnit other) {
            measurementUnit(other.getMeasurementUnit());
            precision(other.getPrecision());
            return this;
        }

        @JsonSetter(value = "measurement_unit", nulls = Nulls.SKIP)
        public Builder measurementUnit(Optional<MeasurementUnit> measurementUnit) {
            this.measurementUnit = measurementUnit;
            return this;
        }

        public Builder measurementUnit(MeasurementUnit measurementUnit) {
            this.measurementUnit = Optional.ofNullable(measurementUnit);
            return this;
        }

        @JsonSetter(value = "precision", nulls = Nulls.SKIP)
        public Builder precision(Optional<Integer> precision) {
            this.precision = precision;
            return this;
        }

        public Builder precision(Integer precision) {
            this.precision = Optional.ofNullable(precision);
            return this;
        }

        public Builder precision(Nullable<Integer> precision) {
            if (precision.isNull()) {
                this.precision = null;
            } else if (precision.isEmpty()) {
                this.precision = Optional.empty();
            } else {
                this.precision = Optional.of(precision.get());
            }
            return this;
        }

        public CatalogMeasurementUnit build() {
            return new CatalogMeasurementUnit(measurementUnit, precision, additionalProperties);
        }
    }
}
