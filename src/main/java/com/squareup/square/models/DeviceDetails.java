
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for DeviceDetails type.
 */
public class DeviceDetails {
    private final OptionalNullable<String> deviceId;
    private final OptionalNullable<String> deviceInstallationId;
    private final OptionalNullable<String> deviceName;

    /**
     * Initialization constructor.
     * @param  deviceId  String value for deviceId.
     * @param  deviceInstallationId  String value for deviceInstallationId.
     * @param  deviceName  String value for deviceName.
     */
    @JsonCreator
    public DeviceDetails(
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("device_installation_id") String deviceInstallationId,
            @JsonProperty("device_name") String deviceName) {
        this.deviceId = OptionalNullable.of(deviceId);
        this.deviceInstallationId = OptionalNullable.of(deviceInstallationId);
        this.deviceName = OptionalNullable.of(deviceName);
    }

    /**
     * Internal initialization constructor.
     */
    protected DeviceDetails(OptionalNullable<String> deviceId,
            OptionalNullable<String> deviceInstallationId, OptionalNullable<String> deviceName) {
        this.deviceId = deviceId;
        this.deviceInstallationId = deviceInstallationId;
        this.deviceName = deviceName;
    }

    /**
     * Internal Getter for DeviceId.
     * The Square-issued ID of the device.
     * @return Returns the Internal String
     */
    @JsonGetter("device_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDeviceId() {
        return this.deviceId;
    }

    /**
     * Getter for DeviceId.
     * The Square-issued ID of the device.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDeviceId() {
        return OptionalNullable.getFrom(deviceId);
    }

    /**
     * Internal Getter for DeviceInstallationId.
     * The Square-issued installation ID for the device.
     * @return Returns the Internal String
     */
    @JsonGetter("device_installation_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDeviceInstallationId() {
        return this.deviceInstallationId;
    }

    /**
     * Getter for DeviceInstallationId.
     * The Square-issued installation ID for the device.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDeviceInstallationId() {
        return OptionalNullable.getFrom(deviceInstallationId);
    }

    /**
     * Internal Getter for DeviceName.
     * The name of the device set by the seller.
     * @return Returns the Internal String
     */
    @JsonGetter("device_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDeviceName() {
        return this.deviceName;
    }

    /**
     * Getter for DeviceName.
     * The name of the device set by the seller.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDeviceName() {
        return OptionalNullable.getFrom(deviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceInstallationId, deviceName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceDetails)) {
            return false;
        }
        DeviceDetails other = (DeviceDetails) obj;
        return Objects.equals(deviceId, other.deviceId)
            && Objects.equals(deviceInstallationId, other.deviceInstallationId)
            && Objects.equals(deviceName, other.deviceName);
    }

    /**
     * Converts this DeviceDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceDetails [" + "deviceId=" + deviceId + ", deviceInstallationId="
                + deviceInstallationId + ", deviceName=" + deviceName + "]";
    }

    /**
     * Builds a new {@link DeviceDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.deviceId = internalGetDeviceId();
        builder.deviceInstallationId = internalGetDeviceInstallationId();
        builder.deviceName = internalGetDeviceName();
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceDetails}.
     */
    public static class Builder {
        private OptionalNullable<String> deviceId;
        private OptionalNullable<String> deviceInstallationId;
        private OptionalNullable<String> deviceName;



        /**
         * Setter for deviceId.
         * @param  deviceId  String value for deviceId.
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = OptionalNullable.of(deviceId);
            return this;
        }

        /**
         * UnSetter for deviceId.
         * @return Builder
         */
        public Builder unsetDeviceId() {
            deviceId = null;
            return this;
        }

        /**
         * Setter for deviceInstallationId.
         * @param  deviceInstallationId  String value for deviceInstallationId.
         * @return Builder
         */
        public Builder deviceInstallationId(String deviceInstallationId) {
            this.deviceInstallationId = OptionalNullable.of(deviceInstallationId);
            return this;
        }

        /**
         * UnSetter for deviceInstallationId.
         * @return Builder
         */
        public Builder unsetDeviceInstallationId() {
            deviceInstallationId = null;
            return this;
        }

        /**
         * Setter for deviceName.
         * @param  deviceName  String value for deviceName.
         * @return Builder
         */
        public Builder deviceName(String deviceName) {
            this.deviceName = OptionalNullable.of(deviceName);
            return this;
        }

        /**
         * UnSetter for deviceName.
         * @return Builder
         */
        public Builder unsetDeviceName() {
            deviceName = null;
            return this;
        }

        /**
         * Builds a new {@link DeviceDetails} object using the set fields.
         * @return {@link DeviceDetails}
         */
        public DeviceDetails build() {
            return new DeviceDetails(deviceId, deviceInstallationId, deviceName);
        }
    }
}
