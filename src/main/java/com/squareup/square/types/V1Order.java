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
@JsonDeserialize(builder = V1Order.Builder.class)
public final class V1Order {
    private final Optional<List<Error>> errors;

    private final Optional<String> id;

    private final Optional<String> buyerEmail;

    private final Optional<String> recipientName;

    private final Optional<String> recipientPhoneNumber;

    private final Optional<V1OrderState> state;

    private final Optional<Address> shippingAddress;

    private final Optional<V1Money> subtotalMoney;

    private final Optional<V1Money> totalShippingMoney;

    private final Optional<V1Money> totalTaxMoney;

    private final Optional<V1Money> totalPriceMoney;

    private final Optional<V1Money> totalDiscountMoney;

    private final Optional<String> createdAt;

    private final Optional<String> updatedAt;

    private final Optional<String> expiresAt;

    private final Optional<String> paymentId;

    private final Optional<String> buyerNote;

    private final Optional<String> completedNote;

    private final Optional<String> refundedNote;

    private final Optional<String> canceledNote;

    private final Optional<V1Tender> tender;

    private final Optional<List<V1OrderHistoryEntry>> orderHistory;

    private final Optional<String> promoCode;

    private final Optional<String> btcReceiveAddress;

    private final Optional<Double> btcPriceSatoshi;

    private final Map<String, Object> additionalProperties;

