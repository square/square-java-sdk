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
 * This is a model class for DeviceMetadata type.
 */
public class DeviceMetadata {
    private final OptionalNullable<String> batteryPercentage;
    private final OptionalNullable<String> chargingState;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> merchantId;
    private final OptionalNullable<String> networkConnectionType;
    private final OptionalNullable<String> paymentRegion;
    private final OptionalNullable<String> serialNumber;
    private final OptionalNullable<String> osVersion;
    private final OptionalNullable<String> appVersion;
    private final OptionalNullable<String> wifiNetworkName;
    private final OptionalNullable<String> wifiNetworkStrength;
    private final OptionalNullable<String> ipAddress;

    /**
     * Initialization constructor.
     * @param  batteryPercentage  String value for batteryPercentage.
     * @param  chargingState  String value for chargingState.
     * @param  locationId  String value for locationId.
     * @param  merchantId  String value for merchantId.
     * @param  networkConnectionType  String value for networkConnectionType.
     * @param  paymentRegion  String value for paymentRegion.
     * @param  serialNumber  String value for serialNumber.
     * @param  osVersion  String value for osVersion.
     * @param  appVersion  String value for appVersion.
     * @param  wifiNetworkName  String value for wifiNetworkName.
     * @param  wifiNetworkStrength  String value for wifiNetworkStrength.
     * @param  ipAddress  String value for ipAddress.
     */
    @JsonCreator
    public DeviceMetadata(
            @JsonProperty("battery_percentage") String batteryPercentage,
            @JsonProperty("charging_state") String chargingState,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("network_connection_type") String networkConnectionType,
            @JsonProperty("payment_region") String paymentRegion,
            @JsonProperty("serial_number") String serialNumber,
            @JsonProperty("os_version") String osVersion,
            @JsonProperty("app_version") String appVersion,
            @JsonProperty("wifi_network_name") String wifiNetworkName,
            @JsonProperty("wifi_network_strength") String wifiNetworkStrength,
            @JsonProperty("ip_address") String ipAddress) {
        this.batteryPercentage = OptionalNullable.of(batteryPercentage);
        this.chargingState = OptionalNullable.of(chargingState);
        this.locationId = OptionalNullable.of(locationId);
        this.merchantId = OptionalNullable.of(merchantId);
        this.networkConnectionType = OptionalNullable.of(networkConnectionType);
        this.paymentRegion = OptionalNullable.of(paymentRegion);
        this.serialNumber = OptionalNullable.of(serialNumber);
        this.osVersion = OptionalNullable.of(osVersion);
        this.appVersion = OptionalNullable.of(appVersion);
        this.wifiNetworkName = OptionalNullable.of(wifiNetworkName);
        this.wifiNetworkStrength = OptionalNullable.of(wifiNetworkStrength);
        this.ipAddress = OptionalNullable.of(ipAddress);
    }

    /**
     * Initialization constructor.
     * @param  batteryPercentage  String value for batteryPercentage.
     * @param  chargingState  String value for chargingState.
     * @param  locationId  String value for locationId.
     * @param  merchantId  String value for merchantId.
     * @param  networkConnectionType  String value for networkConnectionType.
     * @param  paymentRegion  String value for paymentRegion.
     * @param  serialNumber  String value for serialNumber.
     * @param  osVersion  String value for osVersion.
     * @param  appVersion  String value for appVersion.
     * @param  wifiNetworkName  String value for wifiNetworkName.
     * @param  wifiNetworkStrength  String value for wifiNetworkStrength.
     * @param  ipAddress  String value for ipAddress.
     */
    protected DeviceMetadata(
            OptionalNullable<String> batteryPercentage,
            OptionalNullable<String> chargingState,
            OptionalNullable<String> locationId,
            OptionalNullable<String> merchantId,
            OptionalNullable<String> networkConnectionType,
            OptionalNullable<String> paymentRegion,
            OptionalNullable<String> serialNumber,
            OptionalNullable<String> osVersion,
            OptionalNullable<String> appVersion,
            OptionalNullable<String> wifiNetworkName,
            OptionalNullable<String> wifiNetworkStrength,
            OptionalNullable<String> ipAddress) {
        this.batteryPercentage = batteryPercentage;
        this.chargingState = chargingState;
        this.locationId = locationId;
        this.merchantId = merchantId;
        this.networkConnectionType = networkConnectionType;
        this.paymentRegion = paymentRegion;
        this.serialNumber = serialNumber;
        this.osVersion = osVersion;
        this.appVersion = appVersion;
        this.wifiNetworkName = wifiNetworkName;
        this.wifiNetworkStrength = wifiNetworkStrength;
        this.ipAddress = ipAddress;
    }

