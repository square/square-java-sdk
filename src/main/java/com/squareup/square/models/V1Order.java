
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1Order type.
 */
public class V1Order {
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

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  id  String value for id.
     * @param  buyerEmail  String value for buyerEmail.
     * @param  recipientName  String value for recipientName.
     * @param  recipientPhoneNumber  String value for recipientPhoneNumber.
     * @param  state  String value for state.
     * @param  shippingAddress  Address value for shippingAddress.
     * @param  subtotalMoney  V1Money value for subtotalMoney.
     * @param  totalShippingMoney  V1Money value for totalShippingMoney.
     * @param  totalTaxMoney  V1Money value for totalTaxMoney.
     * @param  totalPriceMoney  V1Money value for totalPriceMoney.
     * @param  totalDiscountMoney  V1Money value for totalDiscountMoney.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  expiresAt  String value for expiresAt.
     * @param  paymentId  String value for paymentId.
     * @param  buyerNote  String value for buyerNote.
     * @param  completedNote  String value for completedNote.
     * @param  refundedNote  String value for refundedNote.
     * @param  canceledNote  String value for canceledNote.
     * @param  tender  V1Tender value for tender.
     * @param  orderHistory  List of V1OrderHistoryEntry value for orderHistory.
     * @param  promoCode  String value for promoCode.
     * @param  btcReceiveAddress  String value for btcReceiveAddress.
     * @param  btcPriceSatoshi  Double value for btcPriceSatoshi.
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Id.
     * The order's unique identifier.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for BuyerEmail.
     * The email address of the order's buyer.
     * @return Returns the String
     */
    @JsonGetter("buyer_email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBuyerEmail() {
        return buyerEmail;
    }

    /**
     * Getter for RecipientName.
     * The name of the order's buyer.
     * @return Returns the String
     */
    @JsonGetter("recipient_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRecipientName() {
        return recipientName;
    }

