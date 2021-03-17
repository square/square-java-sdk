
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Payment type.
 */
public class Payment {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money amountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money tipMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money totalMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money appFeeMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money approvedMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<ProcessingFee> processingFee;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money refundedMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String delayDuration;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String delayAction;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String delayedUntil;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sourceType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CardPaymentDetails cardDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CashPaymentDetails cashDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final ExternalPaymentDetails externalDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String orderId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String referenceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String employeeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> refundIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final RiskEvaluation riskEvaluation;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String buyerEmailAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address billingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address shippingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String note;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String statementDescriptionIdentifier;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> capabilities;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String receiptNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String receiptUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String versionToken;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  amountMoney  Money value for amountMoney.
     * @param  tipMoney  Money value for tipMoney.
     * @param  totalMoney  Money value for totalMoney.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  approvedMoney  Money value for approvedMoney.
     * @param  processingFee  List of ProcessingFee value for processingFee.
     * @param  refundedMoney  Money value for refundedMoney.
     * @param  status  String value for status.
     * @param  delayDuration  String value for delayDuration.
     * @param  delayAction  String value for delayAction.
     * @param  delayedUntil  String value for delayedUntil.
     * @param  sourceType  String value for sourceType.
     * @param  cardDetails  CardPaymentDetails value for cardDetails.
     * @param  cashDetails  CashPaymentDetails value for cashDetails.
     * @param  externalDetails  ExternalPaymentDetails value for externalDetails.
     * @param  locationId  String value for locationId.
     * @param  orderId  String value for orderId.
     * @param  referenceId  String value for referenceId.
     * @param  customerId  String value for customerId.
     * @param  employeeId  String value for employeeId.
     * @param  refundIds  List of String value for refundIds.
     * @param  riskEvaluation  RiskEvaluation value for riskEvaluation.
     * @param  buyerEmailAddress  String value for buyerEmailAddress.
     * @param  billingAddress  Address value for billingAddress.
     * @param  shippingAddress  Address value for shippingAddress.
     * @param  note  String value for note.
     * @param  statementDescriptionIdentifier  String value for statementDescriptionIdentifier.
     * @param  capabilities  List of String value for capabilities.
     * @param  receiptNumber  String value for receiptNumber.
     * @param  receiptUrl  String value for receiptUrl.
     * @param  versionToken  String value for versionToken.
     */
    @JsonCreator
    public Payment(
            @JsonProperty("id") String id,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("tip_money") Money tipMoney,
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("approved_money") Money approvedMoney,
            @JsonProperty("processing_fee") List<ProcessingFee> processingFee,
            @JsonProperty("refunded_money") Money refundedMoney,
            @JsonProperty("status") String status,
            @JsonProperty("delay_duration") String delayDuration,
            @JsonProperty("delay_action") String delayAction,
            @JsonProperty("delayed_until") String delayedUntil,
            @JsonProperty("source_type") String sourceType,
            @JsonProperty("card_details") CardPaymentDetails cardDetails,
            @JsonProperty("cash_details") CashPaymentDetails cashDetails,
            @JsonProperty("external_details") ExternalPaymentDetails externalDetails,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("refund_ids") List<String> refundIds,
            @JsonProperty("risk_evaluation") RiskEvaluation riskEvaluation,
            @JsonProperty("buyer_email_address") String buyerEmailAddress,
            @JsonProperty("billing_address") Address billingAddress,
            @JsonProperty("shipping_address") Address shippingAddress,
            @JsonProperty("note") String note,
            @JsonProperty("statement_description_identifier") String statementDescriptionIdentifier,
            @JsonProperty("capabilities") List<String> capabilities,
            @JsonProperty("receipt_number") String receiptNumber,
            @JsonProperty("receipt_url") String receiptUrl,
            @JsonProperty("version_token") String versionToken) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.amountMoney = amountMoney;
        this.tipMoney = tipMoney;
        this.totalMoney = totalMoney;
        this.appFeeMoney = appFeeMoney;
        this.approvedMoney = approvedMoney;
        this.processingFee = processingFee;
        this.refundedMoney = refundedMoney;
        this.status = status;
        this.delayDuration = delayDuration;
        this.delayAction = delayAction;
        this.delayedUntil = delayedUntil;
        this.sourceType = sourceType;
        this.cardDetails = cardDetails;
        this.cashDetails = cashDetails;
        this.externalDetails = externalDetails;
        this.locationId = locationId;
        this.orderId = orderId;
        this.referenceId = referenceId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.refundIds = refundIds;
        this.riskEvaluation = riskEvaluation;
        this.buyerEmailAddress = buyerEmailAddress;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.note = note;
        this.statementDescriptionIdentifier = statementDescriptionIdentifier;
        this.capabilities = capabilities;
        this.receiptNumber = receiptNumber;
        this.receiptUrl = receiptUrl;
        this.versionToken = versionToken;
    }

    /**
     * Getter for Id.
     * A unique ID for the payment.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp of when the payment was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp of when the payment was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for TipMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("tip_money")
    public Money getTipMoney() {
        return tipMoney;
    }

    /**
     * Getter for TotalMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_money")
    public Money getTotalMoney() {
        return totalMoney;
    }

    /**
     * Getter for AppFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("app_fee_money")
    public Money getAppFeeMoney() {
        return appFeeMoney;
    }

    /**
     * Getter for ApprovedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("approved_money")
    public Money getApprovedMoney() {
        return approvedMoney;
    }

    /**
     * Getter for ProcessingFee.
     * The processing fees and fee adjustments assessed by Square for this payment.
     * @return Returns the List of ProcessingFee
     */
    @JsonGetter("processing_fee")
    public List<ProcessingFee> getProcessingFee() {
        return processingFee;
    }

    /**
     * Getter for RefundedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("refunded_money")
    public Money getRefundedMoney() {
        return refundedMoney;
    }

    /**
     * Getter for Status.
     * Indicates whether the payment is APPROVED, COMPLETED, CANCELED, or FAILED.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    /**
     * Getter for DelayDuration.
     * The duration of time after the payment's creation when Square automatically applies the
     * `delay_action` to the payment. This automatic `delay_action` applies only to payments that do
     * not reach a terminal state (COMPLETED, CANCELED, or FAILED) before the `delay_duration` time
     * period. This field is specified as a time duration, in RFC 3339 format. Notes: This feature
     * is only supported for card payments. Default: - Card-present payments: "PT36H" (36 hours)
     * from the creation time. - Card-not-present payments: "P7D" (7 days) from the creation time.
     * @return Returns the String
     */
    @JsonGetter("delay_duration")
    public String getDelayDuration() {
        return delayDuration;
    }

    /**
     * Getter for DelayAction.
     * The action to be applied to the payment when the `delay_duration` has elapsed. This field is
     * read-only. Current values include `CANCEL`.
     * @return Returns the String
     */
    @JsonGetter("delay_action")
    public String getDelayAction() {
        return delayAction;
    }

    /**
     * Getter for DelayedUntil.
     * The read-only timestamp of when the `delay_action` is automatically applied, in RFC 3339
     * format. Note that this field is calculated by summing the payment's `delay_duration` and
     * `created_at` fields. The `created_at` field is generated by Square and might not exactly
     * match the time on your local machine.
     * @return Returns the String
     */
    @JsonGetter("delayed_until")
    public String getDelayedUntil() {
        return delayedUntil;
    }

    /**
     * Getter for SourceType.
     * The source type for this payment. Current values include `CARD`, `CASH`, or `EXTERNAL`.
     * @return Returns the String
     */
    @JsonGetter("source_type")
    public String getSourceType() {
        return sourceType;
    }

    /**
     * Getter for CardDetails.
     * Reflects the current status of a card payment. Contains only non-confidential information.
     * @return Returns the CardPaymentDetails
     */
    @JsonGetter("card_details")
    public CardPaymentDetails getCardDetails() {
        return cardDetails;
    }

    /**
     * Getter for CashDetails.
     * Stores details about a cash payment. Contains only non-confidential information. For more
     * information, see [Take Cash
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments/cash-payments).
     * @return Returns the CashPaymentDetails
     */
    @JsonGetter("cash_details")
    public CashPaymentDetails getCashDetails() {
        return cashDetails;
    }

    /**
     * Getter for ExternalDetails.
     * Stores details about an external payment. Contains only non-confidential information. For
     * more information, see [Take External
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments/external-payments).
     * @return Returns the ExternalPaymentDetails
     */
    @JsonGetter("external_details")
    public ExternalPaymentDetails getExternalDetails() {
        return externalDetails;
    }

    /**
     * Getter for LocationId.
     * The ID of the location associated with the payment.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for OrderId.
     * The ID of the order associated with the payment.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for ReferenceId.
     * An optional ID that associates the payment with an entity in another system.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for CustomerId.
     * The [Customer](#type-customer) ID of the customer associated with the payment.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for EmployeeId.
     * An optional ID of the employee associated with taking the payment.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Getter for RefundIds.
     * A list of `refund_id`s identifying refunds for the payment.
     * @return Returns the List of String
     */
    @JsonGetter("refund_ids")
    public List<String> getRefundIds() {
        return refundIds;
    }

    /**
     * Getter for RiskEvaluation.
     * Represents fraud risk information for the associated payment. When you take a payment through
     * Square's Payments API (using the `CreatePayment` endpoint), Square evaluates it and assigns a
     * risk level to the payment. Sellers can use this information to determine the course of action
     * (for example, provide the goods/services or refund the payment).
     * @return Returns the RiskEvaluation
     */
    @JsonGetter("risk_evaluation")
    public RiskEvaluation getRiskEvaluation() {
        return riskEvaluation;
    }

    /**
     * Getter for BuyerEmailAddress.
     * The buyer's email address.
     * @return Returns the String
     */
    @JsonGetter("buyer_email_address")
    public String getBuyerEmailAddress() {
        return buyerEmailAddress;
    }

    /**
     * Getter for BillingAddress.
     * Represents a physical address.
     * @return Returns the Address
     */
    @JsonGetter("billing_address")
    public Address getBillingAddress() {
        return billingAddress;
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
     * Getter for Note.
     * An optional note to include when creating a payment.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return note;
    }

    /**
     * Getter for StatementDescriptionIdentifier.
     * Additional payment information that gets added to the customer's card statement as part of
     * the statement description. Note that the `statement_description_identifier` might get
     * truncated on the statement description to fit the required information including the Square
     * identifier (SQ *) and the name of the seller taking the payment.
     * @return Returns the String
     */
    @JsonGetter("statement_description_identifier")
    public String getStatementDescriptionIdentifier() {
        return statementDescriptionIdentifier;
    }

    /**
     * Getter for Capabilities.
     * Actions that can be performed on this payment: - `EDIT_AMOUNT_UP` - The payment amount can be
     * edited up. - `EDIT_AMOUNT_DOWN` - The payment amount can be edited down. -
     * `EDIT_TIP_AMOUNT_UP` - The tip amount can be edited up. - `EDIT_TIP_AMOUNT_DOWN` - The tip
     * amount can be edited down.
     * @return Returns the List of String
     */
    @JsonGetter("capabilities")
    public List<String> getCapabilities() {
        return capabilities;
    }

    /**
     * Getter for ReceiptNumber.
     * The payment's receipt number. The field is missing if a payment is canceled.
     * @return Returns the String
     */
    @JsonGetter("receipt_number")
    public String getReceiptNumber() {
        return receiptNumber;
    }

    /**
     * Getter for ReceiptUrl.
     * The URL for the payment's receipt. The field is only populated for COMPLETED payments.
     * @return Returns the String
     */
    @JsonGetter("receipt_url")
    public String getReceiptUrl() {
        return receiptUrl;
    }

    /**
     * Getter for VersionToken.
     * Used for optimistic concurrency. This opaque token identifies a specific version of the
     * `Payment` object.
     * @return Returns the String
     */
    @JsonGetter("version_token")
    public String getVersionToken() {
        return versionToken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, amountMoney, tipMoney, totalMoney,
                appFeeMoney, approvedMoney, processingFee, refundedMoney, status, delayDuration,
                delayAction, delayedUntil, sourceType, cardDetails, cashDetails, externalDetails,
                locationId, orderId, referenceId, customerId, employeeId, refundIds, riskEvaluation,
                buyerEmailAddress, billingAddress, shippingAddress, note,
                statementDescriptionIdentifier, capabilities, receiptNumber, receiptUrl,
                versionToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(tipMoney, other.tipMoney)
            && Objects.equals(totalMoney, other.totalMoney)
            && Objects.equals(appFeeMoney, other.appFeeMoney)
            && Objects.equals(approvedMoney, other.approvedMoney)
            && Objects.equals(processingFee, other.processingFee)
            && Objects.equals(refundedMoney, other.refundedMoney)
            && Objects.equals(status, other.status)
            && Objects.equals(delayDuration, other.delayDuration)
            && Objects.equals(delayAction, other.delayAction)
            && Objects.equals(delayedUntil, other.delayedUntil)
            && Objects.equals(sourceType, other.sourceType)
            && Objects.equals(cardDetails, other.cardDetails)
            && Objects.equals(cashDetails, other.cashDetails)
            && Objects.equals(externalDetails, other.externalDetails)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(orderId, other.orderId)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(refundIds, other.refundIds)
            && Objects.equals(riskEvaluation, other.riskEvaluation)
            && Objects.equals(buyerEmailAddress, other.buyerEmailAddress)
            && Objects.equals(billingAddress, other.billingAddress)
            && Objects.equals(shippingAddress, other.shippingAddress)
            && Objects.equals(note, other.note)
            && Objects.equals(statementDescriptionIdentifier,
                    other.statementDescriptionIdentifier)
            && Objects.equals(capabilities, other.capabilities)
            && Objects.equals(receiptNumber, other.receiptNumber)
            && Objects.equals(receiptUrl, other.receiptUrl)
            && Objects.equals(versionToken, other.versionToken);
    }

    /**
     * Converts this Payment into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Payment [" + "id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", amountMoney=" + amountMoney + ", tipMoney=" + tipMoney + ", totalMoney="
                + totalMoney + ", appFeeMoney=" + appFeeMoney + ", approvedMoney=" + approvedMoney
                + ", processingFee=" + processingFee + ", refundedMoney=" + refundedMoney
                + ", status=" + status + ", delayDuration=" + delayDuration + ", delayAction="
                + delayAction + ", delayedUntil=" + delayedUntil + ", sourceType=" + sourceType
                + ", cardDetails=" + cardDetails + ", cashDetails=" + cashDetails
                + ", externalDetails=" + externalDetails + ", locationId=" + locationId
                + ", orderId=" + orderId + ", referenceId=" + referenceId + ", customerId="
                + customerId + ", employeeId=" + employeeId + ", refundIds=" + refundIds
                + ", riskEvaluation=" + riskEvaluation + ", buyerEmailAddress=" + buyerEmailAddress
                + ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress
                + ", note=" + note + ", statementDescriptionIdentifier="
                + statementDescriptionIdentifier + ", capabilities=" + capabilities
                + ", receiptNumber=" + receiptNumber + ", receiptUrl=" + receiptUrl
                + ", versionToken=" + versionToken + "]";
    }

    /**
     * Builds a new {@link Payment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Payment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .amountMoney(getAmountMoney())
                .tipMoney(getTipMoney())
                .totalMoney(getTotalMoney())
                .appFeeMoney(getAppFeeMoney())
                .approvedMoney(getApprovedMoney())
                .processingFee(getProcessingFee())
                .refundedMoney(getRefundedMoney())
                .status(getStatus())
                .delayDuration(getDelayDuration())
                .delayAction(getDelayAction())
                .delayedUntil(getDelayedUntil())
                .sourceType(getSourceType())
                .cardDetails(getCardDetails())
                .cashDetails(getCashDetails())
                .externalDetails(getExternalDetails())
                .locationId(getLocationId())
                .orderId(getOrderId())
                .referenceId(getReferenceId())
                .customerId(getCustomerId())
                .employeeId(getEmployeeId())
                .refundIds(getRefundIds())
                .riskEvaluation(getRiskEvaluation())
                .buyerEmailAddress(getBuyerEmailAddress())
                .billingAddress(getBillingAddress())
                .shippingAddress(getShippingAddress())
                .note(getNote())
                .statementDescriptionIdentifier(getStatementDescriptionIdentifier())
                .capabilities(getCapabilities())
                .receiptNumber(getReceiptNumber())
                .receiptUrl(getReceiptUrl())
                .versionToken(getVersionToken());
        return builder;
    }

    /**
     * Class to build instances of {@link Payment}.
     */
    public static class Builder {
        private String id;
        private String createdAt;
        private String updatedAt;
        private Money amountMoney;
        private Money tipMoney;
        private Money totalMoney;
        private Money appFeeMoney;
        private Money approvedMoney;
        private List<ProcessingFee> processingFee;
        private Money refundedMoney;
        private String status;
        private String delayDuration;
        private String delayAction;
        private String delayedUntil;
        private String sourceType;
        private CardPaymentDetails cardDetails;
        private CashPaymentDetails cashDetails;
        private ExternalPaymentDetails externalDetails;
        private String locationId;
        private String orderId;
        private String referenceId;
        private String customerId;
        private String employeeId;
        private List<String> refundIds;
        private RiskEvaluation riskEvaluation;
        private String buyerEmailAddress;
        private Address billingAddress;
        private Address shippingAddress;
        private String note;
        private String statementDescriptionIdentifier;
        private List<String> capabilities;
        private String receiptNumber;
        private String receiptUrl;
        private String versionToken;



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
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for tipMoney.
         * @param  tipMoney  Money value for tipMoney.
         * @return Builder
         */
        public Builder tipMoney(Money tipMoney) {
            this.tipMoney = tipMoney;
            return this;
        }

        /**
         * Setter for totalMoney.
         * @param  totalMoney  Money value for totalMoney.
         * @return Builder
         */
        public Builder totalMoney(Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        /**
         * Setter for appFeeMoney.
         * @param  appFeeMoney  Money value for appFeeMoney.
         * @return Builder
         */
        public Builder appFeeMoney(Money appFeeMoney) {
            this.appFeeMoney = appFeeMoney;
            return this;
        }

        /**
         * Setter for approvedMoney.
         * @param  approvedMoney  Money value for approvedMoney.
         * @return Builder
         */
        public Builder approvedMoney(Money approvedMoney) {
            this.approvedMoney = approvedMoney;
            return this;
        }

        /**
         * Setter for processingFee.
         * @param  processingFee  List of ProcessingFee value for processingFee.
         * @return Builder
         */
        public Builder processingFee(List<ProcessingFee> processingFee) {
            this.processingFee = processingFee;
            return this;
        }

        /**
         * Setter for refundedMoney.
         * @param  refundedMoney  Money value for refundedMoney.
         * @return Builder
         */
        public Builder refundedMoney(Money refundedMoney) {
            this.refundedMoney = refundedMoney;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for delayDuration.
         * @param  delayDuration  String value for delayDuration.
         * @return Builder
         */
        public Builder delayDuration(String delayDuration) {
            this.delayDuration = delayDuration;
            return this;
        }

        /**
         * Setter for delayAction.
         * @param  delayAction  String value for delayAction.
         * @return Builder
         */
        public Builder delayAction(String delayAction) {
            this.delayAction = delayAction;
            return this;
        }

        /**
         * Setter for delayedUntil.
         * @param  delayedUntil  String value for delayedUntil.
         * @return Builder
         */
        public Builder delayedUntil(String delayedUntil) {
            this.delayedUntil = delayedUntil;
            return this;
        }

        /**
         * Setter for sourceType.
         * @param  sourceType  String value for sourceType.
         * @return Builder
         */
        public Builder sourceType(String sourceType) {
            this.sourceType = sourceType;
            return this;
        }

        /**
         * Setter for cardDetails.
         * @param  cardDetails  CardPaymentDetails value for cardDetails.
         * @return Builder
         */
        public Builder cardDetails(CardPaymentDetails cardDetails) {
            this.cardDetails = cardDetails;
            return this;
        }

        /**
         * Setter for cashDetails.
         * @param  cashDetails  CashPaymentDetails value for cashDetails.
         * @return Builder
         */
        public Builder cashDetails(CashPaymentDetails cashDetails) {
            this.cashDetails = cashDetails;
            return this;
        }

        /**
         * Setter for externalDetails.
         * @param  externalDetails  ExternalPaymentDetails value for externalDetails.
         * @return Builder
         */
        public Builder externalDetails(ExternalPaymentDetails externalDetails) {
            this.externalDetails = externalDetails;
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
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
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
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Setter for employeeId.
         * @param  employeeId  String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        /**
         * Setter for refundIds.
         * @param  refundIds  List of String value for refundIds.
         * @return Builder
         */
        public Builder refundIds(List<String> refundIds) {
            this.refundIds = refundIds;
            return this;
        }

        /**
         * Setter for riskEvaluation.
         * @param  riskEvaluation  RiskEvaluation value for riskEvaluation.
         * @return Builder
         */
        public Builder riskEvaluation(RiskEvaluation riskEvaluation) {
            this.riskEvaluation = riskEvaluation;
            return this;
        }

        /**
         * Setter for buyerEmailAddress.
         * @param  buyerEmailAddress  String value for buyerEmailAddress.
         * @return Builder
         */
        public Builder buyerEmailAddress(String buyerEmailAddress) {
            this.buyerEmailAddress = buyerEmailAddress;
            return this;
        }

        /**
         * Setter for billingAddress.
         * @param  billingAddress  Address value for billingAddress.
         * @return Builder
         */
        public Builder billingAddress(Address billingAddress) {
            this.billingAddress = billingAddress;
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
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }

        /**
         * Setter for statementDescriptionIdentifier.
         * @param  statementDescriptionIdentifier  String value for statementDescriptionIdentifier.
         * @return Builder
         */
        public Builder statementDescriptionIdentifier(String statementDescriptionIdentifier) {
            this.statementDescriptionIdentifier = statementDescriptionIdentifier;
            return this;
        }

        /**
         * Setter for capabilities.
         * @param  capabilities  List of String value for capabilities.
         * @return Builder
         */
        public Builder capabilities(List<String> capabilities) {
            this.capabilities = capabilities;
            return this;
        }

        /**
         * Setter for receiptNumber.
         * @param  receiptNumber  String value for receiptNumber.
         * @return Builder
         */
        public Builder receiptNumber(String receiptNumber) {
            this.receiptNumber = receiptNumber;
            return this;
        }

        /**
         * Setter for receiptUrl.
         * @param  receiptUrl  String value for receiptUrl.
         * @return Builder
         */
        public Builder receiptUrl(String receiptUrl) {
            this.receiptUrl = receiptUrl;
            return this;
        }

        /**
         * Setter for versionToken.
         * @param  versionToken  String value for versionToken.
         * @return Builder
         */
        public Builder versionToken(String versionToken) {
            this.versionToken = versionToken;
            return this;
        }

        /**
         * Builds a new {@link Payment} object using the set fields.
         * @return {@link Payment}
         */
        public Payment build() {
            return new Payment(id, createdAt, updatedAt, amountMoney, tipMoney, totalMoney,
                    appFeeMoney, approvedMoney, processingFee, refundedMoney, status, delayDuration,
                    delayAction, delayedUntil, sourceType, cardDetails, cashDetails,
                    externalDetails, locationId, orderId, referenceId, customerId, employeeId,
                    refundIds, riskEvaluation, buyerEmailAddress, billingAddress, shippingAddress,
                    note, statementDescriptionIdentifier, capabilities, receiptNumber, receiptUrl,
                    versionToken);
        }
    }
}
