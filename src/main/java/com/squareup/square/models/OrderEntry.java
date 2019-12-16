package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderEntry {

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

    @Override
    public int hashCode() {
        return Objects.hash(orderId, version, locationId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderEntry)) {
            return false;
        }
        OrderEntry orderEntry = (OrderEntry) o;
        return Objects.equals(orderId, orderEntry.orderId) &&
            Objects.equals(version, orderEntry.version) &&
            Objects.equals(locationId, orderEntry.locationId);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .orderId(getOrderId())
            .version(getVersion())
            .locationId(getLocationId());
            return builder;
    }

    public static class Builder {
        private String orderId;
        private Integer version;
        private String locationId;

        public Builder() { }

        public Builder orderId(String value) {
            orderId = value;
            return this;
        }
        public Builder version(Integer value) {
            version = value;
            return this;
        }
        public Builder locationId(String value) {
            locationId = value;
            return this;
        }

        public OrderEntry build() {
            return new OrderEntry(orderId,
                version,
                locationId);
        }
    }
}
