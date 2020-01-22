package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpdateOrderRequest type.
 */
public class UpdateOrderRequest {

    /**
     * Initialization constructor.
     * @param order
     * @param fieldsToClear
     * @param idempotencyKey
     */
    @JsonCreator
    public UpdateOrderRequest(
            @JsonProperty("order") Order order,
            @JsonProperty("fields_to_clear") List<String> fieldsToClear,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.order = order;
        this.fieldsToClear = fieldsToClear;
        this.idempotencyKey = idempotencyKey;
    }

    private final Order order;
    private final List<String> fieldsToClear;
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
     * Getter for FieldsToClear.
     * The [dot notation paths](https://developer.squareup.com/docs/orders-api/manage-orders#on-dot-notation)
     * fields to clear. For example, `line_items[uid].note`
     * [Read more about Deleting fields](https://developer.squareup.com/docs/orders-api/manage-orders#delete-fields).
     */
    @JsonGetter("fields_to_clear")
    public List<String> getFieldsToClear() {
        return this.fieldsToClear;
    }

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this update request
     * If you're unsure whether a particular update was applied to an order successfully,
     * you can reattempt it with the same idempotency key without
     * worrying about creating duplicate updates to the order.
     * The latest order version will be returned.
     * See [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(order, fieldsToClear, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateOrderRequest)) {
            return false;
        }
        UpdateOrderRequest updateOrderRequest = (UpdateOrderRequest) obj;
        return Objects.equals(order, updateOrderRequest.order) &&
            Objects.equals(fieldsToClear, updateOrderRequest.fieldsToClear) &&
            Objects.equals(idempotencyKey, updateOrderRequest.idempotencyKey);
    }

    /**
     * Builds a new {@link UpdateOrderRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateOrderRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .order(getOrder())
            .fieldsToClear(getFieldsToClear())
            .idempotencyKey(getIdempotencyKey());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateOrderRequest}
     */
    public static class Builder {
        private Order order;
        private List<String> fieldsToClear;
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
         * Setter for fieldsToClear
         * @param fieldsToClear
         * @return Builder
         */
        public Builder fieldsToClear(List<String> fieldsToClear) {
            this.fieldsToClear = fieldsToClear;
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
         * Builds a new {@link UpdateOrderRequest} object using the set fields.
         * @return {@link UpdateOrderRequest}
         */
        public UpdateOrderRequest build() {
            return new UpdateOrderRequest(order,
                fieldsToClear,
                idempotencyKey);
        }
    }
}
