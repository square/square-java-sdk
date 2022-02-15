
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderUpdated type.
 */
public class OrderUpdated {
    private final String orderId;
    private final Integer version;
    private final String locationId;
    private final String state;
    private final String createdAt;
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  orderId  String value for orderId.
     * @param  version  Integer value for version.
     * @param  locationId  String value for locationId.
     * @param  state  String value for state.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public OrderUpdated(
            @JsonProperty("order_id") String orderId,
            @JsonProperty("version") Integer version,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("state") String state,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.orderId = orderId;
        this.version = version;
        this.locationId = locationId;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for OrderId.
     * The order's unique ID.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for LocationId.
     * The ID of the seller location that this order is associated with.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
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

    @Override
    public int hashCode() {
        return Objects.hash(orderId, version, locationId, state, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderUpdated)) {
            return false;
        }
        OrderUpdated other = (OrderUpdated) obj;
        return Objects.equals(orderId, other.orderId)
            && Objects.equals(version, other.version)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(state, other.state)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this OrderUpdated into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderUpdated [" + "orderId=" + orderId + ", version=" + version + ", locationId="
                + locationId + ", state=" + state + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + "]";
    }

    /**
     * Builds a new {@link OrderUpdated.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderUpdated.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .orderId(getOrderId())
                .version(getVersion())
                .locationId(getLocationId())
                .state(getState())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderUpdated}.
     */
    public static class Builder {
        private String orderId;
        private Integer version;
        private String locationId;
        private String state;
        private String createdAt;
        private String updatedAt;



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
         * Builds a new {@link OrderUpdated} object using the set fields.
         * @return {@link OrderUpdated}
         */
        public OrderUpdated build() {
            return new OrderUpdated(orderId, version, locationId, state, createdAt, updatedAt);
        }
    }
}
