
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for MeasurementUnitCustom type.
 */
public class MeasurementUnitCustom {
    private final String name;
    private final String abbreviation;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  abbreviation  String value for abbreviation.
     */
    @JsonCreator
    public MeasurementUnitCustom(
            @JsonProperty("name") String name,
            @JsonProperty("abbreviation") String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    /**
     * Getter for Name.
     * The name of the custom unit, for example "bushel".
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for Abbreviation.
     * The abbreviation of the custom unit, such as "bsh" (bushel). This appears in the cart for the
     * Point of Sale app, and in reports.
     * @return Returns the String
     */
    @JsonGetter("abbreviation")
    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, abbreviation);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MeasurementUnitCustom)) {
            return false;
        }
        MeasurementUnitCustom other = (MeasurementUnitCustom) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(abbreviation, other.abbreviation);
    }

    /**
     * Converts this MeasurementUnitCustom into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "MeasurementUnitCustom [" + "name=" + name + ", abbreviation=" + abbreviation + "]";
    }

    /**
     * Builds a new {@link MeasurementUnitCustom.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link MeasurementUnitCustom.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name, abbreviation);
        return builder;
    }

    /**
     * Class to build instances of {@link MeasurementUnitCustom}.
     */
    public static class Builder {
        private String name;
        private String abbreviation;

        /**
         * Initialization constructor.
         * @param  name  String value for name.
         * @param  abbreviation  String value for abbreviation.
         */
        public Builder(String name, String abbreviation) {
            this.name = name;
            this.abbreviation = abbreviation;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for abbreviation.
         * @param  abbreviation  String value for abbreviation.
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
            return new MeasurementUnitCustom(name, abbreviation);
        }
    }
}
