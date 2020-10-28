
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for StandardUnitDescription type.
 */
public class StandardUnitDescription {
    private final MeasurementUnit unit;
    private final String name;
    private final String abbreviation;

    /**
     * Initialization constructor.
     * @param unit MeasurementUnit value for unit.
     * @param name String value for name.
     * @param abbreviation String value for abbreviation.
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

    /**
     * Getter for Unit.
     * Represents a unit of measurement to use with a quantity, such as ounces or inches. Exactly
     * one of the following fields are required: `custom_unit`, `area_unit`, `length_unit`,
     * `volume_unit`, and `weight_unit`.
     * @return Returns the MeasurementUnit
     */
    @JsonGetter("unit")
    public MeasurementUnit getUnit() {
        return this.unit;
    }

    /**
     * Getter for Name.
     * UI display name of the measurement unit. For example, 'Pound'.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Abbreviation.
     * UI display abbreviation for the measurement unit. For example, 'lb'.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardUnitDescription)) {
            return false;
        }
        StandardUnitDescription other = (StandardUnitDescription) obj;
        return Objects.equals(unit, other.unit)
            && Objects.equals(name, other.name)
            && Objects.equals(abbreviation, other.abbreviation);
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
     * Class to build instances of {@link StandardUnitDescription}.
     */
    public static class Builder {
        private MeasurementUnit unit;
        private String name;
        private String abbreviation;



        /**
         * Setter for unit.
         * @param unit MeasurementUnit value for unit.
         * @return Builder
         */
        public Builder unit(MeasurementUnit unit) {
            this.unit = unit;
            return this;
        }

        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for abbreviation.
         * @param abbreviation String value for abbreviation.
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
