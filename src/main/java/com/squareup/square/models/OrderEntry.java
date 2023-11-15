
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
 * This is a model class for OrderEntry type.
 */
public class OrderEntry {
    private final OptionalNullable<String> orderId;
    private final Integer version;
    private final OptionalNullable<String> locationId;

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
        this.orderId = OptionalNullable.of(orderId);
        this.version = version;
        this.locationId = OptionalNullable.of(locationId);
    }

    /**
     * Initialization constructor.
     * @param  orderId  String value for orderId.
     * @param  version  Integer value for version.
     * @param  locationId  String value for locationId.
     */

    protected OrderEntry(OptionalNullable<String> orderId, Integer version,
            OptionalNullable<String> locationId) {
        this.orderId = orderId;
        this.version = version;
        this.locationId = locationId;
    }

    /**
     * Internal Getter for OrderId.
     * The ID of the order.
     * @return Returns the Internal String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOrderId() {
        return this.orderId;
    }

    /**
     * Getter for OrderId.
     * The ID of the order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOrderId() {
        return OptionalNullable.getFrom(orderId);
    }

    /**
     * Getter for Version.
     * The version number, which is incremented each time an update is committed to the order.
     * Orders that were not created through the API do not include a version number and therefore
     * cannot be updated. [Read more about working with
     * versions.](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders)
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Internal Getter for LocationId.
     * The location ID the order belongs to.
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
     * The location ID the order belongs to.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
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
                .version(getVersion());
        builder.orderId = internalGetOrderId();
        builder.locationId = internalGetLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderEntry}.
     */
    public static class Builder {
        private OptionalNullable<String> orderId;
        private Integer version;
        private OptionalNullable<String> locationId;



        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = OptionalNullable.of(orderId);
            return this;
        }

        /**
         * UnSetter for orderId.
         * @return Builder
         */
        public Builder unsetOrderId() {
            orderId = null;
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
         * Builds a new {@link OrderEntry} object using the set fields.
         * @return {@link OrderEntry}
         */
        public OrderEntry build() {
            return new OrderEntry(orderId, version, locationId);
        }
    }
}
