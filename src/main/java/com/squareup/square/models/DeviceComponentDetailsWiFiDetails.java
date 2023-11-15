
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for DeviceComponentDetailsWiFiDetails type.
 */
public class DeviceComponentDetailsWiFiDetails {
    private final OptionalNullable<Boolean> active;
    private final OptionalNullable<String> ssid;
    private final OptionalNullable<String> ipAddressV4;
    private final OptionalNullable<String> secureConnection;
    private final DeviceComponentDetailsMeasurement signalStrength;

    /**
     * Initialization constructor.
     * @param  active  Boolean value for active.
     * @param  ssid  String value for ssid.
     * @param  ipAddressV4  String value for ipAddressV4.
     * @param  secureConnection  String value for secureConnection.
     * @param  signalStrength  DeviceComponentDetailsMeasurement value for signalStrength.
     */
    @JsonCreator
    public DeviceComponentDetailsWiFiDetails(
            @JsonProperty("active") Boolean active,
            @JsonProperty("ssid") String ssid,
            @JsonProperty("ip_address_v4") String ipAddressV4,
            @JsonProperty("secure_connection") String secureConnection,
            @JsonProperty("signal_strength") DeviceComponentDetailsMeasurement signalStrength) {
        this.active = OptionalNullable.of(active);
        this.ssid = OptionalNullable.of(ssid);
        this.ipAddressV4 = OptionalNullable.of(ipAddressV4);
        this.secureConnection = OptionalNullable.of(secureConnection);
        this.signalStrength = signalStrength;
    }

    /**
     * Initialization constructor.
     * @param  active  Boolean value for active.
     * @param  ssid  String value for ssid.
     * @param  ipAddressV4  String value for ipAddressV4.
     * @param  secureConnection  String value for secureConnection.
     * @param  signalStrength  DeviceComponentDetailsMeasurement value for signalStrength.
     */

    protected DeviceComponentDetailsWiFiDetails(OptionalNullable<Boolean> active,
            OptionalNullable<String> ssid, OptionalNullable<String> ipAddressV4,
            OptionalNullable<String> secureConnection,
            DeviceComponentDetailsMeasurement signalStrength) {
        this.active = active;
        this.ssid = ssid;
        this.ipAddressV4 = ipAddressV4;
        this.secureConnection = secureConnection;
        this.signalStrength = signalStrength;
    }

    /**
     * Internal Getter for Active.
     * A boolean to represent whether the WiFI interface is currently active.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("active")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetActive() {
        return this.active;
    }

    /**
     * Getter for Active.
     * A boolean to represent whether the WiFI interface is currently active.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getActive() {
        return OptionalNullable.getFrom(active);
    }

    /**
     * Internal Getter for Ssid.
     * The name of the connected WIFI network.
     * @return Returns the Internal String
     */
    @JsonGetter("ssid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSsid() {
        return this.ssid;
    }

    /**
     * Getter for Ssid.
     * The name of the connected WIFI network.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSsid() {
        return OptionalNullable.getFrom(ssid);
    }

    /**
     * Internal Getter for IpAddressV4.
     * The string representation of the device’s IPv4 address.
     * @return Returns the Internal String
     */
    @JsonGetter("ip_address_v4")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetIpAddressV4() {
        return this.ipAddressV4;
    }

    /**
     * Getter for IpAddressV4.
     * The string representation of the device’s IPv4 address.
     * @return Returns the String
     */
    @JsonIgnore
    public String getIpAddressV4() {
        return OptionalNullable.getFrom(ipAddressV4);
    }

    /**
     * Internal Getter for SecureConnection.
     * The security protocol for a secure connection (e.g. WPA2). None provided if the connection is
     * unsecured.
     * @return Returns the Internal String
     */
    @JsonGetter("secure_connection")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSecureConnection() {
        return this.secureConnection;
    }