    /**
     * Getter for RecipientPhoneNumber.
     * The phone number to use for the order's delivery.
     * @return Returns the String
     */
    @JsonGetter("recipient_phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    /**
     * Getter for State.
     * @return Returns the String
     */
    @JsonGetter("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getState() {
        return state;
    }

    /**
     * Getter for ShippingAddress.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("shipping_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Getter for SubtotalMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("subtotal_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getSubtotalMoney() {
        return subtotalMoney;
    }

    /**
     * Getter for TotalShippingMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("total_shipping_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getTotalShippingMoney() {
        return totalShippingMoney;
    }

    /**
     * Getter for TotalTaxMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("total_tax_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getTotalTaxMoney() {
        return totalTaxMoney;
    }

    /**
     * Getter for TotalPriceMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("total_price_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getTotalPriceMoney() {
        return totalPriceMoney;
    }

    /**
     * Getter for TotalDiscountMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("total_discount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getTotalDiscountMoney() {
        return totalDiscountMoney;
    }

    /**
     * Getter for CreatedAt.
     * The time when the order was created, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the order was last modified, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for ExpiresAt.
     * The time when the order expires if no action is taken, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("expires_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getExpiresAt() {
        return expiresAt;
    }

    /**
     * Getter for PaymentId.
     * The unique identifier of the payment associated with the order.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Getter for BuyerNote.
     * A note provided by the buyer when the order was created, if any.
     * @return Returns the String
     */
    @JsonGetter("buyer_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBuyerNote() {
        return buyerNote;
    }

    /**
     * Getter for CompletedNote.
     * A note provided by the merchant when the order's state was set to COMPLETED, if any
     * @return Returns the String
     */
    @JsonGetter("completed_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCompletedNote() {
        return completedNote;
    }

    /**
     * Getter for RefundedNote.
     * A note provided by the merchant when the order's state was set to REFUNDED, if any.
     * @return Returns the String
     */
    @JsonGetter("refunded_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRefundedNote() {
        return refundedNote;
    }

    /**
     * Getter for CanceledNote.
     * A note provided by the merchant when the order's state was set to CANCELED, if any.
     * @return Returns the String
     */
    @JsonGetter("canceled_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCanceledNote() {
        return canceledNote;
    }

    /**
     * Getter for Tender.
     * A tender represents a discrete monetary exchange. Square represents this exchange as a money
     * object with a specific currency and amount, where the amount is given in the smallest
     * denomination of the given currency. Square POS can accept more than one form of tender for a
     * single payment (such as by splitting a bill between a credit card and a gift card). The
     * `tender` field of the Payment object lists all forms of tender used for the payment. Split
     * tender payments behave slightly differently from single tender payments: The receipt_url for
     * a split tender corresponds only to the first tender listed in the tender field. To get the
     * receipt URLs for the remaining tenders, use the receipt_url fields of the corresponding
     * Tender objects. *A note on gift cards**: when a customer purchases a Square gift card from a
     * merchant, the merchant receives the full amount of the gift card in the associated payment.
     * When that gift card is used as a tender, the balance of the gift card is reduced and the
     * merchant receives no funds. A `Tender` object with a type of `SQUARE_GIFT_CARD` indicates a
     * gift card was used for some or all of the associated payment.
     * @return Returns the V1Tender
     */
    @JsonGetter("tender")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Tender getTender() {
        return tender;
    }

    /**
     * Getter for OrderHistory.
     * The history of actions associated with the order.
     * @return Returns the List of V1OrderHistoryEntry
     */
    @JsonGetter("order_history")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<V1OrderHistoryEntry> getOrderHistory() {
        return orderHistory;
    }

    /**
     * Getter for PromoCode.
     * The promo code provided by the buyer, if any.
     * @return Returns the String
     */
    @JsonGetter("promo_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPromoCode() {
        return promoCode;
    }

    /**
     * Getter for BtcReceiveAddress.
     * For Bitcoin transactions, the address that the buyer sent Bitcoin to.
     * @return Returns the String
     */
    @JsonGetter("btc_receive_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBtcReceiveAddress() {
        return btcReceiveAddress;
    }

    /**
     * Getter for BtcPriceSatoshi.
     * For Bitcoin transactions, the price of the buyer's order in satoshi (100 million satoshi
     * equals 1 BTC).
     * @return Returns the Double
     */
    @JsonGetter("btc_price_satoshi")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Double getBtcPriceSatoshi() {
        return btcPriceSatoshi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, id, buyerEmail, recipientName, recipientPhoneNumber, state,
                shippingAddress, subtotalMoney, totalShippingMoney, totalTaxMoney, totalPriceMoney,
                totalDiscountMoney, createdAt, updatedAt, expiresAt, paymentId, buyerNote,
                completedNote, refundedNote, canceledNote, tender, orderHistory, promoCode,
                btcReceiveAddress, btcPriceSatoshi);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1Order)) {
            return false;
        }
        V1Order other = (V1Order) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(id, other.id)
            && Objects.equals(buyerEmail, other.buyerEmail)
            && Objects.equals(recipientName, other.recipientName)
            && Objects.equals(recipientPhoneNumber, other.recipientPhoneNumber)
            && Objects.equals(state, other.state)
            && Objects.equals(shippingAddress, other.shippingAddress)
            && Objects.equals(subtotalMoney, other.subtotalMoney)
            && Objects.equals(totalShippingMoney, other.totalShippingMoney)
            && Objects.equals(totalTaxMoney, other.totalTaxMoney)
            && Objects.equals(totalPriceMoney, other.totalPriceMoney)
            && Objects.equals(totalDiscountMoney, other.totalDiscountMoney)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(expiresAt, other.expiresAt)
            && Objects.equals(paymentId, other.paymentId)
            && Objects.equals(buyerNote, other.buyerNote)
            && Objects.equals(completedNote, other.completedNote)
            && Objects.equals(refundedNote, other.refundedNote)
            && Objects.equals(canceledNote, other.canceledNote)
            && Objects.equals(tender, other.tender)
            && Objects.equals(orderHistory, other.orderHistory)
            && Objects.equals(promoCode, other.promoCode)
            && Objects.equals(btcReceiveAddress, other.btcReceiveAddress)
            && Objects.equals(btcPriceSatoshi, other.btcPriceSatoshi);
    }

    /**
     * Converts this V1Order into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1Order [" + "errors=" + errors + ", id=" + id + ", buyerEmail=" + buyerEmail
                + ", recipientName=" + recipientName + ", recipientPhoneNumber="
                + recipientPhoneNumber + ", state=" + state + ", shippingAddress=" + shippingAddress
                + ", subtotalMoney=" + subtotalMoney + ", totalShippingMoney=" + totalShippingMoney
                + ", totalTaxMoney=" + totalTaxMoney + ", totalPriceMoney=" + totalPriceMoney
                + ", totalDiscountMoney=" + totalDiscountMoney + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + ", expiresAt=" + expiresAt + ", paymentId="
                + paymentId + ", buyerNote=" + buyerNote + ", completedNote=" + completedNote
                + ", refundedNote=" + refundedNote + ", canceledNote=" + canceledNote + ", tender="
                + tender + ", orderHistory=" + orderHistory + ", promoCode=" + promoCode
                + ", btcReceiveAddress=" + btcReceiveAddress + ", btcPriceSatoshi="
                + btcPriceSatoshi + "]";
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
     * Class to build instances of {@link V1Order}.
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
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

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
         * Setter for buyerEmail.
         * @param  buyerEmail  String value for buyerEmail.
         * @return Builder
         */
        public Builder buyerEmail(String buyerEmail) {
            this.buyerEmail = buyerEmail;
            return this;
        }

        /**
         * Setter for recipientName.
         * @param  recipientName  String value for recipientName.
         * @return Builder
         */
        public Builder recipientName(String recipientName) {
            this.recipientName = recipientName;
            return this;
        }

        /**
         * Setter for recipientPhoneNumber.
         * @param  recipientPhoneNumber  String value for recipientPhoneNumber.
         * @return Builder
         */
        public Builder recipientPhoneNumber(String recipientPhoneNumber) {
            this.recipientPhoneNumber = recipientPhoneNumber;
            return this;
        }

        /**
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
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
         * Setter for subtotalMoney.
         * @param  subtotalMoney  V1Money value for subtotalMoney.
         * @return Builder
         */
        public Builder subtotalMoney(V1Money subtotalMoney) {
            this.subtotalMoney = subtotalMoney;
            return this;
        }

        /**
         * Setter for totalShippingMoney.
         * @param  totalShippingMoney  V1Money value for totalShippingMoney.
         * @return Builder
         */
        public Builder totalShippingMoney(V1Money totalShippingMoney) {
            this.totalShippingMoney = totalShippingMoney;
            return this;
        }

        /**
         * Setter for totalTaxMoney.
         * @param  totalTaxMoney  V1Money value for totalTaxMoney.
         * @return Builder
         */
        public Builder totalTaxMoney(V1Money totalTaxMoney) {
            this.totalTaxMoney = totalTaxMoney;
            return this;
        }

        /**
         * Setter for totalPriceMoney.
         * @param  totalPriceMoney  V1Money value for totalPriceMoney.
         * @return Builder
         */
        public Builder totalPriceMoney(V1Money totalPriceMoney) {
            this.totalPriceMoney = totalPriceMoney;
            return this;
        }

        /**
         * Setter for totalDiscountMoney.
         * @param  totalDiscountMoney  V1Money value for totalDiscountMoney.
         * @return Builder
         */
        public Builder totalDiscountMoney(V1Money totalDiscountMoney) {
            this.totalDiscountMoney = totalDiscountMoney;
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
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for expiresAt.
         * @param  expiresAt  String value for expiresAt.
         * @return Builder
         */
        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        /**
         * Setter for buyerNote.
         * @param  buyerNote  String value for buyerNote.
         * @return Builder
         */
        public Builder buyerNote(String buyerNote) {
            this.buyerNote = buyerNote;
            return this;
        }

        /**
         * Setter for completedNote.
         * @param  completedNote  String value for completedNote.
         * @return Builder
         */
        public Builder completedNote(String completedNote) {
            this.completedNote = completedNote;
            return this;
        }

        /**
         * Setter for refundedNote.
         * @param  refundedNote  String value for refundedNote.
         * @return Builder
         */
        public Builder refundedNote(String refundedNote) {
            this.refundedNote = refundedNote;
            return this;
        }

        /**
         * Setter for canceledNote.
         * @param  canceledNote  String value for canceledNote.
         * @return Builder
         */
        public Builder canceledNote(String canceledNote) {
            this.canceledNote = canceledNote;
            return this;
        }

        /**
         * Setter for tender.
         * @param  tender  V1Tender value for tender.
         * @return Builder
         */
        public Builder tender(V1Tender tender) {
            this.tender = tender;
            return this;
        }

        /**
         * Setter for orderHistory.
         * @param  orderHistory  List of V1OrderHistoryEntry value for orderHistory.
         * @return Builder
         */
        public Builder orderHistory(List<V1OrderHistoryEntry> orderHistory) {
            this.orderHistory = orderHistory;
            return this;
        }

        /**
         * Setter for promoCode.
         * @param  promoCode  String value for promoCode.
         * @return Builder
         */
        public Builder promoCode(String promoCode) {
            this.promoCode = promoCode;
            return this;
        }

        /**
         * Setter for btcReceiveAddress.
         * @param  btcReceiveAddress  String value for btcReceiveAddress.
         * @return Builder
         */
        public Builder btcReceiveAddress(String btcReceiveAddress) {
            this.btcReceiveAddress = btcReceiveAddress;
            return this;
        }

        /**
         * Setter for btcPriceSatoshi.
         * @param  btcPriceSatoshi  Double value for btcPriceSatoshi.
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
            V1Order model =
                    new V1Order(errors, id, buyerEmail, recipientName, recipientPhoneNumber, state,
                            shippingAddress, subtotalMoney, totalShippingMoney, totalTaxMoney,
                            totalPriceMoney, totalDiscountMoney, createdAt, updatedAt, expiresAt,
                            paymentId, buyerNote, completedNote, refundedNote, canceledNote, tender,
                            orderHistory, promoCode, btcReceiveAddress, btcPriceSatoshi);
            model.httpContext = httpContext;
            return model;
        }
    }
}
