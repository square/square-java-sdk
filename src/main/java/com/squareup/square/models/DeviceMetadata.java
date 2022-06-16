
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DeviceMetadata type.
 */
public class DeviceMetadata {
    private final String batteryPercentage;
    private final String chargingState;
    private final String locationId;
    private final String merchantId;
    private final String networkConnectionType;
    private final String paymentRegion;
    private final String serialNumber;
    private final String osVersion;
    private final String appVersion;
    private final String wifiNetworkName;
    private final String wifiNetworkStrength;
    private final String ipAddress;

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
     * Getter for BatteryPercentage.
     * The Terminal’s remaining battery percentage, between 1-100.
     * @return Returns the String
     */
    @JsonGetter("battery_percentage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBatteryPercentage() {
        return batteryPercentage;
    }

    /**
     * Getter for ChargingState.
     * The current charging state of the Terminal. Options: `CHARGING`, `NOT_CHARGING`
     * @return Returns the String
     */
    @JsonGetter("charging_state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getChargingState() {
        return chargingState;
    }

    /**
     * Getter for LocationId.
     * The ID of the Square seller business location associated with the Terminal.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for MerchantId.
     * The ID of the Square merchant account that is currently signed-in to the Terminal.
     * @return Returns the String
     */
    @JsonGetter("merchant_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Getter for NetworkConnectionType.
     * The Terminal’s current network connection type. Options: `WIFI`, `ETHERNET`
     * @return Returns the String
     */
    @JsonGetter("network_connection_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNetworkConnectionType() {
        return networkConnectionType;
    }

    /**
     * Getter for PaymentRegion.
     * The country in which the Terminal is authorized to take payments.
     * @return Returns the String
     */
    @JsonGetter("payment_region")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentRegion() {
        return paymentRegion;
    }

    /**
     * Getter for SerialNumber.
     * The unique identifier assigned to the Terminal, which can be found on the lower back of the
     * device.
     * @return Returns the String
     */
    @JsonGetter("serial_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Getter for OsVersion.
     * The current version of the Terminal’s operating system.
     * @return Returns the String
     */
    @JsonGetter("os_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * Getter for AppVersion.
     * The current version of the application running on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("app_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAppVersion() {
        return appVersion;
    }

    /**
     * Getter for WifiNetworkName.
     * The name of the Wi-Fi network to which the Terminal is connected.
     * @return Returns the String
     */
    @JsonGetter("wifi_network_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getWifiNetworkName() {
        return wifiNetworkName;
    }

    /**
     * Getter for WifiNetworkStrength.
     * The signal strength of the Wi-FI network connection. Options: `POOR`, `FAIR`, `GOOD`,
     * `EXCELLENT`
     * @return Returns the String
     */
    @JsonGetter("wifi_network_strength")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getWifiNetworkStrength() {
        return wifiNetworkStrength;
    }

    /**
     * Getter for IpAddress.
     * The IP address of the Terminal.
     * @return Returns the String
     */
    @JsonGetter("ip_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryPercentage, chargingState, locationId, merchantId,
                networkConnectionType, paymentRegion, serialNumber, osVersion, appVersion,
                wifiNetworkName, wifiNetworkStrength, ipAddress);
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
        Builder builder = new Builder()
                .batteryPercentage(getBatteryPercentage())
                .chargingState(getChargingState())
                .locationId(getLocationId())
                .merchantId(getMerchantId())
                .networkConnectionType(getNetworkConnectionType())
                .paymentRegion(getPaymentRegion())
                .serialNumber(getSerialNumber())
                .osVersion(getOsVersion())
                .appVersion(getAppVersion())
                .wifiNetworkName(getWifiNetworkName())
                .wifiNetworkStrength(getWifiNetworkStrength())
                .ipAddress(getIpAddress());
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceMetadata}.
     */
    public static class Builder {
        private String batteryPercentage;
        private String chargingState;
        private String locationId;
        private String merchantId;
        private String networkConnectionType;
        private String paymentRegion;
        private String serialNumber;
        private String osVersion;
        private String appVersion;
        private String wifiNetworkName;
        private String wifiNetworkStrength;
        private String ipAddress;



        /**
         * Setter for batteryPercentage.
         * @param  batteryPercentage  String value for batteryPercentage.
         * @return Builder
         */
        public Builder batteryPercentage(String batteryPercentage) {
            this.batteryPercentage = batteryPercentage;
            return this;
        }

        /**
         * Setter for chargingState.
         * @param  chargingState  String value for chargingState.
         * @return Builder
         */
        public Builder chargingState(String chargingState) {
            this.chargingState = chargingState;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for merchantId.
         * @param  merchantId  String value for merchantId.
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }

        /**
         * Setter for networkConnectionType.
         * @param  networkConnectionType  String value for networkConnectionType.
         * @return Builder
         */
        public Builder networkConnectionType(String networkConnectionType) {
            this.networkConnectionType = networkConnectionType;
            return this;
        }

        /**
         * Setter for paymentRegion.
         * @param  paymentRegion  String value for paymentRegion.
         * @return Builder
         */
        public Builder paymentRegion(String paymentRegion) {
            this.paymentRegion = paymentRegion;
            return this;
        }

        /**
         * Setter for serialNumber.
         * @param  serialNumber  String value for serialNumber.
         * @return Builder
         */
        public Builder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        /**
         * Setter for osVersion.
         * @param  osVersion  String value for osVersion.
         * @return Builder
         */
        public Builder osVersion(String osVersion) {
            this.osVersion = osVersion;
            return this;
        }

        /**
         * Setter for appVersion.
         * @param  appVersion  String value for appVersion.
         * @return Builder
         */
        public Builder appVersion(String appVersion) {
            this.appVersion = appVersion;
            return this;
        }

        /**
         * Setter for wifiNetworkName.
         * @param  wifiNetworkName  String value for wifiNetworkName.
         * @return Builder
         */
        public Builder wifiNetworkName(String wifiNetworkName) {
            this.wifiNetworkName = wifiNetworkName;
            return this;
        }

        /**
         * Setter for wifiNetworkStrength.
         * @param  wifiNetworkStrength  String value for wifiNetworkStrength.
         * @return Builder
         */
        public Builder wifiNetworkStrength(String wifiNetworkStrength) {
            this.wifiNetworkStrength = wifiNetworkStrength;
            return this;
        }

        /**
         * Setter for ipAddress.
         * @param  ipAddress  String value for ipAddress.
         * @return Builder
         */
        public Builder ipAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        /**
         * Builds a new {@link DeviceMetadata} object using the set fields.
         * @return {@link DeviceMetadata}
         */
        public DeviceMetadata build() {
            return new DeviceMetadata(batteryPercentage, chargingState, locationId, merchantId,
                    networkConnectionType, paymentRegion, serialNumber, osVersion, appVersion,
                    wifiNetworkName, wifiNetworkStrength, ipAddress);
        }
    }
}
