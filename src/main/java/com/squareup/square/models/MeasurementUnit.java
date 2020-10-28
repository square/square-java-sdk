
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for MeasurementUnit type.
 */
public class MeasurementUnit {
    private final MeasurementUnitCustom customUnit;
    private final String areaUnit;
    private final String lengthUnit;
    private final String volumeUnit;
    private final String weightUnit;
    private final String genericUnit;
    private final String timeUnit;
    private final String type;

    /**
     * Initialization constructor.
     * @param customUnit MeasurementUnitCustom value for customUnit.
     * @param areaUnit String value for areaUnit.
     * @param lengthUnit String value for lengthUnit.
     * @param volumeUnit String value for volumeUnit.
     * @param weightUnit String value for weightUnit.
     * @param genericUnit String value for genericUnit.
     * @param timeUnit String value for timeUnit.
     * @param type String value for type.
     */
    @JsonCreator
    public MeasurementUnit(
            @JsonProperty("custom_unit") MeasurementUnitCustom customUnit,
            @JsonProperty("area_unit") String areaUnit,
            @JsonProperty("length_unit") String lengthUnit,
            @JsonProperty("volume_unit") String volumeUnit,
            @JsonProperty("weight_unit") String weightUnit,
            @JsonProperty("generic_unit") String genericUnit,
            @JsonProperty("time_unit") String timeUnit,
            @JsonProperty("type") String type) {
        this.customUnit = customUnit;
        this.areaUnit = areaUnit;
        this.lengthUnit = lengthUnit;
        this.volumeUnit = volumeUnit;
        this.weightUnit = weightUnit;
        this.genericUnit = genericUnit;
        this.timeUnit = timeUnit;
        this.type = type;
    }

    /**
     * Getter for CustomUnit.
     * The information needed to define a custom unit, provided by the seller.
     * @return Returns the MeasurementUnitCustom
     */
    @JsonGetter("custom_unit")
    public MeasurementUnitCustom getCustomUnit() {
        return this.customUnit;
    }

    /**
     * Getter for AreaUnit.
     * Unit of area used to measure a quantity.
     * @return Returns the String
     */
    @JsonGetter("area_unit")
    public String getAreaUnit() {
        return this.areaUnit;
    }

    /**
     * Getter for LengthUnit.
     * The unit of length used to measure a quantity.
     * @return Returns the String
     */
    @JsonGetter("length_unit")
    public String getLengthUnit() {
        return this.lengthUnit;
    }

    /**
     * Getter for VolumeUnit.
     * The unit of volume used to measure a quantity.
     * @return Returns the String
     */
    @JsonGetter("volume_unit")
    public String getVolumeUnit() {
        return this.volumeUnit;
    }

    /**
     * Getter for WeightUnit.
     * Unit of weight used to measure a quantity.
     * @return Returns the String
     */
    @JsonGetter("weight_unit")
    public String getWeightUnit() {
        return this.weightUnit;
    }

    /**
     * Getter for GenericUnit.
     * @return Returns the String
     */
    @JsonGetter("generic_unit")
    public String getGenericUnit() {
        return this.genericUnit;
    }

    /**
     * Getter for TimeUnit.
     * Unit of time used to measure a quantity (a duration).
     * @return Returns the String
     */
    @JsonGetter("time_unit")
    public String getTimeUnit() {
        return this.timeUnit;
    }

    /**
     * Getter for Type.
     * Describes the type of this unit and indicates which field contains the unit information. This
     * is an ‘open’ enum.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(customUnit, areaUnit, lengthUnit, volumeUnit, weightUnit, genericUnit,
                timeUnit, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MeasurementUnit)) {
            return false;
        }
        MeasurementUnit other = (MeasurementUnit) obj;
        return Objects.equals(customUnit, other.customUnit)
            && Objects.equals(areaUnit, other.areaUnit)
            && Objects.equals(lengthUnit, other.lengthUnit)
            && Objects.equals(volumeUnit, other.volumeUnit)
            && Objects.equals(weightUnit, other.weightUnit)
            && Objects.equals(genericUnit, other.genericUnit)
            && Objects.equals(timeUnit, other.timeUnit)
            && Objects.equals(type, other.type);
    }

    /**
     * Builds a new {@link MeasurementUnit.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link MeasurementUnit.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .customUnit(getCustomUnit())
            .areaUnit(getAreaUnit())
            .lengthUnit(getLengthUnit())
            .volumeUnit(getVolumeUnit())
            .weightUnit(getWeightUnit())
            .genericUnit(getGenericUnit())
            .timeUnit(getTimeUnit())
            .type(getType());
        return builder;
    }

    /**
     * Class to build instances of {@link MeasurementUnit}.
     */
    public static class Builder {
        private MeasurementUnitCustom customUnit;
        private String areaUnit;
        private String lengthUnit;
        private String volumeUnit;
        private String weightUnit;
        private String genericUnit;
        private String timeUnit;
        private String type;



        /**
         * Setter for customUnit.
         * @param customUnit MeasurementUnitCustom value for customUnit.
         * @return Builder
         */
        public Builder customUnit(MeasurementUnitCustom customUnit) {
            this.customUnit = customUnit;
            return this;
        }

        /**
         * Setter for areaUnit.
         * @param areaUnit String value for areaUnit.
         * @return Builder
         */
        public Builder areaUnit(String areaUnit) {
            this.areaUnit = areaUnit;
            return this;
        }

        /**
         * Setter for lengthUnit.
         * @param lengthUnit String value for lengthUnit.
         * @return Builder
         */
        public Builder lengthUnit(String lengthUnit) {
            this.lengthUnit = lengthUnit;
            return this;
        }

        /**
         * Setter for volumeUnit.
         * @param volumeUnit String value for volumeUnit.
         * @return Builder
         */
        public Builder volumeUnit(String volumeUnit) {
            this.volumeUnit = volumeUnit;
            return this;
        }

        /**
         * Setter for weightUnit.
         * @param weightUnit String value for weightUnit.
         * @return Builder
         */
        public Builder weightUnit(String weightUnit) {
            this.weightUnit = weightUnit;
            return this;
        }

        /**
         * Setter for genericUnit.
         * @param genericUnit String value for genericUnit.
         * @return Builder
         */
        public Builder genericUnit(String genericUnit) {
            this.genericUnit = genericUnit;
            return this;
        }

        /**
         * Setter for timeUnit.
         * @param timeUnit String value for timeUnit.
         * @return Builder
         */
        public Builder timeUnit(String timeUnit) {
            this.timeUnit = timeUnit;
            return this;
        }

        /**
         * Setter for type.
         * @param type String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Builds a new {@link MeasurementUnit} object using the set fields.
         * @return {@link MeasurementUnit}
         */
        public MeasurementUnit build() {
            return new MeasurementUnit(customUnit,
                areaUnit,
                lengthUnit,
                volumeUnit,
                weightUnit,
                genericUnit,
                timeUnit,
                type);
        }
    }
}
