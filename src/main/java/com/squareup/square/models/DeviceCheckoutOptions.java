
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
 * This is a model class for DeviceCheckoutOptions type.
 */
public class DeviceCheckoutOptions {
    private final String deviceId;
    private final OptionalNullable<Boolean> skipReceiptScreen;
    private final OptionalNullable<Boolean> collectSignature;
    private final TipSettings tipSettings;
    private final OptionalNullable<Boolean> showItemizedCart;

    /**
     * Initialization constructor.
     * @param  deviceId  String value for deviceId.
     * @param  skipReceiptScreen  Boolean value for skipReceiptScreen.
     * @param  collectSignature  Boolean value for collectSignature.
     * @param  tipSettings  TipSettings value for tipSettings.
     * @param  showItemizedCart  Boolean value for showItemizedCart.
     */
    @JsonCreator
    public DeviceCheckoutOptions(
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("skip_receipt_screen") Boolean skipReceiptScreen,
            @JsonProperty("collect_signature") Boolean collectSignature,
            @JsonProperty("tip_settings") TipSettings tipSettings,
            @JsonProperty("show_itemized_cart") Boolean showItemizedCart) {
        this.deviceId = deviceId;
        this.skipReceiptScreen = OptionalNullable.of(skipReceiptScreen);
        this.collectSignature = OptionalNullable.of(collectSignature);
        this.tipSettings = tipSettings;
        this.showItemizedCart = OptionalNullable.of(showItemizedCart);
    }

    /**
     * Internal initialization constructor.
     */
    protected DeviceCheckoutOptions(String deviceId, OptionalNullable<Boolean> skipReceiptScreen,
            OptionalNullable<Boolean> collectSignature, TipSettings tipSettings,
            OptionalNullable<Boolean> showItemizedCart) {
        this.deviceId = deviceId;
        this.skipReceiptScreen = skipReceiptScreen;
        this.collectSignature = collectSignature;
        this.tipSettings = tipSettings;
        this.showItemizedCart = showItemizedCart;
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
        return deviceId;
    }

    /**
     * Internal Getter for SkipReceiptScreen.
     * Instructs the device to skip the receipt screen. Defaults to false.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("skip_receipt_screen")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetSkipReceiptScreen() {
        return this.skipReceiptScreen;
    }

    /**
     * Getter for SkipReceiptScreen.
     * Instructs the device to skip the receipt screen. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getSkipReceiptScreen() {
        return OptionalNullable.getFrom(skipReceiptScreen);
    }

    /**
     * Internal Getter for CollectSignature.
     * Indicates that signature collection is desired during checkout. Defaults to false.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("collect_signature")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetCollectSignature() {
        return this.collectSignature;
    }

    /**
     * Getter for CollectSignature.
     * Indicates that signature collection is desired during checkout. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getCollectSignature() {
        return OptionalNullable.getFrom(collectSignature);
    }

    /**
     * Getter for TipSettings.
     * @return Returns the TipSettings
     */
    @JsonGetter("tip_settings")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TipSettings getTipSettings() {
        return tipSettings;
    }

    /**
     * Internal Getter for ShowItemizedCart.
     * Show the itemization screen prior to taking a payment. This field is only meaningful when the
     * checkout includes an order ID. Defaults to true.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("show_itemized_cart")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetShowItemizedCart() {
        return this.showItemizedCart;
    }

    /**
     * Getter for ShowItemizedCart.
     * Show the itemization screen prior to taking a payment. This field is only meaningful when the
     * checkout includes an order ID. Defaults to true.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getShowItemizedCart() {
        return OptionalNullable.getFrom(showItemizedCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, skipReceiptScreen, collectSignature, tipSettings,
                showItemizedCart);
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
            && Objects.equals(collectSignature, other.collectSignature)
            && Objects.equals(tipSettings, other.tipSettings)
            && Objects.equals(showItemizedCart, other.showItemizedCart);
    }

    /**
     * Converts this DeviceCheckoutOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceCheckoutOptions [" + "deviceId=" + deviceId + ", skipReceiptScreen="
                + skipReceiptScreen + ", collectSignature=" + collectSignature + ", tipSettings="
                + tipSettings + ", showItemizedCart=" + showItemizedCart + "]";
    }

    /**
     * Builds a new {@link DeviceCheckoutOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceCheckoutOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(deviceId)
                .tipSettings(getTipSettings());
        builder.skipReceiptScreen = internalGetSkipReceiptScreen();
        builder.collectSignature = internalGetCollectSignature();
        builder.showItemizedCart = internalGetShowItemizedCart();
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceCheckoutOptions}.
     */
    public static class Builder {
        private String deviceId;
        private OptionalNullable<Boolean> skipReceiptScreen;
        private OptionalNullable<Boolean> collectSignature;
        private TipSettings tipSettings;
        private OptionalNullable<Boolean> showItemizedCart;

        /**
         * Initialization constructor.
         * @param  deviceId  String value for deviceId.
         */
        public Builder(String deviceId) {
            this.deviceId = deviceId;
        }

        /**
         * Setter for deviceId.
         * @param  deviceId  String value for deviceId.
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        /**
         * Setter for skipReceiptScreen.
         * @param  skipReceiptScreen  Boolean value for skipReceiptScreen.
         * @return Builder
         */
        public Builder skipReceiptScreen(Boolean skipReceiptScreen) {
            this.skipReceiptScreen = OptionalNullable.of(skipReceiptScreen);
            return this;
        }

        /**
         * UnSetter for skipReceiptScreen.
         * @return Builder
         */
        public Builder unsetSkipReceiptScreen() {
            skipReceiptScreen = null;
            return this;
        }

        /**
         * Setter for collectSignature.
         * @param  collectSignature  Boolean value for collectSignature.
         * @return Builder
         */
        public Builder collectSignature(Boolean collectSignature) {
            this.collectSignature = OptionalNullable.of(collectSignature);
            return this;
        }

        /**
         * UnSetter for collectSignature.
         * @return Builder
         */
        public Builder unsetCollectSignature() {
            collectSignature = null;
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
         * Setter for showItemizedCart.
         * @param  showItemizedCart  Boolean value for showItemizedCart.
         * @return Builder
         */
        public Builder showItemizedCart(Boolean showItemizedCart) {
            this.showItemizedCart = OptionalNullable.of(showItemizedCart);
            return this;
        }

        /**
         * UnSetter for showItemizedCart.
         * @return Builder
         */
        public Builder unsetShowItemizedCart() {
            showItemizedCart = null;
            return this;
        }

        /**
         * Builds a new {@link DeviceCheckoutOptions} object using the set fields.
         * @return {@link DeviceCheckoutOptions}
         */
        public DeviceCheckoutOptions build() {
            return new DeviceCheckoutOptions(deviceId, skipReceiptScreen, collectSignature,
                    tipSettings, showItemizedCart);
        }
    }
}
