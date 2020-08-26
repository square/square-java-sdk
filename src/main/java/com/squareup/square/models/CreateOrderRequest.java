package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateOrderRequest type.
 */
public class CreateOrderRequest {

    /**
     * Initialization constructor.
     * @param order
     * @param locationId
     * @param idempotencyKey
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

    private final Order order;
    private final String locationId;
    private final String idempotencyKey;
    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square,
     * including line items that specify the products to purchase. Order objects also
     * include information on any associated tenders, refunds, and returns.
     * All Connect V2 Transactions have all been converted to Orders including all associated
     * itemization data.
     */
    @JsonGetter("order")
    public Order getOrder() {
        return this.order;
    }

    /**
     * Getter for LocationId.
     * The ID of the business location to associate the order with.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this
     * order among orders you've created.
     * If you're unsure whether a particular order was created successfully,
     * you can reattempt it with the same idempotency key without
     * worrying about creating duplicate orders.
     * See [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateOrderRequest)) {
            return false;
        }
        CreateOrderRequest createOrderRequest = (CreateOrderRequest) obj;
        return Objects.equals(order, createOrderRequest.order) &&
            Objects.equals(locationId, createOrderRequest.locationId) &&
            Objects.equals(idempotencyKey, createOrderRequest.idempotencyKey);
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
     * Class to build instances of {@link CreateOrderRequest}
     */
    public static class Builder {
        private Order order;
        private String locationId;
        private String idempotencyKey;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for order
         * @param order
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
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
         * Setter for idempotencyKey
         * @param idempotencyKey
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
            return new CreateOrderRequest(order,
                locationId,
                idempotencyKey);
        }
    }
}
