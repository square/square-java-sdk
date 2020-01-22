package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for StandardUnitDescription type.
 */
public class StandardUnitDescription {

    /**
     * Initialization constructor.
     * @param unit
     * @param name
     * @param abbreviation
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(unit, name, abbreviation);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof StandardUnitDescription)) {
            return false;
        }
        StandardUnitDescription standardUnitDescription = (StandardUnitDescription) obj;
        return Objects.equals(unit, standardUnitDescription.unit) &&
            Objects.equals(name, standardUnitDescription.name) &&
            Objects.equals(abbreviation, standardUnitDescription.abbreviation);
    }

    /**
     * Builds a new {@link StandardUnitDescription.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link StandardUnitDescription.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .unit(getUnit())
            .name(getName())
            .abbreviation(getAbbreviation());
            return builder;
    }

    /**
     * Class to build instances of {@link StandardUnitDescription}
     */
    public static class Builder {
        private MeasurementUnit unit;
        private String name;
        private String abbreviation;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for unit
         * @param unit
         * @return Builder
         */
        public Builder unit(MeasurementUnit unit) {
            this.unit = unit;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for abbreviation
         * @param abbreviation
         * @return Builder
         */
        public Builder abbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
            return this;
        }

        /**
         * Builds a new {@link StandardUnitDescription} object using the set fields.
         * @return {@link StandardUnitDescription}
         */
        public StandardUnitDescription build() {
            return new StandardUnitDescription(unit,
                name,
                abbreviation);
        }
    }
}
