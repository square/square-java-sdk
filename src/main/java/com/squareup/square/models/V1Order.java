package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1Order type.
 */
public class V1Order {

    /**
     * Initialization constructor.
     * @param errors
     * @param id
     * @param buyerEmail
     * @param recipientName
     * @param recipientPhoneNumber
     * @param state
     * @param shippingAddress
     * @param subtotalMoney
     * @param totalShippingMoney
     * @param totalTaxMoney
     * @param totalPriceMoney
     * @param totalDiscountMoney
     * @param createdAt
     * @param updatedAt
     * @param expiresAt
     * @param paymentId
     * @param buyerNote
     * @param completedNote
     * @param refundedNote
     * @param canceledNote
     * @param tender
     * @param orderHistory
     * @param promoCode
     * @param btcReceiveAddress
     * @param btcPriceSatoshi
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, id, buyerEmail, recipientName, recipientPhoneNumber, state,
            shippingAddress, subtotalMoney, totalShippingMoney, totalTaxMoney, totalPriceMoney,
            totalDiscountMoney, createdAt, updatedAt, expiresAt, paymentId, buyerNote, completedNote,
            refundedNote, canceledNote, tender, orderHistory, promoCode, btcReceiveAddress,
            btcPriceSatoshi);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1Order)) {
            return false;
        }
        V1Order v1Order = (V1Order) obj;
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

    /**
     * Builds a new {@link V1Order.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Order.Builder} object
     */
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

    /**
     * Class to build instances of {@link V1Order}
     */
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

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for buyerEmail
         * @param buyerEmail
         * @return Builder
         */
        public Builder buyerEmail(String buyerEmail) {
            this.buyerEmail = buyerEmail;
            return this;
        }
        /**
         * Setter for recipientName
         * @param recipientName
         * @return Builder
         */
        public Builder recipientName(String recipientName) {
            this.recipientName = recipientName;
            return this;
        }
        /**
         * Setter for recipientPhoneNumber
         * @param recipientPhoneNumber
         * @return Builder
         */
        public Builder recipientPhoneNumber(String recipientPhoneNumber) {
            this.recipientPhoneNumber = recipientPhoneNumber;
            return this;
        }
        /**
         * Setter for state
         * @param state
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }
        /**
         * Setter for shippingAddress
         * @param shippingAddress
         * @return Builder
         */
        public Builder shippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }
        /**
         * Setter for subtotalMoney
         * @param subtotalMoney
         * @return Builder
         */
        public Builder subtotalMoney(V1Money subtotalMoney) {
            this.subtotalMoney = subtotalMoney;
            return this;
        }
        /**
         * Setter for totalShippingMoney
         * @param totalShippingMoney
         * @return Builder
         */
        public Builder totalShippingMoney(V1Money totalShippingMoney) {
            this.totalShippingMoney = totalShippingMoney;
            return this;
        }
        /**
         * Setter for totalTaxMoney
         * @param totalTaxMoney
         * @return Builder
         */
        public Builder totalTaxMoney(V1Money totalTaxMoney) {
            this.totalTaxMoney = totalTaxMoney;
            return this;
        }
        /**
         * Setter for totalPriceMoney
         * @param totalPriceMoney
         * @return Builder
         */
        public Builder totalPriceMoney(V1Money totalPriceMoney) {
            this.totalPriceMoney = totalPriceMoney;
            return this;
        }
        /**
         * Setter for totalDiscountMoney
         * @param totalDiscountMoney
         * @return Builder
         */
        public Builder totalDiscountMoney(V1Money totalDiscountMoney) {
            this.totalDiscountMoney = totalDiscountMoney;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        /**
         * Setter for expiresAt
         * @param expiresAt
         * @return Builder
         */
        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }
        /**
         * Setter for paymentId
         * @param paymentId
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }
        /**
         * Setter for buyerNote
         * @param buyerNote
         * @return Builder
         */
        public Builder buyerNote(String buyerNote) {
            this.buyerNote = buyerNote;
            return this;
        }
        /**
         * Setter for completedNote
         * @param completedNote
         * @return Builder
         */
        public Builder completedNote(String completedNote) {
            this.completedNote = completedNote;
            return this;
        }
        /**
         * Setter for refundedNote
         * @param refundedNote
         * @return Builder
         */
        public Builder refundedNote(String refundedNote) {
            this.refundedNote = refundedNote;
            return this;
        }
        /**
         * Setter for canceledNote
         * @param canceledNote
         * @return Builder
         */
        public Builder canceledNote(String canceledNote) {
            this.canceledNote = canceledNote;
            return this;
        }
        /**
         * Setter for tender
         * @param tender
         * @return Builder
         */
        public Builder tender(V1Tender tender) {
            this.tender = tender;
            return this;
        }
        /**
         * Setter for orderHistory
         * @param orderHistory
         * @return Builder
         */
        public Builder orderHistory(List<V1OrderHistoryEntry> orderHistory) {
            this.orderHistory = orderHistory;
            return this;
        }
        /**
         * Setter for promoCode
         * @param promoCode
         * @return Builder
         */
        public Builder promoCode(String promoCode) {
            this.promoCode = promoCode;
            return this;
        }
        /**
         * Setter for btcReceiveAddress
         * @param btcReceiveAddress
         * @return Builder
         */
        public Builder btcReceiveAddress(String btcReceiveAddress) {
            this.btcReceiveAddress = btcReceiveAddress;
            return this;
        }
        /**
         * Setter for btcPriceSatoshi
         * @param btcPriceSatoshi
         * @return Builder
         */
        public Builder btcPriceSatoshi(Double btcPriceSatoshi) {
            this.btcPriceSatoshi = btcPriceSatoshi;
            return this;
        }

        /**
         * Builds a new {@link V1Order} object using the set fields.
         * @return {@link V1Order}
         */
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
