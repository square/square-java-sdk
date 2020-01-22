package com.squareup.square.models;

import java.util.List;
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
     * @param idempotencyKey
     * @param referenceId
     * @param lineItems
     * @param taxes
     * @param discounts
     */
    @JsonCreator
    public CreateOrderRequest(
            @JsonProperty("order") Order order,
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("line_items") List<CreateOrderRequestLineItem> lineItems,
            @JsonProperty("taxes") List<CreateOrderRequestTax> taxes,
            @JsonProperty("discounts") List<CreateOrderRequestDiscount> discounts) {
        this.order = order;
        this.idempotencyKey = idempotencyKey;
        this.referenceId = referenceId;
        this.lineItems = lineItems;
        this.taxes = taxes;
        this.discounts = discounts;
    }

    private final Order order;
    private final String idempotencyKey;
    private final String referenceId;
    private final List<CreateOrderRequestLineItem> lineItems;
    private final List<CreateOrderRequestTax> taxes;
    private final List<CreateOrderRequestDiscount> discounts;
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

    /**
     * Getter for ReferenceId.
     * __Deprecated__: Please set the reference_id on the nested [order](#type-order) field
     * instead.
     * An optional ID you can associate with the order for your own
     * purposes (such as to associate the order with an entity ID in your
     * own database).
     * This value cannot exceed 40 characters.
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for LineItems.
     * __Deprecated__: Please set the line_items on the nested [order](#type-order) field
     * instead.
     * The line items to associate with this order.
     * Each line item represents a different product to include in a purchase.
     */
    @JsonGetter("line_items")
    public List<CreateOrderRequestLineItem> getLineItems() {
        return this.lineItems;
    }

    /**
     * Getter for Taxes.
     * __Deprecated__: Please set the taxes on the nested [order](#type-order) field instead.
     * The taxes to include on the order.
     */
    @JsonGetter("taxes")
    public List<CreateOrderRequestTax> getTaxes() {
        return this.taxes;
    }

    /**
     * Getter for Discounts.
     * __Deprecated__: Please set the discounts on the nested [order](#type-order) field instead.
     * The discounts to include on the order.
     */
    @JsonGetter("discounts")
    public List<CreateOrderRequestDiscount> getDiscounts() {
        return this.discounts;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(order, idempotencyKey, referenceId, lineItems, taxes, discounts);
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
            Objects.equals(idempotencyKey, createOrderRequest.idempotencyKey) &&
            Objects.equals(referenceId, createOrderRequest.referenceId) &&
            Objects.equals(lineItems, createOrderRequest.lineItems) &&
            Objects.equals(taxes, createOrderRequest.taxes) &&
            Objects.equals(discounts, createOrderRequest.discounts);
    }

    /**
     * Builds a new {@link CreateOrderRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateOrderRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .order(getOrder())
            .idempotencyKey(getIdempotencyKey())
            .referenceId(getReferenceId())
            .lineItems(getLineItems())
            .taxes(getTaxes())
            .discounts(getDiscounts());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateOrderRequest}
     */
    public static class Builder {
        private Order order;
        private String idempotencyKey;
        private String referenceId;
        private List<CreateOrderRequestLineItem> lineItems;
        private List<CreateOrderRequestTax> taxes;
        private List<CreateOrderRequestDiscount> discounts;

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
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        /**
         * Setter for referenceId
         * @param referenceId
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }
        /**
         * Setter for lineItems
         * @param lineItems
         * @return Builder
         */
        public Builder lineItems(List<CreateOrderRequestLineItem> lineItems) {
            this.lineItems = lineItems;
            return this;
        }
        /**
         * Setter for taxes
         * @param taxes
         * @return Builder
         */
        public Builder taxes(List<CreateOrderRequestTax> taxes) {
            this.taxes = taxes;
            return this;
        }
        /**
         * Setter for discounts
         * @param discounts
         * @return Builder
         */
        public Builder discounts(List<CreateOrderRequestDiscount> discounts) {
            this.discounts = discounts;
            return this;
        }

        /**
         * Builds a new {@link CreateOrderRequest} object using the set fields.
         * @return {@link CreateOrderRequest}
         */
        public CreateOrderRequest build() {
            return new CreateOrderRequest(order,
                idempotencyKey,
                referenceId,
                lineItems,
                taxes,
                discounts);
        }
    }
}
