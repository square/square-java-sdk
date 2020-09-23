package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for DeviceDetails type.
 */
public class DeviceDetails {

    /**
     * Initialization constructor.
     * @param deviceId
     * @param deviceInstallationId
     * @param deviceName
     */
    @JsonCreator
    public DeviceDetails(
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("device_installation_id") String deviceInstallationId,
            @JsonProperty("device_name") String deviceName) {
        this.deviceId = deviceId;
        this.deviceInstallationId = deviceInstallationId;
        this.deviceName = deviceName;
    }

    private final String deviceId;
    private final String deviceInstallationId;
    private final String deviceName;
    /**
     * Getter for DeviceId.
     * Square-issued ID of the device.
     */
    @JsonGetter("device_id")
    public String getDeviceId() {
        return this.deviceId;
    }

    /**
     * Getter for DeviceInstallationId.
     * Square-issued installation ID for the device.
     */
    @JsonGetter("device_installation_id")
    public String getDeviceInstallationId() {
        return this.deviceInstallationId;
    }

    /**
     * Getter for DeviceName.
     * The name of the device set by the merchant.
     */
    @JsonGetter("device_name")
    public String getDeviceName() {
        return this.deviceName;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceInstallationId, deviceName);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof DeviceDetails)) {
            return false;
        }
        DeviceDetails deviceDetails = (DeviceDetails) obj;
        return Objects.equals(deviceId, deviceDetails.deviceId) &&
            Objects.equals(deviceInstallationId, deviceDetails.deviceInstallationId) &&
            Objects.equals(deviceName, deviceDetails.deviceName);
    }

    /**
     * Builds a new {@link DeviceDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .deviceId(getDeviceId())
            .deviceInstallationId(getDeviceInstallationId())
            .deviceName(getDeviceName());
            return builder;
    }

    /**
     * Class to build instances of {@link DeviceDetails}
     */
    public static class Builder {
        private String deviceId;
        private String deviceInstallationId;
        private String deviceName;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for deviceId
         * @param deviceId
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }
        /**
         * Setter for deviceInstallationId
         * @param deviceInstallationId
         * @return Builder
         */
        public Builder deviceInstallationId(String deviceInstallationId) {
            this.deviceInstallationId = deviceInstallationId;
            return this;
        }
        /**
         * Setter for deviceName
         * @param deviceName
         * @return Builder
         */
        public Builder deviceName(String deviceName) {
            this.deviceName = deviceName;
            return this;
        }

        /**
         * Builds a new {@link DeviceDetails} object using the set fields.
         * @return {@link DeviceDetails}
         */
        public DeviceDetails build() {
            return new DeviceDetails(deviceId,
                deviceInstallationId,
                deviceName);
        }
    }
}