    private V1Order(
            Optional<List<Error>> errors,
            Optional<String> id,
            Optional<String> buyerEmail,
            Optional<String> recipientName,
            Optional<String> recipientPhoneNumber,
            Optional<V1OrderState> state,
            Optional<Address> shippingAddress,
            Optional<V1Money> subtotalMoney,
            Optional<V1Money> totalShippingMoney,
            Optional<V1Money> totalTaxMoney,
            Optional<V1Money> totalPriceMoney,
            Optional<V1Money> totalDiscountMoney,
            Optional<String> createdAt,
            Optional<String> updatedAt,
            Optional<String> expiresAt,
            Optional<String> paymentId,
            Optional<String> buyerNote,
            Optional<String> completedNote,
            Optional<String> refundedNote,
            Optional<String> canceledNote,
            Optional<V1Tender> tender,
            Optional<List<V1OrderHistoryEntry>> orderHistory,
            Optional<String> promoCode,
            Optional<String> btcReceiveAddress,
            Optional<Double> btcPriceSatoshi,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.id = id;
        this.buyerEmail = buyerEmail;
        this.recipientName = recipientName;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.state = state;
        this.shippingAddress = shippingAddress;
        this.subtotalMoney = subtotalMoney;
        this.totalShippingMoney = totalShippingMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.totalPriceMoney = totalPriceMoney;
        this.totalDiscountMoney = totalDiscountMoney;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.expiresAt = expiresAt;
        this.paymentId = paymentId;
        this.buyerNote = buyerNote;
        this.completedNote = completedNote;
        this.refundedNote = refundedNote;
        this.canceledNote = canceledNote;
        this.tender = tender;
        this.orderHistory = orderHistory;
        this.promoCode = promoCode;
        this.btcReceiveAddress = btcReceiveAddress;
        this.btcPriceSatoshi = btcPriceSatoshi;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Any errors that occurred during the request.
     */
    @JsonIgnore
    public Optional<List<Error>> getErrors() {
        if (errors == null) {
            return Optional.empty();
        }
        return errors;
    }

    /**
     * @return The order's unique identifier.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The email address of the order's buyer.
     */
    @JsonIgnore
    public Optional<String> getBuyerEmail() {
        if (buyerEmail == null) {
            return Optional.empty();
        }
        return buyerEmail;
    }

    /**
     * @return The name of the order's buyer.
     */
    @JsonIgnore
    public Optional<String> getRecipientName() {
        if (recipientName == null) {
            return Optional.empty();
        }
        return recipientName;
    }

    /**
     * @return The phone number to use for the order's delivery.
     */
    @JsonIgnore
    public Optional<String> getRecipientPhoneNumber() {
        if (recipientPhoneNumber == null) {
            return Optional.empty();
        }
        return recipientPhoneNumber;
    }

    /**
     * @return Whether the tax is an ADDITIVE tax or an INCLUSIVE tax.
     * See <a href="#type-v1orderstate">V1OrderState</a> for possible values
     */
    @JsonProperty("state")
    public Optional<V1OrderState> getState() {
        return state;
    }

    /**
     * @return The address to ship the order to.
     */
    @JsonProperty("shipping_address")
    public Optional<Address> getShippingAddress() {
        return shippingAddress;
    }

    /**
     * @return The amount of all items purchased in the order, before taxes and shipping.
     */
    @JsonProperty("subtotal_money")
    public Optional<V1Money> getSubtotalMoney() {
        return subtotalMoney;
    }

    /**
     * @return The shipping cost for the order.
     */
    @JsonProperty("total_shipping_money")
    public Optional<V1Money> getTotalShippingMoney() {
        return totalShippingMoney;
    }

    /**
     * @return The total of all taxes applied to the order.
     */
    @JsonProperty("total_tax_money")
    public Optional<V1Money> getTotalTaxMoney() {
        return totalTaxMoney;
    }

    /**
     * @return The total cost of the order.
     */
    @JsonProperty("total_price_money")
    public Optional<V1Money> getTotalPriceMoney() {
        return totalPriceMoney;
    }

    /**
     * @return The total of all discounts applied to the order.
     */
    @JsonProperty("total_discount_money")
    public Optional<V1Money> getTotalDiscountMoney() {
        return totalDiscountMoney;
    }

    /**
     * @return The time when the order was created, in ISO 8601 format.
     */
    @JsonProperty("created_at")
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The time when the order was last modified, in ISO 8601 format.
     */
    @JsonProperty("updated_at")
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return The time when the order expires if no action is taken, in ISO 8601 format.
     */
    @JsonIgnore
    public Optional<String> getExpiresAt() {
        if (expiresAt == null) {
            return Optional.empty();
        }
        return expiresAt;
    }

    /**
     * @return The unique identifier of the payment associated with the order.
     */
    @JsonIgnore
    public Optional<String> getPaymentId() {
        if (paymentId == null) {
            return Optional.empty();
        }
        return paymentId;
    }

    /**
     * @return A note provided by the buyer when the order was created, if any.
     */
    @JsonIgnore
    public Optional<String> getBuyerNote() {
        if (buyerNote == null) {
            return Optional.empty();
        }
        return buyerNote;
    }

    /**
     * @return A note provided by the merchant when the order's state was set to COMPLETED, if any
     */
    @JsonIgnore
    public Optional<String> getCompletedNote() {
        if (completedNote == null) {
            return Optional.empty();
        }
        return completedNote;
    }

    /**
     * @return A note provided by the merchant when the order's state was set to REFUNDED, if any.
     */
    @JsonIgnore
    public Optional<String> getRefundedNote() {
        if (refundedNote == null) {
            return Optional.empty();
        }
        return refundedNote;
    }

    /**
     * @return A note provided by the merchant when the order's state was set to CANCELED, if any.
     */
    @JsonIgnore
    public Optional<String> getCanceledNote() {
        if (canceledNote == null) {
            return Optional.empty();
        }
        return canceledNote;
    }

    /**
     * @return The tender used to pay for the order.
     */
    @JsonProperty("tender")
    public Optional<V1Tender> getTender() {
        return tender;
    }

    /**
     * @return The history of actions associated with the order.
     */
    @JsonIgnore
    public Optional<List<V1OrderHistoryEntry>> getOrderHistory() {
        if (orderHistory == null) {
            return Optional.empty();
        }
        return orderHistory;
    }

    /**
     * @return The promo code provided by the buyer, if any.
     */
    @JsonIgnore
    public Optional<String> getPromoCode() {
        if (promoCode == null) {
            return Optional.empty();
        }
        return promoCode;
    }

    /**
     * @return For Bitcoin transactions, the address that the buyer sent Bitcoin to.
     */
    @JsonIgnore
    public Optional<String> getBtcReceiveAddress() {
        if (btcReceiveAddress == null) {
            return Optional.empty();
        }
        return btcReceiveAddress;
    }

    /**
     * @return For Bitcoin transactions, the price of the buyer's order in satoshi (100 million satoshi equals 1 BTC).
     */
    @JsonIgnore
    public Optional<Double> getBtcPriceSatoshi() {
        if (btcPriceSatoshi == null) {
            return Optional.empty();
        }
        return btcPriceSatoshi;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("errors")
    private Optional<List<Error>> _getErrors() {
        return errors;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("buyer_email")
    private Optional<String> _getBuyerEmail() {
        return buyerEmail;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("recipient_name")
    private Optional<String> _getRecipientName() {
        return recipientName;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("recipient_phone_number")
    private Optional<String> _getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("expires_at")
    private Optional<String> _getExpiresAt() {
        return expiresAt;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("payment_id")
    private Optional<String> _getPaymentId() {
        return paymentId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("buyer_note")
    private Optional<String> _getBuyerNote() {
        return buyerNote;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("completed_note")
    private Optional<String> _getCompletedNote() {
        return completedNote;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("refunded_note")
    private Optional<String> _getRefundedNote() {
        return refundedNote;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("canceled_note")
    private Optional<String> _getCanceledNote() {
        return canceledNote;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("order_history")
    private Optional<List<V1OrderHistoryEntry>> _getOrderHistory() {
        return orderHistory;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("promo_code")
    private Optional<String> _getPromoCode() {
        return promoCode;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("btc_receive_address")
    private Optional<String> _getBtcReceiveAddress() {
        return btcReceiveAddress;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("btc_price_satoshi")
    private Optional<Double> _getBtcPriceSatoshi() {
        return btcPriceSatoshi;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V1Order && equalTo((V1Order) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V1Order other) {
        return errors.equals(other.errors)
                && id.equals(other.id)
                && buyerEmail.equals(other.buyerEmail)
                && recipientName.equals(other.recipientName)
                && recipientPhoneNumber.equals(other.recipientPhoneNumber)
                && state.equals(other.state)
                && shippingAddress.equals(other.shippingAddress)
                && subtotalMoney.equals(other.subtotalMoney)
                && totalShippingMoney.equals(other.totalShippingMoney)
                && totalTaxMoney.equals(other.totalTaxMoney)
                && totalPriceMoney.equals(other.totalPriceMoney)
                && totalDiscountMoney.equals(other.totalDiscountMoney)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && expiresAt.equals(other.expiresAt)
                && paymentId.equals(other.paymentId)
                && buyerNote.equals(other.buyerNote)
                && completedNote.equals(other.completedNote)
                && refundedNote.equals(other.refundedNote)
                && canceledNote.equals(other.canceledNote)
                && tender.equals(other.tender)
                && orderHistory.equals(other.orderHistory)
                && promoCode.equals(other.promoCode)
                && btcReceiveAddress.equals(other.btcReceiveAddress)
                && btcPriceSatoshi.equals(other.btcPriceSatoshi);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.errors,
                this.id,
                this.buyerEmail,
                this.recipientName,
                this.recipientPhoneNumber,
                this.state,
                this.shippingAddress,
                this.subtotalMoney,
                this.totalShippingMoney,
                this.totalTaxMoney,
                this.totalPriceMoney,
                this.totalDiscountMoney,
                this.createdAt,
                this.updatedAt,
                this.expiresAt,
                this.paymentId,
                this.buyerNote,
                this.completedNote,
                this.refundedNote,
                this.canceledNote,
                this.tender,
                this.orderHistory,
                this.promoCode,
                this.btcReceiveAddress,
                this.btcPriceSatoshi);
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
        private Optional<List<Error>> errors = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> buyerEmail = Optional.empty();

        private Optional<String> recipientName = Optional.empty();

        private Optional<String> recipientPhoneNumber = Optional.empty();

        private Optional<V1OrderState> state = Optional.empty();

        private Optional<Address> shippingAddress = Optional.empty();

        private Optional<V1Money> subtotalMoney = Optional.empty();

        private Optional<V1Money> totalShippingMoney = Optional.empty();

        private Optional<V1Money> totalTaxMoney = Optional.empty();

        private Optional<V1Money> totalPriceMoney = Optional.empty();

        private Optional<V1Money> totalDiscountMoney = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<String> updatedAt = Optional.empty();

        private Optional<String> expiresAt = Optional.empty();

        private Optional<String> paymentId = Optional.empty();

        private Optional<String> buyerNote = Optional.empty();

        private Optional<String> completedNote = Optional.empty();

        private Optional<String> refundedNote = Optional.empty();

        private Optional<String> canceledNote = Optional.empty();

        private Optional<V1Tender> tender = Optional.empty();

        private Optional<List<V1OrderHistoryEntry>> orderHistory = Optional.empty();

        private Optional<String> promoCode = Optional.empty();

        private Optional<String> btcReceiveAddress = Optional.empty();

        private Optional<Double> btcPriceSatoshi = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V1Order other) {
            errors(other.getErrors());
            id(other.getId());
            buyerEmail(other.getBuyerEmail());
            recipientName(other.getRecipientName());
            recipientPhoneNumber(other.getRecipientPhoneNumber());
            state(other.getState());
            shippingAddress(other.getShippingAddress());
            subtotalMoney(other.getSubtotalMoney());
            totalShippingMoney(other.getTotalShippingMoney());
            totalTaxMoney(other.getTotalTaxMoney());
            totalPriceMoney(other.getTotalPriceMoney());
            totalDiscountMoney(other.getTotalDiscountMoney());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            expiresAt(other.getExpiresAt());
            paymentId(other.getPaymentId());
            buyerNote(other.getBuyerNote());
            completedNote(other.getCompletedNote());
            refundedNote(other.getRefundedNote());
            canceledNote(other.getCanceledNote());
            tender(other.getTender());
            orderHistory(other.getOrderHistory());
            promoCode(other.getPromoCode());
            btcReceiveAddress(other.getBtcReceiveAddress());
            btcPriceSatoshi(other.getBtcPriceSatoshi());
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        public Builder errors(Nullable<List<Error>> errors) {
            if (errors.isNull()) {
                this.errors = null;
            } else if (errors.isEmpty()) {
                this.errors = Optional.empty();
            } else {
                this.errors = Optional.of(errors.get());
            }
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

        @JsonSetter(value = "buyer_email", nulls = Nulls.SKIP)
        public Builder buyerEmail(Optional<String> buyerEmail) {
            this.buyerEmail = buyerEmail;
            return this;
        }

        public Builder buyerEmail(String buyerEmail) {
            this.buyerEmail = Optional.ofNullable(buyerEmail);
            return this;
        }

        public Builder buyerEmail(Nullable<String> buyerEmail) {
            if (buyerEmail.isNull()) {
                this.buyerEmail = null;
            } else if (buyerEmail.isEmpty()) {
                this.buyerEmail = Optional.empty();
            } else {
                this.buyerEmail = Optional.of(buyerEmail.get());
            }
            return this;
        }

        @JsonSetter(value = "recipient_name", nulls = Nulls.SKIP)
        public Builder recipientName(Optional<String> recipientName) {
            this.recipientName = recipientName;
            return this;
        }

        public Builder recipientName(String recipientName) {
            this.recipientName = Optional.ofNullable(recipientName);
            return this;
        }

        public Builder recipientName(Nullable<String> recipientName) {
            if (recipientName.isNull()) {
                this.recipientName = null;
            } else if (recipientName.isEmpty()) {
                this.recipientName = Optional.empty();
            } else {
                this.recipientName = Optional.of(recipientName.get());
            }
            return this;
        }

        @JsonSetter(value = "recipient_phone_number", nulls = Nulls.SKIP)
        public Builder recipientPhoneNumber(Optional<String> recipientPhoneNumber) {
            this.recipientPhoneNumber = recipientPhoneNumber;
            return this;
        }

        public Builder recipientPhoneNumber(String recipientPhoneNumber) {
            this.recipientPhoneNumber = Optional.ofNullable(recipientPhoneNumber);
            return this;
        }

        public Builder recipientPhoneNumber(Nullable<String> recipientPhoneNumber) {
            if (recipientPhoneNumber.isNull()) {
                this.recipientPhoneNumber = null;
            } else if (recipientPhoneNumber.isEmpty()) {
                this.recipientPhoneNumber = Optional.empty();
            } else {
                this.recipientPhoneNumber = Optional.of(recipientPhoneNumber.get());
            }
            return this;
        }

        @JsonSetter(value = "state", nulls = Nulls.SKIP)
        public Builder state(Optional<V1OrderState> state) {
            this.state = state;
            return this;
        }

        public Builder state(V1OrderState state) {
            this.state = Optional.ofNullable(state);
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

        @JsonSetter(value = "subtotal_money", nulls = Nulls.SKIP)
        public Builder subtotalMoney(Optional<V1Money> subtotalMoney) {
            this.subtotalMoney = subtotalMoney;
            return this;
        }

        public Builder subtotalMoney(V1Money subtotalMoney) {
            this.subtotalMoney = Optional.ofNullable(subtotalMoney);
            return this;
        }

        @JsonSetter(value = "total_shipping_money", nulls = Nulls.SKIP)
        public Builder totalShippingMoney(Optional<V1Money> totalShippingMoney) {
            this.totalShippingMoney = totalShippingMoney;
            return this;
        }

        public Builder totalShippingMoney(V1Money totalShippingMoney) {
            this.totalShippingMoney = Optional.ofNullable(totalShippingMoney);
            return this;
        }

        @JsonSetter(value = "total_tax_money", nulls = Nulls.SKIP)
        public Builder totalTaxMoney(Optional<V1Money> totalTaxMoney) {
            this.totalTaxMoney = totalTaxMoney;
            return this;
        }

        public Builder totalTaxMoney(V1Money totalTaxMoney) {
            this.totalTaxMoney = Optional.ofNullable(totalTaxMoney);
            return this;
        }

        @JsonSetter(value = "total_price_money", nulls = Nulls.SKIP)
        public Builder totalPriceMoney(Optional<V1Money> totalPriceMoney) {
            this.totalPriceMoney = totalPriceMoney;
            return this;
        }

        public Builder totalPriceMoney(V1Money totalPriceMoney) {
            this.totalPriceMoney = Optional.ofNullable(totalPriceMoney);
            return this;
        }

        @JsonSetter(value = "total_discount_money", nulls = Nulls.SKIP)
        public Builder totalDiscountMoney(Optional<V1Money> totalDiscountMoney) {
            this.totalDiscountMoney = totalDiscountMoney;
            return this;
        }

        public Builder totalDiscountMoney(V1Money totalDiscountMoney) {
            this.totalDiscountMoney = Optional.ofNullable(totalDiscountMoney);
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

        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public Builder updatedAt(Optional<String> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder updatedAt(String updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        @JsonSetter(value = "expires_at", nulls = Nulls.SKIP)
        public Builder expiresAt(Optional<String> expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public Builder expiresAt(String expiresAt) {
            this.expiresAt = Optional.ofNullable(expiresAt);
            return this;
        }

        public Builder expiresAt(Nullable<String> expiresAt) {
            if (expiresAt.isNull()) {
                this.expiresAt = null;
            } else if (expiresAt.isEmpty()) {
                this.expiresAt = Optional.empty();
            } else {
                this.expiresAt = Optional.of(expiresAt.get());
            }
            return this;
        }

        @JsonSetter(value = "payment_id", nulls = Nulls.SKIP)
        public Builder paymentId(Optional<String> paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder paymentId(String paymentId) {
            this.paymentId = Optional.ofNullable(paymentId);
            return this;
        }

        public Builder paymentId(Nullable<String> paymentId) {
            if (paymentId.isNull()) {
                this.paymentId = null;
            } else if (paymentId.isEmpty()) {
                this.paymentId = Optional.empty();
            } else {
                this.paymentId = Optional.of(paymentId.get());
            }
            return this;
        }

        @JsonSetter(value = "buyer_note", nulls = Nulls.SKIP)
        public Builder buyerNote(Optional<String> buyerNote) {
            this.buyerNote = buyerNote;
            return this;
        }

        public Builder buyerNote(String buyerNote) {
            this.buyerNote = Optional.ofNullable(buyerNote);
            return this;
        }

        public Builder buyerNote(Nullable<String> buyerNote) {
            if (buyerNote.isNull()) {
                this.buyerNote = null;
            } else if (buyerNote.isEmpty()) {
                this.buyerNote = Optional.empty();
            } else {
                this.buyerNote = Optional.of(buyerNote.get());
            }
            return this;
        }

        @JsonSetter(value = "completed_note", nulls = Nulls.SKIP)
        public Builder completedNote(Optional<String> completedNote) {
            this.completedNote = completedNote;
            return this;
        }

        public Builder completedNote(String completedNote) {
            this.completedNote = Optional.ofNullable(completedNote);
            return this;
        }

        public Builder completedNote(Nullable<String> completedNote) {
            if (completedNote.isNull()) {
                this.completedNote = null;
            } else if (completedNote.isEmpty()) {
                this.completedNote = Optional.empty();
            } else {
                this.completedNote = Optional.of(completedNote.get());
            }
            return this;
        }

        @JsonSetter(value = "refunded_note", nulls = Nulls.SKIP)
        public Builder refundedNote(Optional<String> refundedNote) {
            this.refundedNote = refundedNote;
            return this;
        }

        public Builder refundedNote(String refundedNote) {
            this.refundedNote = Optional.ofNullable(refundedNote);
            return this;
        }

        public Builder refundedNote(Nullable<String> refundedNote) {
            if (refundedNote.isNull()) {
                this.refundedNote = null;
            } else if (refundedNote.isEmpty()) {
                this.refundedNote = Optional.empty();
            } else {
                this.refundedNote = Optional.of(refundedNote.get());
            }
            return this;
        }

        @JsonSetter(value = "canceled_note", nulls = Nulls.SKIP)
        public Builder canceledNote(Optional<String> canceledNote) {
            this.canceledNote = canceledNote;
            return this;
        }

        public Builder canceledNote(String canceledNote) {
            this.canceledNote = Optional.ofNullable(canceledNote);
            return this;
        }

        public Builder canceledNote(Nullable<String> canceledNote) {
            if (canceledNote.isNull()) {
                this.canceledNote = null;
            } else if (canceledNote.isEmpty()) {
                this.canceledNote = Optional.empty();
            } else {
                this.canceledNote = Optional.of(canceledNote.get());
            }
            return this;
        }

        @JsonSetter(value = "tender", nulls = Nulls.SKIP)
        public Builder tender(Optional<V1Tender> tender) {
            this.tender = tender;
            return this;
        }

        public Builder tender(V1Tender tender) {
            this.tender = Optional.ofNullable(tender);
            return this;
        }

        @JsonSetter(value = "order_history", nulls = Nulls.SKIP)
        public Builder orderHistory(Optional<List<V1OrderHistoryEntry>> orderHistory) {
            this.orderHistory = orderHistory;
            return this;
        }

        public Builder orderHistory(List<V1OrderHistoryEntry> orderHistory) {
            this.orderHistory = Optional.ofNullable(orderHistory);
            return this;
        }

        public Builder orderHistory(Nullable<List<V1OrderHistoryEntry>> orderHistory) {
            if (orderHistory.isNull()) {
                this.orderHistory = null;
            } else if (orderHistory.isEmpty()) {
                this.orderHistory = Optional.empty();
            } else {
                this.orderHistory = Optional.of(orderHistory.get());
            }
            return this;
        }

        @JsonSetter(value = "promo_code", nulls = Nulls.SKIP)
        public Builder promoCode(Optional<String> promoCode) {
            this.promoCode = promoCode;
            return this;
        }

        public Builder promoCode(String promoCode) {
            this.promoCode = Optional.ofNullable(promoCode);
            return this;
        }

        public Builder promoCode(Nullable<String> promoCode) {
            if (promoCode.isNull()) {
                this.promoCode = null;
            } else if (promoCode.isEmpty()) {
                this.promoCode = Optional.empty();
            } else {
                this.promoCode = Optional.of(promoCode.get());
            }
            return this;
        }

        @JsonSetter(value = "btc_receive_address", nulls = Nulls.SKIP)
        public Builder btcReceiveAddress(Optional<String> btcReceiveAddress) {
            this.btcReceiveAddress = btcReceiveAddress;
            return this;
        }

        public Builder btcReceiveAddress(String btcReceiveAddress) {
            this.btcReceiveAddress = Optional.ofNullable(btcReceiveAddress);
            return this;
        }

        public Builder btcReceiveAddress(Nullable<String> btcReceiveAddress) {
            if (btcReceiveAddress.isNull()) {
                this.btcReceiveAddress = null;
            } else if (btcReceiveAddress.isEmpty()) {
                this.btcReceiveAddress = Optional.empty();
            } else {
                this.btcReceiveAddress = Optional.of(btcReceiveAddress.get());
            }
            return this;
        }

        @JsonSetter(value = "btc_price_satoshi", nulls = Nulls.SKIP)
        public Builder btcPriceSatoshi(Optional<Double> btcPriceSatoshi) {
            this.btcPriceSatoshi = btcPriceSatoshi;
            return this;
        }

        public Builder btcPriceSatoshi(Double btcPriceSatoshi) {
            this.btcPriceSatoshi = Optional.ofNullable(btcPriceSatoshi);
            return this;
        }

        public Builder btcPriceSatoshi(Nullable<Double> btcPriceSatoshi) {
            if (btcPriceSatoshi.isNull()) {
                this.btcPriceSatoshi = null;
            } else if (btcPriceSatoshi.isEmpty()) {
                this.btcPriceSatoshi = Optional.empty();
            } else {
                this.btcPriceSatoshi = Optional.of(btcPriceSatoshi.get());
            }
            return this;
        }

        public V1Order build() {
            return new V1Order(
                    errors,
                    id,
                    buyerEmail,
                    recipientName,
                    recipientPhoneNumber,
                    state,
                    shippingAddress,
                    subtotalMoney,
                    totalShippingMoney,
                    totalTaxMoney,
                    totalPriceMoney,
                    totalDiscountMoney,
                    createdAt,
                    updatedAt,
                    expiresAt,
                    paymentId,
                    buyerNote,
                    completedNote,
                    refundedNote,
                    canceledNote,
                    tender,
                    orderHistory,
                    promoCode,
                    btcReceiveAddress,
                    btcPriceSatoshi,
                    additionalProperties);
        }
    }
}
