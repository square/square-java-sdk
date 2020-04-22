package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderFulfillmentUpdated type.
 */
public class OrderFulfillmentUpdated {

    /**
     * Initialization constructor.
     * @param orderId
     * @param version
     * @param locationId
     * @param state
     * @param createdAt
     * @param updatedAt
     * @param fulfillmentUpdate
     */
    @JsonCreator
    public OrderFulfillmentUpdated(
            @JsonProperty("order_id") String orderId,
            @JsonProperty("version") Integer version,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("state") String state,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("fulfillment_update") List<OrderFulfillmentUpdatedUpdate> fulfillmentUpdate) {
        this.orderId = orderId;
        this.version = version;
        this.locationId = locationId;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.fulfillmentUpdate = fulfillmentUpdate;
    }

    private final String orderId;
    private final Integer version;
    private final String locationId;
    private final String state;
    private final String createdAt;
    private final String updatedAt;
    private final List<OrderFulfillmentUpdatedUpdate> fulfillmentUpdate;
    /**
     * Getter for OrderId.
     * The order's unique ID.
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
     * [Read more about working with versions](https://developer.squareup.com/docs/docs/orders-api/manage-orders#update-orders)
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Getter for LocationId.
     * The ID of the merchant location this order is associated with.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for State.
     * The state of the order.
     */
    @JsonGetter("state")
    public String getState() {
        return this.state;
    }

    /**
     * Getter for CreatedAt.
     * Timestamp for when the order was created in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * Timestamp for when the order was last updated in RFC 3339 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for FulfillmentUpdate.
     * The fulfillments that were updated with this version change.
     */
    @JsonGetter("fulfillment_update")
    public List<OrderFulfillmentUpdatedUpdate> getFulfillmentUpdate() {
        return this.fulfillmentUpdate;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(orderId, version, locationId, state, createdAt, updatedAt,
            fulfillmentUpdate);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderFulfillmentUpdated)) {
            return false;
        }
        OrderFulfillmentUpdated orderFulfillmentUpdated = (OrderFulfillmentUpdated) obj;
        return Objects.equals(orderId, orderFulfillmentUpdated.orderId) &&
            Objects.equals(version, orderFulfillmentUpdated.version) &&
            Objects.equals(locationId, orderFulfillmentUpdated.locationId) &&
            Objects.equals(state, orderFulfillmentUpdated.state) &&
            Objects.equals(createdAt, orderFulfillmentUpdated.createdAt) &&
            Objects.equals(updatedAt, orderFulfillmentUpdated.updatedAt) &&
            Objects.equals(fulfillmentUpdate, orderFulfillmentUpdated.fulfillmentUpdate);
    }

    /**
     * Builds a new {@link OrderFulfillmentUpdated.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderFulfillmentUpdated.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .orderId(getOrderId())
            .version(getVersion())
            .locationId(getLocationId())
            .state(getState())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt())
            .fulfillmentUpdate(getFulfillmentUpdate());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentUpdated}
     */
    public static class Builder {
        private String orderId;
        private Integer version;
        private String locationId;
        private String state;
        private String createdAt;
        private String updatedAt;
        private List<OrderFulfillmentUpdatedUpdate> fulfillmentUpdate;

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
         * Setter for state
         * @param state
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        /**
         * Setter for fulfillmentUpdate
         * @param fulfillmentUpdate
         * @return Builder
         */
        public Builder fulfillmentUpdate(List<OrderFulfillmentUpdatedUpdate> fulfillmentUpdate) {
            this.fulfillmentUpdate = fulfillmentUpdate;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillmentUpdated} object using the set fields.
         * @return {@link OrderFulfillmentUpdated}
         */
        public OrderFulfillmentUpdated build() {
            return new OrderFulfillmentUpdated(orderId,
                version,
                locationId,
                state,
                createdAt,
                updatedAt,
                fulfillmentUpdate);
        }
    }
}
