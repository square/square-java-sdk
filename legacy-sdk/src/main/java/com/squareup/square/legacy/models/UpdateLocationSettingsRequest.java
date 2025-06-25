package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateLocationSettingsRequest type.
 */
public class UpdateLocationSettingsRequest {
    private final CheckoutLocationSettings locationSettings;

    /**
     * Initialization constructor.
     * @param  locationSettings  CheckoutLocationSettings value for locationSettings.
     */
    @JsonCreator
    public UpdateLocationSettingsRequest(@JsonProperty("location_settings") CheckoutLocationSettings locationSettings) {
        this.locationSettings = locationSettings;
    }

    /**
     * Getter for LocationSettings.
     * @return Returns the CheckoutLocationSettings
     */
    @JsonGetter("location_settings")
    public CheckoutLocationSettings getLocationSettings() {
        return locationSettings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationSettings);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateLocationSettingsRequest)) {
            return false;
        }
        UpdateLocationSettingsRequest other = (UpdateLocationSettingsRequest) obj;
        return Objects.equals(locationSettings, other.locationSettings);
    }

    /**
     * Converts this UpdateLocationSettingsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateLocationSettingsRequest [" + "locationSettings=" + locationSettings + "]";
    }

    /**
     * Builds a new {@link UpdateLocationSettingsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateLocationSettingsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationSettings);
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateLocationSettingsRequest}.
     */
    public static class Builder {
        private CheckoutLocationSettings locationSettings;

        /**
         * Initialization constructor.
         * @param  locationSettings  CheckoutLocationSettings value for locationSettings.
         */
        public Builder(CheckoutLocationSettings locationSettings) {
            this.locationSettings = locationSettings;
        }

        /**
         * Setter for locationSettings.
         * @param  locationSettings  CheckoutLocationSettings value for locationSettings.
         * @return Builder
         */
        public Builder locationSettings(CheckoutLocationSettings locationSettings) {
            this.locationSettings = locationSettings;
            return this;
        }

        /**
         * Builds a new {@link UpdateLocationSettingsRequest} object using the set fields.
         * @return {@link UpdateLocationSettingsRequest}
         */
        public UpdateLocationSettingsRequest build() {
            return new UpdateLocationSettingsRequest(locationSettings);
        }
    }
}
