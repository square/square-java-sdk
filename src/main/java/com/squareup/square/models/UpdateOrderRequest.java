
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateOrderRequest type.
 */
public class UpdateOrderRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Order order;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> fieldsToClear;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  order  Order value for order.
     * @param  fieldsToClear  List of String value for fieldsToClear.
     * @param  idempotencyKey  String value for idempotencyKey.
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

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square, including line
     * items that specify the products to purchase. `Order` objects also include information about
     * any associated tenders, refunds, and returns. All Connect V2 Transactions have all been
     * converted to Orders including all associated itemization data.
     * @return Returns the Order
     */
    @JsonGetter("order")
    public Order getOrder() {
        return order;
    }

    /**
     * Getter for FieldsToClear.
     * The [dot notation
     * paths](https://developer.squareup.com/docs/orders-api/manage-orders#on-dot-notation) fields
     * to clear. For example, `line_items[uid].note`. For more information, see [Deleting
     * fields](https://developer.squareup.com/docs/orders-api/manage-orders#delete-fields).
     * @return Returns the List of String
     */
    @JsonGetter("fields_to_clear")
    public List<String> getFieldsToClear() {
        return fieldsToClear;
    }

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this update request. If you are unsure whether a
     * particular update was applied to an order successfully, you can reattempt it with the same
     * idempotency key without worrying about creating duplicate updates to the order. The latest
     * order version is returned. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, fieldsToClear, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateOrderRequest)) {
            return false;
        }
        UpdateOrderRequest other = (UpdateOrderRequest) obj;
        return Objects.equals(order, other.order)
            && Objects.equals(fieldsToClear, other.fieldsToClear)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this UpdateOrderRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateOrderRequest [" + "order=" + order + ", fieldsToClear=" + fieldsToClear
                + ", idempotencyKey=" + idempotencyKey + "]";
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
     * Class to build instances of {@link UpdateOrderRequest}.
     */
    public static class Builder {
        private Order order;
        private List<String> fieldsToClear;
        private String idempotencyKey;



        /**
         * Setter for order.
         * @param  order  Order value for order.
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
            return this;
        }

        /**
         * Setter for fieldsToClear.
         * @param  fieldsToClear  List of String value for fieldsToClear.
         * @return Builder
         */
        public Builder fieldsToClear(List<String> fieldsToClear) {
            this.fieldsToClear = fieldsToClear;
            return this;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
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
            return new UpdateOrderRequest(order, fieldsToClear, idempotencyKey);
        }
    }
}