    /**
     * Getter for SecureConnection.
     * The security protocol for a secure connection (e.g. WPA2). None provided if the connection is
     * unsecured.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSecureConnection() {
        return OptionalNullable.getFrom(secureConnection);
    }

    /**
     * Getter for SignalStrength.
     * A value qualified by unit of measure.
     * @return Returns the DeviceComponentDetailsMeasurement
     */
    @JsonGetter("signal_strength")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeviceComponentDetailsMeasurement getSignalStrength() {
        return signalStrength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, ssid, ipAddressV4, secureConnection, signalStrength);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceComponentDetailsWiFiDetails)) {
            return false;
        }
        DeviceComponentDetailsWiFiDetails other = (DeviceComponentDetailsWiFiDetails) obj;
        return Objects.equals(active, other.active)
            && Objects.equals(ssid, other.ssid)
            && Objects.equals(ipAddressV4, other.ipAddressV4)
            && Objects.equals(secureConnection, other.secureConnection)
            && Objects.equals(signalStrength, other.signalStrength);
    }

    /**
     * Converts this DeviceComponentDetailsWiFiDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceComponentDetailsWiFiDetails [" + "active=" + active + ", ssid=" + ssid
                + ", ipAddressV4=" + ipAddressV4 + ", secureConnection=" + secureConnection
                + ", signalStrength=" + signalStrength + "]";
    }

    /**
     * Builds a new {@link DeviceComponentDetailsWiFiDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceComponentDetailsWiFiDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .signalStrength(getSignalStrength());
        builder.active = internalGetActive();
        builder.ssid = internalGetSsid();
        builder.ipAddressV4 = internalGetIpAddressV4();
        builder.secureConnection = internalGetSecureConnection();
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceComponentDetailsWiFiDetails}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> active;
        private OptionalNullable<String> ssid;
        private OptionalNullable<String> ipAddressV4;
        private OptionalNullable<String> secureConnection;
        private DeviceComponentDetailsMeasurement signalStrength;



        /**
         * Setter for active.
         * @param  active  Boolean value for active.
         * @return Builder
         */
        public Builder active(Boolean active) {
            this.active = OptionalNullable.of(active);
            return this;
        }

        /**
         * UnSetter for active.
         * @return Builder
         */
        public Builder unsetActive() {
            active = null;
            return this;
        }

        /**
         * Setter for ssid.
         * @param  ssid  String value for ssid.
         * @return Builder
         */
        public Builder ssid(String ssid) {
            this.ssid = OptionalNullable.of(ssid);
            return this;
        }

        /**
         * UnSetter for ssid.
         * @return Builder
         */
        public Builder unsetSsid() {
            ssid = null;
            return this;
        }

        /**
         * Setter for ipAddressV4.
         * @param  ipAddressV4  String value for ipAddressV4.
         * @return Builder
         */
        public Builder ipAddressV4(String ipAddressV4) {
            this.ipAddressV4 = OptionalNullable.of(ipAddressV4);
            return this;
        }

        /**
         * UnSetter for ipAddressV4.
         * @return Builder
         */
        public Builder unsetIpAddressV4() {
            ipAddressV4 = null;
            return this;
        }

        /**
         * Setter for secureConnection.
         * @param  secureConnection  String value for secureConnection.
         * @return Builder
         */
        public Builder secureConnection(String secureConnection) {
            this.secureConnection = OptionalNullable.of(secureConnection);
            return this;
        }

        /**
         * UnSetter for secureConnection.
         * @return Builder
         */
        public Builder unsetSecureConnection() {
            secureConnection = null;
            return this;
        }

        /**
         * Setter for signalStrength.
         * @param  signalStrength  DeviceComponentDetailsMeasurement value for signalStrength.
         * @return Builder
         */
        public Builder signalStrength(DeviceComponentDetailsMeasurement signalStrength) {
            this.signalStrength = signalStrength;
            return this;
        }

        /**
         * Builds a new {@link DeviceComponentDetailsWiFiDetails} object using the set fields.
         * @return {@link DeviceComponentDetailsWiFiDetails}
         */
        public DeviceComponentDetailsWiFiDetails build() {
            return new DeviceComponentDetailsWiFiDetails(active, ssid, ipAddressV4,
                    secureConnection, signalStrength);
        }
    }
}
