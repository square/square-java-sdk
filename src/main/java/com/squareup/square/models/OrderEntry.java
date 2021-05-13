
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderEntry type.
 */
public class OrderEntry {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String orderId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer version;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;

    /**
     * Initialization constructor.
     * @param  orderId  String value for orderId.
     * @param  version  Integer value for version.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public OrderEntry(
            @JsonProperty("order_id") String orderId,
            @JsonProperty("version") Integer version,
            @JsonProperty("location_id") String locationId) {
        this.orderId = orderId;
        this.version = version;
        this.locationId = locationId;
    }

    /**
     * Getter for OrderId.
     * The ID of the order.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for Version.
     * The version number, which is incremented each time an update is committed to the order.
     * Orders that were not created through the API do not include a version number and therefore
     * cannot be updated. [Read more about working with
     * versions.](https://developer.squareup.com/docs/orders-api/manage-orders#update-orders)
     * @return Returns the Integer
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for LocationId.
     * The location ID the order belongs to.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, version, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderEntry)) {
            return false;
        }
        OrderEntry other = (OrderEntry) obj;
        return Objects.equals(orderId, other.orderId)
            && Objects.equals(version, other.version)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this OrderEntry into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderEntry [" + "orderId=" + orderId + ", version=" + version + ", locationId="
                + locationId + "]";
    }

    /**
     * Builds a new {@link OrderEntry.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderEntry.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .orderId(getOrderId())
                .version(getVersion())
                .locationId(getLocationId());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderEntry}.
     */
    public static class Builder {
        private String orderId;
        private Integer version;
        private String locationId;



        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * Builds a new {@link OrderEntry} object using the set fields.
         * @return {@link OrderEntry}
         */
        public OrderEntry build() {
            return new OrderEntry(orderId, version, locationId);
        }
    }
}