    /**
     * Internal Getter for BatteryPercentage.
     * The Terminal’s remaining battery percentage, between 1-100.
     * @return Returns the Internal String
     */
    @JsonGetter("battery_percentage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBatteryPercentage() {
        return this.batteryPercentage;
    }

    /**
     * Getter for BatteryPercentage.
     * The Terminal’s remaining battery percentage, between 1-100.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBatteryPercentage() {
        return OptionalNullable.getFrom(batteryPercentage);
    }

    /**
     * Internal Getter for ChargingState.
     * The current charging state of the Terminal. Options: `CHARGING`, `NOT_CHARGING`
     * @return Returns the Internal String
     */
    @JsonGetter("charging_state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetChargingState() {
        return this.chargingState;
    }

    /**
     * Getter for ChargingState.
     * The current charging state of the Terminal. Options: `CHARGING`, `NOT_CHARGING`
     * @return Returns the String
     */
    @JsonIgnore
    public String getChargingState() {
        return OptionalNullable.getFrom(chargingState);
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the Square seller business location associated with the Terminal.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The ID of the Square seller business location associated with the Terminal.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for MerchantId.
     * The ID of the Square merchant account that is currently signed-in to the Terminal.
     * @return Returns the Internal String
     */
    @JsonGetter("merchant_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMerchantId() {
        return this.merchantId;
    }

    /**
     * Getter for MerchantId.
     * The ID of the Square merchant account that is currently signed-in to the Terminal.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMerchantId() {
        return OptionalNullable.getFrom(merchantId);
    }

    /**
     * Internal Getter for NetworkConnectionType.
     * The Terminal’s current network connection type. Options: `WIFI`, `ETHERNET`
     * @return Returns the Internal String
     */
    @JsonGetter("network_connection_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNetworkConnectionType() {
        return this.networkConnectionType;
    }

    /**
     * Getter for NetworkConnectionType.
     * The Terminal’s current network connection type. Options: `WIFI`, `ETHERNET`
     * @return Returns the String
     */
    @JsonIgnore
    public String getNetworkConnectionType() {
        return OptionalNullable.getFrom(networkConnectionType);
    }

    /**
     * Internal Getter for PaymentRegion.
     * The country in which the Terminal is authorized to take payments.
     * @return Returns the Internal String
     */
    @JsonGetter("payment_region")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPaymentRegion() {
        return this.paymentRegion;
    }

    /**
     * Getter for PaymentRegion.
     * The country in which the Terminal is authorized to take payments.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPaymentRegion() {
        return OptionalNullable.getFrom(paymentRegion);
    }

    /**
     * Internal Getter for SerialNumber.
     * The unique identifier assigned to the Terminal, which can be found on the lower back of the
     * device.
     * @return Returns the Internal String
     */
    @JsonGetter("serial_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSerialNumber() {
        return this.serialNumber;
    }

    /**
     * Getter for SerialNumber.
     * The unique identifier assigned to the Terminal, which can be found on the lower back of the
     * device.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSerialNumber() {
        return OptionalNullable.getFrom(serialNumber);
    }

    /**
     * Internal Getter for OsVersion.
     * The current version of the Terminal’s operating system.
     * @return Returns the Internal String
     */
    @JsonGetter("os_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOsVersion() {
        return this.osVersion;
    }

    /**
     * Getter for OsVersion.
     * The current version of the Terminal’s operating system.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOsVersion() {
        return OptionalNullable.getFrom(osVersion);
    }

    /**
     * Internal Getter for AppVersion.
     * The current version of the application running on the Terminal.
     * @return Returns the Internal String
     */
    @JsonGetter("app_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAppVersion() {
        return this.appVersion;
    }

    /**
     * Getter for AppVersion.
     * The current version of the application running on the Terminal.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAppVersion() {
        return OptionalNullable.getFrom(appVersion);
    }

    /**
     * Internal Getter for WifiNetworkName.
     * The name of the Wi-Fi network to which the Terminal is connected.
     * @return Returns the Internal String
     */
    @JsonGetter("wifi_network_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetWifiNetworkName() {
        return this.wifiNetworkName;
    }

    /**
     * Getter for WifiNetworkName.
     * The name of the Wi-Fi network to which the Terminal is connected.
     * @return Returns the String
     */
    @JsonIgnore
    public String getWifiNetworkName() {
        return OptionalNullable.getFrom(wifiNetworkName);
    }

    /**
     * Internal Getter for WifiNetworkStrength.
     * The signal strength of the Wi-FI network connection. Options: `POOR`, `FAIR`, `GOOD`,
     * `EXCELLENT`
     * @return Returns the Internal String
     */
    @JsonGetter("wifi_network_strength")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetWifiNetworkStrength() {
        return this.wifiNetworkStrength;
    }

    /**
     * Getter for WifiNetworkStrength.
     * The signal strength of the Wi-FI network connection. Options: `POOR`, `FAIR`, `GOOD`,
     * `EXCELLENT`
     * @return Returns the String
     */
    @JsonIgnore
    public String getWifiNetworkStrength() {
        return OptionalNullable.getFrom(wifiNetworkStrength);
    }

    /**
     * Internal Getter for IpAddress.
     * The IP address of the Terminal.
     * @return Returns the Internal String
     */
    @JsonGetter("ip_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetIpAddress() {
        return this.ipAddress;
    }

    /**
     * Getter for IpAddress.
     * The IP address of the Terminal.
     * @return Returns the String
     */
    @JsonIgnore
    public String getIpAddress() {
        return OptionalNullable.getFrom(ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                batteryPercentage,
                chargingState,
                locationId,
                merchantId,
                networkConnectionType,
                paymentRegion,
                serialNumber,
                osVersion,
                appVersion,
                wifiNetworkName,
                wifiNetworkStrength,
                ipAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceMetadata)) {
            return false;
        }
        DeviceMetadata other = (DeviceMetadata) obj;
        return Objects.equals(batteryPercentage, other.batteryPercentage)
                && Objects.equals(chargingState, other.chargingState)
                && Objects.equals(locationId, other.locationId)
                && Objects.equals(merchantId, other.merchantId)
                && Objects.equals(networkConnectionType, other.networkConnectionType)
                && Objects.equals(paymentRegion, other.paymentRegion)
                && Objects.equals(serialNumber, other.serialNumber)
                && Objects.equals(osVersion, other.osVersion)
                && Objects.equals(appVersion, other.appVersion)
                && Objects.equals(wifiNetworkName, other.wifiNetworkName)
                && Objects.equals(wifiNetworkStrength, other.wifiNetworkStrength)
                && Objects.equals(ipAddress, other.ipAddress);
    }

