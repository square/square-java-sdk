
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for OrderFulfillmentUpdated type.
 */
public class OrderFulfillmentUpdated {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String orderId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer version;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String state;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<OrderFulfillmentUpdatedUpdate> fulfillmentUpdate;

    /**
     * Initialization constructor.
     * @param  orderId  String value for orderId.
     * @param  version  Integer value for version.
     * @param  locationId  String value for locationId.
     * @param  state  String value for state.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  fulfillmentUpdate  List of OrderFulfillmentUpdatedUpdate value for fulfillmentUpdate.
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

    /**
     * Getter for OrderId.
     * The order's unique ID.
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
     * The ID of the seller location that this order is associated with.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for State.
     * The state of the order.
     * @return Returns the String
     */
    @JsonGetter("state")
    public String getState() {
        return state;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp for when the order was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp for when the order was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for FulfillmentUpdate.
     * The fulfillments that were updated with this version change.
     * @return Returns the List of OrderFulfillmentUpdatedUpdate
     */
    @JsonGetter("fulfillment_update")
    public List<OrderFulfillmentUpdatedUpdate> getFulfillmentUpdate() {
        return fulfillmentUpdate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, version, locationId, state, createdAt, updatedAt,
                fulfillmentUpdate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFulfillmentUpdated)) {
            return false;
        }
        OrderFulfillmentUpdated other = (OrderFulfillmentUpdated) obj;
        return Objects.equals(orderId, other.orderId)
            && Objects.equals(version, other.version)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(state, other.state)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(fulfillmentUpdate, other.fulfillmentUpdate);
    }

    /**
     * Converts this OrderFulfillmentUpdated into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderFulfillmentUpdated [" + "orderId=" + orderId + ", version=" + version
                + ", locationId=" + locationId + ", state=" + state + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + ", fulfillmentUpdate=" + fulfillmentUpdate + "]";
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
     * Class to build instances of {@link OrderFulfillmentUpdated}.
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
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for fulfillmentUpdate.
         * @param  fulfillmentUpdate  List of OrderFulfillmentUpdatedUpdate value for
         *         fulfillmentUpdate.
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
            return new OrderFulfillmentUpdated(orderId, version, locationId, state, createdAt,
                    updatedAt, fulfillmentUpdate);
        }
    }
}
