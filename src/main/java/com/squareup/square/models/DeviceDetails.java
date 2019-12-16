package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class DeviceDetails {

    @JsonCreator
    public DeviceDetails(
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("device_name") String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

    private final String deviceId;
    private final String deviceName;

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceName);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DeviceDetails)) {
            return false;
        }
        DeviceDetails deviceDetails = (DeviceDetails) o;
        return Objects.equals(deviceId, deviceDetails.deviceId) &&
            Objects.equals(deviceName, deviceDetails.deviceName);
    }
    
    /**
     * Getter for DeviceId.
     * Square-issued ID of the device.
     */
    @JsonGetter("device_id")
    public String getDeviceId() { 
        return this.deviceId;
    }

    /**
     * Getter for DeviceName.
     * The name of the device set by the merchant.
     */
    @JsonGetter("device_name")
    public String getDeviceName() { 
        return this.deviceName;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .deviceId(getDeviceId())
            .deviceName(getDeviceName());
            return builder;
    }

    public static class Builder {
        private String deviceId;
        private String deviceName;

        public Builder() { }

        public Builder deviceId(String value) {
            deviceId = value;
            return this;
        }
        public Builder deviceName(String value) {
            deviceName = value;
            return this;
        }

        public DeviceDetails build() {
            return new DeviceDetails(deviceId,
                deviceName);
        }
    }
}
