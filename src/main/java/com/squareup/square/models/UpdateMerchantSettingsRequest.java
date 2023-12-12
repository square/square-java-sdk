
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateMerchantSettingsRequest type.
 */
public class UpdateMerchantSettingsRequest {
    private final CheckoutMerchantSettings merchantSettings;

    /**
     * Initialization constructor.
     * @param  merchantSettings  CheckoutMerchantSettings value for merchantSettings.
     */
    @JsonCreator
    public UpdateMerchantSettingsRequest(
            @JsonProperty("merchant_settings") CheckoutMerchantSettings merchantSettings) {
        this.merchantSettings = merchantSettings;
    }

    /**
     * Getter for MerchantSettings.
     * @return Returns the CheckoutMerchantSettings
     */
    @JsonGetter("merchant_settings")
    public CheckoutMerchantSettings getMerchantSettings() {
        return merchantSettings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantSettings);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateMerchantSettingsRequest)) {
            return false;
        }
        UpdateMerchantSettingsRequest other = (UpdateMerchantSettingsRequest) obj;
        return Objects.equals(merchantSettings, other.merchantSettings);
    }

    /**
     * Converts this UpdateMerchantSettingsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateMerchantSettingsRequest [" + "merchantSettings=" + merchantSettings + "]";
    }

    /**
     * Builds a new {@link UpdateMerchantSettingsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateMerchantSettingsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(merchantSettings);
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateMerchantSettingsRequest}.
     */
    public static class Builder {
        private CheckoutMerchantSettings merchantSettings;

        /**
         * Initialization constructor.
         * @param  merchantSettings  CheckoutMerchantSettings value for merchantSettings.
         */
        public Builder(CheckoutMerchantSettings merchantSettings) {
            this.merchantSettings = merchantSettings;
        }

        /**
         * Setter for merchantSettings.
         * @param  merchantSettings  CheckoutMerchantSettings value for merchantSettings.
         * @return Builder
         */
        public Builder merchantSettings(CheckoutMerchantSettings merchantSettings) {
            this.merchantSettings = merchantSettings;
            return this;
        }

        /**
         * Builds a new {@link UpdateMerchantSettingsRequest} object using the set fields.
         * @return {@link UpdateMerchantSettingsRequest}
         */
        public UpdateMerchantSettingsRequest build() {
            return new UpdateMerchantSettingsRequest(merchantSettings);
        }
    }
}
