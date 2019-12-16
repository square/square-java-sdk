package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Payment {

    @JsonCreator
    public Payment(
            @JsonProperty("id") String id,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("tip_money") Money tipMoney,
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("processing_fee") List<ProcessingFee> processingFee,
            @JsonProperty("refunded_money") Money refundedMoney,
            @JsonProperty("status") String status,
            @JsonProperty("source_type") String sourceType,
            @JsonProperty("card_details") CardPaymentDetails cardDetails,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("refund_ids") List<String> refundIds,
            @JsonProperty("buyer_email_address") String buyerEmailAddress,
            @JsonProperty("billing_address") Address billingAddress,
            @JsonProperty("shipping_address") Address shippingAddress,
            @JsonProperty("note") String note,
            @JsonProperty("statement_description_identifier") String statementDescriptionIdentifier,
            @JsonProperty("receipt_number") String receiptNumber,
            @JsonProperty("receipt_url") String receiptUrl) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.amountMoney = amountMoney;
        this.tipMoney = tipMoney;
        this.totalMoney = totalMoney;
        this.appFeeMoney = appFeeMoney;
        this.processingFee = processingFee;
        this.refundedMoney = refundedMoney;
        this.status = status;
        this.sourceType = sourceType;
        this.cardDetails = cardDetails;
        this.locationId = locationId;
        this.orderId = orderId;
        this.referenceId = referenceId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.refundIds = refundIds;
        this.buyerEmailAddress = buyerEmailAddress;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.note = note;
        this.statementDescriptionIdentifier = statementDescriptionIdentifier;
        this.receiptNumber = receiptNumber;
        this.receiptUrl = receiptUrl;
    }

    private final String id;
    private final String createdAt;
    private final String updatedAt;
    private final Money amountMoney;
    private final Money tipMoney;
    private final Money totalMoney;
    private final Money appFeeMoney;
    private final List<ProcessingFee> processingFee;
    private final Money refundedMoney;
    private final String status;
    private final String sourceType;
    private final CardPaymentDetails cardDetails;
    private final String locationId;
    private final String orderId;
    private final String referenceId;
    private final String customerId;
    private final String employeeId;
    private final List<String> refundIds;
    private final String buyerEmailAddress;
    private final Address billingAddress;
    private final Address shippingAddress;
    private final String note;
    private final String statementDescriptionIdentifier;
    private final String receiptNumber;
    private final String receiptUrl;

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, amountMoney, tipMoney, totalMoney, appFeeMoney, processingFee, refundedMoney, status, sourceType, cardDetails, locationId, orderId, referenceId, customerId, employeeId, refundIds, buyerEmailAddress, billingAddress, shippingAddress, note, statementDescriptionIdentifier, receiptNumber, receiptUrl);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Payment)) {
            return false;
        }
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) &&
            Objects.equals(createdAt, payment.createdAt) &&
            Objects.equals(updatedAt, payment.updatedAt) &&
            Objects.equals(amountMoney, payment.amountMoney) &&
            Objects.equals(tipMoney, payment.tipMoney) &&
            Objects.equals(totalMoney, payment.totalMoney) &&
            Objects.equals(appFeeMoney, payment.appFeeMoney) &&
            Objects.equals(processingFee, payment.processingFee) &&
            Objects.equals(refundedMoney, payment.refundedMoney) &&
            Objects.equals(status, payment.status) &&
            Objects.equals(sourceType, payment.sourceType) &&
            Objects.equals(cardDetails, payment.cardDetails) &&
            Objects.equals(locationId, payment.locationId) &&
            Objects.equals(orderId, payment.orderId) &&
            Objects.equals(referenceId, payment.referenceId) &&
            Objects.equals(customerId, payment.customerId) &&
            Objects.equals(employeeId, payment.employeeId) &&
            Objects.equals(refundIds, payment.refundIds) &&
            Objects.equals(buyerEmailAddress, payment.buyerEmailAddress) &&
            Objects.equals(billingAddress, payment.billingAddress) &&
            Objects.equals(shippingAddress, payment.shippingAddress) &&
            Objects.equals(note, payment.note) &&
            Objects.equals(statementDescriptionIdentifier, payment.statementDescriptionIdentifier) &&
            Objects.equals(receiptNumber, payment.receiptNumber) &&
            Objects.equals(receiptUrl, payment.receiptUrl);
    }

    /**
     * Getter for Id.
     * Unique ID for the payment.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for CreatedAt.
     * Timestamp of when the payment was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * Timestamp of when the payment was last updated, in RFC 3339 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() { 
        return this.updatedAt;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() { 
        return this.amountMoney;
    }

    /**
     * Getter for TipMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("tip_money")
    public Money getTipMoney() { 
        return this.tipMoney;
    }

    /**
     * Getter for TotalMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("total_money")
    public Money getTotalMoney() { 
        return this.totalMoney;
    }

    /**
     * Getter for AppFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("app_fee_money")
    public Money getAppFeeMoney() { 
        return this.appFeeMoney;
    }

    /**
     * Getter for ProcessingFee.
     * Processing fees and fee adjustments assessed by Square on this payment.
     */
    @JsonGetter("processing_fee")
    public List<ProcessingFee> getProcessingFee() { 
        return this.processingFee;
    }

    /**
     * Getter for RefundedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("refunded_money")
    public Money getRefundedMoney() { 
        return this.refundedMoney;
    }

    /**
     * Getter for Status.
     * Indicates whether the payment is `APPROVED`, `COMPLETED`, `CANCELED`, or `FAILED`.
     */
    @JsonGetter("status")
    public String getStatus() { 
        return this.status;
    }

    /**
     * Getter for SourceType.
     * The source type for this payment
     * Current values include:
     * `CARD`
     */
    @JsonGetter("source_type")
    public String getSourceType() { 
        return this.sourceType;
    }

    /**
     * Getter for CardDetails.
     * Reflects the current status of a card payment.
     */
    @JsonGetter("card_details")
    public CardPaymentDetails getCardDetails() { 
        return this.cardDetails;
    }

    /**
     * Getter for LocationId.
     * ID of the location associated with the payment.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for OrderId.
     * ID of the order associated with this payment.
     */
    @JsonGetter("order_id")
    public String getOrderId() { 
        return this.orderId;
    }

    /**
     * Getter for ReferenceId.
     * An optional ID that associates this payment with an entity in
     * another system.
     */
    @JsonGetter("reference_id")
    public String getReferenceId() { 
        return this.referenceId;
    }

    /**
     * Getter for CustomerId.
     * An optional customer_id to be entered by the developer when creating a payment.
     */
    @JsonGetter("customer_id")
    public String getCustomerId() { 
        return this.customerId;
    }

    /**
     * Getter for EmployeeId.
     * An optional ID of the employee associated with taking this payment.
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() { 
        return this.employeeId;
    }

    /**
     * Getter for RefundIds.
     * List of `refund_id`s identifying refunds for this payment.
     */
    @JsonGetter("refund_ids")
    public List<String> getRefundIds() { 
        return this.refundIds;
    }

    /**
     * Getter for BuyerEmailAddress.
     * The buyer's e-mail address
     */
    @JsonGetter("buyer_email_address")
    public String getBuyerEmailAddress() { 
        return this.buyerEmailAddress;
    }

    /**
     * Getter for BillingAddress.
     * Represents a physical address.
     */
    @JsonGetter("billing_address")
    public Address getBillingAddress() { 
        return this.billingAddress;
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
     * Getter for Note.
     * An optional note to include when creating a payment
     */
    @JsonGetter("note")
    public String getNote() { 
        return this.note;
    }

    /**
     * Getter for StatementDescriptionIdentifier.
     * Additional payment information that gets added on the customer's card statement
     * as part of the statement description.
     * Note that the statement_description_identifier may get truncated on the statement description
     * to fit the required information including the Square identifier (SQ *) and name of the
     * merchant taking the payment.
     */
    @JsonGetter("statement_description_identifier")
    public String getStatementDescriptionIdentifier() { 
        return this.statementDescriptionIdentifier;
    }

    /**
     * Getter for ReceiptNumber.
     * The payment's receipt number.
     * The field will be missing if a payment is CANCELED
     */
    @JsonGetter("receipt_number")
    public String getReceiptNumber() { 
        return this.receiptNumber;
    }

    /**
     * Getter for ReceiptUrl.
     * The URL for the payment's receipt.
     * The field will only be populated for COMPLETED payments.
     */
    @JsonGetter("receipt_url")
    public String getReceiptUrl() { 
        return this.receiptUrl;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt())
            .amountMoney(getAmountMoney())
            .tipMoney(getTipMoney())
            .totalMoney(getTotalMoney())
            .appFeeMoney(getAppFeeMoney())
            .processingFee(getProcessingFee())
            .refundedMoney(getRefundedMoney())
            .status(getStatus())
            .sourceType(getSourceType())
            .cardDetails(getCardDetails())
            .locationId(getLocationId())
            .orderId(getOrderId())
            .referenceId(getReferenceId())
            .customerId(getCustomerId())
            .employeeId(getEmployeeId())
            .refundIds(getRefundIds())
            .buyerEmailAddress(getBuyerEmailAddress())
            .billingAddress(getBillingAddress())
            .shippingAddress(getShippingAddress())
            .note(getNote())
            .statementDescriptionIdentifier(getStatementDescriptionIdentifier())
            .receiptNumber(getReceiptNumber())
            .receiptUrl(getReceiptUrl());
            return builder;
    }

    public static class Builder {
        private String id;
        private String createdAt;
        private String updatedAt;
        private Money amountMoney;
        private Money tipMoney;
        private Money totalMoney;
        private Money appFeeMoney;
        private List<ProcessingFee> processingFee;
        private Money refundedMoney;
        private String status;
        private String sourceType;
        private CardPaymentDetails cardDetails;
        private String locationId;
        private String orderId;
        private String referenceId;
        private String customerId;
        private String employeeId;
        private List<String> refundIds;
        private String buyerEmailAddress;
        private Address billingAddress;
        private Address shippingAddress;
        private String note;
        private String statementDescriptionIdentifier;
        private String receiptNumber;
        private String receiptUrl;

        public Builder() { }

        public Builder id(String value) {
            id = value;
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
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder tipMoney(Money value) {
            tipMoney = value;
            return this;
        }
        public Builder totalMoney(Money value) {
            totalMoney = value;
            return this;
        }
        public Builder appFeeMoney(Money value) {
            appFeeMoney = value;
            return this;
        }
        public Builder processingFee(List<ProcessingFee> value) {
            processingFee = value;
            return this;
        }
        public Builder refundedMoney(Money value) {
            refundedMoney = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder sourceType(String value) {
            sourceType = value;
            return this;
        }
        public Builder cardDetails(CardPaymentDetails value) {
            cardDetails = value;
            return this;
        }
        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder orderId(String value) {
            orderId = value;
            return this;
        }
        public Builder referenceId(String value) {
            referenceId = value;
            return this;
        }
        public Builder customerId(String value) {
            customerId = value;
            return this;
        }
        public Builder employeeId(String value) {
            employeeId = value;
            return this;
        }
        public Builder refundIds(List<String> value) {
            refundIds = value;
            return this;
        }
        public Builder buyerEmailAddress(String value) {
            buyerEmailAddress = value;
            return this;
        }
        public Builder billingAddress(Address value) {
            billingAddress = value;
            return this;
        }
        public Builder shippingAddress(Address value) {
            shippingAddress = value;
            return this;
        }
        public Builder note(String value) {
            note = value;
            return this;
        }
        public Builder statementDescriptionIdentifier(String value) {
            statementDescriptionIdentifier = value;
            return this;
        }
        public Builder receiptNumber(String value) {
            receiptNumber = value;
            return this;
        }
        public Builder receiptUrl(String value) {
            receiptUrl = value;
            return this;
        }

        public Payment build() {
            return new Payment(id,
                createdAt,
                updatedAt,
                amountMoney,
                tipMoney,
                totalMoney,
                appFeeMoney,
                processingFee,
                refundedMoney,
                status,
                sourceType,
                cardDetails,
                locationId,
                orderId,
                referenceId,
                customerId,
                employeeId,
                refundIds,
                buyerEmailAddress,
                billingAddress,
                shippingAddress,
                note,
                statementDescriptionIdentifier,
                receiptNumber,
                receiptUrl);
        }
    }
}
