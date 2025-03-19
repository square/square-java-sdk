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
 * This is a model class for DeviceComponentDetailsBatteryDetails type.
 */
public class DeviceComponentDetailsBatteryDetails {
    private final OptionalNullable<Integer> visiblePercent;
    private final String externalPower;

    /**
     * Initialization constructor.
     * @param  visiblePercent  Integer value for visiblePercent.
     * @param  externalPower  String value for externalPower.
     */
    @JsonCreator
    public DeviceComponentDetailsBatteryDetails(
            @JsonProperty("visible_percent") Integer visiblePercent,
            @JsonProperty("external_power") String externalPower) {
        this.visiblePercent = OptionalNullable.of(visiblePercent);
        this.externalPower = externalPower;
    }

    /**
     * Initialization constructor.
     * @param  visiblePercent  Integer value for visiblePercent.
     * @param  externalPower  String value for externalPower.
     */
    protected DeviceComponentDetailsBatteryDetails(OptionalNullable<Integer> visiblePercent, String externalPower) {
        this.visiblePercent = visiblePercent;
        this.externalPower = externalPower;
    }

    /**
     * Internal Getter for VisiblePercent.
     * The battery charge percentage as displayed on the device.
     * @return Returns the Internal Integer
     */
    @JsonGetter("visible_percent")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetVisiblePercent() {
        return this.visiblePercent;
    }

    /**
     * Getter for VisiblePercent.
     * The battery charge percentage as displayed on the device.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getVisiblePercent() {
        return OptionalNullable.getFrom(visiblePercent);
    }

    /**
     * Getter for ExternalPower.
     * An enum for ExternalPower.
     * @return Returns the String
     */
    @JsonGetter("external_power")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getExternalPower() {
        return externalPower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visiblePercent, externalPower);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceComponentDetailsBatteryDetails)) {
            return false;
        }
        DeviceComponentDetailsBatteryDetails other = (DeviceComponentDetailsBatteryDetails) obj;
        return Objects.equals(visiblePercent, other.visiblePercent)
                && Objects.equals(externalPower, other.externalPower);
    }

    /**
     * Converts this DeviceComponentDetailsBatteryDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceComponentDetailsBatteryDetails [" + "visiblePercent=" + visiblePercent + ", externalPower="
                + externalPower + "]";
    }

    /**
     * Builds a new {@link DeviceComponentDetailsBatteryDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceComponentDetailsBatteryDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().externalPower(getExternalPower());
        builder.visiblePercent = internalGetVisiblePercent();
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceComponentDetailsBatteryDetails}.
     */
    public static class Builder {
        private OptionalNullable<Integer> visiblePercent;
        private String externalPower;

        /**
         * Setter for visiblePercent.
         * @param  visiblePercent  Integer value for visiblePercent.
         * @return Builder
         */
        public Builder visiblePercent(Integer visiblePercent) {
            this.visiblePercent = OptionalNullable.of(visiblePercent);
            return this;
        }

        /**
         * UnSetter for visiblePercent.
         * @return Builder
         */
        public Builder unsetVisiblePercent() {
            visiblePercent = null;
            return this;
        }

        /**
         * Setter for externalPower.
         * @param  externalPower  String value for externalPower.
         * @return Builder
         */
        public Builder externalPower(String externalPower) {
            this.externalPower = externalPower;
            return this;
        }

        /**
         * Builds a new {@link DeviceComponentDetailsBatteryDetails} object using the set fields.
         * @return {@link DeviceComponentDetailsBatteryDetails}
         */
        public DeviceComponentDetailsBatteryDetails build() {
            return new DeviceComponentDetailsBatteryDetails(visiblePercent, externalPower);
        }
    }
}
