
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DeviceCheckoutOptions type.
 */
public class DeviceCheckoutOptions {
    private final String deviceId;
    private final Boolean skipReceiptScreen;
    private final TipSettings tipSettings;

    /**
     * Initialization constructor.
     * @param deviceId String value for deviceId.
     * @param skipReceiptScreen Boolean value for skipReceiptScreen.
     * @param tipSettings TipSettings value for tipSettings.
     */
    @JsonCreator
    public DeviceCheckoutOptions(
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("skip_receipt_screen") Boolean skipReceiptScreen,
            @JsonProperty("tip_settings") TipSettings tipSettings) {
        this.deviceId = deviceId;
        this.skipReceiptScreen = skipReceiptScreen;
        this.tipSettings = tipSettings;
    }

    /**
     * Getter for DeviceId.
     * The unique ID of the device intended for this `TerminalCheckout`. A list of `DeviceCode`
     * objects can be retrieved from the /v2/devices/codes endpoint. Match a `DeviceCode.device_id`
     * value with `device_id` to get the associated device code.
     * @return Returns the String
     */
    @JsonGetter("device_id")
    public String getDeviceId() {
        return this.deviceId;
    }

    /**
     * Getter for SkipReceiptScreen.
     * Instruct the device to skip the receipt screen. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonGetter("skip_receipt_screen")
    public Boolean getSkipReceiptScreen() {
        return this.skipReceiptScreen;
    }

    /**
     * Getter for TipSettings.
     * @return Returns the TipSettings
     */
    @JsonGetter("tip_settings")
    public TipSettings getTipSettings() {
        return this.tipSettings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, skipReceiptScreen, tipSettings);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceCheckoutOptions)) {
            return false;
        }
        DeviceCheckoutOptions other = (DeviceCheckoutOptions) obj;
        return Objects.equals(deviceId, other.deviceId)
            && Objects.equals(skipReceiptScreen, other.skipReceiptScreen)
            && Objects.equals(tipSettings, other.tipSettings);
    }

    /**
     * Converts this DeviceCheckoutOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceCheckoutOptions [" + "deviceId=" + deviceId + ", skipReceiptScreen="
                + skipReceiptScreen + ", tipSettings=" + tipSettings + "]";
    }

    /**
     * Builds a new {@link DeviceCheckoutOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceCheckoutOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(deviceId)
                .skipReceiptScreen(getSkipReceiptScreen())
                .tipSettings(getTipSettings());
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceCheckoutOptions}.
     */
    public static class Builder {
        private String deviceId;
        private Boolean skipReceiptScreen;
        private TipSettings tipSettings;

        /**
         * Initialization constructor.
         * @param deviceId String value for deviceId.
         */
        public Builder(String deviceId) {
            this.deviceId = deviceId;
        }

        /**
         * Setter for deviceId.
         * @param deviceId String value for deviceId.
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        /**
         * Setter for skipReceiptScreen.
         * @param skipReceiptScreen Boolean value for skipReceiptScreen.
         * @return Builder
         */
        public Builder skipReceiptScreen(Boolean skipReceiptScreen) {
            this.skipReceiptScreen = skipReceiptScreen;
            return this;
        }

        /**
         * Setter for tipSettings.
         * @param tipSettings TipSettings value for tipSettings.
         * @return Builder
         */
        public Builder tipSettings(TipSettings tipSettings) {
            this.tipSettings = tipSettings;
            return this;
        }

        /**
         * Builds a new {@link DeviceCheckoutOptions} object using the set fields.
         * @return {@link DeviceCheckoutOptions}
         */
        public DeviceCheckoutOptions build() {
            return new DeviceCheckoutOptions(deviceId, skipReceiptScreen, tipSettings);
        }
    }
}
