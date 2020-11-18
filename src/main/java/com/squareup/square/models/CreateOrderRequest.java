
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateOrderRequest type.
 */
public class CreateOrderRequest {
    private final Order order;
    private final String locationId;
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param order Order value for order.
     * @param locationId String value for locationId.
     * @param idempotencyKey String value for idempotencyKey.
     */
    @JsonCreator
    public CreateOrderRequest(
            @JsonProperty("order") Order order,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.order = order;
        this.locationId = locationId;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square, including line
     * items that specify the products to purchase. Order objects also include information on any
     * associated tenders, refunds, and returns. All Connect V2 Transactions have all been converted
     * to Orders including all associated itemization data.
     * @return Returns the Order
     */
    @JsonGetter("order")
    public Order getOrder() {
        return this.order;
    }

    /**
     * Getter for LocationId.
     * The ID of the business location to associate the order with.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this order among orders you've created. If
     * you're unsure whether a particular order was created successfully, you can reattempt it with
     * the same idempotency key without worrying about creating duplicate orders. See
     * [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, locationId, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateOrderRequest)) {
            return false;
        }
        CreateOrderRequest other = (CreateOrderRequest) obj;
        return Objects.equals(order, other.order)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this CreateOrderRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateOrderRequest [" + "order=" + order + ", locationId=" + locationId
                + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CreateOrderRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateOrderRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .order(getOrder())
                .locationId(getLocationId())
                .idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateOrderRequest}.
     */
    public static class Builder {
        private Order order;
        private String locationId;
        private String idempotencyKey;



        /**
         * Setter for order.
         * @param order Order value for order.
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
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
         * Setter for idempotencyKey.
         * @param idempotencyKey String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CreateOrderRequest} object using the set fields.
         * @return {@link CreateOrderRequest}
         */
        public CreateOrderRequest build() {
            return new CreateOrderRequest(order, locationId, idempotencyKey);
        }
    }
}
