/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Transaction.Builder.class)
public final class Transaction {
    private final Optional<String> id;

    private final Optional<String> locationId;

    private final Optional<String> createdAt;

    private final Optional<List<Tender>> tenders;

    private final Optional<List<Refund>> refunds;

    private final Optional<String> referenceId;

    private final Optional<TransactionProduct> product;

    private final Optional<String> clientId;

    private final Optional<Address> shippingAddress;

    private final Optional<String> orderId;

    private final Map<String, Object> additionalProperties;

    private Transaction(
            Optional<String> id,
            Optional<String> locationId,
            Optional<String> createdAt,
            Optional<List<Tender>> tenders,
            Optional<List<Refund>> refunds,
            Optional<String> referenceId,
            Optional<TransactionProduct> product,
            Optional<String> clientId,
            Optional<Address> shippingAddress,
            Optional<String> orderId,
            Map<String, Object> additionalProperties) {
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
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The transaction's unique ID, issued by Square payments servers.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The ID of the transaction's associated location.
     */
    @JsonIgnore
    public Optional<String> getLocationId() {
        if (locationId == null) {
            return Optional.empty();
        }
        return locationId;
    }

    /**
     * @return The timestamp for when the transaction was created, in RFC 3339 format.
     */
    @JsonProperty("created_at")
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The tenders used to pay in the transaction.
     */
    @JsonIgnore
    public Optional<List<Tender>> getTenders() {
        if (tenders == null) {
            return Optional.empty();
        }
        return tenders;
    }

    /**
     * @return Refunds that have been applied to any tender in the transaction.
     */
    @JsonIgnore
    public Optional<List<Refund>> getRefunds() {
        if (refunds == null) {
            return Optional.empty();
        }
        return refunds;
    }

    /**
     * @return If the transaction was created with the <a href="api-endpoint:Transactions-Charge">Charge</a>
     * endpoint, this value is the same as the value provided for the <code>reference_id</code>
     * parameter in the request to that endpoint. Otherwise, it is not set.
     */
    @JsonIgnore
    public Optional<String> getReferenceId() {
        if (referenceId == null) {
            return Optional.empty();
        }
        return referenceId;
    }

    /**
     * @return The Square product that processed the transaction.
     * See <a href="#type-transactionproduct">TransactionProduct</a> for possible values
     */
    @JsonProperty("product")
    public Optional<TransactionProduct> getProduct() {
        return product;
    }

    /**
     * @return If the transaction was created in the Square Point of Sale app, this value
     * is the ID generated for the transaction by Square Point of Sale.
     * <p>This ID has no relationship to the transaction's canonical <code>id</code>, which is
     * generated by Square's backend servers. This value is generated for bookkeeping
     * purposes, in case the transaction cannot immediately be completed (for example,
     * if the transaction is processed in offline mode).</p>
     * <p>It is not currently possible with the Connect API to perform a transaction
     * lookup by this value.</p>
     */
    @JsonIgnore
    public Optional<String> getClientId() {
        if (clientId == null) {
            return Optional.empty();
        }
        return clientId;
    }

    /**
     * @return The shipping address provided in the request, if any.
     */
    @JsonProperty("shipping_address")
    public Optional<Address> getShippingAddress() {
        return shippingAddress;
    }

    /**
     * @return The order_id is an identifier for the order associated with this transaction, if any.
     */
    @JsonIgnore
    public Optional<String> getOrderId() {
        if (orderId == null) {
            return Optional.empty();
        }
        return orderId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("location_id")
    private Optional<String> _getLocationId() {
        return locationId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("tenders")
    private Optional<List<Tender>> _getTenders() {
        return tenders;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("refunds")
    private Optional<List<Refund>> _getRefunds() {
        return refunds;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("reference_id")
    private Optional<String> _getReferenceId() {
        return referenceId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("client_id")
    private Optional<String> _getClientId() {
        return clientId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("order_id")
    private Optional<String> _getOrderId() {
        return orderId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Transaction && equalTo((Transaction) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Transaction other) {
        return id.equals(other.id)
                && locationId.equals(other.locationId)
                && createdAt.equals(other.createdAt)
                && tenders.equals(other.tenders)
                && refunds.equals(other.refunds)
                && referenceId.equals(other.referenceId)
                && product.equals(other.product)
                && clientId.equals(other.clientId)
                && shippingAddress.equals(other.shippingAddress)
                && orderId.equals(other.orderId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.locationId,
                this.createdAt,
                this.tenders,
                this.refunds,
                this.referenceId,
                this.product,
                this.clientId,
                this.shippingAddress,
                this.orderId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> locationId = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<List<Tender>> tenders = Optional.empty();

        private Optional<List<Refund>> refunds = Optional.empty();

        private Optional<String> referenceId = Optional.empty();

        private Optional<TransactionProduct> product = Optional.empty();

        private Optional<String> clientId = Optional.empty();

        private Optional<Address> shippingAddress = Optional.empty();

        private Optional<String> orderId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Transaction other) {
            id(other.getId());
            locationId(other.getLocationId());
            createdAt(other.getCreatedAt());
            tenders(other.getTenders());
            refunds(other.getRefunds());
            referenceId(other.getReferenceId());
            product(other.getProduct());
            clientId(other.getClientId());
            shippingAddress(other.getShippingAddress());
            orderId(other.getOrderId());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        @JsonSetter(value = "location_id", nulls = Nulls.SKIP)
        public Builder locationId(Optional<String> locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder locationId(String locationId) {
            this.locationId = Optional.ofNullable(locationId);
            return this;
        }

        public Builder locationId(Nullable<String> locationId) {
            if (locationId.isNull()) {
                this.locationId = null;
            } else if (locationId.isEmpty()) {
                this.locationId = Optional.empty();
            } else {
                this.locationId = Optional.of(locationId.get());
            }
            return this;
        }

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<String> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(String createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        @JsonSetter(value = "tenders", nulls = Nulls.SKIP)
        public Builder tenders(Optional<List<Tender>> tenders) {
            this.tenders = tenders;
            return this;
        }

        public Builder tenders(List<Tender> tenders) {
            this.tenders = Optional.ofNullable(tenders);
            return this;
        }

        public Builder tenders(Nullable<List<Tender>> tenders) {
            if (tenders.isNull()) {
                this.tenders = null;
            } else if (tenders.isEmpty()) {
                this.tenders = Optional.empty();
            } else {
                this.tenders = Optional.of(tenders.get());
            }
            return this;
        }

        @JsonSetter(value = "refunds", nulls = Nulls.SKIP)
        public Builder refunds(Optional<List<Refund>> refunds) {
            this.refunds = refunds;
            return this;
        }

        public Builder refunds(List<Refund> refunds) {
            this.refunds = Optional.ofNullable(refunds);
            return this;
        }

        public Builder refunds(Nullable<List<Refund>> refunds) {
            if (refunds.isNull()) {
                this.refunds = null;
            } else if (refunds.isEmpty()) {
                this.refunds = Optional.empty();
            } else {
                this.refunds = Optional.of(refunds.get());
            }
            return this;
        }

        @JsonSetter(value = "reference_id", nulls = Nulls.SKIP)
        public Builder referenceId(Optional<String> referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        public Builder referenceId(String referenceId) {
            this.referenceId = Optional.ofNullable(referenceId);
            return this;
        }

        public Builder referenceId(Nullable<String> referenceId) {
            if (referenceId.isNull()) {
                this.referenceId = null;
            } else if (referenceId.isEmpty()) {
                this.referenceId = Optional.empty();
            } else {
                this.referenceId = Optional.of(referenceId.get());
            }
            return this;
        }

        @JsonSetter(value = "product", nulls = Nulls.SKIP)
        public Builder product(Optional<TransactionProduct> product) {
            this.product = product;
            return this;
        }

        public Builder product(TransactionProduct product) {
            this.product = Optional.ofNullable(product);
            return this;
        }

        @JsonSetter(value = "client_id", nulls = Nulls.SKIP)
        public Builder clientId(Optional<String> clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder clientId(String clientId) {
            this.clientId = Optional.ofNullable(clientId);
            return this;
        }

        public Builder clientId(Nullable<String> clientId) {
            if (clientId.isNull()) {
                this.clientId = null;
            } else if (clientId.isEmpty()) {
                this.clientId = Optional.empty();
            } else {
                this.clientId = Optional.of(clientId.get());
            }
            return this;
        }

        @JsonSetter(value = "shipping_address", nulls = Nulls.SKIP)
        public Builder shippingAddress(Optional<Address> shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Builder shippingAddress(Address shippingAddress) {
            this.shippingAddress = Optional.ofNullable(shippingAddress);
            return this;
        }

        @JsonSetter(value = "order_id", nulls = Nulls.SKIP)
        public Builder orderId(Optional<String> orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = Optional.ofNullable(orderId);
            return this;
        }

        public Builder orderId(Nullable<String> orderId) {
            if (orderId.isNull()) {
                this.orderId = null;
            } else if (orderId.isEmpty()) {
                this.orderId = Optional.empty();
            } else {
                this.orderId = Optional.of(orderId.get());
            }
            return this;
        }

        public Transaction build() {
            return new Transaction(
                    id,
                    locationId,
                    createdAt,
                    tenders,
                    refunds,
                    referenceId,
                    product,
                    clientId,
                    shippingAddress,
                    orderId,
                    additionalProperties);
        }
    }
}
