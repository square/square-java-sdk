package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for OrderFulfillmentUpdated type.
 */
public class OrderFulfillmentUpdated {
    private final OptionalNullable<String> orderId;
    private final Integer version;
    private final OptionalNullable<String> locationId;
    private final String state;
    private final String createdAt;
    private final String updatedAt;
    private final OptionalNullable<List<OrderFulfillmentUpdatedUpdate>> fulfillmentUpdate;

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
        this.orderId = OptionalNullable.of(orderId);
        this.version = version;
        this.locationId = OptionalNullable.of(locationId);
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.fulfillmentUpdate = OptionalNullable.of(fulfillmentUpdate);
    }

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
    protected OrderFulfillmentUpdated(
            OptionalNullable<String> orderId,
            Integer version,
            OptionalNullable<String> locationId,
            String state,
            String createdAt,
            String updatedAt,
            OptionalNullable<List<OrderFulfillmentUpdatedUpdate>> fulfillmentUpdate) {
        this.orderId = orderId;
        this.version = version;
        this.locationId = locationId;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.fulfillmentUpdate = fulfillmentUpdate;
    }

    /**
     * Internal Getter for OrderId.
     * The order's unique ID.
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
     * The order's unique ID.
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
     * The ID of the seller location that this order is associated with.
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
     * The ID of the seller location that this order is associated with.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Getter for State.
     * The state of the order.
     * @return Returns the String
     */
    @JsonGetter("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getState() {
        return state;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp for when the order was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp for when the order was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Internal Getter for FulfillmentUpdate.
     * The fulfillments that were updated with this version change.
     * @return Returns the Internal List of OrderFulfillmentUpdatedUpdate
     */
    @JsonGetter("fulfillment_update")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderFulfillmentUpdatedUpdate>> internalGetFulfillmentUpdate() {
        return this.fulfillmentUpdate;
    }

    /**
     * Getter for FulfillmentUpdate.
     * The fulfillments that were updated with this version change.
     * @return Returns the List of OrderFulfillmentUpdatedUpdate
     */
    @JsonIgnore
    public List<OrderFulfillmentUpdatedUpdate> getFulfillmentUpdate() {
        return OptionalNullable.getFrom(fulfillmentUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, version, locationId, state, createdAt, updatedAt, fulfillmentUpdate);
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
                .version(getVersion())
                .state(getState())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        builder.orderId = internalGetOrderId();
        builder.locationId = internalGetLocationId();
        builder.fulfillmentUpdate = internalGetFulfillmentUpdate();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentUpdated}.
     */
    public static class Builder {
        private OptionalNullable<String> orderId;
        private Integer version;
        private OptionalNullable<String> locationId;
        private String state;
        private String createdAt;
        private String updatedAt;
        private OptionalNullable<List<OrderFulfillmentUpdatedUpdate>> fulfillmentUpdate;

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
            this.fulfillmentUpdate = OptionalNullable.of(fulfillmentUpdate);
            return this;
        }

        /**
         * UnSetter for fulfillmentUpdate.
         * @return Builder
         */
        public Builder unsetFulfillmentUpdate() {
            fulfillmentUpdate = null;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillmentUpdated} object using the set fields.
         * @return {@link OrderFulfillmentUpdated}
         */
        public OrderFulfillmentUpdated build() {
            return new OrderFulfillmentUpdated(
                    orderId, version, locationId, state, createdAt, updatedAt, fulfillmentUpdate);
        }
    }
}
