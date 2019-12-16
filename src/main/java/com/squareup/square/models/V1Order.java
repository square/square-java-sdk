package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1Order {

    @JsonCreator
    public V1Order(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("id") String id,
            @JsonProperty("buyer_email") String buyerEmail,
            @JsonProperty("recipient_name") String recipientName,
            @JsonProperty("recipient_phone_number") String recipientPhoneNumber,
            @JsonProperty("state") String state,
            @JsonProperty("shipping_address") Address shippingAddress,
            @JsonProperty("subtotal_money") V1Money subtotalMoney,
            @JsonProperty("total_shipping_money") V1Money totalShippingMoney,
            @JsonProperty("total_tax_money") V1Money totalTaxMoney,
            @JsonProperty("total_price_money") V1Money totalPriceMoney,
            @JsonProperty("total_discount_money") V1Money totalDiscountMoney,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("expires_at") String expiresAt,
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("buyer_note") String buyerNote,
            @JsonProperty("completed_note") String completedNote,
            @JsonProperty("refunded_note") String refundedNote,
            @JsonProperty("canceled_note") String canceledNote,
            @JsonProperty("tender") V1Tender tender,
            @JsonProperty("order_history") List<V1OrderHistoryEntry> orderHistory,
            @JsonProperty("promo_code") String promoCode,
            @JsonProperty("btc_receive_address") String btcReceiveAddress,
            @JsonProperty("btc_price_satoshi") Double btcPriceSatoshi) {
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
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final String id;
    private final String buyerEmail;
    private final String recipientName;
    private final String recipientPhoneNumber;
    private final String state;
    private final Address shippingAddress;
    private final V1Money subtotalMoney;
    private final V1Money totalShippingMoney;
    private final V1Money totalTaxMoney;
    private final V1Money totalPriceMoney;
    private final V1Money totalDiscountMoney;
    private final String createdAt;
    private final String updatedAt;
    private final String expiresAt;
    private final String paymentId;
    private final String buyerNote;
    private final String completedNote;
    private final String refundedNote;
    private final String canceledNote;
    private final V1Tender tender;
    private final List<V1OrderHistoryEntry> orderHistory;
    private final String promoCode;
    private final String btcReceiveAddress;
    private final Double btcPriceSatoshi;

    @Override
    public int hashCode() {
        return Objects.hash(errors, id, buyerEmail, recipientName, recipientPhoneNumber, state, shippingAddress, subtotalMoney, totalShippingMoney, totalTaxMoney, totalPriceMoney, totalDiscountMoney, createdAt, updatedAt, expiresAt, paymentId, buyerNote, completedNote, refundedNote, canceledNote, tender, orderHistory, promoCode, btcReceiveAddress, btcPriceSatoshi);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Order)) {
            return false;
        }
        V1Order v1Order = (V1Order) o;
        return Objects.equals(errors, v1Order.errors) &&
            Objects.equals(id, v1Order.id) &&
            Objects.equals(buyerEmail, v1Order.buyerEmail) &&
            Objects.equals(recipientName, v1Order.recipientName) &&
            Objects.equals(recipientPhoneNumber, v1Order.recipientPhoneNumber) &&
            Objects.equals(state, v1Order.state) &&
            Objects.equals(shippingAddress, v1Order.shippingAddress) &&
            Objects.equals(subtotalMoney, v1Order.subtotalMoney) &&
            Objects.equals(totalShippingMoney, v1Order.totalShippingMoney) &&
            Objects.equals(totalTaxMoney, v1Order.totalTaxMoney) &&
            Objects.equals(totalPriceMoney, v1Order.totalPriceMoney) &&
            Objects.equals(totalDiscountMoney, v1Order.totalDiscountMoney) &&
            Objects.equals(createdAt, v1Order.createdAt) &&
            Objects.equals(updatedAt, v1Order.updatedAt) &&
            Objects.equals(expiresAt, v1Order.expiresAt) &&
            Objects.equals(paymentId, v1Order.paymentId) &&
            Objects.equals(buyerNote, v1Order.buyerNote) &&
            Objects.equals(completedNote, v1Order.completedNote) &&
            Objects.equals(refundedNote, v1Order.refundedNote) &&
            Objects.equals(canceledNote, v1Order.canceledNote) &&
            Objects.equals(tender, v1Order.tender) &&
            Objects.equals(orderHistory, v1Order.orderHistory) &&
            Objects.equals(promoCode, v1Order.promoCode) &&
            Objects.equals(btcReceiveAddress, v1Order.btcReceiveAddress) &&
            Objects.equals(btcPriceSatoshi, v1Order.btcPriceSatoshi);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

    /**
     * Getter for Id.
     * The order's unique identifier.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for BuyerEmail.
     * The email address of the order's buyer.
     */
    @JsonGetter("buyer_email")
    public String getBuyerEmail() { 
        return this.buyerEmail;
    }

    /**
     * Getter for RecipientName.
     * The name of the order's buyer.
     */
    @JsonGetter("recipient_name")
    public String getRecipientName() { 
        return this.recipientName;
    }

    /**
     * Getter for RecipientPhoneNumber.
     * The phone number to use for the order's delivery.
     */
    @JsonGetter("recipient_phone_number")
    public String getRecipientPhoneNumber() { 
        return this.recipientPhoneNumber;
    }

    /**
     * Getter for State.
     */
    @JsonGetter("state")
    public String getState() { 
        return this.state;
    }

    /**
     * Getter for ShippingAddress.
     * Represents a physical address.
     */
    @JsonGetter("shipping_address")
    public Address getShippingAddress() { 
        return this.shippingAddress;
    }

    /**
     * Getter for SubtotalMoney.
     */
    @JsonGetter("subtotal_money")
    public V1Money getSubtotalMoney() { 
        return this.subtotalMoney;
    }

    /**
     * Getter for TotalShippingMoney.
     */
    @JsonGetter("total_shipping_money")
    public V1Money getTotalShippingMoney() { 
        return this.totalShippingMoney;
    }

    /**
     * Getter for TotalTaxMoney.
     */
    @JsonGetter("total_tax_money")
    public V1Money getTotalTaxMoney() { 
        return this.totalTaxMoney;
    }

    /**
     * Getter for TotalPriceMoney.
     */
    @JsonGetter("total_price_money")
    public V1Money getTotalPriceMoney() { 
        return this.totalPriceMoney;
    }

    /**
     * Getter for TotalDiscountMoney.
     */
    @JsonGetter("total_discount_money")
    public V1Money getTotalDiscountMoney() { 
        return this.totalDiscountMoney;
    }

    /**
     * Getter for CreatedAt.
     * The time when the order was created, in ISO 8601 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the order was last modified, in ISO 8601 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() { 
        return this.updatedAt;
    }

    /**
     * Getter for ExpiresAt.
     * The time when the order expires if no action is taken, in ISO 8601 format.
     */
    @JsonGetter("expires_at")
    public String getExpiresAt() { 
        return this.expiresAt;
    }

    /**
     * Getter for PaymentId.
     * The unique identifier of the payment associated with the order.
     */
    @JsonGetter("payment_id")
    public String getPaymentId() { 
        return this.paymentId;
    }

    /**
     * Getter for BuyerNote.
     * A note provided by the buyer when the order was created, if any.
     */
    @JsonGetter("buyer_note")
    public String getBuyerNote() { 
        return this.buyerNote;
    }

    /**
     * Getter for CompletedNote.
     * A note provided by the merchant when the order's state was set to COMPLETED, if any
     */
    @JsonGetter("completed_note")
    public String getCompletedNote() { 
        return this.completedNote;
    }

    /**
     * Getter for RefundedNote.
     * A note provided by the merchant when the order's state was set to REFUNDED, if any.
     */
    @JsonGetter("refunded_note")
    public String getRefundedNote() { 
        return this.refundedNote;
    }

    /**
     * Getter for CanceledNote.
     * A note provided by the merchant when the order's state was set to CANCELED, if any.
     */
    @JsonGetter("canceled_note")
    public String getCanceledNote() { 
        return this.canceledNote;
    }

    /**
     * Getter for Tender.
     * A tender represents a discrete monetary exchange. Square represents this
     * exchange as a money object with a specific currency and amount, where the
     * amount is given in the smallest denomination of the given currency.
     * Square POS can accept more than one form of tender for a single payment (such
     * as by splitting a bill between a credit card and a gift card). The `tender`
     * field of the Payment object lists all forms of tender used for the payment.
     * Split tender payments behave slightly differently from single tender payments:
     * The receipt_url for a split tender corresponds only to the first tender listed
     * in the tender field. To get the receipt URLs for the remaining tenders, use
     * the receipt_url fields of the corresponding Tender objects.
     * *A note on gift cards**: when a customer purchases a Square gift card from a
     * merchant, the merchant receives the full amount of the gift card in the
     * associated payment.
     * When that gift card is used as a tender, the balance of the gift card is
     * reduced and the merchant receives no funds. A `Tender` object with a type of
     * `SQUARE_GIFT_CARD` indicates a gift card was used for some or all of the
     * associated payment.
     */
    @JsonGetter("tender")
    public V1Tender getTender() { 
        return this.tender;
    }

    /**
     * Getter for OrderHistory.
     * The history of actions associated with the order.
     */
    @JsonGetter("order_history")
    public List<V1OrderHistoryEntry> getOrderHistory() { 
        return this.orderHistory;
    }

    /**
     * Getter for PromoCode.
     * The promo code provided by the buyer, if any.
     */
    @JsonGetter("promo_code")
    public String getPromoCode() { 
        return this.promoCode;
    }

    /**
     * Getter for BtcReceiveAddress.
     * For Bitcoin transactions, the address that the buyer sent Bitcoin to.
     */
    @JsonGetter("btc_receive_address")
    public String getBtcReceiveAddress() { 
        return this.btcReceiveAddress;
    }

    /**
     * Getter for BtcPriceSatoshi.
     * For Bitcoin transactions, the price of the buyer's order in satoshi (100 million satoshi equals 1 BTC).
     */
    @JsonGetter("btc_price_satoshi")
    public Double getBtcPriceSatoshi() { 
        return this.btcPriceSatoshi;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .id(getId())
            .buyerEmail(getBuyerEmail())
            .recipientName(getRecipientName())
            .recipientPhoneNumber(getRecipientPhoneNumber())
            .state(getState())
            .shippingAddress(getShippingAddress())
            .subtotalMoney(getSubtotalMoney())
            .totalShippingMoney(getTotalShippingMoney())
            .totalTaxMoney(getTotalTaxMoney())
            .totalPriceMoney(getTotalPriceMoney())
            .totalDiscountMoney(getTotalDiscountMoney())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt())
            .expiresAt(getExpiresAt())
            .paymentId(getPaymentId())
            .buyerNote(getBuyerNote())
            .completedNote(getCompletedNote())
            .refundedNote(getRefundedNote())
            .canceledNote(getCanceledNote())
            .tender(getTender())
            .orderHistory(getOrderHistory())
            .promoCode(getPromoCode())
            .btcReceiveAddress(getBtcReceiveAddress())
            .btcPriceSatoshi(getBtcPriceSatoshi());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String id;
        private String buyerEmail;
        private String recipientName;
        private String recipientPhoneNumber;
        private String state;
        private Address shippingAddress;
        private V1Money subtotalMoney;
        private V1Money totalShippingMoney;
        private V1Money totalTaxMoney;
        private V1Money totalPriceMoney;
        private V1Money totalDiscountMoney;
        private String createdAt;
        private String updatedAt;
        private String expiresAt;
        private String paymentId;
        private String buyerNote;
        private String completedNote;
        private String refundedNote;
        private String canceledNote;
        private V1Tender tender;
        private List<V1OrderHistoryEntry> orderHistory;
        private String promoCode;
        private String btcReceiveAddress;
        private Double btcPriceSatoshi;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder buyerEmail(String value) {
            buyerEmail = value;
            return this;
        }
        public Builder recipientName(String value) {
            recipientName = value;
            return this;
        }
        public Builder recipientPhoneNumber(String value) {
            recipientPhoneNumber = value;
            return this;
        }
        public Builder state(String value) {
            state = value;
            return this;
        }
        public Builder shippingAddress(Address value) {
            shippingAddress = value;
            return this;
        }
        public Builder subtotalMoney(V1Money value) {
            subtotalMoney = value;
            return this;
        }
        public Builder totalShippingMoney(V1Money value) {
            totalShippingMoney = value;
            return this;
        }
        public Builder totalTaxMoney(V1Money value) {
            totalTaxMoney = value;
            return this;
        }
        public Builder totalPriceMoney(V1Money value) {
            totalPriceMoney = value;
            return this;
        }
        public Builder totalDiscountMoney(V1Money value) {
            totalDiscountMoney = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder updatedAt(String value) {
            updatedAt = value;
            return this;
        }
        public Builder expiresAt(String value) {
            expiresAt = value;
            return this;
        }
        public Builder paymentId(String value) {
            paymentId = value;
            return this;
        }
        public Builder buyerNote(String value) {
            buyerNote = value;
            return this;
        }
        public Builder completedNote(String value) {
            completedNote = value;
            return this;
        }
        public Builder refundedNote(String value) {
            refundedNote = value;
            return this;
        }
        public Builder canceledNote(String value) {
            canceledNote = value;
            return this;
        }
        public Builder tender(V1Tender value) {
            tender = value;
            return this;
        }
        public Builder orderHistory(List<V1OrderHistoryEntry> value) {
            orderHistory = value;
            return this;
        }
        public Builder promoCode(String value) {
            promoCode = value;
            return this;
        }
        public Builder btcReceiveAddress(String value) {
            btcReceiveAddress = value;
            return this;
        }
        public Builder btcPriceSatoshi(Double value) {
            btcPriceSatoshi = value;
            return this;
        }

        public V1Order build() {
            V1Order model = new V1Order(errors,
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
                btcPriceSatoshi);
            model.httpContext = httpContext;
            return model;
        }
    }
}
