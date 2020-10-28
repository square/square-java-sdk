
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for OrderCreated type.
 */
public class OrderCreated {
    private final String orderId;
    private final Integer version;
    private final String locationId;
    private final String state;
    private final String createdAt;

    /**
     * Initialization constructor.
     * @param orderId String value for orderId.
     * @param version Integer value for version.
     * @param locationId String value for locationId.
     * @param state String value for state.
     * @param createdAt String value for createdAt.
     */
    @JsonCreator
    public OrderCreated(
            @JsonProperty("order_id") String orderId,
            @JsonProperty("version") Integer version,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("state") String state,
            @JsonProperty("created_at") String createdAt) {
        this.orderId = orderId;
        this.version = version;
        this.locationId = locationId;
        this.state = state;
        this.createdAt = createdAt;
    }

    /**
     * Getter for OrderId.
     * The order's unique ID.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * Getter for Version.
     * Version number which is incremented each time an update is committed to the order. Orders
     * that were not created through the API will not include a version and thus cannot be updated.
     * [Read more about working with
     * versions](https://developer.squareup.com/docs/docs/orders-api/manage-orders#update-orders)
     * @return Returns the Integer
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Getter for LocationId.
     * The ID of the merchant location this order is associated with.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for State.
     * The state of the order.
     * @return Returns the String
     */
    @JsonGetter("state")
    public String getState() {
        return this.state;
    }

    /**
     * Getter for CreatedAt.
     * Timestamp for when the order was created in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(orderId, version, locationId, state, createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderCreated)) {
            return false;
        }
        OrderCreated other = (OrderCreated) obj;
        return Objects.equals(orderId, other.orderId)
            && Objects.equals(version, other.version)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(state, other.state)
            && Objects.equals(createdAt, other.createdAt);
    }

    /**
     * Builds a new {@link OrderCreated.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderCreated.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .orderId(getOrderId())
            .version(getVersion())
            .locationId(getLocationId())
            .state(getState())
            .createdAt(getCreatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderCreated}.
     */
    public static class Builder {
        private String orderId;
        private Integer version;
        private String locationId;
        private String state;
        private String createdAt;



        /**
         * Setter for orderId.
         * @param orderId String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Setter for version.
         * @param version Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for locationId.
         * @param locationId String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for state.
         * @param state String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Builds a new {@link OrderCreated} object using the set fields.
         * @return {@link OrderCreated}
         */
        public OrderCreated build() {
            return new OrderCreated(orderId,
                version,
                locationId,
                state,
                createdAt);
        }
    }
}
