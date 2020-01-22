package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for MeasurementUnit type.
 */
public class MeasurementUnit {

    /**
     * Initialization constructor.
     * @param customUnit
     * @param areaUnit
     * @param lengthUnit
     * @param volumeUnit
     * @param weightUnit
     * @param genericUnit
     * @param timeUnit
     * @param type
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

    private final MeasurementUnitCustom customUnit;
    private final String areaUnit;
    private final String lengthUnit;
    private final String volumeUnit;
    private final String weightUnit;
    private final String genericUnit;
    private final String timeUnit;
    private final String type;
    /**
     * Getter for CustomUnit.
     * The information needed to define a custom unit, provided by the seller.
     */
    @JsonGetter("custom_unit")
    public MeasurementUnitCustom getCustomUnit() {
        return this.customUnit;
    }

    /**
     * Getter for AreaUnit.
     * Unit of area used to measure a quantity.
     */
    @JsonGetter("area_unit")
    public String getAreaUnit() {
        return this.areaUnit;
    }

    /**
     * Getter for LengthUnit.
     * The unit of length used to measure a quantity.
     */
    @JsonGetter("length_unit")
    public String getLengthUnit() {
        return this.lengthUnit;
    }

    /**
     * Getter for VolumeUnit.
     * The unit of volume used to measure a quantity.
     */
    @JsonGetter("volume_unit")
    public String getVolumeUnit() {
        return this.volumeUnit;
    }

    /**
     * Getter for WeightUnit.
     * Unit of weight used to measure a quantity.
     */
    @JsonGetter("weight_unit")
    public String getWeightUnit() {
        return this.weightUnit;
    }

    /**
     * Getter for GenericUnit.
     */
    @JsonGetter("generic_unit")
    public String getGenericUnit() {
        return this.genericUnit;
    }

    /**
     * Getter for TimeUnit.
     * Unit of time used to measure a quantity (a duration).
     */
    @JsonGetter("time_unit")
    public String getTimeUnit() {
        return this.timeUnit;
    }

    /**
     * Getter for Type.
     * Describes the type of this unit and indicates which field contains the unit information. This is an ‘open’ enum.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof MeasurementUnit)) {
            return false;
        }
        MeasurementUnit measurementUnit = (MeasurementUnit) obj;
        return Objects.equals(customUnit, measurementUnit.customUnit) &&
            Objects.equals(areaUnit, measurementUnit.areaUnit) &&
            Objects.equals(lengthUnit, measurementUnit.lengthUnit) &&
            Objects.equals(volumeUnit, measurementUnit.volumeUnit) &&
            Objects.equals(weightUnit, measurementUnit.weightUnit) &&
            Objects.equals(genericUnit, measurementUnit.genericUnit) &&
            Objects.equals(timeUnit, measurementUnit.timeUnit) &&
            Objects.equals(type, measurementUnit.type);
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
     * Class to build instances of {@link MeasurementUnit}
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
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for customUnit
         * @param customUnit
         * @return Builder
         */
        public Builder customUnit(MeasurementUnitCustom customUnit) {
            this.customUnit = customUnit;
            return this;
        }
        /**
         * Setter for areaUnit
         * @param areaUnit
         * @return Builder
         */
        public Builder areaUnit(String areaUnit) {
            this.areaUnit = areaUnit;
            return this;
        }
        /**
         * Setter for lengthUnit
         * @param lengthUnit
         * @return Builder
         */
        public Builder lengthUnit(String lengthUnit) {
            this.lengthUnit = lengthUnit;
            return this;
        }
        /**
         * Setter for volumeUnit
         * @param volumeUnit
         * @return Builder
         */
        public Builder volumeUnit(String volumeUnit) {
            this.volumeUnit = volumeUnit;
            return this;
        }
        /**
         * Setter for weightUnit
         * @param weightUnit
         * @return Builder
         */
        public Builder weightUnit(String weightUnit) {
            this.weightUnit = weightUnit;
            return this;
        }
        /**
         * Setter for genericUnit
         * @param genericUnit
         * @return Builder
         */
        public Builder genericUnit(String genericUnit) {
            this.genericUnit = genericUnit;
            return this;
        }
        /**
         * Setter for timeUnit
         * @param timeUnit
         * @return Builder
         */
        public Builder timeUnit(String timeUnit) {
            this.timeUnit = timeUnit;
            return this;
        }
        /**
         * Setter for type
         * @param type
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
