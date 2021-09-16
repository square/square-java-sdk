
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TerminalDeviceCheckoutOptions type.
 */
public class TerminalDeviceCheckoutOptions {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean skipReceiptScreen;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TipSettings tipSettings;

    /**
     * Initialization constructor.
     * @param  skipReceiptScreen  Boolean value for skipReceiptScreen.
     * @param  tipSettings  TipSettings value for tipSettings.
     */
    @JsonCreator
    public TerminalDeviceCheckoutOptions(
            @JsonProperty("skip_receipt_screen") Boolean skipReceiptScreen,
            @JsonProperty("tip_settings") TipSettings tipSettings) {
        this.skipReceiptScreen = skipReceiptScreen;
        this.tipSettings = tipSettings;
    }

    /**
     * Getter for SkipReceiptScreen.
     * Instructs the device to skip the receipt screen. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonGetter("skip_receipt_screen")
    public Boolean getSkipReceiptScreen() {
        return skipReceiptScreen;
    }

    /**
     * Getter for TipSettings.
     * @return Returns the TipSettings
     */
    @JsonGetter("tip_settings")
    public TipSettings getTipSettings() {
        return tipSettings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skipReceiptScreen, tipSettings);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TerminalDeviceCheckoutOptions)) {
            return false;
        }
        TerminalDeviceCheckoutOptions other = (TerminalDeviceCheckoutOptions) obj;
        return Objects.equals(skipReceiptScreen, other.skipReceiptScreen)
            && Objects.equals(tipSettings, other.tipSettings);
    }

    /**
     * Converts this TerminalDeviceCheckoutOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalDeviceCheckoutOptions [" + "skipReceiptScreen=" + skipReceiptScreen
                + ", tipSettings=" + tipSettings + "]";
    }

    /**
     * Builds a new {@link TerminalDeviceCheckoutOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalDeviceCheckoutOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .skipReceiptScreen(getSkipReceiptScreen())
                .tipSettings(getTipSettings());
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalDeviceCheckoutOptions}.
     */
    public static class Builder {
        private Boolean skipReceiptScreen;
        private TipSettings tipSettings;



        /**
         * Setter for skipReceiptScreen.
         * @param  skipReceiptScreen  Boolean value for skipReceiptScreen.
         * @return Builder
         */
        public Builder skipReceiptScreen(Boolean skipReceiptScreen) {
            this.skipReceiptScreen = skipReceiptScreen;
            return this;
        }

        /**
         * Setter for tipSettings.
         * @param  tipSettings  TipSettings value for tipSettings.
         * @return Builder
         */
        public Builder tipSettings(TipSettings tipSettings) {
            this.tipSettings = tipSettings;
            return this;
        }

        /**
         * Builds a new {@link TerminalDeviceCheckoutOptions} object using the set fields.
         * @return {@link TerminalDeviceCheckoutOptions}
         */
        public TerminalDeviceCheckoutOptions build() {
            return new TerminalDeviceCheckoutOptions(skipReceiptScreen, tipSettings);
        }
    }
}
