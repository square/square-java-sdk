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
 * This is a model class for DeviceComponentDetailsEthernetDetails type.
 */
public class DeviceComponentDetailsEthernetDetails {
    private final OptionalNullable<Boolean> active;
    private final OptionalNullable<String> ipAddressV4;

    /**
     * Initialization constructor.
     * @param  active  Boolean value for active.
     * @param  ipAddressV4  String value for ipAddressV4.
     */
    @JsonCreator
    public DeviceComponentDetailsEthernetDetails(
            @JsonProperty("active") Boolean active, @JsonProperty("ip_address_v4") String ipAddressV4) {
        this.active = OptionalNullable.of(active);
        this.ipAddressV4 = OptionalNullable.of(ipAddressV4);
    }

    /**
     * Initialization constructor.
     * @param  active  Boolean value for active.
     * @param  ipAddressV4  String value for ipAddressV4.
     */
    protected DeviceComponentDetailsEthernetDetails(
            OptionalNullable<Boolean> active, OptionalNullable<String> ipAddressV4) {
        this.active = active;
        this.ipAddressV4 = ipAddressV4;
    }

    /**
     * Internal Getter for Active.
     * A boolean to represent whether the Ethernet interface is currently active.
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
     * A boolean to represent whether the Ethernet interface is currently active.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getActive() {
        return OptionalNullable.getFrom(active);
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
        return Objects.hash(active, ipAddressV4);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceComponentDetailsEthernetDetails)) {
            return false;
        }
        DeviceComponentDetailsEthernetDetails other = (DeviceComponentDetailsEthernetDetails) obj;
        return Objects.equals(active, other.active) && Objects.equals(ipAddressV4, other.ipAddressV4);
    }

    /**
     * Converts this DeviceComponentDetailsEthernetDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceComponentDetailsEthernetDetails [" + "active=" + active + ", ipAddressV4=" + ipAddressV4 + "]";
    }

    /**
     * Builds a new {@link DeviceComponentDetailsEthernetDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceComponentDetailsEthernetDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.active = internalGetActive();
        builder.ipAddressV4 = internalGetIpAddressV4();
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceComponentDetailsEthernetDetails}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> active;
        private OptionalNullable<String> ipAddressV4;

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
         * Builds a new {@link DeviceComponentDetailsEthernetDetails} object using the set fields.
         * @return {@link DeviceComponentDetailsEthernetDetails}
         */
        public DeviceComponentDetailsEthernetDetails build() {
            return new DeviceComponentDetailsEthernetDetails(active, ipAddressV4);
        }
    }
}
