package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for DeviceCheckoutOptions type.
 */
public class DeviceCheckoutOptions {

    /**
     * Initialization constructor.
     * @param deviceId
     * @param skipReceiptScreen
     * @param tipSettings
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

    private final String deviceId;
    private final Boolean skipReceiptScreen;
    private final TipSettings tipSettings;
    /**
     * Getter for DeviceId.
     * The unique Id of the device intended for this `TerminalCheckout`.
     * The Id can be retrieved from /v2/devices api.
     */
    @JsonGetter("device_id")
    public String getDeviceId() {
        return this.deviceId;
    }

    /**
     * Getter for SkipReceiptScreen.
     * Instruct the device to skip the receipt screen. Defaults to false.
     */
    @JsonGetter("skip_receipt_screen")
    public Boolean getSkipReceiptScreen() {
        return this.skipReceiptScreen;
    }

    /**
     * Getter for TipSettings.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof DeviceCheckoutOptions)) {
            return false;
        }
        DeviceCheckoutOptions deviceCheckoutOptions = (DeviceCheckoutOptions) obj;
        return Objects.equals(deviceId, deviceCheckoutOptions.deviceId) &&
            Objects.equals(skipReceiptScreen, deviceCheckoutOptions.skipReceiptScreen) &&
            Objects.equals(tipSettings, deviceCheckoutOptions.tipSettings);
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
     * Class to build instances of {@link DeviceCheckoutOptions}
     */
    public static class Builder {
        private String deviceId;
        private Boolean skipReceiptScreen;
        private TipSettings tipSettings;

        /**
         * Initialization constructor
         */
        public Builder(String deviceId) {
            this.deviceId = deviceId;
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
         * Setter for skipReceiptScreen
         * @param skipReceiptScreen
         * @return Builder
         */
        public Builder skipReceiptScreen(Boolean skipReceiptScreen) {
            this.skipReceiptScreen = skipReceiptScreen;
            return this;
        }
        /**
         * Setter for tipSettings
         * @param tipSettings
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
            return new DeviceCheckoutOptions(deviceId,
                skipReceiptScreen,
                tipSettings);
        }
    }
}
