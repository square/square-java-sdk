package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class MeasurementUnitCustom {

    @JsonCreator
    public MeasurementUnitCustom(
            @JsonProperty("name") String name,
            @JsonProperty("abbreviation") String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    private final String name;
    private final String abbreviation;

    @Override
    public int hashCode() {
        return Objects.hash(name, abbreviation);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MeasurementUnitCustom)) {
            return false;
        }
        MeasurementUnitCustom measurementUnitCustom = (MeasurementUnitCustom) o;
        return Objects.equals(name, measurementUnitCustom.name) &&
            Objects.equals(abbreviation, measurementUnitCustom.abbreviation);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder(name,
            abbreviation);
            return builder;
    }

    public static class Builder {
        private String name;
        private String abbreviation;

        public Builder(String name,
                String abbreviation) {
            this.name = name;
            this.abbreviation = abbreviation;
        }

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder abbreviation(String value) {
            abbreviation = value;
            return this;
        }

        public MeasurementUnitCustom build() {
            return new MeasurementUnitCustom(name,
                abbreviation);
        }
    }
}
