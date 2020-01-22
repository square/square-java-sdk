package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for MeasurementUnitCustom type.
 */
public class MeasurementUnitCustom {

    /**
     * Initialization constructor.
     * @param name
     * @param abbreviation
     */
    @JsonCreator
    public MeasurementUnitCustom(
            @JsonProperty("name") String name,
            @JsonProperty("abbreviation") String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    private final String name;
    private final String abbreviation;
    /**
     * Getter for Name.
     * The name of the custom unit, for example "bushel".
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Abbreviation.
     * The abbreviation of the custom unit, such as "bsh" (bushel). This appears
     * in the cart for the Point of Sale app, and in reports.
     */
    @JsonGetter("abbreviation")
    public String getAbbreviation() {
        return this.abbreviation;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, abbreviation);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof MeasurementUnitCustom)) {
            return false;
        }
        MeasurementUnitCustom measurementUnitCustom = (MeasurementUnitCustom) obj;
        return Objects.equals(name, measurementUnitCustom.name) &&
            Objects.equals(abbreviation, measurementUnitCustom.abbreviation);
    }

    /**
     * Builds a new {@link MeasurementUnitCustom.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link MeasurementUnitCustom.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name,
            abbreviation);
            return builder;
    }

    /**
     * Class to build instances of {@link MeasurementUnitCustom}
     */
    public static class Builder {
        private String name;
        private String abbreviation;

        /**
         * Initialization constructor
         */
        public Builder(String name,
                String abbreviation) {
            this.name = name;
            this.abbreviation = abbreviation;
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
         * Builds a new {@link MeasurementUnitCustom} object using the set fields.
         * @return {@link MeasurementUnitCustom}
         */
        public MeasurementUnitCustom build() {
            return new MeasurementUnitCustom(name,
                abbreviation);
        }
    }
}
