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
 * This is a model class for DeviceComponentDetailsApplicationDetails type.
 */
public class DeviceComponentDetailsApplicationDetails {
    private final String applicationType;
    private final String version;
    private final OptionalNullable<String> sessionLocation;
    private final OptionalNullable<String> deviceCodeId;

    /**
     * Initialization constructor.
     * @param  applicationType  String value for applicationType.
     * @param  version  String value for version.
     * @param  sessionLocation  String value for sessionLocation.
     * @param  deviceCodeId  String value for deviceCodeId.
     */
    @JsonCreator
    public DeviceComponentDetailsApplicationDetails(
            @JsonProperty("application_type") String applicationType,
            @JsonProperty("version") String version,
            @JsonProperty("session_location") String sessionLocation,
            @JsonProperty("device_code_id") String deviceCodeId) {
        this.applicationType = applicationType;
        this.version = version;
        this.sessionLocation = OptionalNullable.of(sessionLocation);
        this.deviceCodeId = OptionalNullable.of(deviceCodeId);
    }

    /**
     * Initialization constructor.
     * @param  applicationType  String value for applicationType.
     * @param  version  String value for version.
     * @param  sessionLocation  String value for sessionLocation.
     * @param  deviceCodeId  String value for deviceCodeId.
     */
    protected DeviceComponentDetailsApplicationDetails(
            String applicationType,
            String version,
            OptionalNullable<String> sessionLocation,
            OptionalNullable<String> deviceCodeId) {
        this.applicationType = applicationType;
        this.version = version;
        this.sessionLocation = sessionLocation;
        this.deviceCodeId = deviceCodeId;
    }

    /**
     * Getter for ApplicationType.
     * @return Returns the String
     */
    @JsonGetter("application_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getApplicationType() {
        return applicationType;
    }

    /**
     * Getter for Version.
     * The version of the application.
     * @return Returns the String
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getVersion() {
        return version;
    }

    /**
     * Internal Getter for SessionLocation.
     * The location_id of the session for the application.
     * @return Returns the Internal String
     */
    @JsonGetter("session_location")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSessionLocation() {
        return this.sessionLocation;
    }

    /**
     * Getter for SessionLocation.
     * The location_id of the session for the application.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSessionLocation() {
        return OptionalNullable.getFrom(sessionLocation);
    }

    /**
     * Internal Getter for DeviceCodeId.
     * The id of the device code that was used to log in to the device.
     * @return Returns the Internal String
     */
    @JsonGetter("device_code_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDeviceCodeId() {
        return this.deviceCodeId;
    }

    /**
     * Getter for DeviceCodeId.
     * The id of the device code that was used to log in to the device.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDeviceCodeId() {
        return OptionalNullable.getFrom(deviceCodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationType, version, sessionLocation, deviceCodeId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceComponentDetailsApplicationDetails)) {
            return false;
        }
        DeviceComponentDetailsApplicationDetails other = (DeviceComponentDetailsApplicationDetails) obj;
        return Objects.equals(applicationType, other.applicationType)
                && Objects.equals(version, other.version)
                && Objects.equals(sessionLocation, other.sessionLocation)
                && Objects.equals(deviceCodeId, other.deviceCodeId);
    }

    /**
     * Converts this DeviceComponentDetailsApplicationDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceComponentDetailsApplicationDetails [" + "applicationType=" + applicationType
                + ", version=" + version + ", sessionLocation=" + sessionLocation
                + ", deviceCodeId=" + deviceCodeId + "]";
    }

    /**
     * Builds a new {@link DeviceComponentDetailsApplicationDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceComponentDetailsApplicationDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().applicationType(getApplicationType()).version(getVersion());
        builder.sessionLocation = internalGetSessionLocation();
        builder.deviceCodeId = internalGetDeviceCodeId();
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceComponentDetailsApplicationDetails}.
     */
    public static class Builder {
        private String applicationType;
        private String version;
        private OptionalNullable<String> sessionLocation;
        private OptionalNullable<String> deviceCodeId;

        /**
         * Setter for applicationType.
         * @param  applicationType  String value for applicationType.
         * @return Builder
         */
        public Builder applicationType(String applicationType) {
            this.applicationType = applicationType;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  String value for version.
         * @return Builder
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for sessionLocation.
         * @param  sessionLocation  String value for sessionLocation.
         * @return Builder
         */
        public Builder sessionLocation(String sessionLocation) {
            this.sessionLocation = OptionalNullable.of(sessionLocation);
            return this;
        }

        /**
         * UnSetter for sessionLocation.
         * @return Builder
         */
        public Builder unsetSessionLocation() {
            sessionLocation = null;
            return this;
        }

        /**
         * Setter for deviceCodeId.
         * @param  deviceCodeId  String value for deviceCodeId.
         * @return Builder
         */
        public Builder deviceCodeId(String deviceCodeId) {
            this.deviceCodeId = OptionalNullable.of(deviceCodeId);
            return this;
        }

        /**
         * UnSetter for deviceCodeId.
         * @return Builder
         */
        public Builder unsetDeviceCodeId() {
            deviceCodeId = null;
            return this;
        }

        /**
         * Builds a new {@link DeviceComponentDetailsApplicationDetails} object using the set
         * fields.
         * @return {@link DeviceComponentDetailsApplicationDetails}
         */
        public DeviceComponentDetailsApplicationDetails build() {
            return new DeviceComponentDetailsApplicationDetails(
                    applicationType, version, sessionLocation, deviceCodeId);
        }
    }
}