    /**
     * Converts this DeviceMetadata into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceMetadata [" + "batteryPercentage=" + batteryPercentage + ", chargingState="
                + chargingState + ", locationId=" + locationId + ", merchantId=" + merchantId
                + ", networkConnectionType=" + networkConnectionType + ", paymentRegion="
                + paymentRegion + ", serialNumber=" + serialNumber + ", osVersion=" + osVersion
                + ", appVersion=" + appVersion + ", wifiNetworkName=" + wifiNetworkName
                + ", wifiNetworkStrength=" + wifiNetworkStrength + ", ipAddress=" + ipAddress + "]";
    }

    /**
     * Builds a new {@link DeviceMetadata.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceMetadata.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.batteryPercentage = internalGetBatteryPercentage();
        builder.chargingState = internalGetChargingState();
        builder.locationId = internalGetLocationId();
        builder.merchantId = internalGetMerchantId();
        builder.networkConnectionType = internalGetNetworkConnectionType();
        builder.paymentRegion = internalGetPaymentRegion();
        builder.serialNumber = internalGetSerialNumber();
        builder.osVersion = internalGetOsVersion();
        builder.appVersion = internalGetAppVersion();
        builder.wifiNetworkName = internalGetWifiNetworkName();
        builder.wifiNetworkStrength = internalGetWifiNetworkStrength();
        builder.ipAddress = internalGetIpAddress();
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceMetadata}.
     */
    public static class Builder {
        private OptionalNullable<String> batteryPercentage;
        private OptionalNullable<String> chargingState;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> merchantId;
        private OptionalNullable<String> networkConnectionType;
        private OptionalNullable<String> paymentRegion;
        private OptionalNullable<String> serialNumber;
        private OptionalNullable<String> osVersion;
        private OptionalNullable<String> appVersion;
        private OptionalNullable<String> wifiNetworkName;
        private OptionalNullable<String> wifiNetworkStrength;
        private OptionalNullable<String> ipAddress;

        /**
         * Setter for batteryPercentage.
         * @param  batteryPercentage  String value for batteryPercentage.
         * @return Builder
         */
        public Builder batteryPercentage(String batteryPercentage) {
            this.batteryPercentage = OptionalNullable.of(batteryPercentage);
            return this;
        }

        /**
         * UnSetter for batteryPercentage.
         * @return Builder
         */
        public Builder unsetBatteryPercentage() {
            batteryPercentage = null;
            return this;
        }

        /**
         * Setter for chargingState.
         * @param  chargingState  String value for chargingState.
         * @return Builder
         */
        public Builder chargingState(String chargingState) {
            this.chargingState = OptionalNullable.of(chargingState);
            return this;
        }

