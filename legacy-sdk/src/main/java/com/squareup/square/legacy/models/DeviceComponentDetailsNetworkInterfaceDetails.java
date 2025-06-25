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
 * This is a model class for DeviceComponentDetailsNetworkInterfaceDetails type.
 */
public class DeviceComponentDetailsNetworkInterfaceDetails {
    private final OptionalNullable<String> ipAddressV4;

    /**
     * Initialization constructor.
     * @param  ipAddressV4  String value for ipAddressV4.
     */
    @JsonCreator
    public DeviceComponentDetailsNetworkInterfaceDetails(@JsonProperty("ip_address_v4") String ipAddressV4) {
        this.ipAddressV4 = OptionalNullable.of(ipAddressV4);
    }

    /**
     * Initialization constructor.
     * @param  ipAddressV4  String value for ipAddressV4.
     */
    protected DeviceComponentDetailsNetworkInterfaceDetails(OptionalNullable<String> ipAddressV4) {
        this.ipAddressV4 = ipAddressV4;
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

    @Override
    public int hashCode() {
        return Objects.hash(ipAddressV4);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceComponentDetailsNetworkInterfaceDetails)) {
            return false;
        }
        DeviceComponentDetailsNetworkInterfaceDetails other = (DeviceComponentDetailsNetworkInterfaceDetails) obj;
        return Objects.equals(ipAddressV4, other.ipAddressV4);
    }

    /**
     * Converts this DeviceComponentDetailsNetworkInterfaceDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceComponentDetailsNetworkInterfaceDetails [" + "ipAddressV4=" + ipAddressV4 + "]";
    }

    /**
     * Builds a new {@link DeviceComponentDetailsNetworkInterfaceDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceComponentDetailsNetworkInterfaceDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.ipAddressV4 = internalGetIpAddressV4();
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceComponentDetailsNetworkInterfaceDetails}.
     */
    public static class Builder {
        private OptionalNullable<String> ipAddressV4;

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
         * Builds a new {@link DeviceComponentDetailsNetworkInterfaceDetails} object using the set
         * fields.
         * @return {@link DeviceComponentDetailsNetworkInterfaceDetails}
         */
        public DeviceComponentDetailsNetworkInterfaceDetails build() {
            return new DeviceComponentDetailsNetworkInterfaceDetails(ipAddressV4);
        }
    }
}
