package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderEntry type.
 */
public class OrderEntry {

    /**
     * Initialization constructor.
     * @param orderId
     * @param version
     * @param locationId
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

    private final String orderId;
    private final Integer version;
    private final String locationId;
    /**
     * Getter for OrderId.
     * The id of the Order
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * Getter for Version.
     * Version number which is incremented each time an update is committed to the order.
     * Orders that were not created through the API will not include a version and
     * thus cannot be updated.
     * [Read more about working with versions](https://developer.squareup.com/docs/orders-api/manage-orders#update-orders).
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Getter for LocationId.
     * The location id the Order belongs to.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(orderId, version, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderEntry)) {
            return false;
        }
        OrderEntry orderEntry = (OrderEntry) obj;
        return Objects.equals(orderId, orderEntry.orderId) &&
            Objects.equals(version, orderEntry.version) &&
            Objects.equals(locationId, orderEntry.locationId);
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
     * Class to build instances of {@link OrderEntry}
     */
    public static class Builder {
        private String orderId;
        private Integer version;
        private String locationId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for orderId
         * @param orderId
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }
        /**
         * Setter for version
         * @param version
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
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
            return new OrderEntry(orderId,
                version,
                locationId);
        }
    }
}
