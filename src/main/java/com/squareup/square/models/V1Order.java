
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.squareup.square.http.client.HttpContext;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1Order type.
 */
public class V1Order {
    private HttpContext httpContext;
    private final OptionalNullable<List<Error>> errors;
    private final String id;
    private final OptionalNullable<String> buyerEmail;
    private final OptionalNullable<String> recipientName;
    private final OptionalNullable<String> recipientPhoneNumber;
    private final String state;
    private final Address shippingAddress;
    private final V1Money subtotalMoney;
    private final V1Money totalShippingMoney;
    private final V1Money totalTaxMoney;
    private final V1Money totalPriceMoney;
    private final V1Money totalDiscountMoney;
    private final String createdAt;
    private final String updatedAt;
    private final OptionalNullable<String> expiresAt;
    private final OptionalNullable<String> paymentId;
    private final OptionalNullable<String> buyerNote;
    private final OptionalNullable<String> completedNote;
    private final OptionalNullable<String> refundedNote;
    private final OptionalNullable<String> canceledNote;
    private final V1Tender tender;
    private final OptionalNullable<List<V1OrderHistoryEntry>> orderHistory;
    private final OptionalNullable<String> promoCode;
    private final OptionalNullable<String> btcReceiveAddress;
    private final OptionalNullable<Double> btcPriceSatoshi;

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
        this.errors = OptionalNullable.of(errors);
        this.id = id;
        this.buyerEmail = OptionalNullable.of(buyerEmail);
        this.recipientName = OptionalNullable.of(recipientName);
        this.recipientPhoneNumber = OptionalNullable.of(recipientPhoneNumber);
        this.state = state;
        this.shippingAddress = shippingAddress;
        this.subtotalMoney = subtotalMoney;
        this.totalShippingMoney = totalShippingMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.totalPriceMoney = totalPriceMoney;
        this.totalDiscountMoney = totalDiscountMoney;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.expiresAt = OptionalNullable.of(expiresAt);
        this.paymentId = OptionalNullable.of(paymentId);
        this.buyerNote = OptionalNullable.of(buyerNote);
        this.completedNote = OptionalNullable.of(completedNote);
        this.refundedNote = OptionalNullable.of(refundedNote);
        this.canceledNote = OptionalNullable.of(canceledNote);
        this.tender = tender;
        this.orderHistory = OptionalNullable.of(orderHistory);
        this.promoCode = OptionalNullable.of(promoCode);
        this.btcReceiveAddress = OptionalNullable.of(btcReceiveAddress);
        this.btcPriceSatoshi = OptionalNullable.of(btcPriceSatoshi);
    }

    /**
     * Internal initialization constructor.
     */
    protected V1Order(OptionalNullable<List<Error>> errors, String id,
            OptionalNullable<String> buyerEmail, OptionalNullable<String> recipientName,
            OptionalNullable<String> recipientPhoneNumber, String state, Address shippingAddress,
            V1Money subtotalMoney, V1Money totalShippingMoney, V1Money totalTaxMoney,
            V1Money totalPriceMoney, V1Money totalDiscountMoney, String createdAt, String updatedAt,
            OptionalNullable<String> expiresAt, OptionalNullable<String> paymentId,
            OptionalNullable<String> buyerNote, OptionalNullable<String> completedNote,
            OptionalNullable<String> refundedNote, OptionalNullable<String> canceledNote,
            V1Tender tender, OptionalNullable<List<V1OrderHistoryEntry>> orderHistory,
            OptionalNullable<String> promoCode, OptionalNullable<String> btcReceiveAddress,
            OptionalNullable<Double> btcPriceSatoshi) {
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
     * Internal Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the Internal List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Error>> internalGetErrors() {
        return this.errors;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonIgnore
    public List<Error> getErrors() {
        return OptionalNullable.getFrom(errors);
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
     * Internal Getter for BuyerEmail.
     * The email address of the order's buyer.
     * @return Returns the Internal String
     */
    @JsonGetter("buyer_email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBuyerEmail() {
        return this.buyerEmail;
    }

    /**
     * Getter for BuyerEmail.
     * The email address of the order's buyer.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBuyerEmail() {
        return OptionalNullable.getFrom(buyerEmail);
    }

    /**
     * Internal Getter for RecipientName.
     * The name of the order's buyer.
     * @return Returns the Internal String
     */
    @JsonGetter("recipient_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetRecipientName() {
        return this.recipientName;
    }

    /**
     * Getter for RecipientName.
     * The name of the order's buyer.
     * @return Returns the String
     */
    @JsonIgnore
    public String getRecipientName() {
        return OptionalNullable.getFrom(recipientName);
    }

    /**
     * Internal Getter for RecipientPhoneNumber.
     * The phone number to use for the order's delivery.
     * @return Returns the Internal String
     */
    @JsonGetter("recipient_phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetRecipientPhoneNumber() {
        return this.recipientPhoneNumber;
    }

    /**
     * Getter for RecipientPhoneNumber.
     * The phone number to use for the order's delivery.
     * @return Returns the String
     */
    @JsonIgnore
    public String getRecipientPhoneNumber() {
        return OptionalNullable.getFrom(recipientPhoneNumber);
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
     * Internal Getter for ExpiresAt.
     * The time when the order expires if no action is taken, in ISO 8601 format.
     * @return Returns the Internal String
     */
    @JsonGetter("expires_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetExpiresAt() {
        return this.expiresAt;
    }

    /**
     * Getter for ExpiresAt.
     * The time when the order expires if no action is taken, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getExpiresAt() {
        return OptionalNullable.getFrom(expiresAt);
    }

    /**
     * Internal Getter for PaymentId.
     * The unique identifier of the payment associated with the order.
     * @return Returns the Internal String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPaymentId() {
        return this.paymentId;
    }

    /**
     * Getter for PaymentId.
     * The unique identifier of the payment associated with the order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPaymentId() {
        return OptionalNullable.getFrom(paymentId);
    }

    /**
     * Internal Getter for BuyerNote.
     * A note provided by the buyer when the order was created, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("buyer_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBuyerNote() {
        return this.buyerNote;
    }

    /**
     * Getter for BuyerNote.
     * A note provided by the buyer when the order was created, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBuyerNote() {
        return OptionalNullable.getFrom(buyerNote);
    }

    /**
     * Internal Getter for CompletedNote.
     * A note provided by the merchant when the order's state was set to COMPLETED, if any
     * @return Returns the Internal String
     */
    @JsonGetter("completed_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCompletedNote() {
        return this.completedNote;
    }

    /**
     * Getter for CompletedNote.
     * A note provided by the merchant when the order's state was set to COMPLETED, if any
     * @return Returns the String
     */
    @JsonIgnore
    public String getCompletedNote() {
        return OptionalNullable.getFrom(completedNote);
    }

    /**
     * Internal Getter for RefundedNote.
     * A note provided by the merchant when the order's state was set to REFUNDED, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("refunded_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetRefundedNote() {
        return this.refundedNote;
    }

    /**
     * Getter for RefundedNote.
     * A note provided by the merchant when the order's state was set to REFUNDED, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getRefundedNote() {
        return OptionalNullable.getFrom(refundedNote);
    }

    /**
     * Internal Getter for CanceledNote.
     * A note provided by the merchant when the order's state was set to CANCELED, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("canceled_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCanceledNote() {
        return this.canceledNote;
    }

    /**
     * Getter for CanceledNote.
     * A note provided by the merchant when the order's state was set to CANCELED, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCanceledNote() {
        return OptionalNullable.getFrom(canceledNote);
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
     * Internal Getter for OrderHistory.
     * The history of actions associated with the order.
     * @return Returns the Internal List of V1OrderHistoryEntry
     */
    @JsonGetter("order_history")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<V1OrderHistoryEntry>> internalGetOrderHistory() {
        return this.orderHistory;
    }

    /**
     * Getter for OrderHistory.
     * The history of actions associated with the order.
     * @return Returns the List of V1OrderHistoryEntry
     */
    @JsonIgnore
    public List<V1OrderHistoryEntry> getOrderHistory() {
        return OptionalNullable.getFrom(orderHistory);
    }

    /**
     * Internal Getter for PromoCode.
     * The promo code provided by the buyer, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("promo_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPromoCode() {
        return this.promoCode;
    }

    /**
     * Getter for PromoCode.
     * The promo code provided by the buyer, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPromoCode() {
        return OptionalNullable.getFrom(promoCode);
    }

    /**
     * Internal Getter for BtcReceiveAddress.
     * For Bitcoin transactions, the address that the buyer sent Bitcoin to.
     * @return Returns the Internal String
     */
    @JsonGetter("btc_receive_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBtcReceiveAddress() {
        return this.btcReceiveAddress;
    }

    /**
     * Getter for BtcReceiveAddress.
     * For Bitcoin transactions, the address that the buyer sent Bitcoin to.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBtcReceiveAddress() {
        return OptionalNullable.getFrom(btcReceiveAddress);
    }

    /**
     * Internal Getter for BtcPriceSatoshi.
     * For Bitcoin transactions, the price of the buyer's order in satoshi (100 million satoshi
     * equals 1 BTC).
     * @return Returns the Internal Double
     */
    @JsonGetter("btc_price_satoshi")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Double> internalGetBtcPriceSatoshi() {
        return this.btcPriceSatoshi;
    }

    /**
     * Getter for BtcPriceSatoshi.
     * For Bitcoin transactions, the price of the buyer's order in satoshi (100 million satoshi
     * equals 1 BTC).
     * @return Returns the Double
     */
    @JsonIgnore
    public Double getBtcPriceSatoshi() {
        return OptionalNullable.getFrom(btcPriceSatoshi);
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
                .id(getId())
                .state(getState())
                .shippingAddress(getShippingAddress())
                .subtotalMoney(getSubtotalMoney())
                .totalShippingMoney(getTotalShippingMoney())
                .totalTaxMoney(getTotalTaxMoney())
                .totalPriceMoney(getTotalPriceMoney())
                .totalDiscountMoney(getTotalDiscountMoney())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .tender(getTender());
        builder.errors = internalGetErrors();
        builder.buyerEmail = internalGetBuyerEmail();
        builder.recipientName = internalGetRecipientName();
        builder.recipientPhoneNumber = internalGetRecipientPhoneNumber();
        builder.expiresAt = internalGetExpiresAt();
        builder.paymentId = internalGetPaymentId();
        builder.buyerNote = internalGetBuyerNote();
        builder.completedNote = internalGetCompletedNote();
        builder.refundedNote = internalGetRefundedNote();
        builder.canceledNote = internalGetCanceledNote();
        builder.orderHistory = internalGetOrderHistory();
        builder.promoCode = internalGetPromoCode();
        builder.btcReceiveAddress = internalGetBtcReceiveAddress();
        builder.btcPriceSatoshi = internalGetBtcPriceSatoshi();
        return builder;
    }

    /**
     * Class to build instances of {@link V1Order}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private OptionalNullable<List<Error>> errors;
        private String id;
        private OptionalNullable<String> buyerEmail;
        private OptionalNullable<String> recipientName;
        private OptionalNullable<String> recipientPhoneNumber;
        private String state;
        private Address shippingAddress;
        private V1Money subtotalMoney;
        private V1Money totalShippingMoney;
        private V1Money totalTaxMoney;
        private V1Money totalPriceMoney;
        private V1Money totalDiscountMoney;
        private String createdAt;
        private String updatedAt;
        private OptionalNullable<String> expiresAt;
        private OptionalNullable<String> paymentId;
        private OptionalNullable<String> buyerNote;
        private OptionalNullable<String> completedNote;
        private OptionalNullable<String> refundedNote;
        private OptionalNullable<String> canceledNote;
        private V1Tender tender;
        private OptionalNullable<List<V1OrderHistoryEntry>> orderHistory;
        private OptionalNullable<String> promoCode;
        private OptionalNullable<String> btcReceiveAddress;
        private OptionalNullable<Double> btcPriceSatoshi;



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
            this.errors = OptionalNullable.of(errors);
            return this;
        }

        /**
         * UnSetter for errors.
         * @return Builder
         */
        public Builder unsetErrors() {
            errors = null;
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
            this.buyerEmail = OptionalNullable.of(buyerEmail);
            return this;
        }

        /**
         * UnSetter for buyerEmail.
         * @return Builder
         */
        public Builder unsetBuyerEmail() {
            buyerEmail = null;
            return this;
        }

        /**
         * Setter for recipientName.
         * @param  recipientName  String value for recipientName.
         * @return Builder
         */
        public Builder recipientName(String recipientName) {
            this.recipientName = OptionalNullable.of(recipientName);
            return this;
        }

        /**
         * UnSetter for recipientName.
         * @return Builder
         */
        public Builder unsetRecipientName() {
            recipientName = null;
            return this;
        }

        /**
         * Setter for recipientPhoneNumber.
         * @param  recipientPhoneNumber  String value for recipientPhoneNumber.
         * @return Builder
         */
        public Builder recipientPhoneNumber(String recipientPhoneNumber) {
            this.recipientPhoneNumber = OptionalNullable.of(recipientPhoneNumber);
            return this;
        }

        /**
         * UnSetter for recipientPhoneNumber.
         * @return Builder
         */
        public Builder unsetRecipientPhoneNumber() {
            recipientPhoneNumber = null;
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
            this.expiresAt = OptionalNullable.of(expiresAt);
            return this;
        }

        /**
         * UnSetter for expiresAt.
         * @return Builder
         */
        public Builder unsetExpiresAt() {
            expiresAt = null;
            return this;
        }

        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = OptionalNullable.of(paymentId);
            return this;
        }

        /**
         * UnSetter for paymentId.
         * @return Builder
         */
        public Builder unsetPaymentId() {
            paymentId = null;
            return this;
        }

        /**
         * Setter for buyerNote.
         * @param  buyerNote  String value for buyerNote.
         * @return Builder
         */
        public Builder buyerNote(String buyerNote) {
            this.buyerNote = OptionalNullable.of(buyerNote);
            return this;
        }

        /**
         * UnSetter for buyerNote.
         * @return Builder
         */
        public Builder unsetBuyerNote() {
            buyerNote = null;
            return this;
        }

        /**
         * Setter for completedNote.
         * @param  completedNote  String value for completedNote.
         * @return Builder
         */
        public Builder completedNote(String completedNote) {
            this.completedNote = OptionalNullable.of(completedNote);
            return this;
        }

        /**
         * UnSetter for completedNote.
         * @return Builder
         */
        public Builder unsetCompletedNote() {
            completedNote = null;
            return this;
        }

        /**
         * Setter for refundedNote.
         * @param  refundedNote  String value for refundedNote.
         * @return Builder
         */
        public Builder refundedNote(String refundedNote) {
            this.refundedNote = OptionalNullable.of(refundedNote);
            return this;
        }

        /**
         * UnSetter for refundedNote.
         * @return Builder
         */
        public Builder unsetRefundedNote() {
            refundedNote = null;
            return this;
        }

        /**
         * Setter for canceledNote.
         * @param  canceledNote  String value for canceledNote.
         * @return Builder
         */
        public Builder canceledNote(String canceledNote) {
            this.canceledNote = OptionalNullable.of(canceledNote);
            return this;
        }

        /**
         * UnSetter for canceledNote.
         * @return Builder
         */
        public Builder unsetCanceledNote() {
            canceledNote = null;
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
            this.orderHistory = OptionalNullable.of(orderHistory);
            return this;
        }

        /**
         * UnSetter for orderHistory.
         * @return Builder
         */
        public Builder unsetOrderHistory() {
            orderHistory = null;
            return this;
        }

        /**
         * Setter for promoCode.
         * @param  promoCode  String value for promoCode.
         * @return Builder
         */
        public Builder promoCode(String promoCode) {
            this.promoCode = OptionalNullable.of(promoCode);
            return this;
        }

        /**
         * UnSetter for promoCode.
         * @return Builder
         */
        public Builder unsetPromoCode() {
            promoCode = null;
            return this;
        }

        /**
         * Setter for btcReceiveAddress.
         * @param  btcReceiveAddress  String value for btcReceiveAddress.
         * @return Builder
         */
        public Builder btcReceiveAddress(String btcReceiveAddress) {
            this.btcReceiveAddress = OptionalNullable.of(btcReceiveAddress);
            return this;
        }

        /**
         * UnSetter for btcReceiveAddress.
         * @return Builder
         */
        public Builder unsetBtcReceiveAddress() {
            btcReceiveAddress = null;
            return this;
        }

        /**
         * Setter for btcPriceSatoshi.
         * @param  btcPriceSatoshi  Double value for btcPriceSatoshi.
         * @return Builder
         */
        public Builder btcPriceSatoshi(Double btcPriceSatoshi) {
            this.btcPriceSatoshi = OptionalNullable.of(btcPriceSatoshi);
            return this;
        }

        /**
         * UnSetter for btcPriceSatoshi.
         * @return Builder
         */
        public Builder unsetBtcPriceSatoshi() {
            btcPriceSatoshi = null;
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
