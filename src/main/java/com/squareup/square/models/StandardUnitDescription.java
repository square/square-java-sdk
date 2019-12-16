package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class StandardUnitDescription {

    @JsonCreator
    public StandardUnitDescription(
            @JsonProperty("unit") MeasurementUnit unit,
            @JsonProperty("name") String name,
            @JsonProperty("abbreviation") String abbreviation) {
        this.unit = unit;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    private final MeasurementUnit unit;
    private final String name;
    private final String abbreviation;

    @Override
    public int hashCode() {
        return Objects.hash(unit, name, abbreviation);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StandardUnitDescription)) {
            return false;
        }
        StandardUnitDescription standardUnitDescription = (StandardUnitDescription) o;
        return Objects.equals(unit, standardUnitDescription.unit) &&
            Objects.equals(name, standardUnitDescription.name) &&
            Objects.equals(abbreviation, standardUnitDescription.abbreviation);
    }

    /**
     * Getter for Unit.
     * Represents a unit of measurement to use with a quantity, such as ounces
     * or inches. Exactly one of the following fields are required: `custom_unit`,
     * `area_unit`, `length_unit`, `volume_unit`, and `weight_unit`.
     */
    @JsonGetter("unit")
    public MeasurementUnit getUnit() { 
        return this.unit;
    }

    /**
     * Getter for Name.
     * UI display name of the measurement unit. For example, 'Pound'.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for Abbreviation.
     * UI display abbreviation for the measurement unit. For example, 'lb'.
     */
    @JsonGetter("abbreviation")
    public String getAbbreviation() { 
        return this.abbreviation;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .unit(getUnit())
            .name(getName())
            .abbreviation(getAbbreviation());
            return builder;
    }

    public static class Builder {
        private MeasurementUnit unit;
        private String name;
        private String abbreviation;

        public Builder() { }

        public Builder unit(MeasurementUnit value) {
            unit = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder abbreviation(String value) {
            abbreviation = value;
            return this;
        }

        public StandardUnitDescription build() {
            return new StandardUnitDescription(unit,
                name,
                abbreviation);
        }
    }
}
