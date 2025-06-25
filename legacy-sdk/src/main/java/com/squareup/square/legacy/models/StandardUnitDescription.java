package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for StandardUnitDescription type.
 */
public class StandardUnitDescription {
    private final MeasurementUnit unit;
    private final OptionalNullable<String> name;
    private final OptionalNullable<String> abbreviation;

    /**
     * Initialization constructor.
     * @param  unit  MeasurementUnit value for unit.
     * @param  name  String value for name.
     * @param  abbreviation  String value for abbreviation.
     */
    @JsonCreator
    public StandardUnitDescription(
            @JsonProperty("unit") MeasurementUnit unit,
            @JsonProperty("name") String name,
            @JsonProperty("abbreviation") String abbreviation) {
        this.unit = unit;
        this.name = OptionalNullable.of(name);
        this.abbreviation = OptionalNullable.of(abbreviation);
    }

    /**
     * Initialization constructor.
     * @param  unit  MeasurementUnit value for unit.
     * @param  name  String value for name.
     * @param  abbreviation  String value for abbreviation.
     */
    protected StandardUnitDescription(
            MeasurementUnit unit, OptionalNullable<String> name, OptionalNullable<String> abbreviation) {
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public MeasurementUnit getUnit() {
        return unit;
    }

    /**
     * Internal Getter for Name.
     * UI display name of the measurement unit. For example, 'Pound'.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * UI display name of the measurement unit. For example, 'Pound'.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for Abbreviation.
     * UI display abbreviation for the measurement unit. For example, 'lb'.
     * @return Returns the Internal String
     */
    @JsonGetter("abbreviation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAbbreviation() {
        return this.abbreviation;
    }

    /**
     * Getter for Abbreviation.
     * UI display abbreviation for the measurement unit. For example, 'lb'.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAbbreviation() {
        return OptionalNullable.getFrom(abbreviation);
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
     * Converts this StandardUnitDescription into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "StandardUnitDescription [" + "unit=" + unit + ", name=" + name + ", abbreviation=" + abbreviation + "]";
    }

    /**
     * Builds a new {@link StandardUnitDescription.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link StandardUnitDescription.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().unit(getUnit());
        builder.name = internalGetName();
        builder.abbreviation = internalGetAbbreviation();
        return builder;
    }

    /**
     * Class to build instances of {@link StandardUnitDescription}.
     */
    public static class Builder {
        private MeasurementUnit unit;
        private OptionalNullable<String> name;
        private OptionalNullable<String> abbreviation;

        /**
         * Setter for unit.
         * @param  unit  MeasurementUnit value for unit.
         * @return Builder
         */
        public Builder unit(MeasurementUnit unit) {
            this.unit = unit;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for abbreviation.
         * @param  abbreviation  String value for abbreviation.
         * @return Builder
         */
        public Builder abbreviation(String abbreviation) {
            this.abbreviation = OptionalNullable.of(abbreviation);
            return this;
        }

        /**
         * UnSetter for abbreviation.
         * @return Builder
         */
        public Builder unsetAbbreviation() {
            abbreviation = null;
            return this;
        }

        /**
         * Builds a new {@link StandardUnitDescription} object using the set fields.
         * @return {@link StandardUnitDescription}
         */
        public StandardUnitDescription build() {
            return new StandardUnitDescription(unit, name, abbreviation);
        }
    }
}
