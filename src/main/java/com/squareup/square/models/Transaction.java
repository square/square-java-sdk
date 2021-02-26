
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Transaction type.
 */
public class Transaction {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Tender> tenders;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Refund> refunds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String referenceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String product;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String clientId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address shippingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String orderId;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  locationId  String value for locationId.
     * @param  createdAt  String value for createdAt.
     * @param  tenders  List of Tender value for tenders.
     * @param  refunds  List of Refund value for refunds.
     * @param  referenceId  String value for referenceId.
     * @param  product  String value for product.
     * @param  clientId  String value for clientId.
     * @param  shippingAddress  Address value for shippingAddress.
     * @param  orderId  String value for orderId.
     */
    @JsonCreator
    public Transaction(
            @JsonProperty("id") String id,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("tenders") List<Tender> tenders,
            @JsonProperty("refunds") List<Refund> refunds,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("product") String product,
            @JsonProperty("client_id") String clientId,
            @JsonProperty("shipping_address") Address shippingAddress,
            @JsonProperty("order_id") String orderId) {
        this.id = id;
        this.locationId = locationId;
        this.createdAt = createdAt;
        this.tenders = tenders;
        this.refunds = refunds;
        this.referenceId = referenceId;
        this.product = product;
        this.clientId = clientId;
        this.shippingAddress = shippingAddress;
        this.orderId = orderId;
    }

    /**
     * Getter for Id.
     * The transaction's unique ID, issued by Square payments servers.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for LocationId.
     * The ID of the transaction's associated location.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp for when the transaction was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for Tenders.
     * The tenders used to pay in the transaction.
     * @return Returns the List of Tender
     */
    @JsonGetter("tenders")
    public List<Tender> getTenders() {
        return tenders;
    }

    /**
     * Getter for Refunds.
     * Refunds that have been applied to any tender in the transaction.
     * @return Returns the List of Refund
     */
    @JsonGetter("refunds")
    public List<Refund> getRefunds() {
        return refunds;
    }

    /**
     * Getter for ReferenceId.
     * If the transaction was created with the [Charge](#endpoint-charge) endpoint, this value is
     * the same as the value provided for the `reference_id` parameter in the request to that
     * endpoint. Otherwise, it is not set.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for Product.
     * Indicates the Square product used to process a transaction.
     * @return Returns the String
     */
    @JsonGetter("product")
    public String getProduct() {
        return product;
    }

    /**
     * Getter for ClientId.
     * If the transaction was created in the Square Point of Sale app, this value is the ID
     * generated for the transaction by Square Point of Sale. This ID has no relationship to the
     * transaction's canonical `id`, which is generated by Square's backend servers. This value is
     * generated for bookkeeping purposes, in case the transaction cannot immediately be completed
     * (for example, if the transaction is processed in offline mode). It is not currently possible
     * with the Connect API to perform a transaction lookup by this value.
     * @return Returns the String
     */
    @JsonGetter("client_id")
    public String getClientId() {
        return clientId;
    }

    /**
     * Getter for ShippingAddress.
     * Represents a physical address.
     * @return Returns the Address
     */
    @JsonGetter("shipping_address")
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Getter for OrderId.
     * The order_id is an identifier for the order associated with this transaction, if any.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locationId, createdAt, tenders, refunds, referenceId, product,
                clientId, shippingAddress, orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(tenders, other.tenders)
            && Objects.equals(refunds, other.refunds)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(product, other.product)
            && Objects.equals(clientId, other.clientId)
            && Objects.equals(shippingAddress, other.shippingAddress)
            && Objects.equals(orderId, other.orderId);
    }

    /**
     * Converts this Transaction into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Transaction [" + "id=" + id + ", locationId=" + locationId + ", createdAt="
                + createdAt + ", tenders=" + tenders + ", refunds=" + refunds + ", referenceId="
                + referenceId + ", product=" + product + ", clientId=" + clientId
                + ", shippingAddress=" + shippingAddress + ", orderId=" + orderId + "]";
    }

    /**
     * Builds a new {@link Transaction.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Transaction.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .locationId(getLocationId())
                .createdAt(getCreatedAt())
                .tenders(getTenders())
                .refunds(getRefunds())
                .referenceId(getReferenceId())
                .product(getProduct())
                .clientId(getClientId())
                .shippingAddress(getShippingAddress())
                .orderId(getOrderId());
        return builder;
    }

    /**
     * Class to build instances of {@link Transaction}.
     */
    public static class Builder {
        private String id;
        private String locationId;
        private String createdAt;
        private List<Tender> tenders;
        private List<Refund> refunds;
        private String referenceId;
        private String product;
        private String clientId;
        private Address shippingAddress;
        private String orderId;



        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for tenders.
         * @param  tenders  List of Tender value for tenders.
         * @return Builder
         */
        public Builder tenders(List<Tender> tenders) {
            this.tenders = tenders;
            return this;
        }

        /**
         * Setter for refunds.
         * @param  refunds  List of Refund value for refunds.
         * @return Builder
         */
        public Builder refunds(List<Refund> refunds) {
            this.refunds = refunds;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        /**
         * Setter for product.
         * @param  product  String value for product.
         * @return Builder
         */
        public Builder product(String product) {
            this.product = product;
            return this;
        }

        /**
         * Setter for clientId.
         * @param  clientId  String value for clientId.
         * @return Builder
         */
        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /**
         * Setter for shippingAddress.
         * @param  shippingAddress  Address value for shippingAddress.
         * @return Builder
         */
        public Builder shippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

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
         * Builds a new {@link Transaction} object using the set fields.
         * @return {@link Transaction}
         */
        public Transaction build() {
            return new Transaction(id, locationId, createdAt, tenders, refunds, referenceId,
                    product, clientId, shippingAddress, orderId);
        }
    }
}
