package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class MeasurementUnit {

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

    @Override
    public int hashCode() {
        return Objects.hash(customUnit, areaUnit, lengthUnit, volumeUnit, weightUnit, genericUnit, timeUnit, type);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MeasurementUnit)) {
            return false;
        }
        MeasurementUnit measurementUnit = (MeasurementUnit) o;
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

    public static class Builder {
        private MeasurementUnitCustom customUnit;
        private String areaUnit;
        private String lengthUnit;
        private String volumeUnit;
        private String weightUnit;
        private String genericUnit;
        private String timeUnit;
        private String type;

        public Builder() { }

        public Builder customUnit(MeasurementUnitCustom value) {
            customUnit = value;
            return this;
        }
        public Builder areaUnit(String value) {
            areaUnit = value;
            return this;
        }
        public Builder lengthUnit(String value) {
            lengthUnit = value;
            return this;
        }
        public Builder volumeUnit(String value) {
            volumeUnit = value;
            return this;
        }
        public Builder weightUnit(String value) {
            weightUnit = value;
            return this;
        }
        public Builder genericUnit(String value) {
            genericUnit = value;
            return this;
        }
        public Builder timeUnit(String value) {
            timeUnit = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }

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
