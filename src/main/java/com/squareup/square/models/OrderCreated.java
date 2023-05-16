
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
 * This is a model class for OrderCreated type.
 */
public class OrderCreated {
    private final OptionalNullable<String> orderId;
    private final Integer version;
    private final OptionalNullable<String> locationId;
    private final String state;
    private final String createdAt;

    /**
     * Initialization constructor.
     * @param  orderId  String value for orderId.
     * @param  version  Integer value for version.
     * @param  locationId  String value for locationId.
     * @param  state  String value for state.
     * @param  createdAt  String value for createdAt.
     */
    @JsonCreator
    public OrderCreated(
            @JsonProperty("order_id") String orderId,
            @JsonProperty("version") Integer version,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("state") String state,
            @JsonProperty("created_at") String createdAt) {
        this.orderId = OptionalNullable.of(orderId);
        this.version = version;
        this.locationId = OptionalNullable.of(locationId);
        this.state = state;
        this.createdAt = createdAt;
    }

    /**
     * Internal initialization constructor.
     */
    protected OrderCreated(OptionalNullable<String> orderId, Integer version,
            OptionalNullable<String> locationId, String state, String createdAt) {
        this.orderId = orderId;
        this.version = version;
        this.locationId = locationId;
        this.state = state;
        this.createdAt = createdAt;
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
     * Converts this OrderCreated into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderCreated [" + "orderId=" + orderId + ", version=" + version + ", locationId="
                + locationId + ", state=" + state + ", createdAt=" + createdAt + "]";
    }

    /**
     * Builds a new {@link OrderCreated.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderCreated.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .version(getVersion())
                .state(getState())
                .createdAt(getCreatedAt());
        builder.orderId = internalGetOrderId();
        builder.locationId = internalGetLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderCreated}.
     */
    public static class Builder {
        private OptionalNullable<String> orderId;
        private Integer version;
        private OptionalNullable<String> locationId;
        private String state;
        private String createdAt;



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
         * Builds a new {@link OrderCreated} object using the set fields.
         * @return {@link OrderCreated}
         */
        public OrderCreated build() {
            return new OrderCreated(orderId, version, locationId, state, createdAt);
        }
    }
}
