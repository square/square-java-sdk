
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for Component type.
 */
public class Component {
    private final String type;
    private final DeviceComponentDetailsApplicationDetails applicationDetails;
    private final DeviceComponentDetailsCardReaderDetails cardReaderDetails;
    private final DeviceComponentDetailsBatteryDetails batteryDetails;
    private final DeviceComponentDetailsWiFiDetails wifiDetails;
    private final DeviceComponentDetailsEthernetDetails ethernetDetails;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  applicationDetails  DeviceComponentDetailsApplicationDetails value for
     *         applicationDetails.
     * @param  cardReaderDetails  DeviceComponentDetailsCardReaderDetails value for
     *         cardReaderDetails.
     * @param  batteryDetails  DeviceComponentDetailsBatteryDetails value for batteryDetails.
     * @param  wifiDetails  DeviceComponentDetailsWiFiDetails value for wifiDetails.
     * @param  ethernetDetails  DeviceComponentDetailsEthernetDetails value for ethernetDetails.
     */
    @JsonCreator
    public Component(
            @JsonProperty("type") String type,
            @JsonProperty("application_details") DeviceComponentDetailsApplicationDetails applicationDetails,
            @JsonProperty("card_reader_details") DeviceComponentDetailsCardReaderDetails cardReaderDetails,
            @JsonProperty("battery_details") DeviceComponentDetailsBatteryDetails batteryDetails,
            @JsonProperty("wifi_details") DeviceComponentDetailsWiFiDetails wifiDetails,
            @JsonProperty("ethernet_details") DeviceComponentDetailsEthernetDetails ethernetDetails) {
        this.type = type;
        this.applicationDetails = applicationDetails;
        this.cardReaderDetails = cardReaderDetails;
        this.batteryDetails = batteryDetails;
        this.wifiDetails = wifiDetails;
        this.ethernetDetails = ethernetDetails;
    }

    /**
     * Getter for Type.
     * An enum for ComponentType.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for ApplicationDetails.
     * @return Returns the DeviceComponentDetailsApplicationDetails
     */
    @JsonGetter("application_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeviceComponentDetailsApplicationDetails getApplicationDetails() {
        return applicationDetails;
    }

    /**
     * Getter for CardReaderDetails.
     * @return Returns the DeviceComponentDetailsCardReaderDetails
     */
    @JsonGetter("card_reader_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeviceComponentDetailsCardReaderDetails getCardReaderDetails() {
        return cardReaderDetails;
    }

    /**
     * Getter for BatteryDetails.
     * @return Returns the DeviceComponentDetailsBatteryDetails
     */
    @JsonGetter("battery_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeviceComponentDetailsBatteryDetails getBatteryDetails() {
        return batteryDetails;
    }

    /**
     * Getter for WifiDetails.
     * @return Returns the DeviceComponentDetailsWiFiDetails
     */
    @JsonGetter("wifi_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeviceComponentDetailsWiFiDetails getWifiDetails() {
        return wifiDetails;
    }

    /**
     * Getter for EthernetDetails.
     * @return Returns the DeviceComponentDetailsEthernetDetails
     */
    @JsonGetter("ethernet_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeviceComponentDetailsEthernetDetails getEthernetDetails() {
        return ethernetDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, applicationDetails, cardReaderDetails, batteryDetails,
                wifiDetails, ethernetDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Component)) {
            return false;
        }
        Component other = (Component) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(applicationDetails, other.applicationDetails)
            && Objects.equals(cardReaderDetails, other.cardReaderDetails)
            && Objects.equals(batteryDetails, other.batteryDetails)
            && Objects.equals(wifiDetails, other.wifiDetails)
            && Objects.equals(ethernetDetails, other.ethernetDetails);
    }

    /**
     * Converts this Component into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Component [" + "type=" + type + ", applicationDetails=" + applicationDetails
                + ", cardReaderDetails=" + cardReaderDetails + ", batteryDetails=" + batteryDetails
                + ", wifiDetails=" + wifiDetails + ", ethernetDetails=" + ethernetDetails + "]";
    }

    /**
     * Builds a new {@link Component.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Component.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type)
                .applicationDetails(getApplicationDetails())
                .cardReaderDetails(getCardReaderDetails())
                .batteryDetails(getBatteryDetails())
                .wifiDetails(getWifiDetails())
                .ethernetDetails(getEthernetDetails());
        return builder;
    }

    /**
     * Class to build instances of {@link Component}.
     */
    public static class Builder {
        private String type;
        private DeviceComponentDetailsApplicationDetails applicationDetails;
        private DeviceComponentDetailsCardReaderDetails cardReaderDetails;
        private DeviceComponentDetailsBatteryDetails batteryDetails;
        private DeviceComponentDetailsWiFiDetails wifiDetails;
        private DeviceComponentDetailsEthernetDetails ethernetDetails;

        /**
         * Initialization constructor.
         * @param  type  String value for type.
         */
        public Builder(String type) {
            this.type = type;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for applicationDetails.
         * @param  applicationDetails  DeviceComponentDetailsApplicationDetails value for
         *         applicationDetails.
         * @return Builder
         */
        public Builder applicationDetails(
                DeviceComponentDetailsApplicationDetails applicationDetails) {
            this.applicationDetails = applicationDetails;
            return this;
        }

        /**
         * Setter for cardReaderDetails.
         * @param  cardReaderDetails  DeviceComponentDetailsCardReaderDetails value for
         *         cardReaderDetails.
         * @return Builder
         */
        public Builder cardReaderDetails(
                DeviceComponentDetailsCardReaderDetails cardReaderDetails) {
            this.cardReaderDetails = cardReaderDetails;
            return this;
        }

        /**
         * Setter for batteryDetails.
         * @param  batteryDetails  DeviceComponentDetailsBatteryDetails value for batteryDetails.
         * @return Builder
         */
        public Builder batteryDetails(DeviceComponentDetailsBatteryDetails batteryDetails) {
            this.batteryDetails = batteryDetails;
            return this;
        }

        /**
         * Setter for wifiDetails.
         * @param  wifiDetails  DeviceComponentDetailsWiFiDetails value for wifiDetails.
         * @return Builder
         */
        public Builder wifiDetails(DeviceComponentDetailsWiFiDetails wifiDetails) {
            this.wifiDetails = wifiDetails;
            return this;
        }

        /**
         * Setter for ethernetDetails.
         * @param  ethernetDetails  DeviceComponentDetailsEthernetDetails value for ethernetDetails.
         * @return Builder
         */
        public Builder ethernetDetails(DeviceComponentDetailsEthernetDetails ethernetDetails) {
            this.ethernetDetails = ethernetDetails;
            return this;
        }

        /**
         * Builds a new {@link Component} object using the set fields.
         * @return {@link Component}
         */
        public Component build() {
            return new Component(type, applicationDetails, cardReaderDetails, batteryDetails,
                    wifiDetails, ethernetDetails);
        }
    }
}