        /**
         * UnSetter for chargingState.
         * @return Builder
         */
        public Builder unsetChargingState() {
            chargingState = null;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for merchantId.
         * @param  merchantId  String value for merchantId.
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = OptionalNullable.of(merchantId);
            return this;
        }

        /**
         * UnSetter for merchantId.
         * @return Builder
         */
        public Builder unsetMerchantId() {
            merchantId = null;
            return this;
        }

        /**
         * Setter for networkConnectionType.
         * @param  networkConnectionType  String value for networkConnectionType.
         * @return Builder
         */
        public Builder networkConnectionType(String networkConnectionType) {
            this.networkConnectionType = OptionalNullable.of(networkConnectionType);
            return this;
        }

        /**
         * UnSetter for networkConnectionType.
         * @return Builder
         */
        public Builder unsetNetworkConnectionType() {
            networkConnectionType = null;
            return this;
        }

        /**
         * Setter for paymentRegion.
         * @param  paymentRegion  String value for paymentRegion.
         * @return Builder
         */
        public Builder paymentRegion(String paymentRegion) {
            this.paymentRegion = OptionalNullable.of(paymentRegion);
            return this;
        }

        /**
         * UnSetter for paymentRegion.
         * @return Builder
         */
        public Builder unsetPaymentRegion() {
            paymentRegion = null;
            return this;
        }

        /**
         * Setter for serialNumber.
         * @param  serialNumber  String value for serialNumber.
         * @return Builder
         */
        public Builder serialNumber(String serialNumber) {
            this.serialNumber = OptionalNullable.of(serialNumber);
            return this;
        }

        /**
         * UnSetter for serialNumber.
         * @return Builder
         */
        public Builder unsetSerialNumber() {
            serialNumber = null;
            return this;
        }

        /**
         * Setter for osVersion.
         * @param  osVersion  String value for osVersion.
         * @return Builder
         */
        public Builder osVersion(String osVersion) {
            this.osVersion = OptionalNullable.of(osVersion);
            return this;
        }

        /**
         * UnSetter for osVersion.
         * @return Builder
         */
        public Builder unsetOsVersion() {
            osVersion = null;
            return this;
        }

        /**
         * Setter for appVersion.
         * @param  appVersion  String value for appVersion.
         * @return Builder
         */
        public Builder appVersion(String appVersion) {
            this.appVersion = OptionalNullable.of(appVersion);
            return this;
        }

        /**
         * UnSetter for appVersion.
         * @return Builder
         */
        public Builder unsetAppVersion() {
            appVersion = null;
            return this;
        }

        /**
         * Setter for wifiNetworkName.
         * @param  wifiNetworkName  String value for wifiNetworkName.
         * @return Builder
         */
        public Builder wifiNetworkName(String wifiNetworkName) {
            this.wifiNetworkName = OptionalNullable.of(wifiNetworkName);
            return this;
        }

        /**
         * UnSetter for wifiNetworkName.
         * @return Builder
         */
        public Builder unsetWifiNetworkName() {
            wifiNetworkName = null;
            return this;
        }

        /**
         * Setter for wifiNetworkStrength.
         * @param  wifiNetworkStrength  String value for wifiNetworkStrength.
         * @return Builder
         */
        public Builder wifiNetworkStrength(String wifiNetworkStrength) {
            this.wifiNetworkStrength = OptionalNullable.of(wifiNetworkStrength);
            return this;
        }

        /**
         * UnSetter for wifiNetworkStrength.
         * @return Builder
         */
        public Builder unsetWifiNetworkStrength() {
            wifiNetworkStrength = null;
            return this;
        }

        /**
         * Setter for ipAddress.
         * @param  ipAddress  String value for ipAddress.
         * @return Builder
         */
        public Builder ipAddress(String ipAddress) {
            this.ipAddress = OptionalNullable.of(ipAddress);
            return this;
        }

        /**
         * UnSetter for ipAddress.
         * @return Builder
         */
        public Builder unsetIpAddress() {
            ipAddress = null;
            return this;
        }

        /**
         * Builds a new {@link DeviceMetadata} object using the set fields.
         * @return {@link DeviceMetadata}
         */
        public DeviceMetadata build() {
            return new DeviceMetadata(
                    batteryPercentage,
                    chargingState,
                    locationId,
                    merchantId,
                    networkConnectionType,
                    paymentRegion,
                    serialNumber,
                    osVersion,
                    appVersion,
                    wifiNetworkName,
                    wifiNetworkStrength,
                    ipAddress);
        }
    }
}
